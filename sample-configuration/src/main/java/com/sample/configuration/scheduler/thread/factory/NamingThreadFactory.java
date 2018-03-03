/*
 * Copyright (c)
 */

package com.sample.configuration.scheduler.thread.factory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jugalkishorsahu on Feb, 2018
 */
public class NamingThreadFactory implements ThreadFactory {

	private static final AtomicInteger poolNumber = new AtomicInteger(1);
	private final ThreadGroup group;
	private final AtomicInteger threadNumber = new AtomicInteger(1);
	private final String namePrefix;

	public NamingThreadFactory(String prefix) {
		SecurityManager s = System.getSecurityManager();
		group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
		namePrefix = new StringBuilder(prefix)
				.append("-")
				.append(poolNumber.getAndIncrement())
				.append("-thread-")
				.toString();
	}

	public Thread newThread(Runnable r) {
		Thread t = new Thread(group, r,
				new StringBuilder(namePrefix).append(threadNumber.getAndIncrement()).toString(), 0);

		if (t.isDaemon())
			t.setDaemon(false);

		if (t.getPriority() != Thread.NORM_PRIORITY)
			t.setPriority(Thread.NORM_PRIORITY);

		return t;
	}
}
