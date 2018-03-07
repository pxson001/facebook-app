package com.facebook.commerce.invoices.xma;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.enums.GraphQLPageProductTransactionOrderStatusEnum;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.prefs.receipts.manual.InvoicesSummaryFragment;
import com.facebook.messaging.payment.value.input.EnterPaymentValueActivity;
import com.facebook.messaging.payment.value.input.MessengerPayType;
import com.facebook.messaging.payment.value.input.pagescommerce.BankWebViewActivity;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: queuing_objects */
public class InvoicesXMAClickHandler {
    private final SecureContextHelper f5957a;
    private final AbstractFbErrorReporter f5958b;

    /* compiled from: queuing_objects */
    /* synthetic */ class C06221 {
        static final /* synthetic */ int[] f5956a = new int[GraphQLPageProductTransactionOrderStatusEnum.values().length];

        static {
            try {
                f5956a[GraphQLPageProductTransactionOrderStatusEnum.VOIDED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5956a[GraphQLPageProductTransactionOrderStatusEnum.AWAITING_PAYMENT_METHOD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5956a[GraphQLPageProductTransactionOrderStatusEnum.AWAITING_PAYMENT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5956a[GraphQLPageProductTransactionOrderStatusEnum.PAYMENT_SUBMITTED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5956a[GraphQLPageProductTransactionOrderStatusEnum.SHIPPED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static InvoicesXMAClickHandler m6289b(InjectorLike injectorLike) {
        return new InvoicesXMAClickHandler((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public InvoicesXMAClickHandler(SecureContextHelper secureContextHelper, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f5957a = secureContextHelper;
        this.f5958b = abstractFbErrorReporter;
    }

    public final void m6291a(Context context, Invoice invoice) {
        String a = invoice.m6280a();
        String str = invoice.f5936d;
        if (Strings.isNullOrEmpty(a) || Strings.isNullOrEmpty(str)) {
            this.f5958b.a("InvoicesXMAClickHandler_onClick", "Invalid IDs for launching summary. PlatformContextID: " + str + ", Invoice.ID: " + a);
            return;
        }
        Intent b = m6288b(context, invoice);
        if (b != null) {
            this.f5957a.a(b, context);
        }
    }

    @Nullable
    private Intent m6288b(Context context, Invoice invoice) {
        GraphQLPageProductTransactionOrderStatusEnum graphQLPageProductTransactionOrderStatusEnum = invoice.f5934b;
        switch (C06221.f5956a[graphQLPageProductTransactionOrderStatusEnum.ordinal()]) {
            case 1:
                return null;
            case 2:
                String str = invoice.f5936d;
                String a = invoice.m6280a();
                Intent intent = new Intent(context, EnterPaymentValueActivity.class);
                intent.putExtra("messenger_pay_type", MessengerPayType.PAGES_COMMERCE);
                intent.putExtra("platform_context_id", str);
                intent.putExtra("invoice_id", a);
                return intent;
            case 3:
                return m6290c(context, invoice);
            case 4:
            case 5:
                return InvoicesSummaryFragment.m14671c(context, invoice.m6280a());
            default:
                this.f5958b.a("InvoicesXMAClickHandler_getClickIntent", "Couldn't create Intent for status: " + graphQLPageProductTransactionOrderStatusEnum);
                return null;
        }
    }

    @Nullable
    private Intent m6290c(Context context, Invoice invoice) {
        if (!invoice.f5938f) {
            return null;
        }
        if (!StringUtil.a(invoice.f5937e)) {
            return BankWebViewActivity.m15978a(context, context.getString(2131238337), invoice.f5937e, null);
        }
        this.f5958b.a("InvoicesXMAClickHandler_getAwaitingPaymentIntent", "No instructionsUrl for invoice withQRCode");
        return null;
    }
}
