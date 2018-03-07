package com.facebook.composer.ui.footerbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass12;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.prefs.ComposerPrefKeys;
import com.facebook.composer.tip.Tip;
import com.facebook.composer.tip.TipControllerInterface;
import com.facebook.composer.tip.TipManager;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fbui.tooltip.Tooltip.OnTooltipClickListener;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsFacecastSupported;
import com.facebook.ipc.composer.model.ComposerFacecastInfo.ProvidesFacecastInfo;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: featured_admin_profile_image_size */
public class ComposerFacecastFooterBarController<DataProvider extends ProvidesIsFacecastSupported & ProvidesFacecastInfo> extends ComposerFooterBarControllerBase {
    private static final ImmutableList<ComposerEvent> f7038a = ImmutableList.of(ComposerEvent.ON_FIRST_DRAW, ComposerEvent.ON_DATASET_CHANGE);
    public final WeakReference<DataProvider> f7039b;
    public final LazyFooterView<GlyphButton> f7040c;
    public final Context f7041d;
    public final TipSeenTracker f7042e;
    public final WeakReference<Listener> f7043f;
    private final OnClickListener f7044g = new C08861(this);

    /* compiled from: featured_admin_profile_image_size */
    class C08861 implements OnClickListener {
        final /* synthetic */ ComposerFacecastFooterBarController f7031a;

        C08861(ComposerFacecastFooterBarController composerFacecastFooterBarController) {
            this.f7031a = composerFacecastFooterBarController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1993997416);
            ((AnonymousClass12) Preconditions.checkNotNull(this.f7031a.f7043f.get())).m7450a();
            Logger.a(2, EntryType.UI_INPUT_END, 1456591522, a);
        }
    }

    /* compiled from: featured_admin_profile_image_size */
    public class C08902 implements TipControllerInterface {
        final /* synthetic */ ComposerFacecastFooterBarController f7035a;
        public Tooltip f7036b;
        public boolean f7037c = false;

        /* compiled from: featured_admin_profile_image_size */
        class C08891 implements Runnable {
            final /* synthetic */ C08902 f7034a;

            /* compiled from: featured_admin_profile_image_size */
            class C08871 implements OnTooltipClickListener {
                final /* synthetic */ C08891 f7032a;

                C08871(C08891 c08891) {
                    this.f7032a = c08891;
                }

                public final void m8311a() {
                    ((AnonymousClass12) this.f7032a.f7034a.f7035a.f7043f.get()).m7450a();
                }
            }

            /* compiled from: featured_admin_profile_image_size */
            class C08882 implements OnDismissListener {
                final /* synthetic */ C08891 f7033a;

                C08882(C08891 c08891) {
                    this.f7033a = c08891;
                }

                public final boolean m8312a(PopoverWindow popoverWindow) {
                    this.f7033a.f7034a.f7037c = false;
                    return false;
                }
            }

            C08891(C08902 c08902) {
                this.f7034a = c08902;
            }

            public void run() {
                this.f7034a.f7036b = new Tooltip(this.f7034a.f7035a.f7041d, 2);
                this.f7034a.f7035a.f7042e.a();
                this.f7034a.f7036b.b(2131234783);
                this.f7034a.f7036b.t = -1;
                this.f7034a.f7036b.a(new C08871(this));
                this.f7034a.f7036b.H = new C08882(this);
                this.f7034a.f7036b.a(Position.ABOVE);
                this.f7034a.f7036b.f(this.f7034a.f7035a.f7040c.m8352a());
            }
        }

        public C08902(ComposerFacecastFooterBarController composerFacecastFooterBarController) {
            this.f7035a = composerFacecastFooterBarController;
        }

        public final void m8313a() {
            this.f7037c = true;
            ((GlyphButton) this.f7035a.f7040c.m8352a()).post(new C08891(this));
        }

        public final boolean m8314b() {
            return this.f7035a.f7042e.c() && this.f7035a.f7039b.get() != null && ((ComposerDataProviderImpl) this.f7035a.f7039b.get()).m7429e().facecastCameraIndex == -1 && ComposerFacecastFooterBarController.m8317c(this.f7035a);
        }

        public final boolean m8315c() {
            if (this.f7036b == null) {
                return false;
            }
            this.f7036b.l();
            this.f7036b = null;
            return true;
        }

        public final boolean m8316d() {
            return this.f7037c;
        }
    }

    @Inject
    @SuppressLint({"ConstructorMayLeakThis"})
    public ComposerFacecastFooterBarController(@Assisted TipManager tipManager, @Assisted LazyFooterView<GlyphButton> lazyFooterView, @Assisted DataProvider dataProvider, @Assisted Listener listener, Context context, TipSeenTracker tipSeenTracker) {
        this.f7039b = new WeakReference(Preconditions.checkNotNull(dataProvider));
        this.f7043f = new WeakReference(Preconditions.checkNotNull(listener));
        this.f7040c = lazyFooterView;
        this.f7041d = context;
        this.f7042e = tipSeenTracker;
        this.f7042e.a(ComposerPrefKeys.r);
        tipManager.a(Tip.FACECAST_ICON_NUX, new C08902(this));
    }

    protected final ImmutableList<ComposerEvent> mo214a() {
        return f7038a;
    }

    public final void mo215b() {
        ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) this.f7039b.get();
        if (composerDataProviderImpl != null) {
            if (m8317c(this)) {
                if (composerDataProviderImpl.m7429e().facecastCameraIndex != -1) {
                    ((GlyphButton) this.f7040c.m8352a()).setGlyphColor(this.f7041d.getResources().getColor(2131362954));
                } else {
                    ((GlyphButton) this.f7040c.m8352a()).setGlyphColor(this.f7041d.getResources().getColorStateList(2131364092));
                }
                ((GlyphButton) this.f7040c.m8352a()).setVisibility(0);
                ((GlyphButton) this.f7040c.m8352a()).setOnClickListener(this.f7044g);
                return;
            }
            this.f7040c.m8353b();
        }
    }

    public static boolean m8317c(ComposerFacecastFooterBarController composerFacecastFooterBarController) {
        return ((ComposerDataProviderImpl) Preconditions.checkNotNull(composerFacecastFooterBarController.f7039b.get())).m7403D();
    }
}
