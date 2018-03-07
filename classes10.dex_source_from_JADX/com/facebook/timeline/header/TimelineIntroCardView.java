package com.facebook.timeline.header;

import android.content.Context;
import android.graphics.Canvas;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.contextual.TimelineContextualInfoAdapter;
import com.facebook.timeline.contextual.TimelineContextualInfoData;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.favphotos.TimelineHeaderFavoritePhotosView;
import com.facebook.timeline.header.favphotos.TimelineHeaderSuggestedPhotosBinder;
import com.facebook.timeline.header.favphotos.TimelineHeaderSuggestedPhotosView;
import com.facebook.timeline.header.ui.LoadMoreItemsView;
import com.facebook.timeline.header.ui.NuxBorderDrawingHelper;
import com.facebook.timeline.header.ui.TimelineIntroCardEmptySection;
import com.facebook.timeline.header.ui.ViewBorderDrawingHelper.BordersSpec;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.FavoritePhoto;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.SuggestedPhoto;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.LazyView;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: frame_ */
public class TimelineIntroCardView extends CustomLinearLayout {
    private static final BordersSpec f11506e = new BordersSpec(true, true, false, false);
    @Inject
    Provider<AllCapsTransformationMethod> f11507a;
    @Inject
    Lazy<TimelineHeaderSuggestedPhotosBinder> f11508b;
    @Inject
    Lazy<NuxBorderDrawingHelper> f11509c;
    @Inject
    QeAccessor f11510d;
    private boolean f11511f;
    public TimelineContextItemsSection f11512g;
    @Nullable
    private View f11513h;
    @Nullable
    private BetterTextView f11514i;
    private LazyView<View> f11515j;
    private LazyView<TimelineHeaderFavoritePhotosView> f11516k;
    private LazyView<TimelineHeaderSuggestedPhotosView> f11517l;
    public IntroCardBinder f11518m;

    private static <T extends View> void m11539a(Class<T> cls, T t) {
        m11540a((Object) t, t.getContext());
    }

    private static void m11540a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((TimelineIntroCardView) obj).m11541a(IdBasedProvider.a(fbInjector, 1281), IdBasedLazy.a(fbInjector, 11275), IdBasedSingletonScopeProvider.b(fbInjector, 11285), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    private void m11541a(Provider<AllCapsTransformationMethod> provider, Lazy<TimelineHeaderSuggestedPhotosBinder> lazy, Lazy<NuxBorderDrawingHelper> lazy2, QeAccessor qeAccessor) {
        this.f11507a = provider;
        this.f11508b = lazy;
        this.f11509c = lazy2;
        this.f11510d = qeAccessor;
    }

    public TimelineIntroCardView(Context context) {
        super(context);
        m11542k();
    }

    public TimelineIntroCardView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m11542k();
    }

    protected TimelineIntroCardView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11542k();
    }

    private void m11542k() {
        m11539a(TimelineIntroCardView.class, (View) this);
        setWillNotDraw(false);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1367009933);
        super.onFinishInflate();
        this.f11512g = (TimelineContextItemsSection) a(2131567953);
        this.f11515j = new LazyView((ViewStub) a(this.f11510d.a(ExperimentsForTimelineAbTestModule.am, false) ? 2131567955 : 2131567954));
        this.f11516k = new LazyView((ViewStub) a(2131567956));
        this.f11517l = new LazyView((ViewStub) a(2131567958));
        LogUtils.g(-1850624472, a);
    }

    public final void m11545a(TimelineContextualInfoAdapter timelineContextualInfoAdapter) {
        if (this.f11512g != null) {
            this.f11512g.setAdapter(timelineContextualInfoAdapter);
        }
    }

    public final void m11544a(OnClickListener onClickListener) {
        Preconditions.checkArgument(this.f11512g.getChildCount() == 0);
        if (this.f11513h == null) {
            this.f11513h = LayoutInflater.from(getContext()).inflate(this.f11510d.a(ExperimentsForTimelineAbTestModule.am, false) ? 2130907458 : 2130907457, this.f11512g, false);
            TimelineIntroCardEmptySection timelineIntroCardEmptySection = (TimelineIntroCardEmptySection) this.f11513h;
            timelineIntroCardEmptySection.setLabelText(getResources().getString(2131235024));
            timelineIntroCardEmptySection.setIcon(2130840032);
            this.f11513h.setOnClickListener(onClickListener);
        }
        this.f11512g.addView(this.f11513h);
        this.f11513h.setVisibility(0);
        this.f11512g.setVisibility(0);
    }

    public final void m11543a() {
        if (this.f11513h != null) {
            this.f11513h.setVisibility(8);
        }
    }

    public final void m11549b(OnClickListener onClickListener) {
        Preconditions.checkArgument(this.f11512g.getChildCount() > 0);
        Context context = getContext();
        if (this.f11514i == null) {
            this.f11514i = (BetterTextView) LayoutInflater.from(context).inflate(2130907473, this.f11512g, false);
            int dimension = (int) context.getResources().getDimension(2131429951);
            if (RTLUtil.a(context)) {
                this.f11514i.setPadding(this.f11514i.getPaddingLeft(), this.f11514i.getPaddingTop(), dimension, this.f11514i.getPaddingBottom());
            } else {
                this.f11514i.setPadding(dimension, this.f11514i.getPaddingTop(), this.f11514i.getPaddingRight(), this.f11514i.getPaddingBottom());
            }
            this.f11514i.setTransformationMethod((TransformationMethod) this.f11507a.get());
            this.f11514i.setOnClickListener(onClickListener);
        }
        this.f11512g.addView(this.f11514i);
        this.f11514i.setVisibility(0);
    }

    public final void m11548b() {
        if (this.f11514i != null) {
            this.f11514i.setVisibility(8);
        }
    }

    public final void m11550c() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131429941);
        this.f11512g.setPadding(this.f11512g.getPaddingLeft(), dimensionPixelSize, this.f11512g.getPaddingRight(), dimensionPixelSize);
    }

    public final boolean m11552d() {
        return this.f11512g.getChildCount() > 0;
    }

    public final boolean m11553e() {
        int childCount = this.f11512g.getChildCount() - 1;
        return childCount >= 0 && (this.f11512g.getChildAt(childCount) instanceof LoadMoreItemsView);
    }

    public final void m11547a(boolean z, boolean z2, ImmutableList<? extends FavoritePhoto> immutableList, OnClickListener onClickListener) {
        TimelineHeaderFavoritePhotosView timelineHeaderFavoritePhotosView = (TimelineHeaderFavoritePhotosView) this.f11516k.a();
        timelineHeaderFavoritePhotosView.m11823a();
        timelineHeaderFavoritePhotosView.setVisibility(0);
        timelineHeaderFavoritePhotosView.setEditClickListener(z ? onClickListener : null);
        if (z && z2) {
            timelineHeaderFavoritePhotosView.setMosaicEditFavPhotosClickListener(onClickListener);
        }
        timelineHeaderFavoritePhotosView.setEditable(z);
        timelineHeaderFavoritePhotosView.m11824a(immutableList);
    }

    public final void m11554f() {
        m11538a(this.f11516k);
    }

    public final void m11551c(OnClickListener onClickListener) {
        View a = this.f11515j.a();
        a.setVisibility(0);
        TimelineIntroCardEmptySection timelineIntroCardEmptySection = (TimelineIntroCardEmptySection) a;
        timelineIntroCardEmptySection.setLabelText(getResources().getString(2131235026));
        timelineIntroCardEmptySection.setIcon(2130840015);
        a.setOnClickListener(onClickListener);
    }

    public final void m11555g() {
        m11538a(this.f11515j);
    }

    public final void m11546a(ImmutableList<? extends SuggestedPhoto> immutableList, OnClickListener onClickListener, OnClickListener onClickListener2) {
        TimelineHeaderSuggestedPhotosView timelineHeaderSuggestedPhotosView = (TimelineHeaderSuggestedPhotosView) this.f11517l.a();
        timelineHeaderSuggestedPhotosView.setVisibility(0);
        ((TimelineHeaderSuggestedPhotosBinder) this.f11508b.get()).m11839a(timelineHeaderSuggestedPhotosView, (ImmutableList) immutableList, onClickListener, onClickListener2);
    }

    public final void m11556h() {
        m11538a(this.f11517l);
    }

    private static void m11538a(LazyView<? extends View> lazyView) {
        if (lazyView != null) {
            lazyView.c();
        }
    }

    public ViewGroup getPublicAboutItemsView() {
        return this.f11512g;
    }

    @Nullable
    public View getFavPhotosEmptyView() {
        return (this.f11515j == null || !this.f11515j.b()) ? null : this.f11515j.a();
    }

    @Nullable
    public View getFavPhotosView() {
        return (this.f11516k == null || !this.f11516k.b()) ? null : (TimelineHeaderFavoritePhotosView) this.f11516k.a();
    }

    @Nullable
    public TimelineHeaderSuggestedPhotosView getSuggestedPhotosView() {
        return (this.f11517l == null || !this.f11517l.b()) ? null : (TimelineHeaderSuggestedPhotosView) this.f11517l.a();
    }

    public final void m11557i() {
        this.f11511f = true;
        ((NuxBorderDrawingHelper) this.f11509c.get()).m12029a(this, f11506e);
        invalidate();
    }

    public final void m11558j() {
        this.f11511f = false;
        invalidate();
    }

    public void setIntroCardBinder(IntroCardBinder introCardBinder) {
        this.f11518m = introCardBinder;
    }

    @Nullable
    public TimelineContextualInfoData getAboutItemsData() {
        return this.f11518m == null ? null : this.f11518m.f11259u;
    }

    @Nullable
    public TimelineHeaderUserData getHeaderData() {
        return this.f11518m == null ? null : this.f11518m.f11252n;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f11511f) {
            ((NuxBorderDrawingHelper) this.f11509c.get()).m12028a(this, canvas, f11506e);
        }
    }
}
