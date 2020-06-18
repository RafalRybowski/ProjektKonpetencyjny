package pl.lodz.project.login

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pl.lodz.project.utils.remote.RetrofitClient
import pl.lodz.project.utils.remote.login.LoginResponse
import pl.lodz.project.utils.remote.login.LoginService
import pl.lodz.project.utils.CurrentUser
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class LoginPresenter(private val view: Login.View): CoroutineScope, Login.Presenter {

    override val coroutineContext: CoroutineContext = Dispatchers.IO
    private val service by lazy {
        RetrofitClient.getClient().create(LoginService::class.java)
    }


    override fun onLogin(login: String, password: String) {
        launch {
            try {
                val response = service.login(login, password)
                responseProcess(response)
            } catch (exception: Exception) {
                withContext(Dispatchers.Main) {
                    showError("Can't login")
                }
            }
        }
    }

    private suspend fun responseProcess(response: LoginResponse) {
        withContext(Dispatchers.Main) {
            CurrentUser.setUser(response)
            toSuccess()
        }
    }

    private fun toSuccess() {
        view.onSuccess()
    }

    private fun showError(exception: String){
        view.onFailure(exception)
    }


}