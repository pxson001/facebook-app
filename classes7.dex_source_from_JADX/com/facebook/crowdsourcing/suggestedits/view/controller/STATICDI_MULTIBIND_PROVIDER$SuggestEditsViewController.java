package com.facebook.crowdsourcing.suggestedits.view.controller;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.crowdsourcing.helper.HoursDataHelper;
import com.facebook.crowdsourcing.picker.SuggestEditsPickerLauncher;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsContextMenuManager;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.katana.app.module.LocaleMethodAutoProvider;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: ्औ */
public final class STATICDI_MULTIBIND_PROVIDER$SuggestEditsViewController implements MultiBindIndexedProvider<SuggestEditsViewController>, Provider<Set<SuggestEditsViewController>> {
    private final InjectorLike f17735a;

    public STATICDI_MULTIBIND_PROVIDER$SuggestEditsViewController(InjectorLike injectorLike) {
        this.f17735a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f17735a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 8;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new SuggestEditsEmptyHeaderViewController();
            case 1:
                return new SuggestEditsHoursViewController((AbstractFbErrorReporter) FbErrorReporterImpl.a(injector), HoursDataHelper.m21326b((InjectorLike) injector), LocaleMethodAutoProvider.b(injector), SuggestEditsPickerLauncher.m21358a(injector));
            case 2:
                return new SuggestEditsLocationViewController((AbstractFbErrorReporter) FbErrorReporterImpl.a(injector), SuggestEditsContextMenuManager.m21459b(injector), SuggestEditsPickerLauncher.m21358a(injector));
            case 3:
                return new SuggestEditsMultiTextFieldViewController((AbstractFbErrorReporter) FbErrorReporterImpl.a(injector), SuggestEditsContextMenuManager.m21459b(injector));
            case 4:
                return new SuggestEditsMultiValueViewController((AbstractFbErrorReporter) FbErrorReporterImpl.a(injector), SuggestEditsPickerLauncher.m21358a(injector));
            case 5:
                return SuggestEditsPageHeaderViewController.m21645b(injector);
            case 6:
                return new SuggestEditsSectionTitleViewController();
            case 7:
                return new SuggestEditsTextFieldViewController(SuggestEditsPickerLauncher.m21358a(injector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injector), SuggestEditsContextMenuManager.m21459b(injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
