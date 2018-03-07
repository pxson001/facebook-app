package com.facebook.friendlist.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.EditText;
import android.widget.Filter.FilterListener;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.friendlist.constants.FriendListSource;
import com.facebook.friendlist.constants.FriendListType;
import com.facebook.friendlist.data.FriendListLoader;
import com.facebook.friendlist.data.FriendListLoaderProvider;
import com.facebook.friendlist.data.FriendListLoaderResult;
import com.facebook.friendlist.data.FriendPageListItemModel;
import com.facebook.friendlist.listadapter.FriendListController;
import com.facebook.friendlist.listadapter.FriendListItemRenderer;
import com.facebook.friendlist.listadapter.FriendListItemRendererProvider;
import com.facebook.friendlist.listadapter.FriendListModel;
import com.facebook.friendlist.listadapter.ProfileFriendListBinderProvider;
import com.facebook.friendlist.logging.FriendListAnalyticsLogger;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.friends.events.FriendingEvents.PYMKBlacklistedEvent;
import com.facebook.friends.events.FriendingEvents.SubscribeStatusChangedEvent;
import com.facebook.friends.events.FriendingEvents.UserBlockedEvent;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.timeline.event.TimelineVisitedEvent;
import com.facebook.timeline.event.TimelineVisitedEventBus;
import com.facebook.timeline.event.TimelineVisitedEventSubscriber;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.compositeadapter.stickyheader.StickyHeaderCompositeAdapter;
import com.facebook.widget.listview.BetterListView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: activity_stack_depth */
public abstract class FriendListFragment extends FbFragment {
    protected BetterListView f20308a;
    private boolean aA = false;
    public boolean aB = false;
    public boolean aC = false;
    public boolean aD = false;
    public boolean aE = false;
    public int aF = 0;
    public FilterListener aG;
    private TextWatcher aH;
    private FriendshipStatusChangedEventSubscriber aI;
    private SubscribeStatusChangedEventSubscriber aJ;
    private UserBlockedEventSubscriber aK;
    @Nullable
    private com.facebook.friends.events.FriendingEvents.PYMKBlacklistedEventSubscriber aL;
    private TimelineVisitedEventSubscriber aM;
    @Inject
    GraphQLCacheManager al;
    @Inject
    InputMethodManager am;
    @Inject
    QeAccessor an;
    @Inject
    public TasksManager ao;
    @Inject
    TimelineVisitedEventBus ap;
    public View aq;
    public View ar;
    public View as;
    public EditText at;
    public View au;
    private FriendListLoader av;
    public StickyHeaderCompositeAdapter<Object> aw;
    public DefaultPageInfoFieldsModel ax;
    public String ay;
    public QuickPerformanceLogger az;
    protected View f20309b;
    @Inject
    @LoggedInUserId
    String f20310c;
    @Inject
    FriendingEventBus f20311d;
    @Inject
    FriendListAnalyticsLogger f20312e;
    @Inject
    FriendListController f20313f;
    @Inject
    FriendListItemRendererProvider f20314g;
    @Inject
    FriendListLoaderProvider f20315h;
    @Inject
    FriendListModel f20316i;

    /* compiled from: activity_stack_depth */
    class C28981 implements OnTouchListener {
        final /* synthetic */ FriendListFragment f20318a;

        C28981(FriendListFragment friendListFragment) {
            this.f20318a = friendListFragment;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.f20318a.f20312e.m20676a(this.f20318a.ay);
            }
            return false;
        }
    }

    /* compiled from: activity_stack_depth */
    class C28992 implements OnFocusChangeListener {
        final /* synthetic */ FriendListFragment f20319a;

        C28992(FriendListFragment friendListFragment) {
            this.f20319a = friendListFragment;
        }

        public void onFocusChange(View view, boolean z) {
            FriendListFragment.ay(this.f20319a);
        }
    }

    /* compiled from: activity_stack_depth */
    class C29003 implements OnClickListener {
        final /* synthetic */ FriendListFragment f20320a;

        C29003(FriendListFragment friendListFragment) {
            this.f20320a = friendListFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 727395730);
            this.f20320a.at.setText("");
            Logger.a(2, EntryType.UI_INPUT_END, -129701797, a);
        }
    }

    /* compiled from: activity_stack_depth */
    class C29014 implements FilterListener {
        final /* synthetic */ FriendListFragment f20321a;

        C29014(FriendListFragment friendListFragment) {
            this.f20321a = friendListFragment;
        }

        public void onFilterComplete(int i) {
            AdapterDetour.a(this.f20321a.aw, -1304387143);
        }
    }

    /* compiled from: activity_stack_depth */
    class C29025 implements OnScrollListener {
        final /* synthetic */ FriendListFragment f20322a;

        C29025(FriendListFragment friendListFragment) {
            this.f20322a = friendListFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            FriendListFragment.ay(this.f20322a);
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i2 > 0) {
                int i4;
                int i5 = i + i2;
                if (i5 == i3) {
                    i5 -= this.f20322a.f20308a.getFooterViewsCount();
                }
                FriendListFragment friendListFragment = this.f20322a;
                int i6 = this.f20322a.aF;
                FriendListModel friendListModel = this.f20322a.f20316i;
                if (!friendListModel.f20390d || friendListModel.m20665d()) {
                    i4 = 0;
                } else {
                    i4 = friendListModel.getSectionForPosition(i5) + 1;
                }
                friendListFragment.aF = Math.max(i6, i5 - i4);
            }
            if (this.f20322a.as() && (i + i2) + 8 >= i3) {
                FriendListFragment.at(this.f20322a);
            }
        }
    }

    /* compiled from: activity_stack_depth */
    class C29036 implements TextWatcher {
        final /* synthetic */ FriendListFragment f20323a;

        C29036(FriendListFragment friendListFragment) {
            this.f20323a = friendListFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (StringUtil.a(charSequence)) {
                this.f20323a.au.setVisibility(8);
            } else {
                this.f20323a.au.setVisibility(0);
            }
            this.f20323a.f20316i.getFilter().filter(charSequence, this.f20323a.aG);
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: activity_stack_depth */
    class C29047 implements OnDrawListener {
        final /* synthetic */ FriendListFragment f20324a;

        C29047(FriendListFragment friendListFragment) {
            this.f20324a = friendListFragment;
        }

        public final boolean gD_() {
            if (!this.f20324a.aB || !this.f20324a.aC) {
                return false;
            }
            this.f20324a.az.b(this.f20324a.ar(), (short) 2);
            return true;
        }
    }

    /* compiled from: activity_stack_depth */
    public class C29069 extends AbstractDisposableFutureCallback<FriendListLoaderResult> {
        final /* synthetic */ FriendListFragment f20327a;

        public C29069(FriendListFragment friendListFragment) {
            this.f20327a = friendListFragment;
        }

        protected final void m20599a(Object obj) {
            FriendListLoaderResult friendListLoaderResult = (FriendListLoaderResult) obj;
            boolean z = true;
            Preconditions.checkNotNull(friendListLoaderResult);
            this.f20327a.ax = friendListLoaderResult.f20298b;
            if (this.f20327a.D()) {
                this.f20327a.aE = true;
            }
            if (!this.f20327a.aC) {
                this.f20327a.aC = true;
                this.f20327a.aD = true;
                if (!(friendListLoaderResult.f20297a == null || friendListLoaderResult.f20297a.isEmpty())) {
                    z = false;
                }
                if (z) {
                    if (this.f20327a.D()) {
                        this.f20327a.az.b(this.f20327a.ar(), (short) 2);
                    }
                    this.f20327a.f20308a.e();
                }
            }
            if (this.f20327a.f20308a.getEmptyView() == null) {
                this.f20327a.f20308a.setEmptyView(this.f20327a.aq.findViewById(16908292));
            }
            FriendListFragment.m20585a(this.f20327a, friendListLoaderResult.f20297a);
        }

        protected final void m20600a(Throwable th) {
            if (!this.f20327a.aC) {
                this.f20327a.aC = true;
                this.f20327a.aD = false;
                if (this.f20327a.D()) {
                    this.f20327a.az.b(this.f20327a.ar(), (short) 3);
                }
                this.f20327a.f20308a.e();
            }
            if (!this.f20327a.ax.c()) {
                if (this.f20327a.ar == null) {
                    FriendListFragment friendListFragment = this.f20327a;
                    if (friendListFragment.ar == null) {
                        friendListFragment.ar = friendListFragment.aq.findViewById(2131562318);
                        if (friendListFragment.ar == null) {
                            friendListFragment.ar = ((ViewStub) friendListFragment.aq.findViewById(2131562317)).inflate();
                        }
                        friendListFragment.ar.setOnClickListener(new OnClickListener(friendListFragment) {
                            final /* synthetic */ FriendListFragment f20317a;

                            {
                                this.f20317a = r1;
                            }

                            public void onClick(View view) {
                                int a = Logger.a(2, EntryType.UI_INPUT_START, 1501818126);
                                this.f20317a.ar.setVisibility(8);
                                FriendListFragment.at(this.f20317a);
                                Logger.a(2, EntryType.UI_INPUT_END, 1154384554, a);
                            }
                        });
                    }
                }
                this.f20327a.ar.setVisibility(0);
            }
        }
    }

    /* compiled from: activity_stack_depth */
    class FriendshipStatusChangedEventSubscriber extends com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEventSubscriber {
        final /* synthetic */ FriendListFragment f20328a;

        public FriendshipStatusChangedEventSubscriber(FriendListFragment friendListFragment) {
            this.f20328a = friendListFragment;
        }

        public final void m20601b(FbEvent fbEvent) {
            FriendshipStatusChangedEvent friendshipStatusChangedEvent = (FriendshipStatusChangedEvent) fbEvent;
            if (friendshipStatusChangedEvent != null && this.f20328a.aw != null) {
                FriendPageListItemModel friendPageListItemModel = (FriendPageListItemModel) this.f20328a.f20316i.m20663c().get(Long.valueOf(friendshipStatusChangedEvent.a));
                if (friendPageListItemModel == null) {
                    return;
                }
                if (friendshipStatusChangedEvent.b != friendPageListItemModel.m20582f()) {
                    FriendListFragment.m20586a(this.f20328a, String.valueOf(friendshipStatusChangedEvent.a));
                    friendPageListItemModel.m20578b(friendshipStatusChangedEvent.b);
                    AdapterDetour.a(this.f20328a.aw, -1616988912);
                } else if (friendshipStatusChangedEvent.b == GraphQLFriendshipStatus.ARE_FRIENDS) {
                    AdapterDetour.a(this.f20328a.aw, 790313509);
                }
            }
        }
    }

    /* compiled from: activity_stack_depth */
    class PYMKBlacklistedEventSubscriber extends com.facebook.friends.events.FriendingEvents.PYMKBlacklistedEventSubscriber {
        final /* synthetic */ FriendListFragment f20329a;

        public PYMKBlacklistedEventSubscriber(FriendListFragment friendListFragment) {
            this.f20329a = friendListFragment;
        }

        public final void m20602b(FbEvent fbEvent) {
            PYMKBlacklistedEvent pYMKBlacklistedEvent = (PYMKBlacklistedEvent) fbEvent;
            if (pYMKBlacklistedEvent != null && this.f20329a.aw != null && ((FriendPageListItemModel) this.f20329a.f20316i.m20663c().get(Long.valueOf(pYMKBlacklistedEvent.a))) != null) {
                FriendListFragment.m20586a(this.f20329a, String.valueOf(pYMKBlacklistedEvent.a));
                this.f20329a.f20316i.m20658a(pYMKBlacklistedEvent.a);
                AdapterDetour.a(this.f20329a.aw, 80844288);
            }
        }
    }

    /* compiled from: activity_stack_depth */
    class SubscribeStatusChangedEventSubscriber extends com.facebook.friends.events.FriendingEvents.SubscribeStatusChangedEventSubscriber {
        final /* synthetic */ FriendListFragment f20330a;

        public SubscribeStatusChangedEventSubscriber(FriendListFragment friendListFragment) {
            this.f20330a = friendListFragment;
        }

        public final void m20603b(FbEvent fbEvent) {
            SubscribeStatusChangedEvent subscribeStatusChangedEvent = (SubscribeStatusChangedEvent) fbEvent;
            if (subscribeStatusChangedEvent != null && this.f20330a.aw != null) {
                FriendPageListItemModel friendPageListItemModel = (FriendPageListItemModel) this.f20330a.f20316i.m20663c().get(Long.valueOf(subscribeStatusChangedEvent.a));
                if (friendPageListItemModel != null && friendPageListItemModel.f20306h != subscribeStatusChangedEvent.b) {
                    FriendListFragment.m20586a(this.f20330a, String.valueOf(subscribeStatusChangedEvent.a));
                    friendPageListItemModel.f20306h = subscribeStatusChangedEvent.b;
                    AdapterDetour.a(this.f20330a.aw, -597514937);
                }
            }
        }
    }

    /* compiled from: activity_stack_depth */
    class TimelineVisitedEventSubscriberForFriendList extends TimelineVisitedEventSubscriber {
        final /* synthetic */ FriendListFragment f20331a;

        public TimelineVisitedEventSubscriberForFriendList(FriendListFragment friendListFragment) {
            this.f20331a = friendListFragment;
        }

        public final void m20604b(FbEvent fbEvent) {
            TimelineVisitedEvent timelineVisitedEvent = (TimelineVisitedEvent) fbEvent;
            if (timelineVisitedEvent != null && this.f20331a.aw != null) {
                FriendPageListItemModel friendPageListItemModel = (FriendPageListItemModel) this.f20331a.f20316i.m20663c().get(Long.valueOf(Long.parseLong(timelineVisitedEvent.b)));
                if (friendPageListItemModel != null && friendPageListItemModel.f20307i != 0) {
                    FriendListFragment.m20586a(this.f20331a, String.valueOf(timelineVisitedEvent.b));
                    friendPageListItemModel.f20307i = 0;
                    AdapterDetour.a(this.f20331a.aw, 1509428637);
                }
            }
        }
    }

    /* compiled from: activity_stack_depth */
    class UserBlockedEventSubscriber extends com.facebook.friends.events.FriendingEvents.UserBlockedEventSubscriber {
        final /* synthetic */ FriendListFragment f20332a;

        public UserBlockedEventSubscriber(FriendListFragment friendListFragment) {
            this.f20332a = friendListFragment;
        }

        public final void m20605b(FbEvent fbEvent) {
            UserBlockedEvent userBlockedEvent = (UserBlockedEvent) fbEvent;
            if (userBlockedEvent != null && this.f20332a.aw != null && ((FriendPageListItemModel) this.f20332a.f20316i.m20663c().get(Long.valueOf(userBlockedEvent.a))) != null) {
                FriendListFragment.m20586a(this.f20332a, String.valueOf(userBlockedEvent.a));
                this.f20332a.f20316i.m20658a(userBlockedEvent.a);
                AdapterDetour.a(this.f20332a.aw, -2041584173);
            }
        }
    }

    public static void m20587a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FriendListFragment) obj).m20588a(String_LoggedInUserIdMethodAutoProvider.b(injectorLike), FriendingEventBus.a(injectorLike), FriendListAnalyticsLogger.m20673a(injectorLike), FriendListController.m20645b(injectorLike), (FriendListItemRendererProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendListItemRendererProvider.class), (FriendListLoaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendListLoaderProvider.class), FriendListModel.m20653b(injectorLike), GraphQLCacheManager.a(injectorLike), InputMethodManagerMethodAutoProvider.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), TasksManager.b(injectorLike), TimelineVisitedEventBus.a(injectorLike));
    }

    abstract int aq();

    abstract int ar();

    abstract boolean as();

    abstract FriendListType mo905b();

    abstract FriendListSource mo906e();

    private void m20588a(String str, FriendingEventBus friendingEventBus, FriendListAnalyticsLogger friendListAnalyticsLogger, FriendListController friendListController, FriendListItemRendererProvider friendListItemRendererProvider, FriendListLoaderProvider friendListLoaderProvider, FriendListModel friendListModel, GraphQLCacheManager graphQLCacheManager, InputMethodManager inputMethodManager, QeAccessor qeAccessor, TasksManager tasksManager, TimelineVisitedEventBus timelineVisitedEventBus) {
        this.f20310c = str;
        this.f20311d = friendingEventBus;
        this.f20312e = friendListAnalyticsLogger;
        this.f20313f = friendListController;
        this.f20314g = friendListItemRendererProvider;
        this.f20315h = friendListLoaderProvider;
        this.f20316i = friendListModel;
        this.al = graphQLCacheManager;
        this.am = inputMethodManager;
        this.an = qeAccessor;
        this.ao = tasksManager;
        this.ap = timelineVisitedEventBus;
    }

    public final void m20594c(Bundle bundle) {
        super.c(bundle);
        this.aC = false;
        this.az = QuickPerformanceLoggerMethodAutoProvider.a(an());
        this.az.a(ar(), ImmutableList.of("profile_friends_page"));
        if (!this.aB && D()) {
            this.aB = true;
            this.az.b(ar());
        }
        Class cls = FriendListFragment.class;
        m20587a((Object) this, getContext());
    }

    public final View m20591a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1443949911);
        Builder builder = new Builder();
        builder.c = false;
        builder = builder;
        builder.b = true;
        this.ax = builder.a();
        this.f20309b = layoutInflater.inflate(2130904511, null);
        this.aq = layoutInflater.inflate(2130904510, viewGroup, false);
        this.aq.setId(aq());
        View view = this.aq;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -269428065, a);
        return view;
    }

    public final void m20592a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.ay = this.s.getString("com.facebook.katana.profile.id");
        Preconditions.checkNotNull(this.ay);
        FriendListLoaderProvider friendListLoaderProvider = this.f20315h;
        this.av = new FriendListLoader(GraphQLQueryExecutor.a(friendListLoaderProvider), (Clock) SystemClockMethodAutoProvider.a(friendListLoaderProvider), this.ay, mo905b());
        boolean equals = FriendListType.ALL_FRIENDS.equals(mo905b());
        this.f20316i.m20660a(equals);
        this.aw = new StickyHeaderCompositeAdapter(getContext(), this.f20316i, this.f20316i, new FriendListItemRenderer(getContext(), mo905b(), mo906e(), (ProfileFriendListBinderProvider) this.f20314g.getOnDemandAssistedProviderForStaticDi(ProfileFriendListBinderProvider.class)), this.f20313f);
        this.f20308a = (BetterListView) e(2131562319);
        av();
        this.f20308a.setAdapter(this.aw);
        this.f20308a.setStickyHeaderEnabled(equals);
        this.as = e(2131567301);
        this.at = (EditText) e(2131560492);
        this.at.setHint(2131241970);
        this.at.setOnTouchListener(new C28981(this));
        this.at.setOnFocusChangeListener(new C28992(this));
        if (!this.f20310c.equals(this.ay)) {
            this.at.setHint(az());
        }
        this.au = e(2131560324);
        this.au.setOnClickListener(new C29003(this));
        this.aG = new C29014(this);
        this.aI = new FriendshipStatusChangedEventSubscriber(this);
        this.aJ = new SubscribeStatusChangedEventSubscriber(this);
        this.aK = new UserBlockedEventSubscriber(this);
        this.f20311d.a(this.aI);
        this.f20311d.a(this.aJ);
        this.f20311d.a(this.aK);
        if (FriendListType.SUGGESTIONS.equals(mo905b())) {
            this.aL = new PYMKBlacklistedEventSubscriber(this);
            this.f20311d.a(this.aL);
        }
        this.aM = new TimelineVisitedEventSubscriberForFriendList(this);
        this.ap.a(this.aM);
        this.f20308a.setOnScrollListener(new C29025(this));
        this.aH = new C29036(this);
        this.at.addTextChangedListener(this.aH);
        this.f20308a.setOnDrawListenerTo(new C29047(this));
        at(this);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1138895796);
        this.ao.c();
        if (this.aE) {
            this.f20312e.m20675a(mo905b(), this.aF, this.ay);
        }
        this.f20308a.setOnScrollListener(null);
        this.f20308a.e();
        this.at.setOnTouchListener(null);
        this.at.setOnFocusChangeListener(null);
        this.at.removeTextChangedListener(this.aH);
        this.aq = null;
        this.f20308a = null;
        this.f20309b = null;
        this.ar = null;
        this.as = null;
        this.at = null;
        this.au = null;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 682905271, a);
    }

    public final void m20590I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1500389266);
        this.f20311d.b(this.aI);
        this.f20311d.b(this.aJ);
        this.f20311d.b(this.aK);
        this.f20311d.b(this.aL);
        this.ap.b(this.aM);
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 946349243, a);
    }

    public final void m20596g(boolean z) {
        super.g(z);
        if (z) {
            if (!this.aB) {
                this.aB = true;
                this.az.b(ar());
            }
            if (this.aC) {
                this.az.b(ar(), this.aD ? (short) 2 : (short) 3);
            }
            if (this.f20316i != null && this.f20316i.m20656a() > 0) {
                this.aE = true;
            }
        } else if (this.aA) {
            this.az.d(ar());
        } else {
            this.aA = true;
        }
    }

    public static Bundle m20589b(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.katana.profile.id", str);
        bundle.putString("profile_name", str2);
        bundle.putString("first_name", str3);
        return bundle;
    }

    public static void at(FriendListFragment friendListFragment) {
        if (friendListFragment.ax.b() && !friendListFragment.ao.a()) {
            final ListenableFuture a = friendListFragment.av.m20574a(friendListFragment.ax.a());
            friendListFragment.ao.a("load_friend_list", new Callable<ListenableFuture<FriendListLoaderResult>>(friendListFragment) {
                final /* synthetic */ FriendListFragment f20326b;

                public Object call() {
                    return a;
                }
            }, new C29069(friendListFragment));
        }
    }

    public static void m20585a(FriendListFragment friendListFragment, ImmutableList immutableList) {
        if (friendListFragment.ax == null) {
            Builder builder = new Builder();
            builder.c = false;
            builder = builder;
            builder.b = false;
            friendListFragment.ax = builder.a();
            friendListFragment.aw();
            return;
        }
        friendListFragment.f20316i.m20659a((List) immutableList);
        AdapterDetour.a(friendListFragment.aw, 1694019570);
        friendListFragment.f20316i.getFilter().filter(friendListFragment.at.getText(), friendListFragment.aG);
        if (!(friendListFragment.ax.b() && friendListFragment.as())) {
            friendListFragment.aw();
        }
        if (friendListFragment.f20316i.m20665d() || friendListFragment.f20316i.m20656a() > 0) {
            if (friendListFragment.as != null) {
                friendListFragment.as.setVisibility(0);
            }
        }
    }

    private void av() {
        if (this.f20308a != null && this.f20309b != null) {
            this.f20308a.addFooterView(this.f20309b, null, false);
        }
    }

    private void aw() {
        if (this.f20308a != null && this.f20309b != null) {
            this.f20308a.removeFooterView(this.f20309b);
        }
    }

    public static void ay(FriendListFragment friendListFragment) {
        if (friendListFragment.am != null && friendListFragment.at != null) {
            friendListFragment.am.hideSoftInputFromWindow(friendListFragment.at.getWindowToken(), 0);
        }
    }

    private String az() {
        Bundle bundle = this.s;
        String string = bundle.getString("first_name");
        String string2 = bundle.getString("profile_name");
        if (string != null) {
            return a(2131241971, new Object[]{string});
        } else if (string2 == null) {
            return b(2131241972);
        } else {
            return a(2131241971, new Object[]{string2});
        }
    }

    public static void m20586a(FriendListFragment friendListFragment, String str) {
        Set hashSet = new HashSet();
        hashSet.add(friendListFragment.f20310c);
        hashSet.add(str);
        hashSet.add(friendListFragment.ay);
        friendListFragment.al.a(hashSet);
    }
}
