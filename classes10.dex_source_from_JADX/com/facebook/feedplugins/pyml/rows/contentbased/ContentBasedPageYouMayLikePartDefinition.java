package com.facebook.feedplugins.pyml.rows.contentbased;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.TriState;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.PagesYouMayLikeEvents.BlacklistPageYouMayLikeItemEvent;
import com.facebook.feed.widget.FeedbackCustomPressStateButton;
import com.facebook.feedplugins.pyml.rows.PageLiker;
import com.facebook.feedplugins.pyml.rows.contentbased.ui.ContentBasedPageYouMayLikeView;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.SuggestedPageUnitItem;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Optional;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: android.permission.INTERNET */
public class ContentBasedPageYouMayLikePartDefinition extends BaseSinglePartDefinition<PagesYouMayLikeItemViewModelProps, Void, AnyEnvironment, ContentBasedPageYouMayLikeView> {
    private static ContentBasedPageYouMayLikePartDefinition f19830i;
    private static final Object f19831j = new Object();
    public final PageLiker f19832a;
    private final TasksManager<GraphQLPage> f19833b;
    public final DefaultFeedUnitRenderer f19834c;
    public final FeedEventBus f19835d;
    public final NewsFeedAnalyticsEventBuilder f19836e;
    public final AnalyticsLogger f19837f;
    private final ClickListenerPartDefinition f19838g;
    public final GatekeeperStoreImpl f19839h;

    /* compiled from: android.permission.INTERNET */
    public class BlacklistIconClickListener implements OnClickListener {
        public final /* synthetic */ ContentBasedPageYouMayLikePartDefinition f19822a;
        public final GraphQLPagesYouMayLikeFeedUnit f19823b;
        private final SuggestedPageUnitItem f19824c;

        public BlacklistIconClickListener(ContentBasedPageYouMayLikePartDefinition contentBasedPageYouMayLikePartDefinition, GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit, SuggestedPageUnitItem suggestedPageUnitItem) {
            this.f19822a = contentBasedPageYouMayLikePartDefinition;
            this.f19823b = graphQLPagesYouMayLikeFeedUnit;
            this.f19824c = suggestedPageUnitItem;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1327698551);
            if (this.f19824c.m() != null) {
                HoneyAnalyticsEvent honeyAnalyticsEvent;
                String ae = this.f19824c.m().ae();
                if (this.f19823b != null) {
                    this.f19822a.f19835d.a(new BlacklistPageYouMayLikeItemEvent(this.f19823b.g(), ae));
                }
                NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = this.f19822a.f19836e;
                ArrayNode a2 = GraphQLHelper.a(this.f19824c, this.f19823b);
                if (NewsFeedAnalyticsEventBuilder.B(a2)) {
                    honeyAnalyticsEvent = null;
                } else {
                    HoneyClientEvent a3 = new HoneyClientEvent("pyml_xout").a("tracking", a2);
                    a3.c = "native_newsfeed";
                    honeyAnalyticsEvent = a3;
                }
                this.f19822a.f19837f.c(honeyAnalyticsEvent);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1800264705, a);
        }
    }

    /* compiled from: android.permission.INTERNET */
    class LikeButtonClickListener implements OnClickListener {
        final /* synthetic */ ContentBasedPageYouMayLikePartDefinition f19825a;
        private final GraphQLPagesYouMayLikeFeedUnit f19826b;
        private final SuggestedPageUnitItem f19827c;

        public LikeButtonClickListener(ContentBasedPageYouMayLikePartDefinition contentBasedPageYouMayLikePartDefinition, GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit, SuggestedPageUnitItem suggestedPageUnitItem) {
            this.f19825a = contentBasedPageYouMayLikePartDefinition;
            this.f19826b = graphQLPagesYouMayLikeFeedUnit;
            this.f19827c = suggestedPageUnitItem;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -855386295);
            Class cls = ContentBasedPageYouMayLikeView.class;
            ViewParent parent = view.getParent();
            while (parent != null && !cls.isInstance(parent)) {
                parent = parent.getParent();
            }
            Optional.fromNullable((View) parent).get();
            this.f19825a.f19832a.a(this.f19827c.m(), GraphQLHelper.a(this.f19827c, this.f19826b), this.f19827c.A(), this.f19825a.f19839h.a(830, false) ? "feed_pyml" : null);
            LogUtils.a(1799536062, a);
        }
    }

    /* compiled from: android.permission.INTERNET */
    class ViewPageClickListener implements OnClickListener {
        final /* synthetic */ ContentBasedPageYouMayLikePartDefinition f19828a;
        private final SuggestedPageUnitItem f19829b;

        public ViewPageClickListener(ContentBasedPageYouMayLikePartDefinition contentBasedPageYouMayLikePartDefinition, SuggestedPageUnitItem suggestedPageUnitItem) {
            this.f19828a = contentBasedPageYouMayLikePartDefinition;
            this.f19829b = suggestedPageUnitItem;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 895995640);
            this.f19828a.f19834c.a(view, LinkifyTargetBuilder.a(this.f19829b.m()), null);
            Logger.a(2, EntryType.UI_INPUT_END, 384149250, a);
        }
    }

    private static ContentBasedPageYouMayLikePartDefinition m20062b(InjectorLike injectorLike) {
        return new ContentBasedPageYouMayLikePartDefinition(PageLiker.b(injectorLike), IdBasedProvider.a(injectorLike, 3561), DefaultFeedUnitRenderer.a(injectorLike), FeedEventBus.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m20063a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PagesYouMayLikeItemViewModelProps pagesYouMayLikeItemViewModelProps = (PagesYouMayLikeItemViewModelProps) obj;
        BlacklistIconClickListener blacklistIconClickListener = new BlacklistIconClickListener(this, pagesYouMayLikeItemViewModelProps.f19874a, pagesYouMayLikeItemViewModelProps.f19875b);
        subParts.a(2131560747, this.f19838g, new ViewPageClickListener(this, pagesYouMayLikeItemViewModelProps.f19875b));
        subParts.a(2131560748, this.f19838g, new ViewPageClickListener(this, pagesYouMayLikeItemViewModelProps.f19875b));
        subParts.a(2131560746, this.f19838g, new ViewPageClickListener(this, pagesYouMayLikeItemViewModelProps.f19875b));
        subParts.a(2131560750, this.f19838g, new LikeButtonClickListener(this, pagesYouMayLikeItemViewModelProps.f19874a, pagesYouMayLikeItemViewModelProps.f19875b));
        subParts.a(2131560751, this.f19838g, blacklistIconClickListener);
        return null;
    }

    public final /* bridge */ /* synthetic */ void m20064a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int color;
        int a = Logger.a(8, EntryType.MARK_PUSH, -665486274);
        ContentBasedPageYouMayLikeView contentBasedPageYouMayLikeView = (ContentBasedPageYouMayLikeView) view;
        GraphQLPage m = ((PagesYouMayLikeItemViewModelProps) obj).f19875b.m();
        contentBasedPageYouMayLikeView.d.setText(m.aG());
        boolean O = m.O();
        FeedbackCustomPressStateButton feedbackCustomPressStateButton = contentBasedPageYouMayLikeView.f;
        int i = contentBasedPageYouMayLikeView.c.booleanValue() ? O ? 2130840279 : 2130840278 : O ? 2130843445 : 2130843444;
        feedbackCustomPressStateButton.setDrawable(i);
        if (O) {
            color = contentBasedPageYouMayLikeView.getResources().getColor(2131361917);
        } else {
            color = contentBasedPageYouMayLikeView.getResources().getColor(2131361974);
        }
        contentBasedPageYouMayLikeView.f.setTextColor(color);
        if (m.av() && ((TriState) contentBasedPageYouMayLikeView.b.get()).asBoolean(false)) {
            contentBasedPageYouMayLikeView.g.setVisibility(0);
        } else {
            contentBasedPageYouMayLikeView.g.setVisibility(8);
        }
        Logger.a(8, EntryType.MARK_POP, 1252104562, a);
    }

    public static ContentBasedPageYouMayLikePartDefinition m20061a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContentBasedPageYouMayLikePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19831j) {
                ContentBasedPageYouMayLikePartDefinition contentBasedPageYouMayLikePartDefinition;
                if (a2 != null) {
                    contentBasedPageYouMayLikePartDefinition = (ContentBasedPageYouMayLikePartDefinition) a2.a(f19831j);
                } else {
                    contentBasedPageYouMayLikePartDefinition = f19830i;
                }
                if (contentBasedPageYouMayLikePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m20062b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19831j, b3);
                        } else {
                            f19830i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = contentBasedPageYouMayLikePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ContentBasedPageYouMayLikePartDefinition(PageLiker pageLiker, Provider<TasksManager> provider, DefaultFeedUnitRenderer defaultFeedUnitRenderer, FeedEventBus feedEventBus, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, ClickListenerPartDefinition clickListenerPartDefinition, GatekeeperStore gatekeeperStore) {
        this.f19832a = pageLiker;
        this.f19838g = clickListenerPartDefinition;
        this.f19833b = (TasksManager) provider.get();
        this.f19834c = defaultFeedUnitRenderer;
        this.f19835d = feedEventBus;
        this.f19836e = newsFeedAnalyticsEventBuilder;
        this.f19837f = analyticsLogger;
        this.f19839h = gatekeeperStore;
    }
}
