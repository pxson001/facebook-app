package com.facebook.richdocument.view.transition.motion;

import android.content.Context;
import android.provider.Settings.System;
import android.view.OrientationEventListener;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.richdocument.view.RichDocumentUIConfig;
import com.facebook.richdocument.view.transition.motion.OrientationChangeEventListener.DeviceOrientation;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;

/* compiled from: orderby */
public class RichDocumentOrientationSensor extends OrientationEventListener implements InjectableComponentWithContext {
    @Inject
    public MonotonicClock f7018a;
    private final Context f7019b;
    public final List<OrientationChangeEventListener> f7020c;
    public DeviceOrientation f7021d = DeviceOrientation.PORTRAIT;
    private DeviceOrientation f7022e;
    private long f7023f;

    public static void m7341a(Object obj, Context context) {
        ((RichDocumentOrientationSensor) obj).f7018a = (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(FbInjector.get(context));
    }

    public RichDocumentOrientationSensor(Context context) {
        super(context);
        this.f7019b = context;
        Class cls = RichDocumentOrientationSensor.class;
        m7341a(this, getContext());
        this.f7020c = new CopyOnWriteArrayList();
    }

    public void onOrientationChanged(int i) {
        if (i != -1) {
            int i2 = 0;
            if (System.getInt(getContext().getContentResolver(), "accelerometer_rotation", 0) != 0) {
                i2 = 1;
            }
            if (i2 != 0) {
                DeviceOrientation deviceOrientation;
                i2 = RichDocumentUIConfig.f6569v;
                switch (this.f7021d) {
                    case PORTRAIT:
                        if (i >= 90 - i2 && i < i2 + 270) {
                            if (i >= 90 - i2 && i < 180) {
                                deviceOrientation = DeviceOrientation.LANDSCAPE_RIGHT;
                                break;
                            } else {
                                deviceOrientation = DeviceOrientation.LANDSCAPE_LEFT;
                                break;
                            }
                        }
                        deviceOrientation = DeviceOrientation.PORTRAIT;
                        break;
                        break;
                    case LANDSCAPE_RIGHT:
                        if (i < i2 || i >= 225) {
                            if (i >= i2 && i < i2 + 270) {
                                deviceOrientation = DeviceOrientation.LANDSCAPE_LEFT;
                                break;
                            } else {
                                deviceOrientation = DeviceOrientation.PORTRAIT;
                                break;
                            }
                        }
                        deviceOrientation = DeviceOrientation.LANDSCAPE_RIGHT;
                        break;
                        break;
                    case LANDSCAPE_LEFT:
                        if (i >= 360 - i2 || i < 135) {
                            if (i >= 90 - i2 && i < 360 - i2) {
                                deviceOrientation = DeviceOrientation.LANDSCAPE_RIGHT;
                                break;
                            } else {
                                deviceOrientation = DeviceOrientation.PORTRAIT;
                                break;
                            }
                        }
                        deviceOrientation = DeviceOrientation.LANDSCAPE_LEFT;
                        break;
                        break;
                    default:
                        deviceOrientation = null;
                        break;
                }
                DeviceOrientation deviceOrientation2 = deviceOrientation;
                if (this.f7022e != deviceOrientation2) {
                    this.f7022e = deviceOrientation2;
                    this.f7023f = this.f7018a.now();
                }
                if (this.f7022e != null && this.f7022e != this.f7021d && this.f7018a.now() - this.f7023f >= ((long) RichDocumentUIConfig.f6570w)) {
                    for (OrientationChangeEventListener a : this.f7020c) {
                        a.mo469a(deviceOrientation2);
                    }
                    this.f7021d = deviceOrientation2;
                }
            }
        }
    }

    public final synchronized void m7343a(OrientationChangeEventListener orientationChangeEventListener) {
        if (canDetectOrientation() && !this.f7020c.contains(orientationChangeEventListener)) {
            this.f7020c.add(orientationChangeEventListener);
            enable();
        }
    }

    public final synchronized void m7344b(OrientationChangeEventListener orientationChangeEventListener) {
        this.f7020c.remove(orientationChangeEventListener);
        if (this.f7020c.isEmpty()) {
            disable();
        }
    }

    public final synchronized void m7342a() {
        this.f7020c.clear();
        disable();
    }

    public Context getContext() {
        return this.f7019b;
    }
}
