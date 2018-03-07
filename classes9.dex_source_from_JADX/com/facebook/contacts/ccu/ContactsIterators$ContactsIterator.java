package com.facebook.contacts.ccu;

import android.database.Cursor;
import com.facebook.common.cursors.CursorHelper;
import com.google.common.collect.AbstractIterator;

/* compiled from: profilePic */
public class ContactsIterators$ContactsIterator extends AbstractIterator<AddressbookContact> {
    public final Cursor f6193a;

    public ContactsIterators$ContactsIterator(Cursor cursor) {
        this.f6193a = cursor;
    }

    public final Object m6529a() {
        if (this.f6193a.isBeforeFirst()) {
            this.f6193a.moveToNext();
        }
        m6528f();
        if (this.f6193a.isAfterLast()) {
            return (AddressbookContact) b();
        }
        return m6527e();
    }

    public final void m6530c() {
        this.f6193a.close();
    }

    private AddressbookContact m6527e() {
        String valueOf = String.valueOf(CursorHelper.b(this.f6193a, "contact_id"));
        AddressbookContact addressbookContact = new AddressbookContact(valueOf);
        do {
            m6528f();
            if (this.f6193a.isAfterLast() || !String.valueOf(CursorHelper.b(this.f6193a, "contact_id")).equals(valueOf)) {
                return addressbookContact;
            }
            m6523a(addressbookContact);
        } while (this.f6193a.moveToNext());
        return addressbookContact;
    }

    private void m6523a(AddressbookContact addressbookContact) {
        String c = CursorHelper.c(this.f6193a, "mimetype");
        if ("vnd.android.cursor.item/phone_v2".equals(c)) {
            m6524b(addressbookContact);
        } else if ("vnd.android.cursor.item/email_v2".equals(c)) {
            m6525c(addressbookContact);
        } else if ("vnd.android.cursor.item/name".equals(c)) {
            m6526d(addressbookContact);
        }
    }

    private int m6528f() {
        int i = 0;
        while (true) {
            Object obj = null;
            if (!this.f6193a.isAfterLast()) {
                int a = CursorHelper.a(this.f6193a, "deleted");
                if (a != 0) {
                    this.f6193a.moveToNext();
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

    private void m6524b(AddressbookContact addressbookContact) {
        addressbookContact.f6188c.add(m6522a("data1"));
    }

    private void m6525c(AddressbookContact addressbookContact) {
        addressbookContact.f6187b.add(m6522a("data1"));
    }

    private void m6526d(AddressbookContact addressbookContact) {
        addressbookContact.f6189d = m6522a("data1");
        addressbookContact.f6190e = m6522a("data2");
        addressbookContact.f6191f = m6522a("data3");
    }

    private String m6522a(String str) {
        return CursorHelper.c(this.f6193a, str);
    }
}
