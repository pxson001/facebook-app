package com.facebook.composer.album;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.C07562;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsAttachToAlbumSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTargetAlbum;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.resources.utils.TextViewUtils;
import com.facebook.widget.LazyView;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: inline_privacy_survey_post_survey_actions */
public class AlbumPillController<DataProvider extends ProvidesIsAttachToAlbumSupported & ProvidesTargetAlbum> implements ComposerEventHandler {
    private final Resources f6230a;
    private final GlyphColorizer f6231b;
    private final WeakReference<DataProvider> f6232c;
    private final LazyView<FbTextView> f6233d;
    public final C07562 f6234e;
    private final OnClickListener f6235f = new C07751(this);

    /* compiled from: inline_privacy_survey_post_survey_actions */
    class C07751 implements OnClickListener {
        final /* synthetic */ AlbumPillController f6229a;

        C07751(AlbumPillController albumPillController) {
            this.f6229a = albumPillController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1942009146);
            ComposerFragment.bK(this.f6229a.f6234e.f6060a);
            Logger.a(2, EntryType.UI_INPUT_END, -1683457718, a);
        }
    }

    @Inject
    public AlbumPillController(Resources resources, GlyphColorizer glyphColorizer, @Assisted DataProvider dataProvider, @Assisted PillClickedListener pillClickedListener, @Assisted ViewStub viewStub) {
        this.f6230a = resources;
        this.f6231b = glyphColorizer;
        this.f6232c = new WeakReference(Preconditions.checkNotNull(dataProvider));
        this.f6234e = pillClickedListener;
        this.f6233d = new LazyView(viewStub);
        m7706a();
    }

    public final void m7707a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        if (composerEvent == ComposerEvent.ON_DATASET_CHANGE) {
            m7706a();
        }
    }

    private void m7706a() {
        ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6232c.get());
        if (composerDataProviderImpl.m7447y()) {
            FbTextView fbTextView = (FbTextView) this.f6233d.a();
            fbTextView.setVisibility(0);
            fbTextView.setOnClickListener(this.f6235f);
            Drawable a = this.f6231b.a(this.f6230a.getDrawable(2130838259), -7235677);
            CharSequence a2 = ((ProvidesTargetAlbum) composerDataProviderImpl).ad() != null ? ((ProvidesTargetAlbum) composerDataProviderImpl).ad().E().a() : this.f6230a.getString(2131234792);
            TextViewUtils.a(fbTextView, ((ProvidesTargetAlbum) composerDataProviderImpl).ad() != null ? this.f6231b.a(this.f6230a.getDrawable(2130838214), -7235677) : this.f6231b.a(this.f6230a.getDrawable(2130838250), -7235677), null, a, null);
            fbTextView.setText(a2);
            return;
        }
        this.f6233d.c();
    }
}
