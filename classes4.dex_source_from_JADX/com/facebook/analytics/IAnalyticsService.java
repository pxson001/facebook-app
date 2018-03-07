package com.facebook.analytics;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* compiled from: thread_key_string */
public interface IAnalyticsService extends IInterface {

    /* compiled from: thread_key_string */
    public abstract class Stub extends Binder implements IAnalyticsService {
        public Stub() {
            attachInterface(this, "com.facebook.analytics.IAnalyticsService");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.facebook.analytics.IAnalyticsService");
                    mo85a(parcel.createTypedArrayList(HoneyAnalyticsEvent.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.facebook.analytics.IAnalyticsService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo85a(List<HoneyAnalyticsEvent> list);
}
