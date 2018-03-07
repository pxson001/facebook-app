package com.facebook.timeline.header;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.header.bio.TimelineHeaderBioView;
import com.facebook.timeline.header.bio.TimelineHeaderSuggestedBioBinder;
import com.facebook.timeline.header.bio.TimelineHeaderSuggestedBioView;
import com.facebook.timeline.header.ui.NuxBorderDrawingHelper;
import com.facebook.timeline.header.ui.TimelineIntroCardEmptySection;
import com.facebook.timeline.header.ui.ViewBorderDrawingHelper.BordersSpec;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.LazyView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: free_call_button */
public class TimelineIntroCardBioView extends CustomFrameLayout {
    private static final BordersSpec f11475d = new BordersSpec(true, true, false, false);
    @Inject
    Lazy<TimelineHeaderSuggestedBioBinder> f11476a;
    @Inject
    Lazy<NuxBorderDrawingHelper> f11477b;
    @Inject
    QeAccessor f11478c;
    private LazyView<TimelineHeaderBioView> f11479e;
    private LazyView<TimelineHeaderSuggestedBioView> f11480f;
    private LazyView<View> f11481g;
    private boolean f11482h;

    private static <T extends View> void m11513a(Class<T> cls, T t) {
        m11514a((Object) t, t.getContext());
    }

    private static void m11514a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((TimelineIntroCardBioView) obj).m11511a(IdBasedLazy.a(fbInjector, 11259), IdBasedSingletonScopeProvider.b(fbInjector, 11285), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    private void m11511a(Lazy<TimelineHeaderSuggestedBioBinder> lazy, Lazy<NuxBorderDrawingHelper> lazy2, QeAccessor qeAccessor) {
        this.f11476a = lazy;
        this.f11477b = lazy2;
        this.f11478c = qeAccessor;
    }

    public TimelineIntroCardBioView(Context context) {
        super(context);
        m11515h();
    }

    public TimelineIntroCardBioView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m11515h();
    }

    public TimelineIntroCardBioView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11515h();
    }

    private void m11515h() {
        m11513a(TimelineIntroCardBioView.class, (View) this);
        setWillNotDraw(false);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 994282793);
        super.onFinishInflate();
        this.f11479e = new LazyView((ViewStub) c(2131567963));
        this.f11480f = new LazyView((ViewStub) c(2131567964));
        this.f11481g = new LazyView((ViewStub) c(this.f11478c.a(ExperimentsForTimelineAbTestModule.am, false) ? 2131567962 : 2131567961));
        LogUtils.g(-915390959, a);
    }

    public final void m11519a(CharSequence charSequence, boolean z, OnClickListener onClickListener, boolean z2) {
        ((TimelineHeaderBioView) this.f11479e.a()).m11616a(charSequence, z, z2);
        TimelineHeaderBioView timelineHeaderBioView = (TimelineHeaderBioView) this.f11479e.a();
        if (!z) {
            onClickListener = null;
        }
        timelineHeaderBioView.setOnClickListener(onClickListener);
        ((TimelineHeaderBioView) this.f11479e.a()).setVisibility(0);
    }

    public final void m11516a() {
        m11512a(this.f11479e);
    }

    public final void m11518a(CharSequence charSequence, OnClickListener onClickListener, OnClickListener onClickListener2) {
        ((TimelineHeaderSuggestedBioView) this.f11480f.a()).setVisibility(0);
        ((TimelineHeaderSuggestedBioBinder) this.f11476a.get()).m11624a((TimelineHeaderSuggestedBioView) this.f11480f.a(), charSequence, onClickListener, onClickListener2);
    }

    public final void m11520b() {
        m11512a(this.f11480f);
    }

    public final void m11517a(OnClickListener onClickListener) {
        TimelineIntroCardEmptySection timelineIntroCardEmptySection = (TimelineIntroCardEmptySection) this.f11481g.a();
        timelineIntroCardEmptySection.setLabelText(getResources().getString(2131235020));
        timelineIntroCardEmptySection.setIcon(2130839836);
        this.f11481g.a().setOnClickListener(onClickListener);
        this.f11481g.a().setVisibility(0);
    }

    public final void m11521e() {
        this.f11482h = true;
        ((NuxBorderDrawingHelper) this.f11477b.get()).m12029a(this, f11475d);
        invalidate();
    }

    public final void m11522f() {
        this.f11482h = false;
        invalidate();
    }

    public final void m11523g() {
        m11512a(this.f11481g);
    }

    private static void m11512a(LazyView<? extends View> lazyView) {
        if (lazyView != null) {
            lazyView.c();
        }
    }

    @Nullable
    public View getBioViewForLogging() {
        return (this.f11479e == null || !this.f11479e.b()) ? null : (TimelineHeaderBioView) this.f11479e.a();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f11482h) {
            ((NuxBorderDrawingHelper) this.f11477b.get()).m12028a(this, canvas, f11475d);
        }
    }
}
