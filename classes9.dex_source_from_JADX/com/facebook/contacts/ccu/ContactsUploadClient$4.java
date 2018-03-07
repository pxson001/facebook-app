package com.facebook.contacts.ccu;

import com.facebook.contacts.ccu.graphql.ContactsUploadSettingMutationModels.ContinuousContactUploadSettingUpdateMutationFieldsModel;
import com.facebook.contacts.ccu.logging.CCUAnalyticsLogger;
import com.facebook.contacts.ccu.logging.CCULoggingConstants.Events;
import com.facebook.graphql.calls.ContinuousContactUploadSettingUpdateInputData.Source;
import com.facebook.graphql.calls.ContinuousContactUploadSettingUpdateInputData.Status;
import com.facebook.graphql.enums.GraphQLContinuousContactUploadSettingStatusEnum;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.ui.toaster.ToastBuilder;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: profilePhotoSource */
class ContactsUploadClient$4 implements FutureCallback<GraphQLResult<ContinuousContactUploadSettingUpdateMutationFieldsModel>> {
    final /* synthetic */ Source f6196a;
    final /* synthetic */ Status f6197b;
    final /* synthetic */ boolean f6198c;
    final /* synthetic */ ContactsUploadClient f6199d;

    /* compiled from: profilePhotoSource */
    class C06401 implements Runnable {
        final /* synthetic */ ContactsUploadClient$4 f6194a;

        C06401(ContactsUploadClient$4 contactsUploadClient$4) {
            this.f6194a = contactsUploadClient$4;
        }

        public void run() {
            this.f6194a.f6199d.n.b(new ToastBuilder(2131236417));
        }
    }

    /* compiled from: profilePhotoSource */
    class C06412 implements Runnable {
        final /* synthetic */ ContactsUploadClient$4 f6195a;

        C06412(ContactsUploadClient$4 contactsUploadClient$4) {
            this.f6195a = contactsUploadClient$4;
        }

        public void run() {
            this.f6195a.f6199d.n.b(new ToastBuilder(2131230758));
        }
    }

    ContactsUploadClient$4(ContactsUploadClient contactsUploadClient, Source source, Status status, boolean z) {
        this.f6199d = contactsUploadClient;
        this.f6196a = source;
        this.f6197b = status;
        this.f6198c = z;
    }

    public void onSuccess(Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (!(graphQLResult.e == null || ((ContinuousContactUploadSettingUpdateMutationFieldsModel) graphQLResult.e).m6686a() == null || ((ContinuousContactUploadSettingUpdateMutationFieldsModel) graphQLResult.e).m6686a().m6682j() == null)) {
            boolean z;
            if (((ContinuousContactUploadSettingUpdateMutationFieldsModel) graphQLResult.e).m6686a().m6682j() == GraphQLContinuousContactUploadSettingStatusEnum.ON) {
                z = true;
            } else {
                z = false;
            }
            this.f6199d.j.a(z);
            this.f6199d.e.a.a(CCUAnalyticsLogger.b(Events.CCU_SETTING.getName()).a("ccu_enabled", z).b("source", this.f6196a.toString()));
        }
        if (this.f6197b == Status.OFF && this.f6196a == Source.USER_SETTING) {
            this.f6199d.d.a(new C06401(this));
        }
        if (this.f6196a == Source.CCU_BACKGROUND_PING) {
            this.f6199d.l.edit().putBoolean(ContactsUploadPrefKeys.f6224e, true).commit();
        }
    }

    public void onFailure(Throwable th) {
        if (this.f6197b == Status.OFF) {
            if (this.f6196a == Source.USER_SETTING) {
                this.f6199d.j.a(true);
                this.f6199d.d.a(new C06412(this));
            }
            if (this.f6196a == Source.CCU_BACKGROUND_PING && this.f6198c) {
                this.f6199d.j.c();
            }
        }
    }
}
