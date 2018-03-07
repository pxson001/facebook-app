package com.facebook.greetingcards.render;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.greetingcards.create.PreviewCardFragment;
import com.facebook.greetingcards.create.PreviewCardFragment.C00292;
import com.facebook.greetingcards.model.CardPhoto;
import com.facebook.greetingcards.model.CardPhoto.Type;
import com.facebook.greetingcards.model.GreetingCard;
import com.facebook.greetingcards.model.GreetingCard.Slide;
import com.facebook.greetingcards.render.FoldingPopoverFragment.BackPressAwareFragment;
import com.facebook.greetingcards.render.templatefetch.FetchTemplateExecutor;
import com.facebook.greetingcards.render.templatefetch.TemplateResult;
import com.facebook.greetingcards.verve.VerveActionListener;
import com.facebook.greetingcards.verve.VerveMediaInfoSupplier;
import com.facebook.greetingcards.verve.model.VMMediaType;
import com.facebook.greetingcards.verve.render.VerveContentView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: {!redirect_after_accept false} */
public class RenderCardFragment extends BackPressAwareFragment {
    public static final Class<?> f151c = RenderCardFragment.class;
    public GreetingCard f152a;
    private View al;
    public VerveContentView am;
    private Button an;
    public C00292 ao;
    public VerveActionListener ap;
    public TemplateResult aq;
    public boolean ar = false;
    private int as;
    private AnalyticsLogger at;
    private NavigationLogger au;
    private ImmutableList<String> av;
    private LoadState aw = LoadState.NO_GREETING_CARD;
    public Executor f153b;
    private FetchTemplateExecutor f154d;
    private TemplateHelper f155e;
    private Provider<MediaGalleryLauncher> f156f;
    public AbstractFbErrorReporter f157g;
    private ProgressBar f158h;
    private View f159i;

    /* compiled from: {!redirect_after_accept false} */
    public abstract class AbstractRenderCardFragmentBuilder<T extends RenderCardFragment> {
        protected T f149a = mo5a();
        public Bundle f150b = new Bundle();

        protected abstract T mo5a();

        public AbstractRenderCardFragmentBuilder(int i) {
            this.f150b.putInt("args_mode", i);
        }

        public final AbstractRenderCardFragmentBuilder m160a(ImmutableList<String> immutableList) {
            this.f150b.putStringArrayList("args_button", Lists.a(immutableList));
            return this;
        }

        public final AbstractRenderCardFragmentBuilder m159a(GreetingCard greetingCard) {
            this.f149a.m175a(greetingCard);
            return this;
        }

        public final T m162b() {
            this.f149a.g(this.f150b);
            return this.f149a;
        }
    }

    /* compiled from: {!redirect_after_accept false} */
    class C00361 implements OnClickListener {
        final /* synthetic */ RenderCardFragment f216a;

        C00361(RenderCardFragment renderCardFragment) {
            this.f216a = renderCardFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1500193528);
            if (this.f216a.ao != null) {
                PreviewCardFragment.ax(this.f216a.ao.f146a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1850752736, a);
        }
    }

    /* compiled from: {!redirect_after_accept false} */
    class C00383 implements VerveMediaInfoSupplier {
        final /* synthetic */ RenderCardFragment f219a;

        C00383(RenderCardFragment renderCardFragment) {
            this.f219a = renderCardFragment;
        }

        public final VMMediaType m262a(String str) {
            return VMMediaType.IMAGE;
        }
    }

    /* compiled from: {!redirect_after_accept false} */
    enum LoadState {
        NO_GREETING_CARD,
        LOADING,
        ERROR,
        LOAD_COMPLETE
    }

    /* compiled from: {!redirect_after_accept false} */
    public class RenderCardFragmentBuilder extends AbstractRenderCardFragmentBuilder<RenderCardFragment> {
        public RenderCardFragmentBuilder(int i) {
            super(i);
        }

        protected final RenderCardFragment mo5a() {
            return new RenderCardFragment();
        }
    }

    public static void m169a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((RenderCardFragment) obj).m168a(FetchTemplateExecutor.m274a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 9351), new TemplateHelper(ResourcesMethodAutoProvider.a(injectorLike)), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), NavigationLogger.a(injectorLike));
    }

    public boolean mo6e() {
        return false;
    }

    public String am_() {
        return "tinsel_view_card";
    }

    @Inject
    private void m168a(FetchTemplateExecutor fetchTemplateExecutor, Executor executor, Provider<MediaGalleryLauncher> provider, TemplateHelper templateHelper, FbErrorReporter fbErrorReporter, AnalyticsLogger analyticsLogger, NavigationLogger navigationLogger) {
        this.f154d = fetchTemplateExecutor;
        this.f153b = executor;
        this.f156f = provider;
        this.f155e = templateHelper;
        this.f157g = fbErrorReporter;
        this.at = analyticsLogger;
        this.au = navigationLogger;
    }

    public final void m175a(GreetingCard greetingCard) {
        Preconditions.checkNotNull(greetingCard);
        if (this.f152a != greetingCard) {
            this.f152a = greetingCard;
            if (this.am != null) {
                m170b(this.f152a);
            }
        }
    }

    public void mo8c(Bundle bundle) {
        super.c(bundle);
        Class cls = RenderCardFragment.class;
        m169a((Object) this, getContext());
        if (bundle != null) {
            GreetingCard greetingCard = (GreetingCard) bundle.getParcelable("extra_greeting_card");
            if (greetingCard != null) {
                this.f152a = greetingCard;
            }
        }
    }

    public final View m173a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1648437742);
        if (viewGroup == null) {
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1612118136, a);
            return null;
        }
        View inflate = layoutInflater.inflate(2130904757, viewGroup, false);
        LogUtils.f(2067989099, a);
        return inflate;
    }

    public final void m178e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("extra_greeting_card", this.f152a);
    }

    public final void m174a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f158h = (ProgressBar) e(2131562862);
        this.f159i = e(2131562863);
        this.al = e(2131562864);
        this.am = (VerveContentView) e(2131562865);
        this.an = (Button) e(2131562866);
        this.an.setOnClickListener(new C00361(this));
        Collection stringArrayList = this.s.getStringArrayList("args_button");
        if (stringArrayList != null) {
            this.av = ImmutableList.copyOf(stringArrayList);
        }
        String str = null;
        if (this.f152a != null) {
            if (this.aq != null) {
                m167a(this, this.aq, this.f152a);
            } else if (this.ar) {
                m166a(this, LoadState.LOADING);
            } else {
                m170b(this.f152a);
            }
            str = this.f152a.f;
        }
        HoneyClientEvent b = new HoneyClientEvent("greeting_card_opened").b("greeting_card_id", str);
        String str2 = "source";
        if (this.s.getString("args_source") == null) {
            str = "feed";
        } else {
            str = this.s.getString("args_source");
        }
        this.at.a(b.b(str2, str));
        this.au.a(am_(), true);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 137714540);
        this.au.c(am_());
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -310534440, a);
    }

    public final void m171G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -311989572);
        super.G();
        this.as = o().getRequestedOrientation();
        o().setRequestedOrientation(1);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1307658106, a);
    }

    public final void m172H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1636287526);
        super.H();
        o().setRequestedOrientation(this.as);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 519596688, a);
    }

    public static void m166a(RenderCardFragment renderCardFragment, LoadState loadState) {
        int i = 0;
        if (loadState != renderCardFragment.aw) {
            int i2;
            renderCardFragment.aw = loadState;
            if (renderCardFragment.s.getInt("args_mode") == 0 && renderCardFragment.aw == LoadState.LOAD_COMPLETE) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            Button button = renderCardFragment.an;
            if (i2 != 0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            button.setVisibility(i2);
            View view = renderCardFragment.al;
            if (renderCardFragment.aw == LoadState.LOAD_COMPLETE) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view.setVisibility(i2);
            ProgressBar progressBar = renderCardFragment.f158h;
            if (renderCardFragment.aw == LoadState.LOADING || renderCardFragment.aw == LoadState.NO_GREETING_CARD) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            progressBar.setVisibility(i2);
            View view2 = renderCardFragment.f159i;
            if (renderCardFragment.aw != LoadState.ERROR) {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    public final void as() {
        if (this.f152a != null && this.aw != LoadState.LOAD_COMPLETE) {
            m170b(this.f152a);
        }
    }

    private DisplayMetrics au() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (VERSION.SDK_INT >= 19) {
            o().getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            o().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    private void m170b(final GreetingCard greetingCard) {
        m166a(this, LoadState.LOADING);
        DisplayMetrics au = au();
        Futures.a(this.f154d.m280a(greetingCard.d, au.widthPixels, au.heightPixels, GraphQlQueryDefaults.a()), new FutureCallback<TemplateResult>(this) {
            final /* synthetic */ RenderCardFragment f218b;

            public void onSuccess(Object obj) {
                try {
                    RenderCardFragment.m167a(this.f218b, (TemplateResult) obj, greetingCard);
                } catch (Throwable e) {
                    BLog.b(RenderCardFragment.f151c, e, "Error displaying layout", new Object[0]);
                }
            }

            public void onFailure(Throwable th) {
                this.f218b.f157g.a("greeting_card_load_failure", th);
                RenderCardFragment.m166a(this.f218b, LoadState.ERROR);
            }
        }, this.f153b);
    }

    private static HashMap<String, String> m165a(Slide slide) {
        HashMap<String, String> c = Maps.c();
        ImmutableList immutableList = slide.c;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            CardPhoto cardPhoto = (CardPhoto) immutableList.get(i);
            if (Type.REMOTE.equals(cardPhoto.b) || Type.LOCAL_UPLOADED.equals(cardPhoto.b)) {
                c.put(cardPhoto.a.toString(), cardPhoto.c);
            }
        }
        return c;
    }

    public final void m176a(TemplateResult templateResult) {
        this.aq = templateResult;
    }

    public static void m167a(RenderCardFragment renderCardFragment, TemplateResult templateResult, GreetingCard greetingCard) {
        float floatValue;
        int i = 0;
        m166a(renderCardFragment, LoadState.LOAD_COMPLETE);
        renderCardFragment.aq = templateResult;
        DisplayMetrics au = renderCardFragment.au();
        int i2 = au.widthPixels;
        int i3 = au.heightPixels;
        float floatValue2 = ((float) i2) / ((Float) templateResult.f243a.size.get(0)).floatValue();
        float floatValue3 = ((float) i3) / ((Float) templateResult.f243a.size.get(1)).floatValue();
        if (((double) Math.abs(floatValue2 - floatValue3)) < 0.01d) {
            floatValue = ((Float) templateResult.f243a.size.get(0)).floatValue() * floatValue2;
            floatValue2 = ((Float) templateResult.f243a.size.get(1)).floatValue() * floatValue3;
        } else {
            int dimensionPixelSize = renderCardFragment.jW_().getDimensionPixelSize(2131434020);
            float min = Math.min(((float) (i2 - (dimensionPixelSize * 2))) / ((Float) templateResult.f243a.size.get(0)).floatValue(), ((float) (i3 - (dimensionPixelSize * 2))) / ((Float) templateResult.f243a.size.get(1)).floatValue());
            floatValue = ((Float) templateResult.f243a.size.get(0)).floatValue() * min;
            floatValue2 = ((Float) templateResult.f243a.size.get(1)).floatValue() * min;
            renderCardFragment.al.setBackgroundResource(2130840766);
        }
        Map c = Maps.c();
        c.putAll(m165a(greetingCard.a));
        ImmutableList immutableList = greetingCard.b;
        int size = immutableList.size();
        while (i < size) {
            c.putAll(m165a((Slide) immutableList.get(i)));
            i++;
        }
        c.putAll(m165a(greetingCard.c));
        renderCardFragment.am.setLayoutParams(new LayoutParams((int) (floatValue + 0.5f), (int) (floatValue2 + 0.5f)));
        renderCardFragment.am.a(renderCardFragment.f155e.m272a(templateResult.f243a, greetingCard, floatValue, floatValue2, renderCardFragment.av), new GreetingCardVerveViewSupplier(templateResult, renderCardFragment.jW_(), ImmutableMap.copyOf(c), renderCardFragment.f156f), renderCardFragment.ap, new C00383(renderCardFragment));
    }
}
