package com.facebook.stickers.search;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.GridView;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.gridlayoututils.GridSizingCalculator;
import com.facebook.common.gridlayoututils.GridSizingCalculator.Sizes;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.MathUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.resources.ui.FbEditText;
import com.facebook.resources.ui.FbTextView;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.stickers.abtest.StickerContentSearchExperimentAccessor;
import com.facebook.stickers.analytics.StickerSearchAnalyticsLogger;
import com.facebook.stickers.client.StickersLoader;
import com.facebook.stickers.gridlayout.StickerGridSizingParams;
import com.facebook.stickers.gridlayout.StickersInFb4aComposerGridSizingParams;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.stickers.model.StickerTag;
import com.facebook.stickers.search.StickerSearchLoader.Params;
import com.facebook.stickers.search.StickerTagsLoader.Results;
import com.facebook.stickers.service.FetchStickerTagsParams.TagType;
import com.facebook.stickers.ui.StickerGridController;
import com.facebook.stickers.ui.StickerGridController.Listener;
import com.facebook.stickers.ui.StickerGridControllerProvider;
import com.facebook.stickers.ui.StickerGridViewAdapter;
import com.facebook.stickers.ui.StickerGridViewAdapterProvider;
import com.facebook.stickers.ui.StickerTagGridViewAdapter;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.RegularImmutableSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: edit_post */
public class StickerSearchContainer extends CustomFrameLayout {
    private static final CallerContext f16813a = CallerContext.a(StickerSearchContainer.class, "sticker_keyboard", "sticker_search");
    public static final Class<?> f16814b = StickerSearchContainer.class;
    private View f16815A;
    private View f16816B;
    private FrameLayout f16817C;
    public FrameLayout f16818D;
    private FbTextView f16819E;
    public StickerGridViewAdapter f16820F;
    public StickerTagGridViewAdapter f16821G;
    public C11863 f16822H;
    private Sizes f16823I;
    private Spring f16824J;
    public StickerSearchListener f16825K;
    public State f16826L;
    public String f16827M;
    public boolean f16828N;
    public boolean f16829O;
    public Runnable f16830P;
    public StickerInterface f16831Q;
    private final float f16832c = 0.2f;
    private final int f16833d = 300;
    private final int f16834e = 12;
    private SpringSystem f16835f;
    public InputMethodManager f16836g;
    private StickersLoader f16837h;
    public StickerTagsLoader f16838i;
    private TaggedStickersLoaderProvider f16839j;
    public TaggedStickersLoader f16840k;
    public StickerSearchLoader f16841l;
    public TrayStickerIdsLoader f16842m;
    private StickerGridViewAdapterProvider f16843n;
    private StickerGridControllerProvider f16844o;
    private DefaultAndroidThreadUtil f16845p;
    public Handler f16846q;
    public AbstractFbErrorReporter f16847r;
    public StickerSearchAnalyticsLogger f16848s;
    private FbSharedPreferences f16849t;
    public StickerContentSearchExperimentAccessor f16850u;
    public ImmutableSet<String> f16851v = RegularImmutableSet.a;
    public Context f16852w;
    private FbTextView f16853x;
    public View f16854y;
    public FbEditText f16855z;

    /* compiled from: edit_post */
    public interface StickerSearchListener {
        void mo1272a();

        void mo1273a(Sticker sticker);

        void mo1274a(String str);

        void mo1275b();
    }

    /* compiled from: edit_post */
    public class AnonymousClass13 implements Runnable {
        final /* synthetic */ String f16792a;
        final /* synthetic */ StickerSearchContainer f16793b;

        public AnonymousClass13(StickerSearchContainer stickerSearchContainer, String str) {
            this.f16793b = stickerSearchContainer;
            this.f16792a = str;
        }

        public void run() {
            StickerSearchContainer stickerSearchContainer = this.f16793b;
            String str = this.f16792a;
            stickerSearchContainer.f16841l.m11055a();
            StickerSearchContainer.setCurrentState(stickerSearchContainer, State.WAIT_FOR_SEARCH_RESULTS);
            stickerSearchContainer.f16841l.m11057a(new Params(str, stickerSearchContainer.f16831Q));
            stickerSearchContainer.f16848s.m23907b(str);
        }
    }

    /* compiled from: edit_post */
    class C11841 implements TextWatcher {
        final /* synthetic */ StickerSearchContainer f16798a;

        C11841(StickerSearchContainer stickerSearchContainer) {
            this.f16798a = stickerSearchContainer;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String charSequence2 = charSequence.toString();
            StickerSearchContainer.m24587a(this.f16798a, StringUtil.a(charSequence2));
            if (this.f16798a.f16828N) {
                this.f16798a.f16828N = false;
                return;
            }
            if (this.f16798a.f16830P != null) {
                HandlerDetour.a(this.f16798a.f16846q, this.f16798a.f16830P);
            }
            if (StringUtil.a(charSequence2)) {
                StickerSearchContainer.m24594m(this.f16798a);
            } else if (charSequence2.length() < 2) {
                StickerSearchContainer.setCurrentState(this.f16798a, State.TYPE_STARTED);
            } else {
                StickerSearchContainer stickerSearchContainer = this.f16798a;
                stickerSearchContainer.f16830P = new AnonymousClass13(stickerSearchContainer, charSequence2);
                HandlerDetour.b(stickerSearchContainer.f16846q, stickerSearchContainer.f16830P, 300, -1058542995);
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: edit_post */
    class C11852 implements OnClickListener {
        final /* synthetic */ StickerSearchContainer f16799a;

        C11852(StickerSearchContainer stickerSearchContainer) {
            this.f16799a = stickerSearchContainer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -936405109);
            this.f16799a.f16855z.setText("");
            Logger.a(2, EntryType.UI_INPUT_END, -1834570750, a);
        }
    }

    /* compiled from: edit_post */
    public class C11863 {
        public final /* synthetic */ StickerSearchContainer f16800a;

        C11863(StickerSearchContainer stickerSearchContainer) {
            this.f16800a = stickerSearchContainer;
        }

        public final void m24563a(int i, int i2) {
            int translationY = (int) (this.f16800a.f16854y.getTranslationY() - ((float) i2));
            if (i < this.f16800a.f16854y.getHeight() && translationY < (-i)) {
                translationY = -i;
            }
            StickerSearchContainer.m24585a(this.f16800a, (float) translationY, AnimationFlag.JUMP_TO_VALUE);
        }
    }

    /* compiled from: edit_post */
    class C11874 extends SimpleSpringListener {
        final /* synthetic */ StickerSearchContainer f16801a;

        C11874(StickerSearchContainer stickerSearchContainer) {
            this.f16801a = stickerSearchContainer;
        }

        public final void m24564a(Spring spring) {
            this.f16801a.f16854y.setTranslationY((float) (-Math.abs(spring.d())));
        }
    }

    /* compiled from: edit_post */
    public class C11906 implements Callback<StickerTagsLoader.Params, Results, Throwable> {
        final /* synthetic */ StickerSearchContainer f16805a;

        /* compiled from: edit_post */
        class C11891 implements Comparator<StickerTag> {
            final /* synthetic */ C11906 f16804a;

            C11891(C11906 c11906) {
                this.f16804a = c11906;
            }

            public int compare(Object obj, Object obj2) {
                return ((StickerTag) obj).f5003e - ((StickerTag) obj2).f5003e;
            }
        }

        public C11906(StickerSearchContainer stickerSearchContainer) {
            this.f16805a = stickerSearchContainer;
        }

        public final void m24567b(Object obj, Object obj2) {
            Collection a = Lists.a(((Results) obj2).f16865a);
            Collections.sort(a, new C11891(this));
            this.f16805a.f16821G.m24764a(ImmutableList.copyOf(a));
            StickerSearchContainer.setCurrentState(this.f16805a, State.TAG_SELECTION);
        }

        public final void m24568c(Object obj, Object obj2) {
            this.f16805a.f16847r.a(StickerSearchContainer.f16814b.toString(), "Featured tag loading failed", (Throwable) obj2);
        }
    }

    /* compiled from: edit_post */
    interface StickerFilterCallback {
        void mo1285a(ImmutableList<Sticker> immutableList);
    }

    /* compiled from: edit_post */
    class C11927 implements Callback<TaggedStickersLoader.Params, TaggedStickersLoader.Results, Throwable> {
        final /* synthetic */ StickerSearchContainer f16807a;

        /* compiled from: edit_post */
        class C11911 implements StickerFilterCallback {
            final /* synthetic */ C11927 f16806a;

            C11911(C11927 c11927) {
                this.f16806a = c11927;
            }

            public final void mo1285a(ImmutableList<Sticker> immutableList) {
                this.f16806a.f16807a.f16820F.m24761a((ImmutableList) immutableList);
                StickerSearchContainer.setCurrentState(this.f16806a.f16807a, State.TAG_RESULTS_SHOWN);
            }
        }

        C11927(StickerSearchContainer stickerSearchContainer) {
            this.f16807a = stickerSearchContainer;
        }

        public final void m24573b(Object obj, Object obj2) {
            TaggedStickersLoader.Results results = (TaggedStickersLoader.Results) obj2;
            if (this.f16807a.f16826L.equals(State.WAIT_FOR_TAGGED_STICKERS)) {
                StickerSearchContainer.m24586a(this.f16807a, results.f16872a, new C11911(this));
            }
        }

        public final void m24574c(Object obj, Object obj2) {
            Throwable th = (Throwable) obj2;
            if (this.f16807a.f16826L.equals(State.WAIT_FOR_TAGGED_STICKERS)) {
                StickerSearchContainer.setCurrentState(this.f16807a, State.ERROR);
            }
            this.f16807a.f16847r.a(StickerSearchContainer.f16814b.toString(), "Tagged stickers loading failed", th);
        }
    }

    /* compiled from: edit_post */
    public class C11959 implements Callback<StickerInterface, TrayStickerIdsLoader.Results, Throwable> {
        final /* synthetic */ StickerSearchContainer f16812a;

        public C11959(StickerSearchContainer stickerSearchContainer) {
            this.f16812a = stickerSearchContainer;
        }

        public final void m24582b(Object obj, Object obj2) {
            TrayStickerIdsLoader.Results results = (TrayStickerIdsLoader.Results) obj2;
            this.f16812a.f16851v = ImmutableSet.copyOf(results.f16877a);
        }

        public final /* bridge */ /* synthetic */ void m24583c(Object obj, Object obj2) {
        }
    }

    /* compiled from: edit_post */
    public enum AnimationFlag {
        SPRING_TO_VALUE,
        JUMP_TO_VALUE
    }

    /* compiled from: edit_post */
    public enum State {
        UNINITIALIZED,
        TAG_SELECTION,
        WAIT_FOR_TAGGED_STICKERS,
        TAG_RESULTS_SHOWN,
        TYPE_STARTED,
        WAIT_FOR_SEARCH_RESULTS,
        SEARCH_FINISHED_WITH_RESULTS,
        SEARCH_FINISHED_NO_RESULTS,
        ERROR
    }

    public static void m24588a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((StickerSearchContainer) obj).m24584a(SpringSystem.b(injectorLike), StickersLoader.m23949b(injectorLike), StickerTagsLoader.m24598b(injectorLike), (TaggedStickersLoaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TaggedStickersLoaderProvider.class), TrayStickerIdsLoader.m24604b(injectorLike), StickerSearchLoader.m24595b(injectorLike), (StickerGridViewAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(StickerGridViewAdapterProvider.class), (StickerGridControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(StickerGridControllerProvider.class), InputMethodManagerMethodAutoProvider.b(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), Handler_ForUiThreadMethodAutoProvider.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), StickerSearchAnalyticsLogger.m23901a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), StickerContentSearchExperimentAccessor.m23888b(injectorLike));
    }

    public StickerSearchContainer(Context context, StickerInterface stickerInterface) {
        super(context);
        this.f16852w = context;
        this.f16831Q = stickerInterface;
        m24589b();
    }

    private void m24589b() {
        Class cls = StickerSearchContainer.class;
        m24588a((Object) this, getContext());
        setContentView(2130905861);
        this.f16853x = (FbTextView) c(2131565149);
        this.f16854y = c(2131565143);
        this.f16855z = (FbEditText) c(2131565144);
        this.f16815A = c(2131565145);
        this.f16816B = c(2131565148);
        this.f16817C = (FrameLayout) c(2131565142);
        this.f16818D = (FrameLayout) c(2131565141);
        this.f16819E = (FbTextView) c(2131565140);
        this.f16853x.setText(getResources().getText(2131230739));
        this.f16855z.addTextChangedListener(new C11841(this));
        this.f16816B.setOnClickListener(new C11852(this));
        this.f16822H = new C11863(this);
        this.f16824J = this.f16835f.a();
        this.f16824J.a(new SpringConfig(600.0d, 37.0d)).a(new C11874(this));
        m24587a(this, true);
        final List a = Lists.a();
        this.f16841l.m11056a(new Callback<Params, StickerSearchLoader.Results, Throwable>(this) {
            final /* synthetic */ StickerSearchContainer f16811b;

            public final void m24577a(Object obj, Object obj2) {
                Params params = (Params) obj;
                StickerSearchLoader.Results results = (StickerSearchLoader.Results) obj2;
                if (this.f16811b.f16826L != State.WAIT_FOR_SEARCH_RESULTS) {
                    this.f16811b.f16848s.m23908c(params.f16857a);
                } else {
                    a.addAll(results.f16859a);
                }
            }

            public final void m24578b(Object obj, Object obj2) {
                final Params params = (Params) obj;
                if (this.f16811b.f16826L != State.WAIT_FOR_SEARCH_RESULTS) {
                    this.f16811b.f16848s.m23908c(params.f16857a);
                    return;
                }
                int i = 0;
                for (Sticker sticker : a) {
                    int i2;
                    if (this.f16811b.f16851v.contains(sticker.f4938a)) {
                        i2 = i + 1;
                    } else {
                        i2 = i;
                    }
                    i = i2;
                }
                this.f16811b.f16848s.m23905a(params.f16857a, a.size(), i);
                if (a.isEmpty()) {
                    StickerSearchContainer.setCurrentState(this.f16811b, State.SEARCH_FINISHED_NO_RESULTS);
                } else {
                    StickerSearchContainer.m24586a(this.f16811b, ImmutableList.copyOf(a), new StickerFilterCallback(this) {
                        final /* synthetic */ C11948 f16809b;

                        public final void mo1285a(ImmutableList<Sticker> immutableList) {
                            switch (this.f16809b.f16811b.f16826L) {
                                case WAIT_FOR_SEARCH_RESULTS:
                                    this.f16809b.f16811b.f16820F.m24761a((ImmutableList) immutableList);
                                    StickerSearchContainer.setCurrentState(this.f16809b.f16811b, State.SEARCH_FINISHED_WITH_RESULTS);
                                    return;
                                default:
                                    this.f16809b.f16811b.f16848s.m23908c(params.f16857a);
                                    return;
                            }
                        }
                    });
                }
                a.clear();
            }

            public final void m24579c(Object obj, Object obj2) {
                Params params = (Params) obj;
                Throwable th = (Throwable) obj2;
                if (this.f16811b.f16826L == State.WAIT_FOR_SEARCH_RESULTS) {
                    StickerSearchContainer.setCurrentState(this.f16811b, State.ERROR);
                }
                this.f16811b.f16847r.a(StickerSearchContainer.f16814b.toString(), "Sticker query search failed", th);
                this.f16811b.f16848s.m23909d(params.f16857a);
            }
        });
        this.f16838i.m11056a(new C11906(this));
        m24591g();
        this.f16842m.m11056a(new C11959(this));
        this.f16842m.m11057a(this.f16831Q);
        setCurrentState(this, State.UNINITIALIZED);
        setBackgroundDrawable(new ColorDrawable(ContextUtils.c(this.f16852w, 2130773089, getResources().getColor(2131362350))));
    }

    @Inject
    private void m24584a(SpringSystem springSystem, StickersLoader stickersLoader, StickerTagsLoader stickerTagsLoader, TaggedStickersLoaderProvider taggedStickersLoaderProvider, TrayStickerIdsLoader trayStickerIdsLoader, StickerSearchLoader stickerSearchLoader, StickerGridViewAdapterProvider stickerGridViewAdapterProvider, StickerGridControllerProvider stickerGridControllerProvider, InputMethodManager inputMethodManager, DefaultAndroidThreadUtil defaultAndroidThreadUtil, Handler handler, AbstractFbErrorReporter abstractFbErrorReporter, StickerSearchAnalyticsLogger stickerSearchAnalyticsLogger, FbSharedPreferences fbSharedPreferences, StickerContentSearchExperimentAccessor stickerContentSearchExperimentAccessor) {
        this.f16835f = springSystem;
        this.f16837h = stickersLoader;
        this.f16838i = stickerTagsLoader;
        this.f16839j = taggedStickersLoaderProvider;
        this.f16840k = taggedStickersLoaderProvider.m24603a(this.f16831Q);
        this.f16842m = trayStickerIdsLoader;
        this.f16841l = stickerSearchLoader;
        this.f16843n = stickerGridViewAdapterProvider;
        this.f16844o = stickerGridControllerProvider;
        this.f16836g = inputMethodManager;
        this.f16845p = defaultAndroidThreadUtil;
        this.f16846q = handler;
        this.f16847r = abstractFbErrorReporter;
        this.f16848s = stickerSearchAnalyticsLogger;
        this.f16849t = fbSharedPreferences;
        this.f16850u = stickerContentSearchExperimentAccessor;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m24590e();
    }

    private void m24590e() {
        if (this.f16823I == null) {
            GridSizingCalculator.Params stickersInFb4aComposerGridSizingParams;
            Resources resources = getContext().getResources();
            if (this.f16831Q == StickerInterface.COMPOSER || this.f16831Q == StickerInterface.POSTS) {
                stickersInFb4aComposerGridSizingParams = new StickersInFb4aComposerGridSizingParams();
            } else {
                stickersInFb4aComposerGridSizingParams = new StickerGridSizingParams();
            }
            this.f16823I = new GridSizingCalculator(resources, stickersInFb4aComposerGridSizingParams).m11042a(getWidth(), getHeight() - resources.getDimensionPixelSize(2131427864), false);
            this.f16821G = new StickerTagGridViewAdapter(this.f16852w);
            this.f16821G.m24764a(RegularImmutableList.a);
            this.f16821G.f17073c = new Object(this) {
                public final /* synthetic */ StickerSearchContainer f16789a;

                {
                    this.f16789a = r1;
                }
            };
            View gridView = new GridView(getContext());
            gridView.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ StickerSearchContainer f16790a;

                {
                    this.f16790a = r1;
                }

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return this.f16790a.f16829O;
                }
            });
            int dimensionPixelSize = getResources().getDimensionPixelSize(2131428597);
            gridView.setNumColumns(2);
            gridView.setGravity(17);
            gridView.setAdapter(this.f16821G);
            gridView.setHorizontalSpacing(getResources().getDimensionPixelSize(2131428596));
            gridView.setVerticalSpacing(dimensionPixelSize);
            gridView.setPadding(getResources().getDimensionPixelSize(2131428591), getResources().getDimensionPixelSize(2131428598), getResources().getDimensionPixelSize(2131428592), dimensionPixelSize);
            gridView.setScrollBarStyle(33554432);
            gridView.setClipToPadding(false);
            gridView.setOnScrollListener(new PositionTrackingOnScrollListener(this.f16822H, 2, dimensionPixelSize));
            this.f16818D.addView(gridView);
            m24592k();
            m24593l();
        }
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 579225019);
        this.f16837h.m23950a();
        this.f16838i.m11055a();
        this.f16841l.m11055a();
        this.f16840k.m11055a();
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 49773982, a);
    }

    public void setStickerSearchListener(final StickerSearchListener stickerSearchListener) {
        this.f16855z.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ StickerSearchContainer f16803b;

            public void onFocusChange(View view, boolean z) {
                if (z) {
                    stickerSearchListener.mo1272a();
                } else {
                    stickerSearchListener.mo1275b();
                }
            }
        });
        this.f16825K = stickerSearchListener;
    }

    public static void setCurrentState(StickerSearchContainer stickerSearchContainer, State state) {
        boolean z = false;
        stickerSearchContainer.f16845p.a();
        if (state != stickerSearchContainer.f16826L) {
            stickerSearchContainer.f16853x.setVisibility(8);
            stickerSearchContainer.f16817C.setVisibility(8);
            stickerSearchContainer.f16819E.setVisibility(8);
            stickerSearchContainer.f16818D.setVisibility(8);
            stickerSearchContainer.f16818D.setAlpha(1.0f);
            stickerSearchContainer.f16829O = false;
            m24585a(stickerSearchContainer, 0.0f, AnimationFlag.SPRING_TO_VALUE);
            switch (state) {
                case UNINITIALIZED:
                    stickerSearchContainer.f16853x.setVisibility(0);
                    break;
                case TAG_SELECTION:
                    stickerSearchContainer.f16818D.setVisibility(0);
                    stickerSearchContainer.f16855z.setVisibility(0);
                    z = true;
                    break;
                case WAIT_FOR_TAGGED_STICKERS:
                    stickerSearchContainer.f16818D.setVisibility(0);
                    stickerSearchContainer.f16818D.setAlpha(0.2f);
                    stickerSearchContainer.f16829O = true;
                    break;
                case TAG_RESULTS_SHOWN:
                    stickerSearchContainer.f16817C.setVisibility(0);
                    break;
                case TYPE_STARTED:
                    stickerSearchContainer.f16818D.setVisibility(0);
                    stickerSearchContainer.f16818D.setAlpha(0.2f);
                    stickerSearchContainer.f16829O = true;
                    break;
                case WAIT_FOR_SEARCH_RESULTS:
                    stickerSearchContainer.f16819E.setText(stickerSearchContainer.getResources().getText(2131230739));
                    stickerSearchContainer.f16819E.setVisibility(0);
                    break;
                case SEARCH_FINISHED_WITH_RESULTS:
                    stickerSearchContainer.f16817C.setVisibility(0);
                    break;
                case SEARCH_FINISHED_NO_RESULTS:
                    stickerSearchContainer.f16819E.setText(stickerSearchContainer.getResources().getText(2131231336));
                    stickerSearchContainer.f16819E.setVisibility(0);
                    break;
                case ERROR:
                    stickerSearchContainer.f16819E.setText(stickerSearchContainer.getResources().getText(2131230758));
                    stickerSearchContainer.f16819E.setVisibility(0);
                    break;
                default:
                    throw new IllegalStateException("StickerSearchContainer has unhandled state.");
            }
            stickerSearchContainer.f16826L = state;
            if (z && !StringUtil.a(stickerSearchContainer.f16827M)) {
                stickerSearchContainer.f16855z.setText(stickerSearchContainer.f16827M);
                stickerSearchContainer.f16827M = null;
            }
        }
    }

    public static void m24585a(StickerSearchContainer stickerSearchContainer, float f, AnimationFlag animationFlag) {
        float b = MathUtil.b(f, (float) (-stickerSearchContainer.getResources().getDimensionPixelSize(2131428594)), 0.0f);
        stickerSearchContainer.f16824J.b((double) b);
        if (animationFlag.equals(AnimationFlag.JUMP_TO_VALUE)) {
            stickerSearchContainer.f16824J.a((double) b).l();
        }
    }

    private void m24591g() {
        this.f16840k.m11056a(new C11927(this));
    }

    private void m24592k() {
        this.f16820F = this.f16843n.m24762a(this.f16852w, "", this.f16823I);
        this.f16820F.f17068i = f16813a;
        this.f16820F.m24761a(RegularImmutableList.a);
        View gridView = new GridView(this.f16852w, null, 2130773099);
        StickerGridController a = this.f16844o.m24758a(gridView, this.f16831Q);
        gridView.setNumColumns(this.f16823I.f7725a);
        gridView.setGravity(17);
        gridView.setAdapter(this.f16820F);
        a.f17054e = new Listener(this) {
            final /* synthetic */ StickerSearchContainer f16791a;

            {
                this.f16791a = r1;
            }

            public final void mo1271a(Sticker sticker) {
                if (this.f16791a.f16825K != null) {
                    this.f16791a.f16836g.hideSoftInputFromWindow(this.f16791a.getWindowToken(), 0);
                    this.f16791a.f16825K.mo1273a(sticker);
                    this.f16791a.f16848s.m23906a(sticker.f4938a, this.f16791a.f16851v.contains(sticker.f4938a), this.f16791a.f16826L.equals(State.TAG_RESULTS_SHOWN));
                }
            }
        };
        gridView.setPadding(0, (int) getResources().getDimension(2131428598), 0, 0);
        gridView.setClipToPadding(false);
        gridView.setOnScrollListener(new PositionTrackingOnScrollListener(this.f16822H, this.f16823I.f7725a, 0));
        this.f16817C.addView(gridView);
    }

    private void m24593l() {
        this.f16838i.m11055a();
        this.f16838i.m11057a(new StickerTagsLoader.Params(TagType.FEATURED));
    }

    public static void m24586a(StickerSearchContainer stickerSearchContainer, ImmutableList immutableList, final StickerFilterCallback stickerFilterCallback) {
        List a = Lists.a();
        final ArrayList a2 = Lists.a();
        int size = immutableList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Sticker sticker = (Sticker) immutableList.get(i2);
            if (stickerSearchContainer.f16851v.contains(sticker.f4938a)) {
                a.add(sticker.f4938a);
            } else if (i < 12) {
                i++;
            } else {
            }
            a2.add(sticker);
        }
        stickerSearchContainer.f16837h.m23950a();
        stickerSearchContainer.f16837h.m23951a(new Callback<StickersLoader.Params, StickersLoader.Results, Throwable>(stickerSearchContainer) {
            final /* synthetic */ StickerSearchContainer f16796c;

            public final void m24561b(Object obj, Object obj2) {
                StickersLoader.Results results = (StickersLoader.Results) obj2;
                StickerSearchContainer stickerSearchContainer = this.f16796c;
                List<Sticker> list = results.f16477a;
                List<Object> list2 = a2;
                Builder builder = ImmutableMap.builder();
                for (Sticker sticker : list) {
                    builder.b(sticker.f4938a, sticker);
                }
                Map b = builder.b();
                ImmutableList.Builder builder2 = ImmutableList.builder();
                for (Object obj3 : list2) {
                    Object obj32;
                    if (b.containsKey(obj32.f4938a)) {
                        obj32 = (Sticker) b.get(obj32.f4938a);
                    }
                    builder2.c(obj32);
                }
                stickerFilterCallback.mo1285a(builder2.b());
            }

            public final /* bridge */ /* synthetic */ void m24562c(Object obj, Object obj2) {
            }
        });
        stickerSearchContainer.f16837h.m23952a(new StickersLoader.Params(a));
    }

    public static void m24587a(StickerSearchContainer stickerSearchContainer, boolean z) {
        if (z) {
            stickerSearchContainer.f16815A.setVisibility(0);
            stickerSearchContainer.f16816B.setVisibility(8);
            return;
        }
        stickerSearchContainer.f16815A.setVisibility(8);
        stickerSearchContainer.f16816B.setVisibility(0);
    }

    public static void m24594m(StickerSearchContainer stickerSearchContainer) {
        setCurrentState(stickerSearchContainer, State.TAG_SELECTION);
    }

    public void setStickerInterface(StickerInterface stickerInterface) {
        this.f16831Q = stickerInterface;
        this.f16842m.m11057a(this.f16831Q);
        this.f16840k = this.f16839j.m24603a(this.f16831Q);
        m24591g();
        this.f16855z.setText("");
        m24594m(this);
    }
}
