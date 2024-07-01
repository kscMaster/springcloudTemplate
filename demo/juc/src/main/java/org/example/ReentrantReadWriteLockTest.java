package org.example;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock读写锁示例
 **/
public class ReentrantReadWriteLockTest {
	
	private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	public static void read () {
		try {
			lock.readLock().lock();
			System.out.println(Thread.currentThread().getName() + "获取  读锁");
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + "释放  读锁");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
		}
	}
	
	public static void write () {
		try {
			lock.writeLock().lock();
			System.out.println(Thread.currentThread().getName() + "获取写锁");
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + "释放写锁");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.writeLock().unlock();
		}
	}
	
	public static void main (String[] args) {
		new Thread(() -> write(), "Thread1").start();
		new Thread(() -> write(), "Thread2").start();
		new Thread(() -> read(), "Thread3").start();
		new Thread(() -> read(), "Thread4").start();
	}
}