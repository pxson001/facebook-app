package com.facebook.messaging.inbox2.recents;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel.MessengerInboxUnitItemsModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: selfupdate_download_failed_with_error */
public class RecentVideoInboxItem extends InboxUnitItem implements InboxRecentItem {
    @Nullable
    public final String f2948f;
    @Nullable
    public final String f2949g;
    public final String f2950h;
    public final Uri f2951i;
    public final Uri f2952j;
    public final Uri f2953k;
    @Nullable
    public final Uri f2954l;
    @Nullable
    public final Uri f2955m;
    public final int f2956n;
    public final int f2957o;
    public final int f2958p;

    public RecentVideoInboxItem(NodesModel nodesModel, MessengerInboxUnitItemsModel messengerInboxUnitItemsModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2, int i3) {
        Uri uri = null;
        super(nodesModel, messengerInboxUnitItemsModel);
        this.f2950h = str;
        this.f2948f = str2;
        this.f2949g = str3;
        this.f2951i = Uri.parse(str4);
        this.f2952j = str5 != null ? Uri.parse(str5) : null;
        this.f2953k = Uri.parse(str6);
        this.f2954l = TextUtils.isEmpty(str7) ? null : Uri.parse(str7);
        if (!TextUtils.isEmpty(str8)) {
            uri = Uri.parse(str8);
        }
        this.f2955m = uri;
        this.f2956n = i;
        this.f2957o = i2;
        this.f2958p = i3;
    }

    public final InboxItemType m2935a() {
        return InboxItemType.V2_RECENT_VIDEO;
    }

    public final InboxItemViewType m2936b() {
        return InboxItemViewType.V2_RECENT_ITEM;
    }

    public final String m2937d() {
        return "tap_recent_videos";
    }

    public final String mo96f() {
        return this.f2950h;
    }

    @Nullable
    public final String lZ_() {
        return this.f2948f;
    }

    @Nullable
    public final String ma_() {
        return this.f2949g;
    }

    @Nullable
    public final String mo97i() {
        return null;
    }

    public final Uri mb_() {
        return this.f2953k;
    }

    public final Uri mc_() {
        return this.f2954l;
    }

    @Nullable
    public final Uri mo99m() {
        return this.f2955m;
    }

    public final boolean m2938e() {
        return false;
    }

    public final String m2941l() {
        return lZ_();
    }
}
