package com.google.android.gms.cast.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.cast.ApplicationMetadata;

public interface zzj extends IInterface {

    public abstract class zza extends Binder implements zzj {
        public zza() {
            attachInterface(this, "com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            DeviceStatus deviceStatus = null;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo649a(parcel.readInt());
                    return true;
                case 2:
                    ApplicationMetadata applicationMetadata;
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (parcel.readInt() != 0) {
                        applicationMetadata = (ApplicationMetadata) ApplicationMetadata.CREATOR.createFromParcel(parcel);
                    }
                    mo652a(applicationMetadata, parcel.readString(), parcel.readString(), parcel.readInt() != 0);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo657b(parcel.readInt());
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    parcel.readString();
                    parcel.readDouble();
                    parcel.readInt();
                    mo658c();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo655a(parcel.readString(), parcel.readString());
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo656a(parcel.readString(), parcel.createByteArray());
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo660d(parcel.readInt());
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo659c(parcel.readInt());
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo661e(parcel.readInt());
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    parcel.readString();
                    mo651a(parcel.readLong(), parcel.readInt());
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    parcel.readString();
                    mo650a(parcel.readLong());
                    return true;
                case 12:
                    ApplicationStatus applicationStatus;
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (parcel.readInt() != 0) {
                        applicationStatus = (ApplicationStatus) ApplicationStatus.CREATOR.createFromParcel(parcel);
                    }
                    mo653a(applicationStatus);
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (parcel.readInt() != 0) {
                        deviceStatus = (DeviceStatus) DeviceStatus.CREATOR.createFromParcel(parcel);
                    }
                    mo654a(deviceStatus);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo649a(int i);

    void mo650a(long j);

    void mo651a(long j, int i);

    void mo652a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z);

    void mo653a(ApplicationStatus applicationStatus);

    void mo654a(DeviceStatus deviceStatus);

    void mo655a(String str, String str2);

    void mo656a(String str, byte[] bArr);

    void mo657b(int i);

    void mo658c();

    void mo659c(int i);

    void mo660d(int i);

    void mo661e(int i);
}
