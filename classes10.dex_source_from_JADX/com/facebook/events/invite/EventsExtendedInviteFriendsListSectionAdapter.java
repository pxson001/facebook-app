package com.facebook.events.invite;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.events.invite.EventsExtendedInviteActivity.C24752;
import com.facebook.events.invite.InviteSubSession.InviteSubSessionTypes;
import com.facebook.inject.Assisted;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.friendselector.CaspianFriendSelectorItemRow;
import com.facebook.widget.friendselector.CaspianFriendSelectorSectionHeader;
import com.facebook.widget.sectionedadapter.SectionedAdapterForRecyclerView.SectionAdapter;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: click_time */
public class EventsExtendedInviteFriendsListSectionAdapter extends SectionAdapter {
    private final String f17601a;
    public final boolean f17602b;
    public final InviteSubSessionTypes f17603c;
    public final Set<String> f17604d;
    private boolean f17605e;
    public int f17606f = Integer.MAX_VALUE;
    public C24752 f17607g;
    private ImmutableList<SimpleUserToken> f17608h = RegularImmutableList.a;
    public Toaster f17609i;
    public InviteSessionLogger f17610j;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: click_time */
    public @interface ItemViewType {
    }

    @Inject
    public EventsExtendedInviteFriendsListSectionAdapter(InviteSessionLogger inviteSessionLogger, Toaster toaster, @Nullable @Assisted String str, @Assisted boolean z, @Assisted int i, @Assisted ImmutableList<SimpleUserToken> immutableList, @Assisted Set<String> set, @Assisted EventsExtendedInviteFriendSelectionChangedListener eventsExtendedInviteFriendSelectionChangedListener, @Assisted InviteSubSessionTypes inviteSubSessionTypes) {
        this.f17610j = inviteSessionLogger;
        this.f17609i = toaster;
        this.f17601a = str;
        this.f17602b = z;
        this.f17606f = i;
        this.f17608h = immutableList;
        this.f17604d = set;
        this.f17607g = eventsExtendedInviteFriendSelectionChangedListener;
        this.f17603c = inviteSubSessionTypes;
    }

    public final View m17969d(ViewGroup viewGroup, int i) {
        switch (i) {
            case 0:
                return new CaspianFriendSelectorItemRow(viewGroup.getContext());
            case 1:
                return new CaspianFriendSelectorSectionHeader(viewGroup.getContext());
            case 2:
                return LayoutInflater.from(viewGroup.getContext()).inflate(2130904158, viewGroup, false);
            default:
                throw new IllegalArgumentException("Unknown View Type");
        }
    }

    public final void m17966a(View view, int i) {
        switch (getItemViewType(i)) {
            case 0:
                CaspianFriendSelectorItemRow caspianFriendSelectorItemRow = (CaspianFriendSelectorItemRow) view;
                SimpleUserToken simpleUserToken = (SimpleUserToken) this.f17608h.get(i - 1);
                caspianFriendSelectorItemRow.a(simpleUserToken, this.f17604d.contains(simpleUserToken.p()));
                caspianFriendSelectorItemRow.setAsHeaderItem(false);
                caspianFriendSelectorItemRow.setFocusable(true);
                return;
            case 1:
                CaspianFriendSelectorSectionHeader caspianFriendSelectorSectionHeader = (CaspianFriendSelectorSectionHeader) view;
                caspianFriendSelectorSectionHeader.a(this.f17601a);
                caspianFriendSelectorSectionHeader.setFocusable(true);
                return;
            case 2:
                view.findViewById(2131561559).setVisibility(this.f17605e ? 0 : 8);
                return;
            default:
                throw new IllegalArgumentException("Unknown View Type");
        }
    }

    public int getViewTypeCount() {
        return 3;
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == m17965d()) {
            return 2;
        }
        return 0;
    }

    public int getCount() {
        return this.f17608h.size() + 2;
    }

    public Object getItem(int i) {
        if (i == 0) {
            return this.f17601a;
        }
        if (i == m17965d()) {
            return null;
        }
        return this.f17608h.get(i - 1);
    }

    private int m17965d() {
        return this.f17608h.size() + 1;
    }

    public final void m17967a(ImmutableList<SimpleUserToken> immutableList) {
        this.f17608h = immutableList;
        notifyDataSetChanged();
    }

    public final void m17968b(boolean z) {
        if (this.f17605e != z) {
            this.f17605e = z;
            j_(m17965d());
        }
    }
}
