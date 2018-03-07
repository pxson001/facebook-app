package com.facebook.timeline.header.bio;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.common.util.FindViewUtil;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: formatted_amount */
public class TimelineHeaderBioView extends CustomLinearLayout {
    @Inject
    public AllCapsTransformationMethod f11592a;
    private FbTextView f11593b;
    private FbTextView f11594c;

    private static <T extends View> void m11614a(Class<T> cls, T t) {
        m11615a((Object) t, t.getContext());
    }

    private static void m11615a(Object obj, Context context) {
        ((TimelineHeaderBioView) obj).f11592a = AllCapsTransformationMethod.b(FbInjector.get(context));
    }

    private void m11613a(AllCapsTransformationMethod allCapsTransformationMethod) {
        this.f11592a = allCapsTransformationMethod;
    }

    public TimelineHeaderBioView(Context context) {
        super(context);
    }

    public TimelineHeaderBioView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void m11612a() {
        m11614a(TimelineHeaderBioView.class, (View) this);
        this.f11593b = (FbTextView) FindViewUtil.b(this, 2131567916);
        this.f11594c = (FbTextView) FindViewUtil.b(this, 2131567917);
        this.f11594c.setTransformationMethod(this.f11592a);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -578740092);
        super.onFinishInflate();
        m11612a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2107093236, a);
    }

    public final void m11616a(CharSequence charSequence, boolean z, boolean z2) {
        if (z) {
            this.f11594c.setVisibility(0);
            setBackgroundResource(2130842711);
        } else {
            this.f11594c.setVisibility(8);
            setBackgroundResource(2130842712);
        }
        LayoutParams layoutParams = (LayoutParams) this.f11593b.getLayoutParams();
        layoutParams.gravity = 1;
        this.f11593b.setLayoutParams(layoutParams);
        this.f11593b.setGravity(1);
        this.f11593b.setTextColor(getResources().getColor(2131361955));
        this.f11593b.setTransformationMethod(null);
        if (z2) {
            this.f11593b.setMaxLines(2);
            this.f11593b.setEllipsize(TruncateAt.END);
        } else {
            this.f11593b.setMaxLines(Integer.MAX_VALUE);
            this.f11593b.setEllipsize(null);
        }
        this.f11593b.setText(charSequence);
    }
}
