package com.facebook.contacts.ccu;

import com.facebook.contacts.ccu.graphql.ContactsBatchUploadMutationModels.ContactBatchUploadMutationFieldsModel;
import com.facebook.graphql.calls.ContactUploadSessionCloseInputData.ForceClose;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: profilePhotoSource */
class ContactsUploadClient$6 implements FutureCallback<GraphQLResult<ContactBatchUploadMutationFieldsModel>> {
    final /* synthetic */ ContactsUploadClient$UploadContactBatchInfo f6204a;
    final /* synthetic */ boolean f6205b;
    final /* synthetic */ ContactsUploadClient f6206c;

    ContactsUploadClient$6(ContactsUploadClient contactsUploadClient, ContactsUploadClient$UploadContactBatchInfo contactsUploadClient$UploadContactBatchInfo, boolean z) {
        this.f6206c = contactsUploadClient;
        this.f6204a = contactsUploadClient$UploadContactBatchInfo;
        this.f6205b = z;
    }

    public void onSuccess(Object obj) {
        this.f6206c.h.a(this.f6204a.f6211c);
        ContactsUploadClient.a(this.f6206c, this.f6204a, ForceClose.FALSE, this.f6205b);
    }

    public void onFailure(Throwable th) {
        this.f6206c.e.a("upload_batch_fail", th.getMessage(), this.f6205b, this.f6206c.I);
        if (this.f6204a.f6212d) {
            ContactsUploadClient.a(this.f6206c, this.f6204a, ForceClose.TRUE, this.f6205b);
            return;
        }
        ContactsUploadClient contactsUploadClient = this.f6206c;
        ContactsUploadClient$UploadContactBatchInfo contactsUploadClient$UploadContactBatchInfo = this.f6204a;
        contactsUploadClient$UploadContactBatchInfo.f6212d = true;
        ContactsUploadClient.a(contactsUploadClient, contactsUploadClient$UploadContactBatchInfo, this.f6205b);
    }
}
