package com.facebook.composer.publish.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.composer.publish.common.model.ComposerSessionLoggingData;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLBudgetRecommendationData;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.greetingcards.model.GreetingCard;
import com.facebook.ipc.composer.model.ComposerLocation;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.composer.model.MinutiaeTag;
import com.facebook.ipc.composer.model.ProductItemAttachment;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.ipc.composer.model.RetrySource;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = PublishPostParamsDeserializer.class)
/* compiled from: activity_class */
public class PublishPostParams implements Parcelable {
    public static final Creator<PublishPostParams> CREATOR = new C10891();
    @JsonIgnore
    public final GreetingCard f11584a;
    @JsonProperty("album_id")
    public final long albumId;
    @JsonProperty("android_key_hash")
    public final String androidKeyHash;
    public final boolean f11585b;
    @JsonIgnore
    public final ComposerLocation f11586c;
    @JsonProperty("canHandleWarning")
    public final boolean canHandleSentryWarning;
    @JsonProperty("caption")
    public final String caption;
    @JsonProperty("composer_session_id")
    public final String composerSessionId;
    @JsonProperty("composer_session_logging_data")
    public final ComposerSessionLoggingData composerSessionLoggingData;
    @JsonProperty("composer_type")
    public final ComposerType composerType;
    @JsonProperty("connection_class")
    public final String connectionClass;
    public final PollUploadParams f11587d;
    @JsonProperty("description")
    public final String description;
    public final String f11588e;
    @JsonIgnore
    private RetrySource f11589f;
    @JsonProperty("idempotence_token")
    public final String idempotenceToken;
    @JsonProperty("is_backout_draft")
    public final boolean isBackoutDraft;
    @JsonProperty("is_checkin")
    public final boolean isCheckin;
    @JsonProperty("is_explicit_location")
    public final boolean isExplicitLocation;
    @JsonProperty("posting_to_feed_only")
    public final boolean isFeedOnlyPost;
    @JsonProperty("is_photo_container")
    public final boolean isPhotoContainer;
    @JsonProperty("is_tags_user_selected")
    public final boolean isTagsUserSelected;
    @JsonProperty("is_throwback_post")
    public final boolean isThrowbackPost;
    @JsonProperty("link")
    public final String link;
    @JsonProperty("attempt_count")
    private int mAttemptCount;
    @JsonProperty("promote_budget")
    public final GraphQLBudgetRecommendationData mBudgetData;
    @JsonProperty("last_error_details")
    private ErrorDetails mLastErrorDetails;
    @JsonProperty("marketplace_id")
    public final long mMarketplaceId;
    @JsonProperty("product_item")
    public final ProductItemAttachment mProductItemAttachment;
    @JsonProperty("media_captions")
    public final ImmutableList<String> mediaCaptions;
    @JsonProperty("media_fbids")
    public final ImmutableList<String> mediaFbIds;
    @JsonProperty("name")
    public final String name;
    @JsonProperty("nectarModule")
    public final String nectarModule;
    @JsonProperty("og_action_type_id")
    public final String ogActionTypeId;
    @JsonProperty("og_hide_object_attachment")
    public final boolean ogHideObjectAttachment;
    @JsonProperty("og_icon_id")
    public final String ogIconId;
    @JsonProperty("og_object_id")
    public final String ogObjectId;
    @JsonProperty("og_phrase")
    public final String ogPhrase;
    @JsonProperty("og_suggestion_mechanism")
    public final String ogSuggestionMechansim;
    @JsonProperty("original_post_time")
    public final long originalPostTime;
    @JsonProperty("picture")
    public final String picture;
    @JsonProperty("place_attachment_removed")
    public final boolean placeAttachmentRemoved;
    @JsonProperty("page_id")
    public final String placeTag;
    @JsonProperty("privacy")
    public final String privacy;
    @JsonProperty("prompt_analytics")
    @Nullable
    public final PromptAnalytics promptAnalytics;
    @JsonProperty("proxied_app_id")
    public final String proxiedAppId;
    @JsonProperty("proxied_app_name")
    public final String proxiedAppName;
    @JsonProperty("publish_mode")
    public final PublishMode publishMode;
    @JsonProperty("quote")
    public final String quote;
    @JsonProperty("raw_message")
    public final String rawMessage;
    @JsonProperty("posting_to_redspace")
    public final RedSpaceValue redSpaceValue;
    @JsonProperty("ref")
    public final String ref;
    @JsonProperty("referenced_sticker_id")
    public final String referencedStickerId;
    @JsonProperty("reshare_original_post")
    public final boolean reshareOriginalPost;
    @JsonProperty("schedule_publish_time")
    public final long schedulePublishTime;
    @JsonProperty("shareable")
    public final GraphQLEntity shareable;
    @JsonProperty("source_type")
    public final String sourceType;
    @JsonProperty("souvenir")
    public final String souvenir;
    @JsonProperty("sync_object_uuid")
    public final ImmutableList<String> syncObjectUUIDs;
    @JsonProperty("tagged_ids")
    public final ImmutableList<Long> taggedIds;
    @JsonProperty("target_id")
    public final long targetId;
    @JsonProperty("text_only_place")
    public final String textOnlyPlace;
    @JsonProperty("throwback_card")
    public final String throwbackCardJson;
    @JsonProperty("title")
    public final String title;
    @JsonProperty("feed_topics")
    @Nullable
    public final ImmutableList<String> topicIds;
    @JsonProperty("tracking")
    public final String tracking;
    @JsonProperty("user_id")
    public final long userId;
    @JsonProperty("warnAcknowledged")
    public final boolean warnAcknowledged;

    /* compiled from: activity_class */
    final class C10891 implements Creator<PublishPostParams> {
        C10891() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PublishPostParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PublishPostParams[i];
        }
    }

    /* compiled from: activity_class */
    public class Builder {
        public String f11532A;
        public String f11533B;
        public String f11534C;
        public String f11535D;
        public String f11536E;
        public String f11537F;
        public String f11538G;
        public String f11539H;
        public String f11540I;
        public String f11541J;
        public String f11542K;
        public String f11543L;
        public boolean f11544M;
        public GraphQLBudgetRecommendationData f11545N;
        public String f11546O;
        public int f11547P;
        public ErrorDetails f11548Q = new com.facebook.composer.publish.common.ErrorDetails.Builder().m19655a();
        public boolean f11549R;
        public ComposerLocation f11550S;
        public ProductItemAttachment f11551T;
        public long f11552U;
        public GreetingCard f11553V;
        public boolean f11554W;
        public boolean f11555X;
        public String f11556Y;
        public boolean f11557Z;
        public String f11558a;
        public RedSpaceValue aa;
        public String ab;
        public String ac;
        public boolean ad;
        public String ae;
        public ImmutableList<String> af;
        public ImmutableList<String> ag;
        public ImmutableList<String> ah;
        public String ai;
        public boolean aj;
        public boolean ak;
        public PollUploadParams al;
        public String am;
        @Nullable
        public PromptAnalytics an;
        public boolean ao;
        public long f11559b;
        public String f11560c;
        public String f11561d;
        public ImmutableList<Long> f11562e = RegularImmutableList.a;
        public long f11563f;
        public String f11564g;
        public ComposerSessionLoggingData f11565h;
        public String f11566i;
        public long f11567j;
        public GraphQLEntity f11568k;
        public String f11569l;
        public String f11570m;
        public long f11571n;
        public PublishMode f11572o = PublishMode.NORMAL;
        public ComposerType f11573p;
        public boolean f11574q;
        public String f11575r;
        public boolean f11576s;
        public long f11577t;
        public boolean f11578u;
        @Nullable
        public ImmutableList<String> f11579v;
        public boolean f11580w;
        public String f11581x;
        public String f11582y;
        public String f11583z;

        public Builder(PublishPostParams publishPostParams) {
            this.f11559b = publishPostParams.targetId;
            this.f11560c = publishPostParams.rawMessage;
            this.f11561d = publishPostParams.placeTag;
            this.f11562e = publishPostParams.taggedIds;
            this.f11564g = publishPostParams.privacy;
            this.f11565h = publishPostParams.composerSessionLoggingData;
            this.f11566i = publishPostParams.link;
            this.f11567j = publishPostParams.userId;
            this.f11568k = publishPostParams.shareable;
            this.f11569l = publishPostParams.tracking;
            this.f11570m = publishPostParams.nectarModule;
            this.f11573p = publishPostParams.composerType;
            this.f11571n = publishPostParams.schedulePublishTime;
            this.f11572o = publishPostParams.publishMode;
            this.f11580w = publishPostParams.isTagsUserSelected;
            this.f11581x = publishPostParams.proxiedAppId;
            this.f11582y = publishPostParams.proxiedAppName;
            this.f11583z = publishPostParams.androidKeyHash;
            this.f11532A = publishPostParams.ref;
            this.f11533B = publishPostParams.name;
            this.f11534C = publishPostParams.caption;
            this.f11535D = publishPostParams.description;
            this.f11536E = publishPostParams.quote;
            this.f11537F = publishPostParams.picture;
            this.f11574q = publishPostParams.isPhotoContainer;
            this.f11538G = publishPostParams.composerSessionId;
            this.f11575r = publishPostParams.idempotenceToken;
            this.f11576s = publishPostParams.isExplicitLocation;
            this.f11577t = publishPostParams.originalPostTime;
            this.f11539H = publishPostParams.ogActionTypeId;
            this.f11540I = publishPostParams.ogObjectId;
            this.f11541J = publishPostParams.ogPhrase;
            this.f11542K = publishPostParams.ogIconId;
            this.f11543L = publishPostParams.ogSuggestionMechansim;
            this.f11547P = publishPostParams.m19711a();
            this.f11548Q = publishPostParams.m19715b();
            this.f11549R = publishPostParams.f11585b;
            this.f11550S = publishPostParams.f11586c;
            this.f11545N = publishPostParams.mBudgetData;
            this.f11551T = publishPostParams.mProductItemAttachment;
            this.f11552U = publishPostParams.mMarketplaceId;
            this.f11553V = publishPostParams.f11584a;
            this.f11554W = publishPostParams.isThrowbackPost;
            this.f11555X = publishPostParams.reshareOriginalPost;
            this.f11556Y = publishPostParams.connectionClass;
            this.f11557Z = publishPostParams.isCheckin;
            this.ab = publishPostParams.textOnlyPlace;
            this.ac = publishPostParams.sourceType;
            this.f11558a = publishPostParams.throwbackCardJson;
            this.f11546O = publishPostParams.referencedStickerId;
            this.f11578u = publishPostParams.placeAttachmentRemoved;
            this.f11579v = publishPostParams.topicIds;
            this.ad = publishPostParams.isBackoutDraft;
            this.ae = publishPostParams.title;
            this.ag = publishPostParams.mediaFbIds;
            this.ah = publishPostParams.syncObjectUUIDs;
            this.af = publishPostParams.mediaCaptions;
            this.ai = publishPostParams.souvenir;
            this.aa = publishPostParams.redSpaceValue;
            this.aj = publishPostParams.warnAcknowledged;
            this.ak = publishPostParams.canHandleSentryWarning;
            this.al = publishPostParams.f11587d;
            this.am = publishPostParams.f11588e;
            this.an = publishPostParams.promptAnalytics;
            this.ao = publishPostParams.isFeedOnlyPost;
        }

        public final PublishPostParams m19701a() {
            if (this.f11573p == null) {
                ComposerType composerType;
                if (this.f11568k != null) {
                    composerType = ComposerType.SHARE;
                } else if (this.f11551T != null) {
                    composerType = ComposerType.SELL;
                } else {
                    composerType = ComposerType.STATUS;
                }
                this.f11573p = composerType;
            }
            return new PublishPostParams(this);
        }

        public final Builder m19699a(ImmutableList<String> immutableList) {
            this.ag = immutableList;
            return this;
        }

        public final Builder m19703b(ImmutableList<String> immutableList) {
            this.ah = immutableList;
            return this;
        }

        public final Builder m19705c(ImmutableList<String> immutableList) {
            this.af = immutableList;
            return this;
        }

        public final Builder m19697a(long j) {
            this.f11559b = j;
            return this;
        }

        public final Builder m19708d(ImmutableList<Long> immutableList) {
            this.f11562e = (ImmutableList) Preconditions.checkNotNull(immutableList);
            return this;
        }

        public final Builder m19702b(long j) {
            this.f11563f = j;
            return this;
        }

        public final Builder m19706c(boolean z) {
            this.f11574q = z;
            return this;
        }

        public final Builder m19704c(long j) {
            this.f11567j = j;
            return this;
        }

        public final Builder m19707d(long j) {
            this.f11577t = j;
            return this;
        }

        public final Builder m19700a(Long l) {
            this.f11571n = l.longValue();
            return this;
        }

        public final Builder m19709q(String str) {
            this.f11538G = str;
            return this;
        }

        public final Builder m19698a(MinutiaeTag minutiaeTag) {
            if (minutiaeTag != null) {
                this.f11539H = minutiaeTag.ogActionTypeId;
                this.f11540I = minutiaeTag.ogObjectId;
                this.f11541J = minutiaeTag.ogPhrase;
                this.f11542K = minutiaeTag.ogIconId;
                this.f11544M = minutiaeTag.ogHideAttachment;
                this.f11543L = minutiaeTag.ogSuggestionMechanism;
            }
            return this;
        }

        public final Builder m19710u(String str) {
            this.f11558a = str;
            return this;
        }
    }

    private PublishPostParams() {
        this.targetId = 0;
        this.rawMessage = null;
        this.placeTag = null;
        this.taggedIds = RegularImmutableList.a;
        this.albumId = 0;
        this.privacy = null;
        this.composerSessionLoggingData = null;
        this.link = null;
        this.userId = 0;
        this.shareable = null;
        this.tracking = null;
        this.nectarModule = null;
        this.composerType = ComposerType.STATUS;
        this.schedulePublishTime = 0;
        this.publishMode = PublishMode.NORMAL;
        this.isTagsUserSelected = false;
        this.proxiedAppId = null;
        this.proxiedAppName = null;
        this.androidKeyHash = null;
        this.ref = null;
        this.name = null;
        this.caption = null;
        this.description = null;
        this.quote = null;
        this.picture = null;
        this.isPhotoContainer = false;
        this.composerSessionId = null;
        this.idempotenceToken = null;
        this.isExplicitLocation = false;
        this.originalPostTime = 0;
        this.ogActionTypeId = null;
        this.ogObjectId = null;
        this.ogPhrase = null;
        this.ogIconId = null;
        this.ogSuggestionMechansim = null;
        this.ogHideObjectAttachment = false;
        this.mAttemptCount = 0;
        this.mLastErrorDetails = new com.facebook.composer.publish.common.ErrorDetails.Builder().m19655a();
        this.f11589f = RetrySource.NONE;
        this.f11585b = false;
        this.f11586c = null;
        this.mBudgetData = null;
        this.mProductItemAttachment = null;
        this.mMarketplaceId = 0;
        this.f11584a = null;
        this.isThrowbackPost = false;
        this.reshareOriginalPost = false;
        this.connectionClass = null;
        this.isCheckin = false;
        this.textOnlyPlace = null;
        this.sourceType = null;
        this.throwbackCardJson = null;
        this.referencedStickerId = null;
        this.placeAttachmentRemoved = false;
        this.topicIds = null;
        this.isBackoutDraft = false;
        this.redSpaceValue = RedSpaceValue.POST_TO_NEWSFEED;
        this.title = null;
        this.mediaFbIds = null;
        this.syncObjectUUIDs = null;
        this.mediaCaptions = null;
        this.souvenir = null;
        this.warnAcknowledged = false;
        this.canHandleSentryWarning = false;
        this.f11587d = null;
        this.f11588e = null;
        this.promptAnalytics = null;
        this.isFeedOnlyPost = false;
    }

    public PublishPostParams(Builder builder) {
        this.targetId = builder.f11559b;
        this.rawMessage = builder.f11560c;
        this.placeTag = builder.f11561d;
        this.taggedIds = builder.f11562e;
        this.albumId = builder.f11563f;
        this.privacy = builder.f11564g;
        this.composerSessionLoggingData = builder.f11565h;
        this.link = builder.f11566i;
        this.userId = builder.f11567j;
        this.shareable = builder.f11568k;
        this.tracking = builder.f11569l;
        this.nectarModule = builder.f11570m;
        this.composerType = (ComposerType) Preconditions.checkNotNull(builder.f11573p);
        this.schedulePublishTime = builder.f11571n;
        this.publishMode = builder.f11572o;
        this.isTagsUserSelected = builder.f11580w;
        this.proxiedAppId = builder.f11581x;
        this.proxiedAppName = builder.f11582y;
        this.androidKeyHash = builder.f11583z;
        this.ref = builder.f11532A;
        this.name = builder.f11533B;
        this.caption = builder.f11534C;
        this.description = builder.f11535D;
        this.quote = builder.f11536E;
        this.picture = builder.f11537F;
        this.isPhotoContainer = builder.f11574q;
        this.composerSessionId = builder.f11538G;
        this.idempotenceToken = builder.f11575r;
        this.isExplicitLocation = builder.f11576s;
        this.originalPostTime = builder.f11577t;
        this.ogActionTypeId = builder.f11539H;
        this.ogObjectId = builder.f11540I;
        this.ogPhrase = builder.f11541J;
        this.ogIconId = builder.f11542K;
        this.ogSuggestionMechansim = builder.f11543L;
        this.ogHideObjectAttachment = builder.f11544M;
        this.mAttemptCount = builder.f11547P;
        this.mLastErrorDetails = builder.f11548Q;
        this.f11589f = RetrySource.NONE;
        this.f11585b = builder.f11549R;
        this.f11586c = builder.f11550S;
        this.mBudgetData = builder.f11545N;
        this.mProductItemAttachment = builder.f11551T;
        this.mMarketplaceId = builder.f11552U;
        this.f11584a = builder.f11553V;
        this.isThrowbackPost = builder.f11554W;
        this.reshareOriginalPost = builder.f11555X;
        this.connectionClass = builder.f11556Y;
        this.isCheckin = builder.f11557Z;
        this.textOnlyPlace = builder.ab;
        this.sourceType = builder.ac;
        this.throwbackCardJson = builder.f11558a;
        this.referencedStickerId = builder.f11546O;
        this.placeAttachmentRemoved = builder.f11578u;
        this.topicIds = builder.f11579v;
        this.isBackoutDraft = builder.ad;
        this.redSpaceValue = builder.aa;
        this.title = builder.ae;
        this.mediaFbIds = builder.ag;
        this.syncObjectUUIDs = builder.ah;
        this.mediaCaptions = builder.af;
        this.souvenir = builder.ai;
        this.warnAcknowledged = builder.aj;
        this.canHandleSentryWarning = builder.ak;
        this.f11587d = builder.al;
        this.f11588e = builder.am;
        this.promptAnalytics = builder.an;
        this.isFeedOnlyPost = builder.ao;
    }

    public PublishPostParams(Parcel parcel) {
        ImmutableList immutableList = null;
        boolean z = true;
        this.targetId = parcel.readLong();
        this.rawMessage = parcel.readString();
        this.placeTag = parcel.readString();
        Collection arrayList = new ArrayList();
        parcel.readList(arrayList, null);
        this.taggedIds = ImmutableList.copyOf(arrayList);
        this.albumId = parcel.readLong();
        this.privacy = parcel.readString();
        this.composerSessionLoggingData = (ComposerSessionLoggingData) parcel.readParcelable(ComposerSessionLoggingData.class.getClassLoader());
        this.link = parcel.readString();
        this.userId = parcel.readLong();
        this.shareable = (GraphQLEntity) FlatBufferModelHelper.m4278a(parcel);
        this.tracking = parcel.readString();
        this.nectarModule = parcel.readString();
        this.composerType = (ComposerType) ParcelUtil.m3831c(parcel, ComposerType.class);
        this.schedulePublishTime = parcel.readLong();
        this.publishMode = (PublishMode) ParcelUtil.m3831c(parcel, PublishMode.class);
        this.isTagsUserSelected = parcel.readByte() != (byte) 0;
        this.proxiedAppId = parcel.readString();
        this.proxiedAppName = parcel.readString();
        this.androidKeyHash = parcel.readString();
        this.ref = parcel.readString();
        this.name = parcel.readString();
        this.caption = parcel.readString();
        this.description = parcel.readString();
        this.quote = parcel.readString();
        this.picture = parcel.readString();
        this.isPhotoContainer = ParcelUtil.m3827a(parcel);
        this.composerSessionId = parcel.readString();
        this.idempotenceToken = parcel.readString();
        this.isExplicitLocation = ParcelUtil.m3827a(parcel);
        this.originalPostTime = parcel.readLong();
        this.ogActionTypeId = parcel.readString();
        this.ogObjectId = parcel.readString();
        this.ogPhrase = parcel.readString();
        this.ogIconId = parcel.readString();
        this.ogSuggestionMechansim = parcel.readString();
        this.ogHideObjectAttachment = parcel.readInt() == 1;
        this.mAttemptCount = parcel.readInt();
        this.mLastErrorDetails = (ErrorDetails) parcel.readParcelable(ErrorDetails.class.getClassLoader());
        this.f11589f = RetrySource.valueOf(parcel.readString());
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.f11585b = z;
        this.f11586c = (ComposerLocation) parcel.readParcelable(ComposerLocation.class.getClassLoader());
        this.mBudgetData = (GraphQLBudgetRecommendationData) FlatBufferModelHelper.m4278a(parcel);
        this.mProductItemAttachment = (ProductItemAttachment) parcel.readParcelable(ProductItemAttachment.class.getClassLoader());
        this.mMarketplaceId = parcel.readLong();
        this.f11584a = (GreetingCard) parcel.readParcelable(GreetingCard.class.getClassLoader());
        this.isThrowbackPost = ParcelUtil.m3827a(parcel);
        this.reshareOriginalPost = ParcelUtil.m3827a(parcel);
        this.connectionClass = parcel.readString();
        this.isCheckin = ParcelUtil.m3827a(parcel);
        this.textOnlyPlace = parcel.readString();
        this.sourceType = parcel.readString();
        this.throwbackCardJson = parcel.readString();
        this.referencedStickerId = parcel.readString();
        this.placeAttachmentRemoved = ParcelUtil.m3827a(parcel);
        this.topicIds = ParcelUtil.m3838j(parcel);
        this.isBackoutDraft = ParcelUtil.m3827a(parcel);
        this.redSpaceValue = (RedSpaceValue) ParcelUtil.m3831c(parcel, RedSpaceValue.class);
        this.title = parcel.readString();
        ImmutableList h = ParcelUtil.m3836h(parcel);
        if (h.isEmpty()) {
            h = null;
        }
        this.mediaFbIds = h;
        h = ParcelUtil.m3836h(parcel);
        if (h.isEmpty()) {
            h = null;
        }
        this.syncObjectUUIDs = h;
        h = ParcelUtil.m3836h(parcel);
        if (!h.isEmpty()) {
            immutableList = h;
        }
        this.mediaCaptions = immutableList;
        this.souvenir = parcel.readString();
        this.warnAcknowledged = ParcelUtil.m3827a(parcel);
        this.canHandleSentryWarning = ParcelUtil.m3827a(parcel);
        this.f11587d = (PollUploadParams) parcel.readParcelable(PollUploadParams.class.getClassLoader());
        this.f11588e = parcel.readString();
        this.promptAnalytics = (PromptAnalytics) parcel.readParcelable(PromptAnalytics.class.getClassLoader());
        this.isFeedOnlyPost = ParcelUtil.m3827a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeLong(this.targetId);
        parcel.writeString(this.rawMessage);
        parcel.writeString(this.placeTag);
        parcel.writeList(this.taggedIds);
        parcel.writeLong(this.albumId);
        parcel.writeString(this.privacy);
        parcel.writeParcelable(this.composerSessionLoggingData, i);
        parcel.writeString(this.link);
        parcel.writeLong(this.userId);
        FlatBufferModelHelper.m4288a(parcel, this.shareable);
        parcel.writeString(this.tracking);
        parcel.writeString(this.nectarModule);
        ParcelUtil.m3820a(parcel, this.composerType);
        parcel.writeLong(this.schedulePublishTime);
        ParcelUtil.m3820a(parcel, this.publishMode);
        parcel.writeByte((byte) (this.isTagsUserSelected ? 1 : 0));
        parcel.writeString(this.proxiedAppId);
        parcel.writeString(this.proxiedAppName);
        parcel.writeString(this.androidKeyHash);
        parcel.writeString(this.ref);
        parcel.writeString(this.name);
        parcel.writeString(this.caption);
        parcel.writeString(this.description);
        parcel.writeString(this.quote);
        parcel.writeString(this.picture);
        ParcelUtil.m3826a(parcel, this.isPhotoContainer);
        parcel.writeString(this.composerSessionId);
        parcel.writeString(this.idempotenceToken);
        ParcelUtil.m3826a(parcel, this.isExplicitLocation);
        parcel.writeLong(this.originalPostTime);
        parcel.writeString(this.ogActionTypeId);
        parcel.writeString(this.ogObjectId);
        parcel.writeString(this.ogPhrase);
        parcel.writeString(this.ogIconId);
        parcel.writeString(this.ogSuggestionMechansim);
        parcel.writeInt(this.ogHideObjectAttachment ? 1 : 0);
        parcel.writeInt(this.mAttemptCount);
        parcel.writeParcelable(this.mLastErrorDetails, i);
        parcel.writeString(this.f11589f.toString());
        if (!this.f11585b) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeParcelable(this.f11586c, i);
        FlatBufferModelHelper.m4288a(parcel, this.mBudgetData);
        parcel.writeParcelable(this.mProductItemAttachment, i);
        parcel.writeLong(this.mMarketplaceId);
        parcel.writeParcelable(this.f11584a, i);
        ParcelUtil.m3826a(parcel, this.isThrowbackPost);
        ParcelUtil.m3826a(parcel, this.reshareOriginalPost);
        parcel.writeString(this.connectionClass);
        ParcelUtil.m3826a(parcel, this.isCheckin);
        parcel.writeString(this.textOnlyPlace);
        parcel.writeString(this.sourceType);
        parcel.writeString(this.throwbackCardJson);
        parcel.writeString(this.referencedStickerId);
        ParcelUtil.m3826a(parcel, this.placeAttachmentRemoved);
        ParcelUtil.m3822a(parcel, this.topicIds);
        ParcelUtil.m3826a(parcel, this.isBackoutDraft);
        ParcelUtil.m3820a(parcel, this.redSpaceValue);
        parcel.writeString(this.title);
        parcel.writeStringList(this.mediaFbIds);
        parcel.writeStringList(this.syncObjectUUIDs);
        parcel.writeStringList(this.mediaCaptions);
        parcel.writeString(this.souvenir);
        ParcelUtil.m3826a(parcel, this.warnAcknowledged);
        ParcelUtil.m3826a(parcel, this.canHandleSentryWarning);
        parcel.writeParcelable(this.f11587d, i);
        parcel.writeString(this.f11588e);
        parcel.writeParcelable(this.promptAnalytics, i);
        ParcelUtil.m3826a(parcel, this.isFeedOnlyPost);
    }

    @JsonIgnore
    public final int m19711a() {
        return this.mAttemptCount;
    }

    @JsonIgnore
    public final void m19712a(int i) {
        this.mAttemptCount = i;
    }

    @JsonIgnore
    public final ErrorDetails m19715b() {
        return this.mLastErrorDetails;
    }

    @JsonIgnore
    public final void m19713a(ErrorDetails errorDetails) {
        this.mLastErrorDetails = errorDetails;
    }

    @JsonIgnore
    public final int m19716c() {
        return this.mAttemptCount - 1;
    }

    @JsonIgnore
    public final void m19714a(RetrySource retrySource) {
        this.f11589f = retrySource;
    }

    @JsonIgnore
    public final RetrySource m19717d() {
        return this.f11589f;
    }
}
