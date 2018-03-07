package com.facebook.messaging.payment.util;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLPeerToPeerPaymentRequestStatus;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.messaging.payment.model.PaymentUser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentRequest;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentUserModel;
import com.facebook.messaging.util.date.MessagingDateUtil;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: internal_id */
public class PaymentRequestUtil {
    private static final GraphQLPeerToPeerPaymentRequestStatus[] f10209a = new GraphQLPeerToPeerPaymentRequestStatus[]{GraphQLPeerToPeerPaymentRequestStatus.CANCELED, GraphQLPeerToPeerPaymentRequestStatus.DECLINED, GraphQLPeerToPeerPaymentRequestStatus.TRANSFER_COMPLETED};
    private static PaymentRequestUtil f10210e;
    private static final Object f10211f = new Object();
    public final Provider<User> f10212b;
    public final MessagingDateUtil f10213c;
    private final Comparator<PaymentRequest> f10214d = new C04631(this);

    /* compiled from: internal_id */
    class C04631 implements Comparator<PaymentRequest> {
        final /* synthetic */ PaymentRequestUtil f10244a;

        C04631(PaymentRequestUtil paymentRequestUtil) {
            this.f10244a = paymentRequestUtil;
        }

        public int compare(Object obj, Object obj2) {
            PaymentRequestModel paymentRequestModel = (PaymentRequestModel) obj;
            PaymentRequestModel paymentRequestModel2 = (PaymentRequestModel) obj2;
            if (paymentRequestModel.lw_().equals(paymentRequestModel2.lw_())) {
                return 0;
            }
            boolean a = this.f10244a.m10701a(paymentRequestModel);
            if (a == this.f10244a.m10701a(paymentRequestModel2)) {
                return Long.valueOf(paymentRequestModel2.c()).compareTo(Long.valueOf(paymentRequestModel.c()));
            }
            if (a) {
                return -1;
            }
            return 1;
        }
    }

    private static PaymentRequestUtil m10695b(InjectorLike injectorLike) {
        return new PaymentRequestUtil(IdBasedProvider.a(injectorLike, 3596), MessagingDateUtil.m10717a(injectorLike));
    }

    public static PaymentRequestUtil m10693a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PaymentRequestUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10211f) {
                PaymentRequestUtil paymentRequestUtil;
                if (a2 != null) {
                    paymentRequestUtil = (PaymentRequestUtil) a2.a(f10211f);
                } else {
                    paymentRequestUtil = f10210e;
                }
                if (paymentRequestUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10695b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10211f, b3);
                        } else {
                            f10210e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = paymentRequestUtil;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PaymentRequestUtil(Provider<User> provider, MessagingDateUtil messagingDateUtil) {
        this.f10212b = provider;
        this.f10213c = messagingDateUtil;
    }

    public final ImmutableList<PaymentRequest> m10700a(ImmutableList<PaymentRequest> immutableList, PaymentRequest paymentRequest) {
        Iterable arrayList = new ArrayList(immutableList);
        Collection arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            PaymentRequestModel paymentRequestModel = (PaymentRequestModel) arrayList.get(i);
            if (paymentRequestModel.lw_().equals(paymentRequest.lw_())) {
                arrayList2.add(paymentRequestModel);
            }
        }
        arrayList.removeAll(arrayList2);
        arrayList.add(paymentRequest);
        return m10699a(new Builder().b(arrayList).b());
    }

    public final ImmutableList<PaymentRequest> m10699a(ImmutableList<PaymentRequest> immutableList) {
        Iterable arrayList = new ArrayList(immutableList);
        Collection arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            PaymentRequestModel paymentRequestModel = (PaymentRequestModel) arrayList.get(i);
            if (paymentRequestModel.lx_() == GraphQLPeerToPeerPaymentRequestStatus.TRANSFER_COMPLETED) {
                arrayList2.add(paymentRequestModel);
            }
        }
        arrayList.removeAll(arrayList2);
        Collections.sort(arrayList, this.f10214d);
        return new Builder().b(arrayList).b();
    }

    public final boolean m10701a(PaymentRequestModel paymentRequestModel) {
        if (!m10702d(paymentRequestModel)) {
            return false;
        }
        switch (3.a[paymentRequestModel.lx_().ordinal()]) {
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    public static boolean m10696b(PaymentRequestModel paymentRequestModel) {
        return m10694a(paymentRequestModel.lx_().ordinal());
    }

    public static boolean m10694a(int i) {
        for (GraphQLPeerToPeerPaymentRequestStatus ordinal : f10209a) {
            if (i == ordinal.ordinal()) {
                return true;
            }
        }
        return false;
    }

    public static PaymentUser m10692a(PaymentUserModel paymentUserModel) {
        return new 2(paymentUserModel);
    }

    public final boolean m10702d(PaymentRequestModel paymentRequestModel) {
        if (this.f10212b.get() == null) {
            return false;
        }
        return ((User) this.f10212b.get()).a.equals(paymentRequestModel.j().c());
    }

    public final boolean m10703e(PaymentRequestModel paymentRequestModel) {
        if (this.f10212b.get() == null) {
            return false;
        }
        return ((User) this.f10212b.get()).a.equals(paymentRequestModel.k().c());
    }

    public static boolean m10697f(@Nullable PaymentRequestModel paymentRequestModel) {
        return m10698g(paymentRequestModel) && paymentRequestModel.lx_() == GraphQLPeerToPeerPaymentRequestStatus.TRANSFER_COMPLETED;
    }

    public static boolean m10698g(@Nullable PaymentRequestModel paymentRequestModel) {
        return (paymentRequestModel == null || paymentRequestModel.ly_() == null) ? false : true;
    }
}
