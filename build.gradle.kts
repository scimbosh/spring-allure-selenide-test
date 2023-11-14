plugins {
	id("org.springframework.boot") version "2.5.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.5.0"
	kotlin("plugin.spring") version "1.5.0"
	kotlin("plugin.jpa") version "1.5.0"
	id("io.qameta.allure") version "2.11.2"
}

repositories {
	mavenCentral()
}

group = "com.scimbosh"
version = "1.0.0"

java {
	sourceCompatibility = JavaVersion.VERSION_11
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation ("org.junit.jupiter:junit-jupiter-api:5.7.0")
	testImplementation("io.qameta.allure:allure-java-commons:2.13.2")
	testImplementation("io.qameta.allure:allure-attachments:2.13.2")
	testImplementation("io.qameta.allure:allure-junit5:2.13.2")
	testImplementation(kotlin("test"))
	testImplementation("com.codeborne:selenide:5.25.1") // 6.17.1
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}