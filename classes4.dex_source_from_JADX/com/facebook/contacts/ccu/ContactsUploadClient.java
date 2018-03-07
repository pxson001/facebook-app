package com.facebook.contacts.ccu;

import android.text.TextUtils;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.collect.MergeJoinIterator;
import com.facebook.common.collect.MergeJoinIterator$KeyExtractor;
import com.facebook.common.collect.MergeJoinIterator.Entry;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.contacts.ccu.ContactsIterators.ContactsIterator;
import com.facebook.contacts.ccu.graphql.ContactsBatchUploadMutation.ContactBatchUploadMutationString;
import com.facebook.contacts.ccu.graphql.ContactsBatchUploadMutationModels.ContactBatchUploadMutationFieldsModel;
import com.facebook.contacts.ccu.graphql.ContactsUploadSessionCloseMutation.ContactUploadSessionCloseMutationString;
import com.facebook.contacts.ccu.graphql.ContactsUploadSessionCloseMutationModels.ContactUploadSessionCloseMutationFieldsModel;
import com.facebook.contacts.ccu.graphql.ContactsUploadSessionCreateAndMaybeFirstBatchUploadMutation;
import com.facebook.contacts.ccu.graphql.ContactsUploadSessionCreateAndMaybeFirstBatchUploadMutation.ContactUploadSessionCreateAndMaybeBatchUploadMutationString;
import com.facebook.contacts.ccu.graphql.ContactsUploadSessionCreateAndMaybeFirstBatchUploadMutationModels.ContactUploadSessionCreateAndMaybeBatchUploadMutationFieldsModel;
import com.facebook.contacts.ccu.graphql.ContactsUploadSessionCreateAndMaybeFirstBatchUploadMutationModels.ContactUploadSessionCreateAndMaybeBatchUploadMutationFieldsModel.ContactUploadSessionModel;
import com.facebook.contacts.ccu.graphql.ContactsUploadSessionCreateAndMaybeFirstBatchUploadMutationModels.ContactUploadSessionCreateAndMaybeBatchUploadMutationFieldsModel.ContactUploadSessionModel.ServerContactHashesModel;
import com.facebook.contacts.ccu.graphql.ContactsUploadSettingMutation.ContinuousContactUploadSettingUpdateMutationString;
import com.facebook.contacts.ccu.graphql.ContactsUploadSettingMutationModels.ContinuousContactUploadSettingUpdateMutationFieldsModel;
import com.facebook.contacts.ccu.graphql.ContactsUploadSettingMutationModels.ContinuousContactUploadSettingUpdateMutationFieldsModel.Builder;
import com.facebook.contacts.ccu.logging.CCUAnalyticsLogger;
import com.facebook.contacts.ccu.logging.CCULoggingConstants.Events;
import com.facebook.contacts.ccu.snapshot.ContactsUploadSnapshot;
import com.facebook.contacts.ccu.snapshot.ContactsUploadSnapshot.ChangeType;
import com.facebook.contacts.ccu.snapshot.ContactsUploadSnapshotController;
import com.facebook.contacts.ccu.snapshot.ContactsUploadSnapshotIterators;
import com.facebook.contacts.ccu.snapshot.ContactsUploadSnapshotIterators.SnapshotIterator;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.calls.ContactBatchUploadInputData;
import com.facebook.graphql.calls.ContactBatchUploadInputData.Contacts;
import com.facebook.graphql.calls.ContactBatchUploadInputData.Contacts.Emails;
import com.facebook.graphql.calls.ContactBatchUploadInputData.Contacts.Modifier;
import com.facebook.graphql.calls.ContactBatchUploadInputData.Contacts.Phones;
import com.facebook.graphql.calls.ContactUploadSessionCloseInputData;
import com.facebook.graphql.calls.ContactUploadSessionCloseInputData.ForceClose;
import com.facebook.graphql.calls.ContactUploadSessionCreateAndMaybeBatchUploadInputData;
import com.facebook.graphql.calls.ContactUploadSessionCreateAndMaybeBatchUploadInputData.ContactUploadSessionType;
import com.facebook.graphql.calls.ContactUploadSessionCreateAndMaybeBatchUploadInputData.NeedFriendableContacts;
import com.facebook.graphql.calls.ContactUploadSessionCreateAndMaybeBatchUploadInputData.NeedInvitableContacts;
import com.facebook.graphql.calls.ContinuousContactUploadSettingUpdateInputData;
import com.facebook.graphql.calls.ContinuousContactUploadSettingUpdateInputData.Source;
import com.facebook.graphql.calls.ContinuousContactUploadSettingUpdateInputData.Status;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Hashing.Sha256Holder;
import com.google.common.primitives.Longs;
import com.google.common.util.concurrent.Futures;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

@UserScoped
/* compiled from: isPartial */
public class ContactsUploadClient {
    private static final Object f10123J = new Object();
    private static final MergeJoinIterator$KeyExtractor<AddressbookContact, Long> f10124a = new C04601();
    private static final MergeJoinIterator$KeyExtractor<ContactsUploadSnapshot, Long> f10125b = new C04612();
    private static final Comparator<Long> f10126c = new C04623();
    private int f10127A;
    private int f10128B;
    private int f10129C;
    private int f10130D;
    private int f10131E;
    private int f10132F;
    private int f10133G;
    private int f10134H;
    public long f10135I;
    public final DefaultAndroidThreadUtil f10136d;
    public final CCUAnalyticsLogger f10137e;
    public final Clock f10138f;
    private final ContactsIterators f10139g;
    public final ContactsUploadSnapshotController f10140h;
    private final ContactsUploadSnapshotIterators f10141i;
    public final ContactsUploadStatusHelper f10142j;
    private final Executor f10143k;
    public final FbSharedPreferences f10144l;
    private final GraphQLQueryExecutor f10145m;
    public final Toaster f10146n;
    private final UniqueIdForDeviceHolderImpl f10147o;
    public ContactsUploadSettings f10148p = ContactsUploadSettings.f10180a;
    public String f10149q;
    private List<String> f10150r;
    public Set<Integer> f10151s;
    public Queue<UploadContactBatchInfo> f10152t;
    public boolean f10153u;
    public ContactsIterator f10154v = null;
    public SnapshotIterator f10155w = null;
    private MergeJoinIterator<AddressbookContact, ContactsUploadSnapshot, Long> f10156x = null;
    public boolean f10157y = false;
    private int f10158z;

    /* compiled from: isPartial */
    final class C04601 implements MergeJoinIterator$KeyExtractor<AddressbookContact, Long> {
        C04601() {
        }

        public final Object mo793a(Object obj) {
            return ((AddressbookContact) obj).a();
        }
    }

    /* compiled from: isPartial */
    final class C04612 implements MergeJoinIterator$KeyExtractor<ContactsUploadSnapshot, Long> {
        C04612() {
        }

        public final Object mo793a(Object obj) {
            return Long.valueOf(((ContactsUploadSnapshot) obj).a);
        }
    }

    /* compiled from: isPartial */
    final class C04623 implements Comparator<Long> {
        C04623() {
        }

        public final int compare(Object obj, Object obj2) {
            return Longs.m1257a(((Long) obj).longValue(), ((Long) obj2).longValue());
        }
    }

    private static ContactsUploadClient m10609b(InjectorLike injectorLike) {
        return new ContactsUploadClient(DefaultAndroidThreadUtil.b(injectorLike), new CCUAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike)), (Clock) SystemClockMethodAutoProvider.a(injectorLike), ContactsIterators.m10621a(injectorLike), ContactsUploadSnapshotController.m10626b(injectorLike), ContactsUploadSnapshotIterators.m10630a(injectorLike), ContactsUploadStatusHelper.m10642b(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), Toaster.b(injectorLike), UniqueIdForDeviceHolderMethodAutoProvider.b(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.contacts.ccu.ContactsUploadClient m10601a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f10123J;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m10609b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f10123J;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.contacts.ccu.ContactsUploadClient) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.contacts.ccu.ContactsUploadClient) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f10123J;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.contacts.ccu.ContactsUploadClient) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.ccu.ContactsUploadClient.a(com.facebook.inject.InjectorLike):com.facebook.contacts.ccu.ContactsUploadClient");
    }

    @Inject
    public ContactsUploadClient(DefaultAndroidThreadUtil defaultAndroidThreadUtil, CCUAnalyticsLogger cCUAnalyticsLogger, Clock clock, ContactsIterators contactsIterators, ContactsUploadSnapshotController contactsUploadSnapshotController, ContactsUploadSnapshotIterators contactsUploadSnapshotIterators, ContactsUploadStatusHelper contactsUploadStatusHelper, ExecutorService executorService, FbSharedPreferences fbSharedPreferences, GraphQLQueryExecutor graphQLQueryExecutor, Toaster toaster, UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl) {
        this.f10136d = defaultAndroidThreadUtil;
        this.f10137e = cCUAnalyticsLogger;
        this.f10138f = clock;
        this.f10139g = contactsIterators;
        this.f10140h = contactsUploadSnapshotController;
        this.f10141i = contactsUploadSnapshotIterators;
        this.f10142j = contactsUploadStatusHelper;
        this.f10143k = executorService;
        this.f10144l = fbSharedPreferences;
        this.f10145m = graphQLQueryExecutor;
        this.f10146n = toaster;
        this.f10147o = uniqueIdForDeviceHolderImpl;
    }

    public final void m10611a(Status status, Source source) {
        m10612a(status, source, false);
    }

    public final void m10612a(Status status, Source source, boolean z) {
        ContinuousContactUploadSettingUpdateInputData continuousContactUploadSettingUpdateInputData = new ContinuousContactUploadSettingUpdateInputData();
        continuousContactUploadSettingUpdateInputData.a("status", status);
        GraphQlCallInput graphQlCallInput = continuousContactUploadSettingUpdateInputData;
        graphQlCallInput.a("source", source);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("phone_id", this.f10147o.a());
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString continuousContactUploadSettingUpdateMutationString = new ContinuousContactUploadSettingUpdateMutationString();
        continuousContactUploadSettingUpdateMutationString.a("input", graphQlCallInput);
        Builder builder = new Builder();
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = ModelHelper.a(flatBufferBuilder, builder.a);
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        Futures.a(this.f10145m.a(GraphQLRequest.a(continuousContactUploadSettingUpdateMutationString).m12413a(new ContinuousContactUploadSettingUpdateMutationFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null)))), new 4(this, source, status, z), this.f10143k);
    }

    public final void m10610a(ContactUploadSessionCreateAndMaybeBatchUploadInputData.Source source, boolean z, int i) {
        if (!this.f10157y) {
            this.f10157y = true;
            if (z) {
                this.f10148p = ContactsUploadSettings.f10180a;
                this.f10140h.m10628a();
            }
            this.f10150r = new ArrayList();
            this.f10154v = this.f10139g.m10623a();
            this.f10155w = this.f10141i.m10632a();
            if (this.f10154v == null || this.f10155w == null) {
                this.f10157y = false;
                return;
            }
            this.f10158z = 0;
            this.f10127A = 0;
            this.f10128B = 0;
            this.f10129C = 0;
            this.f10130D = 0;
            this.f10131E = 0;
            this.f10132F = 0;
            this.f10133G = 0;
            this.f10134H = 0;
            this.f10135I = this.f10144l.a(ContactsUploadPrefKeys.a, 0);
            this.f10156x = MergeJoinIterator.newBuilder().b(f10124a).a(f10125b).a(f10126c).a(this.f10154v).b(this.f10155w).a();
            String a = this.f10144l.a(ContactsUploadPrefKeys.b, "0");
            ContactUploadSessionCreateAndMaybeBatchUploadInputData a2 = new ContactUploadSessionCreateAndMaybeBatchUploadInputData().b(a).c(a).a(source).a(this.f10147o.a());
            ImmutableList.Builder builder = ImmutableList.builder();
            ImmutableList.Builder builder2 = ImmutableList.builder();
            if (z) {
                int i2 = 0;
                while (this.f10156x.hasNext()) {
                    try {
                        int i3 = i2 + 1;
                        if (i2 >= this.f10148p.f10181b) {
                            break;
                        }
                        m10608a((Entry) this.f10156x.next(), builder, builder2);
                        i2 = i3;
                    } catch (Exception e) {
                        Exception exception = e;
                        this.f10154v.c();
                        this.f10155w.close();
                        this.f10157y = false;
                        this.f10137e.m10617a("create_session_process_data_fail", exception.getMessage(), true, this.f10135I);
                        return;
                    }
                }
                a2.a(AddressbookContact.b(builder.b())).a(ContactUploadSessionType.FULL).a(NeedFriendableContacts.TRUE).a(NeedInvitableContacts.TRUE);
                this.f10130D = this.f10127A;
                this.f10127A = 0;
            } else {
                a2.a(ContactUploadSessionType.DELTA);
            }
            this.f10137e.m10620a(z, i, source.toString(), this.f10148p.f10181b, this.f10130D);
            ContactUploadSessionCreateAndMaybeBatchUploadMutationString a3 = ContactsUploadSessionCreateAndMaybeFirstBatchUploadMutation.a();
            a3.a("input", a2);
            Futures.a(this.f10145m.a(GraphQLRequest.a(a3).m12413a(new ContactUploadSessionCreateAndMaybeBatchUploadMutationFieldsModel.Builder().a())), new 5(this, z, a, builder2), this.f10143k);
        }
    }

    public static void m10606a(ContactsUploadClient contactsUploadClient, boolean z) {
        contactsUploadClient.f10151s = Collections.synchronizedSet(new HashSet(contactsUploadClient.f10148p.f10183d));
        contactsUploadClient.f10152t = new ConcurrentLinkedQueue();
        contactsUploadClient.f10153u = false;
        try {
            UploadContactBatchInfo uploadContactBatchInfo;
            ImmutableList.Builder builder = ImmutableList.builder();
            ImmutableList.Builder builder2 = ImmutableList.builder();
            int i = contactsUploadClient.f10148p.f10181b;
            int i2 = 0;
            int i3 = 0;
            while (contactsUploadClient.f10156x.hasNext()) {
                if (contactsUploadClient.m10608a((Entry) contactsUploadClient.f10156x.next(), builder, builder2)) {
                    ImmutableList.Builder builder3;
                    i3++;
                    if (i3 >= i) {
                        uploadContactBatchInfo = new UploadContactBatchInfo(i2, builder.b(), builder2.b(), false);
                        contactsUploadClient.f10137e.m10618a(z, i2, i, i3, contactsUploadClient.f10127A, contactsUploadClient.f10128B, contactsUploadClient.f10129C);
                        if (contactsUploadClient.f10151s.size() < contactsUploadClient.f10148p.f10183d) {
                            contactsUploadClient.f10151s.add(Integer.valueOf(i2));
                            m10604a(contactsUploadClient, uploadContactBatchInfo, z);
                        } else {
                            contactsUploadClient.f10152t.add(uploadContactBatchInfo);
                        }
                        i2++;
                        builder = ImmutableList.builder();
                        builder3 = ImmutableList.builder();
                        contactsUploadClient.f10130D += contactsUploadClient.f10127A;
                        contactsUploadClient.f10127A = 0;
                        contactsUploadClient.f10131E += contactsUploadClient.f10128B;
                        contactsUploadClient.f10128B = 0;
                        contactsUploadClient.f10132F += contactsUploadClient.f10129C;
                        contactsUploadClient.f10129C = 0;
                        i3 = 0;
                    } else {
                        builder3 = builder2;
                    }
                    builder2 = builder3;
                }
            }
            if (i3 > 0) {
                uploadContactBatchInfo = new UploadContactBatchInfo(i2, builder.b(), builder2.b(), false);
                contactsUploadClient.f10137e.m10618a(z, i2, i, i3, contactsUploadClient.f10127A, contactsUploadClient.f10128B, contactsUploadClient.f10129C);
                if (contactsUploadClient.f10151s.size() < contactsUploadClient.f10148p.f10183d) {
                    contactsUploadClient.f10151s.add(Integer.valueOf(i2));
                    m10604a(contactsUploadClient, uploadContactBatchInfo, z);
                } else {
                    contactsUploadClient.f10152t.add(uploadContactBatchInfo);
                }
                contactsUploadClient.f10130D += contactsUploadClient.f10127A;
                contactsUploadClient.f10131E += contactsUploadClient.f10128B;
                contactsUploadClient.f10132F += contactsUploadClient.f10129C;
                contactsUploadClient.f10133G = i2 + 1;
            } else {
                contactsUploadClient.f10133G = i2;
            }
            contactsUploadClient.f10153u = true;
            contactsUploadClient.f10134H = (contactsUploadClient.f10130D + contactsUploadClient.f10131E) + contactsUploadClient.f10132F;
            contactsUploadClient.f10144l.edit().a(ContactsUploadPrefKeys.b, m10602a(contactsUploadClient.f10150r)).commit();
            if (i3 == 0 && i2 == 0) {
                contactsUploadClient.m10607a(ForceClose.FALSE, z);
            }
            contactsUploadClient.f10154v.c();
            contactsUploadClient.f10155w.close();
        } catch (Throwable th) {
            contactsUploadClient.f10154v.c();
            contactsUploadClient.f10155w.close();
        }
    }

    public static void m10604a(ContactsUploadClient contactsUploadClient, UploadContactBatchInfo uploadContactBatchInfo, boolean z) {
        ContactBatchUploadInputData contactBatchUploadInputData = new ContactBatchUploadInputData();
        contactBatchUploadInputData.a("session_id", contactsUploadClient.f10149q);
        GraphQlCallInput graphQlCallInput = contactBatchUploadInputData;
        graphQlCallInput.a("batch_index", Integer.valueOf(uploadContactBatchInfo.a));
        graphQlCallInput = graphQlCallInput;
        List<AddressbookContact> list = uploadContactBatchInfo.b;
        List arrayList = new ArrayList(list.size());
        for (AddressbookContact addressbookContact : list) {
            List arrayList2 = new ArrayList(addressbookContact.c.size());
            for (String str : addressbookContact.c) {
                Phones phones = new Phones();
                phones.a("value", str);
                arrayList2.add(phones);
            }
            List arrayList3 = new ArrayList(addressbookContact.b.size());
            for (String str2 : addressbookContact.b) {
                Emails emails = new Emails();
                emails.a("value", str2);
                arrayList3.add(emails);
            }
            Contacts contacts = new Contacts();
            contacts.a("record_id", addressbookContact.a);
            GraphQlCallInput graphQlCallInput2 = contacts;
            graphQlCallInput2.a("modifier", Modifier.valueOf(addressbookContact.g.toString()));
            graphQlCallInput2 = graphQlCallInput2;
            graphQlCallInput2.a("name", addressbookContact.d);
            graphQlCallInput2 = graphQlCallInput2;
            graphQlCallInput2.a("first_name", addressbookContact.e);
            graphQlCallInput2 = graphQlCallInput2;
            graphQlCallInput2.a("last_name", addressbookContact.f);
            graphQlCallInput2 = graphQlCallInput2;
            graphQlCallInput2.a("phones", arrayList2);
            graphQlCallInput2 = graphQlCallInput2;
            graphQlCallInput2.a("emails", arrayList3);
            graphQlCallInput2 = graphQlCallInput2;
            graphQlCallInput2.a("minimal_hash", addressbookContact.c());
            graphQlCallInput2 = graphQlCallInput2;
            graphQlCallInput2.a("extended_hash", addressbookContact.c());
            arrayList.add(graphQlCallInput2);
        }
        graphQlCallInput.a("contacts", arrayList);
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString contactBatchUploadMutationString = new ContactBatchUploadMutationString();
        contactBatchUploadMutationString.a("input", graphQlCallInput);
        Futures.a(contactsUploadClient.f10145m.a(GraphQLRequest.a(contactBatchUploadMutationString).m12413a(new ContactBatchUploadMutationFieldsModel.Builder().a())), new 6(contactsUploadClient, uploadContactBatchInfo, z), contactsUploadClient.f10143k);
    }

    public static void m10603a(ContactsUploadClient contactsUploadClient, UploadContactBatchInfo uploadContactBatchInfo, ForceClose forceClose, boolean z) {
        contactsUploadClient.f10151s.remove(Integer.valueOf(uploadContactBatchInfo.a));
        if (contactsUploadClient.f10151s.size() >= contactsUploadClient.f10148p.f10183d || contactsUploadClient.f10152t.isEmpty()) {
            Object obj = (contactsUploadClient.f10153u && contactsUploadClient.f10151s.isEmpty() && contactsUploadClient.f10152t.isEmpty()) ? 1 : null;
            if (obj != null) {
                contactsUploadClient.m10607a(forceClose, z);
                return;
            }
            return;
        }
        UploadContactBatchInfo uploadContactBatchInfo2 = (UploadContactBatchInfo) contactsUploadClient.f10152t.poll();
        contactsUploadClient.f10151s.add(Integer.valueOf(uploadContactBatchInfo2.a));
        m10604a(contactsUploadClient, uploadContactBatchInfo2, z);
    }

    private void m10607a(ForceClose forceClose, boolean z) {
        this.f10137e.m10619a(z, this.f10133G, this.f10134H, this.f10130D, this.f10131E, this.f10132F, this.f10158z, this.f10148p.f10184e);
        String a = this.f10144l.a(ContactsUploadPrefKeys.b, "0");
        ContactUploadSessionCloseInputData contactUploadSessionCloseInputData = new ContactUploadSessionCloseInputData();
        contactUploadSessionCloseInputData.a("session_id", this.f10149q);
        GraphQlCallInput graphQlCallInput = contactUploadSessionCloseInputData;
        graphQlCallInput.a("current_session_hash", a);
        GraphQlCallInput graphQlCallInput2 = graphQlCallInput;
        graphQlCallInput2.a("force_close", forceClose);
        graphQlCallInput2 = graphQlCallInput2;
        GraphQlQueryString contactUploadSessionCloseMutationString = new ContactUploadSessionCloseMutationString();
        contactUploadSessionCloseMutationString.a("input", graphQlCallInput2);
        Futures.a(this.f10145m.a(GraphQLRequest.a(contactUploadSessionCloseMutationString).m12413a(new ContactUploadSessionCloseMutationFieldsModel.Builder().a())), new 7(this, z), this.f10143k);
    }

    private boolean m10608a(Entry<AddressbookContact, ContactsUploadSnapshot> entry, ImmutableList.Builder<AddressbookContact> builder, ImmutableList.Builder<ContactsUploadSnapshot> builder2) {
        AddressbookContact addressbookContact = (AddressbookContact) entry.a;
        Object obj = (ContactsUploadSnapshot) entry.b;
        boolean z = false;
        if (addressbookContact == null) {
            addressbookContact = new AddressbookContact(obj.a);
            addressbookContact.g = AddressbookContact.Modifier.REMOVE;
            addressbookContact = addressbookContact;
            obj.c = ChangeType.REMOVE;
            this.f10128B++;
        } else if (obj == null) {
            r3 = this.f10158z + 1;
            this.f10158z = r3;
            if (r3 <= this.f10148p.f10184e) {
                addressbookContact.g = AddressbookContact.Modifier.ADD;
                r1 = new ContactsUploadSnapshot(addressbookContact.a().longValue(), addressbookContact.c());
                r1.c = ChangeType.ADD;
                r1 = r1;
                this.f10127A++;
            }
        } else {
            r3 = this.f10158z + 1;
            this.f10158z = r3;
            if (r3 > this.f10148p.f10184e) {
                addressbookContact = new AddressbookContact(obj.a);
                addressbookContact.g = AddressbookContact.Modifier.REMOVE;
                addressbookContact = addressbookContact;
                obj.c = ChangeType.REMOVE;
                this.f10128B++;
            } else if (!addressbookContact.c().equals(obj.b)) {
                addressbookContact.g = AddressbookContact.Modifier.UPDATE;
                r1 = new ContactsUploadSnapshot(addressbookContact.a().longValue(), addressbookContact.c());
                r1.c = ChangeType.UPDATE;
                r1 = r1;
                this.f10129C++;
            }
        }
        if (addressbookContact.g != AddressbookContact.Modifier.REMOVE) {
            this.f10150r.add(addressbookContact.c());
        }
        if (addressbookContact.g != null) {
            z = true;
            builder.c(addressbookContact);
            builder2.c(obj);
        }
        return z;
    }

    private static String m10602a(List<String> list) {
        Collections.sort(list);
        return Sha256Holder.a.m1885a(TextUtils.join(":", list), Charsets.UTF_8).toString();
    }

    public static void m10605a(ContactsUploadClient contactsUploadClient, ContactUploadSessionModel contactUploadSessionModel) {
        List arrayList = new ArrayList();
        Set hashSet = new HashSet();
        ImmutableList a = contactUploadSessionModel.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ServerContactHashesModel serverContactHashesModel = (ServerContactHashesModel) a.get(i);
            String b = serverContactHashesModel.b();
            String a2 = serverContactHashesModel.a();
            if (StringUtil.a(b) || hashSet.contains(b)) {
                contactsUploadClient.f10137e.f10160a.a(CCUAnalyticsLogger.m10616b(Events.CCU_INVALID_CONTACT_ID.getName()).b("contact_id", b));
            } else {
                hashSet.add(b);
                ContactsUploadSnapshot contactsUploadSnapshot = new ContactsUploadSnapshot(Long.parseLong(b), a2);
                contactsUploadSnapshot.c = ChangeType.ADD;
                arrayList.add(contactsUploadSnapshot);
            }
        }
        contactsUploadClient.f10140h.m10628a();
        contactsUploadClient.f10140h.m10629a(arrayList);
    }
}
