package com.facebook.privacy.protocol;

import android.text.TextUtils;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: sticker_tab_selected */
public class BulkEditAlbumPhotoPrivacyMethod implements ApiMethod<BulkEditAlbumPhotoPrivacyParams, Boolean> {
    public final ApiRequest m6028a(Object obj) {
        BulkEditAlbumPhotoPrivacyParams bulkEditAlbumPhotoPrivacyParams = (BulkEditAlbumPhotoPrivacyParams) obj;
        List arrayList = new ArrayList();
        if (!TextUtils.isEmpty(bulkEditAlbumPhotoPrivacyParams.f4117a)) {
            arrayList.add(new BasicNameValuePair("album_id", bulkEditAlbumPhotoPrivacyParams.f4117a));
        }
        arrayList.add(new BasicNameValuePair("album_type", bulkEditAlbumPhotoPrivacyParams.f4119c.toString()));
        arrayList.add(new BasicNameValuePair("caller", bulkEditAlbumPhotoPrivacyParams.f4118b.toString()));
        arrayList.add(new BasicNameValuePair("caps_privacy", Boolean.toString(bulkEditAlbumPhotoPrivacyParams.f4122f)));
        arrayList.add(new BasicNameValuePair("client_time", Long.toString(bulkEditAlbumPhotoPrivacyParams.f4120d)));
        arrayList.add(new BasicNameValuePair("privacy", bulkEditAlbumPhotoPrivacyParams.f4121e));
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.d = "me/album_privacy_bulk_edit";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.c = "POST";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.b = "bulkEditAlbumPhotoPrivacy";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = arrayList;
        return apiRequestBuilder.a(RequestPriority.INTERACTIVE).C();
    }

    public final Object m6029a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(true);
    }
}
