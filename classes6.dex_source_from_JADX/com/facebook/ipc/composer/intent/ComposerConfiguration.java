package com.facebook.ipc.composer.intent;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.lifeevent.model.ComposerLifeEventModel;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLEditPostFeatureCapability;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.groupcommerce.model.GroupCommerceCategory;
import com.facebook.ipc.composer.model.ComposerCommerceInfo;
import com.facebook.ipc.composer.model.ComposerDateInfo;
import com.facebook.ipc.composer.model.ComposerFacecastInfo;
import com.facebook.ipc.composer.model.ComposerLaunchLoggingParams;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerSlideshowData;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.composer.model.ProductItemAttachment;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.ipc.composer.model.TargetType;
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
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

@AutoGenJsonSerializer
@JsonDeserialize(using = Deserializer.class)
@JsonSerialize(using = ComposerConfigurationSerializer.class)
/* compiled from: localItemCount */
public class ComposerConfiguration implements Parcelable {
    public static final Creator<ComposerConfiguration> CREATOR = new C07301();
    private static final ComposerConfigurationSpec$Validator f11500a = new ComposerConfigurationSpec$Validator();
    public final RedSpaceValue f11501A;
    @Nullable
    public final ComposerShareParams f11502B;
    @Nullable
    public final ComposerSlideshowData f11503C;
    @Nullable
    public final ComposerStickerData f11504D;
    public final ImmutableList<ComposerTaggedUser> f11505E;
    @Nullable
    public final GraphQLAlbum f11506F;
    public final ComposerTargetData f11507G;
    public final GraphQLTextWithEntities f11508H;
    public final boolean f11509I;
    public final boolean f11510J;
    public final boolean f11511K;
    public final boolean f11512L;
    public final boolean f11513M;
    public final ComposerLaunchLoggingParams f11514N;
    @Nullable
    public final String f11515O;
    @Nullable
    public final ComposerLifeEventModel f11516P;
    @Nullable
    public final MinutiaeObject f11517Q;
    @Nullable
    public final String f11518R;
    @Nullable
    public final CurationMechanism f11519S;
    @Nullable
    public final CurationSurface f11520T;
    @Nullable
    public final PlatformConfiguration f11521U;
    @Nullable
    public final SerializedComposerPluginConfig f11522V;
    @Nullable
    public final ProductItemAttachment f11523W;
    @Nullable
    public final Surface f11524X;
    @Nullable
    public final String f11525Y;
    public final boolean f11526Z;
    public final boolean aa;
    public final ComposerSourceType ab;
    @Nullable
    public final String ac;
    @Nullable
    public final String ad;
    public final ImmutableList<GraphQLExploreFeed> ae;
    public final boolean af;
    public final boolean f11527b;
    public final boolean f11528c;
    public final boolean f11529d;
    public final boolean f11530e;
    @Nullable
    public final GraphQLStory f11531f;
    @Nullable
    public final String f11532g;
    public final boolean f11533h;
    public final ComposerCommerceInfo f11534i;
    public final ComposerType f11535j;
    public final boolean f11536k;
    public final boolean f11537l;
    public final boolean f11538m;
    public final boolean f11539n;
    public final ImmutableList<GraphQLEditPostFeatureCapability> f11540o;
    @Nullable
    public final String f11541p;
    public final ImmutableList<GroupCommerceCategory> f11542q;
    public final boolean f11543r;
    @Nullable
    public final ComposerAppAttribution f11544s;
    public final ImmutableList<ComposerAttachment> f11545t;
    @Nullable
    public final ComposerDateInfo f11546u;
    public final ComposerFacecastInfo f11547v;
    public final ComposerLocationInfo f11548w;
    @Nullable
    public final ComposerPageData f11549x;
    @Nullable
    public final GraphQLPrivacyOption f11550y;
    public final int f11551z;

    /* compiled from: localItemCount */
    final class C07301 implements Creator<ComposerConfiguration> {
        C07301() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerConfiguration(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerConfiguration[i];
        }
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = ComposerConfiguration_BuilderDeserializer.class)
    /* compiled from: localItemCount */
    public class Builder {
        private static final ComposerCommerceInfo f11447a = ComposerCommerceInfo.newBuilder().a();
        private static final ComposerType f11448b = ComposerType.STATUS;
        private static final ComposerFacecastInfo f11449c = new com.facebook.ipc.composer.model.ComposerFacecastInfo.Builder().a();
        private static final ComposerLocationInfo f11450d = ComposerLocationInfo.newBuilder().b();
        private static final RedSpaceValue f11451e = RedSpaceValue.POST_TO_NEWSFEED;
        private static final ComposerTargetData f11452f = new com.facebook.ipc.composer.intent.ComposerTargetData.Builder().m18263a();
        private static final ComposerConfigurationSpec$InitialTextExtras f11453g = new ComposerConfigurationSpec$InitialTextExtras();
        private static final GraphQLTextWithEntities f11454h = GraphQLHelper.h;
        private static final ComposerLaunchLoggingParams f11455i = ComposerLaunchLoggingParams.newBuilder().a();
        private static final PlatformConfiguration f11456j = new com.facebook.ipc.composer.intent.PlatformConfiguration.Builder().m18275a();
        private static final ComposerSourceType f11457k = ComposerSourceType.UNKNOWN;
        public ImmutableList<GroupCommerceCategory> f11458A = RegularImmutableList.a;
        public boolean f11459B;
        @Nullable
        public ComposerAppAttribution f11460C;
        public ImmutableList<ComposerAttachment> f11461D = RegularImmutableList.a;
        @Nullable
        public ComposerDateInfo f11462E;
        public ComposerFacecastInfo f11463F = f11449c;
        public ComposerLocationInfo f11464G = f11450d;
        @Nullable
        public ComposerPageData f11465H;
        @Nullable
        public GraphQLPrivacyOption f11466I;
        public int f11467J;
        public RedSpaceValue f11468K = f11451e;
        @Nullable
        public ComposerShareParams f11469L;
        @Nullable
        public ComposerSlideshowData f11470M;
        @Nullable
        public ComposerStickerData f11471N;
        public ImmutableList<ComposerTaggedUser> f11472O = RegularImmutableList.a;
        @Nullable
        public GraphQLAlbum f11473P;
        public ComposerTargetData f11474Q = f11452f;
        public GraphQLTextWithEntities f11475R = f11454h;
        public boolean f11476S;
        public boolean f11477T;
        public boolean f11478U;
        public boolean f11479V;
        public boolean f11480W;
        public ComposerLaunchLoggingParams f11481X = f11455i;
        @Nullable
        public String f11482Y;
        @Nullable
        public ComposerLifeEventModel f11483Z;
        @Nullable
        public MinutiaeObject aa;
        @Nullable
        public String ab;
        @Nullable
        public CurationMechanism ac;
        @Nullable
        public CurationSurface ad;
        @Nullable
        public PlatformConfiguration ae = f11456j;
        @Nullable
        public SerializedComposerPluginConfig af;
        @Nullable
        public ProductItemAttachment ag;
        @Nullable
        public Surface ah;
        @Nullable
        public String ai;
        public boolean aj;
        public boolean ak;
        public ComposerSourceType al = f11457k;
        @Nullable
        public String am;
        @Nullable
        public String an;
        public ImmutableList<GraphQLExploreFeed> ao = RegularImmutableList.a;
        public boolean ap;
        public boolean f11484l;
        public boolean f11485m;
        public boolean f11486n;
        public boolean f11487o;
        @Nullable
        public GraphQLStory f11488p;
        @Nullable
        public String f11489q;
        public boolean f11490r;
        public ComposerCommerceInfo f11491s = f11447a;
        public ComposerType f11492t = f11448b;
        public boolean f11493u;
        public boolean f11494v;
        public boolean f11495w;
        public boolean f11496x;
        public ImmutableList<GraphQLEditPostFeatureCapability> f11497y = RegularImmutableList.a;
        @Nullable
        public String f11498z;

        static {
            ComposerConfigurationSpec$CommerceInfoDefaultValueProvider composerConfigurationSpec$CommerceInfoDefaultValueProvider = new ComposerConfigurationSpec$CommerceInfoDefaultValueProvider();
            ComposerConfigurationSpec$ComposerTypeDefaultValueProvider composerConfigurationSpec$ComposerTypeDefaultValueProvider = new ComposerConfigurationSpec$ComposerTypeDefaultValueProvider();
            C0733x2be41cdc c0733x2be41cdc = new C0733x2be41cdc();
            C0734x8463e675 c0734x8463e675 = new C0734x8463e675();
            C0732xde2f52bf c0732xde2f52bf = new C0732xde2f52bf();
            ComposerConfigurationSpec$InitialTargetDataDefaultValueProvider composerConfigurationSpec$InitialTargetDataDefaultValueProvider = new ComposerConfigurationSpec$InitialTargetDataDefaultValueProvider();
            ComposerConfigurationSpec$InitialTextExtras composerConfigurationSpec$InitialTextExtras = new ComposerConfigurationSpec$InitialTextExtras();
            C0731x418e3220 c0731x418e3220 = new C0731x418e3220();
            C0735xfcfdbd11 c0735xfcfdbd11 = new C0735xfcfdbd11();
            ComposerConfigurationSpec$ComposerSourceTypeDefaultValueProvider composerConfigurationSpec$ComposerSourceTypeDefaultValueProvider = new ComposerConfigurationSpec$ComposerSourceTypeDefaultValueProvider();
        }

        public Builder(ComposerConfiguration composerConfiguration) {
            Preconditions.checkNotNull(composerConfiguration);
            if (composerConfiguration instanceof ComposerConfiguration) {
                composerConfiguration = composerConfiguration;
                this.f11484l = composerConfiguration.f11527b;
                this.f11485m = composerConfiguration.f11528c;
                this.f11486n = composerConfiguration.f11529d;
                this.f11487o = composerConfiguration.f11530e;
                this.f11488p = composerConfiguration.f11531f;
                this.f11489q = composerConfiguration.f11532g;
                this.f11490r = composerConfiguration.f11533h;
                this.f11491s = composerConfiguration.f11534i;
                this.f11492t = composerConfiguration.f11535j;
                this.f11493u = composerConfiguration.f11536k;
                this.f11494v = composerConfiguration.f11537l;
                this.f11495w = composerConfiguration.f11538m;
                this.f11496x = composerConfiguration.f11539n;
                this.f11497y = composerConfiguration.f11540o;
                this.f11498z = composerConfiguration.f11541p;
                this.f11458A = composerConfiguration.f11542q;
                this.f11459B = composerConfiguration.f11543r;
                this.f11460C = composerConfiguration.f11544s;
                this.f11461D = composerConfiguration.f11545t;
                this.f11462E = composerConfiguration.f11546u;
                this.f11463F = composerConfiguration.f11547v;
                this.f11464G = composerConfiguration.f11548w;
                this.f11465H = composerConfiguration.f11549x;
                this.f11466I = composerConfiguration.f11550y;
                this.f11467J = composerConfiguration.f11551z;
                this.f11468K = composerConfiguration.f11501A;
                this.f11469L = composerConfiguration.f11502B;
                this.f11470M = composerConfiguration.f11503C;
                this.f11471N = composerConfiguration.f11504D;
                this.f11472O = composerConfiguration.f11505E;
                this.f11473P = composerConfiguration.f11506F;
                this.f11474Q = composerConfiguration.f11507G;
                this.f11475R = composerConfiguration.f11508H;
                this.f11476S = composerConfiguration.f11509I;
                this.f11477T = composerConfiguration.f11510J;
                this.f11478U = composerConfiguration.f11511K;
                this.f11479V = composerConfiguration.f11512L;
                this.f11480W = composerConfiguration.f11513M;
                this.f11481X = composerConfiguration.f11514N;
                this.f11482Y = composerConfiguration.f11515O;
                this.f11483Z = composerConfiguration.f11516P;
                this.aa = composerConfiguration.f11517Q;
                this.ab = composerConfiguration.f11518R;
                this.ac = composerConfiguration.f11519S;
                this.ad = composerConfiguration.f11520T;
                this.ae = composerConfiguration.f11521U;
                this.af = composerConfiguration.f11522V;
                this.ag = composerConfiguration.f11523W;
                this.ah = composerConfiguration.f11524X;
                this.ai = composerConfiguration.f11525Y;
                this.aj = composerConfiguration.f11526Z;
                this.ak = composerConfiguration.aa;
                this.al = composerConfiguration.ab;
                this.am = composerConfiguration.ac;
                this.an = composerConfiguration.ad;
                this.ao = composerConfiguration.ae;
                this.ap = composerConfiguration.af;
                return;
            }
            this.f11484l = composerConfiguration.getAllowDynamicTextStyle();
            this.f11485m = composerConfiguration.getAllowFeedOnlyPost();
            this.f11486n = composerConfiguration.getAllowTargetSelection();
            this.f11487o = composerConfiguration.getAllowsRedSpaceToggle();
            this.f11488p = composerConfiguration.getAttachedStory();
            this.f11489q = composerConfiguration.getCacheId();
            this.f11490r = composerConfiguration.canViewerEditPostMedia();
            this.f11491s = composerConfiguration.getCommerceInfo();
            this.f11492t = composerConfiguration.getComposerType();
            this.f11493u = composerConfiguration.shouldDisableAttachToAlbum();
            this.f11494v = composerConfiguration.shouldDisableFriendTagging();
            this.f11495w = composerConfiguration.shouldDisableMentions();
            this.f11496x = composerConfiguration.shouldDisablePhotos();
            this.f11497y = composerConfiguration.getEditPostFeatureCapabilities();
            this.f11498z = composerConfiguration.getExternalRefName();
            this.f11458A = composerConfiguration.getGroupCommerceCategories();
            this.f11459B = composerConfiguration.shouldHideKeyboardIfReachedMinimumHeight();
            this.f11460C = composerConfiguration.getInitialAppAttribution();
            this.f11461D = composerConfiguration.getInitialAttachments();
            this.f11462E = composerConfiguration.getInitialDateInfo();
            this.f11463F = composerConfiguration.getInitialFacecastInfo();
            this.f11464G = composerConfiguration.getInitialLocationInfo();
            this.f11465H = composerConfiguration.getInitialPageData();
            this.f11466I = composerConfiguration.getInitialPrivacyOverride();
            this.f11467J = composerConfiguration.getInitialRating();
            this.f11468K = composerConfiguration.getInitialRedSpaceValue();
            this.f11469L = composerConfiguration.getInitialShareParams();
            this.f11470M = composerConfiguration.getInitialSlideshowData();
            this.f11471N = composerConfiguration.getInitialStickerData();
            this.f11472O = composerConfiguration.getInitialTaggedUsers();
            this.f11473P = composerConfiguration.getInitialTargetAlbum();
            this.f11474Q = composerConfiguration.getInitialTargetData();
            this.f11475R = composerConfiguration.getInitialText();
            this.f11476S = composerConfiguration.isEdit();
            this.f11477T = composerConfiguration.isEditPrivacyEnabled();
            this.f11478U = composerConfiguration.isEditTagEnabled();
            this.f11479V = composerConfiguration.isFireAndForget();
            this.f11480W = composerConfiguration.isThrowbackPost();
            this.f11481X = composerConfiguration.getLaunchLoggingParams();
            this.f11482Y = composerConfiguration.getLegacyApiStoryId();
            this.f11483Z = composerConfiguration.m18226a();
            this.aa = composerConfiguration.getMinutiaeObjectTag();
            this.ab = composerConfiguration.getNectarModule();
            this.ac = composerConfiguration.getOgMechanism();
            this.ad = composerConfiguration.getOgSurface();
            this.ae = composerConfiguration.getPlatformConfiguration();
            this.af = composerConfiguration.getPluginConfig();
            this.ag = composerConfiguration.getProductItemAttachment();
            this.ah = composerConfiguration.getReactionSurface();
            this.ai = composerConfiguration.getReactionUnitId();
            this.aj = composerConfiguration.getShouldPickerSupportLiveCamera();
            this.ak = composerConfiguration.shouldPostToMarketplaceByDefault();
            this.al = composerConfiguration.getSourceType();
            this.am = composerConfiguration.getStoryId();
            this.an = composerConfiguration.getTopicFeedId();
            this.ao = composerConfiguration.getTopics();
            this.ap = composerConfiguration.shouldUseOptimisticPosting();
        }

        public final ComposerConfiguration m18223a() {
            return new ComposerConfiguration(this);
        }

        @JsonProperty("allow_dynamic_text_style")
        public Builder setAllowDynamicTextStyle(boolean z) {
            this.f11484l = z;
            return this;
        }

        @JsonProperty("allow_feed_only_post")
        public Builder setAllowFeedOnlyPost(boolean z) {
            this.f11485m = z;
            return this;
        }

        @JsonProperty("allow_target_selection")
        public Builder setAllowTargetSelection(boolean z) {
            this.f11486n = z;
            return this;
        }

        @JsonProperty("allows_red_space_toggle")
        public Builder setAllowsRedSpaceToggle(boolean z) {
            this.f11487o = z;
            return this;
        }

        @JsonProperty("attached_story")
        public Builder setAttachedStory(@Nullable GraphQLStory graphQLStory) {
            this.f11488p = graphQLStory;
            return this;
        }

        @JsonProperty("cache_id")
        public Builder setCacheId(@Nullable String str) {
            this.f11489q = str;
            return this;
        }

        @JsonProperty("can_viewer_edit_post_media")
        public Builder setCanViewerEditPostMedia(boolean z) {
            this.f11490r = z;
            return this;
        }

        @JsonProperty("commerce_info")
        public Builder setCommerceInfo(ComposerCommerceInfo composerCommerceInfo) {
            this.f11491s = composerCommerceInfo;
            return this;
        }

        @JsonProperty("composer_type")
        public Builder setComposerType(ComposerType composerType) {
            this.f11492t = composerType;
            return this;
        }

        @JsonProperty("disable_attach_to_album")
        public Builder setDisableAttachToAlbum(boolean z) {
            this.f11493u = z;
            return this;
        }

        @JsonProperty("disable_friend_tagging")
        public Builder setDisableFriendTagging(boolean z) {
            this.f11494v = z;
            return this;
        }

        @JsonProperty("disable_mentions")
        public Builder setDisableMentions(boolean z) {
            this.f11495w = z;
            return this;
        }

        @JsonProperty("disable_photos")
        public Builder setDisablePhotos(boolean z) {
            this.f11496x = z;
            return this;
        }

        @JsonProperty("edit_post_feature_capabilities")
        public Builder setEditPostFeatureCapabilities(ImmutableList<GraphQLEditPostFeatureCapability> immutableList) {
            this.f11497y = immutableList;
            return this;
        }

        @JsonProperty("external_ref_name")
        public Builder setExternalRefName(@Nullable String str) {
            this.f11498z = str;
            return this;
        }

        @JsonProperty("group_commerce_categories")
        public Builder setGroupCommerceCategories(ImmutableList<GroupCommerceCategory> immutableList) {
            this.f11458A = immutableList;
            return this;
        }

        @JsonProperty("hide_keyboard_if_reached_minimum_height")
        public Builder setHideKeyboardIfReachedMinimumHeight(boolean z) {
            this.f11459B = z;
            return this;
        }

        @JsonProperty("initial_app_attribution")
        public Builder setInitialAppAttribution(@Nullable ComposerAppAttribution composerAppAttribution) {
            this.f11460C = composerAppAttribution;
            return this;
        }

        @JsonProperty("initial_attachments")
        public Builder setInitialAttachments(ImmutableList<ComposerAttachment> immutableList) {
            this.f11461D = immutableList;
            return this;
        }

        @JsonProperty("initial_date_info")
        public Builder setInitialDateInfo(@Nullable ComposerDateInfo composerDateInfo) {
            this.f11462E = composerDateInfo;
            return this;
        }

        @JsonProperty("initial_facecast_info")
        public Builder setInitialFacecastInfo(ComposerFacecastInfo composerFacecastInfo) {
            this.f11463F = composerFacecastInfo;
            return this;
        }

        @JsonProperty("initial_location_info")
        public Builder setInitialLocationInfo(ComposerLocationInfo composerLocationInfo) {
            this.f11464G = composerLocationInfo;
            return this;
        }

        @JsonProperty("initial_page_data")
        public Builder setInitialPageData(@Nullable ComposerPageData composerPageData) {
            this.f11465H = composerPageData;
            return this;
        }

        @JsonProperty("initial_privacy_override")
        public Builder setInitialPrivacyOverride(@Nullable GraphQLPrivacyOption graphQLPrivacyOption) {
            this.f11466I = graphQLPrivacyOption;
            return this;
        }

        @JsonProperty("initial_rating")
        public Builder setInitialRating(int i) {
            this.f11467J = i;
            return this;
        }

        @JsonProperty("initial_red_space_value")
        public Builder setInitialRedSpaceValue(RedSpaceValue redSpaceValue) {
            this.f11468K = redSpaceValue;
            return this;
        }

        @JsonProperty("initial_share_params")
        public Builder setInitialShareParams(@Nullable ComposerShareParams composerShareParams) {
            this.f11469L = composerShareParams;
            return this;
        }

        @JsonProperty("initial_slideshow_data")
        public Builder setInitialSlideshowData(@Nullable ComposerSlideshowData composerSlideshowData) {
            this.f11470M = composerSlideshowData;
            return this;
        }

        @JsonProperty("initial_sticker_data")
        public Builder setInitialStickerData(@Nullable ComposerStickerData composerStickerData) {
            this.f11471N = composerStickerData;
            return this;
        }

        @JsonProperty("initial_tagged_users")
        public Builder setInitialTaggedUsers(ImmutableList<ComposerTaggedUser> immutableList) {
            this.f11472O = immutableList;
            return this;
        }

        @JsonProperty("initial_target_album")
        public Builder setInitialTargetAlbum(@Nullable GraphQLAlbum graphQLAlbum) {
            this.f11473P = graphQLAlbum;
            return this;
        }

        @JsonProperty("initial_target_data")
        public Builder setInitialTargetData(ComposerTargetData composerTargetData) {
            this.f11474Q = composerTargetData;
            return this;
        }

        @JsonProperty("initial_text")
        public Builder setInitialText(GraphQLTextWithEntities graphQLTextWithEntities) {
            this.f11475R = ComposerConfigurationSpec$InitialTextExtras.m18229a(graphQLTextWithEntities);
            return this;
        }

        @JsonProperty("is_edit")
        public Builder setIsEdit(boolean z) {
            this.f11476S = z;
            return this;
        }

        @JsonProperty("is_edit_privacy_enabled")
        public Builder setIsEditPrivacyEnabled(boolean z) {
            this.f11477T = z;
            return this;
        }

        @JsonProperty("is_edit_tag_enabled")
        public Builder setIsEditTagEnabled(boolean z) {
            this.f11478U = z;
            return this;
        }

        @JsonProperty("is_fire_and_forget")
        public Builder setIsFireAndForget(boolean z) {
            this.f11479V = z;
            return this;
        }

        @JsonProperty("is_throwback_post")
        public Builder setIsThrowbackPost(boolean z) {
            this.f11480W = z;
            return this;
        }

        @JsonProperty("launch_logging_params")
        public Builder setLaunchLoggingParams(ComposerLaunchLoggingParams composerLaunchLoggingParams) {
            this.f11481X = composerLaunchLoggingParams;
            return this;
        }

        @JsonProperty("legacy_api_story_id")
        public Builder setLegacyApiStoryId(@Nullable String str) {
            this.f11482Y = str;
            return this;
        }

        @JsonIgnore
        public final Builder m18222a(@Nullable ComposerLifeEventModel composerLifeEventModel) {
            this.f11483Z = composerLifeEventModel;
            return this;
        }

        @JsonProperty("minutiae_object_tag")
        public Builder setMinutiaeObjectTag(@Nullable MinutiaeObject minutiaeObject) {
            this.aa = minutiaeObject;
            return this;
        }

        @JsonProperty("nectar_module")
        public Builder setNectarModule(@Nullable String str) {
            this.ab = str;
            return this;
        }

        @JsonProperty("og_mechanism")
        public Builder setOgMechanism(@Nullable CurationMechanism curationMechanism) {
            this.ac = curationMechanism;
            return this;
        }

        @JsonProperty("og_surface")
        public Builder setOgSurface(@Nullable CurationSurface curationSurface) {
            this.ad = curationSurface;
            return this;
        }

        @JsonProperty("platform_configuration")
        public Builder setPlatformConfiguration(@Nullable PlatformConfiguration platformConfiguration) {
            this.ae = platformConfiguration;
            return this;
        }

        @JsonProperty("plugin_config")
        public Builder setPluginConfig(@Nullable SerializedComposerPluginConfig serializedComposerPluginConfig) {
            this.af = serializedComposerPluginConfig;
            return this;
        }

        @JsonProperty("product_item_attachment")
        public Builder setProductItemAttachment(@Nullable ProductItemAttachment productItemAttachment) {
            this.ag = productItemAttachment;
            return this;
        }

        @JsonProperty("reaction_surface")
        public Builder setReactionSurface(@Nullable Surface surface) {
            this.ah = surface;
            return this;
        }

        @JsonProperty("reaction_unit_id")
        public Builder setReactionUnitId(@Nullable String str) {
            this.ai = str;
            return this;
        }

        @JsonProperty("should_picker_support_live_camera")
        public Builder setShouldPickerSupportLiveCamera(boolean z) {
            this.aj = z;
            return this;
        }

        @JsonProperty("should_post_to_marketplace_by_default")
        public Builder setShouldPostToMarketplaceByDefault(boolean z) {
            this.ak = z;
            return this;
        }

        @JsonProperty("source_type")
        public Builder setSourceType(ComposerSourceType composerSourceType) {
            this.al = composerSourceType;
            return this;
        }

        @JsonProperty("story_id")
        public Builder setStoryId(@Nullable String str) {
            this.am = str;
            return this;
        }

        @JsonProperty("topic_feed_id")
        public Builder setTopicFeedId(@Nullable String str) {
            this.an = str;
            return this;
        }

        @JsonProperty("topics")
        public Builder setTopics(ImmutableList<GraphQLExploreFeed> immutableList) {
            this.ao = immutableList;
            return this;
        }

        @JsonProperty("use_optimistic_posting")
        public Builder setUseOptimisticPosting(boolean z) {
            this.ap = z;
            return this;
        }
    }

    /* compiled from: localItemCount */
    class Deserializer extends JsonDeserializer<ComposerConfiguration> {
        private static final ComposerConfiguration_BuilderDeserializer f11499a = new ComposerConfiguration_BuilderDeserializer();

        private Deserializer() {
        }

        public Object m18224a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return ((Builder) f11499a.a(jsonParser, deserializationContext)).m18223a();
        }
    }

    public ComposerConfiguration(Builder builder) {
        boolean z;
        this.f11527b = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f11484l))).booleanValue();
        this.f11528c = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f11485m))).booleanValue();
        this.f11529d = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f11486n))).booleanValue();
        this.f11530e = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f11487o))).booleanValue();
        this.f11531f = builder.f11488p;
        this.f11532g = builder.f11489q;
        this.f11533h = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f11490r))).booleanValue();
        this.f11534i = (ComposerCommerceInfo) Preconditions.checkNotNull(builder.f11491s);
        this.f11535j = (ComposerType) Preconditions.checkNotNull(builder.f11492t);
        this.f11536k = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f11493u))).booleanValue();
        this.f11537l = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f11494v))).booleanValue();
        this.f11538m = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f11495w))).booleanValue();
        this.f11539n = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f11496x))).booleanValue();
        this.f11540o = (ImmutableList) Preconditions.checkNotNull(builder.f11497y);
        this.f11541p = builder.f11498z;
        this.f11542q = (ImmutableList) Preconditions.checkNotNull(builder.f11458A);
        this.f11543r = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f11459B))).booleanValue();
        this.f11544s = builder.f11460C;
        this.f11545t = (ImmutableList) Preconditions.checkNotNull(builder.f11461D);
        this.f11546u = builder.f11462E;
        this.f11547v = (ComposerFacecastInfo) Preconditions.checkNotNull(builder.f11463F);
        this.f11548w = (ComposerLocationInfo) Preconditions.checkNotNull(builder.f11464G);
        this.f11549x = builder.f11465H;
        this.f11550y = builder.f11466I;
        this.f11551z = ((Integer) Preconditions.checkNotNull(Integer.valueOf(builder.f11467J))).intValue();
        this.f11501A = (RedSpaceValue) Preconditions.checkNotNull(builder.f11468K);
        this.f11502B = builder.f11469L;
        this.f11503C = builder.f11470M;
        this.f11504D = builder.f11471N;
        this.f11505E = (ImmutableList) Preconditions.checkNotNull(builder.f11472O);
        this.f11506F = builder.f11473P;
        this.f11507G = (ComposerTargetData) Preconditions.checkNotNull(builder.f11474Q);
        this.f11508H = (GraphQLTextWithEntities) Preconditions.checkNotNull(builder.f11475R);
        this.f11509I = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f11476S))).booleanValue();
        this.f11510J = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f11477T))).booleanValue();
        this.f11511K = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f11478U))).booleanValue();
        this.f11512L = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f11479V))).booleanValue();
        this.f11513M = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f11480W))).booleanValue();
        this.f11514N = (ComposerLaunchLoggingParams) Preconditions.checkNotNull(builder.f11481X);
        this.f11515O = builder.f11482Y;
        this.f11516P = builder.f11483Z;
        this.f11517Q = builder.aa;
        this.f11518R = builder.ab;
        this.f11519S = builder.ac;
        this.f11520T = builder.ad;
        this.f11521U = builder.ae;
        this.f11522V = builder.af;
        this.f11523W = builder.ag;
        this.f11524X = builder.ah;
        this.f11525Y = builder.ai;
        this.f11526Z = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.aj))).booleanValue();
        this.aa = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.ak))).booleanValue();
        this.ab = (ComposerSourceType) Preconditions.checkNotNull(builder.al);
        this.ac = builder.am;
        this.ad = builder.an;
        this.ae = (ImmutableList) Preconditions.checkNotNull(builder.ao);
        this.af = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.ap))).booleanValue();
        boolean z2 = true;
        boolean z3 = (getComposerType() == ComposerType.SHARE && getInitialShareParams() == null) ? false : true;
        Preconditions.checkArgument(z3);
        if (getComposerType() == ComposerType.RECOMMENDATION) {
            Preconditions.checkNotNull(getOgMechanism());
            Preconditions.checkNotNull(getOgSurface());
            Preconditions.checkNotNull(getInitialTargetData());
            Preconditions.checkNotNull(Long.valueOf(getInitialTargetData().targetId));
            Preconditions.checkNotNull(getInitialTargetData().targetName);
        }
        z3 = getInitialTargetData().actsAsTarget && (getInitialTargetData().targetType == TargetType.PAGE || getInitialTargetData().targetType == TargetType.EVENT);
        if (getInitialPageData() == null || getInitialPageData().getPostAsPageViewerContext() == null) {
            z = false;
        } else {
            z = true;
        }
        if (z3 != z) {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "targetDataActsAsPage is " + z3 + " but hasPageVC is " + z);
    }

    public ComposerConfiguration(Parcel parcel) {
        boolean z;
        int i;
        boolean z2 = true;
        this.f11527b = parcel.readInt() == 1;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f11528c = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f11529d = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f11530e = z;
        if (parcel.readInt() == 0) {
            this.f11531f = null;
        } else {
            this.f11531f = (GraphQLStory) FlatBufferModelHelper.a(parcel);
        }
        if (parcel.readInt() == 0) {
            this.f11532g = null;
        } else {
            this.f11532g = parcel.readString();
        }
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f11533h = z;
        this.f11534i = (ComposerCommerceInfo) parcel.readParcelable(ComposerCommerceInfo.class.getClassLoader());
        this.f11535j = ComposerType.valueOf(parcel.readString());
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f11536k = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f11537l = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f11538m = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f11539n = z;
        GraphQLEditPostFeatureCapability[] graphQLEditPostFeatureCapabilityArr = new GraphQLEditPostFeatureCapability[parcel.readInt()];
        for (int i2 = 0; i2 < graphQLEditPostFeatureCapabilityArr.length; i2++) {
            graphQLEditPostFeatureCapabilityArr[i2] = GraphQLEditPostFeatureCapability.valueOf(parcel.readString());
        }
        this.f11540o = ImmutableList.copyOf(graphQLEditPostFeatureCapabilityArr);
        if (parcel.readInt() == 0) {
            this.f11541p = null;
        } else {
            this.f11541p = parcel.readString();
        }
        GroupCommerceCategory[] groupCommerceCategoryArr = new GroupCommerceCategory[parcel.readInt()];
        for (i = 0; i < groupCommerceCategoryArr.length; i++) {
            groupCommerceCategoryArr[i] = (GroupCommerceCategory) parcel.readParcelable(GroupCommerceCategory.class.getClassLoader());
        }
        this.f11542q = ImmutableList.copyOf(groupCommerceCategoryArr);
        this.f11543r = parcel.readInt() == 1;
        if (parcel.readInt() == 0) {
            this.f11544s = null;
        } else {
            this.f11544s = (ComposerAppAttribution) parcel.readParcelable(ComposerAppAttribution.class.getClassLoader());
        }
        ComposerAttachment[] composerAttachmentArr = new ComposerAttachment[parcel.readInt()];
        for (i = 0; i < composerAttachmentArr.length; i++) {
            composerAttachmentArr[i] = (ComposerAttachment) parcel.readParcelable(ComposerAttachment.class.getClassLoader());
        }
        this.f11545t = ImmutableList.copyOf(composerAttachmentArr);
        if (parcel.readInt() == 0) {
            this.f11546u = null;
        } else {
            this.f11546u = (ComposerDateInfo) parcel.readParcelable(ComposerDateInfo.class.getClassLoader());
        }
        this.f11547v = (ComposerFacecastInfo) parcel.readParcelable(ComposerFacecastInfo.class.getClassLoader());
        this.f11548w = (ComposerLocationInfo) parcel.readParcelable(ComposerLocationInfo.class.getClassLoader());
        if (parcel.readInt() == 0) {
            this.f11549x = null;
        } else {
            this.f11549x = (ComposerPageData) parcel.readParcelable(ComposerPageData.class.getClassLoader());
        }
        if (parcel.readInt() == 0) {
            this.f11550y = null;
        } else {
            this.f11550y = (GraphQLPrivacyOption) FlatBufferModelHelper.a(parcel);
        }
        this.f11551z = parcel.readInt();
        this.f11501A = RedSpaceValue.valueOf(parcel.readString());
        if (parcel.readInt() == 0) {
            this.f11502B = null;
        } else {
            this.f11502B = (ComposerShareParams) parcel.readParcelable(ComposerShareParams.class.getClassLoader());
        }
        if (parcel.readInt() == 0) {
            this.f11503C = null;
        } else {
            this.f11503C = (ComposerSlideshowData) parcel.readParcelable(ComposerSlideshowData.class.getClassLoader());
        }
        if (parcel.readInt() == 0) {
            this.f11504D = null;
        } else {
            this.f11504D = (ComposerStickerData) parcel.readParcelable(ComposerStickerData.class.getClassLoader());
        }
        ComposerTaggedUser[] composerTaggedUserArr = new ComposerTaggedUser[parcel.readInt()];
        for (i = 0; i < composerTaggedUserArr.length; i++) {
            composerTaggedUserArr[i] = (ComposerTaggedUser) parcel.readParcelable(ComposerTaggedUser.class.getClassLoader());
        }
        this.f11505E = ImmutableList.copyOf(composerTaggedUserArr);
        if (parcel.readInt() == 0) {
            this.f11506F = null;
        } else {
            this.f11506F = (GraphQLAlbum) FlatBufferModelHelper.a(parcel);
        }
        this.f11507G = (ComposerTargetData) parcel.readParcelable(ComposerTargetData.class.getClassLoader());
        this.f11508H = (GraphQLTextWithEntities) FlatBufferModelHelper.a(parcel);
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f11509I = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f11510J = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f11511K = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f11512L = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f11513M = z;
        this.f11514N = (ComposerLaunchLoggingParams) parcel.readParcelable(ComposerLaunchLoggingParams.class.getClassLoader());
        if (parcel.readInt() == 0) {
            this.f11515O = null;
        } else {
            this.f11515O = parcel.readString();
        }
        if (parcel.readInt() == 0) {
            this.f11516P = null;
        } else {
            this.f11516P = (ComposerLifeEventModel) parcel.readParcelable(ComposerLifeEventModel.class.getClassLoader());
        }
        if (parcel.readInt() == 0) {
            this.f11517Q = null;
        } else {
            this.f11517Q = (MinutiaeObject) parcel.readParcelable(MinutiaeObject.class.getClassLoader());
        }
        if (parcel.readInt() == 0) {
            this.f11518R = null;
        } else {
            this.f11518R = parcel.readString();
        }
        if (parcel.readInt() == 0) {
            this.f11519S = null;
        } else {
            this.f11519S = CurationMechanism.valueOf(parcel.readString());
        }
        if (parcel.readInt() == 0) {
            this.f11520T = null;
        } else {
            this.f11520T = CurationSurface.valueOf(parcel.readString());
        }
        if (parcel.readInt() == 0) {
            this.f11521U = null;
        } else {
            this.f11521U = (PlatformConfiguration) parcel.readParcelable(PlatformConfiguration.class.getClassLoader());
        }
        if (parcel.readInt() == 0) {
            this.f11522V = null;
        } else {
            this.f11522V = (SerializedComposerPluginConfig) parcel.readParcelable(SerializedComposerPluginConfig.class.getClassLoader());
        }
        if (parcel.readInt() == 0) {
            this.f11523W = null;
        } else {
            this.f11523W = (ProductItemAttachment) parcel.readParcelable(ProductItemAttachment.class.getClassLoader());
        }
        if (parcel.readInt() == 0) {
            this.f11524X = null;
        } else {
            this.f11524X = Surface.valueOf(parcel.readString());
        }
        if (parcel.readInt() == 0) {
            this.f11525Y = null;
        } else {
            this.f11525Y = parcel.readString();
        }
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f11526Z = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.aa = z;
        this.ab = ComposerSourceType.valueOf(parcel.readString());
        if (parcel.readInt() == 0) {
            this.ac = null;
        } else {
            this.ac = parcel.readString();
        }
        if (parcel.readInt() == 0) {
            this.ad = null;
        } else {
            this.ad = parcel.readString();
        }
        GraphQLExploreFeed[] graphQLExploreFeedArr = new GraphQLExploreFeed[parcel.readInt()];
        for (i = 0; i < graphQLExploreFeedArr.length; i++) {
            graphQLExploreFeedArr[i] = (GraphQLExploreFeed) FlatBufferModelHelper.a(parcel);
        }
        this.ae = ImmutableList.copyOf(graphQLExploreFeedArr);
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.af = z2;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder m18225a(ComposerConfiguration composerConfiguration) {
        return new Builder(composerConfiguration);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3;
        int i4 = 1;
        parcel.writeInt(this.f11527b ? 1 : 0);
        if (this.f11528c) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f11529d) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f11530e) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f11531f == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            FlatBufferModelHelper.a(parcel, this.f11531f);
        }
        if (this.f11532g == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(this.f11532g);
        }
        if (this.f11533h) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeParcelable(this.f11534i, i);
        parcel.writeString(this.f11535j.name());
        if (this.f11536k) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f11537l) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f11538m) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f11539n) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.f11540o.size());
        int size = this.f11540o.size();
        for (i3 = 0; i3 < size; i3++) {
            parcel.writeString(((GraphQLEditPostFeatureCapability) this.f11540o.get(i3)).name());
        }
        if (this.f11541p == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(this.f11541p);
        }
        parcel.writeInt(this.f11542q.size());
        size = this.f11542q.size();
        for (i3 = 0; i3 < size; i3++) {
            parcel.writeParcelable((GroupCommerceCategory) this.f11542q.get(i3), i);
        }
        parcel.writeInt(this.f11543r ? 1 : 0);
        if (this.f11544s == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f11544s, i);
        }
        parcel.writeInt(this.f11545t.size());
        size = this.f11545t.size();
        for (i3 = 0; i3 < size; i3++) {
            parcel.writeParcelable((ComposerAttachment) this.f11545t.get(i3), i);
        }
        if (this.f11546u == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f11546u, i);
        }
        parcel.writeParcelable(this.f11547v, i);
        parcel.writeParcelable(this.f11548w, i);
        if (this.f11549x == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f11549x, i);
        }
        if (this.f11550y == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            FlatBufferModelHelper.a(parcel, this.f11550y);
        }
        parcel.writeInt(this.f11551z);
        parcel.writeString(this.f11501A.name());
        if (this.f11502B == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f11502B, i);
        }
        if (this.f11503C == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f11503C, i);
        }
        if (this.f11504D == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f11504D, i);
        }
        parcel.writeInt(this.f11505E.size());
        size = this.f11505E.size();
        for (i3 = 0; i3 < size; i3++) {
            parcel.writeParcelable((ComposerTaggedUser) this.f11505E.get(i3), i);
        }
        if (this.f11506F == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            FlatBufferModelHelper.a(parcel, this.f11506F);
        }
        parcel.writeParcelable(this.f11507G, i);
        FlatBufferModelHelper.a(parcel, this.f11508H);
        if (this.f11509I) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f11510J) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f11511K) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f11512L) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f11513M) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeParcelable(this.f11514N, i);
        if (this.f11515O == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(this.f11515O);
        }
        if (this.f11516P == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f11516P, i);
        }
        if (this.f11517Q == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f11517Q, i);
        }
        if (this.f11518R == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(this.f11518R);
        }
        if (this.f11519S == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(this.f11519S.name());
        }
        if (this.f11520T == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(this.f11520T.name());
        }
        if (this.f11521U == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f11521U, i);
        }
        if (this.f11522V == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f11522V, i);
        }
        if (this.f11523W == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f11523W, i);
        }
        if (this.f11524X == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(this.f11524X.name());
        }
        if (this.f11525Y == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(this.f11525Y);
        }
        if (this.f11526Z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.aa) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.ab.name());
        if (this.ac == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(this.ac);
        }
        if (this.ad == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(this.ad);
        }
        parcel.writeInt(this.ae.size());
        size = this.ae.size();
        for (i3 = 0; i3 < size; i3++) {
            FlatBufferModelHelper.a(parcel, (GraphQLExploreFeed) this.ae.get(i3));
        }
        if (!this.af) {
            i4 = 0;
        }
        parcel.writeInt(i4);
    }

    public int describeContents() {
        return 0;
    }

    @JsonProperty("allow_dynamic_text_style")
    public boolean getAllowDynamicTextStyle() {
        return this.f11527b;
    }

    @JsonProperty("allow_feed_only_post")
    public boolean getAllowFeedOnlyPost() {
        return this.f11528c;
    }

    @JsonProperty("allow_target_selection")
    public boolean getAllowTargetSelection() {
        return this.f11529d;
    }

    @JsonProperty("allows_red_space_toggle")
    public boolean getAllowsRedSpaceToggle() {
        return this.f11530e;
    }

    @JsonProperty("attached_story")
    @Nullable
    public GraphQLStory getAttachedStory() {
        return this.f11531f;
    }

    @JsonProperty("cache_id")
    @Nullable
    public String getCacheId() {
        return this.f11532g;
    }

    @JsonProperty("can_viewer_edit_post_media")
    public boolean canViewerEditPostMedia() {
        return this.f11533h;
    }

    @JsonProperty("commerce_info")
    public ComposerCommerceInfo getCommerceInfo() {
        return this.f11534i;
    }

    @JsonProperty("composer_type")
    public ComposerType getComposerType() {
        return this.f11535j;
    }

    @JsonProperty("disable_attach_to_album")
    public boolean shouldDisableAttachToAlbum() {
        return this.f11536k;
    }

    @JsonProperty("disable_friend_tagging")
    public boolean shouldDisableFriendTagging() {
        return this.f11537l;
    }

    @JsonProperty("disable_mentions")
    public boolean shouldDisableMentions() {
        return this.f11538m;
    }

    @JsonProperty("disable_photos")
    public boolean shouldDisablePhotos() {
        return this.f11539n;
    }

    @JsonProperty("edit_post_feature_capabilities")
    public ImmutableList<GraphQLEditPostFeatureCapability> getEditPostFeatureCapabilities() {
        return this.f11540o;
    }

    @JsonProperty("external_ref_name")
    @Nullable
    public String getExternalRefName() {
        return this.f11541p;
    }

    @JsonProperty("group_commerce_categories")
    public ImmutableList<GroupCommerceCategory> getGroupCommerceCategories() {
        return this.f11542q;
    }

    @JsonProperty("hide_keyboard_if_reached_minimum_height")
    public boolean shouldHideKeyboardIfReachedMinimumHeight() {
        return this.f11543r;
    }

    @JsonProperty("initial_app_attribution")
    @Nullable
    public ComposerAppAttribution getInitialAppAttribution() {
        return this.f11544s;
    }

    @JsonProperty("initial_attachments")
    public ImmutableList<ComposerAttachment> getInitialAttachments() {
        return this.f11545t;
    }

    @JsonProperty("initial_date_info")
    @Nullable
    public ComposerDateInfo getInitialDateInfo() {
        return this.f11546u;
    }

    @JsonProperty("initial_facecast_info")
    public ComposerFacecastInfo getInitialFacecastInfo() {
        return this.f11547v;
    }

    @JsonProperty("initial_location_info")
    public ComposerLocationInfo getInitialLocationInfo() {
        return this.f11548w;
    }

    @JsonProperty("initial_page_data")
    @Nullable
    public ComposerPageData getInitialPageData() {
        return this.f11549x;
    }

    @JsonProperty("initial_privacy_override")
    @Nullable
    public GraphQLPrivacyOption getInitialPrivacyOverride() {
        return this.f11550y;
    }

    @JsonProperty("initial_rating")
    public int getInitialRating() {
        return this.f11551z;
    }

    @JsonProperty("initial_red_space_value")
    public RedSpaceValue getInitialRedSpaceValue() {
        return this.f11501A;
    }

    @JsonProperty("initial_share_params")
    @Nullable
    public ComposerShareParams getInitialShareParams() {
        return this.f11502B;
    }

    @JsonProperty("initial_slideshow_data")
    @Nullable
    public ComposerSlideshowData getInitialSlideshowData() {
        return this.f11503C;
    }

    @JsonProperty("initial_sticker_data")
    @Nullable
    public ComposerStickerData getInitialStickerData() {
        return this.f11504D;
    }

    @JsonProperty("initial_tagged_users")
    public ImmutableList<ComposerTaggedUser> getInitialTaggedUsers() {
        return this.f11505E;
    }

    @JsonProperty("initial_target_album")
    @Nullable
    public GraphQLAlbum getInitialTargetAlbum() {
        return this.f11506F;
    }

    @JsonProperty("initial_target_data")
    public ComposerTargetData getInitialTargetData() {
        return this.f11507G;
    }

    @JsonProperty("initial_text")
    public GraphQLTextWithEntities getInitialText() {
        return this.f11508H;
    }

    @JsonProperty("is_edit")
    public boolean isEdit() {
        return this.f11509I;
    }

    @JsonProperty("is_edit_privacy_enabled")
    public boolean isEditPrivacyEnabled() {
        return this.f11510J;
    }

    @JsonProperty("is_edit_tag_enabled")
    public boolean isEditTagEnabled() {
        return this.f11511K;
    }

    @JsonProperty("is_fire_and_forget")
    public boolean isFireAndForget() {
        return this.f11512L;
    }

    @JsonProperty("is_throwback_post")
    public boolean isThrowbackPost() {
        return this.f11513M;
    }

    @JsonProperty("launch_logging_params")
    public ComposerLaunchLoggingParams getLaunchLoggingParams() {
        return this.f11514N;
    }

    @JsonProperty("legacy_api_story_id")
    @Nullable
    public String getLegacyApiStoryId() {
        return this.f11515O;
    }

    @JsonIgnore
    @Nullable
    public final ComposerLifeEventModel m18226a() {
        return this.f11516P;
    }

    @JsonProperty("minutiae_object_tag")
    @Nullable
    public MinutiaeObject getMinutiaeObjectTag() {
        return this.f11517Q;
    }

    @JsonProperty("nectar_module")
    @Nullable
    public String getNectarModule() {
        return this.f11518R;
    }

    @JsonProperty("og_mechanism")
    @Nullable
    public CurationMechanism getOgMechanism() {
        return this.f11519S;
    }

    @JsonProperty("og_surface")
    @Nullable
    public CurationSurface getOgSurface() {
        return this.f11520T;
    }

    @JsonProperty("platform_configuration")
    @Nullable
    public PlatformConfiguration getPlatformConfiguration() {
        return this.f11521U;
    }

    @JsonProperty("plugin_config")
    @Nullable
    public SerializedComposerPluginConfig getPluginConfig() {
        return this.f11522V;
    }

    @JsonProperty("product_item_attachment")
    @Nullable
    public ProductItemAttachment getProductItemAttachment() {
        return this.f11523W;
    }

    @JsonProperty("reaction_surface")
    @Nullable
    public Surface getReactionSurface() {
        return this.f11524X;
    }

    @JsonProperty("reaction_unit_id")
    @Nullable
    public String getReactionUnitId() {
        return this.f11525Y;
    }

    @JsonProperty("should_picker_support_live_camera")
    public boolean getShouldPickerSupportLiveCamera() {
        return this.f11526Z;
    }

    @JsonProperty("should_post_to_marketplace_by_default")
    public boolean shouldPostToMarketplaceByDefault() {
        return this.aa;
    }

    @JsonProperty("source_type")
    public ComposerSourceType getSourceType() {
        return this.ab;
    }

    @JsonProperty("story_id")
    @Nullable
    public String getStoryId() {
        return this.ac;
    }

    @JsonProperty("topic_feed_id")
    @Nullable
    public String getTopicFeedId() {
        return this.ad;
    }

    @JsonProperty("topics")
    public ImmutableList<GraphQLExploreFeed> getTopics() {
        return this.ae;
    }

    @JsonProperty("use_optimistic_posting")
    public boolean shouldUseOptimisticPosting() {
        return this.af;
    }
}
