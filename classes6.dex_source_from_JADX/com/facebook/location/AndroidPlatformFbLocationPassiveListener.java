package com.facebook.location;

import android.location.LocationManager;
import com.facebook.inject.NeedsApplicationInjector;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: 蓙 */
public class AndroidPlatformFbLocationPassiveListener implements FbLocationPassiveListener {
    private final LocationManager f6a;

    @Inject
    public AndroidPlatformFbLocationPassiveListener(@NeedsApplicationInjector LocationManager locationManager) {
        this.f6a = locationManager;
    }
}
