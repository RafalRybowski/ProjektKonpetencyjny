package pl.lodz.project.login

import android.util.Log
import pl.lodz.project.remote.RetrofitClient
import pl.lodz.project.remote.login.LoginService
import java.lang.Exception
import java.net.SocketTimeoutException

class LoginPresenter(private val view: Login){

    suspend fun onLogin(login: String, password: String) {
        //TODO uncoment when logic o server will be created or used
        try {
//            val loginService = RetrofitClient.getClient().create(LoginService::class.java)
//            val a = loginService.login(login, password)
//            Log.i("haha", a.toString())
            view.onSuccess()
        } catch (exception: Exception) {
            view.onFailure(exception.toString())
        }
    }

}