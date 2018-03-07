package com.facebook.composer.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.lifeevent.model.ComposerLifeEventModel;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.ipc.composer.intent.ComposerPageData;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.ComposerStickerData;
import com.facebook.ipc.composer.model.ComposerDateInfo;
import com.facebook.ipc.composer.model.ComposerFacecastInfo;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerSlideshowData;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.composer.model.ProductItemAttachment;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.photos.creativeediting.analytics.CreativeEditingUsageParams;
import com.facebook.share.model.ComposerAppAttribution;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@AutoGenJsonSerializer
@JsonDeserialize(using = Deserializer.class)
@JsonSerialize(using = CompositionSerializer.class)
/* compiled from: friendsView */
public class Composition implements Parcelable {
    public static final Creator<Composition> CREATOR = new C08531();
    public final boolean f6794A;
    @Nullable
    public final ComposerAppAttribution f6795a;
    public final ImmutableList<ComposerAttachment> f6796b;
    @Nullable
    public final ComposerDateInfo f6797c;
    @Nullable
    public final ComposerLifeEventModel f6798d;
    public final ImmutableMap<String, CreativeEditingUsageParams> f6799e;
    public final ComposerFacecastInfo f6800f;
    public final boolean f6801g;
    public final boolean f6802h;
    public final ComposerLocationInfo f6803i;
    public final long f6804j;
    @Nullable
    public final MinutiaeObject f6805k;
    @Nullable
    public final ComposerPageData f6806l;
    public final ImmutableList<GraphQLExploreFeed> f6807m;
    @Nullable
    public final ProductItemAttachment f6808n;
    public final PublishMode f6809o;
    public final int f6810p;
    public final RedSpaceValue f6811q;
    @Nullable
    public final ComposerStickerData f6812r;
    public final ImmutableList<String> f6813s;
    @Nullable
    public final Long f6814t;
    @Nullable
    public final ComposerShareParams f6815u;
    @Nullable
    public final ComposerSlideshowData f6816v;
    public final ImmutableList<ComposerTaggedUser> f6817w;
    @Nullable
    public final GraphQLAlbum f6818x;
    public final GraphQLTextWithEntities f6819y;
    public final ImmutableList<GraphQLExploreFeed> f6820z;

    /* compiled from: friendsView */
    final class C08531 implements Creator<Composition> {
        C08531() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Composition(parcel);
        }

        public final Object[] newArray(int i) {
            return new Composition[i];
        }
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = Composition_BuilderDeserializer.class)
    /* compiled from: friendsView */
    public class Builder {
        private static final ComposerFacecastInfo f6761a = new com.facebook.ipc.composer.model.ComposerFacecastInfo.Builder().a();
        private static final ComposerLocationInfo f6762b = ComposerLocationInfo.newBuilder().b();
        private static final PublishMode f6763c = PublishMode.NORMAL;
        private static final RedSpaceValue f6764d = RedSpaceValue.POST_TO_NEWSFEED;
        private static final GraphQLTextWithEntities f6765e = GraphQLHelper.h;
        @Nullable
        public ComposerSlideshowData f6766A;
        public ImmutableList<ComposerTaggedUser> f6767B = RegularImmutableList.a;
        @Nullable
        public GraphQLAlbum f6768C;
        public GraphQLTextWithEntities f6769D = f6765e;
        public ImmutableList<GraphQLExploreFeed> f6770E = RegularImmutableList.a;
        public boolean f6771F;
        @Nullable
        public ComposerAppAttribution f6772f;
        public ImmutableList<ComposerAttachment> f6773g = RegularImmutableList.a;
        @Nullable
        public ComposerDateInfo f6774h;
        @Nullable
        public ComposerLifeEventModel f6775i;
        public ImmutableMap<String, CreativeEditingUsageParams> f6776j = RegularImmutableBiMap.a;
        public ComposerFacecastInfo f6777k = f6761a;
        public boolean f6778l;
        public boolean f6779m;
        public ComposerLocationInfo f6780n = f6762b;
        public long f6781o;
        @Nullable
        public MinutiaeObject f6782p;
        @Nullable
        public ComposerPageData f6783q;
        public ImmutableList<GraphQLExploreFeed> f6784r = RegularImmutableList.a;
        @Nullable
        public ProductItemAttachment f6785s;
        public PublishMode f6786t = f6763c;
        public int f6787u;
        public RedSpaceValue f6788v = f6764d;
        @Nullable
        public ComposerStickerData f6789w;
        public ImmutableList<String> f6790x = RegularImmutableList.a;
        @Nullable
        public Long f6791y;
        @Nullable
        public ComposerShareParams f6792z;

        static {
            CompositionSpec$FacecastInfoDefaultValueProvider compositionSpec$FacecastInfoDefaultValueProvider = new CompositionSpec$FacecastInfoDefaultValueProvider();
            CompositionSpec$ComposerLocationInfoDefaultValueProvider compositionSpec$ComposerLocationInfoDefaultValueProvider = new CompositionSpec$ComposerLocationInfoDefaultValueProvider();
            CompositionSpec$PublishModeDefaultValueProvider compositionSpec$PublishModeDefaultValueProvider = new CompositionSpec$PublishModeDefaultValueProvider();
            CompositionSpec$RedSpaceValueDefaultValueProvider compositionSpec$RedSpaceValueDefaultValueProvider = new CompositionSpec$RedSpaceValueDefaultValueProvider();
            CompositionSpec$TextWithEntitiesDefaultValueProvider compositionSpec$TextWithEntitiesDefaultValueProvider = new CompositionSpec$TextWithEntitiesDefaultValueProvider();
        }

        public Builder(Composition composition) {
            Preconditions.checkNotNull(composition);
            if (composition instanceof Composition) {
                composition = composition;
                this.f6772f = composition.f6795a;
                this.f6773g = composition.f6796b;
                this.f6774h = composition.f6797c;
                this.f6775i = composition.f6798d;
                this.f6776j = composition.f6799e;
                this.f6777k = composition.f6800f;
                this.f6778l = composition.f6801g;
                this.f6779m = composition.f6802h;
                this.f6780n = composition.f6803i;
                this.f6781o = composition.f6804j;
                this.f6782p = composition.f6805k;
                this.f6783q = composition.f6806l;
                this.f6784r = composition.f6807m;
                this.f6785s = composition.f6808n;
                this.f6786t = composition.f6809o;
                this.f6787u = composition.f6810p;
                this.f6788v = composition.f6811q;
                this.f6789w = composition.f6812r;
                this.f6790x = composition.f6813s;
                this.f6791y = composition.f6814t;
                this.f6792z = composition.f6815u;
                this.f6766A = composition.f6816v;
                this.f6767B = composition.f6817w;
                this.f6768C = composition.f6818x;
                this.f6769D = composition.f6819y;
                this.f6770E = composition.f6820z;
                this.f6771F = composition.f6794A;
                return;
            }
            this.f6772f = composition.getAppAttribution();
            this.f6773g = composition.getAttachments();
            this.f6774h = composition.getComposerDateInfo();
            this.f6775i = composition.m8149a();
            this.f6776j = composition.m8150b();
            this.f6777k = composition.getFacecastInfo();
            this.f6778l = composition.isBackoutDraft();
            this.f6779m = composition.isFeedOnlyPost();
            this.f6780n = composition.getLocationInfo();
            this.f6781o = composition.getMarketplaceId();
            this.f6782p = composition.getMinutiaeObject();
            this.f6783q = composition.getPageData();
            this.f6784r = composition.getPredictedTopics();
            this.f6785s = composition.getProductItemAttachment();
            this.f6786t = composition.getPublishMode();
            this.f6787u = composition.getRating();
            this.f6788v = composition.getRedSpaceValue();
            this.f6789w = composition.getReferencedStickerData();
            this.f6790x = composition.getRemovedURLs();
            this.f6791y = composition.getScheduleTime();
            this.f6792z = composition.getShareParams();
            this.f6766A = composition.getSlideshowData();
            this.f6767B = composition.getTaggedUsers();
            this.f6768C = composition.getTargetAlbum();
            this.f6769D = composition.getTextWithEntities();
            this.f6770E = composition.getTopics();
            this.f6771F = composition.isUserSelectedTags();
        }

        public final Composition m8146a() {
            return new Composition(this);
        }

        @JsonProperty("app_attribution")
        public Builder setAppAttribution(@Nullable ComposerAppAttribution composerAppAttribution) {
            this.f6772f = composerAppAttribution;
            return this;
        }

        @JsonProperty("attachments")
        public Builder setAttachments(ImmutableList<ComposerAttachment> immutableList) {
            this.f6773g = immutableList;
            return this;
        }

        @JsonProperty("composer_date_info")
        public Builder setComposerDateInfo(@Nullable ComposerDateInfo composerDateInfo) {
            this.f6774h = composerDateInfo;
            return this;
        }

        @JsonIgnore
        public final Builder m8144a(@Nullable ComposerLifeEventModel composerLifeEventModel) {
            this.f6775i = composerLifeEventModel;
            return this;
        }

        @JsonIgnore
        public final Builder m8145a(ImmutableMap<String, CreativeEditingUsageParams> immutableMap) {
            this.f6776j = immutableMap;
            return this;
        }

        @JsonProperty("facecast_info")
        public Builder setFacecastInfo(ComposerFacecastInfo composerFacecastInfo) {
            this.f6777k = composerFacecastInfo;
            return this;
        }

        @JsonProperty("is_backout_draft")
        public Builder setIsBackoutDraft(boolean z) {
            this.f6778l = z;
            return this;
        }

        @JsonProperty("is_feed_only_post")
        public Builder setIsFeedOnlyPost(boolean z) {
            this.f6779m = z;
            return this;
        }

        @JsonProperty("location_info")
        public Builder setLocationInfo(ComposerLocationInfo composerLocationInfo) {
            this.f6780n = composerLocationInfo;
            return this;
        }

        @JsonProperty("marketplace_id")
        public Builder setMarketplaceId(long j) {
            this.f6781o = j;
            return this;
        }

        @JsonProperty("minutiae_object")
        public Builder setMinutiaeObject(@Nullable MinutiaeObject minutiaeObject) {
            this.f6782p = minutiaeObject;
            return this;
        }

        @JsonProperty("page_data")
        public Builder setPageData(@Nullable ComposerPageData composerPageData) {
            this.f6783q = composerPageData;
            return this;
        }

        @JsonProperty("predicted_topics")
        public Builder setPredictedTopics(ImmutableList<GraphQLExploreFeed> immutableList) {
            this.f6784r = immutableList;
            return this;
        }

        @JsonProperty("product_item_attachment")
        public Builder setProductItemAttachment(@Nullable ProductItemAttachment productItemAttachment) {
            this.f6785s = productItemAttachment;
            return this;
        }

        @JsonProperty("publish_mode")
        public Builder setPublishMode(PublishMode publishMode) {
            this.f6786t = publishMode;
            return this;
        }

        @JsonProperty("rating")
        public Builder setRating(int i) {
            this.f6787u = i;
            return this;
        }

        @JsonProperty("red_space_value")
        public Builder setRedSpaceValue(RedSpaceValue redSpaceValue) {
            this.f6788v = redSpaceValue;
            return this;
        }

        @JsonProperty("referenced_sticker_data")
        public Builder setReferencedStickerData(@Nullable ComposerStickerData composerStickerData) {
            this.f6789w = composerStickerData;
            return this;
        }

        @JsonProperty("removed_u_r_ls")
        public Builder setRemovedURLs(ImmutableList<String> immutableList) {
            this.f6790x = immutableList;
            return this;
        }

        @JsonProperty("schedule_time")
        public Builder setScheduleTime(@Nullable Long l) {
            this.f6791y = l;
            return this;
        }

        @JsonProperty("share_params")
        public Builder setShareParams(@Nullable ComposerShareParams composerShareParams) {
            this.f6792z = composerShareParams;
            return this;
        }

        @JsonProperty("slideshow_data")
        public Builder setSlideshowData(@Nullable ComposerSlideshowData composerSlideshowData) {
            this.f6766A = composerSlideshowData;
            return this;
        }

        @JsonProperty("tagged_users")
        public Builder setTaggedUsers(ImmutableList<ComposerTaggedUser> immutableList) {
            this.f6767B = immutableList;
            return this;
        }

        @JsonProperty("target_album")
        public Builder setTargetAlbum(@Nullable GraphQLAlbum graphQLAlbum) {
            this.f6768C = graphQLAlbum;
            return this;
        }

        @JsonProperty("text_with_entities")
        public Builder setTextWithEntities(GraphQLTextWithEntities graphQLTextWithEntities) {
            this.f6769D = graphQLTextWithEntities;
            return this;
        }

        @JsonProperty("topics")
        public Builder setTopics(ImmutableList<GraphQLExploreFeed> immutableList) {
            this.f6770E = immutableList;
            return this;
        }

        @JsonProperty("user_selected_tags")
        public Builder setUserSelectedTags(boolean z) {
            this.f6771F = z;
            return this;
        }
    }

    /* compiled from: friendsView */
    class Deserializer extends JsonDeserializer<Composition> {
        private static final Composition_BuilderDeserializer f6793a = new Composition_BuilderDeserializer();

        private Deserializer() {
        }

        public Object m8147a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return ((Builder) f6793a.a(jsonParser, deserializationContext)).m8146a();
        }
    }

    public Composition(Builder builder) {
        this.f6795a = builder.f6772f;
        this.f6796b = (ImmutableList) Preconditions.checkNotNull(builder.f6773g);
        this.f6797c = builder.f6774h;
        this.f6798d = builder.f6775i;
        this.f6799e = (ImmutableMap) Preconditions.checkNotNull(builder.f6776j);
        this.f6800f = (ComposerFacecastInfo) Preconditions.checkNotNull(builder.f6777k);
        this.f6801g = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f6778l))).booleanValue();
        this.f6802h = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f6779m))).booleanValue();
        this.f6803i = (ComposerLocationInfo) Preconditions.checkNotNull(builder.f6780n);
        this.f6804j = ((Long) Preconditions.checkNotNull(Long.valueOf(builder.f6781o))).longValue();
        this.f6805k = builder.f6782p;
        this.f6806l = builder.f6783q;
        this.f6807m = (ImmutableList) Preconditions.checkNotNull(builder.f6784r);
        this.f6808n = builder.f6785s;
        this.f6809o = (PublishMode) Preconditions.checkNotNull(builder.f6786t);
        this.f6810p = ((Integer) Preconditions.checkNotNull(Integer.valueOf(builder.f6787u))).intValue();
        this.f6811q = (RedSpaceValue) Preconditions.checkNotNull(builder.f6788v);
        this.f6812r = builder.f6789w;
        this.f6813s = (ImmutableList) Preconditions.checkNotNull(builder.f6790x);
        this.f6814t = builder.f6791y;
        this.f6815u = builder.f6792z;
        this.f6816v = builder.f6766A;
        this.f6817w = (ImmutableList) Preconditions.checkNotNull(builder.f6767B);
        this.f6818x = builder.f6768C;
        this.f6819y = (GraphQLTextWithEntities) Preconditions.checkNotNull(builder.f6769D);
        this.f6820z = (ImmutableList) Preconditions.checkNotNull(builder.f6770E);
        this.f6794A = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f6771F))).booleanValue();
    }

    public Composition(Parcel parcel) {
        int i;
        boolean z;
        boolean z2 = true;
        if (parcel.readInt() == 0) {
            this.f6795a = null;
        } else {
            this.f6795a = (ComposerAppAttribution) parcel.readParcelable(ComposerAppAttribution.class.getClassLoader());
        }
        ComposerAttachment[] composerAttachmentArr = new ComposerAttachment[parcel.readInt()];
        for (i = 0; i < composerAttachmentArr.length; i++) {
            composerAttachmentArr[i] = (ComposerAttachment) parcel.readParcelable(ComposerAttachment.class.getClassLoader());
        }
        this.f6796b = ImmutableList.copyOf(composerAttachmentArr);
        if (parcel.readInt() == 0) {
            this.f6797c = null;
        } else {
            this.f6797c = (ComposerDateInfo) parcel.readParcelable(ComposerDateInfo.class.getClassLoader());
        }
        if (parcel.readInt() == 0) {
            this.f6798d = null;
        } else {
            this.f6798d = (ComposerLifeEventModel) parcel.readParcelable(ComposerLifeEventModel.class.getClassLoader());
        }
        Map hashMap = new HashMap();
        int readInt = parcel.readInt();
        for (i = 0; i < readInt; i++) {
            hashMap.put(parcel.readString(), (CreativeEditingUsageParams) parcel.readParcelable(CreativeEditingUsageParams.class.getClassLoader()));
        }
        this.f6799e = ImmutableMap.copyOf(hashMap);
        this.f6800f = (ComposerFacecastInfo) parcel.readParcelable(ComposerFacecastInfo.class.getClassLoader());
        this.f6801g = parcel.readInt() == 1;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f6802h = z;
        this.f6803i = (ComposerLocationInfo) parcel.readParcelable(ComposerLocationInfo.class.getClassLoader());
        this.f6804j = parcel.readLong();
        if (parcel.readInt() == 0) {
            this.f6805k = null;
        } else {
            this.f6805k = (MinutiaeObject) parcel.readParcelable(MinutiaeObject.class.getClassLoader());
        }
        if (parcel.readInt() == 0) {
            this.f6806l = null;
        } else {
            this.f6806l = (ComposerPageData) parcel.readParcelable(ComposerPageData.class.getClassLoader());
        }
        GraphQLExploreFeed[] graphQLExploreFeedArr = new GraphQLExploreFeed[parcel.readInt()];
        for (i = 0; i < graphQLExploreFeedArr.length; i++) {
            graphQLExploreFeedArr[i] = (GraphQLExploreFeed) FlatBufferModelHelper.a(parcel);
        }
        this.f6807m = ImmutableList.copyOf(graphQLExploreFeedArr);
        if (parcel.readInt() == 0) {
            this.f6808n = null;
        } else {
            this.f6808n = (ProductItemAttachment) parcel.readParcelable(ProductItemAttachment.class.getClassLoader());
        }
        this.f6809o = PublishMode.valueOf(parcel.readString());
        this.f6810p = parcel.readInt();
        this.f6811q = RedSpaceValue.valueOf(parcel.readString());
        if (parcel.readInt() == 0) {
            this.f6812r = null;
        } else {
            this.f6812r = (ComposerStickerData) parcel.readParcelable(ComposerStickerData.class.getClassLoader());
        }
        String[] strArr = new String[parcel.readInt()];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr[i2] = parcel.readString();
        }
        this.f6813s = ImmutableList.copyOf(strArr);
        if (parcel.readInt() == 0) {
            this.f6814t = null;
        } else {
            this.f6814t = Long.valueOf(parcel.readLong());
        }
        if (parcel.readInt() == 0) {
            this.f6815u = null;
        } else {
            this.f6815u = (ComposerShareParams) parcel.readParcelable(ComposerShareParams.class.getClassLoader());
        }
        if (parcel.readInt() == 0) {
            this.f6816v = null;
        } else {
            this.f6816v = (ComposerSlideshowData) parcel.readParcelable(ComposerSlideshowData.class.getClassLoader());
        }
        ComposerTaggedUser[] composerTaggedUserArr = new ComposerTaggedUser[parcel.readInt()];
        for (i = 0; i < composerTaggedUserArr.length; i++) {
            composerTaggedUserArr[i] = (ComposerTaggedUser) parcel.readParcelable(ComposerTaggedUser.class.getClassLoader());
        }
        this.f6817w = ImmutableList.copyOf(composerTaggedUserArr);
        if (parcel.readInt() == 0) {
            this.f6818x = null;
        } else {
            this.f6818x = (GraphQLAlbum) FlatBufferModelHelper.a(parcel);
        }
        this.f6819y = (GraphQLTextWithEntities) FlatBufferModelHelper.a(parcel);
        graphQLExploreFeedArr = new GraphQLExploreFeed[parcel.readInt()];
        for (i = 0; i < graphQLExploreFeedArr.length; i++) {
            graphQLExploreFeedArr[i] = (GraphQLExploreFeed) FlatBufferModelHelper.a(parcel);
        }
        this.f6820z = ImmutableList.copyOf(graphQLExploreFeedArr);
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.f6794A = z2;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder m8148a(Composition composition) {
        return new Builder(composition);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3;
        int i4 = 1;
        if (this.f6795a == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f6795a, i);
        }
        parcel.writeInt(this.f6796b.size());
        int size = this.f6796b.size();
        for (i2 = 0; i2 < size; i2++) {
            parcel.writeParcelable((ComposerAttachment) this.f6796b.get(i2), i);
        }
        if (this.f6797c == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f6797c, i);
        }
        if (this.f6798d == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f6798d, i);
        }
        parcel.writeInt(this.f6799e.size());
        Iterator it = this.f6799e.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            parcel.writeString((String) entry.getKey());
            parcel.writeParcelable((Parcelable) entry.getValue(), i);
        }
        parcel.writeParcelable(this.f6800f, i);
        parcel.writeInt(this.f6801g ? 1 : 0);
        if (this.f6802h) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeParcelable(this.f6803i, i);
        parcel.writeLong(this.f6804j);
        if (this.f6805k == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f6805k, i);
        }
        if (this.f6806l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f6806l, i);
        }
        parcel.writeInt(this.f6807m.size());
        size = this.f6807m.size();
        for (i2 = 0; i2 < size; i2++) {
            FlatBufferModelHelper.a(parcel, (GraphQLExploreFeed) this.f6807m.get(i2));
        }
        if (this.f6808n == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f6808n, i);
        }
        parcel.writeString(this.f6809o.name());
        parcel.writeInt(this.f6810p);
        parcel.writeString(this.f6811q.name());
        if (this.f6812r == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f6812r, i);
        }
        parcel.writeInt(this.f6813s.size());
        size = this.f6813s.size();
        for (i2 = 0; i2 < size; i2++) {
            parcel.writeString((String) this.f6813s.get(i2));
        }
        if (this.f6814t == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(this.f6814t.longValue());
        }
        if (this.f6815u == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f6815u, i);
        }
        if (this.f6816v == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f6816v, i);
        }
        parcel.writeInt(this.f6817w.size());
        size = this.f6817w.size();
        for (i2 = 0; i2 < size; i2++) {
            parcel.writeParcelable((ComposerTaggedUser) this.f6817w.get(i2), i);
        }
        if (this.f6818x == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            FlatBufferModelHelper.a(parcel, this.f6818x);
        }
        FlatBufferModelHelper.a(parcel, this.f6819y);
        parcel.writeInt(this.f6820z.size());
        size = this.f6820z.size();
        for (i2 = 0; i2 < size; i2++) {
            FlatBufferModelHelper.a(parcel, (GraphQLExploreFeed) this.f6820z.get(i2));
        }
        if (!this.f6794A) {
            i4 = 0;
        }
        parcel.writeInt(i4);
    }

    public int describeContents() {
        return 0;
    }

    @JsonProperty("app_attribution")
    @Nullable
    public ComposerAppAttribution getAppAttribution() {
        return this.f6795a;
    }

    @JsonProperty("attachments")
    public ImmutableList<ComposerAttachment> getAttachments() {
        return this.f6796b;
    }

    @JsonProperty("composer_date_info")
    @Nullable
    public ComposerDateInfo getComposerDateInfo() {
        return this.f6797c;
    }

    @JsonIgnore
    @Nullable
    public final ComposerLifeEventModel m8149a() {
        return this.f6798d;
    }

    @JsonIgnore
    public final ImmutableMap<String, CreativeEditingUsageParams> m8150b() {
        return this.f6799e;
    }

    @JsonProperty("facecast_info")
    public ComposerFacecastInfo getFacecastInfo() {
        return this.f6800f;
    }

    @JsonProperty("is_backout_draft")
    public boolean isBackoutDraft() {
        return this.f6801g;
    }

    @JsonProperty("is_feed_only_post")
    public boolean isFeedOnlyPost() {
        return this.f6802h;
    }

    @JsonProperty("location_info")
    public ComposerLocationInfo getLocationInfo() {
        return this.f6803i;
    }

    @JsonProperty("marketplace_id")
    public long getMarketplaceId() {
        return this.f6804j;
    }

    @JsonProperty("minutiae_object")
    @Nullable
    public MinutiaeObject getMinutiaeObject() {
        return this.f6805k;
    }

    @JsonProperty("page_data")
    @Nullable
    public ComposerPageData getPageData() {
        return this.f6806l;
    }

    @JsonProperty("predicted_topics")
    public ImmutableList<GraphQLExploreFeed> getPredictedTopics() {
        return this.f6807m;
    }

    @JsonProperty("product_item_attachment")
    @Nullable
    public ProductItemAttachment getProductItemAttachment() {
        return this.f6808n;
    }

    @JsonProperty("publish_mode")
    public PublishMode getPublishMode() {
        return this.f6809o;
    }

    @JsonProperty("rating")
    public int getRating() {
        return this.f6810p;
    }

    @JsonProperty("red_space_value")
    public RedSpaceValue getRedSpaceValue() {
        return this.f6811q;
    }

    @JsonProperty("referenced_sticker_data")
    @Nullable
    public ComposerStickerData getReferencedStickerData() {
        return this.f6812r;
    }

    @JsonProperty("removed_u_r_ls")
    public ImmutableList<String> getRemovedURLs() {
        return this.f6813s;
    }

    @JsonProperty("schedule_time")
    @Nullable
    public Long getScheduleTime() {
        return this.f6814t;
    }

    @JsonProperty("share_params")
    @Nullable
    public ComposerShareParams getShareParams() {
        return this.f6815u;
    }

    @JsonProperty("slideshow_data")
    @Nullable
    public ComposerSlideshowData getSlideshowData() {
        return this.f6816v;
    }

    @JsonProperty("tagged_users")
    public ImmutableList<ComposerTaggedUser> getTaggedUsers() {
        return this.f6817w;
    }

    @JsonProperty("target_album")
    @Nullable
    public GraphQLAlbum getTargetAlbum() {
        return this.f6818x;
    }

    @JsonProperty("text_with_entities")
    public GraphQLTextWithEntities getTextWithEntities() {
        return this.f6819y;
    }

    @JsonProperty("topics")
    public ImmutableList<GraphQLExploreFeed> getTopics() {
        return this.f6820z;
    }

    @JsonProperty("user_selected_tags")
    public boolean isUserSelectedTags() {
        return this.f6794A;
    }
}
