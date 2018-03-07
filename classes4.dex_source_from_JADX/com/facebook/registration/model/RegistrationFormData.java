package com.facebook.registration.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.growth.model.ContactpointType;
import com.facebook.growth.model.Gender;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: extra_page_name */
public class RegistrationFormData implements Parcelable {
    public static final Creator<RegistrationFormData> CREATOR = new C05891();
    public boolean f12472a;
    public boolean f12473b;
    public String f12474c;
    public String f12475d;
    public ContactpointType f12476e;
    public String f12477f;
    public String f12478g;
    public String f12479h;
    public String f12480i;
    public String f12481j;
    public int f12482k;
    public int f12483l;
    public int f12484m;
    public String f12485n;
    public Gender f12486o;
    public boolean f12487p;
    public String f12488q;

    /* compiled from: extra_page_name */
    final class C05891 implements Creator<RegistrationFormData> {
        C05891() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new RegistrationFormData(parcel);
        }

        public final Object[] newArray(int i) {
            return new RegistrationFormData[i];
        }
    }

    public RegistrationFormData() {
        this.f12472a = false;
        this.f12473b = false;
        this.f12474c = "";
        this.f12475d = "";
        this.f12476e = ContactpointType.UNKNOWN;
        this.f12477f = "";
        this.f12478g = "";
        this.f12479h = "";
        this.f12480i = "";
        this.f12481j = "";
        this.f12482k = 0;
        this.f12483l = 0;
        this.f12484m = 0;
        this.f12485n = "";
        this.f12486o = null;
        this.f12487p = false;
        this.f12488q = "";
    }

    public RegistrationFormData(Parcel parcel) {
        this.f12472a = ParcelUtil.a(parcel);
        this.f12473b = ParcelUtil.a(parcel);
        this.f12474c = parcel.readString();
        this.f12475d = parcel.readString();
        this.f12476e = ContactpointType.valueOf(parcel.readString());
        this.f12477f = parcel.readString();
        this.f12478g = parcel.readString();
        this.f12479h = parcel.readString();
        this.f12480i = parcel.readString();
        this.f12481j = parcel.readString();
        this.f12482k = parcel.readInt();
        this.f12483l = parcel.readInt();
        this.f12484m = parcel.readInt();
        this.f12485n = parcel.readString();
        this.f12486o = (Gender) ParcelUtil.c(parcel, Gender.class);
        this.f12487p = ParcelUtil.a(parcel);
        this.f12488q = parcel.readString();
    }

    public final void m13229c(String str) {
        this.f12477f = str;
    }

    public final void m13228a(ContactpointType contactpointType) {
        if (contactpointType == null) {
            contactpointType = ContactpointType.UNKNOWN;
        }
        this.f12476e = contactpointType;
    }

    public final void m13230e(String str) {
        this.f12479h = str;
    }

    public final void m13227a(int i, int i2, int i3) {
        this.f12482k = i;
        this.f12483l = i2;
        this.f12484m = i3;
    }

    public final Date m13231k() {
        if (this.f12482k == 0 && this.f12483l == 0 && this.f12484m == 0) {
            return null;
        }
        return new GregorianCalendar(this.f12482k, this.f12483l, this.f12484m).getTime();
    }

    public final List<NameValuePair> m13232r() {
        List<NameValuePair> arrayList = new ArrayList();
        if (this.f12476e == ContactpointType.PHONE && !StringUtil.c(this.f12479h)) {
            arrayList.add(new BasicNameValuePair("phone", this.f12479h));
        }
        if (this.f12476e == ContactpointType.EMAIL && !StringUtil.c(this.f12481j)) {
            arrayList.add(new BasicNameValuePair("email", this.f12481j));
        }
        if (!(StringUtil.c(this.f12474c) && StringUtil.c(this.f12475d))) {
            arrayList.add(new BasicNameValuePair("firstname", this.f12474c));
            arrayList.add(new BasicNameValuePair("lastname", this.f12475d));
        }
        if (this.f12486o != null) {
            String str;
            switch (2.a[this.f12486o.ordinal()]) {
                case 1:
                    str = "M";
                    break;
                case 2:
                    str = "F";
                    break;
                default:
                    str = "U";
                    break;
            }
            arrayList.add(new BasicNameValuePair("gender", str));
        }
        if (!StringUtil.a(this.f12485n)) {
            arrayList.add(new BasicNameValuePair("password", this.f12485n));
        }
        if (m13231k() != null) {
            arrayList.add(new BasicNameValuePair("birthday", new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(m13231k())));
        }
        return arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f12472a);
        ParcelUtil.a(parcel, this.f12473b);
        parcel.writeString(this.f12474c);
        parcel.writeString(this.f12475d);
        parcel.writeString(this.f12476e.name());
        parcel.writeString(this.f12477f);
        parcel.writeString(this.f12478g);
        parcel.writeString(this.f12479h);
        parcel.writeString(this.f12480i);
        parcel.writeString(this.f12481j);
        parcel.writeInt(this.f12482k);
        parcel.writeInt(this.f12483l);
        parcel.writeInt(this.f12484m);
        parcel.writeString(this.f12485n);
        ParcelUtil.a(parcel, this.f12486o);
        ParcelUtil.a(parcel, this.f12487p);
        parcel.writeString(this.f12488q);
    }
}
