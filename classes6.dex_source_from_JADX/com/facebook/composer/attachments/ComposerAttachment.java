package com.facebook.composer.attachments;

import android.graphics.RectF;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.ipc.composer.model.ComposerVideoTaggingInfo;
import com.facebook.ipc.media.MediaIdKey;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.base.media.MediaItemFactory$FallbackMediaId;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.photos.base.tagging.Tag;
import com.facebook.photos.base.tagging.TaggablePhoto;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.tagging.store.TagStore;
import com.facebook.photos.tagging.store.TagStoreCopy;
import com.facebook.user.model.Name;
import com.facebook.video.creativeediting.model.VideoCreativeEditingData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = ComposerAttachmentDeserializer.class)
@JsonSerialize(using = ComposerAttachmentSerializer.class)
/* compiled from: place_picker_gps_loaded */
public class ComposerAttachment implements Parcelable {
    public static final Creator<ComposerAttachment> CREATOR = new C04601();
    @JsonIgnore
    @Nullable
    public MediaItem f7807a;
    @JsonProperty("caption")
    final GraphQLTextWithEntities mCaption;
    @JsonProperty("creative_editing_data")
    @Nullable
    final CreativeEditingData mCreativeEditingData;
    @JsonProperty("id")
    final int mId;
    @JsonProperty("serialized_media_item")
    @Nullable
    ComposerSerializedMediaItem mSerializedMediaItemInternal;
    @JsonProperty("uri")
    final String mUri;
    @JsonProperty("video_creative_editing_data")
    @Nullable
    final VideoCreativeEditingData mVideoCreativeEditingData;
    @JsonProperty("video_tagging_info")
    @Nullable
    final ComposerVideoTaggingInfo mVideoTaggingInfo;

    /* compiled from: place_picker_gps_loaded */
    final class C04601 implements Creator<ComposerAttachment> {
        C04601() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerAttachment(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerAttachment[i];
        }
    }

    /* compiled from: place_picker_gps_loaded */
    public class Builder {
        public static final Builder f7799a = new Builder(null, null, GraphQLHelper.h);
        public MediaItem f7800b;
        public Uri f7801c;
        public GraphQLTextWithEntities f7802d;
        @Nullable
        public CreativeEditingData f7803e;
        @Nullable
        public VideoCreativeEditingData f7804f;
        @Nullable
        public ComposerVideoTaggingInfo f7805g;
        public int f7806h;

        private Builder() {
        }

        public Builder(MediaItem mediaItem, Uri uri, GraphQLTextWithEntities graphQLTextWithEntities) {
            this.f7800b = mediaItem;
            this.f7801c = uri;
            this.f7802d = graphQLTextWithEntities;
            this.f7806h = -1;
            this.f7803e = null;
            this.f7804f = null;
            this.f7805g = null;
        }

        public static Builder m11211a(@Nonnull ComposerAttachment composerAttachment) {
            Builder builder = new Builder(composerAttachment.f7807a, composerAttachment.m11228c(), composerAttachment.mCaption);
            builder.f7806h = composerAttachment.m11233h();
            builder = builder;
            builder.f7803e = composerAttachment.mCreativeEditingData;
            builder = builder;
            builder.f7804f = composerAttachment.mVideoCreativeEditingData;
            builder = builder;
            builder.f7805g = composerAttachment.mVideoTaggingInfo;
            return builder;
        }

        public static Builder m11212a(@Nullable MediaItem mediaItem) {
            return mediaItem != null ? new Builder(mediaItem, mediaItem.f(), GraphQLHelper.h) : f7799a;
        }

        public final Builder m11213a(GraphQLTextWithEntities graphQLTextWithEntities) {
            this.f7802d = graphQLTextWithEntities;
            return this;
        }

        public final Builder m11215a(CreativeEditingData creativeEditingData) {
            this.f7803e = creativeEditingData;
            return this;
        }

        @Nullable
        public final ComposerAttachment m11216a() {
            if (this == f7799a) {
                return null;
            }
            return new ComposerAttachment(this);
        }

        public final Builder m11214a(MediaItem mediaItem, @Nonnull MediaItemFactory mediaItemFactory) {
            Preconditions.checkNotNull(mediaItem);
            Preconditions.checkArgument(MediaItemFactory.a(mediaItem.f()));
            this.f7800b = mediaItem;
            this.f7801c = this.f7800b.f();
            return this;
        }
    }

    /* compiled from: place_picker_gps_loaded */
    public interface ProvidesAttachments {
        ImmutableList<ComposerAttachment> m11217m();
    }

    public static ImmutableList<ComposerAttachment> m11219a(@Nullable Collection<Uri> collection, @Nonnull MediaItemFactory mediaItemFactory) {
        if (collection == null) {
            return RegularImmutableList.a;
        }
        com.google.common.collect.ImmutableList.Builder builder = ImmutableList.builder();
        for (Uri uri : collection) {
            Builder builder2;
            if (uri == null) {
                builder2 = Builder.f7799a;
            } else if (MediaItemFactory.a(uri)) {
                MediaItem a = mediaItemFactory.a(uri, MediaItemFactory$FallbackMediaId.REMOTE_MEDIA);
                if (a != null) {
                    builder2 = Builder.m11212a(a);
                } else {
                    builder2 = Builder.f7799a;
                }
            } else {
                builder2 = new Builder(null, uri, GraphQLHelper.h);
            }
            ComposerAttachment a2 = builder2.m11216a();
            if (a2 != null) {
                builder.c(a2);
            }
        }
        return builder.b();
    }

    public static ImmutableList<ComposerAttachment> m11220a(@Nullable Collection<? extends MediaItem> collection, ImmutableList<GraphQLTextWithEntities> immutableList) {
        int i = 0;
        if (collection == null) {
            return RegularImmutableList.a;
        }
        Preconditions.checkState(collection.size() == immutableList.size());
        com.google.common.collect.ImmutableList.Builder builder = ImmutableList.builder();
        for (MediaItem a : collection) {
            Builder a2 = Builder.m11212a(a);
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) immutableList.get(i);
            if (!Strings.isNullOrEmpty(graphQLTextWithEntities.a())) {
                a2.f7802d = graphQLTextWithEntities;
            }
            ComposerAttachment a3 = a2.m11216a();
            if (a3 != null) {
                builder.c(a3);
            }
            i++;
        }
        return builder.b();
    }

    public static ImmutableList<ComposerAttachment> m11218a(@Nullable Collection<? extends MediaItem> collection) {
        if (collection == null) {
            return RegularImmutableList.a;
        }
        com.google.common.collect.ImmutableList.Builder builder = ImmutableList.builder();
        for (MediaItem a : collection) {
            ComposerAttachment a2 = Builder.m11212a(a).m11216a();
            if (a2 != null) {
                builder.c(a2);
            }
        }
        return builder.b();
    }

    private ComposerAttachment() {
        this.f7807a = null;
        this.mUri = "";
        this.mCaption = GraphQLHelper.h;
        this.mCreativeEditingData = null;
        this.mVideoCreativeEditingData = null;
        this.mVideoTaggingInfo = null;
        this.mId = 0;
    }

    public ComposerAttachment(Builder builder) {
        this.f7807a = builder.f7800b;
        this.mUri = builder.f7801c.toString();
        this.mCaption = builder.f7802d;
        this.mCreativeEditingData = builder.f7803e;
        this.mVideoCreativeEditingData = builder.f7804f;
        this.mVideoTaggingInfo = builder.f7805g;
        this.mId = builder.f7806h;
    }

    public ComposerAttachment(Parcel parcel) {
        this.f7807a = (MediaItem) parcel.readParcelable(MediaItem.class.getClassLoader());
        this.mSerializedMediaItemInternal = (ComposerSerializedMediaItem) parcel.readParcelable(ComposerSerializedMediaItem.class.getClassLoader());
        this.mUri = parcel.readString();
        this.mCaption = (GraphQLTextWithEntities) FlatBufferModelHelper.a(parcel);
        this.mCreativeEditingData = (CreativeEditingData) parcel.readParcelable(CreativeEditingData.class.getClassLoader());
        this.mVideoCreativeEditingData = (VideoCreativeEditingData) parcel.readParcelable(VideoCreativeEditingData.class.getClassLoader());
        this.mVideoTaggingInfo = (ComposerVideoTaggingInfo) parcel.readParcelable(ComposerVideoTaggingInfo.class.getClassLoader());
        this.mId = parcel.readInt();
    }

    @JsonIgnore
    public final boolean m11225a() {
        return this.f7807a != null;
    }

    @JsonIgnore
    @Nullable
    public final MediaItem m11227b() {
        return this.f7807a;
    }

    @JsonIgnore
    public final Uri m11228c() {
        return Uri.parse(this.mUri);
    }

    @JsonIgnore
    public final GraphQLTextWithEntities m11229d() {
        return this.mCaption;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f7807a, i);
        parcel.writeParcelable(this.mSerializedMediaItemInternal, i);
        parcel.writeString(this.mUri);
        FlatBufferModelHelper.a(parcel, this.mCaption);
        parcel.writeParcelable(this.mCreativeEditingData, i);
        parcel.writeParcelable(this.mVideoCreativeEditingData, i);
        parcel.writeParcelable(this.mVideoTaggingInfo, i);
        parcel.writeInt(this.mId);
    }

    @JsonIgnore
    @Nullable
    public final CreativeEditingData m11230e() {
        return this.mCreativeEditingData;
    }

    @JsonIgnore
    @Nullable
    public final VideoCreativeEditingData m11231f() {
        return this.mVideoCreativeEditingData;
    }

    @JsonIgnore
    @Nullable
    public final ComposerVideoTaggingInfo m11232g() {
        return this.mVideoTaggingInfo;
    }

    @JsonIgnore
    public final int m11233h() {
        return this.mId;
    }

    @JsonIgnore
    public int describeContents() {
        return 0;
    }

    @JsonIgnore
    public final void m11224a(TagStoreCopy tagStoreCopy) {
        this.mSerializedMediaItemInternal = this.f7807a != null ? ComposerSerializedMediaItem.m11238a(m11222b(tagStoreCopy)) : null;
    }

    @JsonIgnore
    public final void m11223a(MediaItemFactory mediaItemFactory, TagStore tagStore) {
        if (this.mSerializedMediaItemInternal != null) {
            this.f7807a = mediaItemFactory.a(m11228c(), MediaItemFactory$FallbackMediaId.REMOTE_MEDIA);
            if ((this.f7807a instanceof PhotoItem) && !this.mSerializedMediaItemInternal.mPhotoTags.isEmpty()) {
                Object obj;
                PhotoItem photoItem = (PhotoItem) this.f7807a;
                List a = m11221a(this.mSerializedMediaItemInternal.mPhotoTags);
                List list = (List) tagStore.f13467h.get(photoItem.d());
                if (list == null || list.isEmpty()) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    tagStore.m21163a((TaggablePhoto) photoItem.f12739f, a);
                }
            }
        }
    }

    private static List<Tag> m11221a(ImmutableList<PhotoTag> immutableList) {
        List<Tag> arrayList = new ArrayList();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            PhotoTag photoTag = (PhotoTag) immutableList.get(i);
            Tag tag = new Tag(new FaceBox(new RectF(photoTag.boxLeft, photoTag.boxTop, photoTag.boxRight, photoTag.boxBottom)), new Name(photoTag.firstName, null, photoTag.text), photoTag.taggedId, photoTag.taggingProfileType, photoTag.isAutoTag);
            tag.f12793h = photoTag.created;
            arrayList.add(tag);
        }
        return arrayList;
    }

    @JsonIgnore
    private ImmutableList<PhotoTag> m11222b(TagStoreCopy tagStoreCopy) {
        if (this.f7807a == null || !(this.f7807a instanceof PhotoItem)) {
            return ImmutableList.of();
        }
        MediaIdKey d = this.f7807a.d();
        if (tagStoreCopy.m21173a(d)) {
            return ImmutableList.of();
        }
        com.google.common.collect.ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList b = tagStoreCopy.m21174b(d);
        int size = b.size();
        for (int i = 0; i < size; i++) {
            Tag tag = (Tag) b.get(i);
            RectF d2 = tag.m20185d().mo1099d();
            builder.c(new PhotoTag(tag.m20188h(), d2.left, d2.top, d2.right, d2.bottom, tag.m20189i(), tag.m20192l(), tag.m20186e(), tag.m20187f().i(), tag.m20187f().a()));
        }
        return builder.b();
    }

    public final boolean m11226a(ComposerAttachment composerAttachment) {
        if (this == composerAttachment) {
            return true;
        }
        if (composerAttachment == null) {
            return false;
        }
        if (Objects.equal(this.f7807a, composerAttachment.f7807a) && Objects.equal(this.mUri, composerAttachment.mUri) && Objects.equal(this.mCaption.a(), composerAttachment.mCaption.a()) && Objects.equal(this.mCreativeEditingData, composerAttachment.mCreativeEditingData) && Objects.equal(this.mVideoCreativeEditingData, composerAttachment.mVideoCreativeEditingData)) {
            return true;
        }
        return false;
    }
}
