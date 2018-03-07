package com.facebook.payments.contactinfo.form;

import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.payments.contactinfo.model.ContactInfoFormInput;
import com.facebook.payments.contactinfo.model.EmailContactInfoFormInput;
import com.facebook.payments.contactinfo.protocol.ContactInfoProtocolUtil;
import com.facebook.payments.contactinfo.protocol.model.AddContactInfoParams;
import com.facebook.payments.contactinfo.protocol.model.AddEmailContactInfoParams;
import com.facebook.payments.contactinfo.protocol.model.ContactInfoProtocolResult;
import com.facebook.payments.contactinfo.protocol.model.EditContactInfoParams.Builder;
import com.facebook.payments.contactinfo.protocol.model.EditEmailContactInfoParams;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: business_page_id */
public class EmailContactInfoFormMutator extends SimpleContactInfoFormMutator {
    public final Executor f18674a;
    public ContactInfoProtocolUtil f18675b;

    /* compiled from: business_page_id */
    public class C21721 extends ResultFutureCallback<ContactInfoProtocolResult> {
        final /* synthetic */ EmailContactInfoFormMutator f18672a;

        public C21721(EmailContactInfoFormMutator emailContactInfoFormMutator) {
            this.f18672a = emailContactInfoFormMutator;
        }

        protected final void m18681a(ServiceException serviceException) {
        }
    }

    /* compiled from: business_page_id */
    class C21732 extends ResultFutureCallback<ContactInfoProtocolResult> {
        final /* synthetic */ EmailContactInfoFormMutator f18673a;

        C21732(EmailContactInfoFormMutator emailContactInfoFormMutator) {
            this.f18673a = emailContactInfoFormMutator;
        }

        protected final void m18683a(ServiceException serviceException) {
        }
    }

    private ListenableFuture m18687a(ContactInfoCommonFormParams contactInfoCommonFormParams, ContactInfoFormInput contactInfoFormInput, boolean z, boolean z2) {
        Builder builder = new EditEmailContactInfoParams.Builder();
        builder.f18704a = contactInfoCommonFormParams.f18642b.mo736a();
        EditEmailContactInfoParams.Builder builder2 = (EditEmailContactInfoParams.Builder) builder;
        if (contactInfoFormInput != null) {
            builder2.f18710a = ((EmailContactInfoFormInput) contactInfoFormInput).f18683a;
        }
        builder2.f18705b = z;
        builder2.f18706c = z2;
        ContactInfoProtocolUtil contactInfoProtocolUtil = this.f18675b;
        ListenableFuture b = contactInfoProtocolUtil.f18695b.b(new EditEmailContactInfoParams(builder2));
        Futures.a(b, new C21732(this), this.f18674a);
        return b;
    }

    @Inject
    public EmailContactInfoFormMutator(Executor executor, ContactInfoProtocolUtil contactInfoProtocolUtil) {
        this.f18674a = executor;
        this.f18675b = contactInfoProtocolUtil;
    }

    public final ListenableFuture mo734a(ContactInfoCommonFormParams contactInfoCommonFormParams, ContactInfoFormInput contactInfoFormInput) {
        if (contactInfoCommonFormParams.f18642b != null) {
            return m18687a(contactInfoCommonFormParams, contactInfoFormInput, false, false);
        }
        AddContactInfoParams.Builder builder = new AddEmailContactInfoParams.Builder();
        builder.f18699a = ((EmailContactInfoFormInput) contactInfoFormInput).f18683a;
        AddContactInfoParams.Builder builder2 = builder;
        builder2.f18697a = contactInfoFormInput.mo738a();
        ListenableFuture b = this.f18675b.f18694a.b(new AddEmailContactInfoParams((AddEmailContactInfoParams.Builder) builder2));
        Futures.a(b, new C21721(this), this.f18674a);
        return b;
    }

    public final ListenableFuture mo735a(ContactInfoCommonFormParams contactInfoCommonFormParams, PaymentsComponentAction paymentsComponentAction) {
        String a = paymentsComponentAction.a("extra_mutation", null);
        if ("make_default_mutation".equals(a)) {
            return m18687a(contactInfoCommonFormParams, null, true, false);
        }
        if ("delete_mutation".equals(a)) {
            return m18687a(contactInfoCommonFormParams, null, false, true);
        }
        return Futures.a(Boolean.valueOf(true));
    }
}
