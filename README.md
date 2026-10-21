# Smart Pantry Manager

## App Description
An Android application built in Java that helps users reduce food waste by tracking their pantry ingredients and suggesting recipes based strictly on what they currently have at home. 

## Database Choice
I chose **SQLite (via the Room Persistence Library)**. 
*Reasoning:* Room provides a local, offline-first database which is perfect for a pantry app. It offers compile-time verification of SQL queries and seamless integration with Java, ensuring data persists securely even if the app is closed.

## Setup Instructions
1. Open the project in Android Studio.
2. Allow Gradle to sync.
3. Run the app on an emulator or physical device (Minimum SDK 24).
4. The database will automatically seed with 15 recipes on the first launch.

## Strict Matching Algorithm
The app uses a custom `IngredientMatcher` class that ensures a recipe is only suggested if the user has *every* required ingredient in the correct quantity. It also normalizes names (e.g., tomato vs tomatoes) to be robust against simple real-world messiness.
