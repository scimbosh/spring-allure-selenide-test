plugins {
	id("org.springframework.boot") version "3.1.2"
	id("io.spring.dependency-management") version "1.1.2"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
	kotlin("plugin.jpa") version "1.8.22"
	id("io.qameta.allure") version "2.11.2"
}

repositories {
	mavenCentral()
}

group = "com.scimbosh"
version = "1.0.0"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

dependencies {

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.qameta.allure:allure-java-commons:2.13.2")
	testImplementation("io.qameta.allure:allure-attachments:2.13.2")
	testImplementation("io.qameta.allure:allure-junit5:2.13.2")
	testImplementation(kotlin("test"))
	testImplementation("com.codeborne:selenide:7.0.0") // 6.17.1
	testImplementation("com.codeborne:selenide-selenoid:7.0.0")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		//jvmTarget = "11"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}