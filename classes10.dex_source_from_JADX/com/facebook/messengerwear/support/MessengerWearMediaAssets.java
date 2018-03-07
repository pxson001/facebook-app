package com.facebook.messengerwear.support;

import android.net.Uri;
import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.time.Clock;
import com.facebook.debug.log.BLog;
import com.facebook.messengerwear.shared.MessengerWearConstants.AssetType;
import com.facebook.messengerwear.shared.MessengerWearConstants.WearDataApiPath;
import com.facebook.messengerwear.shared.MessengerWearCrypto;
import com.facebook.messengerwear.support.MessengerWearMediaFetcher.MediaData;
import com.facebook.messengerwear.support.MessengerWearMediaManager.FetchRequest;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ultralight.Inject;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.Wearable;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.ExecutorService;

/* compiled from: photo_message_view */
public class MessengerWearMediaAssets {
    public static final Class f5014a = MessengerWearMediaAssets.class;
    @Inject
    public Clock f5015b;
    @BackgroundExecutorService
    @Inject
    public ExecutorService f5016c;
    @Inject
    public WearableGoogleApiClientFactory f5017d;

    /* compiled from: photo_message_view */
    public class C06841 implements Runnable {
        final /* synthetic */ FetchRequest f5006a;
        final /* synthetic */ SettableFuture f5007b;
        final /* synthetic */ MessengerWearMediaAssets f5008c;

        public C06841(MessengerWearMediaAssets messengerWearMediaAssets, FetchRequest fetchRequest, SettableFuture settableFuture) {
            this.f5008c = messengerWearMediaAssets;
            this.f5006a = fetchRequest;
            this.f5007b = settableFuture;
        }

        public void run() {
            GoogleApiClient a = this.f5008c.f5017d.m4585a();
            try {
                if (a.d().b()) {
                    Uri e;
                    String a2 = MessengerWearCrypto.m4503a(this.f5006a.f5053b);
                    switch (this.f5006a.f5054c) {
                        case STICKER:
                            e = WearDataApiPath.m4500e(Uri.encode(a2));
                            break;
                        case IMAGE:
                            e = WearDataApiPath.m4502g(Uri.encode(a2));
                            break;
                        default:
                            e = null;
                            break;
                    }
                    DataItemBuffer dataItemBuffer = (DataItemBuffer) Wearable.f13157a.mo673a(a, e).a();
                    e.toString();
                    if (!dataItemBuffer.cp_().e()) {
                        Integer.valueOf(dataItemBuffer.cp_().f());
                        dataItemBuffer.cp_().c();
                        FutureDetour.a(this.f5007b, null, 1577181588);
                        a.e();
                        return;
                    } else if (dataItemBuffer.a() == 0) {
                        FutureDetour.a(this.f5007b, null, -1276304652);
                        a.e();
                        return;
                    } else {
                        Object obj;
                        Integer.valueOf(dataItemBuffer.a());
                        if (dataItemBuffer.a() == 0) {
                            FutureDetour.a(this.f5007b, null, 1556449470);
                        }
                        DataMap a3 = DataMapItem.m13270a((DataItem) dataItemBuffer.a(0)).m13272a();
                        int c = a3.m13264c("frame_count");
                        if (c == 0) {
                            obj = new Asset[]{a3.m13267e("static_asset")};
                        } else {
                            obj = new Asset[c];
                            for (int i = 0; i < c; i++) {
                                obj[i] = a3.m13267e("frame_" + i);
                            }
                        }
                        FutureDetour.a(this.f5007b, obj, 1034137868);
                        dataItemBuffer.c();
                        a.e();
                        return;
                    }
                }
                FutureDetour.a(this.f5007b, null, 2009349364);
            } catch (Throwable e2) {
                this.f5007b.a(e2);
            } finally {
                a.e();
            }
        }
    }

    /* compiled from: photo_message_view */
    public class C06852 implements Runnable {
        final /* synthetic */ MediaData f5009a;
        final /* synthetic */ AssetType f5010b;
        final /* synthetic */ SettableFuture f5011c;
        final /* synthetic */ MessengerWearMediaAssets f5012d;

        public C06852(MessengerWearMediaAssets messengerWearMediaAssets, MediaData mediaData, AssetType assetType, SettableFuture settableFuture) {
            this.f5012d = messengerWearMediaAssets;
            this.f5009a = mediaData;
            this.f5010b = assetType;
            this.f5011c = settableFuture;
        }

        public void run() {
            this.f5010b.toString();
            GoogleApiClient a = this.f5012d.f5017d.m4585a();
            try {
                if (a.d().b()) {
                    String a2 = MessengerWearCrypto.m4503a(this.f5009a.f5032a);
                    PutDataMapRequest putDataMapRequest = null;
                    switch (this.f5010b) {
                        case STICKER:
                            putDataMapRequest = PutDataMapRequest.m13277a(WearDataApiPath.m4499d(a2));
                            break;
                        case IMAGE:
                            putDataMapRequest = PutDataMapRequest.m13277a(WearDataApiPath.m4501f(a2));
                            break;
                    }
                    DataMap b = putDataMapRequest.m13279b();
                    b.m13256a("timestamp", this.f5012d.f5015b.a());
                    b.m13258a("media_id", a2);
                    int length = this.f5009a.f5033b.length;
                    Object obj = new Asset[length];
                    if (length > 1) {
                        b.m13255a("frame_count", length);
                        b.m13255a("loop_count", this.f5009a.f5035d);
                        b.m13260a("frame_durations", MessengerWearMediaAssets.m4540b(this.f5009a.f5034c));
                        String[] strArr = new String[length];
                        for (int i = 0; i < length; i++) {
                            obj[i] = Asset.m13226a(MessengerWearCrypto.m4505a(this.f5009a.f5033b[i]));
                            strArr[i] = "frame_" + i;
                            b.m13257a(strArr[i], obj[i]);
                        }
                        b.m13261a("frame_ids", strArr);
                    } else {
                        obj[0] = Asset.m13226a(MessengerWearCrypto.m4505a(this.f5009a.f5033b[0]));
                        b.m13257a("static_asset", obj[0]);
                    }
                    PutDataRequest c = putDataMapRequest.m13280c();
                    c.m13289g();
                    ((DataItemResult) Wearable.f13157a.mo674a(a, c).a()).cp_().e();
                    putDataMapRequest.m13278a().toString();
                    FutureDetour.a(this.f5011c, obj, 863989846);
                    a.e();
                    return;
                }
                BLog.b(MessengerWearMediaAssets.f5014a, "Connection to Google API failed");
            } catch (Throwable e) {
                BLog.b(MessengerWearMediaAssets.f5014a, "Exception occured while saving an asset", e);
                this.f5011c.a(e);
            } finally {
                a.e();
            }
        }
    }

    public static long[] m4540b(int[] iArr) {
        int length = iArr.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = (long) iArr[i];
        }
        return jArr;
    }
}
