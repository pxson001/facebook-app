package com.facebook.contacts.ccu;

import com.facebook.contacts.ccu.graphql.ContactsUploadSessionCloseMutationModels.ContactUploadSessionCloseMutationFieldsModel;
import com.facebook.contacts.ccu.logging.CCUAnalyticsLogger;
import com.facebook.contacts.ccu.logging.CCULoggingConstants.Events;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: profilePhotoSource */
class ContactsUploadClient$7 implements FutureCallback<GraphQLResult<ContactUploadSessionCloseMutationFieldsModel>> {
    final /* synthetic */ boolean f6207a;
    final /* synthetic */ ContactsUploadClient f6208b;

    ContactsUploadClient$7(ContactsUploadClient contactsUploadClient, boolean z) {
        this.f6208b = contactsUploadClient;
        this.f6207a = z;
    }

    public void onSuccess(Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult.e == null || !((ContactUploadSessionCloseMutationFieldsModel) graphQLResult.e).m6590a()) {
            this.f6208b.e.a("close_session_out_of_sync", null, this.f6207a, this.f6208b.I);
        } else {
            this.f6208b.l.edit().a(ContactsUploadPrefKeys.f6220a, this.f6208b.f.a()).commit();
            CCUAnalyticsLogger cCUAnalyticsLogger = this.f6208b.e;
            boolean z = this.f6207a;
            cCUAnalyticsLogger.a.a(CCUAnalyticsLogger.b(Events.CCU_CONTACTS_UPLOAD_SUCCEEDED.getName()).a("full_upload", z).a("last_upload_success_time", this.f6208b.I));
        }
        this.f6208b.y = false;
    }

    public void onFailure(Throwable th) {
        this.f6208b.e.a("close_session_fail", th.getMessage(), this.f6207a, this.f6208b.I);
        this.f6208b.y = false;
    }
}
