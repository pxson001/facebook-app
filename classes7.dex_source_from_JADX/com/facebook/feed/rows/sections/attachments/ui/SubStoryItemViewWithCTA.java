package com.facebook.feed.rows.sections.attachments.ui;

import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.attachments.angora.actionbutton.GenericActionButtonView;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HasPageStyle;
import javax.annotation.Nullable;

/* compiled from: V360 */
public class SubStoryItemViewWithCTA extends SubStoryItemView implements AttachmentHasButton, HasPageStyle {
    private final GenericActionButtonView f21101a;
    private final LinearLayout f21102b;

    public SubStoryItemViewWithCTA(Context context) {
        this(context, 2130907291);
    }

    private SubStoryItemViewWithCTA(Context context, int i) {
        super(context, i);
        setBackgroundResource(2130843719);
        this.f21101a = (GenericActionButtonView) c(2131567739);
        this.f21102b = (LinearLayout) c(2131567736);
    }

    public void setActionButtonOnClickListener(OnClickListener onClickListener) {
        this.f21101a.a.setOnClickListener(onClickListener);
    }

    @Nullable
    public GenericActionButtonView getActionButton() {
        return this.f21101a;
    }

    public final void m23977a(int i, boolean z, boolean z2) {
        setWidth(i);
    }

    public void setWidth(int i) {
        LayoutParams layoutParams = (LayoutParams) this.f21102b.getLayoutParams();
        layoutParams.width = i;
        this.f21102b.setLayoutParams(layoutParams);
        this.f21102b.requestLayout();
    }
}
