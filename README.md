# WhatsApp Message Sender App

This project is an Android application for managing and sending WhatsApp message campaigns via a custom web service.

## 🚀 Key Features

* **Login:** User authentication and session token management.
* **Channel Management:** Display a list of sending channels, where each channel has its own token for operations.
* **Campaign Management:** View campaigns associated with each channel.
* **Message Display:** View message details within each campaign (recipient, content, status, timestamp).
* **Import from Excel:** Bulk import messages into a new campaign by sharing an Excel file directly to the app.

## 🛠️ Tech Stack

* **Language:** [Kotlin](https://kotlinlang.org/)
* **Architecture:** MVVM (Model-View-ViewModel)
* **UI:** [Jetpack Compose](https://developer.android.com/jetpack/compose)
* **Asynchronous Programming:** [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)
* **Networking:** [Retrofit](https://square.github.io/retrofit/)
* **Dependency Injection:** [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
* **Local Storage:** [DataStore](https://developer.android.com/topic/libraries/architecture/datastore) for token storage.
* **Excel Parsing:** [Apache POI](https://poi.apache.org/)

## ⚙️ Setup and Running

1.  Clone the repository:
    ```bash
    git clone https://github.com/salman-aboholiqah/quancast.git
    ```
2.  Open the project in Android Studio.
3.  Wait for Gradle to sync and download all dependencies.
4.  **Important:** You will need to provide your API base URL before running the app.

## 🔗 API Configuration

The API base URL must be configured for the app to work. You can find and modify it in the project's network configuration files.

---
*This project is currently under development.*
