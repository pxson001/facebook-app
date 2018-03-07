package com.facebook.photos.provider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import com.facebook.content.SecureContentProvider;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.photos.PhotosContract;
import com.facebook.ipc.photos.PhotosContract.LocalPhotoTagsTable.Columns;
import com.facebook.photos.db.PhotosDatabaseSupplier;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: zero_scfg_cache_hit */
public class PhotosProvider extends SecureContentProvider {
    private PhotosDatabaseSupplier f327a;
    private PhotosContract f328b;
    private String f329c;
    private UriMatcher f330d;

    private static <T extends InjectableComponentWithContext> void m660a(Class<T> cls, T t) {
        m661a((Object) t, t.getContext());
    }

    private static void m661a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PhotosProvider) obj).m659a(PhotosDatabaseSupplier.a(injectorLike), PhotosContract.a(injectorLike));
    }

    public final void mo10a() {
        m660a(PhotosProvider.class, (InjectableComponentWithContext) this);
        this.f329c = "vnd.android.cursor.dir/" + this.f328b.a;
        this.f330d = new UriMatcher(-1);
        this.f330d.addURI(this.f328b.a, "localphototags", 1);
        this.f330d.addURI(this.f328b.a, "localphototags/*", 2);
        this.f330d.addURI(this.f328b.a, "localphotometadata", 3);
        this.f330d.addURI(this.f328b.a, "removedprefilledtags", 4);
    }

    @Inject
    private void m659a(PhotosDatabaseSupplier photosDatabaseSupplier, PhotosContract photosContract) {
        this.f327a = photosDatabaseSupplier;
        this.f328b = photosContract;
    }

    protected final String mo8a(Uri uri) {
        switch (this.f330d.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return this.f329c;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
    }

    protected final Cursor mo6a(Uri uri, String[] strArr, @Nullable String str, String[] strArr2, @Nullable String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        switch (this.f330d.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                sQLiteQueryBuilder.setTables("localphototags");
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                sQLiteQueryBuilder.setTables("localphototags");
                sQLiteQueryBuilder.appendWhere(Columns.k.f1025d + "=" + DatabaseUtils.sqlEscapeString(uri.getLastPathSegment()));
                break;
            case 3:
                sQLiteQueryBuilder.setTables("localphotometadata");
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                sQLiteQueryBuilder.setTables("removedprefilledtags");
                break;
            default:
                throw new IllegalArgumentException("Unknown URI for query: " + uri);
        }
        Cursor query = sQLiteQueryBuilder.query(this.f327a.mo2480a(), strArr, str, strArr2, null, null, null);
        query.setNotificationUri(getContext().getContentResolver(), uri);
        return query;
    }

    protected final Uri mo7a(Uri uri, ContentValues contentValues) {
        Uri uri2;
        String str;
        switch (this.f330d.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                uri2 = this.f328b.d;
                str = "localphototags";
                if (!contentValues.containsKey(Columns.k.f1025d)) {
                    throw new IllegalArgumentException("Missing " + Columns.k.f1025d + " for: " + uri);
                }
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                uri2 = this.f328b.d;
                str = "localphototags";
                contentValues.put(Columns.k.f1025d, DatabaseUtils.sqlEscapeString(uri.getLastPathSegment()));
                break;
            case 3:
                uri2 = this.f328b.e;
                str = "localphotometadata";
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                uri2 = this.f328b.f;
                str = "removedprefilledtags";
                break;
            default:
                throw new IllegalArgumentException("Unknown URI for insert: " + uri);
        }
        SQLiteDatabase a = this.f327a.mo2480a();
        SQLiteDetour.a(1895129872);
        long insert = a.insert(str, null, contentValues);
        SQLiteDetour.a(1987794871);
        if (insert > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
            return ContentUris.withAppendedId(uri2, insert);
        }
        throw new SQLException("Failed to insert row into " + uri);
    }

    protected final int mo4a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String str2;
        switch (this.f330d.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                str2 = "localphototags";
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                str2 = "localphototags";
                contentValues.put(Columns.k.f1025d, DatabaseUtils.sqlEscapeString(uri.getLastPathSegment()));
                break;
            case 3:
                str2 = "localphotometadata";
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                str2 = "removedprefilledtags";
                break;
            default:
                throw new IllegalArgumentException("Unknown URI for update: " + uri);
        }
        int update = this.f327a.mo2480a().update(str2, contentValues, str, strArr);
        if (update > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return update;
    }

    protected final int mo5a(Uri uri, String str, String[] strArr) {
        if (this.f328b.c.equals(uri)) {
            this.f327a.mo2481e();
            return 0;
        }
        String str2;
        switch (this.f330d.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                str2 = "localphototags";
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                str2 = "localphototags";
                Expression a = Columns.k.m2090a(DatabaseUtils.sqlEscapeString(uri.getLastPathSegment()));
                str = a.mo1476a();
                strArr = a.mo1477b();
                break;
            case 3:
                str2 = "localphotometadata";
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                str2 = "removedprefilledtags";
                break;
            default:
                throw new IllegalArgumentException("Unknown URI for delete: " + uri);
        }
        int delete = this.f327a.mo2480a().delete(str2, str, strArr);
        if (delete <= 0) {
            return delete;
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return delete;
    }
}
