package com.rapture;

public class NeoscryptWrapper {
	private static  boolean native_library_loaded = false;
	static {
		try {
			System.loadLibrary("neoscryptwrapper");
			//System.out.println("Neoscrypt Loaded");

			native_library_loaded = true;
		} catch (Throwable e) {
			//System.out.println("Neoscrypt Not Loaded");

		}
	}
	
	public static void temp(String[] args) {

	byte[] input= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
            51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
            61, 62, 63, 64, 65, 66, 67, 68, 69, 70,
            71, 72, 73, 74, 75, 76, 77, 78, 79, 80};

    StringBuilder sb = new StringBuilder();
    for (byte b : input) {
        sb.append(String.format("%02X", b));
    }

		NeoscryptWrapper neoScrypt = new NeoscryptWrapper();
		//neoScrypt.printText();
		//byte[] output = input.clone();
		//byte[] input = "myString".getBytes();
		byte[] output = new byte[32];
		//System.out.println("input-"+input.toString());
		//System.out.println("input-"+input.toString());


		neoScrypt.neoscrypt(input, output);

	StringBuilder sbreborn = new StringBuilder();
    for (byte b : output) {
        sbreborn.append(String.format("%02X", b));
    }

    	System.out.println("Input hex: " + sb.toString());

		System.out.println("Output hex: " + sbreborn.toString());

		System.out.println("input-"+input.toString());
		System.out.println("output-"+output.toString());
	}

	public static byte[] neoscryptDigest(byte[] input, int offset, int length)
	{
		byte [] buf = new byte[length];
		for(int i = 0; i < length; ++i)
		{
			buf[i] = input[offset + i];
		}
		return neoscryptDigest(buf);
	}

	public static byte[] neoscryptDigest(byte[] input) {
		//long start = System.currentTimeMillis();
		try {
			return native_library_loaded ? getHash(input) : getHash(input);
            /*long start = System.currentTimeMillis();
            byte [] result = x11_native(input);
            long end1 = System.currentTimeMillis();
            byte [] result2 = x11(input);
            long end2 = System.currentTimeMillis();
            log.info("x11: native {} / java {}", end1-start, end2-end1);
            return result;*/
		} catch (Exception e) {
			return null;
		}
		finally {
			//long time = System.currentTimeMillis()-start;
			//log.info("X11 Hash time: {} ms per block", time);
		}
	}

	public static byte[] getHash(byte[] input) {
		/**
		 * calls the c- code
		 * @parameters:
		 * input: string to be hashed
		 * profile: defines which hash algorithm to use
		 *  - 0x3 : Scrypt
		 *  - 0x80000620 : neoscrypt for feathercoin
		 */
		//System.loadLibrary("neoscryptwrapper");

		NeoscryptWrapper neoScrypt = new NeoscryptWrapper();
		byte[] output = new byte[32];
		//neoScrypt.neoscrypt(input, output);

		//System.out.println("native_library_loaded status= " + native_library_loaded);
		if (native_library_loaded) {
			/* Todo: is char the right data type to pass?

			 */        // System.out.println("Neoscrypt Running");

			//neoScrypt.neoscrypt(input, output);
			//System.out.print( "output: " + output);
			//System.out.println("TESTEST");
			/*StringBuilder sb = new StringBuilder();
			for (byte b : input) {
				sb.append(String.format("%02X", b));
			}*/
			neoScrypt.neoscrypt(input, output);

			/*StringBuilder sbreborn = new StringBuilder();
			for (byte b : output) {
				sbreborn.append(String.format("%02X", b));
			}*/

			//System.out.println("Input hex: " + sb.toString());

			//System.out.println("Output hex: " + sbreborn.toString());

			return (output);
			//return neoScrypt.neoscrypt(input, output);


		}
		return output;

	}


	public native byte[] neoscrypt(byte[] input,byte[] output);

}
