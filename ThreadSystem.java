package aed.stackmachine;

import aed.fifo.*;
import aed.positionlist.*;

public class ThreadSystem {
	private FIFO<Thread> threads;
	private int maxInstructions;

	public ThreadSystem(Thread[] threads, int maxInstructions) {
		this.threads = new FIFOList<Thread>();
		for (Thread thread : threads)
			this.threads.enqueue(thread);

		this.maxInstructions = maxInstructions;
	}

	public void run() {

		while (threads.size() > 0) {
			Thread thread = threads.first();
			threads.dequeue();
			int currInstructions = 0;

			while (!thread.halted() 
			       && currInstructions < maxInstructions) {
				thread.executeInstruction();
				currInstructions++; 
			}

			if (!thread.halted())
				threads.enqueue(thread);
		}
	}
}

