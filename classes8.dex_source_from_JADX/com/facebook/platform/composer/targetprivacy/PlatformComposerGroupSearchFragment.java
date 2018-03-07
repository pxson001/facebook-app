package com.facebook.platform.composer.targetprivacy;

import com.facebook.base.fragment.FbFragment;

/* compiled from: results_module_display_style */
public class PlatformComposerGroupSearchFragment extends PlatformComposerProfileSearchFragment {
    private PlatformComposerGroupFragment f4335c;

    protected final FbFragment mo200e() {
        if (this.f4335c == null) {
            this.f4335c = PlatformComposerGroupFragment.m4233n(this.s);
            this.f4335c.ao = this.f4300a;
            this.f4335c.am = true;
        }
        return this.f4335c;
    }

    protected final void mo199b() {
        this.b = jW_().getString(2131238398);
    }
}
