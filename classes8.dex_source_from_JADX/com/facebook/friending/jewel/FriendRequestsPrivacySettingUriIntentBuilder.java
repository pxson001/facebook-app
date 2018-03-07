package com.facebook.friending.jewel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;
import javax.inject.Inject;

/* compiled from: firstSix */
public class FriendRequestsPrivacySettingUriIntentBuilder extends UriIntentBuilder {
    IUriTemplateIntentBuilder f13213a = new C13831(this);

    /* compiled from: firstSix */
    class C13831 implements IUriTemplateIntentBuilder {
        final /* synthetic */ FriendRequestsPrivacySettingUriIntentBuilder f13212a;

        C13831(FriendRequestsPrivacySettingUriIntentBuilder friendRequestsPrivacySettingUriIntentBuilder) {
            this.f13212a = friendRequestsPrivacySettingUriIntentBuilder;
        }

        public final Intent m14872a(Context context, Bundle bundle) {
            return new Intent(context, FriendRequestsPrivacySettingService.class);
        }
    }

    @Inject
    public FriendRequestsPrivacySettingUriIntentBuilder() {
        a(FBLinks.fo, this.f13213a);
    }
}
