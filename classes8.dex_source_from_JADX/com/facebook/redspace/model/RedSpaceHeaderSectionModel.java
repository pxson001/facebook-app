package com.facebook.redspace.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.redspace.model.RedSpaceSharedActivities.C22761;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceStoriesQueryModel.RedspaceModel.ActivitiesModel.NodesModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceVisitsQueryModel.RedspaceModel.VisitsModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: USER_CENTERED */
public class RedSpaceHeaderSectionModel implements Parcelable {
    public static final Creator<RedSpaceHeaderSectionModel> CREATOR = new C22751();
    public String f21343a;
    public VisitsModel f21344b;
    public RedSpaceSharedActivities f21345c;
    private ImmutableList<NodesModel> f21346d;

    /* compiled from: USER_CENTERED */
    final class C22751 implements Creator<RedSpaceHeaderSectionModel> {
        C22751() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new RedSpaceHeaderSectionModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new RedSpaceHeaderSectionModel[i];
        }
    }

    public RedSpaceHeaderSectionModel() {
        this.f21345c = new RedSpaceSharedActivities();
    }

    public final void m24960a(ImmutableList<NodesModel> immutableList) {
        this.f21346d = immutableList;
        RedSpaceSharedActivities redSpaceSharedActivities = this.f21345c;
        Builder builder = ImmutableList.builder();
        for (NodesModel nodesModel : immutableList) {
            if (nodesModel.a() != null) {
                switch (C22761.f21347a[nodesModel.a().ordinal()]) {
                    case 1:
                        builder.c(redSpaceSharedActivities.f21349b);
                        break;
                    case 2:
                        builder.c(new LocationActivitySharing(nodesModel));
                        break;
                    case 3:
                        builder.c(new GenericActivitySharing(nodesModel));
                        break;
                    default:
                        break;
                }
            }
        }
        redSpaceSharedActivities.f21348a = builder.b();
    }

    public RedSpaceHeaderSectionModel(Parcel parcel) {
        this();
        this.f21343a = parcel.readString();
        m24960a(ImmutableList.copyOf(FlatBufferModelHelper.b(parcel)));
        this.f21344b = (VisitsModel) FlatBufferModelHelper.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f21343a);
        FlatBufferModelHelper.a(parcel, this.f21346d);
        FlatBufferModelHelper.a(parcel, this.f21344b);
    }
}
