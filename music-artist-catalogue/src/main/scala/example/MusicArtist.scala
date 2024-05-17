package example

object MusicArtist {
  case class Artist(
    name: String,
    genre: String,
    origin: String,
    yearsActiveStart: Int,
    isActive: Boolean,
    yearsActiveEnd: Int
  )
}

object Driver extends with App {
}