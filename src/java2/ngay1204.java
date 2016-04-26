package java2;

public class ngay1204 {

	public static void main(String[] args) {
		// MultipleThreads t1 = new MultipleThreads();
		// MultipleThreads t2 = new MultipleThreads();
		// t1.setName("Thread2");
		// t2.setName("Thread3");
		// t1.setPriority(Thread.MIN_PRIORITY);
		// t2.setPriority(Thread.MAX_PRIORITY);
		// t1.start();
		// t2.start();
		// System.out.println("Number of threads running: " +
		// Thread.activeCount());

		// ThreadDemo objNew1 = new ThreadDemo("one");
		// ThreadDemo objNew2 = new ThreadDemo("two");
		// ThreadDemo objNew3 = new ThreadDemo("three");
		// System.out.println("First thread is alive :" +
		// objNew1.objTh.isAlive());
		// System.out.println("Second thread is alive :" +
		// objNew2.objTh.isAlive());
		// System.out.println("Third thread is alive :" +
		// objNew3.objTh.isAlive());
		// System.out.println(Thread.State.RUNNABLE);
		// try {
		// System.out.println("In the main method, waiting for the threads to
		// finish");
		// objNew1.objTh.join();
		// objNew2.objTh.join();
		// objNew3.objTh.join();
		//
		// } catch (InterruptedException e) {
		// System.out.println("Main thread is interrupted");
		// System.out.println("First thread is alive :" +
		// objNew1.objTh.isAlive());
		// System.out.println("Second thread is alive :" +
		// objNew2.objTh.isAlive());
		// System.out.println("Third thread is alive :" +
		// objNew3.objTh.isAlive());
		// System.out.println("Main thread is over and exiting");
		// }

		// Account accObj = new Account();
		// Transaction t1 = new Transaction(accObj, 1000.00);
		// Transaction t2 = new Transaction(accObj, 50.00);

//		DeadDemo objDead1 = new DeadDemo();
//		DeadDemo objDead2 = new DeadDemo();
//		Thread objTh1 = new Thread(objDead1, "thread1");
//		Thread objTh2 = new Thread(objDead2, "thread2");
//		objDead1.deadDemo = objDead2;
//		objDead2.deadDemo = objDead1;
//		objTh1.start();
//		objTh2.start();
//		System.out.println("Started");
//		try {
//			objTh1.join();
//			objTh2.join();
//		} catch (InterruptedException e) {
//			System.out.println("error occurred");
//		}
//		System.exit(0);
		
//		WaitTest1 waitTest1 = new WaitTest1();
//		WaitTest2 waitTest2 = new WaitTest2();
//		Thread thread1 = new Thread(waitTest1, "thread1");
//		Thread thread2 = new Thread(waitTest2, "thread2");
//		Thread thread3 = new Thread(waitTest1, "thread3");
//		
//		thread1.start();
//		thread2.start();
//		thread3.start();
//		System.exit(0);
		
		int a = 1;
		int d = 1;
		int b = a++;
		int c = ++d;
		
		System.out.println(b);
		System.out.println(c);
	}
}

class WaitTest1 implements Runnable {

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread()+ " got into run() of WaitTest1.");
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class WaitTest2 implements Runnable {

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread()+ " got into run() of WaitTest2.");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notify();
	}
}

class DeadDemo implements Runnable {
	DeadDemo deadDemo;

	public synchronized void run() {
		System.out.println(Thread.currentThread().getName()+" vo run roi");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("error occurred");
		}
		
		System.out.println("Deadlock o day");
		deadDemo.test();
	}

	public synchronized void test() {

	}
}

class Account {
	double balance = 200.0;

	public void deposit(double amount) {
		balance = balance + amount;
	}

	public void displayBalance() {
		System.out.println("Balance is:" + balance);
	}
}

class Transaction implements Runnable {
	double amount;
	Account account;
	Thread t;

	public Transaction(Account acc, double amt) {
		account = acc;
		amount = amt;
		t = new Thread(this);
		t.start();
	}

	// Synchronized block calls deposit method
	public void run() {
		synchronized (account) { // Synchronized block
			account.deposit(amount);
			account.displayBalance();
			System.out.println(account.balance++);
		}

		// synchronized (tinh) {
		// }
	}
}

class MultipleThreads extends Thread {
	String name;

	@Override
	public void run() {
		while (true) {
			name = Thread.currentThread().getName();
			System.out.println(name);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				break;
			}
		} // End of while loop
	}
}

class ThreadDemo implements Runnable {
	String name;
	Thread objTh;

	/* Constructor of the class */
	ThreadDemo(String str) {
		name = str;
		objTh = new Thread(this, name);
		System.out.println("New Threads are starting : " + objTh.toString());
		objTh.start();
	}

	public void run() {
		try {
			for (int count = 0; count < 2; count++) {
				System.out.println(name + " : " + count);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println(name + " interrupted");
		}
		
		System.out.println(name + " exiting");
	}
}
