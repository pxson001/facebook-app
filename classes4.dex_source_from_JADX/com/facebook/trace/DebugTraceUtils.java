package com.facebook.trace;

import com.facebook.common.fileupload.FileUploadUtils;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: lg */
public class DebugTraceUtils {
    public static final Class<?> f9393a = DebugTraceUtils.class;
    private static final Pattern f9394b = Pattern.compile("\\d+_.+\\.trace");
    private static final Pattern f9395c = Pattern.compile("(\\d+)_(.+)\\.trace\\.gz");
    private static volatile DebugTraceUtils f9396h;
    public final FileUploadUtils f9397d;
    private final TraceFileFlag f9398e;
    public final Clock f9399f;
    public final DebugTraceData f9400g;

    public static com.facebook.trace.DebugTraceUtils m9784a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9396h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.trace.DebugTraceUtils.class;
        monitor-enter(r1);
        r0 = f9396h;	 Catch:{ all -> 0x003a }
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
        r0 = m9785b(r0);	 Catch:{ all -> 0x0035 }
        f9396h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9396h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.trace.DebugTraceUtils.a(com.facebook.inject.InjectorLike):com.facebook.trace.DebugTraceUtils");
    }

    private static DebugTraceUtils m9785b(InjectorLike injectorLike) {
        return new DebugTraceUtils(FileUploadUtils.a(injectorLike), TraceFileFlag.m9789a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), DebugTraceData.m9779a(injectorLike));
    }

    @Inject
    public DebugTraceUtils(FileUploadUtils fileUploadUtils, TraceFileFlag traceFileFlag, Clock clock, DebugTraceData debugTraceData) {
        this.f9397d = fileUploadUtils;
        this.f9398e = traceFileFlag;
        this.f9399f = clock;
        this.f9400g = debugTraceData;
    }

    public final File[] m9787a() {
        if (!this.f9398e.m9791a()) {
            return null;
        }
        File[] a = this.f9397d.a(this.f9397d.c(), f9394b);
        this.f9398e.m9792b();
        return a;
    }

    public final File[] m9788b() {
        return this.f9397d.a(this.f9397d.c(), f9395c);
    }

    public static Matcher m9786c(String str) {
        Matcher matcher = f9395c.matcher(str);
        if (matcher.matches()) {
            return matcher;
        }
        throw new IllegalArgumentException("Trace file format invariant <timestamp>_perfname.trace.gz failed to hold true");
    }
}
