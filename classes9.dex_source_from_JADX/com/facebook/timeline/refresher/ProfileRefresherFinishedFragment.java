package com.facebook.timeline.refresher;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;

/* compiled from: updatePinnedThreads */
public class ProfileRefresherFinishedFragment extends FbFragment implements OnClickListener {
    private FinishedFragmentListener f976a;
    private FbButton f977b;

    /* compiled from: updatePinnedThreads */
    public interface FinishedFragmentListener {
        void mo46i();
    }

    public final void m998a(Activity activity) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1539783518);
        super.a(activity);
        this.f976a = (FinishedFragmentListener) activity;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 187123027, a);
    }

    public final View m997a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1742999728);
        View inflate = layoutInflater.inflate(2130906469, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -611206611, a);
        return inflate;
    }

    public final void m999d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1835287044);
        super.d(bundle);
        this.f977b = (FbButton) e(2131566396);
        this.f977b.setOnClickListener(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1748827873, a);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 2122172141);
        if (view == this.f977b) {
            this.f976a.mo46i();
        }
        Logger.a(2, EntryType.UI_INPUT_END, 533488850, a);
    }
}
