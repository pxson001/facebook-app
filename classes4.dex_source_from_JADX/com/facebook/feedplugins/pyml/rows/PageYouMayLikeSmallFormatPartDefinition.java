package com.facebook.feedplugins.pyml.rows;

import android.content.Context;
import android.text.Spannable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.TriState;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition.Controller;
import com.facebook.feedplugins.pyml.EgoUnitUtil;
import com.facebook.feedplugins.pyml.rows.ui.PageYouMayLikeSmallFormatView;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.ItemListFeedUnitHelper;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.SponsoredImpression;
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
import com.facebook.ui.futures.TasksManager;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: onMeasure() called on unbound View */
public class PageYouMayLikeSmallFormatPartDefinition extends BaseSinglePartDefinition<Props, State, AnyEnvironment, PageYouMayLikeSmallFormatView> {
    private static PageYouMayLikeSmallFormatPartDefinition f6159i;
    private static final Object f6160j = new Object();
    public final DefaultFeedUnitRenderer f6161a;
    public final PageLiker f6162b;
    public final ScheduledExecutorService f6163c;
    private final NewsFeedAnalyticsEventBuilder f6164d;
    private final boolean f6165e;
    public final GatekeeperStoreImpl f6166f;
    private final PymlSpannableHeaderBuilder f6167g;
    private final EgoUnitUtil f6168h;

    /* compiled from: onMeasure() called on unbound View */
    public class Props {
        public final ScrollableItemListFeedUnit f6377a;
        public final SuggestedPageUnitItem f6378b;
        public final TasksManager<GraphQLPage> f6379c;
        public final Controller f6380d;

        public Props(ScrollableItemListFeedUnit scrollableItemListFeedUnit, SuggestedPageUnitItem suggestedPageUnitItem, TasksManager<GraphQLPage> tasksManager, Controller controller) {
            this.f6377a = scrollableItemListFeedUnit;
            this.f6378b = suggestedPageUnitItem;
            this.f6379c = tasksManager;
            this.f6380d = controller;
        }
    }

    /* compiled from: onMeasure() called on unbound View */
    public class State {
        public final OnClickListener f6392a;
        public final OnClickListener f6393b;
        public final Spannable f6394c;
        public final CharSequence f6395d;

        public State(OnClickListener onClickListener, OnClickListener onClickListener2, Spannable spannable, CharSequence charSequence) {
            this.f6392a = onClickListener;
            this.f6393b = onClickListener2;
            this.f6394c = spannable;
            this.f6395d = charSequence;
        }
    }

    private static PageYouMayLikeSmallFormatPartDefinition m6638b(InjectorLike injectorLike) {
        return new PageYouMayLikeSmallFormatPartDefinition(DefaultFeedUnitRenderer.a(injectorLike), PageLiker.m6642b(injectorLike), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), IdBasedProvider.a(injectorLike, 677), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), PymlSpannableHeaderBuilder.m6647b(injectorLike), EgoUnitUtil.m6652b(injectorLike));
    }

    public final Object m6639a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final Props props = (Props) obj;
        return new State(new OnClickListener(this) {
            final /* synthetic */ PageYouMayLikeSmallFormatPartDefinition f6385b;

            public void onClick(View view) {
                boolean z;
                int a = Logger.a(2, EntryType.UI_INPUT_START, 731900568);
                PageYouMayLikeSmallFormatPartDefinition pageYouMayLikeSmallFormatPartDefinition = this.f6385b;
                ScrollableItemListFeedUnit scrollableItemListFeedUnit = props.f6377a;
                SuggestedPageUnitItem suggestedPageUnitItem = props.f6378b;
                if (suggestedPageUnitItem.mo546A() != null) {
                    z = true;
                } else {
                    z = false;
                }
                view.setTag(2131558518, NewsFeedAnalyticsEventBuilder.b(z, GraphQLHelper.a(suggestedPageUnitItem, scrollableItemListFeedUnit)));
                this.f6385b.f6161a.a(view, LinkifyTargetBuilder.a(props.f6378b.mo548m()), null);
                Logger.a(2, EntryType.UI_INPUT_END, 1844632462, a);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ PageYouMayLikeSmallFormatPartDefinition f6387b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1078931711);
                PageYouMayLikeSmallFormatPartDefinition pageYouMayLikeSmallFormatPartDefinition = this.f6387b;
                Props props = props;
                GraphQLPage m = props.f6378b.mo548m();
                pageYouMayLikeSmallFormatPartDefinition.f6162b.m6643a(m, GraphQLHelper.a(props.f6378b, props.f6377a), props.f6378b.mo546A(), pageYouMayLikeSmallFormatPartDefinition.f6166f.a(830, false) ? "feed_pyml" : null);
                if (!m.O()) {
                    pageYouMayLikeSmallFormatPartDefinition.f6163c.schedule(new 3(pageYouMayLikeSmallFormatPartDefinition, props), 500, TimeUnit.MILLISECONDS);
                }
                Logger.a(2, EntryType.UI_INPUT_END, -250604137, a);
            }
        }, this.f6167g.m6648a(props.f6377a, props.f6378b), this.f6168h.m6655a(props.f6377a, props.f6378b));
    }

    public final /* bridge */ /* synthetic */ void m6640a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1398809151);
        m6637a((Props) obj, (State) obj2, (PageYouMayLikeSmallFormatView) view);
        Logger.a(8, EntryType.MARK_POP, -1643424253, a);
    }

    public final void m6641b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        PageYouMayLikeSmallFormatView pageYouMayLikeSmallFormatView = (PageYouMayLikeSmallFormatView) view;
        ((Props) obj).f6379c.c();
        pageYouMayLikeSmallFormatView.setOnPageInfoClickedListener(null);
        pageYouMayLikeSmallFormatView.f6408m = null;
    }

    public static PageYouMayLikeSmallFormatPartDefinition m6636a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageYouMayLikeSmallFormatPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6160j) {
                PageYouMayLikeSmallFormatPartDefinition pageYouMayLikeSmallFormatPartDefinition;
                if (a2 != null) {
                    pageYouMayLikeSmallFormatPartDefinition = (PageYouMayLikeSmallFormatPartDefinition) a2.a(f6160j);
                } else {
                    pageYouMayLikeSmallFormatPartDefinition = f6159i;
                }
                if (pageYouMayLikeSmallFormatPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6638b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6160j, b3);
                        } else {
                            f6159i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageYouMayLikeSmallFormatPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PageYouMayLikeSmallFormatPartDefinition(DefaultFeedUnitRenderer defaultFeedUnitRenderer, PageLiker pageLiker, ScheduledExecutorService scheduledExecutorService, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, Provider<TriState> provider, GatekeeperStore gatekeeperStore, PymlSpannableHeaderBuilder pymlSpannableHeaderBuilder, EgoUnitUtil egoUnitUtil) {
        this.f6161a = defaultFeedUnitRenderer;
        this.f6162b = pageLiker;
        this.f6163c = scheduledExecutorService;
        this.f6164d = newsFeedAnalyticsEventBuilder;
        this.f6165e = ((TriState) provider.get()).asBoolean(false);
        this.f6166f = gatekeeperStore;
        this.f6167g = pymlSpannableHeaderBuilder;
        this.f6168h = egoUnitUtil;
    }

    private void m6637a(Props props, State state, PageYouMayLikeSmallFormatView pageYouMayLikeSmallFormatView) {
        boolean z;
        SponsoredImpression ab_ = props.f6378b.ab_();
        boolean z2 = ab_ != null && ab_.k();
        CharSequence b = EgoUnitUtil.m6654b(pageYouMayLikeSmallFormatView.getContext(), props.f6378b);
        CharSequence a = EgoUnitUtil.m6649a(pageYouMayLikeSmallFormatView.getContext(), state.f6394c, props.f6378b);
        CharSequence a2 = EgoUnitUtil.m6650a(props.f6378b);
        CharSequence charSequence = state.f6395d;
        PageYouMayLikeSmallFormatView.m6851a(pageYouMayLikeSmallFormatView.f6397b, charSequence);
        pageYouMayLikeSmallFormatView.f6398c.setVisibility(charSequence != null ? 0 : 8);
        PageYouMayLikeSmallFormatView.m6851a(pageYouMayLikeSmallFormatView.f6399d, state.f6394c);
        PageYouMayLikeSmallFormatView.m6851a(pageYouMayLikeSmallFormatView.f6400e, b);
        if (ItemListFeedUnitHelper.m6752a(props.f6377a)) {
            PageYouMayLikeSmallFormatView.m6851a(pageYouMayLikeSmallFormatView.f6404i, a2);
            pageYouMayLikeSmallFormatView.f6404i.setMinLines(1);
            pageYouMayLikeSmallFormatView.f6404i.setMaxLines(3);
            pageYouMayLikeSmallFormatView.f6404i.setGravity(0);
        } else {
            z = this.f6165e;
            int i = 0;
            pageYouMayLikeSmallFormatView.f6404i.setText(a2);
            pageYouMayLikeSmallFormatView.f6404i.setLines(3);
            pageYouMayLikeSmallFormatView.f6404i.setVisibility(0);
            TextView textView = pageYouMayLikeSmallFormatView.f6404i;
            if (z) {
                i = 16;
            }
            textView.setGravity(i);
        }
        PageYouMayLikeSmallFormatView.m6851a(pageYouMayLikeSmallFormatView.f6401f, a);
        PageYouMayLikeSmallFormatView.m6851a(pageYouMayLikeSmallFormatView.f6403h, EgoUnitUtil.m6651a(pageYouMayLikeSmallFormatView.getContext(), props.f6378b));
        pageYouMayLikeSmallFormatView.setOnPageInfoClickedListener(state.f6392a);
        pageYouMayLikeSmallFormatView.f6408m = state.f6393b;
        z = props.f6378b.mo548m().O();
        pageYouMayLikeSmallFormatView.f6407l.setSelected(z);
        pageYouMayLikeSmallFormatView.f6407l.setContentDescription(pageYouMayLikeSmallFormatView.getContext().getResources().getString(z ? 2131233427 : 2131233426));
        pageYouMayLikeSmallFormatView.f6399d.setTag(2131558541, Boolean.valueOf(z2));
        pageYouMayLikeSmallFormatView.f6401f.setTag(2131558541, Boolean.valueOf(z2));
    }
}
