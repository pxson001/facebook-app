package com.facebook.richdocument.presenter;

import android.content.Context;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.richdocument.RichDocumentInfo;
import com.facebook.richdocument.model.block.VideoBlockInput;
import com.facebook.richdocument.model.data.PreloadableBlock;
import com.facebook.richdocument.model.data.VideoBlockData;
import com.facebook.richdocument.view.block.VideoBlockView;
import com.facebook.richdocument.view.block.impl.VideoBlockViewImpl;
import com.facebook.richdocument.view.performance.VideoParamsCreator;
import com.facebook.richdocument.view.recycler.RichDocumentLayoutManager.SingleBind;
import javax.inject.Inject;

/* compiled from: people_tagging_button */
public class VideoBlockPresenter extends AbstractBlockPresenter<VideoBlockView, VideoBlockData> implements SingleBind {
    @Inject
    public VideoParamsCreator f6447d;
    @Inject
    public Lazy<RichDocumentInfo> f6448e;

    public static void m6830a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        VideoBlockPresenter videoBlockPresenter = (VideoBlockPresenter) obj;
        VideoParamsCreator a = VideoParamsCreator.m7158a(injectorLike);
        Lazy a2 = IdBasedLazy.a(injectorLike, 10295);
        videoBlockPresenter.f6447d = a;
        videoBlockPresenter.f6448e = a2;
    }

    public VideoBlockPresenter(VideoBlockViewImpl videoBlockViewImpl) {
        super(videoBlockViewImpl);
        Class cls = VideoBlockPresenter.class;
        m6830a(this, getContext());
    }

    public void m6832a(VideoBlockData videoBlockData) {
        String b;
        ((VideoBlockViewImpl) this.f6382d).mo374a(PresenterUtils.m6822a(videoBlockData));
        VideoBlockViewImpl videoBlockViewImpl = (VideoBlockViewImpl) this.f6382d;
        String l = videoBlockData.mo271l();
        if (videoBlockData.mo305p() != null) {
            b = videoBlockData.mo305p().mo319b();
        } else {
            b = null;
        }
        videoBlockViewImpl.f6695K = b;
        videoBlockViewImpl.f6694J = l;
        if (videoBlockData.mo305p() != null) {
            VideoBlockInput a = this.f6447d.m7160a(videoBlockData);
            if (videoBlockData instanceof PreloadableBlock) {
                ((PreloadableBlock) videoBlockData).mo283a(false);
            }
            ((VideoBlockViewImpl) this.f6382d).m7037a(a, videoBlockData.mo271l());
            PresenterUtils.m6823a(this.f6382d, videoBlockData, ((RichDocumentInfo) this.f6448e.get()).f5119g, videoBlockData.iQ_());
        }
    }

    public final boolean mo369b() {
        return true;
    }

    public final boolean mo370c() {
        return true;
    }
}
