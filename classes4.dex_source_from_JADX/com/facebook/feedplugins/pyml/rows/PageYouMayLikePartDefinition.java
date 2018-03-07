package com.facebook.feedplugins.pyml.rows;

import android.content.Context;
import android.text.Spannable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.TriState;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.events.NavigatedToTargetPageEvent;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition.Controller;
import com.facebook.feedplugins.pyml.EgoUnitUtil;
import com.facebook.feedplugins.pyml.rows.ui.PageYouMayLikeView;
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
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: onDraw() called on unbound View */
public class PageYouMayLikePartDefinition extends BaseSinglePartDefinition<Props, State, AnyEnvironment, PageYouMayLikeView> {
    private static PageYouMayLikePartDefinition f6242j;
    private static final Object f6243k = new Object();
    private final Context f6244a;
    public final DefaultFeedUnitRenderer f6245b;
    public final PageLiker f6246c;
    public final ScheduledExecutorService f6247d;
    public final NewsFeedAnalyticsEventBuilder f6248e;
    public final EventsStream f6249f;
    private final boolean f6250g;
    public final GatekeeperStoreImpl f6251h;
    private final PymlSpannableHeaderBuilder f6252i;

    /* compiled from: onDraw() called on unbound View */
    public class Props {
        public final ScrollableItemListFeedUnit f6469a;
        public final SuggestedPageUnitItem f6470b;
        public final TasksManager<GraphQLPage> f6471c;
        public final Integer f6472d;
        public final Controller f6473e;
        public final Boolean f6474f;
        @Nullable
        public final NavigatedToTargetPageEvent f6475g;
        public final Boolean f6476h;

        public Props(ScrollableItemListFeedUnit scrollableItemListFeedUnit, SuggestedPageUnitItem suggestedPageUnitItem, TasksManager<GraphQLPage> tasksManager, Integer num, Controller controller, Boolean bool, NavigatedToTargetPageEvent navigatedToTargetPageEvent, Boolean bool2) {
            this.f6469a = scrollableItemListFeedUnit;
            this.f6470b = suggestedPageUnitItem;
            this.f6471c = tasksManager;
            this.f6472d = num;
            this.f6473e = controller;
            this.f6474f = bool;
            this.f6475g = navigatedToTargetPageEvent;
            this.f6476h = bool2;
        }
    }

    /* compiled from: onDraw() called on unbound View */
    public class State {
        public final OnClickListener f6481a;
        public final OnClickListener f6482b;
        public final CharSequence f6483c;
        public final CharSequence f6484d;
        public final CharSequence f6485e;
        public final Spannable f6486f;

        public State(OnClickListener onClickListener, OnClickListener onClickListener2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Spannable spannable) {
            this.f6481a = onClickListener;
            this.f6482b = onClickListener2;
            this.f6483c = charSequence;
            this.f6484d = charSequence2;
            this.f6485e = charSequence3;
            this.f6486f = spannable;
        }
    }

    private static PageYouMayLikePartDefinition m6696b(InjectorLike injectorLike) {
        return new PageYouMayLikePartDefinition((Context) injectorLike.getInstance(Context.class), EventsStream.a(injectorLike), DefaultFeedUnitRenderer.a(injectorLike), PageLiker.m6642b(injectorLike), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), IdBasedProvider.a(injectorLike, 677), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), PymlSpannableHeaderBuilder.m6647b(injectorLike));
    }

    public final Object m6697a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final Props props = (Props) obj;
        OnClickListener c02911 = new OnClickListener(this) {
            final /* synthetic */ PageYouMayLikePartDefinition f6478b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1606769980);
                view.setTag(2131558518, PageYouMayLikePartDefinition.m6691a(this.f6478b.f6248e, props.f6469a, props.f6470b));
                PageYouMayLikePartDefinition.m6693a(view, props.f6475g, props.f6470b, this.f6478b.f6245b, this.f6478b.f6249f);
                Logger.a(2, EntryType.UI_INPUT_END, -1933101960, a);
            }
        };
        OnClickListener c02922 = new OnClickListener(this) {
            final /* synthetic */ PageYouMayLikePartDefinition f6480b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1852858761);
                PageYouMayLikePartDefinition.m6695a(this.f6480b.f6251h, this.f6480b.f6246c, this.f6480b.f6247d, props.f6470b, props.f6469a, props.f6473e);
                Logger.a(2, EntryType.UI_INPUT_END, 1381055490, a);
            }
        };
        Spannable a = this.f6252i.m6648a(props.f6469a, props.f6470b);
        return new State(c02911, c02922, EgoUnitUtil.m6650a(props.f6470b), EgoUnitUtil.m6649a(this.f6244a, a, props.f6470b), EgoUnitUtil.m6651a(this.f6244a, props.f6470b), a);
    }

    public final /* bridge */ /* synthetic */ void m6698a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 706763791);
        m6694a((Props) obj, (State) obj2, (PageYouMayLikeView) view);
        Logger.a(8, EntryType.MARK_POP, 516831511, a);
    }

    public final void m6699b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        PageYouMayLikeView pageYouMayLikeView = (PageYouMayLikeView) view;
        ((Props) obj).f6471c.c();
        pageYouMayLikeView.setOnPageInfoClickedListener(null);
        pageYouMayLikeView.f6968o = null;
    }

    public static PageYouMayLikePartDefinition m6692a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageYouMayLikePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6243k) {
                PageYouMayLikePartDefinition pageYouMayLikePartDefinition;
                if (a2 != null) {
                    pageYouMayLikePartDefinition = (PageYouMayLikePartDefinition) a2.a(f6243k);
                } else {
                    pageYouMayLikePartDefinition = f6242j;
                }
                if (pageYouMayLikePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6696b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6243k, b3);
                        } else {
                            f6242j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageYouMayLikePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PageYouMayLikePartDefinition(Context context, EventsStream eventsStream, DefaultFeedUnitRenderer defaultFeedUnitRenderer, PageLiker pageLiker, ScheduledExecutorService scheduledExecutorService, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, Provider<TriState> provider, GatekeeperStore gatekeeperStore, PymlSpannableHeaderBuilder pymlSpannableHeaderBuilder) {
        this.f6244a = context;
        this.f6249f = eventsStream;
        this.f6245b = defaultFeedUnitRenderer;
        this.f6246c = pageLiker;
        this.f6247d = scheduledExecutorService;
        this.f6248e = newsFeedAnalyticsEventBuilder;
        this.f6250g = ((TriState) provider.get()).asBoolean(false);
        this.f6251h = gatekeeperStore;
        this.f6252i = pymlSpannableHeaderBuilder;
    }

    public static void m6693a(View view, @Nullable NavigatedToTargetPageEvent navigatedToTargetPageEvent, SuggestedPageUnitItem suggestedPageUnitItem, DefaultFeedUnitRenderer defaultFeedUnitRenderer, EventsStream eventsStream) {
        defaultFeedUnitRenderer.a(view, LinkifyTargetBuilder.a(suggestedPageUnitItem.mo548m()), null);
        if (navigatedToTargetPageEvent != null) {
            eventsStream.a(navigatedToTargetPageEvent);
        }
    }

    public static void m6695a(GatekeeperStoreImpl gatekeeperStoreImpl, PageLiker pageLiker, ScheduledExecutorService scheduledExecutorService, SuggestedPageUnitItem suggestedPageUnitItem, ScrollableItemListFeedUnit scrollableItemListFeedUnit, Controller controller) {
        GraphQLPage m = suggestedPageUnitItem.mo548m();
        pageLiker.m6643a(m, GraphQLHelper.a(suggestedPageUnitItem, scrollableItemListFeedUnit), suggestedPageUnitItem.mo546A(), gatekeeperStoreImpl.a(830, false) ? "feed_pyml" : null);
        if (!m.O()) {
            scheduledExecutorService.schedule(new 3(controller), 500, TimeUnit.MILLISECONDS);
        }
    }

    private void m6694a(Props props, State state, PageYouMayLikeView pageYouMayLikeView) {
        boolean z;
        int i = 0;
        SponsoredImpression ab_ = props.f6470b.ab_();
        boolean z2 = ab_ != null && ab_.k();
        CharSequence b = EgoUnitUtil.m6654b(pageYouMayLikeView.getContext(), props.f6470b);
        boolean a = ItemListFeedUnitHelper.m6752a(props.f6469a);
        if (a || !this.f6250g) {
            z = false;
        } else {
            z = true;
        }
        pageYouMayLikeView.f6966m.setVisibility(props.f6476h.booleanValue() ? 0 : 8);
        if (!props.f6474f.booleanValue()) {
            pageYouMayLikeView.mo587a(props.f6472d.intValue(), false, true);
        }
        PageYouMayLikeView.m7259a(pageYouMayLikeView.f6956c, state.f6486f);
        pageYouMayLikeView.f6965l.setContentDescription(state.f6486f);
        PageYouMayLikeView.m7259a(pageYouMayLikeView.f6957d, b);
        if (a) {
            PageYouMayLikeView.m7259a(pageYouMayLikeView.f6963j, state.f6483c);
            pageYouMayLikeView.f6963j.setMinLines(1);
            pageYouMayLikeView.f6963j.setMaxLines(3);
        } else {
            pageYouMayLikeView.f6963j.setText(state.f6483c);
            pageYouMayLikeView.f6963j.setLines(3);
            pageYouMayLikeView.f6963j.setVisibility(0);
        }
        if (z) {
            i = 16;
        }
        pageYouMayLikeView.f6963j.setGravity(i);
        PageYouMayLikeView.m7259a(pageYouMayLikeView.f6960g, state.f6484d);
        PageYouMayLikeView.m7259a(pageYouMayLikeView.f6962i, state.f6485e);
        pageYouMayLikeView.setOnPageInfoClickedListener(state.f6481a);
        pageYouMayLikeView.f6968o = state.f6482b;
        boolean O = props.f6470b.mo548m().O();
        pageYouMayLikeView.f6967n.setSelected(O);
        pageYouMayLikeView.f6967n.setContentDescription(pageYouMayLikeView.getContext().getResources().getString(O ? 2131233427 : 2131233426));
        pageYouMayLikeView.setSponsoredTagsValue(z2);
    }

    public static HoneyClientEvent m6691a(NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, ScrollableItemListFeedUnit scrollableItemListFeedUnit, SuggestedPageUnitItem suggestedPageUnitItem) {
        return NewsFeedAnalyticsEventBuilder.b(suggestedPageUnitItem.mo546A() != null, GraphQLHelper.a(suggestedPageUnitItem, scrollableItemListFeedUnit));
    }
}
