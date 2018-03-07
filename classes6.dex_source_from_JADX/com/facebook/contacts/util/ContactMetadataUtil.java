package com.facebook.contacts.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract.RawContacts;
import android.text.TextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.contacts.model.PhonebookContactMetadata;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.google.common.annotations.VisibleForTesting;
import java.util.HashSet;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: overlay_uri */
public class ContactMetadataUtil {
    @VisibleForTesting
    static final String[] f8507a = new String[]{"_id", "times_contacted", "starred", "last_time_contacted", "custom_ringtone", "in_visible_group", "send_to_voicemail", "is_user_profile"};
    @VisibleForTesting
    static final String[] f8508b = new String[]{"account_type"};
    private static final Class<?> f8509c = ContactMetadataUtil.class;
    private final ContentResolver f8510d;
    private final RuntimePermissionsUtil f8511e;
    private final Provider<Boolean> f8512f;

    @Inject
    public ContactMetadataUtil(ContentResolver contentResolver, RuntimePermissionsUtil runtimePermissionsUtil, Provider<Boolean> provider) {
        this.f8510d = contentResolver;
        this.f8511e = runtimePermissionsUtil;
        this.f8512f = provider;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.facebook.contacts.model.PhonebookContactMetadata m12326a(java.lang.String r9) {
        /*
        r8 = this;
        r6 = 0;
        r0 = r8.f8511e;
        r1 = "android.permission.READ_CONTACTS";
        r0 = r0.a(r1);
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        r0 = r6;
    L_0x000c:
        return r0;
    L_0x000d:
        r0 = r8.f8510d;	 Catch:{ Exception -> 0x0042 }
        r1 = android.provider.ContactsContract.Contacts.CONTENT_URI;	 Catch:{ Exception -> 0x0042 }
        r2 = android.net.Uri.encode(r9);	 Catch:{ Exception -> 0x0042 }
        r1 = android.net.Uri.withAppendedPath(r1, r2);	 Catch:{ Exception -> 0x0042 }
        r2 = f8507a;	 Catch:{ Exception -> 0x0042 }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r2 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0042 }
        r1 = m12322a(r2);	 Catch:{ Exception -> 0x0062, all -> 0x005f }
        r0 = r8.f8512f;	 Catch:{ Exception -> 0x0067, all -> 0x005f }
        r0 = r0.get();	 Catch:{ Exception -> 0x0067, all -> 0x005f }
        r0 = (java.lang.Boolean) r0;	 Catch:{ Exception -> 0x0067, all -> 0x005f }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x0067, all -> 0x005f }
        if (r0 == 0) goto L_0x003b;
    L_0x0034:
        r0 = r8.m12325b(r9);	 Catch:{ Exception -> 0x0067, all -> 0x005f }
        r1.m12110a(r0);	 Catch:{ Exception -> 0x0067, all -> 0x005f }
    L_0x003b:
        if (r2 == 0) goto L_0x006d;
    L_0x003d:
        r2.close();
        r0 = r1;
        goto L_0x000c;
    L_0x0042:
        r0 = move-exception;
        r1 = r0;
        r0 = r6;
    L_0x0045:
        r2 = f8509c;	 Catch:{ all -> 0x0058 }
        r3 = "Got Exception when getting metadata for contact %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0058 }
        r5 = 0;
        r4[r5] = r9;	 Catch:{ all -> 0x0058 }
        com.facebook.debug.log.BLog.a(r2, r1, r3, r4);	 Catch:{ all -> 0x0058 }
        if (r6 == 0) goto L_0x000c;
    L_0x0054:
        r6.close();
        goto L_0x000c;
    L_0x0058:
        r0 = move-exception;
    L_0x0059:
        if (r6 == 0) goto L_0x005e;
    L_0x005b:
        r6.close();
    L_0x005e:
        throw r0;
    L_0x005f:
        r0 = move-exception;
        r6 = r2;
        goto L_0x0059;
    L_0x0062:
        r0 = move-exception;
        r1 = r0;
        r0 = r6;
        r6 = r2;
        goto L_0x0045;
    L_0x0067:
        r0 = move-exception;
        r6 = r2;
        r7 = r0;
        r0 = r1;
        r1 = r7;
        goto L_0x0045;
    L_0x006d:
        r0 = r1;
        goto L_0x000c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.util.ContactMetadataUtil.a(java.lang.String):com.facebook.contacts.model.PhonebookContactMetadata");
    }

    private String m12325b(String str) {
        Throwable th;
        Cursor query;
        try {
            query = this.f8510d.query(RawContacts.CONTENT_URI, f8508b, "contact_id = ?", new String[]{str}, null);
            try {
                String b = m12324b(query);
                if (query != null) {
                    query.close();
                }
                return b;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private static PhonebookContactMetadata m12322a(Cursor cursor) {
        int i = 0;
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        String str;
        int i7;
        long j = 0;
        if (cursor.moveToNext()) {
            String string = cursor.getString(cursor.getColumnIndex("_id"));
            i2 = cursor.getInt(cursor.getColumnIndex("times_contacted"));
            i3 = cursor.getInt(cursor.getColumnIndex("starred"));
            j = cursor.getLong(cursor.getColumnIndex("last_time_contacted"));
            if (!StringUtil.a(cursor.getString(cursor.getColumnIndex("custom_ringtone")))) {
                i = 1;
            }
            i4 = cursor.getInt(cursor.getColumnIndex("in_visible_group"));
            i5 = cursor.getInt(cursor.getColumnIndex("send_to_voicemail"));
            i6 = cursor.getInt(cursor.getColumnIndex("is_user_profile"));
            str = string;
            i7 = i5;
            i5 = i2;
            i2 = i4;
            i4 = i3;
            i3 = i;
        } else {
            i6 = 0;
            i7 = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            str = null;
        }
        return new PhonebookContactMetadata(str, i5, m12323a(i4), j, m12323a(i3), m12323a(i2), m12323a(i7), m12323a(i6), null);
    }

    private static String m12324b(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        Iterable hashSet = new HashSet();
        int columnIndex = cursor.getColumnIndex("account_type");
        while (cursor.moveToNext()) {
            hashSet.add(cursor.getString(columnIndex));
        }
        return TextUtils.join(";", hashSet);
    }

    private static boolean m12323a(int i) {
        return i == 1;
    }
}
