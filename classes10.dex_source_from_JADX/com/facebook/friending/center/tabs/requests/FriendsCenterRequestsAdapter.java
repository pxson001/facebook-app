package com.facebook.friending.center.tabs.requests;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.TextView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.friending.center.FriendsCenterHomeFragment;
import com.facebook.friending.center.connectioncontroller.FriendsCenterConnectionControllerManager;
import com.facebook.friending.center.model.FriendsCenterListItemModel;
import com.facebook.friending.center.tabs.requests.items.FriendRequestItem;
import com.facebook.friending.center.tabs.requests.items.RequestsListItem;
import com.facebook.friending.center.tabs.requests.items.RequestsListItemType;
import com.facebook.friending.center.tabs.requests.items.RequestsLoadingMoreItem;
import com.facebook.friending.center.ui.FriendsCenterCommonBinder;
import com.facebook.friending.center.ui.FriendsCenterCommonBinder.OnPYMKResponseListener;
import com.facebook.friending.common.list.FriendListItemView;
import com.facebook.friending.common.list.FriendRequestItemView;
import com.facebook.friends.constants.FriendRequestResponse;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.FriendRequestController;
import com.facebook.friends.controllers.FriendRequestController.Callback;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.listview.StickyHeader.StickyHeaderAdapter;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: adpreview_graphql_error */
public class FriendsCenterRequestsAdapter extends FbBaseAdapter implements StickyHeaderAdapter {
    private final Resources f20063a;
    public final FriendRequestController f20064b;
    public final FriendsCenterCommonBinder f20065c;
    public final GraphQLCacheManager f20066d;
    public final FriendsCenterConnectionControllerManager f20067e;
    public final TasksManager f20068f;
    public List<RequestsListItem> f20069g = new ArrayList();
    private RequestsListItem f20070h = new RequestsLoadingMoreItem();
    private boolean f20071i;
    public FriendsCenterHomeFragment f20072j;
    private int f20073k = 0;
    public int f20074l = 0;

    /* compiled from: adpreview_graphql_error */
    class C28191 implements OnPYMKResponseListener {
        final /* synthetic */ FriendsCenterRequestsAdapter f20049a;

        C28191(FriendsCenterRequestsAdapter friendsCenterRequestsAdapter) {
            this.f20049a = friendsCenterRequestsAdapter;
        }

        public final void mo895a(long j) {
            FriendsCenterRequestsAdapter friendsCenterRequestsAdapter = this.f20049a;
            int i = 0;
            while (i < friendsCenterRequestsAdapter.f20069g.size()) {
                RequestsListItem requestsListItem = (RequestsListItem) friendsCenterRequestsAdapter.f20069g.get(i);
                Object obj = (RequestsListItemType.PERSON_YOU_MAY_KNOW.equals(requestsListItem.mo897n()) || RequestsListItemType.RESPONDED_PERSON_YOU_MAY_KNOW.equals(requestsListItem.mo897n())) ? 1 : null;
                if (obj != null && ((FriendsCenterListItemModel) requestsListItem).m20172a() == j) {
                    break;
                }
                i++;
            }
            i = -1;
            if (i != -1) {
                AdapterDetour.a(this.f20049a, -727644238);
            }
        }
    }

    public static FriendsCenterRequestsAdapter m20353b(InjectorLike injectorLike) {
        return new FriendsCenterRequestsAdapter(ResourcesMethodAutoProvider.a(injectorLike), FriendRequestController.b(injectorLike), FriendsCenterCommonBinder.m20469b(injectorLike), GraphQLCacheManager.a(injectorLike), FriendsCenterConnectionControllerManager.m20129a(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public FriendsCenterRequestsAdapter(Resources resources, FriendRequestController friendRequestController, FriendsCenterCommonBinder friendsCenterCommonBinder, GraphQLCacheManager graphQLCacheManager, FriendsCenterConnectionControllerManager friendsCenterConnectionControllerManager, TasksManager tasksManager) {
        this.f20063a = resources;
        this.f20064b = friendRequestController;
        this.f20065c = friendsCenterCommonBinder;
        this.f20066d = graphQLCacheManager;
        this.f20067e = friendsCenterConnectionControllerManager;
        this.f20068f = tasksManager;
    }

    public int getCount() {
        return this.f20069g.size();
    }

    public Object getItem(int i) {
        this.f20074l = Math.max(this.f20074l, i);
        return this.f20069g.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public final View m20358a(int i, ViewGroup viewGroup) {
        View a;
        switch (RequestsListItemType.values()[i]) {
            case FRIEND_REQUEST_HEADER:
                a = m20352a(viewGroup);
                a.setText(2131233203);
                return a;
            case PYMK_HEADER:
                a = m20352a(viewGroup);
                a.setCompoundDrawables(null, null, null, null);
                a.setText(2131233210);
                return a;
            case FRIEND_REQUEST:
                return m20354b(viewGroup);
            case RESPONDED_REQUEST:
                return m20355c(viewGroup);
            case NO_FRIEND_REQUESTS:
                return LayoutInflater.from(viewGroup.getContext()).inflate(2130904516, viewGroup, false);
            case PERSON_YOU_MAY_KNOW:
                return m20354b(viewGroup);
            case RESPONDED_PERSON_YOU_MAY_KNOW:
                return m20355c(viewGroup);
            case LOADING_MORE:
                return LayoutInflater.from(viewGroup.getContext()).inflate(2130904517, viewGroup, false);
            default:
                throw new IllegalStateException("Unexpected type");
        }
    }

    public final void m20359a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        switch (RequestsListItemType.values()[i2]) {
            case FRIEND_REQUEST:
                C28212 c28212;
                Object c28254;
                C28233 c28233;
                FriendsCenterCommonBinder friendsCenterCommonBinder = this.f20065c;
                FriendRequestItemView friendRequestItemView = (FriendRequestItemView) view;
                FriendRequestItem friendRequestItem = (FriendRequestItem) obj;
                final FriendRequestItem friendRequestItem2 = (FriendRequestItem) obj;
                if (friendRequestItem2.f20010c) {
                    c28212 = new OnClickListener(this) {
                        final /* synthetic */ FriendsCenterRequestsAdapter f20052b;

                        /* compiled from: adpreview_graphql_error */
                        class C28201 implements Callback {
                            final /* synthetic */ C28212 f20050a;

                            C28201(C28212 c28212) {
                                this.f20050a = c28212;
                            }

                            public final void m20343a() {
                                if (this.f20050a.f20052b.f20072j != null) {
                                    this.f20050a.f20052b.f20072j.m20119e();
                                }
                            }

                            public final void m20344a(boolean z) {
                                friendRequestItem2.m20175b(GraphQLFriendshipStatus.CAN_REQUEST);
                                friendRequestItem2.f20012e = true;
                                AdapterDetour.a(this.f20050a.f20052b, 1365983032);
                            }
                        }

                        public void onClick(View view) {
                            int a = Logger.a(2, EntryType.UI_INPUT_START, 2017182370);
                            friendRequestItem2.m20175b(GraphQLFriendshipStatus.OUTGOING_REQUEST);
                            friendRequestItem2.f20012e = false;
                            AdapterDetour.a(this.f20052b, 327914638);
                            FriendsCenterRequestsAdapter.m20356e(this.f20052b);
                            FriendsCenterRequestsAdapter.m20357g(this.f20052b);
                            this.f20052b.f20064b.a(friendRequestItem2.m20172a(), FriendRequestResponse.CONFIRM, new C28201(this));
                            Logger.a(2, EntryType.UI_INPUT_END, 1025741604, a);
                        }
                    };
                } else {
                    c28254 = new OnClickListener(this) {
                        final /* synthetic */ FriendsCenterRequestsAdapter f20058b;

                        /* compiled from: adpreview_graphql_error */
                        class C28241 implements Callback {
                            final /* synthetic */ C28254 f20056a;

                            C28241(C28254 c28254) {
                                this.f20056a = c28254;
                            }

                            public final void m20347a() {
                                if (this.f20056a.f20058b.f20072j != null) {
                                    this.f20056a.f20058b.f20072j.m20119e();
                                }
                            }

                            public final void m20348a(boolean z) {
                                friendRequestItem2.m20175b(GraphQLFriendshipStatus.INCOMING_REQUEST);
                                friendRequestItem2.f20012e = true;
                                AdapterDetour.a(this.f20056a.f20058b, -556820844);
                            }
                        }

                        public void onClick(View view) {
                            int a = Logger.a(2, EntryType.UI_INPUT_START, -238077469);
                            friendRequestItem2.m20175b(GraphQLFriendshipStatus.ARE_FRIENDS);
                            friendRequestItem2.f20012e = false;
                            AdapterDetour.a(this.f20058b, -1952732521);
                            FriendsCenterRequestsAdapter.m20356e(this.f20058b);
                            FriendsCenterRequestsAdapter friendsCenterRequestsAdapter = this.f20058b;
                            friendsCenterRequestsAdapter.f20066d.a(ImmutableSet.of("FC_FRIENDS_QUERY"));
                            friendsCenterRequestsAdapter.f20067e.m20133f();
                            FriendsCenterRequestsAdapter.m20357g(this.f20058b);
                            this.f20058b.f20064b.a(friendRequestItem2.m20172a(), FriendingLocation.FRIENDS_CENTER_REQUESTS, FriendRequestResponse.CONFIRM, new C28241(this));
                            Logger.a(2, EntryType.UI_INPUT_END, -851959739, a);
                        }
                    };
                }
                C28212 c282122 = c28212;
                final FriendRequestItem friendRequestItem3 = (FriendRequestItem) obj;
                if (friendRequestItem3.f20010c) {
                    c28233 = new OnClickListener(this) {
                        final /* synthetic */ FriendsCenterRequestsAdapter f20055b;

                        /* compiled from: adpreview_graphql_error */
                        class C28221 implements Callback {
                            final /* synthetic */ C28233 f20053a;

                            C28221(C28233 c28233) {
                                this.f20053a = c28233;
                            }

                            public final void m20345a() {
                                if (this.f20053a.f20055b.f20072j != null) {
                                    this.f20053a.f20055b.f20072j.m20119e();
                                }
                            }

                            public final void m20346a(boolean z) {
                                friendRequestItem3.m20175b(GraphQLFriendshipStatus.CAN_REQUEST);
                                friendRequestItem3.f20012e = true;
                                AdapterDetour.a(this.f20053a.f20055b, -38787221);
                            }
                        }

                        public void onClick(View view) {
                            int a = Logger.a(2, EntryType.UI_INPUT_START, -262542498);
                            friendRequestItem3.m20175b(GraphQLFriendshipStatus.CAN_REQUEST);
                            friendRequestItem3.f20012e = false;
                            AdapterDetour.a(this.f20055b, -1251587886);
                            FriendsCenterRequestsAdapter.m20356e(this.f20055b);
                            this.f20055b.f20064b.a(friendRequestItem3.m20172a(), FriendRequestResponse.REJECT, new C28221(this));
                            Logger.a(2, EntryType.UI_INPUT_END, 726602456, a);
                        }
                    };
                } else {
                    c28254 = new OnClickListener(this) {
                        final /* synthetic */ FriendsCenterRequestsAdapter f20061b;

                        /* compiled from: adpreview_graphql_error */
                        class C28261 implements Callback {
                            final /* synthetic */ C28275 f20059a;

                            C28261(C28275 c28275) {
                                this.f20059a = c28275;
                            }

                            public final void m20349a() {
                                if (this.f20059a.f20061b.f20072j != null) {
                                    this.f20059a.f20061b.f20072j.m20119e();
                                }
                            }

                            public final void m20350a(boolean z) {
                                friendRequestItem3.m20175b(GraphQLFriendshipStatus.INCOMING_REQUEST);
                                friendRequestItem3.f20012e = true;
                                AdapterDetour.a(this.f20059a.f20061b, -807164460);
                            }
                        }

                        public void onClick(View view) {
                            int a = Logger.a(2, EntryType.UI_INPUT_START, -1747133813);
                            friendRequestItem3.m20175b(GraphQLFriendshipStatus.CAN_REQUEST);
                            friendRequestItem3.f20012e = false;
                            AdapterDetour.a(this.f20061b, 541650909);
                            FriendsCenterRequestsAdapter.m20356e(this.f20061b);
                            this.f20061b.f20064b.a(friendRequestItem3.m20172a(), FriendingLocation.FRIENDS_CENTER_REQUESTS, FriendRequestResponse.REJECT, new C28261(this));
                            Logger.a(2, EntryType.UI_INPUT_END, -1630731280, a);
                        }
                    };
                }
                friendsCenterCommonBinder.m20480a(friendRequestItemView, friendRequestItem, c282122, c28233);
                return;
            case RESPONDED_REQUEST:
                this.f20065c.m20478a((FriendListItemView) view, (FriendsCenterListItemModel) obj);
                return;
            case PERSON_YOU_MAY_KNOW:
                this.f20065c.m20481a((FriendRequestItemView) view, (FriendsCenterListItemModel) obj);
                return;
            case RESPONDED_PERSON_YOU_MAY_KNOW:
                this.f20065c.m20479a((FriendListItemView) view, (FriendsCenterListItemModel) obj, true);
                return;
            default:
                return;
        }
    }

    public int getItemViewType(int i) {
        return ((RequestsListItem) this.f20069g.get(i)).mo897n().ordinal();
    }

    public int getViewTypeCount() {
        return RequestsListItemType.values().length;
    }

    public boolean isEnabled(int i) {
        return ((RequestsListItem) this.f20069g.get(i)).mo898o();
    }

    public final void m20360a(List<RequestsListItem> list) {
        this.f20069g = list;
        if (this.f20071i) {
            this.f20069g.add(this.f20070h);
        }
        AdapterDetour.a(this, 483866174);
    }

    public final void m20361a(boolean z) {
        if (this.f20071i != z) {
            this.f20071i = z;
            if (!this.f20069g.isEmpty()) {
                if (this.f20071i) {
                    this.f20069g.add(this.f20070h);
                } else {
                    this.f20069g.remove(this.f20069g.size() - 1);
                }
                AdapterDetour.a(this, -2025179860);
            }
        }
    }

    private static TextView m20352a(ViewGroup viewGroup) {
        return (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(2130904480, viewGroup, false);
    }

    private static FriendRequestItemView m20354b(ViewGroup viewGroup) {
        FriendRequestItemView friendRequestItemView = new FriendRequestItemView(viewGroup.getContext());
        friendRequestItemView.setThumbnailSize(ThumbnailSize.XLARGE);
        return friendRequestItemView;
    }

    private static FriendListItemView m20355c(ViewGroup viewGroup) {
        FriendListItemView friendListItemView = new FriendListItemView(viewGroup.getContext());
        friendListItemView.setThumbnailSize(ThumbnailSize.XLARGE);
        return friendListItemView;
    }

    public static void m20356e(FriendsCenterRequestsAdapter friendsCenterRequestsAdapter) {
        friendsCenterRequestsAdapter.f20066d.a(ImmutableSet.of("FC_REQUESTS_QUERY"));
    }

    public static void m20357g(FriendsCenterRequestsAdapter friendsCenterRequestsAdapter) {
        friendsCenterRequestsAdapter.f20066d.a(ImmutableSet.of("FC_SUGGESTIONS_QUERY"));
        friendsCenterRequestsAdapter.f20067e.m20132c();
    }

    public final View m20362b(int i, View view, ViewGroup viewGroup) {
        switch (((RequestsListItem) this.f20069g.get(i)).mo897n()) {
            case FRIEND_REQUEST_HEADER:
            case FRIEND_REQUEST:
            case RESPONDED_REQUEST:
                return m20351a(view, viewGroup, 2131233203);
            case PYMK_HEADER:
            case PERSON_YOU_MAY_KNOW:
            case RESPONDED_PERSON_YOU_MAY_KNOW:
                return m20351a(view, viewGroup, 2131233210);
            case NO_FRIEND_REQUESTS:
                return null;
            default:
                return null;
        }
    }

    private TextView m20351a(View view, ViewGroup viewGroup, int i) {
        TextView a;
        if (view == null) {
            a = m20352a(viewGroup);
        } else {
            View view2 = view;
        }
        a = a;
        a.setText(i);
        a.setOnClickListener(null);
        a.setCompoundDrawables(null, null, null, null);
        if (this.f20073k == 0) {
            a.setLayoutParams(new LayoutParams(-1, -2));
            a.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
            this.f20073k = a.getMeasuredHeight();
        }
        return a;
    }

    public final int o_(int i) {
        return 0;
    }

    public final int m20364e(int i) {
        return this.f20073k;
    }

    public final int m20363d() {
        return this.f20063a.getColor(2131361920);
    }

    public final boolean m20365f(int i) {
        return ((RequestsListItem) this.f20069g.get(i)).mo897n() == RequestsListItemType.FRIEND_REQUEST_HEADER || ((RequestsListItem) this.f20069g.get(i)).mo897n() == RequestsListItemType.PYMK_HEADER;
    }
}
