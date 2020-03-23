package com.manu.hello.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @Desc:
 * @Author: jzman
 * @Date: 2020/3/10 14:25.
 */
class Test {
    public static void main(String[] args) {
        File file = new File("G://delete/update.zip");
        check_version(file);
        File file2 = new File("G://delete/test/update.zip");

        String m1 = null;
        String m2 = null;
        try {
            m1 = FileHelper.getFileMD5String(file);
            m2 = FileHelper.getFileMD5String(file2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("---m1-->" + m1);
        System.out.println("---m2-->" + m2);
        System.out.println(FileHelper.checkFileMD5Same(file, file2));

        test("20200306","yyyyMMdd");
//        test("2020031115","yyyyMMddHH");

        String te = "eng.amt.20200306";
        String te1 = "Rom_Debug_01.01_2020031115";
        String[] updateArr = te.split("\\.");
        String[] updateArr1 = te1.split("_");
        System.out.println("--updateArr--->"+ Arrays.toString(updateArr));
        System.out.println("--updateArr1--->"+ Arrays.toString(updateArr1));

        File file1 = new File("mnt/update.zip");
        System.out.println(file1.exists());
    }

    /**
     * 20200306  yyyyMMdd
     * 2020031115 yyyyMMddHH
     *
     * @param date
     * @param format
     */
    public static void test(String date, String format) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(new SimpleDateFormat(format).parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("日期[2016-12-31 12:30:45 123]对应毫秒：" + calendar.getTimeInMillis());

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("----->");
            }
        };
        timer.schedule(timerTask,1000,1000);
    }

    public static boolean check_version(File srcfile) {
        boolean retVal = false;
        ZipFile zfile = null;
        try {
            zfile = new ZipFile(srcfile);
            Enumeration zipEntry = zfile.entries();

            while (zipEntry.hasMoreElements()) {
                ZipEntry z = (ZipEntry) zipEntry.nextElement();
                //Log.d(TAG, "z:" + z.toString());
                if (z.getName().contains("build.prop")) {
                    int index = 0;
                    String rline = null;
                    InputStream is = zfile.getInputStream(z);
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);
                    while ((rline = br.readLine()) != null) {
                        if (rline.contains("ro.build.version.incremental")) {
                            index = rline.indexOf("=");
                            String ver = (String) rline.subSequence(index + 1, rline.length());
                            System.out.println("---ver--->" + ver);
//                            String nowVer = SystemProperties.get("ro.build.version.incremental");
//                            if(ver.equalsIgnoreCase(nowVer)) {
//                                retVal = true;
//                                break;
//                            }
                        }
                    }
                    br.close();
                    isr.close();
                    is.close();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (zfile != null) {
                    zfile.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retVal;
    }
}
