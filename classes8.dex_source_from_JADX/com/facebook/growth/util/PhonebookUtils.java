package com.facebook.growth.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.model.FacebookPhonebookContact;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: edit_credit_card */
public class PhonebookUtils {
    private final ContentResolver f14923a;
    private final RuntimePermissionsUtil f14924b;

    public static PhonebookUtils m17388b(InjectorLike injectorLike) {
        return new PhonebookUtils((Context) injectorLike.getInstance(Context.class, ForAppContext.class), RuntimePermissionsUtil.b(injectorLike));
    }

    @Inject
    public PhonebookUtils(@ForAppContext Context context, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f14923a = context.getContentResolver();
        this.f14924b = runtimePermissionsUtil;
    }

    public final List<FacebookPhonebookContact> m17391a() {
        if (!this.f14924b.a("android.permission.READ_CONTACTS")) {
            return new ArrayList();
        }
        Map hashMap = new HashMap();
        String[] strArr = new String[]{"contact_id", "data1"};
        String[] strArr2 = new String[]{"contact_id", "data1"};
        m17387a(this.f14923a.query(Contacts.CONTENT_URI, new String[]{"_id", "display_name"}, null, null, null), hashMap);
        m17389b(this.f14923a.query(Email.CONTENT_URI, strArr2, null, null, null), hashMap);
        m17390c(this.f14923a.query(Phone.CONTENT_URI, strArr, null, null, null), hashMap);
        return new ArrayList(hashMap.values());
    }

    private static void m17387a(@Nullable Cursor cursor, Map<Long, FacebookPhonebookContact> map) {
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    Long valueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id")));
                    map.put(valueOf, new FacebookPhonebookContact(cursor.getString(cursor.getColumnIndex("display_name")), valueOf.longValue(), new ArrayList(), new ArrayList()));
                } finally {
                    cursor.close();
                }
            }
        }
    }

    private static void m17389b(@Nullable Cursor cursor, Map<Long, FacebookPhonebookContact> map) {
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    Long valueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("contact_id")));
                    if (map.get(valueOf) != null) {
                        ((FacebookPhonebookContact) map.get(valueOf)).b.add(cursor.getString(cursor.getColumnIndex("data1")));
                    }
                } finally {
                    cursor.close();
                }
            }
        }
    }

    private static void m17390c(@Nullable Cursor cursor, Map<Long, FacebookPhonebookContact> map) {
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    Long valueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("contact_id")));
                    if (map.get(valueOf) != null) {
                        ((FacebookPhonebookContact) map.get(valueOf)).a.add(cursor.getString(cursor.getColumnIndex("data1")));
                    }
                } finally {
                    cursor.close();
                }
            }
        }
    }
}
