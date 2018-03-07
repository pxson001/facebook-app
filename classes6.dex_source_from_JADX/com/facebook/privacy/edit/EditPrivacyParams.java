package com.facebook.privacy.edit;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPrivacyOption;

/* compiled from: fetch-image-info- */
public class EditPrivacyParams implements Parcelable {
    public static final Creator<EditPrivacyParams> CREATOR = new C10141();
    public String f15032a;
    public String f15033b;
    public String f15034c;
    public String f15035d;
    public String f15036e;
    public Type f15037f;
    public GraphQLPrivacyOption f15038g;
    public String f15039h;

    /* compiled from: fetch-image-info- */
    final class C10141 implements Creator<EditPrivacyParams> {
        C10141() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EditPrivacyParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new EditPrivacyParams[i];
        }
    }

    /* compiled from: fetch-image-info- */
    public final class Builder {
        public final Type f15024a;
        public String f15025b;
        public String f15026c;
        public String f15027d;
        public String f15028e;
        public String f15029f;
        public GraphQLPrivacyOption f15030g;
        public String f15031h;

        public Builder(Type type) {
            this.f15024a = type;
        }

        public final EditPrivacyParams m22607a() {
            return new EditPrivacyParams(this);
        }
    }

    /* compiled from: fetch-image-info- */
    public enum Type {
        EGO_PAGE_REVIEW,
        STORY,
        PAGE_REVIEW,
        PROFILE_INFO,
        ALBUM
    }

    EditPrivacyParams() {
        this.f15032a = null;
        this.f15033b = null;
        this.f15034c = null;
        this.f15035d = null;
        this.f15036e = null;
        this.f15037f = null;
        this.f15038g = null;
        this.f15039h = null;
    }

    EditPrivacyParams(Builder builder) {
        this.f15032a = builder.f15025b;
        this.f15033b = builder.f15026c;
        this.f15034c = builder.f15027d;
        this.f15035d = builder.f15028e;
        this.f15036e = builder.f15029f;
        this.f15037f = builder.f15024a;
        this.f15038g = builder.f15030g;
        this.f15039h = builder.f15031h;
    }

    public EditPrivacyParams(Parcel parcel) {
        this.f15032a = parcel.readString();
        this.f15033b = parcel.readString();
        this.f15034c = parcel.readString();
        this.f15035d = parcel.readString();
        this.f15036e = parcel.readString();
        this.f15037f = Type.valueOf(parcel.readString());
        this.f15038g = (GraphQLPrivacyOption) FlatBufferModelHelper.a(parcel);
        this.f15039h = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f15032a);
        parcel.writeString(this.f15033b);
        parcel.writeString(this.f15034c);
        parcel.writeString(this.f15035d);
        parcel.writeString(this.f15036e);
        parcel.writeString(this.f15037f.name());
        FlatBufferModelHelper.a(parcel, this.f15038g);
        parcel.writeString(this.f15039h);
    }
}
