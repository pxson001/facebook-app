package com.facebook.bugreporter;

import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.crudolib.params.ParamsCollectionPool;
import com.facebook.crudolib.params.ParamsJsonEncoder;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.DataStreamBodyWithOffset;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: android.speech.action.WEB_SEARCH */
public class BugReportAttachmentUploadMethod implements ApiMethod<BugReportAttachmentUploadParams, Boolean> {
    public final ApiRequest m18528a(Object obj) {
        BugReportAttachmentUploadParams bugReportAttachmentUploadParams = (BugReportAttachmentUploadParams) obj;
        ParamsCollectionMap b = ParamsCollectionPool.a().b();
        b.a(ParamsJsonEncoder.a());
        b.a("config_id", "624618737631578");
        b.a("id", bugReportAttachmentUploadParams.f10431a);
        List arrayList = new ArrayList();
        File file = bugReportAttachmentUploadParams.f10433c;
        String str = bugReportAttachmentUploadParams.f10432b;
        if (!file.exists()) {
            return null;
        }
        String str2;
        String toLowerCase = str.toLowerCase(Locale.getDefault());
        if (toLowerCase.endsWith(".jpg") || toLowerCase.endsWith(".jpeg")) {
            str2 = "image/jpeg";
        } else if (toLowerCase.endsWith(".png")) {
            str2 = "image/png";
        } else {
            str2 = "text/plain";
        }
        arrayList.add(new FormBodyPart(str, new DataStreamBodyWithOffset(file, str2, str, 0, file.length())));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "bugReportAttachmentUpload";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = bugReportAttachmentUploadParams.f10431a + "/attachments";
        newBuilder = newBuilder;
        newBuilder.l = arrayList;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        newBuilder = newBuilder;
        newBuilder.h = b;
        return newBuilder.C();
    }

    public final Object m18529a(Object obj, ApiResponse apiResponse) {
        return Boolean.valueOf(apiResponse.b == 200);
    }
}
