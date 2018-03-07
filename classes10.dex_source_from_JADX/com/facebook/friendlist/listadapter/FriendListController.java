package com.facebook.friendlist.listadapter;

import android.content.Context;
import android.os.Bundle;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.friendlist.data.FriendPageListItemModel;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.widget.compositeadapter.CompositeAdapter.Controller;
import javax.inject.Inject;

/* compiled from: action_mechanism */
public class FriendListController implements Controller<Object> {
    private final FbUriIntentHandler f20380a;
    private final Lazy<NavigationLogger> f20381b;

    public static FriendListController m20645b(InjectorLike injectorLike) {
        return new FriendListController(FbUriIntentHandler.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 137));
    }

    @Inject
    public FriendListController(FbUriIntentHandler fbUriIntentHandler, Lazy<NavigationLogger> lazy) {
        this.f20380a = fbUriIntentHandler;
        this.f20381b = lazy;
    }

    public final boolean m20647a() {
        return true;
    }

    public final boolean m20648b() {
        return false;
    }

    public final void m20646a(Context context, Object obj) {
        if (obj instanceof FriendPageListItemModel) {
            boolean z;
            FriendPageListItemModel friendPageListItemModel = (FriendPageListItemModel) obj;
            String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, Long.valueOf(friendPageListItemModel.m20575a()));
            Bundle bundle = new Bundle();
            ModelBundle.a(bundle, String.valueOf(friendPageListItemModel.m20575a()), friendPageListItemModel.m20580d(), friendPageListItemModel.m20577b());
            bundle.putSerializable("timeline_friend_request_ref", FriendRequestMakeRef.FRIENDS_TAB);
            String str = "timeline_has_unseen_section";
            if (friendPageListItemModel.f20307i > 0) {
                z = true;
            } else {
                z = false;
            }
            bundle.putBoolean(str, z);
            ((NavigationLogger) this.f20381b.get()).a("tap_friendlist_item");
            this.f20380a.a(context, formatStrLocaleSafe, bundle);
        }
    }
}
