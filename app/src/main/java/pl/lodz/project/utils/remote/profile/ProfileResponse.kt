package pl.lodz.project.utils.remote.profile

data class ProfileResponse(
    val rowProfile: ProfileUserInfo,
    val rowsPub: List<ProfilePublication>?
)