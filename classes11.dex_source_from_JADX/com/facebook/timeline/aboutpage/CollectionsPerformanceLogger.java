package com.facebook.timeline.aboutpage;

import com.facebook.graphql.cursor.abtest.ExperimentsForGraphCursorAbTestModule;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: NOTIFICATIONS_EMPTY_VIEW */
public class CollectionsPerformanceLogger {
    private static volatile CollectionsPerformanceLogger f13006c;
    public final QuickPerformanceLogger f13007a;
    private final CollectionsQeHelper f13008b;

    /* compiled from: NOTIFICATIONS_EMPTY_VIEW */
    public enum CollectionsFragmentType {
        SUMMARY,
        SECTION,
        COLLECTION
    }

    public static com.facebook.timeline.aboutpage.CollectionsPerformanceLogger m13751a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13006c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.aboutpage.CollectionsPerformanceLogger.class;
        monitor-enter(r1);
        r0 = f13006c;	 Catch:{ all -> 0x003a }
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
        r0 = m13752b(r0);	 Catch:{ all -> 0x0035 }
        f13006c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13006c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.CollectionsPerformanceLogger.a(com.facebook.inject.InjectorLike):com.facebook.timeline.aboutpage.CollectionsPerformanceLogger");
    }

    private static CollectionsPerformanceLogger m13752b(InjectorLike injectorLike) {
        return new CollectionsPerformanceLogger(QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), CollectionsQeHelper.m13763b(injectorLike));
    }

    @Inject
    public CollectionsPerformanceLogger(QuickPerformanceLogger quickPerformanceLogger, CollectionsQeHelper collectionsQeHelper) {
        this.f13007a = quickPerformanceLogger;
        this.f13008b = collectionsQeHelper;
    }

    private static int m13753d(CollectionsFragmentType collectionsFragmentType) {
        switch (collectionsFragmentType) {
            case SUMMARY:
                return 1703979;
            case SECTION:
                return 1703980;
            case COLLECTION:
                return 1703981;
            default:
                return 0;
        }
    }

    private static int m13754e(CollectionsFragmentType collectionsFragmentType) {
        switch (collectionsFragmentType) {
            case SUMMARY:
                return 1703982;
            case SECTION:
                return 1703983;
            case COLLECTION:
                return 1703984;
            default:
                return 0;
        }
    }

    private static List<Integer> m13755f(CollectionsFragmentType collectionsFragmentType) {
        List<Integer> arrayList = new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(m13753d(collectionsFragmentType)), Integer.valueOf(m13754e(collectionsFragmentType))}));
        if (collectionsFragmentType.equals(CollectionsFragmentType.COLLECTION)) {
            arrayList.add(Integer.valueOf(1703970));
            arrayList.add(Integer.valueOf(1703971));
        }
        if (collectionsFragmentType.equals(CollectionsFragmentType.SUMMARY)) {
            arrayList.add(Integer.valueOf(1703966));
        }
        return arrayList;
    }

    public final void m13756a(CollectionsFragmentType collectionsFragmentType) {
        for (Integer num : m13755f(collectionsFragmentType)) {
            String str;
            String str2;
            this.f13007a.b(num.intValue());
            this.f13007a.a(num.intValue(), this.f13008b.m13764a() ? "cursor" : "not_cursor");
            QuickPerformanceLogger quickPerformanceLogger = this.f13007a;
            int intValue = num.intValue();
            if (1 != 0) {
                str = "flatbuffer_parser";
            } else {
                str = "not_flatbuffer_parser";
            }
            quickPerformanceLogger.a(intValue, str);
            this.f13007a.a(num.intValue(), this.f13008b.m13765d() ? "batch_rerun" : "not_batch_rerun");
            quickPerformanceLogger = this.f13007a;
            intValue = num.intValue();
            if (this.f13008b.m13764a()) {
                str = "local_loader";
            } else {
                str = "android_loader_manager";
            }
            quickPerformanceLogger.a(intValue, str);
            this.f13007a.a(num.intValue(), "warm_mapped_files_" + this.f13008b.f13009a.a(ExperimentsForGraphCursorAbTestModule.a, "never"));
            QuickPerformanceLogger quickPerformanceLogger2 = this.f13007a;
            int intValue2 = num.intValue();
            if (this.f13008b.m13766f()) {
                str2 = "model_cache";
            } else {
                str2 = "no_model_cache";
            }
            quickPerformanceLogger2.a(intValue2, str2);
        }
    }

    public final void m13757a(CollectionsFragmentType collectionsFragmentType, boolean z) {
        int i;
        QuickPerformanceLogger quickPerformanceLogger = this.f13007a;
        switch (collectionsFragmentType) {
            case SUMMARY:
                if (!z) {
                    i = 1703986;
                    break;
                } else {
                    i = 1703985;
                    break;
                }
            case SECTION:
                if (!z) {
                    i = 1703988;
                    break;
                } else {
                    i = 1703987;
                    break;
                }
            case COLLECTION:
                if (!z) {
                    i = 1703990;
                    break;
                } else {
                    i = 1703989;
                    break;
                }
            default:
                i = 0;
                break;
        }
        quickPerformanceLogger.a(i, (short) 24);
        int d = m13753d(collectionsFragmentType);
        if (z) {
            this.f13007a.b(d, (short) 31);
        } else {
            this.f13007a.b(d, (short) 33);
        }
    }

    public final void m13758a(boolean z) {
        if (z) {
            this.f13007a.b(1703992);
        } else {
            this.f13007a.b(1703992, (short) 2);
        }
    }

    public final void m13759b(CollectionsFragmentType collectionsFragmentType) {
        for (Integer intValue : m13755f(collectionsFragmentType)) {
            this.f13007a.b(intValue.intValue(), (short) 4);
        }
    }

    public final void m13761c(CollectionsFragmentType collectionsFragmentType) {
        this.f13007a.b(m13754e(collectionsFragmentType), (short) 2);
        m13760c();
    }

    public final void m13760c() {
        this.f13007a.b(1703966, (short) 2);
    }
}
