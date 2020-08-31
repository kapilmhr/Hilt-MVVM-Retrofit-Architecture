package app.frantic.hilt.network

import app.frantic.hilt.ui.model.Flower
import app.frantic.hilt.network.API_URL.GETFLOWERS
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(GETFLOWERS)
    suspend fun getFlowers(): Response<List<Flower>>

}