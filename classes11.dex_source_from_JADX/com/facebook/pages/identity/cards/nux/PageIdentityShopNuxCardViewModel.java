package com.facebook.pages.identity.cards.nux;

import android.content.res.Resources;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.pages.common.logging.analytics.AdminEvent;

/* compiled from: privacy_checkup_app_delete_dialog_delete_posts */
public class PageIdentityShopNuxCardViewModel extends PageIdentityNuxCardViewModel {
    public PageIdentityShopNuxCardViewModel(Resources resources) {
        super(resources);
    }

    public final int mo83a() {
        return 2130842507;
    }

    public final int mo85b() {
        return this.f3555a.getColor(2131363062);
    }

    public final String mo87c() {
        return this.f3555a.getString(2131235543);
    }

    public final String mo84a(String str) {
        return StringFormatUtil.formatStrLocaleSafe(this.f3555a.getString(2131235544), str);
    }

    public final String mo89d() {
        return this.f3555a.getString(2131235545);
    }

    public final String mo86b(String str) {
        return StringFormatUtil.formatStrLocaleSafe(this.f3555a.getString(2131235544), str);
    }

    public final String mo90e() {
        return this.f3555a.getString(2131235546);
    }

    public final String mo88c(String str) {
        return StringFormatUtil.formatStrLocaleSafe(FBLinks.eB, str);
    }

    public final CharSequence mo91f() {
        return this.f3555a.getString(2131235547);
    }

    public final AdminEvent mo92g() {
        return AdminEvent.EVENT_ADMIN_NUX_SHOP_START;
    }

    public final AdminEvent mo93h() {
        return AdminEvent.EVENT_ADMIN_NUX_SHOP_CLOSE;
    }

    public final String mo94i() {
        return "shop";
    }
}
