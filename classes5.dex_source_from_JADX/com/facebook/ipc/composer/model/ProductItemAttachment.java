package com.facebook.ipc.composer.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.StringUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = ProductItemAttachmentDeserializer.class)
@JsonSerialize(using = ProductItemAttachmentSerializer.class)
/* compiled from: TIMELINE_FRIENDS_LIST */
public class ProductItemAttachment implements Parcelable {
    public static final Creator<ProductItemAttachment> CREATOR = new C13381();
    @JsonIgnore
    public final ProductItemPlace f14016a;
    @JsonIgnore
    public final boolean f14017b;
    @JsonIgnore
    public final boolean f14018c;
    @JsonProperty("category_id")
    public final String categoryID;
    @JsonProperty("currency")
    public final String currencyCode;
    @JsonIgnore
    public final boolean f14019d;
    @JsonProperty("description")
    public final String description;
    @JsonProperty("pickup_delivery_info")
    public final String pickupDeliveryInfo;
    @JsonProperty("price")
    public final Long price;
    @JsonProperty("title")
    public final String title;

    /* compiled from: TIMELINE_FRIENDS_LIST */
    final class C13381 implements Creator<ProductItemAttachment> {
        C13381() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ProductItemAttachment(parcel);
        }

        public final Object[] newArray(int i) {
            return new ProductItemAttachment[i];
        }
    }

    /* compiled from: TIMELINE_FRIENDS_LIST */
    public class Builder {
        public String f14006a;
        public String f14007b;
        public ProductItemPlace f14008c;
        public String f14009d;
        public Long f14010e;
        public String f14011f;
        public String f14012g;
        public boolean f14013h;
        public boolean f14014i;
        public boolean f14015j;

        public final Builder m23390a(String str) {
            this.f14006a = str;
            return this;
        }

        public final Builder m23392b(String str) {
            this.f14007b = str;
            return this;
        }

        public final Builder m23393c(String str) {
            this.f14009d = str;
            return this;
        }

        public final Builder m23389a(Long l) {
            this.f14010e = l;
            return this;
        }

        public final Builder m23394d(String str) {
            this.f14011f = str;
            return this;
        }

        public final ProductItemAttachment m23391a() {
            return new ProductItemAttachment(this);
        }
    }

    /* compiled from: TIMELINE_FRIENDS_LIST */
    public interface ProvidesProductItemAttachment {
        ProductItemAttachment m23395i();
    }

    @JsonProperty("location_page_id")
    public String getLocationPageID() {
        return this.f14016a == null ? null : this.f14016a.locationPageID;
    }

    @JsonIgnore
    private ProductItemAttachment() {
        this(new Builder());
    }

    public ProductItemAttachment(Builder builder) {
        this.title = builder.f14006a;
        this.pickupDeliveryInfo = builder.f14007b;
        this.f14016a = builder.f14008c;
        this.description = builder.f14009d;
        this.price = builder.f14010e;
        this.currencyCode = builder.f14011f;
        this.categoryID = builder.f14012g;
        this.f14017b = builder.f14013h;
        this.f14018c = builder.f14014i;
        this.f14019d = builder.f14015j;
    }

    public ProductItemAttachment(Parcel parcel) {
        this.title = parcel.readString();
        this.pickupDeliveryInfo = parcel.readString();
        this.f14016a = (ProductItemPlace) parcel.readParcelable(ProductItemPlace.class.getClassLoader());
        this.description = parcel.readString();
        this.price = ParcelUtil.m3833e(parcel);
        this.currencyCode = parcel.readString();
        this.categoryID = parcel.readString();
        this.f14017b = false;
        this.f14018c = false;
        this.f14019d = false;
    }

    public int describeContents() {
        return 0;
    }

    private boolean m23396c() {
        return !StringUtil.c(this.title);
    }

    public final boolean m23397a() {
        return this.price != null;
    }

    public final boolean m23398b() {
        if (m23396c() && m23397a() && !(this.f14017b && this.categoryID == null)) {
            if (!this.f14019d) {
                return true;
            }
            if (this.pickupDeliveryInfo != null) {
                if (this.pickupDeliveryInfo.length() >= (this.f14018c ? true : true)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.pickupDeliveryInfo);
        parcel.writeParcelable(this.f14016a, 0);
        parcel.writeString(this.description);
        ParcelUtil.m3821a(parcel, this.price);
        parcel.writeString(this.currencyCode);
        parcel.writeString(this.categoryID);
    }
}
