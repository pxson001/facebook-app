package com.facebook.richdocument.presenter;

import android.content.Context;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.richdocument.RichDocumentInfo;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.SlideshowBlockData;
import com.facebook.richdocument.view.block.SlideshowBlockView;
import javax.inject.Inject;

/* compiled from: people_tagging_metadata */
public class SlideshowBlockPresenter extends AbstractBlockPresenter<SlideshowBlockView, SlideshowBlockData> {
    @Inject
    public Lazy<RichDocumentInfo> f6446d;

    public static void m6828a(Object obj, Context context) {
        ((SlideshowBlockPresenter) obj).f6446d = IdBasedLazy.a(FbInjector.get(context), 10295);
    }

    public final void mo366a(BlockData blockData) {
        SlideshowBlockData slideshowBlockData = (SlideshowBlockData) blockData;
        ((SlideshowBlockView) this.f6382d).mo374a(PresenterUtils.m6822a(slideshowBlockData));
        ((SlideshowBlockView) this.f6382d).mo404a(slideshowBlockData.mo293m(), slideshowBlockData.mo304a());
        ((SlideshowBlockView) this.f6382d).mo405a(slideshowBlockData.mo271l());
        PresenterUtils.m6823a(this.f6382d, slideshowBlockData, ((RichDocumentInfo) this.f6446d.get()).f5119g, slideshowBlockData.iQ_());
    }

    public SlideshowBlockPresenter(SlideshowBlockView slideshowBlockView) {
        super(slideshowBlockView);
        Class cls = SlideshowBlockPresenter.class;
        m6828a(this, getContext());
    }
}
