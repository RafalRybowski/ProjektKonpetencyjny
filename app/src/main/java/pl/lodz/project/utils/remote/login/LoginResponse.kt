package pl.lodz.project.utils.remote.login

data class LoginResponse(
    val status: LoginStatus,
    val userId: Int,
    val degree: String,
    val name: String,
    val surname: String,
    val position: String,
    val phone: String,
    val image: String
)