package com.facebook.notifications.notificationsfriending.adapter;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.friending.center.constants.FriendsCenterSource;
import com.facebook.friending.center.constants.FriendsCenterTabType;
import com.facebook.friending.common.list.FriendListItemView;
import com.facebook.friending.common.list.FriendRequestItemView;
import com.facebook.friending.jewel.adapter.FriendingPYMKBinder;
import com.facebook.friending.jewel.adapter.FriendingPYMKBinder.OnResponseListener;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.model.PersonYouMayKnow;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.notificationsfriending.NotificationsFriendingAdapter.ViewTypes;
import com.facebook.notifications.notificationsfriending.abtest.NotificationsFriendingExperimentController;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: tigon_redirects */
public class PeopleYouMayKnowAdapterSection implements NotificationsFriendingAdapterSection<PersonYouMayKnow> {
    public final NotificationsFriendingExperimentController f1020a;
    public final FbUriIntentHandler f1021b;
    public final FriendingPYMKBinder f1022c;
    private final Resources f1023d;
    public final OnSectionUpdatedListener f1024e;
    public final List<PersonYouMayKnow> f1025f;
    public final Set<Long> f1026g;
    public LoadingState f1027h = LoadingState.LOADING;
    public boolean f1028i;

    /* compiled from: tigon_redirects */
    class C01451 implements OnResponseListener {
        final /* synthetic */ PeopleYouMayKnowAdapterSection f1017a;

        C01451(PeopleYouMayKnowAdapterSection peopleYouMayKnowAdapterSection) {
            this.f1017a = peopleYouMayKnowAdapterSection;
        }

        public final void m1362a(long j) {
            if (this.f1017a.m1372b(j)) {
                this.f1017a.f1024e.mo13e();
            }
        }

        public final void m1363b(long j) {
            this.f1017a.m1369a(j);
        }

        public final void m1364c(long j) {
            if (this.f1017a.m1372b(j)) {
                this.f1017a.f1024e.mo13e();
            }
        }
    }

    /* compiled from: tigon_redirects */
    class C01462 implements OnClickListener {
        final /* synthetic */ PeopleYouMayKnowAdapterSection f1018a;

        C01462(PeopleYouMayKnowAdapterSection peopleYouMayKnowAdapterSection) {
            this.f1018a = peopleYouMayKnowAdapterSection;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 858224039);
            this.f1018a.f1021b.a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.cd, FriendsCenterSource.NOTIFICATIONS_FRIENDING_TAB_FIND_FRIENDS.name(), FriendsCenterTabType.SUGGESTIONS.name()));
            Logger.a(2, EntryType.UI_INPUT_END, 1119724417, a);
        }
    }

    /* compiled from: tigon_redirects */
    public enum LoadingState {
        SUCCESS,
        FAILURE,
        LOADING
    }

    public final /* synthetic */ Object mo16b(int i) {
        return m1366c(i);
    }

    @Inject
    public PeopleYouMayKnowAdapterSection(NotificationsFriendingExperimentController notificationsFriendingExperimentController, FbUriIntentHandler fbUriIntentHandler, FriendingPYMKBinder friendingPYMKBinder, Resources resources, @Assisted OnSectionUpdatedListener onSectionUpdatedListener) {
        this.f1020a = notificationsFriendingExperimentController;
        this.f1024e = onSectionUpdatedListener;
        this.f1021b = fbUriIntentHandler;
        this.f1022c = friendingPYMKBinder;
        this.f1023d = resources;
        this.f1022c.j = FriendingLocation.JEWEL;
        this.f1022c.k = new C01451(this);
        this.f1025f = new ArrayList();
        this.f1026g = new HashSet();
    }

    public final boolean m1382l() {
        return !this.f1027h.equals(LoadingState.LOADING);
    }

    public final String mo17c() {
        return this.f1023d.getString(2131233210);
    }

    public final boolean mo18d() {
        if (!this.f1028i) {
            Object obj = (this.f1020a.m() || this.f1020a.o()) ? 1 : null;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public final String mo19e() {
        return this.f1023d.getString(2131233242);
    }

    public final OnClickListener mo20f() {
        return new C01462(this);
    }

    public final int mo21g() {
        return this.f1025f.size();
    }

    private PersonYouMayKnow m1366c(int i) {
        return (PersonYouMayKnow) this.f1025f.get(i);
    }

    public final View mo14a(int i, View view, ViewGroup viewGroup) {
        switch (mo15a(i)) {
            case PERSON_YOU_MAY_KNOW:
                if (view == null) {
                    view = (FriendRequestItemView) LayoutInflater.from(viewGroup.getContext()).inflate(2130906529, viewGroup, false);
                } else {
                    FriendRequestItemView friendRequestItemView = (FriendRequestItemView) view;
                }
                this.f1022c.a(view, m1366c(i));
                break;
            case RESPONDED_PERSON_YOU_MAY_KNOW:
                if (view == null) {
                    view = (FriendListItemView) LayoutInflater.from(viewGroup.getContext()).inflate(2130906838, viewGroup, false);
                } else {
                    FriendListItemView friendListItemView = (FriendListItemView) view;
                }
                this.f1022c.a(view, m1366c(i));
                break;
            default:
                throw new IllegalArgumentException("Unexpected child view type");
        }
        return view;
    }

    public final boolean mo22h() {
        return true;
    }

    public final ViewTypes mo15a(int i) {
        GraphQLFriendshipStatus f = ((PersonYouMayKnow) this.f1025f.get(i)).f();
        if (GraphQLFriendshipStatus.CAN_REQUEST.equals(f) || GraphQLFriendshipStatus.INCOMING_REQUEST.equals(f)) {
            return ViewTypes.PERSON_YOU_MAY_KNOW;
        }
        return ViewTypes.RESPONDED_PERSON_YOU_MAY_KNOW;
    }

    public final boolean mo23i() {
        return false;
    }

    public final ViewTypes mo24j() {
        return ViewTypes.SEE_ALL_FOOTER;
    }

    public final OnClickListener mo25k() {
        return null;
    }

    public final void m1369a(long j) {
        if (this.f1026g.contains(Long.valueOf(j))) {
            int c = m1365c(j);
            if (c != -1) {
                this.f1025f.remove(c);
                this.f1026g.remove(Long.valueOf(j));
                this.f1024e.mo13e();
            }
        }
    }

    public final void m1370a(long j, GraphQLFriendshipStatus graphQLFriendshipStatus) {
        if (this.f1026g.contains(Long.valueOf(j))) {
            int c = m1365c(j);
            if (c != -1) {
                PersonYouMayKnow personYouMayKnow = (PersonYouMayKnow) this.f1025f.get(c);
                GraphQLFriendshipStatus f = personYouMayKnow.f();
                if (!f.equals(graphQLFriendshipStatus)) {
                    personYouMayKnow.f = f;
                    personYouMayKnow.b(graphQLFriendshipStatus);
                    this.f1024e.mo13e();
                }
            }
        }
    }

    public final boolean m1372b(long j) {
        return this.f1026g.contains(Long.valueOf(j));
    }

    private int m1365c(long j) {
        for (int i = 0; i < this.f1025f.size(); i++) {
            if (((PersonYouMayKnow) this.f1025f.get(i)).a() == j) {
                return i;
            }
        }
        return -1;
    }
}
