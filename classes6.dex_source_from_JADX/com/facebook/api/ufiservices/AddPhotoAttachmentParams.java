package com.facebook.api.ufiservices;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.ipc.media.MediaItem;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: promptType */
public class AddPhotoAttachmentParams implements Parcelable {
    public static final Creator<AddPhotoAttachmentParams> CREATOR = new C04211();
    public final MediaItem f7157a;
    public final String f7158b;
    @Nullable
    public final ViewerContext f7159c;

    /* compiled from: promptType */
    final class C04211 implements Creator<AddPhotoAttachmentParams> {
        C04211() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AddPhotoAttachmentParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new AddPhotoAttachmentParams[i];
        }
    }

    /* compiled from: promptType */
    public class Builder {
        public MediaItem f7154a;
        public String f7155b;
        public ViewerContext f7156c;

        public final AddPhotoAttachmentParams m10321a() {
            Preconditions.checkNotNull(this.f7154a);
            Preconditions.checkNotNull(this.f7155b);
            return new AddPhotoAttachmentParams(this);
        }
    }

    protected AddPhotoAttachmentParams(Parcel parcel) {
        this.f7157a = (MediaItem) parcel.readParcelable(AddPhotoAttachmentParams.class.getClassLoader());
        this.f7158b = parcel.readString();
        this.f7159c = (ViewerContext) parcel.readParcelable(AddPhotoAttachmentParams.class.getClassLoader());
    }

    protected AddPhotoAttachmentParams(Builder builder) {
        this.f7157a = builder.f7154a;
        this.f7158b = builder.f7155b;
        this.f7159c = builder.f7156c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f7157a, i);
        parcel.writeString(this.f7158b);
        parcel.writeParcelable(this.f7159c, i);
    }

    public static Builder m10322a() {
        return new Builder();
    }
}
