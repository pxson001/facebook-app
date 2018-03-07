package com.facebook.feedplugins.articlechaining.controllers;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.device.ScreenUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.feed.analytics.LongClickTracker;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.hscroll.HScrollFeedItem.Position;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.ui.chaining.HScrollChainingUtil;
import com.facebook.feed.ui.chaining.HScrollChainingViewController;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.feed.ui.itemlistfeedunits.FeedListItemUserActionListener;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.feedplugins.articlechaining.state.ArticleChainingPersistentState;
import com.facebook.feedplugins.articlechaining.state.ArticleChainingPersistentStateKey;
import com.facebook.feedplugins.articlechaining.view.ArticleChainingFeedUnitItemView;
import com.facebook.feedplugins.articlechaining.view.ArticleChainingFeedUnitItemView$ArticleChainingItemContainer;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLArticleChainingFeedUnit;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerShareParams.Builder;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.saved.common.protocol.UpdateSavedStateUtils;
import com.facebook.ui.recyclablepager.PagerViewType;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TPAGE_RESU */
public class ArticleChainingViewController extends HScrollChainingViewController {
    private static final CallerContext f22520e = CallerContext.a(ArticleChainingViewController.class, "native_newsfeed");
    private static final PagerViewType f22521f = new C19581();
    private static ArticleChainingViewController f22522t;
    private static final Object f22523u = new Object();
    private final FeedImageLoader f22524g;
    private final CommonEventsBuilder f22525h;
    public final LongClickTracker f22526i;
    public final AnalyticsLogger f22527j;
    public final PackageManager f22528k;
    public final SecureContextHelper f22529l;
    private final FbDraweeControllerBuilder f22530m;
    private final GatekeeperStoreImpl f22531n;
    private final UpdateSavedStateUtils f22532o;
    private final Toaster f22533p;
    public final ComposerLauncher f22534q;
    public final GlyphColorizer f22535r;
    private final OnClickListener f22536s = new C19592(this);

    /* compiled from: TPAGE_RESU */
    final class C19581 implements PagerViewType {
        C19581() {
        }

        public final Class m25221a() {
            return ArticleChainingFeedUnitItemView.class;
        }

        public final View m25220a(Context context) {
            return new ArticleChainingFeedUnitItemView(context);
        }
    }

    /* compiled from: TPAGE_RESU */
    class C19592 implements OnClickListener {
        final /* synthetic */ ArticleChainingViewController f22512a;

        C19592(ArticleChainingViewController articleChainingViewController) {
            this.f22512a = articleChainingViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 182067598);
            String str = (String) view.getTag(2131558527);
            HoneyClientEvent honeyClientEvent = (HoneyClientEvent) view.getTag(2131558518);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            if (honeyClientEvent != null) {
                intent.putExtra("app_id", honeyClientEvent.e);
                intent.putExtra("unity_type", honeyClientEvent.m("unit_type"));
                intent.putExtra("app_link_type", honeyClientEvent.m("application_link_type"));
                intent.putExtra("is_sponsored", honeyClientEvent.j);
                intent.putExtra("tracking_codes", honeyClientEvent.n("tracking"));
                intent.putExtra("neko_log_flag", true);
                Object m = honeyClientEvent.m("instant_article_id");
                if (!StringUtil.a(m)) {
                    intent.putExtra("extra_instant_articles_id", m);
                    intent.putExtra("extra_instant_articles_referrer", "feed_article_chaining");
                }
            }
            HScrollChainingViewController hScrollChainingViewController = this.f22512a;
            if (hScrollChainingViewController.f22528k.resolveActivity(intent, 65536) != null) {
                hScrollChainingViewController.f22529l.b(intent, hScrollChainingViewController.f21854a);
            }
            if (!TrackingNodes.a(honeyClientEvent)) {
                TrackingNodes.a(honeyClientEvent, view);
            }
            if (!(honeyClientEvent == null || honeyClientEvent.t() == null)) {
                this.f22512a.f22526i.a(honeyClientEvent.t(), str);
            }
            this.f22512a.f22527j.a(honeyClientEvent);
            Logger.a(2, EntryType.UI_INPUT_END, 1876076715, a);
        }
    }

    /* compiled from: TPAGE_RESU */
    class C19625 extends OperationResultFutureCallback {
        final /* synthetic */ ArticleChainingViewController f22518a;

        C19625(ArticleChainingViewController articleChainingViewController) {
            this.f22518a = articleChainingViewController;
        }

        protected final void m25222a(ServiceException serviceException) {
        }
    }

    /* compiled from: TPAGE_RESU */
    class C19636 extends OperationResultFutureCallback {
        final /* synthetic */ ArticleChainingViewController f22519a;

        C19636(ArticleChainingViewController articleChainingViewController) {
            this.f22519a = articleChainingViewController;
        }

        protected final void m25224a(ServiceException serviceException) {
        }
    }

    private static ArticleChainingViewController m25230b(InjectorLike injectorLike) {
        return new ArticleChainingViewController((Context) injectorLike.getInstance(Context.class), FeedImageLoader.a(injectorLike), ScreenUtil.a(injectorLike), CommonEventsBuilder.a(injectorLike), FeedRenderUtils.a(injectorLike), FbDraweeControllerBuilder.a(injectorLike), LongClickTracker.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), PackageManagerMethodAutoProvider.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), UpdateSavedStateUtils.a(injectorLike), Toaster.a(injectorLike), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), GlyphColorizer.a(injectorLike));
    }

    public static void m25228a(ArticleChainingViewController articleChainingViewController, GraphQLStoryAttachment graphQLStoryAttachment, ArticleChainingPersistentState articleChainingPersistentState) {
        if (articleChainingPersistentState.f22539a.booleanValue()) {
            articleChainingPersistentState.m25251a(false);
            articleChainingViewController.m25232j();
            articleChainingViewController.f22532o.f(graphQLStoryAttachment.C(), CurationSurface.NATIVE_FEED_CHAINING_BOX, CurationMechanism.TOGGLE_BUTTON, new C19625(articleChainingViewController));
        } else {
            articleChainingPersistentState.m25251a(true);
            articleChainingViewController.m25231i();
            articleChainingViewController.f22532o.e(graphQLStoryAttachment.C(), CurationSurface.NATIVE_FEED_CHAINING_BOX, CurationMechanism.TOGGLE_BUTTON, new C19636(articleChainingViewController));
        }
        if (articleChainingViewController.f21857d != null) {
            ((HasInvalidate) articleChainingViewController.f21857d).hL_();
        }
    }

    public static ArticleChainingViewController m25226a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ArticleChainingViewController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22523u) {
                ArticleChainingViewController articleChainingViewController;
                if (a2 != null) {
                    articleChainingViewController = (ArticleChainingViewController) a2.a(f22523u);
                } else {
                    articleChainingViewController = f22522t;
                }
                if (articleChainingViewController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25230b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22523u, b3);
                        } else {
                            f22522t = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = articleChainingViewController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private void m25227a(View view, FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        HoneyClientEvent a = this.f22525h.a(Strings.nullToEmpty(graphQLStoryAttachment.C()), false, TrackableFeedProps.a(feedProps), "native_newsfeed", null, GraphQLStoryAttachmentUtil.t(graphQLStoryAttachment));
        String nullToEmpty = Strings.nullToEmpty(graphQLStoryAttachment.C());
        if (view != null && nullToEmpty != null) {
            view.setTag(2131558518, a);
            view.setTag(2131558527, nullToEmpty);
            view.setOnClickListener(this.f22536s);
        }
    }

    public final ArrayNode mo1563a(FeedProps<ScrollableItemListFeedUnit> feedProps) {
        if (((ScrollableItemListFeedUnit) feedProps.a) instanceof GraphQLArticleChainingFeedUnit) {
            return TrackableFeedProps.b(feedProps);
        }
        return null;
    }

    @Inject
    public ArticleChainingViewController(Context context, FeedImageLoader feedImageLoader, ScreenUtil screenUtil, CommonEventsBuilder commonEventsBuilder, FeedRenderUtils feedRenderUtils, FbDraweeControllerBuilder fbDraweeControllerBuilder, LongClickTracker longClickTracker, AnalyticsLogger analyticsLogger, PackageManager packageManager, SecureContextHelper secureContextHelper, GatekeeperStoreImpl gatekeeperStoreImpl, UpdateSavedStateUtils updateSavedStateUtils, Toaster toaster, ComposerLauncher composerLauncher, GlyphColorizer glyphColorizer) {
        super(context, screenUtil, feedRenderUtils);
        this.f22524g = feedImageLoader;
        this.f22525h = commonEventsBuilder;
        this.f22530m = fbDraweeControllerBuilder;
        this.f22526i = longClickTracker;
        this.f22527j = analyticsLogger;
        this.f22528k = packageManager;
        this.f22529l = secureContextHelper;
        this.f22531n = gatekeeperStoreImpl;
        this.f22532o = updateSavedStateUtils;
        this.f22533p = toaster;
        this.f22534q = composerLauncher;
        this.f22535r = glyphColorizer;
    }

    protected final int mo1567d() {
        return this.f21854a.getResources().getDimensionPixelSize(2131428807);
    }

    protected final int mo1568e() {
        Resources resources = this.f21854a.getResources();
        int a = HScrollChainingUtil.m24425a(mo1569f()) + resources.getDimensionPixelSize(2131428809);
        if (this.f22531n.a(10, false)) {
            return a + resources.getDimensionPixelSize(2131428259);
        }
        return a;
    }

    protected final int mo1569f() {
        return Math.min(this.f21854a.getResources().getDimensionPixelSize(2131428797), HScrollChainingUtil.m24426a(this.f21855b, mo1567d(), mo1570g()));
    }

    protected final int mo1570g() {
        return this.f21854a.getResources().getDimensionPixelSize(2131428808);
    }

    protected final Class<? extends ScrollableItemListFeedUnit> mo1566c() {
        return GraphQLArticleChainingFeedUnit.class;
    }

    protected final void mo1565a(FeedProps<ScrollableItemListFeedUnit> feedProps, TextView textView) {
        HScrollChainingUtil.m24427a(this.f21854a.getResources(), (ScrollableItemListFeedUnit) feedProps.a, textView, 2131689531);
    }

    public final void mo1564a(View view, Object obj, Position position, FeedListItemUserActionListener feedListItemUserActionListener, ScrollableItemListFeedUnit scrollableItemListFeedUnit) {
        ArticleChainingFeedUnitItemView$ArticleChainingItemContainer articleChainingFeedUnitItemView$ArticleChainingItemContainer = ((ArticleChainingFeedUnitItemView) view).a;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) obj;
        FeedProps a = FeedProps.a(graphQLStoryAttachment, ImmutableList.of(scrollableItemListFeedUnit));
        articleChainingFeedUnitItemView$ArticleChainingItemContainer.m25254a(GraphQLStoryAttachmentUtil.t(graphQLStoryAttachment) != null);
        LayoutParams layoutParams = articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22541a.getLayoutParams();
        layoutParams.width = mo1569f();
        layoutParams.height = mo1568e();
        articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22541a.setLayoutParams(layoutParams);
        m24441a(view, position);
        HScrollChainingUtil.m24428a(articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22542b, graphQLStoryAttachment, this.f22524g, this.f22530m, f22520e);
        CharSequence A = graphQLStoryAttachment.A();
        if (Strings.isNullOrEmpty(A)) {
            articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22543c.setVisibility(8);
        } else {
            articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22543c.setVisibility(0);
            articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22543c.setText(A);
        }
        m25229a(graphQLStoryAttachment, articleChainingFeedUnitItemView$ArticleChainingItemContainer);
        A = (graphQLStoryAttachment.u() == null || StringUtil.c(graphQLStoryAttachment.u().a())) ? "" : graphQLStoryAttachment.u().a();
        if (StringUtil.a(A)) {
            articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22544d.setVisibility(8);
        } else {
            articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22544d.setVisibility(0);
            articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22544d.setText(A);
        }
        m25227a(articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22541a, a);
        m25227a(articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22543c, a);
        m25227a(articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22544d, a);
    }

    public final PagerViewType mo1562a() {
        return f22521f;
    }

    private void m25229a(final GraphQLStoryAttachment graphQLStoryAttachment, ArticleChainingFeedUnitItemView$ArticleChainingItemContainer articleChainingFeedUnitItemView$ArticleChainingItemContainer) {
        if (this.f22531n.a(10, false) && this.f21857d != null) {
            final ArticleChainingPersistentState articleChainingPersistentState = (ArticleChainingPersistentState) ((HasPersistentState) this.f21857d).a(new ArticleChainingPersistentStateKey(graphQLStoryAttachment));
            if (articleChainingPersistentState.f22539a == null) {
                GraphQLStoryActionLink a = ActionLinkHelper.a(graphQLStoryAttachment, -908457779);
                GraphQLSavedState graphQLSavedState = GraphQLSavedState.NOT_SAVED;
                if (!(a == null || a.J() == null || a.J().jn() == null)) {
                    graphQLSavedState = a.J().jn();
                    if (graphQLSavedState == GraphQLSavedState.NOT_SAVABLE || graphQLSavedState == GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
                        return;
                    }
                }
                boolean z = graphQLSavedState == GraphQLSavedState.SAVED || graphQLSavedState == GraphQLSavedState.ARCHIVED;
                articleChainingPersistentState.m25251a(z);
            }
            if (articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22548h == null) {
                articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22548h = articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22546f.inflate();
            }
            articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22548h.setVisibility(0);
            Drawable a2 = this.f22535r.a(2130843792, -9801344);
            ImageWithTextView imageWithTextView = (ImageWithTextView) articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22545e.c(2131559698);
            imageWithTextView.setText(2131233280);
            imageWithTextView.setSoundEffectsEnabled(false);
            imageWithTextView.setImageDrawable(a2);
            if (articleChainingPersistentState.f22539a.booleanValue()) {
                if (articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22548h != null) {
                    ((GlyphView) articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22545e.c(2131559700)).setGlyphColor(articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22545e.getResources().getColor(2131361917));
                    ((TextView) articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22545e.c(2131559701)).setText(2131232731);
                }
            } else if (articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22548h != null) {
                ((GlyphView) articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22545e.c(2131559700)).setGlyphColor(articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22545e.getResources().getColor(2131361936));
                ((TextView) articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22545e.c(2131559701)).setText(2131232730);
            }
            OnClickListener c19603 = new OnClickListener(this) {
                final /* synthetic */ ArticleChainingViewController f22514b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -972376880);
                    HScrollChainingViewController hScrollChainingViewController = this.f22514b;
                    ComposerConfiguration a2 = ComposerConfigurationFactory.a(ComposerSourceType.ARTICLE_CHAINING, Builder.a(graphQLStoryAttachment.C()).b()).setIsFireAndForget(true).setInitialTargetData(ComposerTargetData.a).a();
                    hScrollChainingViewController.f22534q.a(SafeUUIDGenerator.a().toString(), a2, hScrollChainingViewController.f21854a);
                    Logger.a(2, EntryType.UI_INPUT_END, 1836846002, a);
                }
            };
            if (articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22548h != null) {
                ((ImageWithTextView) articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22545e.c(2131559698)).setOnClickListener(c19603);
            }
            c19603 = new OnClickListener(this) {
                final /* synthetic */ ArticleChainingViewController f22517c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -952997525);
                    ArticleChainingViewController.m25228a(this.f22517c, graphQLStoryAttachment, articleChainingPersistentState);
                    Logger.a(2, EntryType.UI_INPUT_END, 1975872796, a);
                }
            };
            if (articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22548h != null) {
                ((LinearLayout) articleChainingFeedUnitItemView$ArticleChainingItemContainer.f22545e.c(2131559699)).setOnClickListener(c19603);
            }
        }
    }

    private void m25231i() {
        if (m25233k()) {
            this.f22533p.b(new ToastBuilder(2131232728));
        }
    }

    private void m25232j() {
        if (m25233k()) {
            this.f22533p.b(new ToastBuilder(2131232729));
        }
    }

    private boolean m25233k() {
        return this.f22531n.a(1108, false);
    }
}
