package com.facebook.friendsnearby.ui;

import android.view.View;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.facebook.widget.tokenizedtypeahead.ui.listview.DefaultViewFactory;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import javax.inject.Inject;

/* compiled from: Wirehog Request Profiling */
public class FriendsNearbyInviteAdapterViewFactory extends DefaultViewFactory {
    public ImmutableSet<String> f20922a = RegularImmutableSet.a;

    @Inject
    public FriendsNearbyInviteAdapterViewFactory() {
        super(true);
    }

    public final void m21881a(View view, BaseToken baseToken, boolean z) {
        SimpleUserToken simpleUserToken = (SimpleUserToken) baseToken;
        if (this.f20922a.contains(simpleUserToken.g.b())) {
            super.a(view, new InvitedSimpleUserToken(simpleUserToken, view.getResources().getString(2131242024, new Object[]{simpleUserToken.b()})), z);
            return;
        }
        super.a(view, simpleUserToken, z);
    }
}
