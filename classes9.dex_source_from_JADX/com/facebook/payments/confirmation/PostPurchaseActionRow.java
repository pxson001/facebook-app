package com.facebook.payments.confirmation;

/* compiled from: call_record */
public class PostPurchaseActionRow implements ConfirmationRow {
    public final SimplePostPurchaseAction f18617a;
    public final boolean f18618b;
    public final boolean f18619c;

    /* compiled from: call_record */
    public class Builder {
        public SimplePostPurchaseAction f18614a;
        public boolean f18615b;
        public boolean f18616c;

        public final PostPurchaseActionRow m18638d() {
            return new PostPurchaseActionRow(this);
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public PostPurchaseActionRow(Builder builder) {
        this.f18617a = builder.f18614a;
        this.f18618b = builder.f18615b;
        this.f18619c = builder.f18616c;
    }

    public final ConfirmationRowType mo733a() {
        return ConfirmationRowType.POST_PURCHASE_ACTION;
    }
}
