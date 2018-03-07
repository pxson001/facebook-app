package com.facebook.confirmation.task;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.confirmation.logging.ConfirmationAnalyticsLogger;
import com.facebook.confirmation.protocol.ConfirmContactpointMethod;
import com.facebook.confirmation.protocol.ConfirmContactpointMethod.Params;
import com.facebook.confirmation.protocol.ConfirmationSource;
import com.facebook.confirmation.task.BackgroundConfirmationHelper.ConfirmationMethod;
import com.facebook.confirmation.util.SmsConfirmationReaderExperimental;
import com.facebook.confirmation.util.SmsReaderExperimental.SmsReaderPointer;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.growth.model.Contactpoint;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fb_api_caller_class */
public class SmsConfirmationReaderBackgroundTaskExperimental extends AbstractBackgroundTask {
    private static final ConfirmationMethod f12048a = ConfirmationMethod.EXPERIMENTAL_SMS_CONFIRMATION;
    private static final CallerContext f12049b = CallerContext.a(SmsConfirmationReaderBackgroundTaskExperimental.class);
    private static volatile SmsConfirmationReaderBackgroundTaskExperimental f12050m;
    private final AppStateManager f12051c;
    private final BackgroundConfirmationHelper f12052d;
    private final Clock f12053e;
    private final SmsConfirmationReaderExperimental f12054f;
    private final RuntimePermissionsUtil f12055g;
    private final Lazy<FbBroadcastManager> f12056h;
    private final Lazy<FbObjectMapper> f12057i;
    private final Lazy<ConfirmContactpointMethod> f12058j;
    private final Lazy<ConfirmationAnalyticsLogger> f12059k;
    private final Lazy<SingleMethodRunner> f12060l;

    public static com.facebook.confirmation.task.SmsConfirmationReaderBackgroundTaskExperimental m12729a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12050m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.confirmation.task.SmsConfirmationReaderBackgroundTaskExperimental.class;
        monitor-enter(r1);
        r0 = f12050m;	 Catch:{ all -> 0x003a }
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
        r0 = m12733b(r0);	 Catch:{ all -> 0x0035 }
        f12050m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12050m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.confirmation.task.SmsConfirmationReaderBackgroundTaskExperimental.a(com.facebook.inject.InjectorLike):com.facebook.confirmation.task.SmsConfirmationReaderBackgroundTaskExperimental");
    }

    private static SmsConfirmationReaderBackgroundTaskExperimental m12733b(InjectorLike injectorLike) {
        return new SmsConfirmationReaderBackgroundTaskExperimental(AppStateManager.a(injectorLike), BackgroundConfirmationHelper.m12689b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), SmsConfirmationReaderExperimental.m12744c(injectorLike), RuntimePermissionsUtil.b(injectorLike), IdBasedLazy.a(injectorLike, 401), IdBasedSingletonScopeProvider.b(injectorLike, 572), IdBasedLazy.a(injectorLike, 5316), IdBasedLazy.a(injectorLike, 881), IdBasedSingletonScopeProvider.b(injectorLike, 2289));
    }

    @Inject
    public SmsConfirmationReaderBackgroundTaskExperimental(AppStateManager appStateManager, BackgroundConfirmationHelper backgroundConfirmationHelper, Clock clock, SmsConfirmationReaderExperimental smsConfirmationReaderExperimental, RuntimePermissionsUtil runtimePermissionsUtil, Lazy<FbBroadcastManager> lazy, Lazy<FbObjectMapper> lazy2, Lazy<ConfirmContactpointMethod> lazy3, Lazy<ConfirmationAnalyticsLogger> lazy4, Lazy<SingleMethodRunner> lazy5) {
        super("SMS_CONFIRMATION_READER");
        this.f12051c = appStateManager;
        this.f12052d = backgroundConfirmationHelper;
        this.f12053e = clock;
        this.f12054f = smsConfirmationReaderExperimental;
        this.f12055g = runtimePermissionsUtil;
        this.f12056h = lazy;
        this.f12057i = lazy2;
        this.f12058j = lazy3;
        this.f12059k = lazy4;
        this.f12060l = lazy5;
    }

    public final boolean mo595i() {
        Map l = m12736l();
        List arrayList = new ArrayList();
        boolean z = false;
        for (Entry entry : l.entrySet()) {
            if (this.f12053e.a() - ((Long) entry.getValue()).longValue() <= 604800000) {
                z = true;
            } else {
                arrayList.add(entry.getKey());
            }
        }
        if (!arrayList.isEmpty()) {
            this.f12052d.m12695a(f12048a, (Contactpoint[]) arrayList.toArray(new Contactpoint[0]));
        }
        return z;
    }

    public final Set<Prerequisite> mo594h() {
        return EnumSet.of(Prerequisite.NETWORK_CONNECTIVITY, Prerequisite.USER_LOGGED_IN);
    }

    public final long mo593f() {
        if (!mo595i()) {
            return -1;
        }
        long j;
        if (this.f12051c.j()) {
            j = 1200000;
        } else {
            j = ((long) (this.f12052d.m12703e() + 1)) * 250;
        }
        return j + this.f12053e.a();
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        boolean a = this.f12055g.a("android.permission.READ_SMS");
        ((ConfirmationAnalyticsLogger) this.f12059k.get()).m12710a(a);
        if (a) {
            m12735k();
        }
        return Futures.a(new BackgroundResult(true));
    }

    private void m12735k() {
        this.f12052d.m12693a(this.f12052d.m12703e() + 1);
        Map l = m12736l();
        if (!l.isEmpty()) {
            SmsReaderPointer b = this.f12052d.m12699b();
            m12732a(l.keySet(), this.f12054f.mo902a(b));
            this.f12052d.m12696a(b);
        }
    }

    private Map<Contactpoint, Long> m12736l() {
        return this.f12052d.m12692a(f12048a);
    }

    private void m12732a(Set<Contactpoint> set, List<SmsCode> list) {
        Set<String> d = this.f12052d.m12702d();
        if ((!list.isEmpty() || !d.isEmpty()) && !set.isEmpty()) {
            ((ConfirmationAnalyticsLogger) this.f12059k.get()).m12707a(set.size(), list.size());
            Set c = this.f12052d.m12701c();
            Set linkedHashSet = new LinkedHashSet();
            for (SmsCode smsCode : list) {
                if (!c.contains(smsCode.a)) {
                    for (Contactpoint contactpoint : set) {
                        TriState a = m12728a(contactpoint, smsCode.a, smsCode.b);
                        if (a == TriState.YES) {
                            m12731a((Set) set, contactpoint);
                            return;
                        } else if (a == TriState.UNSET) {
                            linkedHashSet.add(smsCode.a);
                        } else {
                            c.add(smsCode.a);
                        }
                    }
                    continue;
                }
            }
            for (String str : d) {
                if (!c.contains(str)) {
                    for (Contactpoint contactpoint2 : set) {
                        TriState a2 = m12728a(contactpoint2, str, SmsCodeType.RETRY);
                        if (a2 == TriState.YES) {
                            m12731a((Set) set, contactpoint2);
                            return;
                        } else if (a2 == TriState.UNSET) {
                            linkedHashSet.add(str);
                        } else {
                            c.add(str);
                        }
                    }
                    continue;
                }
            }
            this.f12052d.m12700b(linkedHashSet);
            this.f12052d.m12698a(c);
        }
    }

    private void m12731a(Set<Contactpoint> set, Contactpoint contactpoint) {
        this.f12052d.m12695a(f12048a, (Contactpoint[]) set.toArray(new Contactpoint[0]));
        ((BaseFbBroadcastManager) this.f12056h.get()).a(new Intent("action_background_contactpoint_confirmed").putExtra("extra_background_confirmed_contactpoint", contactpoint));
    }

    private TriState m12728a(Contactpoint contactpoint, String str, SmsCodeType smsCodeType) {
        Params params = new Params(contactpoint, str, ConfirmationSource.ANDROID_AUTO_SMS_API);
        TriState triState = TriState.NO;
        try {
            TriState triState2;
            if (((Boolean) ((AbstractSingleMethodRunner) this.f12060l.get()).a((ApiMethod) this.f12058j.get(), params, f12049b)).booleanValue()) {
                triState2 = TriState.YES;
            } else {
                triState2 = triState;
            }
            ((ConfirmationAnalyticsLogger) this.f12059k.get()).m12708a(triState2, String.valueOf(smsCodeType), null);
            return triState2;
        } catch (Throwable th) {
            Throwable th2 = th;
            ((ConfirmationAnalyticsLogger) this.f12059k.get()).m12708a(triState, String.valueOf(smsCodeType), null);
        }
    }

    @Nullable
    private Pair<Integer, String> m12727a(ServiceException serviceException) {
        ApiErrorResult b = m12734b(serviceException);
        if (b == null) {
            return null;
        }
        Object c;
        Map map = (Map) m12730a(new 1(this), serviceException);
        if (map == null || !map.containsKey("error_message")) {
            c = b.m10834c();
        } else {
            c = (String) map.get("error_message");
        }
        return new Pair(Integer.valueOf(b.m10832a()), c);
    }

    @Nullable
    private static ApiErrorResult m12734b(ServiceException serviceException) {
        OperationResult operationResult = serviceException.result;
        if (operationResult == null) {
            return null;
        }
        Bundle bundle = operationResult.d;
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get("result");
        if (obj instanceof ApiErrorResult) {
            return (ApiErrorResult) obj;
        }
        return null;
    }

    @Nullable
    private <T> T m12730a(TypeReference<T> typeReference, ServiceException serviceException) {
        ApiErrorResult b = m12734b(serviceException);
        if (b == null) {
            return null;
        }
        Object d = b.m10835d();
        if (StringUtil.a(d)) {
            return null;
        }
        try {
            return ((FbObjectMapper) this.f12057i.get()).a(d, typeReference);
        } catch (IOException e) {
            return null;
        }
    }
}
