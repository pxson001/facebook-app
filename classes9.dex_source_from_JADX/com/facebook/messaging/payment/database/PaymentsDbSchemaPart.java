package com.facebook.messaging.payment.database;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlKeys.ForeignKey;
import com.facebook.database.sqlite.SqlKeys.PrimaryKey;
import com.facebook.database.sqlite.SqlKeys.SqlKey;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: insertOrUpdateTransactionInRecentTables */
public class PaymentsDbSchemaPart extends TablesDbSchemaPart {
    private static final Class<?> f12927a = PaymentsDbSchemaPart.class;
    public static final ImmutableList<SqlTable> f12928b = ImmutableList.of(new TransactionsTable(), new RequestsTable(), new RecentAllTransactionsTable(), new RecentIncomingTransactionsTable(), new RecentOutgoingTransactionsTable(), new IncomingRequestIdsTable(), new TransactionPaymentCardIdTable(), new PaymentCardIdsTable(), new PrimaryPaymentCardIdTable(), new RecipientEligibilityTable(), new PropertiesTable());
    private static volatile PaymentsDbSchemaPart f12929c;

    /* compiled from: insertOrUpdateTransactionInRecentTables */
    public final class IncomingRequestIdsTable extends SqlTable {
        public static final SqlColumn f12859a = new SqlColumn("request_id", "INTEGER");
        private static final SqlKey f12860b = new PrimaryKey(ImmutableList.of(f12859a));
        private static final ImmutableList<SqlColumn> f12861c = ImmutableList.of(f12859a);

        public IncomingRequestIdsTable() {
            super("incoming_request_ids", f12861c, f12860b);
        }
    }

    /* compiled from: insertOrUpdateTransactionInRecentTables */
    public final class PaymentCardIdsTable extends SqlTable {
        public static final SqlColumn f12862a = new SqlColumn("credential_id", "INTEGER");
        private static final SqlKey f12863b = new PrimaryKey(ImmutableList.of(f12862a));
        private static final ImmutableList<SqlColumn> f12864c = ImmutableList.of(f12862a);

        public PaymentCardIdsTable() {
            super("payment_card_ids", f12864c, f12863b);
        }
    }

    /* compiled from: insertOrUpdateTransactionInRecentTables */
    public final class PrimaryPaymentCardIdTable extends SqlTable {
        public static final SqlColumn f12865a = new SqlColumn("credential_id", "INTEGER");
        private static final SqlKey f12866b = new ForeignKey(ImmutableList.of(f12865a), "payment_card_ids", ImmutableList.of(PaymentCardIdsTable.f12862a));
        private static final ImmutableList<SqlColumn> f12867c = ImmutableList.of(f12865a);

        public PrimaryPaymentCardIdTable() {
            super("primary_payment_card_id", f12867c, f12866b);
        }
    }

    /* compiled from: insertOrUpdateTransactionInRecentTables */
    public final class PropertiesTable extends SqlTable {
        public static final SqlColumn f12868a = new SqlColumn("key", "TEXT");
        public static final SqlColumn f12869b = new SqlColumn("value", "TEXT");
        private static final SqlKey f12870c = new PrimaryKey(ImmutableList.of(f12868a));
        private static final ImmutableList<SqlColumn> f12871d = ImmutableList.of(f12868a, f12869b);

        public PropertiesTable() {
            super("properties", f12871d, f12870c);
        }
    }

    /* compiled from: insertOrUpdateTransactionInRecentTables */
    public final class RecentAllTransactionsTable extends SqlTable {
        public static final SqlColumn f12872a = new SqlColumn("creation_time", "INTEGER");
        public static final SqlColumn f12873b = new SqlColumn("transaction_id", "INTEGER");
        private static final SqlKey f12874c = new PrimaryKey(ImmutableList.of(f12873b));
        private static final ImmutableList<SqlColumn> f12875d = ImmutableList.of(f12872a, f12873b);
        private static final String f12876e = SqlTable.b("recent_all_transactions", "all_transactions_creation_time_index", ImmutableList.of(f12872a.e()));

        public RecentAllTransactionsTable() {
            super("recent_all_transactions", f12875d, f12874c);
        }

        public final void m13213a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String str = f12876e;
            SQLiteDetour.a(-1002035168);
            sQLiteDatabase.execSQL(str);
            SQLiteDetour.a(-757187736);
        }
    }

    /* compiled from: insertOrUpdateTransactionInRecentTables */
    public final class RecentIncomingTransactionsTable extends SqlTable {
        public static final SqlColumn f12877a = new SqlColumn("creation_time", "INTEGER");
        public static final SqlColumn f12878b = new SqlColumn("transaction_id", "INTEGER");
        private static final SqlKey f12879c = new PrimaryKey(ImmutableList.of(f12878b));
        private static final ImmutableList<SqlColumn> f12880d = ImmutableList.of(f12877a, f12878b);
        private static final String f12881e = SqlTable.b("recent_incoming_transactions", "incoming_transactions_creation_time_index", ImmutableList.of(f12877a.e()));

        public RecentIncomingTransactionsTable() {
            super("recent_incoming_transactions", f12880d, f12879c);
        }

        public final void m13214a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String str = f12881e;
            SQLiteDetour.a(1185491756);
            sQLiteDatabase.execSQL(str);
            SQLiteDetour.a(-138423375);
        }
    }

    /* compiled from: insertOrUpdateTransactionInRecentTables */
    public final class RecentOutgoingTransactionsTable extends SqlTable {
        public static final SqlColumn f12882a = new SqlColumn("creation_time", "INTEGER");
        public static final SqlColumn f12883b = new SqlColumn("transaction_id", "INTEGER");
        private static final SqlKey f12884c = new PrimaryKey(ImmutableList.of(f12883b));
        private static final ImmutableList<SqlColumn> f12885d = ImmutableList.of(f12882a, f12883b);
        private static final String f12886e = SqlTable.b("recent_outgoing_transactions", "outgoing_transactions_creation_time_index", ImmutableList.of(f12882a.e()));

        public RecentOutgoingTransactionsTable() {
            super("recent_outgoing_transactions", f12885d, f12884c);
        }

        public final void m13215a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String str = f12886e;
            SQLiteDetour.a(-79855414);
            sQLiteDatabase.execSQL(str);
            SQLiteDetour.a(-764584261);
        }
    }

    /* compiled from: insertOrUpdateTransactionInRecentTables */
    public final class RecipientEligibilityTable extends SqlTable {
        public static final SqlColumn f12887a = new SqlColumn("recipient_id", "TEXT");
        public static final SqlColumn f12888b = new SqlColumn("is_eligible", "TEXT");
        private static final SqlKey f12889c = new PrimaryKey(ImmutableList.of(f12887a));
        private static final ImmutableList<SqlColumn> f12890d = ImmutableList.of(f12887a, f12888b);

        public RecipientEligibilityTable() {
            super("recipient_eligibility", f12890d, f12889c);
        }
    }

    /* compiled from: insertOrUpdateTransactionInRecentTables */
    public final class RequestsTable extends SqlTable {
        public static final SqlColumn f12891a = new SqlColumn("request_id", "INTEGER");
        public static final SqlColumn f12892b = new SqlColumn("requester_id", "INTEGER");
        public static final SqlColumn f12893c = new SqlColumn("requestee_id", "INTEGER");
        public static final SqlColumn f12894d = new SqlColumn("request_status", "TEXT");
        public static final SqlColumn f12895e = new SqlColumn("creation_time", "TEXT");
        public static final SqlColumn f12896f = new SqlColumn("updated_time", "TEXT");
        public static final SqlColumn f12897g = new SqlColumn("raw_amount", "INTEGER");
        public static final SqlColumn f12898h = new SqlColumn("amount_offset", "INTEGER");
        public static final SqlColumn f12899i = new SqlColumn("currency", "TEXT");
        public static final SqlColumn f12900j = new SqlColumn("memo_text", "TEXT");
        public static final SqlColumn f12901k = new SqlColumn("theme", "THEME");
        public static final SqlColumn f12902l = new SqlColumn("group_thread_id", "INTEGER");
        public static final SqlColumn f12903m = new SqlColumn("transaction_id", "INTEGER");
        private static final SqlKey f12904n = new PrimaryKey(ImmutableList.of(f12891a));
        private static final ImmutableList<SqlColumn> f12905o = ImmutableList.of(f12891a, f12892b, f12893c, f12894d, f12895e, f12896f, f12897g, f12898h, f12899i, f12900j, f12901k, f12902l, new SqlColumn[]{f12903m});

        public RequestsTable() {
            super("requests", f12905o, f12904n);
        }
    }

    /* compiled from: insertOrUpdateTransactionInRecentTables */
    public final class TransactionPaymentCardIdTable extends SqlTable {
        public static final SqlColumn f12906a = new SqlColumn("transaction_id", "INTEGER");
        public static final SqlColumn f12907b = new SqlColumn("credential_id", "INTEGER");
        private static final SqlKey f12908c = new PrimaryKey(ImmutableList.of(f12906a));
        private static final ImmutableList<SqlColumn> f12909d = ImmutableList.of(f12906a, f12907b);

        public TransactionPaymentCardIdTable() {
            super("transaction_payment_card_id", f12909d, f12908c);
        }
    }

    /* compiled from: insertOrUpdateTransactionInRecentTables */
    public final class TransactionsTable extends SqlTable {
        public static final SqlColumn f12910a = new SqlColumn("transaction_id", "INTEGER");
        public static final SqlColumn f12911b = new SqlColumn("sender_id", "INTEGER");
        public static final SqlColumn f12912c = new SqlColumn("receiver_id", "INTEGER");
        public static final SqlColumn f12913d = new SqlColumn("transfer_status", "TEXT");
        public static final SqlColumn f12914e = new SqlColumn("creation_time", "TEXT");
        public static final SqlColumn f12915f = new SqlColumn("updated_time", "TEXT");
        public static final SqlColumn f12916g = new SqlColumn("completed_time", "TEXT");
        public static final SqlColumn f12917h = new SqlColumn("raw_amount", "INTEGER");
        public static final SqlColumn f12918i = new SqlColumn("amount_offset", "INTEGER");
        public static final SqlColumn f12919j = new SqlColumn("currency", "TEXT");
        public static final SqlColumn f12920k = new SqlColumn("raw_amount_fb_discount", "INTEGER");
        public static final SqlColumn f12921l = new SqlColumn("memo_text", "TEXT");
        public static final SqlColumn f12922m = new SqlColumn("theme", "THEME");
        public static final SqlColumn f12923n = new SqlColumn("platform_item", "TEXT");
        public static final SqlColumn f12924o = new SqlColumn("commerce_order", "TEXT");
        private static final SqlKey f12925p = new PrimaryKey(ImmutableList.of(f12910a));
        private static final ImmutableList<SqlColumn> f12926q = ImmutableList.of(f12910a, f12911b, f12912c, f12913d, f12914e, f12915f, f12916g, f12917h, f12918i, f12919j, f12920k, f12921l, new SqlColumn[]{f12922m, f12923n, f12924o});

        public TransactionsTable() {
            super("transactions", f12926q, f12925p);
        }
    }

    public static com.facebook.messaging.payment.database.PaymentsDbSchemaPart m13216a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12929c;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messaging.payment.database.PaymentsDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f12929c;	 Catch:{ all -> 0x0039 }
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
        r0 = m13217d();	 Catch:{ all -> 0x0034 }
        f12929c = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f12929c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.database.PaymentsDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.database.PaymentsDbSchemaPart");
    }

    private static PaymentsDbSchemaPart m13217d() {
        return new PaymentsDbSchemaPart();
    }

    @Inject
    public PaymentsDbSchemaPart() {
        super("payments", 25, f12928b);
    }

    public final void m13218a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Integer.valueOf(i);
        Integer.valueOf(i2);
        int size = f12928b.size();
        for (int i3 = 0; i3 < size; i3++) {
            String a = SqlTable.a(((SqlTable) f12928b.get(i3)).a);
            SQLiteDetour.a(48826042);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(-1790774868);
        }
        a(sQLiteDatabase);
    }

    public final void m13219b(SQLiteDatabase sQLiteDatabase) {
    }
}
