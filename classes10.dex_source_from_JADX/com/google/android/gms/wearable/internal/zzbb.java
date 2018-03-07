package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.google.android.gms.wearable.PutDataRequest;

public interface zzbb extends IInterface {

    public abstract class zza extends Binder implements zzbb {

        class zza implements zzbb {
            private IBinder f13377a;

            zza(IBinder iBinder) {
                this.f13377a = iBinder;
            }

            public final void mo618a(zzaz com_google_android_gms_wearable_internal_zzaz) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.f13377a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo619a(zzaz com_google_android_gms_wearable_internal_zzaz, byte b) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeByte(b);
                    this.f13377a.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo620a(zzaz com_google_android_gms_wearable_internal_zzaz, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeInt(i);
                    this.f13377a.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo621a(zzaz com_google_android_gms_wearable_internal_zzaz, Uri uri) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13377a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo622a(zzaz com_google_android_gms_wearable_internal_zzaz, Uri uri, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.f13377a.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo623a(zzaz com_google_android_gms_wearable_internal_zzaz, Asset asset) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (asset != null) {
                        obtain.writeInt(1);
                        asset.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13377a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo624a(zzaz com_google_android_gms_wearable_internal_zzaz, ConnectionConfiguration connectionConfiguration) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (connectionConfiguration != null) {
                        obtain.writeInt(1);
                        connectionConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13377a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo625a(zzaz com_google_android_gms_wearable_internal_zzaz, PutDataRequest putDataRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (putDataRequest != null) {
                        obtain.writeInt(1);
                        putDataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13377a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo626a(zzaz com_google_android_gms_wearable_internal_zzaz, AddListenerRequest addListenerRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (addListenerRequest != null) {
                        obtain.writeInt(1);
                        addListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13377a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo627a(zzaz com_google_android_gms_wearable_internal_zzaz, AncsNotificationParcelable ancsNotificationParcelable) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (ancsNotificationParcelable != null) {
                        obtain.writeInt(1);
                        ancsNotificationParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13377a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo628a(zzaz com_google_android_gms_wearable_internal_zzaz, LargeAssetEnqueueRequest largeAssetEnqueueRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (largeAssetEnqueueRequest != null) {
                        obtain.writeInt(1);
                        largeAssetEnqueueRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13377a.transact(54, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo629a(zzaz com_google_android_gms_wearable_internal_zzaz, LargeAssetQuery largeAssetQuery) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (largeAssetQuery != null) {
                        obtain.writeInt(1);
                        largeAssetQuery.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13377a.transact(56, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo630a(zzaz com_google_android_gms_wearable_internal_zzaz, LargeAssetRemoveRequest largeAssetRemoveRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (largeAssetRemoveRequest != null) {
                        obtain.writeInt(1);
                        largeAssetRemoveRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13377a.transact(55, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo631a(zzaz com_google_android_gms_wearable_internal_zzaz, RemoveListenerRequest removeListenerRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (removeListenerRequest != null) {
                        obtain.writeInt(1);
                        removeListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13377a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo632a(zzaz com_google_android_gms_wearable_internal_zzaz, zzaw com_google_android_gms_wearable_internal_zzaw, String str) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (com_google_android_gms_wearable_internal_zzaw != null) {
                        iBinder = com_google_android_gms_wearable_internal_zzaw.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f13377a.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo633a(zzaz com_google_android_gms_wearable_internal_zzaz, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    this.f13377a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo634a(zzaz com_google_android_gms_wearable_internal_zzaz, String str, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f13377a.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo635a(zzaz com_google_android_gms_wearable_internal_zzaz, String str, ParcelFileDescriptor parcelFileDescriptor) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13377a.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo636a(zzaz com_google_android_gms_wearable_internal_zzaz, String str, ParcelFileDescriptor parcelFileDescriptor, long j, long j2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.f13377a.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo637a(zzaz com_google_android_gms_wearable_internal_zzaz, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f13377a.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo638a(zzaz com_google_android_gms_wearable_internal_zzaz, String str, String str2, byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr);
                    this.f13377a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo639a(zzaz com_google_android_gms_wearable_internal_zzaz, boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f13377a.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f13377a;
            }

            public final void mo640b(zzaz com_google_android_gms_wearable_internal_zzaz) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.f13377a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo641b(zzaz com_google_android_gms_wearable_internal_zzaz, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeInt(i);
                    this.f13377a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo642b(zzaz com_google_android_gms_wearable_internal_zzaz, Uri uri) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13377a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo643b(zzaz com_google_android_gms_wearable_internal_zzaz, Uri uri, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.f13377a.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo644b(zzaz com_google_android_gms_wearable_internal_zzaz, ConnectionConfiguration connectionConfiguration) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (connectionConfiguration != null) {
                        obtain.writeInt(1);
                        connectionConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13377a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo645b(zzaz com_google_android_gms_wearable_internal_zzaz, zzaw com_google_android_gms_wearable_internal_zzaw, String str) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (com_google_android_gms_wearable_internal_zzaw != null) {
                        iBinder = com_google_android_gms_wearable_internal_zzaw.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f13377a.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo646b(zzaz com_google_android_gms_wearable_internal_zzaz, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    this.f13377a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo647b(zzaz com_google_android_gms_wearable_internal_zzaz, String str, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f13377a.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo648b(zzaz com_google_android_gms_wearable_internal_zzaz, boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f13377a.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo649c(zzaz com_google_android_gms_wearable_internal_zzaz) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.f13377a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo650c(zzaz com_google_android_gms_wearable_internal_zzaz, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeInt(i);
                    this.f13377a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo651c(zzaz com_google_android_gms_wearable_internal_zzaz, Uri uri) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13377a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo652c(zzaz com_google_android_gms_wearable_internal_zzaz, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    this.f13377a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo653d(zzaz com_google_android_gms_wearable_internal_zzaz) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.f13377a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo654d(zzaz com_google_android_gms_wearable_internal_zzaz, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    this.f13377a.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo655e(zzaz com_google_android_gms_wearable_internal_zzaz) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.f13377a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo656e(zzaz com_google_android_gms_wearable_internal_zzaz, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    this.f13377a.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo657f(zzaz com_google_android_gms_wearable_internal_zzaz) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.f13377a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo658f(zzaz com_google_android_gms_wearable_internal_zzaz, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    this.f13377a.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo659g(zzaz com_google_android_gms_wearable_internal_zzaz) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.f13377a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo660h(zzaz com_google_android_gms_wearable_internal_zzaz) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.f13377a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo661i(zzaz com_google_android_gms_wearable_internal_zzaz) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.f13377a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo662j(zzaz com_google_android_gms_wearable_internal_zzaz) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.f13377a.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo663k(zzaz com_google_android_gms_wearable_internal_zzaz) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.f13377a.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo664l(zzaz com_google_android_gms_wearable_internal_zzaz) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.f13377a.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo665m(zzaz com_google_android_gms_wearable_internal_zzaz) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.f13377a.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo666n(zzaz com_google_android_gms_wearable_internal_zzaz) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.f13377a.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo667o(zzaz com_google_android_gms_wearable_internal_zzaz) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.f13377a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo668p(zzaz com_google_android_gms_wearable_internal_zzaz) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.f13377a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo669q(zzaz com_google_android_gms_wearable_internal_zzaz) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.f13377a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzbb m13560a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzbb)) ? new zza(iBinder) : (zzbb) queryLocalInterface;
        }
    }

    void mo618a(zzaz com_google_android_gms_wearable_internal_zzaz);

    void mo619a(zzaz com_google_android_gms_wearable_internal_zzaz, byte b);

    void mo620a(zzaz com_google_android_gms_wearable_internal_zzaz, int i);

    void mo621a(zzaz com_google_android_gms_wearable_internal_zzaz, Uri uri);

    void mo622a(zzaz com_google_android_gms_wearable_internal_zzaz, Uri uri, int i);

    void mo623a(zzaz com_google_android_gms_wearable_internal_zzaz, Asset asset);

    void mo624a(zzaz com_google_android_gms_wearable_internal_zzaz, ConnectionConfiguration connectionConfiguration);

    void mo625a(zzaz com_google_android_gms_wearable_internal_zzaz, PutDataRequest putDataRequest);

    void mo626a(zzaz com_google_android_gms_wearable_internal_zzaz, AddListenerRequest addListenerRequest);

    void mo627a(zzaz com_google_android_gms_wearable_internal_zzaz, AncsNotificationParcelable ancsNotificationParcelable);

    void mo628a(zzaz com_google_android_gms_wearable_internal_zzaz, LargeAssetEnqueueRequest largeAssetEnqueueRequest);

    void mo629a(zzaz com_google_android_gms_wearable_internal_zzaz, LargeAssetQuery largeAssetQuery);

    void mo630a(zzaz com_google_android_gms_wearable_internal_zzaz, LargeAssetRemoveRequest largeAssetRemoveRequest);

    void mo631a(zzaz com_google_android_gms_wearable_internal_zzaz, RemoveListenerRequest removeListenerRequest);

    void mo632a(zzaz com_google_android_gms_wearable_internal_zzaz, zzaw com_google_android_gms_wearable_internal_zzaw, String str);

    void mo633a(zzaz com_google_android_gms_wearable_internal_zzaz, String str);

    void mo634a(zzaz com_google_android_gms_wearable_internal_zzaz, String str, int i);

    void mo635a(zzaz com_google_android_gms_wearable_internal_zzaz, String str, ParcelFileDescriptor parcelFileDescriptor);

    void mo636a(zzaz com_google_android_gms_wearable_internal_zzaz, String str, ParcelFileDescriptor parcelFileDescriptor, long j, long j2);

    void mo637a(zzaz com_google_android_gms_wearable_internal_zzaz, String str, String str2);

    void mo638a(zzaz com_google_android_gms_wearable_internal_zzaz, String str, String str2, byte[] bArr);

    void mo639a(zzaz com_google_android_gms_wearable_internal_zzaz, boolean z);

    void mo640b(zzaz com_google_android_gms_wearable_internal_zzaz);

    void mo641b(zzaz com_google_android_gms_wearable_internal_zzaz, int i);

    void mo642b(zzaz com_google_android_gms_wearable_internal_zzaz, Uri uri);

    void mo643b(zzaz com_google_android_gms_wearable_internal_zzaz, Uri uri, int i);

    void mo644b(zzaz com_google_android_gms_wearable_internal_zzaz, ConnectionConfiguration connectionConfiguration);

    void mo645b(zzaz com_google_android_gms_wearable_internal_zzaz, zzaw com_google_android_gms_wearable_internal_zzaw, String str);

    void mo646b(zzaz com_google_android_gms_wearable_internal_zzaz, String str);

    void mo647b(zzaz com_google_android_gms_wearable_internal_zzaz, String str, int i);

    void mo648b(zzaz com_google_android_gms_wearable_internal_zzaz, boolean z);

    void mo649c(zzaz com_google_android_gms_wearable_internal_zzaz);

    void mo650c(zzaz com_google_android_gms_wearable_internal_zzaz, int i);

    void mo651c(zzaz com_google_android_gms_wearable_internal_zzaz, Uri uri);

    void mo652c(zzaz com_google_android_gms_wearable_internal_zzaz, String str);

    void mo653d(zzaz com_google_android_gms_wearable_internal_zzaz);

    void mo654d(zzaz com_google_android_gms_wearable_internal_zzaz, String str);

    void mo655e(zzaz com_google_android_gms_wearable_internal_zzaz);

    void mo656e(zzaz com_google_android_gms_wearable_internal_zzaz, String str);

    void mo657f(zzaz com_google_android_gms_wearable_internal_zzaz);

    void mo658f(zzaz com_google_android_gms_wearable_internal_zzaz, String str);

    void mo659g(zzaz com_google_android_gms_wearable_internal_zzaz);

    void mo660h(zzaz com_google_android_gms_wearable_internal_zzaz);

    void mo661i(zzaz com_google_android_gms_wearable_internal_zzaz);

    void mo662j(zzaz com_google_android_gms_wearable_internal_zzaz);

    void mo663k(zzaz com_google_android_gms_wearable_internal_zzaz);

    void mo664l(zzaz com_google_android_gms_wearable_internal_zzaz);

    void mo665m(zzaz com_google_android_gms_wearable_internal_zzaz);

    void mo666n(zzaz com_google_android_gms_wearable_internal_zzaz);

    void mo667o(zzaz com_google_android_gms_wearable_internal_zzaz);

    void mo668p(zzaz com_google_android_gms_wearable_internal_zzaz);

    void mo669q(zzaz com_google_android_gms_wearable_internal_zzaz);
}
