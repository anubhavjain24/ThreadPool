public class ThreadPoolTest1 {


    public static void main(String a[]){
        ThreadPoolTest2 threadPoolTest2= new ThreadPoolTest2();
        int i=0;
        while(i<10){
            Thread t=new Thread(()->{
                threadPoolTest2.testFuture();
            });
            t.start();
            ++i;
        }
    }
}
