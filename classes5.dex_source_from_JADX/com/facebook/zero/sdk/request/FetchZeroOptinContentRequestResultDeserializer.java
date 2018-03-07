package com.facebook.zero.sdk.request;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: com.facebook.base.activity.FragmentBaseActivity */
public class FetchZeroOptinContentRequestResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f5901a;

    static {
        GlobalAutoGenDeserializerCache.a(FetchZeroOptinContentRequestResult.class, new FetchZeroOptinContentRequestResultDeserializer());
        m10678e();
    }

    public FetchZeroOptinContentRequestResultDeserializer() {
        a(FetchZeroOptinContentRequestResult.class);
    }

    private static synchronized Map<String, FbJsonField> m10678e() {
        Map<String, FbJsonField> map;
        synchronized (FetchZeroOptinContentRequestResultDeserializer.class) {
            if (f5901a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("title", FbJsonField.jsonField(FetchZeroOptinContentRequestResult.class.getDeclaredField("mTitle")));
                    builder.b("description_text", FbJsonField.jsonField(FetchZeroOptinContentRequestResult.class.getDeclaredField("mDescriptionText")));
                    builder.b("logo_url", FbJsonField.jsonField(FetchZeroOptinContentRequestResult.class.getDeclaredField("mLogoUrl")));
                    builder.b("friends_text", FbJsonField.jsonField(FetchZeroOptinContentRequestResult.class.getDeclaredField("mFriendsText")));
                    builder.b("friends_profile_picture_urls", FbJsonField.jsonField(FetchZeroOptinContentRequestResult.class.getDeclaredField("mProfilePictureUrls"), String.class));
                    builder.b("legal_disclaimer_text", FbJsonField.jsonField(FetchZeroOptinContentRequestResult.class.getDeclaredField("mLegalDisclaimerText")));
                    builder.b("learn_more_text", FbJsonField.jsonField(FetchZeroOptinContentRequestResult.class.getDeclaredField("mLearnMoreText")));
                    builder.b("learn_more_url", FbJsonField.jsonField(FetchZeroOptinContentRequestResult.class.getDeclaredField("mLearnMoreUrl")));
                    builder.b("optin_decline_title", FbJsonField.jsonField(FetchZeroOptinContentRequestResult.class.getDeclaredField("mOptinDeclineTitle")));
                    builder.b("optin_decline_confirm_text", FbJsonField.jsonField(FetchZeroOptinContentRequestResult.class.getDeclaredField("mOptinDeclineConfirmText")));
                    builder.b("optin_decline_button_confirm_text", FbJsonField.jsonField(FetchZeroOptinContentRequestResult.class.getDeclaredField("mOptinDeclineButtonConfirmText")));
                    builder.b("optin_decline_button_cancel_text", FbJsonField.jsonField(FetchZeroOptinContentRequestResult.class.getDeclaredField("mOptinDeclineButtonCancelText")));
                    builder.b("optin_confirm_button_text", FbJsonField.jsonField(FetchZeroOptinContentRequestResult.class.getDeclaredField("mOptinConfirmButtonText")));
                    builder.b("optin_decline_button_text", FbJsonField.jsonField(FetchZeroOptinContentRequestResult.class.getDeclaredField("mOptinDeclineButtonText")));
                    f5901a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f5901a;
        }
        return map;
    }

    public final FbJsonField m10679a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m10678e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m10678e().keySet());
    }
}
