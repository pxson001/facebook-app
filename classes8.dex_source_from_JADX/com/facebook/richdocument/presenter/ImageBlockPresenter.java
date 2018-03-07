package com.facebook.richdocument.presenter;

import android.content.Context;
import android.os.Bundle;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.richdocument.RichDocumentInfo;
import com.facebook.richdocument.logging.RichDocumentAnalyticsLogger;
import com.facebook.richdocument.model.data.ImageBlockData;
import com.facebook.richdocument.presenter.AbstractBlockPresenter.RunOnStartUpTasksCompletedSubscriber;
import com.facebook.richdocument.view.block.ImageBlockView;
import com.facebook.richdocument.view.block.impl.ImageBlockViewImpl;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.inject.Inject;

/* compiled from: photo/{#%s}/?set={%s} */
public class ImageBlockPresenter extends AbstractBlockPresenter<ImageBlockView, ImageBlockData> {
    protected FBFullImageFragmentModel f6405d;
    @Inject
    public RichDocumentAnalyticsLogger f6406e;
    @Inject
    public Lazy<RichDocumentInfo> f6407f;
    private String f6408g;
    private String f6409h;

    public static void m6793a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ImageBlockPresenter imageBlockPresenter = (ImageBlockPresenter) obj;
        RichDocumentAnalyticsLogger a = RichDocumentAnalyticsLogger.m5360a(fbInjector);
        Lazy a2 = IdBasedLazy.a(fbInjector, 10295);
        imageBlockPresenter.f6406e = a;
        imageBlockPresenter.f6407f = a2;
    }

    public ImageBlockPresenter(ImageBlockViewImpl imageBlockViewImpl) {
        super(imageBlockViewImpl);
        Class cls = ImageBlockPresenter.class;
        m6793a(this, getContext());
    }

    public void m6796a(final ImageBlockData imageBlockData) {
        int i = 0;
        String str = null;
        TracerDetour.a("ImageBlockPresenter.bind", -1605120097);
        ((ImageBlockViewImpl) this.f6382d).mo374a(PresenterUtils.m6822a(imageBlockData));
        if (imageBlockData.mo289a() != null) {
            this.f6408g = imageBlockData.mo271l();
            this.f6409h = imageBlockData.mo289a().mo315b();
        } else {
            this.f6408g = null;
            this.f6409h = null;
        }
        if (imageBlockData.mo289a() != null) {
            int bD_;
            TracerDetour.a("ImageBlockPresenter.bind#getImgFromSection", -1511055752);
            String hS_ = imageBlockData.mo289a().hS_();
            this.f6405d = imageBlockData.mo289a().mo316c();
            FBFullImageFragmentModel d = imageBlockData.mo289a().mo317d();
            if (d != null) {
                str = d.d();
                bD_ = d.bD_();
                i = d.a();
            } else {
                bD_ = 0;
            }
            GraphQLDocumentMediaPresentationStyle m = imageBlockData.mo293m();
            TracerDetour.a(1894482679);
            if (this.f6405d != null) {
                TracerDetour.a("ImageBlockPresenter.bind#setImage", 424959809);
                ((ImageBlockViewImpl) this.f6382d).m6999a(hS_, this.f6405d.bD_(), this.f6405d.a());
                ((ImageBlockViewImpl) this.f6382d).m7000a(imageBlockData.mo289a().mo315b(), this.f6405d.d(), this.f6405d.bD_(), this.f6405d.a(), str, bD_, i, m, imageBlockData.mo271l());
                TracerDetour.a(1356400724);
            }
            Runnable c07251 = new Runnable(this) {
                final /* synthetic */ ImageBlockPresenter f6404b;

                public void run() {
                    PresenterUtils.m6823a(this.f6404b.f6382d, imageBlockData, ((RichDocumentInfo) this.f6404b.f6407f.get()).f5119g, imageBlockData.iQ_());
                }
            };
            if (!imageBlockData.iR_()) {
                c07251.run();
            } else if (this.f6381c.m5152b()) {
                c07251.run();
            } else {
                RunOnStartUpTasksCompletedSubscriber runOnStartUpTasksCompletedSubscriber = new RunOnStartUpTasksCompletedSubscriber(this, c07251);
                this.f6384f.add(runOnStartUpTasksCompletedSubscriber);
                this.f6379a.a(runOnStartUpTasksCompletedSubscriber);
            }
        }
        TracerDetour.a(-1042257942);
    }

    public void mo367a(Bundle bundle) {
        super.mo367a(bundle);
        this.f6406e.m5365a(this.f6408g, this.f6409h);
    }
}
