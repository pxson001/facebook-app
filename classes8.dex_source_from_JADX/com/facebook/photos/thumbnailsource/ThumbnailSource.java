package com.facebook.photos.thumbnailsource;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.util.LruCache;
import com.facebook.bitmaps.BitmapResizingParam;
import com.facebook.bitmaps.ThumbnailMaker;
import com.facebook.common.cpu.ProcessorInfoUtil;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.MonotonicClock;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.Assisted;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.photos.simplepicker.LegacySimplePickerFragment.C03641;
import com.facebook.photos.thumbnailsource.ThumbnailSourceSequences.ThumbnailDecodingSequence;
import com.facebook.sequencelogger.NoOpSequence;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.ui.images.cache.CachedBitmapImage;
import com.facebook.ui.images.cache.CachedImage;
import com.facebook.ui.images.cache.ImageCache;
import com.facebook.ui.images.cache.ImageCacheKey;
import com.facebook.ui.images.cache.ImageCacheKey.Options;
import com.facebook.ui.images.cache.ImageCacheKey.OptionsBuilder;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import javax.annotation.Nullable;
import javax.inject.Inject;

@Deprecated
/* compiled from: selected_is_scoped_keyword */
public class ThumbnailSource {
    public static final String f3470a = ThumbnailSource.class.getSimpleName();
    private int f3471b = Integer.MAX_VALUE;
    private int f3472c = 25;
    public final ImageCache f3473d;
    public final Stack<DecodeJob> f3474e;
    public final BlockingQueue<DecodeJob> f3475f;
    public final BlockingQueue<DiskCacheJob> f3476g;
    private final ExecutorService f3477h;
    private final ExecutorService f3478i;
    private final ExecutorService f3479j;
    public List<Future<Void>> f3480k;
    @Nullable
    public C03641 f3481l;
    public final ThumbnailMaker f3482m;
    public final LruCache<String, Boolean> f3483n;
    private final LruCache<String, ImageCacheKey> f3484o;
    private final LruCache<String, ImageCacheKey> f3485p;
    public final SequenceLogger f3486q;
    public final MonotonicClock f3487r;
    private final ThumbnailSourceCacheUtil f3488s;
    public final Set<DecodeJob> f3489t;
    private final ProcessorInfoUtil f3490u;
    private final GatekeeperStoreImpl f3491v;
    public final AbstractFbErrorReporter f3492w;

    /* compiled from: selected_is_scoped_keyword */
    class C04451 implements Comparator<DecodeJob> {
        final /* synthetic */ ThumbnailSource f3455a;

        C04451(ThumbnailSource thumbnailSource) {
            this.f3455a = thumbnailSource;
        }

        public int compare(Object obj, Object obj2) {
            DecodeJob decodeJob = (DecodeJob) obj;
            DecodeJob decodeJob2 = (DecodeJob) obj2;
            if (decodeJob2.f3461e == decodeJob.f3461e) {
                return decodeJob2.f3462f - decodeJob.f3462f;
            }
            return decodeJob2.f3461e - decodeJob.f3461e;
        }
    }

    /* compiled from: selected_is_scoped_keyword */
    /* synthetic */ class C04462 {
        static final /* synthetic */ int[] f3456a = new int[MediaType.values().length];

        static {
            try {
                f3456a[MediaType.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3456a[MediaType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: selected_is_scoped_keyword */
    public class DecodeJob {
        @Nullable
        public MediaItem f3457a;
        int f3458b;
        @Nullable
        ImageCacheKey f3459c;
        public BitmapResizingParam f3460d;
        public int f3461e;
        int f3462f;
        boolean f3463g;
        final /* synthetic */ ThumbnailSource f3464h;

        public DecodeJob(ThumbnailSource thumbnailSource) {
            this.f3464h = thumbnailSource;
        }

        public final void m3428a(MediaItem mediaItem, int i, ImageCacheKey imageCacheKey, BitmapResizingParam bitmapResizingParam, int i2, boolean z) {
            this.f3457a = mediaItem;
            this.f3458b = i;
            this.f3459c = imageCacheKey;
            this.f3460d = bitmapResizingParam;
            this.f3462f = i2;
            this.f3463g = z;
            int i3 = 1;
            int i4 = this.f3457a.l() == MediaType.PHOTO ? 1 : 0;
            if (this.f3460d.d) {
                i3 = 5;
            }
            this.f3461e = (i4 != 0 ? 3 : 2) + i3;
        }

        public final DecodeJob m3429b() {
            this.f3457a = null;
            this.f3458b = -1;
            this.f3459c = null;
            this.f3461e = 0;
            this.f3462f = Integer.MAX_VALUE;
            return this;
        }

        public boolean equals(Object obj) {
            Preconditions.checkNotNull(this.f3457a);
            if (obj == null || !(obj instanceof DecodeJob)) {
                return false;
            }
            return this.f3458b == ((DecodeJob) obj).f3458b && this.f3457a.equals(((DecodeJob) obj).f3457a);
        }

        public int hashCode() {
            Preconditions.checkNotNull(this.f3457a);
            return Objects.hashCode(new Object[]{Integer.valueOf(this.f3458b), this.f3457a});
        }
    }

    /* compiled from: selected_is_scoped_keyword */
    class DiskCacheJob {
        ImageCacheKey f3465a;
        CachedImage f3466b;
        final /* synthetic */ ThumbnailSource f3467c;

        public DiskCacheJob(ThumbnailSource thumbnailSource, ImageCacheKey imageCacheKey, CachedImage cachedImage) {
            this.f3467c = thumbnailSource;
            this.f3465a = imageCacheKey;
            this.f3466b = cachedImage;
        }
    }

    /* compiled from: selected_is_scoped_keyword */
    class ThumbnailDecodingWorker implements Runnable {
        final /* synthetic */ ThumbnailSource f3468a;

        public ThumbnailDecodingWorker(ThumbnailSource thumbnailSource) {
            this.f3468a = thumbnailSource;
        }

        @SuppressLint({"DeprecatedClass"})
        public void run() {
            Preconditions.checkNotNull(this.f3468a.f3481l);
            String l = Long.toString(Thread.currentThread().getId());
            while (true) {
                try {
                    CachedImage cachedImage;
                    Bitmap a;
                    DecodeJob decodeJob = (DecodeJob) this.f3468a.f3475f.take();
                    this.f3468a.f3489t.add(decodeJob);
                    MediaItem mediaItem = decodeJob.f3457a;
                    ImageCacheKey imageCacheKey = decodeJob.f3459c;
                    Sequence a2 = m3430a(l);
                    SequenceLoggerDetour.a(a2, "CacheGet", 2065375470);
                    CachedImage cachedImage2 = decodeJob.f3463g ? (CachedImage) this.f3468a.f3473d.c(imageCacheKey) : null;
                    if (cachedImage2 == null) {
                        SequenceLoggerDetour.c(a2, "CacheGet", 1189927926);
                        SequenceLoggerDetour.a(a2, "Decode", 513125916);
                        Bitmap a3 = this.f3468a.f3482m.a(mediaItem, decodeJob.f3460d);
                        if (a3 != null) {
                            CachedBitmapImage a4 = CachedImage.a(a3);
                            SequenceLoggerDetour.b(a2, "Decode", -1153400418);
                            try {
                                SequenceLoggerDetour.a(a2, "CachePut", 1745994010);
                                if (!decodeJob.f3460d.d || ThumbnailSource.m3433a(a3, imageCacheKey.e().c)) {
                                    this.f3468a.f3473d.b(imageCacheKey, a4);
                                    this.f3468a.f3476g.offer(new DiskCacheJob(this.f3468a, imageCacheKey, a4));
                                }
                                SequenceLoggerDetour.b(a2, "CachePut", 1194410583);
                                cachedImage = a4;
                            } catch (IOException e) {
                                SequenceLoggerDetour.c(a2, "CachePut", 1744080357);
                                cachedImage = a4;
                            }
                        } else {
                            SequenceLoggerDetour.c(a2, "Decode", -1768883460);
                            this.f3468a.f3483n.a(mediaItem.e(), Boolean.TRUE);
                            cachedImage = cachedImage2;
                        }
                    } else {
                        SequenceLoggerDetour.b(a2, "CacheGet", 2000518323);
                        cachedImage = cachedImage2;
                    }
                    this.f3468a.f3486q.b(ThumbnailSourceSequences.f3493a, l, null, this.f3468a.f3487r.now());
                    if (cachedImage != null) {
                        a = cachedImage.a();
                    } else {
                        a = null;
                    }
                    this.f3468a.f3481l.m2918a(mediaItem, a, decodeJob.f3458b, decodeJob.f3460d);
                    Preconditions.checkArgument(this.f3468a.f3489t.remove(decodeJob));
                    this.f3468a.f3474e.push(decodeJob.m3429b());
                } catch (InterruptedException e2) {
                    return;
                } catch (Throwable e3) {
                    this.f3468a.f3492w.b(ThumbnailSource.f3470a, e3);
                }
            }
        }

        private Sequence<ThumbnailDecodingSequence> m3430a(String str) {
            Sequence<ThumbnailDecodingSequence> a;
            if (Math.random() <= 0.05d) {
                a = this.f3468a.f3486q.a(ThumbnailSourceSequences.f3493a, str, null, this.f3468a.f3487r.now());
            } else {
                a = null;
            }
            if (a != null) {
                return a;
            }
            if (ThumbnailSourceSequences.f3494b == null) {
                ThumbnailSourceSequences.f3494b = new NoOpSequence();
            }
            return ThumbnailSourceSequences.f3494b;
        }
    }

    /* compiled from: selected_is_scoped_keyword */
    class ThumbnailDiskCacheWorker implements Runnable {
        final /* synthetic */ ThumbnailSource f3469a;

        public ThumbnailDiskCacheWorker(ThumbnailSource thumbnailSource) {
            this.f3469a = thumbnailSource;
        }

        @SuppressLint({"DeprecatedClass"})
        public void run() {
            while (true) {
                try {
                    DiskCacheJob diskCacheJob = (DiskCacheJob) this.f3469a.f3476g.take();
                    this.f3469a.f3473d.c(diskCacheJob.f3465a, diskCacheJob.f3466b);
                } catch (InterruptedException e) {
                    return;
                } catch (IOException e2) {
                    return;
                }
            }
        }
    }

    @Inject
    public ThumbnailSource(ImageCache imageCache, @Assisted Integer num, @Assisted Boolean bool, ExecutorService executorService, ExecutorService executorService2, ExecutorService executorService3, ThumbnailMaker thumbnailMaker, SequenceLogger sequenceLogger, MonotonicClock monotonicClock, ThumbnailSourceCacheUtil thumbnailSourceCacheUtil, ProcessorInfoUtil processorInfoUtil, GatekeeperStoreImpl gatekeeperStoreImpl, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f3473d = imageCache;
        this.f3472c = num.intValue();
        if (bool.booleanValue()) {
            this.f3475f = new PriorityBlockingQueue(num.intValue(), new C04451(this));
        } else {
            this.f3475f = new ArrayBlockingQueue(num.intValue());
        }
        this.f3476g = new ArrayBlockingQueue(num.intValue());
        this.f3474e = new Stack();
        this.f3477h = executorService;
        this.f3478i = executorService2;
        this.f3479j = executorService3;
        this.f3480k = Lists.a();
        this.f3482m = thumbnailMaker;
        this.f3483n = new LruCache(200);
        this.f3484o = new LruCache(256);
        this.f3485p = new LruCache(2);
        this.f3486q = sequenceLogger;
        this.f3487r = monotonicClock;
        this.f3488s = thumbnailSourceCacheUtil;
        this.f3489t = Collections.synchronizedSet(Sets.a());
        this.f3490u = processorInfoUtil;
        this.f3491v = gatekeeperStoreImpl;
        this.f3492w = abstractFbErrorReporter;
    }

    public static boolean m3433a(Bitmap bitmap, int i) {
        return ((float) bitmap.getWidth()) > ((float) i) * 0.98f && ((float) bitmap.getHeight()) > ((float) i) * 0.98f;
    }

    public final void m3436a() {
        int i = 1;
        Preconditions.checkState(this.f3480k.isEmpty());
        int d = this.f3490u.d();
        int max = Math.max(d - 1, 1);
        int min = Math.min(d, 2);
        d = max - min;
        if (this.f3491v.a(444, false)) {
            d = 1;
        } else {
            i = d;
            d = min;
        }
        Integer.valueOf(d);
        Integer.valueOf(i);
        for (min = 0; min < d; min++) {
            this.f3480k.add(ExecutorDetour.a(this.f3479j, new ThumbnailDecodingWorker(this), 495851316));
        }
        for (d = 0; d < i; d++) {
            this.f3480k.add(ExecutorDetour.a(this.f3477h, new ThumbnailDecodingWorker(this), -1182457707));
        }
        this.f3480k.add(ExecutorDetour.a(this.f3478i, new ThumbnailDiskCacheWorker(this), 1241721770));
    }

    @Nullable
    public final Bitmap m3435a(MediaItem mediaItem, int i, BitmapResizingParam bitmapResizingParam, boolean z) {
        ImageCacheKey a = m3431a(mediaItem, bitmapResizingParam.b);
        CachedImage cachedImage = (CachedImage) this.f3473d.a(a);
        if (cachedImage != null) {
            return cachedImage.a();
        }
        m3432a(mediaItem, i, a, bitmapResizingParam, z);
        return null;
    }

    private void m3432a(MediaItem mediaItem, int i, ImageCacheKey imageCacheKey, BitmapResizingParam bitmapResizingParam, boolean z) {
        DecodeJob decodeJob;
        if (this.f3474e.empty()) {
            decodeJob = new DecodeJob(this);
        } else {
            decodeJob = (DecodeJob) this.f3474e.pop();
        }
        int i2 = this.f3471b;
        this.f3471b = i2 - 1;
        decodeJob.m3428a(mediaItem, i, imageCacheKey, bitmapResizingParam, i2, z);
        if (!this.f3489t.contains(decodeJob)) {
            if (this.f3475f.contains(decodeJob)) {
                this.f3475f.remove(decodeJob);
            }
            if (this.f3475f.size() > this.f3472c) {
                m3434d();
            }
            for (int i3 = 10; i3 > 0 && !this.f3475f.offer(decodeJob); i3--) {
                m3434d();
            }
        }
    }

    private void m3434d() {
        int i = Integer.MIN_VALUE;
        DecodeJob decodeJob = null;
        for (DecodeJob decodeJob2 : this.f3475f) {
            DecodeJob decodeJob22;
            int i2;
            int i3 = decodeJob22.f3462f;
            if (i3 >= i) {
                i2 = i3;
            } else {
                decodeJob22 = decodeJob;
                i2 = i;
            }
            i = i2;
            decodeJob = decodeJob22;
        }
        if (decodeJob != null) {
            try {
                if (this.f3475f.remove(decodeJob)) {
                    this.f3474e.push(decodeJob.m3429b());
                }
            } catch (Throwable e) {
                this.f3492w.a(f3470a, "evictToMakeSpace failed", e);
            }
        }
    }

    private ImageCacheKey m3431a(MediaItem mediaItem, int i) {
        ImageCacheKey imageCacheKey = (ImageCacheKey) this.f3484o.a(mediaItem.e());
        if (imageCacheKey == null) {
            Uri parse = Uri.parse(mediaItem.e());
            switch (C04462.f3456a[mediaItem.l().ordinal()]) {
                case 1:
                    int g = mediaItem.g();
                    OptionsBuilder newBuilder = Options.newBuilder();
                    newBuilder.e = true;
                    imageCacheKey = new ImageCacheKey(parse, newBuilder.a(i, i).f(), StringFormatUtil.formatStrLocaleSafe(":%d:%s", Integer.valueOf(g), "GridImageThumbnails"));
                    break;
                default:
                    imageCacheKey = new ImageCacheKey(parse, ImageCacheKey.c, "GridImageThumbnails");
                    break;
            }
            this.f3484o.a(mediaItem.e(), imageCacheKey);
        }
        return imageCacheKey;
    }
}
