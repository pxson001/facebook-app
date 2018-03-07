package com.facebook.groups.memberlist.intent;

import android.content.ComponentName;
import android.content.Intent;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: extra_location_text */
public class MembershipIntentBuilder {
    private static volatile MembershipIntentBuilder f14442b;
    private final Provider<ComponentName> f14443a;

    public static com.facebook.groups.memberlist.intent.MembershipIntentBuilder m15977a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14442b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.groups.memberlist.intent.MembershipIntentBuilder.class;
        monitor-enter(r1);
        r0 = f14442b;	 Catch:{ all -> 0x003a }
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
        r0 = m15978b(r0);	 Catch:{ all -> 0x0035 }
        f14442b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14442b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberlist.intent.MembershipIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.groups.memberlist.intent.MembershipIntentBuilder");
    }

    private static MembershipIntentBuilder m15978b(InjectorLike injectorLike) {
        return new MembershipIntentBuilder(IdBasedProvider.a(injectorLike, 12));
    }

    @Inject
    public MembershipIntentBuilder(@FragmentChromeActivity Provider<ComponentName> provider) {
        this.f14443a = provider;
    }

    public final Intent m15980a(String str, String str2, boolean z, String str3, @Nullable String str4) {
        Intent a = m15976a();
        a.putExtra("group_feed_id", str);
        a.putExtra("group_admin_type", str2);
        a.putExtra("is_viewer_joined", z);
        a.putExtra("group_visibility", str3);
        a.putExtra("group_url", str4);
        a.putExtra("target_fragment", ContentFragmentType.GROUP_MEMBERSHIP_FRAGMENT.ordinal());
        return a;
    }

    public final Intent m15979a(String str, String str2) {
        Intent a = m15976a();
        a.putExtra("group_feed_id", str);
        a.putExtra("group_admin_type", str2);
        a.putExtra("target_fragment", ContentFragmentType.GROUP_SUGGEST_ADMIN_FRAGMENT.ordinal());
        return a;
    }

    private Intent m15976a() {
        return new Intent().setComponent((ComponentName) this.f14443a.get());
    }
}
