package com.facebook.richdocument.view.block.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.market.GooglePlayIntentHelper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverWindow.OnCancelListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLDocumentVideoAutoplayStyle;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.ham.HamDimensions;
import com.facebook.richdocument.ham.HamViewUtils;
import com.facebook.richdocument.logging.NativeAdsPerfInfoLogger;
import com.facebook.richdocument.logging.NativeAdsPerfInfoLogger.NativeAdsPerfEventInfo;
import com.facebook.richdocument.logging.RichDocumentAnalyticsLogger;
import com.facebook.richdocument.model.block.VideoBlockInput;
import com.facebook.richdocument.utils.ActionUtils;
import com.facebook.richdocument.view.block.BlockViewUtil;
import com.facebook.richdocument.view.util.WebViewUtils;
import com.facebook.richdocument.view.widget.DirectionAwarePopoverMenuWindow;
import com.facebook.richdocument.view.widget.NativeAdsVideoPlayAudioPolicy;
import com.facebook.richdocument.view.widget.RichDocumentVideoPlayer;
import com.facebook.richdocument.view.widget.RichTextView;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.richdocument.view.widget.media.plugins.FullscreenVideoCTAPlugin;
import com.facebook.richdocument.view.widget.media.plugins.MediaFramePlugin;
import com.facebook.richdocument.view.widget.media.plugins.RichDocumentSoundWavePlugin;
import com.facebook.richdocument.view.widget.video.VideoPlayingAudioPolicy;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.OnDispatchDrawListener;
import com.facebook.widget.touch.TouchDelegateUtils;
import com.google.common.collect.ImmutableMap.Builder;
import java.net.URISyntaxException;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: page_loader_currently_loading_ids_left */
public class NativeAdBlockViewImpl extends VideoBlockViewImpl {
    private static final String f6728J = NativeAdBlockViewImpl.class.getSimpleName();
    private static final CallerContext f6729K = CallerContext.a(NativeAdBlockViewImpl.class, "unknown");
    private final CustomLinearLayout f6730L;
    private final CustomLinearLayout f6731M;
    private final RichTextView f6732N;
    private final RichTextView f6733O;
    private final RichTextView f6734P;
    private final RichTextView f6735Q;
    private final FbDraweeView f6736R;
    private final MediaFrame f6737S;
    private final View f6738T;
    private final RichTextView f6739U;
    private final RichTextView f6740V;
    public final GlyphView f6741W;
    public String f6742X;
    private long f6743Y;
    public boolean f6744Z;
    @Inject
    HamViewUtils f6745a;
    public Bundle aa;
    private VideoPlayingAudioPolicy ab;
    public String ac;
    public String ad;
    @Inject
    HamDimensions f6746b;
    @Inject
    SecureContextHelper f6747c;
    @Inject
    AbstractFbErrorReporter f6748d;
    @Inject
    GooglePlayIntentHelper f6749j;
    @Inject
    RichDocumentAnalyticsLogger f6750k;
    @Inject
    ActionUtils f6751l;
    @Inject
    Clock f6752m;
    @Inject
    public NativeAdsPerfInfoLogger f6753n;
    @Inject
    Provider<FbDraweeControllerBuilder> f6754o;
    @Inject
    GatekeeperStoreImpl f6755p;
    @Inject
    DefaultAndroidThreadUtil f6756q;
    @Inject
    FbUriIntentHandler f6757r;
    protected boolean f6758s;

    /* compiled from: page_loader_currently_loading_ids_left */
    class C07521 implements OnDispatchDrawListener {
        final /* synthetic */ NativeAdBlockViewImpl f6677a;

        C07521(NativeAdBlockViewImpl nativeAdBlockViewImpl) {
            this.f6677a = nativeAdBlockViewImpl;
        }

        public final boolean m7020a() {
            NativeAdsPerfInfoLogger nativeAdsPerfInfoLogger = this.f6677a.f6753n;
            CharSequence charSequence = this.f6677a.ac;
            if (!StringUtil.c(charSequence) && nativeAdsPerfInfoLogger.f5483a.containsKey(charSequence)) {
                NativeAdsPerfEventInfo nativeAdsPerfEventInfo = (NativeAdsPerfEventInfo) nativeAdsPerfInfoLogger.f5483a.get(charSequence);
                if (nativeAdsPerfEventInfo != null) {
                    nativeAdsPerfEventInfo.f5480h = nativeAdsPerfInfoLogger.f5485c.now();
                }
            }
            return true;
        }
    }

    /* compiled from: page_loader_currently_loading_ids_left */
    class C07532 implements OnClickListener {
        final /* synthetic */ NativeAdBlockViewImpl f6678a;

        C07532(NativeAdBlockViewImpl nativeAdBlockViewImpl) {
            this.f6678a = nativeAdBlockViewImpl;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1342541381);
            AbstractBlockView abstractBlockView = this.f6678a;
            DirectionAwarePopoverMenuWindow directionAwarePopoverMenuWindow = new DirectionAwarePopoverMenuWindow(abstractBlockView.f6639i, abstractBlockView.getContext());
            directionAwarePopoverMenuWindow.c(abstractBlockView.f6741W);
            directionAwarePopoverMenuWindow.a(true);
            directionAwarePopoverMenuWindow.a(Position.BELOW);
            directionAwarePopoverMenuWindow.I = new C07565(abstractBlockView);
            PopoverMenu c = directionAwarePopoverMenuWindow.c();
            if (c != null) {
                c.a(2131233630).setIcon(2130839945).setOnMenuItemClickListener(new C07576(abstractBlockView));
                directionAwarePopoverMenuWindow.d();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 640699377, a);
        }
    }

    /* compiled from: page_loader_currently_loading_ids_left */
    class C07554 extends BaseControllerListener<ImageInfo> {
        final /* synthetic */ NativeAdBlockViewImpl f6682a;

        C07554(NativeAdBlockViewImpl nativeAdBlockViewImpl) {
            this.f6682a = nativeAdBlockViewImpl;
        }

        public final void m7021a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            this.f6682a.m7077v();
        }
    }

    /* compiled from: page_loader_currently_loading_ids_left */
    public class C07565 implements OnCancelListener {
        final /* synthetic */ NativeAdBlockViewImpl f6683a;

        public C07565(NativeAdBlockViewImpl nativeAdBlockViewImpl) {
            this.f6683a = nativeAdBlockViewImpl;
        }

        public final boolean m7022a() {
            return false;
        }
    }

    /* compiled from: page_loader_currently_loading_ids_left */
    public class C07576 implements OnMenuItemClickListener {
        final /* synthetic */ NativeAdBlockViewImpl f6684a;

        public C07576(NativeAdBlockViewImpl nativeAdBlockViewImpl) {
            this.f6684a = nativeAdBlockViewImpl;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f6684a.f6757r.a(this.f6684a.getContext(), this.f6684a.ad);
        }
    }

    public static void m7050a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((NativeAdBlockViewImpl) obj).m7049a(HamViewUtils.m5278a(injectorLike), HamDimensions.m5268a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GooglePlayIntentHelper.b(injectorLike), RichDocumentAnalyticsLogger.m5360a(injectorLike), ActionUtils.m6846b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), NativeAdsPerfInfoLogger.m5356a(injectorLike), IdBasedProvider.a(injectorLike, 1117), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), FbUriIntentHandler.a(injectorLike));
    }

    private NativeAdBlockViewImpl(MediaFrame mediaFrame, View view) {
        super(mediaFrame, view);
        Class cls = NativeAdBlockViewImpl.class;
        m7050a(this, getContext());
        if (this.f6755p.a(688, false)) {
            this.f6693I = 20;
        }
        this.f6730L = (CustomLinearLayout) view.findViewById(2131562996);
        this.f6745a.m5283c(this.f6730L, 2131558653, 0, 2131558654, 0);
        this.f6732N = (RichTextView) this.f6730L.findViewById(2131562998);
        this.f6741W = (GlyphView) this.f6730L.findViewById(2131562999);
        this.f6745a.m5281a(this.f6732N, 0, 0, 0, 2131558648);
        this.f6738T = this.f6730L.findViewById(2131563000);
        this.f6736R = (FbDraweeView) this.f6730L.findViewById(2131563001);
        this.f6737S = (MediaFrame) this.f6730L.findViewById(2131563002);
        this.f6745a.m5281a((CustomLinearLayout) this.f6730L.findViewById(2131563008), 0, 0, 2131558648, 0);
        this.f6734P = (RichTextView) this.f6730L.findViewById(2131563010);
        this.f6733O = (RichTextView) this.f6730L.findViewById(2131563009);
        this.f6745a.m5281a((CustomLinearLayout) this.f6730L.findViewById(2131563007), 0, 2131558649, 0, 0);
        this.f6735Q = (RichTextView) this.f6730L.findViewById(2131563013);
        this.f6739U = (RichTextView) this.f6730L.findViewById(2131563012);
        this.f6740V = (RichTextView) this.f6730L.findViewById(2131563005);
        this.f6731M = (CustomLinearLayout) view.findViewById(2131563006);
        this.f6745a.m5281a(this.f6731M, 2131558648, 0, 2131558648, 2131558649);
    }

    protected final void mo400a(MediaFrame mediaFrame) {
    }

    private void m7051b(MediaFrame mediaFrame) {
        super.mo400a(mediaFrame);
        m6983a(new FullscreenVideoCTAPlugin(mediaFrame));
    }

    protected final VideoPlayingAudioPolicy mo399a(GatekeeperStoreImpl gatekeeperStoreImpl) {
        if (this.ab == null) {
            this.ab = new NativeAdsVideoPlayAudioPolicy(this.f6686B);
        }
        return this.ab;
    }

    public final void m7068k() {
        this.f6732N.setVisibility(0);
        this.f6738T.setVisibility(0);
    }

    public final void m7069l() {
        this.f6738T.setVisibility(8);
        this.f6731M.a(new C07521(this));
        if (this.f6755p.a(876, false)) {
            this.f6741W.setVisibility(0);
            this.f6741W.setOnClickListener(new C07532(this));
            this.f6741W.setTouchDelegate(TouchDelegateUtils.a(this.f6741W, 8));
        }
        this.f6731M.setVisibility(0);
    }

    private void m7049a(HamViewUtils hamViewUtils, HamDimensions hamDimensions, SecureContextHelper secureContextHelper, FbErrorReporter fbErrorReporter, GooglePlayIntentHelper googlePlayIntentHelper, RichDocumentAnalyticsLogger richDocumentAnalyticsLogger, ActionUtils actionUtils, Clock clock, NativeAdsPerfInfoLogger nativeAdsPerfInfoLogger, Provider<FbDraweeControllerBuilder> provider, GatekeeperStore gatekeeperStore, AndroidThreadUtil androidThreadUtil, FbUriIntentHandler fbUriIntentHandler) {
        this.f6745a = hamViewUtils;
        this.f6746b = hamDimensions;
        this.f6747c = secureContextHelper;
        this.f6748d = fbErrorReporter;
        this.f6749j = googlePlayIntentHelper;
        this.f6750k = richDocumentAnalyticsLogger;
        this.f6751l = actionUtils;
        this.f6752m = clock;
        this.f6753n = nativeAdsPerfInfoLogger;
        this.f6754o = provider;
        this.f6755p = gatekeeperStore;
        this.f6756q = androidThreadUtil;
        this.f6757r = fbUriIntentHandler;
    }

    public final void m7058a(String str) {
        if (!StringUtil.a(str)) {
            this.f6733O.setVisibility(0);
            this.f6733O.f7393d.setText(str);
        }
    }

    public final void m7061b(String str, String str2) {
        if (StringUtil.a(str)) {
            RichTextView richTextView = (RichTextView) this.f6730L.findViewById(2131563011);
            richTextView.setVisibility(0);
            richTextView.f7393d.setText(str2);
            this.f6745a.m5283c(richTextView, 0, 2131558648, 0, 0);
            return;
        }
        this.f6734P.setVisibility(0);
        this.f6734P.f7393d.setText(str);
        this.f6745a.m5281a(this.f6734P, 0, 2131558648, 0, 0);
        m7053g(str2);
    }

    private void m7053g(String str) {
        if (!StringUtil.a(str)) {
            this.f6735Q.setVisibility(0);
            this.f6735Q.f7393d.setText(str);
            this.f6745a.m5283c(this.f6735Q, 0, 2131558648, 0, 0);
        }
    }

    public final void m7060b(String str) {
        if (!StringUtil.a(str)) {
            this.f6739U.setVisibility(0);
            this.f6739U.f7393d.setAllCaps(true);
            this.f6739U.f7393d.setText(str);
            this.f6740V.f7393d.setAllCaps(true);
            this.f6740V.f7393d.setText(str);
            this.f6745a.m5281a(this.f6739U, 2131558648, 2131558648, 2131558648, 2131558648);
        }
    }

    public final void m7063c(final String str, final String str2) {
        OnClickListener c07543 = new OnClickListener(this) {
            final /* synthetic */ NativeAdBlockViewImpl f6681c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -679884446);
                NativeAdBlockViewImpl.m7052d(this.f6681c, str, str2);
                Logger.a(2, EntryType.UI_INPUT_END, 71973484, a);
            }
        };
        this.f6736R.setOnClickListener(c07543);
        this.f6739U.setOnClickListener(c07543);
        this.f6740V.setOnClickListener(c07543);
        this.f6731M.setOnClickListener(c07543);
    }

    public final void m7070m() {
        if (this.f6742X != null && this.f6752m.a() - this.f6743Y > 60000) {
            this.f6751l.m6847a(this.f6742X);
            this.f6743Y = this.f6752m.a();
        }
    }

    private void m7054h(String str) {
        this.f6751l.m6847a(str);
    }

    public static void m7052d(NativeAdBlockViewImpl nativeAdBlockViewImpl, String str, String str2) {
        Throwable e;
        String str3;
        if (str == null) {
            nativeAdBlockViewImpl.f6748d.a(SoftError.a(f6728J + "_openURL", "Attempting to open url when the url parameter is null").g());
            return;
        }
        Uri parse = Uri.parse(str);
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            if (parse.getHost().equals("store")) {
                str = parse.getQueryParameter("store_url");
                parseUri = nativeAdBlockViewImpl.f6749j.a(str);
            } else if (parse.getHost().equals("open_link")) {
                str = parse.getQueryParameter("link");
                parseUri = Intent.parseUri(str, 1);
            }
            parseUri.putExtra("com.android.browser.headers", WebViewUtils.m7371a());
            nativeAdBlockViewImpl.f6747c.b(parseUri, nativeAdBlockViewImpl.getContext());
            nativeAdBlockViewImpl.f6750k.m5369b(str, new HashMap());
            nativeAdBlockViewImpl.m7054h(str2);
        } catch (URISyntaxException e2) {
            e = e2;
            str3 = str;
            nativeAdBlockViewImpl.f6748d.a(SoftError.a(f6728J + "_startActivityForUrl", "Error trying to create Intent from url:" + str3).a(e).g());
        } catch (NullPointerException e3) {
            e = e3;
            str3 = str;
            nativeAdBlockViewImpl.f6748d.a(SoftError.a(f6728J + "_startActivityForUrl", "Error trying to create Intent from url:" + str3).a(e).g());
        }
    }

    public final void m7064d(String str) {
        ImageRequest a = ImageRequest.a(str);
        this.f6736R.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f6754o.get()).a(f6729K).b(this.f6736R.getController())).c(a)).a(new C07554(this))).s());
        this.f6736R.setVisibility(0);
        this.f6736R.getLayoutParams().width = m7073q();
        this.f6736R.getLayoutParams().height = m7074r();
    }

    public final void m7056a(VideoBlockInput videoBlockInput) {
        boolean z = false;
        this.f6737S.mo480b().setVisibility(0);
        if (this.f6737S.getMediaView() != null) {
            this.f6737S.getMediaView().getView().setVisibility(0);
        }
        m6982a(BlockViewUtil.m6916a(videoBlockInput.f5654j));
        if (videoBlockInput.f5655k == GraphQLDocumentVideoAutoplayStyle.AUTOPLAY && this.f6721t.a()) {
            z = true;
        }
        this.H = z;
        m7051b(this.f6634a);
        m7042c(videoBlockInput);
        m7040b(videoBlockInput);
        RichDocumentVideoPlayer D = m7029D();
        double d = (double) ((1.0f * ((float) videoBlockInput.f5647c)) / ((float) videoBlockInput.f5648d));
        Builder builder = new Builder();
        builder.b("CoverImageParamsKey", ImageRequest.a(Uri.parse(videoBlockInput.f5649e))).b("VideoAspectRatioKey", Double.valueOf(d));
        D.a(m7035a(videoBlockInput.f5646b, builder));
        D.m7612a(videoBlockInput.f5647c, videoBlockInput.f5648d);
        D.a(new RichDocumentSoundWavePlugin(getContext()));
        if (videoBlockInput.f5655k == GraphQLDocumentVideoAutoplayStyle.AUTOPLAY) {
            D.setOriginalPlayReason(EventTriggerType.BY_AUTOPLAY);
        } else {
            D.setOriginalPlayReason(EventTriggerType.BY_USER);
        }
        this.f6758s = true;
        m7077v();
    }

    public final void mo401e(Bundle bundle) {
        RichDocumentVideoPlayer D = m7029D();
        if (D != null) {
            D.a(true, EventTriggerType.BY_AUTOPLAY);
            super.mo401e(bundle);
        }
    }

    public final boolean m7071n() {
        if (!(iY_().getParent() instanceof RecyclerView) || ((RecyclerView) iY_().getParent()).indexOfChild(iY_()) == -1) {
            return false;
        }
        return true;
    }

    public final void m7072o() {
        if (!this.f6744Z && this.f6758s) {
            m7047h(this.aa);
            for (MediaFramePlugin mediaFramePlugin : this.f6634a.getPlugins()) {
                if (mediaFramePlugin.mo507b()) {
                    mediaFramePlugin.mo509d();
                }
            }
            this.f6744Z = true;
        }
    }

    public final void mo402f(Bundle bundle) {
        if (this.f6758s) {
            super.mo402f(this.aa);
        }
    }

    public final void mo403g(Bundle bundle) {
        if (this.f6758s) {
            super.mo403g(this.aa);
        }
    }

    public final void mo378b(Bundle bundle) {
        super.mo378b(bundle);
        this.aa = bundle;
        m7079x();
        m7070m();
        m7072o();
    }

    public final void mo379c(Bundle bundle) {
        super.mo379c(bundle);
        m7080y();
        if (this.f6744Z) {
            for (MediaFramePlugin mediaFramePlugin : this.f6634a.getPlugins()) {
                if (mediaFramePlugin.mo507b()) {
                    mediaFramePlugin.mo510e();
                }
            }
            this.f6744Z = false;
        }
    }

    public final int m7073q() {
        return getContext().getResources().getDisplayMetrics().widthPixels - (this.f6746b.m5276b(2131558653) + this.f6746b.m5276b(2131558654));
    }

    public final int m7074r() {
        return (int) (((float) m7073q()) / 1.91f);
    }

    public static VideoBlockViewImpl m7048a(View view) {
        return new NativeAdBlockViewImpl((MediaFrame) view.findViewById(2131563002), view);
    }

    public final void m7075t() {
        NativeAdsPerfInfoLogger nativeAdsPerfInfoLogger = this.f6753n;
        CharSequence charSequence = this.ac;
        if (!StringUtil.c(charSequence) && nativeAdsPerfInfoLogger.f5483a.containsKey(charSequence)) {
            NativeAdsPerfEventInfo nativeAdsPerfEventInfo = (NativeAdsPerfEventInfo) nativeAdsPerfInfoLogger.f5483a.get(charSequence);
            if (nativeAdsPerfEventInfo.m5352a()) {
                nativeAdsPerfEventInfo.f5476d = nativeAdsPerfInfoLogger.f5485c.now();
            }
        }
    }

    public final void m7076u() {
        NativeAdsPerfInfoLogger nativeAdsPerfInfoLogger = this.f6753n;
        CharSequence charSequence = this.ac;
        if (!StringUtil.c(charSequence) && nativeAdsPerfInfoLogger.f5483a.containsKey(charSequence)) {
            NativeAdsPerfEventInfo nativeAdsPerfEventInfo = (NativeAdsPerfEventInfo) nativeAdsPerfInfoLogger.f5483a.get(charSequence);
            if (nativeAdsPerfEventInfo.m5352a()) {
                nativeAdsPerfEventInfo.f5477e = nativeAdsPerfInfoLogger.f5485c.now();
            }
        }
    }

    public final void m7077v() {
        NativeAdsPerfInfoLogger nativeAdsPerfInfoLogger = this.f6753n;
        CharSequence charSequence = this.ac;
        if (!StringUtil.c(charSequence) && nativeAdsPerfInfoLogger.f5483a.containsKey(charSequence)) {
            NativeAdsPerfEventInfo nativeAdsPerfEventInfo = (NativeAdsPerfEventInfo) nativeAdsPerfInfoLogger.f5483a.get(charSequence);
            if (nativeAdsPerfEventInfo.m5352a()) {
                nativeAdsPerfEventInfo.f5475c = nativeAdsPerfInfoLogger.f5485c.now();
            }
        }
    }

    public final void m7078w() {
        NativeAdsPerfInfoLogger nativeAdsPerfInfoLogger = this.f6753n;
        CharSequence charSequence = this.ac;
        if (!StringUtil.c(charSequence) && nativeAdsPerfInfoLogger.f5483a.containsKey(charSequence)) {
            NativeAdsPerfEventInfo nativeAdsPerfEventInfo = (NativeAdsPerfEventInfo) nativeAdsPerfInfoLogger.f5483a.get(charSequence);
            if (nativeAdsPerfEventInfo.m5352a()) {
                nativeAdsPerfEventInfo.f5474b = nativeAdsPerfInfoLogger.f5485c.now();
            }
        }
    }

    public final void m7079x() {
        NativeAdsPerfInfoLogger nativeAdsPerfInfoLogger = this.f6753n;
        CharSequence charSequence = this.ac;
        if (!StringUtil.c(charSequence) && nativeAdsPerfInfoLogger.f5483a.containsKey(charSequence)) {
            NativeAdsPerfEventInfo nativeAdsPerfEventInfo = (NativeAdsPerfEventInfo) nativeAdsPerfInfoLogger.f5483a.get(charSequence);
            if (nativeAdsPerfEventInfo.m5353b() && ((float) nativeAdsPerfEventInfo.f5478f) <= 0.0f) {
                nativeAdsPerfEventInfo.f5478f = nativeAdsPerfInfoLogger.f5485c.now();
            }
        }
    }

    public final void m7080y() {
        NativeAdsPerfInfoLogger nativeAdsPerfInfoLogger = this.f6753n;
        CharSequence charSequence = this.ac;
        if (!StringUtil.c(charSequence) && nativeAdsPerfInfoLogger.f5483a.containsKey(charSequence)) {
            NativeAdsPerfEventInfo nativeAdsPerfEventInfo = (NativeAdsPerfEventInfo) nativeAdsPerfInfoLogger.f5483a.get(charSequence);
            if (nativeAdsPerfEventInfo.m5353b() && ((float) nativeAdsPerfEventInfo.f5479g) <= 0.0f) {
                nativeAdsPerfEventInfo.f5479g = nativeAdsPerfInfoLogger.f5485c.now();
            }
        }
    }

    public final void m7081z() {
        NativeAdsPerfInfoLogger nativeAdsPerfInfoLogger = this.f6753n;
        CharSequence charSequence = this.ac;
        if (!StringUtil.c(charSequence) && nativeAdsPerfInfoLogger.f5483a.containsKey(charSequence)) {
            ((NativeAdsPerfEventInfo) nativeAdsPerfInfoLogger.f5483a.get(charSequence)).f5473a = true;
        }
    }
}
