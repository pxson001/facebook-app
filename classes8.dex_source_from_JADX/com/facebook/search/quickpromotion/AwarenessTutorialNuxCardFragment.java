package com.facebook.search.quickpromotion;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbAutoFitTextView;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TEXT_END_CREDITS_BAR */
public class AwarenessTutorialNuxCardFragment extends FbFragment {
    public static final CallerContext f22342b = CallerContext.a(SearchAwarenessImageFetcher.class, "search_awareness");
    @Inject
    public GlyphColorizer f22343a;
    public FbAutoFitTextView f22344c;
    public FbAutoFitTextView f22345d;
    public FbAutoFitTextView f22346e;
    public CustomLinearLayout f22347f;
    public FbDraweeView f22348g;
    public AwarenessTutorialNuxCardConfiguration f22349h;

    public static void m25846a(Object obj, Context context) {
        ((AwarenessTutorialNuxCardFragment) obj).f22343a = GlyphColorizer.a(FbInjector.get(context));
    }

    public final void m25849c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = AwarenessTutorialNuxCardFragment.class;
        m25846a(this, getContext());
    }

    public final View m25848a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1741603113);
        View inflate = layoutInflater.inflate(2130903328, viewGroup, false);
        this.f22344c = (FbAutoFitTextView) FindViewUtil.b(inflate, 2131559764);
        this.f22345d = (FbAutoFitTextView) FindViewUtil.b(inflate, 2131559765);
        this.f22346e = (FbAutoFitTextView) FindViewUtil.b(inflate, 2131559767);
        this.f22347f = (CustomLinearLayout) FindViewUtil.b(inflate, 2131559763);
        this.f22348g = (FbDraweeView) FindViewUtil.b(inflate, 2131559766);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2020397080, a);
        return inflate;
    }

    public final void m25847G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -470231502);
        super.G();
        if (this.s != null) {
            this.f22349h = (AwarenessTutorialNuxCardConfiguration) this.s.getParcelable("configuration");
            this.f22344c.setText(this.f22349h.f22337a);
            this.f22344c.setMinTextSizeSp(12.0f);
            this.f22345d.setText(this.f22349h.f22338b);
            this.f22345d.setMinTextSizeSp(12.0f);
            Drawable drawable = getContext().getResources().getDrawable(2130837742);
            if (VERSION.SDK_INT >= 16) {
                this.f22345d.setBackground(drawable);
            } else {
                this.f22345d.setBackgroundDrawable(drawable);
            }
            this.f22346e.setText(this.f22349h.f22340d);
            this.f22346e.setMinTextSizeSp(12.0f);
            drawable = new ColorDrawable(this.f22349h.f22341e);
            if (VERSION.SDK_INT >= 16) {
                this.f22347f.setBackground(drawable);
            } else {
                this.f22347f.setBackgroundDrawable(drawable);
            }
            this.f22348g.a(this.f22349h.f22339c, f22342b);
            ((GenericDraweeHierarchy) this.f22348g.getHierarchy()).a(ScaleTypeFitWidthAndCropBottom.f22351i);
            Drawable a2 = this.f22343a.a(2130839976, -1);
            if (a2 != null) {
                a2.setBounds(0, 0, a2.getIntrinsicWidth(), a2.getIntrinsicHeight());
                this.f22345d.setCompoundDrawables(a2, null, null, null);
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -316055778, a);
    }
}
