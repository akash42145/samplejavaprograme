package com.example.module;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Fun extends RecursiveTask<Integer> {
	
	private static final long serialVersionUID = 1L;
	final int value;

	public Fun(int value) {
		this.value = value;
	}

	@Override
	protected Integer compute() { // w1
		if (value < 1) {
			return 1;

		}
		final Fun f1 = new Fun(value - 1);
		final Fun f2 = new Fun(value - 2);
		f1.fork();
		return f1.join() * f2.compute();
	}

	public static void main(String... data) {
		ForkJoinPool pool = new ForkJoinPool();
		try {
			System.out.print(pool.invoke(new Fun(10)));
		} finally {
			pool.shutdown();
		}
	}
}

/*
 * The class compiles and runs without issue, making Options A and B incorrect.
 * The purpose of the fork/join framework is to use parallel processing to
 * complete subtasks across multiple threads concurrently. Unfortunately,
 * calling the compute() method inside of an existing compute() does not spawn a
 * new thread. The result is that this task is completed using a single thread,
 * despite a pool of threads being available. For this reason, Option D is the
 * correct answer. In order to properly implement the fork/join framework, the
 * compute() method would need to be rewritten. The f1.compute() call should be
 * replaced with f1.fork() to spawn a separate task, followed by f2.compute() to
 * process the data on the current thread, and
 * ending in f1.join() to retrieve the results of the first task completed while
 * f2.compute() was being processed. If the code was rewritten as described,
 * then Option C would be the correct answer.
 */