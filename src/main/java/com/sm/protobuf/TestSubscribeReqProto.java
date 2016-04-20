package com.sm.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

public class TestSubscribeReqProto {

	private static byte[] encode(SubsribeReqProto.SubscribeReq req) {
		return req.toByteArray();
	}

	private static SubsribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException {
		return SubsribeReqProto.SubscribeReq.parseFrom(body);
	}
	
	private static SubsribeReqProto.SubscribeReq createSubscribeReq(){
		SubsribeReqProto.SubscribeReq.Builder builder = SubsribeReqProto.SubscribeReq.newBuilder();
		
		builder.setSubReqId(1121);
		builder.setUserName("abcd");
		builder.setAddress("chja");
		builder.setPhoneNumber("123123123")
		;builder.setProductName("好");
		return builder.build();
		
	}
	
	public static void main(String[] args) throws InvalidProtocolBufferException {
		SubsribeReqProto.SubscribeReq req =createSubscribeReq();
		System.out.println("req:"+req);
		System.out.println("req-encode:"+decode(encode(req)));
		
		System.out.println(decode(encode(req)).equals(req));
	}

}
