package com.facebook.photos.upload.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.photos.upload.event.BaseMediaUploadEvent.Status;
import com.facebook.photos.upload.operation.UploadOperation;
import javax.annotation.Nullable;

/* compiled from: topic_feeds_customization */
public class MediaServerProcessingEvent extends BaseMediaUploadEvent implements Parcelable {
    public static final Creator<MediaServerProcessingEvent> CREATOR = new 1();
    public final String f2407a;
    @Nullable
    public final GraphQLStory f2408b;

    public MediaServerProcessingEvent(UploadOperation uploadOperation, String str, boolean z, @Nullable GraphQLStory graphQLStory) {
        super(uploadOperation, z ? Status.MEDIA_PROCESSING_SUCCESS : Status.MEDIA_PROCESSING_FAILED, -1);
        this.f2407a = str;
        this.f2408b = graphQLStory;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2399a, i);
        parcel.writeString(this.f2400b.toString());
        parcel.writeInt(this.f2401c);
        parcel.writeString(this.f2407a);
        FlatBufferModelHelper.a(parcel, this.f2408b);
    }

    public int describeContents() {
        return 0;
    }

    public MediaServerProcessingEvent(Parcel parcel) {
        super((UploadOperation) parcel.readParcelable(UploadOperation.class.getClassLoader()), Status.valueOf(parcel.readString()), parcel.readInt());
        this.f2407a = parcel.readString();
        this.f2408b = (GraphQLStory) FlatBufferModelHelper.a(parcel);
    }
}
