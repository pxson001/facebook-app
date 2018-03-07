package com.facebook.common.cpu;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: voters.count */
public class ProcessorInfoUtil {
    public static final ProcessorInfoUtil f935a = new ProcessorInfoUtil();
    private int f936b;
    private int f937c;
    private int f938d = 0;
    private int f939e = Integer.MAX_VALUE;

    private ProcessorInfoUtil() {
    }

    public static ProcessorInfoUtil m1899a() {
        return f935a;
    }

    public final synchronized int m1903b() {
        int i = 1;
        int i2 = 0;
        synchronized (this) {
            if (this.f936b != 0) {
                i2 = this.f936b;
            } else {
                try {
                    this.f936b = -1;
                    String[] list = new File("/sys/devices/system/cpu/").list();
                    if (list == null || list.length == 0) {
                        i2 = this.f936b;
                    } else {
                        Matcher matcher = Pattern.compile("cpu[0-9]+").matcher(list[0]);
                        if (matcher.matches()) {
                            i2 = 1;
                        }
                        while (i < list.length) {
                            matcher.reset(list[i]);
                            if (matcher.matches()) {
                                i2++;
                            }
                            i++;
                        }
                        if (i2 > 0) {
                            this.f936b = i2;
                        }
                        i2 = this.f936b;
                    }
                } catch (Throwable e) {
                    BLog.a("ProcessorInfoUtil", "Unable to get reliable CPU Core count", e);
                }
            }
        }
        return i2;
    }

    public final int m1904c() {
        if (this.f937c == 0) {
            this.f937c = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return this.f937c;
    }

    public final int m1905d() {
        int b = m1903b();
        if (b == -1) {
            return m1904c();
        }
        return b;
    }

    private void m1900a(int i) {
        if (i > this.f938d) {
            this.f938d = i;
        }
        if (i < this.f939e) {
            this.f939e = i;
        }
    }

    private void m1901b(int i) {
        File file = new File(StringFormatUtil.formatStrLocaleSafe("/sys/devices/system/cpu/cpu%d/cpufreq/cpuinfo_max_freq", Integer.valueOf(i)));
        if (file.exists()) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                m1900a(Integer.parseInt(bufferedReader.readLine()));
            } finally {
                bufferedReader.close();
            }
        }
    }

    private void m1902g() {
        try {
            m1901b(0);
            if (m1903b() > 1) {
                m1901b(m1903b() - 1);
            }
            if (this.f938d == 0) {
                File file = new File("/proc/cpuinfo");
                if (file.exists()) {
                    String readLine;
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    while (true) {
                        try {
                            readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                if (readLine.startsWith("cpu MHz")) {
                                    break;
                                }
                            }
                            break;
                        } finally {
                            bufferedReader.close();
                        }
                    }
                    m1900a((int) (Float.parseFloat(readLine.substring(readLine.lastIndexOf(58) + 2)) * 1000.0f));
                }
            }
        } catch (Throwable e) {
            BLog.a("ProcessorInfoUtil", "Unable to read a CPU core maximum frequency", e);
            this.f938d = -1;
        }
        if (this.f938d <= this.f939e) {
            if (this.f938d == 0) {
                this.f938d = -1;
            }
            this.f939e = -1;
        }
    }

    public final Integer m1906e() {
        if (this.f938d == 0) {
            m1902g();
        }
        return Integer.valueOf(this.f938d);
    }

    public final Integer m1907f() {
        if (this.f938d == 0) {
            m1902g();
        }
        return Integer.valueOf(this.f939e);
    }
}
