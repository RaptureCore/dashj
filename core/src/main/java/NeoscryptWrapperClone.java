
public class NeoscryptWrapperClone {
	private static  boolean native_library_loaded = false;
	static
	{
		System.loadLibrary("neoscryptwrapper");
	}
	
	public static void main(String[] args) {

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

		NeoscryptWrapperClone neoScrypt = new NeoscryptWrapperClone();
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

	public static byte[] getHash(byte[] input) {
		/**
		 * calls the c- code
		 * @parameters:
		 * input: string to be hashed
		 * profile: defines which hash algorithm to use
		 *  - 0x3 : Scrypt
		 *  - 0x80000620 : neoscrypt for feathercoin
		 */
		NeoscryptWrapperClone neoScrypt = new NeoscryptWrapperClone();
		byte[] output = new byte[32];
		neoScrypt.neoscrypt(input, output);

		System.out.println("native_library_loaded status= " + native_library_loaded);
		if (native_library_loaded) {
			/* Todo: is char the right data type to pass?

			 */         System.out.println("Neoscrypt Running");

			neoScrypt.neoscrypt(input, output);
			//System.out.print( "output: " + output);
			//System.out.println("TESTEST");
			return neoScrypt.neoscrypt(input, output);

		}
		return output;

	}


	public native byte[] neoscrypt(byte[] input,byte[] output);

}
