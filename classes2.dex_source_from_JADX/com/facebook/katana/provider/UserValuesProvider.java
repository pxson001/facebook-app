package com.facebook.katana.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.init.AppInitLock;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.content.SecureContentProvider;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.legacykeyvalue.UserValuesContract;
import com.facebook.katana.binding.sessioninfo.SessionInfoHelper;
import com.facebook.katana.prefs.FbandroidPrefKeys;
import com.facebook.legacykeyvalue.db.LegacyKeyValueDatabaseSupplier;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;

/* compiled from: zero_rating2/clearable/dialtone_sticky_mode */
public class UserValuesProvider extends SecureContentProvider {
    private static final String[] f402a = new String[]{"value"};
    private UriMatcher f403b;
    private LegacyKeyValueDatabaseSupplier f404c;
    private FbInjector f405d;
    private AbstractFbErrorReporter f406e;

    protected final void mo10a() {
        this.f403b = new UriMatcher(-1);
        this.f403b.addURI(UserValuesContract.a, "user_values", 1);
        this.f403b.addURI(UserValuesContract.a, "user_values/name/*", 2);
        this.f405d = FbInjector.get(getContext());
        this.f404c = LegacyKeyValueDatabaseSupplier.a(this.f405d);
        this.f406e = FbErrorReporterImpl.m2317a(this.f405d);
        AppInitLock.m2271a(this.f405d).m2277b();
    }

    protected final Cursor mo6a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Object obj = null;
        String c = m788c(uri, str);
        if (c != null) {
            if (c.equals("active_session_info")) {
                String str3;
                ObjectMapper a = FbObjectMapperMethodAutoProvider.m6609a(this.f405d);
                Object a2 = SessionInfoHelper.m8877b(this.f405d).m8882a();
                if (a2 == null) {
                    str3 = null;
                } else {
                    try {
                        str3 = a.m6659a(a2);
                    } catch (Throwable e) {
                        FbErrorReporterImpl.m2317a(this.f405d).m2343a("SessionInfoSerialization", "Couldn't serialize sessionInfo.", e);
                    }
                }
                obj = str3;
            } else {
                obj = FbSharedPreferencesImpl.m1826a(this.f405d).mo278a((PrefKey) FbandroidPrefKeys.f19411c.m2011a(c), null);
                if (obj == null) {
                    return m787b(uri, strArr, str, strArr2, str2);
                }
            }
            Cursor matrixCursor = new MatrixCursor(strArr);
            if (obj == null) {
                return matrixCursor;
            }
            if (strArr == null) {
                strArr = f402a;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : r10) {
                if ("name".equals(obj2)) {
                    arrayList.add(c);
                } else if ("value".equals(obj2)) {
                    arrayList.add(obj);
                } else {
                    throw new IllegalArgumentException("Only name and value are supported in the projection map");
                }
            }
            matrixCursor.addRow(arrayList.toArray());
            return matrixCursor;
        }
        throw new IllegalArgumentException("Unknown URL " + uri);
    }

    private String m788c(Uri uri, String str) {
        if (uri != null) {
            switch (this.f403b.match(uri)) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    if ("name='active_session_info'".equals(str)) {
                        return "active_session_info";
                    }
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    return uri.getLastPathSegment();
            }
        }
        return null;
    }

    private Cursor m787b(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String str3;
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        switch (this.f403b.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                sQLiteQueryBuilder.setTables("user_values");
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                sQLiteQueryBuilder.setTables("user_values");
                sQLiteQueryBuilder.appendWhere("name='" + ((String) uri.getPathSegments().get(2)) + "'");
                break;
            default:
                throw new IllegalArgumentException("Unknown URL " + uri);
        }
        if (TextUtils.isEmpty(str2)) {
            str3 = "name DESC";
        } else {
            str3 = str2;
        }
        Cursor query = sQLiteQueryBuilder.query(this.f404c.mo2480a(), strArr, str, strArr2, null, null, str3);
        query.setNotificationUri(getContext().getContentResolver(), uri);
        return query;
    }

    protected final String mo8a(Uri uri) {
        switch (this.f403b.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return "vnd.android.cursor.item/vnd.facebook.katana.uservalues";
            default:
                throw new IllegalArgumentException("Unknown URL " + uri);
        }
    }

    protected final Uri mo7a(Uri uri, ContentValues contentValues) {
        ContentValues contentValues2;
        if (contentValues != null) {
            contentValues2 = new ContentValues(contentValues);
        } else {
            contentValues2 = new ContentValues();
        }
        if (this.f403b.match(uri) != 1) {
            throw new IllegalArgumentException("Unknown URL " + uri);
        }
        Uri withAppendedPath;
        SQLiteDetour.a(20462865);
        long insert = this.f404c.mo2480a().insert("user_values", "name", contentValues2);
        SQLiteDetour.a(482951401);
        if (insert > 0) {
            withAppendedPath = Uri.withAppendedPath(UserValuesContract.b, Long.valueOf(insert).toString());
            getContext().getContentResolver().notifyChange(uri, null, false);
        } else {
            withAppendedPath = null;
        }
        this.f406e.m2350b("UserValuesProvider", "UserValuesProvider should not create any new entry in old table");
        return withAppendedPath;
    }

    protected final int mo4a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    protected final int mo5a(Uri uri, String str, String[] strArr) {
        int delete;
        SQLiteDatabase a = this.f404c.mo2480a();
        switch (this.f403b.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                delete = a.delete("user_values", str, strArr);
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                delete = a.delete("user_values", "name=" + ((String) uri.getPathSegments().get(1)), null);
                break;
            default:
                throw new IllegalArgumentException("Unknown URL " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null, false);
        return delete;
    }
}
