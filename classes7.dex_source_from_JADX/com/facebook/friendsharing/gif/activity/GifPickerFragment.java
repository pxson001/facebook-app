package com.facebook.friendsharing.gif.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ForegroundExecutorService;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.friendsharing.gif.model.GifModelContainer;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.GridSpacingItemDecoration;
import com.facebook.widget.text.watcher.BaseTextWatcher;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: SEEN */
public class GifPickerFragment extends FbFragment {
    public static final String f23898h = GifPickerFragment.class.getSimpleName();
    @Inject
    Lazy<TasksManager> f23899a;
    public ComposerConfiguration al;
    public String am;
    private GifPickerAdapter an;
    private BetterRecyclerView ao;
    private StaggeredGridLayoutManager ap;
    private ProgressBar aq;
    public List<GifModelContainer> ar;
    public GifTypeaheadText as;
    public TextView at;
    private State au;
    private final OnClickListener av = new C20611(this);
    private final TextWatcher aw = new C20622(this);
    private final OnClickListener ax = new C20633(this);
    @Inject
    Lazy<FbErrorReporter> f23900b;
    @Inject
    @ForegroundExecutorService
    ListeningExecutorService f23901c;
    @Inject
    public GifPickerAnalyticsLogger f23902d;
    @Inject
    GifPickerAdapterProvider f23903e;
    @Inject
    GifFetch f23904f;
    @Inject
    public ComposerLauncher f23905g;
    private Fb4aTitleBar f23906i;

    /* compiled from: SEEN */
    class C20611 implements OnClickListener {
        final /* synthetic */ GifPickerFragment f23885a;

        C20611(GifPickerFragment gifPickerFragment) {
            this.f23885a = gifPickerFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1081302961);
            this.f23885a.at.setVisibility(4);
            this.f23885a.as.f23911b.a();
            GifPickerFragment.ar(this.f23885a);
            Logger.a(2, EntryType.UI_INPUT_END, 836003768, a);
        }
    }

    /* compiled from: SEEN */
    class C20622 extends BaseTextWatcher {
        final /* synthetic */ GifPickerFragment f23886a;

        C20622(GifPickerFragment gifPickerFragment) {
            this.f23886a = gifPickerFragment;
        }

        public void afterTextChanged(Editable editable) {
            if (GifPickerFragment.aq(this.f23886a).isEmpty()) {
                GifPickerFragment.ar(this.f23886a);
            } else {
                GifPickerFragment.m26025b(this.f23886a, GifPickerFragment.aq(this.f23886a));
            }
        }
    }

    /* compiled from: SEEN */
    class C20633 implements OnClickListener {
        final /* synthetic */ GifPickerFragment f23887a;

        C20633(GifPickerFragment gifPickerFragment) {
            this.f23887a = gifPickerFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1409364406);
            this.f23887a.as.f23911b.a();
            Logger.a(2, EntryType.UI_INPUT_END, 308171058, a);
        }
    }

    /* compiled from: SEEN */
    class C20644 implements OnClickListener {
        final /* synthetic */ GifPickerFragment f23888a;

        C20644(GifPickerFragment gifPickerFragment) {
            this.f23888a = gifPickerFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -429841220);
            this.f23888a.ao().onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 1822592175, a);
        }
    }

    /* compiled from: SEEN */
    class C20655 extends OnScrollListener {
        final /* synthetic */ GifPickerFragment f23889a;

        C20655(GifPickerFragment gifPickerFragment) {
            this.f23889a = gifPickerFragment;
        }

        public final void m26016a(RecyclerView recyclerView, int i) {
            super.a(recyclerView, i);
            if (i == 1) {
                this.f23889a.as.f23911b.c();
            }
        }
    }

    /* compiled from: SEEN */
    enum State {
        FETCH,
        IDLE,
        NO_RESULTS,
        ERROR
    }

    public static void m26024a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GifPickerFragment) obj).m26023a(IdBasedLazy.a(fbInjector, 3561), IdBasedSingletonScopeProvider.b(fbInjector, 494), ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(fbInjector), new GifPickerAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(fbInjector)), (GifPickerAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GifPickerAdapterProvider.class), new GifFetch(IdBasedSingletonScopeProvider.b(fbInjector, 494), FbObjectMapperMethodAutoProvider.a(fbInjector)), (ComposerLauncher) ComposerLauncherImpl.a(fbInjector));
    }

    public static void m26022a(GifPickerFragment gifPickerFragment, State state) {
        gifPickerFragment.au = state;
        switch (state) {
            case FETCH:
                gifPickerFragment.at.setVisibility(8);
                gifPickerFragment.ao.setVisibility(8);
                gifPickerFragment.aq.setVisibility(0);
                return;
            case IDLE:
                gifPickerFragment.at.setVisibility(8);
                gifPickerFragment.aq.setVisibility(8);
                gifPickerFragment.ao.setVisibility(0);
                return;
            case NO_RESULTS:
                gifPickerFragment.ao.setVisibility(8);
                gifPickerFragment.aq.setVisibility(8);
                gifPickerFragment.at.setText(gifPickerFragment.jW_().getString(2131238346, new Object[]{gifPickerFragment.as.f23911b.getText().toString()}));
                gifPickerFragment.at.setContentDescription(gifPickerFragment.jW_().getString(2131238346, new Object[]{gifPickerFragment.as.f23911b.getText().toString()}));
                gifPickerFragment.at.setFocusable(true);
                gifPickerFragment.at.setVisibility(0);
                return;
            case ERROR:
                gifPickerFragment.ao.setVisibility(8);
                gifPickerFragment.aq.setVisibility(8);
                gifPickerFragment.at.setText(gifPickerFragment.jW_().getString(2131238345));
                gifPickerFragment.at.setContentDescription(gifPickerFragment.jW_().getString(2131238345));
                gifPickerFragment.at.setFocusable(true);
                gifPickerFragment.at.setVisibility(0);
                gifPickerFragment.at.setOnClickListener(gifPickerFragment.av);
                return;
            default:
                gifPickerFragment.ao.setVisibility(8);
                gifPickerFragment.aq.setVisibility(8);
                gifPickerFragment.at.setVisibility(8);
                return;
        }
    }

    public static String aq(GifPickerFragment gifPickerFragment) {
        return gifPickerFragment.as.f23911b.getText().toString().trim();
    }

    public final void m26031c(Bundle bundle) {
        super.c(bundle);
        Class cls = GifPickerFragment.class;
        m26024a((Object) this, getContext());
        this.ar = new ArrayList();
    }

    public final View m26029a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -146270571);
        View inflate = layoutInflater.inflate(2130904589, viewGroup, false);
        this.f23906i = (Fb4aTitleBar) inflate.findViewById(2131562532);
        this.f23906i.setTitle(jW_().getString(2131238343));
        this.f23906i.a(new C20644(this));
        if (bundle != null) {
            this.am = bundle.getString("gif_picker_session_id_instance_state");
        } else {
            this.am = this.s.getString("extra_gif_picker_launcher_id");
            if (this.am == null) {
                this.am = SafeUUIDGenerator.a().toString();
            }
        }
        this.al = (ComposerConfiguration) Preconditions.checkNotNull((ComposerConfiguration) this.s.getParcelable("extra_gif_picker_launcher_settings"));
        this.aq = (ProgressBar) inflate.findViewById(2131562536);
        this.ao = (BetterRecyclerView) inflate.findViewById(2131562535);
        this.ao.v = false;
        this.ap = new StaggeredGridLayoutManager(2, 1);
        this.ao.setLayoutManager(this.ap);
        this.ao.a(new GridSpacingItemDecoration(jW_().getDimensionPixelSize(2131432427)));
        this.ao.setOnScrollListener(new C20655(this));
        this.as = (GifTypeaheadText) inflate.findViewById(2131562533);
        this.as.setClearTextButtonListener(this.ax);
        this.at = (TextView) inflate.findViewById(2131562534);
        ar(this);
        GifPickerAnalyticsLogger gifPickerAnalyticsLogger = this.f23902d;
        gifPickerAnalyticsLogger.f23884a.a(new HoneyClientEvent("gif_picker_on_fragment_create").b("session_id", this.am));
        LogUtils.f(194911363, a);
        return inflate;
    }

    public final void m26032e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("gif_picker_session_id_instance_state", this.am);
    }

    public final void m26028H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 723949348);
        ((TasksManager) this.f23899a.get()).c();
        this.as.f23911b.removeTextChangedListener(this.aw);
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 543001296, a);
    }

    public final void m26027G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -225970010);
        super.G();
        this.as.f23911b.addTextChangedListener(this.aw);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -822291787, a);
    }

    public final void m26030a(int i, int i2, Intent intent) {
        switch (i) {
            case 1240:
                ao().setResult(i2, intent);
                ao().finish();
                return;
            default:
                return;
        }
    }

    public static void ar(GifPickerFragment gifPickerFragment) {
        final ListenableFuture c = gifPickerFragment.m26026c("http://api.giphy.com/v1/gifs/trending?api_key=dc6zaTOxFJmzC");
        m26022a(gifPickerFragment, State.FETCH);
        ((TasksManager) gifPickerFragment.f23899a.get()).a("TrendingGifsTask", c, new AbstractDisposableFutureCallback(gifPickerFragment) {
            final /* synthetic */ GifPickerFragment f23891b;

            protected final void m26017a(Object obj) {
                try {
                    this.f23891b.ar = (List) FutureDetour.a(c, -324889679);
                    GifPickerFragment.as(this.f23891b);
                    this.f23891b.f23902d.m26014d(this.f23891b.am);
                } catch (Throwable e) {
                    ((AbstractFbErrorReporter) this.f23891b.f23900b.get()).b(GifPickerFragment.f23898h, "Error on Succesful Result", e);
                    GifPickerFragment.m26022a(this.f23891b, State.ERROR);
                }
            }

            protected final void m26018a(Throwable th) {
                this.f23891b.f23902d.m26015e(this.f23891b.am);
                ((AbstractFbErrorReporter) this.f23891b.f23900b.get()).a(GifPickerFragment.f23898h, "Error on onNonCancellationFailure", th);
                GifPickerFragment.m26022a(this.f23891b, State.ERROR);
            }
        });
    }

    public static void m26025b(GifPickerFragment gifPickerFragment, final String str) {
        m26022a(gifPickerFragment, State.FETCH);
        final ListenableFuture c = gifPickerFragment.m26026c("http://api.giphy.com/v1/gifs/search?q=" + str.replaceAll(" ", "+") + "&api_key=dc6zaTOxFJmzC");
        ((TasksManager) gifPickerFragment.f23899a.get()).a("SearchGifsTask", c, new AbstractDisposableFutureCallback(gifPickerFragment) {
            final /* synthetic */ GifPickerFragment f23894c;

            protected final void m26019a(Object obj) {
                try {
                    this.f23894c.ar = (List) FutureDetour.a(c, -132827567);
                    GifPickerFragment.as(this.f23894c);
                    this.f23894c.f23902d.m26013a(this.f23894c.am, str, this.f23894c.ar.size());
                } catch (Throwable e) {
                    ((AbstractFbErrorReporter) this.f23894c.f23900b.get()).a(GifPickerFragment.f23898h, "Error on Successful Result : Search Gifs", e);
                    GifPickerFragment.m26022a(this.f23894c, State.ERROR);
                }
            }

            protected final void m26020a(Throwable th) {
                this.f23894c.f23902d.m26015e(this.f23894c.am);
                ((AbstractFbErrorReporter) this.f23894c.f23900b.get()).a(GifPickerFragment.f23898h, "Error on onNonCancellationFailure", th);
                GifPickerFragment.m26022a(this.f23894c, State.ERROR);
            }
        });
    }

    public static void as(GifPickerFragment gifPickerFragment) {
        if (gifPickerFragment.au != State.ERROR) {
            if (gifPickerFragment.ar.isEmpty()) {
                m26022a(gifPickerFragment, State.NO_RESULTS);
                return;
            }
            m26022a(gifPickerFragment, State.IDLE);
            if (gifPickerFragment.an != null) {
                gifPickerFragment.an.f23880c = ImmutableList.copyOf(gifPickerFragment.ar);
                gifPickerFragment.an.notifyDataSetChanged();
                return;
            }
            GifPickerAdapterProvider gifPickerAdapterProvider = gifPickerFragment.f23903e;
            gifPickerFragment.an = new GifPickerAdapter(FbDraweeControllerBuilder.b(gifPickerAdapterProvider), IdBasedSingletonScopeProvider.b(gifPickerAdapterProvider, 494), gifPickerFragment.ao(), ImmutableList.copyOf(gifPickerFragment.ar), gifPickerFragment);
            gifPickerFragment.ao.setAdapter(gifPickerFragment.an);
        }
    }

    private void m26023a(Lazy<TasksManager> lazy, Lazy<FbErrorReporter> lazy2, ListeningExecutorService listeningExecutorService, GifPickerAnalyticsLogger gifPickerAnalyticsLogger, GifPickerAdapterProvider gifPickerAdapterProvider, GifFetch gifFetch, ComposerLauncher composerLauncher) {
        this.f23899a = lazy;
        this.f23900b = lazy2;
        this.f23901c = listeningExecutorService;
        this.f23902d = gifPickerAnalyticsLogger;
        this.f23903e = gifPickerAdapterProvider;
        this.f23904f = gifFetch;
        this.f23905g = composerLauncher;
    }

    private ListenableFuture<ImmutableList<GifModelContainer>> m26026c(final String str) {
        return this.f23901c.a(new Callable<ImmutableList<GifModelContainer>>(this) {
            final /* synthetic */ GifPickerFragment f23896b;

            public Object call() {
                try {
                    return this.f23896b.f23904f.m26007a(str);
                } catch (Throwable e) {
                    ((AbstractFbErrorReporter) this.f23896b.f23900b.get()).a(GifPickerFragment.f23898h, "Error while fetching Gifs", e);
                    GifPickerFragment.m26022a(this.f23896b, State.ERROR);
                    return ImmutableList.of();
                }
            }
        });
    }
}
