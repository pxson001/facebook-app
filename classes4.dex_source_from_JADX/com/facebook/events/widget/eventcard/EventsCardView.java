package com.facebook.events.widget.eventcard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.text.BetterTextView;
import com.google.common.annotations.VisibleForTesting;
import java.util.Date;
import javax.annotation.Nullable;

/* compiled from: orca_message */
public class EventsCardView extends CustomLinearLayout {
    public FbDraweeView f5982a;
    private ImageBlockLayout f5983b;
    public BetterTextView f5984c;
    private EventCalendarTimeView f5985d;
    public BetterTextView f5986e;
    public BetterTextView f5987f;
    public EventActionButtonView f5988g;
    public ImageView f5989h;
    public boolean f5990i;

    public EventsCardView(Context context) {
        super(context);
        mo543a();
    }

    public EventsCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo543a();
    }

    public EventsCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo543a();
    }

    private void mo543a() {
        setContentView(2130904008);
        setOrientation(1);
        this.f5982a = (FbDraweeView) a(2131561222);
        this.f5983b = (ImageBlockLayout) a(2131561224);
        this.f5984c = (BetterTextView) a(2131561226);
        this.f5985d = (EventCalendarTimeView) a(2131561225);
        this.f5986e = (BetterTextView) a(2131561227);
        this.f5987f = (BetterTextView) a(2131561228);
        this.f5988g = (EventActionButtonView) a(2131561229);
        this.f5989h = (ImageView) a(2131561223);
        Resources resources = getResources();
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder.f = resources.getDrawable(2131361934);
        this.f5982a.setHierarchy(genericDraweeHierarchyBuilder.f(resources.getDrawable(2130839492)).e(ScaleType.h).u());
    }

    public final void m6447b() {
        this.f5990i = false;
        setOnClickListener(null);
        setCalendarFormatStartDate(null);
        setCoverPhotoController(null);
        setTitleText(null);
        m6446a(null, null);
        setSocialContextText(null);
        this.f5988g.m6494a();
        m6449d();
        m6450e();
    }

    public void setShouldHideNullCoverPhotoView(boolean z) {
        this.f5990i = z;
    }

    public final void m6444a(Drawable drawable) {
        CustomViewUtils.b(this.f5983b, drawable);
    }

    public final void m6448c() {
        this.f5989h.setVisibility(0);
    }

    public final void m6449d() {
        CustomViewUtils.b(this.f5983b, null);
    }

    public final void m6450e() {
        this.f5989h.setVisibility(8);
        this.f5989h.setOnClickListener(null);
    }

    protected DraweeView getCoverPhotoView() {
        return this.f5982a;
    }

    public TextView getTitleView() {
        return this.f5984c;
    }

    public TextView getSocialContextTextView() {
        return this.f5987f;
    }

    @VisibleForTesting
    protected void setTitleTextView(BetterTextView betterTextView) {
        this.f5984c = betterTextView;
    }

    @VisibleForTesting
    protected void setSocialContextTextView(BetterTextView betterTextView) {
        this.f5987f = betterTextView;
    }

    @VisibleForTesting
    protected void setEventInfoTextView(BetterTextView betterTextView) {
        this.f5986e = betterTextView;
    }

    public EventActionButtonView getActionButton() {
        return this.f5988g;
    }

    public View getRemoveButton() {
        return this.f5989h;
    }

    public void setCoverPhotoAspectRatio(float f) {
        this.f5982a.setAspectRatio(f);
    }

    public void setCoverPhotoController(@Nullable DraweeController draweeController) {
        m6442a(this.f5982a, draweeController);
    }

    public void setCoverPhotoFocusPoint(@Nullable PointF pointF) {
        if (pointF != null) {
            ((GenericDraweeHierarchy) this.f5982a.getHierarchy()).a(pointF);
        }
    }

    public void setTitleText(@Nullable CharSequence charSequence) {
        m6441a(this.f5984c, charSequence);
    }

    public void setCalendarFormatStartDate(@Nullable Date date) {
        m6443a(this.f5985d, date);
    }

    public final void m6446a(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        m6441a(this.f5986e, m6439a(getContext(), charSequence, charSequence2));
    }

    public void setSocialContextText(@Nullable CharSequence charSequence) {
        m6445a(charSequence, 2131361974);
    }

    public final void m6445a(@Nullable CharSequence charSequence, @ColorRes int i) {
        this.f5987f.setTextColor(getResources().getColor(i));
        m6441a(this.f5987f, charSequence);
    }

    private static void m6443a(EventCalendarTimeView eventCalendarTimeView, Date date) {
        int i = 8;
        if (date == null) {
            eventCalendarTimeView.setVisibility(8);
            return;
        }
        if (eventCalendarTimeView.m6459a(date)) {
            i = 0;
        }
        eventCalendarTimeView.setVisibility(i);
    }

    private void m6442a(DraweeView draweeView, DraweeController draweeController) {
        int i = 0;
        if (this.f5990i) {
            if (draweeController == null) {
                i = 8;
            }
            draweeView.setVisibility(i);
        } else {
            draweeView.setVisibility(0);
        }
        draweeView.setController(draweeController);
    }

    private static void m6441a(TextView textView, CharSequence charSequence) {
        textView.setVisibility(!TextUtils.isEmpty(charSequence) ? 0 : 8);
        textView.setText(charSequence);
    }

    public final void m6451f() {
        this.f5988g.setVisibility(8);
    }

    public void onMeasure(int i, int i2) {
        int i3 = 1;
        super.onMeasure(i, i2);
        if (this.f5984c.getLineCount() <= 1) {
            if (!TextUtils.isEmpty(this.f5986e.getText()) && this.f5986e.getVisibility() == 8) {
                this.f5986e.setVisibility(0);
            }
            i3 = 0;
        } else {
            if (!(this.f5986e.getVisibility() == 8 || this.f5987f.getVisibility() == 8)) {
                this.f5986e.setVisibility(8);
            }
            i3 = 0;
        }
        if (i3 != 0) {
            super.onMeasure(i, i2);
        }
    }

    public static CharSequence m6439a(Context context, CharSequence charSequence, CharSequence charSequence2) {
        if (!TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(charSequence2)) {
            return context.getResources().getString(2131233855, new Object[]{charSequence, charSequence2});
        } else if (!TextUtils.isEmpty(charSequence)) {
            return charSequence;
        } else {
            if (TextUtils.isEmpty(charSequence2)) {
                return null;
            }
            return charSequence2;
        }
    }
}
