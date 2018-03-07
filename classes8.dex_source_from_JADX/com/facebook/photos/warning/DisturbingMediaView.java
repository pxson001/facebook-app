package com.facebook.photos.warning;

import android.content.Context;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.galleryutil.VisibilityAnimator;
import com.facebook.resources.ui.FbButton;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: selectedTokens */
public class DisturbingMediaView extends CustomRelativeLayout {
    @Inject
    public ViewHelperViewAnimatorFactory f3502a;
    private VisibilityAnimator f3503b;
    private DisturbingMediaText f3504c;
    private FbButton f3505d;
    private int f3506e;

    private static <T extends View> void m3449a(Class<T> cls, T t) {
        m3450a((Object) t, t.getContext());
    }

    private static void m3450a(Object obj, Context context) {
        ((DisturbingMediaView) obj).f3502a = ViewHelperViewAnimatorFactory.a(FbInjector.get(context));
    }

    public static DisturbingMediaView m3447a(ViewGroup viewGroup) {
        DisturbingMediaView disturbingMediaView = (DisturbingMediaView) viewGroup.findViewById(2131561071);
        if (disturbingMediaView == null) {
            LayoutInflater.from(viewGroup.getContext()).inflate(2130903927, viewGroup, true);
            disturbingMediaView = (DisturbingMediaView) viewGroup.findViewById(2131561071);
        }
        Preconditions.checkNotNull(disturbingMediaView);
        Preconditions.checkNotNull(disturbingMediaView.f3505d);
        return disturbingMediaView;
    }

    public DisturbingMediaView(Context context) {
        super(context);
        m3448a();
    }

    public DisturbingMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3448a();
    }

    public DisturbingMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3448a();
    }

    private void m3448a() {
        m3449a(DisturbingMediaView.class, (View) this);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 717778218);
        super.onFinishInflate();
        this.f3504c = (DisturbingMediaText) a(2131561072);
        this.f3505d = (FbButton) a(2131561073);
        this.f3506e = (int) ((getResources().getDimension(2131432546) + ((float) this.f3505d.getPaddingTop())) + ((float) this.f3505d.getPaddingBottom()));
        this.f3503b = new VisibilityAnimator(this, 200, false, this.f3502a);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 924199308, a);
    }

    public void setSeePhotoOnClickListener(OnClickListener onClickListener) {
        this.f3505d.setOnClickListener(onClickListener);
    }

    protected void onMeasure(int i, int i2) {
        this.f3504c.setVisibility(0);
        this.f3505d.setMaxWidth(MeasureSpec.getSize(i));
        this.f3505d.setTransformationMethod(null);
        super.onMeasure(i, i2);
        int measuredHeight = this.f3505d.getMeasuredHeight();
        if (this.f3504c.getMeasuredHeight() + measuredHeight > MeasureSpec.getSize(i2) || measuredHeight < this.f3506e) {
            this.f3504c.setVisibility(8);
            this.f3505d.setTransformationMethod(SingleLineTransformationMethod.getInstance());
            super.onMeasure(i, i2);
        }
    }

    public final void m3451a(boolean z) {
        this.f3503b.a(z);
    }

    public final void m3452b(boolean z) {
        this.f3503b.b(z);
    }
}
