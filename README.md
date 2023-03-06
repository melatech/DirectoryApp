# Virgin Money - Android technical assignment
## By Jason Calvert 
Virgin Money is a directory app which allows the staff to view their collegues contact details 
and also see which rooms are currently occupied in the office. The Virgin Money App is a kotlin based Android 
Application which was built using the best practices and the latest technologies.

- The unidirectional architecture with the mvvm pattern was used to make the software build robust
in design with a solid architecture.
- The ui layer was built using the single activity multi fragment model with the viewmodel exposing state handling config changes and also handling user action.
- The data layer contains data classes, datasources and API's and the repository which exposes data to the app and resolves conflicts between multiple datasources.
- The network API called Retrofit that is also in the data layer which is a http client library which allows serialization of request and response calls.
- Kotlin Coroutines with suspend functions was the reactive framework used with flow, for handling streams of data without blocking the main Thread.
</br>
</br>
People Screen
</br>
</br>
<img src="https://user-images.githubusercontent.com/13630124/222995733-cb917dfd-9ac5-4b8a-b4cd-303df6be88c8.jpg" alt="virgin money image" width="270" height="585">

The people list feature displays a list of employees in a recyclerview which makes it very easy to display large sets of data. 
The recyclerview does what it says on the tin, it recycles the views as they scroll onto the screen, 
which means that the views are not destroyed but recycled for new items. The viewholder also comes with click functionality
for navigating to the details screen.
</br>
</br>
**Details Screen**
</br>
</br>
<img src="https://user-images.githubusercontent.com/13630124/222966818-f5af7691-54ca-4010-b21b-cd2060c68865.jpg" alt="virgin money image" width="270" height="585">

The display employee feature displays more information about the employee which is the destination screen from the people screen.
Jetpack Navigation Component was used with the Bottom Navigation Bar which is the backbone of the application.
The Bottom Navigation Bar houses two buttons for navigating between the two screens and also the display screen.
</br>
</br>
**Room Screen**
</br>
</br>
<img src="https://user-images.githubusercontent.com/13630124/222967107-63fa005a-438f-4390-9443-ccd1d66893ff.jpg" alt="virgin money image" width="270" height="585">

The rooms list feature displays a list of rooms which allows the user to see which rooms in the office are occupied or not 
shown by the colours red and green. 
</br>
</br>
### TODO

1. Caching the data in the repository so no need to call the API every time.
2. Use Jetpack Compose to implement ui
