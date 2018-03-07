package com.facebook.messaging.montage.viewer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: is_conference */
public class MontageViewerContainerView extends CustomFrameLayout {
    private final Paint f12618a;

    public MontageViewerContainerView(Context context) {
        this(context, null);
    }

    public MontageViewerContainerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MontageViewerContainerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12618a = new Paint(5);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2021726783);
        super.onSizeChanged(i, i2, i3, i4);
        this.f12618a.setShader(new LinearGradient((float) (i / 2), 0.0f, (float) (i / 2), (float) i2, new int[]{-2013265920, 570425344, 0, 570425344, -2013265920}, new float[]{0.1f, 0.3f, 0.5f, 0.7f, 0.9f}, TileMode.CLAMP));
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 874693629, a);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawPaint(this.f12618a);
    }
}
