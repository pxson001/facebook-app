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
/* compiled from: selfupdate_no_free_space_to_download */
public class RecentLinkInboxItem extends InboxUnitItem implements InboxRecentItem {
    private final String f2940f;
    private final String f2941g;
    private final String f2942h;
    private final Uri f2943i;
    private final String f2944j;
    private final Uri f2945k;
    private final Uri f2946l;

    public RecentLinkInboxItem(NodesModel nodesModel, MessengerInboxUnitItemsModel messengerInboxUnitItemsModel, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Uri uri = null;
        super(nodesModel, messengerInboxUnitItemsModel);
        this.f2940f = str;
        this.f2941g = str2;
        this.f2942h = str3;
        this.f2943i = TextUtils.isEmpty(str4) ? null : Uri.parse(str4);
        this.f2944j = str5;
        this.f2945k = TextUtils.isEmpty(str6) ? null : Uri.parse(str6);
        if (!TextUtils.isEmpty(str7)) {
            uri = Uri.parse(str7);
        }
        this.f2946l = uri;
    }

    public final String mo96f() {
        return this.f2940f;
    }

    @Nullable
    public final String lZ_() {
        return this.f2941g;
    }

    @Nullable
    public final String ma_() {
        return this.f2942h;
    }

    @Nullable
    public final String mo97i() {
        return this.f2944j;
    }

    public final Uri mb_() {
        return this.f2943i;
    }

    public final Uri mc_() {
        return this.f2945k;
    }

    @Nullable
    public final Uri mo99m() {
        return this.f2946l;
    }

    public final InboxItemType m2923a() {
        return InboxItemType.V2_RECENT_LINK;
    }

    public final InboxItemViewType m2924b() {
        return InboxItemViewType.V2_RECENT_ITEM;
    }

    public final String m2925d() {
        return "tap_recent_links";
    }

    public final boolean m2926e() {
        return false;
    }

    public final String m2929l() {
        return lZ_();
    }
}
