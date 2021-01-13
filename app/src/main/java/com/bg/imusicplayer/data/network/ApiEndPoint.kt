package com.bg.imusicplayer.data.network




import com.bg.imusicplayer.data.model.obj.xmlobj.Feed
import com.bg.imusicplayer.data.utils.AppConstants.APP_URL
import com.bg.imusicplayer.data.utils.AppConstants.RESPONSE_DATA_TYPE
import com.bg.imusicplayer.data.utils.AppConstants.TOP_SONGS
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.*

interface ApiEndPoint {


 @GET("$TOP_SONGS/{limit}$RESPONSE_DATA_TYPE")
    suspend fun fetchTopSongs(@Path("limit") limit:Int) : Response<Feed>

    companion object{
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ) : ApiEndPoint {

            val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okkHttpclient)
                .baseUrl(APP_URL)
                /*.addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(StringConverterFactory.create())*/
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                .build()
                .create(ApiEndPoint::class.java)
        }
    }

}

