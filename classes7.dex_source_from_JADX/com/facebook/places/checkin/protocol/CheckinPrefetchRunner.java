package com.facebook.places.checkin.protocol;

import android.location.Location;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.location.ImmutableLocation;
import com.facebook.places.checkin.models.SearchResults;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import java.util.List;
import javax.inject.Inject;

@UserScoped
/* compiled from: input_image_path_extra */
public class CheckinPrefetchRunner {
    public static final Class<?> f11047a = CheckinPrefetchRunner.class;
    private static final Object f11048e = new Object();
    public final CheckinSearchResultsLoader f11049b;
    public final CheckinLocationCache f11050c;
    public final List<PlacePickerFetchParams> f11051d = Lists.a();

    private static CheckinPrefetchRunner m13022b(InjectorLike injectorLike) {
        return new CheckinPrefetchRunner(CheckinLocationCache.m13018a(injectorLike), CheckinSearchResultsLoader.m13043b(injectorLike));
    }

    @Inject
    public CheckinPrefetchRunner(CheckinLocationCache checkinLocationCache, CheckinSearchResultsLoader checkinSearchResultsLoader) {
        this.f11050c = checkinLocationCache;
        this.f11049b = checkinSearchResultsLoader;
    }

    public final void m13025a(final PlacePickerFetchParams placePickerFetchParams) {
        Object obj;
        for (PlacePickerFetchParams placePickerFetchParams2 : this.f11051d) {
            if (placePickerFetchParams2.f11111d || placePickerFetchParams.f11111d) {
                if (placePickerFetchParams2.f11109b != null && placePickerFetchParams.f11109b != null && placePickerFetchParams2.f11109b.equals(placePickerFetchParams.f11109b)) {
                    obj = null;
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        obj = 1;
        if (obj != null) {
            this.f11051d.add(placePickerFetchParams);
            if (placePickerFetchParams.f11109b != null) {
                m13023d(this, placePickerFetchParams);
            } else if (this.f11050c.m13020a() != null) {
                placePickerFetchParams.f11109b = this.f11050c.m13020a();
                m13023d(this, placePickerFetchParams);
            } else {
                this.f11049b.m13045a(new FutureCallback<ImmutableLocation>(this) {
                    final /* synthetic */ CheckinPrefetchRunner f11044b;

                    public void onSuccess(Object obj) {
                        ImmutableLocation immutableLocation = (ImmutableLocation) obj;
                        if (immutableLocation != null) {
                            BLog.a(CheckinPrefetchRunner.f11047a, "Location retrieved");
                            Location l = immutableLocation.l();
                            this.f11044b.f11050c.f11041b = l;
                            CheckinPrefetchRunner checkinPrefetchRunner = this.f11044b;
                            PlacePickerFetchParams placePickerFetchParams = placePickerFetchParams;
                            placePickerFetchParams.f11109b = l;
                            CheckinPrefetchRunner.m13023d(checkinPrefetchRunner, placePickerFetchParams);
                            return;
                        }
                        CheckinPrefetchRunner.m13024e(this.f11044b, placePickerFetchParams);
                    }

                    public void onFailure(Throwable th) {
                        BLog.a(CheckinPrefetchRunner.f11047a, "Location not retrieved", th);
                        CheckinPrefetchRunner.m13024e(this.f11044b, placePickerFetchParams);
                    }
                });
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.places.checkin.protocol.CheckinPrefetchRunner m13021a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f11048e;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m13022b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f11048e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.places.checkin.protocol.CheckinPrefetchRunner) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.places.checkin.protocol.CheckinPrefetchRunner) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f11048e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.places.checkin.protocol.CheckinPrefetchRunner) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.checkin.protocol.CheckinPrefetchRunner.a(com.facebook.inject.InjectorLike):com.facebook.places.checkin.protocol.CheckinPrefetchRunner");
    }

    public static void m13023d(CheckinPrefetchRunner checkinPrefetchRunner, final PlacePickerFetchParams placePickerFetchParams) {
        checkinPrefetchRunner.f11049b.m13044a(placePickerFetchParams, new FutureCallback<SearchResults>(checkinPrefetchRunner) {
            final /* synthetic */ CheckinPrefetchRunner f11046b;

            public void onSuccess(Object obj) {
                this.f11046b.f11051d.remove(placePickerFetchParams);
            }

            public void onFailure(Throwable th) {
                BLog.a(CheckinPrefetchRunner.f11047a, "Place list not retreived", th);
                CheckinPrefetchRunner.m13024e(this.f11046b, placePickerFetchParams);
            }
        });
    }

    public static void m13024e(CheckinPrefetchRunner checkinPrefetchRunner, PlacePickerFetchParams placePickerFetchParams) {
        checkinPrefetchRunner.f11051d.remove(placePickerFetchParams);
    }
}
