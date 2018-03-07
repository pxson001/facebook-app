package com.facebook.platform.common.server;

import com.facebook.common.file.FileTree;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.platform.common.util.PlatformTempFileManager;
import java.io.File;
import javax.inject.Inject;

/* compiled from: funnel_started */
public class DeleteTempFilesForAppCallOperation extends AbstractPlatformOperation {
    private final PlatformTempFileManager f11319b;

    @Inject
    public DeleteTempFilesForAppCallOperation(PlatformTempFileManager platformTempFileManager) {
        super("platform_delete_temp_files");
        this.f11319b = platformTempFileManager;
    }

    public final OperationResult mo836a(OperationParams operationParams) {
        File a = MoreFileUtils.a(MoreFileUtils.a(this.f11319b.f11291a.getCacheDir(), "platform"), operationParams.c.getString("platform_delete_temp_files_params"));
        if (a.exists()) {
            if (a.isDirectory()) {
                FileTree.m3117a(a);
            }
            a.delete();
        }
        return OperationResult.a;
    }
}
