package com.facebook.vault.protocol;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.JSONUtil;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.ProgressDataStreamBody;
import com.facebook.vault.hash.VaultHashUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.File;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: threadProfilesProtected */
public class VaultImageUploadMethod implements ApiMethod<VaultImageUploadParams, VaultImageUploadResult> {
    private final AbstractFbErrorReporter f1865a;

    public final ApiRequest m1952a(Object obj) {
        VaultImageUploadParams vaultImageUploadParams = (VaultImageUploadParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("client_image_hash", vaultImageUploadParams.f1867b));
        a.add(new BasicNameValuePair("date_taken", Integer.toString((int) (((Long) VaultHashUtil.m1740b(vaultImageUploadParams.f1867b).second).longValue() / 1000))));
        a.add(new BasicNameValuePair("device_oid", vaultImageUploadParams.f1868c));
        long j = vaultImageUploadParams.f1869d;
        if (j > 0) {
            a.add(new BasicNameValuePair("existing_fbid", Long.toString(j)));
        }
        File file = vaultImageUploadParams.f1866a;
        FormBodyPart formBodyPart = new FormBodyPart("source", new ProgressDataStreamBody(file, "image/jpeg", file.getName(), vaultImageUploadParams.f1870e));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "vaultImageUpload";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "me/vaultimages";
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.l = ImmutableList.of(formBodyPart);
        return apiRequestBuilder.C();
    }

    @Inject
    public VaultImageUploadMethod(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f1865a = abstractFbErrorReporter;
    }

    public final Object m1953a(Object obj, ApiResponse apiResponse) {
        long c = JSONUtil.c(apiResponse.c().b("id"));
        if (c == 0) {
            this.f1865a.a("vault_image_upload_api missing id", StringFormatUtil.formatStrLocaleSafe("missing id in response: %s", apiResponse.c.toString()));
        }
        return new VaultImageUploadResult(c);
    }
}
