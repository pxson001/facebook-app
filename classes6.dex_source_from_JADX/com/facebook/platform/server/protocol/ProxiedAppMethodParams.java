package com.facebook.platform.server.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: field_matches */
public class ProxiedAppMethodParams implements Parcelable {
    public static final Creator<ProxiedAppMethodParams> CREATOR = new C09891();
    public final String f14909a;
    public final String f14910b;
    public final String f14911c;

    /* compiled from: field_matches */
    final class C09891 implements Creator<ProxiedAppMethodParams> {
        C09891() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ProxiedAppMethodParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ProxiedAppMethodParams[i];
        }
    }

    public ProxiedAppMethodParams(String str, String str2, String str3) {
        this.f14909a = str;
        this.f14910b = str2;
        this.f14911c = str3;
    }

    public ProxiedAppMethodParams(Parcel parcel) {
        this.f14909a = parcel.readString();
        this.f14910b = parcel.readString();
        this.f14911c = parcel.readString();
    }

    public void mo1180a(List<NameValuePair> list) {
        list.add(new BasicNameValuePair("proxied_app_id", this.f14909a));
        if (this.f14910b != null) {
            list.add(new BasicNameValuePair("proxied_app_name", this.f14910b));
        }
        list.add(new BasicNameValuePair("android_key_hash", this.f14911c));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14909a);
        parcel.writeString(this.f14910b);
        parcel.writeString(this.f14911c);
    }
}
