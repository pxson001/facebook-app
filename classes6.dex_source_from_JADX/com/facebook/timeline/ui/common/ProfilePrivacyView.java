package com.facebook.timeline.ui.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: select */
public class ProfilePrivacyView extends CustomLinearLayout {
    private Paint f5066a;
    public Tooltip f5067b;
    public int f5068c;

    public ProfilePrivacyView(Context context) {
        super(context);
        m7829a(context);
    }

    public ProfilePrivacyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7829a(context);
    }

    public ProfilePrivacyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7829a(context);
    }

    public void setFixedPrivacyToolTipDescriptionResource(int i) {
        this.f5068c = i;
    }

    private void m7829a(final Context context) {
        setWillNotDraw(false);
        this.f5068c = 2131234499;
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProfilePrivacyView f5065b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -941840744);
                if (this.f5065b.f5067b == null) {
                    View findViewById = this.f5065b.findViewById(2131566383);
                    if (findViewById == null) {
                        findViewById = this.f5065b;
                    }
                    this.f5065b.f5067b = new Tooltip(context);
                    this.f5065b.f5067b.t = -1;
                    this.f5065b.f5067b.c(findViewById);
                }
                this.f5065b.f5067b.b(this.f5065b.f5068c);
                this.f5065b.f5067b.d();
                LogUtils.a(-1337587482, a);
            }
        });
        this.f5066a = new Paint(1);
        this.f5066a.setColor(getResources().getColor(2131361939));
        this.f5066a.setStrokeWidth(0.0f);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0.0f, (float) getHeight(), (float) getWidth(), (float) getHeight(), this.f5066a);
    }
}
