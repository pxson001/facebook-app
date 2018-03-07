package com.facebook.composer.ui.footerbar;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass17;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.prefs.ComposerPrefKeys;
import com.facebook.composer.tip.Tip;
import com.facebook.composer.tip.TipControllerInterface;
import com.facebook.composer.tip.TipManager;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fbui.tooltip.Tooltip.OnTooltipClickListener;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsCheckinSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesShouldShowNoLocationBadge;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.model.ComposerContentType;
import com.facebook.ipc.composer.model.ComposerContentType.ProvidesContentType;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: feed scroll listener must be set */
public class ComposerCheckInFooterBarController<DataProvider extends ProvidesAttachments & ProvidesIsCheckinSupported & ProvidesSessionId & ProvidesShouldShowNoLocationBadge & ProvidesConfiguration & ProvidesContentType & ProvidesLocationInfo> implements ComposerFooterBarController {
    private static final ImmutableList<ComposerEvent> f7022b = ImmutableList.of(ComposerEvent.ON_FIRST_DRAW, ComposerEvent.ON_DATASET_CHANGE, ComposerEvent.ON_SCROLL_CHANGED);
    public final WeakReference<DataProvider> f7023a;
    private final OnClickListener f7024c = new C08801(this);
    public final Context f7025d;
    public final LazyFooterView<BadgeableFooterButton> f7026e;
    public final AnonymousClass17 f7027f;
    public final FbNetworkManager f7028g;
    public final TipManager f7029h;
    public final TipSeenTracker f7030i;

    /* compiled from: feed scroll listener must be set */
    class C08801 implements OnClickListener {
        final /* synthetic */ ComposerCheckInFooterBarController f7014a;

        C08801(ComposerCheckInFooterBarController composerCheckInFooterBarController) {
            this.f7014a = composerCheckInFooterBarController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -896734265);
            this.f7014a.f7027f.m7452a();
            Logger.a(2, EntryType.UI_INPUT_END, -1398146290, a);
        }
    }

    /* compiled from: feed scroll listener must be set */
    public class C08842 implements TipControllerInterface {
        final /* synthetic */ ComposerCheckInFooterBarController f7018a;
        public Tooltip f7019b;
        public boolean f7020c = false;

        /* compiled from: feed scroll listener must be set */
        class C08831 implements Runnable {
            final /* synthetic */ C08842 f7017a;

            /* compiled from: feed scroll listener must be set */
            class C08811 implements OnTooltipClickListener {
                final /* synthetic */ C08831 f7015a;

                C08811(C08831 c08831) {
                    this.f7015a = c08831;
                }

                public final void m8301a() {
                    this.f7015a.f7017a.f7018a.f7027f.m7452a();
                }
            }

            /* compiled from: feed scroll listener must be set */
            class C08822 implements OnDismissListener {
                final /* synthetic */ C08831 f7016a;

                C08822(C08831 c08831) {
                    this.f7016a = c08831;
                }

                public final boolean m8302a(PopoverWindow popoverWindow) {
                    this.f7016a.f7017a.f7020c = false;
                    return false;
                }
            }

            C08831(C08842 c08842) {
                this.f7017a = c08842;
            }

            public void run() {
                int i;
                this.f7017a.f7019b = new Tooltip(this.f7017a.f7018a.f7025d, 2);
                this.f7017a.f7018a.f7030i.a();
                Tooltip tooltip = this.f7017a.f7019b;
                ProvidesAttachments providesAttachments = (ProvidesAttachments) this.f7017a.f7018a.f7023a.get();
                if (providesAttachments != null) {
                    switch (C08853.f7021a[((ProvidesContentType) providesAttachments).c().ordinal()]) {
                        case 1:
                            i = 2131234639;
                            break;
                        case 2:
                            i = 2131234712;
                            break;
                        default:
                            i = 2131234709;
                            break;
                    }
                }
                i = 2131234709;
                tooltip.b(i);
                this.f7017a.f7019b.t = -1;
                this.f7017a.f7019b.a(new C08811(this));
                this.f7017a.f7019b.H = new C08822(this);
                this.f7017a.f7019b.a(Position.ABOVE);
                this.f7017a.f7019b.f(this.f7017a.f7018a.f7026e.m8352a());
            }
        }

        public C08842(ComposerCheckInFooterBarController composerCheckInFooterBarController) {
            this.f7018a = composerCheckInFooterBarController;
        }

        public final void m8303a() {
            this.f7020c = true;
            ((BadgeableFooterButton) this.f7018a.f7026e.m8352a()).post(new C08831(this));
        }

        public final boolean m8304b() {
            if (!this.f7018a.f7030i.c()) {
                return false;
            }
            ProvidesAttachments providesAttachments = (ProvidesAttachments) this.f7018a.f7023a.get();
            if (providesAttachments == null) {
                return false;
            }
            boolean z;
            if (((ProvidesConfiguration) providesAttachments).o().getPlatformConfiguration() == null || !((ProvidesConfiguration) providesAttachments).o().getPlatformConfiguration().b()) {
                z = false;
            } else {
                z = true;
            }
            if (!ComposerCheckInFooterBarController.m8307c(this.f7018a) || ((ProvidesLocationInfo) providesAttachments).g().k() || !this.f7018a.f7028g.d() || r2 || ((ProvidesContentType) providesAttachments).c() == ComposerContentType.NO_ATTACHMENTS) {
                return false;
            }
            return true;
        }

        public final boolean m8305c() {
            if (this.f7019b == null) {
                return false;
            }
            this.f7019b.l();
            return true;
        }

        public final boolean m8306d() {
            return this.f7020c;
        }
    }

    /* compiled from: feed scroll listener must be set */
    public /* synthetic */ class C08853 {
        public static final /* synthetic */ int[] f7021a = new int[ComposerContentType.values().length];

        static {
            try {
                f7021a[ComposerContentType.SINGLE_PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7021a[ComposerContentType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f7021a[ComposerContentType.MULTIPLE_PHOTOS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f7021a[ComposerContentType.NO_ATTACHMENTS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    @Inject
    public ComposerCheckInFooterBarController(@Assisted TipManager tipManager, @Assisted LazyFooterView<BadgeableFooterButton> lazyFooterView, @Assisted Listener listener, @Assisted DataProvider dataProvider, Context context, FbNetworkManager fbNetworkManager, TipSeenTracker tipSeenTracker) {
        this.f7029h = tipManager;
        this.f7030i = tipSeenTracker;
        this.f7023a = new WeakReference(dataProvider);
        this.f7025d = context;
        this.f7028g = fbNetworkManager;
        this.f7027f = listener;
        this.f7026e = lazyFooterView;
        this.f7030i.a(ComposerPrefKeys.k);
        this.f7029h.a(Tip.TAG_PLACE_AFTER_PHOTO, new C08842(this));
    }

    public final void m8308a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        if (f7022b.contains(composerEvent) && composerEvent != ComposerEvent.ON_SCROLL_CHANGED) {
            mo215b();
        }
    }

    public final void mo215b() {
        ProvidesAttachments providesAttachments = (ProvidesAttachments) this.f7023a.get();
        if (providesAttachments == null || !m8307c(this)) {
            this.f7026e.m8353b();
            return;
        }
        ((BadgeableFooterButton) this.f7026e.m8352a()).setActive(((ProvidesLocationInfo) providesAttachments).g().k());
        ((BadgeableFooterButton) this.f7026e.m8352a()).setVisibility(0);
        ((BadgeableFooterButton) this.f7026e.m8352a()).setOnClickListener(this.f7024c);
        ProvidesAttachments providesAttachments2 = (ProvidesAttachments) this.f7023a.get();
        if (providesAttachments2 != null) {
            Object obj;
            if (((FbLocationStatusUtil) ((ComposerDataProviderImpl) providesAttachments2).f6034r.get()).b().a == State.LOCATION_DISABLED) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                ((BadgeableFooterButton) this.f7026e.m8352a()).getBadgeView().setVisibility(0);
            } else {
                ((BadgeableFooterButton) this.f7026e.m8352a()).m8294a();
            }
        }
    }

    public static boolean m8307c(ComposerCheckInFooterBarController composerCheckInFooterBarController) {
        ProvidesAttachments providesAttachments = (ProvidesAttachments) composerCheckInFooterBarController.f7023a.get();
        return providesAttachments != null && ((ComposerDataProviderImpl) providesAttachments).m7400A();
    }
}
