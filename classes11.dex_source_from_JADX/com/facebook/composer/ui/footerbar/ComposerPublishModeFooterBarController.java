package com.facebook.composer.ui.footerbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.NavigationLogger;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass19;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsCustomPublishModeSupported;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: fb_mobile_login_method_start */
public class ComposerPublishModeFooterBarController<DataProvider extends ProvidesIsCustomPublishModeSupported> extends ComposerFooterBarControllerBase {
    private static final ImmutableList<ComposerEvent> f7072b = ImmutableList.of(ComposerEvent.ON_FIRST_DRAW, ComposerEvent.ON_DATASET_CHANGE);
    private final OnClickListener f7073a = new C08951(this);
    private final WeakReference<DataProvider> f7074c;
    private final LazyFooterView<View> f7075d;
    public final AnonymousClass19 f7076e;

    /* compiled from: fb_mobile_login_method_start */
    class C08951 implements OnClickListener {
        final /* synthetic */ ComposerPublishModeFooterBarController f7071a;

        C08951(ComposerPublishModeFooterBarController composerPublishModeFooterBarController) {
            this.f7071a = composerPublishModeFooterBarController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -156567745);
            AnonymousClass19 anonymousClass19 = this.f7071a.f7076e;
            ((NavigationLogger) anonymousClass19.f6047a.ap.get()).a("tap_composer_footer_buttons");
            ComposerFragment.bV(anonymousClass19.f6047a);
            Logger.a(2, EntryType.UI_INPUT_END, 98121069, a);
        }
    }

    @Inject
    public ComposerPublishModeFooterBarController(@Assisted LazyFooterView<View> lazyFooterView, @Assisted DataProvider dataProvider, @Assisted Listener listener) {
        this.f7075d = lazyFooterView;
        this.f7074c = new WeakReference(dataProvider);
        this.f7076e = listener;
    }

    protected final ImmutableList<ComposerEvent> mo214a() {
        return f7072b;
    }

    public final void mo215b() {
        if (m8333c()) {
            View a = this.f7075d.m8352a();
            a.setVisibility(0);
            a.setOnClickListener(this.f7073a);
            return;
        }
        this.f7075d.m8353b();
    }

    @VisibleForTesting
    private boolean m8333c() {
        ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) this.f7074c.get();
        if (composerDataProviderImpl == null) {
            return false;
        }
        return composerDataProviderImpl.m7402C();
    }
}
