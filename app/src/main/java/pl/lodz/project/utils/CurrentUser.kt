package pl.lodz.project.utils

import pl.lodz.project.utils.remote.login.LoginResponse

object CurrentUser {
    private lateinit var user: UserInformation

    fun setUser(loginResponse: LoginResponse){
        user = UserInformation(
            loginResponse.userId,
            loginResponse.degree,
            loginResponse.name,
            loginResponse.surname,
            loginResponse.position,
            loginResponse.phone,
            loginResponse.image
        )
    }

    fun getUser() = user
}