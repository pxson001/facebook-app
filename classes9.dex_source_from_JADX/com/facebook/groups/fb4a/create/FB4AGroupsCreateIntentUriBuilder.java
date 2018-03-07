package com.facebook.groups.fb4a.create;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.fbreact.fragment.ImmersiveReactFragment;
import com.facebook.fbreact.fragment.ImmersiveReactFragment.Builder;
import com.facebook.groups.memberpicker.abtest.ExperimentsForMemberPickerModule;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: payments_flow_closed */
public class FB4AGroupsCreateIntentUriBuilder extends UriIntentBuilder {
    private static volatile FB4AGroupsCreateIntentUriBuilder f6871b;
    private final Boolean f6872a;

    public static com.facebook.groups.fb4a.create.FB4AGroupsCreateIntentUriBuilder m7145a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6871b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.groups.fb4a.create.FB4AGroupsCreateIntentUriBuilder.class;
        monitor-enter(r1);
        r0 = f6871b;	 Catch:{ all -> 0x003a }
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
        r0 = m7146b(r0);	 Catch:{ all -> 0x0035 }
        f6871b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6871b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.fb4a.create.FB4AGroupsCreateIntentUriBuilder.a(com.facebook.inject.InjectorLike):com.facebook.groups.fb4a.create.FB4AGroupsCreateIntentUriBuilder");
    }

    private static FB4AGroupsCreateIntentUriBuilder m7146b(InjectorLike injectorLike) {
        return new FB4AGroupsCreateIntentUriBuilder((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3967), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FB4AGroupsCreateIntentUriBuilder(QeAccessor qeAccessor, Provider<Boolean> provider, Boolean bool) {
        this.f6872a = bool;
        if (((Boolean) provider.get()).booleanValue() && qeAccessor.a(Liveness.Live, ExperimentsForMemberPickerModule.a, false)) {
            int i = 1;
        } else {
            boolean z = false;
        }
        if (i != 0) {
            Builder newBuilder = ImmersiveReactFragment.newBuilder();
            newBuilder.b = "FBGroupsCreateFlowRoute";
            newBuilder = newBuilder;
            newBuilder.a = "/groups_create_flow";
            newBuilder = newBuilder;
            newBuilder.h = 1;
            a(FBLinks.D, GroupsCreateReactActivity.class, newBuilder.a());
            return;
        }
        a(FBLinks.D, FragmentChromeActivity.class, ContentFragmentType.GROUP_NATIVE_CREATE_FRAGMENT.ordinal(), new Bundle());
    }

    public final Intent m7147a(Context context, String str) {
        Intent a = super.a(context, str);
        if (a == null) {
            return null;
        }
        Bundle bundle;
        Uri parse = Uri.parse(str);
        if (parse.getQueryParameterNames().isEmpty()) {
            bundle = null;
        } else {
            Bundle bundle2 = new Bundle();
            for (String str2 : parse.getQueryParameterNames()) {
                bundle2.putString(str2, parse.getQueryParameter(str2));
            }
            bundle = bundle2;
        }
        Bundle bundle3 = bundle;
        if (bundle3 == null) {
            return a;
        }
        a.putExtras(bundle3);
        return a;
    }

    protected final boolean m7148a() {
        return !this.f6872a.booleanValue();
    }
}
