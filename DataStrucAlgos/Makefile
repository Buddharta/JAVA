#PATH varibles
VPATH = src
SOURCE_DIR = $(PWD)/src
JAR_DIR = /home/shakya/source/JAVA/jarfiles/*
OUT_DIR = $(PWD)/out
CLASSPATH = $(JAR_DIR):$(OUT_DIR)

# Java compiler
JAVAC = javac
# Java interpreter
JAVA = java
# DoublingTest Generator ThreeSum: DoublingTest.java Generator.java ThreeSum.java 

Ramanujan Inversions MaximumSquareSubmatrix: Inversions.java  Ramanujan.java  MaximumSquareSubmatrix.java

JAVA_SOURCE = $(SOURCE_DIR)/*
all: compile run

compile:
	$(JAVAC) -cp $(CLASSPATH) $(SOURCE_DIR)/$(JAVA_SOURCE).java -d $(OUT_DIR)

run:
	cd $(EXEC_DIR) && $(JAVA) -cp $(CLASSPATH):$(OUT_DIR) $(JAVA_SOURCE)

#clean:
#	rm -f $(SOURCE_DIR)/*.class

%: %.java
	javac-introcs $^ -d $(PWD)/out

.PHONY: clean
clean:
	rm -f *.class

