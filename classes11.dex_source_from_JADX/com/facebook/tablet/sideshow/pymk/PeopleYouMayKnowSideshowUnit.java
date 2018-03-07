package com.facebook.tablet.sideshow.pymk;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendRequestCancelRef;
import com.facebook.friends.constants.FriendRequestHowFound;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.tablet.sideshow.analytics.SideshowAnalyticsLogger;
import com.facebook.tablet.sideshow.loader.SideshowLoader.1;
import com.facebook.tablet.sideshow.pymk.events.SideshowFriendingEvents.FriendRequestClickedEvent;
import com.facebook.tablet.sideshow.pymk.events.SideshowFriendingEvents.FriendRequestClickedEventSubscriber;
import com.facebook.tablet.sideshow.pymk.graphql.FetchPeopleYouMayKnowSideshow.FetchPeopleYouMayKnowSideshowString;
import com.facebook.tablet.sideshow.pymk.graphql.FetchPeopleYouMayKnowSideshowDataRequest;
import com.facebook.tablet.sideshow.pymk.graphql.FetchPeopleYouMayKnowSideshowDataRequest.C06451;
import com.facebook.tablet.sideshow.pymk.model.PeopleYouMayKnowDataHolder;
import com.facebook.tablet.sideshow.pymk.model.PeopleYouMayKnowDataHolder.C06461;
import com.facebook.tablet.sideshow.pymk.model.PeopleYouMayKnowRow;
import com.facebook.tablet.sideshow.pymk.ui.PeopleYouMayKnowListAdapter;
import com.facebook.tablet.sideshow.pymk.ui.PeopleYouMayKnowListAdapter.C06471;
import com.facebook.tablet.sideshow.widget.ActionContentViewSideshowUnit;
import com.facebook.tablet.sideshow.widget.SideshowExpandableListView;
import com.facebook.tablet.sideshow.widget.SideshowExpandableListView.OnItemClickedListener;
import com.facebook.tablet.sideshow.widget.SideshowUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: onLoadStart */
public class PeopleYouMayKnowSideshowUnit extends ActionContentViewSideshowUnit {
    public PeopleYouMayKnowListAdapter f4724b;
    private PeopleYouMayKnowDataHolder f4725c;
    public SideshowAnalyticsLogger f4726d;
    public SecureContextHelper f4727e;
    public UriIntentMapper f4728f;
    public FriendingClient f4729g;
    public FbEventSubscriberListManager f4730h;
    private FeedEventBus f4731i;
    public DefaultAndroidThreadUtil f4732j;

    /* compiled from: onLoadStart */
    public class C06422 extends FriendRequestClickedEventSubscriber {
        final /* synthetic */ PeopleYouMayKnowSideshowUnit f4719a;

        public C06422(PeopleYouMayKnowSideshowUnit peopleYouMayKnowSideshowUnit) {
            this.f4719a = peopleYouMayKnowSideshowUnit;
        }

        public final void m5904b(FbEvent fbEvent) {
            FriendRequestClickedEvent friendRequestClickedEvent = (FriendRequestClickedEvent) fbEvent;
            PeopleYouMayKnowSideshowUnit peopleYouMayKnowSideshowUnit = this.f4719a;
            ListenableFuture listenableFuture = null;
            String str = friendRequestClickedEvent.f4747a;
            GraphQLFriendshipStatus graphQLFriendshipStatus = friendRequestClickedEvent.f4748b;
            if (str != null && graphQLFriendshipStatus != null) {
                switch (C06444.f4723a[graphQLFriendshipStatus.ordinal()]) {
                    case 1:
                        listenableFuture = peopleYouMayKnowSideshowUnit.f4729g.b(Long.parseLong(str), FriendRequestHowFound.PYMK_SIDESHOW, null, null);
                        break;
                    case 2:
                        listenableFuture = peopleYouMayKnowSideshowUnit.f4729g.a(Long.parseLong(str), FriendRequestCancelRef.PYMK_SIDESHOW);
                        break;
                }
                if (listenableFuture != null) {
                    peopleYouMayKnowSideshowUnit.f4732j.a(listenableFuture, new C06433(peopleYouMayKnowSideshowUnit, str, graphQLFriendshipStatus));
                }
            }
        }
    }

    /* compiled from: onLoadStart */
    public class C06433 extends AbstractDisposableFutureCallback<GraphQLFriendshipStatus> {
        final /* synthetic */ String f4720a;
        final /* synthetic */ GraphQLFriendshipStatus f4721b;
        final /* synthetic */ PeopleYouMayKnowSideshowUnit f4722c;

        public C06433(PeopleYouMayKnowSideshowUnit peopleYouMayKnowSideshowUnit, String str, GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f4722c = peopleYouMayKnowSideshowUnit;
            this.f4720a = str;
            this.f4721b = graphQLFriendshipStatus;
        }

        protected final void m5906a(Throwable th) {
            PeopleYouMayKnowListAdapter peopleYouMayKnowListAdapter = this.f4722c.f4724b;
            String str = this.f4720a;
            GraphQLFriendshipStatus graphQLFriendshipStatus = this.f4721b;
            if (peopleYouMayKnowListAdapter.f4780b != null) {
                PeopleYouMayKnowDataHolder peopleYouMayKnowDataHolder = peopleYouMayKnowListAdapter.f4780b;
                if (peopleYouMayKnowDataHolder.f4771d.containsKey(str)) {
                    PeopleYouMayKnowRow peopleYouMayKnowRow = (PeopleYouMayKnowRow) peopleYouMayKnowDataHolder.f4770c.get(((Integer) peopleYouMayKnowDataHolder.f4771d.get(str)).intValue());
                    if (peopleYouMayKnowRow != null) {
                        peopleYouMayKnowRow.f4777f = graphQLFriendshipStatus;
                    }
                }
            }
        }
    }

    /* compiled from: onLoadStart */
    public /* synthetic */ class C06444 {
        public static final /* synthetic */ int[] f4723a = new int[GraphQLFriendshipStatus.values().length];

        static {
            try {
                f4723a[GraphQLFriendshipStatus.CAN_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4723a[GraphQLFriendshipStatus.OUTGOING_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public PeopleYouMayKnowSideshowUnit(PeopleYouMayKnowListAdapter peopleYouMayKnowListAdapter, FetchPeopleYouMayKnowSideshowDataRequest fetchPeopleYouMayKnowSideshowDataRequest, SideshowAnalyticsLogger sideshowAnalyticsLogger, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper, SideshowUtils sideshowUtils, FriendingClient friendingClient, FbEventSubscriberListManager fbEventSubscriberListManager, FeedEventBus feedEventBus, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        super(sideshowUtils);
        this.f4724b = peopleYouMayKnowListAdapter;
        this.f4726d = sideshowAnalyticsLogger;
        this.f4725c = new PeopleYouMayKnowDataHolder(fetchPeopleYouMayKnowSideshowDataRequest);
        PeopleYouMayKnowListAdapter peopleYouMayKnowListAdapter2 = this.f4724b;
        PeopleYouMayKnowDataHolder peopleYouMayKnowDataHolder = this.f4725c;
        if (peopleYouMayKnowListAdapter2.f4780b != peopleYouMayKnowDataHolder) {
            peopleYouMayKnowListAdapter2.f4780b = peopleYouMayKnowDataHolder;
            C06471 c06471 = new C06471(peopleYouMayKnowListAdapter2);
            peopleYouMayKnowDataHolder.f4769b.add(c06471);
            if (peopleYouMayKnowDataHolder.m5973a() > 0) {
                c06471.m5974b();
            }
        }
        this.f4727e = secureContextHelper;
        this.f4728f = uriIntentMapper;
        this.f4729g = friendingClient;
        this.f4730h = fbEventSubscriberListManager;
        this.f4731i = feedEventBus;
        this.f4732j = defaultAndroidThreadUtil;
    }

    public final View m5907a(final Context context, ViewGroup viewGroup) {
        LayoutInflater from = LayoutInflater.from(context);
        View inflate = from.inflate(2130903082, viewGroup);
        SideshowExpandableListView sideshowExpandableListView = (SideshowExpandableListView) inflate.findViewById(16908298);
        sideshowExpandableListView.g = new OnItemClickedListener(this) {
            final /* synthetic */ PeopleYouMayKnowSideshowUnit f4718b;

            public final void m5902a(View view, Object obj) {
                this.f4718b.f4726d.b(this.f4718b.m5912d());
                PeopleYouMayKnowRow peopleYouMayKnowRow = (PeopleYouMayKnowRow) obj;
                PeopleYouMayKnowSideshowUnit peopleYouMayKnowSideshowUnit = this.f4718b;
                Context context = context;
                Intent a = peopleYouMayKnowSideshowUnit.f4728f.a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, peopleYouMayKnowRow.f4772a));
                if (a != null) {
                    peopleYouMayKnowSideshowUnit.f4727e.a(a, context);
                }
            }
        };
        ActionContentViewSideshowUnit.a(from, sideshowExpandableListView, viewGroup, 2131241713);
        a(context, sideshowExpandableListView);
        sideshowExpandableListView.setAdapter(this.f4724b);
        this.f4730h = new FbEventSubscriberListManager();
        this.f4730h.a(new C06422(this));
        return inflate;
    }

    public final void m5908a() {
        if (this.f4730h != null) {
            this.f4730h.a(this.f4731i);
        }
    }

    public final void m5910b() {
        if (this.f4730h != null) {
            this.f4730h.b(this.f4731i);
        }
    }

    public final void m5911c() {
        PeopleYouMayKnowDataHolder peopleYouMayKnowDataHolder = this.f4725c;
        peopleYouMayKnowDataHolder.f4770c = null;
        for (C06471 c06471 : peopleYouMayKnowDataHolder.f4769b) {
            AdapterDetour.a(c06471.f4778a, 1292904878);
        }
        this.f4730h = null;
    }

    public final void m5909a(Context context, 1 1) {
        PeopleYouMayKnowDataHolder peopleYouMayKnowDataHolder = this.f4725c;
        FetchPeopleYouMayKnowSideshowDataRequest fetchPeopleYouMayKnowSideshowDataRequest = peopleYouMayKnowDataHolder.f4768a;
        Futures.a(fetchPeopleYouMayKnowSideshowDataRequest.f4753a.a(GraphQLRequest.a((FetchPeopleYouMayKnowSideshowString) new FetchPeopleYouMayKnowSideshowString().a("count", Integer.valueOf(10)))), new C06451(fetchPeopleYouMayKnowSideshowDataRequest, new C06461(peopleYouMayKnowDataHolder, 1)), fetchPeopleYouMayKnowSideshowDataRequest.f4754b);
    }

    public final String m5912d() {
        return "pymk";
    }
}
