package com.facebook.reportaproblem.base.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reportaproblem.base.ReportAProblemForkOption;
import com.facebook.reportaproblem.base.ReportAProblemForkOption.ForkOptionType;
import com.facebook.reportaproblem.base.ui.ReportAProblemForkListView;
import java.util.List;

/* compiled from: setRobotext */
public class ReportAProblemForkScreenController extends ReportAProblemBaseScreenController {
    public final List<ReportAProblemForkOption> f4590b;

    /* compiled from: setRobotext */
    class C02761 implements OnItemClickListener {
        final /* synthetic */ ReportAProblemForkScreenController f4588a;

        C02761(ReportAProblemForkScreenController reportAProblemForkScreenController) {
            this.f4588a = reportAProblemForkScreenController;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ForkOptionType forkOptionType;
            ReportAProblemForkOption reportAProblemForkOption = (ReportAProblemForkOption) this.f4588a.f4590b.get(i);
            if (reportAProblemForkOption.f4538b == null) {
                forkOptionType = ForkOptionType.FORK_OPTION_ACTIVITY;
            } else {
                forkOptionType = ForkOptionType.FORK_OPTION_SCREEN;
            }
            if (forkOptionType == ForkOptionType.FORK_OPTION_SCREEN) {
                this.f4588a.f4566a.m7090a(reportAProblemForkOption.f4538b);
                return;
            }
            ReportAProblemDialogFragment reportAProblemDialogFragment = this.f4588a.f4566a;
            reportAProblemDialogFragment.al.mo319a(reportAProblemForkOption.f4539c, reportAProblemDialogFragment.o());
            reportAProblemDialogFragment.a();
        }
    }

    /* compiled from: setRobotext */
    class C02772 implements OnClickListener {
        final /* synthetic */ ReportAProblemForkScreenController f4589a;

        C02772(ReportAProblemForkScreenController reportAProblemForkScreenController) {
            this.f4589a = reportAProblemForkScreenController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1974712837);
            this.f4589a.f4566a.a();
            Logger.a(2, EntryType.UI_INPUT_END, -1915568358, a);
        }
    }

    public ReportAProblemForkScreenController(List<ReportAProblemForkOption> list) {
        this.f4590b = list;
    }

    public final View mo305a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(2130906821, viewGroup, false);
        ReportAProblemForkListView reportAProblemForkListView = (ReportAProblemForkListView) inflate.findViewById(2131566942);
        reportAProblemForkListView.setForkOptions(this.f4590b);
        reportAProblemForkListView.setOnItemClickListener(new C02761(this));
        ((Button) inflate.findViewById(2131566943)).setOnClickListener(new C02772(this));
        return inflate;
    }
}
