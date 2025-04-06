
public class CounterApp {

	public static void main(String[] args) {
		CountUp countUp = new CountUp();
		CountDown countDown = new CountDown();
		
		Thread thread1 = new Thread(countUp);
		Thread thread2 = new Thread(countDown);
		
		thread1.start();
		try {
			thread1.join(); // Ensure second thread starts only after first finishes
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted: " + e.getMessage());
		}
		thread2.start();

	}

}

class CountUp implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i <= 20; i++) {
			System.out.println("Count Up: " + i);
			try {
				Thread.sleep(100); // Simulate some work
			} catch (InterruptedException e) {
				System.out.println("CountUp interrupted");
			}
		}
	}
	
}

class CountDown implements Runnable {
    @Override
    public void run() {
        for (int i = 20; i >= 0; i--) {
            System.out.println("Count Down: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("CountDown interrupted");
            }
        }
    }
}
