package com.facebook.auth.component;

import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.dialtone.DialtoneFetchQuotaMethod;
import com.facebook.dialtone.DialtoneLoginComponent;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.photoreminders.omnistore.PhotoRemindersOmnistoreSubscriptionInitializer;
import com.facebook.privacy.audience.AudienceEducatorManager;
import com.facebook.privacy.audience.AudienceInfoLoginComponent;
import com.facebook.privacy.protocol.FetchAudienceInfoForLoginMethod;
import com.facebook.privacy.service.ComposerPrivacyOptionsFetchComponent;
import com.facebook.zero.ZeroLoginComponent;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$LoginComponent implements MultiBindIndexedProvider<LoginComponent>, Provider<Set<LoginComponent>> {
    private final InjectorLike f1327a;

    private STATICDI_MULTIBIND_PROVIDER$LoginComponent(InjectorLike injectorLike) {
        this.f1327a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1327a.getScopeAwareInjector(), this);
    }

    public static Set<LoginComponent> m1561a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$LoginComponent(injectorLike));
    }

    public final int size() {
        return 5;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new DialtoneLoginComponent(new DialtoneFetchQuotaMethod(GraphQLProtocolHelper.a(injector)), (DialtoneController) DialtoneControllerImpl.a(injector));
            case 1:
                return PhotoRemindersOmnistoreSubscriptionInitializer.m8845b(injector);
            case 2:
                return new AudienceInfoLoginComponent(new FetchAudienceInfoForLoginMethod(GraphQLProtocolHelper.a(injector)), AudienceEducatorManager.m2134a((InjectorLike) injector));
            case 3:
                return ComposerPrivacyOptionsFetchComponent.m2175b(injector);
            case 4:
                return ZeroLoginComponent.m2187b(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
