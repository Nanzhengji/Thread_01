package threadDemo2;
class MyThread implements Runnable {
	private int ticket = 10;
	@Override
	public void run() {
		for(int i=0; i<10; i++ ) {
			this.sale();
		}
		
	}
	public synchronized void sale(){//卖票,方法为同步方法
		if(ticket>0) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("卖票:"+ticket--);
		}
	}
};

public class Test {
	public static void main(String[] args) {
		MyThread mt=new MyThread();
		Thread t1 = new Thread(mt);
		Thread t2 = new Thread(mt);
		Thread t3 = new Thread(mt);
		t1.start();
		t2.start();
		t3.start();

	}

}
