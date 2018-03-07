package com.facebook.groups.fb4a.react;

import android.app.Activity;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.groups.memberlist.intent.MembershipIntentBuilder;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;

/* compiled from: payments_card_scanner_fail */
public class Fb4aGroupNavigationLauncherProvider extends AbstractAssistedProvider<Fb4aGroupNavigationLauncher> {
    public final Fb4aGroupNavigationLauncher m7195a(Activity activity) {
        return new Fb4aGroupNavigationLauncher(activity, ResourcesMethodAutoProvider.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), IdBasedProvider.a(this, 12), (UriIntentMapper) Fb4aUriIntentMapper.a(this), MembershipIntentBuilder.a(this), FbUriIntentHandler.a(this));
    }
}
