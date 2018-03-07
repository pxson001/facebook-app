package com.facebook.contacts.iterator;

import android.database.Cursor;
import com.facebook.common.cursors.CachedColumnNameCursorProvider;
import com.facebook.common.cursors.CursorHelper;
import com.facebook.contacts.model.PhonebookContact;
import com.facebook.contacts.model.PhonebookContact.Builder;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ObjectArrays;

/* compiled from: phoneNumber */
public abstract class AbstractPhonebookContactIterator extends AbstractIterator<PhonebookContact> {
    public static final String[] f8213a = new String[]{"_id", "contact_id", "deleted", "mimetype", "is_primary", "is_super_primary", "data1", "data2", "data3", "data4", "data5", "data6", "data7", "data8", "data9", "data10", "data11", "data12", "data13", "data14", "data15"};
    public static final String[] f8214b = new String[]{"account_type"};
    public Cursor f8215c;

    public abstract void mo938a(Builder builder);

    public abstract void mo939b(Builder builder);

    public abstract void mo940c(Builder builder);

    public AbstractPhonebookContactIterator(CachedColumnNameCursorProvider cachedColumnNameCursorProvider, Cursor cursor) {
        this.f8215c = CachedColumnNameCursorProvider.a(cursor);
    }

    protected final Object m12042a() {
        if (this.f8215c.isBeforeFirst()) {
            this.f8215c.moveToNext();
        }
        m12041h();
        if (this.f8215c.isAfterLast()) {
            return (PhonebookContact) b();
        }
        return m12040g();
    }

    public final int m12045c() {
        int position = this.f8215c.getPosition();
        long j = -1;
        int i = 0;
        this.f8215c.moveToPosition(-1);
        while (this.f8215c.moveToNext()) {
            if (CursorHelper.m11024a(this.f8215c, "deleted") == 0) {
                long b = CursorHelper.m11025b(this.f8215c, "contact_id");
                if (b != j) {
                    i++;
                    j = b;
                }
            }
        }
        this.f8215c.moveToPosition(position);
        return i;
    }

    public final void m12047d() {
        this.f8215c.close();
    }

    public static String[] m12039e() {
        Object obj = f8213a;
        Object obj2 = f8214b;
        Object a = ObjectArrays.a(String.class, obj.length + obj2.length);
        System.arraycopy(obj, 0, a, 0, obj.length);
        System.arraycopy(obj2, 0, a, obj.length, obj2.length);
        return (String[]) a;
    }

    private PhonebookContact m12040g() {
        String valueOf = String.valueOf(CursorHelper.m11025b(this.f8215c, "contact_id"));
        Builder builder = new Builder(valueOf);
        mo950m(builder);
        do {
            m12041h();
            if (this.f8215c.isAfterLast()) {
                break;
            } else if (!String.valueOf(CursorHelper.m11025b(this.f8215c, "contact_id")).equals(valueOf)) {
                return builder.m12105c();
            } else {
                String c = CursorHelper.m11026c(this.f8215c, "mimetype");
                if ("vnd.android.cursor.item/phone_v2".equals(c)) {
                    mo938a(builder);
                } else if ("vnd.android.cursor.item/email_v2".equals(c)) {
                    mo939b(builder);
                } else if ("vnd.android.cursor.item/name".equals(c)) {
                    mo940c(builder);
                } else if ("vnd.android.cursor.item/photo".equals(c)) {
                    mo941d(builder);
                } else if ("vnd.android.cursor.item/note".equals(c)) {
                    mo942e(builder);
                } else if ("vnd.android.cursor.item/im".equals(c)) {
                    mo943f(builder);
                } else if ("vnd.android.cursor.item/nickname".equals(c)) {
                    mo944g(builder);
                } else if ("vnd.android.cursor.item/postal-address_v2".equals(c)) {
                    mo945h(builder);
                } else if ("vnd.android.cursor.item/website".equals(c)) {
                    mo946i(builder);
                } else if ("vnd.android.cursor.item/relation".equals(c)) {
                    mo947j(builder);
                } else if ("vnd.android.cursor.item/organization".equals(c)) {
                    mo948k(builder);
                } else if ("vnd.android.cursor.item/contact_event".equals(c)) {
                    mo949l(builder);
                } else if ("vnd.android.cursor.item/vnd.com.whatsapp.profile".equals(c)) {
                    mo951n(builder);
                }
            }
        } while (this.f8215c.moveToNext());
        return builder.m12105c();
    }

    private int m12041h() {
        int i = 0;
        while (true) {
            Object obj = null;
            if (!this.f8215c.isAfterLast()) {
                int a = CursorHelper.m11024a(this.f8215c, "deleted");
                if (a != 0) {
                    this.f8215c.moveToNext();
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

    public void mo941d(Builder builder) {
    }

    public void mo942e(Builder builder) {
    }

    public void mo943f(Builder builder) {
    }

    public void mo944g(Builder builder) {
    }

    public void mo945h(Builder builder) {
    }

    public void mo946i(Builder builder) {
    }

    public void mo947j(Builder builder) {
    }

    public void mo948k(Builder builder) {
    }

    public void mo949l(Builder builder) {
    }

    protected void mo950m(Builder builder) {
    }

    public void mo951n(Builder builder) {
    }
}
