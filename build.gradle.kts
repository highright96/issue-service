import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    /* Spring plugins */
    id("org.springframework.boot") version "2.7.2" apply false
    id("io.spring.dependency-management") version "1.0.12.RELEASE"

    /* Kotlin plugins */
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
}

java.sourceCompatibility = JavaVersion.VERSION_17

// 프로젝트 수준의 build.gradle 뿐만 아니라 모든 모듈의 build.gradle 제어
allprojects {
    group = "com.example"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

// 프로젝트 수준의 build.gradle 을 제외한 모든 서브 모듈의 build.gradle 제어
subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "kotlin-spring")
    apply(plugin = "kotlin-jpa")
    apply(plugin = "io.spring.dependency-management")

    dependencies {
        // Kotlin
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        // Database
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")

        // Logging
        implementation("io.github.microutils:kotlin-logging:1.12.5")

        // Test
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation ("org.testcontainers:junit-jupiter:1.17.3")
        testImplementation("org.testcontainers:postgresql:1.17.3")

        // Util
        implementation("io.arrow-kt:arrow-core:1.1.2")
    }

    dependencyManagement {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
