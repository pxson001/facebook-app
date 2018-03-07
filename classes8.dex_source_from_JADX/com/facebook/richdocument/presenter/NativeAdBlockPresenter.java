package com.facebook.richdocument.presenter;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.SizeUtil;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLDocumentNativeAdType;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.querybuilder.common.ScaleInputPixelRatio;
import com.facebook.inject.FbInjector;
import com.facebook.richdocument.fetcher.NativeAdFetcher;
import com.facebook.richdocument.fetcher.NativeAdFetcher.C06871;
import com.facebook.richdocument.model.block.VideoBlockInput;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.NativeAdBlockData;
import com.facebook.richdocument.model.data.impl.NativeAdBlockDataImpl;
import com.facebook.richdocument.model.graphql.RichDocumentNativeAdsGraphql.RichDocumentNativeAdQueryString;
import com.facebook.richdocument.model.graphql.RichDocumentNativeAdsGraphqlModels.RichDocumentNativeAdFragmentModel.NativeTypedAdObjectModel;
import com.facebook.richdocument.view.autoplay.VideoAutoPlayPolicy;
import com.facebook.richdocument.view.block.VideoBlockView;
import com.facebook.richdocument.view.block.impl.NativeAdBlockViewImpl;
import com.facebook.richdocument.view.block.impl.VideoBlockViewImpl;
import com.facebook.richdocument.view.recycler.RichDocumentLayoutManager.SingleBind;
import com.facebook.richdocument.view.transition.TransitionStrategyFactory.StrategyType;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.server.VideoServer;
import com.facebook.video.server.VideoServerMethodAutoProvider;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: person_card */
public class NativeAdBlockPresenter extends AbstractBlockPresenter<VideoBlockView, NativeAdBlockData> implements SingleBind {
    @Inject
    NativeAdFetcher f6429d;
    @Inject
    public VideoServer f6430e;
    @Inject
    public VideoAutoPlayPolicy f6431f;
    @Inject
    public AbstractFbErrorReporter f6432g;
    @Inject
    public GatekeeperStoreImpl f6433h;
    public NativeAdBlockViewImpl f6434i;

    /* compiled from: person_card */
    class C07311 implements FutureCallback<NativeTypedAdObjectModel> {
        final /* synthetic */ NativeAdBlockPresenter f6428a;

        C07311(NativeAdBlockPresenter nativeAdBlockPresenter) {
            this.f6428a = nativeAdBlockPresenter;
        }

        public void onSuccess(@Nullable Object obj) {
            final NativeTypedAdObjectModel nativeTypedAdObjectModel = (NativeTypedAdObjectModel) obj;
            HandlerDetour.a(new Handler(Looper.getMainLooper()), new Runnable(this) {
                final /* synthetic */ C07311 f6427b;

                public void run() {
                    this.f6427b.f6428a.f6434i.m7076u();
                    NativeAdBlockPresenter nativeAdBlockPresenter = this.f6427b.f6428a;
                    NativeTypedAdObjectModel nativeTypedAdObjectModel = nativeTypedAdObjectModel;
                    if (nativeTypedAdObjectModel != null) {
                        nativeAdBlockPresenter.f6434i.m7078w();
                        nativeAdBlockPresenter.f6434i.m7069l();
                        nativeAdBlockPresenter.f6434i.f6742X = nativeTypedAdObjectModel.m6748o();
                        if (nativeAdBlockPresenter.f6434i.m7071n()) {
                            nativeAdBlockPresenter.f6434i.m7070m();
                        }
                        if (!NativeAdBlockPresenter.m6815a(nativeTypedAdObjectModel.m6749p())) {
                            FBFullImageFragmentModel n = nativeTypedAdObjectModel.m6747n();
                            if (n != null) {
                                nativeAdBlockPresenter.f6434i.m7064d(n.d());
                            }
                        } else if (NativeAdBlockPresenter.m6815a(nativeTypedAdObjectModel.m6749p())) {
                            nativeAdBlockPresenter.f6434i.m7056a(VideoBlockInput.m5451a(nativeTypedAdObjectModel.m6753t(), nativeTypedAdObjectModel.m6752s(), nativeTypedAdObjectModel.m6754u(), nativeTypedAdObjectModel.m6755v(), nativeTypedAdObjectModel.m6756w(), nativeAdBlockPresenter.f6430e, nativeAdBlockPresenter.f6431f, nativeAdBlockPresenter.f6432g, nativeAdBlockPresenter.f6433h.a(97, false)));
                            if (nativeAdBlockPresenter.f6434i.m7071n()) {
                                nativeAdBlockPresenter.f6434i.m7072o();
                                VideoBlockViewImpl videoBlockViewImpl = nativeAdBlockPresenter.f6434i;
                                if (videoBlockViewImpl.aa != null) {
                                    videoBlockViewImpl.mo402f(videoBlockViewImpl.aa);
                                }
                            }
                        }
                        nativeAdBlockPresenter.f6434i.m7058a(nativeTypedAdObjectModel.m6751r());
                        nativeAdBlockPresenter.f6434i.m7061b(nativeTypedAdObjectModel.m6750q(), nativeTypedAdObjectModel.m6743j());
                        nativeAdBlockPresenter.f6434i.m7060b(nativeTypedAdObjectModel.m6744k());
                        nativeAdBlockPresenter.f6434i.ad = nativeTypedAdObjectModel.m6742a();
                        nativeAdBlockPresenter.f6434i.m7063c(nativeTypedAdObjectModel.m6746m(), nativeTypedAdObjectModel.m6745l());
                        return;
                    }
                    nativeAdBlockPresenter.f6434i.m7081z();
                }
            }, -133601923);
        }

        public void onFailure(Throwable th) {
        }
    }

    public static void m6813a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((NativeAdBlockPresenter) obj).m6812a(NativeAdFetcher.m5165a(fbInjector), VideoServerMethodAutoProvider.a(fbInjector), VideoAutoPlayPolicy.m6889a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), GatekeeperStoreImplMethodAutoProvider.a(fbInjector));
    }

    public final void mo366a(BlockData blockData) {
        NativeAdBlockDataImpl nativeAdBlockDataImpl = (NativeAdBlockDataImpl) blockData;
        this.f6434i = (NativeAdBlockViewImpl) this.f6382d;
        Bundle bundle = new Bundle();
        bundle.putString("strategyType", StrategyType.NATIVE_ADS_ASPECT_FIT_ONLY.name());
        this.f6434i.mo374a(bundle);
        this.f6434i.m7068k();
        this.f6434i.ac = nativeAdBlockDataImpl.mo271l();
        NativeAdBlockViewImpl nativeAdBlockViewImpl = this.f6434i;
        nativeAdBlockViewImpl.f6753n.m5359a(nativeAdBlockViewImpl.ac);
        m6814a(nativeAdBlockDataImpl.mo271l());
    }

    public NativeAdBlockPresenter(VideoBlockViewImpl videoBlockViewImpl) {
        super(videoBlockViewImpl);
        Class cls = NativeAdBlockPresenter.class;
        m6813a(this, getContext());
    }

    private void m6814a(String str) {
        this.f6434i.m7075t();
        NativeAdFetcher nativeAdFetcher = this.f6429d;
        Context context = getContext();
        Futures.a(Futures.a(nativeAdFetcher.f5227a.a(GraphQLRequest.a((RichDocumentNativeAdQueryString) new RichDocumentNativeAdQueryString().a("adID", str).a("imageWidth", Integer.valueOf(this.f6434i.m7073q())).a("imageHeight", Integer.valueOf(this.f6434i.m7074r())).a("adChoicesIconWidth", Integer.valueOf(SizeUtil.a(context, 8.0f))).a("adChoicesIconHeight", Integer.valueOf(SizeUtil.a(context, 8.0f))).a("scale", ScaleInputPixelRatio.NUMBER_1))), new C06871(nativeAdFetcher), MoreExecutors.a()), new C07311(this), MoreExecutors.a());
    }

    public final boolean mo369b() {
        return true;
    }

    public final boolean mo370c() {
        return true;
    }

    public static boolean m6815a(GraphQLDocumentNativeAdType graphQLDocumentNativeAdType) {
        return graphQLDocumentNativeAdType == GraphQLDocumentNativeAdType.VIDEO || graphQLDocumentNativeAdType == GraphQLDocumentNativeAdType.APP_VIDEO || graphQLDocumentNativeAdType == GraphQLDocumentNativeAdType.LINK_VIDEO;
    }

    private void m6812a(NativeAdFetcher nativeAdFetcher, VideoServer videoServer, VideoAutoPlayPolicy videoAutoPlayPolicy, AbstractFbErrorReporter abstractFbErrorReporter, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f6429d = nativeAdFetcher;
        this.f6430e = videoServer;
        this.f6431f = videoAutoPlayPolicy;
        this.f6432g = abstractFbErrorReporter;
        this.f6433h = gatekeeperStoreImpl;
    }
}
