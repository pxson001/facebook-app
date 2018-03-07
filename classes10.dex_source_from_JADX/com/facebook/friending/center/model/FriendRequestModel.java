package com.facebook.friending.center.model;

import com.facebook.common.util.StringUtil;
import com.facebook.friending.common.list.model.FriendListItemModel;
import javax.annotation.Nullable;

/* compiled from: afc_null_state */
public class FriendRequestModel extends FriendsCenterListItemModel implements FriendListItemModel {
    public final String f20009b;
    public final boolean f20010c;
    @Nullable
    private final String f20011d;
    public boolean f20012e;

    /* compiled from: afc_null_state */
    public class Builder<T extends Builder> extends com.facebook.friending.center.model.FriendsCenterListItemModel.Builder<T> {
        public String f19999a;
        public String f20000b;

        public /* synthetic */ FriendsCenterListItemModel mo892b() {
            return mo896a();
        }

        public FriendRequestModel mo896a() {
            return new FriendRequestModel(this);
        }
    }

    protected FriendRequestModel(Builder builder) {
        super(builder);
        this.f20009b = builder.f19999a;
        this.f20010c = !StringUtil.a(this.f20009b);
        this.f20012e = true;
        this.f20011d = builder.f20000b;
    }

    public final int mo893e() {
        throw new UnsupportedOperationException("FriendRequestItemModel does not support this operation");
    }

    @Nullable
    public final String mo894h() {
        return this.f20011d;
    }
}
