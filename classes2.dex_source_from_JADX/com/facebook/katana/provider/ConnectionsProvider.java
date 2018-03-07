package com.facebook.katana.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.auth.module.TriState_IsMeUserAnEmployeeMethodAutoProvider;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.TriState;
import com.facebook.connections.db.ConnectionsDatabaseSupplier;
import com.facebook.content.SecureContentProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.connections.ConnectionsContract;
import com.facebook.ipc.connections.ConnectionsContract.SearchResultsTable;
import com.facebook.ipc.connections.ConnectionsContract.SearchResultsTable.Columns;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;

/* compiled from: zero_rtt_enabled */
public class ConnectionsProvider extends SecureContentProvider {
    private static final UriMatcher f331a;
    private ConnectionsDatabaseSupplier f332b;
    private AbstractFbErrorReporter f333c;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f331a = uriMatcher;
        uriMatcher.addURI(ConnectionsContract.f334a, "search_results", 1);
    }

    protected final synchronized void mo10a() {
        InjectorLike injectorLike = FbInjector.get(getContext());
        this.f332b = ConnectionsDatabaseSupplier.a(injectorLike);
        this.f333c = FbErrorReporterImpl.m2317a(injectorLike);
    }

    protected final Cursor mo6a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        if (f331a.match(uri) == 1) {
            sQLiteQueryBuilder.setTables("search_results");
            String str3 = "_id ASC";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str2;
            }
            Cursor query = sQLiteQueryBuilder.query(this.f332b.mo2480a(), strArr, str, strArr2, null, null, str3, null);
            query.setNotificationUri(getContext().getContentResolver(), uri);
            return query;
        }
        throw new IllegalArgumentException("Unknown URL " + uri);
    }

    protected final String mo8a(Uri uri) {
        if (f331a.match(uri) > 0) {
            return "vnd.android.cursor.item/vnd.com.facebook.katana.provider.friends";
        }
        throw new IllegalArgumentException("Unknown URL " + uri);
    }

    protected final Uri mo7a(Uri uri, ContentValues contentValues) {
        SQLiteDatabase a = this.f332b.mo2480a();
        if (f331a.match(uri) == 1) {
            String str = Columns.c.f1025d;
            SQLiteDetour.a(1373377956);
            long insert = a.insert("search_results", str, contentValues);
            SQLiteDetour.a(1978615063);
            if (insert > 0) {
                getContext().getContentResolver().notifyChange(SearchResultsTable.a, null);
            }
            return Uri.withAppendedPath(SearchResultsTable.a, String.valueOf(insert));
        }
        throw new IllegalArgumentException("Unknown URL " + uri);
    }

    protected final int mo42a(Uri uri, ContentValues[] contentValuesArr) {
        int i = 0;
        SQLiteDatabase a = this.f332b.mo2480a();
        if (f331a.match(uri) == 1) {
            SQLiteDetour.a(a, 975512562);
            try {
                int i2 = 0;
                for (ContentValues contentValues : contentValuesArr) {
                    String a2 = Columns.b.m2091a();
                    SQLiteDetour.a(-2006886675);
                    long insert = a.insert("search_results", a2, contentValues);
                    SQLiteDetour.a(-659493664);
                    if (insert > 0) {
                        i2++;
                    } else {
                        i++;
                    }
                }
                a.setTransactionSuccessful();
                SQLiteDetour.b(a, -1116458314);
                if (i2 != 0) {
                    getContext().getContentResolver().notifyChange(SearchResultsTable.a, null);
                }
                if (i > 0) {
                    this.f333c.m2340a("Failed insert into SEARCH_RESULTS_TABLE", StringFormatUtil.formatStrLocaleSafe("Failed on %d rows", Integer.valueOf(i)));
                }
                return i2;
            } catch (RuntimeException e) {
                throw m668a(e, "Error in bulk insert of search results");
            } catch (Throwable th) {
                SQLiteDetour.b(a, -301675046);
            }
        } else {
            throw new IllegalArgumentException("Unknown URL " + uri);
        }
    }

    protected final int mo4a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("Nothing is updatable here");
    }

    protected final int mo5a(Uri uri, String str, String[] strArr) {
        if (ConnectionsContract.f335b.equals(uri)) {
            this.f332b.mo2481e();
            return 0;
        }
        SQLiteDatabase a = this.f332b.mo2480a();
        if (f331a.match(uri) == 1) {
            int delete = a.delete("search_results", str, strArr);
            if (delete <= 0) {
                return delete;
            }
            getContext().getContentResolver().notifyChange(SearchResultsTable.a, null);
            return delete;
        }
        throw new IllegalArgumentException("Unknown URL " + uri);
    }

    private RuntimeException m668a(RuntimeException runtimeException, String str) {
        if ((TriState.YES == TriState_IsMeUserAnEmployeeMethodAutoProvider.m11944b(FbInjector.get(getContext())) ? 1 : null) != null || BuildConstants.i) {
            return runtimeException;
        }
        return new IllegalArgumentException(str);
    }
}
