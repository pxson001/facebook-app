package com.facebook.memory.logging;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.logger.IAnalyticsPeriodicEventReporter;
import com.facebook.common.build.BuildConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: Unexpected exception while constructing JSONObject to be dispatched to Javascript. */
public class OtherAppMemoryUsageReporter implements IAnalyticsPeriodicEventReporter {
    private static final Comparator<ProcessInfo> f10465a = new C12301();
    private static volatile OtherAppMemoryUsageReporter f10466b;

    /* compiled from: Unexpected exception while constructing JSONObject to be dispatched to Javascript. */
    final class C12301 implements Comparator<ProcessInfo> {
        C12301() {
        }

        public final int compare(Object obj, Object obj2) {
            ProcessInfo processInfo = (ProcessInfo) obj;
            ProcessInfo processInfo2 = (ProcessInfo) obj2;
            if (processInfo.f10464c == processInfo2.f10464c) {
                return processInfo2.f10463b - processInfo.f10463b;
            }
            return processInfo2.f10464c - processInfo.f10464c;
        }
    }

    /* compiled from: Unexpected exception while constructing JSONObject to be dispatched to Javascript. */
    class ProcessInfo {
        String f10462a;
        int f10463b;
        int f10464c;

        public ProcessInfo(String str, int i, int i2) {
            this.f10462a = str;
            this.f10463b = i;
            this.f10464c = i2;
        }
    }

    public static com.facebook.memory.logging.OtherAppMemoryUsageReporter m10886a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f10466b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.memory.logging.OtherAppMemoryUsageReporter.class;
        monitor-enter(r1);
        r0 = f10466b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m10889b();	 Catch:{ all -> 0x0034 }
        f10466b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f10466b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.memory.logging.OtherAppMemoryUsageReporter.a(com.facebook.inject.InjectorLike):com.facebook.memory.logging.OtherAppMemoryUsageReporter");
    }

    private static OtherAppMemoryUsageReporter m10889b() {
        return new OtherAppMemoryUsageReporter();
    }

    @Nullable
    public final HoneyAnalyticsEvent m10890a(long j, String str) {
        List<ProcessInfo> a = m10887a();
        if (a.size() == 0) {
            return null;
        }
        String n = BuildConstants.n();
        String l = BuildConstants.l();
        Collections.sort(a, f10465a);
        long j2 = 0;
        long j3 = 0;
        int i = 0;
        long j4 = 0;
        long j5 = 0;
        ProcessInfo processInfo = null;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Object obj = null;
        long j6 = 0;
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        for (ProcessInfo processInfo2 : a) {
            if (processInfo2.f10464c != i2) {
                if (i2 >= 0) {
                    hashMap.put("total_rss_at_priority_" + processInfo2.f10464c, Long.valueOf(j4));
                }
                i2 = processInfo2.f10464c;
                j4 = 0;
            } else {
                j4 += (long) processInfo2.f10463b;
            }
            if (processInfo2.f10462a.startsWith("com.facebook")) {
                j2 += (long) processInfo2.f10463b;
                if (processInfo2.f10462a.startsWith(l)) {
                    j7 += (long) processInfo2.f10463b;
                } else {
                    j9 += (long) processInfo2.f10463b;
                }
            } else {
                j3 += (long) processInfo2.f10463b;
            }
            if (obj == null) {
                if (n.equals(processInfo2.f10462a)) {
                    obj = 1;
                    processInfo = processInfo2;
                } else {
                    i3++;
                    j8 = ((long) processInfo2.f10463b) + j8;
                    j5 = j4;
                }
            } else {
                i++;
                j6 += (long) processInfo2.f10463b;
            }
            hashMap2.put(processInfo2.f10462a + "." + processInfo2.f10464c, Integer.valueOf(processInfo2.f10463b));
        }
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("other_app_memory_usage");
        honeyClientEvent.a("earlier_process_count", i3);
        honeyClientEvent.a("earlier_total_rss_kb", j8);
        honeyClientEvent.a("later_process_count", i);
        honeyClientEvent.a("later_total_rss_kb", j6);
        honeyClientEvent.a("facebook_apps_total_rss_kb", j2);
        honeyClientEvent.a("non_facebook_total_rss_kb", j3);
        honeyClientEvent.a("total_rss_kb_before_fb4a_at_same_priority", j5);
        honeyClientEvent.a("fb4a_total_rss_kb", j7);
        honeyClientEvent.a("non_fb4a_total_rss_kb", j9);
        honeyClientEvent.a(hashMap);
        honeyClientEvent.a(hashMap2);
        if (processInfo == null) {
            return honeyClientEvent;
        }
        honeyClientEvent.a("fb4a_priority", processInfo.f10464c);
        return honeyClientEvent;
    }

    private static List<ProcessInfo> m10887a() {
        File file = new File("/proc");
        List arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                String name = file2.getName();
                Object obj = null;
                for (int i = 0; i < name.length(); i++) {
                    char charAt = name.charAt(i);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                }
                obj = 1;
                if (obj != null) {
                    ProcessInfo a = m10885a(file2);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
            }
        }
        return arrayList;
    }

    private static ProcessInfo m10885a(File file) {
        Scanner a;
        try {
            a = m10888a(file, "cmdline");
            try {
                String next = a.next();
                a.close();
                a = m10888a(file, "statm");
                a.nextInt();
                int nextInt = a.nextInt() * 4;
                a.close();
                Scanner a2 = m10888a(file, "oom_score_adj");
                try {
                    int nextInt2 = a2.nextInt();
                    a2.close();
                    return new ProcessInfo(next, nextInt, nextInt2);
                } catch (Exception e) {
                    a = a2;
                }
            } catch (Exception e2) {
                if (a != null) {
                    a.close();
                }
                return null;
            }
        } catch (Exception e3) {
            a = null;
            if (a != null) {
                a.close();
            }
            return null;
        }
    }

    private static Scanner m10888a(File file, String str) {
        Scanner scanner = new Scanner(new File(file.getCanonicalPath() + File.separator + str));
        scanner.useDelimiter("[^A-Za-z0-9.:]");
        return scanner;
    }
}
