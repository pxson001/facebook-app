package com.facebook.contacts.provider;

import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWrapper;
import com.facebook.contacts.database.ContactSerialization;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactPhone;
import com.facebook.debug.log.BLog;
import com.facebook.user.model.Name;
import com.facebook.user.names.NameNormalizer;

@Deprecated
/* compiled from: page_photo_menu_photos */
class ContactsConnectionsCursor extends CursorWrapper {
    private static final Class<?> f8409a = ContactsConnectionsCursor.class;
    private static final int f8410e = m12284a("_id");
    private static final int f8411f = m12284a("_count");
    private static final int f8412g = m12284a("user_id");
    private static final int f8413h = m12284a("display_name");
    private static final int f8414i = m12284a("sort_name");
    private static final int f8415j = m12284a("user_image_url");
    private static final int f8416k = m12284a("contact_type");
    private static final int f8417l = m12284a("first_name");
    private static final int f8418m = m12284a("last_name");
    private static final int f8419n = m12284a("cell");
    private static final int f8420o = m12284a("other");
    private static final int f8421p = m12284a("search_token");
    private final ContactSerialization f8422b;
    private final NameNormalizer f8423c;
    private Object[] f8424d = new Object[ContactsConnectionsContract.b.length];

    public ContactsConnectionsCursor(Cursor cursor, ContactSerialization contactSerialization, NameNormalizer nameNormalizer) {
        super(cursor);
        this.f8422b = contactSerialization;
        this.f8423c = nameNormalizer;
    }

    private boolean m12285a() {
        try {
            String i;
            Contact a = this.f8422b.a(super.getString(0));
            String g = a.e().g();
            Name f = a.f();
            if (f != null) {
                i = f.i();
            } else {
                i = g;
            }
            this.f8424d[f8410e] = Integer.valueOf(getPosition());
            this.f8424d[f8411f] = Integer.valueOf(getCount());
            this.f8424d[f8412g] = Long.valueOf(Long.parseLong(a.c()));
            this.f8424d[f8413h] = g;
            this.f8424d[f8414i] = i;
            this.f8424d[f8415j] = a.g();
            this.f8424d[f8416k] = a.A();
            this.f8424d[f8417l] = a.e().a();
            this.f8424d[f8418m] = a.e().c();
            Object[] objArr = this.f8424d;
            int i2 = f8419n;
            i = (a.o() == null || a.o().size() <= 0) ? null : ((ContactPhone) a.o().get(0)).m12030c();
            objArr[i2] = i;
            objArr = this.f8424d;
            i2 = f8420o;
            if (a.o() == null || a.o().size() <= 1) {
                i = null;
            } else {
                i = ((ContactPhone) a.o().get(1)).m12030c();
            }
            objArr[i2] = i;
            this.f8424d[f8421p] = this.f8423c.a(a.e().g());
            return true;
        } catch (Throwable e) {
            BLog.b(f8409a, "Error deserializing contact", e);
            return false;
        }
    }

    public boolean move(int i) {
        return super.move(i) && m12285a();
    }

    public boolean moveToPosition(int i) {
        return super.moveToPosition(i) && m12285a();
    }

    public boolean moveToFirst() {
        return super.moveToFirst() && m12285a();
    }

    public boolean moveToLast() {
        return super.moveToLast() && m12285a();
    }

    public boolean moveToNext() {
        return super.moveToNext() && m12285a();
    }

    public boolean moveToPrevious() {
        return super.moveToPrevious() && m12285a();
    }

    public int getColumnIndex(String str) {
        return m12284a(str);
    }

    private static int m12284a(String str) {
        return ((Integer) ContactsConnectionsContract.d.get(str)).intValue();
    }

    public int getColumnIndexOrThrow(String str) {
        if (ContactsConnectionsContract.d.containsKey(str)) {
            return getColumnIndex(str);
        }
        throw new IllegalArgumentException("No column " + str);
    }

    public String getColumnName(int i) {
        return ContactsConnectionsContract.b[i];
    }

    public String[] getColumnNames() {
        return ContactsConnectionsContract.b;
    }

    public int getColumnCount() {
        return ContactsConnectionsContract.b.length;
    }

    public byte[] getBlob(int i) {
        throw new UnsupportedOperationException();
    }

    public String getString(int i) {
        return (String) this.f8424d[i];
    }

    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
        throw new UnsupportedOperationException();
    }

    public short getShort(int i) {
        return (short) ((int) getLong(i));
    }

    public int getInt(int i) {
        return (int) getLong(i);
    }

    public long getLong(int i) {
        return ((Long) this.f8424d[i]).longValue();
    }

    public float getFloat(int i) {
        throw new UnsupportedOperationException();
    }

    public double getDouble(int i) {
        throw new UnsupportedOperationException();
    }

    public int getType(int i) {
        return ((Integer) ContactsConnectionsContract.c.get(Integer.valueOf(i))).intValue();
    }

    public boolean isNull(int i) {
        return this.f8424d[i] == null;
    }
}
