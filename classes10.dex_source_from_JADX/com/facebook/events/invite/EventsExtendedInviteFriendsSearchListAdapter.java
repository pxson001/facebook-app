package com.facebook.events.invite;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.events.invite.EventsExtendedInviteActivity.C24752;
import com.facebook.events.invite.InviteSubSession.InviteSubSessionTypes;
import com.facebook.inject.Assisted;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.friendselector.CaspianFriendSelectorItemRow;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: click_suggestion */
public class EventsExtendedInviteFriendsSearchListAdapter extends Adapter<RowHolder> {
    private final C24752 f17611a;
    private final Set<String> f17612b;
    private boolean f17613c;
    public int f17614d = Integer.MAX_VALUE;
    public ImmutableList<SimpleUserToken> f17615e = RegularImmutableList.a;
    public Toaster f17616f;
    private InviteSessionLogger f17617g;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: click_suggestion */
    public @interface ItemViewType {
    }

    /* compiled from: click_suggestion */
    public class RowHolder extends ViewHolder {
        public RowHolder(View view) {
            super(view);
        }
    }

    public final ViewHolder m17973a(ViewGroup viewGroup, int i) {
        View caspianFriendSelectorItemRow;
        switch (i) {
            case 0:
                caspianFriendSelectorItemRow = new CaspianFriendSelectorItemRow(viewGroup.getContext());
                ((CaspianFriendSelectorItemRow) caspianFriendSelectorItemRow).setAsHeaderItem(false);
                break;
            case 1:
                caspianFriendSelectorItemRow = LayoutInflater.from(viewGroup.getContext()).inflate(2130904158, viewGroup, false);
                break;
            default:
                throw new IllegalArgumentException("Unknown View Type");
        }
        return new RowHolder(caspianFriendSelectorItemRow);
    }

    public final void m17974a(ViewHolder viewHolder, int i) {
        RowHolder rowHolder = (RowHolder) viewHolder;
        switch (getItemViewType(i)) {
            case 0:
                SimpleUserToken simpleUserToken = (SimpleUserToken) this.f17615e.get(i);
                ((CaspianFriendSelectorItemRow) rowHolder.a).a(simpleUserToken, this.f17612b.contains(simpleUserToken.p()));
                return;
            case 1:
                rowHolder.a.setVisibility(this.f17613c ? 0 : 8);
                return;
            default:
                throw new IllegalArgumentException("Unknown View Type");
        }
    }

    @Inject
    public EventsExtendedInviteFriendsSearchListAdapter(InviteSessionLogger inviteSessionLogger, Toaster toaster, @Assisted Set<String> set, @Assisted EventsExtendedInviteFriendSelectionChangedListener eventsExtendedInviteFriendSelectionChangedListener) {
        this.f17617g = inviteSessionLogger;
        this.f17616f = toaster;
        this.f17612b = set;
        this.f17611a = eventsExtendedInviteFriendSelectionChangedListener;
    }

    public final int aZ_() {
        return this.f17615e.size() + 1;
    }

    public final boolean m17976f(int i) {
        boolean z = false;
        if (getItemViewType(i) != 0) {
            return false;
        }
        SimpleUserToken simpleUserToken = (SimpleUserToken) m17972g(i);
        if (!simpleUserToken.a()) {
            return false;
        }
        String p = simpleUserToken.p();
        boolean contains = this.f17612b.contains(p);
        if (contains) {
            this.f17612b.remove(p);
            this.f17617g.m18056b(InviteSubSessionTypes.INVITE_SEARCH, 1);
        } else if (this.f17612b.size() >= this.f17614d) {
            this.f17616f.b(new ToastBuilder(2131232667));
            return false;
        } else {
            this.f17612b.add(p);
            this.f17617g.m18053a(InviteSubSessionTypes.INVITE_SEARCH, 1);
        }
        C24752 c24752 = this.f17611a;
        if (!contains) {
            z = true;
        }
        c24752.m17869a(simpleUserToken, z, true);
        j_(i);
        return true;
    }

    public int getItemViewType(int i) {
        if (i == m17971d()) {
            return 1;
        }
        return 0;
    }

    private Object m17972g(int i) {
        if (getItemViewType(i) == 0) {
            return this.f17615e.get(i);
        }
        throw new UnsupportedOperationException("getItem call on non-invitee row is not supported");
    }

    public final void m17975b(boolean z) {
        if (this.f17613c != z) {
            this.f17613c = z;
            j_(m17971d());
        }
    }

    private int m17971d() {
        return this.f17615e.size();
    }
}
