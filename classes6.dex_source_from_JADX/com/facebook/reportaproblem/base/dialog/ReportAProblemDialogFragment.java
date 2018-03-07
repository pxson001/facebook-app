package com.facebook.reportaproblem.base.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reportaproblem.base.ReportAProblem;
import com.facebook.reportaproblem.base.ReportAProblemConfig;
import com.facebook.reportaproblem.base.ReportAProblemKeyboardHelper;
import com.facebook.reportaproblem.base.bugreport.file.BugReportDeleteDirectoryTask;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFile;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* compiled from: setRobotextTags */
public class ReportAProblemDialogFragment extends DialogFragment {
    public ReportAProblemConfig al;
    private RelativeLayout am;
    private View an;
    public boolean ao = true;
    private final Map<String, ReportAProblemScreenController> ap = new HashMap();
    public final Stack<String> aq = new Stack();
    private boolean ar = false;
    public OnDismissListener as;

    public final void m7088a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1004819122);
        super.a(bundle);
        this.al = ReportAProblem.a();
        d(true);
        Bundle ap = ap();
        String str = "param_key_report_directory";
        File file = new File(new File(getContext().getCacheDir(), "bugreports"), String.valueOf(System.nanoTime()));
        if (!(file.exists() || file.mkdirs())) {
            file = null;
        }
        ap.putString(str, file.toString());
        ap().putString("param_key_current_activity", this.al.mo318a(o()));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1671881439, a);
    }

    public final Dialog m7091c(Bundle bundle) {
        Dialog c02751 = new Dialog(this, getContext(), 2131625597) {
            final /* synthetic */ ReportAProblemDialogFragment f4587a;

            public void onBackPressed() {
                if (this.f4587a.aq.isEmpty()) {
                    super.onBackPressed();
                } else {
                    this.f4587a.m7090a((String) this.f4587a.aq.pop());
                }
            }
        };
        c02751.requestWindowFeature(1);
        c02751.setCanceledOnTouchOutside(true);
        return c02751;
    }

    public final void m7087a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        at().mo307a(i, i2, intent);
    }

    public final View m7086a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1960416863);
        this.am = new RelativeLayout(getContext());
        this.an = m7083c(au()).mo305a(o().getLayoutInflater(), this.am);
        if (this.an != null) {
            this.am.addView(this.an);
        }
        View view = this.am;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1864596641, a);
        return view;
    }

    public final void m7084G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1532718638);
        super.G();
        m7083c(au()).mo310d();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -738153994, a);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.as != null) {
            this.as.onDismiss(dialogInterface);
        }
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1565332109);
        this.ar = false;
        at().mo308b();
        Dialog dialog = this.f;
        if (dialog != null && this.M) {
            dialog.setDismissMessage(null);
        }
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2064753365, a);
    }

    public final void m7085I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1668815747);
        for (ReportAProblemBaseScreenController c : this.ap.values()) {
            c.mo309c();
        }
        if (this.ao) {
            new BugReportDeleteDirectoryTask().execute(new File[]{aq()});
        }
        FragmentActivity o = o();
        if (!(o == null || o.getWindow() == null)) {
            ReportAProblemKeyboardHelper.m7036a(o, o.getWindow().getDecorView());
        }
        super.I();
        LogUtils.f(-1979412875, a);
    }

    public final void m7090a(String str) {
        if (m7082b(str)) {
            ReportAProblemBaseScreenController at = at();
            if (at.mo306a()) {
                this.aq.push(au());
            } else {
                this.aq.clear();
            }
            View a = m7083c(str).mo305a(o().getLayoutInflater(), this.am);
            this.am.removeView(this.an);
            this.am.addView(a);
            this.an = a;
            at.mo308b();
            this.s.putString("com.facebook.reportaproblem.base.dialog.CurrentScreen", str);
            m7083c(au()).mo310d();
        }
    }

    public final void m7089a(View view, Bundle bundle) {
        this.f.getWindow().setBackgroundDrawableResource(17170445);
        this.f.getWindow().setSoftInputMode(16);
        this.ar = true;
        super.a(view, bundle);
    }

    private boolean m7082b(String str) {
        boolean z;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            z = true;
        } else {
            z = false;
        }
        boolean z2;
        if (str.equals(au())) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (this.ar && r0 && r3) {
            return true;
        }
        return false;
    }

    private ReportAProblemBaseScreenController m7083c(String str) {
        ReportAProblemBaseScreenController reportAProblemBaseScreenController = (ReportAProblemBaseScreenController) this.ap.get(str);
        if (reportAProblemBaseScreenController != null) {
            return reportAProblemBaseScreenController;
        }
        reportAProblemBaseScreenController = this.al.m7016a(str);
        reportAProblemBaseScreenController.mo311a(this);
        this.ap.put(str, reportAProblemBaseScreenController);
        return reportAProblemBaseScreenController;
    }

    private ReportAProblemBaseScreenController at() {
        return m7083c(au());
    }

    public final File aq() {
        return new File(ap().getString("param_key_report_directory"));
    }

    public final List<BugReportFile> ar() {
        return ap().getParcelableArrayList("param_key_bug_report_screenshot_files");
    }

    private String au() {
        return this.s.getString("com.facebook.reportaproblem.base.dialog.CurrentScreen");
    }

    public final Bundle ap() {
        return this.s.getBundle("com.facebook.reportaproblem.base.dialog.ParamBundle");
    }
}
