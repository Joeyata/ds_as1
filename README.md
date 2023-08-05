distributed systems assignment 1


#Compile
Use ***make build*** to compile all java files
Also can use ***make clean*** to clear all exist java files before we build.

#Run

First, use ***make launch-server*** to launch server
Then, use ***make launch-client file_name=xxx*** to launch client. xxx is the name of the input file,default is "input.txt".
For example, 
client1 can use ***make launch-client*** to use "input.txt" as input and run the client.
client2 can use ***make launch-client file_name="input1.txt"*** to use "input1.txt" as input and run the client.

#the structure of the input file
Every line contain a command, if the command needs an integer, it will look like "command integer".
Like: 
"pushValue 3"
"pushValue 4"
"max" 
"pop"
The client will pop 4 finally.
The input file can be changed, so the code of the project will not need to be changed.

