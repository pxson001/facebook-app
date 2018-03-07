package com.facebook.composer.location.controller;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.composer.activity.ComposerMutatorImpl;
import com.facebook.composer.activity.TransactionImpl;
import com.facebook.composer.analytics.ComposerAnalyticsEventBuilder;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsImplicitLocationSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerMutator;
import com.facebook.ipc.composer.dataaccessor.ComposerTransaction;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerLocationInfo.Builder;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerLocationInfo.SetsLocationInfo;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.resources.ui.FbTextView;
import com.facebook.resources.utils.TextViewUtils;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.LazyView;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: front_photo_page_id */
public class ImplicitLocationPillController<DataProvider extends ProvidesIsImplicitLocationSupported & ProvidesSessionId & ProvidesConfiguration & ProvidesLocationInfo, Transaction extends ComposerTransaction & SetsLocationInfo<Transaction>> implements ComposerEventHandler {
    public static final ComposerEventOriginator f6696a = ComposerEventOriginator.a(ImplicitLocationPillController.class);
    public final WeakReference<DataProvider> f6697b;
    private final LazyView<FbTextView> f6698c;
    public final WeakReference<ComposerMutator<Transaction>> f6699d;
    private final GlyphColorizer f6700e;
    private final Resources f6701f;
    public final QeAccessor f6702g;
    public final ComposerAnalyticsLogger f6703h;
    private final OnClickListener f6704i = new C08491(this);

    /* compiled from: front_photo_page_id */
    class C08491 implements OnClickListener {
        final /* synthetic */ ImplicitLocationPillController f6694a;

        C08491(ImplicitLocationPillController implicitLocationPillController) {
            this.f6694a = implicitLocationPillController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 570922884);
            if (this.f6694a.f6702g.a(ExperimentsForFeedUtilComposerAbtestModule.h, false)) {
                Builder a2 = ComposerLocationInfo.a(((ProvidesLocationInfo) ((ProvidesIsImplicitLocationSupported) Preconditions.checkNotNull(this.f6694a.f6697b.get()))).g());
                a2.f = null;
                a2 = a2;
                a2.e = true;
                ((TransactionImpl) ((ComposerMutatorImpl) Preconditions.checkNotNull(this.f6694a.f6699d.get())).m7626a(ImplicitLocationPillController.f6696a).m7685a(a2.b())).m7689a();
                ComposerAnalyticsLogger composerAnalyticsLogger = this.f6694a.f6703h;
                composerAnalyticsLogger.a.a(new ComposerAnalyticsEventBuilder("composer_implicit_location_removed").h(((ProvidesSessionId) ((ProvidesIsImplicitLocationSupported) Preconditions.checkNotNull(this.f6694a.f6697b.get()))).ab()).a);
            } else {
                ImplicitLocationPillController.m8115b(this.f6694a);
            }
            LogUtils.a(-445874098, a);
        }
    }

    /* compiled from: front_photo_page_id */
    /* synthetic */ class C08502 {
        static final /* synthetic */ int[] f6695a = new int[ComposerEvent.values().length];

        static {
            try {
                f6695a[ComposerEvent.ON_FIRST_DRAW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6695a[ComposerEvent.ON_DATASET_CHANGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    @Inject
    public ImplicitLocationPillController(QeAccessor qeAccessor, ComposerAnalyticsLogger composerAnalyticsLogger, GlyphColorizer glyphColorizer, Resources resources, @Assisted LazyView<FbTextView> lazyView, @Assisted DataProvider dataProvider, @Assisted ComposerMutator<Transaction> composerMutator) {
        this.f6698c = (LazyView) Preconditions.checkNotNull(lazyView);
        this.f6697b = new WeakReference(Preconditions.checkNotNull(dataProvider));
        this.f6699d = new WeakReference(Preconditions.checkNotNull(composerMutator));
        this.f6702g = qeAccessor;
        this.f6703h = composerAnalyticsLogger;
        this.f6700e = glyphColorizer;
        this.f6701f = resources;
        m8116c();
    }

    public static void m8115b(ImplicitLocationPillController implicitLocationPillController) {
        boolean z;
        ProvidesIsImplicitLocationSupported providesIsImplicitLocationSupported = (ProvidesIsImplicitLocationSupported) Preconditions.checkNotNull(implicitLocationPillController.f6697b.get());
        ComposerLocationInfo g = ((ProvidesLocationInfo) providesIsImplicitLocationSupported).g();
        Builder a = ComposerLocationInfo.a(g);
        if (g.l()) {
            z = false;
        } else {
            z = true;
        }
        a.j = z;
        ((TransactionImpl) ((ComposerMutatorImpl) Preconditions.checkNotNull(implicitLocationPillController.f6699d.get())).m7626a(f6696a).m7685a(a.b())).m7689a();
        ComposerAnalyticsLogger composerAnalyticsLogger = implicitLocationPillController.f6703h;
        String ab = ((ProvidesSessionId) providesIsImplicitLocationSupported).ab();
        boolean l = ((ProvidesLocationInfo) providesIsImplicitLocationSupported).g().l();
        ComposerAnalyticsEventBuilder h = new ComposerAnalyticsEventBuilder("composer_implicit_location_toggled").h(ab);
        h.a.a("implicit_location_disabled", l);
        composerAnalyticsLogger.a.a(h.a);
    }

    public final void m8117a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        switch (C08502.f6695a[composerEvent.ordinal()]) {
            case 1:
            case 2:
                m8116c();
                return;
            default:
                return;
        }
    }

    private void m8116c() {
        ProvidesIsImplicitLocationSupported providesIsImplicitLocationSupported = (ProvidesIsImplicitLocationSupported) Preconditions.checkNotNull(this.f6697b.get());
        if (((ProvidesLocationInfo) providesIsImplicitLocationSupported).g().l()) {
            ((FbTextView) this.f6698c.a()).setOnClickListener(this.f6704i);
            ((FbTextView) this.f6698c.a()).setVisibility(0);
            ((FbTextView) this.f6698c.a()).setText(this.f6702g.a(ExperimentsForFeedUtilComposerAbtestModule.g, 2131234784, this.f6701f));
        } else if (!providesIsImplicitLocationSupported.G() || ((ProvidesLocationInfo) providesIsImplicitLocationSupported).g().f() == null || ((ProvidesLocationInfo) providesIsImplicitLocationSupported).g().f().label == null) {
            this.f6698c.c();
        } else {
            Drawable drawable;
            String[] split = ((ProvidesLocationInfo) providesIsImplicitLocationSupported).g().f().label.split(",");
            ((FbTextView) this.f6698c.a()).setVisibility(0);
            ((FbTextView) this.f6698c.a()).setText(split[0]);
            Drawable a = this.f6700e.a(this.f6701f.getDrawable(2130838233), -7235677);
            if (((ProvidesConfiguration) providesIsImplicitLocationSupported).o().isEdit()) {
                ((FbTextView) this.f6698c.a()).setEnabled(false);
                drawable = null;
            } else {
                ((FbTextView) this.f6698c.a()).setOnClickListener(this.f6704i);
                drawable = this.f6700e.a(this.f6701f.getDrawable(2130838225), -7235677);
                ((FbTextView) this.f6698c.a()).setEnabled(true);
            }
            TextViewUtils.a((TextView) this.f6698c.a(), a, null, drawable, null);
        }
    }
}
