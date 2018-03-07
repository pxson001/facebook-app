package com.facebook.assetdownload.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.assetdownload.AssetDownloadConfiguration;
import com.facebook.assetdownload.AssetDownloadConfiguration.ConnectionConstraint;
import com.facebook.assetdownload.repository.AssetDownloadDbSchemaPart.ConfigurationRepositoryTable.Columns;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.ConjunctionExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: failed saving file */
public class AssetDownloadConfigurationRepository {
    private final AssetDownloadDatabaseSupplier f12327a;
    private final AssetDownloadConfigurationMarshaller f12328b;

    public static AssetDownloadConfigurationRepository m13009b(InjectorLike injectorLike) {
        return new AssetDownloadConfigurationRepository(AssetDownloadDatabaseSupplier.m13018a(injectorLike), AssetDownloadConfigurationMarshaller.m13022a(injectorLike));
    }

    @Inject
    public AssetDownloadConfigurationRepository(AssetDownloadDatabaseSupplier assetDownloadDatabaseSupplier, AssetDownloadConfigurationMarshaller assetDownloadConfigurationMarshaller) {
        this.f12327a = assetDownloadDatabaseSupplier;
        this.f12328b = assetDownloadConfigurationMarshaller;
    }

    public final boolean m13013a(AssetDownloadConfiguration assetDownloadConfiguration, boolean z) {
        return m13006a(this.f12327a.a(), z ? 5 : 3, assetDownloadConfiguration);
    }

    public final ImmutableList<AssetDownloadConfiguration> m13011a() {
        return m13005a(null);
    }

    public final ImmutableList<AssetDownloadConfiguration> m13012a(int i, ConnectionConstraint connectionConstraint, long j, long j2, long j3) {
        Preconditions.checkNotNull(connectionConstraint, "connectionConstraint must not be null");
        Preconditions.checkArgument(j > 0, "olderThanTimestamp must be greater 0");
        Preconditions.checkArgument(i > 0, "maxNumberOfConfigurations must be greater 0");
        SQLiteDatabase a = this.f12327a.a();
        r1 = new Expression[3];
        r1[0] = SqlExpression.b(new Expression[]{Columns.f12338f.b(Long.toString(j)), Columns.f12338f.d(Long.toString(j3))});
        r1[1] = SqlExpression.b(new Expression[]{Columns.f12339g.b(Long.toString(j2)), Columns.f12339g.d(Long.toString(j3))});
        r1[2] = Columns.f12337e.a(connectionConstraint.name());
        ConjunctionExpression a2 = SqlExpression.a(r1);
        Cursor query = a.query("configurations", new String[]{Columns.f12333a.a(), Columns.f12335c.a()}, a2.a(), a2.b(), null, null, Columns.f12336d.e(), Integer.toString(i));
        Builder builder = new Builder();
        try {
            int a3 = Columns.f12335c.a(query);
            while (query.moveToNext()) {
                builder.c(this.f12328b.m13024a(query.getBlob(a3)));
            }
            return builder.b();
        } finally {
            query.close();
        }
    }

    public final boolean m13014a(String str, long j) {
        Preconditions.checkNotNull(str, "identifier must not be null");
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.f12338f.d, Long.valueOf(j));
        return m13007a(str, contentValues);
    }

    public final boolean m13016b(String str, long j) {
        Preconditions.checkNotNull(str, "identifier must not be null");
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.f12339g.d, Long.valueOf(j));
        return m13007a(str, contentValues);
    }

    public final int m13015b() {
        return m13008b(null);
    }

    public final int m13017c() {
        return m13008b(Columns.f12338f.e(Long.toString(0)));
    }

    public final int m13010a(long j, long j2) {
        return m13008b(SqlExpression.a(new Expression[]{Columns.f12339g.e(Long.toString(j)), Columns.f12339g.c(Long.toString(j2))}));
    }

    private ContentValues m13004a(AssetDownloadConfiguration assetDownloadConfiguration) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.f12333a.d, assetDownloadConfiguration.mIdentifier);
        contentValues.put(Columns.f12334b.d, assetDownloadConfiguration.mNamespace);
        contentValues.put(Columns.f12335c.d, this.f12328b.m13025a(assetDownloadConfiguration));
        contentValues.put(Columns.f12336d.d, Integer.valueOf(assetDownloadConfiguration.mPriority));
        contentValues.put(Columns.f12337e.d, assetDownloadConfiguration.mConnectionConstraint.name());
        return contentValues;
    }

    private boolean m13006a(SQLiteDatabase sQLiteDatabase, int i, AssetDownloadConfiguration assetDownloadConfiguration) {
        ContentValues a = m13004a(assetDownloadConfiguration);
        try {
            SQLiteDetour.a(-1363011985);
            long insertWithOnConflict = sQLiteDatabase.insertWithOnConflict("configurations", null, a, i);
            SQLiteDetour.a(-1250892477);
            if (insertWithOnConflict >= 0) {
                return true;
            }
            return false;
        } catch (SQLiteConstraintException e) {
            if (i == 3) {
                return false;
            }
            throw e;
        }
    }

    private ImmutableList<AssetDownloadConfiguration> m13005a(@Nullable Expression expression) {
        String a;
        String[] b;
        SQLiteDatabase a2 = this.f12327a.a();
        String str = "configurations";
        String[] strArr = new String[]{Columns.f12333a.a(), Columns.f12335c.a()};
        if (expression != null) {
            a = expression.a();
        } else {
            a = null;
        }
        if (expression != null) {
            b = expression.b();
        } else {
            b = null;
        }
        Cursor query = a2.query(str, strArr, a, b, null, null, null);
        Builder builder = new Builder();
        try {
            int a3 = Columns.f12335c.a(query);
            while (query.moveToNext()) {
                builder.c(this.f12328b.m13024a(query.getBlob(a3)));
            }
            return builder.b();
        } finally {
            query.close();
        }
    }

    private boolean m13007a(String str, ContentValues contentValues) {
        Preconditions.checkNotNull(str, "identifier must not be null");
        if (this.f12327a.a().update("configurations", contentValues, Columns.f12333a + "=?", new String[]{str}) > 0) {
            return true;
        }
        return false;
    }

    private int m13008b(@Nullable Expression expression) {
        Cursor rawQuery = this.f12327a.a().rawQuery("SELECT COUNT (*) FROM configurations" + (expression != null ? " WHERE " + expression.a() : ""), expression != null ? expression.b() : new String[0]);
        try {
            rawQuery.moveToNext();
            int i = rawQuery.getInt(0);
            return i;
        } finally {
            rawQuery.close();
        }
    }
}
