package com.sm.server;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class TimeServerHandler extends ChannelHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String body = (String) msg;
		// byte[] req = new byte[buf.readableBytes()];
		// buf.readBytes(req);
		// String body = new String(req,
		// "UTF-8").substring(0,req.length-System.getProperty("line.separator").length());
		System.out.println("The server " + body);
		String currentTime = "QUERY TIME ORDER".equals(body) ? new Date().toString() : "BAD ORDER";
		ByteBuf resp = Unpooled.copiedBuffer((currentTime + System.getProperty("line.separator")).getBytes());
		resp.writeBytes("nihao".getBytes());
		resp.nioBuffer();
		ctx.writeAndFlush(resp);

	}

	/*
	 * @Override public void channelReadComplete(ChannelHandlerContext ctx)
	 * throws Exception { ctx.flush(); }
	 */

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}
	
	public static void main(String[] args) {
		System.out.println(System.getProperty("java.home"));
	}
}
