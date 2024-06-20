plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    `java-test-fixtures`
}

testing {

}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}