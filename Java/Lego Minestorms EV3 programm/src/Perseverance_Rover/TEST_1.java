package Perseverance_Rover;

public class TEST_1 {

	public static void main(String[] args) {
	       
        Thread testThread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i + " <--- Thread_1");
                }
            }
        });
       
        testThread.start();
       
       
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " <--- Outside of thread_2");
        }
       
    }
}