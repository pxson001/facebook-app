package com.facebook.analytics;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.util.Pair;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: tl_fr_box */
public class CpuTimeGetter {
    private static final Class<?> f1859a = CpuTimeGetter.class;

    public static native long getClockTicksPerSecond();

    static {
        SoLoader.a("analytics4a");
    }

    @DoNotStrip
    public static void init() {
    }

    private static String[] m2542c() {
        return m2539a("/proc/self/stat");
    }

    private static String[] m2539a(String str) {
        Throwable e;
        Throwable th;
        String[] strArr = null;
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            try {
                String readLine = randomAccessFile.readLine();
                try {
                    randomAccessFile.close();
                } catch (Throwable e2) {
                    m2538a(e2, StringFormatUtil.formatStrLocaleSafe("Error closing procfs file: %s", str));
                }
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return readLine.split(" ");
            } catch (Exception e3) {
                e2 = e3;
                try {
                    m2538a(e2, StringFormatUtil.formatStrLocaleSafe("Error reading cpu time from procfs file: %s", str));
                    if (randomAccessFile != null) {
                        return strArr;
                    }
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e22) {
                        m2538a(e22, StringFormatUtil.formatStrLocaleSafe("Error closing procfs file: %s", str));
                    }
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    return strArr;
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable e222) {
                            m2538a(e222, StringFormatUtil.formatStrLocaleSafe("Error closing procfs file: %s", str));
                        }
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                    }
                    throw th;
                }
            }
        } catch (Exception e4) {
            e222 = e4;
            randomAccessFile = strArr;
            m2538a(e222, StringFormatUtil.formatStrLocaleSafe("Error reading cpu time from procfs file: %s", str));
            if (randomAccessFile != null) {
                return strArr;
            }
            randomAccessFile.close();
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return strArr;
        } catch (Throwable e2222) {
            randomAccessFile = strArr;
            th = e2222;
            if (randomAccessFile != null) {
                randomAccessFile.close();
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
            throw th;
        }
    }

    private static double m2535a(String[] strArr, int i, long j) {
        double d = 0.0d;
        if (i >= strArr.length) {
            return d;
        }
        String str = strArr[i];
        try {
            return ((double) Long.parseLong(str)) / ((double) j);
        } catch (Throwable e) {
            m2538a(e, StringFormatUtil.formatStrLocaleSafe("Error parsing %d /proc/[pid]/stat field as long: %s", Integer.valueOf(i), str));
            return d;
        }
    }

    public static CpuUsageData m2536a() {
        return m2537a(m2542c());
    }

    private static CpuUsageData m2537a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        long clockTicksPerSecond = getClockTicksPerSecond();
        return new CpuUsageData(m2535a(strArr, 13, clockTicksPerSecond), m2535a(strArr, 14, clockTicksPerSecond), m2535a(strArr, 15, clockTicksPerSecond), m2535a(strArr, 16, clockTicksPerSecond));
    }

    public static Map<String, Pair<String, CpuUsageData>> m2541b() {
        try {
            Map d = m2543d();
            if (d == null) {
                return null;
            }
            Map<String, Pair<String, CpuUsageData>> hashMap = new HashMap();
            for (Entry entry : d.entrySet()) {
                CpuUsageData a = m2537a(m2539a(StringFormatUtil.formatStrLocaleSafe("/proc/%d/task/%s/stat", Integer.valueOf(Process.myPid()), entry.getKey())));
                if (a != null) {
                    hashMap.put(entry.getKey(), new Pair(entry.getValue(), a));
                }
            }
            return hashMap;
        } catch (Throwable e) {
            BLog.b(f1859a, "Error getting thread level CPU Usage data", e);
            return null;
        }
    }

    private static Map<String, String> m2543d() {
        File file;
        Throwable e;
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        String str = "/proc/self/task";
        Map<String, String> hashMap = new HashMap();
        try {
            file = new File(str);
            try {
                for (File file2 : file.listFiles()) {
                    String b = m2540b(file2.getName());
                    if (b != null) {
                        hashMap.put(file2.getName(), b);
                    }
                }
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return hashMap;
            } catch (Exception e2) {
                e = e2;
                try {
                    m2538a(e, StringFormatUtil.formatStrLocaleSafe("Error getting threads from task directory: %s", str));
                    if (file != null) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                    }
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (file != null) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                    }
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            file = null;
            m2538a(e, StringFormatUtil.formatStrLocaleSafe("Error getting threads from task directory: %s", str));
            if (file != null) {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            file = null;
            if (file != null) {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
            throw e;
        }
    }

    private static String m2540b(String str) {
        try {
            Throwable th;
            Throwable th2;
            RandomAccessFile randomAccessFile = new RandomAccessFile(StringFormatUtil.formatStrLocaleSafe("/proc/self/task/%s/comm", str), "r");
            try {
                String readLine = randomAccessFile.readLine();
                randomAccessFile.close();
                return readLine;
            } catch (Throwable th3) {
                th = th3;
            }
            if (th2 != null) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th2, th4);
                }
            } else {
                randomAccessFile.close();
            }
            throw th;
            throw th;
        } catch (IOException e) {
            return null;
        }
    }

    private static void m2538a(Throwable th, String str) {
        BLog.a(f1859a, str, th);
    }
}
