package com.facebook.messaging.media.mediatray;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RotateDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.loader.AbstractFbLoaderCallback;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.pagerindicator.ColorInterpolatorHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.keyboard.PermissionRequestKeyboardView;
import com.facebook.messaging.media.mediatray.MediaTrayItemViewHolder.ClickListener;
import com.facebook.messaging.media.upload.MediaUploadManagerImpl;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.runtimepermissions.RequestPermissionsPrefKeys;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.uicontrib.fab.FabView;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.ViewStubHolder.OnInflateListener;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

@TargetApi(14)
/* compiled from: section is null */
public class MediaTrayKeyboardView extends CustomFrameLayout {
    public static final Class<?> f3092j = MediaTrayKeyboardView.class;
    private static final CallerContext f3093k = CallerContext.a(MediaTrayKeyboardView.class);
    public ThreadKey f3094A;
    private ViewStubHolder<PermissionRequestKeyboardView> f3095B;
    @Nullable
    public MediaTrayKeyboardClickListener f3096C;
    @Nullable
    public MediaTrayAdapter f3097D;
    private WindowManager f3098E;
    private DisplayMetrics f3099F;
    private List<MediaTrayItemViewHolder> f3100G = new LinkedList();
    private C05074 f3101H;
    @Inject
    AbstractFbErrorReporter f3102a;
    @Inject
    FbSharedPreferences f3103b;
    @Inject
    GlyphColorizer f3104c;
    @Inject
    NavigationLogger f3105d;
    @Inject
    MediaUploadManagerImpl f3106e;
    @Inject
    MediaTrayAdapterProvider f3107f;
    @Inject
    LocalMediaTrayLoader f3108g;
    @Inject
    QeAccessor f3109h;
    @Inject
    RuntimePermissionsUtil f3110i;
    private final ValueAnimator f3111l = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(100);
    public RecyclerView f3112m;
    private LinearLayoutManager f3113n;
    private View f3114o;
    public View f3115p;
    private TextView f3116q;
    private int f3117r;
    private View f3118s;
    public FabView f3119t;
    private TextView f3120u;
    private int f3121v;
    private int f3122w;
    private int f3123x;
    private boolean f3124y;
    private boolean f3125z;

    /* compiled from: section is null */
    class C05041 implements OnInflateListener<PermissionRequestKeyboardView> {
        final /* synthetic */ MediaTrayKeyboardView f3076a;

        /* compiled from: section is null */
        class C05031 implements OnClickListener {
            final /* synthetic */ C05041 f3074a;

            C05031(C05041 c05041) {
                this.f3074a = c05041;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1144631926);
                if (this.f3074a.f3076a.f3096C != null) {
                    this.f3074a.f3076a.f3096C.mo160a(new String[]{"android.permission.READ_EXTERNAL_STORAGE"});
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1630165512, a);
            }
        }

        C05041(MediaTrayKeyboardView mediaTrayKeyboardView) {
            this.f3076a = mediaTrayKeyboardView;
        }

        public final void m3037a(View view) {
            ((PermissionRequestKeyboardView) view).setButtonListener(new C05031(this));
        }
    }

    /* compiled from: section is null */
    class C05052 extends OnScrollListener {
        final /* synthetic */ MediaTrayKeyboardView f3077a;

        C05052(MediaTrayKeyboardView mediaTrayKeyboardView) {
            this.f3077a = mediaTrayKeyboardView;
        }

        public final void m3038a(RecyclerView recyclerView, int i) {
            this.f3077a.m3056a(i);
        }

        public final void m3039a(RecyclerView recyclerView, int i, int i2) {
            MediaTrayKeyboardView.m3084n(this.f3077a);
        }
    }

    /* compiled from: section is null */
    class C05063 implements OnClickListener {
        final /* synthetic */ MediaTrayKeyboardView f3078a;

        C05063(MediaTrayKeyboardView mediaTrayKeyboardView) {
            this.f3078a = mediaTrayKeyboardView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -130383503);
            MediaTrayKeyboardView.m3083m(this.f3078a);
            Logger.a(2, EntryType.UI_INPUT_END, -2136455178, a);
        }
    }

    /* compiled from: section is null */
    public class C05074 {
        final /* synthetic */ MediaTrayKeyboardView f3079a;

        C05074(MediaTrayKeyboardView mediaTrayKeyboardView) {
            this.f3079a = mediaTrayKeyboardView;
        }

        public final void m3040a() {
            MediaTrayKeyboardView.m3086p(this.f3079a);
        }
    }

    /* compiled from: section is null */
    class C05085 implements OnClickListener {
        final /* synthetic */ MediaTrayKeyboardView f3080a;

        C05085(MediaTrayKeyboardView mediaTrayKeyboardView) {
            this.f3080a = mediaTrayKeyboardView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1475624862);
            if (this.f3080a.f3097D == null || this.f3080a.f3097D.m3014g() <= 0) {
                MediaTrayKeyboardView.m3083m(this.f3080a);
            } else {
                MediaTrayKeyboardView.m3088r(this.f3080a);
            }
            LogUtils.a(312381023, a);
        }
    }

    /* compiled from: section is null */
    class C05107 extends AbstractFbLoaderCallback<MediaTrayLoader$Params, MediaTrayLoader$Result, Throwable> {
        final /* synthetic */ MediaTrayKeyboardView f3086a;

        C05107(MediaTrayKeyboardView mediaTrayKeyboardView) {
            this.f3086a = mediaTrayKeyboardView;
        }

        public final void m3041b(Object obj, Object obj2) {
            this.f3086a.m3065a(((MediaTrayLoader$Result) obj2).f3130a);
        }

        public final void m3042c(Object obj, Object obj2) {
            Throwable th = (Throwable) obj2;
            this.f3086a.f3115p.setVisibility(0);
            this.f3086a.f3102a.a(MediaTrayKeyboardView.f3092j.getName(), "Failed to load media tray", th);
        }
    }

    /* compiled from: section is null */
    public interface MediaEditCallback {
        void mo110a(MediaResource mediaResource);
    }

    /* compiled from: section is null */
    class C05129 implements ClickListener {
        final /* synthetic */ MediaTrayKeyboardView f3090a;

        C05129(MediaTrayKeyboardView mediaTrayKeyboardView) {
            this.f3090a = mediaTrayKeyboardView;
        }

        public final void mo106a(MediaTrayItemViewHolder mediaTrayItemViewHolder, int i) {
            this.f3090a.m3059a(mediaTrayItemViewHolder, i);
        }

        public final void mo107a(MediaTrayLoader$Item mediaTrayLoader$Item, int i) {
            this.f3090a.m3064a(mediaTrayLoader$Item, i);
        }

        public final void mo108b(MediaTrayLoader$Item mediaTrayLoader$Item, int i) {
            this.f3090a.m3072b(mediaTrayLoader$Item, i);
        }

        @Nullable
        public final ThreadKey mo105a() {
            return this.f3090a.f3094A;
        }
    }

    /* compiled from: section is null */
    public interface MediaTrayKeyboardClickListener {
        void mo156a();

        void mo157a(MediaResource mediaResource);

        void mo158a(MediaResource mediaResource, @Nullable MediaEditCallback mediaEditCallback);

        void mo159a(List<MediaResource> list, boolean z);

        void mo160a(String[] strArr);
    }

    /* compiled from: section is null */
    class SpacingItemDecoration extends ItemDecoration {
        private final int f3091a;

        public SpacingItemDecoration(int i) {
            this.f3091a = i;
        }

        public final void m3054a(Rect rect, View view, RecyclerView recyclerView, State state) {
            super.a(rect, view, recyclerView, state);
            if (RecyclerView.e(view) > 0) {
                rect.left = this.f3091a;
            }
        }
    }

    private static <T extends View> void m3066a(Class<T> cls, T t) {
        m3067a((Object) t, t.getContext());
    }

    private static void m3067a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((MediaTrayKeyboardView) obj).m3058a((AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), GlyphColorizer.a(fbInjector), NavigationLogger.a(fbInjector), MediaUploadManagerImpl.a(fbInjector), (MediaTrayAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(MediaTrayAdapterProvider.class), new LocalMediaTrayLoader(DefaultBlueServiceOperationFactory.b(fbInjector), IdBasedProvider.a(fbInjector, 4099), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector)), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), RuntimePermissionsUtil.b(fbInjector));
    }

    private void m3058a(AbstractFbErrorReporter abstractFbErrorReporter, FbSharedPreferences fbSharedPreferences, GlyphColorizer glyphColorizer, NavigationLogger navigationLogger, MediaUploadManagerImpl mediaUploadManagerImpl, MediaTrayAdapterProvider mediaTrayAdapterProvider, LocalMediaTrayLoader localMediaTrayLoader, QeAccessor qeAccessor, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f3102a = abstractFbErrorReporter;
        this.f3103b = fbSharedPreferences;
        this.f3104c = glyphColorizer;
        this.f3105d = navigationLogger;
        this.f3106e = mediaUploadManagerImpl;
        this.f3107f = mediaTrayAdapterProvider;
        this.f3108g = localMediaTrayLoader;
        this.f3109h = qeAccessor;
        this.f3110i = runtimePermissionsUtil;
    }

    public MediaTrayKeyboardView(Context context) {
        super(context);
        m3082l();
    }

    public MediaTrayKeyboardView(Context context, AttributeSet attributeSet) {
        super(context);
        m3082l();
    }

    public MediaTrayKeyboardView(Context context, AttributeSet attributeSet, int i) {
        super(context);
        m3082l();
    }

    private void m3082l() {
        m3066a(MediaTrayKeyboardView.class, (View) this);
        this.f3125z = this.f3109h.a(ExperimentsForMediaTrayModule.f3024a, false);
        setContentView(2130905188);
        this.f3112m = (RecyclerView) c(2131563742);
        this.f3114o = c(2131559308);
        this.f3115p = c(2131563743);
        this.f3116q = (TextView) c(2131563743);
        this.f3118s = c(2131563744);
        this.f3120u = (TextView) c(2131563746);
        this.f3119t = (FabView) c(2131563745);
        m3085o();
        this.f3095B = ViewStubHolder.a((ViewStubCompat) c(2131563747));
        this.f3095B.c = new C05041(this);
        this.f3117r = getResources().getDimensionPixelOffset(2131433647);
        this.f3112m.a(new SpacingItemDecoration(this.f3117r));
        this.f3112m.setOverScrollMode(2);
        this.f3112m.setOnScrollListener(new C05052(this));
        getContext();
        this.f3113n = new LinearLayoutManager(0, false);
        this.f3112m.setLayoutManager(this.f3113n);
        this.f3118s.setOnClickListener(new C05063(this));
        this.f3101H = new C05074(this);
        this.f3121v = (int) getResources().getDimension(2131433648);
        this.f3098E = (WindowManager) getContext().getSystemService("window");
        this.f3099F = new DisplayMetrics();
        this.f3098E.getDefaultDisplay().getMetrics(this.f3099F);
        setContainerFocusable(true);
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1868069312);
        super.onAttachedToWindow();
        MediaUploadManagerImpl mediaUploadManagerImpl = this.f3106e;
        mediaUploadManagerImpl.F.add(this.f3101H);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1447495434, a);
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -644355905);
        super.onDetachedFromWindow();
        if (this.f3097D != null) {
            this.f3097D.f3045k = null;
        }
        this.f3112m.setOnScrollListener(null);
        this.f3118s.setOnClickListener(null);
        MediaUploadManagerImpl mediaUploadManagerImpl = this.f3106e;
        mediaUploadManagerImpl.F.remove(this.f3101H);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 401234356, a);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m3084n(this);
    }

    void setThreadKey(ThreadKey threadKey) {
        if (!(this.f3094A == null || this.f3094A.equals(threadKey))) {
            this.f3124y = true;
        }
        this.f3094A = threadKey;
    }

    private void m3059a(MediaTrayItemViewHolder mediaTrayItemViewHolder, int i) {
        if (mediaTrayItemViewHolder != null) {
            Object obj;
            if (mediaTrayItemViewHolder.f3066t.getVisibility() == 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null && mediaTrayItemViewHolder.m3028z()) {
                Type type = this.f3097D.m3012e(i).f3126a;
                if (this.f3125z) {
                    int g = this.f3097D.m3014g();
                    boolean b = this.f3097D.m3010b(i, mediaTrayItemViewHolder);
                    m3057a(g, (b ? 1 : -1) + g);
                    if (VERSION.SDK_INT >= 16) {
                        CharSequence charSequence = null;
                        if (b) {
                            if (type == Type.PHOTO) {
                                charSequence = getContext().getString(2131240911);
                            } else if (type == Type.VIDEO) {
                                charSequence = getContext().getString(2131240912);
                            }
                        } else if (type == Type.PHOTO) {
                            charSequence = getContext().getString(2131240913);
                        } else if (type == Type.VIDEO) {
                            charSequence = getContext().getString(2131240914);
                        }
                        if (charSequence != null) {
                            announceForAccessibility(charSequence);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (i == this.f3097D.f3042h) {
                    this.f3097D.m3013e();
                    return;
                } else {
                    this.f3105d.b("media_tray_popup", type == Type.PHOTO ? "press_photo_item_for_select" : "press_video_item_for_select", "select_media_item", Collections.singletonMap("media_item_position", Integer.valueOf(i)));
                    MediaTrayAdapter mediaTrayAdapter = this.f3097D;
                    mediaTrayAdapter.m3013e();
                    mediaTrayAdapter.f3044j = mediaTrayItemViewHolder;
                    mediaTrayAdapter.f3042h = i;
                    mediaTrayAdapter.f3044j.m3027x();
                    return;
                }
            }
        }
        if (mediaTrayItemViewHolder == null || !mediaTrayItemViewHolder.m3028z()) {
            this.f3097D.notifyDataSetChanged();
        }
    }

    private void m3056a(int i) {
        if (i == 0) {
            m3097g();
            if (this.f3112m != null && this.f3113n != null) {
                m3098h();
            }
        } else if (this.f3097D != null && this.f3097D.f3042h != -1) {
            this.f3097D.m3013e();
        }
    }

    public static void m3083m(MediaTrayKeyboardView mediaTrayKeyboardView) {
        mediaTrayKeyboardView.f3105d.b("media_tray_popup", "press_gallery_icon", "open_gallery", null);
        if (mediaTrayKeyboardView.f3096C != null) {
            mediaTrayKeyboardView.f3096C.mo156a();
        }
    }

    public static void m3084n(MediaTrayKeyboardView mediaTrayKeyboardView) {
        Object obj = 1;
        if (mediaTrayKeyboardView.f3125z) {
            mediaTrayKeyboardView.f3118s.setVisibility(8);
            return;
        }
        int d = mediaTrayKeyboardView.f3097D == null ? 0 : mediaTrayKeyboardView.f3097D.m3011d();
        int aZ_ = mediaTrayKeyboardView.f3097D == null ? 0 : mediaTrayKeyboardView.f3097D.aZ_();
        if (d == 0) {
            mediaTrayKeyboardView.f3118s.setVisibility(8);
            return;
        }
        int i = aZ_ - d;
        int l = mediaTrayKeyboardView.f3113n.l();
        Object obj2 = i <= mediaTrayKeyboardView.f3113n.n() ? 1 : null;
        mediaTrayKeyboardView.f3118s.setVisibility(obj2 != null ? 0 : 4);
        if (obj2 != null) {
            d = mediaTrayKeyboardView.f3121v;
            if (i <= l) {
                obj = null;
            }
            if (obj != null) {
                d += mediaTrayKeyboardView.f3113n.c(i).getLeft();
            }
            mediaTrayKeyboardView.f3118s.offsetLeftAndRight(d - mediaTrayKeyboardView.f3118s.getLeft());
        }
    }

    private void m3085o() {
        final RotateDrawable rotateDrawable = (RotateDrawable) this.f3104c.a(2130841184, ContextCompat.b(getContext(), 17170443));
        final RotateDrawable rotateDrawable2 = (RotateDrawable) this.f3104c.a(2130841183, ContextCompat.b(getContext(), 2131362241));
        this.f3119t.setGlyph(new LayerDrawable(new Drawable[]{rotateDrawable2, rotateDrawable}));
        this.f3119t.setOnClickListener(new C05085(this));
        this.f3111l.setInterpolator(new LinearInterpolator());
        this.f3111l.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ MediaTrayKeyboardView f3083c;
            private final int f3084d = ContextCompat.b(this.f3083c.getContext(), 17170443);
            private final int f3085e = ContextCompat.b(this.f3083c.getContext(), 2131362241);

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                rotateDrawable.setLevel((int) (floatValue * 10000.0f));
                rotateDrawable2.setLevel((int) (floatValue * 10000.0f));
                rotateDrawable.setAlpha((int) (floatValue * 255.0f));
                rotateDrawable2.setAlpha((int) ((-255.0f * floatValue) + 255.0f));
                this.f3083c.f3119t.setFillColor(ColorInterpolatorHelper.a(floatValue, this.f3084d, this.f3085e));
            }
        });
        this.f3111l.setCurrentPlayTime(0);
        m3057a(0, 0);
    }

    private void m3057a(int i, int i2) {
        int d = this.f3097D == null ? 0 : this.f3097D.m3011d();
        if (!this.f3125z || d <= 0) {
            this.f3119t.setVisibility(8);
            return;
        }
        if (i == 0 && i2 > 0) {
            this.f3111l.start();
        } else if (i > 0 && i2 == 0) {
            this.f3111l.reverse();
        }
        this.f3120u.setText(String.valueOf(i2));
        TextView textView = this.f3120u;
        if (i2 > 0) {
            d = 0;
        } else {
            d = 8;
        }
        textView.setVisibility(d);
        this.f3119t.setContentDescription(getFabDescription());
        this.f3119t.setVisibility(0);
    }

    private String getFabDescription() {
        Set<MediaTrayLoader$Item> set = this.f3097D.f3046l;
        if (set.isEmpty()) {
            return getContext().getString(2131240907);
        }
        int i = 0;
        int i2 = 0;
        for (MediaTrayLoader$Item mediaTrayLoader$Item : set) {
            if (mediaTrayLoader$Item.f3126a == Type.PHOTO) {
                i2++;
            } else {
                int i3;
                if (mediaTrayLoader$Item.f3126a == Type.VIDEO) {
                    i3 = i + 1;
                } else {
                    i3 = i;
                }
                i = i3;
            }
        }
        if (i == 0) {
            return getContext().getResources().getQuantityString(2131689778, i2, new Object[]{Integer.valueOf(i2)});
        } else if (i2 == 0) {
            return getContext().getResources().getQuantityString(2131689779, i, new Object[]{Integer.valueOf(i)});
        } else if (i > 1) {
            return getContext().getResources().getQuantityString(2131689780, i2, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (i2 <= 1) {
            return getContext().getString(2131240915);
        } else {
            return getContext().getResources().getQuantityString(2131689781, i, new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
        }
    }

    public static void m3086p(MediaTrayKeyboardView mediaTrayKeyboardView) {
        if (mediaTrayKeyboardView.f3106e.a()) {
            List<MediaTrayItemViewHolder> list = mediaTrayKeyboardView.f3100G;
            mediaTrayKeyboardView.f3100G = Lists.b();
            for (MediaTrayItemViewHolder b : list) {
                b.m3024b(EventTriggerType.BY_AUTOPLAY);
            }
        } else if (mediaTrayKeyboardView.f3112m.getVisibility() == 0) {
            mediaTrayKeyboardView.m3097g();
        }
    }

    final void m3091a() {
        this.f3112m.setVisibility(8);
        LocalMediaTrayLoader localMediaTrayLoader = this.f3108g;
        localMediaTrayLoader.a(new C05107(this));
        localMediaTrayLoader.a(new MediaTrayLoader$Params(!ThreadKey.g(this.f3094A)));
        m3087q();
    }

    private void m3087q() {
        if (VERSION.SDK_INT <= 21 || this.f3110i.a("android.permission.READ_EXTERNAL_STORAGE")) {
            if (VERSION.SDK_INT > 21) {
                this.f3114o.setImportantForAccessibility(0);
                this.f3115p.setImportantForAccessibility(0);
            }
            this.f3095B.e();
            return;
        }
        this.f3114o.setImportantForAccessibility(4);
        this.f3115p.setImportantForAccessibility(4);
        this.f3095B.f();
    }

    final void m3094b() {
        this.f3112m.setVisibility(8);
        setContainerFocusable(true);
        m3098h();
        for (MediaTrayItemViewHolder mediaTrayItemViewHolder : this.f3100G) {
            if (mediaTrayItemViewHolder.f3054A == Type.VIDEO) {
                mediaTrayItemViewHolder.f3068v.m3113a();
            }
        }
        this.f3100G.clear();
    }

    final void m3095e() {
        m3089s();
    }

    final Bundle m3096f() {
        Bundle bundle = new Bundle();
        m3098h();
        bundle.putInt("media_tray_position", this.f3122w);
        bundle.putInt("media_tray_offset", this.f3123x);
        return bundle;
    }

    final void m3092a(Bundle bundle) {
        this.f3122w = bundle.getInt("media_tray_position");
        this.f3123x = bundle.getInt("media_tray_offset");
        m3089s();
    }

    public final void m3097g() {
        if (this.f3097D != null && this.f3097D.aZ_() != 0 && !this.f3106e.a()) {
            MediaTrayItemViewHolder mediaTrayItemViewHolder;
            int l = this.f3113n.l();
            int n = this.f3113n.n();
            List<MediaTrayItemViewHolder> list = this.f3100G;
            this.f3100G = Lists.b();
            for (int i = l; i <= n; i++) {
                ViewHolder c = this.f3112m.c(i);
                if (c != null && (c instanceof MediaTrayItemViewHolder)) {
                    mediaTrayItemViewHolder = (MediaTrayItemViewHolder) c;
                    list.remove(c);
                    if (m3069a(c.a)) {
                        this.f3100G.add(mediaTrayItemViewHolder);
                    } else {
                        mediaTrayItemViewHolder.m3024b(EventTriggerType.BY_AUTOPLAY);
                    }
                }
            }
            for (MediaTrayItemViewHolder mediaTrayItemViewHolder2 : list) {
                mediaTrayItemViewHolder2.m3024b(EventTriggerType.BY_AUTOPLAY);
            }
            for (MediaTrayItemViewHolder mediaTrayItemViewHolder22 : this.f3100G) {
                EventTriggerType eventTriggerType = EventTriggerType.BY_AUTOPLAY;
                if (mediaTrayItemViewHolder22.f3054A == Type.VIDEO) {
                    mediaTrayItemViewHolder22.f3068v.m3114a(eventTriggerType);
                } else if (mediaTrayItemViewHolder22.f3054A == Type.PHOTO) {
                    Animatable g = mediaTrayItemViewHolder22.f3067u.getController().g();
                    if (g != null) {
                        g.start();
                    }
                }
                mediaTrayItemViewHolder22.f3071y = true;
            }
        }
    }

    private void setContainerFocusable(boolean z) {
        setFocusable(z);
        setFocusableInTouchMode(z);
    }

    public static void m3088r(MediaTrayKeyboardView mediaTrayKeyboardView) {
        List arrayList = new ArrayList();
        for (MediaTrayLoader$Item mediaTrayLoader$Item : mediaTrayKeyboardView.f3097D.f3046l) {
            arrayList.add(mediaTrayLoader$Item.f3128c);
        }
        mediaTrayKeyboardView.f3096C.mo159a(arrayList, mediaTrayKeyboardView.f3109h.a(ExperimentsForMediaTrayModule.f3026c, true));
        int g = mediaTrayKeyboardView.f3097D.m3014g();
        MediaTrayAdapter mediaTrayAdapter = mediaTrayKeyboardView.f3097D;
        mediaTrayAdapter.f3046l.clear();
        mediaTrayAdapter.notifyDataSetChanged();
        mediaTrayAdapter = mediaTrayKeyboardView.f3097D;
        mediaTrayAdapter.f3036b.clear();
        mediaTrayAdapter.notifyDataSetChanged();
        mediaTrayKeyboardView.m3057a(g, 0);
    }

    private void m3064a(MediaTrayLoader$Item mediaTrayLoader$Item, int i) {
        if (this.f3096C != null && this.f3097D != null) {
            this.f3105d.b("media_tray_popup", mediaTrayLoader$Item.f3126a == Type.PHOTO ? "press_photo_item_for_send" : "press_video_item_for_send", "send_media_item", Collections.singletonMap("media_item_position", Integer.valueOf(i)));
            this.f3096C.mo157a(mediaTrayLoader$Item.f3128c);
        }
    }

    private void m3072b(final MediaTrayLoader$Item mediaTrayLoader$Item, final int i) {
        if (this.f3096C != null && this.f3097D != null) {
            List<MediaTrayItemViewHolder> list = this.f3100G;
            this.f3100G = Lists.b();
            for (MediaTrayItemViewHolder b : list) {
                b.m3024b(EventTriggerType.BY_AUTOPLAY);
            }
            MediaEditCallback mediaEditCallback = null;
            boolean a = this.f3109h.a(ExperimentsForMediaTrayModule.f3025b, false);
            if (this.f3125z && a) {
                mediaEditCallback = new MediaEditCallback(this) {
                    final /* synthetic */ MediaTrayKeyboardView f3089c;

                    public final void mo110a(MediaResource mediaResource) {
                        this.f3089c.f3097D.m3009a(mediaTrayLoader$Item, i, mediaResource);
                    }
                };
            }
            this.f3096C.mo158a(mediaTrayLoader$Item.f3128c, mediaEditCallback);
        }
    }

    public void setMediaTrayKeyboardClickListener(MediaTrayKeyboardClickListener mediaTrayKeyboardClickListener) {
        this.f3096C = mediaTrayKeyboardClickListener;
    }

    private void m3065a(ImmutableList<MediaTrayLoader$Item> immutableList) {
        int aZ_;
        if (this.f3097D != null) {
            aZ_ = this.f3097D.aZ_();
        } else {
            aZ_ = -1;
        }
        this.f3097D = this.f3107f.m3015a(immutableList);
        this.f3112m.setAdapter(this.f3097D);
        this.f3097D.f3045k = new C05129(this);
        this.f3116q.setText(2131231949);
        if (this.f3122w >= 0) {
            boolean z = this.f3097D.aZ_() > aZ_;
            if ((aZ_ == -1 || !z) && !this.f3124y) {
                m3089s();
            } else {
                m3100j();
                this.f3124y = false;
            }
        }
        this.f3114o.setVisibility(4);
        if (immutableList.isEmpty()) {
            this.f3112m.setVisibility(4);
            this.f3116q.setVisibility(0);
            this.f3118s.setVisibility(8);
        } else {
            this.f3112m.setVisibility(0);
            this.f3116q.setVisibility(4);
            this.f3118s.setVisibility(0);
            if (hasFocus()) {
                this.f3112m.requestFocus();
                setContainerFocusable(false);
            }
        }
        m3057a(0, 0);
        this.f3112m.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ MediaTrayKeyboardView f3075a;

            {
                this.f3075a = r1;
            }

            public void onGlobalLayout() {
                this.f3075a.m3097g();
                if (VERSION.SDK_INT >= 16) {
                    this.f3075a.f3112m.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    this.f3075a.f3112m.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        });
    }

    private boolean m3069a(View view) {
        int width = view.getWidth();
        if (width <= 0) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        if (i > 0) {
            if (((float) (this.f3099F.widthPixels - i)) / ((float) width) > 0.85f) {
                return true;
            }
            return false;
        } else if (((float) (i + width)) / ((float) width) > 0.6f) {
            return true;
        } else {
            return false;
        }
    }

    public final void m3098h() {
        int i = 0;
        this.f3122w = this.f3113n.l();
        View childAt = this.f3112m.getChildAt(0);
        if (childAt != null) {
            i = childAt.getLeft();
        }
        this.f3123x = i;
    }

    private void m3089s() {
        this.f3113n.d(this.f3122w, this.f3123x);
    }

    public final void m3099i() {
        m3068a(true);
    }

    public final void m3100j() {
        m3068a(false);
    }

    private void m3068a(boolean z) {
        this.f3122w = 0;
        this.f3123x = 0;
        if (z) {
            this.f3113n.a(this.f3112m, null, 0);
        } else {
            this.f3113n.e(0);
        }
    }

    public final void m3093a(Map<String, Integer> map) {
        Integer num = (Integer) map.get("android.permission.READ_EXTERNAL_STORAGE");
        if (num != null) {
            switch (num.intValue()) {
                case 0:
                    this.f3095B.e();
                    return;
                case 1:
                    this.f3103b.edit().putBoolean(RequestPermissionsPrefKeys.e, false).commit();
                    return;
                case 2:
                    m3090t();
                    return;
                default:
                    return;
            }
        }
    }

    private void m3090t() {
        if (this.f3103b.a(RequestPermissionsPrefKeys.e, false)) {
            this.f3110i.b();
        } else {
            this.f3103b.edit().putBoolean(RequestPermissionsPrefKeys.e, true).commit();
        }
    }
}
