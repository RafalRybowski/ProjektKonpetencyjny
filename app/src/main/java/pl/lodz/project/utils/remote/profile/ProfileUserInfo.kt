package pl.lodz.project.utils.remote.profile

data class ProfileUserInfo (
    val ID_KONTA : Int,
    val TYTUL : String,
    val IMIE : String,
    val NAZWISKO : String,
    val ID_TYPU_KONTA : Int,
    val SPECJALIZACJA : String,
    val IMAGE : String?,
    val NUMER_TELEFONU : String,
    val NAZWA_TYPU_KONTA : String
)