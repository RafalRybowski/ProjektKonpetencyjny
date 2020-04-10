package pl.lodz.project.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.lodz.project.R

class LoginActivity : AppCompatActivity(), Login.View {

    private val loginPresenter = LoginPresenter(this)
    private val scopeIO = CoroutineScope(Dispatchers.IO)
    private val scopeUI = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton.setOnClickListener {
            scopeIO.launch {
                loginPresenter.onLogin(loginEditText.text, passwordEditText.text)
            }
        }
    }
}
