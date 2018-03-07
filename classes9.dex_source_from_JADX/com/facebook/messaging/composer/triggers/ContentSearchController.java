package com.facebook.messaging.composer.triggers;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.internal.widget.ViewStubCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Product;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.Assisted;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.composer.edit.MessageComposerEditor;
import com.facebook.messaging.composer.triggers.ContentSearchResultsView.OnHighlightListener;
import com.facebook.messaging.composer.triggers.ContentSearchResultsView.OnSelectListener;
import com.facebook.messaging.composer.triggers.OpenCloseAnimator.AnimatedView;
import com.facebook.messaging.composer.triggers.analytics.ContentSearchLogger;
import com.facebook.messaging.media.externalmedia.ExternalMediaGraphQLFetcher;
import com.facebook.messaging.media.externalmedia.ExternalMediaGraphQLRequest;
import com.facebook.messaging.media.externalmedia.ExternalMediaGraphQLRequest.AppFbidFilter;
import com.facebook.messaging.media.externalmedia.ExternalMediaGraphQLRequest.GroupByType;
import com.facebook.messaging.media.externalmedia.ExternalMediaGraphQLRequest.QueryType;
import com.facebook.messaging.media.externalmedia.ExternalMediaGraphQLRequest.ResultType;
import com.facebook.messaging.media.externalmedia.ExternalMediaGraphQLResponse;
import com.facebook.messaging.media.externalmedia.MediaParams;
import com.facebook.messaging.media.externalmedia.MediaParams.MediaType;
import com.facebook.messaging.media.externalmedia.MediaParamsBuilder;
import com.facebook.messaging.media.preview.MediaPreviewDialogManager;
import com.facebook.orca.compose.TwoLineComposerView.10;
import com.facebook.stickers.abtest.ExperimentsForStickerAbTestingModule;
import com.facebook.stickers.abtest.StickerContentSearchExperimentAccessor;
import com.facebook.stickers.model.Sticker;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.ViewStubHolder.OnInflateListener;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: messenger_inbox_unit_updated_time */
public class ContentSearchController {
    private static final ImmutableMap<ContentSearchType, ImmutableList<ResultType>> f9795a = new Builder().b(ContentSearchType.ANIMATION, ImmutableList.of(ResultType.ANIMATION)).b(ContentSearchType.STICKER, ImmutableList.of(ResultType.STICKER)).b();
    private static final ImmutableMap<ContentSearchType, ImmutableList<MediaType>> f9796b = new Builder().b(ContentSearchType.ANIMATION, ImmutableList.of(MediaType.WEBP, MediaType.GIF)).b(ContentSearchType.STICKER, ImmutableList.of(MediaType.JPG, MediaType.PNG, MediaType.WEBP, MediaType.GIF)).b();
    private static final ImmutableList<MediaType> f9797c = ImmutableList.of(MediaType.JPG, MediaType.PNG);
    private static final ImmutableList<AppFbidFilter> f9798d = ImmutableList.of(AppFbidFilter.INTERNAL_STICKERS);
    public final ViewStubHolder<ContentSearchResultsView> f9799e;
    public final OpenCloseAnimator f9800f;
    private final int f9801g;
    private final int f9802h;
    public final MessageComposerEditor f9803i;
    private final Executor f9804j;
    private final ExternalMediaGraphQLFetcher f9805k;
    public final ScheduledExecutorService f9806l;
    public final MediaPreviewDialogManager f9807m;
    public final ContentSearchLogger f9808n;
    public final MessagingPerformanceLogger f9809o;
    private final StickerContentSearchExperimentAccessor f9810p;
    public final boolean f9811q;
    private FutureAndCallbackHolder<ExternalMediaGraphQLResponse> f9812r;
    public ScheduledFuture f9813s;
    public 10 f9814t;
    public String f9815u;
    public boolean f9816v;
    public ContentSearchType f9817w = ContentSearchType.ANIMATION;

    /* compiled from: messenger_inbox_unit_updated_time */
    class C11341 implements OnInflateListener<ContentSearchResultsView> {
        final /* synthetic */ ContentSearchController f9791a;

        /* compiled from: messenger_inbox_unit_updated_time */
        class C11321 implements OnSelectListener {
            final /* synthetic */ C11341 f9788a;

            C11321(C11341 c11341) {
                this.f9788a = c11341;
            }

            public final void mo398a(Sticker sticker, int i) {
                if (this.f9788a.f9791a.f9814t != null) {
                    this.f9788a.f9791a.f9814t.a(sticker, this.f9788a.f9791a.f9815u, i);
                }
            }

            public final void mo399a(MediaResource mediaResource, int i) {
                if (this.f9788a.f9791a.f9814t != null) {
                    this.f9788a.f9791a.f9814t.a(mediaResource, this.f9788a.f9791a.f9815u, i);
                }
            }
        }

        C11341(ContentSearchController contentSearchController) {
            this.f9791a = contentSearchController;
        }

        public final void m10374a(View view) {
            final ContentSearchResultsView contentSearchResultsView = (ContentSearchResultsView) view;
            contentSearchResultsView.f9856f = new C11321(this);
            if (this.f9791a.f9811q) {
                contentSearchResultsView.setOnHighlightListener(new OnHighlightListener(this) {
                    final /* synthetic */ C11341 f9790b;

                    public final void mo401a(MediaResource mediaResource) {
                        m10370c(mediaResource);
                    }

                    public final void mo402b(MediaResource mediaResource) {
                        m10370c(mediaResource);
                    }

                    public final void mo400a() {
                        this.f9790b.f9791a.f9807m.a();
                    }

                    private void m10370c(MediaResource mediaResource) {
                        if (mediaResource != null) {
                            MediaPreviewDialogManager mediaPreviewDialogManager = this.f9790b.f9791a.f9807m;
                            Context context = contentSearchResultsView.getContext();
                            ImageRequestBuilder a = ImageRequestBuilder.a(mediaResource.c);
                            ImageDecodeOptionsBuilder newBuilder = ImageDecodeOptions.newBuilder();
                            newBuilder.d = true;
                            a.e = newBuilder.h();
                            mediaPreviewDialogManager.a(context, a.m());
                        }
                    }
                });
            }
        }
    }

    /* compiled from: messenger_inbox_unit_updated_time */
    class C11362 implements TextWatcher {
        final /* synthetic */ ContentSearchController f9793a;

        /* compiled from: messenger_inbox_unit_updated_time */
        class C11351 implements Runnable {
            final /* synthetic */ C11362 f9792a;

            C11351(C11362 c11362) {
                this.f9792a = c11362;
            }

            public void run() {
                this.f9792a.f9793a.f9813s = null;
                ContentSearchController contentSearchController = this.f9792a.f9793a;
                if (contentSearchController.f9816v) {
                    ContentSearchController.m10380d(contentSearchController);
                }
            }
        }

        C11362(ContentSearchController contentSearchController) {
            this.f9793a = contentSearchController;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f9793a.f9809o.e("content_search");
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (this.f9793a.f9816v) {
                CharSequence a = this.f9793a.f9803i.m10355a();
                if (this.f9793a.f9813s != null) {
                    this.f9793a.f9813s.cancel(false);
                    this.f9793a.f9813s = null;
                }
                if (StringUtil.c(a)) {
                    ContentSearchController.m10380d(this.f9793a);
                } else {
                    this.f9793a.f9813s = this.f9793a.f9806l.schedule(new C11351(this), 200, TimeUnit.MILLISECONDS);
                }
            }
            this.f9793a.f9809o.d();
        }
    }

    /* compiled from: messenger_inbox_unit_updated_time */
    class C11373 extends AbstractDisposableFutureCallback<ExternalMediaGraphQLResponse> {
        final /* synthetic */ ContentSearchController f9794a;

        C11373(ContentSearchController contentSearchController) {
            this.f9794a = contentSearchController;
        }

        protected final void m10375a(Object obj) {
            ContentSearchController.m10377a(this.f9794a, (ExternalMediaGraphQLResponse) obj);
        }

        protected final void m10376a(Throwable th) {
            this.f9794a.m10383g();
            this.f9794a.f9808n.m10484c();
        }
    }

    @Inject
    public ContentSearchController(Resources resources, ExternalMediaGraphQLFetcher externalMediaGraphQLFetcher, Executor executor, ScheduledExecutorService scheduledExecutorService, @Assisted ViewStubCompat viewStubCompat, @Assisted MessageComposerEditor messageComposerEditor, GatekeeperStoreImpl gatekeeperStoreImpl, @ForMediaResourcePreview MediaPreviewDialogManager mediaPreviewDialogManager, ContentSearchLogger contentSearchLogger, MessagingPerformanceLogger messagingPerformanceLogger, StickerContentSearchExperimentAccessor stickerContentSearchExperimentAccessor) {
        this.f9803i = messageComposerEditor;
        this.f9807m = mediaPreviewDialogManager;
        this.f9806l = scheduledExecutorService;
        this.f9809o = messagingPerformanceLogger;
        this.f9811q = gatekeeperStoreImpl.a(197, false);
        this.f9801g = resources.getDimensionPixelSize(2131433758) + resources.getDimensionPixelSize(2131433762);
        this.f9802h = resources.getDimensionPixelSize(2131433759);
        this.f9810p = stickerContentSearchExperimentAccessor;
        this.f9799e = ViewStubHolder.a(viewStubCompat);
        this.f9800f = new OpenCloseAnimator(this.f9799e, this.f9801g);
        this.f9799e.c = new C11341(this);
        this.f9803i.m10357a(new C11362(this));
        this.f9805k = externalMediaGraphQLFetcher;
        this.f9804j = executor;
        this.f9808n = contentSearchLogger;
    }

    public final void m10384b(boolean z) {
        this.f9816v = false;
        m10379c(z);
    }

    public static void m10380d(ContentSearchController contentSearchController) {
        ImmutableList immutableList = null;
        CharSequence f = contentSearchController.m10382f();
        if (!Objects.equal(f, contentSearchController.f9815u)) {
            QueryType queryType;
            contentSearchController.f9815u = f;
            if (StringUtil.c(f)) {
                queryType = QueryType.TRENDING;
            } else {
                queryType = QueryType.SEARCH;
            }
            if (contentSearchController.f9812r != null) {
                contentSearchController.f9812r.a(true);
                contentSearchController.f9812r = null;
            }
            List list = (List) f9796b.get(contentSearchController.f9817w);
            if (contentSearchController.f9817w == ContentSearchType.STICKER) {
                StickerContentSearchExperimentAccessor stickerContentSearchExperimentAccessor = contentSearchController.f9810p;
                boolean z = false;
                if (stickerContentSearchExperimentAccessor.a == Product.MESSENGER && stickerContentSearchExperimentAccessor.b.a(ExperimentsForStickerAbTestingModule.d, false)) {
                    z = true;
                }
                if (!z) {
                    immutableList = f9798d;
                }
            }
            String str = contentSearchController.f9815u;
            ImmutableList immutableList2 = (ImmutableList) f9795a.get(contentSearchController.f9817w);
            GroupByType groupByType = GroupByType.UNGROUPED;
            MediaParamsBuilder newBuilder = MediaParams.newBuilder();
            newBuilder.f11618a = list;
            newBuilder = newBuilder;
            newBuilder.f11620c = contentSearchController.f9802h;
            newBuilder = newBuilder;
            newBuilder.f11621d = true;
            MediaParams e = newBuilder.m12245e();
            MediaParamsBuilder newBuilder2 = MediaParams.newBuilder();
            newBuilder2.f11618a = list;
            MediaParamsBuilder mediaParamsBuilder = newBuilder2;
            mediaParamsBuilder.f11620c = contentSearchController.f9802h;
            ImmutableList of = ImmutableList.of(e, mediaParamsBuilder.m12245e());
            newBuilder = MediaParams.newBuilder();
            newBuilder.f11618a = f9797c;
            newBuilder = newBuilder;
            newBuilder.f11620c = contentSearchController.f9802h;
            ExternalMediaGraphQLRequest externalMediaGraphQLRequest = new ExternalMediaGraphQLRequest(queryType, str, immutableList2, groupByType, 40, of, ImmutableList.of(newBuilder.m12245e()), immutableList);
            contentSearchController.f9808n.m10485d();
            contentSearchController.f9808n.m10481a();
            C11373 c11373 = new C11373(contentSearchController);
            contentSearchController.f9812r = FutureAndCallbackHolder.a(contentSearchController.f9805k.m12243a(externalMediaGraphQLRequest), c11373);
            contentSearchController.m10381e();
            Futures.a(contentSearchController.f9812r.a, c11373, contentSearchController.f9804j);
        }
    }

    private void m10381e() {
        if (this.f9814t != null) {
            boolean z;
            10 10 = this.f9814t;
            if (this.f9812r == null || this.f9812r.a.isDone()) {
                z = false;
            } else {
                z = true;
            }
            10.a(z);
        }
    }

    private String m10382f() {
        String obj = this.f9803i.m10355a().toString();
        if (this.f9817w == ContentSearchType.STICKER && StringUtil.c(obj)) {
            return "Happy";
        }
        return obj;
    }

    public static void m10377a(ContentSearchController contentSearchController, ExternalMediaGraphQLResponse externalMediaGraphQLResponse) {
        if (Objects.equal(contentSearchController.m10382f(), contentSearchController.f9815u)) {
            contentSearchController.f9812r = null;
            contentSearchController.m10381e();
            ((ContentSearchResultsView) contentSearchController.f9799e.a()).setResults(externalMediaGraphQLResponse.f11606a);
        }
    }

    private void m10383g() {
        if (Objects.equal(m10382f(), this.f9815u)) {
            this.f9815u = null;
            this.f9812r = null;
            m10381e();
            ((ContentSearchResultsView) this.f9799e.a()).setResults(RegularImmutableList.a);
        }
    }

    private void m10379c(boolean z) {
        this.f9815u = null;
        if (this.f9812r != null) {
            this.f9812r.a(false);
            this.f9812r = null;
        }
        if (this.f9813s != null) {
            this.f9813s.cancel(false);
            this.f9813s = null;
        }
        m10381e();
        if (z) {
            this.f9800f.m10474a(false);
            return;
        }
        OpenCloseAnimator openCloseAnimator = this.f9800f;
        if (openCloseAnimator.f9924c || openCloseAnimator.f9925d != null) {
            if (openCloseAnimator.f9925d != null) {
                openCloseAnimator.f9925d.cancel();
                openCloseAnimator.f9925d = null;
            }
            openCloseAnimator.f9922a.a().getLayoutParams().height = 0;
            openCloseAnimator.f9922a.e();
            ((AnimatedView) openCloseAnimator.f9922a.a()).mo403a();
            openCloseAnimator.f9924c = false;
        }
    }
}
