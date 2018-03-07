package com.facebook.richdocument.view.block.impl;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import android.widget.ImageView;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.inject.FbInjector;
import com.facebook.richdocument.event.RecyclerViewFocusCoordinator;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentMediaTransitionEventSubscriber;
import com.facebook.richdocument.event.RichDocumentEvents.RecyclerViewFocusRequest;
import com.facebook.richdocument.event.RichDocumentEvents.RecyclerViewFocusRequest.RequestType;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentMediaTransitionEvent;
import com.facebook.richdocument.ham.HamViewUtils;
import com.facebook.richdocument.logging.RichDocumentAnalyticsLogger;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocksImpl;
import com.facebook.richdocument.presenter.SlideshowBlockPresenter;
import com.facebook.richdocument.view.RichDocumentAdapter;
import com.facebook.richdocument.view.block.BlockViewUtil;
import com.facebook.richdocument.view.block.SlideshowBlockView;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.transition.MediaTransitionState.Orientation;
import com.facebook.richdocument.view.transition.MediaTransitionState.PresentationMode;
import com.facebook.richdocument.view.widget.SlideshowView;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.richdocument.view.widget.media.plugins.SlideshowArrowPlugin;
import com.facebook.richdocument.view.widget.media.plugins.SlideshowTouchHelperPlugin;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: page_clicked_item_id_extra */
public class SlideshowBlockViewImpl extends MediaBlockView<SlideshowBlockPresenter, SlideshowView> implements SlideshowBlockView {
    @Inject
    public RichDocumentEventBus f6800a;
    @Inject
    public HamViewUtils f6801b;
    @Inject
    public RichDocumentAnalyticsLogger f6802c;
    public MediaTransitionState f6803d;
    private String f6804j;
    public int f6805k;
    private final FbEventSubscriberListManager f6806l = new FbEventSubscriberListManager();
    private final RichDocumentMediaTransitionEventSubscriber f6807m = new C07631(this);

    /* compiled from: page_clicked_item_id_extra */
    class C07631 extends RichDocumentMediaTransitionEventSubscriber {
        final /* synthetic */ SlideshowBlockViewImpl f6797a;

        C07631(SlideshowBlockViewImpl slideshowBlockViewImpl) {
            this.f6797a = slideshowBlockViewImpl;
        }

        public final void m7090b(FbEvent fbEvent) {
            RichDocumentMediaTransitionEvent richDocumentMediaTransitionEvent = (RichDocumentMediaTransitionEvent) fbEvent;
            MediaTransitionState mediaTransitionState = richDocumentMediaTransitionEvent.f5177b;
            if (richDocumentMediaTransitionEvent.f5179d && !mediaTransitionState.equals(this.f6797a.f6803d)) {
                this.f6797a.f6803d = mediaTransitionState;
                if (this.f6797a.f6803d.f6981e == PresentationMode.COLLAPSED && this.f6797a.f6803d.f6982f == Orientation.PORTRAIT) {
                    this.f6797a.f6802c.m5364a("collapse", 0, this.f6797a.f6805k);
                } else {
                    this.f6797a.f6802c.m5364a("expand", 0, this.f6797a.f6805k);
                }
            }
        }
    }

    public static void m7092a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        SlideshowBlockViewImpl slideshowBlockViewImpl = (SlideshowBlockViewImpl) obj;
        RichDocumentEventBus a = RichDocumentEventBus.m5130a(fbInjector);
        HamViewUtils a2 = HamViewUtils.m5278a(fbInjector);
        RichDocumentAnalyticsLogger a3 = RichDocumentAnalyticsLogger.m5360a(fbInjector);
        slideshowBlockViewImpl.f6800a = a;
        slideshowBlockViewImpl.f6801b = a2;
        slideshowBlockViewImpl.f6802c = a3;
    }

    public SlideshowBlockViewImpl(MediaFrame mediaFrame, View view, ImageView imageView) {
        super(mediaFrame, view);
        Class cls = SlideshowBlockViewImpl.class;
        m7092a((Object) this, getContext());
        m7095a(mediaFrame);
        final SlideshowView slideshowView = (SlideshowView) m6992h();
        slideshowView.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ SlideshowBlockViewImpl f6799b;

            public final void m7091a(RecyclerView recyclerView, int i) {
                if (i == 1) {
                    this.f6799b.f6800a.a(new RecyclerViewFocusRequest(RequestType.UNSET_FOCUSED_VIEW, slideshowView, null));
                }
            }
        });
        this.f6806l.a(new RecyclerViewFocusCoordinator(slideshowView));
        this.f6806l.a(this.f6800a);
        this.f6801b.m5280a(imageView, 2131558715, 2131558716);
    }

    protected void m7095a(MediaFrame mediaFrame) {
        m6983a(new SlideshowArrowPlugin(mediaFrame));
        m6983a(new SlideshowTouchHelperPlugin(mediaFrame));
    }

    public final boolean mo377a(int i, int i2) {
        SlideshowView c = m7099c();
        int[] iArr = new int[2];
        c.getLocationOnScreen(iArr);
        if (i >= iArr[0] && i <= iArr[0] + c.getWidth() && i2 >= iArr[1]) {
            if (i2 <= c.getHeight() + iArr[1]) {
                return true;
            }
        }
        return false;
    }

    public void mo374a(Bundle bundle) {
        super.mo374a(bundle);
        m7099c().m7707o();
    }

    public final void mo378b(Bundle bundle) {
        this.f6800a.a(this.f6807m);
        Map hashMap = new HashMap();
        hashMap.put("block_media_type", "slideshow");
        hashMap.put("current_slide", Integer.valueOf(1));
        hashMap.put("total_slides", Integer.valueOf(this.f6805k));
        this.f6802c.m5366a(this.f6804j, hashMap);
    }

    public final void mo379c(Bundle bundle) {
        super.mo379c(bundle);
        this.f6800a.b(this.f6807m);
        m7099c().onDetachedFromWindow();
    }

    public final void mo404a(GraphQLDocumentMediaPresentationStyle graphQLDocumentMediaPresentationStyle, RichDocumentBlocksImpl richDocumentBlocksImpl) {
        this.f6805k = richDocumentBlocksImpl.m5459c();
        m6982a(BlockViewUtil.m6916a(graphQLDocumentMediaPresentationStyle));
        SlideshowView c = m7099c();
        c.f7497q = richDocumentBlocksImpl.m5459c();
        c.setAdapter(new RichDocumentAdapter(c.getContext(), richDocumentBlocksImpl, c.f7493m.m5228a(null), (BetterLinearLayoutManager) c.getLayoutManager(), c, null));
        c.f7494n.f7604b = SlideshowView.m7697a(richDocumentBlocksImpl);
        if (richDocumentBlocksImpl != null && richDocumentBlocksImpl.m5459c() <= 1) {
            m6987b(SlideshowArrowPlugin.class);
        }
    }

    public final void mo405a(String str) {
        this.f6804j = str;
    }

    public final SlideshowView m7099c() {
        return (SlideshowView) m6992h();
    }
}
