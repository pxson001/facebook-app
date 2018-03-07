package com.facebook.messaging.payment.prefs.receipts.manual.model;

import android.net.Uri;
import com.facebook.graphql.enums.GraphQLPageProductTransactionOrderStatusEnum;
import com.facebook.messaging.payment.ui.model.PlatformCommerceAmountViewParams;
import com.facebook.payments.ui.SingleItemInfoViewParams;
import com.google.common.base.Absent;
import com.google.common.base.Objects;
import com.google.common.base.Optional;

/* compiled from: getActiveSession */
public class InvoicesSummaryModel {
    public final Optional<String> f14248a;
    public final Optional<SingleItemInfoViewParams> f14249b;
    public final Optional<PlatformCommerceAmountViewParams> f14250c;
    public final Optional<String> f14251d;
    public final Optional<String> f14252e;
    public final Optional<String> f14253f;
    public final Optional<String> f14254g;
    public final Optional<String> f14255h;
    public final Optional<Uri> f14256i;
    public final Optional<Uri> f14257j;
    public final Optional<Integer> f14258k;
    public final Optional<String> f14259l;
    public final Optional<String> f14260m;
    public final Optional<GraphQLPageProductTransactionOrderStatusEnum> f14261n;
    public final Optional<String> f14262o;
    public final Optional<String> f14263p;
    public final Optional<String> f14264q;

    /* compiled from: getActiveSession */
    public class Builder {
        public Optional<String> f14231a = Absent.INSTANCE;
        public Optional<SingleItemInfoViewParams> f14232b = Absent.INSTANCE;
        public Optional<PlatformCommerceAmountViewParams> f14233c = Absent.INSTANCE;
        public Optional<String> f14234d = Absent.INSTANCE;
        public Optional<String> f14235e = Absent.INSTANCE;
        public Optional<String> f14236f = Absent.INSTANCE;
        public Optional<String> f14237g = Absent.INSTANCE;
        public Optional<String> f14238h = Absent.INSTANCE;
        public Optional<Uri> f14239i = Absent.INSTANCE;
        public Optional<Uri> f14240j = Absent.INSTANCE;
        public Optional<Integer> f14241k = Absent.INSTANCE;
        public Optional<String> f14242l = Absent.INSTANCE;
        public Optional<String> f14243m = Absent.INSTANCE;
        public Optional<GraphQLPageProductTransactionOrderStatusEnum> f14244n = Absent.INSTANCE;
        public Optional<String> f14245o = Absent.INSTANCE;
        public Optional<String> f14246p = Absent.INSTANCE;
        public Optional<String> f14247q = Absent.INSTANCE;

        public Builder(InvoicesSummaryModel invoicesSummaryModel) {
            this.f14231a = invoicesSummaryModel.f14248a;
            this.f14232b = invoicesSummaryModel.f14249b;
            this.f14233c = invoicesSummaryModel.f14250c;
            this.f14234d = invoicesSummaryModel.f14251d;
            this.f14235e = invoicesSummaryModel.f14252e;
            this.f14236f = invoicesSummaryModel.f14253f;
            this.f14237g = invoicesSummaryModel.f14254g;
            this.f14238h = invoicesSummaryModel.f14255h;
            this.f14239i = invoicesSummaryModel.f14256i;
            this.f14240j = invoicesSummaryModel.f14257j;
            this.f14241k = invoicesSummaryModel.f14258k;
            this.f14242l = invoicesSummaryModel.f14259l;
            this.f14243m = invoicesSummaryModel.f14260m;
            this.f14244n = invoicesSummaryModel.f14261n;
            this.f14245o = invoicesSummaryModel.f14262o;
            this.f14246p = invoicesSummaryModel.f14263p;
            this.f14247q = invoicesSummaryModel.f14264q;
        }

        public final Builder m14687d(String str) {
            this.f14237g = Optional.fromNullable(str);
            return this;
        }

        public final Builder m14688f(String str) {
            this.f14243m = Optional.fromNullable(str);
            return this;
        }

        public final InvoicesSummaryModel m14686a() {
            return new InvoicesSummaryModel(this);
        }
    }

    public InvoicesSummaryModel(Builder builder) {
        this.f14248a = builder.f14231a;
        this.f14249b = builder.f14232b;
        this.f14250c = builder.f14233c;
        this.f14251d = builder.f14234d;
        this.f14252e = builder.f14235e;
        this.f14253f = builder.f14236f;
        this.f14254g = builder.f14237g;
        this.f14255h = builder.f14238h;
        this.f14256i = builder.f14239i;
        this.f14257j = builder.f14240j;
        this.f14258k = builder.f14241k;
        this.f14259l = builder.f14242l;
        this.f14260m = builder.f14243m;
        this.f14261n = builder.f14244n;
        this.f14262o = builder.f14245o;
        this.f14263p = builder.f14246p;
        this.f14264q = builder.f14247q;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof InvoicesSummaryModel)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        InvoicesSummaryModel invoicesSummaryModel = (InvoicesSummaryModel) obj;
        if (Objects.equal(this.f14248a, invoicesSummaryModel.f14248a) && Objects.equal(this.f14249b, invoicesSummaryModel.f14249b) && Objects.equal(this.f14250c, invoicesSummaryModel.f14250c) && Objects.equal(this.f14251d, invoicesSummaryModel.f14251d) && Objects.equal(this.f14252e, invoicesSummaryModel.f14252e) && Objects.equal(this.f14253f, invoicesSummaryModel.f14253f) && Objects.equal(this.f14254g, invoicesSummaryModel.f14254g) && Objects.equal(this.f14255h, invoicesSummaryModel.f14255h) && Objects.equal(this.f14256i, invoicesSummaryModel.f14256i) && Objects.equal(this.f14257j, invoicesSummaryModel.f14257j) && Objects.equal(this.f14258k, invoicesSummaryModel.f14258k) && Objects.equal(this.f14259l, invoicesSummaryModel.f14259l) && Objects.equal(this.f14260m, invoicesSummaryModel.f14260m) && Objects.equal(this.f14261n, invoicesSummaryModel.f14261n) && Objects.equal(this.f14262o, invoicesSummaryModel.f14262o) && Objects.equal(this.f14263p, invoicesSummaryModel.f14263p) && Objects.equal(this.f14264q, invoicesSummaryModel.f14264q)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f14248a, this.f14249b, this.f14250c, this.f14251d, this.f14252e, this.f14253f, this.f14254g, this.f14255h, this.f14256i, this.f14257j, this.f14258k, this.f14259l, this.f14260m, this.f14261n, this.f14262o, this.f14263p, this.f14264q});
    }
}
