package com.facebook.richdocument.view.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.rows.core.events.Action;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.events.Subscription;
import com.facebook.feedback.events.FeedbackEvents.UpdateLikeFeedbackEvent;
import com.facebook.feedback.ui.FeedbackControllerParams.Builder;
import com.facebook.feedback.ui.FeedbackControllerProvider;
import com.facebook.feedback.ui.FeedbackPopoverLauncher;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLDocumentFeedbackOptions;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.richdocument.RichDocumentInfo;
import com.facebook.richdocument.abtest.ExperimentsForRichDocumentAbtestModule;
import com.facebook.richdocument.fetcher.RichDocumentFeedbackFetcher;
import com.facebook.richdocument.ham.ExtraPaddingAware;
import com.facebook.richdocument.ham.HamDimensions;
import com.facebook.richdocument.ham.HamViewUtils;
import com.facebook.richdocument.model.block.FeedbackAnnotation;
import com.facebook.richdocument.view.RichDocumentUIConfig;
import com.facebook.richdocument.view.block.BlockViewUtil;
import com.facebook.richdocument.view.touch.RichDocumentTouch;
import com.facebook.richdocument.view.util.CompositeRecyclableViewFactory.RecyclableView;
import com.facebook.richdocument.view.util.RichDocumentLayoutDirection;
import com.facebook.ufiservices.event.CommentEvents.AddCommentEvent;
import com.facebook.ufiservices.event.CommentEvents.DeleteCommentEvent;
import com.facebook.ufiservices.event.CommentEvents.UpdateCommentEvent;
import com.facebook.ufiservices.flyout.FeedbackParams;
import com.facebook.ufiservices.flyout.PopoverParams;
import com.facebook.widget.CustomLinearLayout;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Objects;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: offer_claim_to_wallet */
public class UFIView extends CustomLinearLayout implements ExtraPaddingAware, RecyclableView, AnnotationView<FeedbackAnnotation> {
    public static final String f7523n = UFIView.class.getSimpleName();
    private static final Typeface f7524o = Typeface.create("sans-serif", 1);
    private GraphQLDocumentFeedbackOptions f7525A;
    public GraphQLFeedback f7526B;
    private int f7527C;
    private int f7528D;
    private int f7529E;
    public boolean f7530F;
    private final Runnable f7531G;
    @Inject
    Lazy<FeedbackPopoverLauncher> f7532a;
    @Inject
    Lazy<ComposerLauncher> f7533b;
    @Inject
    FeedbackControllerProvider f7534c;
    @Inject
    Lazy<EventsStream> f7535d;
    @Inject
    Lazy<FeedbackMutator> f7536e;
    @Inject
    Lazy<HamViewUtils> f7537f;
    @Inject
    Lazy<HamDimensions> f7538g;
    @Inject
    Lazy<RichDocumentFeedbackFetcher> f7539h;
    @Inject
    AbstractFbErrorReporter f7540i;
    @Inject
    RichDocumentLayoutDirection f7541j;
    @Inject
    RichDocumentInfo f7542k;
    @Inject
    QeAccessor f7543l;
    @Inject
    GatekeeperStoreImpl f7544m;
    public FeedbackAnnotation f7545p;
    public ComposerLaunchParams f7546q;
    private final ArrayList<Subscription> f7547r;
    public PressStateButton f7548s;
    public PressStateButton f7549t;
    public PressStateButton f7550u;
    public RichTextView f7551v;
    public RichTextView f7552w;
    private View f7553x;
    public boolean f7554y;
    private boolean f7555z;

    /* compiled from: offer_claim_to_wallet */
    class C08591 implements Runnable {
        final /* synthetic */ UFIView f7501a;

        C08591(UFIView uFIView) {
            this.f7501a = uFIView;
        }

        public void run() {
            if (this.f7501a.f7548s != null) {
                this.f7501a.f7548s.requestLayout();
            }
            if (this.f7501a.f7549t != null) {
                this.f7501a.f7549t.requestLayout();
            }
            if (this.f7501a.f7550u != null) {
                this.f7501a.f7550u.requestLayout();
            }
            if (this.f7501a.f7551v != null) {
                this.f7501a.f7551v.requestLayout();
            }
            if (this.f7501a.f7552w != null) {
                this.f7501a.f7552w.requestLayout();
            }
            this.f7501a.f7530F = false;
        }
    }

    /* compiled from: offer_claim_to_wallet */
    class C08602 implements OnClickListener {
        final /* synthetic */ UFIView f7502a;

        C08602(UFIView uFIView) {
            this.f7502a = uFIView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1748802128);
            FeedbackControllerProvider feedbackControllerProvider = this.f7502a.f7534c;
            Builder builder = new Builder();
            builder.b = true;
            feedbackControllerProvider.a(builder.a()).a(this.f7502a.f7526B, null);
            Logger.a(2, EntryType.UI_INPUT_END, 593912926, a);
        }
    }

    /* compiled from: offer_claim_to_wallet */
    class C08624 implements OnClickListener {
        final /* synthetic */ UFIView f7505a;

        C08624(UFIView uFIView) {
            this.f7505a = uFIView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1419667216);
            if (this.f7505a.f7546q != null) {
                this.f7505a.f7526B;
            }
            Logger.a(2, EntryType.UI_INPUT_END, 179434119, a);
        }
    }

    /* compiled from: offer_claim_to_wallet */
    class C08657 extends ResultFutureCallback<GraphQLResult<GraphQLFeedback>> {
        final /* synthetic */ UFIView f7510a;

        C08657(UFIView uFIView) {
            this.f7510a = uFIView;
        }

        protected final void m7711a(Object obj) {
            UFIView.setFeedback(this.f7510a, (GraphQLFeedback) ((GraphQLResult) obj).e);
        }

        protected final void m7710a(ServiceException serviceException) {
            AbstractFbErrorReporter abstractFbErrorReporter = this.f7510a.f7540i;
            SoftErrorBuilder a = SoftError.a(UFIView.f7523n, "Fetching UFI failed");
            a.c = serviceException;
            abstractFbErrorReporter.a(a.g());
        }
    }

    /* compiled from: offer_claim_to_wallet */
    class C08668 implements Action<UpdateLikeFeedbackEvent> {
        final /* synthetic */ UFIView f7511a;

        C08668(UFIView uFIView) {
            this.f7511a = uFIView;
        }

        public final void m7712a(Object obj) {
            UpdateLikeFeedbackEvent updateLikeFeedbackEvent = (UpdateLikeFeedbackEvent) obj;
            this.f7511a.f7526B = updateLikeFeedbackEvent.a;
            this.f7511a.f7554y = true;
            this.f7511a.m7756d();
        }
    }

    /* compiled from: offer_claim_to_wallet */
    class C08679 implements Action<AddCommentEvent> {
        final /* synthetic */ UFIView f7512a;

        C08679(UFIView uFIView) {
            this.f7512a = uFIView;
        }

        public final void m7713a(Object obj) {
            AddCommentEvent addCommentEvent = (AddCommentEvent) obj;
            this.f7512a.f7526B = ((FeedbackMutator) this.f7512a.f7536e.get()).c(this.f7512a.f7526B, addCommentEvent.a);
            this.f7512a.f7554y = true;
            this.f7512a.m7756d();
        }
    }

    /* compiled from: offer_claim_to_wallet */
    public class ComposerLaunchParams {
        public int f7518a;
        public Activity f7519b;
        public Fragment f7520c;
        public ComposerConfiguration f7521d;
        public String f7522e;

        /* compiled from: offer_claim_to_wallet */
        public class Builder {
            public String f7513a;
            public ComposerConfiguration f7514b;
            public Activity f7515c;
            public Fragment f7516d;
            public int f7517e;

            public Builder(ComposerConfiguration composerConfiguration) {
                if (composerConfiguration == null) {
                    throw new IllegalArgumentException("A non-null ComposerConfiguration is required");
                }
                this.f7514b = composerConfiguration;
            }

            public final ComposerLaunchParams m7719a() {
                return new ComposerLaunchParams(this);
            }
        }

        public ComposerLaunchParams(Builder builder) {
            this.f7521d = builder.f7514b;
            this.f7522e = builder.f7513a;
            this.f7518a = builder.f7517e;
            this.f7519b = builder.f7515c;
            this.f7520c = builder.f7516d;
        }
    }

    private static <T extends View> void m7728a(Class<T> cls, T t) {
        m7729a((Object) t, t.getContext());
    }

    private static void m7729a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((UFIView) obj).m7726a(IdBasedLazy.a(fbInjector, 1794), IdBasedSingletonScopeProvider.b(fbInjector, 849), (FeedbackControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FeedbackControllerProvider.class), IdBasedSingletonScopeProvider.b(fbInjector, 1492), IdBasedSingletonScopeProvider.b(fbInjector, 996), IdBasedLazy.a(fbInjector, 10330), IdBasedLazy.a(fbInjector, 10329), IdBasedSingletonScopeProvider.b(fbInjector, 3292), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), RichDocumentLayoutDirection.m7366a(fbInjector), RichDocumentInfo.m5102a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), GatekeeperStoreImplMethodAutoProvider.a(fbInjector));
    }

    public UFIView(Context context) {
        this(context, null);
    }

    public UFIView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7547r = new ArrayList();
        this.f7555z = true;
        this.f7525A = GraphQLDocumentFeedbackOptions.NONE;
        this.f7530F = false;
        this.f7531G = new C08591(this);
        m7728a(UFIView.class, (View) this);
        setContentView(2130906883);
        this.f7548s = (PressStateButton) a(2131567044);
        this.f7549t = (PressStateButton) a(2131567045);
        this.f7550u = (PressStateButton) a(2131567046);
        this.f7551v = (RichTextView) a(2131567048);
        this.f7552w = (RichTextView) a(2131567049);
        this.f7553x = a(2131567047);
        this.f7527C = getResources().getColor(2131363472);
        this.f7548s.setOnClickListener(new C08602(this));
        ((HamViewUtils) this.f7537f.get()).m5283c(this.f7548s, 0, 0, 2131558649, 0);
        ArrayNode arrayNode = null;
        if (this.f7542k.f5116d instanceof ArrayNode) {
            arrayNode = (ArrayNode) this.f7542k.f5116d;
        }
        FeedbackLoggingParams.Builder builder = new FeedbackLoggingParams.Builder();
        builder.c = "native_article_story";
        builder = builder;
        builder.a = arrayNode;
        final FeedbackLoggingParams a = builder.a();
        this.f7549t.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ UFIView f7504b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 404231887);
                FeedbackParams.Builder builder = new FeedbackParams.Builder();
                builder.a = this.f7504b.f7526B;
                builder = builder;
                builder.d = this.f7504b.f7526B.z_();
                builder = builder;
                builder.e = this.f7504b.f7526B.j();
                builder = builder;
                builder.i = true;
                builder = builder;
                builder.h = false;
                builder = builder;
                builder.j = false;
                builder = builder;
                builder.g = a;
                FeedbackParams a2 = builder.a();
                PopoverParams.Builder builder2 = new PopoverParams.Builder();
                builder2.a = false;
                ((FeedbackPopoverLauncher) this.f7504b.f7532a.get()).a(this.f7504b.getContext(), a2, builder2.a());
                Logger.a(2, EntryType.UI_INPUT_END, -579660345, a);
            }
        });
        ((HamViewUtils) this.f7537f.get()).m5283c(this.f7550u, 2131558649, 0, 0, 0);
        this.f7550u.setOnClickListener(new C08624(this));
        this.f7551v.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ UFIView f7507b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1931080736);
                FeedbackParams.Builder builder = new FeedbackParams.Builder();
                builder.a = this.f7507b.f7526B;
                builder = builder;
                builder.d = this.f7507b.f7526B.z_();
                builder = builder;
                builder.e = this.f7507b.f7526B.j();
                builder = builder;
                builder.i = false;
                builder = builder;
                builder.h = false;
                builder = builder;
                builder.j = true;
                builder = builder;
                builder.g = a;
                FeedbackParams a2 = builder.a();
                PopoverParams.Builder builder2 = new PopoverParams.Builder();
                builder2.a = false;
                ((FeedbackPopoverLauncher) this.f7507b.f7532a.get()).a(this.f7507b.getContext(), a2, builder2.a());
                Logger.a(2, EntryType.UI_INPUT_END, 1488014516, a);
            }
        });
        this.f7552w.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ UFIView f7509b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 29086826);
                FeedbackParams.Builder builder = new FeedbackParams.Builder();
                builder.a = this.f7509b.f7526B;
                builder = builder;
                builder.d = this.f7509b.f7526B.z_();
                builder = builder;
                builder.e = this.f7509b.f7526B.j();
                builder = builder;
                builder.i = false;
                builder = builder;
                builder.h = false;
                builder = builder;
                builder.j = false;
                builder = builder;
                builder.g = a;
                FeedbackParams a2 = builder.a();
                PopoverParams.Builder builder2 = new PopoverParams.Builder();
                builder2.a = false;
                ((FeedbackPopoverLauncher) this.f7509b.f7532a.get()).a(this.f7509b.getContext(), a2, builder2.a());
                Logger.a(2, EntryType.UI_INPUT_END, -998136839, a);
            }
        });
        int b = ((HamDimensions) this.f7538g.get()).m5276b(2131558723);
        RichDocumentTouch.m7189a(this.f7548s, Integer.valueOf(b), Integer.valueOf(b), Integer.valueOf(3));
        RichDocumentTouch.m7189a(this.f7549t, Integer.valueOf(b), Integer.valueOf(b), Integer.valueOf(3));
        RichDocumentTouch.m7189a(this.f7551v, Integer.valueOf(b), Integer.valueOf(b), Integer.valueOf(3));
        RichDocumentTouch.m7189a(this.f7552w, Integer.valueOf(b), Integer.valueOf(b), Integer.valueOf(3));
        this.f7549t.setAlignImageToTextTop(true);
        setClipChildren(false);
        setClipToPadding(false);
        if (!RichDocumentLayoutDirection.m7368c()) {
            return;
        }
        if (this.f7541j.m7370b()) {
            setLayoutDirection(1);
        } else {
            setLayoutDirection(0);
        }
    }

    private void m7726a(Lazy<FeedbackPopoverLauncher> lazy, Lazy<ComposerLauncher> lazy2, FeedbackControllerProvider feedbackControllerProvider, Lazy<EventsStream> lazy3, Lazy<FeedbackMutator> lazy4, Lazy<HamViewUtils> lazy5, Lazy<HamDimensions> lazy6, Lazy<RichDocumentFeedbackFetcher> lazy7, FbErrorReporter fbErrorReporter, RichDocumentLayoutDirection richDocumentLayoutDirection, RichDocumentInfo richDocumentInfo, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore) {
        this.f7532a = lazy;
        this.f7533b = lazy2;
        this.f7534c = feedbackControllerProvider;
        this.f7535d = lazy3;
        this.f7536e = lazy4;
        this.f7537f = lazy5;
        this.f7538g = lazy6;
        this.f7539h = lazy7;
        this.f7540i = fbErrorReporter;
        this.f7541j = richDocumentLayoutDirection;
        this.f7542k = richDocumentInfo;
        this.f7543l = qeAccessor;
        this.f7544m = gatekeeperStore;
    }

    public void setAnnotation(FeedbackAnnotation feedbackAnnotation) {
        this.f7545p = feedbackAnnotation;
        setFeedbackOptions(feedbackAnnotation.f5619a);
        if (feedbackAnnotation.f5620b != null) {
            m7730a(feedbackAnnotation.f5620b.z_());
        }
        m7756d();
    }

    public void setComposerLaunchParams(ComposerLaunchParams composerLaunchParams) {
        this.f7546q = composerLaunchParams;
    }

    public void setShowShareButton(boolean z) {
        if (this.f7555z != z) {
            this.f7555z = z;
            m7746j();
        }
    }

    private void setFeedbackOptions(GraphQLDocumentFeedbackOptions graphQLDocumentFeedbackOptions) {
        if (graphQLDocumentFeedbackOptions == null) {
            graphQLDocumentFeedbackOptions = GraphQLDocumentFeedbackOptions.NONE;
        }
        this.f7525A = graphQLDocumentFeedbackOptions;
    }

    public static void m7740f(UFIView uFIView) {
        if (uFIView.f7546q.f7519b != null) {
            ((ComposerLauncher) uFIView.f7533b.get()).a(uFIView.f7546q.f7522e, uFIView.f7546q.f7521d, uFIView.f7546q.f7518a, uFIView.f7546q.f7519b);
        } else if (uFIView.f7546q.f7520c != null) {
            ((ComposerLauncher) uFIView.f7533b.get()).a(uFIView.f7546q.f7522e, uFIView.f7546q.f7521d, uFIView.f7546q.f7518a, uFIView.f7546q.f7520c);
        } else {
            ((ComposerLauncher) uFIView.f7533b.get()).a(uFIView.f7546q.f7522e, uFIView.f7546q.f7521d, uFIView.getContext());
        }
    }

    public int getExtraPaddingBottom() {
        return Math.abs(this.f7549t.f7240e.f7393d.getPaint().getFontMetricsInt().bottom) + (getHeight() - (this.f7549t.f7240e.getBottom() + this.f7549t.getTop()));
    }

    private void m7730a(String str) {
        RichDocumentFeedbackFetcher richDocumentFeedbackFetcher = (RichDocumentFeedbackFetcher) this.f7539h.get();
        C08657 c08657 = new C08657(this);
        richDocumentFeedbackFetcher.b.a(str, richDocumentFeedbackFetcher.a.a(RichDocumentFeedbackFetcher.a(str, 604800)), c08657);
    }

    public static void setFeedback(UFIView uFIView, GraphQLFeedback graphQLFeedback) {
        uFIView.f7526B = graphQLFeedback;
        uFIView.m7742g();
        uFIView.f7554y = true;
        uFIView.m7756d();
    }

    public FeedbackAnnotation getAnnotation() {
        return this.f7545p;
    }

    public final View mo438b() {
        return this;
    }

    private void m7742g() {
        if (this.f7526B != null && this.f7525A != null) {
            m7750n();
            this.f7547r.add(((EventsStream) this.f7535d.get()).a(UpdateLikeFeedbackEvent.class, this.f7526B.z_(), new C08668(this)));
            this.f7547r.add(((EventsStream) this.f7535d.get()).a(AddCommentEvent.class, this.f7526B.j(), new C08679(this)));
            this.f7547r.add(((EventsStream) this.f7535d.get()).a(UpdateCommentEvent.class, this.f7526B.j(), new Action<UpdateCommentEvent>(this) {
                final /* synthetic */ UFIView f7499a;

                {
                    this.f7499a = r1;
                }

                public final void m7708a(Object obj) {
                    UpdateCommentEvent updateCommentEvent = (UpdateCommentEvent) obj;
                    this.f7499a.f7526B = ((FeedbackMutator) this.f7499a.f7536e.get()).c(this.f7499a.f7526B, updateCommentEvent.a);
                    this.f7499a.f7554y = true;
                    this.f7499a.m7756d();
                }
            }));
            this.f7547r.add(((EventsStream) this.f7535d.get()).a(DeleteCommentEvent.class, this.f7526B.j(), new Action<DeleteCommentEvent>(this) {
                final /* synthetic */ UFIView f7500a;

                {
                    this.f7500a = r1;
                }

                public final void m7709a(Object obj) {
                    DeleteCommentEvent deleteCommentEvent = (DeleteCommentEvent) obj;
                    this.f7500a.f7526B = ((FeedbackMutator) this.f7500a.f7536e.get()).e(this.f7500a.f7526B, deleteCommentEvent.a);
                    this.f7500a.f7554y = true;
                    this.f7500a.m7756d();
                }
            }));
        }
    }

    protected final void m7756d() {
        if (this.f7525A == null || this.f7526B == null) {
            setVisibility(8);
            return;
        }
        this.f7553x.setVisibility(8);
        m7743h();
        m7745i();
        m7746j();
        m7747k();
        m7748l();
        if (getAlpha() >= RichDocumentUIConfig.f6566s) {
            setVisibility(0);
        }
    }

    public void setIsOverlay(boolean z) {
        this.f7527C = getResources().getColor(z ? 2131363468 : 2131363472);
        this.f7528D = getContext().getResources().getColor(z ? 2131363468 : 2131363473);
        m7756d();
    }

    public final boolean mo439c() {
        return true;
    }

    private void m7743h() {
        if (this.f7525A == GraphQLDocumentFeedbackOptions.LIKES || this.f7525A == GraphQLDocumentFeedbackOptions.LIKES_AND_COMMENTS) {
            this.f7548s.setVisibility(0);
            Drawable drawable = this.f7548s.getDrawable();
            if (this.f7526B.y_()) {
                BlockViewUtil.m6919a(drawable, getContext().getResources().getColor(2131363466));
                this.f7548s.setTextColor(getContext().getResources().getColor(2131363466));
                return;
            }
            BlockViewUtil.m6919a(drawable, this.f7528D);
            this.f7548s.setTextColor(this.f7527C);
            return;
        }
        this.f7548s.setVisibility(8);
    }

    private void m7745i() {
        if (this.f7525A == GraphQLDocumentFeedbackOptions.LIKES_AND_COMMENTS) {
            this.f7549t.setVisibility(0);
            this.f7549t.setTextColor(this.f7527C);
            BlockViewUtil.m6919a(this.f7549t.getDrawable(), this.f7528D);
            return;
        }
        this.f7549t.setVisibility(8);
    }

    private void m7746j() {
        if (m7752p()) {
            this.f7550u.setVisibility(0);
            this.f7550u.setTextColor(this.f7527C);
            BlockViewUtil.m6919a(this.f7550u.getDrawable(), this.f7528D);
            return;
        }
        this.f7550u.setVisibility(8);
    }

    private void m7747k() {
        if (this.f7526B != null && this.f7526B.C() != null) {
            int a = this.f7526B.C().a();
            if (a <= 0 || !(this.f7525A == GraphQLDocumentFeedbackOptions.LIKES || this.f7525A == GraphQLDocumentFeedbackOptions.LIKES_AND_COMMENTS)) {
                this.f7551v.setVisibility(8);
                return;
            }
            this.f7551v.setVisibility(0);
            this.f7551v.f7393d.setText(getResources().getQuantityString(2131689697, a, new Object[]{Integer.valueOf(a)}));
            this.f7551v.f7393d.setTextColor(this.f7527C);
            this.f7553x.setVisibility(0);
        }
    }

    private void m7748l() {
        if (this.f7526B != null && this.f7526B.L() != null) {
            int a = this.f7526B.L().a();
            if (a <= 0 || this.f7525A != GraphQLDocumentFeedbackOptions.LIKES_AND_COMMENTS) {
                this.f7552w.setVisibility(8);
                return;
            }
            this.f7552w.setVisibility(0);
            this.f7552w.f7393d.setText(getResources().getQuantityString(2131689698, a, new Object[]{Integer.valueOf(a)}));
            this.f7552w.f7393d.setTextColor(this.f7527C);
            this.f7553x.setVisibility(0);
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        m7749m();
    }

    private void m7749m() {
        if (this.f7529E < 3 && !this.f7530F) {
            boolean z = false;
            if (Objects.equal(this.f7548s.getTypeface(), f7524o)) {
                z = true;
            }
            if (Objects.equal(this.f7549t.getTypeface(), f7524o)) {
                z = true;
            }
            if (Objects.equal(this.f7551v.f7393d.getTypeface(), f7524o)) {
                z = true;
            }
            if (Objects.equal(this.f7552w.f7393d.getTypeface(), f7524o)) {
                z = true;
            }
            if (z) {
                this.f7529E++;
                removeCallbacks(this.f7531G);
                postDelayed(this.f7531G, 100);
                this.f7530F = true;
            }
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1902345289);
        super.onAttachedToWindow();
        m7742g();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 359527054, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1217858031);
        super.onDetachedFromWindow();
        m7750n();
        this.f7529E = 0;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -747770042, a);
    }

    private void m7750n() {
        int size = this.f7547r.size();
        for (int i = 0; i < size; i++) {
            ((EventsStream) this.f7535d.get()).a((Subscription) this.f7547r.get(i));
        }
        this.f7547r.clear();
    }

    public boolean getIsDirtyAndReset() {
        boolean z = this.f7554y;
        this.f7554y = false;
        return z;
    }

    public final void mo437a() {
        this.f7526B = null;
        this.f7525A = null;
        this.f7529E = 0;
        setVisibility(8);
    }

    private boolean m7751o() {
        return this.f7544m.a(99, false) ? true : this.f7543l.a(ExperimentsForRichDocumentAbtestModule.f, false);
    }

    private boolean m7752p() {
        return this.f7555z && m7751o() && (this.f7525A == GraphQLDocumentFeedbackOptions.LIKES || this.f7525A == GraphQLDocumentFeedbackOptions.LIKES_AND_COMMENTS);
    }
}
