package io.jeffchang.buttondemo.network.remote


import io.jeffchang.buttondemo.models.User
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Service that defines the RESTful interactions with the API.
 */

interface FakeButtonService {

    @POST("user")
    fun postUsers(@Field("name") name: String,
                  @Field("email") user: String,
                  @Field("candidate") candidateId: String): Single<User>

    @GET("user")
    fun getUsers(@Query("candidate") candidate: String): Single<List<User>>

}
