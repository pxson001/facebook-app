package com.facebook.photos.warning;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View.MeasureSpec;
import com.facebook.feed.collage.CollageItem;
import com.facebook.feed.collage.ui.CollageAttachmentView;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: select_friends_view */
public class ObjectionableContentCollageAttachmentView extends CustomFrameLayout {
    @Inject
    public ObjectionableContentController f3509a;
    private ObjectionableContentWarningView f3510b = ((ObjectionableContentWarningView) c(2131564311));
    private CollageAttachmentView<CollageItem> f3511c = ((CollageAttachmentView) c(2131564005));

    public static void m3454a(Object obj, Context context) {
        ((ObjectionableContentCollageAttachmentView) obj).f3509a = ObjectionableContentController.a(FbInjector.get(context));
    }

    public ObjectionableContentCollageAttachmentView(Context context) {
        super(context);
        setContentView(2130905521);
        Class cls = ObjectionableContentCollageAttachmentView.class;
        m3454a(this, getContext());
    }

    protected void onMeasure(int i, int i2) {
        this.f3511c.measure(i, i2);
        Rect c = this.f3511c.c(0);
        this.f3510b.measure(MeasureSpec.makeMeasureSpec(c.width(), 1073741824), MeasureSpec.makeMeasureSpec(c.height(), 1073741824));
        setMeasuredDimension(this.f3511c.getMeasuredWidth(), this.f3511c.getMeasuredHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = 0;
        this.f3511c.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        Rect c = this.f3511c.c(0);
        this.f3510b.layout(getPaddingLeft() + c.left, getPaddingTop() + c.top, getPaddingLeft() + c.right, getPaddingTop() + c.bottom);
        CollageItem collageItem = (CollageItem) this.f3511c.getVisibleAttachments().get(0);
        if (m3456a(c) && this.f3509a.a(collageItem.b())) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        ObjectionableContentWarningView objectionableContentWarningView = this.f3510b;
        if (i5 == 0) {
            i6 = 8;
        }
        objectionableContentWarningView.setVisibility(i6);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        ImmutableList visibleAttachments = this.f3511c.getVisibleAttachments();
        for (int i = 0; i < visibleAttachments.size(); i++) {
            CollageItem collageItem = (CollageItem) visibleAttachments.get(i);
            Rect c = this.f3511c.c(i);
            if (m3455a(i, collageItem, c)) {
                int min = (int) (0.25d * ((double) Math.min(c.width(), c.height())));
                Drawable drawable = getResources().getDrawable(2130844035);
                drawable.setAlpha(128);
                drawable.setBounds(c.centerX() - (min / 2), c.centerY() - (min / 2), c.centerX() + (min / 2), (min / 2) + c.centerY());
                drawable.draw(canvas);
            }
        }
    }

    private boolean m3455a(int i, CollageItem collageItem, Rect rect) {
        return (!this.f3509a.a(collageItem.b()) || m3456a(rect) || !this.f3511c.f(i) || this.f3511c.b(i) || collageItem.a()) ? false : true;
    }

    private boolean m3456a(Rect rect) {
        return rect.width() == getMeasuredWidth();
    }
}
