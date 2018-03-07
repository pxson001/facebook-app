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
import com.facebook.ipc.userstatus.UserStatusContract;
import com.facebook.ipc.userstatus.UserStatusContract.UserStatusesTable;
import com.facebook.ipc.userstatus.UserStatusContract.UserStatusesTable.Columns;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.userstatus.db.UserStatusDatabaseSupplier;

/* compiled from: { */
public class UserStatusesProvider extends SecureContentProvider {
    private static final UriMatcher f281a;
    private UserStatusDatabaseSupplier f282b;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f281a = uriMatcher;
        uriMatcher.addURI(UserStatusContract.f283a, "user_statuses", 1);
        f281a.addURI(UserStatusContract.f283a, "user_statuses/#", 2);
    }

    public final void mo10a() {
        this.f282b = UserStatusDatabaseSupplier.a(FbInjector.get(getContext()));
    }

    protected final Cursor mo6a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String str3;
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        switch (f281a.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                sQLiteQueryBuilder.setTables("user_statuses");
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                sQLiteQueryBuilder.setTables("user_statuses");
                sQLiteQueryBuilder.appendWhere("_id=" + ((String) uri.getPathSegments().get(1)));
                break;
            default:
                throw new IllegalArgumentException("Unknown URL " + uri);
        }
        if (TextUtils.isEmpty(str2)) {
            str3 = "timestamp DESC";
        } else {
            str3 = str2;
        }
        Cursor query = sQLiteQueryBuilder.query(this.f282b.mo2480a(), strArr, str, strArr2, null, null, str3);
        query.setNotificationUri(getContext().getContentResolver(), uri);
        return query;
    }

    protected final String mo8a(Uri uri) {
        switch (f281a.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return "vnd.android.cursor.dir/vnd.facebook.katana.userstatuses";
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return "vnd.android.cursor.item/vnd.facebook.katana.userstatuses";
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
        if (f281a.match(uri) != 1) {
            throw new IllegalArgumentException("Unknown URL " + uri);
        }
        String str = Columns.b.f1025d;
        SQLiteDetour.a(386811571);
        long insertOrThrow = this.f282b.mo2480a().insertOrThrow("user_statuses", str, contentValues2);
        SQLiteDetour.a(984497327);
        if (insertOrThrow > 0) {
            Uri withAppendedPath = Uri.withAppendedPath(UserStatusesTable.a, Long.valueOf(insertOrThrow).toString());
            getContext().getContentResolver().notifyChange(uri, null, false);
            return withAppendedPath;
        }
        throw new SQLException("Failed to insert row into " + uri);
    }

    protected final int mo4a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int update;
        SQLiteDatabase a = this.f282b.mo2480a();
        switch (f281a.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                update = a.update("user_statuses", contentValues, str, strArr);
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                update = a.update("user_statuses", contentValues, Columns.a.f1025d + "=" + ((String) uri.getPathSegments().get(1)), null);
                break;
            default:
                throw new IllegalArgumentException("Unknown URL " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null, false);
        return update;
    }

    protected final int mo5a(Uri uri, String str, String[] strArr) {
        if (UserStatusContract.f284b.equals(uri)) {
            this.f282b.mo2481e();
            return 0;
        }
        int delete;
        SQLiteDatabase a = this.f282b.mo2480a();
        switch (f281a.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                delete = a.delete("user_statuses", str, strArr);
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                delete = a.delete("user_statuses", Columns.a.f1025d + "=" + ((String) uri.getPathSegments().get(1)), null);
                break;
            default:
                throw new IllegalArgumentException("Unknown URL " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null, false);
        return delete;
    }
}
