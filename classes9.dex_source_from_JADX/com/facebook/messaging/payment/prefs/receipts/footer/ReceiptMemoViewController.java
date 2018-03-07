package com.facebook.messaging.payment.prefs.receipts.footer;

import android.content.Context;
import android.text.Spannable.Factory;
import android.text.SpannableStringBuilder;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.TransferContextModel;
import com.facebook.payments.ui.FloatingLabelTextView;
import com.facebook.ui.emoji.EmojiUtil;
import javax.inject.Inject;

@ContextScoped
/* compiled from: get_payment_methods_info */
public class ReceiptMemoViewController {
    private static ReceiptMemoViewController f14104c;
    private static final Object f14105d = new Object();
    public final EmojiUtil f14106a;
    public FloatingLabelTextView f14107b;

    private static ReceiptMemoViewController m14580b(InjectorLike injectorLike) {
        return new ReceiptMemoViewController(EmojiUtil.a(injectorLike));
    }

    @Inject
    public ReceiptMemoViewController(EmojiUtil emojiUtil) {
        this.f14106a = emojiUtil;
    }

    public final void m14581a(Object obj) {
        Object obj2 = null;
        if (obj instanceof PaymentTransaction) {
            TransferContextModel transferContextModel = ((PaymentTransaction) obj).f13239l;
            if (transferContextModel != null) {
                obj2 = transferContextModel.m13950a();
            }
        } else if (obj instanceof PaymentRequestModel) {
            obj2 = ((PaymentRequestModel) obj).m13814g();
        }
        if (StringUtil.c(obj2)) {
            this.f14107b.setVisibility(8);
            return;
        }
        CharSequence spannableStringBuilder = new SpannableStringBuilder(Factory.getInstance().newSpannable(obj2.trim()));
        this.f14106a.a(spannableStringBuilder, (int) this.f14107b.getTextSize());
        this.f14107b.setText(spannableStringBuilder);
        this.f14107b.setVisibility(0);
    }

    public static ReceiptMemoViewController m14579a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReceiptMemoViewController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14105d) {
                ReceiptMemoViewController receiptMemoViewController;
                if (a2 != null) {
                    receiptMemoViewController = (ReceiptMemoViewController) a2.a(f14105d);
                } else {
                    receiptMemoViewController = f14104c;
                }
                if (receiptMemoViewController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14580b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14105d, b3);
                        } else {
                            f14104c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = receiptMemoViewController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
