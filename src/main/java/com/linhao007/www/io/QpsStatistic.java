package com.linhao007.www.io;

import java.io.*;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/4/4 11:44
 * @description:
 */
public class QpsStatistic {
    /**
     * 对时间进行排序
     */
    public static final TreeMap<String, AtomicInteger> map = new TreeMap<>();

    public static final String ACCESS_LOG_PATH = "/Users/linhao007/access.log";
    public static final int BUFFER_SIZE = 20 * 1024 * 1024;


    public static void main(String[] args) {
        //假设每次读取20M 分批处理  统计
        File file = null;
        FileInputStream filePutStream = null;
        BufferedInputStream bufferedInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;

        try {
            file = new File(ACCESS_LOG_PATH);
            //构建文本输入缓冲流
            filePutStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(filePutStream);
            inputStreamReader = new InputStreamReader(bufferedInputStream);
            reader = new BufferedReader(inputStreamReader, BUFFER_SIZE);
            while (reader.ready()) {
                String line = reader.readLine();
                //进行解析处理
                String[] split = line.split("\\|");
                String timeStr = split[0];
                String platform = split[3];
                if (platform.equalsIgnoreCase("IOS")) {
                    if (map.containsKey(timeStr)) {
                        map.get(timeStr).incrementAndGet();
                    } else {
                        map.put(timeStr, new AtomicInteger(1));
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Exception:" + e);
        } finally {
            //关闭流
            try {
                if (reader != null) {
                    reader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (filePutStream != null) {
                    filePutStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(map.toString());


    }
}
