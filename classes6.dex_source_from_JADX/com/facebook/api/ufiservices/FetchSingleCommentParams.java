package com.facebook.api.ufiservices;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLComment;
import javax.annotation.Nullable;

/* compiled from: promos */
public class FetchSingleCommentParams implements Parcelable {
    public static final Creator<FetchSingleCommentParams> CREATOR = new C04221();
    public String f7178a;
    public String f7179b;
    public int f7180c;
    public String f7181d;
    public String f7182e;
    public boolean f7183f;
    public String f7184g;
    public GraphQLComment f7185h;
    @Nullable
    public GraphQLComment f7186i;
    public String f7187j;
    public boolean f7188k;

    /* compiled from: promos */
    final class C04221 implements Creator<FetchSingleCommentParams> {
        C04221() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchSingleCommentParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchSingleCommentParams[i];
        }
    }

    /* compiled from: promos */
    public class Builder {
        public String f7167a;
        public String f7168b;
        public int f7169c = 25;
        public String f7170d;
        public String f7171e;
        public boolean f7172f;
        public String f7173g;
        public GraphQLComment f7174h;
        @Nullable
        public GraphQLComment f7175i;
        public String f7176j;
        public boolean f7177k;

        public final FetchSingleCommentParams m10340a() {
            return new FetchSingleCommentParams(this);
        }
    }

    public FetchSingleCommentParams(Builder builder) {
        this.f7178a = builder.f7167a;
        this.f7179b = builder.f7168b;
        this.f7180c = builder.f7169c;
        this.f7181d = builder.f7170d;
        this.f7182e = builder.f7171e;
        this.f7183f = builder.f7172f;
        this.f7184g = builder.f7173g;
        this.f7185h = builder.f7174h;
        this.f7186i = builder.f7175i;
        this.f7187j = builder.f7176j;
        this.f7188k = builder.f7177k;
    }

    public FetchSingleCommentParams(Parcel parcel) {
        this.f7178a = parcel.readString();
        this.f7179b = parcel.readString();
        this.f7180c = parcel.readInt();
        this.f7181d = parcel.readString();
        this.f7182e = parcel.readString();
        this.f7183f = parcel.readInt() != 0;
        this.f7184g = parcel.readString();
        this.f7185h = (GraphQLComment) FlatBufferModelHelper.a(parcel);
        this.f7186i = (GraphQLComment) FlatBufferModelHelper.a(parcel);
        this.f7187j = parcel.readString();
        this.f7188k = ParcelUtil.a(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7178a);
        parcel.writeString(this.f7179b);
        parcel.writeInt(this.f7180c);
        parcel.writeString(this.f7181d);
        parcel.writeString(this.f7182e);
        parcel.writeInt(this.f7183f ? 1 : 0);
        parcel.writeString(this.f7184g);
        FlatBufferModelHelper.a(parcel, this.f7185h);
        FlatBufferModelHelper.a(parcel, this.f7186i);
        parcel.writeString(this.f7187j);
        ParcelUtil.a(parcel, this.f7188k);
    }

    public int describeContents() {
        return 0;
    }

    public final String m10341l() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Comment Id: ").append(this.f7178a).append("\n");
        stringBuilder.append("Parent Legacy Api Post Id: ").append(this.f7179b).append("\n");
        stringBuilder.append("Max Comments Items: ").append(this.f7180c).append("\n");
        stringBuilder.append("Parent Story Id: ").append(this.f7181d).append("\n");
        stringBuilder.append("Parent Story Cache Id: ").append(this.f7182e).append("\n");
        stringBuilder.append("Include Permalink Title: ").append(this.f7183f).append("\n");
        stringBuilder.append("Reply Comment Id: ").append(this.f7184g).append("\n");
        stringBuilder.append("Include Comments Disabled Fields:").append(this.f7188k).append("\n");
        return stringBuilder.toString();
    }
}
