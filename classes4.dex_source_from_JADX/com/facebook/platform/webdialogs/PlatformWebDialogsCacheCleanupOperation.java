package com.facebook.platform.webdialogs;

import android.os.Bundle;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.platform.common.server.AbstractPlatformOperation;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: from_surface_destroy */
public class PlatformWebDialogsCacheCleanupOperation extends AbstractPlatformOperation {
    private PlatformWebDialogsCache f11339b;

    @Inject
    public PlatformWebDialogsCacheCleanupOperation(PlatformWebDialogsCache platformWebDialogsCache) {
        super("platform_cleanup_cached_webdialogs");
        this.f11339b = platformWebDialogsCache;
    }

    public final OperationResult mo836a(OperationParams operationParams) {
        Bundle bundle = operationParams.c;
        if (bundle == null) {
            return OperationResult.a(ErrorCode.CACHE_DISK_ERROR);
        }
        ArrayList stringArrayList = bundle.getStringArrayList("platform_urls_to_delete");
        if (!(stringArrayList == null || stringArrayList.isEmpty())) {
            int size = stringArrayList.size();
            for (int i = 0; i < size; i++) {
                this.f11339b.m9410b((String) stringArrayList.get(i));
            }
        }
        if (bundle.getBoolean("delete_orphaned_files_flag")) {
            this.f11339b.m9412d();
        }
        this.f11339b.m9413e();
        return OperationResult.a;
    }
}
