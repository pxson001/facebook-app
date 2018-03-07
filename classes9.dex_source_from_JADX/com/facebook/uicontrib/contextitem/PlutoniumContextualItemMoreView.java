package com.facebook.uicontrib.contextitem;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import com.facebook.device.ScreenUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.nodes.ImageBlockLayoutNode;
import com.facebook.inject.FbInjector;
import com.facebook.nodes.ImageNode;
import com.facebook.nodes.NodeView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: timestamp_in_folder_ms DESC LIMIT 25 */
public class PlutoniumContextualItemMoreView extends NodeView {
    @Inject
    public ScreenUtil f1636a;
    @Inject
    public GlyphColorizer f1637b;
    public Paint f1638c;
    public ImageBlockLayoutNode f1639d = ((ImageBlockLayoutNode) a(2131560785));
    public ImageBlockLayoutNode f1640e;
    public ImageBlockLayoutNode f1641f;
    public boolean f1642g;
    public int f1643h;

    public static void m1666a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PlutoniumContextualItemMoreView plutoniumContextualItemMoreView = (PlutoniumContextualItemMoreView) obj;
        ScreenUtil a = ScreenUtil.a(fbInjector);
        GlyphColorizer a2 = GlyphColorizer.a(fbInjector);
        plutoniumContextualItemMoreView.f1636a = a;
        plutoniumContextualItemMoreView.f1637b = a2;
    }

    public PlutoniumContextualItemMoreView(Context context) {
        super(context);
        Class cls = PlutoniumContextualItemMoreView.class;
        m1666a(this, getContext());
        setContentNode(2130903801);
        ImageNode imageNode = (ImageNode) a(2131560786);
        this.f1640e = (ImageBlockLayoutNode) a(2131560788);
        ImageNode imageNode2 = (ImageNode) a(2131560789);
        this.f1641f = (ImageBlockLayoutNode) a(2131560791);
        this.f1638c = new Paint(1);
        this.f1638c.setColor(getResources().getColor(2131362991));
        this.f1638c.setStrokeWidth(0.0f);
        imageNode.a(this.f1637b.a(2130839972, getResources().getColor(2131361936)));
        imageNode2.a(this.f1637b.a(2130839844, getResources().getColor(2131361936)));
        ImmutableList of = ImmutableList.of(this.f1639d, this.f1640e, this.f1641f);
        int size = of.size();
        for (int i = 0; i < size; i++) {
            ImageBlockLayoutNode imageBlockLayoutNode = (ImageBlockLayoutNode) of.get(i);
            imageBlockLayoutNode.a(17);
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(2130772600, typedValue, true);
            int dimensionPixelSize = getResources().getDimensionPixelSize(typedValue.resourceId == 0 ? 2131427497 : typedValue.resourceId);
            context.getTheme().resolveAttribute(2130772599, typedValue, true);
            this.f1643h = getResources().getDimensionPixelSize(typedValue.resourceId == 0 ? 2131427496 : typedValue.resourceId);
            imageBlockLayoutNode.c(this.f1643h, dimensionPixelSize, getResources().getDimensionPixelSize(2131430084) + this.f1643h, dimensionPixelSize);
            imageBlockLayoutNode.h(this.f1643h);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(this.f1636a.c(), 1073741824), i2);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f1642g) {
            canvas.drawLine((float) this.f1643h, (float) this.f1639d.k, (float) (this.f1639d.l() - this.f1643h), (float) this.f1639d.k, this.f1638c);
        }
        canvas.drawLine((float) this.f1643h, (float) this.f1640e.k, (float) (this.f1640e.l() - this.f1643h), (float) this.f1640e.k, this.f1638c);
    }
}
