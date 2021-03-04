package com.yoscar.demo.thredDemo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class PicDownloadThread extends Thread {

    private String url;

    private String fileName;

    public PicDownloadThread(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        WebDownloader downloader = new WebDownloader();
        downloader.downloader(url, fileName);
        System.out.println("下载文件名为：" + fileName);
    }

    public static void main(String[] args) {
        PicDownloadThread thread1 = new PicDownloadThread("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fa0.att.hudong.com%2F30%2F29%2F01300000201438121627296084016.jpg&refer=http%3A%2F%2Fa0.att.hudong.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1617413212&t=b78a6e781e8ea754858421ffe079af42", "猫.png");
        PicDownloadThread thread2 = new PicDownloadThread("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fa2.att.hudong.com%2F27%2F81%2F01200000194677136358818023076.jpg&refer=http%3A%2F%2Fa2.att.hudong.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1617413212&t=3b6945645de483a98e46581bd23ce6a1", "鹿.png");
        PicDownloadThread thread3 = new PicDownloadThread("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fa0.att.hudong.com%2F52%2F62%2F31300542679117141195629117826.jpg&refer=http%3A%2F%2Fa0.att.hudong.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1617413212&t=7e29928e3403c0ba60f7c0d993ff2ed9", "阳.png");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class WebDownloader {
    public void downloader(String url, String fileName) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("下载图片异常");
        }
    }
}
