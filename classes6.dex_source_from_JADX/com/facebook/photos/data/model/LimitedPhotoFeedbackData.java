package com.facebook.photos.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: horizontal_alignment */
public final class LimitedPhotoFeedbackData implements Parcelable {
    public static final Creator<LimitedPhotoFeedbackData> CREATOR = new C08421();
    @JsonProperty("can_viewer_comment")
    public final boolean canViewerComment;
    @JsonProperty("can_viewer_like")
    public final boolean canViewerLike;
    @JsonProperty("comments")
    public final CountData commentCount;
    @JsonProperty("does_viewer_like")
    public final boolean doesViewerLike;
    @JsonProperty("id")
    public final String id;
    @JsonProperty("likers")
    public final CountData likeCount;

    /* compiled from: horizontal_alignment */
    final class C08421 implements Creator<LimitedPhotoFeedbackData> {
        C08421() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LimitedPhotoFeedbackData(parcel);
        }

        public final Object[] newArray(int i) {
            return new LimitedPhotoFeedbackData[i];
        }
    }

    /* compiled from: horizontal_alignment */
    public class CountData {
        @JsonProperty("count")
        public final long count;

        private CountData() {
            this.count = 0;
        }

        public CountData(long j) {
            this.count = j;
        }
    }

    private LimitedPhotoFeedbackData() {
        this.id = null;
        this.doesViewerLike = false;
        this.canViewerLike = false;
        this.canViewerComment = false;
        this.likeCount = null;
        this.commentCount = null;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        ParcelUtil.a(parcel, this.doesViewerLike);
        ParcelUtil.a(parcel, this.canViewerLike);
        ParcelUtil.a(parcel, this.canViewerComment);
        parcel.writeLong(this.likeCount.count);
        parcel.writeLong(this.commentCount.count);
    }

    public LimitedPhotoFeedbackData(Parcel parcel) {
        this.id = parcel.readString();
        this.doesViewerLike = ParcelUtil.a(parcel);
        this.canViewerLike = ParcelUtil.a(parcel);
        this.canViewerComment = ParcelUtil.a(parcel);
        this.likeCount = new CountData(parcel.readLong());
        this.commentCount = new CountData(parcel.readLong());
    }
}
