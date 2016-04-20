package com.sm.server;

import com.sm.serializable.SubscribeReq;
import com.sm.serializable.SubscribeResp;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandler.Sharable;

@Sharable
public class SubReqServerHandler extends ChannelHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		SubscribeReq req = (SubscribeReq) msg;

		if ("Lilinfeng".equalsIgnoreCase(req.getUserName())) {
			System.out.println("req:" + req.toString());
			SubscribeResp resp = new SubscribeResp();
			resp.setSubReqId(req.getSubReqId());
			resp.setRespCode(0);
			resp.setDesc("netty succeed.");

			ctx.writeAndFlush(resp);
		}
	}
}
