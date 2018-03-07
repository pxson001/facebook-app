package com.facebook.fbservice.service;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftErrorHelper;
import com.facebook.common.executors.BackgroundWorkLogger;
import com.facebook.common.executors.BaseBackgroundWorkLogger;
import com.facebook.common.executors.DefaultHandlerExecutorServiceFactory;
import com.facebook.common.executors.HandlerExecutorServiceFactory;
import com.facebook.common.executors.STATICDI_VARIABLE_ANNOTATION_PROVIDER$ThreadPriority;
import com.facebook.common.executors.ThreadPriority;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.common.util.ExceptionUtil;
import com.facebook.fbservice.service.IBlueService.Stub;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.generated.STATICDI_NAMED_CONSTANTS$java_lang_Class;
import com.google.common.collect.Maps;
import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: first_ad */
public class BlueServiceLogic extends Stub {
    private static final String f23633a = BlueServiceLogic.class.getName();
    private static volatile BlueServiceLogic f23634o;
    private final Object f23635b = new Object();
    @GuardedBy("mLock")
    private final Map<Class, BlueServiceQueue> f23636c = Maps.m838c();
    private final AtomicLong f23637d = new AtomicLong(System.currentTimeMillis());
    private final Context f23638e;
    private final BlueServiceQueueManager f23639f;
    private final ViewerContextManager f23640g;
    private final AbstractFbErrorReporter f23641h;
    private final AnalyticsLogger f23642i;
    private final DefaultHandlerExecutorServiceFactory f23643j;
    private final BackgroundWorkLogger f23644k;
    private final Provider<Set<BlueServiceQueueHook>> f23645l;
    private final SoftErrorHelper f23646m;
    private final Provider<Boolean> f23647n;

    public static com.facebook.fbservice.service.BlueServiceLogic m32037a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23634o;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.fbservice.service.BlueServiceLogic.class;
        monitor-enter(r1);
        r0 = f23634o;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m32039b(r0);	 Catch:{ all -> 0x0035 }
        f23634o = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23634o;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbservice.service.BlueServiceLogic.a(com.facebook.inject.InjectorLike):com.facebook.fbservice.service.BlueServiceLogic");
    }

    private static BlueServiceLogic m32039b(InjectorLike injectorLike) {
        return new BlueServiceLogic((Context) injectorLike.getInstance(Context.class), BlueServiceQueueManager.m32055a(injectorLike), ViewerContextManagerProvider.m2496b(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), DefaultHandlerExecutorServiceFactory.m32064a(injectorLike), BaseBackgroundWorkLogger.m1660a(injectorLike), new STATICDI_MULTIBIND_PROVIDER$BlueServiceQueueHook(injectorLike.getScopeAwareInjector()), SoftErrorHelper.m32068a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3971));
    }

    @Inject
    public BlueServiceLogic(Context context, BlueServiceQueueManager blueServiceQueueManager, ViewerContextManager viewerContextManager, FbErrorReporter fbErrorReporter, AnalyticsLogger analyticsLogger, HandlerExecutorServiceFactory handlerExecutorServiceFactory, BackgroundWorkLogger backgroundWorkLogger, Provider<Set<BlueServiceQueueHook>> provider, SoftErrorHelper softErrorHelper, Provider<Boolean> provider2) {
        this.f23638e = context;
        this.f23639f = blueServiceQueueManager;
        this.f23640g = viewerContextManager;
        this.f23641h = fbErrorReporter;
        this.f23642i = analyticsLogger;
        this.f23643j = handlerExecutorServiceFactory;
        this.f23644k = backgroundWorkLogger;
        this.f23645l = provider;
        this.f23646m = softErrorHelper;
        this.f23647n = provider2;
    }

    public final void m32044a() {
        synchronized (this.f23635b) {
            for (BlueServiceQueue c : this.f23636c.values()) {
                c.m32100c();
            }
            this.f23636c.clear();
        }
    }

    public final void m32048b() {
        synchronized (this.f23635b) {
            for (BlueServiceQueue c : this.f23636c.values()) {
                c.m32100c();
            }
            this.f23636c.clear();
        }
    }

    public final String mo3498a(String str, Bundle bundle, boolean z, @Nullable CallerContext callerContext) {
        return mo3499a(str, bundle, z, null, callerContext);
    }

    public final String mo3499a(String str, Bundle bundle, boolean z, @Nullable ICompletionHandler iCompletionHandler, @Nullable CallerContext callerContext) {
        String l;
        synchronized (this.f23635b) {
            if (this.f23639f.m32062c()) {
                throw new RemoteException();
            }
            CallerContext a;
            if (bundle != null) {
                try {
                    bundle.setClassLoader(this.f23638e.getClassLoader());
                } catch (Throwable e) {
                    new Object[1][0] = str;
                    String str2 = "Error occurred in startOperation(" + str + ", " + bundle + "), exception: " + ExceptionUtil.a(e);
                    this.f23641h.m2340a("BlueService", str2);
                    throw m32041c(str2);
                }
            }
            AppInitLockHelper.m8874a(this.f23638e);
            InjectorLike injectorLike = FbInjector.get(this.f23638e);
            Class a2 = STATICDI_NAMED_CONSTANTS$java_lang_Class.m32075a(str);
            BlueServiceQueue blueServiceQueue = (BlueServiceQueue) this.f23636c.get(a2);
            if (blueServiceQueue == null) {
                Provider a3 = STATICDI_VARIABLE_ANNOTATION_PROVIDER$BlueServiceHandler.m32076a(injectorLike, a2);
                ThreadPriority threadPriority = ThreadPriority.NORMAL;
                if (STATICDI_VARIABLE_ANNOTATION_PROVIDER$ThreadPriority.m32078a(a2)) {
                    threadPriority = STATICDI_VARIABLE_ANNOTATION_PROVIDER$ThreadPriority.m32077a(injectorLike, a2);
                }
                blueServiceQueue = m32038a(a2, a3, threadPriority);
                blueServiceQueue.m32098b();
                this.f23636c.put(a2, blueServiceQueue);
            }
            BlueServiceQueue blueServiceQueue2 = blueServiceQueue;
            l = Long.toString(this.f23637d.getAndIncrement());
            if (callerContext == null) {
                a = CallerContext.m9060a(a2);
            } else {
                a = callerContext;
            }
            blueServiceQueue2.m32094a(new Operation(l, str, bundle, z, a), iCompletionHandler);
        }
        return l;
    }

    private BlueServiceQueue m32038a(Class<? extends Annotation> cls, Provider<BlueServiceHandler> provider, ThreadPriority threadPriority) {
        return new BlueServiceQueue(cls, provider, (Set) this.f23645l.get(), this.f23643j, this.f23639f, this.f23640g, this.f23641h, this.f23642i, AwakeTimeSinceBootClock.get(), this.f23644k, threadPriority, this.f23646m, this.f23647n);
    }

    public final boolean mo3501a(String str, ICompletionHandler iCompletionHandler) {
        synchronized (this.f23635b) {
            for (BlueServiceQueue blueServiceQueue : this.f23636c.values()) {
                if (blueServiceQueue.m32095a(str)) {
                    break;
                }
            }
            BlueServiceQueue blueServiceQueue2 = null;
        }
        if (blueServiceQueue2 == null || !blueServiceQueue2.m32096a(str, iCompletionHandler)) {
            return false;
        }
        return true;
    }

    public final boolean mo3500a(String str) {
        BlueServiceQueue b = m32040b(str);
        if (b != null) {
            return b.m32099b(str);
        }
        return false;
    }

    public final boolean mo3502a(String str, RequestPriority requestPriority) {
        BlueServiceQueue b = m32040b(str);
        if (b != null) {
            return b.m32097a(str, requestPriority);
        }
        return false;
    }

    private BlueServiceQueue m32040b(String str) {
        BlueServiceQueue blueServiceQueue;
        synchronized (this.f23635b) {
            for (BlueServiceQueue blueServiceQueue2 : this.f23636c.values()) {
                if (blueServiceQueue2.m32095a(str)) {
                    break;
                }
            }
            blueServiceQueue2 = null;
        }
        return blueServiceQueue2;
    }

    @TargetApi(15)
    private static RemoteException m32041c(String str) {
        return new RemoteException(str);
    }
}
