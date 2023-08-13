# Hog

[![Publish to Maven Central](https://github.com/K-Huntun/Hog/actions/workflows/publish.yml/badge.svg?event=release)](https://github.com/K-Huntun/Hog/actions/workflows/publish.yml)

Hog is a logging library for Kotlin Multiplatform Mobile (KMM) , designed to provide a simple logging solution for your applications. It supports Android, iOS platforms, allowing you to have consistent logging functionality across multiple platforms.

## Features
- Multiple log levels: Hog supports different log levels, including VERBOSE, DEBUG, INFO, WARN, and ERROR.

- Customizable log output: You can define your own log delegate function to handle the logging output.

- Throwable support: Hog allows you to log exceptions and stack traces along with your log messages.

## Getting Started

To start using Hog in your KMM project, follow these steps:

1. Add the Hog library as a dependency in your Kotlin Multiplatform module's Gradle file.
```kotlin
kotlin {
    // ...
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("top.heiha.huntun:hog:$latestVersion")
            }
        }
        // ...
    }
}
```
2. Start logging in your shared code.
```kotlin
import com.example.hog.logv
import com.example.hog.logi
import com.example.hog.loge

fun someFunction() {
    logv("TAG", "Verbose log message")
    logi("TAG", "Info log message")
    loge("TAG", "Error log message", Throwable("Something went wrong"))
}
```

## Log Levels
Hog supports the following log levels:
- VERBOSE: Detailed logs used for debugging purposes.
- DEBUG: Debugging logs for tracking the flow of the application.
- INFO: Informational logs to provide general information about the application.
- WARN: Warning logs to indicate potential issues that may need attention.
- ERROR: Error logs to signify critical errors or exceptions.
You can choose the appropriate log level based on the importance and severity of the log message.

## Custom Log Delegate
Hog allows you to define your own log delegate function to handle the logging output. By default, it uses the log function provided by the library. However, you can override this behavior by assigning your custom log delegate function to the logDelegate variable.

```kotlin
logDelegate = ::myLogDelegate

fun myLogDelegate(level: LogLevel, tag: String, msg: String, tr: Throwable?) {
// Implement your custom logging logic here
}
```
In your custom log delegate function, you can define how the log messages should be processed and outputted. You have access to the log level, tag, message, and optional throwable object.

## Throwable Support
Hog allows you to log exceptions and stack traces along with your log messages. When logging an error or an exception, you can pass a throwable object as an optional parameter.

```kotlin
loge("TAG", "Error log message", Throwable("Something went wrong"))
```
The throwable object will be converted to a string representation, including the stack trace, and appended to the log message.

## License
This library is licensed under the MIT License. You are free to use, modify, and distribute this library.