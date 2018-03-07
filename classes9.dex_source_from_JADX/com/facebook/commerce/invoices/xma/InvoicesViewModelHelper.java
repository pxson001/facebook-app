package com.facebook.commerce.invoices.xma;

import android.content.res.Resources;
import com.facebook.commerce.invoices.common.InvoicesUIHelper;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.graphql.enums.GraphQLPageProductTransactionOrderStatusEnum;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: queuing_type */
public class InvoicesViewModelHelper {
    private final InvoicesUIHelper f5952a;
    public final GlyphColorizer f5953b;
    public final Resources f5954c;
    @Nullable
    public Invoice f5955d;

    /* compiled from: queuing_type */
    public /* synthetic */ class C06211 {
        public static final /* synthetic */ int[] f5951a = new int[GraphQLPageProductTransactionOrderStatusEnum.values().length];

        static {
            try {
                f5951a[GraphQLPageProductTransactionOrderStatusEnum.AWAITING_PAYMENT_METHOD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5951a[GraphQLPageProductTransactionOrderStatusEnum.AWAITING_PAYMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5951a[GraphQLPageProductTransactionOrderStatusEnum.PAYMENT_SUBMITTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Inject
    public InvoicesViewModelHelper(InvoicesUIHelper invoicesUIHelper, GlyphColorizer glyphColorizer, Resources resources) {
        this.f5952a = invoicesUIHelper;
        this.f5953b = glyphColorizer;
        this.f5954c = resources;
    }
}
