package com.facebook.zero.fb4a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.zero.activity.DialtoneOptinInterstitialActivity;
import com.facebook.zero.activity.LightswitchOptinInterstitialActivity;
import com.facebook.zero.activity.TimeBasedOptinInterstitialActivity;
import com.facebook.zero.activity.ZeroOptinInterstitialActivity;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: mostRecentEventCount */
public class ZeroInterstitialIntentUriBuilder extends UriIntentBuilder {
    private static volatile ZeroInterstitialIntentUriBuilder f5338a;

    /* compiled from: mostRecentEventCount */
    class Fb4aInterstitialActivityIntentBuilder implements IUriTemplateIntentBuilder {
        private final Class<? extends Activity> f5337a;

        public Fb4aInterstitialActivityIntentBuilder(Class<? extends Activity> cls) {
            this.f5337a = cls;
        }

        public final Intent m6577a(Context context, Bundle bundle) {
            Intent intent = new Intent(context, this.f5337a);
            intent.setFlags(268435456);
            return intent;
        }
    }

    public static com.facebook.zero.fb4a.ZeroInterstitialIntentUriBuilder m6578a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5338a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.zero.fb4a.ZeroInterstitialIntentUriBuilder.class;
        monitor-enter(r1);
        r0 = f5338a;	 Catch:{ all -> 0x0039 }
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
        r0 = m6579b();	 Catch:{ all -> 0x0034 }
        f5338a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f5338a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.fb4a.ZeroInterstitialIntentUriBuilder.a(com.facebook.inject.InjectorLike):com.facebook.zero.fb4a.ZeroInterstitialIntentUriBuilder");
    }

    private static ZeroInterstitialIntentUriBuilder m6579b() {
        return new ZeroInterstitialIntentUriBuilder();
    }

    @Inject
    public ZeroInterstitialIntentUriBuilder() {
        a(FBLinks.a("zero_interstitial"), new Fb4aInterstitialActivityIntentBuilder(ZeroOptinInterstitialActivity.class));
        a(FBLinks.a("dialtone_optin_interstitial"), new Fb4aInterstitialActivityIntentBuilder(DialtoneOptinInterstitialActivity.class));
        a(FBLinks.a("lightswitch_optin_interstitial"), new Fb4aInterstitialActivityIntentBuilder(LightswitchOptinInterstitialActivity.class));
        a(FBLinks.a("time_based_optin_interstitial"), new Fb4aInterstitialActivityIntentBuilder(TimeBasedOptinInterstitialActivity.class));
    }
}
