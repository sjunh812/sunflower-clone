package org.sjhstudio.sunflowerclone.domain.model

data class UnsplashPhoto(
    val id: String,
    val url: String,
    val user: UnsplashUser
)

data class UnsplashUser(
    val name: String,
    val username: String
) {
    val attributeUrl: String
        get() {
            return "https://unsplash.com/$username?utm_source=sunflower&utm_medium=referral"
        }
}