package com.facebook.friendsnearby.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentViewWithButton.Theme;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyHighlightQueryModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyHighlightQueryModel.NearbyFriendsContactsSetItemModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyNewListItemModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyNewListItemModel.AdditionalItemDescriptionModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyNewListItemModel.ContactModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyNewListItemModel.ContactModel.RepresentedProfileModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbySearchQueryModel.FriendsModel.EdgesModel.NodeModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbySearchQueryModel.FriendsModel.EdgesModel.NodeModel.NearbyFriendsContactsSetItemModel.ItemDescriptionModel;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.inject.Assisted;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: a20d7aea259612e2b3ed98de1b8fcada */
public class FriendsNearbyNewListRow implements FriendsNearbyRow {
    public boolean f20509a;
    private String f20510b;
    private String f20511c;
    private Uri f20512d;
    private String f20513e;
    public String f20514f;
    public String f20515g;
    private String f20516h;
    private GatekeeperStoreImpl f20517i;

    @Nullable
    public static FriendsNearbyNewListRow m20898a(@Nullable FriendsNearbyNewListItemModel friendsNearbyNewListItemModel, String str, boolean z, FriendsNearbyNewListRowProvider friendsNearbyNewListRowProvider) {
        String str2 = null;
        if (friendsNearbyNewListItemModel == null) {
            return null;
        }
        ContactModel c = friendsNearbyNewListItemModel.m21398c();
        if (c == null) {
            return null;
        }
        RepresentedProfileModel a = c.m21375a();
        if (a == null) {
            return null;
        }
        String b = a.m21369b();
        if (b == null) {
            return null;
        }
        Uri uri;
        String str3;
        String str4;
        DefaultImageFields d = a.m21371d();
        if (d == null || d.b() == null) {
            uri = null;
        } else {
            uri = Uri.parse(d.b());
        }
        String c2 = a.m21370c();
        if (friendsNearbyNewListItemModel.m21399d() == null) {
            str3 = "";
        } else {
            str3 = friendsNearbyNewListItemModel.m21399d().m21382a();
        }
        AdditionalItemDescriptionModel b2 = friendsNearbyNewListItemModel.m21397b();
        if (b2 == null) {
            str4 = "";
        } else {
            str4 = b2.m21355a();
        }
        if (friendsNearbyNewListItemModel.nq_() != null) {
            str2 = friendsNearbyNewListItemModel.nq_().m21387a();
        }
        return friendsNearbyNewListRowProvider.m20915a(b, uri, c2, str3, str4, m20900c(str2), str, z);
    }

    @Nullable
    public static FriendsNearbyNewListRow m20897a(@Nullable FriendsNearbyHighlightQueryModel friendsNearbyHighlightQueryModel, String str, boolean z, FriendsNearbyNewListRowProvider friendsNearbyNewListRowProvider) {
        Uri uri = null;
        if (friendsNearbyHighlightQueryModel == null) {
            return null;
        }
        NearbyFriendsContactsSetItemModel d = friendsNearbyHighlightQueryModel.m21219d();
        if (d == null) {
            return null;
        }
        String b = friendsNearbyHighlightQueryModel.m21217b();
        if (b == null) {
            return null;
        }
        DefaultImageFields nm_ = friendsNearbyHighlightQueryModel.nm_();
        if (nm_ != null) {
            uri = Uri.parse(nm_.b());
        }
        return friendsNearbyNewListRowProvider.m20915a(b, uri, friendsNearbyHighlightQueryModel.m21218c(), d.m21206b() == null ? "" : d.m21206b().m21199a(), d.m21204a() == null ? "" : d.m21204a().m21193a(), "aura", str, z);
    }

    @Nullable
    public static FriendsNearbyNewListRow m20899a(@Nullable NodeModel nodeModel, String str, boolean z, FriendsNearbyNewListRowProvider friendsNearbyNewListRowProvider) {
        Uri uri = null;
        if (nodeModel == null || nodeModel.m21483j() == null) {
            return null;
        }
        if (nodeModel.m21486m() != null) {
            uri = Uri.parse(nodeModel.m21486m().b());
        }
        NodeModel.NearbyFriendsContactsSetItemModel l = nodeModel.m21485l();
        String str2 = "";
        if (l != null) {
            ItemDescriptionModel j = l.m21458j();
            if (j != null) {
                str2 = j.m21447a();
            }
        }
        String str3 = "";
        if (!(l == null || l.m21456a() == null)) {
            str3 = l.m21456a().m21441a();
        }
        return friendsNearbyNewListRowProvider.m20915a(nodeModel.m21483j(), uri, nodeModel.m21484k(), str2, str3, "aura", str, z);
    }

    private static String m20900c(String str) {
        return (str == null || !(str.startsWith("check_in") || str.startsWith("current_city"))) ? "aura" : str;
    }

    @Inject
    public FriendsNearbyNewListRow(@Assisted String str, @Assisted Uri uri, @Assisted String str2, @Assisted String str3, @Assisted String str4, @Assisted String str5, @Assisted String str6, @Assisted boolean z, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f20511c = str;
        this.f20512d = uri;
        this.f20513e = str2;
        this.f20514f = str3;
        this.f20515g = str4;
        this.f20516h = str5;
        this.f20510b = str6;
        this.f20509a = z;
        this.f20517i = gatekeeperStoreImpl;
    }

    public final String mo920i() {
        return this.f20510b;
    }

    public final String mo908a() {
        return this.f20511c;
    }

    @Nullable
    public final Uri mo911b() {
        return this.f20512d;
    }

    public final String mo913c() {
        return this.f20513e;
    }

    @Nullable
    public final String mo909a(Context context) {
        return this.f20514f;
    }

    @Nullable
    public final String mo915d() {
        return this.f20515g;
    }

    public final String mo916e() {
        return this.f20516h;
    }

    public final boolean mo917f() {
        return this.f20516h.startsWith("aura");
    }

    public final boolean mo918g() {
        return true;
    }

    public final Drawable mo907a(Resources resources) {
        GlyphColorizer glyphColorizer = new GlyphColorizer(resources);
        if (this.f20517i.a(999, false)) {
            return glyphColorizer.a(2130839685, resources.getColor(2131361937));
        }
        return resources.getDrawable(this.f20509a ? 2130840480 : 2130840477);
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
        return context.getString(2131241990, new Object[]{this.f20513e});
    }
}
