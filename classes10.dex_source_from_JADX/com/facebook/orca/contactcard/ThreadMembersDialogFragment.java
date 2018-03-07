package com.facebook.orca.contactcard;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.util.ContextUtils;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.orca.contactcard.ThreadMembersView.Listener;
import com.facebook.orca.threadview.GroupThreadMembersActions;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;

/* compiled from: onion_state_change */
public class ThreadMembersDialogFragment extends FbDialogFragment {
    public GroupThreadMembersActions am;
    public ThreadSummary an;

    /* compiled from: onion_state_change */
    class C08381 implements Listener {
        final /* synthetic */ ThreadMembersDialogFragment f5777a;

        C08381(ThreadMembersDialogFragment threadMembersDialogFragment) {
            this.f5777a = threadMembersDialogFragment;
        }

        public final void mo216a(User user) {
            this.f5777a.a();
            this.f5777a.am.m6573a(user);
        }

        public final void mo215a() {
            this.f5777a.a();
            this.f5777a.am.m6572a(this.f5777a.an.a);
        }
    }

    public final void m5467a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -253783152);
        super.a(bundle);
        FbInjector.a(ThreadMembersDialogFragment.class, this);
        a(2, 2131625142);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -650720886, a);
    }

    public final View m5466a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -675448423);
        ThreadMembersView threadMembersView = (ThreadMembersView) layoutInflater.cloneInContext(ContextUtils.a(getContext(), 2130772966, 2131625114)).inflate(2130905702, viewGroup, false);
        threadMembersView.setThreadSummary(this.an);
        threadMembersView.f5788i = new C08381(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -184014095, a);
        return threadMembersView;
    }

    public final Dialog m5468c(Bundle bundle) {
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            this.an = (ThreadSummary) bundle2.getParcelable("thread_summary");
        }
        Preconditions.checkNotNull(this.an);
        Dialog c = super.c(bundle);
        c.setCanceledOnTouchOutside(true);
        return c;
    }
}
