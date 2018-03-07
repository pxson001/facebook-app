package com.facebook.prefs.shared;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.gk.internal.RemoveGatekeepersFbSharedPrefsUpgradeStep;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferencesContract.PreferencesTable;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Throwables;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: vnd.android.cursor.item/vnd.facebook.katana.bookmark_group_order */
public class FbSharedPreferencesDbStorage implements FbSharedPreferencesStorage {
    public static final PrefKey f982a = ((PrefKey) SharedPrefKeys.f988b.m2011a("version"));
    private final SharedPrefsDatabaseSupplier f983b;
    private final Lazy<FbErrorReporter> f984c;
    private final Random f985d;
    public final Provider<Set<FbSharedPreferencesDbUpgradeStep>> f986e;

    @VisibleForTesting
    private static int m1999a() {
        return 2;
    }

    @Inject
    public FbSharedPreferencesDbStorage(SharedPrefsDatabaseSupplier sharedPrefsDatabaseSupplier, Lazy<FbErrorReporter> lazy, Random random, Provider<Set<FbSharedPreferencesDbUpgradeStep>> provider) {
        this.f983b = sharedPrefsDatabaseSupplier;
        this.f984c = lazy;
        this.f985d = random;
        this.f986e = provider;
    }

    public final void mo315a(Map<PrefKey, Object> map) {
        Throwable th;
        Cursor query;
        try {
            TracerDetour.a("FbSharedPreferencesDbStorage.queryDb", 1308435304);
            try {
                int a = this.f983b.mo2480a();
                query = a.query("preferences", PreferencesTable.f2182a, null, null, null, null, null);
                try {
                    TracerDetour.a(a);
                    if (query == null) {
                        ((AbstractFbErrorReporter) this.f984c.get()).m2350b("FbSharedPreferencesDbStorage_NULL_CURSOR", "Null cursor.");
                        if (query != null) {
                            query.close();
                            return;
                        }
                        return;
                    }
                    a = "FbSharedPreferencesDbStorage.loadPrefsFromCursor";
                    TracerDetour.a(a, 778774600);
                    try {
                        FbSharedPreferencesContract.m4331a(query, map);
                        TracerDetour.a(a);
                        if (query != null) {
                            query.close();
                        }
                        m2003b(map);
                    } finally {
                        TracerDetour.a(-2061098704);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            } finally {
                int i = -300063959;
                TracerDetour.a(-300063959);
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

    @VisibleForTesting
    private void m2003b(Map<PrefKey, Object> map) {
        if (!map.isEmpty()) {
            Object obj = map.get(f982a);
            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
            int i = 2;
            if (intValue != i) {
                Integer.valueOf(intValue);
                Integer.valueOf(i);
                Multimap u = HashMultimap.m10690u();
                for (Object obj2 : (Set) this.f986e.get()) {
                    u.mo431a(Integer.valueOf(obj2.d), obj2);
                }
                Multimap multimap = u;
                for (int i2 = intValue; i2 < i; i2++) {
                    for (RemoveGatekeepersFbSharedPrefsUpgradeStep a : multimap.mo427c(Integer.valueOf(i2))) {
                        a.a(map, this);
                    }
                }
                Map hashMap = new HashMap();
                hashMap.put(f982a, Integer.valueOf(2));
                map.putAll(hashMap);
                mo316a(hashMap, Collections.emptySet());
            }
        }
    }

    public final void mo316a(Map<PrefKey, Object> map, Collection<PrefKey> collection) {
        if (!map.isEmpty() || !collection.isEmpty()) {
            Throwable th;
            Object obj = this.f985d.nextInt(1000) <= 0 ? 1 : null;
            SQLiteDatabase a = this.f983b.mo2480a();
            int i = 0;
            Object obj2 = null;
            Throwable th2 = null;
            while (i < 10) {
                TracerDetour.a("FbSharedPreferencesDbStorage.writePrefChangesAttempt", 439325917);
                SQLiteDetour.a(a, 1687205420);
                if (obj2 == null) {
                    try {
                        m2002a(a, (Map) map);
                        int i2 = 1;
                    } catch (SQLiteException e) {
                        th2 = e;
                        if (obj != null) {
                            m2000a(i, "FbSharedPreferencesDbStorage_PROVIDER_SQLITE_EXCEPTION", "Writing preferences failed.", th2);
                        }
                        m2004c();
                        SQLiteDetour.b(a, 567338283);
                        TracerDetour.a(113090650);
                        i++;
                    } catch (Throwable th3) {
                        SQLiteDetour.b(a, 945893798);
                        TracerDetour.a(985517572);
                    }
                }
                m2001a(a, (Collection) collection);
                a.setTransactionSuccessful();
                SQLiteDetour.b(a, 1227064222);
                TracerDetour.a(-2110871216);
                th = null;
            }
            th = th2;
            if (th != null) {
                throw Throwables.propagate(th);
            }
        }
    }

    private static void m2002a(SQLiteDatabase sQLiteDatabase, Map<PrefKey, Object> map) {
        if (!map.isEmpty()) {
            ContentValues contentValues = new ContentValues();
            for (Entry entry : map.entrySet()) {
                FbSharedPreferencesContract.m4330a(contentValues, (PrefKey) entry.getKey(), entry.getValue());
                SQLiteDetour.a(-1750399044);
                sQLiteDatabase.replaceOrThrow("preferences", null, contentValues);
                SQLiteDetour.a(1351350244);
            }
        }
    }

    private static void m2001a(SQLiteDatabase sQLiteDatabase, Collection<PrefKey> collection) {
        if (!collection.isEmpty()) {
            String[] strArr = new String[1];
            for (PrefKey a : collection) {
                strArr[0] = a.m2012a();
                sQLiteDatabase.delete("preferences", "key = ?", strArr);
            }
        }
    }

    private void m2000a(int i, String str, String str2, Throwable th) {
        SoftErrorBuilder a = SoftError.a(str, StringFormatUtil.formatStrLocaleSafe("Attempt #%d. %s.", Integer.valueOf(i), str2));
        a.e = 1;
        a = a;
        a.c = th;
        ((AbstractFbErrorReporter) this.f984c.get()).mo336a(a.g());
    }

    private static void m2004c() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
