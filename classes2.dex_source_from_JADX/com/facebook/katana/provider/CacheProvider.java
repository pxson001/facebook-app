package com.facebook.katana.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.SecureContentProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.ipc.cache.CacheContract;
import com.facebook.ipc.cache.CacheContract.CacheTable;
import com.facebook.ipc.cache.CacheContract.CacheTable.Columns;
import com.facebook.manageddatastore.db.MDSCacheDatabaseSupplier;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import javax.annotation.Nullable;

/* compiled from: zero_rating2/clearable/zero_header_params_refresh_ttl */
public class CacheProvider extends SecureContentProvider {
    private static final UriMatcher f364a;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MDSCacheDatabaseSupplier> f365b = UltralightRuntime.f368b;

    private static <T extends InjectableComponentWithContext> void m721a(Class<T> cls, T t) {
        m722a((Object) t, t.getContext());
    }

    private static void m722a(Object obj, Context context) {
        ((CacheProvider) obj).f365b = IdBasedSingletonScopeProvider.m1810b(FbInjector.get(context), 2524);
    }

    private void m720a(com.facebook.inject.Lazy<MDSCacheDatabaseSupplier> lazy) {
        this.f365b = lazy;
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f364a = uriMatcher;
        uriMatcher.addURI(CacheContract.f366a, "cache", 1);
        f364a.addURI(CacheContract.f366a, "cache/#", 2);
        f364a.addURI(CacheContract.f366a, "cache/name/*", 3);
        f364a.addURI(CacheContract.f366a, "cache/prefix/*", 4);
        f364a.addURI(CacheContract.f366a, "cache/sweep_prefix/*/#", 5);
    }

    public final void mo10a() {
        m721a(CacheProvider.class, (InjectableComponentWithContext) this);
    }

    protected final Cursor mo6a(Uri uri, String[] strArr, @Nullable String str, String[] strArr2, @Nullable String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        switch (f364a.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                sQLiteQueryBuilder.setTables("cache");
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                sQLiteQueryBuilder.setTables("cache");
                sQLiteQueryBuilder.appendWhere(Columns.a.f1025d + "=" + ((String) uri.getPathSegments().get(1)));
                break;
            case 3:
                sQLiteQueryBuilder.setTables("cache");
                sQLiteQueryBuilder.appendWhere(Columns.b.f1025d + "=" + DatabaseUtils.sqlEscapeString((String) uri.getPathSegments().get(2)));
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                String str3 = (String) uri.getPathSegments().get(2);
                sQLiteQueryBuilder.setTables("cache");
                sQLiteQueryBuilder.appendWhere(StringFormatUtil.formatStrLocaleSafe("SUBSTR(%s, 1, %d)=%s", Columns.b.f1025d, Integer.valueOf(str3.length()), DatabaseUtils.sqlEscapeString(str3)));
                break;
            default:
                throw new IllegalArgumentException("Unknown URL " + uri);
        }
        Cursor query = sQLiteQueryBuilder.query(((MDSCacheDatabaseSupplier) this.f365b.get()).mo2480a(), strArr, str, strArr2, null, null, TextUtils.isEmpty(str2) ? "name DESC" : str2);
        query.setNotificationUri(getContext().getContentResolver(), uri);
        return query;
    }

    protected final String mo8a(Uri uri) {
        switch (f364a.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
                return "vnd.android.cursor.item/vnd.facebook.katana.cache";
            default:
                throw new IllegalArgumentException("Unknown URL " + uri);
        }
    }

    protected final Uri mo7a(Uri uri, ContentValues contentValues) {
        if (f364a.match(uri) != 1) {
            throw new IllegalArgumentException("Unknown URL " + uri);
        }
        ContentValues contentValues2;
        if (contentValues != null) {
            contentValues2 = new ContentValues(contentValues);
        } else {
            contentValues2 = new ContentValues();
        }
        String str = Columns.b.f1025d;
        SQLiteDetour.a(-150004833);
        long replaceOrThrow = ((MDSCacheDatabaseSupplier) this.f365b.get()).mo2480a().replaceOrThrow("cache", str, contentValues2);
        SQLiteDetour.a(1796686245);
        if (replaceOrThrow <= 0) {
            throw new SQLException("Failed to insert row into " + uri);
        }
        Uri withAppendedPath = Uri.withAppendedPath(CacheTable.a, Long.toString(replaceOrThrow));
        getContext().getContentResolver().notifyChange(uri, null, false);
        return withAppendedPath;
    }

    protected final int mo4a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int update;
        SQLiteDatabase a = ((MDSCacheDatabaseSupplier) this.f365b.get()).mo2480a();
        String str2;
        switch (f364a.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                update = a.update("cache", contentValues, str, strArr);
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                str2 = "cache";
                update = a.update(str2, contentValues, Columns.a.f1025d + "=" + ((String) uri.getPathSegments().get(1)), null);
                break;
            case 3:
                str2 = "cache";
                update = a.update(str2, contentValues, Columns.b.f1025d + "=" + DatabaseUtils.sqlEscapeString((String) uri.getPathSegments().get(2)), null);
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                String str3 = (String) uri.getPathSegments().get(2);
                update = a.update("cache", contentValues, StringFormatUtil.formatStrLocaleSafe("SUBSTR(%s, 1, %d)=%s", Columns.b.f1025d, Integer.valueOf(str3.length()), DatabaseUtils.sqlEscapeString(str3)), null);
                break;
            default:
                throw new IllegalArgumentException("Unknown URL " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null, false);
        return update;
    }

    protected final int mo5a(Uri uri, String str, String[] strArr) {
        int delete;
        SQLiteDatabase a = ((MDSCacheDatabaseSupplier) this.f365b.get()).mo2480a();
        String str2;
        switch (f364a.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                delete = a.delete("cache", str, strArr);
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                delete = a.delete("cache", Columns.a.f1025d + "=" + ((String) uri.getPathSegments().get(1)), null);
                break;
            case 3:
                String str3 = "cache";
                delete = a.delete(str3, Columns.b.f1025d + "=" + DatabaseUtils.sqlEscapeString((String) uri.getPathSegments().get(2)), null);
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                str2 = (String) uri.getPathSegments().get(2);
                delete = a.delete("cache", StringFormatUtil.formatStrLocaleSafe("SUBSTR(%s, 1, %d)=%s", Columns.b.f1025d, Integer.valueOf(str2.length()), DatabaseUtils.sqlEscapeString(str2)), null);
                break;
            case 5:
                str2 = (String) uri.getPathSegments().get(2);
                int parseInt = Integer.parseInt((String) uri.getPathSegments().get(3));
                Object[] objArr = new Object[]{Columns.b.f1025d, Integer.valueOf(str2.length()), DatabaseUtils.sqlEscapeString(str2), Long.valueOf(System.currentTimeMillis() / 1000), Columns.d.f1025d, Integer.valueOf(parseInt)};
                delete = a.delete("cache", StringFormatUtil.a("SUBSTR(%s, 1, %d)=%s AND (%d-%s > %d)", objArr), null);
                break;
            default:
                throw new IllegalArgumentException("Unknown URL " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null, false);
        return delete;
    }
}
