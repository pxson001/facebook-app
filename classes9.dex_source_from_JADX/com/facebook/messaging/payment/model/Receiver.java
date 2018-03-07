package com.facebook.messaging.payment.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.Postprocessable;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentUserModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentUserModel.Builder;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = ReceiverDeserializer.class)
@Immutable
/* compiled from: hw_vcap */
public class Receiver implements Parcelable, Postprocessable<Receiver>, PaymentUser {
    public static final Creator<Receiver> CREATOR = new C14861();
    static final Receiver f13258a = new Receiver("0", "");
    @JsonProperty("id")
    private String mId;
    @JsonProperty("is_messenger_user")
    private final boolean mIsMessengerUser;
    @JsonProperty("name")
    private String mName;

    /* compiled from: hw_vcap */
    final class C14861 implements Creator<Receiver> {
        C14861() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Receiver(parcel);
        }

        public final Object[] newArray(int i) {
            return new Receiver[i];
        }
    }

    public final /* synthetic */ Object m13541a() {
        return m13540f();
    }

    private Receiver(String str, String str2) {
        this(str, str2, false);
    }

    public Receiver(String str, String str2, boolean z) {
        this.mId = str;
        this.mName = str2;
        this.mIsMessengerUser = z;
        m13540f();
    }

    protected Receiver(Parcel parcel) {
        this.mId = parcel.readString();
        this.mName = parcel.readString();
        this.mIsMessengerUser = ParcelUtil.a(parcel);
        m13540f();
    }

    private Receiver() {
        this.mId = null;
        this.mName = null;
        this.mIsMessengerUser = false;
    }

    public final String mo526b() {
        return this.mId;
    }

    public final String mo527c() {
        return this.mName;
    }

    public final boolean mo528d() {
        return this.mIsMessengerUser;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("id", this.mId).add("name", this.mName).add("is_messenger_user", this.mIsMessengerUser).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mName);
        ParcelUtil.a(parcel, this.mIsMessengerUser);
    }

    private Receiver m13540f() {
        this.mId = this.mId != null ? this.mId : "0";
        this.mName = this.mName != null ? this.mName : "";
        return this;
    }

    public final PaymentUserModel m13545e() {
        Builder builder = new Builder();
        builder.f13426b = this.mId;
        builder = builder;
        builder.f13427c = this.mIsMessengerUser;
        builder = builder;
        builder.f13428d = this.mName;
        return builder.m13868a();
    }
}
