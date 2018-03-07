package com.facebook.devicebasedlogin.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: The observer is null. */
public class DBLLoggedInAccountSettingsProgressFragment extends FbFragment {
    public final View m26156a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1214760363);
        View inflate = layoutInflater.inflate(2130903857, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -154267829, a);
        return inflate;
    }
}
