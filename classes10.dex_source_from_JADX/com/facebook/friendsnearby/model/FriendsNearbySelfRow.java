package com.facebook.friendsnearby.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.contentview.ContentViewWithButton.Theme;
import com.facebook.gk.store.GatekeeperStoreImpl;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: _first_name */
public class FriendsNearbySelfRow implements FriendsNearbyRow {
    private final GatekeeperStoreImpl f20565a;
    public String f20566b;
    public Uri f20567c;
    public String f20568d;
    public String f20569e;

    @Inject
    public FriendsNearbySelfRow(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f20565a = gatekeeperStoreImpl;
    }

    public final String mo920i() {
        return "friends_nearby_self_view_section";
    }

    public final String mo908a() {
        return this.f20566b;
    }

    @Nullable
    public final Uri mo911b() {
        return this.f20567c;
    }

    public final String mo913c() {
        return this.f20568d;
    }

    @Nullable
    public final String mo909a(Context context) {
        return this.f20569e;
    }

    @Nullable
    public final String mo915d() {
        return null;
    }

    public final String mo916e() {
        return "aura";
    }

    public final boolean mo917f() {
        return !StringUtil.a(this.f20569e) && this.f20565a.a(1000, false);
    }

    public final boolean mo918g() {
        return !StringUtil.a(this.f20569e) && this.f20565a.a(1000, false);
    }

    public final Drawable mo907a(Resources resources) {
        return resources.getDrawable(2130840490);
    }

    public final Drawable mo910b(Resources resources) {
        return null;
    }

    public final String mo912b(Context context) {
        return null;
    }

    public final Theme mo919h() {
        return Theme.NONE;
    }

    public final String mo914c(Context context) {
        return null;
    }
}
