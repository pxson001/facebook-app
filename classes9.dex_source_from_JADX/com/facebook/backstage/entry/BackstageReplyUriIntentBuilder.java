package com.facebook.backstage.entry;

import android.content.ComponentName;
import android.os.Bundle;
import com.facebook.backstage.abtest.BackstageGatekeepers;
import com.facebook.backstage.consumption.BackstageNavigatorApi.NavigationState;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: resize_strategy */
public class BackstageReplyUriIntentBuilder extends UriIntentBuilder {
    private static volatile BackstageReplyUriIntentBuilder f5177b;
    private final BackstageGatekeepers f5178a;

    public static com.facebook.backstage.entry.BackstageReplyUriIntentBuilder m4956a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5177b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backstage.entry.BackstageReplyUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f5177b;	 Catch:{ all -> 0x003a }
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
        r0 = m4957b(r0);	 Catch:{ all -> 0x0035 }
        f5177b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5177b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backstage.entry.BackstageReplyUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.backstage.entry.BackstageReplyUriIntentBuilder");
    }

    private static BackstageReplyUriIntentBuilder m4957b(InjectorLike injectorLike) {
        return new BackstageReplyUriIntentBuilder(IdBasedSingletonScopeProvider.a(injectorLike, 11), BackstageGatekeepers.m4256b(injectorLike));
    }

    @Inject
    public BackstageReplyUriIntentBuilder(Provider<ComponentName> provider, BackstageGatekeepers backstageGatekeepers) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("open_divebar", true);
        bundle.putString("NAVIGATION_RECORDING_KEY", NavigationState.REPLY.name());
        a(FBLinks.eK, provider, bundle);
        this.f5178a = backstageGatekeepers;
    }

    protected final boolean m4958a() {
        return this.f5178a.m4258b();
    }
}
