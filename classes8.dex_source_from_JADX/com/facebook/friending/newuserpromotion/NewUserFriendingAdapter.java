package com.facebook.friending.newuserpromotion;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.util.CollectionUtil;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.friending.common.list.FriendListItemView;
import com.facebook.friending.common.list.FriendRequestItemView;
import com.facebook.friending.common.list.model.FriendListCommonModel;
import com.facebook.friending.newuserpromotion.friendrequests.NewUserFriendRequestsBinder;
import com.facebook.friending.newuserpromotion.friendrequests.NewUserFriendRequestsController;
import com.facebook.friending.newuserpromotion.friendrequests.NewUserFriendRequestsController.C14231;
import com.facebook.friending.newuserpromotion.friendrequests.NewUserFriendRequestsControllerProvider;
import com.facebook.friending.newuserpromotion.pymk.NewUserPYMKBinder;
import com.facebook.friending.newuserpromotion.pymk.NewUserPYMKController;
import com.facebook.friending.newuserpromotion.pymk.NewUserPYMKController.C14241;
import com.facebook.friending.newuserpromotion.pymk.NewUserPYMKControllerProvider;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendRequestResponse;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.FriendingExceptionHandler;
import com.facebook.friends.model.FriendRequest;
import com.facebook.friends.model.FriendRequestState;
import com.facebook.friends.model.PersonYouMayKnow;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nux.status.NuxStepListener;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: filterID */
public class NewUserFriendingAdapter extends Adapter<ViewHolder> {
    public final NewUserFriendRequestsController f13340a;
    private final NewUserFriendRequestsBinder f13341b;
    public final NewUserPYMKController f13342c;
    private final NewUserPYMKBinder f13343d;
    private final Set<String> f13344e = new HashSet();
    public final List<FriendRequest> f13345f = new ArrayList();
    private final Set<Long> f13346g = new HashSet();
    private final List<PersonYouMayKnow> f13347h = new ArrayList();
    public final List<NewUserFriendingFragmentRow> f13348i = new ArrayList();

    /* compiled from: filterID */
    public class NewUserFriendingFragmentRow {
        public final RowType f13338a;
        public final Object f13339b;

        public NewUserFriendingFragmentRow(RowType rowType) {
            this(rowType, null);
        }

        public NewUserFriendingFragmentRow(RowType rowType, Object obj) {
            this.f13338a = rowType;
            this.f13339b = obj;
        }
    }

    /* compiled from: filterID */
    public enum RowType {
        FRIEND_REQUEST_HEADER,
        FRIEND_REQUEST,
        PYMK_HEADER,
        PYMK,
        PROGRESS_BAR
    }

    /* compiled from: filterID */
    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder m14991a(ViewGroup viewGroup, int i) {
        switch (RowType.values()[i]) {
            case FRIEND_REQUEST_HEADER:
                return new ViewHolder(m14989d(viewGroup, 2131233203));
            case FRIEND_REQUEST:
                FriendRequestItemView friendRequestItemView = new FriendRequestItemView(viewGroup.getContext());
                friendRequestItemView.setThumbnailSize(ThumbnailSize.LARGE);
                friendRequestItemView.setFocusable(true);
                return new ViewHolder(friendRequestItemView);
            case PYMK_HEADER:
                return new ViewHolder(m14989d(viewGroup, 2131233210));
            case PYMK:
                FriendListItemView friendListItemView = new FriendListItemView(viewGroup.getContext());
                friendListItemView.setThumbnailSize(ThumbnailSize.LARGE);
                friendListItemView.setFocusable(true);
                return new ViewHolder(friendListItemView);
            case PROGRESS_BAR:
                LoadingIndicatorView loadingIndicatorView = new LoadingIndicatorView(viewGroup.getContext());
                loadingIndicatorView.a();
                return new ViewHolder(loadingIndicatorView);
            default:
                throw new IllegalArgumentException("In onCreateViewHolder, Unexpected view type: " + i);
        }
    }

    public final void m14993a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        switch (((NewUserFriendingFragmentRow) this.f13348i.get(i)).f13338a) {
            case FRIEND_REQUEST:
                FriendRequest friendRequest = (FriendRequest) ((NewUserFriendingFragmentRow) this.f13348i.get(i)).f13339b;
                this.f13341b.m15013a((FriendRequestItemView) viewHolder2.a, friendRequest, m14988a(friendRequest, FriendRequestResponse.CONFIRM), m14988a(friendRequest, FriendRequestResponse.REJECT));
                return;
            case PYMK:
                final PersonYouMayKnow personYouMayKnow = (PersonYouMayKnow) ((NewUserFriendingFragmentRow) this.f13348i.get(i)).f13339b;
                this.f13343d.m15019a((FriendListItemView) viewHolder2.a, personYouMayKnow, new OnClickListener(this) {
                    final /* synthetic */ NewUserFriendingAdapter f13336b;

                    public void onClick(View view) {
                        ListenableFuture a;
                        GraphQLFriendshipStatus graphQLFriendshipStatus;
                        int a2 = Logger.a(2, EntryType.UI_INPUT_START, 1911276706);
                        NewUserPYMKController newUserPYMKController = this.f13336b.f13342c;
                        PersonYouMayKnow personYouMayKnow = personYouMayKnow;
                        long a3 = personYouMayKnow.a();
                        GraphQLFriendshipStatus f = personYouMayKnow.f();
                        if (newUserPYMKController.f13393c instanceof NuxStepListener) {
                            ((NuxStepListener) newUserPYMKController.f13393c).c("people_you_may_know");
                        }
                        if (GraphQLFriendshipStatus.OUTGOING_REQUEST == f) {
                            a = newUserPYMKController.f13391a.a(a3, newUserPYMKController.f13394d.friendRequestCancelRef);
                            graphQLFriendshipStatus = GraphQLFriendshipStatus.CAN_REQUEST;
                        } else {
                            if (GraphQLFriendshipStatus.CAN_REQUEST == f) {
                                a = newUserPYMKController.f13391a.b(a3, newUserPYMKController.f13394d.friendRequestHowFound, newUserPYMKController.f13394d.peopleYouMayKnowLocation, null);
                                graphQLFriendshipStatus = GraphQLFriendshipStatus.OUTGOING_REQUEST;
                            }
                            Logger.a(2, EntryType.UI_INPUT_END, -1529170815, a2);
                        }
                        newUserPYMKController.f13395e.m14992a(a3, graphQLFriendshipStatus);
                        newUserPYMKController.f13396f.b("PYMK_FRIENDING_ACTION_TASK" + a3, a, new C14241(newUserPYMKController, a3, f));
                        Logger.a(2, EntryType.UI_INPUT_END, -1529170815, a2);
                    }
                });
                return;
            default:
                return;
        }
    }

    @Inject
    public NewUserFriendingAdapter(NewUserFriendRequestsControllerProvider newUserFriendRequestsControllerProvider, NewUserFriendRequestsBinder newUserFriendRequestsBinder, NewUserPYMKControllerProvider newUserPYMKControllerProvider, NewUserPYMKBinder newUserPYMKBinder, @Assisted Context context, @Assisted TasksManager tasksManager, @Assisted FriendingLocation friendingLocation) {
        this.f13340a = newUserFriendRequestsControllerProvider.m15016a(context, friendingLocation, this, tasksManager);
        this.f13341b = newUserFriendRequestsBinder;
        this.f13342c = new NewUserPYMKController(FriendingClient.b(newUserPYMKControllerProvider), FriendingExceptionHandler.b(newUserPYMKControllerProvider), context, friendingLocation, this, tasksManager);
        this.f13343d = newUserPYMKBinder;
    }

    public final long H_(int i) {
        return (long) i;
    }

    public final int aZ_() {
        return this.f13348i.size();
    }

    public int getItemViewType(int i) {
        return ((NewUserFriendingFragmentRow) this.f13348i.get(i)).f13338a.ordinal();
    }

    public final void m14996a(List<FriendRequest> list) {
        if (!CollectionUtil.a(list)) {
            for (FriendRequest friendRequest : list) {
                if (!(friendRequest == null || this.f13344e.contains(friendRequest.b))) {
                    this.f13345f.add(friendRequest);
                    this.f13344e.add(friendRequest.b);
                }
            }
            m14990e();
        }
    }

    public final void m14997b(List<PersonYouMayKnow> list) {
        if (!CollectionUtil.a(list)) {
            for (PersonYouMayKnow personYouMayKnow : list) {
                if (!(personYouMayKnow == null || this.f13346g.contains(Long.valueOf(personYouMayKnow.a())))) {
                    this.f13347h.add(personYouMayKnow);
                    this.f13346g.add(Long.valueOf(personYouMayKnow.a()));
                }
            }
            m14990e();
        }
    }

    public final void m14995a(String str, FriendRequestState friendRequestState) {
        int a = m14987a(Long.parseLong(str), RowType.FRIEND_REQUEST);
        if (a != -1) {
            ((FriendRequest) ((NewUserFriendingFragmentRow) this.f13348i.get(a)).f13339b).j = friendRequestState;
            j_(a);
        }
    }

    public final void m14992a(long j, GraphQLFriendshipStatus graphQLFriendshipStatus) {
        int a = m14987a(j, RowType.PYMK);
        if (a != -1) {
            ((PersonYouMayKnow) ((NewUserFriendingFragmentRow) this.f13348i.get(a)).f13339b).b(graphQLFriendshipStatus);
            j_(a);
        }
    }

    private OnClickListener m14988a(final FriendRequest friendRequest, final FriendRequestResponse friendRequestResponse) {
        return new OnClickListener(this) {
            final /* synthetic */ NewUserFriendingAdapter f13334c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -804479983);
                NewUserFriendRequestsController newUserFriendRequestsController = this.f13334c.f13340a;
                FriendRequest friendRequest = friendRequest;
                FriendRequestResponse friendRequestResponse = friendRequestResponse;
                newUserFriendRequestsController.f13382c.c();
                if (newUserFriendRequestsController.f13383d instanceof NuxStepListener) {
                    ((NuxStepListener) newUserFriendRequestsController.f13383d).c("people_you_may_know");
                }
                long a2 = friendRequest.a();
                ListenableFuture a3 = newUserFriendRequestsController.f13380a.a(a2, friendRequestResponse, newUserFriendRequestsController.f13384e.friendRequestResponseRef);
                newUserFriendRequestsController.f13385f.m14995a(friendRequest.b, friendRequestResponse == FriendRequestResponse.REJECT ? FriendRequestState.REJECTED : FriendRequestState.ACCEPTED);
                newUserFriendRequestsController.f13386g.b("RESPOND_TO_FRIEND_REQUEST_TASK" + a2, a3, new C14231(newUserFriendRequestsController, friendRequest));
                Logger.a(2, EntryType.UI_INPUT_END, 2085956346, a);
            }
        };
    }

    public final void m14994a(String str) {
        int i = 0;
        while (i < this.f13345f.size()) {
            if (((FriendRequest) this.f13345f.get(i)).b.equals(str)) {
                break;
            }
            i++;
        }
        i = -1;
        int i2 = i;
        if (i2 != -1) {
            this.f13345f.remove(i2);
            this.f13344e.remove(str);
            m14990e();
        }
    }

    private int m14987a(long j, RowType rowType) {
        for (int i = 0; i < this.f13348i.size(); i++) {
            Object obj = ((NewUserFriendingFragmentRow) this.f13348i.get(i)).f13339b;
            if (rowType == ((NewUserFriendingFragmentRow) this.f13348i.get(i)).f13338a && (obj instanceof FriendListCommonModel) && ((FriendListCommonModel) obj).a() == j) {
                return i;
            }
        }
        return -1;
    }

    private void m14990e() {
        this.f13348i.clear();
        if (!this.f13345f.isEmpty()) {
            this.f13348i.add(new NewUserFriendingFragmentRow(RowType.FRIEND_REQUEST_HEADER));
            for (FriendRequest newUserFriendingFragmentRow : this.f13345f) {
                this.f13348i.add(new NewUserFriendingFragmentRow(RowType.FRIEND_REQUEST, newUserFriendingFragmentRow));
            }
        }
        if (!this.f13347h.isEmpty()) {
            this.f13348i.add(new NewUserFriendingFragmentRow(RowType.PYMK_HEADER));
            for (PersonYouMayKnow newUserFriendingFragmentRow2 : this.f13347h) {
                this.f13348i.add(new NewUserFriendingFragmentRow(RowType.PYMK, newUserFriendingFragmentRow2));
            }
        }
        this.f13348i.add(new NewUserFriendingFragmentRow(RowType.PROGRESS_BAR));
        notifyDataSetChanged();
    }

    private static View m14989d(ViewGroup viewGroup, int i) {
        TextView textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(2130904507, viewGroup, false);
        textView.setText(i);
        CustomFontHelper.a(textView, FontFamily.ROBOTO, FontWeight.MEDIUM, textView.getTypeface());
        return textView;
    }
}
