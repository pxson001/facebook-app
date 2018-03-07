package com.facebook.groupcommerce.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.groupcommerce.util.GroupCommerceLogger;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.dialogs.FbDialogFragment;

/* compiled from: ae0d17ae1690700d23953b398f2755ae */
public final class GroupsSalePostInterceptDialogFragment extends FbDialogFragment {
    public OnClickListener am;
    public OnClickListener an;
    public GroupCommerceLogger ao;

    /* compiled from: ae0d17ae1690700d23953b398f2755ae */
    class C11661 implements OnClickListener {
        final /* synthetic */ GroupsSalePostInterceptDialogFragment f10077a;

        C11661(GroupsSalePostInterceptDialogFragment groupsSalePostInterceptDialogFragment) {
            this.f10077a = groupsSalePostInterceptDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f10077a.ao.a.a(new HoneyClientEvent("composer_group_sale_post_intercept_accepted"));
            this.f10077a.am.onClick(dialogInterface, i);
        }
    }

    /* compiled from: ae0d17ae1690700d23953b398f2755ae */
    class C11672 implements OnClickListener {
        final /* synthetic */ GroupsSalePostInterceptDialogFragment f10078a;

        C11672(GroupsSalePostInterceptDialogFragment groupsSalePostInterceptDialogFragment) {
            this.f10078a = groupsSalePostInterceptDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f10078a.ao.a.a(new HoneyClientEvent("composer_group_sale_post_intercept_declined"));
            this.f10078a.an.onClick(dialogInterface, i);
        }
    }

    public static void m10426a(Object obj, Context context) {
        ((GroupsSalePostInterceptDialogFragment) obj).ao = GroupCommerceLogger.a(FbInjector.get(context));
    }

    public final void m10427a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -343496907);
        super.a(bundle);
        Class cls = GroupsSalePostInterceptDialogFragment.class;
        m10426a(this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -227620119, a);
    }

    public final Dialog m10428c(Bundle bundle) {
        CharSequence b = b(2131242387);
        CharSequence b2 = b(2131242388);
        CharSequence b3 = b(2131242389);
        CharSequence b4 = b(2131242390);
        FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(getContext());
        fbAlertDialogBuilder.a(b);
        fbAlertDialogBuilder.b(b2);
        fbAlertDialogBuilder.a(b3, new C11661(this));
        fbAlertDialogBuilder.b(b4, new C11672(this));
        HoneyClientEventFast a = this.ao.a.a("composer_group_sale_post_intercept", false);
        if (a.a()) {
            a.b();
        }
        return fbAlertDialogBuilder.b();
    }
}
