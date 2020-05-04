package pl.lodz.project.utils.remote.publications

data class Publication(
    val idPublication: Int,
    val idAuthor: Int,
    val tile: String,
    val date: String,
    val ISBN: String,
    val place: String
)