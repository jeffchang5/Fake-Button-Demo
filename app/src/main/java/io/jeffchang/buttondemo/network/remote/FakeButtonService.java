package io.jeffchang.buttondemo.network.remote;


import java.util.List;

import io.jeffchang.buttondemo.models.User;
import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Service that defines the RESTful interactions with the API.
 */

public interface FakeButtonService {

    @POST("user")
    Single<User> postUsers(@Field("name") String name,
                           @Field("email") String user,
                           @Field("candidate") String candidateId);

    @GET("user")
    Single<List<User>> getUsers(@Query("candidate") String candidate);

}
