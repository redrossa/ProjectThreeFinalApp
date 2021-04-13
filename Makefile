CP := -cp junit5.jar:opencsv-5.3.jar:commons-text-1.9.jar:commons-logging-1.2.jar:commons-lang3-3.11.jar:comomons-collections-3.2.2.jar:commons-collections4-4.4.jar:commons-beanutils-1.9.4.jar:.

run: compile
	java $(CP) Main maplocations.csv

compile: Location.java LocationDataReader.java GraphADT.java CS400Graph.java Backend.java Frontend.java Main.java
	javac $(CP) Location.java LocationDataReader.java GraphADT.java CS400Graph.java Backend.java Frontend.java Main.java

test: testData testBackend testFrontend

testFrontend: TestFrontend.java
	javac $(CP) TestFrontend.java
	java -jar junit5.jar $(CP) --scan-classpath

testBackend: TestBackend.java
	javac $(CP) TestBackend.java
	java -jar junit5.jar $(CP) --scan-classpath

testData: DataWranglerTests.java
	javac $(CP) DataWranglerTests.java
	java -jar junit5.jar $(CP) --scan-classpath

clean:
	$(RM) *.class
