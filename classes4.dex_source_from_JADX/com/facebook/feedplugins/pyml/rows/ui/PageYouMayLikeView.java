package com.facebook.feedplugins.pyml.rows.ui;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.common.util.SizeUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HasPageStyle;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import javax.annotation.Nullable;

/* compiled from: notif_id */
public class PageYouMayLikeView extends PagerItemWrapperLayout implements HasPageStyle, RecyclableView {
    public boolean f6954a;
    public View f6955b = c(2131565663);
    public TextView f6956c = ((TextView) c(2131561160));
    public TextView f6957d = ((TextView) c(2131565667));
    public View f6958e = c(2131565665);
    public View f6959f = c(2131565668);
    public TextView f6960g = ((TextView) c(2131565671));
    public ViewGroup f6961h = ((ViewGroup) c(2131565670));
    public TextView f6962i = ((TextView) c(2131565672));
    public TextView f6963j = ((TextView) c(2131560628));
    public FbDraweeView f6964k = ((FbDraweeView) c(2131561267));
    public FbDraweeView f6965l = ((FbDraweeView) c(2131565666));
    public PageYouMayLikeHeaderView f6966m = ((PageYouMayLikeHeaderView) c(2131565664));
    public GlyphView f6967n = ((GlyphView) c(2131565674));
    public OnClickListener f6968o;
    public int f6969p;
    public int f6970q;

    /* compiled from: notif_id */
    public class C03301 implements OnClickListener {
        final /* synthetic */ PageYouMayLikeView f6976a;

        public C03301(PageYouMayLikeView pageYouMayLikeView) {
            this.f6976a = pageYouMayLikeView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1919925467);
            if (this.f6976a.f6968o != null) {
                this.f6976a.f6968o.onClick(this.f6976a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1958932842, a);
        }
    }

    public PageYouMayLikeView(Context context) {
        super(context);
        setContentView(2130906091);
        this.f6956c.setMovementMethod(LinkMovementMethod.getInstance());
        this.f6960g.setMovementMethod(LinkMovementMethod.getInstance());
        this.f6967n.setOnClickListener(new C03301(this));
        this.f6964k.setHierarchy(new GenericDraweeHierarchyBuilder(getContext().getResources()).u());
        this.f6969p = getResources().getDimensionPixelSize(2131428854);
        this.f6970q = getResources().getDimensionPixelSize(2131428895);
    }

    public final void mo587a(int i, boolean z, boolean z2) {
        int i2 = z ? 0 : this.f6969p * -1;
        if (z2) {
            this.f6955b.setPadding(i2, this.f6955b.getPaddingTop(), i2, this.f6955b.getPaddingBottom());
        }
        this.f6955b.setBackgroundResource(0);
        setBackgroundResource(0);
        this.f6959f.setBackgroundResource(2130840170);
        this.f6958e.setPadding(this.f6969p, this.f6970q, this.f6969p, 0);
        this.f6963j.setPadding(this.f6969p, 0, this.f6969p, 0);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f6959f.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.leftMargin = this.f6969p;
            marginLayoutParams.bottomMargin = this.f6969p;
            marginLayoutParams.rightMargin = this.f6969p;
        }
        if (z) {
            i2 = this.f6967n.getPaddingLeft();
            int a = SizeUtil.a(getContext(), 4.0f) + i2;
            this.f6967n.setPadding(i2, a, i2, a);
        }
    }

    public void setWidth(int i) {
        LayoutParams layoutParams = (LayoutParams) this.f6955b.getLayoutParams();
        layoutParams.width = i;
        this.f6955b.setLayoutParams(layoutParams);
        this.f6955b.requestLayout();
    }

    public void setOnPageInfoClickedListener(@Nullable OnClickListener onClickListener) {
        this.f6965l.setOnClickListener(onClickListener);
        this.f6964k.setOnClickListener(onClickListener);
        this.f6963j.setOnClickListener(onClickListener);
        this.f6961h.setOnClickListener(onClickListener);
    }

    public static void m7259a(TextView textView, CharSequence charSequence) {
        int i = (charSequence == null || charSequence.length() <= 0) ? 8 : 0;
        textView.setText(charSequence);
        textView.setVisibility(i);
    }

    public void setProfileController(@Nullable DraweeController draweeController) {
        this.f6965l.setController(draweeController);
    }

    public void setSponsoredTagsValue(boolean z) {
        this.f6956c.setTag(2131558541, Boolean.valueOf(z));
        this.f6960g.setTag(2131558541, Boolean.valueOf(z));
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2025383861);
        super.onAttachedToWindow();
        this.f6954a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1082813104, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 254261418);
        super.onDetachedFromWindow();
        this.f6954a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 2129749384, a);
    }

    public final boolean mo569a() {
        return this.f6954a;
    }
}
