package com.facebook.photos.pandora.ui;

import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.pandora.common.cache.PandoraStoryMemoryCache;
import com.facebook.photos.pandora.common.data.PandoraInstanceId;
import com.facebook.photos.pandora.common.futures.PandoraFuturesGenerator;
import com.facebook.photos.pandora.common.source.PandoraRequestSource;
import com.facebook.photos.pandora.common.ui.feedadapter.PandoraBasicFeedAdapter;
import com.facebook.photos.pandora.common.ui.renderer.PandoraRendererController;
import com.facebook.photos.pandora.common.ui.renderer.PandoraRendererResult;
import com.facebook.photos.pandora.common.ui.renderer.configs.PandoraRendererConfiguration;
import com.facebook.photos.pandora.common.ui.renderer.configs.PandoraRendererGridConfiguration;
import com.facebook.photos.pandora.common.ui.views.PandoraInlineVideoEnvironmentProvider;
import com.facebook.photos.pandora.logging.PandoraSequenceLogger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: com.facebook.feed.fragment.NewsFeedFragment */
public class PandoraTaggedPhotosAdapter extends PandoraBasicFeedAdapter {
    public Lazy<PandoraFuturesGenerator> f17729t;

    /* compiled from: com.facebook.feed.fragment.NewsFeedFragment */
    public class C18951 implements Callable<ListenableFuture> {
        final /* synthetic */ PandoraTaggedPhotosAdapter f17727a;

        public C18951(PandoraTaggedPhotosAdapter pandoraTaggedPhotosAdapter) {
            this.f17727a = pandoraTaggedPhotosAdapter;
        }

        public Object call() {
            String str;
            int i;
            if (!this.f17727a.f17461m) {
                str = null;
            } else if (this.f17727a.f17456h != null) {
                str = this.f17727a.f17456h.f17365d;
            } else {
                str = null;
            }
            PandoraFuturesGenerator pandoraFuturesGenerator = (PandoraFuturesGenerator) this.f17727a.f17729t.get();
            String str2 = this.f17727a.f17458j;
            PandoraInstanceId pandoraInstanceId = this.f17727a.f17460l;
            if (this.f17727a.m21431b()) {
                i = 30;
            } else {
                i = 12;
            }
            return pandoraFuturesGenerator.m21383a(str2, pandoraInstanceId, null, str, i, this.f17727a.m21436h());
        }
    }

    /* compiled from: com.facebook.feed.fragment.NewsFeedFragment */
    public class C18962 extends AbstractDisposableFutureCallback<OperationResult> {
        final /* synthetic */ PandoraTaggedPhotosAdapter f17728a;

        public C18962(PandoraTaggedPhotosAdapter pandoraTaggedPhotosAdapter) {
            this.f17728a = pandoraTaggedPhotosAdapter;
        }

        protected final void m21697a(Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (operationResult != null && operationResult.b) {
                PandoraRendererResult pandoraRendererResult = (PandoraRendererResult) operationResult.h();
                this.f17728a.f17465q.m21552a("LoadImageURLs", "ExtraLoadImageURLsSource", this.f17728a.f17462n);
                if (pandoraRendererResult != null) {
                    boolean z;
                    this.f17728a.f17457i.m21442a(pandoraRendererResult.f17472a);
                    PandoraBasicFeedAdapter pandoraBasicFeedAdapter = this.f17728a;
                    if (this.f17728a.f17456h == null || !this.f17728a.f17456h.f17364c) {
                        z = false;
                    } else {
                        z = true;
                    }
                    pandoraBasicFeedAdapter.f17461m = z;
                    if (this.f17728a.f17456h.f17363b != null && this.f17728a.f17456h.f17363b.size() >= 12 && this.f17728a.f17456h.f17363b.size() <= 12) {
                        this.f17728a.f17465q.m21551a("LoadScreenImages");
                    }
                    AdapterDetour.a(this.f17728a, -1917347732);
                }
            }
        }

        protected final void m21698a(Throwable th) {
            ((AbstractFbErrorReporter) this.f17728a.f17452d.get()).b("fetchTaggedMediaSet", th);
            AdapterDetour.a(this.f17728a, -729528594);
        }
    }

    public static PandoraTaggedPhotosAdapter m21699b(InjectorLike injectorLike) {
        return new PandoraTaggedPhotosAdapter(IdBasedLazy.a(injectorLike, 9373), IdBasedLazy.a(injectorLike, 3561), IdBasedSingletonScopeProvider.b(injectorLike, 9384), IdBasedLazy.a(injectorLike, 9385), String_LoggedInUserIdMethodAutoProvider.b(injectorLike), IdBasedLazy.a(injectorLike, 9376), IdBasedSingletonScopeProvider.b(injectorLike, 494), PandoraSequenceLogger.m21549a(injectorLike), (PandoraInlineVideoEnvironmentProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PandoraInlineVideoEnvironmentProvider.class));
    }

    @Inject
    public PandoraTaggedPhotosAdapter(Lazy<PandoraStoryMemoryCache> lazy, Lazy<TasksManager> lazy2, Lazy<PandoraRendererController> lazy3, Lazy<PandoraRendererGridConfiguration> lazy4, String str, Lazy<PandoraFuturesGenerator> lazy5, Lazy<FbErrorReporter> lazy6, PandoraSequenceLogger pandoraSequenceLogger, PandoraInlineVideoEnvironmentProvider pandoraInlineVideoEnvironmentProvider) {
        super(lazy, lazy2, lazy3, (PandoraRendererConfiguration) lazy4.get(), lazy6, str, pandoraSequenceLogger, pandoraInlineVideoEnvironmentProvider);
        this.f17729t = lazy5;
    }

    public final void mo1053a(String str, String str2, boolean z, boolean z2, boolean z3) {
        super.mo1053a(str, "LoadScreenImagesPhotosOf", z, z2, z3);
    }

    public final String mo1055e() {
        return StringFormatUtil.a("fetchTaggedMediaSet_%s", new Object[]{this.f17460l});
    }

    protected final boolean mo1057j() {
        return false;
    }

    protected final PandoraRequestSource mo1056f() {
        return PandoraRequestSource.TAGGED_MEDIA_SET;
    }

    public final void mo1054d() {
        if (this.f17461m) {
            if (this.f17456h == null) {
                m21428a(this.f17458j, this.f17460l, "LoadScreenImagesPhotosOf", this.f17463o, this.f17464p, this.f17466r);
            }
            this.f17465q.m21551a("LoadImageURLs");
            ((TasksManager) this.f17451c.get()).a(mo1055e(), new C18951(this), new C18962(this));
        }
    }

    protected final boolean mo1058m() {
        return this.f17461m;
    }
}
