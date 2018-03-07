package com.facebook.api.ufiservices.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLComment;

/* compiled from: android_place_creation */
public class EditCommentParams implements Parcelable {
    public static final Creator<EditCommentParams> CREATOR = new C09881();
    public final String f10294a;
    public final String f10295b;
    public final String f10296c;
    public final String f10297d;
    public final GraphQLComment f10298e;

    /* compiled from: android_place_creation */
    final class C09881 implements Creator<EditCommentParams> {
        C09881() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EditCommentParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new EditCommentParams[i];
        }
    }

    public EditCommentParams(String str, String str2, String str3, String str4, GraphQLComment graphQLComment) {
        this.f10294a = str;
        this.f10295b = str2;
        this.f10296c = str3;
        this.f10297d = str4;
        this.f10298e = graphQLComment;
    }

    public EditCommentParams(Parcel parcel) {
        this.f10294a = parcel.readString();
        this.f10295b = parcel.readString();
        this.f10296c = parcel.readString();
        this.f10297d = parcel.readString();
        this.f10298e = (GraphQLComment) FlatBufferModelHelper.m4278a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10294a);
        parcel.writeString(this.f10295b);
        parcel.writeString(this.f10296c);
        parcel.writeString(this.f10297d);
        FlatBufferModelHelper.m4288a(parcel, this.f10298e);
    }
}
