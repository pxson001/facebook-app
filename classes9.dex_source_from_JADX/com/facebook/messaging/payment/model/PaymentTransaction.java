package com.facebook.messaging.payment.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.Postprocessable;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPeerToPeerTransferReceiverStatus;
import com.facebook.graphql.enums.GraphQLPeerToPeerTransferSenderStatus;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.CommerceOrderModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentCurrencyQuantityModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentTransactionModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentTransactionModel.Builder;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentUserModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PlatformItemModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.TransferContextModel;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: icon_style */
public class PaymentTransaction implements Parcelable, Postprocessable<PaymentTransaction> {
    public static final Creator<PaymentTransaction> CREATOR = new C14851();
    private static final TransferContextModel f13228a = new TransferContextModel();
    public final String f13229b;
    public PaymentType f13230c;
    public Sender f13231d;
    public Receiver f13232e;
    public String f13233f;
    public TransferStatus f13234g;
    public String f13235h;
    public String f13236i;
    public Amount f13237j;
    public Amount f13238k;
    public TransferContextModel f13239l;
    public PlatformItemModel f13240m;
    public CommerceOrder f13241n;
    public String f13242o;

    /* compiled from: icon_style */
    final class C14851 implements Creator<PaymentTransaction> {
        C14851() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PaymentTransaction(parcel);
        }

        public final Object[] newArray(int i) {
            return new PaymentTransaction[i];
        }
    }

    public final /* synthetic */ Object m13519a() {
        return m13518q();
    }

    public PaymentTransaction(PaymentTransactionBuilder paymentTransactionBuilder) {
        this.f13229b = paymentTransactionBuilder.f13243a;
        this.f13230c = paymentTransactionBuilder.f13244b;
        this.f13233f = paymentTransactionBuilder.f13247e;
        this.f13234g = paymentTransactionBuilder.f13248f;
        this.f13236i = paymentTransactionBuilder.f13250h;
        this.f13235h = paymentTransactionBuilder.f13249g;
        this.f13231d = paymentTransactionBuilder.f13245c;
        this.f13232e = paymentTransactionBuilder.f13246d;
        this.f13237j = paymentTransactionBuilder.f13251i;
        this.f13238k = paymentTransactionBuilder.f13252j;
        this.f13239l = paymentTransactionBuilder.f13253k;
        this.f13240m = paymentTransactionBuilder.f13254l;
        this.f13241n = paymentTransactionBuilder.f13255m;
        this.f13242o = paymentTransactionBuilder.f13256n;
        m13518q();
    }

    public static PaymentTransactionBuilder newBuilder() {
        return new PaymentTransactionBuilder();
    }

    public final String m13520b() {
        return this.f13229b;
    }

    public final Sender m13521d() {
        return this.f13231d;
    }

    public final Receiver m13522e() {
        return this.f13232e;
    }

    public final String m13523f() {
        return this.f13233f;
    }

    public final TransferStatus m13524g() {
        return this.f13234g;
    }

    public final String m13525h() {
        return this.f13235h;
    }

    public final String m13526i() {
        return this.f13236i;
    }

    public final Amount m13527j() {
        return this.f13237j;
    }

    public final Amount m13528k() {
        return this.f13238k;
    }

    public final TransferContextModel m13529l() {
        return this.f13239l;
    }

    @Nullable
    public final PlatformItemModel m13530m() {
        return this.f13240m;
    }

    @Nullable
    public final CommerceOrder m13531n() {
        return this.f13241n;
    }

    protected PaymentTransaction(Parcel parcel) {
        this.f13229b = parcel.readString();
        this.f13230c = (PaymentType) ParcelUtil.c(parcel, PaymentType.class);
        this.f13233f = parcel.readString();
        this.f13234g = (TransferStatus) parcel.readSerializable();
        this.f13236i = parcel.readString();
        this.f13235h = parcel.readString();
        this.f13231d = (Sender) parcel.readParcelable(Sender.class.getClassLoader());
        this.f13232e = (Receiver) parcel.readParcelable(Receiver.class.getClassLoader());
        this.f13237j = (Amount) parcel.readParcelable(Amount.class.getClassLoader());
        this.f13238k = (Amount) parcel.readParcelable(Amount.class.getClassLoader());
        this.f13239l = (TransferContextModel) FlatBufferModelHelper.a(parcel);
        this.f13240m = (PlatformItemModel) FlatBufferModelHelper.a(parcel);
        this.f13241n = (CommerceOrder) parcel.readParcelable(CommerceOrder.class.getClassLoader());
        this.f13242o = parcel.readString();
        m13518q();
    }

    private PaymentTransaction() {
        this.f13229b = null;
        this.f13230c = null;
        this.f13232e = null;
        this.f13231d = null;
        this.f13233f = null;
        this.f13234g = null;
        this.f13235h = null;
        this.f13236i = null;
        this.f13237j = null;
        this.f13238k = null;
        this.f13239l = null;
        this.f13240m = null;
        this.f13241n = null;
        this.f13242o = null;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("id", this.f13229b).add("payment_type", this.f13230c).add("sender", this.f13231d).add("receiver", this.f13232e).add("creation_time", this.f13233f).add("transfer_status", this.f13234g).add("completed_time", this.f13235h).add("updated_time", this.f13236i).add("amount", this.f13237j).add("amount_fb_discount", this.f13238k).add("transfer_context", this.f13239l).add("platform_item", this.f13240m).add("commerce_order", this.f13241n).add("order_id", this.f13242o).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f13229b);
        ParcelUtil.a(parcel, this.f13230c);
        parcel.writeString(this.f13233f);
        parcel.writeSerializable(this.f13234g);
        parcel.writeString(this.f13236i);
        parcel.writeString(this.f13235h);
        parcel.writeParcelable(this.f13231d, i);
        parcel.writeParcelable(this.f13232e, i);
        parcel.writeParcelable(this.f13237j, i);
        parcel.writeParcelable(this.f13238k, i);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f13239l);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f13240m);
        parcel.writeParcelable(this.f13241n, i);
        parcel.writeString(this.f13242o);
    }

    private PaymentTransaction m13518q() {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(this.f13229b));
        this.f13230c = this.f13230c != null ? this.f13230c : PaymentType.UNKNOWN;
        this.f13233f = this.f13233f != null ? this.f13233f : "0";
        this.f13235h = this.f13235h != null ? this.f13235h : "0";
        this.f13236i = this.f13236i != null ? this.f13236i : "0";
        this.f13231d = this.f13231d != null ? this.f13231d : Sender.f13260a;
        this.f13232e = this.f13232e != null ? this.f13232e : Receiver.f13258a;
        this.f13234g = this.f13234g != null ? this.f13234g : TransferStatus.UNKNOWN_STATUS;
        this.f13237j = this.f13237j != null ? this.f13237j : Amount.f13194a;
        this.f13238k = this.f13238k != null ? this.f13238k : Amount.f13195b;
        this.f13239l = this.f13239l != null ? this.f13239l : f13228a;
        return this;
    }

    public final PaymentTransactionModel m13532p() {
        TransferContextModel transferContextModel;
        PaymentCurrencyQuantityModel paymentCurrencyQuantityModel;
        CommerceOrderModel commerceOrderModel;
        PaymentUserModel paymentUserModel;
        PaymentUserModel paymentUserModel2 = null;
        GraphQLObjectType graphQLObjectType = new GraphQLObjectType(this.f13230c.getValue());
        PlatformItemModel platformItemModel = this.f13240m instanceof PlatformItemModel ? this.f13240m : null;
        GraphQLPeerToPeerTransferReceiverStatus fromString = GraphQLPeerToPeerTransferReceiverStatus.fromString(this.f13234g.toString());
        GraphQLPeerToPeerTransferSenderStatus fromString2 = GraphQLPeerToPeerTransferSenderStatus.fromString(this.f13234g.toString());
        if (this.f13239l instanceof TransferContextModel) {
            transferContextModel = this.f13239l;
        } else {
            transferContextModel = null;
        }
        Builder builder = new Builder();
        builder.f13392a = graphQLObjectType;
        builder = builder;
        if (this.f13237j == null) {
            paymentCurrencyQuantityModel = null;
        } else {
            paymentCurrencyQuantityModel = this.f13237j.m13470e();
        }
        builder.f13393b = paymentCurrencyQuantityModel;
        builder = builder;
        if (this.f13238k == null) {
            paymentCurrencyQuantityModel = null;
        } else {
            paymentCurrencyQuantityModel = this.f13238k.m13470e();
        }
        builder.f13394c = paymentCurrencyQuantityModel;
        builder = builder;
        if (this.f13241n == null) {
            commerceOrderModel = null;
        } else {
            commerceOrderModel = this.f13241n.m13476d();
        }
        builder.f13395d = commerceOrderModel;
        Builder builder2 = builder;
        builder2.f13396e = Long.parseLong(this.f13235h);
        builder2 = builder2;
        builder2.f13397f = Long.parseLong(this.f13233f);
        builder2 = builder2;
        builder2.f13398g = this.f13229b;
        builder2 = builder2;
        builder2.f13400i = platformItemModel;
        builder2 = builder2;
        if (this.f13232e == null) {
            paymentUserModel = null;
        } else {
            paymentUserModel = this.f13232e.m13545e();
        }
        builder2.f13401j = paymentUserModel;
        Builder builder3 = builder2;
        builder3.f13402k = fromString;
        builder3 = builder3;
        if (this.f13231d != null) {
            paymentUserModel2 = this.f13231d.m13553e();
        }
        builder3.f13403l = paymentUserModel2;
        builder3 = builder3;
        builder3.f13404m = fromString2;
        builder3 = builder3;
        builder3.f13405n = transferContextModel;
        Builder builder4 = builder3;
        builder4.f13406o = Long.parseLong(this.f13236i);
        builder4 = builder4;
        builder4.f13399h = this.f13242o;
        return builder4.m13829a();
    }
}
