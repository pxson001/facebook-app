package com.facebook.reportaproblem.base.dialog;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: setStoryId */
public abstract class ReportAProblemBaseScreenController {
    public ReportAProblemDialogFragment f4566a;

    public abstract View mo305a(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public void mo311a(ReportAProblemDialogFragment reportAProblemDialogFragment) {
        this.f4566a = reportAProblemDialogFragment;
    }

    public void mo308b() {
    }

    public void mo309c() {
        this.f4566a = null;
    }

    public void mo307a(int i, int i2, Intent intent) {
    }

    public boolean mo306a() {
        return false;
    }

    public void mo310d() {
    }
}
