package com.facebook.katana.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.content.SecureContentProvider;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.legacykeyvalue.KeyValueContract;
import com.facebook.legacykeyvalue.db.LegacyKeyValueDatabaseSupplier;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;

/* compiled from: zero_rating2/clearable/zero_upsell_ttl */
public class KeyValueProvider extends SecureContentProvider {
    private static final UriMatcher f345a;
    private LegacyKeyValueDatabaseSupplier f346b;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f345a = uriMatcher;
        uriMatcher.addURI(KeyValueContract.f347a, "key_value", 1);
        f345a.addURI(KeyValueContract.f347a, "key_value/#", 2);
        f345a.addURI(KeyValueContract.f347a, "key_value/key/*", 3);
    }

    public final void mo10a() {
        this.f346b = LegacyKeyValueDatabaseSupplier.a(FbInjector.get(getContext()));
    }

    protected final Cursor mo6a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String str3;
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        switch (f345a.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                sQLiteQueryBuilder.setTables("key_value");
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                sQLiteQueryBuilder.setTables("key_value");
                sQLiteQueryBuilder.appendWhere("_id=" + ((String) uri.getPathSegments().get(1)));
                break;
            case 3:
                sQLiteQueryBuilder.setTables("key_value");
                sQLiteQueryBuilder.appendWhere("key='" + ((String) uri.getPathSegments().get(2)) + "'");
                break;
            default:
                throw new IllegalArgumentException("Unknown URL " + uri);
        }
        if (TextUtils.isEmpty(str2)) {
            str3 = "key DESC";
        } else {
            str3 = str2;
        }
        Cursor query = sQLiteQueryBuilder.query(this.f346b.mo2480a(), strArr, str, strArr2, null, null, str3);
        query.setNotificationUri(getContext().getContentResolver(), uri);
        return query;
    }

    protected final String mo8a(Uri uri) {
        switch (f345a.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
                return "vnd.android.cursor.item/vnd.facebook.katana.keyvalue";
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
        if (f345a.match(uri) != 1) {
            throw new IllegalArgumentException("Unknown URL " + uri);
        }
        SQLiteDetour.a(-1669997433);
        long insertOrThrow = this.f346b.mo2480a().insertOrThrow("key_value", "key", contentValues2);
        SQLiteDetour.a(-1640863497);
        if (insertOrThrow > 0) {
            Uri withAppendedPath = Uri.withAppendedPath(KeyValueContract.f349c, Long.valueOf(insertOrThrow).toString());
            getContext().getContentResolver().notifyChange(uri, null, false);
            return withAppendedPath;
        }
        throw new SQLException("Failed to insert row into " + uri);
    }

    protected final int mo4a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int update;
        SQLiteDatabase a = this.f346b.mo2480a();
        switch (f345a.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                update = a.update("key_value", contentValues, str, strArr);
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                update = a.update("key_value", contentValues, "_id=" + ((String) uri.getPathSegments().get(1)), null);
                break;
            case 3:
                update = a.update("key_value", contentValues, "key='" + ((String) uri.getPathSegments().get(2)) + "'", null);
                break;
            default:
                throw new IllegalArgumentException("Unknown URL " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null, false);
        return update;
    }

    protected final int mo5a(Uri uri, String str, String[] strArr) {
        int delete;
        SQLiteDatabase a = this.f346b.mo2480a();
        switch (f345a.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                delete = a.delete("key_value", str, strArr);
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                delete = a.delete("key_value", "_id=" + ((String) uri.getPathSegments().get(1)), null);
                break;
            case 3:
                delete = a.delete("key_value", "key=" + ((String) uri.getPathSegments().get(1)), null);
                break;
            default:
                throw new IllegalArgumentException("Unknown URL " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null, false);
        return delete;
    }
}
