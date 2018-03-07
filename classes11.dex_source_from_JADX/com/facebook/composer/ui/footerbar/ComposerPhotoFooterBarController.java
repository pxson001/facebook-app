package com.facebook.composer.ui.footerbar;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.NavigationLogger;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass14;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.capability.ComposerPhotoCapability.ProvidesCapability;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: fbid_type */
public class ComposerPhotoFooterBarController<DataProvider extends ProvidesAttachments & ProvidesCapability> extends ComposerFooterBarControllerBase {
    private static final ImmutableList<ComposerEvent> f7058a = ImmutableList.of(ComposerEvent.ON_FIRST_DRAW, ComposerEvent.ON_DATASET_CHANGE);
    private final WeakReference<DataProvider> f7059b;
    private final LazyFooterView<GlyphButton> f7060c;
    private final Resources f7061d;
    public final AnonymousClass14 f7062e;
    private final OnClickListener f7063f = new C08931(this);

    /* compiled from: fbid_type */
    class C08931 implements OnClickListener {
        final /* synthetic */ ComposerPhotoFooterBarController f7057a;

        C08931(ComposerPhotoFooterBarController composerPhotoFooterBarController) {
            this.f7057a = composerPhotoFooterBarController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1086572210);
            AnonymousClass14 anonymousClass14 = this.f7057a.f7062e;
            ((NavigationLogger) anonymousClass14.f6042a.ap.get()).a("tap_composer_footer_buttons");
            ComposerFragment.bZ(anonymousClass14.f6042a);
            Logger.a(2, EntryType.UI_INPUT_END, 1786911549, a);
        }
    }

    @Inject
    public ComposerPhotoFooterBarController(@Assisted LazyFooterView<GlyphButton> lazyFooterView, @Assisted DataProvider dataProvider, @Assisted Listener listener, Resources resources) {
        this.f7060c = lazyFooterView;
        this.f7061d = resources;
        this.f7059b = new WeakReference(Preconditions.checkNotNull(dataProvider));
        this.f7062e = listener;
    }

    protected final ImmutableList<ComposerEvent> mo214a() {
        return f7058a;
    }

    public final void mo215b() {
        ProvidesAttachments providesAttachments = (ProvidesAttachments) this.f7059b.get();
        if (providesAttachments == null || !m8326c()) {
            this.f7060c.m8353b();
            return;
        }
        GlyphButton glyphButton = (GlyphButton) this.f7060c.m8352a();
        glyphButton.setContentDescription(this.f7061d.getString(2131234645));
        if (providesAttachments.m().isEmpty()) {
            glyphButton.setGlyphColor(this.f7061d.getColorStateList(2131364092));
        } else {
            glyphButton.setGlyphColor(this.f7061d.getColor(2131362954));
        }
        glyphButton.setVisibility(0);
        glyphButton.setOnClickListener(this.f7063f);
    }

    @VisibleForTesting
    private boolean m8326c() {
        ProvidesAttachments providesAttachments = (ProvidesAttachments) this.f7059b.get();
        return providesAttachments != null && ((ComposerDataProviderImpl) providesAttachments).ax().isSupported();
    }
}
