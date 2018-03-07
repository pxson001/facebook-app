package com.facebook.contacts.iterator;

import android.database.Cursor;
import com.facebook.common.cursors.CachedColumnNameCursorProvider;
import com.facebook.common.cursors.CursorHelper;
import com.facebook.common.util.StringUtil;
import com.facebook.contacts.model.PhonebookContact.Builder;
import com.facebook.contacts.model.PhonebookEmailAddress;
import com.facebook.contacts.model.PhonebookPhoneNumber;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.user.model.UserPhoneNumber;
import com.facebook.user.util.UserPhoneNumberUtil;
import javax.inject.Inject;

/* compiled from: payment_provider */
public class MessengerPhonebookContactIterator extends AbstractPhonebookContactIterator {
    private final UserPhoneNumberUtil f8248d;

    @Inject
    public MessengerPhonebookContactIterator(UserPhoneNumberUtil userPhoneNumberUtil, CachedColumnNameCursorProvider cachedColumnNameCursorProvider, @Assisted Cursor cursor) {
        super(cachedColumnNameCursorProvider, cursor);
        this.f8248d = userPhoneNumberUtil;
    }

    protected final void mo938a(Builder builder) {
        String c = CursorHelper.m11026c(this.f8215c, "data1");
        if (!StringUtil.a(c)) {
            TracerDetour.a("parseSmsAddress", 231097735);
            try {
                if (this.f8248d.b(c)) {
                    int a = CursorHelper.m11024a(this.f8215c, "data2");
                    UserPhoneNumber a2 = this.f8248d.a(c, a);
                    if (a2 != null) {
                        builder.m12103a(new PhonebookPhoneNumber(a2.b(), a, null));
                    }
                }
                TracerDetour.a(-1998265337);
            } catch (Throwable th) {
                TracerDetour.a(1745343805);
            }
        }
    }

    protected final void mo939b(Builder builder) {
        Object c = CursorHelper.m11026c(this.f8215c, "data1");
        if (!StringUtil.a(c)) {
            builder.m12102a(new PhonebookEmailAddress(c.toLowerCase(), CursorHelper.m11024a(this.f8215c, "data2"), CursorHelper.m11026c(this.f8215c, "data3")));
        }
    }

    protected final void mo940c(Builder builder) {
        int i = 0;
        String c = CursorHelper.m11026c(this.f8215c, "data1");
        String c2 = CursorHelper.m11026c(this.f8215c, "data2");
        String c3 = CursorHelper.m11026c(this.f8215c, "data3");
        int a = CursorHelper.m11024a(this.f8215c, "is_super_primary");
        int length = c == null ? 0 : c.length();
        String str = builder.f8267b;
        if (str != null) {
            i = str.length();
        }
        if (length > i || (a != 0 && length > 0)) {
            builder.f8267b = c;
            builder.f8268c = c2;
            builder.f8269d = c3;
        }
    }
}
