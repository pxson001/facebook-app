package com.facebook.platform.opengraph.server;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiMethodRunner;
import com.facebook.http.protocol.ApiMethodRunner$Batch;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.platform.common.server.AbstractPlatformOperation;
import com.facebook.platform.server.protocol.UploadStagingResourcePhotoMethod;
import com.facebook.platform.server.protocol.UploadStagingResourcePhotoMethod.Params;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: funnel_cancelled */
public class UploadStagingResourcePhotosOperation extends AbstractPlatformOperation {
    public final Provider<ApiMethodRunner> f11322b;
    public final UploadStagingResourcePhotoMethod f11323c;

    public static UploadStagingResourcePhotosOperation m11755b(InjectorLike injectorLike) {
        return new UploadStagingResourcePhotosOperation(IdBasedSingletonScopeProvider.a(injectorLike, 2279), new UploadStagingResourcePhotoMethod());
    }

    @Inject
    public UploadStagingResourcePhotosOperation(Provider<ApiMethodRunner> provider, UploadStagingResourcePhotoMethod uploadStagingResourcePhotoMethod) {
        super("platform_upload_staging_resource_photos");
        this.f11322b = provider;
        this.f11323c = uploadStagingResourcePhotoMethod;
    }

    public final OperationResult mo836a(OperationParams operationParams) {
        Preconditions.checkArgument(this.f11251a.equals(operationParams.b));
        Params params = (Params) operationParams.c.getParcelable("platform_upload_staging_resource_photos_params");
        ApiMethodRunner$Batch a = ((ApiMethodRunnerImpl) this.f11322b.get()).a();
        ImmutableMap immutableMap = params.a;
        HashMap c = Maps.c();
        Iterator it = immutableMap.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i2 = i + 1;
            String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("uploadStagingResourcePhoto%d", Integer.valueOf(i));
            Params params2 = new Params(formatStrLocaleSafe, (Bitmap) entry.getValue());
            c.put(entry.getKey(), formatStrLocaleSafe);
            Builder a2 = BatchOperation.m12541a(this.f11323c, params2);
            a2.f11927c = formatStrLocaleSafe;
            a.mo888a(a2.m12549a());
            i = i2;
        }
        a.mo889a("uploadStagingResources", CallerContext.a(getClass()));
        Bundle bundle = new Bundle();
        for (Entry entry2 : c.entrySet()) {
            bundle.putString(((Uri) entry2.getKey()).toString(), (String) a.mo887a((String) entry2.getValue()));
        }
        return OperationResult.a(bundle);
    }
}
