package com.facebook.composer.ui.footerbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.NavigationLogger;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass22;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsTransliterationSupported;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: fb_incentive_start_confirmation_fragment */
public class ComposerTransliterationFooterBarController<DataProvider extends ProvidesIsTransliterationSupported> extends ComposerFooterBarControllerBase {
    private static final ImmutableList<ComposerEvent> f7091a = ImmutableList.of(ComposerEvent.ON_FIRST_DRAW);
    private final OnClickListener f7092b = new C09011(this);
    public final WeakReference<Listener> f7093c;
    public final WeakReference<DataProvider> f7094d;
    private final LazyFooterView<GlyphButton> f7095e;

    /* compiled from: fb_incentive_start_confirmation_fragment */
    class C09011 implements OnClickListener {
        final /* synthetic */ ComposerTransliterationFooterBarController f7090a;

        C09011(ComposerTransliterationFooterBarController composerTransliterationFooterBarController) {
            this.f7090a = composerTransliterationFooterBarController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 831320488);
            AnonymousClass22 anonymousClass22 = (AnonymousClass22) this.f7090a.f7093c.get();
            if (anonymousClass22 != null) {
                ((NavigationLogger) anonymousClass22.f6051a.ap.get()).a("tap_composer_footer_buttons");
                ComposerFragment.ck(anonymousClass22.f6051a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -11755615, a);
        }
    }

    @Inject
    public ComposerTransliterationFooterBarController(@Assisted Listener listener, @Assisted DataProvider dataProvider, @Assisted LazyFooterView<GlyphButton> lazyFooterView) {
        this.f7094d = new WeakReference(dataProvider);
        this.f7093c = new WeakReference(listener);
        this.f7095e = lazyFooterView;
    }

    protected final ImmutableList<ComposerEvent> mo214a() {
        return f7091a;
    }

    public final void mo215b() {
        if (((ComposerDataProviderImpl) this.f7094d.get()).m7416S()) {
            ((GlyphButton) this.f7095e.m8352a()).setVisibility(0);
            ((GlyphButton) this.f7095e.m8352a()).setOnClickListener(this.f7092b);
            return;
        }
        this.f7095e.m8353b();
    }
}
