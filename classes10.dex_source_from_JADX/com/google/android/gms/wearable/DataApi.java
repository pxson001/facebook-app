package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface DataApi {

    public interface DataListener {
        void mo134a(DataEventBuffer dataEventBuffer);
    }

    public interface DataItemResult extends Result {
    }

    public interface DeleteDataItemsResult extends Result {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FilterType {
    }

    PendingResult<DataItemBuffer> mo673a(GoogleApiClient googleApiClient, Uri uri);

    PendingResult<DataItemResult> mo674a(GoogleApiClient googleApiClient, PutDataRequest putDataRequest);

    PendingResult<DeleteDataItemsResult> mo675b(GoogleApiClient googleApiClient, Uri uri);
}
