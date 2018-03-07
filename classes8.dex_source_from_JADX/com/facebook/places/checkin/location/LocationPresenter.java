package com.facebook.places.checkin.location;

import android.location.Location;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationCache;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.location.ImmutableLocation;
import com.facebook.places.checkin.PlacePickerFragment;
import com.facebook.places.checkin.protocol.CheckinLocationCache;
import com.facebook.places.checkin.protocol.CheckinSearchResultsLoader;
import com.facebook.places.checkin.protocol.CheckinSearchResultsLoader.Task;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: city_id */
public class LocationPresenter {
    private static final Class<?> f18053a = LocationPresenter.class;
    private final CheckinLocationCache f18054b;
    public final FbLocationStatusUtil f18055c;
    public final CheckinSearchResultsLoader f18056d;
    public PlacePickerFragment f18057e;
    public boolean f18058f;
    public boolean f18059g = false;
    public Location f18060h;
    public final LocationCacheReader f18061i;
    private final PerfTestConfig f18062j;
    public final FutureCallback<ImmutableLocation> f18063k = new C19491(this);

    /* compiled from: city_id */
    class C19491 implements FutureCallback<ImmutableLocation> {
        final /* synthetic */ LocationPresenter f18052a;

        C19491(LocationPresenter locationPresenter) {
            this.f18052a = locationPresenter;
        }

        public void onSuccess(@Nullable Object obj) {
            ImmutableLocation immutableLocation = (ImmutableLocation) obj;
            if (immutableLocation != null) {
                LocationPresenter.m22010c(this.f18052a, immutableLocation.l());
            }
        }

        public void onFailure(Throwable th) {
            LocationPresenter.m22012n(this.f18052a);
            PlacePickerFragment placePickerFragment = this.f18052a.f18057e;
            if (placePickerFragment.aJ.isEmpty()) {
                placePickerFragment.aS.m22055f();
                placePickerFragment.f17972c.m22015f();
            }
            placePickerFragment.f17978i.f();
            placePickerFragment.at.a();
        }
    }

    public static LocationPresenter m22009a(InjectorLike injectorLike) {
        return new LocationPresenter(CheckinLocationCache.a(injectorLike), FbLocationStatusUtil.a(injectorLike), new LocationCacheReader(CheckinLocationCache.a(injectorLike), FbLocationCache.b(injectorLike), PerfTestConfig.a(injectorLike)), PerfTestConfig.a(injectorLike), CheckinSearchResultsLoader.b(injectorLike));
    }

    @Inject
    public LocationPresenter(CheckinLocationCache checkinLocationCache, FbLocationStatusUtil fbLocationStatusUtil, LocationCacheReader locationCacheReader, PerfTestConfig perfTestConfig, CheckinSearchResultsLoader checkinSearchResultsLoader) {
        this.f18054b = checkinLocationCache;
        this.f18055c = fbLocationStatusUtil;
        this.f18061i = locationCacheReader;
        this.f18062j = perfTestConfig;
        this.f18056d = checkinSearchResultsLoader;
    }

    public final void m22013b() {
        Preconditions.checkNotNull(this.f18057e);
        if (this.f18060h == null) {
            Object obj;
            if (m22016h()) {
                Location location;
                LocationCacheReader locationCacheReader = this.f18061i;
                if (locationCacheReader.f18051g) {
                    location = null;
                } else {
                    if (locationCacheReader.f18050f == null) {
                        Location location2;
                        if (PerfTestConfigBase.i) {
                            Location location3 = new Location("fake");
                            location3.setLatitude(40.730769d);
                            location3.setLongitude(-73.991322d);
                            location3.setAccuracy(1000.0f);
                            location3.setTime(System.currentTimeMillis());
                            location2 = location3;
                        } else {
                            location2 = locationCacheReader.f18046b.a();
                            if (location2 == null) {
                                if (locationCacheReader.f18049e != null) {
                                    location2 = locationCacheReader.f18049e;
                                } else {
                                    ImmutableLocation a = locationCacheReader.f18047c.a(LocationCacheReader.f18045a);
                                    location2 = a != null ? a.l() : null;
                                }
                            }
                        }
                        locationCacheReader.f18050f = location2;
                    }
                    location = locationCacheReader.f18050f;
                }
                Location location4 = location;
                if (location4 != null) {
                    m22010c(this, location4);
                } else {
                    m22011d(null);
                }
            } else {
                this.f18060h = null;
                m22011d(null);
            }
            if (PerfTestConfigBase.j) {
                obj = null;
            } else {
                Object obj2 = (PerfTestConfigBase.i || !this.f18055c.b().c.contains("network")) ? null : 1;
                obj = obj2;
            }
            if (obj != null) {
                this.f18057e.kh_();
                return;
            }
            return;
        }
        m22011d(this.f18060h);
    }

    public static void m22012n(LocationPresenter locationPresenter) {
        if (locationPresenter.f18059g) {
            locationPresenter.f18056d.g.c(Task.NEARBY_LOCATION);
            locationPresenter.f18059g = false;
            locationPresenter.f18057e.m21922a();
        }
    }

    public final void m22014e() {
        if (this.f18058f) {
            m22011d(this.f18060h);
        } else if (m22016h()) {
            this.f18061i.f18051g = true;
            if (!this.f18059g) {
                this.f18056d.b(this.f18063k);
                this.f18059g = true;
            }
        }
    }

    public static void m22010c(LocationPresenter locationPresenter, Location location) {
        locationPresenter.f18054b.b = location;
        locationPresenter.f18060h = location;
        locationPresenter.m22011d(location);
        m22012n(locationPresenter);
    }

    public final void m22015f() {
        m22012n(this);
        if (this.f18060h == null) {
            m22011d(null);
        }
    }

    private void m22011d(Location location) {
        if (this.f18059g) {
            this.f18057e.m21925a(location);
            return;
        }
        this.f18057e.m21922a();
        this.f18057e.m21925a(location);
        this.f18057e.m21922a();
    }

    public final boolean m22016h() {
        if (PerfTestConfigBase.i || this.f18055c.a() == State.OKAY) {
            return true;
        }
        return false;
    }
}
