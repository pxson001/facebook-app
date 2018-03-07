package com.facebook.payments.confirmation;

import android.content.res.Resources;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: calendar_settings */
public class SimpleConfirmationRowsGenerator {
    public final Resources f18637a;

    public final ImmutableList<ConfirmationRow> m18658a(SimpleConfirmationData simpleConfirmationData) {
        simpleConfirmationData = simpleConfirmationData;
        Builder builder = new Builder();
        builder.c(m18655a(ConfirmationRowType.CHECK_MARK));
        builder.c(new SimpleProductPurchaseRow(this.f18637a.getString(2131241071)));
        builder.c(m18655a(ConfirmationRowType.DIVIDER));
        m18656a(simpleConfirmationData, builder);
        return builder.b();
    }

    @Inject
    public SimpleConfirmationRowsGenerator(Resources resources) {
        this.f18637a = resources;
    }

    private ConfirmationRow m18655a(final ConfirmationRowType confirmationRowType) {
        return new ConfirmationRow(this) {
            final /* synthetic */ SimpleConfirmationRowsGenerator f18636b;

            public final ConfirmationRowType mo733a() {
                return confirmationRowType;
            }
        };
    }

    private void m18656a(SimpleConfirmationData simpleConfirmationData, Builder<ConfirmationRow> builder) {
        int i = 0;
        Builder builder2 = new Builder();
        builder2.c(new ReceiptPostPurchaseAction(simpleConfirmationData.f18629b.mo732a().f18595c, this.f18637a.getString(2131241069), PostPurchaseActionType.SEE_RECEIPT));
        ImmutableList immutableList = RegularImmutableList.a;
        Preconditions.checkArgument(immutableList.size() <= 3);
        builder2.b(immutableList);
        if (simpleConfirmationData.f18629b.mo732a().f18594b) {
            builder2.c(m18657c());
        }
        immutableList = builder2.b();
        while (i < immutableList.size() - 1) {
            int i2 = i + 1;
            SimplePostPurchaseAction simplePostPurchaseAction = (SimplePostPurchaseAction) immutableList.get(i);
            PostPurchaseActionRow.Builder newBuilder = PostPurchaseActionRow.newBuilder();
            newBuilder.f18614a = simplePostPurchaseAction;
            newBuilder = newBuilder;
            newBuilder.f18616c = simpleConfirmationData.m18645b(simplePostPurchaseAction.f18625b);
            builder.c(newBuilder.m18638d());
            i = i2;
        }
        PostPurchaseActionRow.Builder newBuilder2 = PostPurchaseActionRow.newBuilder();
        newBuilder2.f18614a = (SimplePostPurchaseAction) immutableList.get(i);
        PostPurchaseActionRow.Builder builder3 = newBuilder2;
        builder3.f18615b = true;
        PostPurchaseActionRow.Builder builder4 = builder3;
        builder4.f18616c = simpleConfirmationData.m18645b(((SimplePostPurchaseAction) immutableList.get(i)).f18625b);
        builder.c(builder4.m18638d());
    }

    private SimplePostPurchaseAction m18657c() {
        return new SimplePostPurchaseAction(this.f18637a.getString(2131241070), PostPurchaseActionType.ACTIVATE_SECURITY_PIN);
    }
}
