package com.facebook.offers.uri;

import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.offers.activity.OfferRedirectToWebActivity;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: current_context_menu_place */
public class OffersUriIntentBuilder extends UriIntentBuilder {
    private static volatile OffersUriIntentBuilder f16525a;

    public static com.facebook.offers.uri.OffersUriIntentBuilder m19472a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16525a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.offers.uri.OffersUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f16525a;	 Catch:{ all -> 0x0039 }
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
        r0 = m19473b();	 Catch:{ all -> 0x0034 }
        f16525a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f16525a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.uri.OffersUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.offers.uri.OffersUriIntentBuilder");
    }

    private static OffersUriIntentBuilder m19473b() {
        return new OffersUriIntentBuilder();
    }

    @Inject
    public OffersUriIntentBuilder() {
        a(FBLinks.fp, FragmentChromeActivity.class, ContentFragmentType.OFFERS_WALLET_FRAGMENT.ordinal());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.fq, "{offer_claim_id}"), FragmentChromeActivity.class, ContentFragmentType.OFFERS_DETAIL_PAGE_FRAGMENT.ordinal());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.fr, "{coupon_id}"), FragmentChromeActivity.class, ContentFragmentType.OFFERS_DETAIL_PAGE_FRAGMENT.ordinal());
        a(StringFormatUtil.a(FBLinks.ft, new Object[]{"{offer_id}", "{share_id}", "{notif_trigger}", "{notif_medium}", "{rule}"}), FragmentChromeActivity.class, ContentFragmentType.OFFERS_DETAIL_PAGE_FRAGMENT.ordinal());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.fs, "{offer_id}", "{share_id}", "{redirect}"), FragmentChromeActivity.class, ContentFragmentType.OFFERS_DETAIL_PAGE_FRAGMENT.ordinal());
        a(StringFormatUtil.a(FBLinks.fv, new Object[]{"{offer_view_id}", "{share_id}", "{notif_trigger}", "{notif_medium}", "{rule}"}), FragmentChromeActivity.class, ContentFragmentType.OFFERS_DETAIL_PAGE_FRAGMENT.ordinal());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.fu, "{offer_view_id}", "{share_id}", "{redirect}"), FragmentChromeActivity.class, ContentFragmentType.OFFERS_DETAIL_PAGE_FRAGMENT.ordinal());
        a(StringFormatUtil.a(FBLinks.fx, new Object[]{"{offer_view_id}", "{share_id}", "{site_uri}", "{title}", "{offer_code}", "{notif_trigger}", "{notif_medium}", "{rule}"}), OfferRedirectToWebActivity.class);
        a(StringFormatUtil.a(FBLinks.fw, new Object[]{"{offer_view_id}", "{share_id}", "{site_uri}", "{title}", "{offer_code}"}), OfferRedirectToWebActivity.class);
        a(StringFormatUtil.a(FBLinks.fz, new Object[]{"{offer_id}", "{share_id}", "{site_uri}", "{title}", "{offer_code}", "{notif_trigger}", "{notif_medium}", "{rule}"}), OfferRedirectToWebActivity.class);
        a(StringFormatUtil.a(FBLinks.fy, new Object[]{"{offer_id}", "{share_id}", "{site_uri}", "{title}", "{offer_code}"}), OfferRedirectToWebActivity.class);
        a(StringFormatUtil.a(FBLinks.fA, new Object[]{"{offer_view_id}", "{share_id}", "{site_uri}", "{title}", "{notif_trigger}", "{notif_medium}", "{rule}"}), OfferRedirectToWebActivity.class);
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.fB, "{offer_view_id}", "{share_id}", "{site_uri}", "{title}"), OfferRedirectToWebActivity.class);
        a(StringFormatUtil.a(FBLinks.fD, new Object[]{"{offer_id}", "{share_id}", "{site_uri}", "{title}", "{notif_trigger}", "{notif_medium}", "{rule}"}), OfferRedirectToWebActivity.class);
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.fC, "{offer_id}", "{share_id}", "{site_uri}", "{title}"), OfferRedirectToWebActivity.class);
    }

    protected final boolean m19474a() {
        return true;
    }
}
