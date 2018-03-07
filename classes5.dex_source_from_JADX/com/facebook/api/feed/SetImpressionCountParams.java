package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.Lists;
import java.util.ArrayList;

/* compiled from: attachment_property_type */
public class SetImpressionCountParams implements Parcelable {
    public static final Creator<SetImpressionCountParams> CREATOR = new C09491();
    public final ArrayList<ImpressionCount> f8742a;

    /* compiled from: attachment_property_type */
    final class C09491 implements Creator<SetImpressionCountParams> {
        C09491() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SetImpressionCountParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SetImpressionCountParams[i];
        }
    }

    /* compiled from: attachment_property_type */
    public class ImpressionCount implements Parcelable {
        public static final Creator<ImpressionCount> CREATOR = new C09501();
        public final String f8740a;
        public final int f8741b;

        /* compiled from: attachment_property_type */
        final class C09501 implements Creator<ImpressionCount> {
            C09501() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new ImpressionCount(parcel);
            }

            public final Object[] newArray(int i) {
                return new ImpressionCount[i];
            }
        }

        public ImpressionCount(Parcel parcel) {
            this.f8740a = parcel.readString();
            this.f8741b = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f8740a);
            parcel.writeInt(this.f8741b);
        }

        public int describeContents() {
            return 0;
        }
    }

    public SetImpressionCountParams() {
        this.f8742a = Lists.a();
    }

    public SetImpressionCountParams(Parcel parcel) {
        this.f8742a = parcel.readArrayList(ImpressionCount.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f8742a);
    }
}
