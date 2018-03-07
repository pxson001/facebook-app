package com.facebook.placetips.pulsarcore.service;

import com.facebook.inject.InjectorLike;
import com.facebook.placetips.bootstrap.PlaceTipsLocalLogger;
import com.facebook.placetips.bootstrap.PulsarScanTrigger;
import com.facebook.placetips.logging.PlaceTipsLocalLoggerImpl;
import com.facebook.placetips.pulsarcore.PulsarScanTriggerImpl;
import javax.inject.Inject;

/* compiled from: TITLE_SIZE */
public class BluetoothDiscoveryInterruptHandler {
    public final PlaceTipsLocalLogger f10783a;
    public final PulsarManifestComponentManager f10784b;
    public final PulsarScanTrigger f10785c;

    public static BluetoothDiscoveryInterruptHandler m11282b(InjectorLike injectorLike) {
        return new BluetoothDiscoveryInterruptHandler((PlaceTipsLocalLogger) PlaceTipsLocalLoggerImpl.a(injectorLike), PulsarManifestComponentManager.b(injectorLike), (PulsarScanTrigger) PulsarScanTriggerImpl.b(injectorLike));
    }

    @Inject
    public BluetoothDiscoveryInterruptHandler(PlaceTipsLocalLogger placeTipsLocalLogger, PulsarManifestComponentManager pulsarManifestComponentManager, PulsarScanTrigger pulsarScanTrigger) {
        this.f10783a = placeTipsLocalLogger;
        this.f10784b = pulsarManifestComponentManager;
        this.f10785c = pulsarScanTrigger;
    }
}
