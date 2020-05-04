package pl.lodz.project.login

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pl.lodz.project.utils.remote.RetrofitClient
import pl.lodz.project.utils.remote.login.LoginResponse
import pl.lodz.project.utils.remote.login.LoginService
import pl.lodz.project.utils.remote.login.LoginStatus
import pl.lodz.project.utils.CurrentUser
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class LoginPresenter(private val view: Login): CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.IO

    fun onLogin(login: String, password: String) {
        launch {
            try {
                val loginService = RetrofitClient.getClient().create(LoginService::class.java)
                val response = loginService.login(login, password)
                responseProcess(response)
            } catch (exception: Exception) {
                withContext(Dispatchers.Main) {
                    showError(exception.toString())
                }
            }
        }
    }

    suspend fun responseProcess(response: LoginResponse) {
        withContext(Dispatchers.Main) {
            if(response.status == LoginStatus.SUCCESS) {
                CurrentUser.setUser(response)
                toSuccess()
            } else {
                showError("Can't login")
            }
        }
    }

    private fun toSuccess() {
        view.onSuccess()
    }

    private fun showError(exception: String){
        view.onFailure(exception)
    }


}