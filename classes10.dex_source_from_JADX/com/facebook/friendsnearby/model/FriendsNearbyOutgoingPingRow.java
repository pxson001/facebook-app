package com.facebook.friendsnearby.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.fbui.widget.contentview.ContentViewWithButton.Theme;
import com.facebook.friendsnearby.pingdialog.LocationPingParams;
import javax.annotation.Nullable;

/* compiled from: _ui */
public class FriendsNearbyOutgoingPingRow implements FriendsNearbyRow {
    final Uri f20524a;
    final String f20525b;
    final String f20526c;
    public LocationPingParams f20527d;
    public String f20528e;

    public static FriendsNearbyOutgoingPingRow m20928a(LocationPingParams locationPingParams, Uri uri, String str, String str2, String str3) {
        return new FriendsNearbyOutgoingPingRow(locationPingParams, uri, str, str2, str3);
    }

    private FriendsNearbyOutgoingPingRow(LocationPingParams locationPingParams, Uri uri, String str, String str2, String str3) {
        this.f20527d = locationPingParams;
        this.f20524a = uri;
        this.f20525b = str;
        this.f20528e = str2;
        this.f20526c = str3;
    }

    public final String mo920i() {
        return this.f20526c;
    }

    public final String mo908a() {
        return this.f20527d.f20620a;
    }

    @Nullable
    public final Uri mo911b() {
        return this.f20524a;
    }

    public final String mo913c() {
        return this.f20525b;
    }

    @Nullable
    public final String mo909a(Context context) {
        return this.f20528e;
    }

    @Nullable
    public final String mo915d() {
        return null;
    }

    public final String mo916e() {
        return "aura";
    }

    public final boolean mo917f() {
        return true;
    }

    public final boolean mo918g() {
        return true;
    }

    public final Drawable mo907a(Resources resources) {
        return resources.getDrawable(2130840480);
    }

    public final Drawable mo910b(Resources resources) {
        return null;
    }

    public final String mo912b(Context context) {
        return "";
    }

    public final Theme mo919h() {
        return Theme.NONE;
    }

    public final String mo914c(Context context) {
        return context.getString(2131241990, new Object[]{this.f20525b});
    }
}
