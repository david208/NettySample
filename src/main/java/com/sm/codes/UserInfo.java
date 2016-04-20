package com.sm.codes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Random;

public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public byte[] encode() {
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

		byteBuffer.clear();
		byte[] value = this.name.getBytes();
		byteBuffer.put(value);
		byteBuffer.putInt(value.length);
		byteBuffer.putInt(this.age);
		byteBuffer.flip();
		byte[] result = new byte[byteBuffer.remaining()];
		byteBuffer.get(result);
		return result;

	}

	public static void main(String[] arg) throws IOException {
		Random random = new Random(1000);
		UserInfo userinfo = new UserInfo();
		userinfo.setAge(random.nextInt());
		userinfo.setName("my name is ");
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		objectOutputStream.writeObject(userinfo);
		objectOutputStream.flush();
		objectOutputStream.close();
		byte[] jdk = byteArrayOutputStream.toByteArray();
		byte[] sample = userinfo.encode();

		System.out.println(jdk.length + ":" + sample.length);
	}
}
