package com.bg.imusicplayer.data.network

import com.bg.imusicplayer.data.utils.ApiException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.lang.Exception

abstract class AbstractTaskApiRequest {

    suspend fun<T: Any> apiRequest1(call: suspend () -> Response<T>) : T{
        val response = call.invoke()
        if(response.isSuccessful){
            return response.body()!!
        }else{
            val error = response.errorBody()?.string()
            val message = StringBuilder()
            error?.let{
                try{
                    message.append(JSONObject(it).getString("message"))
                }catch(e: JSONException){ }
                message.append("\n")
            }
            message.append("Error Code: ${response.code()}")
            throw ApiException(message.toString())
        }
    }


    suspend fun<T: Any> apiRequest(call: suspend () -> Response<T>) : T{
        try {
            val response = call.invoke()
            if(response.isSuccessful){
                return response.body()!!
            }else{
                val error = response.errorBody()?.string()
                val message = StringBuilder()
                error?.let{
                    try{
                        message.append(JSONObject(it).getString("message"))
                    }catch(e: JSONException){ }
                    message.append("\n")
                }
                message.append("Error Code: ${response.code()}")
                throw ApiException(message.toString())
            }
        }catch (e:Exception){
            e.stackTrace
        }
        throw ApiException("message".toString())
    }

}