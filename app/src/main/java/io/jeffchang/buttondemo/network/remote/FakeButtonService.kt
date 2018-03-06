package io.jeffchang.buttondemo.network.remote


import io.jeffchang.buttondemo.models.User
import io.reactivex.Single
import retrofit2.http.*

/**
 * Service that defines the RESTful interactions with the API.
 */

interface FakeButtonService {

    @POST("user")
    fun postUser(@Body user: User): Single<User>

    @GET("user")
    fun getUsers(@Query("candidate") candidate: String): Single<List<User>>

    companion object {
        const val CANDIDATE_ID = "vbnguirofbm34!"
    }
}
