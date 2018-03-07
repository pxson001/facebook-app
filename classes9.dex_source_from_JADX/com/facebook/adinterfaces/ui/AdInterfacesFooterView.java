package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.text.Spanned;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.facebook.adinterfaces.AdInterfacesObjectiveActivity;
import com.facebook.common.util.ContextUtils;
import com.facebook.resources.ui.FbButton;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: V2_RECENT_THREADS_PLACEHOLDER */
public class AdInterfacesFooterView extends CustomLinearLayout {
    private FbButton f22719a;
    private FbButton f22720b;
    private FbButton f22721c;
    private FbButton f22722d;
    private FbButton f22723e;
    private BetterTextView f22724f;
    private Runnable f22725g;

    /* compiled from: V2_RECENT_THREADS_PLACEHOLDER */
    class C26241 implements Runnable {
        final /* synthetic */ AdInterfacesFooterView f22718a;

        C26241(AdInterfacesFooterView adInterfacesFooterView) {
            this.f22718a = adInterfacesFooterView;
        }

        public void run() {
            AdInterfacesObjectiveActivity adInterfacesObjectiveActivity = (AdInterfacesObjectiveActivity) ContextUtils.a(this.f22718a.getContext(), AdInterfacesObjectiveActivity.class);
            if (adInterfacesObjectiveActivity != null) {
                adInterfacesObjectiveActivity.m22508b(this.f22718a.getMeasuredHeight());
            }
        }
    }

    public AdInterfacesFooterView(Context context) {
        super(context);
        m24645a();
    }

    public AdInterfacesFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24645a();
    }

    public AdInterfacesFooterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24645a();
    }

    private void m24645a() {
        setContentView(2130903117);
        this.f22719a = (FbButton) a(2131559281);
        this.f22720b = (FbButton) a(2131559282);
        this.f22721c = (FbButton) a(2131559283);
        this.f22722d = (FbButton) a(2131559284);
        this.f22723e = (FbButton) a(2131559285);
        this.f22724f = (BetterTextView) a(2131559286);
        this.f22725g = new C26241(this);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        post(this.f22725g);
    }

    public void setCreateAdButtonEnabled(boolean z) {
        this.f22719a.setEnabled(z);
    }

    public void setCreateAdButtonVisibility(int i) {
        this.f22719a.setVisibility(i);
    }

    public void setCreateAdButtonText(String str) {
        this.f22719a.setText(str);
    }

    public void setCreateAdButtonListener(OnClickListener onClickListener) {
        this.f22719a.setOnClickListener(onClickListener);
    }

    public void setAddBudgetButtonEnabled(boolean z) {
        this.f22720b.setEnabled(z);
    }

    public void setAddBudgetButtonVisibility(int i) {
        this.f22720b.setVisibility(i);
    }

    public void setAddBudgetButtonText(String str) {
        this.f22720b.setText(str);
    }

    public void setAddBudgetButtonListener(OnClickListener onClickListener) {
        this.f22720b.setOnClickListener(onClickListener);
    }

    public void setResumeAdButtonVisibility(int i) {
        this.f22721c.setVisibility(i);
    }

    public void setResumeAdButtonListener(OnClickListener onClickListener) {
        this.f22721c.setOnClickListener(onClickListener);
    }

    public void setResumeAdButtonText(int i) {
        this.f22721c.setText(i);
    }

    public void setPauseAdButtonVisibility(int i) {
        this.f22722d.setVisibility(i);
    }

    public void setPauseAdButtonListener(OnClickListener onClickListener) {
        this.f22722d.setOnClickListener(onClickListener);
    }

    public void setPauseAdButtonText(int i) {
        this.f22722d.setText(i);
    }

    public void setDeleteAdButtonVisibility(int i) {
        this.f22723e.setVisibility(i);
    }

    public void setDeleteAdButtonListener(OnClickListener onClickListener) {
        this.f22723e.setOnClickListener(onClickListener);
    }

    public void setDeleteAdButtonText(int i) {
        this.f22723e.setText(i);
    }

    public void setLegalDisclaimerContent(Spanned spanned) {
        this.f22724f.setText(spanned);
    }

    public void setLegalDisclaimerVisibility(int i) {
        this.f22724f.setVisibility(i);
    }

    public void setLegalDisclaimerMovementMethod(MovementMethod movementMethod) {
        this.f22724f.setMovementMethod(movementMethod);
    }
}
