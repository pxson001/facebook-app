package com.facebook.growth.util;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.PhoneLookup;
import android.provider.ContactsContract.Profile;
import com.facebook.growth.model.Birthday;
import com.facebook.growth.model.DeviceOwnerData;
import com.facebook.growth.model.FullName;
import com.google.common.annotations.VisibleForTesting;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: edit_page_info_tap */
public class DeviceOwnerInfoUtil {
    @VisibleForTesting
    static final String[] f14912a = new String[]{"display_name", "mimetype", "data1", "data1", "data2", "data1", "data3", "data2", "data5"};
    @VisibleForTesting
    static final String[] f14913b = new String[]{"vnd.android.cursor.item/email_v2", "vnd.android.cursor.item/contact_event", "vnd.android.cursor.item/phone_v2", "vnd.android.cursor.item/name"};
    private final Context f14914c;
    private final ContentResolver f14915d;
    private final DateFormat[] f14916e = new DateFormat[]{new SimpleDateFormat("yy-MM-dd", Locale.US), new SimpleDateFormat("yyyy-MM-dd", Locale.US), new SimpleDateFormat("--MM-dd", Locale.US), DateFormat.getDateInstance(), new SimpleDateFormat("yyyy/MM/dd", Locale.US), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)};
    private final DateFormat f14917f = this.f14916e[2];
    private Set<Long> f14918g;

    @Inject
    public DeviceOwnerInfoUtil(Context context, ContentResolver contentResolver) {
        this.f14914c = context;
        this.f14915d = contentResolver;
        this.f14918g = new HashSet();
    }

    @TargetApi(14)
    @Nullable
    public final DeviceOwnerData m17380a() {
        Cursor query;
        Throwable th;
        int checkCallingOrSelfPermission = this.f14914c.checkCallingOrSelfPermission("android.permission.READ_CONTACTS");
        if (checkCallingOrSelfPermission != 0) {
            throw new RuntimeException("Permission not granted: " + checkCallingOrSelfPermission);
        }
        try {
            query = this.f14915d.query(Uri.withAppendedPath(Profile.CONTENT_URI, "data"), f14912a, "mimetype = ? OR mimetype = ? OR mimetype = ? OR mimetype = ?", f14913b, "is_primary DESC");
            try {
                DeviceOwnerData b = m17378b(query);
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

    public final List<DeviceOwnerData> m17381a(String str) {
        return m17377a(Data.CONTENT_URI, new String[]{"contact_id"}, "data1 LIKE ? AND mimetype = ?", new String[]{str, "vnd.android.cursor.item/email_v2"}, null);
    }

    public final List<DeviceOwnerData> m17382b(String str) {
        return m17377a(Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)), new String[]{"_id"}, null, null, null);
    }

    @Nullable
    private List<DeviceOwnerData> m17377a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor query;
        Throwable th;
        try {
            query = this.f14915d.query(uri, strArr, str, strArr2, str2);
            try {
                List<DeviceOwnerData> a = m17376a(query);
                if (query != null) {
                    query.close();
                }
                return a;
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

    @Nullable
    private List<DeviceOwnerData> m17376a(Cursor cursor) {
        Throwable th;
        List<DeviceOwnerData> arrayList = new ArrayList();
        if (cursor == null || cursor.getCount() <= 0) {
            return arrayList;
        }
        while (cursor.moveToNext()) {
            Cursor query;
            long j = cursor.getLong(0);
            if (!this.f14918g.contains(Long.valueOf(j))) {
                this.f14918g.add(Long.valueOf(j));
                try {
                    query = this.f14915d.query(Data.CONTENT_URI, f14912a, "contact_id = '" + j + "' AND (mimetype = ? OR mimetype = ? OR mimetype = ? OR mimetype = ?" + ")", f14913b, "is_primary DESC");
                    try {
                        DeviceOwnerData b = m17378b(query);
                        if (b != null) {
                            arrayList.add(b);
                        }
                        if (query != null) {
                            query.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    query = null;
                }
            }
        }
        return arrayList;
        if (query != null) {
            query.close();
        }
        throw th;
    }

    @Nullable
    private DeviceOwnerData m17378b(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        DeviceOwnerData deviceOwnerData = new DeviceOwnerData();
        int columnIndex = cursor.getColumnIndex("mimetype");
        while (cursor.moveToNext()) {
            String string = cursor.getString(columnIndex);
            if (string.equals("vnd.android.cursor.item/name")) {
                deviceOwnerData.m17352a(new FullName(cursor.getString(cursor.getColumnIndex("data2")), cursor.getString(cursor.getColumnIndex("data5")), cursor.getString(cursor.getColumnIndex("data3")), cursor.getString(cursor.getColumnIndex("display_name"))));
            } else if (string.equals("vnd.android.cursor.item/phone_v2")) {
                deviceOwnerData.m17355b(cursor.getString(cursor.getColumnIndex("data1")));
            } else if (string.equals("vnd.android.cursor.item/email_v2")) {
                deviceOwnerData.m17353a(cursor.getString(cursor.getColumnIndex("data1")));
            } else if (string.equals("vnd.android.cursor.item/contact_event")) {
                m17379d(cursor, deviceOwnerData);
            }
        }
        return deviceOwnerData;
    }

    private void m17379d(Cursor cursor, DeviceOwnerData deviceOwnerData) {
        Date date = null;
        if (cursor.getInt(cursor.getColumnIndex("data2")) == 3) {
            DateFormat dateFormat;
            String string = cursor.getString(cursor.getColumnIndex("data1"));
            DateFormat[] dateFormatArr = this.f14916e;
            int length = dateFormatArr.length;
            int i = 0;
            Date date2 = null;
            while (i < length) {
                dateFormat = dateFormatArr[i];
                try {
                    date = dateFormat.parse(string);
                    if (date != null) {
                        break;
                    }
                    i++;
                    Object obj = dateFormat;
                } catch (ParseException e) {
                    dateFormat = date2;
                }
            }
            Object obj2 = date2;
            if (date != null && deviceOwnerData.m17349a() == null) {
                Calendar instance = Calendar.getInstance();
                instance.setTime(date);
                i = instance.get(5);
                deviceOwnerData.m17350a(new Birthday(dateFormat == this.f14917f ? 0 : instance.get(1), instance.get(2), i));
            }
        }
    }
}
