javac com/rapture/NeoscryptWrapper.java
javah com.rapture.NeoscryptWrapper
gcc -I$JAVA_HOME/include -I$JAVA_HOME/include/darwin -fPIC -c NeoscryptWrapper.c neoscrypt.c
gcc -shared -Wl,-install_name,libneoscryptwrapper.dylib.1 -o libneoscryptwrapper.dylib.1.0 NeoscryptWrapper.o neoscrypt.o
cp libneoscryptwrapper.dylib.1.0 ../libs/libneoscryptwrapper.dylib

