package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		this.payload = payload; // TODO: check for length within boundary
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	public byte[] encapsulate() {
		
		byte[] encoded = new byte[MessageConfig.SEGMENTSIZE];
		
		
		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format
		encoded[0] = (byte) getData().length;
		for(int i=1; i< payload.length+1; i++) {
			encoded[i] = payload[i-1];
		}
		
		return encoded;
		
	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate the data contained in the received byte array and store it 
		// in the payload of this message
		int size = received[0];
		byte[] pl = new byte[size];
		
		for(int i=0; i<size; i++) {
			pl[i] = received[i+1];
		}
		payload = pl;
		
	}
}
