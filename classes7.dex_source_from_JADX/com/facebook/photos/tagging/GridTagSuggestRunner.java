package com.facebook.photos.tagging;

import android.content.Context;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.facerec.manager.FaceBoxPrioritizer;
import com.facebook.facerec.manager.FaceBoxPrioritizer.FaceBoxPrioritizerListener;
import com.facebook.facerec.model.LocalFaceRecImageData;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.base.media.MediaItemsOperator;
import com.facebook.photos.base.media.MediaItemsOperator.SelectMode;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.facebook.photos.tagging.store.TagStore;
import com.facebook.photos.tagging.store.TaggableLocalMediaUtil;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: intro_card_impression */
public class GridTagSuggestRunner implements MediaItemsOperator {
    public final Context f10913a;
    public final Lazy<FaceBoxPrioritizer> f10914b;
    @DefaultExecutorService
    private final ExecutorService f10915c;
    private final FaceBoxPrioritizerListener f10916d = new C09432(this);
    public final TaggableLocalMediaUtil f10917e;
    public final TagStore f10918f;
    public final FaceBoxStore f10919g;
    public AutoTaggingHelper f10920h;

    /* compiled from: intro_card_impression */
    public class C09432 implements FaceBoxPrioritizerListener {
        final /* synthetic */ GridTagSuggestRunner f10912a;

        public C09432(GridTagSuggestRunner gridTagSuggestRunner) {
            this.f10912a = gridTagSuggestRunner;
        }

        public final void m12930a(LocalFaceRecImageData localFaceRecImageData) {
        }

        public final void m12931b(LocalFaceRecImageData localFaceRecImageData) {
            this.f10912a.f10920h.m12928a(this.f10912a.f10913a, localFaceRecImageData, null);
        }
    }

    public static GridTagSuggestRunner m12932a(InjectorLike injectorLike) {
        return new GridTagSuggestRunner((Context) injectorLike.getInstance(Context.class), IdBasedLazy.a(injectorLike, 5764), AutoTaggingHelper.m12927b(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), TaggableLocalMediaUtil.a(injectorLike), TagStore.a(injectorLike), FaceBoxStore.a(injectorLike));
    }

    @Inject
    public GridTagSuggestRunner(Context context, Lazy<FaceBoxPrioritizer> lazy, AutoTaggingHelper autoTaggingHelper, ExecutorService executorService, TaggableLocalMediaUtil taggableLocalMediaUtil, TagStore tagStore, FaceBoxStore faceBoxStore) {
        this.f10913a = context;
        this.f10914b = lazy;
        this.f10915c = executorService;
        this.f10920h = autoTaggingHelper;
        this.f10917e = taggableLocalMediaUtil;
        this.f10918f = tagStore;
        this.f10919g = faceBoxStore;
    }

    public final void m12933a() {
        ((FaceBoxPrioritizer) this.f10914b.get()).j = null;
        ((FaceBoxPrioritizer) this.f10914b.get()).b();
    }

    public final void m12935b() {
        ((FaceBoxPrioritizer) this.f10914b.get()).n = 0;
    }

    public final void m12934a(final MediaItem mediaItem, final SelectMode selectMode) {
        if (mediaItem instanceof PhotoItem) {
            if (!this.f10919g.c(((PhotoItem) mediaItem).f)) {
                ((FaceBoxPrioritizer) this.f10914b.get()).j = this.f10916d;
                ExecutorDetour.a(this.f10915c, new Runnable(this) {
                    final /* synthetic */ GridTagSuggestRunner f10911c;

                    public void run() {
                        this.f10911c.f10917e.c();
                        this.f10911c.f10917e.a((PhotoItem) mediaItem);
                        LocalFaceRecImageData localFaceRecImageData = new LocalFaceRecImageData((PhotoItem) mediaItem, this.f10911c.f10918f, this.f10911c.f10919g);
                        if (selectMode == SelectMode.SELECT) {
                            List a = Lists.a();
                            a.add(localFaceRecImageData);
                            ((FaceBoxPrioritizer) this.f10911c.f10914b.get()).a(a);
                            return;
                        }
                        ((FaceBoxPrioritizer) this.f10911c.f10914b.get()).a(localFaceRecImageData);
                    }
                }, 1870026447);
            }
        }
    }
}
