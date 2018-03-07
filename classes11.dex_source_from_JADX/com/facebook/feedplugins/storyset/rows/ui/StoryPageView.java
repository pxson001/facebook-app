package com.facebook.feedplugins.storyset.rows.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.common.util.SizeUtil;
import com.facebook.components.feed.FeedComponentView;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderOptionsMenu;
import com.facebook.feed.rows.sections.header.ui.HScrollPageHeaderView;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HasPageStyle;
import com.facebook.feedplugins.base.blingbar.ui.ConstantHeightBlingBarView;
import com.facebook.feedplugins.base.footer.ui.Footer;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import com.google.common.base.Optional;
import javax.annotation.Nullable;

/* compiled from: appStateDidChange */
public abstract class StoryPageView<V extends View & Footer> extends PagerItemWrapperLayout implements CanShowHeaderOptionsMenu, HasPageStyle, CanHaveEmbededHeader, RecyclableView {
    public boolean f9857a;
    private final HScrollPageHeaderView f9858b;
    private final FeedComponentView f9859c;
    private final TextView f9860d;
    public final ImageView f9861e;
    private final StoryPageLabelWithButtonView f9862f;
    private final ConstantHeightBlingBarView f9863g;
    private final TextView f9864h;
    private final V f9865i;
    private final LinearLayout f9866j;
    private final Optional<View> f9867k;
    private final CustomLinearLayout f9868l;
    private final ColorDrawable f9869m;
    private final int f9870n;
    private boolean f9871o = false;
    private boolean f9872p = true;

    public StoryPageView(Context context, int i) {
        super(context);
        setContentView(i);
        this.f9867k = d(2131562633);
        this.f9864h = (TextView) c(2131567721);
        this.f9868l = (CustomLinearLayout) c(2131567720);
        this.f9861e = (ImageView) c(2131567722);
        this.f9864h.setMovementMethod(LinkMovementMethod.getInstance());
        this.f9864h.setSingleLine();
        this.f9864h.setEllipsize(TruncateAt.END);
        setSocialContextText(null);
        this.f9866j = (LinearLayout) c(2131567723);
        this.f9858b = (HScrollPageHeaderView) c(2131562634);
        this.f9858b.setSingleLineTitle(true);
        this.f9859c = (FeedComponentView) c(2131564191);
        this.f9860d = (TextView) c(2131564192);
        this.f9862f = (StoryPageLabelWithButtonView) c(2131567715);
        this.f9863g = (ConstantHeightBlingBarView) c(2131562638);
        this.f9865i = c(2131562639);
        this.f9869m = new ColorDrawable(context.getResources().getColor(2131362789));
        this.f9870n = (int) context.getResources().getDimension(2131428854);
    }

    public HScrollPageHeaderView getHeader() {
        return this.f9858b;
    }

    public TextView getContentText() {
        return this.f9860d;
    }

    public StoryPageLabelWithButtonView getLabelAndButton() {
        return this.f9862f;
    }

    public void setSocialContextText(@Nullable CharSequence charSequence) {
        boolean z = false;
        int i = (charSequence == null || charSequence.length() <= 0) ? 8 : 0;
        this.f9864h.setText(charSequence);
        this.f9864h.setVisibility(i);
        if (i == 0) {
            z = true;
        }
        this.f9871o = z;
    }

    public ConstantHeightBlingBarView getBlingBar() {
        return this.f9863g;
    }

    public V getFooter() {
        return this.f9865i;
    }

    public void setWidth(int i) {
        if (getLayoutParams() != null && getLayoutParams().width != i) {
            getLayoutParams().width = i;
        }
    }

    public LinearLayout getAttachmentContainer() {
        return this.f9866j;
    }

    public void setUseEmbeddedHeaderComponent(boolean z) {
        int i;
        int i2 = 8;
        FeedComponentView feedComponentView = this.f9859c;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        feedComponentView.setVisibility(i);
        HScrollPageHeaderView hScrollPageHeaderView = this.f9858b;
        if (!z) {
            i2 = 0;
        }
        hScrollPageHeaderView.setVisibility(i2);
    }

    public void setMenuButtonActive(boolean z) {
        this.f9861e.setVisibility(z ? 0 : 8);
    }

    public final boolean hk_() {
        return this.f9861e.getVisibility() == 0;
    }

    public final void m10254a(Tooltip tooltip) {
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -819772550);
        super.onAttachedToWindow();
        this.f9857a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 48866132, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -330483382);
        super.onDetachedFromWindow();
        this.f9857a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1503721177, a);
    }

    public final boolean m10255a() {
        return this.f9857a;
    }

    public final void m10253a(int i, boolean z, boolean z2) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131428854);
        int a = dimensionPixelSize - SizeUtil.a(getContext(), 2.0f);
        this.f9866j.setBackgroundResource(2130840170);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f9866j.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.leftMargin = a;
            marginLayoutParams.rightMargin = a;
            marginLayoutParams.topMargin = getResources().getDimensionPixelSize(2131427640);
        }
        this.f9872p = false;
        int i2 = z ? 0 : a * -1;
        if (z2 && this.f9867k.isPresent()) {
            ((View) this.f9867k.get()).setPadding(i2, ((View) this.f9867k.get()).getPaddingTop(), i2, ((View) this.f9867k.get()).getPaddingBottom());
        }
        if (z) {
            setWidth(i);
            this.f9860d.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, 0);
            marginLayoutParams = (MarginLayoutParams) this.f9860d.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = 0;
            }
        } else if (this.f9867k.isPresent()) {
            ((View) this.f9867k.get()).setBackgroundResource(0);
        }
        setMenuButtonActive(true);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int width = getWidth();
        if (this.f9871o) {
            int bottom = this.f9868l.getBottom();
            this.f9869m.setBounds(this.f9870n, paddingTop + bottom, width - this.f9870n, (bottom + paddingTop) + 1);
            this.f9869m.draw(canvas);
        }
        if (this.f9872p) {
            bottom = this.f9863g.getTop();
            this.f9869m.setBounds(this.f9870n, (paddingTop + bottom) - 1, width - this.f9870n, paddingTop + bottom);
            this.f9869m.draw(canvas);
        }
    }
}
