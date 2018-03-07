package com.facebook.oxygen.preloads.sdk.firstparty.settings;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.oxygen.preloads.sdk.firstparty.settings.FirstPartySettingsContract.SettingsTable;

/* compiled from: textAlign */
public class FirstPartySettings {
    private final String f1093a;
    private final String f1094b;
    public final boolean f1095c;
    public boolean f1096d;
    public boolean f1097e;
    public boolean f1098f;
    private String f1099g;
    private boolean f1100h;

    private FirstPartySettings(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, String str3, boolean z5) {
        this.f1093a = str;
        this.f1094b = str2;
        this.f1095c = z;
        this.f1096d = z2;
        this.f1097e = z3;
        this.f1098f = z4;
        this.f1099g = str3;
        this.f1100h = z5;
    }

    public static FirstPartySettings m1423a(Context context) {
        return m1422a(context.getContentResolver(), FirstPartySettingsContract.m1428a(context.getPackageName()));
    }

    public static FirstPartySettings m1422a(ContentResolver contentResolver, Uri uri) {
        boolean z = true;
        Cursor query = contentResolver.query(uri, null, null, null, null);
        if (query == null) {
            throw new IllegalStateException("Failed to fetch settings: null cursor.");
        }
        try {
            if (query.moveToFirst()) {
                boolean z2;
                boolean z3;
                boolean z4;
                int columnIndex = query.getColumnIndex(SettingsTable.f1101a);
                int columnIndex2 = query.getColumnIndex("signature");
                int columnIndex3 = query.getColumnIndex("is_managed");
                int columnIndex4 = query.getColumnIndex(SettingsTable.f1102b);
                int columnIndex5 = query.getColumnIndex(SettingsTable.f1103c);
                int columnIndex6 = query.getColumnIndex(SettingsTable.f1104d);
                int columnIndex7 = query.getColumnIndex(SettingsTable.f1105e);
                int columnIndex8 = query.getColumnIndex(SettingsTable.f1106f);
                String string = query.getString(columnIndex);
                String string2 = query.getString(columnIndex2);
                boolean z5 = query.getInt(columnIndex3) != 0;
                if (query.getInt(columnIndex4) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (query.getInt(columnIndex5) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (query.getInt(columnIndex6) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                String string3 = query.getString(columnIndex7);
                if (query.getInt(columnIndex8) == 0) {
                    z = false;
                }
                FirstPartySettings firstPartySettings = new FirstPartySettings(string, string2, z5, z2, z3, z4, string3, z);
                return firstPartySettings;
            }
            throw new IllegalStateException("Failed to fetch settings: empty cursor");
        } finally {
            query.close();
        }
    }

    public static void m1425a(ContentResolver contentResolver, String str, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SettingsTable.f1106f, Integer.valueOf(z ? 1 : 0));
        try {
            int update = contentResolver.update(FirstPartySettingsContract.m1428a(str), contentValues, null, null);
            if (update != 1) {
                throw new AppmanagerRemoteException(2, "Expected 1 row changed, actually " + update);
            }
        } catch (Throwable e) {
            throw new AppmanagerRemoteException(1, "Could not resolve content uri for firstparty settings", e);
        }
    }

    public final void m1427b(Context context) {
        m1424a(context.getContentResolver());
    }

    private void m1424a(ContentResolver contentResolver) {
        m1426b(contentResolver, FirstPartySettingsContract.m1428a(this.f1093a));
    }

    private void m1426b(ContentResolver contentResolver, Uri uri) {
        int i;
        int i2 = 1;
        ContentValues contentValues = new ContentValues();
        contentValues.put(SettingsTable.f1102b, Integer.valueOf(this.f1096d ? 1 : 0));
        String str = SettingsTable.f1103c;
        if (this.f1097e) {
            i = 1;
        } else {
            i = 0;
        }
        contentValues.put(str, Integer.valueOf(i));
        str = SettingsTable.f1104d;
        if (this.f1098f) {
            i = 1;
        } else {
            i = 0;
        }
        contentValues.put(str, Integer.valueOf(i));
        if (this.f1099g == null) {
            contentValues.putNull(SettingsTable.f1105e);
        } else {
            contentValues.put(SettingsTable.f1105e, this.f1099g);
        }
        String str2 = SettingsTable.f1106f;
        if (!this.f1100h) {
            i2 = 0;
        }
        contentValues.put(str2, Integer.valueOf(i2));
        if (contentResolver.update(uri, contentValues, null, null) < 0) {
            throw new IllegalStateException("Failed to update settings");
        }
    }
}
