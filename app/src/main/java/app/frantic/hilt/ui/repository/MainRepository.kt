package app.frantic.hilt.ui.repository

import app.frantic.hilt.network.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiService) {


    suspend fun getFlowers() =  apiHelper.getFlowers()

}