package com.facebook.messaging.payment.method.input;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.messaging.payment.model.Address;
import com.facebook.messaging.payment.model.PartialPaymentCard;
import com.facebook.messaging.payment.model.VerificationFollowUpAction;
import com.facebook.messaging.payment.model.VerificationFollowUpActionBuilder;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.service.model.cards.AddPaymentCardResult;
import com.facebook.payments.paymentmethods.cardform.CardFormInput;
import com.facebook.payments.paymentmethods.cardform.CardFormParams;
import com.facebook.payments.paymentmethods.cardform.SimpleCardFormMutator;
import com.facebook.payments.paymentmethods.cardform.protocol.CardFormProtocolUtil;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: initPlayout() called twice without stopPlayout() */
public class MessengerPayAddCardFormMutator extends SimpleCardFormMutator {
    private final Context f13013b;
    private final Provider<User> f13014c;
    private final Executor f13015d;
    private final PaymentProtocolUtil f13016e;

    @Inject
    public MessengerPayAddCardFormMutator(Context context, Provider<User> provider, Executor executor, CardFormProtocolUtil cardFormProtocolUtil, PaymentProtocolUtil paymentProtocolUtil) {
        super(context, executor, cardFormProtocolUtil);
        this.f13013b = context;
        this.f13014c = provider;
        this.f13015d = executor;
        this.f13016e = paymentProtocolUtil;
    }

    public final ListenableFuture m13322a(CardFormParams cardFormParams, final CardFormInput cardFormInput) {
        if (this.f13014c.get() == null) {
            return Futures.a(Boolean.valueOf(false));
        }
        String str;
        PaymentProtocolUtil paymentProtocolUtil = this.f13016e;
        String str2 = cardFormInput.a;
        int i = cardFormInput.c;
        int i2 = cardFormInput.d;
        String str3 = cardFormInput.e;
        String str4 = cardFormInput.f;
        String str5 = ((User) this.f13014c.get()).a;
        if (((MessengerPayCardFormParams) cardFormParams).f13032e) {
            str = "messenger_commerce";
        } else {
            str = "p2p";
        }
        ListenableFuture a = paymentProtocolUtil.m14956a(str2, i, i2, str3, str4, str5, str, ((MessengerPayCardFormParams) cardFormParams).f13029b);
        Futures.a(a, new ResultFutureCallback<AddPaymentCardResult>(this) {
            final /* synthetic */ MessengerPayAddCardFormMutator f13012b;

            protected final void m13321a(Object obj) {
                AddPaymentCardResult addPaymentCardResult = (AddPaymentCardResult) obj;
                MessengerPayAddCardFormMutator messengerPayAddCardFormMutator = this.f13012b;
                CardFormInput cardFormInput = cardFormInput;
                if (messengerPayAddCardFormMutator.a != null) {
                    Preconditions.checkNotNull(cardFormInput.a);
                    Object partialPaymentCard = new PartialPaymentCard(Long.parseLong(addPaymentCardResult.credentialId), cardFormInput.a.substring(cardFormInput.a.length() - 4, cardFormInput.a.length()), cardFormInput.c, cardFormInput.d + 2000, new Address(cardFormInput.f), cardFormInput.a(), true, true);
                    VerificationFollowUpActionBuilder verificationFollowUpActionBuilder = new VerificationFollowUpActionBuilder();
                    verificationFollowUpActionBuilder.f13266a = addPaymentCardResult.followUpActionType;
                    verificationFollowUpActionBuilder = verificationFollowUpActionBuilder;
                    verificationFollowUpActionBuilder.f13267b = addPaymentCardResult.followUpActionText;
                    verificationFollowUpActionBuilder = verificationFollowUpActionBuilder;
                    verificationFollowUpActionBuilder.f13268c = addPaymentCardResult.followUpActionUrl;
                    verificationFollowUpActionBuilder = verificationFollowUpActionBuilder;
                    verificationFollowUpActionBuilder.f13269d = addPaymentCardResult.followUpActionButtonText;
                    VerificationFollowUpAction verificationFollowUpAction = new VerificationFollowUpAction(verificationFollowUpActionBuilder);
                    Parcelable intent = new Intent();
                    intent.putExtra("encoded_credential_id", addPaymentCardResult.encodedCredentialId);
                    intent.putExtra("partial_payment_card", partialPaymentCard);
                    intent.putExtra("verification_follow_up_action", verificationFollowUpAction);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("extra_activity_result_data", intent);
                    messengerPayAddCardFormMutator.a.a(new PaymentsComponentAction(Action.FINISH_ACTIVITY, bundle));
                }
            }

            protected final void m13320a(ServiceException serviceException) {
                this.f13012b.a(serviceException);
            }
        }, this.f13015d);
        return a;
    }

    protected final String m13323a(ApiErrorResult apiErrorResult) {
        switch (apiErrorResult.a()) {
            case 10052:
            case 10057:
                return this.f13013b.getString(2131240285);
            case 10053:
                return this.f13013b.getString(2131240284);
            case 10054:
                return this.f13013b.getString(2131240287);
            case 10055:
                return this.f13013b.getString(2131240286);
            case 10056:
                return this.f13013b.getString(2131240288);
            default:
                return super.a(apiErrorResult);
        }
    }
}
