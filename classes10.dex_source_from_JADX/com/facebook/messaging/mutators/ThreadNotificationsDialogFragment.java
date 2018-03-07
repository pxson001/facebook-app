package com.facebook.messaging.mutators;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.notify.bridge.NotificationBridge;
import com.facebook.messaging.notify.bridge.NotificationBridgeMethodAutoProvider;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.google.common.base.Preconditions;

/* compiled from: rowMessage */
public class ThreadNotificationsDialogFragment extends FbDialogFragment {
    public NotificationBridge am;

    public static void m3249a(Object obj, Context context) {
        ((ThreadNotificationsDialogFragment) obj).am = NotificationBridgeMethodAutoProvider.a(FbInjector.get(context));
    }

    public static ThreadNotificationsDialogFragment m3248a(ThreadKey threadKey) {
        Preconditions.checkNotNull(threadKey);
        ThreadNotificationsDialogFragment threadNotificationsDialogFragment = new ThreadNotificationsDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("thread_key", threadKey);
        threadNotificationsDialogFragment.g(bundle);
        return threadNotificationsDialogFragment;
    }

    public final void m3250a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 852980595);
        super.a(bundle);
        Class cls = ThreadNotificationsDialogFragment.class;
        m3249a(this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1218536471, a);
    }

    public final Dialog m3251c(Bundle bundle) {
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            bundle2.getParcelable("thread_key");
        }
        return this.am.b();
    }
}
