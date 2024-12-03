package io.wookoo.flyticketssearch.network

import com.squareup.moshi.Moshi
import io.wookoo.flyticketssearch.network.Consts.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitConfig(client: Client) {

    private val moshi: Moshi = Moshi.Builder()
        .addLast(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client.networkClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
}
