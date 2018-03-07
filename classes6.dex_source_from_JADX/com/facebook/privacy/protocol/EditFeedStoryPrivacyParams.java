package com.facebook.privacy.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.google.common.base.Preconditions;

/* compiled from: sticker_store_pack_opened */
public class EditFeedStoryPrivacyParams implements Parcelable {
    public static final Creator<EditFeedStoryPrivacyParams> CREATOR = new C02291();
    public final String f4123a;
    public final String f4124b;
    public final String f4125c;
    public final GraphQLPrivacyOption f4126d;

    /* compiled from: sticker_store_pack_opened */
    final class C02291 implements Creator<EditFeedStoryPrivacyParams> {
        C02291() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EditFeedStoryPrivacyParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new EditFeedStoryPrivacyParams[i];
        }
    }

    public EditFeedStoryPrivacyParams(String str, String str2, String str3, GraphQLPrivacyOption graphQLPrivacyOption) {
        this.f4123a = str;
        this.f4124b = (String) Preconditions.checkNotNull(str2);
        this.f4125c = str3;
        this.f4126d = (GraphQLPrivacyOption) Preconditions.checkNotNull(graphQLPrivacyOption);
    }

    public EditFeedStoryPrivacyParams(Parcel parcel) {
        this.f4123a = parcel.readString();
        this.f4124b = parcel.readString();
        this.f4125c = parcel.readString();
        this.f4126d = (GraphQLPrivacyOption) FlatBufferModelHelper.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4123a);
        parcel.writeString(this.f4124b);
        parcel.writeString(this.f4125c);
        FlatBufferModelHelper.a(parcel, this.f4126d);
    }
}
