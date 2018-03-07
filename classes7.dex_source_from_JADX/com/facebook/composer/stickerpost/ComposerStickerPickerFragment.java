package com.facebook.composer.stickerpost;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.ui.titlebar.ComposerBaseTitleBar;
import com.facebook.composer.ui.titlebar.ComposerTitleBar;
import com.facebook.composer.ui.titlebar.ComposerTitleBar.StateBuilder;
import com.facebook.composer.ui.titlebar.HarrisonPlusIconType;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerStickerData.Builder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativeediting.stickers.events.StickerEventBus;
import com.facebook.photos.creativeediting.stickers.events.StickerEvents.StickerSelectedEvent;
import com.facebook.photos.creativeediting.stickers.stickers.StickerPicker;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ui.dialogs.FbDialogFragment.FbDialog;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.google.common.base.Preconditions;

/* compiled from: compute_delta_and_upload */
public class ComposerStickerPickerFragment extends FbDialogFragment {
    private static final String am = ComposerStickerPickerFragment.class.getSimpleName();
    private final StickerSelectedEventSubscriber an = new StickerSelectedEventSubscriber(this);
    public Lazy<StickerEventBus> ao;
    public ComposerLauncher ap;
    private View aq;
    private StickerPicker ar;
    public String as;
    @Nullable
    public ComposerConfiguration at;
    public ComposerTitleBar au;
    public boolean av;
    public ComposerStickerController aw;
    public ComposerStickerPostLogger ax;
    public InputMethodManager ay;

    /* compiled from: compute_delta_and_upload */
    public class C13612 implements OnBackPressedListener {
        final /* synthetic */ ComposerStickerPickerFragment f16955a;

        public C13612(ComposerStickerPickerFragment composerStickerPickerFragment) {
            this.f16955a = composerStickerPickerFragment;
        }

        public final void m20910a() {
            boolean z = false;
            this.f16955a.ay.hideSoftInputFromWindow(this.f16955a.T.getWindowToken(), 0);
            ComposerStickerPostLogger composerStickerPostLogger = this.f16955a.ax;
            if (this.f16955a.at != null) {
                z = true;
            }
            composerStickerPostLogger.m20922b(z);
            this.f16955a.a();
        }
    }

    /* compiled from: compute_delta_and_upload */
    class StickerSelectedEventSubscriber extends com.facebook.photos.creativeediting.stickers.events.StickerEvents.StickerSelectedEventSubscriber {
        final /* synthetic */ ComposerStickerPickerFragment f16956a;

        public StickerSelectedEventSubscriber(ComposerStickerPickerFragment composerStickerPickerFragment) {
            this.f16956a = composerStickerPickerFragment;
        }

        public final void m20911b(FbEvent fbEvent) {
            StickerSelectedEvent stickerSelectedEvent = (StickerSelectedEvent) fbEvent;
            if (stickerSelectedEvent.f9609a != null) {
                this.f16956a.ax.m20920a(Builder.a(stickerSelectedEvent.f9609a).a());
                if (this.f16956a.at != null) {
                    this.f16956a.ap.a(this.f16956a.as, ComposerConfiguration.a(this.f16956a.at).setInitialStickerData(Builder.a(stickerSelectedEvent.f9609a).a()).a(), 1756, this.f16956a.an());
                    this.f16956a.av = true;
                    return;
                }
                if (this.f16956a.aw != null) {
                    this.f16956a.aw.m20909a(stickerSelectedEvent.f9609a);
                }
                this.f16956a.a();
            }
        }
    }

    public static void m20912a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ComposerStickerPickerFragment composerStickerPickerFragment = (ComposerStickerPickerFragment) obj;
        Lazy b = IdBasedSingletonScopeProvider.b(fbInjector, 9280);
        ComposerLauncher composerLauncher = (ComposerLauncher) ComposerLauncherImpl.a(fbInjector);
        ComposerStickerPostLogger composerStickerPostLogger = new ComposerStickerPostLogger(AnalyticsLoggerMethodAutoProvider.a(fbInjector));
        InputMethodManager b2 = InputMethodManagerMethodAutoProvider.b(fbInjector);
        composerStickerPickerFragment.ao = b;
        composerStickerPickerFragment.ap = composerLauncher;
        composerStickerPickerFragment.ax = composerStickerPostLogger;
        composerStickerPickerFragment.ay = b2;
    }

    public final void m20916a(Bundle bundle) {
        boolean z = true;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1791719772);
        super.a(bundle);
        Class cls = ComposerStickerPickerFragment.class;
        m20912a(this, getContext());
        this.as = (String) Preconditions.checkNotNull(this.s.getString("sessionId"));
        this.at = (ComposerConfiguration) this.s.getParcelable("composerConfiguration");
        boolean z2 = bundle != null && bundle.getBoolean("hasLaunchedComposer");
        this.av = z2;
        e(true);
        a(2, 2131625394);
        this.ax.f16958b = this.as;
        if (bundle == null) {
            ComposerStickerPostLogger composerStickerPostLogger = this.ax;
            if (this.at == null) {
                z = false;
            }
            composerStickerPostLogger.m20921a(z);
        }
        LogUtils.f(-1373720858, a);
    }

    public final View m20915a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1172549910);
        this.aq = layoutInflater.inflate(2130903727, viewGroup, false);
        ComposerBaseTitleBar composerBaseTitleBar = (ComposerBaseTitleBar) this.aq.findViewById(2131560640);
        composerBaseTitleBar.setOnBackPressedListener(new C13612(this));
        StateBuilder stateBuilder = new StateBuilder();
        stateBuilder.f2091a = jW_().getString(2131234533);
        stateBuilder = stateBuilder.m2067a(true);
        stateBuilder.f2094d = HarrisonPlusIconType.m2080c();
        this.au = new ComposerTitleBar(composerBaseTitleBar, stateBuilder.m2066a());
        this.ar = (StickerPicker) this.aq.findViewById(2131560641);
        this.ar.m11564a(this.as, am, StickerInterface.POSTS);
        this.ar.m11565b();
        View view = this.aq;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1056397082, a);
        return view;
    }

    public final Dialog m20917c(Bundle bundle) {
        return new FbDialog(this, getContext(), d()) {
            final /* synthetic */ ComposerStickerPickerFragment f16954b;

            public void onBackPressed() {
                this.f16954b.ax.m20922b(this.f16954b.at != null);
                dismiss();
            }
        };
    }

    public final void m20913G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1419972486);
        super.G();
        if (this.av) {
            a();
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1157269642, a);
            return;
        }
        this.ar.m11567d();
        ((StickerEventBus) this.ao.get()).a(this.an);
        LogUtils.f(-6231214, a);
    }

    public final void m20918e(Bundle bundle) {
        super.e(bundle);
        bundle.putBoolean("hasLaunchedComposer", this.av);
    }

    public final void m20914H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1621531329);
        ((StickerEventBus) this.ao.get()).b(this.an);
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -392599911, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1349372590);
        this.ar.m11563a();
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1271744962, a);
    }
}
