package com.facebook.messaging.ephemeral;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.ephemeral.analytics.EphemeralAnalyticsLogger;
import com.facebook.messaging.ephemeral.gating.EphemeralGatingAccessType;
import com.facebook.messaging.ephemeral.gating.EphemeralGatingUtil;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mStreetNumber */
public class ModifyThreadEphemeralityDialog extends FbDialogFragment {
    private static final int[] aq = new int[]{0, 60000, 900000, 3600000, 14400000, 86400000};
    private static final int[] ar = new int[]{0};
    @Inject
    public EphemeralAnalyticsLogger am;
    @Inject
    public EphemeralGatingUtil an;
    @Inject
    public MessageLifetimeStringHelper ao;
    @Inject
    public ModifyThreadEphemeralityHelper ap;
    public int as = -1;
    public int[] at;
    public String au;

    /* compiled from: mStreetNumber */
    class C12181 implements OnClickListener {
        final /* synthetic */ ModifyThreadEphemeralityDialog f11023a;

        C12181(ModifyThreadEphemeralityDialog modifyThreadEphemeralityDialog) {
            this.f11023a = modifyThreadEphemeralityDialog;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f11023a.am.f11061a.a(new HoneyClientEvent("ephemeral_cancel_change").b("source", this.f11023a.au));
            dialogInterface.cancel();
        }
    }

    /* compiled from: mStreetNumber */
    class C12203 implements OnClickListener {
        final /* synthetic */ ModifyThreadEphemeralityDialog f11026a;

        C12203(ModifyThreadEphemeralityDialog modifyThreadEphemeralityDialog) {
            this.f11026a = modifyThreadEphemeralityDialog;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f11026a.as = i;
        }
    }

    public static void m11438a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ModifyThreadEphemeralityDialog modifyThreadEphemeralityDialog = (ModifyThreadEphemeralityDialog) obj;
        EphemeralAnalyticsLogger b = EphemeralAnalyticsLogger.m11448b(fbInjector);
        EphemeralGatingUtil b2 = EphemeralGatingUtil.b(fbInjector);
        MessageLifetimeStringHelper b3 = MessageLifetimeStringHelper.m11436b(fbInjector);
        ModifyThreadEphemeralityHelper b4 = ModifyThreadEphemeralityHelper.m11443b(fbInjector);
        modifyThreadEphemeralityDialog.am = b;
        modifyThreadEphemeralityDialog.an = b2;
        modifyThreadEphemeralityDialog.ao = b3;
        modifyThreadEphemeralityDialog.ap = b4;
    }

    public static ModifyThreadEphemeralityDialog m11437a(ThreadSummary threadSummary, String str) {
        Preconditions.checkNotNull(threadSummary);
        Preconditions.checkNotNull(str);
        ModifyThreadEphemeralityDialog modifyThreadEphemeralityDialog = new ModifyThreadEphemeralityDialog();
        Bundle bundle = new Bundle();
        bundle.putParcelable("thread_summary_arg", threadSummary);
        bundle.putString("analytics_source_arg", str);
        modifyThreadEphemeralityDialog.g(bundle);
        return modifyThreadEphemeralityDialog;
    }

    public final void m11439a(@Nullable Bundle bundle) {
        EphemeralGatingAccessType ephemeralGatingAccessType;
        Object obj;
        int[] iArr;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1306580822);
        super.a(bundle);
        Class cls = ModifyThreadEphemeralityDialog.class;
        m11438a((Object) this, getContext());
        EphemeralGatingUtil ephemeralGatingUtil = this.an;
        if (ephemeralGatingUtil.a()) {
            ephemeralGatingAccessType = EphemeralGatingAccessType.NONE;
        } else if (ephemeralGatingUtil.a.a(218, false)) {
            ephemeralGatingAccessType = EphemeralGatingAccessType.ENABLE_AND_DISABLE;
        } else {
            ephemeralGatingAccessType = EphemeralGatingAccessType.DISABLE_ONLY;
        }
        if (ephemeralGatingAccessType == EphemeralGatingAccessType.DISABLE_ONLY) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            iArr = ar;
        } else {
            iArr = aq;
        }
        this.at = iArr;
        LogUtils.f(658603395, a);
    }

    private String[] aq() {
        String[] strArr = new String[this.at.length];
        for (int i = 0; i < this.at.length; i++) {
            String string;
            MessageLifetimeStringHelper messageLifetimeStringHelper = this.ao;
            int i2 = this.at[i];
            if (i2 <= 0) {
                string = messageLifetimeStringHelper.f11022a.getString(2131231888);
            } else {
                int i3 = (int) (((long) i2) / 1000);
                int i4 = 2131689504;
                int i5 = (int) (((long) i2) / 60000);
                if (i5 > 0) {
                    i4 = 2131689503;
                } else {
                    i5 = i3;
                }
                i3 = (int) (((long) i2) / 3600000);
                if (i3 > 0) {
                    i4 = 2131689502;
                    i5 = i3;
                }
                i3 = (int) (((long) i2) / 86400000);
                if (i3 > 0) {
                    i4 = 2131689501;
                    i5 = i3;
                }
                string = messageLifetimeStringHelper.f11022a.getQuantityString(i4, i5, new Object[]{Integer.valueOf(i5)});
            }
            strArr[i] = string;
        }
        return strArr;
    }

    public final void m11440a(FragmentManager fragmentManager) {
        a(fragmentManager, "ephemeral_dialog");
    }

    public final Dialog m11441c(Bundle bundle) {
        final ThreadSummary threadSummary = (ThreadSummary) this.s.getParcelable("thread_summary_arg");
        this.au = this.s.getString("analytics_source_arg");
        this.am.f11061a.a(new HoneyClientEvent("ephemeral_dialog_open").b("source", this.au));
        Resources resources = getContext().getResources();
        Builder a = new FbAlertDialogBuilder(getContext()).a(resources.getString(2131231887));
        CharSequence[] aq = aq();
        int binarySearch = Arrays.binarySearch(this.at, threadSummary.H);
        if (binarySearch < 0) {
            binarySearch = -1;
        }
        return a.a(aq, binarySearch, new C12203(this)).a(resources.getString(2131230726), new OnClickListener(this) {
            final /* synthetic */ ModifyThreadEphemeralityDialog f11025b;

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f11025b.as != -1) {
                    ModifyThreadEphemeralityDialog modifyThreadEphemeralityDialog = this.f11025b;
                    ThreadSummary threadSummary = threadSummary;
                    int i2 = this.f11025b.at[this.f11025b.as];
                    if (threadSummary.H != i2) {
                        modifyThreadEphemeralityDialog.ap.m11444a(threadSummary.a, i2, threadSummary.H);
                    }
                }
                this.f11025b.am.f11061a.a(new HoneyClientEvent("ephemeral_confirm_change").b("source", this.f11025b.au));
                dialogInterface.dismiss();
            }
        }).b(resources.getString(2131230727), new C12181(this)).a();
    }
}
