package com.facebook.friending.center.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.friending.center.model.FriendsCenterListItemModel;
import com.facebook.friending.center.ui.FriendsCenterCommonBinder.OnPYMKResponseListener;
import com.facebook.friending.common.list.FriendListItemView;
import com.facebook.friending.common.list.FriendRequestItemView;
import com.facebook.friending.common.list.model.FriendListItemModel;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.FbBaseAdapter;

/* compiled from: add_pin */
public abstract class FriendsCenterBaseAdapter extends FbBaseAdapter {
    protected boolean f20124a = false;
    public boolean f20125b;
    public FriendsCenterCommonBinder f20126c;
    public int f20127d = 0;

    /* compiled from: add_pin */
    public class C28581 implements OnPYMKResponseListener {
        final /* synthetic */ FriendsCenterBaseAdapter f20122a;

        public C28581(FriendsCenterBaseAdapter friendsCenterBaseAdapter) {
            this.f20122a = friendsCenterBaseAdapter;
        }

        public final void mo895a(long j) {
            if (this.f20122a.mo899a(j) != -1) {
                AdapterDetour.a(this.f20122a, -269368389);
            }
        }
    }

    /* compiled from: add_pin */
    public enum RowType {
        PERSON_YOU_MAY_KNOW,
        RESPONDED_PERSON_YOU_MAY_KNOW,
        REGULAR_LIST_ITEM,
        LOADING_ITEM
    }

    protected abstract int mo899a(long j);

    protected abstract FriendsCenterListItemModel mo900a(int i);

    public FriendsCenterBaseAdapter(FriendsCenterCommonBinder friendsCenterCommonBinder) {
        this.f20126c = friendsCenterCommonBinder;
    }

    public Object getItem(int i) {
        this.f20127d = Math.max(this.f20127d, i);
        return mo900a(i);
    }

    public final View m20456a(int i, ViewGroup viewGroup) {
        switch (RowType.values()[i]) {
            case PERSON_YOU_MAY_KNOW:
                FriendRequestItemView friendRequestItemView = new FriendRequestItemView(viewGroup.getContext());
                friendRequestItemView.setThumbnailSize(ThumbnailSize.XLARGE);
                return friendRequestItemView;
            case RESPONDED_PERSON_YOU_MAY_KNOW:
                return m20454b(viewGroup);
            case REGULAR_LIST_ITEM:
                return m20454b(viewGroup);
            case LOADING_ITEM:
                return LayoutInflater.from(viewGroup.getContext()).inflate(2130904517, viewGroup, false);
            default:
                throw new IllegalStateException("Unexpected Type");
        }
    }

    public final void m20458a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        switch (RowType.values()[i2]) {
            case PERSON_YOU_MAY_KNOW:
                this.f20126c.m20481a((FriendRequestItemView) view, (FriendListItemModel) obj);
                return;
            case RESPONDED_PERSON_YOU_MAY_KNOW:
                this.f20126c.m20479a((FriendListItemView) view, (FriendListItemModel) obj, true);
                return;
            case REGULAR_LIST_ITEM:
                this.f20126c.m20478a((FriendListItemView) view, (FriendListItemModel) obj);
                return;
            default:
                return;
        }
    }

    public int getItemViewType(int i) {
        Object obj = (this.f20124a && i == getCount() - 1) ? 1 : null;
        if (obj != null) {
            return RowType.LOADING_ITEM.ordinal();
        }
        if (!this.f20125b) {
            return RowType.REGULAR_LIST_ITEM.ordinal();
        }
        Object obj2;
        GraphQLFriendshipStatus f = mo900a(i).f();
        if (GraphQLFriendshipStatus.CAN_REQUEST.equals(f) || GraphQLFriendshipStatus.INCOMING_REQUEST.equals(f)) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            return RowType.PERSON_YOU_MAY_KNOW.ordinal();
        }
        return RowType.RESPONDED_PERSON_YOU_MAY_KNOW.ordinal();
    }

    public int getViewTypeCount() {
        return RowType.values().length;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean isEnabled(int i) {
        return getItemViewType(i) != RowType.LOADING_ITEM.ordinal();
    }

    public final void m20459a(boolean z) {
        if (this.f20124a != z) {
            this.f20124a = z;
            AdapterDetour.a(this, -165332499);
        }
    }

    public final void m20460c() {
        this.f20126c.m20477a();
    }

    private static FriendListItemView m20454b(ViewGroup viewGroup) {
        FriendListItemView friendListItemView = new FriendListItemView(viewGroup.getContext());
        friendListItemView.setThumbnailSize(ThumbnailSize.XLARGE);
        return friendListItemView;
    }
}
