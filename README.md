# Hilt-MVVM-Retrofit-Architecture
This is a sample app which uses HILT as dependency Injection in MVVM pattern.<br>
It also uses Retrofit for network communication and Parcelize the Model Class. 

## Add dependency in project

### Hilt
```
    implementation 'com.google.dagger:hilt-android:2.28-alpha'
    kapt 'com.google.dagger:hilt-android-compiler:2.28-alpha'
    implementation 'androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01'
    kapt 'androidx.hilt:hilt-compiler:1.0.0-alpha01'
 ```
 ### Network
```
    implementation "com.squareup.retrofit2:converter-gson:2.6.2"
    implementation "com.squareup.retrofit2:retrofit:2.8.1"
    implementation "com.squareup.okhttp3:okhttp:4.7.2"
    implementation "com.squareup.okhttp3:logging-interceptor:4.7.2"
 ```
 
  ### Coroutine
```
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.6"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.6"
 ```

#### The app has following packages:
1. **model**: It contains all the data accessing and manipulating components.
2. **module**: It contains the files required by Dagger
3. **ui**: View classes along with their corresponding ViewModel.
4. **network**: It contains all helper classes for network call.
5. **utils**: Utility classes.
