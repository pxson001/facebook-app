package com.facebook.reportaproblem.base.dialog;

import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.facebook.reportaproblem.base.ReportAProblemConstants;
import com.facebook.reportaproblem.base.bugreport.BugReportCategoryInfo;
import com.facebook.reportaproblem.base.ui.BugReportCategoryChooserListView;
import java.util.List;

/* compiled from: setTabSelectionListener */
public class BugReportCategoryChooserScreenController extends ReportAProblemBaseScreenController {
    public final List<BugReportCategoryInfo> f4567b;
    @Nullable
    private final String f4568c;

    /* compiled from: setTabSelectionListener */
    class C02701 implements OnItemClickListener {
        final /* synthetic */ BugReportCategoryChooserScreenController f4565a;

        C02701(BugReportCategoryChooserScreenController bugReportCategoryChooserScreenController) {
            this.f4565a = bugReportCategoryChooserScreenController;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f4565a.f4566a.ap().putParcelable("param_key_category_info", (Parcelable) this.f4565a.f4567b.get(i));
            this.f4565a.f4566a.m7090a(ReportAProblemConstants.f4530d);
        }
    }

    public BugReportCategoryChooserScreenController(List<BugReportCategoryInfo> list, @Nullable String str) {
        this.f4567b = list;
        this.f4568c = str;
    }

    public final View mo305a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(2130903450, viewGroup, false);
        BugReportCategoryChooserListView bugReportCategoryChooserListView = (BugReportCategoryChooserListView) inflate.findViewById(2131560049);
        bugReportCategoryChooserListView.setCategoryInfos(this.f4567b);
        bugReportCategoryChooserListView.setOnItemClickListener(new C02701(this));
        if (this.f4568c != null) {
            ((TextView) inflate.findViewById(2131560050)).setText(this.f4568c);
        }
        return inflate;
    }

    public final boolean mo306a() {
        return true;
    }
}
