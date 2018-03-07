package com.facebook.feedplugins.base.footer.ui;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.feedplugins.base.footer.ui.Footer.DividerStyle;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: gk_assisted_reg_share_to_a_contact_share_sheet */
public class FooterDividerPainter {
    private final int f22309a;
    private final Paint f22310b = new Paint();
    private final Paint f22311c;
    public DividerStyle f22312d;
    public DividerStyle f22313e;

    public static FooterDividerPainter m30246b(InjectorLike injectorLike) {
        return new FooterDividerPainter(ResourcesMethodAutoProvider.m6510a(injectorLike));
    }

    @Inject
    public FooterDividerPainter(Resources resources) {
        this.f22309a = resources.getDimensionPixelSize(2131427642);
        this.f22310b.setColor(resources.getColor(2131362761));
        this.f22310b.setStrokeWidth(1.0f);
        this.f22311c = new Paint();
        this.f22311c.setColor(resources.getColor(2131362791));
        this.f22311c.setStrokeWidth(1.0f);
    }

    public final void m30247a(View view, Canvas canvas) {
        if (this.f22312d == DividerStyle.VISIBLE) {
            int paddingTop = view.getPaddingTop();
            canvas.drawLine((float) (this.f22309a + view.getPaddingLeft()), (float) paddingTop, (float) ((view.getWidth() - this.f22309a) - view.getPaddingRight()), (float) paddingTop, this.f22310b);
        }
        if (this.f22313e == DividerStyle.VISIBLE) {
            paddingTop = (view.getHeight() - view.getPaddingBottom()) - 1;
            canvas.drawLine((float) view.getPaddingLeft(), (float) paddingTop, (float) (view.getWidth() - view.getPaddingRight()), (float) paddingTop, this.f22310b);
        }
    }
}
