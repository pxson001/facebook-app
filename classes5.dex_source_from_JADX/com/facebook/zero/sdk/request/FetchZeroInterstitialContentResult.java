package com.facebook.zero.sdk.request;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = FetchZeroInterstitialContentResultDeserializer.class)
@Immutable
/* compiled from: com.facebook.common.jobscheduler.compat.GcmTaskServiceCompat.gms.TRY_SCHEDULE- */
public class FetchZeroInterstitialContentResult implements Parcelable {
    public static final Creator<FetchZeroInterstitialContentResult> CREATOR = new C05371();
    @JsonProperty("campaign_token_to_refresh_type")
    private final String mCampaignTokenToRefreshType;
    @JsonProperty("clickable_link_text")
    private final String mClickableLinkText;
    @JsonProperty("clickable_link_url")
    private final Uri mClickableLinkUrl;
    @JsonProperty("description_text")
    private final String mDescriptionText;
    @JsonProperty("detail_text")
    private final String mDetailText;
    @JsonProperty("facepile_text")
    private final String mFacepileText;
    @JsonProperty("image_url")
    private final Uri mImageUrl;
    @JsonProperty("primary_button_action")
    private final String mPrimaryButtonAction;
    @JsonProperty("primary_button_intent_url")
    private final String mPrimaryButtonIntentUrl;
    @JsonProperty("primary_button_step")
    private final String mPrimaryButtonStep;
    @JsonProperty("primary_button_text")
    private final String mPrimaryButtonText;
    @JsonProperty("facepile_profile_picture_urls")
    private final ImmutableList<String> mProfilePictureUrls;
    @JsonProperty("secondary_button_action")
    private final String mSecondaryButtonAction;
    @JsonProperty("secondary_button_intent_url")
    private final String mSecondaryButtonIntentUrl;
    @JsonProperty("secondary_button_override_back_only")
    private final boolean mSecondaryButtonOverrideBackOnly;
    @JsonProperty("secondary_button_step")
    private final String mSecondaryButtonStep;
    @JsonProperty("secondary_button_text")
    private final String mSecondaryButtonText;
    @JsonProperty("should_use_default_image")
    private final boolean mShouldUseDefaultImage;
    @JsonProperty("subtitle")
    private final String mSubTitle;
    @JsonProperty("title")
    private final String mTitle;

    /* compiled from: com.facebook.common.jobscheduler.compat.GcmTaskServiceCompat.gms.TRY_SCHEDULE- */
    final class C05371 implements Creator<FetchZeroInterstitialContentResult> {
        C05371() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchZeroInterstitialContentResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchZeroInterstitialContentResult[i];
        }
    }

    public FetchZeroInterstitialContentResult() {
        this.mTitle = null;
        this.mSubTitle = null;
        this.mDescriptionText = null;
        this.mImageUrl = Uri.parse("");
        this.mShouldUseDefaultImage = false;
        this.mFacepileText = null;
        this.mProfilePictureUrls = RegularImmutableList.a;
        this.mDetailText = null;
        this.mClickableLinkText = null;
        this.mClickableLinkUrl = Uri.parse("");
        this.mPrimaryButtonText = null;
        this.mPrimaryButtonIntentUrl = null;
        this.mPrimaryButtonStep = null;
        this.mPrimaryButtonAction = null;
        this.mSecondaryButtonText = null;
        this.mSecondaryButtonIntentUrl = null;
        this.mSecondaryButtonStep = null;
        this.mSecondaryButtonAction = null;
        this.mSecondaryButtonOverrideBackOnly = false;
        this.mCampaignTokenToRefreshType = null;
    }

    public FetchZeroInterstitialContentResult(Parcel parcel) {
        boolean z = true;
        this.mTitle = parcel.readString();
        this.mSubTitle = parcel.readString();
        this.mDescriptionText = parcel.readString();
        this.mImageUrl = Uri.parse(parcel.readString());
        this.mShouldUseDefaultImage = parcel.readByte() != (byte) 0;
        this.mFacepileText = parcel.readString();
        Collection a = Lists.a();
        parcel.readStringList(a);
        this.mProfilePictureUrls = ImmutableList.copyOf(a);
        this.mDetailText = parcel.readString();
        this.mClickableLinkText = parcel.readString();
        this.mClickableLinkUrl = Uri.parse(parcel.readString());
        this.mPrimaryButtonText = parcel.readString();
        this.mPrimaryButtonIntentUrl = parcel.readString();
        this.mPrimaryButtonStep = parcel.readString();
        this.mPrimaryButtonAction = parcel.readString();
        this.mSecondaryButtonText = parcel.readString();
        this.mSecondaryButtonIntentUrl = parcel.readString();
        this.mSecondaryButtonStep = parcel.readString();
        this.mSecondaryButtonAction = parcel.readString();
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.mSecondaryButtonOverrideBackOnly = z;
        this.mCampaignTokenToRefreshType = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mSubTitle);
        parcel.writeString(this.mDescriptionText);
        parcel.writeString(this.mImageUrl.toString());
        parcel.writeByte((byte) (this.mShouldUseDefaultImage ? 1 : 0));
        parcel.writeString(this.mFacepileText);
        parcel.writeStringList(this.mProfilePictureUrls);
        parcel.writeString(this.mDetailText);
        parcel.writeString(this.mClickableLinkText);
        parcel.writeString(this.mClickableLinkUrl.toString());
        parcel.writeString(this.mPrimaryButtonText);
        parcel.writeString(this.mPrimaryButtonIntentUrl);
        parcel.writeString(this.mPrimaryButtonStep);
        parcel.writeString(this.mPrimaryButtonAction);
        parcel.writeString(this.mSecondaryButtonText);
        parcel.writeString(this.mSecondaryButtonIntentUrl);
        parcel.writeString(this.mSecondaryButtonStep);
        parcel.writeString(this.mSecondaryButtonAction);
        if (!this.mSecondaryButtonOverrideBackOnly) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(this.mCampaignTokenToRefreshType);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FetchZeroInterstitialContentResult)) {
            return false;
        }
        FetchZeroInterstitialContentResult fetchZeroInterstitialContentResult = (FetchZeroInterstitialContentResult) obj;
        if (Objects.equal(this.mTitle, fetchZeroInterstitialContentResult.m10634a()) && Objects.equal(this.mSubTitle, fetchZeroInterstitialContentResult.m10635b()) && Objects.equal(this.mDescriptionText, fetchZeroInterstitialContentResult.m10636c()) && Objects.equal(this.mImageUrl, fetchZeroInterstitialContentResult.m10637d()) && this.mShouldUseDefaultImage == fetchZeroInterstitialContentResult.m10638e() && Objects.equal(this.mFacepileText, fetchZeroInterstitialContentResult.m10639f()) && Objects.equal(this.mProfilePictureUrls, fetchZeroInterstitialContentResult.m10640g()) && Objects.equal(this.mDetailText, fetchZeroInterstitialContentResult.m10641h()) && Objects.equal(this.mClickableLinkText, fetchZeroInterstitialContentResult.m10642i()) && Objects.equal(this.mClickableLinkUrl, fetchZeroInterstitialContentResult.m10643j()) && Objects.equal(this.mPrimaryButtonText, fetchZeroInterstitialContentResult.m10644k()) && Objects.equal(this.mPrimaryButtonIntentUrl, fetchZeroInterstitialContentResult.m10645l()) && Objects.equal(this.mPrimaryButtonStep, fetchZeroInterstitialContentResult.m10646m()) && Objects.equal(this.mPrimaryButtonAction, fetchZeroInterstitialContentResult.m10647n()) && Objects.equal(this.mSecondaryButtonText, fetchZeroInterstitialContentResult.m10648o()) && Objects.equal(this.mSecondaryButtonIntentUrl, fetchZeroInterstitialContentResult.m10649p()) && Objects.equal(this.mSecondaryButtonStep, fetchZeroInterstitialContentResult.m10650q()) && Objects.equal(this.mSecondaryButtonAction, fetchZeroInterstitialContentResult.m10651r()) && this.mSecondaryButtonOverrideBackOnly == fetchZeroInterstitialContentResult.m10652s() && Objects.equal(this.mCampaignTokenToRefreshType, fetchZeroInterstitialContentResult.m10653t())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.mTitle, this.mDescriptionText, this.mImageUrl, Boolean.valueOf(this.mShouldUseDefaultImage), this.mFacepileText, this.mProfilePictureUrls, this.mDetailText, this.mClickableLinkText, this.mClickableLinkUrl, this.mPrimaryButtonText, this.mPrimaryButtonIntentUrl, this.mPrimaryButtonStep, this.mPrimaryButtonAction, this.mSecondaryButtonText, this.mSecondaryButtonIntentUrl, this.mSecondaryButtonStep, this.mSecondaryButtonAction, Boolean.valueOf(this.mSecondaryButtonOverrideBackOnly), this.mCampaignTokenToRefreshType});
    }

    public String toString() {
        return Objects.toStringHelper(this).add("title", this.mTitle).add("subTitle", this.mSubTitle).add("description_text", this.mDescriptionText).add("image_url", this.mImageUrl).add("should_use_default_image", this.mShouldUseDefaultImage).add("facepile_text", this.mFacepileText).add("profile_picture_urls", this.mProfilePictureUrls).add("detail_text", this.mDetailText).add("clickable_link_text", this.mClickableLinkText).add("clickable_link_url", this.mClickableLinkUrl).add("primary_button_text", this.mPrimaryButtonText).add("primary_button_intent_url", this.mPrimaryButtonIntentUrl).add("primary_button_step", this.mPrimaryButtonStep).add("primary_button_action", this.mPrimaryButtonAction).add("secondary_button_text", this.mSecondaryButtonText).add("secondary_button_intent_url", this.mSecondaryButtonIntentUrl).add("secondary_button_step", this.mSecondaryButtonStep).add("secondary_button_action", this.mSecondaryButtonAction).add("secondary_button_override_back_only", this.mSecondaryButtonOverrideBackOnly).add("campaign_token_to_refresh_type", this.mCampaignTokenToRefreshType).toString();
    }

    public final String m10634a() {
        return this.mTitle;
    }

    public final String m10635b() {
        return this.mSubTitle;
    }

    public final String m10636c() {
        return this.mDescriptionText;
    }

    public final Uri m10637d() {
        return this.mImageUrl;
    }

    public final boolean m10638e() {
        return this.mShouldUseDefaultImage;
    }

    public final String m10639f() {
        return this.mFacepileText;
    }

    public final ImmutableList<String> m10640g() {
        return this.mProfilePictureUrls;
    }

    public final String m10641h() {
        return this.mDetailText;
    }

    public final String m10642i() {
        return this.mClickableLinkText;
    }

    public final Uri m10643j() {
        return this.mClickableLinkUrl;
    }

    public final String m10644k() {
        return this.mPrimaryButtonText;
    }

    public final String m10645l() {
        return this.mPrimaryButtonIntentUrl;
    }

    public final String m10646m() {
        return this.mPrimaryButtonStep;
    }

    public final String m10647n() {
        return this.mPrimaryButtonAction;
    }

    public final String m10648o() {
        return this.mSecondaryButtonText;
    }

    public final String m10649p() {
        return this.mSecondaryButtonIntentUrl;
    }

    public final String m10650q() {
        return this.mSecondaryButtonStep;
    }

    public final String m10651r() {
        return this.mSecondaryButtonAction;
    }

    public final boolean m10652s() {
        return this.mSecondaryButtonOverrideBackOnly;
    }

    public final String m10653t() {
        return this.mCampaignTokenToRefreshType;
    }
}
