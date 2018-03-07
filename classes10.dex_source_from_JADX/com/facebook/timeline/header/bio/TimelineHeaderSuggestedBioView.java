package com.facebook.timeline.header.bio;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.util.FindViewUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: forjjjwayvbnkeyfhjzwskkkyyyfucrryppynnymmyjkmfkt */
public class TimelineHeaderSuggestedBioView extends FbRelativeLayout {
    private View f11599a;
    private BetterTextView f11600b;
    private BetterTextView f11601c;

    public TimelineHeaderSuggestedBioView(Context context) {
        super(context);
    }

    public TimelineHeaderSuggestedBioView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1450919001);
        super.onFinishInflate();
        this.f11599a = FindViewUtil.b(this, 2131567979);
        this.f11600b = (BetterTextView) FindViewUtil.b(this, 2131567980);
        this.f11601c = (BetterTextView) FindViewUtil.b(this, 2131567981);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -869562549, a);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f11601c.setText(charSequence);
    }

    public void setOnCloseListener(OnClickListener onClickListener) {
        this.f11599a.setOnClickListener(onClickListener);
    }

    public void setClickableColor(@ColorRes int i) {
        this.f11600b.setTextColor(ContextCompat.b(getContext(), i));
    }
}
