package com.facebook.common.init;

import com.facebook.analytics.immediateactiveseconds.ImmediateActiveSecondReporter.ImmediateActiveSecondReporterBroadcastReceiverRegistration;
import com.facebook.analytics.timespent.TimeSpentEventReporter.TimeChangeReceiverRegistration;
import com.facebook.analytics.timespent.TimeSpentEventReporter.UserActivityReceiverRegistration;
import com.facebook.contacts.service.C0155x19975bfe;
import com.facebook.content.FacebookOnlyIntentActionFactory;
import com.facebook.device_id.UniqueDeviceIdBroadcastAppStateReceiverRegistration;
import com.facebook.dialtone.DialtoneController.LocalDialtoneControllerReceiverRegistration;
import com.facebook.dialtone.automode.DialtoneAutoModeController.LocalDialtoneAutoModeControllerReceiverRegistration;
import com.facebook.dialtone.services.DialtonePhotoCapReminder.LocalDialtonePhotoCapReminderReceiverRegistration;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.languages.switchercommonex.LocaleChangeBroadcastReceiverRegistration;
import com.facebook.messaging.clockskew.C0157x69b2e8f6;
import com.facebook.messaging.tincan.gatekeepers.TincanGatekeepers;
import com.facebook.messaging.tincan.messenger.C0158x36b99af8;
import com.facebook.messaging.tincan.messenger.IncomingMessageHandler.OnInitBroadcastReceiverRegistration;
import com.facebook.omnistore.module.OmnistoreComponentManager.OmnistoreComponentManagerBroadcastReceiverRegistration;
import com.facebook.orca.notify.SmsFallbackNumberNotificationHandler$ReceiverRegistration;
import com.facebook.oxygen.preloads.integration.dogfooding.DogfoodingBroadcastRegistration;
import com.facebook.places.checkin.protocol.PlacesBroadcastReceiverRegistrations$StreamPublishComplete;
import com.facebook.placetips.presence.PlaceTipsAppStateReceiver;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.zero.service.C0159xeeee0c1b;
import com.facebook.zero.service.C0160x6b4d5335;
import com.facebook.zero.service.C0161xe64c4ca1;
import com.facebook.zero.service.FbZeroIndicatorManager.CrossFbAppZeroIndicatorManagerReceiverRegistration;
import com.facebook.zero.service.FbZeroIndicatorManager.LocalZeroIndicatorManagerReceiverRegistration;
import com.facebook.zero.service.FbZeroTokenManager.CrossProcessZeroTokenManagerReceiverRegistration;
import com.facebook.zero.service.FbZeroTokenManager.LocalZeroTokenManagerReceiverRegistration;
import com.facebook.zero.service.ZeroInterstitialEligibilityManager.LocalZeroInterstitialEligibilityManagerReceiverRegistration;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class C0153x827e3911 implements MultiBindIndexedProvider<INeedInitForBroadcastReceiverRegistration>, Provider<Set<INeedInitForBroadcastReceiverRegistration>> {
    private final InjectorLike f2296a;

    public C0153x827e3911(InjectorLike injectorLike) {
        this.f2296a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f2296a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 25;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return ImmediateActiveSecondReporterBroadcastReceiverRegistration.m4481a(injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return TimeChangeReceiverRegistration.m4491a(injector);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return UserActivityReceiverRegistration.m4493a(injector);
            case 3:
                return new C0155x19975bfe(IdBasedSingletonScopeProvider.m1810b(injector, 5392), FacebookOnlyIntentActionFactory.m4495a((InjectorLike) injector));
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return UniqueDeviceIdBroadcastAppStateReceiverRegistration.m4498a(injector);
            case 5:
                return LocalDialtoneControllerReceiverRegistration.m4500a(injector);
            case 6:
                return LocalDialtoneAutoModeControllerReceiverRegistration.m4503a(injector);
            case 7:
                return LocalDialtonePhotoCapReminderReceiverRegistration.m4505a(injector);
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return new LocaleChangeBroadcastReceiverRegistration(IdBasedSingletonScopeProvider.m1810b(injector, 2461));
            case 9:
                return C0157x69b2e8f6.m4512a(injector);
            case 10:
                return new C0158x36b99af8(IdBasedLazy.m1808a(injector, 2733));
            case 11:
                return new OnInitBroadcastReceiverRegistration(IdBasedSingletonScopeProvider.m1810b(injector, 2736), TincanGatekeepers.m4518b(injector));
            case 12:
                return OmnistoreComponentManagerBroadcastReceiverRegistration.m4526x47a887d1(injector);
            case 13:
                return SmsFallbackNumberNotificationHandler$ReceiverRegistration.m4529a(injector);
            case 14:
                return DogfoodingBroadcastRegistration.m4531a(injector);
            case 15:
                return new PlacesBroadcastReceiverRegistrations$StreamPublishComplete(IdBasedSingletonScopeProvider.m1810b(injector, 9536));
            case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                return new PlaceTipsAppStateReceiver(IdBasedLazy.m1808a(injector, 3020), IdBasedSingletonScopeProvider.m1810b(injector, 3010));
            case 17:
                return CrossFbAppZeroIndicatorManagerReceiverRegistration.m4534a(injector);
            case 18:
                return LocalZeroIndicatorManagerReceiverRegistration.m4536a(injector);
            case 19:
                return CrossProcessZeroTokenManagerReceiverRegistration.m4538a(injector);
            case 20:
                return LocalZeroTokenManagerReceiverRegistration.m4540a(injector);
            case 21:
                return C0159xeeee0c1b.m4542a(injector);
            case 22:
                return C0160x6b4d5335.m4544a(injector);
            case 23:
                return LocalZeroInterstitialEligibilityManagerReceiverRegistration.m4546a(injector);
            case 24:
                return C0161xe64c4ca1.m4548a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
