package com.facebook.pages.fb4a.admin_activity.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.pages.fb4a.admin_activity.views.PageActivityInsightsSummarySwitcher.InsightsSwitcherState;

/* compiled from: quicksilver_play_time */
public class PageActivityInsightsSwitcherIndicator extends View {
    private Paint f2782a;
    private InsightsSwitcherState f2783b;

    public PageActivityInsightsSwitcherIndicator(Context context) {
        super(context);
        m3770a();
    }

    public PageActivityInsightsSwitcherIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3770a();
    }

    public PageActivityInsightsSwitcherIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3770a();
    }

    private void m3770a() {
        this.f2782a = new Paint();
        this.f2782a.setStyle(Style.STROKE);
        this.f2782a.setStrokeWidth(2.0f);
        this.f2782a.setColor(getContext().getResources().getColor(2131363050));
    }

    public void setSwitcherState(InsightsSwitcherState insightsSwitcherState) {
        if (this.f2783b != insightsSwitcherState) {
            this.f2783b = insightsSwitcherState;
            invalidate();
        }
    }

    public void onDraw(Canvas canvas) {
        int measuredHeight = getMeasuredHeight();
        int i = measuredHeight * 2;
        int measuredWidth = getMeasuredWidth();
        Path path = new Path();
        path.moveTo(0.0f, (float) measuredHeight);
        if (this.f2783b == InsightsSwitcherState.WEEKLY_LIKE) {
            path.lineTo((float) ((measuredWidth / 4) - (i / 2)), (float) measuredHeight);
            path.lineTo((float) (measuredWidth / 4), 0.0f);
            path.lineTo((float) ((i / 2) + (measuredWidth / 4)), (float) measuredHeight);
            path.lineTo((float) measuredWidth, (float) measuredHeight);
        } else if (this.f2783b == InsightsSwitcherState.WEEKLY_POST_REACH) {
            path.lineTo((float) (((measuredWidth * 3) / 4) - (i / 2)), (float) measuredHeight);
            path.lineTo((float) ((measuredWidth * 3) / 4), 0.0f);
            path.lineTo((float) ((i / 2) + ((measuredWidth * 3) / 4)), (float) measuredHeight);
            path.lineTo((float) measuredWidth, (float) measuredHeight);
        }
        canvas.drawPath(path, this.f2782a);
    }
}
