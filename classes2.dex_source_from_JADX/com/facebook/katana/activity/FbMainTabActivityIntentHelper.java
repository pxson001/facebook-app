package com.facebook.katana.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.facebook.apptab.state.NavigationConfig;
import com.facebook.apptab.state.TabBarStateManager;
import com.facebook.apptab.state.TabTag;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.internal.InternalIntentSigner;
import com.facebook.katana.intent.Fb4aInternalIntentSigner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: sms_takeover_legacy_fallback_devices */
public class FbMainTabActivityIntentHelper {
    private static volatile FbMainTabActivityIntentHelper f4532h;
    private final TabBarStateManager f4533a;
    private final Provider<ComponentName> f4534b;
    private final Provider<ComponentName> f4535c;
    private final Context f4536d;
    private final SecureContextHelper f4537e;
    private final InternalIntentSigner f4538f;
    private ImmutableMap<String, TabTag> f4539g;

    public static com.facebook.katana.activity.FbMainTabActivityIntentHelper m8233a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4532h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.activity.FbMainTabActivityIntentHelper.class;
        monitor-enter(r1);
        r0 = f4532h;	 Catch:{ all -> 0x003a }
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
        r0 = m8235b(r0);	 Catch:{ all -> 0x0035 }
        f4532h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4532h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.activity.FbMainTabActivityIntentHelper.a(com.facebook.inject.InjectorLike):com.facebook.katana.activity.FbMainTabActivityIntentHelper");
    }

    private static FbMainTabActivityIntentHelper m8235b(InjectorLike injectorLike) {
        return new FbMainTabActivityIntentHelper((Context) injectorLike.getInstance(Context.class), TabBarStateManager.m6591a(injectorLike), DefaultSecureContextHelper.m4636a(injectorLike), Fb4aInternalIntentSigner.m7903a(injectorLike), IdBasedProvider.m1811a(injectorLike, 12), IdBasedSingletonScopeProvider.m1809a(injectorLike, 11));
    }

    @Inject
    public FbMainTabActivityIntentHelper(Context context, TabBarStateManager tabBarStateManager, SecureContextHelper secureContextHelper, InternalIntentSigner internalIntentSigner, @FragmentChromeActivity Provider<ComponentName> provider, Provider<ComponentName> provider2) {
        this.f4536d = context;
        this.f4533a = (TabBarStateManager) Preconditions.checkNotNull(tabBarStateManager);
        this.f4538f = internalIntentSigner;
        this.f4534b = provider;
        this.f4535c = provider2;
        this.f4537e = secureContextHelper;
    }

    public final boolean m8241a(Activity activity, Intent intent) {
        if (!m8238e(intent)) {
            return false;
        }
        this.f4537e.mo662a(m8237d(intent), activity);
        activity.finish();
        return true;
    }

    private Intent m8237d(@Nullable Intent intent) {
        if (intent == null) {
            return null;
        }
        if (intent.getParcelableExtra("tabbar_target_intent") != null) {
            return intent;
        }
        Intent intent2 = new Intent();
        TabTag f = m8239f(intent);
        if (f == null) {
            intent2.setComponent(new ComponentName(this.f4536d, ImmersiveActivity.class));
        } else {
            intent2.setComponent((ComponentName) this.f4535c.get());
            intent2.setFlags(67108864);
            this.f4538f.mo1178a(intent2);
            intent.putExtra("target_tab_name", f.name());
        }
        intent2.putExtra("tabbar_target_intent", intent);
        return intent2;
    }

    public final Intent m8240a(@Nullable Intent intent) {
        if (intent == null) {
            return null;
        }
        Intent intent2 = (Intent) intent.getParcelableExtra("tabbar_target_intent");
        if (intent2 == null) {
            return intent;
        }
        intent2.setExtrasClassLoader(getClass().getClassLoader());
        return intent2;
    }

    public final boolean m8242b(@Nullable Intent intent) {
        return m8234a(intent, (ComponentName) this.f4534b.get());
    }

    private static boolean m8234a(@Nullable Intent intent, ComponentName componentName) {
        if (intent == null || intent.getComponent() == null || componentName == null) {
            return false;
        }
        return Objects.equal(intent.getComponent(), componentName);
    }

    public static boolean m8236c(Intent intent) {
        return intent.getExtras() == null || intent.getExtras().isEmpty();
    }

    private boolean m8238e(Intent intent) {
        return m8239f(intent) != null;
    }

    private TabTag m8239f(Intent intent) {
        if (this.f4539g == null) {
            NavigationConfig a = this.f4533a.m6594a();
            Builder builder = ImmutableMap.builder();
            ImmutableList immutableList = a.f7048a;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                TabTag tabTag = (TabTag) immutableList.get(i);
                builder.m609b(tabTag.fblink, tabTag);
            }
            this.f4539g = builder.m610b();
        }
        return (TabTag) this.f4539g.get(intent.getStringExtra("extra_launch_uri"));
    }
}
