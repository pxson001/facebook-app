package com.facebook.katana;

import android.annotation.SuppressLint;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.UriFlaggedIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.UriBuilder;
import com.facebook.common.uri.UriMapPattern;
import javax.inject.Inject;

@UriMapPattern
/* compiled from: value is not a supported type. */
public class SettingsIntentUriBuilder extends UriIntentBuilder {
    @Inject
    @SuppressLint({"DeprecatedMethod"})
    public SettingsIntentUriBuilder() {
        a(FBLinks.a("settings/notifications"), new UriFlaggedIntentBuilder(new UriBuilder(NotificationSettingsActivity.class), 67108864));
        a(FBLinks.a("settings/tor"), new UriFlaggedIntentBuilder(new UriBuilder(FacebookOverTorSettingsActivity.class), 67108864));
    }
}
