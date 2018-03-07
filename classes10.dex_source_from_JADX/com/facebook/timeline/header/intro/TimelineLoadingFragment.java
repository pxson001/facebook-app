package com.facebook.timeline.header.intro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;

/* compiled from: fetch_more_in_section */
public class TimelineLoadingFragment extends FbFragment {
    public final View m11894a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1545337752);
        LoadingIndicatorView loadingIndicatorView = (LoadingIndicatorView) layoutInflater.inflate(2130907468, viewGroup, false);
        loadingIndicatorView.a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 322919349, a);
        return loadingIndicatorView;
    }
}
