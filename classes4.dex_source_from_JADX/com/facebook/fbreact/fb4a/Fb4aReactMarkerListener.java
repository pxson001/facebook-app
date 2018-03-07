package com.facebook.fbreact.fb4a;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fbreact.eventsperf.EventsPerfLogger;
import com.facebook.fbreact.interfaces.ListenableReactBridgeStartup.ReactBridgeStartupListener;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.react.bridge.ReactMarker.MarkerListener;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: manufacturer */
public class Fb4aReactMarkerListener implements MarkerListener {
    private static volatile Fb4aReactMarkerListener f8358d;
    public final Collection<ReactBridgeStartupListener> f8359a = Collections.synchronizedSet(new HashSet());
    private final MonotonicClock f8360b;
    private final QuickPerformanceLogger f8361c;

    public static com.facebook.fbreact.fb4a.Fb4aReactMarkerListener m8647a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8358d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.fbreact.fb4a.Fb4aReactMarkerListener.class;
        monitor-enter(r1);
        r0 = f8358d;	 Catch:{ all -> 0x003a }
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
        r0 = m8648b(r0);	 Catch:{ all -> 0x0035 }
        f8358d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8358d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbreact.fb4a.Fb4aReactMarkerListener.a(com.facebook.inject.InjectorLike):com.facebook.fbreact.fb4a.Fb4aReactMarkerListener");
    }

    private static Fb4aReactMarkerListener m8648b(InjectorLike injectorLike) {
        return new Fb4aReactMarkerListener((MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public Fb4aReactMarkerListener(MonotonicClock monotonicClock, QuickPerformanceLogger quickPerformanceLogger) {
        this.f8360b = monotonicClock;
        this.f8361c = quickPerformanceLogger;
    }

    public final void mo682a(String str) {
        if ("CREATE_REACT_CONTEXT_START".equals(str)) {
            this.f8361c.markerStart(7798786, 0, this.f8360b.now());
        } else if ("CREATE_REACT_CONTEXT_END".equals(str)) {
            long now = this.f8360b.now();
            long d = this.f8361c.d(7798786, 0);
            this.f8361c.a(7798786, (short) 2, now);
            for (EventsPerfLogger a : this.f8359a) {
                a.a(d, now);
            }
        } else if ("BUILD_NATIVE_MODULE_REGISTRY_START".equals(str)) {
            this.f8361c.b(7798788);
        } else if ("BUILD_NATIVE_MODULE_REGISTRY_END".equals(str)) {
            this.f8361c.b(7798788, (short) 2);
        } else if ("BUILD_JS_MODULE_CONFIG_START".equals(str)) {
            this.f8361c.b(7798789);
        } else if ("BUILD_JS_MODULE_CONFIG_END".equals(str)) {
            this.f8361c.b(7798789, (short) 2);
        } else if ("CREATE_CATALYST_INSTANCE_START".equals(str)) {
            this.f8361c.b(7798790);
        } else if ("CREATE_CATALYST_INSTANCE_END".equals(str)) {
            this.f8361c.b(7798790, (short) 2);
        } else if ("RUN_JS_BUNDLE_START".equals(str)) {
            this.f8361c.b(7798791);
        } else if ("RUN_JS_BUNDLE_END".equals(str)) {
            this.f8361c.b(7798791, (short) 2);
        }
    }
}
