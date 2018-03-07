package com.facebook.photos.pandora.common.data.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;

/* compiled from: composer_rating_label_selected */
public class PandoraAlbumStoryModel extends PandoraDataModel {
    public static final Creator<PandoraAlbumStoryModel> CREATOR = new C18471();
    public final ImmutableList<GraphQLStory> f17368a;

    /* compiled from: composer_rating_label_selected */
    final class C18471 implements Creator<PandoraAlbumStoryModel> {
        C18471() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PandoraAlbumStoryModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new PandoraAlbumStoryModel[i];
        }
    }

    public PandoraAlbumStoryModel(ImmutableList<GraphQLStory> immutableList) {
        this.f17368a = immutableList;
    }

    public PandoraAlbumStoryModel(Parcel parcel) {
        this.f17368a = ImmutableListHelper.a(parcel.readArrayList(GraphQLStory.class.getClassLoader()));
    }

    public final PandoraDataModelType mo1041a() {
        return PandoraDataModelType.ALBUM_POST_SECTION;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f17368a);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PandoraAlbumStoryModel)) {
            return false;
        }
        return Objects.equal(((PandoraAlbumStoryModel) obj).f17368a, this.f17368a);
    }
}
