package com.facebook.contacts.upload;

import android.os.Bundle;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.contacts.iterator.PhoneUserIterators;
import com.facebook.contacts.upload.data.ContactsUploadDbHandler;
import com.facebook.contacts.upload.data.PhoneAddressBookSnapshotEntry;
import com.facebook.contacts.upload.data.PhoneAddressBookSnapshotEntryChange;
import com.facebook.contacts.upload.data.PhoneAddressBookSnapshotEntryChange.ChangeType;
import com.facebook.contacts.upload.graphql.FetchPhonebookHashesGraphQL.FetchPhonebookHashesQueryString;
import com.facebook.contacts.upload.graphql.FetchPhonebookHashesGraphQLModels.FetchPhonebookHashesQueryModel;
import com.facebook.contacts.upload.graphql.FetchPhonebookHashesGraphQLModels.FetchPhonebookHashesQueryModel.AddressbooksModel.EdgesModel;
import com.facebook.contacts.upload.graphql.FetchPhonebookHashesGraphQLModels.FetchPhonebookHashesQueryModel.AddressbooksModel.EdgesModel.NodeModel;
import com.facebook.contacts.upload.graphql.FetchPhonebookHashesGraphQLModels.FetchPhonebookHashesQueryModel.AddressbooksModel.EdgesModel.NodeModel.AddressbookContactsModel.NodesModel;
import com.facebook.contacts.upload.logging.ContactsUploadAnalyticsLogger;
import com.facebook.contacts.upload.logging.ContactsUploadLoggingConstants;
import com.facebook.contacts.upload.logging.ContactsUploadLoggingConstants.Events;
import com.facebook.contacts.upload.prefs.ContactUploadStatusHelper;
import com.facebook.contacts.upload.prefs.ContactsUploadPrefKeys;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.funnellogger.FunnelDefinition;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fb4a_iab_core_feature */
public class ContinuousContactUploadClient {
    public static final CallerContext f12145a = CallerContext.a(ContinuousContactUploadClient.class);
    private static final Class<?> f12146b = ContinuousContactUploadClient.class;
    private final DefaultBlueServiceOperationFactory f12147c;
    private final Clock f12148d;
    public final ContactsUploadAnalyticsLogger f12149e;
    public final ContactsUploadDbHandler f12150f;
    public final ContactUploadStatusHelper f12151g;
    public final Executor f12152h;
    public final FbSharedPreferences f12153i;
    public final GraphQLQueryExecutor f12154j;
    private final PhoneUserIterators f12155k;
    private final Provider<TriState> f12156l;
    private Set<Long> f12157m;
    private int f12158n = 10000;
    public long f12159o;

    private void m12816b(boolean r19) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
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
        r18 = this;
        r0 = r18;
        r2 = r0.f12155k;
        r6 = r2.m12848d();
        if (r6 != 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r0 = r18;	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        r2 = r0.f12153i;	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        r3 = com.facebook.contacts.upload.prefs.ContactsUploadPrefKeys.f10967j;	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        r4 = 1;	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        r8 = r2.a(r3, r4);	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        r4 = 1;	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        r2 = "_id";	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        r7 = r6.getColumnIndex(r2);	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        r2 = "version";	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        r10 = r6.getColumnIndex(r2);	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        r3 = 0;	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
    L_0x0026:
        r2 = r6.moveToNext();	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        if (r2 == 0) goto L_0x005a;	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
    L_0x002c:
        if (r19 == 0) goto L_0x009f;	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
    L_0x002e:
        r0 = r18;	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        r2 = r0.f12156l;	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        r2 = r2.get();	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        r2 = (com.facebook.common.util.TriState) r2;	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        r11 = 0;	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        r2 = r2.asBoolean(r11);	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        if (r2 == 0) goto L_0x009f;	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
    L_0x003f:
        r2 = r3 + 1;	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        r0 = r18;	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        r3 = r0.f12158n;	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        if (r2 > r3) goto L_0x005a;	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
    L_0x0047:
        r12 = r6.getLong(r7);	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        r14 = r6.getLong(r10);	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        r16 = 31;
        r4 = r4 * r16;
        r4 = r4 + r12;
        r12 = 31;
        r4 = r4 * r12;
        r4 = r4 + r14;
        r3 = r2;
        goto L_0x0026;
    L_0x005a:
        r2 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x0064;
    L_0x005e:
        if (r6 == 0) goto L_0x000a;
    L_0x0060:
        r6.close();
        goto L_0x000a;
    L_0x0064:
        r0 = r18;	 Catch:{  }
        r2 = r0.f12153i;	 Catch:{  }
        r2 = r2.edit();	 Catch:{  }
        r3 = com.facebook.contacts.upload.prefs.ContactsUploadPrefKeys.f10966i;	 Catch:{  }
        r0 = r18;	 Catch:{  }
        r7 = r0.f12148d;	 Catch:{  }
        r8 = r7.a();	 Catch:{  }
        r2 = r2.a(r3, r8);	 Catch:{  }
        r3 = com.facebook.contacts.upload.prefs.ContactsUploadPrefKeys.f10967j;	 Catch:{  }
        r2 = r2.a(r3, r4);	 Catch:{  }
        r2.commit();	 Catch:{  }
        if (r6 == 0) goto L_0x000a;
    L_0x0085:
        r6.close();
        goto L_0x000a;
    L_0x0089:
        r2 = move-exception;
        r3 = f12146b;	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        r4 = "Got exception when check contact id and phonebook version";	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        com.facebook.debug.log.BLog.a(r3, r4, r2);	 Catch:{ Exception -> 0x0089, all -> 0x0098 }
        if (r6 == 0) goto L_0x000a;
    L_0x0093:
        r6.close();
        goto L_0x000a;
    L_0x0098:
        r2 = move-exception;
        if (r6 == 0) goto L_0x009e;
    L_0x009b:
        r6.close();
    L_0x009e:
        throw r2;
    L_0x009f:
        r2 = r3;
        goto L_0x0047;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.upload.ContinuousContactUploadClient.b(boolean):void");
    }

    public static ContinuousContactUploadClient m12814b(InjectorLike injectorLike) {
        return new ContinuousContactUploadClient(DefaultBlueServiceOperationFactory.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), ContactsUploadAnalyticsLogger.m12821a(injectorLike), ContactsUploadDbHandler.m12834b(injectorLike), ContactUploadStatusHelper.m11414b(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), PhoneUserIterators.m12840a(injectorLike), IdBasedProvider.a(injectorLike, 660));
    }

    public static ContinuousContactUploadClient m12809a(InjectorLike injectorLike) {
        return m12814b(injectorLike);
    }

    @Inject
    public ContinuousContactUploadClient(BlueServiceOperationFactory blueServiceOperationFactory, Clock clock, ContactsUploadAnalyticsLogger contactsUploadAnalyticsLogger, ContactsUploadDbHandler contactsUploadDbHandler, ContactUploadStatusHelper contactUploadStatusHelper, ExecutorService executorService, FbSharedPreferences fbSharedPreferences, GraphQLQueryExecutor graphQLQueryExecutor, PhoneUserIterators phoneUserIterators, Provider<TriState> provider) {
        this.f12147c = blueServiceOperationFactory;
        this.f12148d = clock;
        this.f12149e = contactsUploadAnalyticsLogger;
        this.f12150f = contactsUploadDbHandler;
        this.f12151g = contactUploadStatusHelper;
        this.f12152h = executorService;
        this.f12153i = fbSharedPreferences;
        this.f12154j = graphQLQueryExecutor;
        this.f12155k = phoneUserIterators;
        this.f12156l = provider;
    }

    public final OperationFuture m12818a(String str, boolean z) {
        ContactsUploadAnalyticsLogger contactsUploadAnalyticsLogger = this.f12149e;
        FunnelDefinition funnelDefinition = FunnelRegistry.r;
        funnelDefinition.d = false;
        funnelDefinition.c = ContactsUploadLoggingConstants.a;
        contactsUploadAnalyticsLogger.f12163b.a(FunnelRegistry.r);
        if ("contacts_upload_friend_finder".equals(str)) {
            this.f12149e.m12825a(ContactsUploadLoggingConstants.b);
        } else {
            this.f12149e.m12825a(ContactsUploadLoggingConstants.c);
        }
        if (z) {
            this.f12149e.m12825a(ContactsUploadLoggingConstants.d);
            String a = this.f12153i.a(ContactsUploadPrefKeys.f10968k, "0");
            GraphQLRequest a2 = GraphQLRequest.a((FetchPhonebookHashesQueryString) new FetchPhonebookHashesQueryString().a("client_hash", a)).a(GraphQLCachePolicy.c);
            this.f12149e.m12823a(Events.SEND_ROOTHASH_TO_SERVER);
            Futures.a(this.f12154j.a(a2), new 2(this, str, a), this.f12152h);
            return null;
        }
        this.f12149e.m12825a(ContactsUploadLoggingConstants.e);
        return m12811a(str);
    }

    private OperationFuture m12811a(String str) {
        this.f12149e.m12823a(Events.START_UPLOAD_CONTACTS);
        Bundle bundle = new Bundle();
        bundle.putBoolean("forceFullUploadAndTurnOffGlobalKillSwitch", false);
        bundle.putInt("contactsUploadPhonebookMaxLimit", this.f12158n);
        OperationFuture a = BlueServiceOperationFactoryDetour.a(this.f12147c, str, bundle, ErrorPropagation.BY_EXCEPTION, f12145a, -2055642194).a();
        Futures.a(a, new 1(this), MoreExecutors.a());
        return a;
    }

    public final boolean m12820a(boolean z) {
        m12816b(z);
        return this.f12153i.a(ContactsUploadPrefKeys.f10963f, -1) >= this.f12153i.a(ContactsUploadPrefKeys.f10966i, -1);
    }

    public final void m12819a(GraphQLResult<FetchPhonebookHashesQueryModel> graphQLResult, String str, String str2) {
        boolean z;
        boolean z2;
        NodeModel a = m12810a((GraphQLResult) graphQLResult);
        if (a != null) {
            this.f12158n = a.k();
        }
        if (a == null || a.j()) {
            z = false;
        } else {
            z = true;
        }
        boolean z3 = z;
        if (z3) {
            this.f12149e.m12824a(Events.SYNC_CHECK_SERVER_RESPONSE_RECEIVED, ContactsUploadLoggingConstants.f);
            m12815b(a);
            m12811a(str);
            z2 = true;
        } else if (m12820a(true)) {
            z2 = false;
            if (a == null) {
                this.f12149e.m12824a(Events.SYNC_CHECK_SERVER_RESPONSE_RECEIVED, ContactsUploadLoggingConstants.i);
            } else {
                this.f12149e.m12824a(Events.SYNC_CHECK_SERVER_RESPONSE_RECEIVED, ContactsUploadLoggingConstants.g);
            }
            m12812a(this);
            this.f12149e.m12831b();
        } else {
            if (a == null) {
                this.f12149e.m12824a(Events.SYNC_CHECK_SERVER_RESPONSE_RECEIVED, ContactsUploadLoggingConstants.j);
            } else {
                this.f12149e.m12824a(Events.SYNC_CHECK_SERVER_RESPONSE_RECEIVED, ContactsUploadLoggingConstants.h);
            }
            m12811a(str);
            z2 = true;
        }
        this.f12149e.m12830a(true, z3, z2, str2, this.f12159o, m12813b(this));
    }

    private void m12815b(NodeModel nodeModel) {
        this.f12149e.m12823a(Events.UPDATE_SNAPSHOT_DB_WITH_SERVER_ENTRIES);
        if (nodeModel != null && nodeModel.a() != null) {
            ImmutableList<NodesModel> a = nodeModel.a().a();
            List arrayList = new ArrayList();
            this.f12157m = new HashSet();
            for (NodesModel nodesModel : a) {
                Long c = m12817c(nodesModel.a());
                if (c != null) {
                    arrayList.add(new PhoneAddressBookSnapshotEntryChange(ChangeType.ADD, c.longValue(), new PhoneAddressBookSnapshotEntry(c.longValue(), nodesModel.j())));
                }
            }
            this.f12150f.m12836a();
            this.f12150f.m12837a(arrayList);
        }
    }

    private static NodeModel m12810a(GraphQLResult<FetchPhonebookHashesQueryModel> graphQLResult) {
        if (graphQLResult == null || graphQLResult.e == null || ((FetchPhonebookHashesQueryModel) graphQLResult.e).a() == null || ((FetchPhonebookHashesQueryModel) graphQLResult.e).a().a().isEmpty()) {
            return null;
        }
        return ((EdgesModel) ((FetchPhonebookHashesQueryModel) graphQLResult.e).a().a().get(0)).a();
    }

    private Long m12817c(String str) {
        if (StringUtil.a(str)) {
            return null;
        }
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            if (this.f12157m.contains(valueOf)) {
                this.f12149e.m12828a(str, true);
                return null;
            }
            this.f12157m.add(valueOf);
            return valueOf;
        } catch (Exception e) {
            this.f12149e.m12828a(str, false);
            return null;
        }
    }

    public static void m12812a(ContinuousContactUploadClient continuousContactUploadClient) {
        long a = continuousContactUploadClient.f12148d.a();
        long b = (a - m12813b(continuousContactUploadClient)) / 1000;
        ContactsUploadAnalyticsLogger contactsUploadAnalyticsLogger = continuousContactUploadClient.f12149e;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("ccu_upload");
        honeyClientEvent.b("data_type", "ccu_upload_age").a("ccu_last_uploaded_addressbook_age_in_seconds", b).c = "contacts_upload";
        contactsUploadAnalyticsLogger.f12162a.a(honeyClientEvent);
        continuousContactUploadClient.f12153i.edit().a(ContactsUploadPrefKeys.f10963f, a).commit();
    }

    public static long m12813b(ContinuousContactUploadClient continuousContactUploadClient) {
        return continuousContactUploadClient.f12153i.a(ContactsUploadPrefKeys.f10963f, -1);
    }
}
