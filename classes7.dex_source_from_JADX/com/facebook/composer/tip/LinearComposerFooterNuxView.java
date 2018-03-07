package com.facebook.composer.tip;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.annotation.Nullable;

/* compiled from: composer_payment_tab */
public class LinearComposerFooterNuxView extends ImageBlockLayout {
    @Nullable
    private OnDismissListener f17006h;
    private TextView f17007i;

    /* compiled from: composer_payment_tab */
    class C13711 implements OnClickListener {
        final /* synthetic */ LinearComposerFooterNuxView f17005a;

        C13711(LinearComposerFooterNuxView linearComposerFooterNuxView) {
            this.f17005a = linearComposerFooterNuxView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1596561964);
            this.f17005a.m20955a();
            Logger.a(2, EntryType.UI_INPUT_END, 1478333078, a);
        }
    }

    /* compiled from: composer_payment_tab */
    public interface OnDismissListener {
    }

    public LinearComposerFooterNuxView(Context context) {
        super(context);
        m20954f();
    }

    public LinearComposerFooterNuxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20954f();
    }

    public LinearComposerFooterNuxView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20954f();
    }

    private void m20954f() {
        setContentView(2130905044);
        this.f17007i = (TextView) getView(2131563425);
        getView(2131563426).setOnClickListener(new C13711(this));
    }

    public void setText(String str) {
        this.f17007i.setText(str);
    }

    public final void m20955a() {
        setVisibility(8);
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f17006h = onDismissListener;
    }
}
