# SehatQ Android Engineer Technical Test
Android application

## Architecture
<p align="center"><a><img src="https://miro.medium.com/max/1400/1*B7LkQDyDqLN3rRSrNYkETA.jpeg" width="500"></a></p>

* Data -> Implementations of our repositories and other data sources like databases or network
* Domain -> Holds all of the application’s business logic.
* App/Presentation -> contains all of the code related to the Presentation layer and all the things from Android SDK using MVVM Pattern

Model View ViewModel

<p align="center"><a><img src="https://developer.android.com/topic/libraries/architecture/images/final-architecture.png" width="500"></a></p>

## Used Android Jetpack :
Android Jetpack
<p align="center"><a><img src="https://www.xda-developers.com/files/2018/05/Android-Jetpack-1024x517.png" width="400"></a></p>
 
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) provides a way to create and retrieve objects. It typically stores the state of a view’s data and communicates with other components.

* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)  notifies Observer objects when the lifecycle state changes.

* [Navigation Component](https://developer.android.com/guide/navigation) to handle all navigations and also passing of data between destinations.

* [Data Binding](https://developer.android.com/topic/libraries/data-binding/) to declaratively bind UI components in layouts to data sources.

* [Room](https://developer.android.com/topic/libraries/architecture/room) persistence library which provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.

### List Libraries Used in this Project
* [Coroutine](https://github.com/Kotlin/kotlinx.coroutines)
* [OkHttp](https://square.github.io/okhttp/)
* [Lottie](https://github.com/airbnb/lottie-android)
* [Glide](https://github.com/bumptech/glide)
* [Retrofit](https://github.com/square/retrofit)
* [Timber](https://github.com/JakeWharton/timber)
* [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)

# Screenshoot

### Login
<img src="https://github.com/rio45ka/SehatQAssignment/blob/master/screenshot/login.jpeg" width="315" height="650">

### Home
<img src="https://github.com/rio45ka/SehatQAssignment/blob/master/screenshot/dashboard.jpeg" width="315" height="650">

### Search Empty
<img src="https://github.com/rio45ka/SehatQAssignment/blob/master/screenshot/search_empty.jpeg" width="315" height="650">

### Search
<img src="https://github.com/rio45ka/SehatQAssignment/blob/master/screenshot/search.jpeg" width="315" height="650">

### Detail
<img src="https://github.com/rio45ka/SehatQAssignment/blob/master/screenshot/detail.jpeg" width="315" height="650">

### Detail Purchased
<img src="https://github.com/rio45ka/SehatQAssignment/blob/master/screenshot/detail_cart.jpeg" width="315" height="650">

### Share
<img src="https://github.com/rio45ka/SehatQAssignment/blob/master/screenshot/share.jpeg" width="315" height="650">

### Purchased History
<img src="https://github.com/rio45ka/SehatQAssignment/blob/master/screenshot/purchase_history.jpeg" width="315" height="650">
