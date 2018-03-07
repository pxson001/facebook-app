package com.facebook.composer.topics;

import android.os.Handler;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.media.MediaUtils;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.topics.ComposerTopicsDetector.C28981;
import com.facebook.debug.log.BLog;
import com.facebook.feed.topicfeeds.abtest.ExperimentsForTopicFeedsTestModule;
import com.facebook.feed.topicfeeds.abtest.TopicFeedsTestUtil;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.intent.ComposerPageDataSpec.ProvidesPageData;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.upload.operation.UploadOperationHelper;
import com.facebook.photos.upload.protocol.UploadPhotoParams;
import com.facebook.photos.upload.protocol.UploadPhotoSource;
import com.facebook.photos.upload.retry.ImmediateRetryPolicy;
import com.facebook.photos.upload.uploaders.DirectPhotoUploader;
import com.facebook.photos.upload.uploaders.DirectPhotoUploader.DirectUploadListener;
import com.facebook.photos.upload.uploaders.MediaUploadCancelHandler;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Tried to terminate a search session but no session is ongoing */
public class TopicsPhotoManager<DataProvider extends ProvidesSessionId & ProvidesPageData> {
    public static final String f23945a = TopicsPhotoManager.class.getSimpleName();
    public final Lazy<DirectPhotoUploader> f23946b;
    public final Lazy<ExecutorService> f23947c;
    public final DataProvider f23948d;
    public final MediaUploadCancelHandler f23949e;
    public final UploadOperationHelper f23950f;
    public final Provider<ImmediateRetryPolicy> f23951g;
    public final Map<String, PhotoInfo> f23952h;
    public final Handler f23953i;
    public C28981 f23954j;
    public ImmutableList<String> f23955k = RegularImmutableList.a;
    public ImmutableList<String> f23956l = RegularImmutableList.a;

    /* compiled from: Tried to terminate a search session but no session is ongoing */
    public class PhotoInfo {
        public String f23943a;
        public String f23944b;

        public PhotoInfo(String str) {
            this.f23944b = str;
        }
    }

    @Inject
    public TopicsPhotoManager(@Assisted DataProvider dataProvider, Lazy<DirectPhotoUploader> lazy, Lazy<ExecutorService> lazy2, MediaUploadCancelHandler mediaUploadCancelHandler, UploadOperationHelper uploadOperationHelper, Provider<ImmediateRetryPolicy> provider) {
        this.f23948d = dataProvider;
        this.f23946b = lazy;
        this.f23947c = lazy2;
        this.f23949e = mediaUploadCancelHandler;
        this.f23950f = uploadOperationHelper;
        this.f23951g = provider;
        this.f23952h = new HashMap();
        this.f23953i = new Handler();
    }

    public final int m25900a(ImmutableList<ComposerAttachment> immutableList) {
        Builder builder = new Builder();
        List arrayList = new ArrayList();
        int size = immutableList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            ComposerAttachment composerAttachment = (ComposerAttachment) immutableList.get(i);
            MediaItem b = composerAttachment.b();
            if (b != null) {
                String path = b.f().getPath();
                if (MediaUtils.a(b.b().mMimeType.mRawType)) {
                    arrayList.add(path);
                    String a = composerAttachment.d().a();
                    if (!this.f23952h.containsKey(path)) {
                        builder.c(b);
                        this.f23952h.put(path, new PhotoInfo(a));
                        i3 = i2 | 1;
                    } else if (!((PhotoInfo) this.f23952h.get(path)).f23944b.equals(a)) {
                        ((PhotoInfo) this.f23952h.get(path)).f23944b = a;
                        i3 = i2 | 4;
                    }
                    i++;
                    i2 = i3;
                }
            }
            i3 = i2;
            i++;
            i2 = i3;
        }
        Iterator it = this.f23952h.keySet().iterator();
        while (it.hasNext()) {
            if (!arrayList.contains(it.next())) {
                it.remove();
                i2 |= 2;
            }
        }
        if ((i2 & 1) > 0) {
            final ImmutableList b2 = builder.b();
            this.f23949e.a();
            ExecutorDetour.a((ExecutorService) this.f23947c.get(), new Runnable(this) {
                final /* synthetic */ TopicsPhotoManager f23942b;

                /* compiled from: Tried to terminate a search session but no session is ongoing */
                class C29061 implements Runnable {
                    final /* synthetic */ C29071 f23940a;

                    C29061(C29071 c29071) {
                        this.f23940a = c29071;
                    }

                    public void run() {
                        TopicsPhotoManager.m25899f(this.f23940a.f23942b);
                        if (this.f23940a.f23942b.f23954j != null) {
                            int intValue;
                            C28981 c28981 = this.f23940a.f23942b.f23954j;
                            ComposerTopicsDetector composerTopicsDetector = c28981.f23898a;
                            TopicFeedsTestUtil topicFeedsTestUtil = c28981.f23898a.f23909f;
                            if (topicFeedsTestUtil.p.isPresent()) {
                                intValue = ((Integer) topicFeedsTestUtil.p.get()).intValue();
                            } else {
                                topicFeedsTestUtil.p = Optional.of(Integer.valueOf(topicFeedsTestUtil.a.a(ExperimentsForTopicFeedsTestModule.h, 10)));
                                intValue = ((Integer) topicFeedsTestUtil.p.get()).intValue();
                            }
                            composerTopicsDetector.f23923t = intValue;
                            ComposerTopicsDetector.m25875b(c28981.f23898a, c28981.f23898a.f23909f.m());
                        }
                    }
                }

                public void run() {
                    Collection<UploadPhotoParams> a = Lists.a();
                    int size = b2.size();
                    for (int i = 0; i < size; i++) {
                        ViewerContext postAsPageViewerContext;
                        MediaItem mediaItem = (MediaItem) b2.get(i);
                        UploadPhotoParams.Builder builder = new UploadPhotoParams.Builder(new UploadPhotoSource(mediaItem.f().getPath(), mediaItem.o()));
                        if (((ComposerDataProviderImpl) this.f23942b.f23948d).p() != null) {
                            postAsPageViewerContext = ((ComposerDataProviderImpl) this.f23942b.f23948d).p().getPostAsPageViewerContext();
                        } else {
                            postAsPageViewerContext = null;
                        }
                        a.add(builder.a(postAsPageViewerContext).a());
                    }
                    DefaultPhotoFlowLogger a2 = this.f23942b.f23950f.a(this.f23942b.f23948d.ab());
                    a2.b("photo_topic_classification_batch");
                    try {
                        ((DirectPhotoUploader) this.f23942b.f23946b.get()).a(a, new DirectUploadListener(), this.f23942b.f23949e, a2, a2.j("2.0"), null, (ImmediateRetryPolicy) this.f23942b.f23951g.get());
                        for (UploadPhotoParams uploadPhotoParams : a) {
                            String l = Long.toString(uploadPhotoParams.v());
                            PhotoInfo photoInfo = (PhotoInfo) this.f23942b.f23952h.get(uploadPhotoParams.d());
                            if (photoInfo != null) {
                                photoInfo.f23943a = l;
                            } else {
                                BLog.b(TopicsPhotoManager.f23945a, "Missing photo info!");
                            }
                        }
                    } catch (CancellationException e) {
                        TopicsPhotoManager.f23945a;
                    } catch (Throwable e2) {
                        BLog.b(TopicsPhotoManager.f23945a, e2, "Error occurred during upload", new Object[0]);
                    }
                    HandlerDetour.a(this.f23942b.f23953i, new C29061(this), 701017013);
                }
            }, -1500053609);
        }
        if (i2 != 0) {
            m25899f(this);
        }
        return i2;
    }

    public final boolean m25901a() {
        return !this.f23955k.isEmpty();
    }

    public static void m25899f(TopicsPhotoManager topicsPhotoManager) {
        Builder builder = new Builder();
        Builder builder2 = new Builder();
        for (PhotoInfo photoInfo : topicsPhotoManager.f23952h.values()) {
            if (photoInfo.f23943a != null) {
                builder.c(photoInfo.f23943a);
                builder2.c(photoInfo.f23944b != null ? photoInfo.f23944b : "");
            }
        }
        topicsPhotoManager.f23955k = builder.b();
        topicsPhotoManager.f23956l = builder2.b();
    }
}
