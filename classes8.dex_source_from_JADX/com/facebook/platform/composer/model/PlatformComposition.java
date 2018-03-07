package com.facebook.platform.composer.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.lifeevent.model.ComposerLifeEventModel;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.ComposerStickerData;
import com.facebook.ipc.composer.model.ComposerDateInfo;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ProductItemAttachment;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger.LoggingParameters;
import com.facebook.photos.creativeediting.analytics.CreativeEditingUsageParams;
import com.facebook.share.model.ComposerAppAttribution;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import java.util.HashSet;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = PlatformCompositionDeserializer.class)
@JsonSerialize(using = PlatformCompositionSerializer.class)
/* compiled from: review_profile_pic_size */
public class PlatformComposition implements Parcelable {
    public static final Creator<PlatformComposition> CREATOR = new C05431();
    @JsonIgnore
    public final ComposerLifeEventModel f4228a;
    @JsonIgnore
    public final ImmutableList<LoggingParameters> f4229b;
    @JsonIgnore
    public final ImmutableMap<String, CreativeEditingUsageParams> f4230c;
    @JsonProperty("app_attribution")
    @Nullable
    final ComposerAppAttribution mAppAttribution;
    @JsonProperty("app_provided_hashtag")
    final String mAppProvidedHashtag;
    @JsonProperty("attachments")
    final ImmutableList<ComposerAttachment> mAttachments;
    @JsonProperty("date_info")
    @Nullable
    final ComposerDateInfo mComposerDateInfo;
    @JsonProperty("has_user_interacted")
    final boolean mHasUserInteracted;
    @JsonProperty("is_backout_draft")
    final boolean mIsBackoutDraft;
    @JsonProperty("is_feed_only_post")
    final boolean mIsFeedOnlyPost;
    @JsonProperty("location_info")
    final ComposerLocationInfo mLocationInfo;
    @JsonProperty("marketplace_id")
    final long mMarketplaceId;
    @JsonProperty("minutiae_object")
    @Nullable
    final MinutiaeObject mMinutiaeObject;
    @JsonProperty("product_item_attachment")
    @Nullable
    final ProductItemAttachment mProductItemAttachment;
    @JsonProperty("publish_mode")
    final PublishMode mPublishMode;
    @JsonProperty("rating")
    final int mRating;
    @JsonProperty("posting_to_redspace")
    final RedSpaceValue mRedSpaceValue;
    @JsonProperty("referenced_sticker_data")
    final ComposerStickerData mReferencedStickerData;
    @JsonProperty("removed_urls")
    final ImmutableList<String> mRemovedURLs;
    @JsonProperty("schedule_time")
    @Nullable
    final Long mScheduleTime;
    @JsonProperty("share_params")
    @Nullable
    final ComposerShareParams mShareParams;
    @JsonProperty("tagged_profiles")
    final ImmutableList<FacebookProfile> mTaggedProfiles;
    @JsonProperty("target_album")
    @Nullable
    final GraphQLAlbum mTargetAlbum;
    @JsonProperty("text_with_entities")
    final GraphQLTextWithEntities mTextWithEntities;
    @JsonProperty("topic_feeds")
    final ImmutableList<String> mTopicIds;
    @JsonProperty("user_deleted_app_provided_hashtag")
    final boolean mUserDeletedAppProvidedHashtag;
    @JsonProperty("user_id")
    final long mUserId;
    @JsonProperty("user_selected_tags")
    final boolean mUserSelectedTags;

    /* compiled from: review_profile_pic_size */
    final class C05431 implements Creator<PlatformComposition> {
        C05431() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PlatformComposition(parcel);
        }

        public final Object[] newArray(int i) {
            return new PlatformComposition[i];
        }
    }

    /* compiled from: review_profile_pic_size */
    public class Builder {
        public boolean f4200A;
        public boolean f4201B;
        public long f4202a;
        public ImmutableList<ComposerAttachment> f4203b = RegularImmutableList.a;
        public GraphQLAlbum f4204c = null;
        public boolean f4205d;
        public int f4206e;
        public GraphQLTextWithEntities f4207f = GraphQLHelper.h;
        public ComposerLocationInfo f4208g = ComposerLocationInfo.newBuilder().b();
        public MinutiaeObject f4209h;
        public ProductItemAttachment f4210i;
        public long f4211j;
        public boolean f4212k;
        public ImmutableList<FacebookProfile> f4213l = RegularImmutableList.a;
        public PublishMode f4214m = PublishMode.NORMAL;
        @Nullable
        public Long f4215n;
        public ImmutableList<String> f4216o = RegularImmutableList.a;
        public ComposerLifeEventModel f4217p;
        public ComposerDateInfo f4218q;
        public ImmutableList<LoggingParameters> f4219r = RegularImmutableList.a;
        public ImmutableMap<String, CreativeEditingUsageParams> f4220s = RegularImmutableBiMap.a;
        public ComposerStickerData f4221t;
        @Nullable
        public ComposerShareParams f4222u;
        public boolean f4223v;
        public RedSpaceValue f4224w = RedSpaceValue.POST_TO_NEWSFEED;
        @Nullable
        public ComposerAppAttribution f4225x;
        public ImmutableList<String> f4226y;
        public String f4227z;

        public Builder(long j) {
            this.f4202a = j;
            this.f4213l = RegularImmutableList.a;
        }

        public Builder(PlatformComposition platformComposition) {
            this.f4202a = platformComposition.mUserId;
            this.f4203b = platformComposition.mAttachments;
            this.f4204c = platformComposition.mTargetAlbum;
            this.f4205d = platformComposition.mHasUserInteracted;
            this.f4206e = platformComposition.mRating;
            this.f4207f = platformComposition.mTextWithEntities;
            this.f4208g = platformComposition.mLocationInfo;
            this.f4209h = platformComposition.mMinutiaeObject;
            this.f4210i = platformComposition.mProductItemAttachment;
            this.f4211j = platformComposition.mMarketplaceId;
            this.f4212k = platformComposition.mUserSelectedTags;
            this.f4213l = platformComposition.mTaggedProfiles;
            this.f4214m = platformComposition.mPublishMode;
            this.f4215n = platformComposition.mScheduleTime;
            this.f4216o = platformComposition.mRemovedURLs;
            this.f4217p = platformComposition.f4228a;
            this.f4218q = platformComposition.mComposerDateInfo;
            this.f4219r = platformComposition.f4229b;
            this.f4220s = platformComposition.f4230c;
            this.f4221t = platformComposition.mReferencedStickerData;
            this.f4222u = platformComposition.mShareParams;
            this.f4223v = platformComposition.mIsBackoutDraft;
            this.f4224w = platformComposition.mRedSpaceValue;
            this.f4225x = platformComposition.mAppAttribution;
            this.f4226y = platformComposition.mTopicIds;
            this.f4227z = platformComposition.mAppProvidedHashtag;
            this.f4200A = platformComposition.mUserDeletedAppProvidedHashtag;
            this.f4201B = platformComposition.m4147B();
        }

        public final Builder m4143a(ImmutableList<ComposerAttachment> immutableList) {
            this.f4203b = (ImmutableList) Preconditions.checkNotNull(immutableList);
            return this;
        }

        public final Builder m4144b(ImmutableList<FacebookProfile> immutableList) {
            this.f4213l = (ImmutableList) Preconditions.checkNotNull(immutableList);
            return this;
        }

        public final PlatformComposition m4145b() {
            return new PlatformComposition(this);
        }
    }

    private PlatformComposition() {
        this(new Builder(0));
    }

    public PlatformComposition(Parcel parcel) {
        this.mUserId = parcel.readLong();
        this.mAttachments = ImmutableList.copyOf(parcel.readArrayList(MediaItem.class.getClassLoader()));
        this.mTargetAlbum = (GraphQLAlbum) FlatBufferModelHelper.a(parcel);
        this.mLocationInfo = (ComposerLocationInfo) parcel.readParcelable(ComposerLocationInfo.class.getClassLoader());
        this.mUserSelectedTags = parcel.readInt() != 0;
        this.mMinutiaeObject = (MinutiaeObject) parcel.readParcelable(MinutiaeObject.class.getClassLoader());
        this.mProductItemAttachment = (ProductItemAttachment) parcel.readParcelable(ProductItemAttachment.class.getClassLoader());
        this.mMarketplaceId = parcel.readLong();
        this.mTaggedProfiles = ParcelUtil.a(parcel, FacebookProfile.CREATOR);
        this.mRating = parcel.readInt();
        this.mTextWithEntities = (GraphQLTextWithEntities) FlatBufferModelHelper.a(parcel);
        this.mHasUserInteracted = ParcelUtil.a(parcel);
        this.mPublishMode = (PublishMode) ParcelUtil.c(parcel, PublishMode.class);
        this.mScheduleTime = ParcelUtil.e(parcel);
        this.mRemovedURLs = ParcelUtil.h(parcel);
        this.f4228a = (ComposerLifeEventModel) parcel.readParcelable(ComposerLifeEventModel.class.getClassLoader());
        this.mComposerDateInfo = (ComposerDateInfo) parcel.readParcelable(ComposerDateInfo.class.getClassLoader());
        this.f4229b = ImmutableList.copyOf(parcel.readArrayList(LoggingParameters.class.getClassLoader()));
        this.f4230c = ImmutableMap.copyOf(parcel.readHashMap(CreativeEditingUsageParams.class.getClassLoader()));
        this.mReferencedStickerData = (ComposerStickerData) parcel.readParcelable(ComposerStickerData.class.getClassLoader());
        this.mShareParams = (ComposerShareParams) parcel.readParcelable(ComposerShareParams.class.getClassLoader());
        this.mIsBackoutDraft = ParcelUtil.a(parcel);
        this.mRedSpaceValue = (RedSpaceValue) ParcelUtil.c(parcel, RedSpaceValue.class);
        this.mAppAttribution = (ComposerAppAttribution) parcel.readParcelable(ComposerAppAttribution.class.getClassLoader());
        this.mTopicIds = ParcelUtil.h(parcel);
        this.mAppProvidedHashtag = parcel.readString();
        this.mUserDeletedAppProvidedHashtag = ParcelUtil.a(parcel);
        this.mIsFeedOnlyPost = ParcelUtil.a(parcel);
    }

    public PlatformComposition(Builder builder) {
        this.mUserId = builder.f4202a;
        this.mAttachments = (ImmutableList) Preconditions.checkNotNull(builder.f4203b);
        this.mTargetAlbum = builder.f4203b.isEmpty() ? null : builder.f4204c;
        this.mHasUserInteracted = builder.f4205d;
        this.mRating = builder.f4206e;
        this.mTextWithEntities = builder.f4207f;
        this.mLocationInfo = builder.f4208g;
        this.mMinutiaeObject = builder.f4209h;
        this.mProductItemAttachment = builder.f4210i;
        this.mMarketplaceId = builder.f4211j;
        this.mUserSelectedTags = builder.f4212k;
        this.mTaggedProfiles = builder.f4213l;
        this.mPublishMode = builder.f4214m;
        this.mScheduleTime = builder.f4215n;
        this.mRemovedURLs = builder.f4216o;
        this.f4228a = builder.f4217p;
        this.mComposerDateInfo = builder.f4218q;
        this.f4229b = builder.f4219r;
        this.f4230c = builder.f4220s;
        this.mReferencedStickerData = builder.f4221t;
        this.mShareParams = builder.f4222u;
        this.mIsBackoutDraft = builder.f4223v;
        this.mRedSpaceValue = builder.f4224w;
        this.mAppAttribution = builder.f4225x;
        this.mTopicIds = builder.f4226y;
        this.mAppProvidedHashtag = builder.f4227z;
        this.mUserDeletedAppProvidedHashtag = builder.f4200A;
        this.mIsFeedOnlyPost = builder.f4201B;
    }

    public final boolean m4149a() {
        return this.mHasUserInteracted;
    }

    @Deprecated
    public final long m4150b() {
        return this.mUserId;
    }

    @Nullable
    public final GraphQLAlbum m4151c() {
        return this.mTargetAlbum;
    }

    public final boolean m4152d() {
        return this.mTargetAlbum != null;
    }

    public final ImmutableList<ComposerAttachment> m4153e() {
        return this.mAttachments;
    }

    public final RedSpaceValue m4154f() {
        return this.mRedSpaceValue;
    }

    public final GraphQLTextWithEntities m4155g() {
        return this.mTextWithEntities;
    }

    public final String m4156h() {
        return MentionsUtils.a(m4155g());
    }

    public final ComposerLocationInfo m4157i() {
        return this.mLocationInfo;
    }

    public final MinutiaeObject m4158j() {
        return this.mMinutiaeObject;
    }

    public final ProductItemAttachment m4159k() {
        return this.mProductItemAttachment;
    }

    public final long m4160l() {
        return this.mMarketplaceId;
    }

    public final PublishMode m4161m() {
        return this.mPublishMode;
    }

    @Nullable
    public final Long m4162n() {
        return this.mScheduleTime;
    }

    public final ImmutableMap<String, CreativeEditingUsageParams> m4163o() {
        return this.f4230c;
    }

    @Nullable
    public final ComposerStickerData m4164p() {
        return this.mReferencedStickerData;
    }

    @Nullable
    public final ComposerShareParams m4165q() {
        return this.mShareParams;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mUserId);
        parcel.writeList(this.mAttachments);
        FlatBufferModelHelper.a(parcel, this.mTargetAlbum);
        parcel.writeParcelable(this.mLocationInfo, i);
        parcel.writeInt(this.mUserSelectedTags ? 1 : 0);
        parcel.writeParcelable(this.mMinutiaeObject, i);
        parcel.writeParcelable(this.mProductItemAttachment, i);
        parcel.writeLong(this.mMarketplaceId);
        parcel.writeTypedList(this.mTaggedProfiles);
        parcel.writeInt(this.mRating);
        FlatBufferModelHelper.a(parcel, this.mTextWithEntities);
        ParcelUtil.a(parcel, this.mHasUserInteracted);
        ParcelUtil.a(parcel, this.mPublishMode);
        ParcelUtil.a(parcel, this.mScheduleTime);
        parcel.writeStringList(this.mRemovedURLs);
        parcel.writeParcelable(this.f4228a, i);
        parcel.writeParcelable(this.mComposerDateInfo, i);
        parcel.writeList(this.f4229b);
        parcel.writeMap(this.f4230c);
        parcel.writeParcelable(this.mReferencedStickerData, i);
        parcel.writeParcelable(this.mShareParams, i);
        ParcelUtil.a(parcel, this.mIsBackoutDraft);
        ParcelUtil.a(parcel, this.mRedSpaceValue);
        parcel.writeParcelable(this.mAppAttribution, i);
        parcel.writeStringList(this.mTopicIds);
        parcel.writeString(this.mAppProvidedHashtag);
        ParcelUtil.a(parcel, this.mUserDeletedAppProvidedHashtag);
        ParcelUtil.a(parcel, this.mIsFeedOnlyPost);
    }

    public final boolean m4166r() {
        return this.mUserSelectedTags;
    }

    public final boolean m4167s() {
        return this.mMinutiaeObject != null;
    }

    public final ImmutableSet<Long> m4168t() {
        int i = 0;
        Collection hashSet = new HashSet();
        int size = this.mTaggedProfiles.size();
        for (int i2 = 0; i2 < size; i2++) {
            hashSet.add(Long.valueOf(((FacebookProfile) this.mTaggedProfiles.get(i2)).mId));
        }
        ImmutableSet of = ImmutableSet.of(Integer.valueOf(2645995));
        hashSet.addAll(MentionsUtils.a(m4155g(), of));
        ImmutableList e = m4153e();
        int size2 = e.size();
        while (i < size2) {
            hashSet.addAll(MentionsUtils.a(((ComposerAttachment) e.get(i)).d(), of));
            i++;
        }
        hashSet.remove(Long.valueOf(this.mUserId));
        return ImmutableSet.copyOf(hashSet);
    }

    public final ImmutableSet<Long> m4169u() {
        com.google.common.collect.ImmutableSet.Builder builder = ImmutableSet.builder();
        int size = this.mTaggedProfiles.size();
        for (int i = 0; i < size; i++) {
            builder.c(Long.valueOf(((FacebookProfile) this.mTaggedProfiles.get(i)).mId));
        }
        return builder.b();
    }

    public final ImmutableList<FacebookProfile> m4170v() {
        return this.mTaggedProfiles;
    }

    public final boolean m4171w() {
        return this.mIsBackoutDraft;
    }

    public final ComposerAppAttribution m4172x() {
        return this.mAppAttribution;
    }

    public final ImmutableList<String> m4173y() {
        return this.mTopicIds;
    }

    public final String m4174z() {
        return this.mAppProvidedHashtag;
    }

    public final boolean m4146A() {
        return this.mUserDeletedAppProvidedHashtag;
    }

    public final boolean m4147B() {
        return this.mIsFeedOnlyPost;
    }

    public final Builder m4148C() {
        return new Builder(this);
    }
}
