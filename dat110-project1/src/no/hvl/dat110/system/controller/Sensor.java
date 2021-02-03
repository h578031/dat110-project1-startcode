package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class Sensor extends RPCStub {

	private byte RPCID = 1;
	
	public int read() {
		
		int temp;
		
		// TODO
		// implement marshalling, call and unmarshalling for read RPC method
		byte[] req = RPCUtils.marshallVoid(RPCID);
		byte[] res = rpcclient.call(req);
		temp = RPCUtils.unmarshallInteger(res);
		return temp;
	}
	
}
