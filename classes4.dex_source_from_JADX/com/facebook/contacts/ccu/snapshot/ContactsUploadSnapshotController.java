package com.facebook.contacts.ccu.snapshot;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.contacts.database.ContactsDatabaseSupplier;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* compiled from: isIncrementalUpdate */
public class ContactsUploadSnapshotController {
    private final DefaultAndroidThreadUtil f10166a;
    private final ContactsDatabaseSupplier f10167b;

    public static ContactsUploadSnapshotController m10626b(InjectorLike injectorLike) {
        return new ContactsUploadSnapshotController(DefaultAndroidThreadUtil.b(injectorLike), ContactsDatabaseSupplier.m8560a(injectorLike));
    }

    @Inject
    public ContactsUploadSnapshotController(DefaultAndroidThreadUtil defaultAndroidThreadUtil, ContactsDatabaseSupplier contactsDatabaseSupplier) {
        this.f10166a = defaultAndroidThreadUtil;
        this.f10167b = contactsDatabaseSupplier;
    }

    public final void m10629a(List<ContactsUploadSnapshot> list) {
        if (!list.isEmpty()) {
            TracerDetour.a("UpdatePhoneAddressBookSnapshot(%d)", Integer.valueOf(list.size()), -873731985);
            try {
                SQLiteDatabase a = this.f10167b.a();
                SQLiteDetour.a(a, -1183828853);
                try {
                    Iterator it = list.iterator();
                    while (true) {
                        int hasNext = it.hasNext();
                        if (hasNext != 0) {
                            ContactsUploadSnapshot contactsUploadSnapshot = (ContactsUploadSnapshot) it.next();
                            switch (1.a[contactsUploadSnapshot.a().ordinal()]) {
                                case 1:
                                case 2:
                                    m10627b(contactsUploadSnapshot);
                                    break;
                                case 3:
                                    m10625a(contactsUploadSnapshot);
                                    break;
                                default:
                                    throw new IllegalArgumentException("Unknown change type " + contactsUploadSnapshot.a());
                            }
                        }
                        a.setTransactionSuccessful();
                        SQLiteDetour.b(a, hasNext);
                        return;
                    }
                } finally {
                    SQLiteDetour.b(a, -1161096014);
                }
            } finally {
                TracerDetour.a(1949306549);
            }
        }
    }

    public final void m10628a() {
        this.f10166a.b();
        this.f10167b.a().delete("contacts_upload_snapshot", null, null);
    }

    private void m10625a(ContactsUploadSnapshot contactsUploadSnapshot) {
        this.f10167b.a().delete("contacts_upload_snapshot", "local_contact_id=?", new String[]{String.valueOf(contactsUploadSnapshot.a)});
    }

    private void m10627b(ContactsUploadSnapshot contactsUploadSnapshot) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("local_contact_id", Long.valueOf(contactsUploadSnapshot.a));
        contentValues.put("contact_hash", contactsUploadSnapshot.b);
        SQLiteDetour.a(-1507727513);
        this.f10167b.a().replaceOrThrow("contacts_upload_snapshot", null, contentValues);
        SQLiteDetour.a(-918040912);
    }
}
