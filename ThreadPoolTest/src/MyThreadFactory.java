import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadFactory implements ThreadFactory {
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        MyThreadFactory() {
            namePrefix = "mypool-thread-";
        }

        public Thread newThread(Runnable r) {
            return  new Thread(r,namePrefix + threadNumber.getAndIncrement());
        }
}
