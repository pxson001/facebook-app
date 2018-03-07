package com.facebook.zero.common.intent;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.zero.intent.CampaignCTAExternalIntentWhitelistItem;
import com.facebook.zero.intent.FbAppExternalIntentWhitelistItem;
import com.facebook.zero.intent.FbLinkExternalIntentWhitelistItem;
import com.facebook.zero.intent.ForInternalIntentExternalIntentWhitelistItem;
import com.facebook.zero.intent.IOrgExternalIntentWhitelistItem;
import com.facebook.zero.intent.LauncherExternalIntentWhitelistItem;
import com.facebook.zero.intent.LocationSettingsExternalWhiteListItem;
import com.facebook.zero.intent.MessagingExternalIntentWhiteListItem;
import com.facebook.zero.intent.PhoneNumberExternalIntentWhitelistItem;
import com.facebook.zero.intent.SMSAppSelectionExternalIntentWhitelistItem;
import com.facebook.zero.service.FbZeroIndicatorManager;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: target_profile_pic_url */
public final class STATICDI_MULTIBIND_PROVIDER$ExternalIntentWhitelistItem implements MultiBindIndexedProvider<ExternalIntentWhitelistItem>, Provider<Set<ExternalIntentWhitelistItem>> {
    private final InjectorLike f6281a;

    public STATICDI_MULTIBIND_PROVIDER$ExternalIntentWhitelistItem(InjectorLike injectorLike) {
        this.f6281a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f6281a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 10;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new CampaignCTAExternalIntentWhitelistItem(FbZeroIndicatorManager.a(injector), IdBasedProvider.a(injector, 4034));
            case 1:
                return new FbAppExternalIntentWhitelistItem();
            case 2:
                return new FbLinkExternalIntentWhitelistItem(ProductMethodAutoProvider.b(injector));
            case 3:
                return new ForInternalIntentExternalIntentWhitelistItem((Context) injector.getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injector));
            case 4:
                return new IOrgExternalIntentWhitelistItem();
            case 5:
                return new LauncherExternalIntentWhitelistItem();
            case 6:
                return new LocationSettingsExternalWhiteListItem();
            case 7:
                return new MessagingExternalIntentWhiteListItem();
            case 8:
                return new PhoneNumberExternalIntentWhitelistItem();
            case 9:
                return new SMSAppSelectionExternalIntentWhitelistItem();
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
