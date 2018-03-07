package com.facebook.nodes;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import java.util.ArrayList;

/* compiled from: ticket_provider_name */
public final class FrameLayoutNode extends NodeGroup {
    private static final ArrayList<Node> f3094a = new ArrayList(1);

    protected final LayoutParams mo182a() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public FrameLayoutNode(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    protected final void mo184a(int i, int i2) {
        int max;
        int i3 = 0;
        int y = m4126y();
        int i4 = (MeasureSpec.getMode(i) == 1073741824 && MeasureSpec.getMode(i2) == 1073741824) ? 0 : 1;
        f3094a.clear();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < y) {
            int i8;
            int i9;
            Node g = m4125g(i5);
            if (g == null || g.m4108t() == 8) {
                i8 = i6;
                i9 = i7;
            } else {
                m4115a(g, i, 0, i2, 0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) g.m4106r();
                int max2 = Math.max(i6, (g.m4098j() + layoutParams.leftMargin) + layoutParams.rightMargin);
                max = Math.max(i7, (g.m4099k() + layoutParams.topMargin) + layoutParams.bottomMargin);
                if (i4 != 0 && (layoutParams.width == -1 || layoutParams.height == -1)) {
                    f3094a.add(g);
                }
                i8 = max2;
                i9 = max;
            }
            i5++;
            i6 = i8;
            i7 = i9;
        }
        m4091c(View.resolveSize((m4102n() + m4103o()) + i6, i), View.resolveSize((m4104p() + m4105q()) + i7, i2));
        max = f3094a.size();
        while (i3 < max) {
            Node node = (Node) f3094a.get(i3);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) node.m4106r();
            if (marginLayoutParams.width == -1) {
                max2 = MeasureSpec.makeMeasureSpec((m4098j() - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, 1073741824);
            } else {
                max2 = ViewGroup.getChildMeasureSpec(i, marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width);
            }
            if (marginLayoutParams.height == -1) {
                i9 = MeasureSpec.makeMeasureSpec((m4099k() - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin, 1073741824);
            } else {
                i9 = ViewGroup.getChildMeasureSpec(i2, marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
            }
            node.m4089b(max2, i9);
            i3++;
        }
    }

    protected final void mo185a(int i, int i2, int i3, int i4) {
        int y = m4126y();
        int n = m4102n();
        int o = (i3 - i) - m4103o();
        int p = m4104p();
        int q = (i4 - i2) - m4105q();
        for (int i5 = 0; i5 < y; i5++) {
            Node g = m4125g(i5);
            if (!(g == null || g.m4108t() == 8)) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) g.m4106r();
                int j = g.m4098j();
                int k = g.m4099k();
                int i6 = layoutParams.gravity;
                if (i6 == -1) {
                    i6 = 51;
                }
                int i7 = i6 & 112;
                switch (i6 & 7) {
                    case 1:
                        i6 = (((((o - n) - j) / 2) + n) + layoutParams.leftMargin) - layoutParams.rightMargin;
                        break;
                    case 5:
                        i6 = (o - j) - layoutParams.rightMargin;
                        break;
                    default:
                        i6 = layoutParams.leftMargin + n;
                        break;
                }
                switch (i7) {
                    case 16:
                        i7 = (((((q - p) - k) / 2) + p) + layoutParams.topMargin) - layoutParams.bottomMargin;
                        break;
                    case 48:
                        i7 = p + layoutParams.topMargin;
                        break;
                    case 80:
                        i7 = (q - k) - layoutParams.bottomMargin;
                        break;
                    default:
                        i7 = p + layoutParams.topMargin;
                        break;
                }
                m4121b(g, i6, i7, j, k);
            }
        }
    }

    public final LayoutParams mo183a(Context context, AttributeSet attributeSet) {
        return new FrameLayout.LayoutParams(context, attributeSet);
    }
}
