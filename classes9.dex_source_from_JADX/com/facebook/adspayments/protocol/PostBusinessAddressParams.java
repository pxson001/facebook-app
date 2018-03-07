package com.facebook.adspayments.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.adspayments.model.BusinessAddressDetails;
import com.facebook.common.locale.Country;
import com.facebook.common.parcels.ParcelUtil;
import com.google.common.base.Strings;
import java.util.List;
import javax.annotation.Nullable;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: URLQueryBuilder */
public class PostBusinessAddressParams implements Parcelable {
    public static final Creator<PostBusinessAddressParams> CREATOR = new C28651();
    public final String f23707a;
    public final String f23708b;
    public final BusinessAddressDetails f23709c;
    public final String f23710d;
    public final String f23711e;
    public final BusinessAddressDetails f23712f;
    public final String f23713g;
    public final boolean f23714h;
    public final boolean f23715i;
    public final boolean f23716j;

    /* compiled from: URLQueryBuilder */
    final class C28651 implements Creator<PostBusinessAddressParams> {
        C28651() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PostBusinessAddressParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PostBusinessAddressParams[i];
        }
    }

    public PostBusinessAddressParams(String str, Country country) {
        this(str, null, new BusinessAddressDetails(null, null, null, null, null, country.b()), null);
    }

    public PostBusinessAddressParams(String str, String str2, BusinessAddressDetails businessAddressDetails, String str3) {
        this(str, str2, businessAddressDetails, str3, false, false, null, null, null, false);
    }

    public PostBusinessAddressParams(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), (BusinessAddressDetails) ParcelUtil.b(parcel, BusinessAddressDetails.class), parcel.readString());
    }

    public PostBusinessAddressParams(String str, String str2, BusinessAddressDetails businessAddressDetails, String str3, boolean z, boolean z2) {
        this(str, str2, businessAddressDetails, str3, z, z2, null, null, null, false);
    }

    public PostBusinessAddressParams(String str, String str2, BusinessAddressDetails businessAddressDetails, String str3, boolean z, boolean z2, String str4, BusinessAddressDetails businessAddressDetails2, String str5, boolean z3) {
        this.f23707a = str;
        this.f23708b = str2;
        this.f23709c = businessAddressDetails;
        this.f23710d = str3;
        this.f23711e = str4;
        this.f23712f = businessAddressDetails2;
        this.f23713g = str5;
        this.f23714h = z;
        this.f23715i = z2;
        this.f23716j = z3;
    }

    public int describeContents() {
        return 0;
    }

    public static void m25743a(List<NameValuePair> list, String str, @Nullable String str2) {
        if (!Strings.isNullOrEmpty(str2)) {
            list.add(new BasicNameValuePair(str, str2));
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f23707a);
        parcel.writeString(this.f23708b);
        parcel.writeParcelable(this.f23709c, i);
        parcel.writeString(this.f23710d);
    }
}
