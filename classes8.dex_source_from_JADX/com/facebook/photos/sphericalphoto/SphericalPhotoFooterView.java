package com.facebook.photos.sphericalphoto;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.widget.FrameLayout;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.ufi.UFIFooterButtonStyleDefinition.FooterLayoutType;
import com.facebook.feed.ufi.UFIParams;
import com.facebook.feed.ufi.UFIParams.I18nStyleType;
import com.facebook.feed.ufi.UFIStyle;
import com.facebook.feed.ufi.UFIStyleProvider;
import com.facebook.feedback.reactions.api.ReactionsMutationController;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.reactions.ui.FeedbackReactionsController;
import com.facebook.feedback.reactions.ui.PillsBlingBarPartDefinitionHelper;
import com.facebook.feedback.reactions.ui.PillsBlingBarView;
import com.facebook.feedback.reactions.ui.ReactionMutateListener;
import com.facebook.feedback.reactions.ui.logging.ReactionsFooterInteractionLogger;
import com.facebook.feedback.reactions.ui.logging.ReactionsFooterInteractionLoggerProvider;
import com.facebook.feedback.reactions.ui.overlay.ReactionsDockOverlay.DockTheme;
import com.facebook.feedback.ui.FeedbackPopoverLauncher;
import com.facebook.feedplugins.base.footer.ui.Footer.ButtonClickedListener;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;
import com.facebook.feedplugins.base.footer.ui.FooterBinderUtil;
import com.facebook.feedplugins.feedbackreactions.ui.ReactionsFooterBinderUtil;
import com.facebook.feedplugins.feedbackreactions.ui.ReactionsFooterView;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.analytics.PhotosAnalyticsEntities.Actions;
import com.facebook.photos.data.protocol.PhotosMetadataConversionHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.ufiperf.perf.UfiPerfUtil;
import com.facebook.ufiservices.analytics.UFIServicesAnalyticsEventBuilder;
import com.facebook.ufiservices.flyout.FeedbackParams;
import com.facebook.ui.dialogs.DialogContext;
import com.facebook.widget.springbutton.TouchSpring;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Preconditions;
import java.util.EnumMap;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: serp_module */
public class SphericalPhotoFooterView extends FrameLayout {
    @Inject
    PillsBlingBarPartDefinitionHelper f3344a;
    @Inject
    Provider<TouchSpring> f3345b;
    @Inject
    SpringSystem f3346c;
    @Inject
    ComposerLauncher f3347d;
    @Inject
    ReactionsMutationController f3348e;
    @Inject
    ReactionsFooterInteractionLoggerProvider f3349f;
    @Inject
    FeedbackReactionsController f3350g;
    @Inject
    UFIStyleProvider f3351h;
    @Inject
    Lazy<FeedbackPopoverLauncher> f3352i;
    @Inject
    AnalyticsLogger f3353j;
    @Inject
    UFIServicesAnalyticsEventBuilder f3354k;
    @Inject
    UfiPerfUtil f3355l;
    @Inject
    Lazy<NavigationLogger> f3356m;
    @Inject
    Lazy<IFeedIntentBuilder> f3357n;
    private PillsBlingBarView f3358o;
    private ReactionsFooterView f3359p;
    public MediaMetadata f3360q;
    private boolean f3361r = false;
    private ButtonClickedListener f3362s;
    private OnLayoutChangeListener f3363t;
    private ReactionMutateListener f3364u;
    private ReactionsFooterInteractionLogger f3365v;
    private Spring f3366w;
    private View f3367x;
    public FeedProps<GraphQLStory> f3368y;
    @Nullable
    private UFIStyle f3369z;

    /* compiled from: serp_module */
    class C04242 implements OnClickListener {
        final /* synthetic */ SphericalPhotoFooterView f3340a;

        C04242(SphericalPhotoFooterView sphericalPhotoFooterView) {
            this.f3340a = sphericalPhotoFooterView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 747265482);
            this.f3340a.m3308a(false);
            Logger.a(2, EntryType.UI_INPUT_END, 1684906678, a);
        }
    }

    /* compiled from: serp_module */
    class C04253 implements ReactionMutateListener {
        final /* synthetic */ SphericalPhotoFooterView f3341a;

        C04253(SphericalPhotoFooterView sphericalPhotoFooterView) {
            this.f3341a = sphericalPhotoFooterView;
        }

        public final void m3282a(View view, FeedbackReaction feedbackReaction, DisposableFutureCallback disposableFutureCallback) {
            if (feedbackReaction != FeedbackReaction.d) {
                GraphQLFeedback a = PhotosMetadataConversionHelper.a(this.f3341a.f3360q.C());
                FeedProps feedProps = this.f3341a.f3368y;
                if (feedProps == null) {
                    Builder builder = new Builder();
                    builder.D = a;
                    feedProps = FeedProps.c(builder.a());
                }
                FeedbackLoggingParams.Builder builder2 = new FeedbackLoggingParams.Builder();
                builder2.c = "spherical_photos";
                builder2 = builder2;
                builder2.b = "spherical_photos_ufi";
                builder2 = builder2;
                builder2.a = TrackableFeedProps.a(feedProps);
                this.f3341a.f3348e.a(a, feedbackReaction, builder2.a(), disposableFutureCallback);
            }
        }
    }

    /* compiled from: serp_module */
    class C04264 implements ButtonClickedListener {
        final /* synthetic */ SphericalPhotoFooterView f3342a;

        C04264(SphericalPhotoFooterView sphericalPhotoFooterView) {
            this.f3342a = sphericalPhotoFooterView;
        }

        public final void m3283a(View view, FooterButtonId footerButtonId) {
            switch (C04275.f3343a[footerButtonId.ordinal()]) {
                case 1:
                    SphericalPhotoFooterView.m3303e(this.f3342a);
                    return;
                case 2:
                    this.f3342a.m3308a(true);
                    return;
                case 3:
                    this.f3342a.f3347d.a(null, ((IFeedIntentBuilder) this.f3342a.f3357n.get()).a(this.f3342a.f3360q.d(), ComposerSourceType.PHOTOSTAB).setIsFireAndForget(true).a(), SphericalPhotoFooterView.getBaseContext(this.f3342a));
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: serp_module */
    /* synthetic */ class C04275 {
        static final /* synthetic */ int[] f3343a = new int[FooterButtonId.values().length];

        static {
            try {
                f3343a[FooterButtonId.LIKE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3343a[FooterButtonId.COMMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3343a[FooterButtonId.SHARE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static <T extends View> void m3291a(Class<T> cls, T t) {
        m3292a((Object) t, t.getContext());
    }

    private static void m3292a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SphericalPhotoFooterView) obj).m3289a(PillsBlingBarPartDefinitionHelper.a(fbInjector), IdBasedProvider.a(fbInjector, 3736), SpringSystem.b(fbInjector), (ComposerLauncher) ComposerLauncherImpl.a(fbInjector), ReactionsMutationController.a(fbInjector), (ReactionsFooterInteractionLoggerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ReactionsFooterInteractionLoggerProvider.class), FeedbackReactionsController.a(fbInjector), (UFIStyleProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(UFIStyleProvider.class), IdBasedLazy.a(fbInjector, 1794), AnalyticsLoggerMethodAutoProvider.a(fbInjector), UFIServicesAnalyticsEventBuilder.a(fbInjector), UfiPerfUtil.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 137), IdBasedSingletonScopeProvider.b(fbInjector, 2347));
    }

    public SphericalPhotoFooterView(Context context) {
        super(context);
        m3286a();
    }

    public SphericalPhotoFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3286a();
    }

    public SphericalPhotoFooterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3286a();
    }

    private void m3286a() {
        m3291a(SphericalPhotoFooterView.class, (View) this);
        LayoutInflater.from(getContext()).inflate(2130907187, this);
        this.f3359p = (ReactionsFooterView) findViewById(2131567565);
        this.f3358o = (PillsBlingBarView) findViewById(2131567563);
        this.f3367x = findViewById(2131567564);
        m3294b();
    }

    public final void m3307a(MediaMetadata mediaMetadata) {
        boolean z = false;
        Preconditions.checkNotNull(mediaMetadata);
        if (m3298c(mediaMetadata)) {
            if (getVisibility() != 0) {
                setVisibility(0);
            }
            Preconditions.checkNotNull(mediaMetadata.C());
            boolean z2 = this.f3360q == null;
            m3295b(mediaMetadata);
            this.f3361r = false;
            if (this.f3358o != null) {
                GraphQLFeedback a = PhotosMetadataConversionHelper.a(mediaMetadata.C());
                this.f3358o.setVisibility(0);
                PillsBlingBarPartDefinitionHelper.a(a, Integer.valueOf(0), this.f3358o);
                if (m3302e(mediaMetadata) > 0 || m3304f(mediaMetadata) > 0) {
                    z = true;
                }
                this.f3361r = z;
            } else if (!((!z2 && m3299d(this.f3360q) == m3299d(mediaMetadata) && m3304f(this.f3360q) == m3304f(mediaMetadata)) || this.f3358o == null)) {
                this.f3358o.setVisibility(8);
            }
            m3296c();
            this.f3360q = mediaMetadata;
            return;
        }
        setVisibility(4);
    }

    private void m3289a(PillsBlingBarPartDefinitionHelper pillsBlingBarPartDefinitionHelper, Provider<TouchSpring> provider, SpringSystem springSystem, ComposerLauncher composerLauncher, ReactionsMutationController reactionsMutationController, ReactionsFooterInteractionLoggerProvider reactionsFooterInteractionLoggerProvider, FeedbackReactionsController feedbackReactionsController, UFIStyleProvider uFIStyleProvider, Lazy<FeedbackPopoverLauncher> lazy, AnalyticsLogger analyticsLogger, UFIServicesAnalyticsEventBuilder uFIServicesAnalyticsEventBuilder, UfiPerfUtil ufiPerfUtil, Lazy<NavigationLogger> lazy2, Lazy<IFeedIntentBuilder> lazy3) {
        this.f3344a = pillsBlingBarPartDefinitionHelper;
        this.f3345b = provider;
        this.f3346c = springSystem;
        this.f3347d = composerLauncher;
        this.f3348e = reactionsMutationController;
        this.f3349f = reactionsFooterInteractionLoggerProvider;
        this.f3350g = feedbackReactionsController;
        this.f3351h = uFIStyleProvider;
        this.f3352i = lazy;
        this.f3353j = analyticsLogger;
        this.f3354k = uFIServicesAnalyticsEventBuilder;
        this.f3355l = ufiPerfUtil;
        this.f3356m = lazy2;
        this.f3357n = lazy3;
    }

    private void m3295b(MediaMetadata mediaMetadata) {
        boolean g = mediaMetadata.C().g();
        boolean c = mediaMetadata.C().c();
        boolean g2 = m3306g(mediaMetadata);
        EnumMap enumMap = new EnumMap(FooterButtonId.class);
        FooterBinderUtil.a(g, c, g2, enumMap, this.f3345b);
        GraphQLFeedback a = PhotosMetadataConversionHelper.a(mediaMetadata.C());
        FooterBinderUtil.a(this.f3359p, enumMap, a, this.f3362s);
        ReactionsFooterBinderUtil.a(this.f3359p, a, this.f3364u, this.f3366w, m3284a(a), this.f3350g, DockTheme.DARK, this.f3350g.a(a.K()));
        if (this.f3369z != null) {
            final UFIParams a2 = this.f3369z.a(g, c, g2);
            m3287a(a2, this.f3359p.getMeasuredWidth());
            if (this.f3363t != null) {
                this.f3359p.removeOnLayoutChangeListener(this.f3363t);
            }
            this.f3363t = new OnLayoutChangeListener(this) {
                final /* synthetic */ SphericalPhotoFooterView f3339b;

                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    this.f3339b.m3287a(a2, i3 - i);
                }
            };
            this.f3359p.addOnLayoutChangeListener(this.f3363t);
        }
    }

    private void m3287a(UFIParams uFIParams, int i) {
        I18nStyleType a = uFIParams.a(i);
        this.f3359p.setButtonWeights(uFIParams.a(a));
        this.f3359p.setShowIcons(I18nStyleType.hasIcons(a));
    }

    private void m3294b() {
        this.f3362s = m3305f();
        this.f3364u = m3301d();
        OnClickListener c04242 = new C04242(this);
        if (this.f3358o != null) {
            this.f3358o.setOnClickListener(c04242);
        }
        this.f3369z = this.f3351h.a(FooterLayoutType.INLINE);
        Spring a = this.f3346c.a().a(SpringConfig.b(11.0d, 0.0d));
        a.c = true;
        this.f3366w = a;
    }

    private void m3296c() {
        this.f3367x.setVisibility(this.f3361r ? 0 : 8);
    }

    public final void m3308a(boolean z) {
        String str = null;
        if (this.f3360q != null && this.f3360q.C() != null) {
            boolean z2;
            String d;
            String z_;
            GraphQLFeedback a = PhotosMetadataConversionHelper.a(this.f3360q.C());
            FeedProps feedProps = this.f3368y;
            this.f3355l.a();
            ((NavigationLogger) this.f3356m.get()).a("tap_photo_footer_comment");
            ArrayNode a2 = feedProps != null ? TrackableFeedProps.a(feedProps) : null;
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
            builder2.c = "spherical_photos";
            builder2 = builder2;
            builder2.a = a2;
            builder.g = builder2.a();
            builder = builder;
            builder.i = z;
            ((FeedbackPopoverLauncher) this.f3352i.get()).a(getBaseContext(this), builder.a());
            AnalyticsLogger analyticsLogger = this.f3353j;
            if (feedProps == null || !StoryProps.p(feedProps)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (this.f3360q != null) {
                d = this.f3360q.d();
            } else {
                d = null;
            }
            if (a != null) {
                z_ = a.z_();
            } else {
                z_ = null;
            }
            if (a != null) {
                str = a.j();
            }
            analyticsLogger.c(UFIServicesAnalyticsEventBuilder.a(z2, d, z_, str, a2, "spherical_photos"));
        }
    }

    private ReactionMutateListener m3301d() {
        return new C04253(this);
    }

    private void m3288a(FeedbackReaction feedbackReaction) {
        this.f3364u.a(this.f3359p, feedbackReaction, null);
        this.f3359p.setReaction(feedbackReaction);
    }

    public static void m3303e(SphericalPhotoFooterView sphericalPhotoFooterView) {
        Preconditions.checkNotNull(sphericalPhotoFooterView.f3360q);
        FeedbackReaction d = sphericalPhotoFooterView.f3360q.C().w() == 0 ? sphericalPhotoFooterView.f3350g.d() : FeedbackReaction.c;
        sphericalPhotoFooterView.m3288a(d);
        AnalyticsLogger analyticsLogger = sphericalPhotoFooterView.f3353j;
        String str = d == FeedbackReaction.c ? Actions.f2068c : d == sphericalPhotoFooterView.f3350g.d() ? Actions.f2066a : Actions.f2067b;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.e = sphericalPhotoFooterView.f3360q.d();
        HoneyClientEvent honeyClientEvent2 = honeyClientEvent;
        honeyClientEvent2.d = "fbobj";
        analyticsLogger.c(honeyClientEvent2);
    }

    private static boolean m3298c(MediaMetadata mediaMetadata) {
        return ((MediaMetadata) Preconditions.checkNotNull(mediaMetadata)).C() != null;
    }

    private static int m3299d(MediaMetadata mediaMetadata) {
        return mediaMetadata.C().p() != null ? mediaMetadata.C().p().a() : 0;
    }

    private static int m3302e(MediaMetadata mediaMetadata) {
        GraphQLFeedback a = PhotosMetadataConversionHelper.a(mediaMetadata.C());
        return a.E() != null ? a.E().a() : 0;
    }

    private static int m3304f(MediaMetadata mediaMetadata) {
        return GraphQLHelper.f(PhotosMetadataConversionHelper.a(mediaMetadata.C()));
    }

    private static boolean m3306g(MediaMetadata mediaMetadata) {
        return mediaMetadata.q();
    }

    public static Context getBaseContext(SphericalPhotoFooterView sphericalPhotoFooterView) {
        Context context = sphericalPhotoFooterView.getContext();
        return DialogContext.a(context) ? ((DialogContext) context).getBaseContext() : context;
    }

    private ButtonClickedListener m3305f() {
        return new C04264(this);
    }

    private ReactionsFooterInteractionLogger m3284a(GraphQLFeedback graphQLFeedback) {
        if (this.f3365v != null) {
            this.f3365v.g = graphQLFeedback.z_();
            return this.f3365v;
        }
        String c;
        ReactionsFooterInteractionLoggerProvider reactionsFooterInteractionLoggerProvider = this.f3349f;
        if (this.f3368y != null) {
            c = ((GraphQLStory) this.f3368y.a).c();
        } else {
            c = null;
        }
        this.f3365v = reactionsFooterInteractionLoggerProvider.a(c, graphQLFeedback.z_(), "spherical_photos");
        return this.f3365v;
    }

    public void setStoryProps(@Nullable FeedProps<GraphQLStory> feedProps) {
        this.f3368y = feedProps;
    }
}
