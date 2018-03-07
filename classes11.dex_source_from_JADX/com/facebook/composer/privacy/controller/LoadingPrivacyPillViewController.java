package com.facebook.composer.privacy.controller;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.inject.Assisted;
import com.facebook.resources.ui.FbTextView;
import com.facebook.resources.utils.TextViewUtils;
import com.facebook.widget.LazyView;
import com.facebook.widget.LazyView.OnInflateRunner;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: flex_settings_screen_optin */
public class LoadingPrivacyPillViewController<DataProvider extends ProvidesPrivacyData> implements ComposerEventHandler {
    private final LazyView<FbTextView> f6866a;
    private final WeakReference<DataProvider> f6867b;
    public final Resources f6868c;

    /* compiled from: flex_settings_screen_optin */
    class C08641 implements OnInflateRunner<FbTextView> {
        final /* synthetic */ LoadingPrivacyPillViewController f6864a;

        C08641(LoadingPrivacyPillViewController loadingPrivacyPillViewController) {
            this.f6864a = loadingPrivacyPillViewController;
        }

        public final void m8207a(View view) {
            FbTextView fbTextView = (FbTextView) view;
            TextViewUtils.a(fbTextView, this.f6864a.f6868c.getDrawable(2130842741), null, null, null);
            fbTextView.setText(this.f6864a.f6868c.getString(2131234609));
        }
    }

    /* compiled from: flex_settings_screen_optin */
    /* synthetic */ class C08652 {
        static final /* synthetic */ int[] f6865a = new int[ComposerEvent.values().length];

        static {
            try {
                f6865a[ComposerEvent.ON_FIRST_DRAW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6865a[ComposerEvent.ON_DATASET_CHANGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6865a[ComposerEvent.ON_STATUS_TEXT_CHANGED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6865a[ComposerEvent.ON_PRIVACY_FETCHED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6865a[ComposerEvent.ON_PRIVACY_CHANGE_FROM_INLINE_PRIVACY_SURVEY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    @Inject
    public LoadingPrivacyPillViewController(Resources resources, @Assisted DataProvider dataProvider, @Assisted ViewStub viewStub) {
        this.f6868c = resources;
        this.f6867b = new WeakReference(dataProvider);
        this.f6866a = new LazyView(viewStub, new C08641(this));
        m8208a();
    }

    public final void m8209a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        switch (C08652.f6865a[composerEvent.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                m8208a();
                return;
            default:
                return;
        }
    }

    private void m8208a() {
        if (((ProvidesPrivacyData) Preconditions.checkNotNull(this.f6867b.get())).ag().d) {
            ((FbTextView) this.f6866a.a()).setVisibility(0);
        } else {
            this.f6866a.c();
        }
    }
}
