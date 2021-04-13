CP := junit5.jar:opencsv-5.3.jar:commons-text-1.9.jar:commons-logging-1.2.jar:commons-lang3-3.11.jar:commons-collections-3.2.2.jar:commons-collections4-4.4.jar:commons-beanutils-1.9.4.jar:.

run: compile
	java -cp $(CP) Main maplocations.csv

compile: Location.java LocationDataReader.java GraphADT.java CS400Graph.java Backend.java Frontend.java Main.java
	javac -cp $(CP) Location.java LocationDataReader.java GraphADT.java CS400Graph.java Backend.java Frontend.java Main.java

test: testData testBackend testFrontend

testFrontend: TestFrontend.java
	javac -cp $(CP) TestFrontend.java
	java -jar junit5.jar -cp $(CP) -c TestFrontend

testBackend: TestBackend.java
	javac -cp $(CP) TestBackend.java
	java -jar junit5.jar -cp $(CP) -c TestBackend

testData: DataWranglerTests.java
	javac -cp $(CP) DataWranglerTests.java
	java -jar junit5.jar -cp $(CP) -c DataWranglerTests

clean:
	$(RM) *.class
