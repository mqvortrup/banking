dependencies {
    repositories {
        mavenCentral()
    }
    "implementation"(project(":domain"))
}

plugins {
    kotlin("jvm")
    idea
}