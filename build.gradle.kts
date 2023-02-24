import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.apache.lucene/lucene-core
    implementation("org.apache.lucene:lucene-core:9.3.0")
    // https://mvnrepository.com/artifact/org.apache.lucene/lucene-queryparser
    implementation("org.apache.lucene:lucene-queryparser:9.3.0")
    // https://mvnrepository.com/artifact/org.apache.lucene/lucene-analysis-kuromoji
    implementation("org.apache.lucene:lucene-analysis-kuromoji:9.3.0")



    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}
