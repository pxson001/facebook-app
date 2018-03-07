package com.facebook.payments.contactinfo.form;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.payments.contactinfo.model.ContactInfo;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: c4e5181164b61149ab0cd64d39fa3011 */
public class ContactInfoCommonFormParams implements Parcelable {
    public static final Creator<ContactInfoCommonFormParams> CREATOR = new C21641();
    public final ContactInfoFormStyle f18641a;
    @Nullable
    public final ContactInfo f18642b;
    public final int f18643c;

    /* compiled from: c4e5181164b61149ab0cd64d39fa3011 */
    final class C21641 implements Creator<ContactInfoCommonFormParams> {
        C21641() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ContactInfoCommonFormParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ContactInfoCommonFormParams[i];
        }
    }

    public ContactInfoCommonFormParams(ContactInfoCommonFormParamsBuilder contactInfoCommonFormParamsBuilder) {
        this.f18641a = (ContactInfoFormStyle) Preconditions.checkNotNull(contactInfoCommonFormParamsBuilder.f18644a);
        this.f18642b = contactInfoCommonFormParamsBuilder.f18645b;
        this.f18643c = contactInfoCommonFormParamsBuilder.f18646c;
    }

    public ContactInfoCommonFormParams(Parcel parcel) {
        this.f18641a = (ContactInfoFormStyle) ParcelUtil.c(parcel, ContactInfoFormStyle.class);
        this.f18642b = (ContactInfo) parcel.readParcelable(ContactInfo.class.getClassLoader());
        this.f18643c = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f18641a);
        parcel.writeParcelable(this.f18642b, i);
        parcel.writeInt(this.f18643c);
    }
}
