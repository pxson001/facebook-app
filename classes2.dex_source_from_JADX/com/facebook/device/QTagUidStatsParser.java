package com.facebook.device;

import android.annotation.TargetApi;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import com.facebook.device.resourcemonitor.DataUsageBytes;
import com.google.common.annotations.VisibleForTesting;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/* compiled from: setChildrenDrawingOrderEnabled */
public class QTagUidStatsParser {
    public static boolean m9247a() {
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            boolean exists = new File("/proc/net/xt_qtaguid/stats").exists();
            return exists;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    @TargetApi(9)
    public static DataUsageBytes m9243a(int i, int i2) {
        return m9244a(i, i2, 0).m9251b(m9244a(i, i2, 1));
    }

    @TargetApi(9)
    public static DataUsageBytes m9244a(int i, int i2, int i3) {
        Throwable e;
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        InputStream inputStream = null;
        InputStream dataInputStream;
        try {
            dataInputStream = new DataInputStream(new FileInputStream(new File("/proc/net/xt_qtaguid/stats")));
            try {
                DataUsageBytes a = m9245a(dataInputStream, i, i2, i3);
                try {
                    dataInputStream.close();
                } catch (IOException e2) {
                }
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return a;
            } catch (FileNotFoundException e3) {
                e = e3;
                try {
                    throw new QTagUidStatsParserException(e);
                } catch (Throwable th) {
                    e = th;
                    inputStream = dataInputStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    throw e;
                }
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            dataInputStream = null;
            throw new QTagUidStatsParserException(e);
        } catch (Throwable th2) {
            e = th2;
            if (inputStream != null) {
                inputStream.close();
            }
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw e;
        }
    }

    @VisibleForTesting
    private static DataUsageBytes m9245a(InputStream inputStream, int i, int i2, int i3) {
        DataUsageBytes dataUsageBytes = DataUsageBytes.f5369a;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            byte[] bArr = new byte[4096];
            Object obj = 1;
            int read = inputStream.read(bArr);
            DataUsageBytes dataUsageBytes2 = dataUsageBytes;
            while (read > 0) {
                int i4 = 0;
                while (i4 < read) {
                    DataUsageBytes dataUsageBytes3;
                    Object obj2;
                    Object obj3;
                    char c = (char) bArr[i4];
                    if (c == '\n') {
                        String stringBuilder2 = stringBuilder.toString();
                        stringBuilder.setLength(0);
                        if (obj != null) {
                            dataUsageBytes3 = dataUsageBytes2;
                            obj2 = null;
                        } else {
                            DataUsageBytes a = m9246a(stringBuilder2, i, i2, i3);
                            if (a != DataUsageBytes.f5369a) {
                                dataUsageBytes2 = dataUsageBytes2.m9251b(a);
                            }
                            obj3 = obj;
                            dataUsageBytes3 = dataUsageBytes2;
                            obj2 = obj3;
                        }
                    } else {
                        stringBuilder.append(c);
                        obj3 = obj;
                        dataUsageBytes3 = dataUsageBytes2;
                        obj2 = obj3;
                    }
                    i4++;
                    obj3 = obj2;
                    dataUsageBytes2 = dataUsageBytes3;
                    obj = obj3;
                }
                read = inputStream.read(bArr);
            }
            return dataUsageBytes2;
        } catch (Throwable e) {
            throw new QTagUidStatsParserException(e);
        } catch (Throwable e2) {
            throw new QTagUidStatsParserException(e2);
        }
    }

    private static DataUsageBytes m9246a(String str, int i, int i2, int i3) {
        try {
            StringTokenizer stringTokenizer = new StringTokenizer(str);
            stringTokenizer.nextToken();
            if (stringTokenizer.nextToken().equalsIgnoreCase("lo")) {
                return DataUsageBytes.f5369a;
            }
            if (m9242a(stringTokenizer.nextToken()) != i2) {
                return DataUsageBytes.f5369a;
            }
            if (Integer.parseInt(stringTokenizer.nextToken()) != i) {
                return DataUsageBytes.f5369a;
            }
            if (Integer.parseInt(stringTokenizer.nextToken()) != i3) {
                return DataUsageBytes.f5369a;
            }
            long parseLong = Long.parseLong(stringTokenizer.nextToken());
            stringTokenizer.nextToken();
            return new DataUsageBytes(parseLong, Long.parseLong(stringTokenizer.nextToken()));
        } catch (NoSuchElementException e) {
            return DataUsageBytes.f5369a;
        }
    }

    private static int m9242a(String str) {
        if (str.equals("0x0")) {
            return 0;
        }
        return new BigInteger(str.substring(2, str.length() - 8), 16).intValue();
    }
}
