package com.facebook.photos.pandora.ui;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.photos.pandora.common.cache.PandoraStoryMemoryCache;
import com.facebook.photos.pandora.common.cache.PandoraStoryMemoryCache.MemoryCacheEntryKey;
import com.facebook.photos.pandora.common.data.PandoraInstanceId;
import com.facebook.photos.pandora.common.futures.PandoraFuturesGenerator;
import com.facebook.photos.pandora.common.futures.photocollage.PandoraPhotoCollageFetchPhotosFutureGenerator;
import com.facebook.photos.pandora.common.source.PandoraRequestSource;
import com.facebook.photos.pandora.common.ui.feedadapter.PandoraBasicFeedAdapter;
import com.facebook.photos.pandora.common.ui.renderer.PandoraRendererController;
import com.facebook.photos.pandora.common.ui.renderer.PandoraRendererResult;
import com.facebook.photos.pandora.common.ui.renderer.configs.PandoraRendererConfiguration;
import com.facebook.photos.pandora.common.ui.views.PandoraInlineVideoEnvironmentProvider;
import com.facebook.photos.pandora.logging.PandoraSequenceLogger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: download_start_timestamp */
public class PandoraPhotoCollageAdapter extends PandoraBasicFeedAdapter {
    public final Lazy<PandoraFuturesGenerator> f17664t;
    public final PandoraPhotoCollageFetchPhotosFutureGenerator f17665u;
    private final boolean f17666v;
    private final boolean f17667w;
    public boolean f17668x = true;
    public Optional<PhotoCollageLoadingListener> f17669y = Absent.withType();

    /* compiled from: download_start_timestamp */
    public interface PhotoCollageLoadingListener {
        void mo904a();

        void mo905a(PandoraRendererResult pandoraRendererResult);
    }

    /* compiled from: download_start_timestamp */
    public class C18852 extends AbstractDisposableFutureCallback<OperationResult> {
        final /* synthetic */ PandoraPhotoCollageAdapter f17663a;

        public C18852(PandoraPhotoCollageAdapter pandoraPhotoCollageAdapter) {
            this.f17663a = pandoraPhotoCollageAdapter;
        }

        protected final void m21638a(Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (operationResult != null && operationResult.b) {
                PandoraRendererResult pandoraRendererResult = (PandoraRendererResult) operationResult.h();
                if (this.f17663a.f17463o) {
                    this.f17663a.f17465q.m21552a("LoadImageURLs", "ExtraLoadImageURLsSource", this.f17663a.f17462n);
                }
                if (pandoraRendererResult != null) {
                    boolean z;
                    this.f17663a.f17457i.m21442a(pandoraRendererResult.f17472a);
                    PandoraBasicFeedAdapter pandoraBasicFeedAdapter = this.f17663a;
                    if (this.f17663a.f17456h == null || !this.f17663a.f17456h.f17364c) {
                        z = false;
                    } else {
                        z = true;
                    }
                    pandoraBasicFeedAdapter.f17461m = z;
                    if (this.f17663a.f17456h != null && this.f17663a.f17456h.f17363b != null && this.f17663a.f17456h.f17363b.size() >= 12 && this.f17663a.f17456h.f17363b.size() <= 12 && this.f17663a.f17463o) {
                        this.f17663a.f17465q.m21551a("LoadScreenImages");
                    }
                    if (this.f17663a.f17669y.isPresent()) {
                        ((PhotoCollageLoadingListener) this.f17663a.f17669y.get()).mo905a(pandoraRendererResult);
                    }
                    AdapterDetour.a(this.f17663a, -1134640231);
                }
            }
        }

        protected final void m21639a(Throwable th) {
            ((AbstractFbErrorReporter) this.f17663a.f17452d.get()).a("fetchMediaSet", th);
            this.f17663a.f17461m = false;
            AdapterDetour.a(this.f17663a, 40817062);
        }
    }

    @Inject
    public PandoraPhotoCollageAdapter(Lazy<PandoraStoryMemoryCache> lazy, Lazy<PandoraFuturesGenerator> lazy2, Lazy<TasksManager> lazy3, Lazy<PandoraRendererController> lazy4, Lazy<FbErrorReporter> lazy5, String str, PandoraSequenceLogger pandoraSequenceLogger, PandoraInlineVideoEnvironmentProvider pandoraInlineVideoEnvironmentProvider, @Assisted PandoraPhotoCollageFetchPhotosFutureGenerator pandoraPhotoCollageFetchPhotosFutureGenerator, @Assisted Boolean bool, @Assisted Boolean bool2, @Assisted PandoraRendererConfiguration pandoraRendererConfiguration) {
        super(lazy, lazy3, lazy4, pandoraRendererConfiguration, lazy5, str, pandoraSequenceLogger, pandoraInlineVideoEnvironmentProvider);
        this.f17664t = lazy2;
        this.f17665u = pandoraPhotoCollageFetchPhotosFutureGenerator;
        this.f17666v = bool.booleanValue();
        this.f17667w = bool2.booleanValue();
    }

    public final String mo1055e() {
        return StringFormatUtil.a("fetchUploadedMediaSet_%s", new Object[]{this.f17460l});
    }

    protected final boolean mo1059k() {
        return this.f17666v;
    }

    protected final boolean mo1060l() {
        return this.f17667w;
    }

    public final void mo1054d() {
        if (this.f17461m && this.f17464p) {
            String str;
            if (this.f17456h == null) {
                m21428a(this.f17458j, this.f17460l, "LoadScreenImagesUploads", this.f17463o, this.f17464p, this.f17466r);
            }
            if (this.f17463o) {
                this.f17465q.m21551a("LoadImageURLs");
            }
            String str2 = this.f17456h.f17365d;
            if (this.f17461m) {
                str = str2;
            } else {
                str = null;
            }
            ((TasksManager) this.f17451c.get()).a(mo1055e() + str, new Callable<ListenableFuture>(this) {
                final /* synthetic */ PandoraPhotoCollageAdapter f17662b;

                public Object call() {
                    int i;
                    PandoraFuturesGenerator pandoraFuturesGenerator = (PandoraFuturesGenerator) this.f17662b.f17664t.get();
                    PandoraPhotoCollageFetchPhotosFutureGenerator pandoraPhotoCollageFetchPhotosFutureGenerator = this.f17662b.f17665u;
                    PandoraInstanceId pandoraInstanceId = this.f17662b.f17460l;
                    PandoraRendererConfiguration pandoraRendererConfiguration = this.f17662b.f17449a;
                    String str = str;
                    if (this.f17662b.m21431b()) {
                        i = 30;
                    } else {
                        i = 12;
                    }
                    MemoryCacheEntryKey h = this.f17662b.m21436h();
                    PandoraBasicFeedAdapter pandoraBasicFeedAdapter = this.f17662b;
                    boolean z = true;
                    if (!(pandoraBasicFeedAdapter.f17463o || !pandoraBasicFeedAdapter.f17668x || pandoraBasicFeedAdapter.f17463o)) {
                        z = false;
                    }
                    return pandoraFuturesGenerator.m21382a(pandoraPhotoCollageFetchPhotosFutureGenerator, pandoraInstanceId, pandoraRendererConfiguration, null, str, i, h, z);
                }
            }, new C18852(this));
        }
        this.f17668x = false;
    }

    public final void m21640a(PhotoCollageLoadingListener photoCollageLoadingListener) {
        this.f17669y = Optional.fromNullable(photoCollageLoadingListener);
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        if (!mo1058m() && this.f17669y.isPresent()) {
            ((PhotoCollageLoadingListener) this.f17669y.get()).mo904a();
        }
    }

    protected final PandoraRequestSource mo1056f() {
        return PandoraRequestSource.UPLOADED_MEDIA_SET;
    }

    protected final boolean mo1058m() {
        return this.f17461m;
    }
}
