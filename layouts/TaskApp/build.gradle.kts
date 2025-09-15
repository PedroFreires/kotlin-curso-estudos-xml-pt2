// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false

    // the dependency for the Google services Gradle plugin
    id("com.google.gms.google-services") version "4.4.3" apply false


}

buildscript{
    dependencies{
        //Safe Args
        val nav_version = "2.9.4"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}