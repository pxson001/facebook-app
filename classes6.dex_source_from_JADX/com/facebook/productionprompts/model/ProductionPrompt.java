package com.facebook.productionprompts.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.events.common.EventsDateUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLPromptType;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FramePackModel;
import com.facebook.productionprompts.graphql.C0259xb568e2b0.EdgesModel;
import com.facebook.productionprompts.graphql.C0259xb568e2b0.EdgesModel.NodeModel;
import com.facebook.productionprompts.graphql.C0259xb568e2b0.EdgesModel.NodeModel.CheckinLocationModel;
import com.facebook.productionprompts.graphql.C0259xb568e2b0.EdgesModel.NodeModel.LinkAttachmentModel;
import com.facebook.productionprompts.graphql.C0259xb568e2b0.EdgesModel.NodeModel.MemeCategoryModel;
import com.facebook.productionprompts.graphql.C0259xb568e2b0.EdgesModel.NodeModel.MinutiaeActionModel;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLModels.ProductionPromptsInfoModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = ProductionPromptDeserializer.class)
@Immutable
@JsonSerialize(using = ProductionPromptSerializer.class)
/* compiled from: startOffset */
public class ProductionPrompt implements Parcelable {
    public static final Creator<ProductionPrompt> CREATOR = new C02621();
    @JsonProperty("banner_subheader")
    public final String mBannerSubheader;
    @JsonProperty("banner_text")
    public final String mBannerText;
    @JsonProperty("cta_text")
    public final String mCallToActionText;
    @JsonProperty("checkin_location_id")
    public final String mCheckinLocationId;
    @JsonProperty("checkin_location_name")
    public final String mCheckinLocationName;
    @JsonProperty("composer_prompt_text")
    public final String mComposerPromptText;
    @JsonProperty("dismiss_survey_id")
    public final String mDismissSurveyId;
    @JsonProperty("end_time")
    public final long mEndTime;
    @JsonProperty("frame_pack_model")
    final FramePackModel mFramePackModel;
    @JsonProperty("ignore_survey_id")
    public final String mIgnoreSurveyId;
    @JsonProperty("link_attachment_url")
    public final String mLinkAttachmentUrl;
    @JsonProperty("meme_urls")
    public final ImmutableList<String> mMemeUrls;
    @JsonProperty("minutiae_object")
    public final MinutiaeObject mMinutiaeObject;
    @JsonProperty("post_with_minutiae_survey_id")
    public final String mPostWithMinutiaeSurveyId;
    @JsonProperty("profile_picture_overlay")
    public final ProfilePictureOverlay mProfilePictureOverlay;
    @JsonProperty("prompt_confidence")
    public final String mPromptConfidence;
    @JsonProperty("prompt_display_reason")
    public final PromptDisplayReason mPromptDisplayReason;
    @JsonProperty("id")
    public final String mPromptId;
    @JsonProperty("image_uri")
    public final String mPromptImageUri;
    @JsonProperty("title")
    public final String mPromptTitle;
    @JsonProperty("prompt_type")
    public final String mPromptType;
    @JsonProperty("server_ranking_score")
    final double mServerRankingScore;
    @JsonProperty("server_tracking_string")
    final String mServerTrackingString;
    @JsonProperty("start_time")
    public final long mStartTime;
    @JsonProperty("suggested_cover_photos")
    public final ImmutableList<String> mSuggestedCoverPhotos;

    /* compiled from: startOffset */
    final class C02621 implements Creator<ProductionPrompt> {
        C02621() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ProductionPrompt(parcel);
        }

        public final Object[] newArray(int i) {
            return new ProductionPrompt[i];
        }
    }

    @Nullable
    public static ProductionPrompt m6278a(ProductionPromptsInfoModel productionPromptsInfoModel) {
        if (!m6283b(productionPromptsInfoModel)) {
            return null;
        }
        String j = productionPromptsInfoModel.s().m6223j();
        String a = productionPromptsInfoModel.s().m6222a();
        long time = EventsDateUtil.a(j).getTime();
        long time2 = EventsDateUtil.a(a).getTime();
        ProductionPromptBuilder productionPromptBuilder = new ProductionPromptBuilder(productionPromptsInfoModel.j());
        productionPromptBuilder.f4238f = time;
        ProductionPromptBuilder productionPromptBuilder2 = productionPromptBuilder;
        productionPromptBuilder2.f4239g = time2;
        ProductionPromptBuilder productionPromptBuilder3 = productionPromptBuilder2;
        if (productionPromptsInfoModel.o() != null) {
            productionPromptBuilder3.f4234b = productionPromptsInfoModel.o().m6153a();
        }
        if (productionPromptsInfoModel.m() != null) {
            productionPromptBuilder3.f4237e = productionPromptsInfoModel.m().m6141a();
        }
        if (productionPromptsInfoModel.n() != null) {
            productionPromptBuilder3.f4243k = productionPromptsInfoModel.n().m6146a();
            ProductionPromptBuilder productionPromptBuilder4 = productionPromptBuilder3;
            productionPromptBuilder4.f4244l = productionPromptsInfoModel.n().m6147j();
            productionPromptBuilder4.f4245m = productionPromptsInfoModel.n().m6148k();
        }
        ImmutableList a2 = productionPromptsInfoModel.r().m6216a();
        if (!a2.isEmpty()) {
            EdgesModel edgesModel = (EdgesModel) a2.get(0);
            productionPromptBuilder3.f4235c = edgesModel.m6211l();
            productionPromptBuilder3.f4236d = edgesModel.m6210k();
            if (edgesModel.m6209j() != null) {
                m6280a(edgesModel.m6209j(), productionPromptBuilder3);
                MinutiaeActionModel m = edgesModel.m6209j().m6202m();
                if (m != null) {
                    productionPromptBuilder3.f4241i = MinutiaeObject.a(m.m6192j().C_(), m.m6194l().m6186a(), m.m6193k(), m.m6192j());
                }
                CheckinLocationModel a3 = edgesModel.m6209j().m6198a();
                if (a3 != null) {
                    productionPromptBuilder3.f4246n = a3.m6166j();
                    productionPromptBuilder3.f4247o = a3.m6167k();
                }
                LinkAttachmentModel k = edgesModel.m6209j().m6200k();
                if (!(k == null || Strings.isNullOrEmpty(k.m6174a()))) {
                    productionPromptBuilder3.f4242j = k.m6174a();
                }
                MemeCategoryModel l = edgesModel.m6209j().m6201l();
                if (l != null) {
                    productionPromptBuilder3.f4256x = l.m6180a();
                }
                productionPromptBuilder3.f4250r = edgesModel.m6209j().m6199j();
                productionPromptBuilder3.f4257y = edgesModel.m6209j().m6204o();
            }
            if (!(edgesModel.m6212m() == null || Strings.isNullOrEmpty(edgesModel.m6212m().a()))) {
                productionPromptBuilder3.f4240h = edgesModel.m6212m().a();
            }
            if (edgesModel.m6208a() != null) {
                productionPromptBuilder3.f4255w = edgesModel.m6208a().toString();
            }
        }
        if (productionPromptsInfoModel.p() != null) {
            productionPromptBuilder3.f4248p = productionPromptsInfoModel.p().toString();
        }
        productionPromptBuilder3.f4251s = productionPromptsInfoModel.q();
        if (!Strings.isNullOrEmpty(productionPromptsInfoModel.t())) {
            productionPromptBuilder3.f4252t = productionPromptsInfoModel.t();
        }
        if (productionPromptsInfoModel.l() != null) {
            productionPromptBuilder3.f4253u = new PromptDisplayReason(productionPromptsInfoModel.l());
        }
        if (productionPromptsInfoModel.k() != null) {
            productionPromptBuilder3.f4254v = productionPromptsInfoModel.k().toString();
        }
        Preconditions.checkNotNull(productionPromptBuilder3.f4233a);
        Preconditions.checkArgument(productionPromptBuilder3.f4239g >= productionPromptBuilder3.f4238f);
        return m6279a(productionPromptBuilder3);
    }

    private static void m6280a(NodeModel nodeModel, ProductionPromptBuilder productionPromptBuilder) {
        if (nodeModel.m6203n() != null && nodeModel.m6203n().c() != null && nodeModel.m6203n().j() != null && nodeModel.m6203n().j().a() != null) {
            productionPromptBuilder.f4249q = ProfilePictureOverlay.m6332a(nodeModel.m6203n().c(), nodeModel.m6203n().j().a());
        }
    }

    public static boolean m6281a(ProductionPromptsInfoModel productionPromptsInfoModel, Calendar calendar) {
        if (!m6283b(productionPromptsInfoModel)) {
            return false;
        }
        String j = productionPromptsInfoModel.s().m6223j();
        String a = productionPromptsInfoModel.s().m6222a();
        long time = EventsDateUtil.a(j).getTime();
        long time2 = EventsDateUtil.a(a).getTime();
        long timeInMillis = calendar.getTimeInMillis();
        if (time > timeInMillis || timeInMillis >= time2) {
            return false;
        }
        return true;
    }

    private static boolean m6283b(ProductionPromptsInfoModel productionPromptsInfoModel) {
        if (productionPromptsInfoModel == null) {
            return false;
        }
        boolean z = productionPromptsInfoModel.m() == null || Strings.isNullOrEmpty(productionPromptsInfoModel.m().m6141a());
        boolean z2;
        if (productionPromptsInfoModel.o() == null || Strings.isNullOrEmpty(productionPromptsInfoModel.o().toString())) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean z3;
        if (productionPromptsInfoModel.p() == GraphQLPromptType.CHECKIN) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (Strings.isNullOrEmpty(productionPromptsInfoModel.j()) || productionPromptsInfoModel.s() == null || Strings.isNullOrEmpty(productionPromptsInfoModel.s().m6223j()) || Strings.isNullOrEmpty(productionPromptsInfoModel.s().m6222a())) {
            return false;
        }
        if (z && r3 && !r4) {
            return false;
        }
        return true;
    }

    private ProductionPrompt() {
        this.mPromptId = null;
        this.mPromptTitle = null;
        this.mBannerText = null;
        this.mBannerSubheader = null;
        this.mPromptImageUri = null;
        this.mStartTime = 0;
        this.mEndTime = 0;
        this.mComposerPromptText = null;
        this.mMinutiaeObject = null;
        this.mLinkAttachmentUrl = null;
        this.mDismissSurveyId = null;
        this.mIgnoreSurveyId = null;
        this.mPostWithMinutiaeSurveyId = null;
        this.mCheckinLocationId = null;
        this.mCheckinLocationName = null;
        this.mPromptType = null;
        this.mProfilePictureOverlay = null;
        this.mFramePackModel = null;
        this.mServerRankingScore = 0.0d;
        this.mServerTrackingString = null;
        this.mPromptDisplayReason = null;
        this.mPromptConfidence = null;
        this.mCallToActionText = null;
        this.mMemeUrls = null;
        this.mSuggestedCoverPhotos = null;
    }

    private ProductionPrompt(String str, String str2, String str3, String str4, String str5, long j, long j2, String str6, MinutiaeObject minutiaeObject, String str7, String str8, String str9, String str10, String str11, String str12, String str13, ProfilePictureOverlay profilePictureOverlay, FramePackModel framePackModel, double d, String str14, PromptDisplayReason promptDisplayReason, String str15, String str16, ImmutableList<String> immutableList, ImmutableList<String> immutableList2) {
        this.mPromptId = str;
        this.mPromptTitle = str2;
        this.mBannerText = str3;
        this.mBannerSubheader = str4;
        this.mPromptImageUri = str5;
        this.mStartTime = j;
        this.mEndTime = j2;
        this.mComposerPromptText = str6;
        this.mMinutiaeObject = minutiaeObject;
        this.mLinkAttachmentUrl = str7;
        this.mDismissSurveyId = str8;
        this.mIgnoreSurveyId = str9;
        this.mPostWithMinutiaeSurveyId = str10;
        this.mCheckinLocationId = str11;
        this.mCheckinLocationName = str12;
        this.mPromptType = str13;
        this.mProfilePictureOverlay = profilePictureOverlay;
        this.mFramePackModel = framePackModel;
        this.mServerRankingScore = d;
        this.mServerTrackingString = str14;
        this.mPromptDisplayReason = promptDisplayReason;
        this.mPromptConfidence = str15;
        this.mCallToActionText = str16;
        this.mMemeUrls = immutableList;
        this.mSuggestedCoverPhotos = immutableList2;
    }

    public static ProductionPrompt m6279a(ProductionPromptBuilder productionPromptBuilder) {
        return new ProductionPrompt(productionPromptBuilder.m6303a(), productionPromptBuilder.m6304b(), productionPromptBuilder.m6305c(), productionPromptBuilder.m6306d(), productionPromptBuilder.m6307e(), productionPromptBuilder.m6308f(), productionPromptBuilder.m6309g(), productionPromptBuilder.m6310h(), productionPromptBuilder.m6311i(), productionPromptBuilder.m6312j(), productionPromptBuilder.m6314l(), productionPromptBuilder.m6313k(), productionPromptBuilder.m6315m(), productionPromptBuilder.m6316n(), productionPromptBuilder.m6317o(), productionPromptBuilder.m6318p(), productionPromptBuilder.m6319q(), productionPromptBuilder.m6320r(), productionPromptBuilder.m6321s(), productionPromptBuilder.m6322t(), productionPromptBuilder.m6323u(), productionPromptBuilder.m6324v(), productionPromptBuilder.m6325w(), productionPromptBuilder.m6326x(), productionPromptBuilder.m6327y());
    }

    public final String m6284a() {
        return this.mPromptId;
    }

    @Nullable
    public final String m6285b() {
        return this.mBannerText;
    }

    @Nullable
    public final String m6286c() {
        return this.mBannerSubheader;
    }

    @Nullable
    public final MinutiaeObject m6287d() {
        return this.mMinutiaeObject;
    }

    @Nullable
    public final Uri m6288e() {
        if (this.mPromptImageUri == null) {
            return null;
        }
        return Uri.parse(this.mPromptImageUri);
    }

    @Nullable
    public final String m6289f() {
        return this.mLinkAttachmentUrl;
    }

    @Nullable
    public final String m6290g() {
        return this.mCheckinLocationId;
    }

    @Nullable
    public final String m6291h() {
        return this.mCheckinLocationName;
    }

    @Nullable
    public final String m6292i() {
        return this.mPromptType;
    }

    public final boolean m6293j() {
        return m6290g() != null;
    }

    public final boolean m6294k() {
        String i = m6292i();
        return i != null && i.equals(GraphQLPromptType.CLIPBOARD.toString());
    }

    @Nullable
    public final ProfilePictureOverlay m6295l() {
        return this.mProfilePictureOverlay;
    }

    @Nullable
    public final FramePackModel m6296m() {
        return this.mFramePackModel;
    }

    public final double m6297n() {
        return this.mServerRankingScore;
    }

    public final String m6298o() {
        return this.mServerTrackingString;
    }

    @Nullable
    public final PromptDisplayReason m6299p() {
        return this.mPromptDisplayReason;
    }

    public final String m6300q() {
        return this.mPromptConfidence;
    }

    @Nullable
    public final ImmutableList<String> m6301r() {
        return this.mMemeUrls;
    }

    @Nullable
    public final ImmutableList<String> m6302s() {
        return this.mSuggestedCoverPhotos;
    }

    private boolean m6282a(ProductionPrompt productionPrompt) {
        if (productionPrompt == null || !Objects.equal(this.mPromptType, productionPrompt.mPromptType) || !Objects.equal(this.mPromptId, productionPrompt.mPromptId) || !Objects.equal(this.mPromptTitle, productionPrompt.mPromptTitle) || !Objects.equal(this.mBannerText, productionPrompt.mBannerText) || !Objects.equal(this.mBannerSubheader, productionPrompt.mBannerSubheader) || !Objects.equal(this.mPromptImageUri, productionPrompt.mPromptImageUri) || !Objects.equal(Long.valueOf(this.mStartTime), Long.valueOf(productionPrompt.mStartTime)) || !Objects.equal(Long.valueOf(this.mEndTime), Long.valueOf(productionPrompt.mEndTime)) || !Objects.equal(this.mComposerPromptText, productionPrompt.mComposerPromptText) || !Objects.equal(this.mLinkAttachmentUrl, productionPrompt.mLinkAttachmentUrl) || !Objects.equal(this.mIgnoreSurveyId, productionPrompt.mIgnoreSurveyId) || !Objects.equal(this.mDismissSurveyId, productionPrompt.mDismissSurveyId) || !Objects.equal(this.mPostWithMinutiaeSurveyId, productionPrompt.mPostWithMinutiaeSurveyId) || !Objects.equal(this.mCheckinLocationId, productionPrompt.mCheckinLocationId) || !Objects.equal(this.mPromptType, productionPrompt.mPromptType) || !Objects.equal(this.mProfilePictureOverlay, productionPrompt.mProfilePictureOverlay)) {
            return false;
        }
        if (this.mMinutiaeObject == null) {
            if (productionPrompt.mMinutiaeObject != null) {
                return false;
            }
        } else if (!this.mMinutiaeObject.b(productionPrompt.mMinutiaeObject)) {
            return false;
        }
        if (this.mFramePackModel == null) {
            if (productionPrompt.mFramePackModel != null) {
                return false;
            }
        } else if (!this.mFramePackModel.m4641d().equals(productionPrompt.mFramePackModel.m4641d())) {
            return false;
        }
        if (Objects.equal(this.mPromptDisplayReason, productionPrompt.mPromptDisplayReason) && Objects.equal(this.mPromptConfidence, productionPrompt.mPromptConfidence) && Objects.equal(this.mCallToActionText, productionPrompt.mCallToActionText) && Objects.equal(this.mMemeUrls, productionPrompt.mMemeUrls) && Objects.equal(this.mSuggestedCoverPhotos, productionPrompt.mSuggestedCoverPhotos)) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductionPrompt)) {
            return false;
        }
        ProductionPrompt productionPrompt = (ProductionPrompt) obj;
        if (m6282a(productionPrompt) && Objects.equal(Double.valueOf(this.mServerRankingScore), Double.valueOf(productionPrompt.mServerRankingScore)) && Objects.equal(this.mServerTrackingString, productionPrompt.mServerTrackingString)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.mPromptId, this.mPromptTitle, this.mBannerText, this.mBannerSubheader, this.mPromptImageUri, Long.valueOf(this.mStartTime), Long.valueOf(this.mEndTime), this.mPromptType, this.mComposerPromptText, this.mMinutiaeObject, this.mLinkAttachmentUrl, this.mDismissSurveyId, this.mIgnoreSurveyId, this.mPostWithMinutiaeSurveyId, this.mCheckinLocationId, this.mCheckinLocationName, this.mPromptType, this.mProfilePictureOverlay, this.mFramePackModel, Double.valueOf(this.mServerRankingScore), this.mServerTrackingString, this.mPromptDisplayReason, this.mPromptConfidence, this.mCallToActionText, this.mMemeUrls, this.mSuggestedCoverPhotos});
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mPromptId);
        parcel.writeString(this.mPromptTitle);
        parcel.writeString(this.mBannerText);
        parcel.writeString(this.mBannerSubheader);
        parcel.writeString(this.mPromptImageUri);
        parcel.writeLong(this.mStartTime);
        parcel.writeLong(this.mEndTime);
        parcel.writeString(this.mComposerPromptText);
        parcel.writeParcelable(this.mMinutiaeObject, i);
        parcel.writeString(this.mLinkAttachmentUrl);
        parcel.writeString(this.mDismissSurveyId);
        parcel.writeString(this.mIgnoreSurveyId);
        parcel.writeString(this.mPostWithMinutiaeSurveyId);
        parcel.writeString(this.mCheckinLocationId);
        parcel.writeString(this.mCheckinLocationName);
        parcel.writeString(this.mPromptType);
        parcel.writeParcelable(this.mProfilePictureOverlay, i);
        FlatBufferModelHelper.a(parcel, this.mFramePackModel);
        parcel.writeDouble(this.mServerRankingScore);
        parcel.writeString(this.mServerTrackingString);
        parcel.writeParcelable(this.mPromptDisplayReason, i);
        parcel.writeString(this.mPromptConfidence);
        parcel.writeString(this.mCallToActionText);
        parcel.writeStringList(this.mMemeUrls);
        parcel.writeStringList(this.mSuggestedCoverPhotos);
    }

    public ProductionPrompt(Parcel parcel) {
        ImmutableList immutableList = null;
        this.mPromptId = parcel.readString();
        this.mPromptTitle = parcel.readString();
        this.mBannerText = parcel.readString();
        this.mBannerSubheader = parcel.readString();
        this.mPromptImageUri = parcel.readString();
        this.mStartTime = parcel.readLong();
        this.mEndTime = parcel.readLong();
        this.mComposerPromptText = parcel.readString();
        this.mMinutiaeObject = (MinutiaeObject) parcel.readParcelable(MinutiaeObject.class.getClassLoader());
        this.mLinkAttachmentUrl = parcel.readString();
        this.mDismissSurveyId = parcel.readString();
        this.mIgnoreSurveyId = parcel.readString();
        this.mPostWithMinutiaeSurveyId = parcel.readString();
        this.mCheckinLocationId = parcel.readString();
        this.mCheckinLocationName = parcel.readString();
        this.mPromptType = parcel.readString();
        this.mProfilePictureOverlay = (ProfilePictureOverlay) parcel.readParcelable(ProfilePictureOverlay.class.getClassLoader());
        this.mFramePackModel = (FramePackModel) FlatBufferModelHelper.a(parcel);
        this.mServerRankingScore = parcel.readDouble();
        this.mServerTrackingString = parcel.readString();
        this.mPromptDisplayReason = (PromptDisplayReason) parcel.readParcelable(PromptDisplayReason.class.getClassLoader());
        this.mPromptConfidence = parcel.readString();
        this.mCallToActionText = parcel.readString();
        Collection arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        this.mMemeUrls = arrayList.size() == 0 ? null : ImmutableList.copyOf(arrayList);
        arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        if (arrayList.size() != 0) {
            immutableList = ImmutableList.copyOf(arrayList);
        }
        this.mSuggestedCoverPhotos = immutableList;
    }
}
