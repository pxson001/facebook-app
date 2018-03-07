package com.facebook.feedplugins.pyml.rows.ui;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import com.facebook.widget.springbutton.SpringScaleButton;

/* compiled from: o2i_ul_bwe */
public class PageYouMayLikeSmallFormatView extends PagerItemWrapperLayout implements RecyclableView {
    public boolean f6396a;
    public TextView f6397b = ((TextView) c(2131565661));
    public View f6398c = c(2131565662);
    public TextView f6399d = ((TextView) c(2131561160));
    public TextView f6400e = ((TextView) c(2131565667));
    public TextView f6401f = ((TextView) c(2131565671));
    public ViewGroup f6402g = ((ViewGroup) c(2131565670));
    public TextView f6403h = ((TextView) c(2131565672));
    public TextView f6404i = ((TextView) c(2131560628));
    public FbDraweeView f6405j = ((FbDraweeView) c(2131561267));
    public FbDraweeView f6406k = ((FbDraweeView) c(2131565666));
    public SpringScaleButton f6407l = ((SpringScaleButton) c(2131565674));
    public OnClickListener f6408m;

    /* compiled from: o2i_ul_bwe */
    public class C02861 implements OnClickListener {
        final /* synthetic */ PageYouMayLikeSmallFormatView f6409a;

        public C02861(PageYouMayLikeSmallFormatView pageYouMayLikeSmallFormatView) {
            this.f6409a = pageYouMayLikeSmallFormatView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1769449050);
            if (this.f6409a.f6408m != null) {
                this.f6409a.f6408m.onClick(this.f6409a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1948310570, a);
        }
    }

    public PageYouMayLikeSmallFormatView(Context context) {
        super(context);
        setContentView(2130906092);
        this.f6397b.setMovementMethod(LinkMovementMethod.getInstance());
        this.f6399d.setMovementMethod(LinkMovementMethod.getInstance());
        this.f6401f.setMovementMethod(LinkMovementMethod.getInstance());
        this.f6407l.setGlyphColor(getResources().getColorStateList(2131364107));
        this.f6407l.setOnClickListener(new C02861(this));
        this.f6405j.setHierarchy(new GenericDraweeHierarchyBuilder(getContext().getResources()).u());
    }

    public void setOnPageInfoClickedListener(OnClickListener onClickListener) {
        this.f6406k.setOnClickListener(onClickListener);
        this.f6405j.setOnClickListener(onClickListener);
        this.f6404i.setOnClickListener(onClickListener);
        this.f6402g.setOnClickListener(onClickListener);
    }

    public static void m6851a(TextView textView, CharSequence charSequence) {
        int i = (charSequence == null || charSequence.length() <= 0) ? 8 : 0;
        textView.setText(charSequence);
        textView.setVisibility(i);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -43213244);
        super.onAttachedToWindow();
        this.f6396a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1380232460, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -667387686);
        super.onDetachedFromWindow();
        this.f6396a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 252573505, a);
    }

    public final boolean mo569a() {
        return this.f6396a;
    }
}
