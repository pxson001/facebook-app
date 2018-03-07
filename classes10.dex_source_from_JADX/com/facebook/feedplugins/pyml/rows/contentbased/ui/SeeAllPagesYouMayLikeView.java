package com.facebook.feedplugins.pyml.rows.contentbased.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.facebook.feed.widget.FeedbackCustomPressStateButton;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import com.facebook.widget.springbutton.TouchSpring;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: android.hardware.action.NEW_PICTURE */
public class SeeAllPagesYouMayLikeView extends PagerItemWrapperLayout implements RecyclableView {
    @Inject
    public Provider<TouchSpring> f19887a;
    public boolean f19888b;
    private ImageButton f19889c;
    private FeedbackCustomPressStateButton f19890d;

    public static void m20095a(Object obj, Context context) {
        ((SeeAllPagesYouMayLikeView) obj).f19887a = IdBasedProvider.a(FbInjector.get(context), 3736);
    }

    public SeeAllPagesYouMayLikeView(Context context) {
        this(context, null);
    }

    private SeeAllPagesYouMayLikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Class cls = SeeAllPagesYouMayLikeView.class;
        m20095a(this, getContext());
        setContentView(2130903783);
        this.f19889c = (ImageButton) findViewById(2131560752);
        this.f19890d = (FeedbackCustomPressStateButton) findViewById(2131560753);
        this.f19890d.setSpring((TouchSpring) this.f19887a.get());
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -60408906);
        super.onAttachedToWindow();
        this.f19888b = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1908393771, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 450751514);
        super.onDetachedFromWindow();
        this.f19889c.setOnClickListener(null);
        this.f19888b = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2050783732, a);
    }

    public final boolean m20096a() {
        return this.f19888b;
    }
}
