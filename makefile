all: clean build run

build:
	./gradlew build
	
run:
	java -jar ./build/libs/MiniProject_Arch-1.0-SNAPSHOT.jar

clean:
	./gradlew clean