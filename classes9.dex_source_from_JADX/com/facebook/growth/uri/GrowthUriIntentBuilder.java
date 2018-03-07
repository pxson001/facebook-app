package com.facebook.growth.uri;

import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.growth.addcontactpoint.AddContactpointActivity;
import com.facebook.growth.friendfinder.FriendFinderLearnMoreActivity;
import com.facebook.growth.friendfinder.FriendFinderStartActivity;
import com.facebook.growth.promotion.FriendingPossibilitiesActivity;
import com.facebook.growth.promotion.NativeNameActivity;
import com.facebook.ipc.katana.findfriends.CIFlow;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: p2p_pin_status_update */
public class GrowthUriIntentBuilder extends UriIntentBuilder {
    private static volatile GrowthUriIntentBuilder f7537a;

    public static com.facebook.growth.uri.GrowthUriIntentBuilder m7829a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f7537a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.growth.uri.GrowthUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f7537a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m7830b();	 Catch:{ all -> 0x0034 }
        f7537a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f7537a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.growth.uri.GrowthUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.growth.uri.GrowthUriIntentBuilder");
    }

    private static GrowthUriIntentBuilder m7830b() {
        return new GrowthUriIntentBuilder();
    }

    @Inject
    public GrowthUriIntentBuilder() {
        a(StringFormatUtil.a(FBLinks.a("findfriends?ci_flow={%s %s}&ccu_ref={%s %s}&force_show_legal_screen={!%s false}"), new Object[]{"ci_flow", CIFlow.UNKNOWN.value, "ccu_ref", "UNKNOWN", "force_show_legal_screen"}), FriendFinderStartActivity.class);
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.dC, "{QUICK_PROMOTION}"), FriendingPossibilitiesActivity.class);
        a(FBLinks.dD, NativeNameActivity.class);
        a(FBLinks.dL, AddContactpointActivity.class);
        a(FBLinks.cb, FriendFinderLearnMoreActivity.class);
    }
}
