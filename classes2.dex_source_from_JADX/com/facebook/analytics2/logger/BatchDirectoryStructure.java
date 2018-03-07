package com.facebook.analytics2.logger;

import android.annotation.SuppressLint;
import com.facebook.crudolib.processname.ProcessNameHelper;
import java.io.File;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: t_tn */
public class BatchDirectoryStructure {
    static final long f3415a = TimeUnit.DAYS.toMillis(1);
    static final long f3416b = TimeUnit.HOURS.toMillis(1);
    public static final Comparator<File> f3417c = new C02041();

    /* compiled from: t_tn */
    final class C02041 implements Comparator<File> {
        C02041() {
        }

        public final int compare(Object obj, Object obj2) {
            File file = (File) obj2;
            String name = ((File) obj).getName();
            String name2 = file.getName();
            int length = name.length();
            int length2 = name2.length();
            int i = length < length2 ? -1 : length == length2 ? 0 : 1;
            length = i;
            return length != 0 ? length : name.compareTo(name2);
        }
    }

    private BatchDirectoryStructure() {
    }

    public static File m5617a(File file) {
        String a = ProcessNameHelper.m2551a();
        if (a == null) {
            a = "unknown";
        }
        return new File(file, a);
    }

    public static File m5618a(File file, @Nullable String str) {
        return new File(file, m5619a(str));
    }

    @Nonnull
    private static String m5619a(@Nullable String str) {
        return str != null ? str : "null";
    }

    public static File m5621b(File file) {
        return new File(new File(new File(file, String.valueOf(m5616a())), String.valueOf(m5620b())), "batch-" + m5622c() + ".json");
    }

    public static long m5616a() {
        return m5622c() / f3415a;
    }

    public static long m5620b() {
        return m5622c() / f3416b;
    }

    @SuppressLint({"BadMethodUse-java.lang.System.currentTimeMillis"})
    public static long m5622c() {
        return System.currentTimeMillis();
    }
}
