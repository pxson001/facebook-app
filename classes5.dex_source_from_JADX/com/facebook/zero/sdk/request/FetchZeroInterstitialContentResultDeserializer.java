package com.facebook.zero.sdk.request;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: com.facebook.common.init.PostSplashScreen */
public class FetchZeroInterstitialContentResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f5898a;

    static {
        GlobalAutoGenDeserializerCache.a(FetchZeroInterstitialContentResult.class, new FetchZeroInterstitialContentResultDeserializer());
        m10654e();
    }

    public FetchZeroInterstitialContentResultDeserializer() {
        a(FetchZeroInterstitialContentResult.class);
    }

    private static synchronized Map<String, FbJsonField> m10654e() {
        Map<String, FbJsonField> map;
        synchronized (FetchZeroInterstitialContentResultDeserializer.class) {
            if (f5898a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("title", FbJsonField.jsonField(FetchZeroInterstitialContentResult.class.getDeclaredField("mTitle")));
                    builder.b("subtitle", FbJsonField.jsonField(FetchZeroInterstitialContentResult.class.getDeclaredField("mSubTitle")));
                    builder.b("description_text", FbJsonField.jsonField(FetchZeroInterstitialContentResult.class.getDeclaredField("mDescriptionText")));
                    builder.b("image_url", FbJsonField.jsonField(FetchZeroInterstitialContentResult.class.getDeclaredField("mImageUrl")));
                    builder.b("should_use_default_image", FbJsonField.jsonField(FetchZeroInterstitialContentResult.class.getDeclaredField("mShouldUseDefaultImage")));
                    builder.b("facepile_text", FbJsonField.jsonField(FetchZeroInterstitialContentResult.class.getDeclaredField("mFacepileText")));
                    builder.b("facepile_profile_picture_urls", FbJsonField.jsonField(FetchZeroInterstitialContentResult.class.getDeclaredField("mProfilePictureUrls"), String.class));
                    builder.b("detail_text", FbJsonField.jsonField(FetchZeroInterstitialContentResult.class.getDeclaredField("mDetailText")));
                    builder.b("clickable_link_text", FbJsonField.jsonField(FetchZeroInterstitialContentResult.class.getDeclaredField("mClickableLinkText")));
                    builder.b("clickable_link_url", FbJsonField.jsonField(FetchZeroInterstitialContentResult.class.getDeclaredField("mClickableLinkUrl")));
                    builder.b("primary_button_text", FbJsonField.jsonField(FetchZeroInterstitialContentResult.class.getDeclaredField("mPrimaryButtonText")));
                    builder.b("primary_button_intent_url", FbJsonField.jsonField(FetchZeroInterstitialContentResult.class.getDeclaredField("mPrimaryButtonIntentUrl")));
                    builder.b("primary_button_step", FbJsonField.jsonField(FetchZeroInterstitialContentResult.class.getDeclaredField("mPrimaryButtonStep")));
                    builder.b("primary_button_action", FbJsonField.jsonField(FetchZeroInterstitialContentResult.class.getDeclaredField("mPrimaryButtonAction")));
                    builder.b("secondary_button_text", FbJsonField.jsonField(FetchZeroInterstitialContentResult.class.getDeclaredField("mSecondaryButtonText")));
                    builder.b("secondary_button_intent_url", FbJsonField.jsonField(FetchZeroInterstitialContentResult.class.getDeclaredField("mSecondaryButtonIntentUrl")));
                    builder.b("secondary_button_step", FbJsonField.jsonField(FetchZeroInterstitialContentResult.class.getDeclaredField("mSecondaryButtonStep")));
                    builder.b("secondary_button_action", FbJsonField.jsonField(FetchZeroInterstitialContentResult.class.getDeclaredField("mSecondaryButtonAction")));
                    builder.b("secondary_button_override_back_only", FbJsonField.jsonField(FetchZeroInterstitialContentResult.class.getDeclaredField("mSecondaryButtonOverrideBackOnly")));
                    builder.b("campaign_token_to_refresh_type", FbJsonField.jsonField(FetchZeroInterstitialContentResult.class.getDeclaredField("mCampaignTokenToRefreshType")));
                    f5898a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f5898a;
        }
        return map;
    }

    public final FbJsonField m10655a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m10654e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m10654e().keySet());
    }
}
