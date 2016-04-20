package com.sm.client;

import java.util.Random;

import com.sm.serializable.SubscribeReq;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class SubReqClientHandler extends ChannelHandlerAdapter {
	
	private Random random = new Random();

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		for (int i = 0; i < 10; i++) {
			SubscribeReq req = new SubscribeReq();
			req.setAddress("上海市浦东新区");
			req.setPhoneNumber("1851564648947");
			req.setProductName("权威只能");
			req.setSubReqId(random.nextInt());
			req.setUserName("Lilinfeng");
			ctx.write(req);
		}
		ctx.flush();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("msg"+msg);
	}
}
