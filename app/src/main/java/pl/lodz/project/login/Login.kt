package pl.lodz.project.login

interface Login {
    fun onSuccess()
    fun onFailure(error: String)
}