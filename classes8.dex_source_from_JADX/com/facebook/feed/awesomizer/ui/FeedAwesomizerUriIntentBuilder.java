package com.facebook.feed.awesomizer.ui;

import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.base.activity.ReactFragmentActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.feed.awesomizer.abtest.ExperimentsForFeedAwesomizerTestModule;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: gysc */
public class FeedAwesomizerUriIntentBuilder extends UriIntentBuilder {
    private static volatile FeedAwesomizerUriIntentBuilder f11851a;

    public static com.facebook.feed.awesomizer.ui.FeedAwesomizerUriIntentBuilder m13948a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11851a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.awesomizer.ui.FeedAwesomizerUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f11851a;	 Catch:{ all -> 0x003a }
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
        r0 = m13949b(r0);	 Catch:{ all -> 0x0035 }
        f11851a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11851a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.awesomizer.ui.FeedAwesomizerUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.feed.awesomizer.ui.FeedAwesomizerUriIntentBuilder");
    }

    private static FeedAwesomizerUriIntentBuilder m13949b(InjectorLike injectorLike) {
        return new FeedAwesomizerUriIntentBuilder((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3967));
    }

    @Inject
    public FeedAwesomizerUriIntentBuilder(QeAccessor qeAccessor, Provider<Boolean> provider) {
        boolean z = ((Boolean) provider.get()).booleanValue() && qeAccessor.a(ExperimentsForFeedAwesomizerTestModule.f11604b, false);
        a(FBLinks.bV, z ? ReactFragmentActivity.class : FragmentChromeActivity.class, ContentFragmentType.AWESOMIZER_HOME_FRAGMENT.ordinal());
        a(FBLinks.bW, FragmentChromeActivity.class, ContentFragmentType.AWESOMIZER_UNFOLLOW_FRAGMENT.ordinal());
        a(FBLinks.bX, FragmentChromeActivity.class, ContentFragmentType.AWESOMIZER_REFOLLOW_FRAGMENT.ordinal());
        a(FBLinks.bY, FragmentChromeActivity.class, ContentFragmentType.AWESOMIZER_SEEFIRST_FRAGMENT.ordinal());
        a(FBLinks.bZ, FragmentChromeActivity.class, ContentFragmentType.AWESOMIZER_DISCOVER_FRAGMENT.ordinal());
    }
}
