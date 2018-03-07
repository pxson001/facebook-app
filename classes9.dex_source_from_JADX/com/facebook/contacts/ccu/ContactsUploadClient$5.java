package com.facebook.contacts.ccu;

import com.facebook.contacts.ccu.graphql.C0643xf635526d.ContactUploadSessionCreateAndMaybeBatchUploadMutationFieldsModel;
import com.facebook.contacts.ccu.logging.CCUAnalyticsLogger;
import com.facebook.contacts.ccu.logging.CCULoggingConstants.Events;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: profilePhotoSource */
class ContactsUploadClient$5 implements FutureCallback<GraphQLResult<ContactUploadSessionCreateAndMaybeBatchUploadMutationFieldsModel>> {
    final /* synthetic */ boolean f6200a;
    final /* synthetic */ String f6201b;
    final /* synthetic */ Builder f6202c;
    final /* synthetic */ ContactsUploadClient f6203d;

    ContactsUploadClient$5(ContactsUploadClient contactsUploadClient, boolean z, String str, Builder builder) {
        this.f6203d = contactsUploadClient;
        this.f6200a = z;
        this.f6201b = str;
        this.f6202c = builder;
    }

    public void onSuccess(Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult.e == null || ((ContactUploadSessionCreateAndMaybeBatchUploadMutationFieldsModel) graphQLResult.e).m6656a() == null || ((ContactUploadSessionCreateAndMaybeBatchUploadMutationFieldsModel) graphQLResult.e).m6656a().m6621k() == null) {
            this.f6203d.e.a("create_session_fail", "create session result is null", this.f6200a, this.f6203d.I);
            this.f6203d.y = false;
            this.f6203d.v.m6530c();
            this.f6203d.w.close();
            return;
        }
        this.f6203d.q = ((ContactUploadSessionCreateAndMaybeBatchUploadMutationFieldsModel) graphQLResult.e).m6656a().m6621k();
        this.f6203d.p = ContactsUploadSettings.a(((ContactUploadSessionCreateAndMaybeBatchUploadMutationFieldsModel) graphQLResult.e).m6656a().m6622l());
        if (!this.f6200a) {
            boolean j = ((ContactUploadSessionCreateAndMaybeBatchUploadMutationFieldsModel) graphQLResult.e).m6656a().m6620j();
            if (!j) {
                ContactsUploadClient.a(this.f6203d, ((ContactUploadSessionCreateAndMaybeBatchUploadMutationFieldsModel) graphQLResult.e).m6656a());
            }
            CCUAnalyticsLogger cCUAnalyticsLogger = this.f6203d.e;
            String str = this.f6201b;
            cCUAnalyticsLogger.a.a(CCUAnalyticsLogger.b(Events.CCU_CREATE_SESSION_CHECK_SYNC.getName()).a("in_sync", j).b("root_hash", str).a("last_upload_success_time", this.f6203d.I));
        }
        this.f6203d.h.a(this.f6202c.b());
        ContactsUploadClient.a(this.f6203d, this.f6200a);
    }

    public void onFailure(Throwable th) {
        this.f6203d.e.a("create_session_fail", th.getMessage(), this.f6200a, this.f6203d.I);
        this.f6203d.y = false;
        this.f6203d.v.m6530c();
        this.f6203d.w.close();
    }
}
