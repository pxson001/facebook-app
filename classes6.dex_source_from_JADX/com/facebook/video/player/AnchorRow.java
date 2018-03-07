package com.facebook.video.player;

import android.graphics.Point;
import android.view.View;
import com.facebook.video.player.AnchorLayout.Anchor;
import com.facebook.video.player.AnchorLayout.AnchorPosition;
import com.facebook.video.player.AnchorLayout.LayoutParams;
import java.util.Iterator;
import java.util.LinkedList;
import javax.annotation.Nullable;

/* compiled from: composer_publish_params_json_failed */
public class AnchorRow {
    private final Anchor f18958a;
    private final int f18959b;
    private final Point f18960c;
    private LinkedList<View>[] f18961d;
    private int[] f18962e;
    private int[] f18963f;
    private int[] f18964g;
    public int f18965h = 0;
    public int f18966i;
    public int f18967j;
    public int f18968k;
    public int f18969l;

    /* compiled from: composer_publish_params_json_failed */
    /* synthetic */ class C14091 {
        static final /* synthetic */ int[] f18956a = new int[Anchor.values().length];
        static final /* synthetic */ int[] f18957b = new int[AnchorPosition.values().length];

        static {
            try {
                f18957b[AnchorPosition.START.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18957b[AnchorPosition.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18957b[AnchorPosition.END.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f18956a[Anchor.BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f18956a[Anchor.INNER_BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f18956a[Anchor.START.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f18956a[Anchor.INNER_START.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f18956a[Anchor.END.ordinal()] = 5;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f18956a[Anchor.INNER_END.ordinal()] = 6;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    public AnchorRow(Anchor anchor, int i, Point point) {
        this.f18958a = anchor;
        this.f18959b = i;
        this.f18960c = point;
        if (anchor.isHorizontal()) {
            this.f18966i = point.y;
            this.f18967j = point.x + ((int) Math.ceil((((double) this.f18959b) * 1.0d) / 2.0d));
            this.f18968k = point.y;
            this.f18969l = point.x - (this.f18959b / 2);
        } else {
            this.f18966i = point.y - (this.f18959b / 2);
            this.f18967j = point.x;
            this.f18968k = point.y + ((int) Math.ceil((((double) this.f18959b) * 1.0d) / 2.0d));
            this.f18969l = point.x;
        }
        int length = AnchorPosition.values().length;
        this.f18961d = new LinkedList[length];
        this.f18962e = new int[length];
        this.f18963f = new int[length];
        this.f18964g = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            this.f18961d[i2] = new LinkedList();
            this.f18962e[i2] = 0;
            this.f18963f[i2] = this.f18959b;
            this.f18964g[i2] = Integer.MAX_VALUE;
        }
    }

    @Nullable
    public final AnchorRow m27632a(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredWidth = layoutParams.rightMargin + (layoutParams.leftMargin + view.getMeasuredWidth());
        int measuredHeight = layoutParams.bottomMargin + (layoutParams.topMargin + view.getMeasuredHeight());
        int i = this.f18958a.isHorizontal() ? measuredWidth : measuredHeight;
        if (!this.f18958a.isHorizontal()) {
            measuredHeight = measuredWidth;
        }
        if (i > this.f18963f[layoutParams.c.ordinal()] || layoutParams.b > this.f18964g[layoutParams.c.ordinal()]) {
            Point point;
            switch (C14091.f18956a[this.f18958a.ordinal()]) {
                case 1:
                case 2:
                    point = new Point(this.f18960c.x, this.f18966i);
                    break;
                case 3:
                case 4:
                    point = new Point(this.f18967j, this.f18960c.y);
                    break;
                case 5:
                case 6:
                    point = new Point(this.f18969l, this.f18960c.y);
                    break;
                default:
                    point = new Point(this.f18960c.x, this.f18968k);
                    break;
            }
            AnchorRow anchorRow = new AnchorRow(this.f18958a, Math.max(this.f18959b, i), point);
            anchorRow.m27632a(view);
            return anchorRow;
        }
        this.f18964g[layoutParams.c.ordinal()] = layoutParams.b;
        if (measuredHeight > this.f18965h) {
            this.f18965h = measuredHeight;
            switch (C14091.f18956a[this.f18958a.ordinal()]) {
                case 1:
                case 2:
                    this.f18966i = this.f18968k - this.f18965h;
                    break;
                case 3:
                case 4:
                    this.f18967j = this.f18969l + this.f18965h;
                    break;
                case 5:
                case 6:
                    this.f18969l = this.f18967j - this.f18965h;
                    break;
                default:
                    this.f18968k = this.f18966i + this.f18965h;
                    break;
            }
        }
        int[] iArr = this.f18962e;
        measuredHeight = layoutParams.c.ordinal();
        iArr[measuredHeight] = iArr[measuredHeight] + i;
        iArr = this.f18963f;
        measuredHeight = layoutParams.c.ordinal();
        iArr[measuredHeight] = iArr[measuredHeight] - i;
        switch (C14091.f18957b[layoutParams.c.ordinal()]) {
            case 1:
                this.f18961d[layoutParams.c.ordinal()].addLast(view);
                m27630h();
                m27631i();
                break;
            case 2:
                this.f18961d[layoutParams.c.ordinal()].addLast(view);
                m27629g();
                m27631i();
                break;
            case 3:
                this.f18961d[layoutParams.c.ordinal()].addFirst(view);
                m27629g();
                m27630h();
                break;
        }
        return null;
    }

    public final void m27633a() {
        for (AnchorPosition anchorPosition : AnchorPosition.values()) {
            int i;
            switch (C14091.f18957b[anchorPosition.ordinal()]) {
                case 2:
                    i = (this.f18959b - this.f18962e[anchorPosition.ordinal()]) / 2;
                    break;
                case 3:
                    i = this.f18959b - this.f18962e[anchorPosition.ordinal()];
                    break;
                default:
                    i = 0;
                    break;
            }
            Iterator it = this.f18961d[anchorPosition.ordinal()].iterator();
            int i2 = i;
            while (it.hasNext()) {
                View view = (View) it.next();
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (this.f18958a.isHorizontal()) {
                    layoutParams.e = new Point(this.f18969l + i2, (this.f18966i + ((this.f18965h - view.getMeasuredHeight()) / 2)) - layoutParams.topMargin);
                    i2 = ((view.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin) + i2;
                } else {
                    layoutParams.e = new Point((this.f18969l + ((this.f18965h - view.getMeasuredWidth()) / 2)) - layoutParams.leftMargin, this.f18966i + i2);
                    i2 = ((view.getMeasuredHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) + i2;
                }
            }
        }
    }

    private void m27629g() {
        this.f18963f[AnchorPosition.START.ordinal()] = this.f18962e[AnchorPosition.CENTER.ordinal()] > 0 ? ((this.f18959b - this.f18962e[AnchorPosition.CENTER.ordinal()]) / 2) - this.f18962e[AnchorPosition.START.ordinal()] : (this.f18959b - this.f18962e[AnchorPosition.END.ordinal()]) - this.f18962e[AnchorPosition.START.ordinal()];
    }

    private void m27630h() {
        this.f18963f[AnchorPosition.CENTER.ordinal()] = (this.f18959b - (Math.max(this.f18962e[AnchorPosition.START.ordinal()], this.f18962e[AnchorPosition.END.ordinal()]) * 2)) - this.f18962e[AnchorPosition.CENTER.ordinal()];
    }

    private void m27631i() {
        this.f18963f[AnchorPosition.END.ordinal()] = this.f18962e[AnchorPosition.CENTER.ordinal()] > 0 ? ((this.f18959b - this.f18962e[AnchorPosition.CENTER.ordinal()]) / 2) - this.f18962e[AnchorPosition.END.ordinal()] : (this.f18959b - this.f18962e[AnchorPosition.START.ordinal()]) - this.f18962e[AnchorPosition.END.ordinal()];
    }
}
