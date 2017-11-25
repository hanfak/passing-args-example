Run via command line

mvn package

java -cp target/executable-jar-example-1.0-SNAPSHOT.jar Runner commands "5 5\n1 2 N\nLMLMLMLMM"

java -cp target/executable-jar-example-1.0-SNAPSHOT.jar Runner file ./ExampleText.txt 

# Run using bash script

Give permissions to bash script

chmod u+x runner.sh

To run with commands in file
./runner.sh file ./ExampleText.txt

To run with inline commands
./runner.sh commands "5 5\n1 2 N\nLMLMLMLMM"

To run default
./runner.sh

