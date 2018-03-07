package com.facebook.timeline.viewfeaturedcontainers.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: extra_events_discovery_filter_location_range */
public class FeaturedHeaderButtonBarView extends CustomLinearLayout {
    public Paint f12880a = new Paint();
    public int f12881b;
    public int f12882c;
    public boolean f12883d;
    public BetterTextView f12884e;
    public GlyphView f12885f;
    public BetterTextView f12886g;

    public FeaturedHeaderButtonBarView(Context context) {
        super(context);
        setContentView(2130904284);
        setOrientation(0);
        setBackgroundResource(2131361920);
        this.f12880a.setStyle(Style.FILL_AND_STROKE);
        this.f12880a.setAntiAlias(true);
        this.f12880a.setColor(getContext().getResources().getColor(2131361917));
        this.f12881b = context.getResources().getDimensionPixelSize(2131429973);
        this.f12882c = context.getResources().getDimensionPixelSize(2131429974);
        setWillNotDraw(false);
        this.f12884e = (BetterTextView) a(2131561869);
        this.f12885f = (GlyphView) a(2131561868);
        this.f12886g = (BetterTextView) a(2131561870);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f12883d) {
            int left = ((this.f12884e.getLeft() * 2) + this.f12884e.getMeasuredWidth()) / 2;
            Path path = new Path();
            path.reset();
            path.moveTo((float) left, 0.0f);
            path.lineTo((float) (this.f12881b + left), 0.0f);
            path.lineTo((float) left, (float) this.f12882c);
            path.lineTo((float) (left - this.f12881b), 0.0f);
            path.lineTo((float) left, 0.0f);
            canvas.drawPath(path, this.f12880a);
        }
    }
}
