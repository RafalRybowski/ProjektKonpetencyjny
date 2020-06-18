package pl.lodz.project.login

interface Login {
    interface View {
        fun onSuccess()
        fun onFailure(error: String)
    }

    interface Presenter {
        fun onLogin(login: String, password: String)
    }
}