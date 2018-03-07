package com.facebook.messaging.sms.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.clockskew.EstimatedServerClock;
import com.facebook.messaging.sms.database.SmsTakeoverDbSchemaPart.ThreadReadStateTable;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: commerce_id */
public class ReadonlyModeMarkThreadDbHandler {
    private static volatile ReadonlyModeMarkThreadDbHandler f17522c;
    private final SmsTakeoverDatabaseSupplier f17523a;
    private final EstimatedServerClock f17524b;

    public static com.facebook.messaging.sms.database.ReadonlyModeMarkThreadDbHandler m17504a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f17522c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.sms.database.ReadonlyModeMarkThreadDbHandler.class;
        monitor-enter(r1);
        r0 = f17522c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m17505b(r0);	 Catch:{ all -> 0x0035 }
        f17522c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17522c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.database.ReadonlyModeMarkThreadDbHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sms.database.ReadonlyModeMarkThreadDbHandler");
    }

    private static ReadonlyModeMarkThreadDbHandler m17505b(InjectorLike injectorLike) {
        return new ReadonlyModeMarkThreadDbHandler(SmsTakeoverDatabaseSupplier.m17509a(injectorLike), EstimatedServerClock.a(injectorLike));
    }

    @Inject
    public ReadonlyModeMarkThreadDbHandler(SmsTakeoverDatabaseSupplier smsTakeoverDatabaseSupplier, EstimatedServerClock estimatedServerClock) {
        this.f17523a = smsTakeoverDatabaseSupplier;
        this.f17524b = estimatedServerClock;
    }

    public final void m17507a(Collection<Long> collection) {
        SQLiteDatabase a = this.f17523a.a();
        SQLiteDetour.a(a, 201995248);
        try {
            long a2 = this.f17524b.a();
            for (Long longValue : collection) {
                m17506b(longValue.longValue(), a2, 1);
            }
            a.setTransactionSuccessful();
        } catch (Throwable e) {
            BLog.b("ReadonlyModeMarkThreadDbHandler", e, "Error mark threads [read] in readonly mode", new Object[0]);
        } finally {
            SQLiteDetour.b(a, -527300343);
        }
    }

    private void m17506b(long j, long j2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ThreadReadStateTable.f17526a.d, Long.valueOf(j));
        contentValues.put(ThreadReadStateTable.f17527b.d, Integer.valueOf(i));
        contentValues.put(ThreadReadStateTable.f17528c.d, Long.valueOf(j2));
        SQLiteDetour.a(593826264);
        this.f17523a.a().replace("thread_read_stat", null, contentValues);
        SQLiteDetour.a(67416846);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m17508a(long r14, long r16, int r18) {
        /*
        r13 = this;
        r8 = 2;
        r4 = 0;
        r11 = 0;
        r10 = 1;
        r2 = r13.f17524b;
        r0 = r16;
        r2 = r2.a(r0);
        r0 = r18;
        if (r0 != r10) goto L_0x005b;
    L_0x0010:
        r2 = new com.facebook.database.sqlite.SqlExpression.Expression[r8];
        r3 = com.facebook.messaging.sms.database.SmsTakeoverDbSchemaPart.ThreadReadStateTable.f17526a;
        r3 = r3.a();
        r5 = java.lang.String.valueOf(r14);
        r3 = com.facebook.database.sqlite.SqlExpression.a(r3, r5);
        r2[r11] = r3;
        r3 = com.facebook.messaging.sms.database.SmsTakeoverDbSchemaPart.ThreadReadStateTable.f17527b;
        r3 = r3.a();
        r5 = "0";
        r3 = com.facebook.database.sqlite.SqlExpression.a(r3, r5);
        r2[r10] = r3;
        r2 = com.facebook.database.sqlite.SqlExpression.a(r2);
        r6 = r2;
    L_0x0035:
        r2 = r13.f17523a;
        r2 = r2.a();
        r3 = "thread_read_stat";
        r5 = r6.a();
        r6 = r6.b();
        r7 = r4;
        r8 = r4;
        r9 = r4;
        r3 = r2.query(r3, r4, r5, r6, r7, r8, r9);
        r2 = r3.moveToNext();	 Catch:{ Exception -> 0x009d }
        if (r2 == 0) goto L_0x0094;
    L_0x0052:
        r0 = r18;
        if (r0 == r10) goto L_0x0092;
    L_0x0056:
        r2 = r10;
    L_0x0057:
        r3.close();
    L_0x005a:
        return r2;
    L_0x005b:
        r5 = 3;
        r5 = new com.facebook.database.sqlite.SqlExpression.Expression[r5];
        r6 = com.facebook.messaging.sms.database.SmsTakeoverDbSchemaPart.ThreadReadStateTable.f17526a;
        r6 = r6.a();
        r7 = java.lang.String.valueOf(r14);
        r6 = com.facebook.database.sqlite.SqlExpression.a(r6, r7);
        r5[r11] = r6;
        r6 = com.facebook.messaging.sms.database.SmsTakeoverDbSchemaPart.ThreadReadStateTable.f17528c;
        r6 = r6.a();
        r2 = java.lang.String.valueOf(r2);
        r2 = com.facebook.database.sqlite.SqlExpression.f(r6, r2);
        r5[r10] = r2;
        r2 = com.facebook.messaging.sms.database.SmsTakeoverDbSchemaPart.ThreadReadStateTable.f17527b;
        r2 = r2.a();
        r3 = "1";
        r2 = com.facebook.database.sqlite.SqlExpression.a(r2, r3);
        r5[r8] = r2;
        r2 = com.facebook.database.sqlite.SqlExpression.a(r5);
        r6 = r2;
        goto L_0x0035;
    L_0x0092:
        r2 = r11;
        goto L_0x0057;
    L_0x0094:
        r3.close();
    L_0x0097:
        r0 = r18;
        if (r0 != r10) goto L_0x00b1;
    L_0x009b:
        r2 = r10;
        goto L_0x005a;
    L_0x009d:
        r2 = move-exception;
        r4 = "ReadonlyModeMarkThreadDbHandler";
        r5 = "Error checking thread state in readonly mode";
        r6 = 0;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x00ac }
        com.facebook.debug.log.BLog.b(r4, r2, r5, r6);	 Catch:{ all -> 0x00ac }
        r3.close();
        goto L_0x0097;
    L_0x00ac:
        r2 = move-exception;
        r3.close();
        throw r2;
    L_0x00b1:
        r2 = r11;
        goto L_0x005a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.database.ReadonlyModeMarkThreadDbHandler.a(long, long, int):boolean");
    }
}
