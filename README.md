# EyojMovies-SeriesTracker

Kullanılan Kütüphaneler

Retrofit: TheMovieDB API'sine yapılan çağrılarla güncel veriler alınmaktadır.

Horizontal Pager: Sanki bir sayfayı değiştiriyormuş gibi resimleri görüntülemek için Jetpack Compose kütüphanesi kullanılmaktadır.

Dagger&Hilt: Bağımlılık yönetimi için tercih edilmiş olup, kodun düzenli ve bakımı kolay hale getirilmiştir.

Compose Navigation&Bottom Navigation: Uygulamada gezinme ve ekran geçişleri yönetimi için kullanılmaktadır.

Compose ImageAsyncPainter: Dizi ve filmlerle ilgili resimleri yüklemek ve göstermek amacıyla kullanışlıdır.

Material&Material3: Verilerin ekrana yansıtılması ve işlenmesi için kullanılan kütüphanelerdir.

3. Parti Kütüphaneler

Lottie Animation: Uygulamada akış sağlayan görsellerin kullanımını destekler.
YouTubePlayer: Uygulama içerisinde videoları izlemek için kullanılır. 


Project Description
This project is built upon the MVVM (Model-View-ViewModel) and Clean Architecture principles, 
aiming to deliver a comprehensive application experience. Leveraging TheMovieDB API, the project 
fetches data related to TV series and movies, presenting users with informative details.

Architecture Overview
The application's core logic and processes are centralized within the ViewModel layer. ViewModels 
take charge of data storage and user interactions. Data flow is orchestrated using "Coroutines" to 
handle asynchronous operations seamlessly. Specifically, in the ViewModel context, "Jobs" are employed 
during data retrieval. This approach enables close monitoring of background tasks, allowing for efficient
cancellations when necessary. Consequently, real-time updates are facilitated on the user interface, 
contributing to a fluid and responsive user experience.

Used Libraries

Retrofit: Seamlessly initiates API calls to TheMovieDB, ensuring the retrieval of the latest and 
most relevant data.

Horizontal Pager: Harnesses the power of the Jetpack Compose library to provide users with a 
captivating and smooth image browsing experience, perfectly emulating lifelike page transitions.

Dagger&Hilt: Empowers the project with advanced dependency management capabilities, cultivating a 
codebase that is both structured and easily maintainable.

Compose Navigation&Bottom Navigation: Enhances user experience by optimizing navigation and 
seamlessly managing screen transitions throughout the application.

Compose ImageAsyncPainter: Effortlessly handles the loading and presentation of captivating 
visuals, enriching the portrayal of TV series and movie content.

Material&Material3: Anchors the project with essential libraries that enable intuitive data visualization
and manipulation, significantly elevating the overall user interface.

Third-Party Libraries

Lottie Animation: Animation that seamlessly blends lively visuals, reminiscent of videos, heightening visual 
engagement and interaction.

YouTubePlayer: Empowers seamless video playback within the app, enabling users to watch videos without leaving the application.
