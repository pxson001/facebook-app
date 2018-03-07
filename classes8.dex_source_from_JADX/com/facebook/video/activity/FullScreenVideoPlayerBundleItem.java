package com.facebook.video.activity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLStory;
import javax.annotation.Nullable;

@Deprecated
/* compiled from: mAttachments */
public class FullScreenVideoPlayerBundleItem implements Parcelable {
    public static final Creator<FullScreenVideoPlayerBundleItem> CREATOR = new C10001();
    public final Uri f9570a;
    public final int f9571b;
    public final GraphQLImage f9572c;
    public final String f9573d;
    @Nullable
    public final GraphQLStory f9574e;

    /* compiled from: mAttachments */
    final class C10001 implements Creator<FullScreenVideoPlayerBundleItem> {
        C10001() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FullScreenVideoPlayerBundleItem((Uri) parcel.readParcelable(Uri.class.getClassLoader()), parcel.readInt(), (GraphQLImage) FlatBufferModelHelper.a(parcel), parcel.readString(), (GraphQLStory) FlatBufferModelHelper.a(parcel));
        }

        public final Object[] newArray(int i) {
            return new FullScreenVideoPlayerBundleItem[i];
        }
    }

    public FullScreenVideoPlayerBundleItem(Uri uri, int i, GraphQLImage graphQLImage, String str, GraphQLStory graphQLStory) {
        this.f9570a = uri;
        this.f9571b = i;
        this.f9572c = graphQLImage;
        this.f9573d = str;
        this.f9574e = graphQLStory;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f9570a, i);
        parcel.writeInt(this.f9571b);
        FlatBufferModelHelper.a(parcel, this.f9572c);
        parcel.writeString(this.f9573d);
        FlatBufferModelHelper.a(parcel, this.f9574e);
    }
}
