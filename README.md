# Currency Conversion API Client

This is a simple Kotlin application that provides a client for converting currency amounts using the [ExchangeRatesAPI](https://apilayer.com/marketplace/exchangerates_data-api-10448). It utilizes Retrofit for making network calls and OkHttp for intercepting requests and adding authentication headers.

## Features

- Convert currency amounts from one currency to another.

## Structure
###  `CurrencyAPI`

- ***Retrofit***: A type-safe HTTP client for Android and Java.
- ***OkHttp***: An HTTP client for making network requests.
- ***Gson***: A library for converting Java objects to JSON and vice versa.
### `CurrencyViewModel`

The `CurrencyViewModel` class is responsible for handling currency conversion logic, including:

- Making API calls to fetch conversion rates.
- Managing conversion results and error states.
- Providing the result and error messages as `StateFlow` for UI observation.
###  `MainActivity`
- User can input an amount to be converted.  
- Users can select currencies to convert from and to using drop-down lists (spinners).  
- Displays the conversion result with an underline effect.  
- Shows an error message if the entered amount is invalid (e.g., non-numeric input).  
- Utilizes Kotlin Coroutines for asynchronous data handling.  
## Getting Started
### Prerequisites  

Make sure you have the following installed on your machine:  

- **Android Studio**: Download and install the latest version from [Android Studio](https://developer.android.com/studio).  
- **JDK**: Ensure that the Java Development Kit (JDK) is installed. The required version is typically bundled with Android Studio.  
- **Android SDK**: This should already be included with your Android Studio setup.
- **Gradle**: Ensure you have Gradle set up for dependency management.
- An API key from [ExchangeRatesAPI](https://apilayer.com/marketplace/exchangerates_data-api-10448).

## Building and Running the App  

Follow these steps to build and run the Currency Converter app on your device or emulator:
## Link Demo
- [Kotlin ConvertCurrency](https://youtu.be/cpF0KNyPgBg)  



