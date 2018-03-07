package com.facebook.feedplugins.topiccustomizationstory.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.GradientDrawable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;

/* compiled from: android.intent.action.PROXY_CHANGE */
public class TopicCustomizationStoryCardView extends PagerItemWrapperLayout implements RecyclableView {
    public static final CallerContext f9984a = CallerContext.a(TopicCustomizationStoryCardView.class);
    public boolean f9985b;
    public FbDraweeView f9986c = ((FbDraweeView) c(2131568070));
    public GlyphView f9987d = ((GlyphView) c(2131568071));
    public FbTextView f9988e = ((FbTextView) c(2131568072));

    public TopicCustomizationStoryCardView(Context context) {
        super(context);
        setContentView(2130907525);
    }

    public final void m10348a(Boolean bool, String str) {
        if (bool.booleanValue()) {
            this.f9987d.setImageResource(2130839776);
        } else {
            this.f9987d.setImageResource(2130840034);
        }
        m10347a((GradientDrawable) this.f9987d.getBackground(), str);
    }

    public final void m10349a(String str, String str2) {
        this.f9988e.setText(str);
        m10347a((GradientDrawable) this.f9988e.getBackground(), str2);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 184301847);
        super.onAttachedToWindow();
        this.f9985b = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1768400031, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 814443016);
        super.onDetachedFromWindow();
        this.f9985b = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1822930218, a);
    }

    public final boolean m10350a() {
        return this.f9985b;
    }

    private void m10347a(GradientDrawable gradientDrawable, String str) {
        gradientDrawable.setColor(Color.parseColor("#" + str));
        gradientDrawable.setColorFilter(getResources().getColor(2131361843), Mode.SRC_ATOP);
    }
}
