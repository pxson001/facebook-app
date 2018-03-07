package com.facebook.groups.groupsgrid.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: X-Akamai-Pragma-Client-IP */
public class GroupsSectionedGridSectionHeader extends CustomLinearLayout {
    @Inject
    public Resources f10361a;
    public Paint f10362b = new Paint(1);
    public int f10363c = this.f10361a.getDimensionPixelSize(2131431925);
    public int f10364d = this.f10361a.getDimensionPixelSize(2131434705);
    public int f10365e = this.f10361a.getDimensionPixelSize(2131434703);
    public int f10366f = this.f10361a.getDimensionPixelSize(2131434704);
    private boolean f10367g;
    public TextView f10368h;
    public TextView f10369i;
    public ImageView f10370j;
    public View f10371k;

    public static void m10771a(Object obj, Context context) {
        ((GroupsSectionedGridSectionHeader) obj).f10361a = ResourcesMethodAutoProvider.a(FbInjector.get(context));
    }

    public GroupsSectionedGridSectionHeader(Context context) {
        super(context);
        Class cls = GroupsSectionedGridSectionHeader.class;
        m10771a(this, getContext());
        this.f10362b.setColor(this.f10361a.getColor(2131363505));
        this.f10362b.setStyle(Style.FILL);
        setWillNotDraw(false);
        setContentView(2130904744);
        this.f10368h = (TextView) a(2131561741);
        this.f10369i = (TextView) a(2131562820);
        this.f10370j = (ImageView) a(2131562821);
        this.f10371k = a(2131562819);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f10367g) {
            canvas.drawRect((float) this.f10363c, (float) this.f10364d, (float) (getWidth() - this.f10363c), 1.0f + ((float) this.f10364d), this.f10362b);
        }
    }

    public final void m10772a(int i, String str, @Nullable String str2, @Nullable Drawable drawable, OnClickListener onClickListener, boolean z) {
        int i2;
        this.f10371k.setId(i);
        this.f10367g = z;
        if (z) {
            i2 = this.f10366f;
        } else {
            i2 = this.f10365e;
        }
        setPadding(0, i2, 0, this.f10365e);
        invalidate();
        this.f10368h.setText(str);
        if (str2 != null) {
            this.f10369i.setVisibility(0);
            this.f10369i.setText(str2);
        } else {
            this.f10369i.setVisibility(8);
        }
        if (drawable != null) {
            this.f10370j.setImageDrawable(drawable);
            this.f10370j.setVisibility(0);
        } else {
            this.f10370j.setVisibility(8);
        }
        this.f10371k.setOnClickListener(onClickListener);
    }
}
