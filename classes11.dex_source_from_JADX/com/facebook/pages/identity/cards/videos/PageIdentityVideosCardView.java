package com.facebook.pages.identity.cards.videos;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventBus;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.dialtone.common.DialtoneStateChangedListener;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.model.GraphQLActorCache;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageSecondaryCardView;
import com.facebook.pages.fb4a.videohub.util.VideoModelMutator;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ufiservices.event.UfiEvents.LikeUpdatedUIEvent;
import com.facebook.video.activity.FullscreenVideoPlayerLauncher;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: places_feed_gps */
public class PageIdentityVideosCardView extends CustomLinearLayout implements PageSecondaryCardView {
    public static final CallerContext f3771i = CallerContext.a(PageIdentityVideosCardView.class, "page_identity_video");
    @Inject
    FullscreenVideoPlayerLauncher f3772a;
    @Inject
    public Provider<FbDraweeControllerBuilder> f3773b;
    @Inject
    FbUriIntentHandler f3774c;
    @Inject
    PagesAnalytics f3775d;
    @Inject
    public DialtoneController f3776e;
    @Inject
    public FeedEventBus f3777f;
    @Inject
    Lazy<GraphQLActorCache> f3778g;
    @Inject
    public Lazy<FbErrorReporter> f3779h;
    public TextView f3780j = ((TextView) a(2131565542));
    public FbDraweeView f3781k = ((FbDraweeView) a(2131565544));
    public View f3782l = a(2131565543);
    public View f3783m = a(2131565545);
    public DialtoneStateChangedListener f3784n;
    public VideoDetailFragmentModel f3785o;

    /* compiled from: places_feed_gps */
    public class C05171 implements OnClickListener {
        final /* synthetic */ boolean f3765a;
        final /* synthetic */ long f3766b;
        final /* synthetic */ PageIdentityVideosCardView f3767c;

        public C05171(PageIdentityVideosCardView pageIdentityVideosCardView, boolean z, long j) {
            this.f3767c = pageIdentityVideosCardView;
            this.f3765a = z;
            this.f3766b = j;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1153778416);
            if (this.f3765a) {
                this.f3767c.f3774c.a(this.f3767c.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.au, Long.valueOf(this.f3766b)));
                this.f3767c.f3775d.a(this.f3766b, "VideoCard");
            } else {
                this.f3767c.f3774c.a(this.f3767c.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.aw, Long.valueOf(this.f3766b), "VideoHubFragment"));
            }
            LogUtils.a(-113605840, a);
        }
    }

    /* compiled from: places_feed_gps */
    public class C05182 implements OnClickListener {
        final /* synthetic */ PageIdentityVideosCardView f3768a;

        public C05182(PageIdentityVideosCardView pageIdentityVideosCardView) {
            this.f3768a = pageIdentityVideosCardView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -204036273);
            this.f3768a.f3772a.b(this.f3768a.f3785o, this.f3768a.getContext(), PlayerOrigin.PAGE_VIDEO_CARD);
            Logger.a(2, EntryType.UI_INPUT_END, -722602430, a);
        }
    }

    /* compiled from: places_feed_gps */
    public class C05193 implements DialtoneStateChangedListener {
        final /* synthetic */ PageIdentityVideosCardView f3769a;

        public C05193(PageIdentityVideosCardView pageIdentityVideosCardView) {
            this.f3769a = pageIdentityVideosCardView;
        }

        public final void iw_() {
        }

        public final void b_(boolean z) {
            if (z) {
                this.f3769a.f3783m.setVisibility(8);
            } else {
                this.f3769a.f3783m.setVisibility(0);
            }
        }
    }

    /* compiled from: places_feed_gps */
    public class LikeUpdatedUIEventSubscriber extends com.facebook.ufiservices.event.UfiEvents.LikeUpdatedUIEventSubscriber {
        final /* synthetic */ PageIdentityVideosCardView f3770a;

        public LikeUpdatedUIEventSubscriber(PageIdentityVideosCardView pageIdentityVideosCardView) {
            this.f3770a = pageIdentityVideosCardView;
        }

        public final void m4751b(FbEvent fbEvent) {
            LikeUpdatedUIEvent likeUpdatedUIEvent = (LikeUpdatedUIEvent) fbEvent;
            PageIdentityVideosCardView pageIdentityVideosCardView = this.f3770a;
            pageIdentityVideosCardView.f3785o = VideoModelMutator.m4233a(pageIdentityVideosCardView.f3785o, likeUpdatedUIEvent.a, likeUpdatedUIEvent.b);
        }
    }

    public static void m4753a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageIdentityVideosCardView) obj).m4752a(FullscreenVideoPlayerLauncher.b(fbInjector), IdBasedProvider.a(fbInjector, 1117), FbUriIntentHandler.a(fbInjector), PagesAnalytics.a(fbInjector), (DialtoneController) DialtoneControllerImpl.a(fbInjector), FeedEventBus.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 262), IdBasedSingletonScopeProvider.b(fbInjector, 494));
    }

    protected /* bridge */ /* synthetic */ FbEventBus getEventBus() {
        return this.f3777f;
    }

    public PageIdentityVideosCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = PageIdentityVideosCardView.class;
        m4753a(this, getContext());
        setContentView(2130906040);
        setOrientation(1);
        this.f3781k.setAspectRatio(1.7777778f);
        this.f3781k.setHierarchy(new GenericDraweeHierarchyBuilder(getContext().getResources()).e(ScaleType.g).u());
        a(new LikeUpdatedUIEventSubscriber(this));
    }

    private void m4752a(FullscreenVideoPlayerLauncher fullscreenVideoPlayerLauncher, Provider<FbDraweeControllerBuilder> provider, FbUriIntentHandler fbUriIntentHandler, PagesAnalytics pagesAnalytics, DialtoneController dialtoneController, FeedEventBus feedEventBus, Lazy<GraphQLActorCache> lazy, Lazy<FbErrorReporter> lazy2) {
        this.f3772a = fullscreenVideoPlayerLauncher;
        this.f3773b = provider;
        this.f3774c = fbUriIntentHandler;
        this.f3775d = pagesAnalytics;
        this.f3776e = dialtoneController;
        this.f3777f = feedEventBus;
        this.f3778g = lazy;
        this.f3779h = lazy2;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1288356872);
        super.onAttachedToWindow();
        if (this.f3776e.j()) {
            this.f3783m.setVisibility(8);
            if (this.f3784n == null) {
                this.f3784n = new C05193(this);
            }
            this.f3776e.a(this.f3784n);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2116866084, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1837239646);
        super.onDetachedFromWindow();
        if (this.f3784n != null) {
            this.f3776e.b(this.f3784n);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1571069257, a);
    }
}
