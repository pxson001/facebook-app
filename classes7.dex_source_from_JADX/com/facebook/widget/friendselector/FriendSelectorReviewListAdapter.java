package com.facebook.widget.friendselector;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.HashSet;
import java.util.Set;

/* compiled from: db_handle_batch_fail */
public class FriendSelectorReviewListAdapter extends BaseAdapter {
    private ImmutableList<SimpleUserToken> f16089a;
    private final Set<SimpleUserToken> f16090b = new HashSet();

    public /* synthetic */ Object getItem(int i) {
        return m20111b(i);
    }

    public FriendSelectorReviewListAdapter(ImmutableList<SimpleUserToken> immutableList) {
        this.f16089a = immutableList;
    }

    public final void m20115a(ImmutableList<SimpleUserToken> immutableList) {
        this.f16089a = immutableList;
        this.f16090b.clear();
        AdapterDetour.b(this, 1735902286);
    }

    public int getCount() {
        return this.f16089a.size();
    }

    private SimpleUserToken m20111b(int i) {
        return (SimpleUserToken) this.f16089a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View caspianFriendSelectorReviewItemRow;
        if (view == null) {
            caspianFriendSelectorReviewItemRow = new CaspianFriendSelectorReviewItemRow(viewGroup.getContext());
        } else {
            caspianFriendSelectorReviewItemRow = view;
        }
        SimpleUserToken b = m20111b(i);
        ((CaspianFriendSelectorItemRow) caspianFriendSelectorReviewItemRow).m20004a(b, !this.f16090b.contains(b));
        return caspianFriendSelectorReviewItemRow;
    }

    public final void m20114a(int i) {
        SimpleUserToken b = m20111b(i);
        if (this.f16090b.contains(b)) {
            this.f16090b.remove(b);
        } else {
            this.f16090b.add(b);
        }
        AdapterDetour.a(this, 407454884);
    }

    public final ImmutableSet<SimpleUserToken> m20113a() {
        return ImmutableSet.copyOf(this.f16090b);
    }

    public final int m20116b() {
        return this.f16089a.size() - this.f16090b.size();
    }

    public final int m20112a(BaseToken baseToken) {
        return this.f16089a.indexOf(baseToken);
    }
}
