package com.sm.protobuf;

import java.util.Random;

import com.sm.serializable.SubscribeReq;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class SubReqClientHandler extends ChannelHandlerAdapter {
	
	private Random random = new Random();

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		for (int i = 0; i < 10; i++) {
			SubsribeReqProto.SubscribeReq.Builder req = SubsribeReqProto.SubscribeReq.newBuilder();
			req.setAddress("444");
			req.setPhoneNumber("1851564648947");
			req.setProductName("22");
			req.setSubReqId(random.nextInt());
			req.setUserName("Lilinfeng");
			ctx.writeAndFlush(req);
		}
		ctx.flush();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("msg"+msg);
	}
}
