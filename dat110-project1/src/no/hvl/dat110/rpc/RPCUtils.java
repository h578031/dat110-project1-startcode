package no.hvl.dat110.rpc;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;

import no.hvl.dat110.TODO;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the 
	// RPC message syntax [rpcid,parameter/return value]
	
	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded;

		// TODO: marshall RPC identifier and string into byte array
		encoded = new byte[str.length()+1];
		encoded[0] = rpcid;
		byte[] strArr = str.getBytes();
		for(int i=1; i<encoded.length; i++) {
			encoded[i] = strArr[i-1];
		}

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded;
		byte[] dec = new byte[data.length-1];
		// TODO: unmarshall String contained in data into decoded
		for(int i=0; i<data.length-1; i++) {
			dec[i] = data[i+1];
		}
		decoded = new String(dec);

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = {rpcid};

		// TODO: marshall RPC identifier in case of void type
		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {
		
		// TODO: unmarshall void type
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded = new byte[5];
		
		// TODO: marshall RPC identifier and string into byte array
		encoded[0] = rpcid;
		
		ByteBuffer buffer = ByteBuffer.allocate(4);
		byte[] bArr = buffer.putInt(x).array();
		for(int i=1; i<encoded.length; i++) {
			encoded[i] = bArr[i-1];
		}
		

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;

		// TODO: unmarshall integer contained in data
		ByteBuffer buffer = ByteBuffer.wrap(data);
		decoded = buffer.getInt(1);

		return decoded;

	}
}
