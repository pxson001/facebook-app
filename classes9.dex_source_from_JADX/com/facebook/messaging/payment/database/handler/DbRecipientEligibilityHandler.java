package com.facebook.messaging.payment.database.handler;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.TriState;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.database.PaymentsDatabaseSupplier;
import com.facebook.messaging.payment.database.PaymentsDbSchemaPart.RecipientEligibilityTable;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: inline_reply_fragment */
public class DbRecipientEligibilityHandler {
    private static volatile DbRecipientEligibilityHandler f12992c;
    private final AbstractFbErrorReporter f12993a;
    private final PaymentsDatabaseSupplier f12994b;

    public static com.facebook.messaging.payment.database.handler.DbRecipientEligibilityHandler m13280a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12992c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.payment.database.handler.DbRecipientEligibilityHandler.class;
        monitor-enter(r1);
        r0 = f12992c;	 Catch:{ all -> 0x003a }
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
        r0 = m13281b(r0);	 Catch:{ all -> 0x0035 }
        f12992c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12992c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.database.handler.DbRecipientEligibilityHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.database.handler.DbRecipientEligibilityHandler");
    }

    private static DbRecipientEligibilityHandler m13281b(InjectorLike injectorLike) {
        return new DbRecipientEligibilityHandler((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PaymentsDatabaseSupplier.m13210a(injectorLike));
    }

    @Inject
    public DbRecipientEligibilityHandler(AbstractFbErrorReporter abstractFbErrorReporter, PaymentsDatabaseSupplier paymentsDatabaseSupplier) {
        this.f12993a = abstractFbErrorReporter;
        this.f12994b = paymentsDatabaseSupplier;
    }

    public final TriState m13282a(String str) {
        TracerDetour.a("getRecipientEligibility", 1015639141);
        try {
            Cursor query = this.f12994b.a().query("recipient_eligibility", new String[]{RecipientEligibilityTable.f12888b.a()}, RecipientEligibilityTable.f12887a.a() + "=" + str, null, null, null, null);
            try {
                TriState triState;
                if (query.getCount() > 1) {
                    this.f12993a.b("DbRecipientEligibilityHandler", "RecipientEligibilityTable table should only have one row for a given recipient IDbut it has " + query.getCount());
                    triState = TriState.UNSET;
                    return triState;
                }
                if (query.getCount() == 0) {
                    triState = TriState.UNSET;
                    query.close();
                    TracerDetour.a(-637433307);
                } else {
                    query.moveToFirst();
                    triState = TriState.valueOf(Boolean.valueOf(RecipientEligibilityTable.f12888b.b(query)).booleanValue());
                    query.close();
                    TracerDetour.a(-1154355755);
                }
                return triState;
            } finally {
                query.close();
            }
        } finally {
            TracerDetour.a(-1645278009);
        }
    }

    public final void m13283a(String str, boolean z) {
        TracerDetour.a("setRecipientEligibility", -1699823669);
        try {
            SQLiteDatabase a = this.f12994b.a();
            SQLiteDetour.a(a, -1413216756);
            int contentValues;
            try {
                contentValues = new ContentValues();
                contentValues.put(RecipientEligibilityTable.f12887a.a(), str);
                contentValues.put(RecipientEligibilityTable.f12888b.a(), String.valueOf(z));
                if (a.update("recipient_eligibility", contentValues, RecipientEligibilityTable.f12887a.a() + " = ? ", new String[]{str}) == 0) {
                    String str2 = "recipient_eligibility";
                }
                a.setTransactionSuccessful();
                SQLiteDetour.b(a, -1496900197);
            } catch (SQLException e) {
                contentValues = e;
                this.f12993a.b("DbRecipientEligibilityHandler", "A SQLException occurred when trying to insert into the database", contentValues);
                SQLiteDetour.b(a, contentValues);
                TracerDetour.a(406332184);
            } finally {
                SQLiteDetour.b(a, 2054496768);
            }
            TracerDetour.a(406332184);
        } catch (Throwable th) {
            TracerDetour.a(1226557915);
        }
    }
}
