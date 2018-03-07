package com.facebook.groups.fb4a.react;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.groups.memberlist.intent.MembershipIntentBuilder;
import com.facebook.inject.Assisted;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: payments_card_scanner_success */
public class Fb4aGroupNavigationLauncher {
    public final Activity f6905a;
    public final Resources f6906b;
    public final SecureContextHelper f6907c;
    private final Provider<ComponentName> f6908d;
    public final UriIntentMapper f6909e;
    private final MembershipIntentBuilder f6910f;
    public final FbUriIntentHandler f6911g;

    @Inject
    public Fb4aGroupNavigationLauncher(@Assisted Activity activity, Resources resources, SecureContextHelper secureContextHelper, @FragmentChromeActivity Provider<ComponentName> provider, UriIntentMapper uriIntentMapper, MembershipIntentBuilder membershipIntentBuilder, FbUriIntentHandler fbUriIntentHandler) {
        this.f6905a = activity;
        this.f6906b = resources;
        this.f6907c = secureContextHelper;
        this.f6908d = provider;
        this.f6909e = uriIntentMapper;
        this.f6910f = membershipIntentBuilder;
        this.f6911g = fbUriIntentHandler;
    }

    private Intent m7191a() {
        return new Intent().setComponent((ComponentName) this.f6908d.get());
    }

    public final void m7192a(String str) {
        Intent a = m7191a();
        a.putExtra("target_fragment", ContentFragmentType.GROUP_CREATE_SIDE_CONVERSATION_FRAGMENT.ordinal());
        a.putExtra("group_feed_id", str);
        this.f6907c.a(a, this.f6905a);
    }

    public final void m7194a(String str, String str2, boolean z, String str3, String str4) {
        this.f6907c.a(this.f6910f.a(str, str2, z, str3, str4), this.f6905a);
    }

    public final void m7193a(String str, String str2, String str3) {
        Intent a = m7191a();
        a.putExtra("group_feed_id", str);
        a.putExtra("target_fragment", ContentFragmentType.GROUP_MEMBER_PICKER_FRAGMENT.ordinal());
        a.putExtra("group_visibility", str2);
        a.putExtra("group_url", str3);
        this.f6907c.a(a, this.f6905a);
    }
}
