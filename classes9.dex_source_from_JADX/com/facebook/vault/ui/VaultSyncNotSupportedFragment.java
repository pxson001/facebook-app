package com.facebook.vault.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: text/vnd.wap.connectivity-xml */
public class VaultSyncNotSupportedFragment extends FbFragment {
    public final View m2061a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1735108289);
        View inflate = layoutInflater.inflate(2130907647, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -647882897, a);
        return inflate;
    }
}
