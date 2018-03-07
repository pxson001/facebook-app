package com.facebook.socialgood.guestlist;

import android.content.res.Resources;
import android.text.TextUtils;
import com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserConnectionsFragmentModel;

/* compiled from: PAGES_LAUNCHPOINT_FEED_FRAGMENT */
public class FundraiserGuestListUser {
    private final FundraiserConnectionsFragmentModel f12682a;
    public boolean f12683b = false;
    private boolean f12684c;

    public FundraiserGuestListUser(FundraiserConnectionsFragmentModel fundraiserConnectionsFragmentModel, boolean z) {
        this.f12682a = fundraiserConnectionsFragmentModel;
        this.f12684c = z;
    }

    public final String m13190c() {
        return this.f12682a.m13075m();
    }

    public final String m13189a(Resources resources) {
        if (this.f12682a.m13074l() == null || this.f12682a.m13074l().m13060a() == 0 || this.f12684c || this.f12682a.m13073k()) {
            return "";
        }
        return resources.getQuantityString(2131689819, this.f12682a.m13074l().m13060a(), new Object[]{Integer.valueOf(this.f12682a.m13074l().m13060a())});
    }

    public final String m13191d() {
        if (this.f12682a.m13076n() == null || TextUtils.isEmpty(this.f12682a.m13076n().b())) {
            return null;
        }
        return this.f12682a.m13076n().b();
    }

    public final String m13192e() {
        return this.f12682a.m13072j();
    }
}
