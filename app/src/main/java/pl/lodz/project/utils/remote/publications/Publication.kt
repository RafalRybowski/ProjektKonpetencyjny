package pl.lodz.project.utils.remote.publications

import java.io.Serializable

data class Publication(
    val idPublication: Int,
    val idAuthors: Int,
    val title: String,
    val date: String,
    val ISBN: String,
    val place: String
): Serializable