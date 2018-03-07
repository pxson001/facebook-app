package com.facebook.messaging.payment.database.handler;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.util.ContactFetchUtil;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.database.DbPaymentPropertyKey;
import com.facebook.messaging.payment.database.DbPaymentsProperties;
import com.facebook.messaging.payment.database.PaymentsDbSchemaPart.RecentAllTransactionsTable;
import com.facebook.messaging.payment.database.PaymentsDbSchemaPart.RecentIncomingTransactionsTable;
import com.facebook.messaging.payment.database.PaymentsDbSchemaPart.RecentOutgoingTransactionsTable;
import com.facebook.messaging.payment.model.PaymentTransactionQueryType;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentUserModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentUserModel.Builder;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: input_custom_budget */
public class DbPaymentsUtil {
    private static final String f12987a = DbPaymentsUtil.class.getSimpleName();
    private static volatile DbPaymentsUtil f12988e;
    private final ContactFetchUtil f12989b;
    private final AbstractFbErrorReporter f12990c;
    private final Map<String, Contact> f12991d = new HashMap();

    /* compiled from: input_custom_budget */
    public class TransactionsTableResult {
        public final String f12983a;
        public final String f12984b;
        public final String f12985c;
        public final DbPaymentPropertyKey f12986d;

        public TransactionsTableResult(String str, String str2, String str3, DbPaymentPropertyKey dbPaymentPropertyKey) {
            this.f12983a = str;
            this.f12984b = str2;
            this.f12985c = str3;
            this.f12986d = dbPaymentPropertyKey;
        }
    }

    public static com.facebook.messaging.payment.database.handler.DbPaymentsUtil m13275a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f12988e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.payment.database.handler.DbPaymentsUtil.class;
        monitor-enter(r1);
        r0 = f12988e;	 Catch:{ all -> 0x003a }
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
        r0 = m13276b(r0);	 Catch:{ all -> 0x0035 }
        f12988e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12988e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.database.handler.DbPaymentsUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.database.handler.DbPaymentsUtil");
    }

    private static DbPaymentsUtil m13276b(InjectorLike injectorLike) {
        return new DbPaymentsUtil(ContactFetchUtil.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public DbPaymentsUtil(ContactFetchUtil contactFetchUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f12989b = contactFetchUtil;
        this.f12990c = abstractFbErrorReporter;
    }

    public static TransactionsTableResult m13274a(PaymentTransactionQueryType paymentTransactionQueryType) {
        String str;
        String str2;
        String str3;
        DbPaymentPropertyKey dbPaymentPropertyKey;
        switch (paymentTransactionQueryType) {
            case ALL:
                str = "recent_all_transactions";
                str2 = RecentAllTransactionsTable.f12873b.d;
                str3 = RecentAllTransactionsTable.f12872a.d;
                dbPaymentPropertyKey = DbPaymentsProperties.f12845a;
                break;
            case INCOMING:
                str = "recent_incoming_transactions";
                str2 = RecentIncomingTransactionsTable.f12878b.d;
                str3 = RecentIncomingTransactionsTable.f12877a.d;
                dbPaymentPropertyKey = DbPaymentsProperties.f12846b;
                break;
            case OUTGOING:
                str = "recent_outgoing_transactions";
                str2 = RecentOutgoingTransactionsTable.f12883b.d;
                str3 = RecentOutgoingTransactionsTable.f12882a.d;
                dbPaymentPropertyKey = DbPaymentsProperties.f12847c;
                break;
            default:
                throw new IllegalStateException("Unknown transaction query type encountered");
        }
        return new TransactionsTableResult(str, str2, str3, dbPaymentPropertyKey);
    }

    @Nullable
    public final PaymentUserModel m13277a(String str) {
        Contact b = m13279b(str);
        if (b == null) {
            return null;
        }
        Builder builder = new Builder();
        builder.f13426b = str;
        builder = builder;
        builder.f13427c = b.s();
        builder = builder;
        builder.f13428d = b.e().i();
        return builder.m13868a();
    }

    @Nullable
    public final Contact m13279b(String str) {
        if (this.f12991d.containsKey(str)) {
            return (Contact) this.f12991d.get(str);
        }
        m13278a(ImmutableList.of(str));
        return (Contact) this.f12991d.get(str);
    }

    public final void m13278a(ImmutableList<String> immutableList) {
        int i;
        ImmutableSet.Builder builder = new ImmutableSet.Builder();
        int size = immutableList.size();
        for (i = 0; i < size; i++) {
            builder.c(UserKey.b((String) immutableList.get(i)));
        }
        try {
            ImmutableList immutableList2 = (ImmutableList) FutureDetour.a(this.f12989b.a(builder.b(), DataFreshnessParam.STALE_DATA_OKAY), 10, TimeUnit.SECONDS, 1887848819);
            int size2 = immutableList2.size();
            for (i = 0; i < size2; i++) {
                Contact contact = (Contact) immutableList2.get(i);
                this.f12991d.put(contact.c(), contact);
            }
        } catch (Throwable e) {
            this.f12990c.a(f12987a, "InterruptedException raised while waiting for contact fetching futures to return.", e);
        } catch (Throwable e2) {
            this.f12990c.a(f12987a, "ExecutionException raised while waiting for contact fetching futures to return.", e2);
        } catch (Throwable e22) {
            this.f12990c.a(f12987a, "TimeoutException raised while waiting for contact fetching futures to return.", e22);
        }
    }
}
