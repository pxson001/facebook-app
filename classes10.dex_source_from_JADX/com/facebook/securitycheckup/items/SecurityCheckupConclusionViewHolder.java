package com.facebook.securitycheckup.items;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.graphql.calls.SecurityCheckupLoggingInputData.Event;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.securitycheckup.SecurityCheckupIconGenerator;
import com.facebook.securitycheckup.SecurityCheckupLogger;
import com.facebook.securitycheckup.utils.HelpPageUtil;
import com.facebook.securitycheckup.utils.ViewUtil;
import javax.inject.Inject;

/* compiled from: ignored previously-seen alert  */
public class SecurityCheckupConclusionViewHolder extends SecurityCheckupViewHolder {
    private final LinearLayout f9803o;
    public final FbTextView f9804p;
    public final FbTextView f9805q;
    public final FbButton f9806r;
    public final FbButton f9807s;
    public final HelpPageUtil f9808t;
    public final FrameLayout f9809u;
    private SecurityCheckupIconGenerator f9810v;
    public SecurityCheckupLogger f9811w;

    /* compiled from: ignored previously-seen alert  */
    class C14541 implements OnClickListener {
        final /* synthetic */ SecurityCheckupConclusionViewHolder f9797a;

        C14541(SecurityCheckupConclusionViewHolder securityCheckupConclusionViewHolder) {
            this.f9797a = securityCheckupConclusionViewHolder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -807391642);
            this.f9797a.f9811w.m9903a(Event.FINISHED_CLICK_SETTINGS);
            this.f9797a.f9808t.m10067a("/settings?tab=security");
            Logger.a(2, EntryType.UI_INPUT_END, 2034333307, a);
        }
    }

    /* compiled from: ignored previously-seen alert  */
    class C14552 implements OnClickListener {
        final /* synthetic */ SecurityCheckupConclusionViewHolder f9798a;

        C14552(SecurityCheckupConclusionViewHolder securityCheckupConclusionViewHolder) {
            this.f9798a = securityCheckupConclusionViewHolder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2135303020);
            this.f9798a.f9811w.m9903a(Event.FINISHED_CLICK_LEARN_MORE);
            this.f9798a.f9808t.m10067a("/about/basics/how-to-keep-your-account-secure");
            Logger.a(2, EntryType.UI_INPUT_END, -2078663083, a);
        }
    }

    /* compiled from: ignored previously-seen alert  */
    class C14563 implements Runnable {
        final /* synthetic */ SecurityCheckupConclusionViewHolder f9799a;

        C14563(SecurityCheckupConclusionViewHolder securityCheckupConclusionViewHolder) {
            this.f9799a = securityCheckupConclusionViewHolder;
        }

        public void run() {
            SecurityCheckupViewHolder securityCheckupViewHolder = this.f9799a;
            DisplayMetrics displayMetrics = securityCheckupViewHolder.f9801m.getResources().getDisplayMetrics();
            int height = (int) (((float) (displayMetrics.heightPixels - (((((securityCheckupViewHolder.f9809u.getHeight() + securityCheckupViewHolder.f9804p.getHeight()) + ViewUtil.m10068a(displayMetrics, 8)) + securityCheckupViewHolder.f9805q.getHeight()) + securityCheckupViewHolder.f9806r.getHeight()) + securityCheckupViewHolder.f9807s.getHeight()))) / 7.0f);
            LayoutParams layoutParams = (LayoutParams) securityCheckupViewHolder.f9809u.getLayoutParams();
            layoutParams.bottomMargin = height;
            layoutParams.topMargin = height * 2;
            securityCheckupViewHolder.f9809u.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) securityCheckupViewHolder.f9806r.getLayoutParams();
            layoutParams.bottomMargin = height;
            layoutParams.topMargin = height;
            securityCheckupViewHolder.f9806r.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) securityCheckupViewHolder.f9807s.getLayoutParams();
            layoutParams.bottomMargin = height;
            securityCheckupViewHolder.f9807s.setLayoutParams(layoutParams);
        }
    }

    @Inject
    public SecurityCheckupConclusionViewHolder(@Assisted View view, @Assisted Context context, HelpPageUtil helpPageUtil, SecurityCheckupLogger securityCheckupLogger) {
        super(view, context);
        this.f9803o = (LinearLayout) view.findViewById(2131567308);
        this.f9804p = (FbTextView) view.findViewById(2131567310);
        this.f9805q = (FbTextView) view.findViewById(2131567311);
        this.f9806r = (FbButton) view.findViewById(2131567312);
        this.f9807s = (FbButton) view.findViewById(2131567313);
        this.f9807s.setText(context.getString(2131241602));
        this.f9808t = helpPageUtil;
        this.f9809u = (FrameLayout) view.findViewById(2131567309);
        this.f9811w = securityCheckupLogger;
    }

    public final void mo452a(SecurityCheckupItem securityCheckupItem, int i) {
        super.mo452a(securityCheckupItem, i);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) this.f9803o.getLayoutParams();
        layoutParams.height = this.f9801m.getResources().getDisplayMetrics().heightPixels;
        this.f9803o.setLayoutParams(layoutParams);
        this.f9804p.setText(securityCheckupItem.f9842a);
        this.f9805q.setText(securityCheckupItem.f9843b);
        this.f9806r.setText(securityCheckupItem.f9844c);
        this.f9806r.setOnClickListener(new C14541(this));
        this.f9807s.setOnClickListener(new C14552(this));
        this.f9809u.removeAllViews();
        this.f9810v = new SecurityCheckupIconGenerator(this.f9809u, this.f9800l.f9845d, this.f9800l.f9847f);
        this.a.post(new C14563(this));
        m10021x();
    }

    public final void m10020w() {
        m10018c(1);
        if (!this.f9800l.f9847f) {
            this.f9810v.m9899a();
            this.f9800l.f9847f = true;
        }
    }

    public final void m10021x() {
        m10018c(0);
    }

    private void m10018c(int i) {
        this.f9809u.animate().alpha((float) i).setDuration(400);
        this.f9804p.animate().alpha((float) i).setDuration(400);
        this.f9805q.animate().alpha((float) i).setDuration(400);
        this.f9806r.animate().alpha((float) i).setDuration(400);
        this.f9807s.animate().alpha((float) i).setDuration(400);
    }
}
