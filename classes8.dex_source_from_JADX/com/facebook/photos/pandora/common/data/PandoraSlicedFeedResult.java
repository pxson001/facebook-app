package com.facebook.photos.pandora.common.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.photos.pandora.common.data.model.PandoraDataModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: composer_submit_button_tapped_with_short_review */
public class PandoraSlicedFeedResult implements Parcelable {
    public static final Creator<PandoraSlicedFeedResult> CREATOR = new C18451();
    @Nullable
    public final GraphQLPageInfo f17360a;
    public final ImmutableList<PandoraDataModel> f17361b;

    /* compiled from: composer_submit_button_tapped_with_short_review */
    final class C18451 implements Creator<PandoraSlicedFeedResult> {
        C18451() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PandoraSlicedFeedResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new PandoraSlicedFeedResult[i];
        }
    }

    public PandoraSlicedFeedResult(@Nullable GraphQLPageInfo graphQLPageInfo, ImmutableList<PandoraDataModel> immutableList) {
        this.f17360a = graphQLPageInfo;
        this.f17361b = immutableList;
    }

    public PandoraSlicedFeedResult(Parcel parcel) {
        this.f17360a = (GraphQLPageInfo) FlatBufferModelHelper.a(parcel);
        this.f17361b = ImmutableListHelper.a(parcel.readArrayList(PandoraDataModel.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.a(parcel, this.f17360a);
        parcel.writeList(this.f17361b);
    }
}
