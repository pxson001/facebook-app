package com.facebook.payments.shipping.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.payments.shipping.model.SimpleMailingAddressFormatter.FormatType;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: backstage_post_update_seen_state */
public class SimpleMailingAddress implements MailingAddress {
    public static final Creator<SimpleMailingAddress> CREATOR = new C22371();
    private final String f19001a;
    private final String f19002b;
    private final String f19003c;
    private final String f19004d;
    private final String f19005e;
    private final String f19006f;
    private final String f19007g;
    private final String f19008h;
    private final String f19009i;
    private final String f19010j;
    private final boolean f19011k;

    /* compiled from: backstage_post_update_seen_state */
    final class C22371 implements Creator<SimpleMailingAddress> {
        C22371() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SimpleMailingAddress(parcel);
        }

        public final Object[] newArray(int i) {
            return new SimpleMailingAddress[i];
        }
    }

    public static SimpleMailingAddressBuilder newBuilder() {
        return new SimpleMailingAddressBuilder();
    }

    public SimpleMailingAddress(SimpleMailingAddressBuilder simpleMailingAddressBuilder) {
        this.f19001a = simpleMailingAddressBuilder.f19012a;
        this.f19002b = simpleMailingAddressBuilder.f19013b;
        this.f19003c = simpleMailingAddressBuilder.f19014c;
        this.f19004d = simpleMailingAddressBuilder.f19015d;
        this.f19005e = simpleMailingAddressBuilder.f19016e;
        this.f19006f = simpleMailingAddressBuilder.f19017f;
        this.f19007g = simpleMailingAddressBuilder.f19018g;
        this.f19008h = simpleMailingAddressBuilder.f19019h;
        this.f19009i = simpleMailingAddressBuilder.f19020i;
        this.f19010j = simpleMailingAddressBuilder.f19021j;
        this.f19011k = simpleMailingAddressBuilder.f19022k;
    }

    public SimpleMailingAddress(Parcel parcel) {
        this.f19001a = parcel.readString();
        this.f19002b = parcel.readString();
        this.f19003c = parcel.readString();
        this.f19004d = parcel.readString();
        this.f19005e = parcel.readString();
        this.f19006f = parcel.readString();
        this.f19007g = parcel.readString();
        this.f19008h = parcel.readString();
        this.f19009i = parcel.readString();
        this.f19010j = parcel.readString();
        this.f19011k = ParcelUtil.a(parcel);
    }

    public final String mo760a() {
        return this.f19001a;
    }

    public final String mo762b() {
        return this.f19003c;
    }

    public final String mo763c() {
        return this.f19004d;
    }

    public final String mo764d() {
        return this.f19006f;
    }

    public final String mo765e() {
        return this.f19007g;
    }

    public final String mo766f() {
        return this.f19008h;
    }

    public final String mo767g() {
        return this.f19009i;
    }

    public final String mo768h() {
        return this.f19010j;
    }

    public final boolean mo769i() {
        return this.f19011k;
    }

    public final String mo761a(@FormatType String str) {
        return SimpleMailingAddressFormatter.m18984a(this, str);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f19001a);
        parcel.writeString(this.f19002b);
        parcel.writeString(this.f19003c);
        parcel.writeString(this.f19004d);
        parcel.writeString(this.f19005e);
        parcel.writeString(this.f19006f);
        parcel.writeString(this.f19007g);
        parcel.writeString(this.f19008h);
        parcel.writeString(this.f19009i);
        parcel.writeString(this.f19010j);
        ParcelUtil.a(parcel, this.f19011k);
    }

    public int describeContents() {
        return 0;
    }
}
