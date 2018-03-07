package com.facebook.orca.contactcard;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.orca.threadview.RemoveMembersHelper;
import com.facebook.orca.threadview.RemoveMembersHelper.Listener;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: onthisday */
public class RemoveMembersFragment extends FbDialogFragment {
    public RemoveMembersHelper am;
    public ErrorDialogs an;
    public ThreadSummary ao;

    /* compiled from: onthisday */
    class C08361 implements Listener {
        final /* synthetic */ RemoveMembersFragment f5774a;

        /* compiled from: onthisday */
        class C08351 implements OnClickListener {
            final /* synthetic */ C08361 f5773a;

            C08351(C08361 c08361) {
                this.f5773a = c08361;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.f5773a.f5774a.b();
            }
        }

        C08361(RemoveMembersFragment removeMembersFragment) {
            this.f5774a = removeMembersFragment;
        }

        public final void mo213a() {
            this.f5774a.b();
        }

        public final void mo214a(ServiceException serviceException) {
            ErrorDialogs errorDialogs = this.f5774a.an;
            ErrorDialogParamsBuilder a = ErrorDialogParams.a(this.f5774a.jW_()).a(2131230721);
            a.f = serviceException;
            a = a;
            a.g = new C08351(this);
            errorDialogs.a(a.l());
        }
    }

    public final void m5462a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1388249260);
        super.a(bundle);
        FbInjector.a(RemoveMembersFragment.class, this);
        a(2, 2131625142);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 618733724, a);
    }

    public final View m5461a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1637067264);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(ContextUtils.a(getContext(), 2130772966, 2131625114));
        this.am.f7363c = new C08361(this);
        final ThreadMembersView threadMembersView = (ThreadMembersView) cloneInContext.inflate(2130905702, viewGroup, false);
        threadMembersView.setActionCaption(jW_().getString(2131231715));
        threadMembersView.f5789j = true;
        threadMembersView.f5790k = true;
        threadMembersView.setThreadSummary(this.ao);
        threadMembersView.setActionButtonEnabled(false);
        threadMembersView.f5788i = new ThreadMembersView.Listener(this) {
            final /* synthetic */ RemoveMembersFragment f5776b;

            public final void mo216a(User user) {
                threadMembersView.setActionButtonEnabled(!threadMembersView.getSelectedUsers().isEmpty());
            }

            public final void mo215a() {
                ImmutableList selectedUsers = threadMembersView.getSelectedUsers();
                int size = selectedUsers.size();
                for (int i = 0; i < size; i++) {
                    User user = (User) selectedUsers.get(i);
                    RemoveMembersFragment removeMembersFragment = this.f5776b;
                    removeMembersFragment.am.m6997a(removeMembersFragment.getContext(), user, removeMembersFragment.ao);
                }
            }
        };
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2112415891, a);
        return threadMembersView;
    }

    public final Dialog m5463c(Bundle bundle) {
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            this.ao = (ThreadSummary) bundle2.getParcelable("thread_summary");
        }
        Preconditions.checkNotNull(this.ao);
        Dialog c = super.c(bundle);
        c.setCanceledOnTouchOutside(true);
        return c;
    }
}
