package com.facebook.friending.center.tabs.search;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.friending.center.constants.FriendsCenterTabType;
import com.facebook.friending.center.fetcher.FriendsCenterSearchFetcher;
import com.facebook.friending.center.fetcher.FriendsCenterSearchFetcher.C28101;
import com.facebook.friending.center.logging.FriendsCenterAnalyticsLogger;
import com.facebook.friending.center.logging.FriendsCenterPerfLogger;
import com.facebook.friending.center.logging.FriendsCenterPerfLoggerProvider;
import com.facebook.friending.center.model.FriendsCenterListItemModel;
import com.facebook.friending.center.protocol.FriendsCenterDefaultFieldsGraphQLModels.FriendsCenterDefaultNodeModel;
import com.facebook.friending.center.protocol.FriendsCenterDefaultFieldsGraphQLModels.FriendsCenterDefaultNodeModel.MutualFriendsModel;
import com.facebook.friending.center.protocol.FriendsCenterSearchFriendsGraphQL.FriendsCenterSearchFriendsQueryString;
import com.facebook.friending.center.ui.FriendsCenterListAdapter;
import com.facebook.friending.common.list.model.FriendListItemModel;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEventSubscriber;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.keyboard.SmoothKeyboardFragmentBehavior;
import com.facebook.ui.search.SearchEditText;
import com.facebook.ui.search.SearchEditText.OnSubmitListener;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.ScrollableListContainer;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: add_sticker_pack */
public class FriendsCenterSearchFragment extends FbFragment implements AnalyticsFragment, ScrollableListContainer {
    public static final CallerContext am = CallerContext.a(FriendsCenterSearchFragment.class);
    @Inject
    public FriendsCenterListAdapter f20101a;
    public String aA;
    public long aB;
    public int aC = 0;
    @Inject
    public FriendsCenterAnalyticsLogger al;
    private final FriendshipStatusChangedEventSubscriber an = new C28381(this);
    public FriendsCenterPerfLogger ao;
    public boolean ap;
    private boolean aq = false;
    private boolean ar = false;
    public SearchEditText as;
    public BetterListView at;
    public View au;
    public TextView av;
    public ImageButton aw;
    private ImageView ax;
    public Map<Long, FriendsCenterListItemModel> ay;
    private TextWatcher az;
    @Inject
    TasksManager f20102b;
    @Inject
    FriendsCenterSearchFetcher f20103c;
    @Inject
    FriendingEventBus f20104d;
    @Inject
    FbUriIntentHandler f20105e;
    @Inject
    FriendsCenterPerfLoggerProvider f20106f;
    @Inject
    public MonotonicClock f20107g;
    @Inject
    GlyphColorizer f20108h;
    @Inject
    DefaultAndroidThreadUtil f20109i;

    /* compiled from: add_sticker_pack */
    class C28381 extends FriendshipStatusChangedEventSubscriber {
        final /* synthetic */ FriendsCenterSearchFragment f20091a;

        C28381(FriendsCenterSearchFragment friendsCenterSearchFragment) {
            this.f20091a = friendsCenterSearchFragment;
        }

        public final void m20412b(FbEvent fbEvent) {
            FriendshipStatusChangedEvent friendshipStatusChangedEvent = (FriendshipStatusChangedEvent) fbEvent;
            if (friendshipStatusChangedEvent != null && friendshipStatusChangedEvent.b != null && !friendshipStatusChangedEvent.c) {
                FriendListItemModel friendListItemModel = (FriendListItemModel) this.f20091a.ay.get(Long.valueOf(friendshipStatusChangedEvent.a));
                if (friendListItemModel != null && friendListItemModel.f() != friendshipStatusChangedEvent.b) {
                    friendListItemModel.b(friendshipStatusChangedEvent.b);
                    AdapterDetour.a(this.f20091a.f20101a, 1917188133);
                }
            }
        }
    }

    /* compiled from: add_sticker_pack */
    class C28392 implements Runnable {
        final /* synthetic */ FriendsCenterSearchFragment f20092a;

        C28392(FriendsCenterSearchFragment friendsCenterSearchFragment) {
            this.f20092a = friendsCenterSearchFragment;
        }

        public void run() {
            this.f20092a.as.setText(this.f20092a.aA);
        }
    }

    /* compiled from: add_sticker_pack */
    class C28403 implements Callable<ListenableFuture<ImmutableList<FriendsCenterDefaultNodeModel>>> {
        final /* synthetic */ FriendsCenterSearchFragment f20093a;

        C28403(FriendsCenterSearchFragment friendsCenterSearchFragment) {
            this.f20093a = friendsCenterSearchFragment;
        }

        public Object call() {
            FriendsCenterSearchFetcher friendsCenterSearchFetcher = this.f20093a.f20103c;
            CallerContext callerContext = FriendsCenterSearchFragment.am;
            String str = this.f20093a.aA;
            Preconditions.checkNotNull(callerContext, "You must provide a caller context");
            GraphQlQueryString friendsCenterSearchFriendsQueryString = new FriendsCenterSearchFriendsQueryString();
            friendsCenterSearchFriendsQueryString.a("query_param", str).a("after_param", friendsCenterSearchFetcher.f19978a.a()).a("first_param", String.valueOf(20));
            GraphQLRequest a = GraphQLRequest.a(friendsCenterSearchFriendsQueryString).a(GraphQLCachePolicy.c);
            a.f = callerContext;
            return Futures.a(friendsCenterSearchFetcher.f19979b.a(a), new C28101(friendsCenterSearchFetcher), friendsCenterSearchFetcher.f19980c);
        }
    }

    /* compiled from: add_sticker_pack */
    class C28414 extends AbstractDisposableFutureCallback<ImmutableList<FriendsCenterDefaultNodeModel>> {
        final /* synthetic */ FriendsCenterSearchFragment f20094a;

        C28414(FriendsCenterSearchFragment friendsCenterSearchFragment) {
            this.f20094a = friendsCenterSearchFragment;
        }

        protected final void m20413a(Object obj) {
            ImmutableList immutableList = (ImmutableList) obj;
            if (!(this.f20094a.ap || this.f20094a.ao == null)) {
                this.f20094a.ao.m20164a();
                this.f20094a.ap = true;
            }
            if (!this.f20094a.f20103c.m20148a()) {
                this.f20094a.f20101a.m20459a(false);
            }
            if (immutableList.isEmpty()) {
                FriendsCenterSearchFragment.aq(this.f20094a);
                return;
            }
            Builder builder = new Builder();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                FriendsCenterDefaultNodeModel friendsCenterDefaultNodeModel = (FriendsCenterDefaultNodeModel) immutableList.get(i);
                long parseLong = Long.parseLong(friendsCenterDefaultNodeModel.m20200k());
                if (!this.f20094a.ay.containsKey(Long.valueOf(parseLong))) {
                    String b;
                    int a;
                    DefaultImageFieldsModel n = friendsCenterDefaultNodeModel.m20203n();
                    MutualFriendsModel l = friendsCenterDefaultNodeModel.m20201l();
                    FriendsCenterListItemModel.Builder builder2 = new FriendsCenterListItemModel.Builder();
                    builder2.f19993a = parseLong;
                    builder2 = builder2;
                    if (n != null) {
                        b = n.b();
                    } else {
                        b = null;
                    }
                    builder2.f19994b = b;
                    FriendsCenterListItemModel.Builder builder3 = builder2;
                    builder3.f19995c = friendsCenterDefaultNodeModel.m20202m();
                    builder2 = builder3;
                    if (l != null) {
                        a = l.m20188a();
                    } else {
                        a = 0;
                    }
                    builder2.f19996d = a;
                    builder3 = builder2;
                    builder3.f19997e = FriendingLocation.FRIENDS_CENTER_SEARCH;
                    builder3 = builder3;
                    builder3.f19998f = friendsCenterDefaultNodeModel.m20199j();
                    FriendsCenterListItemModel b2 = builder3.mo892b();
                    builder.c(b2);
                    this.f20094a.ay.put(Long.valueOf(parseLong), b2);
                }
            }
            this.f20094a.f20101a.m20488a(builder.b());
        }

        protected final void m20414a(Throwable th) {
            if (this.f20094a.ay.isEmpty()) {
                FriendsCenterSearchFragment.m20416a(this.f20094a, this.f20094a.b(2131230761));
                this.f20094a.aA = null;
            }
        }
    }

    /* compiled from: add_sticker_pack */
    public class C28425 implements OnSubmitListener {
        final /* synthetic */ FriendsCenterSearchFragment f20095a;

        public C28425(FriendsCenterSearchFragment friendsCenterSearchFragment) {
            this.f20095a = friendsCenterSearchFragment;
        }

        public final void m20415a() {
            FriendsCenterSearchFragment.at(this.f20095a);
        }
    }

    /* compiled from: add_sticker_pack */
    public class C28436 implements OnScrollListener {
        final /* synthetic */ FriendsCenterSearchFragment f20096a;

        public C28436(FriendsCenterSearchFragment friendsCenterSearchFragment) {
            this.f20096a = friendsCenterSearchFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                this.f20096a.as.c();
            }
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (((i + i2) + 3 >= i3 ? 1 : null) != null && !this.f20096a.f20101a.isEmpty()) {
                FriendsCenterSearchFragment.aq(this.f20096a);
            }
        }
    }

    /* compiled from: add_sticker_pack */
    public class C28447 implements OnItemClickListener {
        final /* synthetic */ FriendsCenterSearchFragment f20097a;

        public C28447(FriendsCenterSearchFragment friendsCenterSearchFragment) {
            this.f20097a = friendsCenterSearchFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            FriendsCenterSearchFragment.m20419g(this.f20097a, i);
        }
    }

    /* compiled from: add_sticker_pack */
    class C28468 implements TextWatcher {
        final /* synthetic */ FriendsCenterSearchFragment f20099a;

        /* compiled from: add_sticker_pack */
        class C28451 implements Runnable {
            final /* synthetic */ C28468 f20098a;

            C28451(C28468 c28468) {
                this.f20098a = c28468;
            }

            public void run() {
                FriendsCenterSearchFragment friendsCenterSearchFragment = this.f20098a.f20099a;
                if (friendsCenterSearchFragment.f20107g.now() >= friendsCenterSearchFragment.aB + 300) {
                    FriendsCenterSearchFragment.at(friendsCenterSearchFragment);
                }
            }
        }

        C28468(FriendsCenterSearchFragment friendsCenterSearchFragment) {
            this.f20099a = friendsCenterSearchFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.toString().trim().isEmpty()) {
                this.f20099a.aw.setVisibility(4);
                return;
            }
            if (this.f20099a.aw.getVisibility() == 4) {
                this.f20099a.aw.setVisibility(0);
            }
            this.f20099a.aB = this.f20099a.f20107g.now();
            this.f20099a.f20109i.b(new C28451(this), 300);
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: add_sticker_pack */
    class C28479 implements OnClickListener {
        final /* synthetic */ FriendsCenterSearchFragment f20100a;

        C28479(FriendsCenterSearchFragment friendsCenterSearchFragment) {
            this.f20100a = friendsCenterSearchFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1074720386);
            this.f20100a.as.a();
            this.f20100a.aw.setVisibility(4);
            Logger.a(2, EntryType.UI_INPUT_END, 839591463, a);
        }
    }

    public static void m20418a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FriendsCenterSearchFragment) obj).m20417a(FriendsCenterListAdapter.m20485b(injectorLike), TasksManager.b(injectorLike), new FriendsCenterSearchFetcher(GraphQLQueryExecutor.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike)), FriendingEventBus.a(injectorLike), FbUriIntentHandler.a(injectorLike), (FriendsCenterPerfLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendsCenterPerfLoggerProvider.class), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), GlyphColorizer.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), FriendsCenterAnalyticsLogger.m20155a(injectorLike));
    }

    public final void m20426c(Bundle bundle) {
        super.c(bundle);
        Class cls = FriendsCenterSearchFragment.class;
        m20418a((Object) this, getContext());
        a(new SmoothKeyboardFragmentBehavior());
        this.ay = Maps.c();
        this.ao = this.f20106f.m20168a(am_(), Integer.valueOf(3080202), "FriendCenterSearchTabTTI");
    }

    public final View m20424a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1543005524);
        View inflate = layoutInflater.inflate(2130904519, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1275938849, a);
        return inflate;
    }

    public final void m20425a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.as = (SearchEditText) e(2131562332);
        this.at = (BetterListView) e(2131562334);
        this.au = e(2131562324);
        this.av = (TextView) e(2131562325);
        this.aw = (ImageButton) e(2131562333);
        this.ax = (ImageView) e(2131562331);
        this.at.setEmptyView(e(16908292));
        this.at.setAdapter(this.f20101a);
        this.aB = 0;
        av();
        this.as.f = new C28425(this);
        this.at.setOnScrollListener(new C28436(this));
        this.at.setOnItemClickListener(new C28447(this));
        m20416a(this, null);
    }

    public final void m20421G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -469084692);
        super.G();
        this.ar = true;
        if (D()) {
            ay();
        }
        if (D() && this.f20101a.getCount() == 0) {
            this.as.b();
        }
        this.as.addTextChangedListener(this.az);
        this.f20104d.a(this.an);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1832025926, a);
    }

    public final void m20422H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -413637815);
        this.as.removeTextChangedListener(this.az);
        this.as.c();
        this.ar = false;
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 509598849, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -144938859);
        this.f20102b.c();
        this.at.setOnScrollListener(null);
        this.at.setOnItemClickListener(null);
        this.at = null;
        this.as.f = null;
        this.as = null;
        this.au = null;
        this.av = null;
        this.aw = null;
        this.ax = null;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -731568354, a);
    }

    public final void m20423I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 540889927);
        if (this.aq) {
            if (this.aC > 0) {
                this.al.m20162c(this.f20101a.f20127d);
                this.f20101a.f20127d = 0;
            }
            this.al.m20161b(this.aC);
        }
        this.f20104d.b(this.an);
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1581964304, a);
    }

    public final void m20427g(boolean z) {
        super.g(z);
        if (z) {
            ay();
        }
        if (this.as != null) {
            if (z && this.f20101a.getCount() == 0) {
                this.as.b();
                this.aq = true;
            } else {
                this.as.c();
            }
            if (z && !StringUtil.a(this.aA)) {
                this.as.post(new C28392(this));
            }
        }
    }

    public final void gB_() {
        this.at.setSelection(0);
    }

    public final boolean gC_() {
        return this.at.getFirstVisiblePosition() == 0;
    }

    @Nullable
    public final ScrollingViewProxy m20428n() {
        return this.at == null ? null : new ListViewProxy(this.at);
    }

    public final String am_() {
        return FriendsCenterTabType.SEARCH.analyticsTag;
    }

    public static void aq(FriendsCenterSearchFragment friendsCenterSearchFragment) {
        if (!friendsCenterSearchFragment.f20102b.a("SEARCH")) {
            if (friendsCenterSearchFragment.f20103c.m20148a()) {
                friendsCenterSearchFragment.ar();
            } else if (friendsCenterSearchFragment.ay.isEmpty()) {
                m20416a(friendsCenterSearchFragment, friendsCenterSearchFragment.b(2131239333));
            }
        }
    }

    private void ar() {
        this.f20101a.m20459a(true);
        this.f20102b.a("SEARCH", new C28403(this), new C28414(this));
    }

    public static void at(FriendsCenterSearchFragment friendsCenterSearchFragment) {
        friendsCenterSearchFragment.aC++;
        String trim = friendsCenterSearchFragment.as.getText().toString().trim();
        if (!StringUtil.a(trim) && !trim.equals(friendsCenterSearchFragment.aA)) {
            friendsCenterSearchFragment.au.setVisibility(0);
            friendsCenterSearchFragment.av.setVisibility(8);
            friendsCenterSearchFragment.aA = trim;
            friendsCenterSearchFragment.f20103c.f19978a = FriendsCenterSearchFetcher.m20147c();
            friendsCenterSearchFragment.f20102b.c();
            friendsCenterSearchFragment.ay.clear();
            FriendsCenterListAdapter friendsCenterListAdapter = friendsCenterSearchFragment.f20101a;
            friendsCenterListAdapter.f20172c.clear();
            AdapterDetour.a(friendsCenterListAdapter, 2070319932);
            friendsCenterSearchFragment.ap = false;
            friendsCenterSearchFragment.ao.m20165a(true);
            friendsCenterSearchFragment.ar();
        }
    }

    private void av() {
        this.ax.setVisibility(0);
        this.aw.setVisibility(4);
        this.ax.setImageDrawable(m20420h(2130839976));
        this.aw.setImageDrawable(m20420h(2130839815));
        this.az = new C28468(this);
        this.aw.setOnClickListener(new C28479(this));
    }

    public static void m20416a(FriendsCenterSearchFragment friendsCenterSearchFragment, String str) {
        friendsCenterSearchFragment.au.setVisibility(8);
        friendsCenterSearchFragment.av.setVisibility(0);
        friendsCenterSearchFragment.av.setText(str);
    }

    public static void m20419g(FriendsCenterSearchFragment friendsCenterSearchFragment, int i) {
        FriendsCenterListItemModel friendsCenterListItemModel = (FriendsCenterListItemModel) friendsCenterSearchFragment.f20101a.getItem(i);
        String a = StringFormatUtil.a(FBLinks.aX, new Object[]{Long.valueOf(friendsCenterListItemModel.m20172a())});
        Bundle bundle = new Bundle();
        bundle.putSerializable("timeline_friend_request_ref", FriendRequestMakeRef.FRIENDS_CENTER);
        ModelBundle.a(bundle, String.valueOf(friendsCenterListItemModel.m20172a()), friendsCenterListItemModel.m20177d(), friendsCenterListItemModel.m20174b(), null, null);
        friendsCenterSearchFragment.f20105e.a(friendsCenterSearchFragment.getContext(), a, bundle);
    }

    private void m20417a(FriendsCenterListAdapter friendsCenterListAdapter, TasksManager tasksManager, FriendsCenterSearchFetcher friendsCenterSearchFetcher, FriendingEventBus friendingEventBus, FbUriIntentHandler fbUriIntentHandler, FriendsCenterPerfLoggerProvider friendsCenterPerfLoggerProvider, MonotonicClock monotonicClock, GlyphColorizer glyphColorizer, DefaultAndroidThreadUtil defaultAndroidThreadUtil, FriendsCenterAnalyticsLogger friendsCenterAnalyticsLogger) {
        this.f20101a = friendsCenterListAdapter;
        this.f20102b = tasksManager;
        this.f20103c = friendsCenterSearchFetcher;
        this.f20104d = friendingEventBus;
        this.f20105e = fbUriIntentHandler;
        this.f20106f = friendsCenterPerfLoggerProvider;
        this.f20107g = monotonicClock;
        this.f20108h = glyphColorizer;
        this.f20109i = defaultAndroidThreadUtil;
        this.al = friendsCenterAnalyticsLogger;
    }

    private Drawable m20420h(int i) {
        return this.f20108h.a(i, -8421505);
    }

    private void ay() {
        if (this.ar) {
            HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
            if (hasTitleBar != null) {
                hasTitleBar.a_(b(2131233242));
                hasTitleBar.c(true);
                hasTitleBar.a(null);
            }
        }
    }
}
