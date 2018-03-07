package com.facebook.events.invite.common;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.messaging.util.MessengerAppUtils;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: header_two_style */
public class EventInviteNavigationHelper {
    private boolean f11447a;
    private Context f11448b;
    public MessengerAppUtils f11449c;
    private QeAccessor f11450d;
    private UriIntentMapper f11451e;

    public static EventInviteNavigationHelper m13376b(InjectorLike injectorLike) {
        return new EventInviteNavigationHelper(Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), MessengerAppUtils.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike));
    }

    @Inject
    public EventInviteNavigationHelper(Boolean bool, Context context, MessengerAppUtils messengerAppUtils, QeAccessor qeAccessor, UriIntentMapper uriIntentMapper) {
        this.f11447a = bool.booleanValue();
        this.f11448b = context;
        this.f11449c = messengerAppUtils;
        this.f11450d = qeAccessor;
        this.f11451e = uriIntentMapper;
    }

    public final Intent m13377a(String str, String str2, GraphQLEventPrivacyType graphQLEventPrivacyType, boolean z, String str3) {
        if (str == null || str3 == null) {
            return null;
        }
        String formatStrLocaleSafe;
        boolean z2 = str2 == null && graphQLEventPrivacyType == GraphQLEventPrivacyType.PRIVATE_TYPE && !this.f11447a && z && this.f11450d.a(ExperimentsForEventsGatingModule.E, false);
        if (str2 != null) {
            formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.bM, str, str2);
        } else if (z2) {
            formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.bL, str);
        } else {
            formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.bK, str);
        }
        Intent a = this.f11451e.a(this.f11448b, formatStrLocaleSafe);
        a.putExtra("extra_invite_action_mechanism", str3);
        if (z2) {
            return a;
        }
        boolean z3;
        String str4 = "extra_enable_invite_through_messenger";
        if ((graphQLEventPrivacyType == GraphQLEventPrivacyType.PRIVATE_TYPE || graphQLEventPrivacyType == GraphQLEventPrivacyType.GROUP) && this.f11449c.d() && this.f11449c.a("50.0")) {
            z3 = true;
        } else {
            z3 = false;
        }
        a.putExtra(str4, z3);
        return a;
    }
}
