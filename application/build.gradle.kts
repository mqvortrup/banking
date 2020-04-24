dependencies {
    repositories {
        mavenCentral()
    }
    "implementation"(project(":domain"))
    "implementation"(project(":singlepayments"))
}

plugins {
    kotlin("jvm")
    idea
}