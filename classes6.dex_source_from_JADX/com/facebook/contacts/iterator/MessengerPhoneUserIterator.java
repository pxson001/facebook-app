package com.facebook.contacts.iterator;

import android.database.Cursor;
import com.facebook.common.cursors.CachedColumnNameCursorProvider;
import com.facebook.common.cursors.CursorHelper;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.user.model.Name;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.facebook.user.model.UserEmailAddress;
import com.facebook.user.model.UserPhoneNumber;
import com.facebook.user.util.UserPhoneNumberUtil;
import com.google.common.base.Objects;
import com.google.common.collect.AbstractIterator;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: payment_value */
public class MessengerPhoneUserIterator extends AbstractIterator<User> {
    private static final Class<?> f8243a = MessengerPhoneUserIterator.class;
    public final Cursor f8244b;
    public final UserPhoneNumberUtil f8245c;
    public int f8246d;
    public boolean f8247e = false;

    @Inject
    public MessengerPhoneUserIterator(UserPhoneNumberUtil userPhoneNumberUtil, CachedColumnNameCursorProvider cachedColumnNameCursorProvider, @Assisted Cursor cursor) {
        this.f8245c = userPhoneNumberUtil;
        this.f8244b = CachedColumnNameCursorProvider.a(cursor);
    }

    protected final Object m12091a() {
        if (this.f8244b.isBeforeFirst()) {
            this.f8244b.moveToNext();
        }
        m12090f();
        if (this.f8244b.isAfterLast()) {
            return (User) b();
        }
        return m12089e();
    }

    private User m12089e() {
        String valueOf = String.valueOf(CursorHelper.m11025b(this.f8244b, "contact_id"));
        UserBuilder userBuilder = new UserBuilder();
        userBuilder.a(Type.ADDRESS_BOOK, valueOf);
        do {
            m12090f();
            if (this.f8244b.isAfterLast()) {
                break;
            } else if (!Objects.equal(String.valueOf(CursorHelper.m11025b(this.f8244b, "contact_id")), valueOf)) {
                return userBuilder.aa();
            } else {
                String c = CursorHelper.m11026c(this.f8244b, "mimetype");
                if ("vnd.android.cursor.item/name".equals(c)) {
                    int a = CursorHelper.m11024a(this.f8244b, "is_super_primary");
                    Name name = new Name(CursorHelper.m11026c(this.f8244b, "data2"), CursorHelper.m11026c(this.f8244b, "data3"), CursorHelper.m11026c(this.f8244b, "data1"));
                    if (this.f8247e) {
                        userBuilder.g = name;
                    } else {
                        int i;
                        int length = name.i().length();
                        Name name2 = userBuilder.g;
                        if (name2 == null) {
                            i = 0;
                        } else {
                            i = name2.i().length();
                        }
                        if (length > i || (a != 0 && length > 0)) {
                            userBuilder.g = name;
                        }
                    }
                } else if ("vnd.android.cursor.item/email_v2".equals(c)) {
                    Object c2 = CursorHelper.m11026c(this.f8244b, "data1");
                    int a2 = CursorHelper.m11024a(this.f8244b, "data2");
                    if (!StringUtil.a(c2)) {
                        r6 = userBuilder.c;
                        if (r6 == null) {
                            r6 = new ArrayList();
                            userBuilder.c = r6;
                        }
                        r6.add(new UserEmailAddress(c2, a2, !this.f8247e));
                    }
                } else if ("vnd.android.cursor.item/phone_v2".equals(c)) {
                    Object userPhoneNumber;
                    String c3 = CursorHelper.m11026c(this.f8244b, "data1");
                    int a3 = CursorHelper.m11024a(this.f8244b, "data2");
                    if (this.f8247e) {
                        userPhoneNumber = new UserPhoneNumber(c3, c3, a3);
                    } else {
                        UserPhoneNumber a4 = m12088a(c3, a3, this.f8246d, this.f8245c);
                    }
                    if (userPhoneNumber != null) {
                        r6 = userBuilder.d;
                        if (r6 == null) {
                            r6 = new ArrayList();
                            userBuilder.d = r6;
                        }
                        r6.add(userPhoneNumber);
                    }
                }
            }
        } while (this.f8244b.moveToNext());
        return userBuilder.aa();
    }

    private int m12090f() {
        int i = 0;
        while (true) {
            Object obj = null;
            if (!this.f8244b.isAfterLast()) {
                int a = CursorHelper.m11024a(this.f8244b, "deleted");
                if (a != 0) {
                    Long.valueOf(CursorHelper.m11025b(this.f8244b, "_id"));
                    this.f8244b.moveToNext();
                }
                if (a != 0) {
                    obj = 1;
                }
            }
            if (obj == null) {
                return i;
            }
            i++;
        }
    }

    public final void m12092c() {
        this.f8244b.close();
    }

    public static UserPhoneNumber m12088a(String str, int i, int i2, UserPhoneNumberUtil userPhoneNumberUtil) {
        UserPhoneNumber userPhoneNumber = null;
        if (i2 == 0 || i2 == i) {
            TracerDetour.a("parseSmsAddress", -520290726);
            try {
                if (userPhoneNumberUtil.a(str).m27092a()) {
                    userPhoneNumber = userPhoneNumberUtil.a(str, i);
                }
                TracerDetour.a(-1371955847);
            } catch (Throwable th) {
                TracerDetour.a(644386573);
            }
        }
        return userPhoneNumber;
    }
}
