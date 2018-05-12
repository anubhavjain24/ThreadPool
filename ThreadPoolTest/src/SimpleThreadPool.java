import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPool {

	public static void main(String[] args) {
		ExecutorService executorService= Executors.newFixedThreadPool(5);
		int i=0;
		while(i<10){
			executorService.execute(()-> {
				try {
					System.out.println("Inside Thread -> " + Thread.currentThread().getName());
					Thread.sleep(100);
				}catch (Exception e){

				}
			});
			i++;
		}
		//executorService.shutdown();
		executorService.shutdownNow();
	}
}
