package com.facebook.goodwill.birthday;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.util.FindViewUtil;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.feed.data.FeedUnitSubscriber;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.loader.FeedOnDataChangeListener;
import com.facebook.feed.rows.NewsFeedRootGroupPartDefinition;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.HideEvents.ChangeRendererEventSubscriber;
import com.facebook.feed.util.event.HideEvents.StoryDeleteEvent;
import com.facebook.feed.util.event.HideEvents.StoryDeleteEventSubscriber;
import com.facebook.feedcontrollers.FeedLikeController;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.goodwill.birthday.BirthdayCardLoader.C29931;
import com.facebook.goodwill.birthday.BirthdayCardLoader.LoadStoriesCallback;
import com.facebook.goodwill.birthday.BirthdayCardLoader.Task;
import com.facebook.goodwill.feed.ui.ThrowbackFeedListType;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.LayoutManagerWithKeepAttachedHack;
import com.facebook.widget.recyclerview.RecyclerViewProxy;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.inject.Inject;

@UriMatchPatterns(fragment = ContentFragmentType.BIRTHDAY_CARD_FRAGMENT)
/* compiled from: WEBVIEW_INTERSTITIAL_UNKNOWN */
public class BirthdayCardFragment extends FbFragment {
    @Inject
    public BirthdayCardLoader f21009a;
    @Inject
    Lazy<ComposerPublishServiceHelper> al;
    @Inject
    public FeedUnitSubscriber am;
    @Inject
    public FeedLikeController an;
    public FeedOnDataChangeListener ao;
    private MultiRowAdapter ap;
    public ScrollingViewProxy aq;
    public BirthdayCardHeaderView ar;
    public View as;
    public View at;
    public LoadingIndicatorView au;
    @Inject
    public BirthdayCardLoaderProtocol f21010b;
    @Inject
    MultiRowAdapterBuilder f21011c;
    @Inject
    Lazy<NewsFeedRootGroupPartDefinition> f21012d;
    @Inject
    MultipleRowsStoriesRecycleCallback f21013e;
    @Inject
    public FbEventSubscriberListManager f21014f;
    @Inject
    FeedEventBus f21015g;
    @Inject
    FeedStoryMutator f21016h;
    @Inject
    BirthdayCardFeedEnvironmentProvider f21017i;

    /* compiled from: WEBVIEW_INTERSTITIAL_UNKNOWN */
    public class C29861 extends StoryDeleteEventSubscriber {
        final /* synthetic */ BirthdayCardFragment f21003a;

        public C29861(BirthdayCardFragment birthdayCardFragment) {
            this.f21003a = birthdayCardFragment;
        }

        public final void m21995b(FbEvent fbEvent) {
            StoryDeleteEvent storyDeleteEvent = (StoryDeleteEvent) fbEvent;
            BirthdayCardFragment.m22001a(this.f21003a, storyDeleteEvent.a(), storyDeleteEvent.b());
            BirthdayCardFragment.as(this.f21003a).notifyDataSetChanged();
        }
    }

    /* compiled from: WEBVIEW_INTERSTITIAL_UNKNOWN */
    public class C29872 extends ChangeRendererEventSubscriber {
        final /* synthetic */ BirthdayCardFragment f21004a;

        public C29872(BirthdayCardFragment birthdayCardFragment) {
            this.f21004a = birthdayCardFragment;
        }

        public final void m21996b(FbEvent fbEvent) {
            BirthdayCardFragment.as(this.f21004a).notifyDataSetChanged();
        }
    }

    /* compiled from: WEBVIEW_INTERSTITIAL_UNKNOWN */
    class C29883 implements OnScrollListener {
        final /* synthetic */ BirthdayCardFragment f21005a;

        C29883(BirthdayCardFragment birthdayCardFragment) {
            this.f21005a = birthdayCardFragment;
        }

        public final void m21997a(ScrollingViewProxy scrollingViewProxy, int i) {
        }

        public final void m21998a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            Object obj = null;
            if (!BirthdayCardFragment.as(this.f21005a).isEmpty() && i2 > 0 && i3 > 0 && (i + i2) + 5 > i3) {
                obj = 1;
            }
            if (obj != null) {
                BirthdayCardLoader birthdayCardLoader = this.f21005a.f21009a;
                if (!birthdayCardLoader.f21035f) {
                    birthdayCardLoader.f21031b.a(Task.LOAD_NEXT_PAGE, new C29931(birthdayCardLoader), new LoadStoriesCallback(birthdayCardLoader));
                }
            }
        }
    }

    /* compiled from: WEBVIEW_INTERSTITIAL_UNKNOWN */
    public class C29894 {
        public final /* synthetic */ BirthdayCardFragment f21006a;

        public C29894(BirthdayCardFragment birthdayCardFragment) {
            this.f21006a = birthdayCardFragment;
        }
    }

    /* compiled from: WEBVIEW_INTERSTITIAL_UNKNOWN */
    public class C29905 implements FeedOnDataChangeListener {
        final /* synthetic */ BirthdayCardFragment f21007a;

        public C29905(BirthdayCardFragment birthdayCardFragment) {
            this.f21007a = birthdayCardFragment;
        }

        public final void m21999c() {
            BirthdayCardFragment.as(this.f21007a).notifyDataSetChanged();
        }
    }

    /* compiled from: WEBVIEW_INTERSTITIAL_UNKNOWN */
    class C29916 implements Runnable {
        final /* synthetic */ BirthdayCardFragment f21008a;

        C29916(BirthdayCardFragment birthdayCardFragment) {
            this.f21008a = birthdayCardFragment;
        }

        public void run() {
            BirthdayCardFragment.as(this.f21008a).notifyDataSetChanged();
        }
    }

    public static void m22003a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((BirthdayCardFragment) obj).m22002a(BirthdayCardLoader.m22015b(fbInjector), BirthdayCardLoaderProtocol.m22019b(fbInjector), MultiRowAdapterBuilder.b(fbInjector), IdBasedLazy.a(fbInjector, 1480), MultipleRowsStoriesRecycleCallback.a(fbInjector), FbEventSubscriberListManager.a(fbInjector), FeedEventBus.a(fbInjector), FeedStoryMutator.b(fbInjector), (BirthdayCardFeedEnvironmentProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(BirthdayCardFeedEnvironmentProvider.class), IdBasedLazy.a(fbInjector, 5272), FeedUnitSubscriber.b(fbInjector), FeedLikeController.b(fbInjector));
    }

    private void m22002a(BirthdayCardLoader birthdayCardLoader, BirthdayCardLoaderProtocol birthdayCardLoaderProtocol, MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<NewsFeedRootGroupPartDefinition> lazy, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, FbEventSubscriberListManager fbEventSubscriberListManager, FeedEventBus feedEventBus, FeedStoryMutator feedStoryMutator, BirthdayCardFeedEnvironmentProvider birthdayCardFeedEnvironmentProvider, Lazy<ComposerPublishServiceHelper> lazy2, FeedUnitSubscriber feedUnitSubscriber, FeedLikeController feedLikeController) {
        this.f21009a = birthdayCardLoader;
        this.f21010b = birthdayCardLoaderProtocol;
        this.f21011c = multiRowAdapterBuilder;
        this.f21012d = lazy;
        this.f21013e = multipleRowsStoriesRecycleCallback;
        this.f21014f = fbEventSubscriberListManager;
        this.f21015g = feedEventBus;
        this.f21016h = feedStoryMutator;
        this.f21017i = birthdayCardFeedEnvironmentProvider;
        this.al = lazy2;
        this.am = feedUnitSubscriber;
        this.an = feedLikeController;
    }

    public final void m22010c(Bundle bundle) {
        super.c(bundle);
        Class cls = BirthdayCardFragment.class;
        m22003a(this, getContext());
        this.f21014f.a(new C29861(this));
        this.f21014f.a(new C29872(this));
    }

    public final View m22008a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1594522046);
        View frameLayout = new FrameLayout(o());
        BetterRecyclerView betterRecyclerView = (BetterRecyclerView) FindViewUtil.b(layoutInflater.inflate(2130904605, frameLayout), 2131562570);
        betterRecyclerView.setLayoutManager(new LayoutManagerWithKeepAttachedHack(betterRecyclerView));
        RecyclerViewProxy recyclerViewProxy = new RecyclerViewProxy(betterRecyclerView);
        recyclerViewProxy.k();
        recyclerViewProxy.b(false);
        recyclerViewProxy.d(true);
        this.aq = recyclerViewProxy;
        this.ar = new BirthdayCardHeaderView(o());
        this.as = layoutInflater.inflate(2130904604, this.aq.b(), false);
        this.at = layoutInflater.inflate(2130904607, this.aq.b(), false);
        this.au = (LoadingIndicatorView) this.at.findViewById(2131562574);
        m22005b(true, this.au);
        this.f21010b.f21042e = 10;
        BirthdayCardLoader birthdayCardLoader = this.f21009a;
        BirthdayCardLoaderProtocol birthdayCardLoaderProtocol = this.f21010b;
        C29894 c29894 = new C29894(this);
        birthdayCardLoader.f21032c = (BirthdayCardLoaderProtocol) Preconditions.checkNotNull(birthdayCardLoaderProtocol);
        birthdayCardLoader.f21033d = (C29894) Preconditions.checkNotNull(c29894);
        this.ao = new C29905(this);
        this.am.a(at(this), this.ao);
        this.an.a(at(this).a, this.ao);
        aq();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1753556945, a);
        return frameLayout;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1233899600);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131239676);
            hasTitleBar.c(true);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 938712188, a);
    }

    public final void m22006G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2057222050);
        super.G();
        if (this.f21014f != null) {
            this.f21014f.a(this.f21015g);
        }
        this.am.d();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 414640622, a);
    }

    public final void m22007H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1980605613);
        super.H();
        if (this.f21014f != null) {
            this.f21014f.b(this.f21015g);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1248768383, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2071740304);
        super.mY_();
        if (this.ap != null) {
            this.ap.jc_();
        }
        this.am.e();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 65962669, a);
    }

    public final void m22009a(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 1756:
                    ((ComposerPublishServiceHelper) this.al.get()).c(intent);
                    return;
                default:
                    return;
            }
        }
    }

    private void aq() {
        this.aq.b(new C29883(this));
        this.aq.d(this.ar);
        this.aq.e(this.at);
        this.aq.a(as(this));
        this.aq.a(this.f21013e.a());
        BirthdayCardLoader birthdayCardLoader = this.f21009a;
        birthdayCardLoader.f21031b.a(Task.LOAD_INITIAL_FEED, birthdayCardLoader.m22017a(true), new LoadStoriesCallback(birthdayCardLoader));
    }

    public static MultiRowAdapter as(BirthdayCardFragment birthdayCardFragment) {
        if (birthdayCardFragment.ap == null) {
            AnyEnvironment birthdayCardFeedEnvironment = new BirthdayCardFeedEnvironment(birthdayCardFragment.getContext(), ThrowbackFeedListType.f21225a, HasScrollListenerSupportImpl.a(birthdayCardFragment.aq), new C29916(birthdayCardFragment));
            Builder a = birthdayCardFragment.f21011c.a(birthdayCardFragment.f21012d, at(birthdayCardFragment));
            a.f = birthdayCardFeedEnvironment;
            birthdayCardFragment.ap = a.e();
        }
        return birthdayCardFragment.ap;
    }

    public static FeedUnitCollection at(BirthdayCardFragment birthdayCardFragment) {
        return birthdayCardFragment.f21009a.f21030a;
    }

    public static void m22005b(boolean z, LoadingIndicatorView loadingIndicatorView) {
        if (z) {
            loadingIndicatorView.a();
        } else {
            loadingIndicatorView.b();
        }
    }

    public static void m22001a(BirthdayCardFragment birthdayCardFragment, String str, String str2) {
        if (str != null || str2 == null) {
            birthdayCardFragment.m22004b(str);
            return;
        }
        GraphQLStory b = at(birthdayCardFragment).b(str2);
        if (b != null) {
            birthdayCardFragment.m22000a(FeedProps.c(b));
        }
    }

    private void m22000a(FeedProps<GraphQLStory> feedProps) {
        at(this).a.a((GraphQLStory) this.f21016h.a(feedProps, StoryVisibility.GONE).a);
    }

    private void m22004b(String str) {
        if (!Strings.isNullOrEmpty(str)) {
            GraphQLStory graphQLStory;
            if (Strings.isNullOrEmpty(str)) {
                graphQLStory = null;
            } else {
                for (GraphQLFeedUnitEdge c : at(this).a(str)) {
                    FeedUnit c2 = c.c();
                    if (c2 instanceof GraphQLStory) {
                        graphQLStory = (GraphQLStory) c2;
                        break;
                    }
                }
                graphQLStory = null;
            }
            Flattenable flattenable = graphQLStory;
            if (flattenable != null) {
                m22000a(FeedProps.c(flattenable));
            }
        }
    }
}
