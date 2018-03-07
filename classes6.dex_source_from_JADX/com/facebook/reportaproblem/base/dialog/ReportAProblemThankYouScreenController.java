package com.facebook.reportaproblem.base.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: setReactionUnitId */
public class ReportAProblemThankYouScreenController extends ReportAProblemBaseScreenController {
    private int f4592b;

    /* compiled from: setReactionUnitId */
    class C02781 implements OnClickListener {
        final /* synthetic */ ReportAProblemThankYouScreenController f4591a;

        C02781(ReportAProblemThankYouScreenController reportAProblemThankYouScreenController) {
            this.f4591a = reportAProblemThankYouScreenController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -196342154);
            this.f4591a.f4566a.a();
            Logger.a(2, EntryType.UI_INPUT_END, -882568969, a);
        }
    }

    public ReportAProblemThankYouScreenController(Integer num) {
        this.f4592b = num != null ? num.intValue() : 2130906823;
    }

    public final View mo305a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(this.f4592b, viewGroup, false);
        ((Button) inflate.findViewById(2131566945)).setOnClickListener(new C02781(this));
        return inflate;
    }
}
