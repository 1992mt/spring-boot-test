package com.test;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicStampedReference;

public class UserDirTest {
	public static void main(String[] args) {
			System.out.println(System.getProperty("user.dir"));
			AtomicBoolean ab =new AtomicBoolean();
			AtomicStampedReference asr=new AtomicStampedReference(new Object(), 0);
			ConcurrentLinkedQueue clq=new ConcurrentLinkedQueue();
	}
}
