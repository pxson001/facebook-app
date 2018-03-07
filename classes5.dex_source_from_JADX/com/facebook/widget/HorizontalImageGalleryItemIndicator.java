package com.facebook.widget;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.util.ArrayList;

/* compiled from: com.google.android.gms.permission.BIND_NETWORK_TASK_SERVICE */
public class HorizontalImageGalleryItemIndicator extends LinearLayout {
    private int f5649a;
    private int f5650b;
    private ShapeDrawable f5651c;
    private ShapeDrawable f5652d;
    private ArrayList<ImageView> f5653e;
    private int f5654f;
    private int f5655g;
    private Context f5656h;
    private int f5657i;
    private int f5658j;

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2071122873);
        m10447b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -698360554, a);
    }

    private void m10447b() {
        this.f5653e = new ArrayList();
        this.f5651c = new ShapeDrawable();
        this.f5652d = new ShapeDrawable();
        this.f5651c.setBounds(0, 0, this.f5649a, this.f5649a);
        this.f5652d.setBounds(0, 0, this.f5649a, this.f5649a);
        Shape ovalShape = new OvalShape();
        ovalShape.resize((float) this.f5649a, (float) this.f5649a);
        Shape ovalShape2 = new OvalShape();
        ovalShape2.resize((float) this.f5649a, (float) this.f5649a);
        this.f5651c.getPaint().setColor(this.f5657i);
        this.f5652d.getPaint().setColor(this.f5658j);
        this.f5651c.setShape(ovalShape);
        this.f5652d.setShape(ovalShape2);
        this.f5649a = (int) (((float) this.f5649a) * getResources().getDisplayMetrics().density);
    }

    public void setPageCount(int i) {
        this.f5654f = i;
        for (int i2 = 0; i2 < i; i2++) {
            View imageView = new ImageView(this.f5656h);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f5649a, this.f5649a);
            layoutParams.setMargins((this.f5649a / 2) * this.f5650b, this.f5649a, (this.f5649a / 2) * this.f5650b, this.f5649a);
            imageView.setLayoutParams(layoutParams);
            imageView.setBackgroundDrawable(this.f5652d);
            this.f5653e.add(imageView);
            addView(imageView);
        }
    }

    public void setCurrentPage(int i) {
        if (i < this.f5654f) {
            ((ImageView) this.f5653e.get(this.f5655g)).setBackgroundDrawable(this.f5652d);
            ((ImageView) this.f5653e.get(i)).setBackgroundDrawable(this.f5651c);
            this.f5655g = i;
        }
    }

    public void setIndicatorDiameter(int i) {
        this.f5649a = i;
        for (int i2 = 0; i2 < this.f5654f; i2++) {
            ((ImageView) this.f5653e.get(i2)).setLayoutParams(new LinearLayout.LayoutParams(this.f5649a, this.f5649a));
        }
    }

    public int getIndicatorDiameter() {
        return this.f5649a;
    }

    public void setSpacingCoefficient(int i) {
        this.f5650b = i;
    }

    public final void m10448a() {
        this.f5654f = 0;
        this.f5655g = 0;
        this.f5653e.clear();
        removeAllViewsInLayout();
    }
}
