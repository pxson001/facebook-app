package com.facebook.platform.composer.titlebar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.facebook.common.util.SizeUtil;

/* compiled from: resultList */
public class PlatformComposerTitleBarBackground extends LinearLayout {
    private final Paint f4436a = new Paint();
    private final Path f4437b = new Path();
    private int f4438c;

    public PlatformComposerTitleBarBackground(Context context) {
        super(context);
        m4298a(context);
    }

    public PlatformComposerTitleBarBackground(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4298a(context);
    }

    private void m4298a(Context context) {
        this.f4436a.setColor(getResources().getColor(2131363634));
        this.f4438c = SizeUtil.a(context, 10.0f);
        if (ViewCompat.h(this) == 0) {
            this.f4437b.moveTo((float) this.f4438c, 0.0f);
        }
        this.f4437b.lineTo((float) this.f4438c, (float) this.f4438c);
        this.f4437b.lineTo(0.0f, (float) this.f4438c);
        this.f4437b.close();
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.translate((float) (getWidth() - this.f4438c), (float) ((getHeight() - this.f4438c) - 2));
        canvas.drawPath(this.f4437b, this.f4436a);
    }
}
