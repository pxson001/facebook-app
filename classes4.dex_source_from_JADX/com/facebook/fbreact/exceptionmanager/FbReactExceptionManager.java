package com.facebook.fbreact.exceptionmanager;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.fbreact.instance.FbReactInstanceHolder;
import com.facebook.fbreact.instance.FbReactInstanceHolderSpec;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.DevSupportManager;
import com.facebook.react.modules.core.JavascriptException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: marauder_session_id */
public class FbReactExceptionManager extends BaseJavaModule implements NativeModuleCallExceptionHandler {
    private static volatile FbReactExceptionManager f8342e;
    private final Lazy<FbReactInstanceHolder> f8343a;
    private final Lazy<FbReactInstanceHolderSpec> f8344b;
    private final AbstractFbErrorReporter f8345c;
    private final Set<NativeModuleCallExceptionHandler> f8346d = Collections.synchronizedSet(new HashSet());

    public static com.facebook.fbreact.exceptionmanager.FbReactExceptionManager m8599a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8342e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.fbreact.exceptionmanager.FbReactExceptionManager.class;
        monitor-enter(r1);
        r0 = f8342e;	 Catch:{ all -> 0x003a }
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
        r0 = m8601b(r0);	 Catch:{ all -> 0x0035 }
        f8342e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8342e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbreact.exceptionmanager.FbReactExceptionManager.a(com.facebook.inject.InjectorLike):com.facebook.fbreact.exceptionmanager.FbReactExceptionManager");
    }

    private static FbReactExceptionManager m8601b(InjectorLike injectorLike) {
        return new FbReactExceptionManager(IdBasedSingletonScopeProvider.b(injectorLike, 5782), IdBasedLazy.a(injectorLike, 5775), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public FbReactExceptionManager(Lazy<FbReactInstanceHolder> lazy, Lazy<FbReactInstanceHolderSpec> lazy2, FbErrorReporter fbErrorReporter) {
        this.f8343a = lazy;
        this.f8344b = lazy2;
        this.f8345c = fbErrorReporter;
    }

    public String getName() {
        return "RKExceptionsManager";
    }

    public final boolean mo673d() {
        return true;
    }

    @ReactMethod
    public void reportFatalException(String str, ReadableArray readableArray, int i) {
        if (!m8602p().a()) {
            throw new JavascriptException(m8600a(str, readableArray));
        }
    }

    private DevSupportManager m8602p() {
        return ((FbReactInstanceHolder) this.f8343a.get()).c().a();
    }

    @ReactMethod
    public void reportSoftException(String str, ReadableArray readableArray, int i) {
        if (!m8602p().a()) {
            this.f8345c.a(str, new JavascriptSoftException(m8600a(str, readableArray)));
        }
    }

    @ReactMethod
    public void updateExceptionMessage(String str, ReadableArray readableArray, int i) {
        m8602p();
    }

    public final void m8603a(NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler) {
        UiThreadUtil.b();
        this.f8346d.add(nativeModuleCallExceptionHandler);
    }

    public final void m8605b(NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler) {
        UiThreadUtil.b();
        this.f8346d.remove(nativeModuleCallExceptionHandler);
    }

    private static String m8600a(String str, ReadableArray readableArray) {
        StringBuilder append = new StringBuilder(str).append(", stack:\n");
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap b = readableArray.b(i);
            append.append(b.getString("methodName")).append("@").append(b.getInt("lineNumber"));
            if (b.hasKey("column") && !b.isNull("column") && b.getType("column") == ReadableType.Number) {
                append.append(":").append(b.getInt("column"));
            }
            append.append("\n");
        }
        return append.toString();
    }

    public final void mo672a(Exception exception) {
        if (m8602p().a()) {
            exception.getMessage();
            return;
        }
        synchronized (this.f8346d) {
            if (!this.f8346d.isEmpty()) {
                this.f8345c.a(exception.getMessage(), exception);
                ((FbReactInstanceHolder) this.f8343a.get()).b();
                UiThreadUtil.a(new 1(this, new HashSet(this.f8346d), exception));
            } else if (exception instanceof RuntimeException) {
                throw ((RuntimeException) exception);
            } else {
                throw new RuntimeException(exception);
            }
        }
    }
}
