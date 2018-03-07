package com.facebook.bookmark.provider;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.facebook.bookmark.db.BookmarkDatabaseSupplier;
import com.facebook.bookmark.ipc.BookmarkContract;
import com.facebook.content.SecureContentProvider;
import com.facebook.inject.FbInjector;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: zero_url_not_rewritten */
public class BookmarkProvider extends SecureContentProvider {
    private static final UriMatcher f288a;
    private BookmarkDatabaseSupplier f289b;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f288a = uriMatcher;
        uriMatcher.addURI(BookmarkContract.f290a, "bookmarks", 0);
        f288a.addURI(BookmarkContract.f290a, "BookmarkUnreadCount", 1);
        f288a.addURI(BookmarkContract.f290a, "bookmark_sync_status", 2);
        f288a.addURI(BookmarkContract.f290a, "bookmark_group", 3);
    }

    protected final synchronized void mo10a() {
        this.f289b = BookmarkDatabaseSupplier.a(FbInjector.get(getContext()));
    }

    private static String m587c(Uri uri) {
        switch (f288a.match(uri)) {
            case 0:
                return "bookmarks";
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return "bookmarks";
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return "bookmark_sync_status";
            case 3:
                return "bookmark_group";
            default:
                throw new SQLException("The uri " + uri + " is invalid for bookmark content provider.");
        }
    }

    public final Cursor mo6a(Uri uri, String[] strArr, @Nullable String str, String[] strArr2, @Nullable String str2) {
        if (f288a.match(uri) != 1) {
            return this.f289b.mo2480a().query(m587c(uri), strArr, str, strArr2, null, null, str2);
        }
        throw new SQLException(uri + " is only used for notification and updating.");
    }

    public final String mo8a(Uri uri) {
        switch (f288a.match(uri)) {
            case 0:
                return "vnd.android.cursor.item/vnd.facebook.katana.bookmark";
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return "vnd.android.cursor.item/vnd.facebook.katana.bookmark_unread_count";
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return "vnd.android.cursor.item/vnd.facebook.katana.bookmark_sync_status";
            case 3:
                return "vnd.android.cursor.item/vnd.facebook.katana.bookmark_group_order";
            default:
                throw new SQLException("The uri " + uri + " is invalid for bookmark content provider.");
        }
    }

    public final Uri mo7a(Uri uri, ContentValues contentValues) {
        switch (f288a.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                throw new SQLException(uri + " is only used for notification and updating.");
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                throw new SQLException("Could only insert record into sync_status table.");
            default:
                SQLiteDatabase a = this.f289b.mo2480a();
                String c = m587c(uri);
                SQLiteDetour.a(-1740901813);
                long insertOrThrow = a.insertOrThrow(c, null, contentValues);
                SQLiteDetour.a(488594583);
                if (insertOrThrow >= 0) {
                    return uri;
                }
                throw new SQLException("Failed to insert row into " + uri);
        }
    }

    public final int mo5a(Uri uri, @Nullable String str, String[] strArr) {
        switch (f288a.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                throw new SQLException(uri + " is only used for notification and updating.");
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                throw new SQLException("Could only delete record from sync_status table.");
            default:
                if (!BookmarkContract.f291b.equals(uri)) {
                    return this.f289b.mo2480a().delete(m587c(uri), str, strArr);
                }
                this.f289b.mo2481e();
                return 0;
        }
    }

    public final ContentProviderResult[] mo43a(ArrayList<ContentProviderOperation> arrayList) {
        SQLiteDatabase a = this.f289b.mo2480a();
        SQLiteDetour.a(a, 1328912896);
        try {
            ContentProviderResult[] a2 = super.mo43a((ArrayList) arrayList);
            a.setTransactionSuccessful();
            return a2;
        } finally {
            SQLiteDetour.b(a, 629143157);
        }
    }

    public final int mo42a(Uri uri, ContentValues[] contentValuesArr) {
        switch (f288a.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                throw new SQLException(uri + " is only used for notification and updating.");
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                throw new SQLException("Could only insert records into sync_status table.");
            default:
                SQLiteDatabase a = this.f289b.mo2480a();
                String c = m587c(uri);
                SQLiteDetour.a(a, 1113222938);
                try {
                    for (ContentValues contentValues : contentValuesArr) {
                        SQLiteDetour.a(645670517);
                        long insert = a.insert(c, null, contentValues);
                        SQLiteDetour.a(1528353795);
                        if (insert < 0) {
                            return 0;
                        }
                    }
                    a.setTransactionSuccessful();
                    SQLiteDetour.b(a, -376970026);
                    return contentValuesArr.length;
                } finally {
                    SQLiteDetour.b(a, 1704777004);
                }
        }
    }

    public final int mo4a(Uri uri, ContentValues contentValues, @Nullable String str, String[] strArr) {
        return this.f289b.mo2480a().update(m587c(uri), contentValues, str, strArr);
    }
}
