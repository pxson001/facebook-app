package com.facebook.composer.ui.footerbar;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass18;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.model.ComposerDateInfo.ProvidesDateInfo;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginIsDatePickerSupportedGetter;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: fb_web_login_e2e */
public class ComposerPickDateFooterBarController<DataProvider extends ProvidesDateInfo & ProvidesPluginIsDatePickerSupportedGetter> extends ComposerFooterBarControllerBase {
    private static final ImmutableList<ComposerEvent> f7065a = ImmutableList.of(ComposerEvent.ON_FIRST_DRAW, ComposerEvent.ON_DATASET_CHANGE);
    private final OnClickListener f7066b = new C08941(this);
    private final WeakReference<DataProvider> f7067c;
    private final LazyFooterView<GlyphWithTextView> f7068d;
    public final AnonymousClass18 f7069e;
    private final Resources f7070f;

    /* compiled from: fb_web_login_e2e */
    class C08941 implements OnClickListener {
        final /* synthetic */ ComposerPickDateFooterBarController f7064a;

        C08941(ComposerPickDateFooterBarController composerPickDateFooterBarController) {
            this.f7064a = composerPickDateFooterBarController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -962525634);
            this.f7064a.f7069e.m7453a();
            Logger.a(2, EntryType.UI_INPUT_END, 1890999719, a);
        }
    }

    @Inject
    public ComposerPickDateFooterBarController(@Assisted DataProvider dataProvider, @Assisted LazyFooterView<GlyphWithTextView> lazyFooterView, @Assisted Listener listener, Resources resources) {
        this.f7067c = new WeakReference(dataProvider);
        this.f7068d = lazyFooterView;
        this.f7069e = listener;
        this.f7070f = resources;
    }

    protected final ImmutableList<ComposerEvent> mo214a() {
        return f7065a;
    }

    public final void mo215b() {
        ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) this.f7067c.get();
        if (composerDataProviderImpl == null || ((ProvidesPluginIsDatePickerSupportedGetter) composerDataProviderImpl).ar() == null || !((ProvidesPluginIsDatePickerSupportedGetter) composerDataProviderImpl).ar().a()) {
            this.f7068d.m8353b();
            return;
        }
        boolean z = composerDataProviderImpl.m7428d().a() != null;
        ((GlyphWithTextView) this.f7068d.m8352a()).setActive(z);
        ((GlyphWithTextView) this.f7068d.m8352a()).setPadding(z ? 0 : this.f7070f.getDimensionPixelSize(2131429627), 0, 0, 0);
        ((GlyphWithTextView) this.f7068d.m8352a()).setVisibility(0);
        ((GlyphWithTextView) this.f7068d.m8352a()).setOnClickListener(this.f7066b);
    }
}
