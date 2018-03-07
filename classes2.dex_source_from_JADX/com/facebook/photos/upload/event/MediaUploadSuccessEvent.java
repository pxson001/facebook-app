package com.facebook.photos.upload.event;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.photos.upload.event.BaseMediaUploadEvent.Status;
import com.facebook.photos.upload.operation.UploadOperation;
import javax.annotation.Nullable;

/* compiled from: topic_name */
public class MediaUploadSuccessEvent extends BaseMediaUploadEvent implements Parcelable {
    public static final Creator<MediaUploadSuccessEvent> CREATOR = new 1();
    public final String f2402a;
    @Nullable
    private final Bundle f2403b;
    @Nullable
    public final GraphQLStory f2404c;

    public MediaUploadSuccessEvent(UploadOperation uploadOperation, String str, @Nullable Bundle bundle, @Nullable GraphQLStory graphQLStory) {
        super(uploadOperation, Status.UPLOAD_SUCCESS, -1);
        this.f2402a = str;
        this.f2403b = bundle;
        this.f2404c = graphQLStory;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2399a, i);
        parcel.writeString(this.f2400b.toString());
        parcel.writeInt(this.f2401c);
        parcel.writeString(this.f2402a);
        parcel.writeBundle(this.f2403b);
        FlatBufferModelHelper.a(parcel, this.f2404c);
    }

    public int describeContents() {
        return 0;
    }

    public MediaUploadSuccessEvent(Parcel parcel) {
        super((UploadOperation) parcel.readParcelable(UploadOperation.class.getClassLoader()), Status.valueOf(parcel.readString()), parcel.readInt());
        this.f2402a = parcel.readString();
        this.f2403b = parcel.readBundle();
        this.f2404c = (GraphQLStory) FlatBufferModelHelper.a(parcel);
    }
}
