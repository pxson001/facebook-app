package com.facebook.messengerwear.shared;

import android.net.Uri;
import com.facebook.messengerwear.shared.MessengerWearConstants.WearDataApiPath;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.Wearable;
import java.util.concurrent.TimeUnit;

/* compiled from: photo_view_fragment_tag */
public class GoogleApiSharedHelper {
    public static boolean m4484a(GoogleApiClient googleApiClient, String str) {
        boolean e;
        Uri parse = Uri.parse("wear:" + WearDataApiPath.m4496a(MessengerWearCrypto.m4503a(str)));
        if (googleApiClient.a(3000, TimeUnit.MILLISECONDS).b()) {
            DeleteDataItemsResult deleteDataItemsResult = (DeleteDataItemsResult) Wearable.f13157a.mo675b(googleApiClient, parse).a(3000, TimeUnit.MILLISECONDS);
            googleApiClient.e();
            e = deleteDataItemsResult.cp_().e();
        } else {
            e = false;
        }
        return e;
    }
}
