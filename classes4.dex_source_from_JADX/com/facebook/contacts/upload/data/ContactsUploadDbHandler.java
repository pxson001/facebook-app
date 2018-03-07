package com.facebook.contacts.upload.data;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.contacts.database.ContactsDatabaseSupplier;
import com.facebook.contacts.upload.prefs.ContactsUploadPrefKeys;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.api.LoomLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.LoomLoggerDetour;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* compiled from: fb4a_feed_updates */
public class ContactsUploadDbHandler {
    private final DefaultAndroidThreadUtil f12164a;
    private final FbSharedPreferences f12165b;
    private final ContactsDatabaseSupplier f12166c;

    public static ContactsUploadDbHandler m12834b(InjectorLike injectorLike) {
        return new ContactsUploadDbHandler(DefaultAndroidThreadUtil.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), ContactsDatabaseSupplier.m8560a(injectorLike));
    }

    @Inject
    public ContactsUploadDbHandler(DefaultAndroidThreadUtil defaultAndroidThreadUtil, FbSharedPreferences fbSharedPreferences, ContactsDatabaseSupplier contactsDatabaseSupplier) {
        this.f12164a = defaultAndroidThreadUtil;
        this.f12165b = fbSharedPreferences;
        this.f12166c = contactsDatabaseSupplier;
    }

    public static ContactsUploadDbHandler m12832a(InjectorLike injectorLike) {
        return m12834b(injectorLike);
    }

    public final void m12837a(List<PhoneAddressBookSnapshotEntryChange> list) {
        if (!list.isEmpty()) {
            TracerDetour.a("UpdatePhoneAddressBookSnapshot(%d)", Integer.valueOf(list.size()), -754905604);
            LoomLogger.a(LoomLoggerDetour.a(-1903393177), "UpdatePhoneAddressBookSnapshot", String.valueOf(list.size()));
            try {
                SQLiteDatabase a = this.f12166c.a();
                SQLiteDetour.a(a, -1630689551);
                try {
                    Iterator it = list.iterator();
                    while (true) {
                        int hasNext = it.hasNext();
                        if (hasNext != 0) {
                            PhoneAddressBookSnapshotEntryChange phoneAddressBookSnapshotEntryChange = (PhoneAddressBookSnapshotEntryChange) it.next();
                            switch (1.a[phoneAddressBookSnapshotEntryChange.a.ordinal()]) {
                                case 1:
                                case 2:
                                    m12835b(phoneAddressBookSnapshotEntryChange);
                                    break;
                                case 3:
                                    m12833a(phoneAddressBookSnapshotEntryChange);
                                    break;
                                default:
                                    throw new IllegalArgumentException("Unknown change type " + phoneAddressBookSnapshotEntryChange.a);
                            }
                        }
                        a.setTransactionSuccessful();
                        SQLiteDetour.b(a, hasNext);
                        return;
                    }
                } finally {
                    SQLiteDetour.b(a, 513541441);
                }
            } finally {
                TracerDetour.a(896286838);
            }
        }
    }

    public final void m12836a() {
        this.f12164a.b();
        this.f12165b.edit().a(ContactsUploadPrefKeys.f10972o).commit();
        this.f12166c.a().delete("phone_address_book_snapshot", null, null);
    }

    private void m12833a(PhoneAddressBookSnapshotEntryChange phoneAddressBookSnapshotEntryChange) {
        this.f12166c.a().delete("phone_address_book_snapshot", "local_contact_id=?", new String[]{String.valueOf(phoneAddressBookSnapshotEntryChange.b)});
    }

    private void m12835b(PhoneAddressBookSnapshotEntryChange phoneAddressBookSnapshotEntryChange) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("local_contact_id", Long.valueOf(phoneAddressBookSnapshotEntryChange.c.a));
        contentValues.put("contact_hash", phoneAddressBookSnapshotEntryChange.c.b);
        SQLiteDetour.a(788997373);
        this.f12166c.a().replaceOrThrow("phone_address_book_snapshot", null, contentValues);
        SQLiteDetour.a(1801424542);
    }
}
