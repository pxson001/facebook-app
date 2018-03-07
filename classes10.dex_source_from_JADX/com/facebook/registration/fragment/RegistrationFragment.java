package com.facebook.registration.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.facebook.base.fragment.AbstractNavigableFragment;
import com.facebook.common.util.FindViewUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.registration.constants.RegFragmentState;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.titlebar.HasTitleBar;

/* compiled from: last_used */
public abstract class RegistrationFragment extends AbstractNavigableFragment {
    protected abstract int aq();

    protected abstract int mo384e();

    public final View m8758a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1960875305);
        if (this.g) {
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2092901851, a);
            return null;
        }
        View inflate = layoutInflater.inflate(ar(), viewGroup, false);
        ViewStub viewStub = (ViewStub) FindViewUtil.b(inflate, 2131566930);
        viewStub.setLayoutResource(aq());
        viewStub.inflate();
        mo383b(inflate, bundle);
        LogUtils.f(477629983, a);
        return inflate;
    }

    protected void mo383b(View view, Bundle bundle) {
    }

    protected void q_() {
        super.q_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(mo384e());
        }
    }

    protected int ar() {
        return 2130906815;
    }

    protected void mo385a(RegFragmentState regFragmentState) {
        b(new Intent(regFragmentState.getKey()));
    }
}
