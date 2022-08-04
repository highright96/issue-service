dependencies {
    implementation(project(":domain"))
    testImplementation(project(":presentation"))

    implementation("com.linecorp.kotlin-jdsl:spring-data-kotlin-jdsl-starter:2.0.4.RELEASE")

    // Database
    implementation("org.postgresql:postgresql:42.3.3")
}