package com.facebook.feedplugins.pyml.rows.contentbased.ui;

import android.content.Context;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.util.TriState;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.annotations.IsFeedLikeIconGradientBackgroundEnabled;
import com.facebook.feed.widget.FeedbackCustomPressStateButton;
import com.facebook.feedplugins.pyml.annotations.IsPYMLVerificationEnabled;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import com.facebook.widget.springbutton.TouchSpring;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: notifications_disabled */
public abstract class ContentBasedPageYouMayLikeView extends PagerItemWrapperLayout implements RecyclableView {
    @Inject
    public Provider<TouchSpring> f6727a;
    @Inject
    @IsPYMLVerificationEnabled
    public Provider<TriState> f6728b;
    @IsFeedLikeIconGradientBackgroundEnabled
    @Inject
    public Boolean f6729c;
    public final TextView f6730d;
    public final FbDraweeView f6731e;
    public final FeedbackCustomPressStateButton f6732f;
    public final ImageView f6733g;
    public boolean f6734h;

    public static void m7114a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ContentBasedPageYouMayLikeView contentBasedPageYouMayLikeView = (ContentBasedPageYouMayLikeView) obj;
        Provider a = IdBasedProvider.a(fbInjector, 3736);
        Provider a2 = IdBasedProvider.a(fbInjector, 679);
        Boolean valueOf = Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(fbInjector).a(709, false));
        contentBasedPageYouMayLikeView.f6727a = a;
        contentBasedPageYouMayLikeView.f6728b = a2;
        contentBasedPageYouMayLikeView.f6729c = valueOf;
    }

    private ContentBasedPageYouMayLikeView(Context context) {
        super(context);
        Class cls = ContentBasedPageYouMayLikeView.class;
        m7114a(this, getContext());
        setContentView(2130903782);
        this.f6730d = (TextView) c(2131560747);
        this.f6731e = (FbDraweeView) c(2131560746);
        this.f6732f = (FeedbackCustomPressStateButton) c(2131560750);
        this.f6733g = (ImageView) c(2131560748);
        this.f6732f.setSpring((TouchSpring) this.f6727a.get());
        ((ImageView) c(2131560751)).setEnabled(true);
    }

    public ContentBasedPageYouMayLikeView(Context context, int i) {
        this(context);
        ViewStub viewStub = (ViewStub) c(2131560749);
        viewStub.setLayoutResource(i);
        viewStub.inflate();
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1342965082);
        super.onAttachedToWindow();
        this.f6734h = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1555439383, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -554759710);
        super.onDetachedFromWindow();
        this.f6734h = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -28915613, a);
    }

    public final boolean mo569a() {
        return this.f6734h;
    }

    public void setViewPageClickListener(@Nullable OnClickListener onClickListener) {
        this.f6730d.setOnClickListener(onClickListener);
        this.f6731e.setOnClickListener(onClickListener);
    }
}
