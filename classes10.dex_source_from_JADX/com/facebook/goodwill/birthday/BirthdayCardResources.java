package com.facebook.goodwill.birthday;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLTextWithEntities;

/* compiled from: WEBVIEW_BANNER_50 */
public class BirthdayCardResources implements Parcelable {
    public static final Creator<BirthdayCardResources> CREATOR = new C29961();
    public final String f21043a;
    public final GraphQLTextWithEntities f21044b;
    public final String f21045c;
    public final int f21046d;
    public final int f21047e;
    public final String f21048f;
    public final String f21049g;

    /* compiled from: WEBVIEW_BANNER_50 */
    final class C29961 implements Creator<BirthdayCardResources> {
        C29961() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new BirthdayCardResources(parcel);
        }

        public final Object[] newArray(int i) {
            return new BirthdayCardResources[i];
        }
    }

    public BirthdayCardResources(String str, GraphQLTextWithEntities graphQLTextWithEntities, String str2, int i, int i2, String str3, String str4) {
        this.f21043a = str;
        this.f21044b = graphQLTextWithEntities;
        this.f21045c = str2;
        this.f21046d = i;
        this.f21047e = i2;
        this.f21048f = str3;
        this.f21049g = str4;
    }

    public BirthdayCardResources(Parcel parcel) {
        this.f21043a = parcel.readString();
        this.f21044b = (GraphQLTextWithEntities) FlatBufferModelHelper.a(parcel);
        this.f21045c = parcel.readString();
        this.f21046d = parcel.readInt();
        this.f21047e = parcel.readInt();
        this.f21048f = parcel.readString();
        this.f21049g = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f21043a);
        FlatBufferModelHelper.a(parcel, this.f21044b);
        parcel.writeString(this.f21045c);
        parcel.writeInt(this.f21046d);
        parcel.writeInt(this.f21047e);
        parcel.writeString(this.f21048f);
        parcel.writeString(this.f21049g);
    }
}
