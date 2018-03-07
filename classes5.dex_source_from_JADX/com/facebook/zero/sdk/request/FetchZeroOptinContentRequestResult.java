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
@JsonDeserialize(using = FetchZeroOptinContentRequestResultDeserializer.class)
@Immutable
/* compiled from: com.facebook.base.activity.FragmentChromeActivity */
public class FetchZeroOptinContentRequestResult implements Parcelable {
    public static final Creator<FetchZeroOptinContentRequestResult> CREATOR = new C05411();
    @JsonProperty("description_text")
    private final String mDescriptionText;
    @JsonProperty("friends_text")
    private final String mFriendsText;
    @JsonProperty("learn_more_text")
    private final String mLearnMoreText;
    @JsonProperty("learn_more_url")
    private final Uri mLearnMoreUrl;
    @JsonProperty("legal_disclaimer_text")
    private final String mLegalDisclaimerText;
    @JsonProperty("logo_url")
    private final Uri mLogoUrl;
    @JsonProperty("optin_confirm_button_text")
    private final String mOptinConfirmButtonText;
    @JsonProperty("optin_decline_button_cancel_text")
    private final String mOptinDeclineButtonCancelText;
    @JsonProperty("optin_decline_button_confirm_text")
    private final String mOptinDeclineButtonConfirmText;
    @JsonProperty("optin_decline_button_text")
    private final String mOptinDeclineButtonText;
    @JsonProperty("optin_decline_confirm_text")
    private final String mOptinDeclineConfirmText;
    @JsonProperty("optin_decline_title")
    private final String mOptinDeclineTitle;
    @JsonProperty("friends_profile_picture_urls")
    private final ImmutableList<String> mProfilePictureUrls;
    @JsonProperty("title")
    private final String mTitle;

    /* compiled from: com.facebook.base.activity.FragmentChromeActivity */
    final class C05411 implements Creator<FetchZeroOptinContentRequestResult> {
        C05411() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchZeroOptinContentRequestResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchZeroOptinContentRequestResult[i];
        }
    }

    public FetchZeroOptinContentRequestResult() {
        this.mTitle = null;
        this.mDescriptionText = null;
        this.mLogoUrl = Uri.parse("");
        this.mFriendsText = null;
        this.mProfilePictureUrls = RegularImmutableList.a;
        this.mLegalDisclaimerText = null;
        this.mLearnMoreText = null;
        this.mLearnMoreUrl = Uri.parse("");
        this.mOptinDeclineTitle = null;
        this.mOptinDeclineConfirmText = null;
        this.mOptinDeclineButtonConfirmText = null;
        this.mOptinDeclineButtonCancelText = null;
        this.mOptinConfirmButtonText = null;
        this.mOptinDeclineButtonText = null;
    }

    public FetchZeroOptinContentRequestResult(Parcel parcel) {
        this.mTitle = parcel.readString();
        this.mDescriptionText = parcel.readString();
        this.mLogoUrl = Uri.parse(parcel.readString());
        this.mFriendsText = parcel.readString();
        Collection a = Lists.a();
        parcel.readStringList(a);
        this.mProfilePictureUrls = ImmutableList.copyOf(a);
        this.mLegalDisclaimerText = parcel.readString();
        this.mLearnMoreText = parcel.readString();
        this.mLearnMoreUrl = Uri.parse(parcel.readString());
        this.mOptinDeclineTitle = parcel.readString();
        this.mOptinDeclineConfirmText = parcel.readString();
        this.mOptinDeclineButtonConfirmText = parcel.readString();
        this.mOptinDeclineButtonCancelText = parcel.readString();
        this.mOptinConfirmButtonText = parcel.readString();
        this.mOptinDeclineButtonText = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mDescriptionText);
        parcel.writeString(this.mLogoUrl.toString());
        parcel.writeString(this.mFriendsText);
        parcel.writeStringList(this.mProfilePictureUrls);
        parcel.writeString(this.mLegalDisclaimerText);
        parcel.writeString(this.mLearnMoreText);
        parcel.writeString(this.mLearnMoreUrl.toString());
        parcel.writeString(this.mOptinDeclineTitle);
        parcel.writeString(this.mOptinDeclineConfirmText);
        parcel.writeString(this.mOptinDeclineButtonConfirmText);
        parcel.writeString(this.mOptinDeclineButtonCancelText);
        parcel.writeString(this.mOptinConfirmButtonText);
        parcel.writeString(this.mOptinDeclineButtonText);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FetchZeroOptinContentRequestResult)) {
            return false;
        }
        FetchZeroOptinContentRequestResult fetchZeroOptinContentRequestResult = (FetchZeroOptinContentRequestResult) obj;
        if (Objects.equal(this.mTitle, fetchZeroOptinContentRequestResult.m10664a()) && Objects.equal(this.mDescriptionText, fetchZeroOptinContentRequestResult.m10665b()) && Objects.equal(this.mLogoUrl, fetchZeroOptinContentRequestResult.m10666c()) && Objects.equal(this.mFriendsText, fetchZeroOptinContentRequestResult.m10667d()) && Objects.equal(this.mProfilePictureUrls, fetchZeroOptinContentRequestResult.m10668e()) && Objects.equal(this.mLegalDisclaimerText, fetchZeroOptinContentRequestResult.m10669f()) && Objects.equal(this.mLearnMoreText, fetchZeroOptinContentRequestResult.m10670g()) && Objects.equal(this.mLearnMoreUrl, fetchZeroOptinContentRequestResult.m10671h()) && Objects.equal(this.mOptinDeclineTitle, fetchZeroOptinContentRequestResult.m10672i()) && Objects.equal(this.mOptinDeclineConfirmText, fetchZeroOptinContentRequestResult.m10673j()) && Objects.equal(this.mOptinDeclineButtonConfirmText, fetchZeroOptinContentRequestResult.m10674k()) && Objects.equal(this.mOptinDeclineButtonCancelText, fetchZeroOptinContentRequestResult.m10675l()) && Objects.equal(this.mOptinConfirmButtonText, fetchZeroOptinContentRequestResult.m10676m()) && Objects.equal(this.mOptinDeclineButtonText, fetchZeroOptinContentRequestResult.m10677n())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.mTitle, this.mDescriptionText, this.mLogoUrl, this.mFriendsText, this.mProfilePictureUrls, this.mLegalDisclaimerText, this.mLearnMoreText, this.mLearnMoreUrl, this.mOptinDeclineTitle, this.mOptinDeclineConfirmText, this.mOptinDeclineButtonConfirmText, this.mOptinDeclineButtonCancelText, this.mOptinConfirmButtonText, this.mOptinDeclineButtonText});
    }

    public String toString() {
        return Objects.toStringHelper(this).add("title", this.mTitle).add("description_text", this.mDescriptionText).add("logo_url", this.mLogoUrl).add("friends_text", this.mFriendsText).add("friends_profile_picture_urls", this.mProfilePictureUrls).add("legal_disclaimer_text", this.mLegalDisclaimerText).add("learn_more_text", this.mLearnMoreText).add("learn_more_url", this.mLearnMoreUrl).add("optin_decline_title", this.mOptinDeclineTitle).add("optin_decline_confirm_text", this.mOptinDeclineConfirmText).add("optin_decline_button_confirm_text", this.mOptinDeclineButtonConfirmText).add("optin_decline_button_cancel_text", this.mOptinDeclineButtonCancelText).add("optin_confirm_button_text", this.mOptinConfirmButtonText).add("optin_decline_button_text", this.mOptinDeclineButtonText).toString();
    }

    public final String m10664a() {
        return this.mTitle;
    }

    public final String m10665b() {
        return this.mDescriptionText;
    }

    public final Uri m10666c() {
        return this.mLogoUrl;
    }

    public final String m10667d() {
        return this.mFriendsText;
    }

    public final ImmutableList<String> m10668e() {
        return this.mProfilePictureUrls;
    }

    public final String m10669f() {
        return this.mLegalDisclaimerText;
    }

    public final String m10670g() {
        return this.mLearnMoreText;
    }

    public final Uri m10671h() {
        return this.mLearnMoreUrl;
    }

    public final String m10672i() {
        return this.mOptinDeclineTitle;
    }

    public final String m10673j() {
        return this.mOptinDeclineConfirmText;
    }

    public final String m10674k() {
        return this.mOptinDeclineButtonConfirmText;
    }

    public final String m10675l() {
        return this.mOptinDeclineButtonCancelText;
    }

    public final String m10676m() {
        return this.mOptinConfirmButtonText;
    }

    public final String m10677n() {
        return this.mOptinDeclineButtonText;
    }
}
