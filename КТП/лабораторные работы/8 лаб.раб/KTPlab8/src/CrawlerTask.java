import java.io.IOException;
import java.util.LinkedList;

public class CrawlerTask implements Runnable {
    private URLDepthPair urlDepthPair;
    private URLPool urlPool;
    private LinkedList<URLDepthPair> newLinks;
    private int count;
    public CrawlerTask(URLPool urlPool, int count){
        this.urlPool = urlPool;
        this.count = count;
    }
    @Override
    public void run() {

        while (true) {
            urlDepthPair = urlPool.get();
            try {
                Crawlers crawlers = new Crawlers(urlDepthPair.getURL(), 80, urlDepthPair.depth());
                newLinks = crawlers.StartScanner(urlDepthPair.depth() + 1);
                urlPool.set(newLinks);
            }
            catch (IOException e) {
                System.out.println(e);
            }
       }
    }

}
