package com.facebook.socialgood;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: PEOPLE_METADATA */
public class SocialGoodUriIntentBuilder extends UriIntentBuilder {
    private static volatile SocialGoodUriIntentBuilder f12615b;
    private final QeAccessor f12616a;

    public static com.facebook.socialgood.SocialGoodUriIntentBuilder m13024a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12615b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.socialgood.SocialGoodUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f12615b;	 Catch:{ all -> 0x003a }
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
        r0 = m13025b(r0);	 Catch:{ all -> 0x0035 }
        f12615b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12615b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.SocialGoodUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.socialgood.SocialGoodUriIntentBuilder");
    }

    private static SocialGoodUriIntentBuilder m13025b(InjectorLike injectorLike) {
        return new SocialGoodUriIntentBuilder((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SocialGoodUriIntentBuilder(QeAccessor qeAccessor) {
        this.f12616a = qeAccessor;
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.eW, "{fundraiser_campaign_id}", "{post_id}"), FragmentChromeActivity.class, ContentFragmentType.FUNDRAISER_PAGE_FRAGMENT.ordinal());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.eY, "{fundraiser_campaign_id}", "{action_type}"), FragmentChromeActivity.class, ContentFragmentType.FUNDRAISER_PAGE_FRAGMENT.ordinal());
    }

    public final Intent m13026a(Context context, String str) {
        Intent a = super.a(context, str);
        return (a == null || !this.f12616a.a(ExperimentsForSocialGoodModule.f12614a, false)) ? null : a;
    }

    public final boolean m13027a() {
        return true;
    }
}
