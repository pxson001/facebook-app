package com.facebook.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.database.sqlite.SqlKeys.ForeignKey;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: viewport_entry_ts */
public abstract class SqlTable {
    public final String f1016a;
    private final ImmutableList<SqlColumn> f1017b;
    @Nullable
    private final ImmutableList<SqlKeys$SqlKey> f1018c;

    public SqlTable(String str, ImmutableList<SqlColumn> immutableList, SqlKeys$SqlKey sqlKeys$SqlKey) {
        this(str, (ImmutableList) immutableList, ImmutableList.of(sqlKeys$SqlKey));
    }

    public SqlTable(String str, ImmutableList<SqlColumn> immutableList, ImmutableList<SqlKeys$SqlKey> immutableList2) {
        this.f1016a = str;
        this.f1017b = immutableList;
        this.f1018c = immutableList2;
    }

    public SqlTable(String str, ImmutableList<SqlColumn> immutableList) {
        this.f1016a = str;
        this.f1017b = immutableList;
        this.f1018c = null;
    }

    public void mo1453a(SQLiteDatabase sQLiteDatabase) {
        String a = m2071a(this.f1016a, this.f1017b, this.f1018c);
        SQLiteDetour.a(112597731);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-1177953716);
    }

    public void mo1454a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        String a = m2069a(this.f1016a);
        SQLiteDetour.a(497723133);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-1942166866);
        mo1453a(sQLiteDatabase);
    }

    public void mo1479b(SQLiteDatabase sQLiteDatabase) {
    }

    public void mo1455c(SQLiteDatabase sQLiteDatabase) {
    }

    public void m2087d(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.delete(this.f1016a, null, null);
    }

    public static String m2071a(String str, ImmutableList<SqlColumn> immutableList, ImmutableList<SqlKeys$SqlKey> immutableList2) {
        return m2072a(str, (ImmutableList) immutableList, (ImmutableList) immutableList2, "CREATE TABLE");
    }

    public static String m2081b(String str, ImmutableList<SqlColumn> immutableList, ImmutableList<SqlKeys$SqlKey> immutableList2) {
        return m2072a(str, (ImmutableList) immutableList, (ImmutableList) immutableList2, "CREATE TEMPORARY TABLE");
    }

    private static String m2072a(String str, ImmutableList<SqlColumn> immutableList, ImmutableList<SqlKeys$SqlKey> immutableList2, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(" ");
        stringBuilder.append(str);
        stringBuilder.append(" (");
        stringBuilder.append(Joiner.on(", ").join(Collections2.m847a((Collection) immutableList, SqlColumn.f1023b)));
        if (!(immutableList2 == null || immutableList2.isEmpty())) {
            stringBuilder.append(", ");
            stringBuilder.append(Joiner.on(", ").join(Collections2.m847a((Collection) immutableList2, SqlKeys.a)));
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static String m2069a(String str) {
        return "DROP TABLE IF EXISTS " + str;
    }

    public static String m2073a(String str, String str2, ImmutableList<SqlColumn> immutableList) {
        return m2074a(str, str2, m2075a((List) immutableList));
    }

    public static String m2082b(String str, String str2, ImmutableList<String> immutableList) {
        return m2074a(str, str2, Joiner.on(", ").join((Iterable) immutableList));
    }

    private static String m2074a(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE INDEX IF NOT EXISTS ");
        stringBuilder.append(str2);
        stringBuilder.append(" ON ");
        stringBuilder.append(str);
        stringBuilder.append(" (");
        stringBuilder.append(str3);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @VisibleForTesting
    public static String m2075a(List<SqlColumn> list) {
        return Joiner.on(", ").join(Collections2.m847a((Collection) list, SqlColumn.f1024c));
    }

    @VisibleForTesting
    private static String m2076a(List<SqlColumn> list, ImmutableMap<SqlColumn, Function<SqlColumn, String>> immutableMap) {
        return Joiner.on(", ").join(Collections2.m847a((Collection) list, new 1(immutableMap)));
    }

    public static String m2070a(String str, SqlColumn sqlColumn) {
        return "ALTER TABLE " + str + " ADD COLUMN " + sqlColumn.f1025d + " " + sqlColumn.f1026e;
    }

    private static void m2079a(SQLiteDatabase sQLiteDatabase, String str, ImmutableList<SqlColumn> immutableList, ImmutableMap<SqlColumn, Function<SqlColumn, String>> immutableMap, ImmutableList<SqlKeys$SqlKey> immutableList2) {
        String str2 = str + "_temp";
        String a = m2075a((List) immutableList);
        String a2 = m2076a((List) immutableList, (ImmutableMap) immutableMap);
        String str3 = "INSERT INTO %s SELECT %s FROM %s";
        a = StringFormatUtil.formatStrLocaleSafe(str3, str2, a, str);
        a2 = StringFormatUtil.formatStrLocaleSafe(str3, str, a2, str2);
        str3 = m2081b(str2, (ImmutableList) immutableList, (ImmutableList) immutableList2);
        SQLiteDetour.a(473449026);
        sQLiteDatabase.execSQL(str3);
        SQLiteDetour.a(-1605506033);
        SQLiteDetour.a(-979498907);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(1446436650);
        a = m2069a(str);
        SQLiteDetour.a(-1085276998);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-53664751);
        a = m2071a(str, (ImmutableList) immutableList, (ImmutableList) immutableList2);
        SQLiteDetour.a(171421176);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(731399037);
        SQLiteDetour.a(1619715909);
        sQLiteDatabase.execSQL(a2);
        SQLiteDetour.a(232419042);
        str2 = m2069a(str2);
        SQLiteDetour.a(-1317361625);
        sQLiteDatabase.execSQL(str2);
        SQLiteDetour.a(1744157989);
    }

    public static void m2078a(SQLiteDatabase sQLiteDatabase, String str, ImmutableList<SqlColumn> immutableList, ImmutableMap<SqlColumn, Function<SqlColumn, String>> immutableMap, SqlKeys$SqlKey sqlKeys$SqlKey) {
        m2079a(sQLiteDatabase, str, (ImmutableList) immutableList, (ImmutableMap) immutableMap, ImmutableList.of(sqlKeys$SqlKey));
    }

    public static void m2077a(SQLiteDatabase sQLiteDatabase, String str, ImmutableList<SqlColumn> immutableList, SqlKeys$SqlKey sqlKeys$SqlKey) {
        ImmutableList of = ImmutableList.of(sqlKeys$SqlKey);
        String str2 = str + "_temp";
        String a = m2075a((List) immutableList);
        String str3 = "INSERT INTO %s SELECT %s FROM %s";
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(str3, str2, a, str);
        a = StringFormatUtil.formatStrLocaleSafe(str3, str, a, str2);
        str3 = m2081b(str2, (ImmutableList) immutableList, of);
        SQLiteDetour.a(-1149920851);
        sQLiteDatabase.execSQL(str3);
        SQLiteDetour.a(-1785752329);
        SQLiteDetour.a(850764554);
        sQLiteDatabase.execSQL(formatStrLocaleSafe);
        SQLiteDetour.a(251701695);
        str3 = m2069a(str);
        SQLiteDetour.a(-2016946717);
        sQLiteDatabase.execSQL(str3);
        SQLiteDetour.a(1712495344);
        str3 = m2071a(str, (ImmutableList) immutableList, of);
        SQLiteDetour.a(857230874);
        sQLiteDatabase.execSQL(str3);
        SQLiteDetour.a(-816686386);
        SQLiteDetour.a(500927114);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-500326047);
        str2 = m2069a(str2);
        SQLiteDetour.a(-1662462568);
        sQLiteDatabase.execSQL(str2);
        SQLiteDetour.a(831759200);
    }

    public static void m2080a(SQLiteDatabase sQLiteDatabase, String str, String str2, ImmutableList<SqlColumn> immutableList, ImmutableList<SqlColumn> immutableList2, ImmutableList<SqlColumn> immutableList3, @Nullable String str3) {
        int size = immutableList3.size();
        for (int i = 0; i < size; i++) {
            SqlColumn sqlColumn = (SqlColumn) immutableList3.get(i);
            String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("DELETE FROM %s where %s NOT IN (SELECT %s FROM %s)", str, sqlColumn.f1025d, sqlColumn.f1025d, str2);
            SQLiteDetour.a(887488074);
            sQLiteDatabase.execSQL(formatStrLocaleSafe);
            SQLiteDetour.a(424113740);
        }
        m2079a(sQLiteDatabase, str, (ImmutableList) immutableList, RegularImmutableBiMap.f695a, ImmutableList.of(new SqlKeys$PrimaryKey(immutableList2), new ForeignKey(immutableList3, str2, immutableList3, str3)));
    }
}
