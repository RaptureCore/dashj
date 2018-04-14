javah hashblock
gcc -I$JAVA_HOME/include -I$JAVA_HOME/include/darwin -fPIC -c hashblock.cpp aes_helper.c bmw.c blake.c cubehash.c echo.c groestl.c jh.c keccak.c luffa.c shavite.c simd.c skein.c	
gcc -shared -Wl,-install_name,libx11.dylib.1 -o libx11.dylib.1.0 hashblock.o aes_helper.o bmw.o blake.o cubehash.o echo.o groestl.o jh.o keccak.o luffa.o shavite.o simd.o skein.o
cp libx11.dylib.1.0 libx11.dylib
