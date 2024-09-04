#Т естовое задание для Effective Mobile
## Проделанная работа
+ Рабочая загрузка данных о вакансиях, что у меня очень дольго не получалось :)
+ Разобралась на начальном уровне с XML. Никогда с ним до этого не работала. Однако большая часть UI сделана с использованием Jetpack Compose.
+ Разобралась с навигацией на Compose.
+ Показала работу с Git Flow. Много веток не создавала, так как это не удобно, когда работаешь один.

## Трудности
+ Всё что связано с XML, но сделала два экрана:
  
  ![image](https://github.com/user-attachments/assets/eda696f2-9ac5-42e6-b502-2959e833e695)
  
  ![image](https://github.com/user-attachments/assets/43969cc2-c458-4a03-9ad8-8699778ea676)

+ Очень долго не могла наладить подгрузку информации по вакансиям.

## Скриншоты 
![image](https://github.com/user-attachments/assets/227d6308-2f80-44eb-a828-18f70b814d90)

![image](https://github.com/user-attachments/assets/e18f95c1-af1a-4d53-b011-ad7cbc780997)


После нажатия на кнопку "Ещё вакансии":

![image](https://github.com/user-attachments/assets/665528e9-dc3b-4542-8ffd-872bf81c71d6)





## Структура приложения
```
├── manifests
│   └── AndroidManifest.xml
├── java
│   ├── com.effectivemobile.jobsearch
│   │   ├── activities
│   │   │   ├── LoginActivity1.kt
│   │   │   └── LoginActivity2.kt
│   │   ├── data
│   │   │   ├── repositories
│   │   │   │   └── VacanciesRepository.kt
│   │   │   ├── AppContainer.kt
│   │   │   ├── JobSearch.kt
│   │   │   └── Vacancy.kt
│   │   ├── network
│   │   │   ├── models
│   │   │   │   ├── Address.kt
│   │   │   │   ├── Experience.kt
│   │   │   │   ├── JobSearch.kt
│   │   │   │   ├── Offers.kt
│   │   │   │   ├── Salary.kt
│   │   │   │   ├── Vacancies.kt
│   │   │   │   └── VacancyService.kt
│   │   ├── ui
│   │   │   ├── screens
│   │   │   │   ├── BottomNavigationBar.kt
│   │   │   │   ├── FavoritesScreen.kt
│   │   │   │   ├── InformationScreen.kt
│   │   │   │   ├── MainScreen.kt
│   │   │   │   ├── PlaceholderScreen.kt
│   │   │   │   ├── VacanciesGridScreen.kt
│   │   │   │   └── VacancyCard.kt
│   │   │   ├── theme
│   │   │   │   ├── Color.kt
│   │   │   │   ├── Theme.kt
│   │   │   │   └── Type.kt
│   │   │   ├── viewModels
│   │   │   │   ├── FavoritesViewModel.kt
│   │   │   │   └── VacanciesViewModel.kt
│   │   │   └── utils
│   │   │       ├── Constants.kt
│   │   JobSearchApp.kt
|   |---JobSearchApplication.kt
│   │   MainActivity.kt
│   └── (test)
│       └── (androidTest)
├── res
│   ├── drawable
│   │   └── (Images and other resources)
│   ├── layout
│   │   ├── activity_login1.xml
│   │   ├── activity_login2.xml
│   │   └── nav_graph.xml
│   ├── mipmap
│   └── navigation

```
## Зависимости
```
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")


    implementation("io.coil-kt:coil-compose:2.7.0")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.4")
    implementation("androidx.navigation:navigation-compose:2.7.7")


    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
    implementation("androidx.activity:activity-compose:1.9.1")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.appcompat:appcompat:1.7.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
```

## Стек
+ Kotlin 
+ Корутины 
+ ﻿Flow
+ ﻿﻿MVVM
+ Jetpack Compose/XML
+ Clean Architecture
+ Многомодульность 
+ Retrofit
