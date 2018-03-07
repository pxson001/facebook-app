package com.facebook.composer.privacy.controller;

import android.content.res.Resources;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.privacy.common.ComposerFixedPrivacyData;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.composer.ui.statusview.FixedPrivacyPillView;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsAlbumPillSupported;
import com.facebook.privacy.ui.PrivacyIcons;
import com.facebook.privacy.ui.PrivacyIcons.Size;
import com.facebook.resources.utils.TextViewUtils;
import com.facebook.widget.LazyView;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: focusTextInput */
public class FixedPrivacyPillViewController<DataProvider extends ProvidesIsAlbumPillSupported & ProvidesPrivacyData> implements ComposerEventHandler {
    private GlyphColorizer f6858a;
    private final Resources f6859b;
    private final LazyView<FixedPrivacyPillView> f6860c;
    private final WeakReference<DataProvider> f6861d;
    private final Lazy<FbErrorReporter> f6862e;
    private final PrivacyIcons f6863f;

    /* compiled from: focusTextInput */
    /* synthetic */ class C08631 {
        static final /* synthetic */ int[] f6857a = new int[ComposerEvent.values().length];

        static {
            try {
                f6857a[ComposerEvent.ON_FIRST_DRAW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6857a[ComposerEvent.ON_DATASET_CHANGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6857a[ComposerEvent.ON_STATUS_TEXT_CHANGED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6857a[ComposerEvent.ON_PRIVACY_FETCHED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6857a[ComposerEvent.ON_PRIVACY_CHANGE_FROM_INLINE_PRIVACY_SURVEY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    @Inject
    public FixedPrivacyPillViewController(GlyphColorizer glyphColorizer, Resources resources, Lazy<FbErrorReporter> lazy, @Assisted DataProvider dataProvider, @Assisted LazyView<FixedPrivacyPillView> lazyView, PrivacyIcons privacyIcons) {
        this.f6858a = glyphColorizer;
        this.f6859b = resources;
        this.f6862e = lazy;
        this.f6861d = new WeakReference(dataProvider);
        this.f6860c = lazyView;
        this.f6863f = privacyIcons;
        m8204a();
    }

    public final void m8205a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        switch (C08631.f6857a[composerEvent.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                m8204a();
                return;
            default:
                return;
        }
    }

    private void m8204a() {
        ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6861d.get());
        if (((ProvidesPrivacyData) composerDataProviderImpl).ag().d) {
            this.f6860c.c();
        } else if (((ProvidesPrivacyData) composerDataProviderImpl).ag().a == null) {
            this.f6860c.c();
        } else {
            ComposerFixedPrivacyData composerFixedPrivacyData = ((ProvidesPrivacyData) composerDataProviderImpl).ag().a;
            Preconditions.checkArgument(composerFixedPrivacyData.a != null);
            FixedPrivacyPillView fixedPrivacyPillView = (FixedPrivacyPillView) this.f6860c.a();
            fixedPrivacyPillView.setCompoundDrawablePadding(this.f6859b.getDimensionPixelSize(2131427789));
            fixedPrivacyPillView.setVisibility(0);
            int a = this.f6863f.a(composerFixedPrivacyData.a, Size.PILL);
            if (composerFixedPrivacyData.b == null) {
                ((AbstractFbErrorReporter) this.f6862e.get()).b(FixedPrivacyPillViewController.class.getSimpleName(), "ComposerFixedPrivacyData : Label is null");
            }
            if (a == 0) {
                ((AbstractFbErrorReporter) this.f6862e.get()).b(FixedPrivacyPillViewController.class.getSimpleName(), "ComposerFixedPrivacyData : Drawable Resource is 0");
            }
            if (Strings.isNullOrEmpty(composerFixedPrivacyData.c)) {
                ((AbstractFbErrorReporter) this.f6862e.get()).b(FixedPrivacyPillViewController.class.getSimpleName(), "ComposerFixedPrivacyData : ToolTipText is empty or null");
            }
            fixedPrivacyPillView.setText(composerFixedPrivacyData.b);
            TextViewUtils.a(fixedPrivacyPillView, this.f6858a.a(a, -7235677), null, null, null);
            fixedPrivacyPillView.f7211b = composerFixedPrivacyData.c;
        }
    }
}
