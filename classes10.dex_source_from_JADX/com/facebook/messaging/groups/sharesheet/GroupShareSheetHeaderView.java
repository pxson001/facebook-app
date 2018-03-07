package com.facebook.messaging.groups.sharesheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.messaging.groups.sharesheet.GroupCustomShareActionsView.Callback;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.ViewHelper;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: shipping_and_returns_policy */
public class GroupShareSheetHeaderView extends CustomLinearLayout {
    private GroupCustomShareActionsView f2527a;
    private ToggleApprovalsShareSheetView f2528b;
    private ViewGroup f2529c;
    private TextView f2530d;
    private ViewGroup f2531e;
    private TextView f2532f;

    public GroupShareSheetHeaderView(Context context) {
        super(context);
        m2542b();
    }

    public GroupShareSheetHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m2542b();
    }

    public GroupShareSheetHeaderView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2542b();
    }

    private void m2542b() {
        setOrientation(1);
        setContentView(2130904695);
        this.f2527a = (GroupCustomShareActionsView) a(2131562729);
        this.f2528b = (ToggleApprovalsShareSheetView) a(2131562730);
        this.f2529c = (ViewGroup) a(2131562731);
        this.f2530d = (TextView) a(2131562732);
        this.f2531e = (ViewGroup) a(2131562733);
        this.f2532f = (TextView) a(2131562734);
    }

    public final void m2547a(ThreadSummary threadSummary) {
        this.f2528b.m2556a(threadSummary);
    }

    public void setActionCallback(Callback callback) {
        this.f2527a.f2500e = callback;
    }

    public void setToggleApprovalCallback(ToggleApprovalsShareSheetView.Callback callback) {
        this.f2528b.f2540g = callback;
    }

    public final void m2548a(boolean z, boolean z2) {
        this.f2527a.setVisibility(8);
        setPreviewTogglePosition(z2);
        this.f2528b.m2557a(z);
        this.f2528b.setVisibility(0);
    }

    public void setPreviewTogglePosition(boolean z) {
        this.f2528b.setTogglePosition(z);
    }

    public final void m2549c(int i) {
        m2541a(getResources().getString(i));
    }

    private void m2541a(String str) {
        ViewHelper.a(this.f2529c, getResources().getColor(2131363843));
        m2544c(str);
    }

    public final void m2550d(int i) {
        m2543b(getResources().getString(i));
    }

    private void m2543b(String str) {
        ViewHelper.a(this.f2529c, getResources().getColor(2131363844));
        m2544c(str);
    }

    private void m2544c(String str) {
        m2546a();
        if (!Strings.isNullOrEmpty(str)) {
            this.f2530d.setText(str);
            this.f2529c.setVisibility(0);
        }
    }

    public final void m2551e(int i) {
        m2545d(getResources().getString(i));
    }

    private void m2545d(String str) {
        m2546a();
        if (!Strings.isNullOrEmpty(str)) {
            this.f2532f.setText(str);
            this.f2531e.setVisibility(0);
        }
    }

    public final void m2546a() {
        this.f2529c.setVisibility(8);
        this.f2531e.setVisibility(8);
    }
}
