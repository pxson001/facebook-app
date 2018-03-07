package com.facebook.messaging.payment.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.CommerceOrderModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.CommerceOrderModel.Builder;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = CommerceOrderDeserializer.class)
@Immutable
/* compiled from: image/vnd.wap.wbmp */
public class CommerceOrder implements Parcelable {
    public static final Creator<CommerceOrder> CREATOR = new C14801();
    @JsonProperty("description")
    private String mDescription;
    @JsonProperty("id")
    private String mId;
    @JsonProperty("image_url")
    private String mImageUrl;
    @JsonProperty("name")
    private String mName;
    @JsonProperty("seller_info")
    private String mSellerInfo;

    /* compiled from: image/vnd.wap.wbmp */
    final class C14801 implements Creator<CommerceOrder> {
        C14801() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CommerceOrder(parcel);
        }

        public final Object[] newArray(int i) {
            return new CommerceOrder[i];
        }
    }

    public CommerceOrder(String str, String str2, String str3, String str4, @Nullable String str5) {
        this.mId = str;
        this.mName = str2;
        this.mDescription = str3;
        this.mSellerInfo = str4;
        this.mImageUrl = str5;
    }

    protected CommerceOrder(Parcel parcel) {
        this.mId = parcel.readString();
        this.mName = parcel.readString();
        this.mDescription = parcel.readString();
        this.mSellerInfo = parcel.readString();
        this.mImageUrl = parcel.readString();
    }

    private CommerceOrder() {
        this.mId = null;
        this.mName = null;
        this.mDescription = null;
        this.mSellerInfo = null;
        this.mImageUrl = null;
    }

    public final String m13473a() {
        return this.mName;
    }

    public final String m13474b() {
        return this.mSellerInfo;
    }

    @Nullable
    public final String m13475c() {
        return this.mImageUrl;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("id", this.mId).add("name", this.mName).add("description", this.mDescription).add("sellerInfo", this.mSellerInfo).add("imageUrl", this.mImageUrl).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mName);
        parcel.writeString(this.mDescription);
        parcel.writeString(this.mSellerInfo);
        parcel.writeString(this.mImageUrl);
    }

    public final CommerceOrderModel m13476d() {
        Builder builder = new Builder();
        builder.f13271a = this.mDescription;
        builder = builder;
        builder.f13272b = this.mId;
        builder = builder;
        builder.f13273c = this.mImageUrl;
        builder = builder;
        builder.f13274d = this.mName;
        builder = builder;
        builder.f13275e = this.mSellerInfo;
        return builder.m13567a();
    }
}
