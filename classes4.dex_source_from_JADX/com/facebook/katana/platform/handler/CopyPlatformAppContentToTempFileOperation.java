package com.facebook.katana.platform.handler;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.platform.common.server.AbstractPlatformOperation;
import com.facebook.platform.common.util.PlatformTempFileManager;
import java.io.File;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: generic_analytic_counters */
public class CopyPlatformAppContentToTempFileOperation extends AbstractPlatformOperation {
    private final Context f11287b;
    private final PlatformTempFileManager f11288c;
    private final MoreFileUtils f11289d;

    @Inject
    public CopyPlatformAppContentToTempFileOperation(Context context, PlatformTempFileManager platformTempFileManager, MoreFileUtils moreFileUtils) {
        super("platform_copy_platform_app_content");
        this.f11287b = context;
        this.f11288c = platformTempFileManager;
        this.f11289d = moreFileUtils;
    }

    public final OperationResult mo836a(OperationParams operationParams) {
        ContentResolver contentResolver = this.f11287b.getContentResolver();
        Params params = (Params) operationParams.c.getParcelable("platform_copy_platform_app_content_params");
        ArrayList arrayList = params.b;
        String str = params.a;
        String str2 = params.c;
        Bundle bundle = new Bundle();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str3 = (String) arrayList.get(i);
            File a = this.f11288c.m11694a(str, SafeUUIDGenerator.a().toString() + str2);
            this.f11289d.a(contentResolver.openInputStream(Uri.parse(str3)), a);
            bundle.putString(str3, a.getAbsolutePath());
        }
        return OperationResult.a(bundle);
    }
}
