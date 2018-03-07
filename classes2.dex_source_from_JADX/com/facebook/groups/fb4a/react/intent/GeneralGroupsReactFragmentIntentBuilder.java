package com.facebook.groups.fb4a.react.intent;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.facebook.base.activity.ReactFragmentActivity;
import com.facebook.common.fragmentconstants.FragmentConstants$ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: iw */
public class GeneralGroupsReactFragmentIntentBuilder {
    private static final Class<?> f18720e = GeneralGroupsReactFragmentIntentBuilder.class;
    private static volatile GeneralGroupsReactFragmentIntentBuilder f18721f;
    private final Provider<ComponentName> f18722a;
    private final Provider<Boolean> f18723b;
    private final SecureContextHelper f18724c;
    private final QeAccessor f18725d;

    public static com.facebook.groups.fb4a.react.intent.GeneralGroupsReactFragmentIntentBuilder m26314a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18721f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.groups.fb4a.react.intent.GeneralGroupsReactFragmentIntentBuilder.class;
        monitor-enter(r1);
        r0 = f18721f;	 Catch:{ all -> 0x003a }
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
        r0 = m26316b(r0);	 Catch:{ all -> 0x0035 }
        f18721f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18721f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.fb4a.react.intent.GeneralGroupsReactFragmentIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.groups.fb4a.react.intent.GeneralGroupsReactFragmentIntentBuilder");
    }

    private static GeneralGroupsReactFragmentIntentBuilder m26316b(InjectorLike injectorLike) {
        return new GeneralGroupsReactFragmentIntentBuilder(IdBasedProvider.m1811a(injectorLike, 13), IdBasedProvider.m1811a(injectorLike, 3967), DefaultSecureContextHelper.m4636a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    GeneralGroupsReactFragmentIntentBuilder(@ReactFragmentActivity Provider<ComponentName> provider, Provider<Boolean> provider2, SecureContextHelper secureContextHelper, QeAccessor qeAccessor) {
        this.f18722a = provider;
        this.f18723b = provider2;
        this.f18724c = secureContextHelper;
        this.f18725d = qeAccessor;
    }

    public final void m26318a(String str, String str2, Context context) {
        if (m26315a(str2)) {
            this.f18724c.mo662a(m26317a(str, str2, false), context);
        }
    }

    @Nullable
    public final Intent m26317a(String str, String str2, boolean z) {
        if (!m26315a(str2)) {
            return null;
        }
        Intent component = new Intent().setComponent((ComponentName) this.f18722a.get());
        component.putExtra("target_fragment", FragmentConstants$ContentFragmentType.GENERAL_GROUPS_REACT_FRAGMENT.ordinal());
        component.putExtra("show_search", z);
        if (str != null) {
            component.putExtra("uri", str);
        }
        if (str2 == null) {
            return component;
        }
        component.putExtra("route", str2);
        return component;
    }

    private boolean m26315a(String str) {
        if (((Boolean) this.f18723b.get()).booleanValue()) {
            return "FBGroupStorySeenByRoute".equals(str) ? this.f18725d.mo594a(Liveness.Live, ExperimentsForGroupsFb4aReactIntentModule.a, false) : true;
        } else {
            BLog.a(f18720e, StringFormatUtil.a("React Native is turned off, not launching route: %s", new Object[]{str}));
            return false;
        }
    }
}
