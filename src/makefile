BUILD_DIR = ./build/

all: clean build

build:
	mkdir -p $(BUILD_DIR);
	javac -d $(BUILD_DIR) *.java;

clean:
	rm -rf $(BUILD_DIR);

launch-server:
	java -cp $(BUILD_DIR) Server;

launch-client:
	java -cp $(BUILD_DIR) Client;
