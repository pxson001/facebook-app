package com.facebook.composer.ui.footerbar;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.NavigationLogger;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass13;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsAttachToAlbumSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTargetAlbum;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: feedUnitId */
public class ComposerAlbumFooterBarController<DataProvider extends ProvidesIsAttachToAlbumSupported & ProvidesTargetAlbum> extends ComposerFooterBarControllerBase {
    private static final ImmutableList<ComposerEvent> f7008a = ImmutableList.of(ComposerEvent.ON_FIRST_DRAW, ComposerEvent.ON_DATASET_CHANGE);
    public final WeakReference<DataProvider> f7009b;
    private final LazyFooterView<GlyphButton> f7010c;
    public final AnonymousClass13 f7011d;
    private final Resources f7012e;
    private final OnClickListener f7013f = new C08791(this);

    /* compiled from: feedUnitId */
    class C08791 implements OnClickListener {
        final /* synthetic */ ComposerAlbumFooterBarController f7007a;

        C08791(ComposerAlbumFooterBarController composerAlbumFooterBarController) {
            this.f7007a = composerAlbumFooterBarController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1244281835);
            AnonymousClass13 anonymousClass13 = this.f7007a.f7011d;
            ((NavigationLogger) anonymousClass13.f6041a.ap.get()).a("tap_composer_footer_buttons");
            ComposerFragment.bK(anonymousClass13.f6041a);
            Logger.a(2, EntryType.UI_INPUT_END, -1611593827, a);
        }
    }

    @Inject
    public ComposerAlbumFooterBarController(@Assisted LazyFooterView<GlyphButton> lazyFooterView, @Assisted DataProvider dataProvider, @Assisted Listener listener, Resources resources) {
        this.f7012e = resources;
        this.f7009b = new WeakReference(dataProvider);
        this.f7011d = listener;
        this.f7010c = lazyFooterView;
    }

    protected final ImmutableList<ComposerEvent> mo214a() {
        return f7008a;
    }

    public final void mo215b() {
        ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) this.f7009b.get();
        if (composerDataProviderImpl != null) {
            Object obj;
            ComposerDataProviderImpl composerDataProviderImpl2 = (ComposerDataProviderImpl) this.f7009b.get();
            if (composerDataProviderImpl2 == null || !composerDataProviderImpl2.m7447y()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                ((GlyphButton) this.f7010c.m8352a()).setContentDescription(this.f7012e.getString(2131234646));
                if (((ProvidesTargetAlbum) composerDataProviderImpl).ad() != null) {
                    ((GlyphButton) this.f7010c.m8352a()).setGlyphColor(this.f7012e.getColor(2131362954));
                } else {
                    ((GlyphButton) this.f7010c.m8352a()).setGlyphColor(this.f7012e.getColorStateList(2131364092));
                }
                ((GlyphButton) this.f7010c.m8352a()).setVisibility(0);
                ((GlyphButton) this.f7010c.m8352a()).setOnClickListener(this.f7013f);
                return;
            }
            this.f7010c.m8353b();
        }
    }
}
