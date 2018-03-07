package com.facebook.messaging.payment.pin.database;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlKeys.PrimaryKey;
import com.facebook.database.sqlite.SqlKeys.SqlKey;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: has already been used in " */
public class PaymentPinDbSchemaPart extends TablesDbSchemaPart {
    private static final Class<?> f13699a = PaymentPinDbSchemaPart.class;
    public static final ImmutableList<SqlTable> f13700b = ImmutableList.of(new PaymentPinIdTable());
    private static volatile PaymentPinDbSchemaPart f13701c;

    /* compiled from: has already been used in " */
    public final class PaymentPinIdTable extends SqlTable {
        public static final SqlColumn f13696a = new SqlColumn("pin_id", "INTEGER");
        private static final SqlKey f13697b = new PrimaryKey(ImmutableList.of(f13696a));
        private static final ImmutableList<SqlColumn> f13698c = ImmutableList.of(f13696a);

        public PaymentPinIdTable() {
            super("payment_pin_id", f13698c, f13697b);
        }
    }

    public static com.facebook.messaging.payment.pin.database.PaymentPinDbSchemaPart m14257a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f13701c;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messaging.payment.pin.database.PaymentPinDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f13701c;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m14258d();	 Catch:{ all -> 0x0034 }
        f13701c = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f13701c;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.pin.database.PaymentPinDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.pin.database.PaymentPinDbSchemaPart");
    }

    private static PaymentPinDbSchemaPart m14258d() {
        return new PaymentPinDbSchemaPart();
    }

    @Inject
    public PaymentPinDbSchemaPart() {
        super("payment_pin", 1, f13700b);
    }

    public final void m14259a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Integer.valueOf(i);
        Integer.valueOf(i2);
        int size = f13700b.size();
        for (int i3 = 0; i3 < size; i3++) {
            String a = SqlTable.a(((SqlTable) f13700b.get(i3)).a);
            SQLiteDetour.a(-1755814392);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(-1778721114);
        }
        a(sQLiteDatabase);
    }

    public final void m14260b(SQLiteDatabase sQLiteDatabase) {
    }
}
