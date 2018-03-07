package com.facebook.search.bootstrap.db.data;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteQueryBuilder;
import android.text.TextUtils;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.inject.InjectorLike;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.bootstrap.common.normalizer.NormalizedTokenHelper;
import com.facebook.search.bootstrap.db.data.BootstrapDbSchemaPart.EntitiesIndexTable;
import com.facebook.search.bootstrap.db.data.BootstrapDbSchemaPart.EntitiesPhoneticIndexTable;
import com.facebook.search.bootstrap.db.data.BootstrapDbSchemaPart.EntitiesTable.Columns;
import com.facebook.search.bootstrap.db.data.BootstrapDbSchemaPart.KeywordsIndexTable;
import com.facebook.search.bootstrap.db.data.BootstrapDbSchemaPart.KeywordsTable;
import com.facebook.search.util.text.TextToPhoneticAndNormalizedTokensUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: external_links */
public class BootstrapDbFetchHelper {
    private static final String f15652b = (Columns.f15687i + " ASC");
    private static final String[] f15653c = new String[]{Columns.f15680b.d, Columns.f15681c.d, Columns.f15682d.d, Columns.f15683e.d, Columns.f15684f.d, Columns.f15685g.d, Columns.f15686h.d, Columns.f15687i.d, Columns.f15688j.d};
    private static final String[] f15654d = new String[]{Columns.f15680b.d};
    private static final String f15655e = (KeywordsTable.Columns.f15700g + " ASC");
    private static final String[] f15656f = new String[]{KeywordsTable.Columns.f15695b.d, KeywordsTable.Columns.f15696c.d, KeywordsTable.Columns.f15697d.d, KeywordsTable.Columns.f15698e.d, KeywordsTable.Columns.f15699f.d, KeywordsTable.Columns.f15700g.d, KeywordsTable.Columns.f15701h.d};
    private static final String[] f15657g = new String[]{KeywordsTable.Columns.f15695b.d};
    public final TextToPhoneticAndNormalizedTokensUtil f15658a;
    private final BootstrapDatabaseSupplier f15659h;
    private final NormalizedTokenHelper f15660i;

    public static BootstrapDbFetchHelper m23383b(InjectorLike injectorLike) {
        return new BootstrapDbFetchHelper(BootstrapDatabaseSupplier.m23374a(injectorLike), NormalizedTokenHelper.m23188b(injectorLike), TextToPhoneticAndNormalizedTokensUtil.m23593b(injectorLike));
    }

    @Inject
    public BootstrapDbFetchHelper(BootstrapDatabaseSupplier bootstrapDatabaseSupplier, NormalizedTokenHelper normalizedTokenHelper, TextToPhoneticAndNormalizedTokensUtil textToPhoneticAndNormalizedTokensUtil) {
        this.f15659h = bootstrapDatabaseSupplier;
        this.f15660i = normalizedTokenHelper;
        this.f15658a = textToPhoneticAndNormalizedTokensUtil;
    }

    public final Cursor m23385a(String str, int i) {
        ImmutableList a;
        NormalizedTokenHelper normalizedTokenHelper = this.f15660i;
        if (normalizedTokenHelper.f15583e.a(ExperimentsForSearchAbTestModule.I, false)) {
            a = normalizedTokenHelper.f15581c.m23591a(str);
        } else {
            a = normalizedTokenHelper.f15581c.m23592b(str);
        }
        ImmutableList immutableList = a;
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("entities");
        return m23380a(sQLiteQueryBuilder, f15653c, m23381a(immutableList, Columns.f15679a, "entities_data", EntitiesIndexTable.Columns.f15671a, EntitiesIndexTable.Columns.f15672b), f15652b, i);
    }

    public final Cursor m23387b(String str, int i) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("entities");
        Builder builder = new Builder();
        ImmutableList a = this.f15658a.m23594a(str);
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            builder.c(DatabaseUtils.sqlEscapeString((String) a.get(i2)));
        }
        return m23380a(sQLiteQueryBuilder, f15653c, Columns.f15679a + " IN ( SELECT " + EntitiesPhoneticIndexTable.Columns.f15675a + " FROM entities_phonetic_data" + " WHERE " + EntitiesPhoneticIndexTable.Columns.f15676b + " IN (" + TextUtils.join(",", builder.b()) + "))", f15652b, i);
    }

    public final Cursor m23389c(String str, int i) {
        ImmutableList b = this.f15660i.f15581c.m23592b(str);
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("keywords");
        return m23380a(sQLiteQueryBuilder, f15656f, m23381a(b, KeywordsTable.Columns.f15694a, "keywords_data", KeywordsIndexTable.Columns.f15690a, KeywordsIndexTable.Columns.f15691b), f15655e, i);
    }

    public final ImmutableList<String> m23386a(ImmutableList<String> immutableList) {
        Cursor query;
        Throwable th;
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables(m23384c(immutableList));
        try {
            query = sQLiteQueryBuilder.query(this.f15659h.a(), f15654d, null, null, null, null, null);
            try {
                Builder builder = new Builder();
                while (query != null && query.moveToNext()) {
                    builder.c(query.getString(0));
                }
                ImmutableList<String> b = builder.b();
                if (query != null) {
                    query.close();
                }
                return b;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final ImmutableList<String> m23388b(ImmutableList<String> immutableList) {
        Throwable th;
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("keywords");
        Cursor query;
        try {
            Expression a = SqlExpression.a(KeywordsTable.Columns.f15695b.a(), immutableList);
            query = sQLiteQueryBuilder.query(this.f15659h.a(), f15657g, a.a(), a.b(), null, null, null);
            try {
                Builder builder = new Builder();
                while (query != null && query.moveToNext()) {
                    builder.c(query.getString(0));
                }
                ImmutableList<String> b = builder.b();
                if (query != null) {
                    query.close();
                }
                return b;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private static String m23384c(ImmutableList<String> immutableList) {
        return " entities" + " WHERE " + Columns.f15680b + " IN ( " + TextUtils.join(",", immutableList) + " )";
    }

    private static String m23381a(ImmutableList<String> immutableList, SqlColumn sqlColumn, String str, SqlColumn sqlColumn2, SqlColumn sqlColumn3) {
        StringBuilder append = new StringBuilder(200).append(sqlColumn).append(" IN (");
        int size = immutableList.size() - 1;
        int size2 = immutableList.size();
        int i = 0;
        int i2 = 0;
        while (i < size2) {
            boolean z;
            String str2 = (String) immutableList.get(i);
            if (i2 > 0) {
                append.append(" INTERSECT ");
            }
            if (i2 == size) {
                z = true;
            } else {
                z = false;
            }
            m23382a(append, str2, str, sqlColumn2, sqlColumn3, z);
            i++;
            i2++;
        }
        append.append(")");
        return append.toString();
    }

    private static void m23382a(StringBuilder stringBuilder, String str, String str2, SqlColumn sqlColumn, SqlColumn sqlColumn2, boolean z) {
        stringBuilder.append("SELECT ").append(sqlColumn).append(" FROM ").append(str2).append(" WHERE ").append(sqlColumn2);
        if (z) {
            stringBuilder.append(" BETWEEN X'").append(str).append("' AND X'").append(str).append("FF");
        } else {
            stringBuilder.append(" = X'").append(str);
        }
        stringBuilder.append("'");
    }

    private Cursor m23380a(SQLiteQueryBuilder sQLiteQueryBuilder, String[] strArr, String str, String str2, int i) {
        return sQLiteQueryBuilder.query(this.f15659h.a(), strArr, str, null, null, null, str2, String.valueOf(i));
    }
}
