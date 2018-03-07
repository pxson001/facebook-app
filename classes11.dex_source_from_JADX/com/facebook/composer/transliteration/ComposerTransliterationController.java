package com.facebook.composer.transliteration;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass42;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsTransliterationSupported;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.LazyView;
import com.facebook.widget.LazyView.OnInflateRunner;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: feedplugins.greetingcard.binder */
public class ComposerTransliterationController<DataProvider extends ProvidesIsTransliterationSupported> implements ComposerEventHandler {
    public final OnClickListener f6993a = new C08771(this);
    public final WeakReference<Listener> f6994b;
    public final WeakReference<DataProvider> f6995c;
    public final LazyView<GlyphButton> f6996d;

    /* compiled from: feedplugins.greetingcard.binder */
    class C08771 implements OnClickListener {
        final /* synthetic */ ComposerTransliterationController f6991a;

        C08771(ComposerTransliterationController composerTransliterationController) {
            this.f6991a = composerTransliterationController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1025827231);
            ComposerFragment.ck(((AnonymousClass42) Preconditions.checkNotNull(this.f6991a.f6994b.get())).f6074a);
            Logger.a(2, EntryType.UI_INPUT_END, -787489208, a);
        }
    }

    /* compiled from: feedplugins.greetingcard.binder */
    class C08782 implements OnInflateRunner<GlyphButton> {
        final /* synthetic */ ComposerTransliterationController f6992a;

        C08782(ComposerTransliterationController composerTransliterationController) {
            this.f6992a = composerTransliterationController;
        }

        public final void m8288a(View view) {
            ((GlyphButton) view).setOnClickListener(this.f6992a.f6993a);
        }
    }

    @Inject
    public ComposerTransliterationController(@Assisted Listener listener, @Assisted DataProvider dataProvider, @Assisted ViewStub viewStub) {
        this.f6994b = new WeakReference(listener);
        this.f6995c = new WeakReference(dataProvider);
        this.f6996d = new LazyView(viewStub, new C08782(this));
    }

    public final void m8289a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        if (composerEvent != ComposerEvent.ON_DATASET_CHANGE && composerEvent != ComposerEvent.ON_FIRST_DRAW) {
            return;
        }
        if (((ComposerDataProviderImpl) this.f6995c.get()).m7416S()) {
            ((GlyphButton) this.f6996d.a()).setVisibility(0);
        } else {
            this.f6996d.c();
        }
    }
}
