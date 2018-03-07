package com.facebook.offers.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.i18n.BasicDateTimeFormat;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.facebook.ipc.composer.intent.ComposerShareParams.Builder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.offers.graphql.OfferGraphQLConversionHelper;
import com.facebook.offers.logging.OffersEventUtil;
import com.facebook.offers.model.OfferOrCoupon;
import com.facebook.richdocument.view.widget.media.plugins.DefaultAspectRatioVideoPlugin;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.facebook.video.player.plugins.FullscreenVideoControlsPlugin;
import com.facebook.video.player.plugins.InlineSubtitlePlugin;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.google.common.collect.ImmutableList;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: custom_all_friends_res_id */
public final class OfferRenderingUtils {
    private static volatile OfferRenderingUtils f16248k;
    public final Clock f16249a;
    private final SimpleDateFormat f16250b;
    public final FbUriIntentHandler f16251c;
    public final GlyphColorizer f16252d;
    public final SecureContextHelper f16253e;
    private final Lazy<ComposerLauncher> f16254f;
    private final Lazy<IFeedIntentBuilder> f16255g;
    public final AnalyticsLogger f16256h;
    public final OffersEventUtil f16257i;
    public final UriIntentMapper f16258j;

    /* compiled from: custom_all_friends_res_id */
    public class C17562 implements OnClickListener {
        final /* synthetic */ Context f16240a;
        final /* synthetic */ OfferOrCoupon f16241b;
        final /* synthetic */ String f16242c;
        final /* synthetic */ OfferRenderingUtils f16243d;

        public C17562(OfferRenderingUtils offerRenderingUtils, Context context, OfferOrCoupon offerOrCoupon, String str) {
            this.f16243d = offerRenderingUtils;
            this.f16240a = context;
            this.f16241b = offerOrCoupon;
            this.f16242c = str;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1781090554);
            this.f16243d.m19017a(this.f16240a, this.f16241b);
            this.f16243d.f16256h.a(this.f16243d.f16257i.m19447a("opened_link", this.f16241b, this.f16242c));
            Logger.a(2, EntryType.UI_INPUT_END, 282353710, a);
        }
    }

    /* compiled from: custom_all_friends_res_id */
    public class C17573 implements OnClickListener {
        final /* synthetic */ Context f16244a;
        final /* synthetic */ OfferOrCoupon f16245b;
        final /* synthetic */ String f16246c;
        final /* synthetic */ OfferRenderingUtils f16247d;

        public C17573(OfferRenderingUtils offerRenderingUtils, Context context, OfferOrCoupon offerOrCoupon, String str) {
            this.f16247d = offerRenderingUtils;
            this.f16244a = context;
            this.f16245b = offerOrCoupon;
            this.f16246c = str;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2125511916);
            this.f16247d.m19018a(this.f16244a, this.f16245b, this.f16246c);
            Logger.a(2, EntryType.UI_INPUT_END, 430228830, a);
        }
    }

    public static com.facebook.offers.fragment.OfferRenderingUtils m19015a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16248k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.offers.fragment.OfferRenderingUtils.class;
        monitor-enter(r1);
        r0 = f16248k;	 Catch:{ all -> 0x003a }
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
        r0 = m19016b(r0);	 Catch:{ all -> 0x0035 }
        f16248k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16248k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.fragment.OfferRenderingUtils.a(com.facebook.inject.InjectorLike):com.facebook.offers.fragment.OfferRenderingUtils");
    }

    private static OfferRenderingUtils m19016b(InjectorLike injectorLike) {
        return new OfferRenderingUtils(BasicDateTimeFormat.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), FbUriIntentHandler.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), GlyphColorizer.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 849), IdBasedSingletonScopeProvider.b(injectorLike, 2347), AnalyticsLoggerMethodAutoProvider.a(injectorLike), OffersEventUtil.m19445b(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike));
    }

    @Inject
    public OfferRenderingUtils(BasicDateTimeFormat basicDateTimeFormat, Clock clock, FbUriIntentHandler fbUriIntentHandler, SecureContextHelper secureContextHelper, GlyphColorizer glyphColorizer, Lazy<ComposerLauncher> lazy, Lazy<IFeedIntentBuilder> lazy2, AnalyticsLogger analyticsLogger, OffersEventUtil offersEventUtil, UriIntentMapper uriIntentMapper) {
        this.f16250b = basicDateTimeFormat.f();
        this.f16249a = clock;
        this.f16251c = fbUriIntentHandler;
        this.f16252d = glyphColorizer;
        this.f16253e = secureContextHelper;
        this.f16254f = lazy;
        this.f16255g = lazy2;
        this.f16256h = analyticsLogger;
        this.f16257i = offersEventUtil;
        this.f16258j = uriIntentMapper;
    }

    public final boolean m19022a(OfferOrCoupon offerOrCoupon) {
        return (offerOrCoupon.m19459h() * 1000) - this.f16249a.a() < 0;
    }

    public final void m19020a(final View view, OfferOrCoupon offerOrCoupon) {
        final String c = offerOrCoupon.m19456e().m19244c();
        view.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ OfferRenderingUtils f16239c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -2085805483);
                this.f16239c.f16251c.a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.af, c));
                Logger.a(2, EntryType.UI_INPUT_END, -1639844493, a);
            }
        });
    }

    public final void m19017a(Context context, OfferOrCoupon offerOrCoupon) {
        String a;
        String str;
        Object i = offerOrCoupon.m19460i();
        if (offerOrCoupon.m19466q() != null) {
            String b;
            if (offerOrCoupon.m19466q().mo1011z() != null) {
                b = offerOrCoupon.m19466q().mo1011z().m19289b();
            } else {
                b = null;
            }
            a = OffersEventUtil.m19444a(offerOrCoupon.m19466q());
            str = b;
        } else {
            a = null;
            str = null;
        }
        String jQ_ = offerOrCoupon.m19469t() != null ? offerOrCoupon.m19469t().jQ_() : null;
        if (StringUtil.a(i)) {
            String k;
            if (offerOrCoupon.m19471v()) {
                k = offerOrCoupon.m19462k();
            } else {
                k = null;
            }
            if (m19021a(context, jQ_, str, a, k)) {
                return;
            }
        }
        m19019a(context, i, offerOrCoupon.m19461j(), offerOrCoupon.m19457f(), jQ_, str, a);
    }

    public final void m19018a(Context context, OfferOrCoupon offerOrCoupon, @Nullable String str) {
        FeedProps c = FeedProps.c(OfferGraphQLConversionHelper.m19043a(offerOrCoupon.f16522a.mo1001A()));
        ((ComposerLauncher) this.f16254f.get()).a(null, ((IFeedIntentBuilder) this.f16255g.get()).a(c, ComposerSourceType.OFFERS_SPACE).setInitialShareParams(Builder.a(((GraphQLStory) c.a).av()).b()).setIsFireAndForget(true).a(), context);
        this.f16256h.a(this.f16257i.m19447a("share_offer", offerOrCoupon, str));
    }

    public final void m19019a(Context context, String str, String str2, String str3, @Nullable String str4, @Nullable String str5, String str6) {
        Intent a = NativeThirdPartyUriHelper.a(context, Uri.parse(str));
        if (a == null) {
            a = new Intent("android.intent.action.VIEW");
            a.setData(Uri.parse(str));
        }
        if (!StringUtil.a(str4)) {
            a.putExtra("offer_id", str4);
        }
        if (!StringUtil.a(str5)) {
            a.putExtra("offer_view_id", str5);
        }
        if (!StringUtil.a(str6)) {
            a.putExtra("share_id", str6);
        }
        if (!StringUtil.a(str2)) {
            a.putExtra("offers_coupon_code", str2);
        }
        if (!StringUtil.a(str3)) {
            a.putExtra("offers_title", str3);
        }
        this.f16253e.b(a, context);
    }

    public final boolean m19021a(Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        String formatStrLocaleSafe;
        if (str2 != null) {
            formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.fu, str2, str3, "0");
        } else if (str != null) {
            formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.fs, str, str3, "0");
        } else if (StringUtil.a(str4)) {
            return false;
        } else {
            formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.fr, str4);
        }
        Intent a = this.f16258j.a(context, formatStrLocaleSafe);
        a.setFlags(268435456);
        this.f16253e.a(a, context);
        return true;
    }

    public final synchronized List<RichVideoPlayerPlugin> m19023b(Context context) {
        return ImmutableList.of(new VideoPlugin(context), new CoverImagePlugin(context), new LoadingSpinnerPlugin(context), new FullscreenVideoControlsPlugin(context), new DefaultAspectRatioVideoPlugin(context), new InlineSubtitlePlugin(context));
    }
}
