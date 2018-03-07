package com.facebook.katana.provider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.SecureContentProvider;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.vault.VaultContract;
import com.facebook.ipc.vault.VaultContract.ImagesTable;
import com.facebook.ipc.vault.VaultContract.ImagesTable.Columns;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.vault.db.VaultImageDatabaseSupplier;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: zero_rating2/clearable/rewrite_rules */
public class VaultImageProvider extends SecureContentProvider {
    private static final String f380a = ("vnd.android.cursor.dir/" + VaultContract.f383a);
    private static final UriMatcher f381b;
    private VaultImageDatabaseSupplier f382c;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f381b = uriMatcher;
        uriMatcher.addURI(VaultContract.f383a, "images", 1);
        f381b.addURI(VaultContract.f383a, "images/*", 2);
    }

    public final void mo10a() {
        this.f382c = VaultImageDatabaseSupplier.a(FbInjector.get(getContext()));
    }

    protected final String mo8a(Uri uri) {
        switch (f381b.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return f380a;
            default:
                throw new IllegalArgumentException("Unknown URL " + uri);
        }
    }

    protected final Cursor mo6a(Uri uri, String[] strArr, @Nullable String str, String[] strArr2, @Nullable String str2) {
        List arrayList;
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("images");
        if (strArr2 == null) {
            arrayList = new ArrayList();
        } else {
            Object arrayList2 = new ArrayList(Arrays.asList(strArr2));
        }
        switch (f381b.match(uri)) {
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                String decode = Uri.decode(uri.getLastPathSegment());
                sQLiteQueryBuilder.appendWhere(StringFormatUtil.a("%s = ?", new Object[]{Columns.a.f1025d}));
                arrayList.add(decode);
                break;
        }
        Cursor query = sQLiteQueryBuilder.query(this.f382c.mo2480a(), strArr, str, (String[]) arrayList.toArray(new String[arrayList.size()]), null, null, str2);
        query.setNotificationUri(getContext().getContentResolver(), uri);
        return query;
    }

    protected final Uri mo7a(Uri uri, ContentValues contentValues) {
        SQLiteDatabase a = this.f382c.mo2480a();
        switch (f381b.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                if (!contentValues.containsKey(Columns.a.f1025d)) {
                    throw new IllegalArgumentException("Missing primary key (IMAGE_HASH) for:" + uri);
                }
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                contentValues.put(Columns.a.f1025d, Uri.decode(uri.getLastPathSegment()));
                break;
            default:
                throw new IllegalArgumentException("Unknown URL for insert: " + uri);
        }
        String str = Columns.b.f1025d;
        SQLiteDetour.a(971012033);
        long replace = a.replace("images", str, contentValues);
        SQLiteDetour.a(1865975644);
        if (replace > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
            return ContentUris.withAppendedId(ImagesTable.a, replace);
        }
        throw new SQLException("Failed to insert row into " + uri);
    }

    protected final int mo5a(Uri uri, String str, String[] strArr) {
        if (VaultContract.f384b.equals(uri)) {
            this.f382c.mo2481e();
            return 0;
        }
        SQLiteDatabase a = this.f382c.mo2480a();
        switch (f381b.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                int delete = a.delete("images", str, strArr);
                if (delete <= 0) {
                    return delete;
                }
                getContext().getContentResolver().notifyChange(uri, null);
                return delete;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                String decode = Uri.decode(uri.getLastPathSegment());
                List a2;
                if (TextUtils.isEmpty(str)) {
                    a2 = Lists.m1296a();
                    a2.add(decode);
                    return a.delete("images", StringFormatUtil.a("%s = ?", new Object[]{Columns.a.f1025d}), (String[]) a2.toArray(new String[a2.size()]));
                }
                a2 = new ArrayList(Arrays.asList(strArr));
                a2.add(decode);
                return a.delete("images", StringFormatUtil.a("%s and (%s = ?)", new Object[]{str, Columns.a.f1025d}), (String[]) a2.toArray(new String[a2.size()]));
            default:
                throw new IllegalArgumentException("Unknown URL for delete: " + uri);
        }
    }

    protected final int mo4a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        SQLiteDatabase a = this.f382c.mo2480a();
        switch (f381b.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                int update = a.update("images", contentValues, str, strArr);
                if (update <= 0) {
                    return update;
                }
                getContext().getContentResolver().notifyChange(uri, null);
                return update;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                String decode = Uri.decode(uri.getLastPathSegment());
                List a2;
                if (TextUtils.isEmpty(str)) {
                    a2 = Lists.m1296a();
                    a2.add(decode);
                    return a.update("images", contentValues, StringFormatUtil.a("%s = ?", new Object[]{Columns.a.f1025d}), (String[]) a2.toArray(new String[a2.size()]));
                }
                a2 = new ArrayList(Arrays.asList(strArr));
                a2.add(decode);
                return a.update("images", contentValues, StringFormatUtil.a("%s and (%s = ?)", new Object[]{str, Columns.a.f1025d}), (String[]) a2.toArray(new String[a2.size()]));
            default:
                throw new IllegalArgumentException("Unknown URL for update: " + uri);
        }
    }
}
