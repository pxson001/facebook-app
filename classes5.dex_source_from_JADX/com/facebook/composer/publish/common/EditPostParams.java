package com.facebook.composer.publish.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.ipc.composer.model.MinutiaeTag;
import com.facebook.ipc.composer.model.ProductItemAttachment;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = EditPostParamsDeserializer.class)
@JsonSerialize(using = EditPostParamsSerializer.class)
/* compiled from: addExtraDataFromUI */
public class EditPostParams implements Parcelable {
    public static final Creator<EditPostParams> CREATOR = new C10821();
    @JsonProperty("cache_ids")
    public final ImmutableList<String> cacheIds;
    @JsonProperty("composer_session_id")
    public final String composerSessionId;
    @JsonProperty("has_media_fbids")
    public final boolean hasMediaFbIds;
    @JsonProperty("is_photo_container")
    public final boolean isPhotoContainer;
    @JsonProperty("last_error_details")
    @Nullable
    public ErrorDetails lastErrorDetails;
    @JsonProperty("legacy_story_api_id")
    public final String legacyStoryApiId;
    @JsonProperty("link_edit")
    public final LinkEdit linkEdit;
    @JsonProperty("media_captions")
    public final ImmutableList<String> mediaCaptions;
    @JsonProperty("media_fbids")
    public final ImmutableList<String> mediaFbIds;
    @JsonProperty("message")
    public final GraphQLTextWithEntities message;
    @JsonProperty("minutiae_tag")
    public final MinutiaeTag minutiaeTag;
    @JsonProperty("original_post_time")
    public final long originalPostTime;
    @JsonProperty("place_tag")
    public final String placeTag;
    @JsonProperty("privacy")
    public final String privacy;
    @JsonProperty("product_item_attachment")
    public final ProductItemAttachment productItemAttachment;
    @JsonProperty("should_publish_unpublished_content")
    public final boolean shouldPublishUnpublishedContent;
    @JsonProperty("story_id")
    public final String storyId;
    @JsonProperty("tagged_ids")
    @Nullable
    public final ImmutableList<Long> taggedIds;
    @JsonProperty("target_id")
    public final long targetId;
    @JsonProperty("topic_feeds")
    @Nullable
    public final ImmutableList<GraphQLExploreFeed> topics;

    /* compiled from: addExtraDataFromUI */
    final class C10821 implements Creator<EditPostParams> {
        C10821() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EditPostParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new EditPostParams[i];
        }
    }

    /* compiled from: addExtraDataFromUI */
    public class Builder {
        public String f11483a;
        public String f11484b;
        public GraphQLTextWithEntities f11485c;
        public String f11486d;
        public ImmutableList<String> f11487e;
        public MinutiaeTag f11488f;
        @Nullable
        public ImmutableList<Long> f11489g;
        public String f11490h;
        @Nonnull
        public String f11491i;
        public ProductItemAttachment f11492j;
        public boolean f11493k;
        public long f11494l;
        public boolean f11495m;
        public ImmutableList<String> f11496n;
        public long f11497o;
        public boolean f11498p;
        public ImmutableList<String> f11499q;
        @Nullable
        public ErrorDetails f11500r;
        public LinkEdit f11501s;
        @Nullable
        public ImmutableList<GraphQLExploreFeed> f11502t;

        public Builder(EditPostParams editPostParams) {
            this.f11483a = editPostParams.composerSessionId;
            this.f11484b = editPostParams.legacyStoryApiId;
            this.f11485c = editPostParams.message;
            this.f11486d = editPostParams.storyId;
            this.f11487e = editPostParams.cacheIds;
            this.f11488f = editPostParams.minutiaeTag;
            this.f11489g = editPostParams.taggedIds;
            this.f11490h = editPostParams.placeTag;
            this.f11491i = editPostParams.privacy;
            this.f11492j = editPostParams.productItemAttachment;
            this.f11493k = editPostParams.shouldPublishUnpublishedContent;
            this.f11494l = editPostParams.originalPostTime;
            this.f11495m = editPostParams.hasMediaFbIds;
            this.f11496n = editPostParams.mediaFbIds;
            this.f11497o = editPostParams.targetId;
            this.f11499q = editPostParams.mediaCaptions;
            this.f11500r = editPostParams.lastErrorDetails;
            this.f11501s = editPostParams.linkEdit;
            this.f11502t = editPostParams.topics;
        }

        public final EditPostParams m19645a() {
            return new EditPostParams(this);
        }

        public final Builder m19644a(ImmutableList<String> immutableList) {
            this.f11487e = immutableList == null ? null : ImmutableList.copyOf(immutableList);
            return this;
        }

        public final Builder m19646b(ImmutableList<String> immutableList) {
            this.f11496n = immutableList;
            return this;
        }
    }

    public EditPostParams(Builder builder) {
        this.composerSessionId = builder.f11483a;
        this.legacyStoryApiId = (String) Preconditions.checkNotNull(builder.f11484b);
        this.message = builder.f11485c;
        this.storyId = builder.f11486d;
        this.cacheIds = builder.f11487e;
        this.minutiaeTag = builder.f11488f;
        this.taggedIds = builder.f11489g;
        this.placeTag = builder.f11490h;
        this.privacy = builder.f11491i;
        this.productItemAttachment = builder.f11492j;
        this.shouldPublishUnpublishedContent = builder.f11493k;
        this.originalPostTime = builder.f11494l;
        this.hasMediaFbIds = builder.f11495m;
        this.mediaFbIds = builder.f11496n;
        this.targetId = builder.f11497o;
        this.isPhotoContainer = builder.f11498p;
        this.mediaCaptions = builder.f11499q;
        this.lastErrorDetails = builder.f11500r;
        this.linkEdit = builder.f11501s;
        this.topics = builder.f11502t;
    }

    public EditPostParams(Parcel parcel) {
        Collection arrayList;
        this.composerSessionId = parcel.readString();
        this.legacyStoryApiId = parcel.readString();
        this.message = (GraphQLTextWithEntities) FlatBufferModelHelper.m4278a(parcel);
        this.storyId = parcel.readString();
        this.cacheIds = ParcelUtil.m3836h(parcel);
        this.minutiaeTag = (MinutiaeTag) parcel.readParcelable(MinutiaeTag.class.getClassLoader());
        if ((parcel.readByte() == (byte) 1 ? 1 : null) != null) {
            arrayList = new ArrayList();
            parcel.readList(arrayList, Long.class.getClassLoader());
            this.taggedIds = ImmutableList.copyOf(arrayList);
        } else {
            this.taggedIds = null;
        }
        this.placeTag = parcel.readString();
        this.privacy = parcel.readString();
        this.productItemAttachment = (ProductItemAttachment) parcel.readParcelable(ProductItemAttachment.class.getClassLoader());
        this.shouldPublishUnpublishedContent = ParcelUtil.m3827a(parcel);
        this.originalPostTime = parcel.readLong();
        this.hasMediaFbIds = ParcelUtil.m3827a(parcel);
        this.mediaFbIds = ParcelUtil.m3836h(parcel);
        this.targetId = parcel.readLong();
        this.isPhotoContainer = ParcelUtil.m3827a(parcel);
        this.mediaCaptions = ParcelUtil.m3836h(parcel);
        this.lastErrorDetails = (ErrorDetails) parcel.readParcelable(ErrorDetails.class.getClassLoader());
        this.linkEdit = (LinkEdit) parcel.readParcelable(LinkEdit.class.getClassLoader());
        arrayList = FlatBufferModelHelper.m4294b(parcel);
        this.topics = arrayList == null ? null : ImmutableList.copyOf(arrayList);
    }

    private EditPostParams() {
        this.composerSessionId = null;
        this.legacyStoryApiId = null;
        this.message = null;
        this.storyId = null;
        this.cacheIds = RegularImmutableList.a;
        this.minutiaeTag = null;
        this.taggedIds = null;
        this.placeTag = null;
        this.privacy = null;
        this.productItemAttachment = null;
        this.shouldPublishUnpublishedContent = false;
        this.originalPostTime = 0;
        this.hasMediaFbIds = false;
        this.mediaFbIds = RegularImmutableList.a;
        this.targetId = 0;
        this.isPhotoContainer = false;
        this.mediaCaptions = RegularImmutableList.a;
        this.linkEdit = null;
        this.topics = null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.composerSessionId);
        parcel.writeString(this.legacyStoryApiId);
        FlatBufferModelHelper.m4288a(parcel, this.message);
        parcel.writeString(this.storyId);
        parcel.writeStringList(this.cacheIds);
        parcel.writeParcelable(this.minutiaeTag, i);
        if (this.taggedIds != null) {
            parcel.writeByte((byte) 1);
            parcel.writeList(this.taggedIds);
        } else {
            parcel.writeByte((byte) 0);
        }
        parcel.writeString(this.placeTag);
        parcel.writeString(this.privacy);
        parcel.writeParcelable(this.productItemAttachment, i);
        ParcelUtil.m3826a(parcel, this.shouldPublishUnpublishedContent);
        parcel.writeLong(this.originalPostTime);
        ParcelUtil.m3826a(parcel, this.hasMediaFbIds);
        parcel.writeStringList(this.mediaFbIds);
        parcel.writeLong(this.targetId);
        ParcelUtil.m3826a(parcel, this.isPhotoContainer);
        parcel.writeStringList(this.mediaCaptions);
        parcel.writeParcelable(this.lastErrorDetails, i);
        parcel.writeParcelable(this.linkEdit, i);
        FlatBufferModelHelper.m4289a(parcel, this.topics);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("method", "EditPostMethod").add("composer_session_id", String.valueOf(this.composerSessionId)).add("legacyStoryApiId", String.valueOf(this.legacyStoryApiId)).add("message", String.valueOf(this.message)).add("storyId", String.valueOf(this.storyId)).add("cacheId", String.valueOf(this.cacheIds)).add("minutiae", String.valueOf(this.minutiaeTag)).add("with", String.valueOf(this.taggedIds)).add("place", String.valueOf(this.placeTag)).add("privacy", String.valueOf(this.privacy)).add("originalPostTime", String.valueOf(this.originalPostTime)).add("taggaed_ids", String.valueOf(this.taggedIds)).add("has_media_fb_ids", String.valueOf(this.hasMediaFbIds)).add("media_fb_ids", String.valueOf(this.mediaFbIds)).add("target_id", String.valueOf(this.targetId)).add("is_photo_container", String.valueOf(this.isPhotoContainer)).add("media_captions", String.valueOf(this.mediaCaptions)).add("last_error_details", String.valueOf(this.lastErrorDetails)).add("link_edit", String.valueOf(this.linkEdit)).toString();
    }

    @Nullable
    public final ErrorDetails m19647a() {
        return this.lastErrorDetails;
    }

    public final void m19648a(ErrorDetails errorDetails) {
        this.lastErrorDetails = errorDetails;
    }
}
