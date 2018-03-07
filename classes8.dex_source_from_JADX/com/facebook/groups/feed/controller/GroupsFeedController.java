package com.facebook.groups.feed.controller;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.BaseAdapter;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.AbstractFbFragmentListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.util.TriState;
import com.facebook.common.viewport.ViewportMonitor;
import com.facebook.composer.publish.common.EditPostParams;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.debug.dumpsys.DumpsysContext;
import com.facebook.debug.dumpsys.DumpsysDumper;
import com.facebook.debug.log.BLog;
import com.facebook.feed.data.FeedUnitSubscriber;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.loader.FeedOnDataChangeListener;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.feed.rows.MultiRowFeedLifecycleSubscribers;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.BoundedAdapter;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.ui.FeedLifecycleSubscribers;
import com.facebook.feed.ui.GenericNotificationBanner;
import com.facebook.feed.ui.GenericNotificationBanner.NotificationBannerType;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.ViewportViewEvents.FeedVisibilityEvent;
import com.facebook.feed.util.event.ViewportViewEvents.FeedVisibilityEventSubscriber;
import com.facebook.feedcontrollers.FeedDeletePostController;
import com.facebook.feedcontrollers.FeedEditPostController;
import com.facebook.feedcontrollers.FeedEditPostController.C12821;
import com.facebook.feedcontrollers.FeedLikeController;
import com.facebook.feedcontrollers.FeedSetNotifyMeController;
import com.facebook.feedcontrollers.FeedStoryVisibilityController;
import com.facebook.feedcontrollers.FeedUnitMutationController;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.groups.feed.controller.GroupsFeedPager.C14815;
import com.facebook.groups.perf.DefaultGroupsPerfLogger;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.places.checkin.launcher.PlacePickerResultHandler;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.adapters.MergingAdapter;
import com.facebook.widget.AnimatedNotificationBanner;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.refreshableview.RefreshableListViewContainer;
import com.facebook.widget.refreshableview.RefreshableViewContainerLike;
import com.google.common.collect.ImmutableList;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: failed to initialize camera */
public class GroupsFeedController extends AbstractFbFragmentListener {
    public ListViewProxy f13875A;
    public GroupsFeedControllerResponder f13876B;
    public SelfRegistrableReceiverImpl f13877C;
    private String f13878D = null;
    public GroupsFeedPager f13879E;
    private boolean f13880F;
    public boolean f13881G;
    private boolean f13882H;
    public boolean f13883I;
    private final Provider<TriState> f13884J;
    private final Provider<TriState> f13885K;
    public boolean f13886L;
    public boolean f13887M;
    public final FeedLikeController f13888a;
    public final FeedSetNotifyMeController f13889b;
    public final FeedEditPostController f13890c;
    public final FeedDeletePostController f13891d;
    public final FeedStoryVisibilityController f13892e;
    private final FeedVisibilityEventForViewportSubscriber f13893f;
    public final FeedUnitMutationController f13894g;
    private final FbNetworkManager f13895h;
    private final FeedLifecycleSubscribers f13896i;
    private final Lazy<DumpsysDumper> f13897j;
    private final MultipleRowsStoriesRecycleCallback f13898k;
    public final FeedUnitSubscriber f13899l;
    public final ViewportMonitor f13900m;
    private final Lazy<PlacePickerResultHandler> f13901n;
    private final FeedLoggingViewportEventListener f13902o;
    public final FbEventSubscriberListManager f13903p;
    public final FeedEventBus f13904q;
    private BaseAdapter f13905r;
    private BaseAdapter f13906s;
    private BaseAdapter f13907t;
    public MultiRowAdapter f13908u;
    private FeedEnvironment f13909v;
    public RefreshableListViewContainer f13910w;
    public SwipeRefreshLayout f13911x;
    private GenericNotificationBanner f13912y;
    public View f13913z;

    /* compiled from: failed to initialize camera */
    class C14701 implements OnScrollListener {
        final /* synthetic */ GroupsFeedController f13867a;

        C14701(GroupsFeedController groupsFeedController) {
            this.f13867a = groupsFeedController;
        }

        public final void m15518a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            GroupsFeedController groupsFeedController = this.f13867a;
            Object obj = null;
            if (!groupsFeedController.f13908u.isEmpty() && i2 > 0 && i3 > 0 && (i + i2) + 5 > i3) {
                obj = 1;
            }
            if (obj != null) {
                GroupsFeedPager groupsFeedPager = groupsFeedController.f13879E;
                if (!groupsFeedPager.f13938r) {
                    DefaultGroupsPerfLogger defaultGroupsPerfLogger = groupsFeedPager.f13926f;
                    new C14815(groupsFeedPager).run();
                }
            }
            if ((!this.f13867a.f13886L || this.f13867a.f13887M) && GroupsFeedController.m15528k(this.f13867a)) {
                this.f13867a.f13900m.a(this.f13867a.f13875A, i, i2, i3);
            }
        }

        public final void m15517a(ScrollingViewProxy scrollingViewProxy, int i) {
            switch (i) {
                case 0:
                    if (GroupsFeedController.m15528k(this.f13867a)) {
                        this.f13867a.f13900m.b(scrollingViewProxy);
                    }
                    this.f13867a.f13887M = false;
                    return;
                case 1:
                    this.f13867a.f13886L = true;
                    this.f13867a.f13887M = true;
                    return;
                case 2:
                    this.f13867a.f13887M = true;
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: failed to initialize camera */
    class C14712 implements OnRefreshListener {
        final /* synthetic */ GroupsFeedController f13868a;

        C14712(GroupsFeedController groupsFeedController) {
            this.f13868a = groupsFeedController;
        }

        public final void m15519a() {
            this.f13868a.f13876B.m15551b(true);
            this.f13868a.m15538c(true);
        }
    }

    /* compiled from: failed to initialize camera */
    class C14723 extends RefreshableViewContainerLike.OnRefreshListener {
        final /* synthetic */ GroupsFeedController f13869a;

        C14723(GroupsFeedController groupsFeedController) {
            this.f13869a = groupsFeedController;
        }

        public final void m15520b(boolean z) {
            if (z) {
                this.f13869a.f13876B.m15551b(z);
                this.f13869a.m15538c(true);
            }
        }
    }

    /* compiled from: failed to initialize camera */
    class C14734 implements OnGlobalLayoutListener {
        final /* synthetic */ GroupsFeedController f13870a;

        C14734(GroupsFeedController groupsFeedController) {
            this.f13870a = groupsFeedController;
        }

        public void onGlobalLayout() {
            this.f13870a.m15536b(false);
            if (VERSION.SDK_INT < 16) {
                this.f13870a.f13910w.c().getViewTreeObserver().removeGlobalOnLayoutListener(this);
            } else {
                this.f13870a.f13910w.c().getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* compiled from: failed to initialize camera */
    class C14745 implements FeedOnDataChangeListener {
        final /* synthetic */ GroupsFeedController f13871a;

        C14745(GroupsFeedController groupsFeedController) {
            this.f13871a = groupsFeedController;
        }

        public final void m15521c() {
            if (this.f13871a.f13881G) {
                this.f13871a.f13876B.nt_();
                this.f13871a.m15536b(false);
            }
        }
    }

    /* compiled from: failed to initialize camera */
    class C14756 implements FeedOnDataChangeListener {
        final /* synthetic */ GroupsFeedController f13872a;

        C14756(GroupsFeedController groupsFeedController) {
            this.f13872a = groupsFeedController;
        }

        public final void m15522c() {
            GroupsFeedController groupsFeedController = this.f13872a;
            if (groupsFeedController.f13881G) {
                groupsFeedController.f13876B.m15555r();
                groupsFeedController.f13908u.notifyDataSetChanged();
                groupsFeedController.m15536b(false);
            }
            if (GroupsFeedController.m15528k(this.f13872a)) {
                this.f13872a.f13900m.a(this.f13872a.f13875A);
            }
        }
    }

    /* compiled from: failed to initialize camera */
    public class C14767 implements ActionReceiver {
        final /* synthetic */ GroupsFeedController f13873a;

        public C14767(GroupsFeedController groupsFeedController) {
            this.f13873a = groupsFeedController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -571897741);
            this.f13873a.m15543g();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 885292366, a);
        }
    }

    /* compiled from: failed to initialize camera */
    class FeedVisibilityEventForViewportSubscriber extends FeedVisibilityEventSubscriber {
        final /* synthetic */ GroupsFeedController f13874a;

        public FeedVisibilityEventForViewportSubscriber(GroupsFeedController groupsFeedController) {
            this.f13874a = groupsFeedController;
        }

        public final void m15523b(FbEvent fbEvent) {
            FeedVisibilityEvent feedVisibilityEvent = (FeedVisibilityEvent) fbEvent;
            if (GroupsFeedController.m15528k(this.f13874a) && this.f13874a.f13900m != null && this.f13874a.f13875A != null) {
                if (feedVisibilityEvent.a) {
                    this.f13874a.f13900m.a(this.f13874a.f13875A);
                } else {
                    this.f13874a.f13900m.c(this.f13874a.f13875A);
                }
            }
        }
    }

    public static GroupsFeedController m15527b(InjectorLike injectorLike) {
        return new GroupsFeedController((FeedLifecycleSubscribers) MultiRowFeedLifecycleSubscribers.a(injectorLike), IdBasedProvider.a(injectorLike, 687), IdBasedProvider.a(injectorLike, 686), FbEventSubscriberListManager.a(injectorLike), FbNetworkManager.a(injectorLike), FeedDeletePostController.m14023a(injectorLike), FeedEditPostController.m14029a(injectorLike), FeedEventBus.a(injectorLike), FeedLikeController.m14039a(injectorLike), FeedLoggingViewportEventListener.a(injectorLike), FeedSetNotifyMeController.m14046a(injectorLike), FeedStoryVisibilityController.m14053a(injectorLike), FeedUnitMutationController.m14058a(injectorLike), FeedUnitSubscriber.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 5454), MultipleRowsStoriesRecycleCallback.a(injectorLike), IdBasedLazy.a(injectorLike, 2998), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), ViewportMonitor.a(injectorLike));
    }

    public static GroupsFeedController m15524a(InjectorLike injectorLike) {
        return m15527b(injectorLike);
    }

    public final void m15533a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (BuildConstants.i && this.f13908u != null) {
            DumpsysContext dumpsysContext = new DumpsysContext(str, fileDescriptor, printWriter, strArr, (DumpsysDumper) this.f13897j.get());
            dumpsysContext.f.a(this.f13908u, dumpsysContext);
        }
    }

    @Inject
    public GroupsFeedController(FeedLifecycleSubscribers feedLifecycleSubscribers, Provider<TriState> provider, Provider<TriState> provider2, FbEventSubscriberListManager fbEventSubscriberListManager, FbNetworkManager fbNetworkManager, FeedDeletePostController feedDeletePostController, FeedEditPostController feedEditPostController, FeedEventBus feedEventBus, FeedLikeController feedLikeController, FeedLoggingViewportEventListener feedLoggingViewportEventListener, FeedSetNotifyMeController feedSetNotifyMeController, FeedStoryVisibilityController feedStoryVisibilityController, FeedUnitMutationController feedUnitMutationController, FeedUnitSubscriber feedUnitSubscriber, Lazy<DumpsysDumper> lazy, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, Lazy<PlacePickerResultHandler> lazy2, QeAccessor qeAccessor, ViewportMonitor viewportMonitor) {
        this.f13891d = feedDeletePostController;
        this.f13897j = lazy;
        this.f13890c = feedEditPostController;
        this.f13903p = fbEventSubscriberListManager;
        this.f13904q = feedEventBus;
        this.f13896i = feedLifecycleSubscribers;
        this.f13902o = feedLoggingViewportEventListener;
        this.f13894g = feedUnitMutationController;
        this.f13899l = feedUnitSubscriber;
        this.f13884J = provider;
        this.f13888a = feedLikeController;
        this.f13895h = fbNetworkManager;
        this.f13898k = multipleRowsStoriesRecycleCallback;
        this.f13889b = feedSetNotifyMeController;
        this.f13901n = lazy2;
        this.f13900m = viewportMonitor;
        this.f13892e = feedStoryVisibilityController;
        this.f13885K = provider2;
        this.f13893f = new FeedVisibilityEventForViewportSubscriber(this);
    }

    public final void m15532a(View view, GroupsFeedPager groupsFeedPager, FeedUnitCollection feedUnitCollection, FbFragment fbFragment, GroupsFeedControllerResponder groupsFeedControllerResponder, boolean z, OnDrawListener onDrawListener) {
        this.f13881G = true;
        this.f13879E = groupsFeedPager;
        this.f13880F = z;
        fbFragment.a(this);
        Context context = view.getContext();
        if (this.f13877C == null) {
            this.f13877C = new LocalFbBroadcastManager(context).a().a("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED", new C14767(this)).a();
            this.f13877C.b();
        }
        this.f13878D = view.getContext().getResources().getString(2131239412);
        this.f13876B = groupsFeedControllerResponder;
        this.f13913z = view;
        this.f13911x = (FbSwipeRefreshLayout) this.f13913z.findViewById(2131561342);
        if (this.f13911x == null) {
            this.f13882H = false;
            this.f13910w = (RefreshableListViewContainer) view.findViewById(2131558777);
        } else {
            this.f13882H = true;
        }
        this.f13902o.a("group_feed");
        if (m15528k(this)) {
            this.f13900m.a(this.f13902o);
        }
        this.f13875A = new ListViewProxy((BetterListView) this.f13913z.findViewById(2131558776));
        this.f13875A.b(0);
        this.f13875A.k();
        this.f13875A.b(false);
        this.f13875A.d(true);
        this.f13875A.f(view.findViewById(16908292));
        if (onDrawListener != null) {
            this.f13875A.b(onDrawListener);
        }
        this.f13876B.m15548a(view);
        this.f13912y = (GenericNotificationBanner) view.findViewById(2131560231);
        m15529n();
        GroupsFeedControllerResponder groupsFeedControllerResponder2 = this.f13876B;
        this.f13875A.d();
        this.f13906s = groupsFeedControllerResponder2.m15553l();
        groupsFeedControllerResponder2 = this.f13876B;
        this.f13875A.d();
        this.f13907t = groupsFeedControllerResponder2.m15554m();
        this.f13909v = this.f13876B.m15546a(this.f13875A.d());
        this.f13908u = this.f13876B.m15547a((ListItemCollection) feedUnitCollection, this.f13909v);
        m15525a(feedUnitCollection);
    }

    public final void m15536b(boolean z) {
        this.f13883I = this.f13879E.m15574h();
        GroupsFeedControllerResponder groupsFeedControllerResponder = this.f13876B;
        boolean z2 = this.f13883I;
        boolean z3 = this.f13875A.n() && !z;
        groupsFeedControllerResponder.m15549a(z2, z3);
        if (!this.f13879E.m15574h()) {
            if (m15530p()) {
                if (this.f13882H) {
                    this.f13911x.setRefreshing(false);
                } else {
                    this.f13910w.f();
                }
            }
            Object obj = null;
            for (int i = 0; i < this.f13908u.getCount(); i++) {
                FeedUnit c = ((BoundedAdapter) this.f13908u.getItem(i)).c();
                if ((c instanceof GraphQLStory) && ((GraphQLStory) c).o() == StoryVisibility.VISIBLE) {
                    obj = 1;
                    break;
                }
            }
            if (obj == null) {
                m15526a(true, false);
            } else {
                m15526a(false, false);
            }
        } else if (!this.f13875A.n() || !z) {
            if (m15530p()) {
                Object obj2 = null;
                if (!(this.f13913z == null || this.f13913z.findViewById(2131558775) == null || this.f13913z.findViewById(2131558775).getVisibility() != 0)) {
                    obj2 = 1;
                }
                if (obj2 == null && !this.f13882H) {
                    this.f13910w.d();
                }
            }
            if (this.f13875A.n()) {
                m15526a(false, true);
            }
        } else if (m15530p() && !this.f13882H) {
            this.f13910w.e();
        }
    }

    public static boolean m15528k(GroupsFeedController groupsFeedController) {
        return ((TriState) groupsFeedController.f13885K.get()).equals(TriState.YES);
    }

    public final BetterListView m15540e() {
        return this.f13875A.d();
    }

    public final void m15542f() {
        if (this.f13895h.d() && this.f13913z != null) {
            AnimatedNotificationBanner animatedNotificationBanner = (AnimatedNotificationBanner) this.f13913z.findViewById(2131560231);
            if (animatedNotificationBanner != null) {
                animatedNotificationBanner.a(this.f13878D, true);
            }
        }
    }

    public final void m15534b(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 1758:
                    FeedEditPostController feedEditPostController = this.f13890c;
                    EditPostParams editPostParams = (EditPostParams) intent.getParcelableExtra("publishEditPostParamsKey");
                    if (editPostParams != null) {
                        GraphQLStory graphQLStory;
                        GraphQLStory b;
                        Flattenable flattenable;
                        feedEditPostController.f11942a.c(intent);
                        if (editPostParams.cacheIds != null && !editPostParams.cacheIds.isEmpty()) {
                            List list = null;
                            ImmutableList immutableList = editPostParams.cacheIds;
                            int size = immutableList.size();
                            int i3 = 0;
                            while (i3 < size) {
                                list = feedEditPostController.f11945d.d((String) immutableList.get(i3));
                                if (list == null || list.isEmpty()) {
                                    i3++;
                                } else if (!(list == null || list.isEmpty())) {
                                    graphQLStory = (GraphQLStory) ((GraphQLFeedUnitEdge) list.get(0)).c();
                                }
                            }
                            graphQLStory = (GraphQLStory) ((GraphQLFeedUnitEdge) list.get(0)).c();
                            break;
                        }
                        b = feedEditPostController.f11945d.b(editPostParams.legacyStoryApiId);
                        if (b == null) {
                            BLog.b(FeedEditPostController.class, "Original story couldn't be retrieved. LegacyStoryApiId : %s", new Object[]{editPostParams.legacyStoryApiId});
                        } else {
                            graphQLStory = b;
                        }
                        if (editPostParams.productItemAttachment != null) {
                            flattenable = (GraphQLStory) feedEditPostController.f11943b.a(graphQLStory, editPostParams.productItemAttachment, true).a;
                        } else {
                            b = (GraphQLStory) feedEditPostController.f11943b.a(graphQLStory, editPostParams.message, true).a;
                        }
                        feedEditPostController.f11945d.a(StoryProps.d(feedEditPostController.f11943b.a(FeedProps.c(flattenable), StoryVisibility.GONE)));
                        FeedEditPostController.m14031b(feedEditPostController);
                        C12821 c12821 = new C12821(feedEditPostController, graphQLStory, editPostParams);
                        if (feedEditPostController.f11948g != null) {
                            feedEditPostController.f11948g.c();
                        }
                        feedEditPostController.f11948g = feedEditPostController.f11944c.a().a("com.facebook.STREAM_PUBLISH_COMPLETE", c12821).a();
                        feedEditPostController.f11948g.b();
                    }
                    return;
                case 5002:
                    ((PlacePickerResultHandler) this.f13901n.get()).a(intent);
                    return;
                default:
                    return;
            }
        }
    }

    protected final void m15543g() {
        m15529n();
        this.f13876B.m15552f();
    }

    private void m15529n() {
        if (this.f13876B != null && this.f13912y != null && !this.f13876B.m15550a(this.f13895h, this.f13912y) && this.f13875A != null) {
            if (this.f13895h.d()) {
                this.f13912y.a();
            } else {
                this.f13912y.a(NotificationBannerType.NO_CONNECTION);
            }
        }
    }

    @SuppressLint({"DeprecatedMethod"})
    @TargetApi(16)
    private void m15525a(FeedUnitCollection feedUnitCollection) {
        BaseAdapter mergingAdapter;
        this.f13875A.b(new C14701(this));
        if (this.f13906s != null && this.f13907t != null) {
            mergingAdapter = new MergingAdapter(this.f13906s, this.f13907t);
        } else if (this.f13906s != null) {
            mergingAdapter = this.f13906s;
        } else {
            mergingAdapter = null;
        }
        if (mergingAdapter != null) {
            this.f13905r = new MergingStickyHeaderAdapter(mergingAdapter, (BaseAdapter) this.f13908u);
            this.f13875A.a(this.f13905r);
        } else {
            this.f13875A.a(this.f13908u);
        }
        this.f13875A.a(this.f13898k.a());
        if (this.f13882H) {
            this.f13911x.e = new C14712(this);
        } else if (this.f13910w != null) {
            this.f13910w.setOnRefreshListener(new C14723(this));
            this.f13910w.c().getViewTreeObserver().addOnGlobalLayoutListener(new C14734(this));
        }
        FeedOnDataChangeListener c14745 = new C14745(this);
        this.f13888a.m14042a(feedUnitCollection.a, c14745);
        this.f13889b.m14049a(feedUnitCollection.a, c14745);
        this.f13890c.m14032a(feedUnitCollection.a, c14745);
        this.f13891d.m14028a(feedUnitCollection.a, c14745);
        this.f13892e.m14056a(feedUnitCollection.a, c14745);
        this.f13894g.m14061a(feedUnitCollection.a, c14745);
        this.f13903p.a(this.f13893f);
        this.f13903p.a(this.f13904q);
        this.f13899l.a(feedUnitCollection, new C14756(this));
        GroupsFeedPager groupsFeedPager = this.f13879E;
        groupsFeedPager.f13938r = false;
        groupsFeedPager.f13939s = true;
        GroupsFeedPager.m15567k(groupsFeedPager);
        groupsFeedPager.f13925e.a(groupsFeedPager.f13930j, new IntentFilter("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED"));
        groupsFeedPager.f13929i.m15474a();
        groupsFeedPager.f13928h.m15474a();
        groupsFeedPager.f13939s = false;
    }

    public final void m15544h() {
        this.f13908u.notifyDataSetChanged();
        FeedUnitCollection feedUnitCollection = this.f13879E.f13923c;
        this.f13899l.a(feedUnitCollection.d.a());
        this.f13899l.a(feedUnitCollection);
    }

    private boolean m15530p() {
        if (this.f13882H) {
            if (this.f13911x != null) {
                return true;
            }
            return false;
        } else if (this.f13910w == null || this.f13910w.c().getHeight() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    private void m15526a(boolean z, boolean z2) {
        int i = 0;
        if (this.f13880F && this.f13913z != null) {
            View findViewById = this.f13913z.findViewById(2131561172);
            if (findViewById != null) {
                View findViewById2 = this.f13913z.findViewById(2131558776);
                View findViewById3 = this.f13913z.findViewById(2131558775);
                int i2 = (z2 && this.f13895h.d()) ? 0 : 8;
                findViewById3.setVisibility(i2);
                if (z) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                findViewById.setVisibility(i2);
                if (z || z2) {
                    i = 8;
                }
                findViewById2.setVisibility(i);
            }
        }
    }

    public final void m15545i() {
        m15538c(false);
    }

    public final void m15538c(boolean z) {
        this.f13879E.m15571a(z);
    }

    public final void m15537c(Fragment fragment) {
        if (m15528k(this)) {
            this.f13900m.c(this.f13875A);
        }
    }

    public final void m15539d(Fragment fragment) {
        if (m15528k(this)) {
            this.f13900m.a(true, this.f13875A);
        }
        this.f13908u.notifyDataSetChanged();
        this.f13896i.a();
        this.f13899l.d();
    }

    public final void m15531a(Fragment fragment, View view, Bundle bundle) {
        super.a(fragment, view, bundle);
        this.f13881G = true;
    }

    public final void m15535b(Fragment fragment) {
        super.b(fragment);
        this.f13881G = false;
    }

    public final void m15541e(Fragment fragment) {
        this.f13888a.m14041a();
        this.f13889b.m14048a();
        FeedEditPostController feedEditPostController = this.f13890c;
        if (feedEditPostController.f11947f != null) {
            feedEditPostController.f11947f.a(false);
            feedEditPostController.f11947f = null;
        }
        if (feedEditPostController.f11948g != null) {
            feedEditPostController.f11948g.c();
        }
        this.f13891d.m14027a();
        this.f13892e.m14055a();
        this.f13903p.b(this.f13904q);
        this.f13899l.e();
        this.f13894g.m14060a();
        if (this.f13911x != null) {
            this.f13911x.e = null;
            this.f13911x = null;
        }
        if (this.f13877C != null) {
            this.f13877C.c();
            this.f13877C = null;
        }
    }
}
