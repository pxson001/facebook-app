package com.facebook.messaging.mutators;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.blocking.BlockingAnalyticsLogger;
import com.facebook.messaging.groups.admin.GroupsAdminLogger;
import com.facebook.messaging.groups.threadactions.GroupThreadActionHandler;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.C11603;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: same_logged_in_user */
public class AskToOpenThreadDialogFragment extends FbDialogFragment {
    @Inject
    public BlockingAnalyticsLogger am;
    @Inject
    public Lazy<GroupThreadActionHandler> an;
    @Inject
    public GroupsAdminLogger ao;
    public ThreadSummary ap;
    public C11603 aq;

    /* compiled from: same_logged_in_user */
    class C05311 implements OnClickListener {
        final /* synthetic */ AskToOpenThreadDialogFragment f3314a;

        C05311(AskToOpenThreadDialogFragment askToOpenThreadDialogFragment) {
            this.f3314a = askToOpenThreadDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            HoneyClientEventFast a = this.f3314a.am.a.a("message_block_select_leave_group_from_blocked_warning_alert", false);
            if (a.a()) {
                a.b();
            }
            this.f3314a.ao.m2350a(this.f3314a.ap, "thread_blocking_flow");
            ((GroupThreadActionHandler) this.f3314a.an.get()).m2575a(this.f3314a.D, this.f3314a.ap);
        }
    }

    /* compiled from: same_logged_in_user */
    class C05322 implements OnClickListener {
        final /* synthetic */ AskToOpenThreadDialogFragment f3315a;

        C05322(AskToOpenThreadDialogFragment askToOpenThreadDialogFragment) {
            this.f3315a = askToOpenThreadDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            HoneyClientEventFast a = this.f3315a.am.a.a("message_block_select_see_conversation_from_blocked_warning_alert", false);
            if (a.a()) {
                a.b();
            }
            this.f3315a.a();
        }
    }

    /* compiled from: same_logged_in_user */
    class C05333 implements OnClickListener {
        final /* synthetic */ AskToOpenThreadDialogFragment f3316a;

        C05333(AskToOpenThreadDialogFragment askToOpenThreadDialogFragment) {
            this.f3316a = askToOpenThreadDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Preconditions.checkNotNull(this.f3316a.aq);
            this.f3316a.aq.m7465a();
            HoneyClientEventFast a = this.f3316a.am.a.a("message_block_select_cancel_from_blocked_warning_alert", false);
            if (a.a()) {
                a.b();
            }
            this.f3316a.b();
        }
    }

    public static void m3224a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        AskToOpenThreadDialogFragment askToOpenThreadDialogFragment = (AskToOpenThreadDialogFragment) obj;
        BlockingAnalyticsLogger b = BlockingAnalyticsLogger.b(fbInjector);
        Lazy a = IdBasedLazy.a(fbInjector, 7872);
        GroupsAdminLogger b2 = GroupsAdminLogger.m2349b(fbInjector);
        askToOpenThreadDialogFragment.am = b;
        askToOpenThreadDialogFragment.an = a;
        askToOpenThreadDialogFragment.ao = b2;
    }

    public final void m3225a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1461541997);
        super.a(bundle);
        Class cls = AskToOpenThreadDialogFragment.class;
        m3224a(this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1857452275, a);
    }

    public final Dialog m3226c(Bundle bundle) {
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            this.ap = (ThreadSummary) bundle2.getParcelable("thread_summary");
        }
        Preconditions.checkNotNull(this.ap);
        if (!this.ap.w) {
            b();
        }
        FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(getContext());
        fbAlertDialogBuilder.a(2131240233).b(2131240234).a(2131240239, new C05333(this)).c(2131240235, new C05322(this)).b(2131240236, new C05311(this)).a(false);
        return fbAlertDialogBuilder.a();
    }
}
