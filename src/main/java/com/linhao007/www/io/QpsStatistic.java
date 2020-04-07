package com.linhao007.www.io;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/4/4 11:44
 * @description: java实现脚本：grep 'iOS' access.log | awk -F"|" '{print $1}' | sort | uniq -c
 */
public class QpsStatistic {
    /**
     * 对时间进行排序
     */
    public static  TreeMap<String, AtomicInteger> map = null;

    public static final String ACCESS_LOG_PATH = "/Users/linhao007/access.log";
    public static final int BUFFER_SIZE = 20 * 1024 * 1024;

    public static final String IOS = "IOS";
    public static final String ANDROID = "ANDROID";


    public static void main(String[] args) {
        //假设每次读取20M 分批处理  统计
        File file = null;
        FileInputStream filePutStream = null;
        BufferedInputStream bufferedInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;

        try {
            file = new File(ACCESS_LOG_PATH);
            if (!file.exists()) {
                System.out.println("文件信息不存在");
                return;
            }
            //构建文本输入缓冲流
            filePutStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(filePutStream);
            inputStreamReader = new InputStreamReader(bufferedInputStream);
            reader = new BufferedReader(inputStreamReader, BUFFER_SIZE);
            map = new TreeMap<>();
            while (reader.ready()) {
                String line = reader.readLine();

                //判断日志是否合法 进行解析处理
                String timeStr = getNormalTime(line, IOS);
                if (timeStr == null) {
                    continue;
                }

                if (map.containsKey(timeStr)) {
                    map.get(timeStr).incrementAndGet();
                } else {
                    map.put(timeStr, new AtomicInteger(1));
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

        //打印
        if (map != null) {
            for (String key : map.keySet()) {
                System.out.println(map.get(key).get() + " " + key);
            }
        }
    }

    /**
     * 日志格式校验
     */
    public static String getNormalTime(String line, String platformExample) {
        String timeStr = null;
        //判断行首不能为空字符 也过滤掉行为空的情况
        if (line.charAt(0) == ' ') {
            return timeStr;
        }

        //是否存在“|”来分割  不存在不进行统计
        if (!line.contains("|")) {
            return timeStr;
        }

        String[] split = line.split("\\|");
        timeStr = split[0];
        //判断是否是时间格式 不是时间格式 认为非法  不进行统计
        if (!isNormalDate(timeStr)) {
            return null;
        }

        String platform = split[3];
        if (!platform.equalsIgnoreCase(platformExample)) {
            return null;
        }
        return timeStr;
    }

    public static boolean isNormalDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        try {
            format.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
