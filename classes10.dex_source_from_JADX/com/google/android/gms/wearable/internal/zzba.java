package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zze;
import java.util.List;

public interface zzba extends IInterface {

    public abstract class zza extends Binder implements zzba {

        class zza implements zzba {
            private IBinder f13376a;

            zza(IBinder iBinder) {
                this.f13376a = iBinder;
            }

            public final void mo562a(DataHolder dataHolder) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13376a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public final void mo563a(AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (amsEntityUpdateParcelable != null) {
                        obtain.writeInt(1);
                        amsEntityUpdateParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13376a.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public final void mo564a(AncsNotificationParcelable ancsNotificationParcelable) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (ancsNotificationParcelable != null) {
                        obtain.writeInt(1);
                        ancsNotificationParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13376a.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public final void mo565a(CapabilityInfoParcelable capabilityInfoParcelable) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (capabilityInfoParcelable != null) {
                        obtain.writeInt(1);
                        capabilityInfoParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13376a.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public final void mo566a(ChannelEventParcelable channelEventParcelable) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (channelEventParcelable != null) {
                        obtain.writeInt(1);
                        channelEventParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13376a.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public final void mo567a(LargeAssetQueueStateChangeParcelable largeAssetQueueStateChangeParcelable) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (largeAssetQueueStateChangeParcelable != null) {
                        obtain.writeInt(1);
                        largeAssetQueueStateChangeParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13376a.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public final void mo568a(LargeAssetSyncRequestPayload largeAssetSyncRequestPayload, zzay com_google_android_gms_wearable_internal_zzay) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (largeAssetSyncRequestPayload != null) {
                        obtain.writeInt(1);
                        largeAssetSyncRequestPayload.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_wearable_internal_zzay != null) {
                        iBinder = com_google_android_gms_wearable_internal_zzay.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f13376a.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public final void mo569a(MessageEventParcelable messageEventParcelable) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (messageEventParcelable != null) {
                        obtain.writeInt(1);
                        messageEventParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13376a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public final void mo570a(NodeParcelable nodeParcelable) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (nodeParcelable != null) {
                        obtain.writeInt(1);
                        nodeParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13376a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public final void mo571a(zzax com_google_android_gms_wearable_internal_zzax, String str, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (com_google_android_gms_wearable_internal_zzax != null) {
                        iBinder = com_google_android_gms_wearable_internal_zzax.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f13376a.transact(11, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public final void mo572a(List<NodeParcelable> list) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    obtain.writeTypedList(list);
                    this.f13376a.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f13376a;
            }

            public final void mo573b(NodeParcelable nodeParcelable) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (nodeParcelable != null) {
                        obtain.writeInt(1);
                        nodeParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13376a.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.wearable.internal.IWearableListener");
        }

        public static zzba m13304a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzba)) ? new zza(iBinder) : (zzba) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            LargeAssetSyncRequestPayload largeAssetSyncRequestPayload = null;
            NodeParcelable nodeParcelable;
            IInterface queryLocalInterface;
            switch (i) {
                case 1:
                    DataHolder a;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (parcel.readInt() != 0) {
                        zze com_google_android_gms_common_data_zze = DataHolder.CREATOR;
                        a = zze.a(parcel);
                    }
                    mo562a(a);
                    return true;
                case 2:
                    MessageEventParcelable messageEventParcelable;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (parcel.readInt() != 0) {
                        messageEventParcelable = (MessageEventParcelable) MessageEventParcelable.CREATOR.createFromParcel(parcel);
                    }
                    mo569a(messageEventParcelable);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (parcel.readInt() != 0) {
                        nodeParcelable = (NodeParcelable) NodeParcelable.CREATOR.createFromParcel(parcel);
                    }
                    mo570a(nodeParcelable);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (parcel.readInt() != 0) {
                        nodeParcelable = (NodeParcelable) NodeParcelable.CREATOR.createFromParcel(parcel);
                    }
                    mo573b(nodeParcelable);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    mo572a(parcel.createTypedArrayList(NodeParcelable.CREATOR));
                    return true;
                case 6:
                    AncsNotificationParcelable ancsNotificationParcelable;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (parcel.readInt() != 0) {
                        ancsNotificationParcelable = (AncsNotificationParcelable) AncsNotificationParcelable.CREATOR.createFromParcel(parcel);
                    }
                    mo564a(ancsNotificationParcelable);
                    return true;
                case 7:
                    ChannelEventParcelable channelEventParcelable;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (parcel.readInt() != 0) {
                        channelEventParcelable = (ChannelEventParcelable) ChannelEventParcelable.CREATOR.createFromParcel(parcel);
                    }
                    mo566a(channelEventParcelable);
                    return true;
                case 8:
                    CapabilityInfoParcelable capabilityInfoParcelable;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (parcel.readInt() != 0) {
                        capabilityInfoParcelable = (CapabilityInfoParcelable) CapabilityInfoParcelable.CREATOR.createFromParcel(parcel);
                    }
                    mo565a(capabilityInfoParcelable);
                    return true;
                case 9:
                    AmsEntityUpdateParcelable amsEntityUpdateParcelable;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (parcel.readInt() != 0) {
                        amsEntityUpdateParcelable = (AmsEntityUpdateParcelable) AmsEntityUpdateParcelable.CREATOR.createFromParcel(parcel);
                    }
                    mo563a(amsEntityUpdateParcelable);
                    return true;
                case 10:
                    LargeAssetQueueStateChangeParcelable largeAssetQueueStateChangeParcelable;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (parcel.readInt() != 0) {
                        largeAssetQueueStateChangeParcelable = (LargeAssetQueueStateChangeParcelable) LargeAssetQueueStateChangeParcelable.CREATOR.createFromParcel(parcel);
                    }
                    mo567a(largeAssetQueueStateChangeParcelable);
                    return true;
                case 11:
                    zzax com_google_android_gms_wearable_internal_zzax;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder == null) {
                        com_google_android_gms_wearable_internal_zzax = null;
                    } else {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IFileDescriptorReceiver");
                        com_google_android_gms_wearable_internal_zzax = (queryLocalInterface == null || !(queryLocalInterface instanceof zzax)) ? new zzax$zza$zza(readStrongBinder) : (zzax) queryLocalInterface;
                    }
                    mo571a(com_google_android_gms_wearable_internal_zzax, parcel.readString(), parcel.readInt());
                    return true;
                case 12:
                    zzay com_google_android_gms_wearable_internal_zzay;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (parcel.readInt() != 0) {
                        largeAssetSyncRequestPayload = (LargeAssetSyncRequestPayload) LargeAssetSyncRequestPayload.CREATOR.createFromParcel(parcel);
                    }
                    IBinder readStrongBinder2 = parcel.readStrongBinder();
                    if (readStrongBinder2 == null) {
                        com_google_android_gms_wearable_internal_zzay = null;
                    } else {
                        queryLocalInterface = readStrongBinder2.queryLocalInterface("com.google.android.gms.wearable.internal.ILargeAssetSyncRequestResponder");
                        com_google_android_gms_wearable_internal_zzay = (queryLocalInterface == null || !(queryLocalInterface instanceof zzay)) ? new zzay$zza$zza(readStrongBinder2) : (zzay) queryLocalInterface;
                    }
                    mo568a(largeAssetSyncRequestPayload, com_google_android_gms_wearable_internal_zzay);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.wearable.internal.IWearableListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo562a(DataHolder dataHolder);

    void mo563a(AmsEntityUpdateParcelable amsEntityUpdateParcelable);

    void mo564a(AncsNotificationParcelable ancsNotificationParcelable);

    void mo565a(CapabilityInfoParcelable capabilityInfoParcelable);

    void mo566a(ChannelEventParcelable channelEventParcelable);

    void mo567a(LargeAssetQueueStateChangeParcelable largeAssetQueueStateChangeParcelable);

    void mo568a(LargeAssetSyncRequestPayload largeAssetSyncRequestPayload, zzay com_google_android_gms_wearable_internal_zzay);

    void mo569a(MessageEventParcelable messageEventParcelable);

    void mo570a(NodeParcelable nodeParcelable);

    void mo571a(zzax com_google_android_gms_wearable_internal_zzax, String str, int i);

    void mo572a(List<NodeParcelable> list);

    void mo573b(NodeParcelable nodeParcelable);
}
