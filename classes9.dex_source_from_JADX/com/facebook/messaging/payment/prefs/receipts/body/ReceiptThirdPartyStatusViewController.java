package com.facebook.messaging.payment.prefs.receipts.body;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.enums.GraphQLPeerToPeerPaymentRequestStatus;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.TransferStatus;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: goodfriends_show_tooltip */
public class ReceiptThirdPartyStatusViewController {
    private static ReceiptThirdPartyStatusViewController f14069c;
    private static final Object f14070d = new Object();
    private Resources f14071a;
    public BetterTextView f14072b;

    /* compiled from: goodfriends_show_tooltip */
    public /* synthetic */ class C16031 {
        public static final /* synthetic */ int[] f14068b = new int[GraphQLPeerToPeerPaymentRequestStatus.values().length];

        static {
            try {
                f14068b[GraphQLPeerToPeerPaymentRequestStatus.DECLINED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14068b[GraphQLPeerToPeerPaymentRequestStatus.CANCELED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14068b[GraphQLPeerToPeerPaymentRequestStatus.INITED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f14068b[GraphQLPeerToPeerPaymentRequestStatus.TRANSFER_INITED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f14068b[GraphQLPeerToPeerPaymentRequestStatus.TRANSFER_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            f14067a = new int[TransferStatus.values().length];
            try {
                f14067a[TransferStatus.R_PENDING_VERIFICATION.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f14067a[TransferStatus.R_PENDING_VERIFICATION_PROCESSING.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f14067a[TransferStatus.R_PENDING_MANUAL_REVIEW.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f14067a[TransferStatus.R_CANCELED_RECIPIENT_RISK.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f14067a[TransferStatus.R_CANCELED_DECLINED.ordinal()] = 5;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f14067a[TransferStatus.R_CANCELED_EXPIRED.ordinal()] = 6;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f14067a[TransferStatus.R_CANCELED_SAME_CARD.ordinal()] = 7;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f14067a[TransferStatus.R_CANCELED.ordinal()] = 8;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f14067a[TransferStatus.R_CANCELED_SENDER_RISK.ordinal()] = 9;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f14067a[TransferStatus.R_CANCELED_CUSTOMER_SERVICE.ordinal()] = 10;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f14067a[TransferStatus.R_CANCELED_CHARGEBACK.ordinal()] = 11;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f14067a[TransferStatus.R_CANCELED_SYSTEM_FAIL.ordinal()] = 12;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f14067a[TransferStatus.R_PENDING.ordinal()] = 13;
            } catch (NoSuchFieldError e18) {
            }
            try {
                f14067a[TransferStatus.R_COMPLETED.ordinal()] = 14;
            } catch (NoSuchFieldError e19) {
            }
            try {
                f14067a[TransferStatus.R_PENDING_NUX.ordinal()] = 15;
            } catch (NoSuchFieldError e20) {
            }
            try {
                f14067a[TransferStatus.R_PENDING_PROCESSING.ordinal()] = 16;
            } catch (NoSuchFieldError e21) {
            }
            try {
                f14067a[TransferStatus.R_PENDING_PUSH_FAIL.ordinal()] = 17;
            } catch (NoSuchFieldError e22) {
            }
            try {
                f14067a[TransferStatus.R_PENDING_PUSH_FAIL_CARD_EXPIRED.ordinal()] = 18;
            } catch (NoSuchFieldError e23) {
            }
            try {
                f14067a[TransferStatus.S_PENDING_VERIFICATION.ordinal()] = 19;
            } catch (NoSuchFieldError e24) {
            }
            try {
                f14067a[TransferStatus.S_PENDING_VERIFICATION_PROCESSING.ordinal()] = 20;
            } catch (NoSuchFieldError e25) {
            }
            try {
                f14067a[TransferStatus.S_PENDING_MANUAL_REVIEW.ordinal()] = 21;
            } catch (NoSuchFieldError e26) {
            }
            try {
                f14067a[TransferStatus.S_CANCELED_SENDER_RISK.ordinal()] = 22;
            } catch (NoSuchFieldError e27) {
            }
            try {
                f14067a[TransferStatus.S_CANCELED_RECIPIENT_RISK.ordinal()] = 23;
            } catch (NoSuchFieldError e28) {
            }
            try {
                f14067a[TransferStatus.S_CANCELED_DECLINED.ordinal()] = 24;
            } catch (NoSuchFieldError e29) {
            }
            try {
                f14067a[TransferStatus.S_CANCELED_EXPIRED.ordinal()] = 25;
            } catch (NoSuchFieldError e30) {
            }
            try {
                f14067a[TransferStatus.S_CANCELED_SAME_CARD.ordinal()] = 26;
            } catch (NoSuchFieldError e31) {
            }
            try {
                f14067a[TransferStatus.S_CANCELED.ordinal()] = 27;
            } catch (NoSuchFieldError e32) {
            }
            try {
                f14067a[TransferStatus.S_CANCELED_CUSTOMER_SERVICE.ordinal()] = 28;
            } catch (NoSuchFieldError e33) {
            }
            try {
                f14067a[TransferStatus.S_CANCELED_CHARGEBACK.ordinal()] = 29;
            } catch (NoSuchFieldError e34) {
            }
            try {
                f14067a[TransferStatus.S_CANCELED_SYSTEM_FAIL.ordinal()] = 30;
            } catch (NoSuchFieldError e35) {
            }
            try {
                f14067a[TransferStatus.S_PENDING.ordinal()] = 31;
            } catch (NoSuchFieldError e36) {
            }
            try {
                f14067a[TransferStatus.S_COMPLETED.ordinal()] = 32;
            } catch (NoSuchFieldError e37) {
            }
            try {
                f14067a[TransferStatus.S_SENT.ordinal()] = 33;
            } catch (NoSuchFieldError e38) {
            }
            try {
                f14067a[TransferStatus.UNKNOWN_STATUS.ordinal()] = 34;
            } catch (NoSuchFieldError e39) {
            }
        }
    }

    private static ReceiptThirdPartyStatusViewController m14552b(InjectorLike injectorLike) {
        return new ReceiptThirdPartyStatusViewController(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ReceiptThirdPartyStatusViewController(Resources resources) {
        this.f14071a = resources;
    }

    public final void m14553a(Object obj) {
        if (obj instanceof PaymentTransaction) {
            m14551a((PaymentTransaction) obj);
        } else if (obj instanceof PaymentRequestModel) {
            PaymentRequestModel paymentRequestModel = (PaymentRequestModel) obj;
            this.f14072b.setVisibility(0);
            switch (C16031.f14068b[paymentRequestModel.lx_().ordinal()]) {
                case 1:
                    this.f14072b.setText(2131240330);
                    break;
                case 2:
                    this.f14072b.setText(2131240329);
                    break;
                case 3:
                case 4:
                case 5:
                    this.f14072b.setText(2131240331);
                    break;
                default:
                    this.f14072b.setVisibility(8);
                    break;
            }
        }
    }

    public static ReceiptThirdPartyStatusViewController m14549a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReceiptThirdPartyStatusViewController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14070d) {
                ReceiptThirdPartyStatusViewController receiptThirdPartyStatusViewController;
                if (a2 != null) {
                    receiptThirdPartyStatusViewController = (ReceiptThirdPartyStatusViewController) a2.a(f14070d);
                } else {
                    receiptThirdPartyStatusViewController = f14069c;
                }
                if (receiptThirdPartyStatusViewController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14552b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14070d, b3);
                        } else {
                            f14069c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = receiptThirdPartyStatusViewController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private void m14551a(PaymentTransaction paymentTransaction) {
        switch (paymentTransaction.f13234g) {
            case R_PENDING_VERIFICATION:
            case R_PENDING_VERIFICATION_PROCESSING:
            case R_PENDING_MANUAL_REVIEW:
                this.f14072b.setText(this.f14071a.getString(2131240349));
                return;
            case R_CANCELED_RECIPIENT_RISK:
            case R_CANCELED_DECLINED:
            case R_CANCELED_EXPIRED:
            case R_CANCELED_SAME_CARD:
            case R_CANCELED:
            case R_CANCELED_SENDER_RISK:
            case R_CANCELED_CUSTOMER_SERVICE:
            case R_CANCELED_CHARGEBACK:
            case R_CANCELED_SYSTEM_FAIL:
                this.f14072b.setText(this.f14071a.getString(2131240350));
                return;
            case R_PENDING:
            case R_COMPLETED:
            case R_PENDING_NUX:
            case R_PENDING_PROCESSING:
                m14550a();
                return;
            case R_PENDING_PUSH_FAIL:
            case R_PENDING_PUSH_FAIL_CARD_EXPIRED:
            case S_PENDING_VERIFICATION:
            case S_PENDING_VERIFICATION_PROCESSING:
            case S_PENDING_MANUAL_REVIEW:
                this.f14072b.setText(this.f14071a.getString(2131240349));
                return;
            case S_CANCELED_SENDER_RISK:
            case S_CANCELED_RECIPIENT_RISK:
            case S_CANCELED_DECLINED:
            case S_CANCELED_EXPIRED:
            case S_CANCELED_SAME_CARD:
            case S_CANCELED:
            case S_CANCELED_CUSTOMER_SERVICE:
            case S_CANCELED_CHARGEBACK:
            case S_CANCELED_SYSTEM_FAIL:
                this.f14072b.setText(this.f14071a.getString(2131240350));
                return;
            case S_PENDING:
            case S_COMPLETED:
            case S_SENT:
                m14550a();
                return;
            default:
                m14550a();
                BLog.a("ReceiptThirdPartyStatusViewController", "We should not see this unknown transfer status %s", new Object[]{r0});
                return;
        }
    }

    private void m14550a() {
        this.f14072b.setVisibility(8);
    }
}
