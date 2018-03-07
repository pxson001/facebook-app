package com.facebook.backstage.consumption.importflow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.backstage.ui.ViewAnimator;
import com.facebook.backstage.ui.ViewAnimator.OnFinishListener;
import com.facebook.resources.ui.FbTextView;

/* compiled from: ringtone_toast_qe */
public class ImportFlowTitleView extends LinearLayout {
    private final OnFinishListener f4812a;
    private final FbTextView f4813b;
    private final FbTextView f4814c;
    private final FbTextView f4815d;
    public volatile boolean f4816e;

    /* compiled from: ringtone_toast_qe */
    class C04961 implements OnFinishListener {
        final /* synthetic */ ImportFlowTitleView f4811a;

        C04961(ImportFlowTitleView importFlowTitleView) {
            this.f4811a = importFlowTitleView;
        }

        public final void mo142a() {
            this.f4811a.f4816e = false;
        }
    }

    public ImportFlowTitleView(Context context) {
        this(context, null);
    }

    public ImportFlowTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImportFlowTitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4812a = new C04961(this);
        View inflate = LayoutInflater.from(getContext()).inflate(2130904851, this);
        this.f4813b = (FbTextView) inflate.findViewById(2131563075);
        this.f4814c = (FbTextView) inflate.findViewById(2131563076);
        this.f4815d = (FbTextView) inflate.findViewById(2131563074);
        setClickable(true);
    }

    public void setOnShareClickedListener(OnClickListener onClickListener) {
        this.f4814c.setOnClickListener(onClickListener);
    }

    public final void m4699a(int i) {
        this.f4813b.setTextSize(0, getResources().getDimension(2131433234));
        if (i == 0) {
            this.f4813b.setText(2131239915);
            this.f4814c.setEnabled(false);
        } else {
            this.f4813b.setText(getResources().getQuantityString(2131689746, i, new Object[]{Integer.valueOf(i)}));
            this.f4814c.setEnabled(true);
        }
        this.f4814c.setText(2131239919);
    }

    public final void m4698a() {
        this.f4813b.setTextSize(0, getResources().getDimension(2131433241));
        this.f4813b.setText(2131239917);
        this.f4814c.setText(2131239918);
    }

    public void setOnCloseClickedListener(OnClickListener onClickListener) {
        this.f4815d.setOnClickListener(onClickListener);
    }

    public final void m4700b() {
        if (this.f4816e) {
            ViewAnimator.m5752a((View) this).m5761e();
            setY((float) (-getHeight()));
            this.f4816e = false;
            return;
        }
        this.f4816e = true;
        ViewAnimator b = ViewAnimator.m5752a((View) this).m5755b((float) (-getHeight()));
        b.f5528e = this.f4812a;
        b.m5759d();
    }

    public final void m4701c() {
        if (this.f4816e) {
            ViewAnimator.m5752a((View) this).m5761e();
            setY(0.0f);
            this.f4816e = false;
            return;
        }
        this.f4816e = true;
        ViewAnimator b = ViewAnimator.m5752a((View) this).m5755b((float) getHeight());
        b.f5528e = this.f4812a;
        b.m5759d();
    }

    public final void m4702d() {
        this.f4814c.setVisibility(4);
    }

    public final void m4703e() {
        this.f4814c.setVisibility(0);
    }
}
