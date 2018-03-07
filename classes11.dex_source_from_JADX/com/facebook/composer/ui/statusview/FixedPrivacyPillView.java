package com.facebook.composer.ui.statusview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;

/* compiled from: fb4a_priority */
public class FixedPrivacyPillView extends FbTextView {
    public Tooltip f7210a;
    public String f7211b;
    private OnClickListener f7212c;

    /* compiled from: fb4a_priority */
    class C09191 implements OnClickListener {
        final /* synthetic */ FixedPrivacyPillView f7209a;

        C09191(FixedPrivacyPillView fixedPrivacyPillView) {
            this.f7209a = fixedPrivacyPillView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -766037053);
            if (this.f7209a.f7210a == null) {
                this.f7209a.f7210a = new Tooltip(this.f7209a.getContext());
                this.f7209a.f7210a.t = -1;
                this.f7209a.f7210a.c(this.f7209a);
            }
            this.f7209a.f7210a.b(this.f7209a.f7211b);
            this.f7209a.f7210a.d();
            Logger.a(2, EntryType.UI_INPUT_END, -1809895694, a);
        }
    }

    public FixedPrivacyPillView(Context context) {
        super(context);
        m8432a();
    }

    public FixedPrivacyPillView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8432a();
    }

    public FixedPrivacyPillView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8432a();
    }

    private void m8432a() {
        this.f7212c = new C09191(this);
        setOnClickListener(this.f7212c);
    }

    public void setToolTipText(String str) {
        this.f7211b = str;
    }
}
