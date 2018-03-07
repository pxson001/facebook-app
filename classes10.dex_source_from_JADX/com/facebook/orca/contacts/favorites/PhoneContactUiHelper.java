package com.facebook.orca.contacts.favorites;

import android.content.res.Resources;
import com.facebook.telephony.FbPhoneNumberUtils;
import com.facebook.user.model.User;
import com.facebook.user.model.UserPhoneNumber;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: onAdminPromotionDeclined callback inappropriately called */
public class PhoneContactUiHelper {
    private final FbPhoneNumberUtils f6009a;
    private final Resources f6010b;

    @Inject
    public PhoneContactUiHelper(FbPhoneNumberUtils fbPhoneNumberUtils, Resources resources) {
        this.f6009a = fbPhoneNumberUtils;
        this.f6010b = resources;
    }

    public final String m5650a(User user) {
        Preconditions.checkArgument(user.ao());
        String str = "";
        UserPhoneNumber w = user.w();
        if (w == null) {
            return str;
        }
        str = this.f6009a.b(w.b);
        if (Strings.isNullOrEmpty(str)) {
            return str;
        }
        str = str + "  ";
        switch (w.d) {
            case 1:
                return str + this.f6010b.getString(2131231804);
            case 2:
                return str + this.f6010b.getString(2131231803);
            case 3:
                return str + this.f6010b.getString(2131231805);
            default:
                return str;
        }
    }
}
