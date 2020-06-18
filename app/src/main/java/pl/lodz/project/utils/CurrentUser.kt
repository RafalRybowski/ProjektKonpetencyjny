package pl.lodz.project.utils

import pl.lodz.project.utils.remote.login.LoginResponse

object CurrentUser {
    private var userID: Int = 0

    fun setUser(loginResponse: LoginResponse){
        userID = loginResponse.ID_KONTA

    }

    fun getUser() = userID
}