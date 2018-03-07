package com.facebook.timeline.header;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import com.facebook.inject.Lazy;
import com.facebook.timeline.header.ui.NuxBorderDrawingHelper;
import com.facebook.timeline.header.ui.ViewBorderDrawingHelper.BordersSpec;

/* compiled from: friends_nearby_dashboard_map_interaction */
public class IntroCardExternalLinkWrappingView extends LinearLayout {
    private static final BordersSpec f11285a = new BordersSpec(true, true, false, false);
    private final Lazy<NuxBorderDrawingHelper> f11286b;
    public View f11287c;
    public boolean f11288d;

    public IntroCardExternalLinkWrappingView(Context context, Lazy<NuxBorderDrawingHelper> lazy) {
        super(context, null);
        this.f11286b = lazy;
        setOrientation(0);
        setGravity(17);
        setBackgroundResource(2131361920);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f11287c != null) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f11287c.getLayoutParams();
            setMeasuredDimension(i, marginLayoutParams.bottomMargin + (MeasureSpec.getSize(this.f11287c.getMeasuredHeight()) + marginLayoutParams.topMargin));
        }
    }

    public final void m11394a(View view) {
        this.f11287c = view;
        addView(view);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f11288d) {
            ((NuxBorderDrawingHelper) this.f11286b.get()).m12028a(this, canvas, f11285a);
        }
    }
}
