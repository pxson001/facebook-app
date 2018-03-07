package com.facebook.commerce.invoices.xma;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.graphql.enums.GraphQLPageProductTransactionOrderStatusEnum;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItem;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModel;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModelType;
import com.facebook.messaging.business.commerce.model.retail.Receipt;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: quickcam photo */
public class Invoice implements CommerceBubbleModel {
    public static final Creator<Invoice> CREATOR = new C06191();
    public final Receipt f5933a;
    public final GraphQLPageProductTransactionOrderStatusEnum f5934b;
    public final String f5935c;
    public final String f5936d;
    public final String f5937e;
    public final boolean f5938f;

    /* compiled from: quickcam photo */
    final class C06191 implements Creator<Invoice> {
        C06191() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Invoice(parcel);
        }

        public final Object[] newArray(int i) {
            return new Invoice[i];
        }
    }

    public Invoice(InvoiceBuilder invoiceBuilder) {
        this.f5933a = (Receipt) Preconditions.checkNotNull(invoiceBuilder.f5939a);
        this.f5934b = (GraphQLPageProductTransactionOrderStatusEnum) Preconditions.checkNotNull(invoiceBuilder.f5940b);
        this.f5935c = invoiceBuilder.f5941c;
        this.f5936d = invoiceBuilder.f5942d;
        this.f5937e = invoiceBuilder.f5943e;
        this.f5938f = invoiceBuilder.f5944f;
    }

    public Invoice(Parcel parcel) {
        this.f5933a = (Receipt) parcel.readParcelable(Receipt.class.getClassLoader());
        this.f5934b = GraphQLPageProductTransactionOrderStatusEnum.fromString(parcel.readString());
        this.f5935c = parcel.readString();
        this.f5936d = parcel.readString();
        this.f5937e = parcel.readString();
        this.f5938f = ParcelUtil.a(parcel);
    }

    public final String m6280a() {
        return this.f5933a.a();
    }

    public final CommerceBubbleModelType m6281b() {
        return this.f5933a.b();
    }

    public final ImmutableList<PlatformGenericAttachmentItem> m6282c() {
        return this.f5933a.c();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f5933a, i);
        parcel.writeString(this.f5934b.name());
        parcel.writeString(this.f5935c);
        parcel.writeString(this.f5936d);
        parcel.writeString(this.f5937e);
        ParcelUtil.a(parcel, this.f5938f);
    }
}
