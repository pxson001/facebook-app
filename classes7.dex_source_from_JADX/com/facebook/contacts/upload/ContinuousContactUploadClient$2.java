package com.facebook.contacts.upload;

import com.facebook.contacts.upload.graphql.FetchPhonebookHashesGraphQLModels.FetchPhonebookHashesQueryModel;
import com.facebook.contacts.upload.logging.ContactsUploadLoggingConstants.Events;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: tapped_create_shortcut */
public class ContinuousContactUploadClient$2 implements FutureCallback<GraphQLResult<FetchPhonebookHashesQueryModel>> {
    final /* synthetic */ String f2192a;
    final /* synthetic */ String f2193b;
    final /* synthetic */ ContinuousContactUploadClient f2194c;

    public ContinuousContactUploadClient$2(ContinuousContactUploadClient continuousContactUploadClient, String str, String str2) {
        this.f2194c = continuousContactUploadClient;
        this.f2192a = str;
        this.f2193b = str2;
    }

    public void onSuccess(Object obj) {
        this.f2194c.a((GraphQLResult) obj, this.f2192a, this.f2193b);
    }

    public void onFailure(Throwable th) {
        this.f2194c.e.a(false, false, false, this.f2193b, this.f2194c.o, ContinuousContactUploadClient.b(this.f2194c));
        this.f2194c.e.a(Events.SYNC_CHECK_SERVER_RESPONSE_NOT_RECEIVED);
        this.f2194c.e.b();
    }
}
