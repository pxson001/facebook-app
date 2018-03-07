package com.facebook.qe.api.factory;

import com.facebook.common.preconditions.Preconditions;
import com.facebook.qe.api.ExposureLoggerFilter;
import com.facebook.qe.api.UniqueDeviceIdentityProvider;
import com.facebook.qe.api.impl.QeInternalImpl;
import com.facebook.qe.module.QeExposureLogger;
import com.facebook.qe.module.QeLoggedInUserIdentityProvider;
import com.facebook.qe.module.QeMigratedExperimentProvider;
import com.facebook.qe.module.QeRecentUserIdentitiesProvider;
import com.facebook.qe.observer.QeAccessorObserver;
import com.facebook.qe.schema.Schema;
import com.facebook.qe.store.StoreFs;

/* compiled from: unknown_reason */
public class QeImplFactory {
    public StoreFs f1930a;
    public StoreFs f1931b;
    public Schema f1932c;
    public Schema f1933d;
    public QeExposureLogger f1934e;
    public QeLoggedInUserIdentityProvider f1935f;
    public UniqueDeviceIdentityProvider f1936g;
    public QeRecentUserIdentitiesProvider f1937h;
    public QeMigratedExperimentProvider f1938i;
    public Boolean f1939j;
    public Boolean f1940k;
    public QeAccessorObserver f1941l;

    public final QeInternalImpl m3855a() {
        boolean z;
        if (this.f1939j == null || this.f1940k == null || this.f1930a == null || this.f1931b == null || this.f1932c == null || this.f1933d == null || this.f1934e == null || this.f1935f == null || this.f1936g == null || this.f1937h == null) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.m2016a(z);
        return new QeInternalImpl(this.f1932c, this.f1933d, this.f1930a, this.f1931b, new ExposureLoggerFilter(this.f1932c.mo568b()), new ExposureLoggerFilter(this.f1933d.mo568b()), this.f1934e, this.f1935f, this.f1936g, this.f1937h, this.f1938i, this.f1939j.booleanValue(), this.f1940k.booleanValue(), this.f1941l);
    }
}
