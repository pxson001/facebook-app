package com.facebook.widget.images;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.R;
import com.facebook.common.activitylistener.ActivityListener;
import com.facebook.common.activitylistener.ActivityListenerManager;
import com.facebook.common.activitylistener.BaseActivityListener;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider;
import com.facebook.common.io.FbCloseables;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.common.userinteraction.UserInteractionListener;
import com.facebook.common.util.StringUtil;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.debug.log.BLog;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneController.FeatureType;
import com.facebook.dialtone.DialtoneController.PlaceholderState;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.dialtone.UpgradeButtonDrawable;
import com.facebook.dialtone.common.DialtoneStateChangedListener;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.SettableDataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.internal.ImageRequestBuilderFactory;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.images.base.UrlImageProcessor;
import com.facebook.ui.images.fetch.FetchImageParams;
import com.facebook.ui.images.fetch.FetchImageParams.Builder;
import com.facebook.ui.images.fetch.FetchImagePerfLogger;
import com.facebook.ui.images.fetch.FetchImagePerfLogger$ImageDimensions;
import com.facebook.ui.images.fetch.FetchImagePerfLogger.OperationResult;
import com.facebook.ui.images.fetch.FetchImageProgressHandler;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.FacebookProgressCircleViewAnimated;
import com.facebook.widget.RecyclableView;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Absent;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Platform;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.Closeable;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

@Deprecated
/* compiled from: reply_to_mention_clicked */
public class UrlImage extends CustomViewGroup implements RecyclableView {
    private static final Handler ak = new Handler(Looper.getMainLooper());
    private static final Runnable al = new C03421();
    @VisibleForTesting
    static final Set<UrlImage> f5855h = Platform.a(new IdentityHashMap());
    private static int f5856i = 0;
    private static int f5857j = 0;
    private static final ScaleType[] f5858k = new ScaleType[]{ScaleType.MATRIX, ScaleType.FIT_XY, ScaleType.FIT_START, ScaleType.FIT_CENTER, ScaleType.FIT_END, ScaleType.CENTER, ScaleType.CENTER_CROP, ScaleType.CENTER_INSIDE};
    private static final Matrix f5859l = new Matrix();
    public Optional<View> f5860A;
    private final ImageSpec f5861B;
    private ImageSpec f5862C;
    private Postprocessor f5863D;
    public ProgressBarMode f5864E;
    private Animation f5865F;
    @Nullable
    public OnImageDownloadListener f5866G;
    public OnModeChangedListener f5867H;
    private UrlImageProgressListener f5868I;
    private Optional<View> f5869J;
    public Optional<DialtoneStateChangedListener> f5870K;
    private boolean f5871L;
    private final boolean f5872M;
    private final boolean f5873N;
    private int f5874O;
    private boolean f5875P;
    private boolean f5876Q;
    public boolean f5877R;
    private boolean f5878S;
    private CallerContext f5879T;
    private boolean f5880U;
    public int f5881V;
    private int f5882W;
    @VisibleForTesting
    final ImageSpec f5883a;
    private boolean aa;
    public boolean ab;
    private boolean ac;
    private ImagePipeline ad;
    public DrawableUtil ae;
    private int af;
    private final UserInteractionListener ag;
    private boolean ah;
    private UpgradeButtonDrawable ai;
    public boolean aj;
    private final ActivityListener am;
    @VisibleForTesting
    ImmutableList<ImageRequest> f5884b;
    @VisibleForTesting
    DataSource f5885c;
    @VisibleForTesting
    CurrentMode f5886d;
    @VisibleForTesting
    boolean f5887e;
    @VisibleForTesting
    boolean f5888f;
    protected DialtoneController f5889g;
    private String f5890m;
    private FirstAvailableImageUrisHelper f5891n;
    private LayoutInflater f5892o;
    private Executor f5893p;
    private FetchImagePerfLogger f5894q;
    private AnalyticsTagger f5895r;
    public PerfTestConfig f5896s;
    private DefaultUserInteractionController f5897t;
    private MarkerConfig f5898u;
    private ImageCacheReader f5899v;
    private MonotonicClock f5900w;
    private OnClickListener f5901x;
    public final ImageView f5902y;
    public final ImageView f5903z;

    /* compiled from: reply_to_mention_clicked */
    final class C03421 implements Runnable {
        C03421() {
        }

        public final void run() {
            UrlImage.m8428b();
        }
    }

    /* compiled from: reply_to_mention_clicked */
    class C03432 extends BaseActivityListener {
        final /* synthetic */ UrlImage f5837a;

        C03432(UrlImage urlImage) {
            this.f5837a = urlImage;
        }

        public final void m8394b(Activity activity) {
            UrlImage.setActivityStarted(this.f5837a, true);
        }

        public final void m8395e(Activity activity) {
            UrlImage.setActivityStarted(this.f5837a, false);
        }
    }

    /* compiled from: reply_to_mention_clicked */
    class C03443 implements UserInteractionListener {
        final /* synthetic */ UrlImage f5838a;

        C03443(UrlImage urlImage) {
            this.f5838a = urlImage;
        }

        public final void m8396a(boolean z) {
            this.f5838a.m8465a(z);
        }
    }

    /* compiled from: reply_to_mention_clicked */
    class C03454 implements DialtoneStateChangedListener {
        final /* synthetic */ UrlImage f5839a;

        C03454(UrlImage urlImage) {
            this.f5839a = urlImage;
        }

        public final void iw_() {
        }

        public final void b_(boolean z) {
            if (z) {
                UrlImage.m8435f(this.f5839a);
            } else {
                PerfTestConfig perfTestConfig = this.f5839a.f5896s;
                if (PerfTestConfigBase.b() || this.f5839a.ab) {
                    UrlImage.m8458w(this.f5839a);
                }
                UrlImage.setMode(this.f5839a, CurrentMode.PROGRESS_BAR);
            }
            this.f5839a.m8467c();
            this.f5839a.f5889g.b((DialtoneStateChangedListener) this.f5839a.f5870K.orNull());
        }
    }

    /* compiled from: reply_to_mention_clicked */
    class C03465 implements OnClickListener {
        final /* synthetic */ UrlImage f5840a;

        C03465(UrlImage urlImage) {
            this.f5840a = urlImage;
        }

        public void onClick(View view) {
            Uri uri;
            boolean z;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1293921371);
            DialtoneController dialtoneController = this.f5840a.f5889g;
            DialtoneStateChangedListener dialtoneStateChangedListener = (DialtoneStateChangedListener) this.f5840a.f5870K.get();
            if (this.f5840a.f5883a.f5844a == null) {
                uri = null;
            } else {
                uri = this.f5840a.f5883a.f5844a.a;
            }
            if (this.f5840a.ae) {
                z = false;
            } else {
                z = true;
            }
            dialtoneController.a(dialtoneStateChangedListener, uri, z);
            LogUtils.a(-1940518315, a);
        }
    }

    /* compiled from: reply_to_mention_clicked */
    class C03476 extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
        final /* synthetic */ UrlImage f5841a;

        C03476(UrlImage urlImage) {
            this.f5841a = urlImage;
        }

        public final void m8397e(DataSource<CloseableReference<CloseableImage>> dataSource) {
            if (dataSource.b()) {
                CloseableReference closeableReference = (CloseableReference) dataSource.d();
                Drawable a = closeableReference == null ? null : this.f5841a.ae.a(closeableReference);
                if (a == null) {
                    this.f5841a.aj = true;
                }
                this.f5841a.m8462a(a, (DataSource) dataSource);
            }
        }

        public final void m8398f(DataSource<CloseableReference<CloseableImage>> dataSource) {
            this.f5841a.aj = true;
            this.f5841a.m8464a(dataSource.e(), (DataSource) dataSource);
        }
    }

    /* compiled from: reply_to_mention_clicked */
    class C03487 implements AnimationListener {
        final /* synthetic */ UrlImage f5842a;

        C03487(UrlImage urlImage) {
            this.f5842a = urlImage;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            this.f5842a.f5902y.setVisibility(4);
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: reply_to_mention_clicked */
    public enum CurrentMode {
        PLACEHOLDER,
        LOADED_IMAGE,
        PROGRESS_BAR
    }

    @VisibleForTesting
    /* compiled from: reply_to_mention_clicked */
    class ImageSpec {
        FetchImageParams f5844a;
        Drawable f5845b;
        Integer f5846c;
        Drawable f5847d;
        Integer f5848e;
        ScaleType f5849f;
        Matrix f5850g;
        boolean f5851h;

        ImageSpec() {
        }

        final boolean m8399a(@Nullable FetchImageParams fetchImageParams) {
            boolean z;
            FetchImageParams fetchImageParams2 = this.f5844a;
            if (fetchImageParams == null && fetchImageParams2 == null) {
                z = true;
            } else if (fetchImageParams == null || fetchImageParams2 == null) {
                z = false;
            } else {
                boolean z2 = Objects.equal(fetchImageParams.a, fetchImageParams2.a) && Objects.equal(fetchImageParams.e, fetchImageParams2.e) && Objects.equal(fetchImageParams.f, fetchImageParams2.f);
                z = z2;
            }
            return z;
        }

        public String toString() {
            return Objects.toStringHelper(this).add("fetchImageParams", this.f5844a).add("drawableFromFetchImageParams", this.f5845b).add("resourceId", this.f5846c).add("drawable", this.f5847d).toString();
        }
    }

    /* compiled from: reply_to_mention_clicked */
    public abstract class OnImageDownloadListener {
        public void m8400a() {
        }
    }

    /* compiled from: reply_to_mention_clicked */
    public interface OnModeChangedListener {
        void m8401a(CurrentMode currentMode);

        void m8402b(CurrentMode currentMode);
    }

    /* compiled from: reply_to_mention_clicked */
    public enum ProgressBarMode {
        PROGRESS_BAR_HIDDEN,
        PROGRESS_BAR_INDETERMINATE,
        PROGRESS_BAR_DETERMINATE_WITH_PLACEHOLDER,
        PROGRESS_BAR_INDETERMINATE_WITH_PLACEHOLDER
    }

    /* compiled from: reply_to_mention_clicked */
    public class UrlImageProgressHandler extends FetchImageProgressHandler {
        final /* synthetic */ UrlImage f5852a;

        protected UrlImageProgressHandler(UrlImage urlImage) {
            this.f5852a = urlImage;
        }

        protected final void mo395b(int i) {
            if (this.f5852a.f5864E == ProgressBarMode.PROGRESS_BAR_DETERMINATE_WITH_PLACEHOLDER && this.f5852a.f5860A.isPresent() && i > this.f5852a.f5881V) {
                this.f5852a.f5881V = i;
                ((FacebookProgressCircleViewAnimated) this.f5852a.f5860A.get()).setProgress((long) this.f5852a.f5881V);
            }
        }
    }

    /* compiled from: reply_to_mention_clicked */
    public class UrlImageProgressListener {
        final /* synthetic */ UrlImage f5853a;
        private final UrlImageProgressHandler f5854b;

        UrlImageProgressListener(UrlImage urlImage, UrlImageProgressHandler urlImageProgressHandler) {
            this.f5853a = urlImage;
            this.f5854b = urlImageProgressHandler;
        }

        public final void m8404a(int i) {
            Message obtainMessage = this.f5854b.obtainMessage(1);
            obtainMessage.arg1 = i;
            obtainMessage.sendToTarget();
        }
    }

    private static <T extends View> void m8421a(Class<T> cls, T t) {
        m8422a((Object) t, t.getContext());
    }

    private static void m8422a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((UrlImage) obj).m8417a(DrawableUtil.a(injectorLike), FirstAvailableImageUrisHelper.m8363b(injectorLike), LayoutInflaterMethodAutoProvider.b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider.a(injectorLike), FetchImagePerfLogger.a(injectorLike), AnalyticsTagger.a(injectorLike), PerfTestConfig.a(injectorLike), DefaultUserInteractionController.a(injectorLike), ImagePipelineMethodAutoProvider.a(injectorLike), ImageCacheReader.m8365b(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (DialtoneController) DialtoneControllerImpl.a(injectorLike));
    }

    private int getShortId() {
        return hashCode() % 1000;
    }

    private int getFetchUrlHashCode() {
        return this.f5883a.f5844a == null ? 0 : System.identityHashCode(this.f5883a.f5844a.a);
    }

    public UrlImage(Context context) {
        this(context, null, 0);
    }

    public UrlImage(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UrlImage(Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 2131624745);
    }

    public UrlImage(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.f5861B = new ImageSpec();
        this.f5862C = null;
        this.f5883a = new ImageSpec();
        this.f5877R = false;
        this.f5887e = false;
        this.f5888f = false;
        this.f5878S = true;
        this.f5881V = 0;
        this.f5882W = 0;
        this.ac = false;
        this.af = 0;
        this.aj = false;
        this.am = new C03432(this);
        m8421a(UrlImage.class, (View) this);
        this.f5861B.f5849f = ScaleType.CENTER_INSIDE;
        this.f5883a.f5849f = ScaleType.FIT_CENTER;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UrlImage, i, i2);
        this.f5873N = obtainStyledAttributes.getBoolean(6, false);
        this.f5880U = this.f5873N;
        this.f5872M = obtainStyledAttributes.getBoolean(3, false);
        boolean z = obtainStyledAttributes.getBoolean(4, false);
        if (this.f5872M && this.f5873N) {
            this.f5892o.inflate(2130905916, this);
        } else if (this.f5872M) {
            this.f5892o.inflate(2130905915, this);
        } else if (z) {
            this.f5892o.inflate(2130905918, this);
        } else if (this.f5873N) {
            this.f5892o.inflate(2130905917, this);
        } else {
            this.f5892o.inflate(2130905914, this);
        }
        this.f5875P = obtainStyledAttributes.hasValue(8);
        this.f5874O = obtainStyledAttributes.getColor(8, 0);
        this.f5903z = (ImageView) getView(2131565266);
        this.f5902y = (ImageView) getOptionalView(2131565268).or(this.f5903z);
        this.f5860A = Absent.INSTANCE;
        this.f5869J = Absent.INSTANCE;
        this.f5868I = new UrlImageProgressListener(this, new UrlImageProgressHandler(this));
        this.f5869J = Absent.INSTANCE;
        Object string = obtainStyledAttributes.getString(0);
        if (!StringUtil.a(string)) {
            FetchImageParams fetchImageParams;
            ImageSpec imageSpec = this.f5883a;
            if (StringUtil.a(string)) {
                fetchImageParams = null;
            } else {
                Uri parse = Uri.parse(string);
                fetchImageParams = parse == null ? null : FetchImageParams.a(parse).a();
            }
            imageSpec.f5844a = fetchImageParams;
        }
        int i3 = obtainStyledAttributes.getInt(10, -1);
        if (i3 >= 0) {
            this.f5883a.f5849f = f5858k[i3];
        }
        this.f5883a.f5851h = obtainStyledAttributes.getBoolean(7, false);
        i3 = obtainStyledAttributes.getInt(9, -1);
        if (i3 >= 0) {
            this.f5861B.f5849f = f5858k[i3];
        }
        this.f5864E = obtainStyledAttributes.getBoolean(2, false) ? ProgressBarMode.PROGRESS_BAR_INDETERMINATE : ProgressBarMode.PROGRESS_BAR_HIDDEN;
        this.f5861B.f5846c = Integer.valueOf(obtainStyledAttributes.getResourceId(1, 0));
        this.f5886d = CurrentMode.PLACEHOLDER;
        this.f5870K = Absent.INSTANCE;
        m8442i();
        if (m8444j()) {
            m8435f(this);
        } else if (this.f5861B.f5846c.intValue() != 0) {
            this.f5902y.setImageResource(this.f5861B.f5846c.intValue());
        }
        this.f5902y.setScaleType(this.f5861B.f5849f);
        this.f5876Q = obtainStyledAttributes.getBoolean(5, false);
        obtainStyledAttributes.recycle();
        this.ag = new C03443(this);
        this.f5897t.a(this.ag);
        ActivityListenerManager.a(this.am, context);
    }

    @Inject
    private void m8417a(DrawableUtil drawableUtil, FirstAvailableImageUrisHelper firstAvailableImageUrisHelper, LayoutInflater layoutInflater, Executor executor, FetchImagePerfLogger fetchImagePerfLogger, AnalyticsTagger analyticsTagger, PerfTestConfig perfTestConfig, DefaultUserInteractionController defaultUserInteractionController, ImagePipeline imagePipeline, ImageCacheReader imageCacheReader, MonotonicClock monotonicClock, DialtoneController dialtoneController) {
        this.ae = drawableUtil;
        this.f5891n = firstAvailableImageUrisHelper;
        this.f5892o = layoutInflater;
        this.f5893p = executor;
        this.f5894q = fetchImagePerfLogger;
        this.f5895r = analyticsTagger;
        this.f5896s = perfTestConfig;
        this.f5897t = defaultUserInteractionController;
        this.ad = imagePipeline;
        this.f5899v = imageCacheReader;
        this.f5900w = monotonicClock;
        this.f5889g = dialtoneController;
    }

    public void setDoFetchImagePerfLogging(boolean z) {
        this.ab = z;
    }

    private void m8411a(int i) {
        if (i > 0) {
            if (this.f5869J.isPresent()) {
                if (this.f5872M) {
                    ((FrameLayout) findViewById(2131565267)).removeView((View) this.f5869J.get());
                } else {
                    removeView((View) this.f5869J.get());
                }
            }
            if (this.f5889g.j() && m8444j()) {
                if (this.ai == null) {
                    this.ai = new UpgradeButtonDrawable(this.f5889g, new PlaceholderState(this.f5890m, 0, FeatureType.PHOTO));
                }
                View view = new View(getContext());
                view.setBackgroundDrawable(this.ai);
                this.f5869J = Optional.of(view);
            } else {
                this.f5869J = Optional.of(this.f5892o.inflate(i, this, false));
            }
            this.f5870K = Optional.of(new C03454(this));
            ((View) this.f5869J.get()).setOnClickListener(this.f5901x);
            if (this.f5872M) {
                ((FrameLayout) findViewById(2131565267)).addView((View) this.f5869J.get());
            } else {
                addView((View) this.f5869J.get());
            }
        }
    }

    public static void m8435f(UrlImage urlImage) {
        urlImage.f5901x = new C03465(urlImage);
        urlImage.f5902y.setImageResource(urlImage.getDialtonePlaceholderImageSpec().f5846c.intValue());
        urlImage.m8411a(2130903908);
    }

    public static boolean m8438g(UrlImage urlImage) {
        return urlImage.f5889g.b(urlImage.f5890m);
    }

    private ImageSpec getDialtonePlaceholderImageSpec() {
        if (this.f5862C == null) {
            this.f5862C = new ImageSpec();
            this.f5862C.f5849f = ScaleType.FIT_XY;
            this.f5862C.f5846c = Integer.valueOf(2130838405);
        }
        return this.f5862C;
    }

    private boolean m8440h() {
        return this.f5883a.f5844a != null && this.f5889g.a(this.f5883a.f5844a.a, this.f5879T);
    }

    public void setIsDialtoneWhitelisted(boolean z) {
        this.ah = z;
    }

    private void m8442i() {
        this.f5890m = null;
        try {
            this.f5890m = getResources().getResourceEntryName(getId());
        } catch (NotFoundException e) {
        }
        this.ah = this.f5889g.a(this.f5890m, this.f5879T);
    }

    public void setId(int i) {
        super.setId(i);
        m8442i();
    }

    private boolean m8444j() {
        return (!this.f5889g.j() || this.ah || m8440h()) ? false : true;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1439820559);
        if (BLog.b(2)) {
            Long.valueOf(this.f5900w.now());
            Integer.valueOf(getShortId());
        }
        super.onAttachedToWindow();
        if (!this.f5887e) {
            this.f5877R = true;
            this.f5879T = AnalyticsTagger.b(this);
            if (m8444j()) {
                this.f5889g.a((DialtoneStateChangedListener) this.f5870K.orNull());
            }
            m8447l();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1506051200, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1036041479);
        if (BLog.b(2)) {
            Long.valueOf(this.f5900w.now());
            Integer.valueOf(getShortId());
        }
        super.onDetachedFromWindow();
        this.f5877R = false;
        m8448m();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 927449153, a);
    }

    private String m8446k() {
        if (!BLog.b(2)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        View view;
        while (view.getParent() instanceof View) {
            View view2 = (View) view.getParent();
            stringBuilder.append(view2.getClass().getName());
            stringBuilder.append(" <- ");
            view = view2;
        }
        stringBuilder.append('\n');
        return stringBuilder.toString();
    }

    public void onFinishTemporaryDetach() {
        boolean z = false;
        if (BLog.b(2)) {
            Long.valueOf(this.f5900w.now());
            Integer.valueOf(getShortId());
        }
        if (AnalyticsTagger.b(this) != null) {
            this.f5879T = AnalyticsTagger.b(this);
        }
        if (!m8449n()) {
            f5857j++;
            m8423a("onFinishTemporaryDetach");
        }
        this.f5888f = false;
        if (this.f5885c == null && this.f5883a.f5845b == null) {
            z = true;
        }
        if (z || this.f5876Q) {
            if (BLog.b(2)) {
                Long.valueOf(this.f5900w.now());
                Integer.valueOf(getShortId());
                Integer.valueOf(getFetchUrlHashCode());
            }
            m8467c();
        }
    }

    public void onStartTemporaryDetach() {
        if (BLog.b(2)) {
            Long.valueOf(this.f5900w.now());
            Integer.valueOf(getShortId());
        }
        super.onStartTemporaryDetach();
        if (m8449n()) {
            f5857j--;
            m8423a("onStartTemporaryDetach");
        }
        this.f5888f = true;
        if (BLog.b(2)) {
            Long.valueOf(this.f5900w.now());
            Integer.valueOf(getShortId());
        }
        m8453r();
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (!this.f5875P) {
            return;
        }
        if (isPressed() && this.aa) {
            Mode mode = Mode.SRC_OVER;
            this.f5903z.setColorFilter(this.f5874O, mode);
            this.f5902y.setColorFilter(this.f5874O, mode);
            return;
        }
        this.f5903z.setColorFilter(null);
        this.f5902y.setColorFilter(null);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.aa = onClickListener != null;
    }

    private void m8447l() {
        if (!m8449n()) {
            f5857j++;
            m8423a("onAttachingToViewTree");
        }
        this.f5887e = true;
        this.f5888f = false;
        m8461z();
    }

    @VisibleForTesting
    private void m8448m() {
        if (m8449n()) {
            f5857j--;
            m8423a("onDetachedFromViewTree");
        }
        this.f5887e = false;
        m8453r();
    }

    private boolean m8449n() {
        return this.f5887e && !this.f5888f;
    }

    private void m8423a(String str) {
        if (BLog.b(2)) {
            Object[] objArr = new Object[]{Long.valueOf(this.f5900w.now()), Integer.valueOf(getShortId()), str, Integer.valueOf(f5856i), Integer.valueOf(f5857j)};
        }
    }

    @VisibleForTesting
    private void m8450o() {
        if (BLog.b(2)) {
            Long.valueOf(this.f5900w.now());
            Integer.valueOf(getShortId());
        }
        m8456u();
        m8454s();
    }

    @VisibleForTesting
    private void m8451p() {
        if (BLog.b(2)) {
            Long.valueOf(this.f5900w.now());
            Integer.valueOf(getShortId());
        }
        m8455t();
    }

    @VisibleForTesting
    private void m8452q() {
        if (BLog.b(2)) {
            Long.valueOf(this.f5900w.now());
            Integer.valueOf(getShortId());
        }
        m8450o();
        m8451p();
    }

    @VisibleForTesting
    private void m8453r() {
        if (this.f5885c != null || this.f5883a.f5845b != null || this.f5861B.f5845b != null) {
            f5855h.add(this);
            if (f5855h.size() == 1) {
                HandlerDetour.a(ak, al, 17760119);
            }
        }
    }

    @VisibleForTesting
    static void m8428b() {
        if (BLog.b(2)) {
            Integer.valueOf(f5855h.size());
        }
        for (UrlImage urlImage : f5855h) {
            if (urlImage.f5888f || !urlImage.f5887e) {
                urlImage.m8452q();
            }
        }
        f5855h.clear();
    }

    private static boolean m8425a(ImageView imageView, @Nullable Drawable drawable) {
        Drawable drawable2 = imageView.getDrawable();
        if (drawable == null) {
            return false;
        }
        if (drawable == drawable2) {
            return true;
        }
        if (!(drawable2 instanceof LayerDrawable)) {
            return false;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable2;
        for (int i = 0; i < layerDrawable.getNumberOfLayers(); i++) {
            if (layerDrawable.getDrawable(i) == drawable) {
                return true;
            }
        }
        return false;
    }

    private static void m8429b(ImageView imageView, @Nullable Drawable drawable) {
        if (m8425a(imageView, drawable)) {
            m8431c(imageView, null);
            drawable.setCallback(null);
        }
    }

    @VisibleForTesting
    private void m8454s() {
        if (this.f5883a != null) {
            m8429b(this.f5903z, this.f5883a.f5845b);
            if (this.f5883a.f5845b instanceof Closeable) {
                if (BLog.b(2)) {
                    Long.valueOf(this.f5900w.now());
                    Integer.valueOf(getShortId());
                    Integer.valueOf(System.identityHashCode(this.f5883a.f5845b));
                }
                FbCloseables.a((Closeable) this.f5883a.f5845b);
                f5856i--;
                m8423a("closeImageDrawable");
            } else if (this.f5883a.f5845b != null && BLog.b(2)) {
                Long.valueOf(this.f5900w.now());
                Integer.valueOf(getShortId());
                Integer.valueOf(System.identityHashCode(this.f5883a.f5845b));
            }
            this.f5883a.f5845b = null;
            if (this.f5886d != CurrentMode.PLACEHOLDER) {
                setLoadingMode(CurrentMode.PLACEHOLDER);
            }
        }
    }

    @VisibleForTesting
    private void m8455t() {
        if (this.f5861B != null) {
            m8429b(this.f5902y, this.f5861B.f5845b);
            if (this.f5861B.f5845b instanceof Closeable) {
                if (BLog.b(2)) {
                    Long.valueOf(this.f5900w.now());
                    Integer.valueOf(getShortId());
                    Integer.valueOf(System.identityHashCode(this.f5861B.f5845b));
                }
                FbCloseables.a((Closeable) this.f5861B.f5845b);
                f5856i--;
                m8423a("closePlaceholderDrawable");
            }
            this.f5861B.f5845b = null;
        }
    }

    public FetchImageParams getImageParams() {
        return this.f5883a.f5844a;
    }

    public void setImageParams(@Nullable Uri uri) {
        if (uri == null) {
            setImageParams(null);
        } else {
            m8413a(uri, null);
        }
    }

    @Deprecated
    private void m8413a(@Nullable Uri uri, @Nullable UrlImageProcessor urlImageProcessor) {
        if (uri == null) {
            setImageParams(null);
            return;
        }
        Builder a = FetchImageParams.a(uri);
        a.d = urlImageProcessor;
        setImageParams(a.a());
    }

    public void setImageParams(@Nullable FetchImageParams fetchImageParams) {
        m8463a(fetchImageParams, null);
    }

    public final void m8463a(@Nullable FetchImageParams fetchImageParams, @Nullable Postprocessor postprocessor) {
        this.f5863D = postprocessor;
        if (!this.f5883a.m8399a(fetchImageParams)) {
            if (BLog.b(2)) {
                int i;
                Object[] objArr = new Object[5];
                objArr[0] = Long.valueOf(this.f5900w.now());
                objArr[1] = Integer.valueOf(getShortId());
                objArr[2] = Integer.valueOf(getFetchUrlHashCode());
                if (fetchImageParams == null) {
                    i = 0;
                } else {
                    i = System.identityHashCode(fetchImageParams.a);
                }
                objArr[3] = Integer.valueOf(i);
                objArr[4] = m8446k();
            }
            this.f5884b = null;
            m8456u();
            if (!this.f5876Q) {
                m8454s();
            }
            if (fetchImageParams == null) {
                this.f5883a.f5844a = null;
            } else {
                m8409E();
                this.f5882W = 0;
                this.f5883a.f5844a = fetchImageParams;
                if (BLog.b(2)) {
                    Long.valueOf(this.f5900w.now());
                    Integer.valueOf(getShortId());
                }
                if (PerfTestConfigBase.b() || this.ab) {
                    m8458w(this);
                }
            }
            m8467c();
        }
    }

    public FetchImageParams getPlaceholderImageParams() {
        return this.f5861B.f5844a;
    }

    public void setPlaceholderImageParams(@Nullable FetchImageParams fetchImageParams) {
        if (!this.f5861B.m8399a(fetchImageParams)) {
            m8455t();
            if (fetchImageParams == null) {
                this.f5861B.f5844a = null;
                this.f5861B.f5845b = null;
            } else {
                this.f5861B.f5844a = fetchImageParams;
                if (this.f5887e) {
                    this.f5861B.f5845b = this.f5899v.m8367a(fetchImageParams);
                    if (this.f5861B.f5845b instanceof Closeable) {
                        f5856i++;
                        m8423a("setPlaceholderImageParams");
                    }
                }
            }
            if (this.f5887e && this.f5886d == CurrentMode.PLACEHOLDER) {
                setMode(this, CurrentMode.PLACEHOLDER);
            }
        }
    }

    public void setOnImageDownloadListener(@Nullable OnImageDownloadListener onImageDownloadListener) {
        this.f5866G = onImageDownloadListener;
    }

    public void setOnModeChangedListener(OnModeChangedListener onModeChangedListener) {
        this.f5867H = onModeChangedListener;
    }

    public ScaleType getScaleType() {
        return this.f5883a.f5849f;
    }

    public void setScaleType(ScaleType scaleType) {
        this.f5883a.f5849f = scaleType;
        if (this.f5886d == CurrentMode.LOADED_IMAGE) {
            this.f5903z.setScaleType(scaleType);
        }
    }

    public void setImageMatrix(Matrix matrix) {
        this.f5883a.f5850g = matrix;
        if (this.f5886d == CurrentMode.LOADED_IMAGE) {
            this.f5903z.setImageMatrix(matrix);
        }
    }

    public void setAdjustViewBounds(boolean z) {
        this.f5883a.f5851h = z;
        if (this.f5886d == CurrentMode.LOADED_IMAGE) {
            this.f5903z.setAdjustViewBounds(z);
        }
    }

    public boolean getAdjustViewBounds() {
        return this.f5883a.f5851h;
    }

    public void setPlaceHolderResourceId(int i) {
        this.f5861B.f5846c = Integer.valueOf(i);
        this.f5861B.f5847d = null;
        if (this.f5886d == CurrentMode.PLACEHOLDER && !m8444j()) {
            this.f5902y.setImageResource(i);
        }
    }

    public int getPlaceHolderResourceId() {
        return this.f5861B.f5846c.intValue();
    }

    public void setPlaceHolderDrawable(@Nullable Drawable drawable) {
        this.f5861B.f5846c = null;
        this.f5861B.f5847d = drawable;
        if (this.f5886d == CurrentMode.PLACEHOLDER && !m8444j()) {
            this.f5902y.setImageDrawable(drawable);
        }
    }

    @Deprecated
    public Drawable getImageDrawable() {
        return this.f5883a.f5845b;
    }

    @Deprecated
    public Bitmap getBitmap() {
        if (this.f5883a.f5845b == null) {
            return null;
        }
        if (this.f5883a.f5845b instanceof CloseableBitmapDrawable) {
            Bitmap bitmap;
            CloseableBitmapDrawable closeableBitmapDrawable = (CloseableBitmapDrawable) this.f5883a.f5845b;
            if (closeableBitmapDrawable.m8357c()) {
                bitmap = null;
            } else {
                bitmap = ((CloseableBitmap) ((CloseableImage) closeableBitmapDrawable.f5757a.a())).a();
            }
            return bitmap;
        } else if (this.f5883a.f5845b instanceof BitmapDrawable) {
            return ((BitmapDrawable) this.f5883a.f5845b).getBitmap();
        } else {
            return null;
        }
    }

    public void setPlaceholderBackgroundResourceId(int i) {
        this.f5861B.f5848e = Integer.valueOf(i);
        if (this.f5886d == CurrentMode.PLACEHOLDER) {
            this.f5903z.setBackgroundResource(i);
        }
    }

    public void setPressedOverlayColorResourceId(int i) {
        if (i <= 0) {
            this.f5874O = 0;
            this.f5875P = false;
            return;
        }
        this.f5874O = getResources().getColor(i);
        this.f5875P = true;
    }

    public void setPlaceHolderScaleType(ScaleType scaleType) {
        this.f5861B.f5849f = scaleType;
        if (this.f5886d == CurrentMode.PLACEHOLDER) {
            this.f5902y.setScaleType(scaleType);
        }
    }

    public void setProgressBarMode(ProgressBarMode progressBarMode) {
        this.f5864E = progressBarMode;
        m8408D();
        if (progressBarMode != ProgressBarMode.PROGRESS_BAR_HIDDEN && this.f5860A.isPresent()) {
            if (this.f5872M) {
                ((FrameLayout) findViewById(2131565267)).addView((View) this.f5860A.get());
            } else {
                addView((View) this.f5860A.get());
            }
        }
    }

    public void setRetainImageDuringUpdate(boolean z) {
        this.f5876Q = z;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m8405A();
    }

    public final void m8465a(boolean z) {
        this.f5871L = z;
        this.f5894q.a(!z);
    }

    @VisibleForTesting
    final void m8467c() {
        if (!this.f5887e) {
            return;
        }
        if (!this.f5888f && this.f5878S) {
            m8461z();
        } else if (BLog.b(2)) {
            Long.valueOf(this.f5900w.now());
            Integer.valueOf(getShortId());
        }
    }

    @VisibleForTesting
    private void m8456u() {
        if (this.f5885c != null) {
            if (BLog.b(2)) {
                Long.valueOf(this.f5900w.now());
                Integer.valueOf(getShortId());
                Integer.valueOf(getFetchUrlHashCode());
            }
            if (this.f5885c != null) {
                this.f5885c.g();
                this.f5885c = null;
            }
            if (BLog.b(2)) {
                Long.valueOf(this.f5900w.now());
                Integer.valueOf(getShortId());
                Long.valueOf(this.f5900w.now());
                Integer.valueOf(getShortId());
            }
            m8415a(OperationResult.CANCELLED);
            m8416a(OperationResult.CANCELLED, null);
        }
    }

    @VisibleForTesting
    ImmutableList<ImageRequest> getOrCreateRequests() {
        if (this.f5884b == null) {
            ImageRequestBuilder a = ImageRequestBuilderFactory.a(this.f5883a.f5844a, getContext().getResources());
            a.j = this.f5863D;
            ImageRequestBuilder imageRequestBuilder = a;
            if (this.f5883a.f5844a.c == null) {
                this.f5884b = ImmutableList.of(imageRequestBuilder.m());
            } else {
                ImmutableList.Builder builder = ImmutableList.builder();
                ImmutableList immutableList = this.f5883a.f5844a.c.f5122a;
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    builder.c(imageRequestBuilder.b((Uri) immutableList.get(i)).m());
                }
                this.f5884b = builder.b();
            }
        }
        return this.f5884b;
    }

    private void m8457v() {
        this.f5898u = this.f5894q.b(this.f5883a.f5844a.a, 5439490, "UrlImagePipelineExperiment");
    }

    private void m8415a(OperationResult operationResult) {
        if (this.f5898u != null) {
            Map c = Maps.c();
            c.put("operationResult", operationResult.toString());
            this.f5894q.a(this.f5898u, c);
            this.f5898u = null;
        }
    }

    public static void m8458w(UrlImage urlImage) {
        if (urlImage.f5883a.f5844a != null && urlImage.f5883a.f5844a.a != null) {
            urlImage.f5894q.b(urlImage.f5883a.f5844a.a, 5439489, "UrlImageBindModelToRender");
        }
    }

    private void m8416a(OperationResult operationResult, @Nullable Throwable th) {
        if (this.f5883a.f5844a != null && this.f5883a.f5844a.a != null) {
            this.f5894q.a(this.f5883a.f5844a.a, operationResult.toString(), null, th);
        }
    }

    @VisibleForTesting
    private void m8459x() {
        DataSource c;
        Executor a;
        if (this.f5883a.f5845b != null && BLog.b(2)) {
            Long.valueOf(this.f5900w.now());
            Integer.valueOf(getShortId());
            Integer.valueOf(System.identityHashCode(this.f5883a.f5845b));
        }
        ImmutableList<ImageRequest> orCreateRequests = getOrCreateRequests();
        if (orCreateRequests.size() == 1) {
            c = this.ad.c((ImageRequest) orCreateRequests.get(0), getCallerContext());
        } else {
            FirstAvailableImageUrisHelper firstAvailableImageUrisHelper = this.f5891n;
            CallerContext callerContext = getCallerContext();
            SettableDataSource settableDataSource = new SettableDataSource();
            for (ImageRequest b : orCreateRequests) {
                DataSource b2 = firstAvailableImageUrisHelper.f5797b.b(b, callerContext);
                Preconditions.checkState(b2.b(), "Bitmap-cache-only requests should be executed synchronously");
                CloseableReference closeableReference = (CloseableReference) b2.d();
                b2.g();
                if (closeableReference != null) {
                    settableDataSource.a(closeableReference);
                    closeableReference.close();
                    break;
                }
            }
            FirstAvailableImageUrisHelper.m8362a(firstAvailableImageUrisHelper, orCreateRequests.iterator(), settableDataSource, callerContext);
            c = settableDataSource;
        }
        if (BLog.b(2)) {
            Long.valueOf(this.f5900w.now());
            Integer.valueOf(getShortId());
            Integer.valueOf(getFetchUrlHashCode());
        }
        C03476 c03476 = new C03476(this);
        this.f5885c = c;
        if (this.f5885c.b()) {
            this.f5880U = false;
            a = MoreExecutors.a();
        } else {
            setLoadingMode(this.f5864E != ProgressBarMode.PROGRESS_BAR_HIDDEN ? CurrentMode.PROGRESS_BAR : CurrentMode.PLACEHOLDER);
            a = this.f5893p;
        }
        this.f5885c.a(c03476, a);
    }

    @VisibleForTesting
    final void m8462a(@Nullable Drawable drawable, DataSource dataSource) {
        if (dataSource == this.f5885c) {
            this.f5885c = null;
            if (drawable == null) {
                if (BLog.b(2)) {
                    Long.valueOf(this.f5900w.now());
                    Integer.valueOf(getShortId());
                }
                m8415a(OperationResult.FAILURE);
            } else {
                if (BLog.b(2)) {
                    Long.valueOf(this.f5900w.now());
                    Integer.valueOf(getShortId());
                }
                m8415a(OperationResult.SUCCESS);
            }
            m8412a(drawable);
            return;
        }
        if (BLog.b(2)) {
            Long.valueOf(this.f5900w.now());
            Integer.valueOf(getShortId());
            Integer.valueOf(System.identityHashCode(dataSource));
            Integer.valueOf(System.identityHashCode(this.f5885c));
        }
        if (drawable instanceof Closeable) {
            if (BLog.b(2)) {
                Long.valueOf(this.f5900w.now());
                Integer.valueOf(getShortId());
                Integer.valueOf(System.identityHashCode(drawable));
            }
            FbCloseables.a((Closeable) drawable);
        }
    }

    @VisibleForTesting
    final void m8464a(Throwable th, DataSource dataSource) {
        if (dataSource == this.f5885c) {
            this.f5885c = null;
            if (th instanceof CancellationException) {
                if (BLog.b(2)) {
                    Long.valueOf(this.f5900w.now());
                    Integer.valueOf(getShortId());
                }
                m8415a(OperationResult.CANCELLED);
            } else {
                if (BLog.b(2)) {
                    Long.valueOf(this.f5900w.now());
                    Integer.valueOf(getShortId());
                }
                m8415a(OperationResult.FAILURE);
            }
            m8424a(th);
        } else if (BLog.b(2)) {
            Long.valueOf(this.f5900w.now());
            Integer.valueOf(getShortId());
            Integer.valueOf(System.identityHashCode(dataSource));
            Integer.valueOf(System.identityHashCode(this.f5885c));
        }
    }

    private CallerContext m8460y() {
        if (PerfTestConfigBase.b() || this.ab) {
            return CallerContext.a(getClass(), "unknown", "instrumented_image_fetch");
        }
        return CallerContext.a(getClass(), "unknown");
    }

    private CallerContext getCallerContext() {
        if (this.f5879T == null) {
            this.f5879T = m8460y();
        }
        return this.f5879T;
    }

    @VisibleForTesting
    private void m8461z() {
        if (m8444j()) {
            setMode(this, CurrentMode.PLACEHOLDER);
            m8411a(2130903908);
            m8406B();
            return;
        }
        if (this.f5861B.f5844a != null && this.f5861B.f5845b == null) {
            this.f5861B.f5845b = this.f5899v.m8367a(this.f5861B.f5844a);
            if (this.f5861B.f5845b instanceof Closeable) {
                f5856i++;
                m8423a("updateImage");
            }
        }
        this.f5880U = this.f5873N;
        if (!this.f5876Q) {
            m8450o();
        }
        if (this.f5883a.f5844a == null) {
            setImageSpecDrawable(null);
            setMode(this, CurrentMode.PLACEHOLDER);
            return;
        }
        if (BLog.b(2)) {
            Long.valueOf(this.f5900w.now());
            Integer.valueOf(getShortId());
        }
        if (PerfTestConfigBase.b() || this.ab) {
            m8457v();
        }
        m8459x();
    }

    private void m8405A() {
        if (!this.ac) {
            return;
        }
        if (getWidth() != 0 || getHeight() != 0) {
            Drawable imageDrawable = getImageDrawable();
            if (imageDrawable != null && this.f5886d == CurrentMode.LOADED_IMAGE) {
                boolean z;
                int width = getWidth() - (getPaddingLeft() + getPaddingRight());
                int height = getHeight() - (getPaddingTop() + getPaddingBottom());
                FetchImagePerfLogger fetchImagePerfLogger = this.f5894q;
                int intrinsicWidth = imageDrawable.getIntrinsicWidth();
                int intrinsicHeight = imageDrawable.getIntrinsicHeight();
                FetchImagePerfLogger$ImageDimensions fetchImagePerfLogger$ImageDimensions = new FetchImagePerfLogger$ImageDimensions(fetchImagePerfLogger);
                fetchImagePerfLogger$ImageDimensions.f5117a = width;
                fetchImagePerfLogger$ImageDimensions.f5118b = height;
                fetchImagePerfLogger$ImageDimensions.f5119c = intrinsicWidth;
                fetchImagePerfLogger$ImageDimensions.f5120d = intrinsicHeight;
                fetchImagePerfLogger.f.addLast(fetchImagePerfLogger$ImageDimensions);
                FetchImagePerfLogger fetchImagePerfLogger2 = this.f5894q;
                if (this.f5871L) {
                    z = false;
                } else {
                    z = true;
                }
                fetchImagePerfLogger2.a(z);
                this.ac = false;
            }
        }
    }

    @VisibleForTesting
    private void m8412a(Drawable drawable) {
        if (drawable == null) {
            setMode(this, CurrentMode.PLACEHOLDER);
            m8406B();
            if (BLog.b(2)) {
                Long.valueOf(this.f5900w.now());
                Integer.valueOf(getShortId());
            }
            m8416a(OperationResult.FAILURE, null);
            return;
        }
        if (BLog.b(2)) {
            Long.valueOf(this.f5900w.now());
            Integer.valueOf(getShortId());
            Integer.valueOf(getFetchUrlHashCode());
            Integer.valueOf(System.identityHashCode(drawable));
        }
        setImageSpecDrawable(drawable);
        setMode(this, CurrentMode.LOADED_IMAGE);
        if (BLog.b(2)) {
            Long.valueOf(this.f5900w.now());
            Integer.valueOf(getShortId());
        }
        m8416a(OperationResult.SUCCESS, null);
        if (this.f5883a.f5844a != null) {
            this.f5868I.m8404a(100);
        }
        if (this.f5866G != null) {
            this.f5866G.m8400a();
        }
        m8405A();
    }

    private void m8424a(Throwable th) {
        if (th instanceof CancellationException) {
            if (BLog.b(2)) {
                Long.valueOf(this.f5900w.now());
                Integer.valueOf(getShortId());
            }
            m8416a(OperationResult.CANCELLED, th);
            return;
        }
        if (BLog.b(2)) {
            Long.valueOf(this.f5900w.now());
            Integer.valueOf(getShortId());
            Integer.valueOf(getFetchUrlHashCode());
        }
        setMode(this, CurrentMode.PLACEHOLDER);
        if (BLog.b(2)) {
            Long.valueOf(this.f5900w.now());
            Integer.valueOf(getShortId());
        }
        m8416a(OperationResult.FAILURE, th);
        m8406B();
    }

    @VisibleForTesting
    void setImageSpecDrawable(@Nullable Drawable drawable) {
        if (this.f5883a.f5845b instanceof Closeable) {
            m8429b(this.f5903z, this.f5883a.f5845b);
            FbCloseables.a((Closeable) this.f5883a.f5845b);
            if (!(this.f5876Q || drawable == null)) {
                BLog.c("UrlImage", "view %d: setImageSpecDrawable: having to explicitly close drawable %x", new Object[]{Integer.valueOf(getShortId()), Integer.valueOf(System.identityHashCode(this.f5883a.f5845b))});
            }
            f5856i--;
            m8423a("setImageSpecDrawable");
        }
        this.f5883a.f5845b = drawable;
        if (this.f5883a.f5845b instanceof Closeable) {
            f5856i++;
            m8423a("setImageSpecDrawable");
        }
    }

    private boolean m8406B() {
        if (!this.f5869J.isPresent() || this.f5882W >= 4) {
            return false;
        }
        m8409E();
        if (this.f5860A.isPresent()) {
            ((View) this.f5860A.get()).setVisibility(8);
        }
        if (this.f5869J.isPresent()) {
            this.f5882W++;
            ((View) this.f5869J.get()).setVisibility(0);
        }
        return true;
    }

    private void m8407C() {
        if (this.f5869J.isPresent() && !m8444j()) {
            ((View) this.f5869J.get()).setVisibility(8);
        }
    }

    private ImageSpec getInternalPlaceholderImageSpec() {
        return m8444j() ? getDialtonePlaceholderImageSpec() : this.f5861B;
    }

    public static void setMode(UrlImage urlImage, CurrentMode currentMode) {
        if (BLog.b(2)) {
            Long.valueOf(urlImage.f5900w.now());
            Integer.valueOf(urlImage.getShortId());
            currentMode.toString();
        }
        if (urlImage.f5867H != null) {
            urlImage.f5867H.m8401a(currentMode);
        }
        MarkerConfig markerConfig = null;
        if (urlImage.f5883a.f5844a != null) {
            markerConfig = urlImage.f5894q.a(urlImage.f5883a.f5844a.a, 5439499, "UrlImageLogMode");
        }
        if (urlImage.f5872M) {
            if (currentMode == CurrentMode.LOADED_IMAGE || currentMode == CurrentMode.PLACEHOLDER) {
                if (urlImage.f5860A.isPresent()) {
                    ((View) urlImage.f5860A.get()).setVisibility(8);
                }
                urlImage.m8407C();
            }
            if (currentMode == CurrentMode.PLACEHOLDER) {
                urlImage.f5903z.clearAnimation();
                if (urlImage.f5903z != urlImage.f5902y) {
                    urlImage.f5903z.setVisibility(4);
                    urlImage.f5902y.setVisibility(0);
                }
                urlImage.m8414a(urlImage.f5902y, urlImage.getInternalPlaceholderImageSpec(), currentMode);
            } else if (currentMode == CurrentMode.LOADED_IMAGE) {
                urlImage.f5903z.clearAnimation();
                urlImage.f5902y.setVisibility(4);
                urlImage.f5903z.setVisibility(0);
                urlImage.m8414a(urlImage.f5903z, urlImage.f5883a, currentMode);
                if (urlImage.f5880U) {
                    if (urlImage.f5902y != urlImage.f5903z) {
                        urlImage.m8414a(urlImage.f5902y, urlImage.getInternalPlaceholderImageSpec(), currentMode);
                    }
                    urlImage.f5903z.startAnimation(urlImage.getFadeInAnimation());
                }
            } else if (currentMode == CurrentMode.PROGRESS_BAR && urlImage.f5860A.isPresent()) {
                ((View) urlImage.f5860A.get()).setVisibility(0);
            }
        } else if (currentMode == CurrentMode.PROGRESS_BAR) {
            if (urlImage.f5864E == ProgressBarMode.PROGRESS_BAR_DETERMINATE_WITH_PLACEHOLDER || urlImage.f5864E == ProgressBarMode.PROGRESS_BAR_INDETERMINATE_WITH_PLACEHOLDER) {
                urlImage.m8414a(urlImage.f5903z, urlImage.f5861B, currentMode);
            } else {
                urlImage.f5903z.setVisibility(8);
                urlImage.f5902y.setVisibility(8);
            }
            urlImage.m8408D();
            urlImage.m8407C();
            if (urlImage.f5860A.isPresent()) {
                ((View) urlImage.f5860A.get()).setVisibility(0);
            }
            urlImage.f5903z.clearAnimation();
        } else if (currentMode == CurrentMode.PLACEHOLDER) {
            urlImage.f5903z.clearAnimation();
            if (urlImage.f5903z != urlImage.f5902y) {
                urlImage.f5903z.setVisibility(4);
                urlImage.f5902y.setVisibility(0);
            }
            if (urlImage.f5860A.isPresent()) {
                ((View) urlImage.f5860A.get()).setVisibility(8);
            }
            urlImage.m8414a(urlImage.f5902y, urlImage.getInternalPlaceholderImageSpec(), currentMode);
        } else if (currentMode == CurrentMode.LOADED_IMAGE) {
            if (!(urlImage.f5883a.f5844a == null || urlImage.f5883a.f5844a.a == null)) {
                urlImage.f5883a.f5844a.a.toString();
            }
            if (BLog.b(2)) {
                Long.valueOf(urlImage.f5900w.now());
                Integer.valueOf(urlImage.getShortId());
                Integer.valueOf(urlImage.getFetchUrlHashCode());
            }
            if (urlImage.f5886d == CurrentMode.PLACEHOLDER && urlImage.af == urlImage.getFetchUrlHashCode() && BLog.b(2)) {
                Long.valueOf(urlImage.f5900w.now());
                Integer.valueOf(urlImage.getShortId());
                Integer.valueOf(urlImage.getFetchUrlHashCode());
                urlImage.f5883a.f5844a.a.toString();
            }
            urlImage.af = urlImage.getFetchUrlHashCode();
            urlImage.f5903z.clearAnimation();
            urlImage.f5903z.setVisibility(0);
            urlImage.m8414a(urlImage.f5903z, urlImage.f5883a, currentMode);
            if (urlImage.f5880U) {
                if (urlImage.f5902y != urlImage.f5903z) {
                    urlImage.m8414a(urlImage.f5902y, urlImage.getInternalPlaceholderImageSpec(), currentMode);
                }
                urlImage.f5902y.setVisibility(0);
                urlImage.f5903z.startAnimation(urlImage.getFadeInAnimation());
            } else {
                urlImage.f5902y.setVisibility(4);
            }
            urlImage.f5903z.setVisibility(0);
            if (urlImage.f5860A.isPresent()) {
                ((View) urlImage.f5860A.get()).setVisibility(8);
            }
            urlImage.m8407C();
        }
        if (markerConfig != null) {
            urlImage.f5894q.a(markerConfig, currentMode.toString(), urlImage.f5886d.toString(), urlImage.f5872M, urlImage.f5903z.getVisibility());
        }
        urlImage.f5886d = currentMode;
        if (urlImage.f5867H != null) {
            urlImage.f5867H.m8402b(currentMode);
        }
    }

    public static void setActivityStarted(UrlImage urlImage, boolean z) {
        if (urlImage.f5878S != z) {
            urlImage.f5878S = z;
            if (z) {
                urlImage.m8467c();
            } else {
                urlImage.m8452q();
            }
        }
    }

    @VisibleForTesting
    void setLoadingMode(CurrentMode currentMode) {
        if (!this.f5876Q || this.f5886d != CurrentMode.LOADED_IMAGE || currentMode == CurrentMode.LOADED_IMAGE) {
            setMode(this, currentMode);
        }
    }

    private void m8414a(ImageView imageView, ImageSpec imageSpec, CurrentMode currentMode) {
        MarkerConfig a;
        boolean z;
        boolean z2 = true;
        if (imageSpec.f5844a != null) {
            a = this.f5894q.a(imageSpec.f5844a.a, 5439500, "UrlImageUpdateImageView");
        } else {
            a = null;
        }
        imageView.setScaleType(imageSpec.f5849f);
        imageView.setImageMatrix(imageSpec.f5850g == null ? f5859l : imageSpec.f5850g);
        imageView.setAdjustViewBounds(imageSpec.f5851h);
        if (imageSpec.f5848e == null || imageSpec.f5848e.intValue() == -1) {
            imageView.setBackgroundDrawable(null);
        } else {
            imageView.setBackgroundResource(imageSpec.f5848e.intValue());
        }
        if (imageSpec.f5845b != null) {
            m8431c(imageView, imageSpec.f5845b);
            z = true;
        } else if (imageSpec.f5847d != null) {
            m8431c(imageView, imageSpec.f5847d);
            z = true;
        } else if (imageSpec.f5846c == null || imageSpec.f5846c.intValue() == -1) {
            m8431c(imageView, null);
            z = false;
        } else {
            imageView.setImageResource(imageSpec.f5846c.intValue());
            z = true;
        }
        if (a != null) {
            boolean z3;
            FetchImagePerfLogger fetchImagePerfLogger = this.f5894q;
            if (imageSpec.f5848e == null || imageSpec.f5848e.intValue() == -1) {
                z3 = false;
            } else {
                z3 = true;
            }
            boolean z4 = imageSpec.f5845b != null;
            boolean z5 = imageSpec.f5847d != null;
            if (imageSpec.f5846c == null || imageSpec.f5846c.intValue() == -1) {
                z2 = false;
            }
            fetchImagePerfLogger.a(a, z3, z4, z5, z2, z, currentMode.toString());
        }
    }

    @VisibleForTesting
    private static void m8431c(ImageView imageView, @Nullable Drawable drawable) {
        if (drawable == null || !(imageView instanceof ImageViewTouchBase)) {
            imageView.setImageDrawable(drawable);
            return;
        }
        if (drawable instanceof CloseableBitmapDrawable) {
            drawable = drawable.getCurrent();
        }
        ((ImageViewTouchBase) imageView).setDrawable(drawable);
    }

    public ImageView getImageView() {
        return this.f5903z;
    }

    public void setHasBeenAttached(boolean z) {
        this.f5877R = z;
    }

    public final boolean m8466a() {
        return this.f5877R;
    }

    public final boolean m8468d() {
        return this.f5886d == CurrentMode.LOADED_IMAGE;
    }

    public final boolean m8469e() {
        return this.aj;
    }

    private void m8408D() {
        if (!this.f5860A.isPresent()) {
            int i;
            switch (this.f5864E) {
                case PROGRESS_BAR_HIDDEN:
                    return;
                case PROGRESS_BAR_INDETERMINATE:
                case PROGRESS_BAR_INDETERMINATE_WITH_PLACEHOLDER:
                    i = 2130907621;
                    break;
                case PROGRESS_BAR_DETERMINATE_WITH_PLACEHOLDER:
                    i = 2130907620;
                    break;
                default:
                    i = 0;
                    break;
            }
            this.f5860A = Optional.of(this.f5892o.inflate(i, this, false));
        }
    }

    private Animation getFadeInAnimation() {
        if (this.f5865F == null) {
            this.f5865F = AnimationUtils.loadAnimation(getContext(), 2130968629);
            this.f5865F.setAnimationListener(new C03487(this));
        }
        return this.f5865F;
    }

    private static String m8427b(int i) {
        switch (i) {
            case 0:
                return "VISIBLE";
            case 4:
                return "INVISIBLE";
            case 8:
                return "GONE";
            default:
                return String.valueOf(i);
        }
    }

    public String toString() {
        return Objects.toStringHelper(this).add("mode", this.f5886d).add("visibility", m8427b(getVisibility())).add("imageSpec", this.f5883a).add("attachedToViewTree", this.f5887e).add("attachedToWindow", this.f5877R).add("analyticsTagContainer", this.f5879T).toString();
    }

    private void m8409E() {
        this.f5881V = 0;
    }
}
