package com.facebook.platform.composer.targetprivacy;

import com.facebook.base.fragment.FbFragment;

/* compiled from: results_module_result_type */
public class PlatformComposerFriendSearchFragment extends PlatformComposerProfileSearchFragment {
    private PlatformComposerFriendsFragment f4302c;

    protected final FbFragment mo200e() {
        if (this.f4302c == null) {
            this.f4302c = PlatformComposerFriendsFragment.m4222n(this.s);
            this.f4302c.ar = this.f4300a;
            this.f4302c.am = true;
        }
        return this.f4302c;
    }

    protected final void mo199b() {
        this.b = jW_().getString(2131238397);
    }
}
