package app.frantic.hilt.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import app.frantic.hilt.ui.model.Flower
import app.frantic.hilt.ui.repository.MainRepository
import app.frantic.hilt.utils.Resource
import com.mindorks.framework.mvvm.utils.NetworkHelper
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _flowers = MutableLiveData<Resource<List<Flower>>>()
    val flowers: LiveData<Resource<List<Flower>>>
        get() = _flowers

    init {
        fetchFlowers()
    }

    private fun fetchFlowers() {
        viewModelScope.launch {
            _flowers.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getFlowers().let {
                    if (it.isSuccessful) {
                        _flowers.postValue(Resource.success(it.body()))
                    } else _flowers.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _flowers.postValue(Resource.error("No internet connection", null))
        }
    }
}