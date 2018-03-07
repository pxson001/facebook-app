package com.facebook.widget.tokenizedtypeahead.chips;

import android.content.res.Resources;
import com.facebook.telephony.FbPhoneNumberUtils;
import com.facebook.user.model.User.Type;
import javax.inject.Inject;

/* compiled from: com.facebook.platform.status.ERROR_TYPE */
public class ContactChipUserStringUtil {
    public final FbPhoneNumberUtils f20113a;
    public final Resources f20114b;

    /* compiled from: com.facebook.platform.status.ERROR_TYPE */
    public /* synthetic */ class C15101 {
        public static final /* synthetic */ int[] f20112a = new int[Type.values().length];

        static {
            try {
                f20112a[Type.FACEBOOK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f20112a[Type.FACEBOOK_CONTACT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f20112a[Type.PHONE_NUMBER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f20112a[Type.ADDRESS_BOOK.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f20112a[Type.EMAIL.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    @Inject
    public ContactChipUserStringUtil(FbPhoneNumberUtils fbPhoneNumberUtils, Resources resources) {
        this.f20113a = fbPhoneNumberUtils;
        this.f20114b = resources;
    }
}
