package com.facebook.analytics.analyticsmodule;

import android.content.Context;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.logger.IAnalyticsPeriodicEventReporter;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;
import com.google.common.primitives.Longs;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: send_failure */
public class DBSizePeriodicReporter implements IAnalyticsPeriodicEventReporter {
    private static volatile DBSizePeriodicReporter f4029b;
    private final Context f4030a;

    /* compiled from: send_failure */
    class FileSize {
        public static Comparator<FileSize> f4026c = new C03621();
        private String f4027a;
        public long f4028b;

        /* compiled from: send_failure */
        final class C03621 implements Comparator<FileSize> {
            C03621() {
            }

            public final int compare(Object obj, Object obj2) {
                return Longs.a(((FileSize) obj2).f4028b, ((FileSize) obj).f4028b);
            }
        }

        public FileSize(File file) {
            this.f4027a = file.getName();
            this.f4028b = file.length();
        }

        public static JsonNode m3910b(FileSize fileSize) {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            objectNode.a("name", fileSize.f4027a);
            objectNode.a("size", fileSize.f4028b);
            return objectNode;
        }
    }

    public static com.facebook.analytics.analyticsmodule.DBSizePeriodicReporter m3911a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f4029b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.analyticsmodule.DBSizePeriodicReporter.class;
        monitor-enter(r1);
        r0 = f4029b;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m3913b(r0);	 Catch:{ all -> 0x0035 }
        f4029b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4029b;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.analyticsmodule.DBSizePeriodicReporter.a(com.facebook.inject.InjectorLike):com.facebook.analytics.analyticsmodule.DBSizePeriodicReporter");
    }

    private static DBSizePeriodicReporter m3913b(InjectorLike injectorLike) {
        return new DBSizePeriodicReporter((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public DBSizePeriodicReporter(Context context) {
        this.f4030a = context;
    }

    public final HoneyAnalyticsEvent m3915a(long j, String str) {
        return m3914b(j, str);
    }

    private HoneyClientEvent m3914b(long j, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("db_size_info");
        honeyClientEvent.e = j;
        honeyClientEvent.f = str;
        honeyClientEvent.c = "device";
        m3912a(honeyClientEvent);
        return honeyClientEvent;
    }

    private void m3912a(HoneyClientEvent honeyClientEvent) {
        long j = 0;
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        try {
            File[] listFiles = new File(this.f4030a.getFilesDir().getParentFile().getPath(), "databases").listFiles();
            List a = Lists.a(listFiles.length);
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                long length2;
                File file = listFiles[i];
                if (file.isFile()) {
                    length2 = file.length() + j;
                    try {
                        a.add(new FileSize(file));
                    } catch (Exception e) {
                        j = length2;
                    }
                } else {
                    length2 = j;
                }
                i++;
                j = length2;
            }
            Collections.sort(a, FileSize.f4026c);
            for (FileSize b : a.subList(0, Math.min(50, a.size()))) {
                arrayNode.a(FileSize.m3910b(b));
            }
        } catch (Exception e2) {
        }
        honeyClientEvent.a("db_folder_size", j);
        honeyClientEvent.a("db_top_sizes", arrayNode);
    }
}
