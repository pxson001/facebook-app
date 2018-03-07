package com.facebook.analytics;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

/* compiled from: tip_id */
public class IAnalyticsService$Stub$Proxy implements IAnalyticsService {
    private IBinder f1864a;

    public IAnalyticsService$Stub$Proxy(IBinder iBinder) {
        this.f1864a = iBinder;
    }

    public IBinder asBinder() {
        return this.f1864a;
    }

    public final void m2549a(List<HoneyAnalyticsEvent> list) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.facebook.analytics.IAnalyticsService");
            obtain.writeTypedList(list);
            this.f1864a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
