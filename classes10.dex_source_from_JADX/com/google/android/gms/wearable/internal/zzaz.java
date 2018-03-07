package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zze;

public interface zzaz extends IInterface {

    public abstract class zza extends Binder implements zzaz {

        class zza implements zzaz {
            private IBinder f13375a;

            zza(IBinder iBinder) {
                this.f13375a = iBinder;
            }

            public final void mo585a(Status status) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo586a(DataHolder dataHolder) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo587a(AddLocalCapabilityResponse addLocalCapabilityResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (addLocalCapabilityResponse != null) {
                        obtain.writeInt(1);
                        addLocalCapabilityResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo588a(ChannelReceiveFileResponse channelReceiveFileResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (channelReceiveFileResponse != null) {
                        obtain.writeInt(1);
                        channelReceiveFileResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo589a(ChannelSendFileResponse channelSendFileResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (channelSendFileResponse != null) {
                        obtain.writeInt(1);
                        channelSendFileResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo590a(CloseChannelResponse closeChannelResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (closeChannelResponse != null) {
                        obtain.writeInt(1);
                        closeChannelResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo591a(DeleteDataItemsResponse deleteDataItemsResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (deleteDataItemsResponse != null) {
                        obtain.writeInt(1);
                        deleteDataItemsResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo592a(EnqueueLargeAssetResponse enqueueLargeAssetResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (enqueueLargeAssetResponse != null) {
                        obtain.writeInt(1);
                        enqueueLargeAssetResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo593a(GetAllCapabilitiesResponse getAllCapabilitiesResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getAllCapabilitiesResponse != null) {
                        obtain.writeInt(1);
                        getAllCapabilitiesResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo594a(GetCapabilityResponse getCapabilityResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getCapabilityResponse != null) {
                        obtain.writeInt(1);
                        getCapabilityResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo595a(GetChannelInputStreamResponse getChannelInputStreamResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getChannelInputStreamResponse != null) {
                        obtain.writeInt(1);
                        getChannelInputStreamResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo596a(GetChannelOutputStreamResponse getChannelOutputStreamResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getChannelOutputStreamResponse != null) {
                        obtain.writeInt(1);
                        getChannelOutputStreamResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo597a(GetCloudSyncOptInOutDoneResponse getCloudSyncOptInOutDoneResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getCloudSyncOptInOutDoneResponse != null) {
                        obtain.writeInt(1);
                        getCloudSyncOptInOutDoneResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo598a(GetCloudSyncOptInStatusResponse getCloudSyncOptInStatusResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getCloudSyncOptInStatusResponse != null) {
                        obtain.writeInt(1);
                        getCloudSyncOptInStatusResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo599a(GetCloudSyncSettingResponse getCloudSyncSettingResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getCloudSyncSettingResponse != null) {
                        obtain.writeInt(1);
                        getCloudSyncSettingResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo600a(GetConfigResponse getConfigResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getConfigResponse != null) {
                        obtain.writeInt(1);
                        getConfigResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo601a(GetConfigsResponse getConfigsResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getConfigsResponse != null) {
                        obtain.writeInt(1);
                        getConfigsResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo602a(GetConnectedNodesResponse getConnectedNodesResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getConnectedNodesResponse != null) {
                        obtain.writeInt(1);
                        getConnectedNodesResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo603a(GetDataItemResponse getDataItemResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getDataItemResponse != null) {
                        obtain.writeInt(1);
                        getDataItemResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo604a(GetFdForAssetResponse getFdForAssetResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getFdForAssetResponse != null) {
                        obtain.writeInt(1);
                        getFdForAssetResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo605a(GetLargeAssetQueueStateResponse getLargeAssetQueueStateResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getLargeAssetQueueStateResponse != null) {
                        obtain.writeInt(1);
                        getLargeAssetQueueStateResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo606a(GetLocalNodeResponse getLocalNodeResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getLocalNodeResponse != null) {
                        obtain.writeInt(1);
                        getLocalNodeResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo607a(OpenChannelResponse openChannelResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (openChannelResponse != null) {
                        obtain.writeInt(1);
                        openChannelResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo608a(PutDataResponse putDataResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (putDataResponse != null) {
                        obtain.writeInt(1);
                        putDataResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo609a(RemoveLargeAssetQueueEntriesResponse removeLargeAssetQueueEntriesResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (removeLargeAssetQueueEntriesResponse != null) {
                        obtain.writeInt(1);
                        removeLargeAssetQueueEntriesResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo610a(RemoveLocalCapabilityResponse removeLocalCapabilityResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (removeLocalCapabilityResponse != null) {
                        obtain.writeInt(1);
                        removeLocalCapabilityResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo611a(SendMessageResponse sendMessageResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (sendMessageResponse != null) {
                        obtain.writeInt(1);
                        sendMessageResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo612a(StorageInfoResponse storageInfoResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (storageInfoResponse != null) {
                        obtain.writeInt(1);
                        storageInfoResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f13375a;
            }

            public final void mo613b(CloseChannelResponse closeChannelResponse) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (closeChannelResponse != null) {
                        obtain.writeInt(1);
                        closeChannelResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13375a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.wearable.internal.IWearableCallbacks");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            RemoveLocalCapabilityResponse removeLocalCapabilityResponse = null;
            CloseChannelResponse closeChannelResponse;
            switch (i) {
                case 2:
                    GetConfigResponse getConfigResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        getConfigResponse = (GetConfigResponse) GetConfigResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo600a(getConfigResponse);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    PutDataResponse putDataResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        putDataResponse = (PutDataResponse) PutDataResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo608a(putDataResponse);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    GetDataItemResponse getDataItemResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        getDataItemResponse = (GetDataItemResponse) GetDataItemResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo603a(getDataItemResponse);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    DataHolder a;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        zze com_google_android_gms_common_data_zze = DataHolder.CREATOR;
                        a = zze.a(parcel);
                    }
                    mo586a(a);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    DeleteDataItemsResponse deleteDataItemsResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        deleteDataItemsResponse = (DeleteDataItemsResponse) DeleteDataItemsResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo591a(deleteDataItemsResponse);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    SendMessageResponse sendMessageResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        sendMessageResponse = (SendMessageResponse) SendMessageResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo611a(sendMessageResponse);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    GetFdForAssetResponse getFdForAssetResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        getFdForAssetResponse = (GetFdForAssetResponse) GetFdForAssetResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo604a(getFdForAssetResponse);
                    parcel2.writeNoException();
                    return true;
                case 9:
                    GetLocalNodeResponse getLocalNodeResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        getLocalNodeResponse = (GetLocalNodeResponse) GetLocalNodeResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo606a(getLocalNodeResponse);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    GetConnectedNodesResponse getConnectedNodesResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        getConnectedNodesResponse = (GetConnectedNodesResponse) GetConnectedNodesResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo602a(getConnectedNodesResponse);
                    parcel2.writeNoException();
                    return true;
                case 11:
                    Status status;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        status = (Status) Status.CREATOR.createFromParcel(parcel);
                    }
                    mo585a(status);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    StorageInfoResponse storageInfoResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        storageInfoResponse = (StorageInfoResponse) StorageInfoResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo612a(storageInfoResponse);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    GetConfigsResponse getConfigsResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        getConfigsResponse = (GetConfigsResponse) GetConfigsResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo601a(getConfigsResponse);
                    parcel2.writeNoException();
                    return true;
                case 14:
                    OpenChannelResponse openChannelResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        openChannelResponse = (OpenChannelResponse) OpenChannelResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo607a(openChannelResponse);
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        closeChannelResponse = (CloseChannelResponse) CloseChannelResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo590a(closeChannelResponse);
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        closeChannelResponse = (CloseChannelResponse) CloseChannelResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo613b(closeChannelResponse);
                    parcel2.writeNoException();
                    return true;
                case 17:
                    GetChannelInputStreamResponse getChannelInputStreamResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        getChannelInputStreamResponse = (GetChannelInputStreamResponse) GetChannelInputStreamResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo595a(getChannelInputStreamResponse);
                    parcel2.writeNoException();
                    return true;
                case 18:
                    GetChannelOutputStreamResponse getChannelOutputStreamResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        getChannelOutputStreamResponse = (GetChannelOutputStreamResponse) GetChannelOutputStreamResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo596a(getChannelOutputStreamResponse);
                    parcel2.writeNoException();
                    return true;
                case 19:
                    ChannelReceiveFileResponse channelReceiveFileResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        channelReceiveFileResponse = (ChannelReceiveFileResponse) ChannelReceiveFileResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo588a(channelReceiveFileResponse);
                    parcel2.writeNoException();
                    return true;
                case 20:
                    ChannelSendFileResponse channelSendFileResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        channelSendFileResponse = (ChannelSendFileResponse) ChannelSendFileResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo589a(channelSendFileResponse);
                    parcel2.writeNoException();
                    return true;
                case 22:
                    GetCapabilityResponse getCapabilityResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        getCapabilityResponse = (GetCapabilityResponse) GetCapabilityResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo594a(getCapabilityResponse);
                    parcel2.writeNoException();
                    return true;
                case 23:
                    GetAllCapabilitiesResponse getAllCapabilitiesResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        getAllCapabilitiesResponse = (GetAllCapabilitiesResponse) GetAllCapabilitiesResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo593a(getAllCapabilitiesResponse);
                    parcel2.writeNoException();
                    return true;
                case 26:
                    AddLocalCapabilityResponse addLocalCapabilityResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        addLocalCapabilityResponse = (AddLocalCapabilityResponse) AddLocalCapabilityResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo587a(addLocalCapabilityResponse);
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        removeLocalCapabilityResponse = (RemoveLocalCapabilityResponse) RemoveLocalCapabilityResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo610a(removeLocalCapabilityResponse);
                    parcel2.writeNoException();
                    return true;
                case 28:
                    GetCloudSyncOptInOutDoneResponse getCloudSyncOptInOutDoneResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        getCloudSyncOptInOutDoneResponse = (GetCloudSyncOptInOutDoneResponse) GetCloudSyncOptInOutDoneResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo597a(getCloudSyncOptInOutDoneResponse);
                    parcel2.writeNoException();
                    return true;
                case 29:
                    GetCloudSyncSettingResponse getCloudSyncSettingResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        getCloudSyncSettingResponse = (GetCloudSyncSettingResponse) GetCloudSyncSettingResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo599a(getCloudSyncSettingResponse);
                    parcel2.writeNoException();
                    return true;
                case 30:
                    GetCloudSyncOptInStatusResponse getCloudSyncOptInStatusResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        getCloudSyncOptInStatusResponse = (GetCloudSyncOptInStatusResponse) GetCloudSyncOptInStatusResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo598a(getCloudSyncOptInStatusResponse);
                    parcel2.writeNoException();
                    return true;
                case 31:
                    EnqueueLargeAssetResponse enqueueLargeAssetResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        enqueueLargeAssetResponse = (EnqueueLargeAssetResponse) EnqueueLargeAssetResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo592a(enqueueLargeAssetResponse);
                    parcel2.writeNoException();
                    return true;
                case 32:
                    RemoveLargeAssetQueueEntriesResponse removeLargeAssetQueueEntriesResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        removeLargeAssetQueueEntriesResponse = (RemoveLargeAssetQueueEntriesResponse) RemoveLargeAssetQueueEntriesResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo609a(removeLargeAssetQueueEntriesResponse);
                    parcel2.writeNoException();
                    return true;
                case 33:
                    GetLargeAssetQueueStateResponse getLargeAssetQueueStateResponse;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        getLargeAssetQueueStateResponse = (GetLargeAssetQueueStateResponse) GetLargeAssetQueueStateResponse.CREATOR.createFromParcel(parcel);
                    }
                    mo605a(getLargeAssetQueueStateResponse);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo585a(Status status);

    void mo586a(DataHolder dataHolder);

    void mo587a(AddLocalCapabilityResponse addLocalCapabilityResponse);

    void mo588a(ChannelReceiveFileResponse channelReceiveFileResponse);

    void mo589a(ChannelSendFileResponse channelSendFileResponse);

    void mo590a(CloseChannelResponse closeChannelResponse);

    void mo591a(DeleteDataItemsResponse deleteDataItemsResponse);

    void mo592a(EnqueueLargeAssetResponse enqueueLargeAssetResponse);

    void mo593a(GetAllCapabilitiesResponse getAllCapabilitiesResponse);

    void mo594a(GetCapabilityResponse getCapabilityResponse);

    void mo595a(GetChannelInputStreamResponse getChannelInputStreamResponse);

    void mo596a(GetChannelOutputStreamResponse getChannelOutputStreamResponse);

    void mo597a(GetCloudSyncOptInOutDoneResponse getCloudSyncOptInOutDoneResponse);

    void mo598a(GetCloudSyncOptInStatusResponse getCloudSyncOptInStatusResponse);

    void mo599a(GetCloudSyncSettingResponse getCloudSyncSettingResponse);

    void mo600a(GetConfigResponse getConfigResponse);

    void mo601a(GetConfigsResponse getConfigsResponse);

    void mo602a(GetConnectedNodesResponse getConnectedNodesResponse);

    void mo603a(GetDataItemResponse getDataItemResponse);

    void mo604a(GetFdForAssetResponse getFdForAssetResponse);

    void mo605a(GetLargeAssetQueueStateResponse getLargeAssetQueueStateResponse);

    void mo606a(GetLocalNodeResponse getLocalNodeResponse);

    void mo607a(OpenChannelResponse openChannelResponse);

    void mo608a(PutDataResponse putDataResponse);

    void mo609a(RemoveLargeAssetQueueEntriesResponse removeLargeAssetQueueEntriesResponse);

    void mo610a(RemoveLocalCapabilityResponse removeLocalCapabilityResponse);

    void mo611a(SendMessageResponse sendMessageResponse);

    void mo612a(StorageInfoResponse storageInfoResponse);

    void mo613b(CloseChannelResponse closeChannelResponse);
}
