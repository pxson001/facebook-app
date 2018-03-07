package com.facebook.content;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v4.app.Fragment;
import android.widget.Toast;
import com.facebook.common.android.String_PackageNameMethodAutoProvider;
import com.facebook.common.appchoreographer.ActivityChoreographerImpl;
import com.facebook.common.appchoreographer.iface.ActivityChoreographer;
import com.facebook.common.appchoreographer.iface.ChoreographedActivity;
import com.facebook.common.dextricks.Mlog;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.internal.ImmutableList;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: tokenRequestReason */
public class DefaultSecureContextHelper implements SecureContextHelper {
    private static final String f2438a = DefaultSecureContextHelper.class.getSimpleName();
    private static volatile DefaultSecureContextHelper f2439j;
    private final String f2440b;
    private final Lazy<SecureContextHelperUtil> f2441c;
    private final Lazy<FbErrorReporter> f2442d;
    private final Lazy<Set<ExternalIntentHandler>> f2443e;
    private final Lazy<Set<InternalIntentHandler>> f2444f;
    private final Lazy<DefaultExternalIntentHandler> f2445g;
    private final Lazy<DefaultInternalIntentHandler> f2446h;
    private final Lazy<ActivityChoreographer> f2447i;

    public static com.facebook.content.DefaultSecureContextHelper m4636a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2439j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.content.DefaultSecureContextHelper.class;
        monitor-enter(r1);
        r0 = f2439j;	 Catch:{ all -> 0x003a }
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
        r0 = m4638b(r0);	 Catch:{ all -> 0x0035 }
        f2439j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2439j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.content.DefaultSecureContextHelper.a(com.facebook.inject.InjectorLike):com.facebook.content.DefaultSecureContextHelper");
    }

    private static DefaultSecureContextHelper m4638b(InjectorLike injectorLike) {
        return new DefaultSecureContextHelper(String_PackageNameMethodAutoProvider.m4353a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 972), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494), ProviderLazy.m1699a(new STATICDI_MULTIBIND_PROVIDER$ExternalIntentHandler(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()), STATICDI_MULTIBIND_PROVIDER$InternalIntentHandler.m4653a(injectorLike), IdBasedLazy.m1808a(injectorLike, 5405), IdBasedLazy.m1808a(injectorLike, 967), IdBasedSingletonScopeProvider.m1810b(injectorLike, 466));
    }

    @Inject
    public DefaultSecureContextHelper(String str, Lazy<SecureContextHelperUtil> lazy, Lazy<FbErrorReporter> lazy2, Lazy<Set<ExternalIntentHandler>> lazy3, Lazy<Set<InternalIntentHandler>> lazy4, Lazy<DefaultExternalIntentHandler> lazy5, Lazy<DefaultInternalIntentHandler> lazy6, Lazy<ActivityChoreographer> lazy7) {
        this.f2440b = str;
        this.f2441c = lazy;
        this.f2442d = lazy2;
        this.f2443e = lazy3;
        this.f2444f = lazy4;
        this.f2445g = lazy5;
        this.f2446h = lazy6;
        this.f2447i = lazy7;
    }

    private static void m4637a(Context context) {
        Intent intent = new Intent("com.facebook.dexopt-pause");
        intent.putExtra("com.facebook.dexopt-unpause-time", System.nanoTime() + ((long) (1000000 * 10000)));
        context.sendBroadcast(intent);
        Mlog.v("send pause-optimization broadcast", new Object[0]);
    }

    public final void mo662a(Intent intent, Context context) {
        if (IntentResolver.m31356b(this.f2440b, (SecureContextHelperUtil) this.f2441c.get(), (AbstractFbErrorReporter) this.f2442d.get(), intent)) {
            try {
                Class cls = Class.forName(intent.getComponent().getClassName());
                if (ChoreographedActivity.class.isAssignableFrom(cls)) {
                    ((ActivityChoreographerImpl) this.f2447i.get()).m12867a(cls);
                }
            } catch (Throwable e) {
                BLog.a(f2438a, "Unable to track activity launch.", e);
            }
            for (InternalIntentHandler a : (Set) this.f2444f.get()) {
                if (a.mo3407a(intent, context)) {
                    return;
                }
            }
            ((DefaultInternalIntentHandler) this.f2446h.get()).mo3407a(intent, context);
        }
    }

    public final void mo660a(Intent intent, int i, Activity activity) {
        if (IntentResolver.m31356b(this.f2440b, (SecureContextHelperUtil) this.f2441c.get(), (AbstractFbErrorReporter) this.f2442d.get(), intent)) {
            for (InternalIntentHandler a : (Set) this.f2444f.get()) {
                if (a.mo3405a(intent, i, activity)) {
                    return;
                }
            }
            ((DefaultInternalIntentHandler) this.f2446h.get()).mo3405a(intent, i, activity);
        }
    }

    public final void mo661a(Intent intent, int i, Fragment fragment) {
        if (IntentResolver.m31356b(this.f2440b, (SecureContextHelperUtil) this.f2441c.get(), (AbstractFbErrorReporter) this.f2442d.get(), intent)) {
            for (InternalIntentHandler a : (Set) this.f2444f.get()) {
                if (a.mo3406a(intent, i, fragment)) {
                    return;
                }
            }
            ((DefaultInternalIntentHandler) this.f2446h.get()).mo3406a(intent, i, fragment);
        }
    }

    public final void mo665b(Intent intent, Context context) {
        m4637a(context);
        for (ExternalIntentHandler a : (Set) this.f2443e.get()) {
            if (a.a(intent, context)) {
                return;
            }
        }
        try {
            ((DefaultExternalIntentHandler) this.f2445g.get()).a(intent, context);
        } catch (SecurityException e) {
            ((AbstractFbErrorReporter) this.f2442d.get()).m2340a("ExternalIntentSecurityException", "SecurityException when launching external intent: " + intent);
            Toast.makeText(context, context.getText(2131230954), 0).show();
        }
    }

    public final void mo663b(Intent intent, int i, Activity activity) {
        m4637a((Context) activity);
        for (ExternalIntentHandler a : (Set) this.f2443e.get()) {
            if (a.a(intent, i, activity)) {
                return;
            }
        }
        try {
            ((DefaultExternalIntentHandler) this.f2445g.get()).a(intent, i, activity);
        } catch (SecurityException e) {
            ((AbstractFbErrorReporter) this.f2442d.get()).m2340a("ExternalIntentSecurityException", "SecurityException when launching external intent: " + intent);
            Toast.makeText(activity, activity.getText(2131230954), 0).show();
        }
    }

    public final void mo664b(Intent intent, int i, Fragment fragment) {
        m4637a(fragment.getContext());
        for (ExternalIntentHandler a : (Set) this.f2443e.get()) {
            if (a.a(intent, i, fragment)) {
                return;
            }
        }
        try {
            ((DefaultExternalIntentHandler) this.f2445g.get()).a(intent, i, fragment);
        } catch (SecurityException e) {
            ((AbstractFbErrorReporter) this.f2442d.get()).m2340a("ExternalIntentSecurityException", "SecurityException when launching external intent: " + intent);
            Toast.makeText(fragment.getContext(), fragment.m241a(2131230954), 0).show();
        }
    }

    @Nullable
    public final ComponentName mo666c(Intent intent, Context context) {
        boolean a;
        String str = this.f2440b;
        SecureContextHelperUtil secureContextHelperUtil = (SecureContextHelperUtil) this.f2441c.get();
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) this.f2442d.get();
        if (intent.getComponent() == null || !intent.getComponent().getPackageName().equals(str)) {
            PackageManager packageManager = secureContextHelperUtil.f23245a;
            ApplicationInfo applicationInfo = secureContextHelperUtil.f23246b;
            Iterable<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 64);
            List arrayList = new ArrayList();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                ComponentInfo componentInfo = resolveInfo.serviceInfo;
                if (SecureContextHelperUtil.m31349a(componentInfo, packageManager, applicationInfo)) {
                    arrayList.add(componentInfo);
                }
            }
            a = IntentResolver.m31354a(str, abstractFbErrorReporter, intent, (List) ImmutableList.a(arrayList));
        } else {
            a = true;
        }
        if (!a) {
            return null;
        }
        for (InternalIntentHandler b : (Set) this.f2444f.get()) {
            ComponentName b2 = b.mo3408b(intent, context);
            if (b2 != null) {
                return b2;
            }
        }
        return ((DefaultInternalIntentHandler) this.f2446h.get()).mo3408b(intent, context);
    }
}
