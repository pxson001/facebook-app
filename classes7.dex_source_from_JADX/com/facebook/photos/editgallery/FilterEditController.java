package com.facebook.photos.editgallery;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.view.View;
import android.view.ViewStub;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.Assisted;
import com.facebook.ipc.editgallery.EditFeature;
import com.facebook.photos.creativeediting.abtest.ExperimentsForCreativeEditingAbtestModule;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger;
import com.facebook.photos.creativeediting.model.CreativeEditingData.Builder;
import com.facebook.photos.creativeediting.model.SwipeableParams;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsHelper;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableController;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableLayout;
import com.facebook.photos.creativeediting.utilities.SpringAlphaAnimator;
import com.facebook.photos.editgallery.EditFeatureController.UriRequestType;
import com.facebook.photos.editgallery.EditGalleryFragmentController.C08673;
import com.facebook.photos.editgallery.EditGalleryFragmentController.State;
import com.facebook.photos.editgallery.EditGalleryFragmentManager.UsageParams;
import com.facebook.qe.api.QeAccessor;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.HScrollDividerDecorator;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: left item's drawable hierarchy was not properly set up */
public class FilterEditController implements EditFeatureController {
    public final Context f10368a;
    private final EditableOverlayContainerView f10369b;
    public final C08673 f10370c;
    private final ViewStub f10371d;
    public final FbTextView f10372e;
    private final FilterPickerScrollAdapterProvider f10373f;
    private final Provider<SpringAlphaAnimator> f10374g;
    private final QeAccessor f10375h;
    private final SpringAlphaAnimator f10376i;
    private final Uri f10377j;
    private final View f10378k = this.f10379l.findViewById(2131559198);
    private final View f10379l;
    private final View f10380m;
    public BetterRecyclerView f10381n;
    public FilterPickerScrollAdapter f10382o;
    private boolean f10383p;
    private boolean f10384q;
    private CreativeEditingSwipeableLayout f10385r;
    private Optional<CreativeEditingLogger> f10386s;
    public State f10387t;

    @Inject
    public FilterEditController(@Assisted ViewStub viewStub, @Assisted CreativeEditingSwipeableLayout creativeEditingSwipeableLayout, @Assisted EditableOverlayContainerView editableOverlayContainerView, @Assisted EditGallerySwipeableLayoutController editGallerySwipeableLayoutController, @Assisted Optional<CreativeEditingLogger> optional, @Assisted Uri uri, @Assisted View view, Context context, FilterPickerScrollAdapterProvider filterPickerScrollAdapterProvider, Provider<SpringAlphaAnimator> provider, QeAccessor qeAccessor) {
        this.f10379l = (View) Preconditions.checkNotNull(view);
        this.f10368a = context;
        this.f10386s = (Optional) Preconditions.checkNotNull(optional);
        this.f10371d = (ViewStub) Preconditions.checkNotNull(viewStub);
        this.f10373f = filterPickerScrollAdapterProvider;
        this.f10372e = (FbTextView) FindViewUtil.b(this.f10379l, 2131559197);
        this.f10369b = editableOverlayContainerView;
        this.f10377j = (Uri) Preconditions.checkNotNull(uri);
        this.f10375h = qeAccessor;
        this.f10380m = this.f10379l.findViewById(2131559199);
        this.f10374g = provider;
        this.f10376i = (SpringAlphaAnimator) this.f10374g.get();
        this.f10385r = (CreativeEditingSwipeableLayout) Preconditions.checkNotNull(creativeEditingSwipeableLayout);
        this.f10370c = (C08673) Preconditions.checkNotNull(editGallerySwipeableLayoutController);
        m12237r();
    }

    public final void mo561a(State state) {
        Preconditions.checkNotNull(state.f10290k);
        this.f10387t = state;
        this.f10383p = true;
        this.f10385r.setVisibility(0);
        this.f10369b.f9662k = false;
        m12238s();
        m12240u();
    }

    public final void mo564b() {
        if (this.f10383p) {
            this.f10383p = false;
            this.f10369b.f9662k = true;
            this.f10379l.setVisibility(4);
            m12239t();
        }
    }

    public final void mo569g() {
    }

    public final void mo565c() {
    }

    public final Object mo572j() {
        return EditFeature.FILTER;
    }

    public final String mo559a() {
        return this.f10368a.getResources().getString(2131237788);
    }

    public final UriRequestType mo573k() {
        return UriRequestType.SHOW_EDITED_URI;
    }

    public final void mo560a(Rect rect) {
    }

    public final void mo570h() {
        if (this.f10369b.getVisibility() != 0) {
            this.f10369b.setAlpha(0.0f);
            this.f10369b.setVisibility(0);
            this.f10376i.a();
            this.f10376i.a(this.f10369b, 1);
        }
        m12235o();
    }

    private void m12235o() {
        if (!m12236q()) {
            this.f10372e.setText(this.f10368a.getString(2131237802));
            this.f10372e.setTextColor(this.f10368a.getResources().getColor(2131362927));
            this.f10372e.setContentDescription(this.f10368a.getString(2131237802));
            this.f10372e.setVisibility(0);
            this.f10372e.setClickable(false);
        }
        if (this.f10382o != null) {
            SwipeableParams swipeableParams;
            CreativeEditingSwipeableController a = this.f10370c.m12157a();
            if (a.m11789k()) {
                swipeableParams = a.f9804G;
            } else {
                swipeableParams = null;
            }
            SwipeableParams swipeableParams2 = swipeableParams;
            if (swipeableParams2 != null) {
                int indexOf = this.f10387t.f10295p.indexOf(swipeableParams2);
                int size = this.f10387t.f10295p.size();
                this.f10382o.f10411m = indexOf;
                BetterRecyclerView betterRecyclerView = this.f10381n;
                if (indexOf != size - 1) {
                    indexOf = indexOf == size + -2 ? indexOf + 1 : indexOf + 2;
                }
                betterRecyclerView.a(indexOf);
            }
        }
        this.f10380m.setVisibility(8);
        this.f10378k.setVisibility(8);
        this.f10379l.setVisibility(0);
    }

    public final void mo571i() {
        this.f10369b.setVisibility(4);
        this.f10379l.setVisibility(4);
    }

    public final void mo562a(UsageParams usageParams) {
        usageParams.f10350e++;
    }

    public final boolean mo574l() {
        boolean z;
        if (this.f10387t.f10290k.a().equals(this.f10370c.m12157a().m11786g())) {
            z = false;
        } else {
            z = true;
        }
        this.f10384q = z;
        return this.f10384q;
    }

    public final State mo575m() {
        State state = this.f10387t;
        Builder builder = new Builder(this.f10387t.f10290k);
        builder.a = this.f10370c.m12157a().m11786g();
        builder = builder;
        builder.j = this.f10370c.m12157a().m11787i();
        state.f10290k = builder.a();
        return this.f10387t;
    }

    public final boolean mo566d() {
        return false;
    }

    public final boolean mo567e() {
        return false;
    }

    public final void mo568f() {
    }

    public final void mo563a(boolean z) {
        if (this.f10386s.isPresent()) {
            String g;
            CreativeEditingLogger creativeEditingLogger = (CreativeEditingLogger) this.f10386s.get();
            int i = this.f10370c.f10273a.f10318U;
            if (this.f10370c.m12157a().m11786g() != null) {
                g = this.f10370c.m12157a().m11786g();
            } else {
                g = "";
            }
            creativeEditingLogger.m11471a(i, g, z);
        }
    }

    private boolean m12236q() {
        return this.f10375h.a(ExperimentsForCreativeEditingAbtestModule.b, false);
    }

    private void m12237r() {
        if (m12236q()) {
            this.f10370c.m12157a().m11780b();
            this.f10381n = (BetterRecyclerView) this.f10371d.inflate();
            this.f10381n.setLayoutManager(new BetterLinearLayoutManager(this.f10368a, 0, false));
            this.f10381n.a(new HScrollDividerDecorator(this.f10368a.getResources().getColor(2131361871), this.f10368a.getResources().getDimensionPixelSize(2131427421)));
        }
    }

    private void m12238s() {
        if (m12236q()) {
            this.f10381n.setVisibility(0);
        }
    }

    private void m12239t() {
        if (m12236q()) {
            this.f10381n.setVisibility(4);
        }
    }

    private void m12240u() {
        if (m12236q()) {
            FilterPickerScrollAdapterProvider filterPickerScrollAdapterProvider = this.f10373f;
            Context context = this.f10368a;
            Uri uri = this.f10377j;
            State state = this.f10387t;
            this.f10382o = new FilterPickerScrollAdapter(context, uri, state, this.f10370c, FbDraweeControllerBuilder.b(filterPickerScrollAdapterProvider), (PostprocessorFactoryProvider) filterPickerScrollAdapterProvider.getOnDemandAssistedProviderForStaticDi(PostprocessorFactoryProvider.class), SwipeableParamsHelper.m11713b(filterPickerScrollAdapterProvider));
            this.f10381n.setAdapter(this.f10382o);
        }
    }
}
