import java.util.concurrent.*;


public class ThreadPoolTest2 {

	static ThreadPoolExecutor connectionExecutor = new ThreadPoolExecutor(1, 1,
			0L, TimeUnit.MILLISECONDS,
			new LinkedBlockingQueue<Runnable>(5),new MyThreadFactory(),new MyRejectedExecutionHandler());
	static int timeoutThreads=0;
	static int interruptedThreads=0;

	void testFuture(){
		try{
			System.out.println("Request received on Thread :"+Thread.currentThread().getName());
			Future<String> futureResponse = connectionExecutor.submit(() -> {
				try{
					System.out.println("Thread statistics Active Threads :"+connectionExecutor.getActiveCount()+
							" ,Pool Threads :"+connectionExecutor.getPoolSize()+
							",Tasks Scheduled Till Now :"+connectionExecutor.getTaskCount()+"," +
							" CompeltedTasks Till Now:"+connectionExecutor.getCompletedTaskCount()+
							", Worker queue size :"+connectionExecutor.getQueue().size() +
							", Pool Thread Name :"+ Thread.currentThread().getName());
					Thread.sleep(1000);
				}catch (Exception e){
					e.printStackTrace();
				}
				return "Sucess";
			});
			try{
				//System.out.println(futureResponse.get(2, TimeUnit.SECONDS));
				System.out.println(futureResponse.get());
			}/*catch(TimeoutException e){
				System.out.println("Thread Timeout : "+ Thread.currentThread().getName());
				++timeoutThreads;
			}*/catch(InterruptedException e){
				System.out.println("Interupted");
				++interruptedThreads;
			}
		}catch(Exception e){
			System.out.println("Exception"+e.getMessage()+e.getCause());
		}
	}

}
