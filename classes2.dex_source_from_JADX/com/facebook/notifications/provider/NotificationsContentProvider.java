package com.facebook.notifications.provider;

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
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.SecureContentProvider;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.notifications.GraphQLNotificationsContract;
import com.facebook.ipc.notifications.GraphQLNotificationsContract.GraphQLNotificationsTable.Columns;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.notifications.db.GraphQLNotificationsDatabaseSupplier;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.base.Joiner;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: zero_rating_enabled_on_wifi */
public abstract class NotificationsContentProvider extends SecureContentProvider {
    private static final Class<?> f339a = NotificationsContentProvider.class;
    private UriMatcher f340b;
    public GraphQLNotificationsContract f341c;
    public GraphQLNotificationsDatabaseSupplier f342d;
    public JewelCounters f343e;
    public Provider<String> f344f;

    public static void m681a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        NotificationsContentProvider notificationsContentProvider = (NotificationsContentProvider) obj;
        GraphQLNotificationsDatabaseSupplier a = GraphQLNotificationsDatabaseSupplier.a(injectorLike);
        JewelCounters a2 = JewelCounters.m6558a(injectorLike);
        GraphQLNotificationsContract b = GraphQLNotificationsContract.b(injectorLike);
        Provider a3 = IdBasedProvider.m1811a(injectorLike, 4442);
        notificationsContentProvider.f342d = a;
        notificationsContentProvider.f343e = a2;
        notificationsContentProvider.f341c = b;
        notificationsContentProvider.f344f = a3;
    }

    protected final Cursor mo6a(Uri uri, String[] strArr, String str, String[] strArr2, @Nullable String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        switch (this.f340b.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                sQLiteQueryBuilder.setTables("gql_notifications");
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                sQLiteQueryBuilder.setTables("gql_notifications");
                sQLiteQueryBuilder.appendWhere(Columns.a.f1025d + "=" + ((String) uri.getPathSegments().get(1)));
                break;
            default:
                throw new IllegalArgumentException("Unknown URL " + uri);
        }
        Cursor query = sQLiteQueryBuilder.query(this.f342d.mo2480a(), strArr, str, strArr2, null, null, TextUtils.isEmpty(str2) ? "updated DESC" : str2, uri.getQueryParameter("LIMIT"));
        query.setNotificationUri(getContext().getContentResolver(), uri.buildUpon().query("").build());
        return query;
    }

    protected final String mo8a(Uri uri) {
        switch (this.f340b.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return "vnd.android.cursor.dir/vnd.facebook.katana.gql_notifications";
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
        if (this.f340b.match(uri) != 1) {
            throw new IllegalArgumentException("Unknown URL " + uri);
        }
        String str = Columns.b.f1025d;
        SQLiteDetour.a(-930045431);
        long insertOrThrow = this.f342d.mo2480a().insertOrThrow("gql_notifications", str, contentValues2);
        SQLiteDetour.a(304796549);
        if (insertOrThrow > 0) {
            m683e();
            Uri withAppendedPath = Uri.withAppendedPath(this.f341c.b, Long.toString(insertOrThrow));
            m682d(uri);
            return withAppendedPath;
        }
        throw new SQLException("Failed to insert row into " + uri);
    }

    protected final int mo42a(Uri uri, ContentValues[] contentValuesArr) {
        int i = 0;
        if (this.f340b.match(uri) != 1) {
            throw new IllegalArgumentException("Unknown URL " + uri);
        }
        SQLiteDatabase a = this.f342d.mo2480a();
        int i2 = 0;
        while (i < contentValuesArr.length) {
            String str = Columns.b.f1025d;
            ContentValues contentValues = contentValuesArr[i];
            SQLiteDetour.a(-1608176546);
            long insert = a.insert("gql_notifications", str, contentValues);
            SQLiteDetour.a(1639119034);
            if (insert > 0) {
                i2++;
            }
            i++;
        }
        if (i2 > 0) {
            m683e();
            m682d(uri);
            return i2;
        }
        throw new SQLException("Failed to insert row into " + uri);
    }

    private void m682d(Uri uri) {
        if (uri.getQueryParameter("NO_NOTIFY") == null) {
            mo52c(uri);
        }
    }

    protected void mo52c(Uri uri) {
        getContext().getContentResolver().notifyChange(uri, null);
    }

    protected final int mo4a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int update;
        SQLiteDatabase a = this.f342d.mo2480a();
        switch (this.f340b.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                update = a.update("gql_notifications", contentValues, str, strArr);
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                update = a.update("gql_notifications", contentValues, Columns.a.f1025d + "=" + ((String) uri.getPathSegments().get(1)), null);
                break;
            default:
                throw new IllegalArgumentException("Unknown URL " + uri);
        }
        if (update > 0 && contentValues.containsKey(Columns.d.f1025d)) {
            m683e();
        }
        if (update > 0) {
            m682d(uri);
        }
        return update;
    }

    protected final int mo5a(Uri uri, String str, String[] strArr) {
        int delete;
        SQLiteDatabase a = this.f342d.mo2480a();
        switch (this.f340b.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                try {
                    delete = a.delete("gql_notifications", str, strArr);
                    break;
                } catch (Throwable e) {
                    BLog.b(f339a, "db.delete SQLiteFullException", e);
                    delete = 0;
                    break;
                } catch (Throwable e2) {
                    BLog.b(f339a, "db.delete SQLiteDiskIOException", e2);
                    delete = 0;
                    break;
                }
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                try {
                    delete = a.delete("gql_notifications", Columns.a.m2091a() + "=" + ((String) uri.getPathSegments().get(1)), null);
                    break;
                } catch (Throwable e22) {
                    BLog.b(f339a, "db.delete SQLiteFullException", e22);
                    delete = 0;
                    break;
                } catch (Throwable e222) {
                    BLog.b(f339a, "db.delete SQLiteDiskIOException", e222);
                    delete = 0;
                    break;
                }
            default:
                throw new IllegalArgumentException("Unknown URL " + uri);
        }
        if (delete > 0) {
            m683e();
            m682d(uri);
        }
        return delete;
    }

    protected void mo10a() {
        Class cls = NotificationsContentProvider.class;
        m681a((Object) this, getContext());
        AppInitLockHelper.m8874a(getContext());
        this.f340b = new UriMatcher(-1);
        this.f340b.addURI(this.f341c.a, "gql_notifications", 1);
        this.f340b.addURI(this.f341c.a, "gql_notifications/#", 2);
    }

    private void m683e() {
        r6 = new Object[5];
        r6[2] = StringFormatUtil.a("%s == %s", new Object[]{Columns.d.f1025d, DatabaseUtils.sqlEscapeString(GraphQLStorySeenState.UNSEEN_AND_UNREAD.name())});
        r6[3] = "AND";
        r6[4] = StringFormatUtil.a("%s == %s", new Object[]{Columns.c.f1025d, String.valueOf(this.f344f.get())});
        Cursor rawQuery = this.f342d.mo2480a().rawQuery(Joiner.on(" ").join("SELECT COUNT(*)", "FROM", r6), null);
        rawQuery.moveToFirst();
        int i = (int) rawQuery.getLong(0);
        rawQuery.close();
        int i2 = i;
        Integer.valueOf(i2);
        this.f343e.m6561a(Jewel.NOTIFICATIONS, i2);
    }
}
