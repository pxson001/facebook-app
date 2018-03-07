package com.facebook.pages.identity.cards.nux;

import android.content.res.Resources;
import android.text.style.ForegroundColorSpan;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.SpannableStringFormatter;
import com.facebook.common.util.SpannableStringSubstitution;
import com.facebook.pages.common.constants.PagesConstants.URL;
import com.facebook.pages.common.logging.analytics.AdminEvent;

/* compiled from: privacy_checkup_app_delete_dialog_exposed */
public class PageIdentityServicesNuxCardViewModel extends PageIdentityNuxCardViewModel {
    public PageIdentityServicesNuxCardViewModel(Resources resources) {
        super(resources);
    }

    public final int mo83a() {
        return 2130842507;
    }

    public final int mo85b() {
        return this.f3555a.getColor(2131363056);
    }

    public final String mo87c() {
        return this.f3555a.getString(2131235520);
    }

    public final String mo84a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StringFormatUtil.formatStrLocaleSafe(this.f3555a.getString(2131235521), str));
        stringBuilder.append("\n");
        stringBuilder.append(this.f3555a.getString(2131235522));
        stringBuilder.append("\n");
        stringBuilder.append(this.f3555a.getString(2131233658));
        stringBuilder.append(this.f3555a.getString(2131235523));
        stringBuilder.append("\n");
        stringBuilder.append(this.f3555a.getString(2131233658));
        stringBuilder.append(this.f3555a.getString(2131235524));
        stringBuilder.append("\n");
        stringBuilder.append(this.f3555a.getString(2131233658));
        stringBuilder.append(this.f3555a.getString(2131235525));
        return stringBuilder.toString();
    }

    public final String mo89d() {
        return this.f3555a.getString(2131235526);
    }

    public final String mo86b(String str) {
        return StringFormatUtil.formatStrLocaleSafe(this.f3555a.getString(2131235518), str);
    }

    public final String mo90e() {
        return this.f3555a.getString(2131235519);
    }

    public final String mo88c(String str) {
        return StringFormatUtil.formatStrLocaleSafe(URL.D, str);
    }

    public final CharSequence mo91f() {
        return SpannableStringFormatter.a(this.f3555a, 2131235528, new SpannableStringSubstitution[]{new SpannableStringSubstitution(2131235527, new ForegroundColorSpan(this.f3555a.getColor(2131361921)), 0)});
    }

    public final AdminEvent mo92g() {
        return AdminEvent.EVENT_ADMIN_START_ADD_SERVICES_CARD;
    }

    public final AdminEvent mo93h() {
        return AdminEvent.EVENT_ADMIN_CLOSE_ADD_SERVICES_CARD;
    }

    public final String mo94i() {
        return "services";
    }
}
