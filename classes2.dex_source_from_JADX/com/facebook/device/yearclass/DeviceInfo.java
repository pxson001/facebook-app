package com.facebook.device.yearclass;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build.VERSION;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.schema.Locators;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: gms_advertiser_id */
public class DeviceInfo {
    private static final FileFilter f22214a = new C08981();

    /* compiled from: gms_advertiser_id */
    final class C08981 implements FileFilter {
        C08981() {
        }

        public final boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            int i = 3;
            while (i < name.length()) {
                if (name.charAt(i) < '0' || name.charAt(i) > '9') {
                    return false;
                }
                i++;
            }
            return true;
        }
    }

    public static int m30098a() {
        int i = -1;
        if (VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            return new File("/sys/devices/system/cpu/").listFiles(f22214a).length;
        } catch (SecurityException e) {
            return i;
        } catch (NullPointerException e2) {
            return i;
        }
    }

    public static int m30102b() {
        int i = 0;
        int i2 = -1;
        while (i < m30098a()) {
            int i3;
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq");
                if (file.exists()) {
                    byte[] bArr = new byte[HTTPTransportCallback.BODY_BYTES_RECEIVED];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        i3 = 0;
                        while (bArr[i3] >= (byte) 48 && bArr[i3] <= (byte) 57 && i3 < HTTPTransportCallback.BODY_BYTES_RECEIVED) {
                            i3++;
                        }
                        Integer valueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i3)));
                        if (valueOf.intValue() > i2) {
                            i2 = valueOf.intValue();
                        }
                    } catch (NumberFormatException e) {
                        i++;
                    } finally {
                        fileInputStream.close();
                    }
                }
                i++;
            } catch (IOException e2) {
                return -1;
            }
        }
        if (i2 != -1) {
            return i2;
        }
        FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
        try {
            i3 = m30099a("cpu MHz", fileInputStream2) * 1000;
            if (i3 > i2) {
                i2 = i3;
            }
            return i2;
        } finally {
            fileInputStream2.close();
        }
    }

    @TargetApi(16)
    public static long m30101a(Context context) {
        if (VERSION.SDK_INT >= 16) {
            MemoryInfo memoryInfo = new MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/meminfo");
            try {
                long a = ((long) m30099a("MemTotal", fileInputStream)) * Locators.dm;
                return a;
            } finally {
                fileInputStream.close();
            }
        } catch (IOException e) {
            return -1;
        }
    }

    private static int m30099a(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i = 0;
            while (i < read) {
                if (bArr[i] == (byte) 10 || i == 0) {
                    if (bArr[i] == (byte) 10) {
                        i++;
                    }
                    int i2 = i;
                    while (i2 < read) {
                        int i3 = i2 - i;
                        if (bArr[i2] != str.charAt(i3)) {
                            continue;
                            break;
                        } else if (i3 == str.length() - 1) {
                            return m30100a(bArr, i2);
                        } else {
                            i2++;
                        }
                    }
                    continue;
                }
                i++;
            }
        } catch (IOException e) {
        } catch (NumberFormatException e2) {
        }
        return -1;
    }

    private static int m30100a(byte[] bArr, int i) {
        while (i < bArr.length && bArr[i] != (byte) 10) {
            if (bArr[i] < (byte) 48 || bArr[i] > (byte) 57) {
                i++;
            } else {
                int i2 = i + 1;
                while (i2 < bArr.length && bArr[i2] >= (byte) 48 && bArr[i2] <= (byte) 57) {
                    i2++;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
        }
        return -1;
    }
}
