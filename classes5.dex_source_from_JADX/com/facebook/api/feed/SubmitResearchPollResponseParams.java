package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: attachment_meta */
public class SubmitResearchPollResponseParams implements Parcelable {
    public static final Creator<SubmitResearchPollResponseParams> CREATOR = new C09531();
    public final String f8749a;
    public final String f8750b;
    public final Boolean f8751c;
    public final String f8752d;
    public final List<String> f8753e;

    /* compiled from: attachment_meta */
    final class C09531 implements Creator<SubmitResearchPollResponseParams> {
        C09531() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SubmitResearchPollResponseParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SubmitResearchPollResponseParams[i];
        }
    }

    public SubmitResearchPollResponseParams(String str, String str2, Boolean bool, String str3, List<String> list) {
        this.f8749a = str;
        this.f8750b = str2;
        this.f8751c = bool;
        this.f8752d = str3;
        this.f8753e = list;
    }

    public SubmitResearchPollResponseParams(Parcel parcel) {
        this.f8749a = parcel.readString();
        this.f8750b = parcel.readString();
        this.f8751c = Boolean.valueOf(parcel.readInt() != 0);
        this.f8752d = parcel.readString();
        this.f8753e = Lists.a();
        parcel.readStringList(this.f8753e);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8749a);
        parcel.writeString(this.f8750b);
        parcel.writeInt(this.f8751c.booleanValue() ? 1 : 0);
        parcel.writeString(this.f8752d);
        parcel.writeStringList(this.f8753e);
    }

    public int describeContents() {
        return 0;
    }
}
