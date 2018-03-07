package com.facebook.messaging.payment.prefs.transactions;

import android.content.res.Resources;
import android.graphics.Typeface;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.graphql.enums.GraphQLPeerToPeerPaymentRequestStatus;
import com.facebook.messaging.payment.model.Amount;
import com.facebook.messaging.payment.model.PaymentTransactionType;
import com.facebook.messaging.payment.model.PaymentUser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentCurrencyQuantityModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentUserModel;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: friends_who_recently_used */
public class OrionRequestMessengerPayHistoryItemViewParamsFactory {
    public static final Class<?> f14401a = OrionRequestMessengerPayHistoryItemViewParamsFactory.class;
    private final Provider<User> f14402b;
    public final Resources f14403c;
    public final AbstractFbErrorReporter f14404d;

    /* compiled from: friends_who_recently_used */
    final class C16391 implements PaymentUser {
        final /* synthetic */ PaymentUserModel f14399a;

        C16391(PaymentUserModel paymentUserModel) {
            this.f14399a = paymentUserModel;
        }

        public final String mo526b() {
            return this.f14399a.m13879c();
        }

        public final String mo527c() {
            return this.f14399a.lE_();
        }

        public final boolean mo528d() {
            return this.f14399a.m13880d();
        }
    }

    /* compiled from: friends_who_recently_used */
    public /* synthetic */ class C16402 {
        public static final /* synthetic */ int[] f14400a = new int[GraphQLPeerToPeerPaymentRequestStatus.values().length];

        static {
            try {
                f14400a[GraphQLPeerToPeerPaymentRequestStatus.DECLINED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14400a[GraphQLPeerToPeerPaymentRequestStatus.CANCELED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14400a[GraphQLPeerToPeerPaymentRequestStatus.INITED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f14400a[GraphQLPeerToPeerPaymentRequestStatus.TRANSFER_INITED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f14400a[GraphQLPeerToPeerPaymentRequestStatus.TRANSFER_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f14400a[GraphQLPeerToPeerPaymentRequestStatus.TRANSFER_COMPLETED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    @Inject
    public OrionRequestMessengerPayHistoryItemViewParamsFactory(Provider<User> provider, Resources resources, FbErrorReporter fbErrorReporter) {
        this.f14402b = provider;
        this.f14403c = resources;
        this.f14404d = fbErrorReporter;
    }

    public final MessengerPayHistoryItemViewParams m14786a(Object obj) {
        Preconditions.checkArgument(obj instanceof PaymentRequestModel);
        PaymentRequestModel paymentRequestModel = (PaymentRequestModel) obj;
        if (this.f14402b.get() == null) {
            this.f14404d.b(f14401a.getSimpleName(), "null ViewerContextUser found when creating params for payment request");
            return null;
        }
        boolean z;
        MessengerPayHistoryStatusViewParamsBuilder newBuilder;
        MessengerPayHistoryStatusViewParams d;
        boolean equals = ((User) this.f14402b.get()).a.equals(paymentRequestModel.m13816k().m13879c());
        MessengerPayHistoryItemViewCommonParamsBuilder newBuilder2 = MessengerPayHistoryItemViewCommonParams.newBuilder();
        newBuilder2.f14343a = PaymentTransactionType.ORION;
        MessengerPayHistoryItemViewCommonParamsBuilder messengerPayHistoryItemViewCommonParamsBuilder = newBuilder2;
        if (equals) {
            z = false;
        } else {
            z = true;
        }
        messengerPayHistoryItemViewCommonParamsBuilder.f14347e = Boolean.valueOf(z);
        newBuilder2 = messengerPayHistoryItemViewCommonParamsBuilder;
        newBuilder2.f14344b = m14785a(paymentRequestModel, equals).mo527c();
        newBuilder2 = newBuilder2;
        PaymentCurrencyQuantityModel b = paymentRequestModel.m13811b();
        newBuilder2.f14345c = new Amount(b.m13707b(), b.m13708c(), b.m13703a());
        newBuilder2 = newBuilder2;
        switch (C16402.f14400a[paymentRequestModel.lx_().ordinal()]) {
            case 1:
                newBuilder = MessengerPayHistoryStatusViewParams.newBuilder();
                newBuilder.f14387b = MessengerPayHistoryStatusViewState.CANCELED;
                newBuilder = newBuilder;
                newBuilder.f14386a = Typeface.DEFAULT_BOLD;
                newBuilder = newBuilder;
                newBuilder.f14388c = this.f14403c.getString(2131240330);
                d = newBuilder.m14774d();
                break;
            case 2:
                newBuilder = MessengerPayHistoryStatusViewParams.newBuilder();
                newBuilder.f14387b = MessengerPayHistoryStatusViewState.CANCELED;
                newBuilder = newBuilder;
                newBuilder.f14386a = Typeface.DEFAULT_BOLD;
                newBuilder = newBuilder;
                newBuilder.f14388c = this.f14403c.getString(2131240329);
                d = newBuilder.m14774d();
                break;
            case 3:
            case 4:
            case 5:
                newBuilder = MessengerPayHistoryStatusViewParams.newBuilder();
                newBuilder.f14387b = MessengerPayHistoryStatusViewState.COMPLETED;
                newBuilder = newBuilder;
                newBuilder.f14386a = Typeface.DEFAULT;
                newBuilder = newBuilder;
                newBuilder.f14388c = this.f14403c.getString(2131240331);
                d = newBuilder.m14774d();
                break;
            case 6:
                this.f14404d.b(f14401a.getSimpleName(), "A TRANSFER_COMPLETED request is seen by the user.");
                break;
        }
        paymentRequestModel.lx_();
        newBuilder = MessengerPayHistoryStatusViewParams.newBuilder();
        newBuilder.f14387b = MessengerPayHistoryStatusViewState.PENDING;
        newBuilder = newBuilder;
        newBuilder.f14386a = Typeface.DEFAULT_BOLD;
        newBuilder = newBuilder;
        newBuilder.f14388c = "";
        d = newBuilder.m14774d();
        newBuilder2.f14346d = d;
        newBuilder2 = newBuilder2;
        UserMessengerPayHistoryItemViewParamsBuilder newBuilder3 = UserMessengerPayHistoryItemViewParams.newBuilder();
        newBuilder3.f14420a = m14785a(paymentRequestModel, equals);
        UserMessengerPayHistoryItemViewParamsBuilder userMessengerPayHistoryItemViewParamsBuilder = newBuilder3;
        userMessengerPayHistoryItemViewParamsBuilder.f14421b = newBuilder2.m14754f();
        return userMessengerPayHistoryItemViewParamsBuilder.m14816c();
    }

    private static PaymentUser m14785a(PaymentRequestModel paymentRequestModel, boolean z) {
        return new C16391(z ? paymentRequestModel.m13815j() : paymentRequestModel.m13816k());
    }
}
