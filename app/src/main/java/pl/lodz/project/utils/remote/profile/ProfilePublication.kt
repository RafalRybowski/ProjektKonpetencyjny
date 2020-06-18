package pl.lodz.project.utils.remote.profile

import java.math.BigInteger

data class ProfilePublication(
    val TYTUL_PUBLIKACJI: String,
    val DATA_PUBLIKACJI: String,
    val ISBN: BigInteger,
    val MIEJSCE_WYSTAPIENIA: String
)