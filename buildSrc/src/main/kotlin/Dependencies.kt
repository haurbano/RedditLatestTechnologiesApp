
object Deps {
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appcompat}" }
    val material by lazy { "com.google.android.material:material:${Versions.material}" }

}

object TestDeps {
    val jUnit by lazy { "junit:junit:${Versions.jUnit}" }
}
