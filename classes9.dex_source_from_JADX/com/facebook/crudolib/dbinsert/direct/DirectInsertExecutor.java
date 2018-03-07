package com.facebook.crudolib.dbinsert.direct;

import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteProgram;
import android.support.v4.util.SimpleArrayMap;
import com.facebook.crudolib.db.DbHelper;
import com.facebook.crudolib.db.InsertOrReplaceStatements;
import com.facebook.crudolib.dbinsert.FluentInsert;
import com.facebook.crudolib.dbinsert.InsertProvider;
import com.facebook.crudolib.dbquery.loader.inprocess.NoContentResolver;
import com.facebook.crudolib.mutableprimitive.MutableInt;
import com.facebook.saved2.model.Saved2DatabaseProvider;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;

/* compiled from: TreehouseRNPreComment */
public class DirectInsertExecutor {
    public static final ThreadLocal<AllTransactionState> f24001c = new C29081();
    public final Saved2DatabaseProvider f24002a;
    @GuardedBy("this")
    private final SimpleArrayMap<String, InsertOrReplaceStatements> f24003b = new SimpleArrayMap(4);

    /* compiled from: TreehouseRNPreComment */
    final class C29081 extends ThreadLocal<AllTransactionState> {
        C29081() {
        }

        protected final Object initialValue() {
            return new AllTransactionState();
        }
    }

    @NotThreadSafe
    /* compiled from: TreehouseRNPreComment */
    class AllTransactionState {
        private final WeakHashMap<SQLiteDatabase, PerDbTransactionState> f23997a = new WeakHashMap(4);

        public final PerDbTransactionState m25944a(SQLiteDatabase sQLiteDatabase) {
            PerDbTransactionState perDbTransactionState = (PerDbTransactionState) this.f23997a.get(sQLiteDatabase);
            if (perDbTransactionState != null) {
                return perDbTransactionState;
            }
            perDbTransactionState = new PerDbTransactionState();
            this.f23997a.put(sQLiteDatabase, perDbTransactionState);
            return perDbTransactionState;
        }
    }

    /* compiled from: TreehouseRNPreComment */
    public class NotifyChangeTransactionListener {
        public final InsertProvider f23998a;

        public NotifyChangeTransactionListener(InsertProvider insertProvider) {
            this.f23998a = insertProvider;
        }
    }

    @NotThreadSafe
    /* compiled from: TreehouseRNPreComment */
    public class PerDbTransactionState {
        public final ArrayList<TransactionListener> f23999a = new ArrayList(4);
        public int f24000b;

        public final int m25945a(int i) {
            if (this.f24000b <= 0) {
                throw new IllegalStateException("depth=" + this.f24000b);
            }
            if (this.f24000b == 1) {
                int size = this.f23999a.size();
                for (int i2 = 0; i2 < size; i2++) {
                    NotifyChangeTransactionListener notifyChangeTransactionListener = (NotifyChangeTransactionListener) this.f23999a.get(i2);
                    if (i > 0) {
                        NoContentResolver.a.a(notifyChangeTransactionListener.f23998a.a());
                    }
                }
                this.f23999a.clear();
            }
            int i3 = this.f24000b - 1;
            this.f24000b = i3;
            return i3;
        }
    }

    public DirectInsertExecutor(Saved2DatabaseProvider saved2DatabaseProvider) {
        this.f24002a = saved2DatabaseProvider;
    }

    private synchronized InsertOrReplaceStatements m25946a(String str, String[] strArr, String[] strArr2) {
        InsertOrReplaceStatements insertOrReplaceStatements;
        insertOrReplaceStatements = (InsertOrReplaceStatements) this.f24003b.get(str);
        if (insertOrReplaceStatements == null) {
            insertOrReplaceStatements = new InsertOrReplaceStatements(str, strArr, strArr2);
            this.f24003b.put(str, insertOrReplaceStatements);
        }
        return insertOrReplaceStatements;
    }

    public final C29102 m25949a(InsertProvider insertProvider) {
        Object[] b = insertProvider.b();
        if (((Integer) b[2]).intValue() != 5) {
            throw new UnsupportedOperationException();
        }
        String[] strArr = (String[]) b[3];
        final String[] strArr2 = (String[]) b[1];
        final int[] iArr = (int[]) b[4];
        final InsertOrReplaceStatements a = m25946a((String) b[0], strArr, strArr2);
        final String[] strArr3 = new String[strArr.length];
        final SQLiteDatabase a2 = this.f24002a.a();
        SQLiteDetour.a(a2, 1789800008);
        PerDbTransactionState a3 = ((AllTransactionState) f24001c.get()).m25944a(a2);
        a3.f23999a.add(new NotifyChangeTransactionListener(insertProvider));
        a3.f24000b++;
        final ArrayList arrayList = new ArrayList(32);
        final MutableInt mutableInt = new MutableInt(0);
        final MutableInt mutableInt2 = new MutableInt(0);
        return new Object(this) {
            final /* synthetic */ DirectInsertExecutor f23996i;

            public final FluentInsert m25942a() {
                MutableInt mutableInt = mutableInt;
                mutableInt.a++;
                final Object[] objArr = new Object[strArr2.length];
                return new FluentInsert(this) {
                    final /* synthetic */ C29102 f23987b;

                    public final FluentInsert m25940a(int i, String str) {
                        objArr[i] = str;
                        return this;
                    }

                    public final FluentInsert m25936a(int i, Boolean bool) {
                        objArr[i] = bool;
                        return this;
                    }

                    public final FluentInsert m25938a(int i, Integer num) {
                        objArr[i] = num;
                        return this;
                    }

                    public final FluentInsert m25939a(int i, Long l) {
                        objArr[i] = l;
                        return this;
                    }

                    public final FluentInsert m25937a(int i, Double d) {
                        objArr[i] = d;
                        return this;
                    }

                    public final FluentInsert m25935a(int i) {
                        objArr[i] = null;
                        return this;
                    }

                    public final void m25941a() {
                        SQLiteProgram a;
                        SQLiteDatabase a2 = this.f23987b.f23996i.f24002a.a();
                        long b = DirectInsertExecutor.m25947b(a, a2, DirectInsertExecutor.m25948b(strArr3, objArr, iArr), -1);
                        if (b == -1) {
                            a = a.m25932a(a2);
                        } else {
                            a = a.m25934b(a2);
                            a.bindLong(strArr2.length + 1, b);
                        }
                        int length = objArr.length;
                        for (int i = 0; i < length; i++) {
                            DatabaseUtils.bindObjectToProgram(a, i + 1, objArr[i]);
                        }
                        if (b == -1) {
                            try {
                                SQLiteDetour.a(809370132);
                                b = a.executeInsert();
                                SQLiteDetour.a(-428495746);
                            } catch (Throwable th) {
                                a.clearBindings();
                            }
                        } else {
                            SQLiteDetour.a(-1628252656);
                            a.execute();
                            SQLiteDetour.a(-347872775);
                        }
                        MutableInt mutableInt = mutableInt2;
                        mutableInt.a++;
                        arrayList.add(Long.valueOf(b));
                        a.clearBindings();
                    }
                };
            }

            @Nullable
            public final long[] m25943b() {
                int i;
                Object obj = mutableInt.a == mutableInt2.a ? 1 : null;
                if (obj != null) {
                    a2.setTransactionSuccessful();
                }
                SQLiteDetour.b(a2, -2006711806);
                PerDbTransactionState a = ((AllTransactionState) DirectInsertExecutor.f24001c.get()).m25944a(a2);
                if (obj != null) {
                    i = mutableInt2.a;
                } else {
                    i = 0;
                }
                a.m25945a(i);
                if (obj == null) {
                    return null;
                }
                List list = arrayList;
                int size = list.size();
                long[] jArr = new long[size];
                for (int i2 = 0; i2 < size; i2++) {
                    jArr[i2] = ((Long) list.get(i2)).longValue();
                }
                return jArr;
            }
        };
    }

    public static <T> String[] m25948b(String[] strArr, T[] tArr, int[] iArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            Object obj = tArr[iArr[i]];
            strArr[i] = obj != null ? obj.toString() : null;
        }
        return strArr;
    }

    public static long m25947b(InsertOrReplaceStatements insertOrReplaceStatements, SQLiteDatabase sQLiteDatabase, String[] strArr, long j) {
        String a = insertOrReplaceStatements.m25933a(sQLiteDatabase, strArr);
        ArrayList arrayList = new ArrayList(strArr.length);
        for (Object obj : strArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return DbHelper.m25928a(sQLiteDatabase.rawQuery(a, (String[]) arrayList.toArray(new String[arrayList.size()])), j);
    }
}
