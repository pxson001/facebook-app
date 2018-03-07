package com.facebook.friending.center.ui;

import com.facebook.friending.center.model.FriendsCenterListItemModel;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: add_people */
public class FriendsCenterListAdapter extends FriendsCenterBaseAdapter {
    public final List<FriendsCenterListItemModel> f20172c = new ArrayList();

    public static FriendsCenterListAdapter m20485b(InjectorLike injectorLike) {
        return new FriendsCenterListAdapter(FriendsCenterCommonBinder.m20469b(injectorLike));
    }

    @Inject
    public FriendsCenterListAdapter(FriendsCenterCommonBinder friendsCenterCommonBinder) {
        super(friendsCenterCommonBinder);
    }

    public int getCount() {
        int i = (!this.f20124a || this.f20172c.isEmpty()) ? 0 : 1;
        return i + this.f20172c.size();
    }

    public final FriendsCenterListItemModel mo900a(int i) {
        Object obj = (this.f20124a && i == getCount() - 1) ? 1 : null;
        return obj != null ? null : (FriendsCenterListItemModel) this.f20172c.get(i);
    }

    public final int mo899a(long j) {
        int size = this.f20172c.size();
        for (int i = 0; i < size; i++) {
            if (((FriendsCenterListItemModel) this.f20172c.get(i)).m20172a() == j) {
                return i;
            }
        }
        return -1;
    }

    public final void m20488a(List<FriendsCenterListItemModel> list) {
        this.f20172c.addAll(list);
        AdapterDetour.a(this, 414387080);
    }
}
