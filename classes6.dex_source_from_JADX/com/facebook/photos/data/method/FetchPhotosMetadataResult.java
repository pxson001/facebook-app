package com.facebook.photos.data.method;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.photos.data.model.FacebookPhoto;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: i18n_post_search_user_expansion */
public class FetchPhotosMetadataResult implements Parcelable {
    public static final Creator<FetchPhotosMetadataResult> CREATOR = new C08381();
    public final List<GraphQLPhoto> f12945a;

    /* compiled from: i18n_post_search_user_expansion */
    final class C08381 implements Creator<FetchPhotosMetadataResult> {
        C08381() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchPhotosMetadataResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchPhotosMetadataResult[i];
        }
    }

    public FetchPhotosMetadataResult(List<GraphQLPhoto> list) {
        this.f12945a = list;
    }

    public FetchPhotosMetadataResult(Parcel parcel) {
        this.f12945a = Lists.a();
        parcel.readList(this.f12945a, FacebookPhoto.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f12945a);
    }
}
