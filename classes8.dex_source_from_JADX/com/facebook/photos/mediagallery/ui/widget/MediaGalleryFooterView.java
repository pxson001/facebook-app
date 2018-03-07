package com.facebook.photos.mediagallery.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.feedcache.memory.FeedUnitCache;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.hardware.FbViewConfigurationCompat;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.metatext.MetaTextBuilder.StyleParamsBuilder;
import com.facebook.composer.metatext.MetaTextBuilder.TagClickListener;
import com.facebook.composer.metatext.MetaTextModel;
import com.facebook.composer.metatext.TagsTextViewContainer;
import com.facebook.composer.metatext.TagsTextViewContainer.SeeMoreClickSpanListener;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.tooltip.Tooltip.OnTooltipClickListener;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.ufi.UFIFooterButtonStyleDefinition.FooterLayoutType;
import com.facebook.feed.ufi.UFIParams.I18nStyleType;
import com.facebook.feed.ufi.UFIStyle;
import com.facebook.feed.ufi.UFIStyleProvider;
import com.facebook.feedback.reactions.api.ReactionsMutationController;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.reactions.ui.FeedbackReactionsController;
import com.facebook.feedback.reactions.ui.FloatingReactionsLauncher;
import com.facebook.feedback.reactions.ui.PillsBlingBarPartDefinitionHelper;
import com.facebook.feedback.reactions.ui.PillsBlingBarView;
import com.facebook.feedback.reactions.ui.ReactionMutateListener;
import com.facebook.feedback.reactions.ui.logging.ReactionsFooterInteractionLogger;
import com.facebook.feedback.reactions.ui.logging.ReactionsFooterInteractionLoggerProvider;
import com.facebook.feedback.reactions.ui.overlay.ReactionsDockOverlay.DockTheme;
import com.facebook.feedback.ui.FeedbackController;
import com.facebook.feedback.ui.FeedbackControllerParams;
import com.facebook.feedback.ui.FeedbackControllerProvider;
import com.facebook.feedback.ui.FeedbackPopoverLauncher;
import com.facebook.feedplugins.base.footer.ui.Footer.ButtonClickedListener;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;
import com.facebook.feedplugins.base.footer.ui.FooterBinderUtil;
import com.facebook.feedplugins.feedbackreactions.ui.ReactionsFooterBinderUtil;
import com.facebook.feedplugins.feedbackreactions.ui.ReactionsFooterView;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.funnellogger.FunnelLogger;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesEntityFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields.Ranges;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.interstitial.InterstitialStartHelper;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.analytics.PhotosAnalyticsEntities.Actions;
import com.facebook.photos.base.analytics.MediaLogger;
import com.facebook.photos.base.analytics.constants.ConsumptionLoggingConstants.UserAction;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.data.protocol.PhotosMetadataConversionHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadataWithoutFeedback.WithTags.Nodes;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.TagInfoQuery.Edges;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.LocationSuggestionModel.LocationTagSuggestionModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataWithoutFeedbackModel.ExplicitPlaceModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataWithoutFeedbackModel.WithTagsModel.NodesModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.PlaceInfoModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel;
import com.facebook.photos.galleryutil.MediaGalleryDeepLinkViewGroup;
import com.facebook.photos.gating.IsMinutiaeSuffixEnabled;
import com.facebook.photos.mediagallery.IsBillingEnabled;
import com.facebook.photos.mediagallery.abtest.ExperimentsForMediaGalleryAbTestModule;
import com.facebook.photos.mediagallery.mutation.MediaMutationGenerator;
import com.facebook.photos.mediagallery.ui.tagging.TaggingStateController;
import com.facebook.photos.mediagallery.ui.tagging.TaggingStateController.C03181;
import com.facebook.photos.mediagallery.ui.tagging.TaggingStateController.TaggingStateListener;
import com.facebook.photos.mediagallery.util.MediaGalleryPrivacyUtil;
import com.facebook.photos.mediagallery.util.SuggestedLocationUtils;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.ufiperf.perf.UfiPerfUtil;
import com.facebook.ufiservices.analytics.UFIServicesAnalyticsEventBuilder;
import com.facebook.ufiservices.flyout.FeedbackParams;
import com.facebook.ufiservices.flyout.ProfileListPopoverLauncher;
import com.facebook.ui.dialogs.DialogContext;
import com.facebook.video.engine.VideoResolution;
import com.facebook.widget.springbutton.TouchSpring;
import com.facebook.widget.text.BetterLinkMovementMethod;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: single_photo_attachment */
public class MediaGalleryFooterView extends FrameLayout {
    private static final String f2655L = MediaGalleryFooterView.class.getSimpleName();
    private static final int f2656M = 2130840122;
    private static final int f2657N = 2130842655;
    private static final int f2658O = 2130839669;
    @Inject
    Lazy<InterstitialStartHelper> f2659A;
    @Inject
    PillsBlingBarPartDefinitionHelper f2660B;
    @Inject
    FeedbackReactionsController f2661C;
    @Inject
    ReactionsMutationController f2662D;
    @Inject
    ReactionsFooterInteractionLoggerProvider f2663E;
    @Inject
    FunnelLoggerImpl f2664F;
    @Inject
    Provider<MediaGalleryActionsGenerator> f2665G;
    @Inject
    UFIStyleProvider f2666H;
    @Inject
    FloatingReactionsLauncher f2667I;
    @Inject
    Lazy<ObjectMapper> f2668J;
    @Inject
    GatekeeperStoreImpl f2669K;
    private FbFragment f2670P;
    private View f2671Q;
    public MediaGalleryDeepLinkViewGroup f2672R;
    private GlyphView f2673S;
    public GlyphView f2674T;
    private GlyphView f2675U;
    private MediaGallerySuggestedLocationView f2676V;
    private View f2677W;
    @Inject
    FeedbackControllerProvider f2678a;
    public MediaLogger aA;
    private TagClickListener aB;
    @Nullable
    private FeedbackController aC;
    private ButtonClickedListener aD;
    private ReactionMutateListener aE;
    private ReactionsFooterInteractionLogger aF;
    private MediaGalleryActionsGenerator aG;
    @Nullable
    private UFIStyle aH;
    private Spring aI;
    private FbTextView aa;
    private TagsTextViewContainer ab;
    private FbTextView ac;
    private LinearLayout ad;
    private FbTextView ae;
    private FbDraweeView af;
    private View ag;
    private View ah;
    private FbTextView ai;
    private PillsBlingBarView aj;
    private ReactionsFooterView ak;
    private MediaGallerySeekBar al;
    private MediaGalleryPlayButton am;
    private MediaGalleryAttributionController an;
    public MediaMetadata ao;
    @Nullable
    public String ap;
    @Nullable
    public String aq;
    @Nullable
    public String ar;
    @Nullable
    public String as;
    @Nullable
    private ArrayNode at;
    private boolean au = false;
    private boolean av = false;
    private boolean aw = false;
    public boolean ax;
    private TaggingStateListener ay;
    public FullscreenGallerySource az;
    @Inject
    Lazy<FeedbackPopoverLauncher> f2679b;
    @Inject
    Lazy<MediaGalleryMenuHelper> f2680c;
    @Inject
    MediaGalleryAttributionControllerProvider f2681d;
    @Inject
    AnalyticsLogger f2682e;
    @Inject
    UFIServicesAnalyticsEventBuilder f2683f;
    @Inject
    UfiPerfUtil f2684g;
    @Inject
    TaggingStateController f2685h;
    @Inject
    FbViewConfigurationCompat f2686i;
    @Inject
    BetterLinkMovementMethod f2687j;
    @IsMinutiaeSuffixEnabled
    @Inject
    Provider<TriState> f2688k;
    @Inject
    @IsBillingEnabled
    Provider<Boolean> f2689l;
    @Inject
    Lazy<FeedUnitCache> f2690m;
    @Inject
    Lazy<IFeedIntentBuilder> f2691n;
    @Inject
    ComposerLauncher f2692o;
    @Inject
    Provider<TouchSpring> f2693p;
    @Inject
    SpringSystem f2694q;
    @Inject
    Lazy<NavigationLogger> f2695r;
    @Inject
    Provider<IFeedIntentBuilder> f2696s;
    @Inject
    Lazy<GraphQLLinkExtractor> f2697t;
    @Inject
    Provider<ProfileListPopoverLauncher> f2698u;
    @Inject
    Lazy<FbErrorReporter> f2699v;
    @Inject
    MediaMutationGenerator f2700w;
    @Inject
    SuggestedLocationUtils f2701x;
    @Inject
    QeAccessor f2702y;
    @Inject
    Lazy<InterstitialManager> f2703z;

    /* compiled from: single_photo_attachment */
    /* synthetic */ class AnonymousClass14 {
        static final /* synthetic */ int[] f2644a = new int[FooterButtonId.values().length];

        static {
            try {
                f2644a[FooterButtonId.LIKE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2644a[FooterButtonId.COMMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2644a[FooterButtonId.SHARE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: single_photo_attachment */
    class C03331 implements OnClickListener {
        final /* synthetic */ MediaGalleryFooterView f2645a;

        C03331(MediaGalleryFooterView mediaGalleryFooterView) {
            this.f2645a = mediaGalleryFooterView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1976283488);
            this.f2645a.f2664F.b(FunnelRegistry.z, "click_blingbar");
            this.f2645a.m2787b(false);
            Logger.a(2, EntryType.UI_INPUT_END, 1587733901, a);
        }
    }

    /* compiled from: single_photo_attachment */
    class C03353 implements Function<Nodes, FacebookProfile> {
        final /* synthetic */ MediaGalleryFooterView f2648a;

        C03353(MediaGalleryFooterView mediaGalleryFooterView) {
            this.f2648a = mediaGalleryFooterView;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            NodesModel nodesModel = (NodesModel) obj;
            return new FacebookProfile(Long.parseLong(nodesModel.c()), nodesModel.d());
        }

        public boolean equals(@Nullable Object obj) {
            return false;
        }
    }

    /* compiled from: single_photo_attachment */
    class C03364 implements Function<Edges, FacebookProfile> {
        final /* synthetic */ MediaGalleryFooterView f2649a;

        C03364(MediaGalleryFooterView mediaGalleryFooterView) {
            this.f2649a = mediaGalleryFooterView;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            EdgesModel edgesModel = (EdgesModel) obj;
            if (edgesModel == null || edgesModel.b() == null || edgesModel.b().c() == null) {
                return null;
            }
            int i;
            switch (edgesModel.b().b().g()) {
                case -776825814:
                    i = 6;
                    break;
                case 2479791:
                    i = 1;
                    break;
                case 105285582:
                    i = 5;
                    break;
                default:
                    i = 0;
                    break;
            }
            return new FacebookProfile(Long.parseLong(edgesModel.b().c()), edgesModel.b().d(), null, i);
        }

        public boolean equals(@Nullable Object obj) {
            return false;
        }
    }

    /* compiled from: single_photo_attachment */
    class C03375 implements ButtonClickedListener {
        final /* synthetic */ MediaGalleryFooterView f2650a;

        C03375(MediaGalleryFooterView mediaGalleryFooterView) {
            this.f2650a = mediaGalleryFooterView;
        }

        public final void m2724a(View view, FooterButtonId footerButtonId) {
            switch (AnonymousClass14.f2644a[footerButtonId.ordinal()]) {
                case 1:
                    this.f2650a.f2664F.b(FunnelRegistry.z, "click_like_button");
                    MediaGalleryFooterView.m2770m(this.f2650a);
                    return;
                case 2:
                    this.f2650a.f2664F.b(FunnelRegistry.z, "click_comment_button");
                    this.f2650a.m2787b(true);
                    return;
                case 3:
                    this.f2650a.f2664F.b(FunnelRegistry.z, "click_share_button");
                    this.f2650a.f2692o.a(null, ((IFeedIntentBuilder) this.f2650a.f2691n.get()).a(this.f2650a.ao.d(), ComposerSourceType.PHOTOSTAB).setIsFireAndForget(true).a(), MediaGalleryFooterView.getBaseContext(this.f2650a));
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: single_photo_attachment */
    class C03386 implements TaggingStateListener {
        final /* synthetic */ MediaGalleryFooterView f2651a;

        C03386(MediaGalleryFooterView mediaGalleryFooterView) {
            this.f2651a = mediaGalleryFooterView;
        }

        public final void mo119a(boolean z) {
            MediaGalleryFooterView.setTaggingMode(this.f2651a, z);
        }
    }

    /* compiled from: single_photo_attachment */
    class C03397 implements TagClickListener {
        final /* synthetic */ MediaGalleryFooterView f2652a;

        C03397(MediaGalleryFooterView mediaGalleryFooterView) {
            this.f2652a = mediaGalleryFooterView;
        }

        public final void m2727a(int i) {
            Object obj = 1;
            ImmutableList i2 = MediaGalleryFooterView.m2764i(this.f2652a, this.f2652a.ao);
            if (i2 != null && i < i2.size()) {
                Bundle bundle = new Bundle();
                ModelBundle.a(bundle, String.valueOf(((FacebookProfile) i2.get(i)).mId), ((FacebookProfile) i2.get(i)).mImageUrl, ((FacebookProfile) i2.get(i)).mDisplayName);
                Object obj2 = ((FacebookProfile) i2.get(i)).a == 5 ? 1 : null;
                if (((FacebookProfile) i2.get(i)).a != 1) {
                    obj = null;
                }
                String str = obj2 != null ? FBLinks.aP : obj != null ? FBLinks.af : FBLinks.aX;
                ((IFeedIntentBuilder) this.f2652a.f2696s.get()).a(this.f2652a.getContext(), StringFormatUtil.formatStrLocaleSafe(str, Long.valueOf(((FacebookProfile) i2.get(i)).mId)), bundle, null);
            }
        }

        public final void m2726a() {
            ImmutableList i = MediaGalleryFooterView.m2764i(this.f2652a, this.f2652a.ao);
            List arrayList = new ArrayList();
            for (int i2 = 1; i2 < i.size(); i2++) {
                arrayList.add(Long.toString(((FacebookProfile) i.get(i2)).mId));
            }
            ((ProfileListPopoverLauncher) this.f2652a.f2698u.get()).a(this.f2652a.getContext(), arrayList);
        }

        public final void m2728b() {
            ExplicitPlaceModel A = this.f2652a.ao.A();
            if (A != null && !StringUtil.a(A.c())) {
                Bundle bundle = new Bundle();
                ModelBundle.b(bundle, A.c(), A.d(), null);
                ((IFeedIntentBuilder) this.f2652a.f2696s.get()).a(this.f2652a.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.af, A.c()), bundle, null);
            }
        }

        public final void m2729c() {
        }

        public final void m2730d() {
        }
    }

    /* compiled from: single_photo_attachment */
    class C03408 implements ReactionMutateListener {
        final /* synthetic */ MediaGalleryFooterView f2653a;

        C03408(MediaGalleryFooterView mediaGalleryFooterView) {
            this.f2653a = mediaGalleryFooterView;
        }

        public final void m2731a(View view, FeedbackReaction feedbackReaction, DisposableFutureCallback disposableFutureCallback) {
            if (feedbackReaction != FeedbackReaction.d) {
                GraphQLFeedback a = PhotosMetadataConversionHelper.a(this.f2653a.ao.C());
                ArrayNode trackingCodes = MediaGalleryFooterView.getTrackingCodes(this.f2653a);
                if (trackingCodes == null) {
                    Builder builder = new Builder();
                    builder.D = a;
                    trackingCodes = TrackableFeedProps.a(FeedProps.c(builder.a()));
                }
                FeedbackLoggingParams.Builder builder2 = new FeedbackLoggingParams.Builder();
                builder2.c = "photo_gallery";
                builder2 = builder2;
                builder2.b = "media_gallery_ufi";
                builder2 = builder2;
                builder2.a = trackingCodes;
                this.f2653a.f2662D.a(a, feedbackReaction, builder2.a(), disposableFutureCallback);
                if (feedbackReaction.e == 11) {
                    this.f2653a.f2667I.a(view);
                }
            }
        }
    }

    /* compiled from: single_photo_attachment */
    class C03419 implements OnClickListener {
        final /* synthetic */ MediaGalleryFooterView f2654a;

        C03419(MediaGalleryFooterView mediaGalleryFooterView) {
            this.f2654a = mediaGalleryFooterView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 963615099);
            this.f2654a.f2664F.b(FunnelRegistry.z, "click_menu_button");
            this.f2654a.m2784a(UserAction.CLICK, Optional.of(view));
            Logger.a(2, EntryType.UI_INPUT_END, 1070812102, a);
        }
    }

    private static <T extends View> void m2742a(Class<T> cls, T t) {
        m2743a((Object) t, t.getContext());
    }

    private static void m2743a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MediaGalleryFooterView) obj).m2738a((FeedbackControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedbackControllerProvider.class), IdBasedLazy.a(injectorLike, 1794), IdBasedLazy.a(injectorLike, 9366), (MediaGalleryAttributionControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MediaGalleryAttributionControllerProvider.class), AnalyticsLoggerMethodAutoProvider.a(injectorLike), UFIServicesAnalyticsEventBuilder.a(injectorLike), UfiPerfUtil.a(injectorLike), TaggingStateController.m2663a(injectorLike), FbViewConfigurationCompat.a(injectorLike), BetterLinkMovementMethod.a(injectorLike), IdBasedProvider.a(injectorLike, 725), IdBasedProvider.a(injectorLike, 4252), IdBasedSingletonScopeProvider.b(injectorLike, 243), IdBasedSingletonScopeProvider.b(injectorLike, 2347), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 3736), SpringSystem.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 137), IdBasedSingletonScopeProvider.a(injectorLike, 2347), IdBasedLazy.a(injectorLike, 2189), IdBasedSingletonScopeProvider.a(injectorLike, 11470), IdBasedSingletonScopeProvider.b(injectorLike, 494), MediaMutationGenerator.a(injectorLike), SuggestedLocationUtils.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2360), IdBasedLazy.a(injectorLike, 2352), PillsBlingBarPartDefinitionHelper.a(injectorLike), FeedbackReactionsController.a(injectorLike), ReactionsMutationController.a(injectorLike), (ReactionsFooterInteractionLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionsFooterInteractionLoggerProvider.class), FunnelLoggerImpl.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 9363), (UFIStyleProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(UFIStyleProvider.class), FloatingReactionsLauncher.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 572), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public MediaGalleryFooterView(Context context) {
        super(context);
        m2749c();
    }

    public MediaGalleryFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2749c();
    }

    public MediaGalleryFooterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2749c();
    }

    private void m2749c() {
        m2742a(MediaGalleryFooterView.class, (View) this);
        LayoutInflater.from(getContext()).inflate(2130905169, this);
        this.f2672R = (MediaGalleryDeepLinkViewGroup) findViewById(2131563685);
        this.f2671Q = findViewById(2131563684);
        this.f2677W = findViewById(2131563691);
        this.ak = (ReactionsFooterView) findViewById(2131563702);
        this.ah = findViewById(2131563696);
        this.aj = (PillsBlingBarView) findViewById(2131563708);
        this.aj.q = true;
        this.ab = (TagsTextViewContainer) findViewById(2131563693);
        this.ab.setMovementMethod(this.f2687j);
        this.ab.setHighlightColor(0);
        TagsTextViewContainer tagsTextViewContainer = this.ab;
        StyleParamsBuilder styleParamsBuilder = new StyleParamsBuilder(getResources());
        styleParamsBuilder.a = new ForegroundColorSpan(getResources().getColor(2131361864));
        styleParamsBuilder = styleParamsBuilder;
        styleParamsBuilder.b = new TextAppearanceSpan(getContext(), 2131625544);
        tagsTextViewContainer.g = styleParamsBuilder.a();
        this.ab.j = m2778q();
        this.ad = (LinearLayout) findViewById(2131563694);
        this.ag = findViewById(2131563700);
        m2752d();
        this.ac = (FbTextView) findViewById(2131563695);
        this.ay = m2763i();
        this.f2685h.m2667a(this.ay);
        this.aB = m2765j();
        if (!this.f2702y.a(ExperimentsForMediaGalleryAbTestModule.e, false)) {
            getFeedbackController();
        }
        setVisibility(4);
        this.aG = (MediaGalleryActionsGenerator) this.f2665G.get();
    }

    private FeedbackController getFeedbackController() {
        if (this.aC == null) {
            this.aC = this.f2678a.a(FeedbackControllerParams.a);
        }
        return this.aC;
    }

    private void m2752d() {
        this.aD = m2762h();
        this.aE = m2768l();
        OnClickListener c03331 = new C03331(this);
        this.ai = (FbTextView) findViewById(2131563701);
        this.ai.setOnClickListener(c03331);
        if (this.aj != null) {
            this.aj.setOnClickListener(c03331);
        }
        this.al = (MediaGallerySeekBar) findViewById(2131563699);
        this.am = (MediaGalleryPlayButton) findViewById(2131563703);
        this.f2675U = (GlyphView) findViewById(2131563689);
        this.f2675U.setOnClickListener(m2772n());
        if (!this.f2686i.a()) {
            this.f2675U.setImageResource(f2658O);
            this.f2675U.setVisibility(0);
        }
        this.f2673S = (GlyphView) findViewById(2131563687);
        this.f2674T = (GlyphView) findViewById(2131563688);
        this.aH = this.f2666H.a(FooterLayoutType.INLINE);
        Spring a = this.f2694q.a().a(SpringConfig.b(11.0d, 0.0d));
        a.c = true;
        this.aI = a;
    }

    private void m2739a(MediaMetadata mediaMetadata) {
        boolean g = mediaMetadata.C().g();
        boolean c = mediaMetadata.C().c();
        boolean k = m2767k(mediaMetadata);
        EnumMap enumMap = new EnumMap(FooterButtonId.class);
        FooterBinderUtil.a(g, c, k, enumMap, this.f2693p);
        GraphQLFeedback a = PhotosMetadataConversionHelper.a(mediaMetadata.C());
        FooterBinderUtil.a(this.ak, enumMap, a, this.aD);
        ReactionsFooterBinderUtil.a(this.ak, a, this.aE, this.aI, m2732a(a), this.f2661C, DockTheme.DARK, this.f2661C.a(a.K()));
        this.ak.setButtonWeights(this.aH.a(g, c, k).a(I18nStyleType.ICONS_EQUAL_WIDTH));
        this.ak.setShowIcons(true);
    }

    public final void m2783a(FbFragment fbFragment, MediaMetadata mediaMetadata) {
        int i = 1;
        int i2 = 0;
        Preconditions.checkNotNull(mediaMetadata);
        if (m2746b(mediaMetadata)) {
            if (getVisibility() != 0) {
                setVisibility(0);
            }
            if (!(this.ao == null || Objects.equal(this.ao.d(), mediaMetadata.d()))) {
                this.av = false;
            }
            Preconditions.checkNotNull(mediaMetadata.C());
            int i3 = this.ao == null ? 1 : 0;
            m2739a(mediaMetadata);
            this.aw = false;
            if (this.aj != null) {
                boolean z;
                this.aj.setVisibility(0);
                this.ai.setVisibility(8);
                PillsBlingBarPartDefinitionHelper.a(PhotosMetadataConversionHelper.a(mediaMetadata.C()), Integer.valueOf(0), this.aj);
                if (m2750d(mediaMetadata) > 0 || m2753e(mediaMetadata) > 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.aw = z;
            } else if (!(i3 == 0 && m2747c(this.ao) == m2747c(mediaMetadata) && m2753e(this.ao) == m2753e(mediaMetadata))) {
                CharSequence o = m2774o(mediaMetadata);
                if (this.aj != null) {
                    this.aj.setVisibility(8);
                }
                this.ai.setVisibility(0);
                this.ai.setText(o);
                this.ai.setEnabled(!o.equals(""));
            }
            if (!(i3 == 0 && this.ao.n() == mediaMetadata.n())) {
                if (mediaMetadata.n()) {
                    this.f2673S.setImageResource(f2656M);
                    this.f2673S.setVisibility(0);
                } else {
                    this.f2673S.setVisibility(8);
                }
            }
            if (!(i3 == 0 && this.ao.p() == mediaMetadata.p() && this.ao.v() == mediaMetadata.v() && this.ao.O() == mediaMetadata.O() && this.ao.A() == mediaMetadata.A())) {
                if (!(mediaMetadata.v() && !mediaMetadata.p() && mediaMetadata.A() == null && mediaMetadata.O() == null)) {
                    i = 0;
                }
                if (mediaMetadata.p() || i != 0) {
                    this.f2674T.setImageResource(f2657N);
                    this.f2674T.setVisibility(0);
                    this.f2674T.setGlyphColor(mediaMetadata.A() != null ? -10972929 : -1);
                } else {
                    this.f2674T.setVisibility(8);
                }
                if (i != 0) {
                    m2779r();
                }
            }
            if (!(i3 == 0 && this.ao.L() == mediaMetadata.L())) {
                m2777p(mediaMetadata);
            }
            MetaTextModel.Builder builder = new MetaTextModel.Builder();
            builder.a = m2759g(mediaMetadata);
            MetaTextModel.Builder builder2 = builder;
            if (((TriState) this.f2688k.get()).asBoolean(false)) {
                CheckinPlaceModel a;
                builder2.b = m2761h(mediaMetadata);
                builder2.c = m2764i(this, mediaMetadata);
                ExplicitPlaceModel A = mediaMetadata.A();
                if (A != null) {
                    CheckinPlaceModel.Builder builder3 = new CheckinPlaceModel.Builder();
                    builder3.f = A.c();
                    builder3 = builder3;
                    builder3.h = A.d();
                    a = builder3.a();
                } else {
                    a = null;
                }
                builder2.d = a;
            }
            MetaTextModel a2 = builder2.a();
            m2776p();
            if (mediaMetadata.J()) {
                this.ab.setVisibility(8);
                this.al.f2819h = mediaMetadata.d();
                this.al.setVisibility(0);
                this.am.f2809b = mediaMetadata.d();
                this.am.setVisibility(0);
                setVideoControlAlpha(1.0f);
            } else {
                this.ab.a(a2, this.aB, this.av);
                this.ab.setMovementMethod(this.f2687j);
                TagsTextViewContainer tagsTextViewContainer = this.ab;
                if (!m2744a(m2757f(mediaMetadata), a2) || this.f2685h.f2565c) {
                    i2 = 8;
                }
                tagsTextViewContainer.setVisibility(i2);
                if (this.av) {
                    m2775o(this);
                }
                this.am.setVisibility(8);
                this.al.setVisibility(8);
            }
            this.f2685h.m2666a(this.ao, mediaMetadata);
            if (this.au) {
                if (this.an == null) {
                    m2760g();
                }
                this.an.m2719a(this.ao, mediaMetadata);
            }
            m2766k();
            this.ao = mediaMetadata;
            this.f2670P = fbFragment;
            return;
        }
        setVisibility(4);
    }

    private ReactionsFooterInteractionLogger m2732a(GraphQLFeedback graphQLFeedback) {
        if (this.aF != null) {
            this.aF.g = graphQLFeedback.z_();
            return this.aF;
        }
        this.aF = this.f2663E.a(getStoryId(), graphQLFeedback.z_(), "photo_gallery");
        return this.aF;
    }

    public final void m2784a(UserAction userAction, Optional<View> optional) {
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(getContext(), 1);
        ((MediaGalleryMenuHelper) this.f2680c.get()).m2857a(this.f2670P, figPopoverMenuWindow.c(), this.ao, this.ap, this.ar, this.aG);
        if (optional.isPresent()) {
            figPopoverMenuWindow.c(true);
            figPopoverMenuWindow.f((View) optional.get());
        } else {
            figPopoverMenuWindow.c(false);
            figPopoverMenuWindow.f(this.ak);
        }
        if (this.aA == null || this.ao == null) {
            String str = f2655L;
            String str2 = "MediaLogger or CurrentMedia is not available when opening overflow menu: %s : source %s";
            Object[] objArr = new Object[2];
            objArr[0] = this.ao != null ? "media exists" : "media is null";
            objArr[1] = this.az != null ? this.az.toString() : "unknown";
            BLog.c(str, str2, objArr);
            return;
        }
        String c;
        MediaLogger mediaLogger = this.aA;
        str2 = this.ao.d();
        if (this.ao.N() != null) {
            c = this.ao.N().c();
        } else {
            c = null;
        }
        mediaLogger.b(str2, c, userAction);
    }

    public void setShowAttribution(boolean z) {
        Preconditions.checkState(this.ao == null);
        this.au = z;
    }

    public void setStoryCacheId(@Nullable String str) {
        this.ap = str;
    }

    public void setStoryId(@Nullable String str) {
        this.aq = str;
    }

    public void setInSponsoredContext(boolean z) {
        this.ax = z;
    }

    public void setTrackingCodes(@Nullable String str) {
        if (str != null) {
            try {
                this.at = (ArrayNode) ((ObjectMapper) this.f2668J.get()).a(str);
            } catch (Throwable e) {
                ((AbstractFbErrorReporter) this.f2699v.get()).a(MediaGalleryFooterView.class.getName(), "error while parsing tracking codes ", e);
            }
        }
    }

    public void setGroupId(@Nullable String str) {
        this.as = str;
    }

    public void setLegacyApiStoryId(@Nullable String str) {
        this.ar = str;
    }

    public void setGallerySource(FullscreenGallerySource fullscreenGallerySource) {
        this.az = fullscreenGallerySource;
    }

    public void setMediaLogger(MediaLogger mediaLogger) {
        this.aA = mediaLogger;
    }

    public final void m2785a(boolean z) {
        TaggingStateController taggingStateController = this.f2685h;
        GlyphView glyphView = this.f2673S;
        Preconditions.checkNotNull(glyphView);
        Preconditions.checkState(taggingStateController.f2563a != TriState.UNSET);
        taggingStateController.f2566d = glyphView;
        if (taggingStateController.f2563a == TriState.YES) {
            taggingStateController.f2566d.setOnClickListener(new C03181(taggingStateController));
            taggingStateController.f2565c = z;
            taggingStateController.f2568f = z;
        } else {
            taggingStateController.f2566d.setVisibility(8);
        }
        setTaggingMode(this, this.f2685h.f2565c);
    }

    public void setLocationButtonOnClickListener(OnClickListener onClickListener) {
        this.f2674T.setOnClickListener(onClickListener);
    }

    public final void m2781a() {
        if (this.aC != null) {
            this.aC.a();
        }
        this.f2685h.m2668b(this.ay);
        this.f2674T.setOnClickListener(null);
        MediaGalleryMenuHelper mediaGalleryMenuHelper = (MediaGalleryMenuHelper) this.f2680c.get();
        mediaGalleryMenuHelper.f2786f.c();
        if (mediaGalleryMenuHelper.f2806z != null) {
            mediaGalleryMenuHelper.f2806z.clear();
        }
        setVisibility(8);
        this.ao = null;
        this.f2670P = null;
    }

    public final boolean m2788b() {
        return this.ao != null && m2746b(this.ao);
    }

    @Nullable
    public MediaGalleryDeepLinkViewGroup getMediaGalleryDeepLinkViewGroup() {
        return this.f2672R;
    }

    @Deprecated
    private FeedProps<GraphQLStory> getStoryProps() {
        if (this.ap == null) {
            return null;
        }
        FeedUnit d = ((FeedUnitCache) this.f2690m.get()).d(this.ap);
        return d instanceof GraphQLStory ? FeedProps.c((GraphQLStory) d) : null;
    }

    private boolean m2755e() {
        if (m2758f()) {
            return this.ax;
        }
        FeedProps storyProps = getStoryProps();
        return storyProps != null && StoryProps.p(storyProps);
    }

    @Nullable
    private String getStoryId() {
        if (m2758f()) {
            return this.aq;
        }
        FeedProps storyProps = getStoryProps();
        return storyProps != null ? ((GraphQLStory) storyProps.a).c() : null;
    }

    @Nullable
    public static ArrayNode getTrackingCodes(MediaGalleryFooterView mediaGalleryFooterView) {
        if (mediaGalleryFooterView.m2758f()) {
            return mediaGalleryFooterView.at;
        }
        FeedProps storyProps = mediaGalleryFooterView.getStoryProps();
        return storyProps != null ? TrackableFeedProps.a(storyProps) : null;
    }

    private boolean m2758f() {
        return this.f2669K.a(718, false);
    }

    private static boolean m2746b(MediaMetadata mediaMetadata) {
        return ((MediaMetadata) Preconditions.checkNotNull(mediaMetadata)).C() != null;
    }

    private static int m2747c(MediaMetadata mediaMetadata) {
        return mediaMetadata.C().p() != null ? mediaMetadata.C().p().a() : 0;
    }

    private static int m2750d(MediaMetadata mediaMetadata) {
        GraphQLFeedback a = PhotosMetadataConversionHelper.a(mediaMetadata.C());
        return a.E() != null ? a.E().a() : 0;
    }

    private static int m2753e(MediaMetadata mediaMetadata) {
        return GraphQLHelper.f(PhotosMetadataConversionHelper.a(mediaMetadata.C()));
    }

    @Nullable
    private static String m2757f(MediaMetadata mediaMetadata) {
        return mediaMetadata.M() != null ? mediaMetadata.M().a() : null;
    }

    @Nullable
    private SpannableStringBuilder m2759g(MediaMetadata mediaMetadata) {
        CharSequence f = m2757f(mediaMetadata);
        if (f == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(f);
        ImmutableList b = mediaMetadata.M().b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            Ranges ranges = (Ranges) b.get(i);
            m2736a(spannableStringBuilder, ranges.a(), ranges.c(), ranges.b() + ranges.c());
        }
        return spannableStringBuilder;
    }

    private void m2736a(SpannableStringBuilder spannableStringBuilder, final DefaultTextWithEntitiesEntityFields defaultTextWithEntitiesEntityFields, int i, int i2) {
        spannableStringBuilder.setSpan(new StyleSpan(1), i, i2, 33);
        spannableStringBuilder.setSpan(new ClickableSpan(this) {
            final /* synthetic */ MediaGalleryFooterView f2647b;

            public void onClick(View view) {
                if (this.f2647b.m2734a(defaultTextWithEntitiesEntityFields) == null) {
                    ((AbstractFbErrorReporter) this.f2647b.f2699v.get()).b(MediaGalleryFooterView.class.getName(), "null url from entity with id " + defaultTextWithEntitiesEntityFields.d());
                } else {
                    ((IFeedIntentBuilder) this.f2647b.f2696s.get()).a(this.f2647b.getContext(), this.f2647b.m2734a(defaultTextWithEntitiesEntityFields));
                }
            }

            public void updateDrawState(TextPaint textPaint) {
            }
        }, i, i2, 33);
    }

    private String m2734a(DefaultTextWithEntitiesEntityFields defaultTextWithEntitiesEntityFields) {
        if (defaultTextWithEntitiesEntityFields.b().g() == -1932766292) {
            if (Strings.isNullOrEmpty(defaultTextWithEntitiesEntityFields.g())) {
                return null;
            }
            return ((GraphQLLinkExtractor) this.f2697t.get()).a(defaultTextWithEntitiesEntityFields.b(), new Object[]{defaultTextWithEntitiesEntityFields.g(), Strings.nullToEmpty(defaultTextWithEntitiesEntityFields.C_()), Strings.nullToEmpty(defaultTextWithEntitiesEntityFields.d())});
        } else if (defaultTextWithEntitiesEntityFields.b().g() != 514783620) {
            this.f2697t.get();
            return GraphQLLinkExtractor.a(defaultTextWithEntitiesEntityFields.b().g(), new Object[]{defaultTextWithEntitiesEntityFields.d()});
        } else if (Strings.isNullOrEmpty(defaultTextWithEntitiesEntityFields.D_())) {
            return null;
        } else {
            return ((GraphQLLinkExtractor) this.f2697t.get()).a(defaultTextWithEntitiesEntityFields.b(), defaultTextWithEntitiesEntityFields.d(), defaultTextWithEntitiesEntityFields.D_());
        }
    }

    @Nullable
    private static MinutiaeObject m2761h(MediaMetadata mediaMetadata) {
        return mediaMetadata.H() != null ? MinutiaeObject.a(PhotosMetadataConversionHelper.a(mediaMetadata.H())) : null;
    }

    @Nullable
    public static ImmutableList m2764i(MediaGalleryFooterView mediaGalleryFooterView, MediaMetadata mediaMetadata) {
        if (!mediaGalleryFooterView.m2773n(mediaMetadata) && !mediaGalleryFooterView.m2771m(mediaMetadata)) {
            return null;
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        Set a = Sets.a();
        if (mediaGalleryFooterView.m2773n(mediaMetadata)) {
            Object a2 = Lists.a(mediaMetadata.V().a(), new C03353(mediaGalleryFooterView));
            builder.b(a2);
            a.addAll(a2);
        }
        if (mediaGalleryFooterView.m2771m(mediaMetadata)) {
            for (FacebookProfile facebookProfile : Lists.a(mediaMetadata.U().a(), new C03364(mediaGalleryFooterView))) {
                if (!(a.contains(facebookProfile) || facebookProfile.a == 6)) {
                    builder.c(facebookProfile);
                }
            }
        }
        return builder.b();
    }

    private boolean m2767k(MediaMetadata mediaMetadata) {
        if (mediaMetadata.J()) {
            return mediaMetadata.u();
        }
        return mediaMetadata.q() && this.az != FullscreenGallerySource.PHOTO_COMMENT;
    }

    private static boolean m2744a(String str, MetaTextModel metaTextModel) {
        if (StringUtil.a(str)) {
            Object obj = (metaTextModel.d == null && metaTextModel.b == null && ((metaTextModel.c == null || metaTextModel.c.isEmpty()) && (metaTextModel.a == null || metaTextModel.a.length() == 0))) ? 1 : null;
            if (obj != null) {
                return false;
            }
        }
        return true;
    }

    private boolean m2769l(MediaMetadata mediaMetadata) {
        return (!((TriState) this.f2688k.get()).asBoolean(false) || mediaMetadata.H() == null || mediaMetadata.H().a().isEmpty()) ? false : true;
    }

    private boolean m2771m(MediaMetadata mediaMetadata) {
        return (!((TriState) this.f2688k.get()).asBoolean(false) || mediaMetadata == null || mediaMetadata.U() == null || mediaMetadata.U().a() == null || mediaMetadata.U().a().isEmpty()) ? false : true;
    }

    private boolean m2773n(MediaMetadata mediaMetadata) {
        return (!((TriState) this.f2688k.get()).asBoolean(false) || mediaMetadata == null || mediaMetadata.V() == null || mediaMetadata.V().a() == null || mediaMetadata.V().a().isEmpty()) ? false : true;
    }

    private CharSequence m2774o(MediaMetadata mediaMetadata) {
        CharSequence charSequence;
        CharSequence charSequence2;
        String str = "  ";
        int c = m2747c(mediaMetadata);
        int e = m2753e(mediaMetadata);
        if (c == 0) {
            charSequence = "";
        } else {
            charSequence = getResources().getQuantityString(2131689631, c, new Object[]{Integer.valueOf(c)});
        }
        if (e == 0) {
            charSequence2 = "";
        } else {
            charSequence2 = getResources().getQuantityString(2131689632, e, new Object[]{Integer.valueOf(e)});
        }
        if (c == 0 && e == 0) {
            return "";
        }
        if (c != 0 && e != 0) {
            return StringFormatUtil.formatStrLocaleSafe("%s%s%s", charSequence, str, charSequence2);
        }
        if (c != 0) {
            return charSequence;
        }
        return charSequence2;
    }

    private void m2760g() {
        int i;
        int i2 = 0;
        this.aa = (FbTextView) findViewById(2131563692);
        this.ae = (FbTextView) findViewById(2131563697);
        this.af = (FbDraweeView) findViewById(2131563698);
        MediaGalleryAttributionControllerProvider mediaGalleryAttributionControllerProvider = this.f2681d;
        FbTextView fbTextView = this.aa;
        FbTextView fbTextView2 = this.ae;
        this.an = new MediaGalleryAttributionController(fbTextView, fbTextView2, this.af, (TimeFormatUtil) DefaultTimeFormatUtil.a(mediaGalleryAttributionControllerProvider), MediaGalleryPrivacyUtil.a(mediaGalleryAttributionControllerProvider), IdBasedSingletonScopeProvider.a(mediaGalleryAttributionControllerProvider, 2347));
        fbTextView = this.aa;
        if (this.f2685h.f2565c) {
            i = 8;
        } else {
            i = 0;
        }
        fbTextView.setVisibility(i);
        LinearLayout linearLayout = this.ad;
        if (this.f2685h.f2565c) {
            i2 = 8;
        }
        linearLayout.setVisibility(i2);
    }

    private ButtonClickedListener m2762h() {
        return new C03375(this);
    }

    private TaggingStateListener m2763i() {
        return new C03386(this);
    }

    private TagClickListener m2765j() {
        return new C03397(this);
    }

    public static void setTaggingMode(MediaGalleryFooterView mediaGalleryFooterView, boolean z) {
        boolean z2;
        int i;
        Object obj = 1;
        int i2 = 8;
        mediaGalleryFooterView.f2673S.setGlyphColor(z ? -10972929 : -1);
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        mediaGalleryFooterView.setUfiElementsEnabled(z2);
        FbTextView fbTextView = mediaGalleryFooterView.ac;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        fbTextView.setVisibility(i);
        LinearLayout linearLayout = mediaGalleryFooterView.ad;
        if (!mediaGalleryFooterView.au || z) {
            i = 8;
        } else {
            i = 0;
        }
        linearLayout.setVisibility(i);
        if (mediaGalleryFooterView.ao == null || !(!Strings.isNullOrEmpty(m2757f(mediaGalleryFooterView.ao)) || mediaGalleryFooterView.m2769l(mediaGalleryFooterView.ao) || mediaGalleryFooterView.m2773n(mediaGalleryFooterView.ao))) {
            obj = null;
        }
        TagsTextViewContainer tagsTextViewContainer = mediaGalleryFooterView.ab;
        if (obj == null || z) {
            i = 8;
        } else {
            i = 0;
        }
        tagsTextViewContainer.setVisibility(i);
        if (mediaGalleryFooterView.aa != null) {
            FbTextView fbTextView2 = mediaGalleryFooterView.aa;
            if (z) {
                i = 8;
            } else {
                i = 0;
            }
            fbTextView2.setVisibility(i);
        }
        View view = mediaGalleryFooterView.ah;
        if (!z) {
            i2 = 0;
        }
        view.setVisibility(i2);
        mediaGalleryFooterView.m2766k();
    }

    private void setUfiElementsEnabled(boolean z) {
        this.ak.setEnabled(z);
        this.ai.setEnabled(z);
        if (this.aj != null) {
            this.aj.setEnabled(z);
        }
    }

    private void m2766k() {
        View view;
        View view2;
        int i;
        if (this.f2685h.f2565c) {
            view = this.ag;
        } else {
            view = this.ag;
            if (this.ab.getVisibility() == 0 || !this.ai.getText().equals("") || this.aw || this.au) {
                view2 = view;
                i = 0;
                view2.setVisibility(i);
            }
        }
        view2 = view;
        i = 8;
        view2.setVisibility(i);
    }

    private ReactionMutateListener m2768l() {
        return new C03408(this);
    }

    private void m2737a(FeedbackReaction feedbackReaction) {
        this.aE.a(this.ak, feedbackReaction, null);
        this.ak.setReaction(feedbackReaction);
    }

    public static void m2770m(MediaGalleryFooterView mediaGalleryFooterView) {
        Preconditions.checkNotNull(mediaGalleryFooterView.ao);
        FeedbackReaction d = mediaGalleryFooterView.ao.C().w() == 0 ? mediaGalleryFooterView.f2661C.d() : FeedbackReaction.c;
        mediaGalleryFooterView.m2737a(d);
        AnalyticsLogger analyticsLogger = mediaGalleryFooterView.f2682e;
        String str = d == FeedbackReaction.c ? Actions.f2068c : d == mediaGalleryFooterView.f2661C.d() ? Actions.f2066a : Actions.f2067b;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.e = mediaGalleryFooterView.ao.d();
        HoneyClientEvent honeyClientEvent2 = honeyClientEvent;
        honeyClientEvent2.d = "fbobj";
        analyticsLogger.c(honeyClientEvent2);
    }

    public final void m2787b(boolean z) {
        String str = null;
        if (this.ao != null && this.ao.C() != null) {
            GraphQLFeedback a = PhotosMetadataConversionHelper.a(this.ao.C());
            this.f2684g.a();
            ((NavigationLogger) this.f2695r.get()).a("tap_photo_footer_comment");
            FeedbackParams.Builder builder = new FeedbackParams.Builder();
            builder.a = a;
            builder = builder;
            builder.d = a.z_();
            builder = builder;
            builder.e = a.j();
            builder = builder;
            builder.p = GraphQLHelper.b(a);
            builder = builder;
            FeedbackLoggingParams.Builder builder2 = new FeedbackLoggingParams.Builder();
            builder2.c = "photo_gallery";
            builder2 = builder2;
            builder2.a = getTrackingCodes(this);
            builder.g = builder2.a();
            builder = builder;
            builder.i = z;
            FeedbackParams.Builder builder3 = builder;
            if (!StringUtil.a(this.as)) {
                builder3.a(Long.valueOf(Long.parseLong(this.as)));
            }
            ((FeedbackPopoverLauncher) this.f2679b.get()).a(getBaseContext(this), builder3.a());
            AnalyticsLogger analyticsLogger = this.f2682e;
            boolean z2 = ((Boolean) this.f2689l.get()).booleanValue() && m2755e();
            String d = this.ao != null ? this.ao.d() : null;
            String z_ = a != null ? a.z_() : null;
            if (a != null) {
                str = a.j();
            }
            analyticsLogger.c(UFIServicesAnalyticsEventBuilder.a(z2, d, z_, str, getTrackingCodes(this), "photo_gallery"));
        }
    }

    private OnClickListener m2772n() {
        return new C03419(this);
    }

    public static Context getBaseContext(MediaGalleryFooterView mediaGalleryFooterView) {
        Context context = mediaGalleryFooterView.getContext();
        return DialogContext.a(context) ? ((DialogContext) context).getBaseContext() : context;
    }

    public static void m2775o(MediaGalleryFooterView mediaGalleryFooterView) {
        mediaGalleryFooterView.av = true;
        Rect rect = new Rect();
        mediaGalleryFooterView.f2671Q.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        if (mediaGalleryFooterView.ad.getVisibility() == 0) {
            mediaGalleryFooterView.ad.getGlobalVisibleRect(rect2);
        } else {
            mediaGalleryFooterView.ah.getGlobalVisibleRect(rect2);
        }
        int min = Math.min(rect2.top - rect.bottom, mediaGalleryFooterView.ab.getLayoutHeight());
        if (min != mediaGalleryFooterView.ab.getHeight()) {
            mediaGalleryFooterView.ab.setMaxHeight(min);
            LayoutParams layoutParams = (LayoutParams) mediaGalleryFooterView.f2677W.getLayoutParams();
            layoutParams.height = -2;
            mediaGalleryFooterView.f2677W.setLayoutParams(layoutParams);
            mediaGalleryFooterView.ab.setBackgroundDrawable(new ColorDrawable(mediaGalleryFooterView.getResources().getColor(2131361847)));
        }
    }

    private void m2776p() {
        this.ab.setMaxLines(4);
        LayoutParams layoutParams = (LayoutParams) this.f2677W.getLayoutParams();
        layoutParams.height = getResources().getDimensionPixelSize(2131431938);
        this.f2677W.setLayoutParams(layoutParams);
    }

    private SeeMoreClickSpanListener m2778q() {
        return new SeeMoreClickSpanListener(this) {
            final /* synthetic */ MediaGalleryFooterView f2638a;

            {
                this.f2638a = r1;
            }

            public final void m2722a() {
                MediaGalleryFooterView.m2775o(this.f2638a);
            }
        };
    }

    private void m2779r() {
        ViewerSuggestLocationInterstitialController viewerSuggestLocationInterstitialController = (ViewerSuggestLocationInterstitialController) ((InterstitialManager) this.f2703z.get()).a("4003", ViewerSuggestLocationInterstitialController.class);
        if (viewerSuggestLocationInterstitialController != null) {
            InterstitialTrigger interstitialTrigger = new InterstitialTrigger(Action.MEDIA_GALLERY_OPENED);
            viewerSuggestLocationInterstitialController.f2838c = this.f2674T;
            viewerSuggestLocationInterstitialController.f2837b = m2780s();
            ((InterstitialStartHelper) this.f2659A.get()).a(getContext(), interstitialTrigger, InterstitialController.class, null);
        }
    }

    private OnTooltipClickListener m2780s() {
        return new OnTooltipClickListener(this) {
            final /* synthetic */ MediaGalleryFooterView f2639a;

            {
                this.f2639a = r1;
            }

            public final void m2723a() {
                this.f2639a.f2674T.callOnClick();
            }
        };
    }

    private void m2777p(MediaMetadata mediaMetadata) {
        final LocationTagSuggestionModel L = mediaMetadata.L();
        if (L != null && this.f2674T.getVisibility() != 8 && mediaMetadata.A() == null) {
            this.f2701x.a(L, mediaMetadata);
            if (this.f2676V == null) {
                this.f2676V = (MediaGallerySuggestedLocationView) ((ViewStub) findViewById(2131563690)).inflate();
                this.f2676V.setAnchor(this.f2674T);
            }
            this.f2676V.setAcceptSuggestedLocationListener(new OnClickListener(this) {
                final /* synthetic */ MediaGalleryFooterView f2641b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1672939819);
                    PlaceInfoModel a2 = L.a();
                    this.f2641b.f2700w.a(this.f2641b.ao.d(), a2.c(), a2.d(), L.b());
                    this.f2641b.f2701x.c(L, this.f2641b.ao);
                    Logger.a(2, EntryType.UI_INPUT_END, 2047991078, a);
                }
            });
            this.f2676V.setRejectSuggestedLocationListener(new OnClickListener(this) {
                final /* synthetic */ MediaGalleryFooterView f2643b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 529466239);
                    this.f2643b.f2700w.a(this.f2643b.ao.d(), L.a().c(), L.b());
                    this.f2643b.f2701x.d(L, this.f2643b.ao);
                    Logger.a(2, EntryType.UI_INPUT_END, -1708284884, a);
                }
            });
            MediaGallerySuggestedLocationView mediaGallerySuggestedLocationView = this.f2676V;
            mediaGallerySuggestedLocationView.f2824b.a(Uri.parse(L.a().bm_().a()), MediaGallerySuggestedLocationView.f2823a);
            mediaGallerySuggestedLocationView.f2825c.setText(Html.fromHtml(mediaGallerySuggestedLocationView.getContext().getString(2131237859, new Object[]{r3.d()})));
            this.f2676V.setVisibility(0);
            this.f2701x.b(L, mediaMetadata);
        } else if (this.f2676V != null) {
            this.f2676V.setVisibility(8);
        }
    }

    private void m2738a(FeedbackControllerProvider feedbackControllerProvider, Lazy<FeedbackPopoverLauncher> lazy, Lazy<MediaGalleryMenuHelper> lazy2, MediaGalleryAttributionControllerProvider mediaGalleryAttributionControllerProvider, AnalyticsLogger analyticsLogger, UFIServicesAnalyticsEventBuilder uFIServicesAnalyticsEventBuilder, UfiPerfUtil ufiPerfUtil, TaggingStateController taggingStateController, FbViewConfigurationCompat fbViewConfigurationCompat, BetterLinkMovementMethod betterLinkMovementMethod, Provider<TriState> provider, Provider<Boolean> provider2, Lazy<FeedUnitCache> lazy3, Lazy<IFeedIntentBuilder> lazy4, ComposerLauncher composerLauncher, Provider<TouchSpring> provider3, SpringSystem springSystem, Lazy<NavigationLogger> lazy5, Provider<IFeedIntentBuilder> provider4, Lazy<GraphQLLinkExtractor> lazy6, Provider<ProfileListPopoverLauncher> provider5, Lazy<FbErrorReporter> lazy7, MediaMutationGenerator mediaMutationGenerator, SuggestedLocationUtils suggestedLocationUtils, QeAccessor qeAccessor, Lazy<InterstitialManager> lazy8, Lazy<InterstitialStartHelper> lazy9, PillsBlingBarPartDefinitionHelper pillsBlingBarPartDefinitionHelper, FeedbackReactionsController feedbackReactionsController, ReactionsMutationController reactionsMutationController, ReactionsFooterInteractionLoggerProvider reactionsFooterInteractionLoggerProvider, FunnelLogger funnelLogger, Provider<MediaGalleryActionsGenerator> provider6, UFIStyleProvider uFIStyleProvider, FloatingReactionsLauncher floatingReactionsLauncher, Lazy<ObjectMapper> lazy10, GatekeeperStore gatekeeperStore) {
        this.f2678a = feedbackControllerProvider;
        this.f2679b = lazy;
        this.f2680c = lazy2;
        this.f2681d = mediaGalleryAttributionControllerProvider;
        this.f2682e = analyticsLogger;
        this.f2683f = uFIServicesAnalyticsEventBuilder;
        this.f2684g = ufiPerfUtil;
        this.f2685h = taggingStateController;
        this.f2686i = fbViewConfigurationCompat;
        this.f2687j = betterLinkMovementMethod;
        this.f2688k = provider;
        this.f2689l = provider2;
        this.f2690m = lazy3;
        this.f2691n = lazy4;
        this.f2692o = composerLauncher;
        this.f2693p = provider3;
        this.f2694q = springSystem;
        this.f2695r = lazy5;
        this.f2696s = provider4;
        this.f2697t = lazy6;
        this.f2698u = provider5;
        this.f2699v = lazy7;
        this.f2700w = mediaMutationGenerator;
        this.f2701x = suggestedLocationUtils;
        this.f2702y = qeAccessor;
        this.f2703z = lazy8;
        this.f2659A = lazy9;
        this.f2660B = pillsBlingBarPartDefinitionHelper;
        this.f2661C = feedbackReactionsController;
        this.f2662D = reactionsMutationController;
        this.f2663E = reactionsFooterInteractionLoggerProvider;
        this.f2664F = funnelLogger;
        this.f2665G = provider6;
        this.f2666H = uFIStyleProvider;
        this.f2667I = floatingReactionsLauncher;
        this.f2668J = lazy10;
        this.f2669K = gatekeeperStore;
    }

    public final void m2782a(int i, int i2, CharSequence charSequence, CharSequence charSequence2) {
        this.al.m2870a(i, i2, charSequence, charSequence2);
    }

    public final void m2789c(boolean z) {
        if (z) {
            this.am.m2863b();
        } else {
            this.am.m2862a();
        }
    }

    public final void m2786a(boolean z, VideoResolution videoResolution) {
        this.al.m2871a(z, videoResolution == VideoResolution.HIGH_DEFINITION);
    }

    public void setVideoControlAlpha(float f) {
        this.am.setAlpha(f);
        this.al.setAlpha(f);
    }
}
