package com.facebook.composer.ui.footerbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.ui.footerbar.ComposerCheckInFooterBarController.Listener;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsImplicitLocationSupported;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.katana.model.GeoRegion.ImplicitLocation;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: fbresources_corrupt_language_pack_download */
public class ComposerImplicitLocationFooterBarController<DataProvider extends ProvidesIsImplicitLocationSupported & ProvidesLocationInfo> extends ComposerFooterBarControllerBase {
    private static final ImmutableList<ComposerEvent> f7047a = ImmutableList.of(ComposerEvent.ON_FIRST_DRAW, ComposerEvent.ON_DATASET_CHANGE);
    private final WeakReference<DataProvider> f7048b;
    private final LazyFooterView<FbTextView> f7049c;
    private final OnClickListener f7050d;

    @Inject
    public ComposerImplicitLocationFooterBarController(@Assisted LazyFooterView<FbTextView> lazyFooterView, @Assisted DataProvider dataProvider, @Assisted final Listener listener) {
        this.f7049c = (LazyFooterView) Preconditions.checkNotNull(lazyFooterView);
        this.f7048b = (WeakReference) Preconditions.checkNotNull(new WeakReference(dataProvider));
        this.f7050d = new OnClickListener(this) {
            final /* synthetic */ ComposerImplicitLocationFooterBarController f7046b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -387700339);
                listener.m7452a();
                Logger.a(2, EntryType.UI_INPUT_END, -533605525, a);
            }
        };
    }

    protected final ImmutableList<ComposerEvent> mo214a() {
        return f7047a;
    }

    public final void mo215b() {
        ProvidesIsImplicitLocationSupported providesIsImplicitLocationSupported = (ProvidesIsImplicitLocationSupported) Preconditions.checkNotNull(this.f7048b.get(), "dataProvider was garbage collected");
        if (!providesIsImplicitLocationSupported.G() || ((ProvidesLocationInfo) providesIsImplicitLocationSupported).g().f() == null) {
            this.f7049c.m8353b();
            return;
        }
        ((FbTextView) this.f7049c.m8352a()).setVisibility(0);
        ((FbTextView) this.f7049c.m8352a()).setText(((ImplicitLocation) Preconditions.checkNotNull(((ProvidesLocationInfo) providesIsImplicitLocationSupported).g().f())).label);
        ((FbTextView) this.f7049c.m8352a()).setOnClickListener(this.f7050d);
    }
}
