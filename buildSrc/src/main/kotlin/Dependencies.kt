
object Deps {
    // Android
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appcompat}" }
    val material by lazy { "com.google.android.material:material:${Versions.material}" }

    // DI
    val koin by lazy { "io.insert-koin:koin-core:${Versions.koin}" }
    val koinAndroid by lazy { "io.insert-koin:koin-android:${Versions.koin}" }

    // Retrofit
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val gsonConverter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}" }

    // Coroutines
    val coroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}" }
    val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}" }

    //Compose
    val composeUI by lazy { "androidx.compose.ui:ui:${Versions.composeVersion}" }
    val composeMaterial by lazy { "androidx.compose.material:material:${Versions.composeVersion}" }
    val composePreviewTooling by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}" }
    val composeActivity by lazy { "androidx.activity:activity-compose:${Versions.composeActivity}" }
    val composeUiTooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.composeVersion}" }
    val googleSwipeRefresh by lazy { "com.google.accompanist:accompanist-swiperefresh:${Versions.googleSwipeRefresh}" }

    val lifeCycleRuntime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycleRuntime}" }
    val coil by lazy { "io.coil-kt:coil-compose:${Versions.coil}" }

    // Paging
    val paging by lazy { "androidx.paging:paging-runtime:${Versions.paging}" }
    val pagingCOmpose by lazy { "androidx.paging:paging-compose:${Versions.pagingCompose}" }

    // Navigation
    val navigationCompose by lazy {"androidx.navigation:navigation-compose:${Versions.navigationCompose}"}

    // Code Quiality
    val ktlint by lazy { "com.pinterest:ktlint:${Versions.ktLintVersion}" }
}

object TestDeps {
    val jUnit by lazy { "junit:junit:${Versions.jUnit}" }
    val mockito by lazy { "org.mockito:mockito-core:${Versions.mockito3Version}" }
}
