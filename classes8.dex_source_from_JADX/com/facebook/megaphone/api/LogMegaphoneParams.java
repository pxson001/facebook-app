package com.facebook.megaphone.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: typeahead_sid */
public class LogMegaphoneParams implements Parcelable {
    public static final Creator<LogMegaphoneParams> CREATOR = new C01251();
    public final String f1278a;
    public final String f1279b;
    public final Map<String, String> f1280c;

    /* compiled from: typeahead_sid */
    final class C01251 implements Creator<LogMegaphoneParams> {
        C01251() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LogMegaphoneParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new LogMegaphoneParams[i];
        }
    }

    public LogMegaphoneParams(String str, String str2, Map<String, String> map) {
        this.f1278a = str;
        this.f1279b = str2;
        this.f1280c = map;
    }

    public LogMegaphoneParams(Parcel parcel) {
        this.f1278a = parcel.readString();
        this.f1279b = parcel.readString();
        this.f1280c = (Map) parcel.readSerializable();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1278a);
        parcel.writeString(this.f1279b);
        parcel.writeSerializable(Maps.a(this.f1280c));
    }
}
