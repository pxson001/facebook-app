package com.facebook.search.quickpromotion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLSearchAwarenessTutorialNUXButtonStyle;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.resources.ui.FbButton;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.logging.SearchAwarenessLogger;
import com.facebook.search.prefs.SearchAwarenessPrefKeys;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.TutorialNuxCarouselFieldsFragmentModel;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.TutorialNuxConfigurationModel;
import com.facebook.search.quickpromotion.SearchAwarenessOptOutController.OnActionClickListener;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.viewpageindicator.CirclePageIndicator;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: TEXT_AUTHOR_PIC */
public class SearchAwarenessTutorialNuxActivity extends FbFragmentActivity {
    private FbButton f22430A;
    private FbButton f22431B;
    private FbButton f22432C;
    private GlyphView f22433D;
    private TutorialNuxConfigurationModel f22434E;
    @Inject
    private AwarenessTutorialNuxCardAdapterProvider f22435p;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SearchAwarenessTutorialNuxController> f22436q = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SearchAwarenessOptOutController> f22437r = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FbSharedPreferences> f22438s = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<UriIntentMapper> f22439t = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SearchAwarenessLogger> f22440u = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<GatekeeperStore> f22441v = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RTLUtil> f22442w = UltralightRuntime.b;
    public ViewPager f22443x;
    public CirclePageIndicator f22444y;
    private AwarenessTutorialNuxCardAdapter f22445z;

    /* compiled from: TEXT_AUTHOR_PIC */
    class C23861 implements OnPageChangeListener {
        final /* synthetic */ SearchAwarenessTutorialNuxActivity f22421a;

        C23861(SearchAwarenessTutorialNuxActivity searchAwarenessTutorialNuxActivity) {
            this.f22421a = searchAwarenessTutorialNuxActivity;
        }

        public final void m25899a(int i, float f, int i2) {
        }

        public final void e_(int i) {
            ((SearchAwarenessLogger) this.f22421a.f22440u.get()).a(SearchAwarenessTutorialNuxActivity.m25912d(this.f22421a, i));
            SearchAwarenessTutorialNuxActivity.m25921k(this.f22421a);
        }

        public final void m25900b(int i) {
        }
    }

    /* compiled from: TEXT_AUTHOR_PIC */
    class C23894 implements OnClickListener {
        final /* synthetic */ SearchAwarenessTutorialNuxActivity f22426a;

        C23894(SearchAwarenessTutorialNuxActivity searchAwarenessTutorialNuxActivity) {
            this.f22426a = searchAwarenessTutorialNuxActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 679256514);
            int n = SearchAwarenessTutorialNuxActivity.m25924n(this.f22426a);
            this.f22426a.f22443x.a(n, true);
            this.f22426a.f22444y.setCurrentItem(n);
            Logger.a(2, EntryType.UI_INPUT_END, -350963674, a);
        }
    }

    /* compiled from: TEXT_AUTHOR_PIC */
    class C23915 implements OnClickListener {
        final /* synthetic */ SearchAwarenessTutorialNuxActivity f22428a;

        /* compiled from: TEXT_AUTHOR_PIC */
        class C23901 implements OnActionClickListener {
            final /* synthetic */ C23915 f22427a;

            C23901(C23915 c23915) {
                this.f22427a = c23915;
            }

            public final void mo1239a() {
                ((SearchAwarenessLogger) this.f22427a.f22428a.f22440u.get()).b("dismiss_action");
                this.f22427a.f22428a.finish();
            }

            public final void mo1240b() {
                ((SearchAwarenessLogger) this.f22427a.f22428a.f22440u.get()).b("dismiss_action");
                this.f22427a.f22428a.finish();
            }
        }

        C23915(SearchAwarenessTutorialNuxActivity searchAwarenessTutorialNuxActivity) {
            this.f22428a = searchAwarenessTutorialNuxActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1827118356);
            if (((GatekeeperStoreImpl) this.f22428a.f22441v.get()).a(SearchAbTestGatekeepers.l, false)) {
                ((SearchAwarenessOptOutController) this.f22428a.f22437r.get()).m25893a(AwarenessType.TUTORIAL_NUX, new C23901(this), this.f22428a.f22443x.getWindowToken());
            } else {
                ((SearchAwarenessLogger) this.f22428a.f22440u.get()).b("dismiss_action");
                this.f22428a.finish();
            }
            LogUtils.a(629353712, a);
        }
    }

    /* compiled from: TEXT_AUTHOR_PIC */
    /* synthetic */ class C23926 {
        static final /* synthetic */ int[] f22429a = new int[GraphQLSearchAwarenessTutorialNUXButtonStyle.values().length];

        static {
            try {
                f22429a[GraphQLSearchAwarenessTutorialNUXButtonStyle.NEXT_BUTTON.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22429a[GraphQLSearchAwarenessTutorialNUXButtonStyle.HIDDEN_ON_FIRST_IMPRESSION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22429a[GraphQLSearchAwarenessTutorialNUXButtonStyle.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static <T extends Context> void m25907a(Class<T> cls, T t) {
        m25908a((Object) t, (Context) t);
    }

    public static void m25908a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SearchAwarenessTutorialNuxActivity) obj).m25906a((AwarenessTutorialNuxCardAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(AwarenessTutorialNuxCardAdapterProvider.class), IdBasedSingletonScopeProvider.b(fbInjector, 10523), IdBasedSingletonScopeProvider.b(fbInjector, 10520), IdBasedSingletonScopeProvider.b(fbInjector, 3078), IdBasedSingletonScopeProvider.b(fbInjector, 2436), IdBasedLazy.a(fbInjector, 3376), IdBasedSingletonScopeProvider.b(fbInjector, 2128), IdBasedSingletonScopeProvider.b(fbInjector, 552));
    }

    private void m25906a(AwarenessTutorialNuxCardAdapterProvider awarenessTutorialNuxCardAdapterProvider, com.facebook.inject.Lazy<SearchAwarenessTutorialNuxController> lazy, com.facebook.inject.Lazy<SearchAwarenessOptOutController> lazy2, com.facebook.inject.Lazy<FbSharedPreferences> lazy3, com.facebook.inject.Lazy<UriIntentMapper> lazy4, com.facebook.inject.Lazy<SearchAwarenessLogger> lazy5, com.facebook.inject.Lazy<GatekeeperStore> lazy6, com.facebook.inject.Lazy<RTLUtil> lazy7) {
        this.f22435p = awarenessTutorialNuxCardAdapterProvider;
        this.f22436q = lazy;
        this.f22437r = lazy2;
        this.f22438s = lazy3;
        this.f22439t = lazy4;
        this.f22440u = lazy5;
        this.f22441v = lazy6;
        this.f22442w = lazy7;
    }

    protected final void m25926b(Bundle bundle) {
        super.b(bundle);
        overridePendingTransition(2130968739, 0);
        setContentView(2130903330);
        Class cls = SearchAwarenessTutorialNuxActivity.class;
        m25908a((Object) this, (Context) this);
        this.f22434E = ((SearchAwarenessTutorialNuxController) this.f22436q.get()).f22472l;
        Preconditions.checkNotNull(this.f22434E);
        Preconditions.checkNotNull(this.f22434E.m9064a());
        InjectorLike injectorLike = this.f22435p;
        this.f22445z = new AwarenessTutorialNuxCardAdapter((SearchAwarenessTutorialNuxAssetManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchAwarenessTutorialNuxAssetManagerProvider.class), kO_(), SearchAwarenessTutorialNuxController.m25941a(injectorLike), (Context) injectorLike.getInstance(Context.class), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), RTLUtil.a(injectorLike));
        this.f22443x = (ViewPager) a(2131559779);
        this.f22443x.setAdapter(this.f22445z);
        this.f22444y = (CirclePageIndicator) a(2131559780);
        this.f22444y.setViewPager(this.f22443x);
        m25919i();
        this.f22444y.f = new C23861(this);
        final TutorialNuxCarouselFieldsFragmentModel a = this.f22434E.m9064a();
        this.f22430A = (FbButton) a(2131559762);
        this.f22430A.setText(a.m9055p());
        this.f22430A.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SearchAwarenessTutorialNuxActivity f22423b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -625219027);
                Object q = a.m9056q();
                if (!TextUtils.isEmpty(q)) {
                    Intent a2 = ((UriIntentMapper) this.f22423b.f22439t.get()).a(this.f22423b.getApplicationContext(), q);
                    if (a2 != null) {
                        this.f22423b.startActivity(a2);
                    }
                }
                ((SearchAwarenessLogger) this.f22423b.f22440u.get()).b("primary_action");
                SearchAwarenessTutorialNuxActivity.m25922l(this.f22423b);
                this.f22423b.finish();
                Logger.a(2, EntryType.UI_INPUT_END, 962282574, a);
            }
        });
        this.f22431B = (FbButton) a(2131559761);
        this.f22431B.setText(a.m9057r());
        this.f22431B.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SearchAwarenessTutorialNuxActivity f22425b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1126291563);
                Object s = a.m9058s();
                if (!TextUtils.isEmpty(s)) {
                    Intent a2 = ((UriIntentMapper) this.f22425b.f22439t.get()).a(this.f22425b.getApplicationContext(), s);
                    if (a2 != null) {
                        this.f22425b.startActivity(a2);
                    }
                }
                ((SearchAwarenessLogger) this.f22425b.f22440u.get()).b("secondary_action");
                this.f22425b.finish();
                Logger.a(2, EntryType.UI_INPUT_END, 1688123159, a);
            }
        });
        this.f22432C = (FbButton) a(2131559760);
        this.f22432C.setOnClickListener(new C23894(this));
        this.f22433D = (GlyphView) a(2131559781);
        this.f22433D.setOnClickListener(new C23915(this));
        m25921k(this);
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1900898229);
        super.onDestroy();
        this.f22430A.setOnClickListener(null);
        this.f22431B.setOnClickListener(null);
        this.f22432C.setOnClickListener(null);
        this.f22433D.setOnClickListener(null);
        this.f22444y.f = null;
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -2040660500, a);
    }

    public void onBackPressed() {
        super.onBackPressed();
        ((SearchAwarenessLogger) this.f22440u.get()).b("back_button_action");
    }

    private void m25919i() {
        int b = ((RTLUtil) this.f22442w.get()).a() ? this.f22445z.b() - 1 : 0;
        this.f22443x.setCurrentItem(b);
        this.f22444y.setCurrentItem(b);
        ((SearchAwarenessLogger) this.f22440u.get()).a(m25912d(this, b));
    }

    public static Intent m25904a(Context context) {
        return new Intent(context, SearchAwarenessTutorialNuxActivity.class);
    }

    private GraphQLSearchAwarenessTutorialNUXButtonStyle m25920j() {
        return this.f22434E.m9064a().m9047a();
    }

    public static void m25921k(SearchAwarenessTutorialNuxActivity searchAwarenessTutorialNuxActivity) {
        int i = 8;
        int i2 = searchAwarenessTutorialNuxActivity.f22443x.k;
        FbButton fbButton;
        int i3;
        switch (C23926.f22429a[searchAwarenessTutorialNuxActivity.m25920j().ordinal()]) {
            case 1:
                fbButton = searchAwarenessTutorialNuxActivity.f22430A;
                if (searchAwarenessTutorialNuxActivity.m25910b(i2)) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                fbButton.setVisibility(i3);
                fbButton = searchAwarenessTutorialNuxActivity.f22431B;
                if (searchAwarenessTutorialNuxActivity.m25910b(i2)) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                fbButton.setVisibility(i3);
                FbButton fbButton2 = searchAwarenessTutorialNuxActivity.f22432C;
                if (!searchAwarenessTutorialNuxActivity.m25910b(i2)) {
                    i = 0;
                }
                fbButton2.setVisibility(i);
                searchAwarenessTutorialNuxActivity.f22433D.setVisibility(0);
                return;
            case 2:
                if (searchAwarenessTutorialNuxActivity.m25910b(i2) || !searchAwarenessTutorialNuxActivity.m25925o()) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                fbButton = searchAwarenessTutorialNuxActivity.f22430A;
                if (i3 != 0) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                fbButton.setVisibility(i2);
                FbButton fbButton3 = searchAwarenessTutorialNuxActivity.f22431B;
                if (i3 != 0) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                fbButton3.setVisibility(i3);
                searchAwarenessTutorialNuxActivity.f22432C.setVisibility(8);
                GlyphView glyphView = searchAwarenessTutorialNuxActivity.f22433D;
                if (!searchAwarenessTutorialNuxActivity.m25925o()) {
                    i = 0;
                }
                glyphView.setVisibility(i);
                return;
            case 3:
                searchAwarenessTutorialNuxActivity.f22430A.setVisibility(0);
                searchAwarenessTutorialNuxActivity.f22431B.setVisibility(0);
                searchAwarenessTutorialNuxActivity.f22432C.setVisibility(8);
                searchAwarenessTutorialNuxActivity.f22433D.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public static void m25922l(SearchAwarenessTutorialNuxActivity searchAwarenessTutorialNuxActivity) {
        ((FbSharedPreferences) searchAwarenessTutorialNuxActivity.f22438s.get()).edit().putBoolean(SearchAwarenessPrefKeys.b("4084"), true).commit();
    }

    private int m25923m() {
        return ((RTLUtil) this.f22442w.get()).a() ? 0 : this.f22445z.b() - 1;
    }

    private boolean m25910b(int i) {
        return i == m25923m();
    }

    public static int m25924n(SearchAwarenessTutorialNuxActivity searchAwarenessTutorialNuxActivity) {
        return ((RTLUtil) searchAwarenessTutorialNuxActivity.f22442w.get()).a() ? Math.max(searchAwarenessTutorialNuxActivity.f22443x.k - 1, searchAwarenessTutorialNuxActivity.m25923m()) : Math.min(searchAwarenessTutorialNuxActivity.f22443x.k + 1, searchAwarenessTutorialNuxActivity.m25923m());
    }

    private boolean m25925o() {
        return ((FbSharedPreferences) this.f22438s.get()).a(SearchAwarenessPrefKeys.a("4084"), 0) == 1;
    }

    public static int m25912d(SearchAwarenessTutorialNuxActivity searchAwarenessTutorialNuxActivity, int i) {
        return ((RTLUtil) searchAwarenessTutorialNuxActivity.f22442w.get()).a() ? searchAwarenessTutorialNuxActivity.f22445z.b() - i : i + 1;
    }
}
