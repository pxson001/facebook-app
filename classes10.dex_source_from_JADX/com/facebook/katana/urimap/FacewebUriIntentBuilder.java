package com.facebook.katana.urimap;

import android.content.ComponentName;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.util.BundleUtils;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: tinsel_view_card */
public class FacewebUriIntentBuilder extends UriIntentBuilder {
    private static volatile FacewebUriIntentBuilder f1210a;

    public static com.facebook.katana.urimap.FacewebUriIntentBuilder m1242a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1210a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.urimap.FacewebUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f1210a;	 Catch:{ all -> 0x003a }
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
        r0 = m1243b(r0);	 Catch:{ all -> 0x0035 }
        f1210a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1210a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.urimap.FacewebUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.katana.urimap.FacewebUriIntentBuilder");
    }

    private static FacewebUriIntentBuilder m1243b(InjectorLike injectorLike) {
        return new FacewebUriIntentBuilder(IdBasedProvider.a(injectorLike, 12));
    }

    @Inject
    public FacewebUriIntentBuilder(@FragmentChromeActivity Provider<ComponentName> provider) {
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("faceweb/f?href={%s}"), "mobile_page"), provider, BundleUtils.a(new Object[]{"target_fragment", Integer.valueOf(ContentFragmentType.FACEWEB_FRAGMENT.ordinal())}));
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("facewebmodal/f?href={%s}"), "mobile_page"), provider, BundleUtils.a(new Object[]{"faceweb_modal", Boolean.valueOf(true)}));
    }
}
