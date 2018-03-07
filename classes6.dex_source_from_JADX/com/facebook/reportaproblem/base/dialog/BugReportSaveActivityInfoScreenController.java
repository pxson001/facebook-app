package com.facebook.reportaproblem.base.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.reportaproblem.base.bugreport.BugReportSaveActivityInfoTask;
import com.facebook.reportaproblem.base.bugreport.file.BugReportActivityFileProvider;
import com.facebook.reportaproblem.base.bugreport.file.BugReportUiDataProvider;
import java.util.List;

/* compiled from: setShouldPostToMarketplaceByDefault */
public class BugReportSaveActivityInfoScreenController extends ReportAProblemBaseScreenController {
    private BugReportSaveActivityInfoTask f4584b;
    private final List<BugReportActivityFileProvider> f4585c;
    private final List<BugReportUiDataProvider> f4586d;

    public BugReportSaveActivityInfoScreenController(List<BugReportActivityFileProvider> list, List<BugReportUiDataProvider> list2) {
        this.f4585c = list;
        this.f4586d = list2;
    }

    public final void mo311a(ReportAProblemDialogFragment reportAProblemDialogFragment) {
        super.mo311a(reportAProblemDialogFragment);
        this.f4584b = new BugReportSaveActivityInfoTask(this, this.f4566a.aq(), this.f4585c, this.f4586d, this.f4566a.o());
        this.f4584b.execute(new Void[0]);
    }

    public final View mo305a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(2130903455, viewGroup, false);
    }

    public final void mo309c() {
        if (this.f4584b != null) {
            this.f4584b.cancel(true);
        }
        super.mo309c();
    }
}
