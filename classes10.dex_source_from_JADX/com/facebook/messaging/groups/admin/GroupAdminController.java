package com.facebook.messaging.groups.admin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.groups.links.gatekeepers.JoinableLinksGatekeepers;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummary.GroupType;
import com.facebook.orca.threadview.MessengerContactRowMenuHelper.C10871.C10861;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: sideloading_post_ready_to_install_notification */
public class GroupAdminController {
    public final Provider<UserKey> f2428a;
    private final JoinableLinksGatekeepers f2429b;

    public static GroupAdminController m2341b(InjectorLike injectorLike) {
        return new GroupAdminController(IdBasedProvider.a(injectorLike, 3597), JoinableLinksGatekeepers.m2480a(injectorLike));
    }

    @Inject
    public GroupAdminController(Provider<UserKey> provider, JoinableLinksGatekeepers joinableLinksGatekeepers) {
        this.f2428a = provider;
        this.f2429b = joinableLinksGatekeepers;
    }

    public final boolean m2344a(ThreadSummary threadSummary) {
        if (this.f2429b.m2482a() && threadSummary.P == GroupType.HIDDEN) {
            return true;
        }
        return false;
    }

    public final boolean m2345a(ThreadSummary threadSummary, UserKey userKey) {
        if (!m2344a(threadSummary)) {
            return false;
        }
        ThreadParticipant a = threadSummary.a(userKey);
        if (a != null) {
            return a.e;
        }
        return false;
    }

    public final boolean m2346c(ThreadSummary threadSummary) {
        if (!m2344a(threadSummary)) {
            return false;
        }
        if (threadSummary == null) {
            return false;
        }
        ThreadParticipant a = threadSummary.a((UserKey) this.f2428a.get());
        if (a == null) {
            return false;
        }
        return a.e;
    }

    public final boolean m2347e(ThreadSummary threadSummary) {
        if (m2344a(threadSummary) && !m2340a(threadSummary.h).isEmpty()) {
            return true;
        }
        return false;
    }

    public static ImmutableList<ThreadParticipant> m2340a(ImmutableList<ThreadParticipant> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ThreadParticipant threadParticipant = (ThreadParticipant) immutableList.get(i);
            if (threadParticipant.e) {
                builder.c(threadParticipant);
            }
        }
        return builder.b();
    }

    public final void m2343a(ThreadSummary threadSummary, C10861 c10861) {
        if (!m2344a(threadSummary)) {
            c10861.m6921a();
        } else if (m2346c(threadSummary) || !m2347e(threadSummary)) {
            c10861.m6921a();
        } else {
            AdminAlertDialogFactory.m2336a(c10861.f7237b.f7239b.f7242a).b();
            GroupsAdminLogger groupsAdminLogger = (GroupsAdminLogger) c10861.f7237b.f7239b.f7252k.get();
            ThreadSummary threadSummary2 = c10861.f7237b.f7239b.f7257p;
            if (threadSummary2 != null && threadSummary2.a.b() && groupsAdminLogger.f2430a.m2344a(threadSummary2)) {
                HoneyClientEventFast a = groupsAdminLogger.f2431b.a("member_remove_attempt", false);
                if (a.a()) {
                    a.a("tfbid", threadSummary2.a.i()).a("groupsize", threadSummary2.h.size());
                    a.b();
                }
            }
        }
    }

    public final void m2342a(ThreadSummary threadSummary, final AdminRequiredActionCallback adminRequiredActionCallback, Context context) {
        if (!this.f2429b.m2483a(threadSummary)) {
            return;
        }
        if (!m2347e(threadSummary)) {
            AlertDialog.Builder b = new FbAlertDialogBuilder(context).a(false).a(2131231894).b(2131231895);
            b.a(2131231896, new OnClickListener(this) {
                final /* synthetic */ GroupAdminController f2425b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    adminRequiredActionCallback.mo72a();
                    dialogInterface.dismiss();
                }
            });
            b.b(17039360, new OnClickListener(this) {
                final /* synthetic */ GroupAdminController f2427b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    adminRequiredActionCallback.mo73b();
                    dialogInterface.dismiss();
                }
            });
            b.b();
        } else if (m2346c(threadSummary)) {
            adminRequiredActionCallback.mo72a();
        } else {
            adminRequiredActionCallback.mo74c();
        }
    }
}
