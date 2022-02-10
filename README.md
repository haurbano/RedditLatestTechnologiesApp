# Reddit

## Description
Reddit application example with the latest Android Libraries

## Technologie:

### Libraries
- **Retrofit**: Requests
- **Gson**: Map responses from requests
- **Android ViewModels**
- **Android flow**: UI updates from ViewModel to Activity
- **mockk:** Mocks in testing
- **Koin**: Dependency injection

### Background Strategy:
- **Kotlin Coroutines**

### Code Quiality
- **Code Style**: Added task using [ktlint](https://github.com/pinterest/ktlint) to keep a good code styel. The code style task is run always before the build task.

###  Thrid Party Dependencies
- **BuildSrc Strategy**: [Blog](https://proandroiddev.com/gradle-dependency-management-with-kotlin-94eed4df9a28)

### UI Library
I used Jetpack Compose, it was my frist project with this labrary and it's not stable yet :(

## Architecture
- Using **Clean Architechture** for the whole application and using **MVVM** for the presentation layer.
