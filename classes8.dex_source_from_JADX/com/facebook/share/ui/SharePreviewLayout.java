package com.facebook.share.ui;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.OverlayableRelativeLayout;

/* compiled from: media_set_display_activity_mediaset_extra */
public class SharePreviewLayout extends OverlayableRelativeLayout {
    private final FbDraweeView f8982a;
    private final TextView f8983b;
    private final TextView f8984c;
    private final TextView f8985d;
    private final TextView f8986e;
    private final View f8987f;
    private final ProgressBar f8988g;
    public boolean f8989h;
    private String f8990i;
    private boolean f8991j;
    private boolean f8992k;
    private Mode f8993l;

    /* compiled from: media_set_display_activity_mediaset_extra */
    public enum Mode {
        LINK_SHARE,
        OPEN_GRAPH
    }

    public SharePreviewLayout(Context context) {
        this(context, null, 0);
    }

    public SharePreviewLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SharePreviewLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8989h = true;
        this.f8993l = Mode.LINK_SHARE;
        setContentView(2130904335);
        if (attributeSet.getAttributeBooleanValue(0, false)) {
            ((RelativeLayout) a(2131558531)).setBackgroundDrawable(null);
        }
        this.f8982a = (FbDraweeView) a(2131561985);
        this.f8983b = (TextView) a(2131561990);
        this.f8984c = (TextView) a(2131561991);
        this.f8985d = (TextView) a(2131561992);
        this.f8986e = (TextView) a(2131561983);
        this.f8987f = a(2131561987);
        this.f8988g = (ProgressBar) a(2131561986);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f8989h) {
            int size = MeasureSpec.getSize(i2);
            switch (MeasureSpec.getMode(i2)) {
                case Integer.MIN_VALUE:
                    Resources resources = getResources();
                    int dimensionPixelSize = (resources.getDimensionPixelSize(2131428032) * 2) + resources.getDimensionPixelSize(2131428031);
                    int height = getHeight();
                    if (height == 0) {
                        height = resources.getDimensionPixelSize(2131427503);
                    }
                    if (size < height + dimensionPixelSize) {
                        setMeasuredDimension(0, 0);
                        return;
                    }
                    return;
                case 0:
                case 1073741824:
                    return;
                default:
                    return;
            }
        }
    }

    public void setHideable(boolean z) {
        this.f8989h = z;
    }

    public final SharePreviewLayout m10704a(String str) {
        this.f8983b.setText(str);
        m10702a();
        return this;
    }

    public final SharePreviewLayout m10707b(String str) {
        this.f8984c.setText(str);
        m10702a();
        return this;
    }

    public final SharePreviewLayout m10709c(String str) {
        this.f8985d.setText(str);
        m10702a();
        return this;
    }

    public final SharePreviewLayout m10705a(String str, CallerContext callerContext) {
        this.f8990i = str;
        if (StringUtil.c(this.f8990i)) {
            this.f8982a.a(null, callerContext);
        } else {
            this.f8982a.a(Uri.parse(this.f8990i), callerContext);
        }
        m10702a();
        return this;
    }

    public final SharePreviewLayout m10710d(String str) {
        this.f8986e.setText(str);
        m10702a();
        return this;
    }

    public final SharePreviewLayout m10706a(boolean z) {
        this.f8991j = z;
        m10702a();
        return this;
    }

    public final SharePreviewLayout m10708b(boolean z) {
        this.f8992k = z;
        m10702a();
        return this;
    }

    public final SharePreviewLayout m10703a(Mode mode) {
        this.f8993l = mode;
        m10702a();
        return this;
    }

    private void m10702a() {
        if (this.f8993l == Mode.LINK_SHARE) {
            this.f8986e.setVisibility(8);
        } else if (this.f8993l == Mode.OPEN_GRAPH) {
            this.f8986e.setVisibility(0);
        }
        if (this.f8992k) {
            this.f8988g.setVisibility(0);
            this.f8983b.setVisibility(4);
            this.f8985d.setVisibility(4);
            this.f8982a.setVisibility(4);
            return;
        }
        this.f8988g.setVisibility(4);
        this.f8983b.setVisibility(0);
        this.f8985d.setVisibility(0);
        if (StringUtil.c(this.f8990i)) {
            this.f8982a.setVisibility(4);
            this.f8987f.setVisibility(4);
            return;
        }
        this.f8982a.setVisibility(0);
        if (this.f8991j) {
            this.f8987f.setVisibility(0);
        }
    }
}
