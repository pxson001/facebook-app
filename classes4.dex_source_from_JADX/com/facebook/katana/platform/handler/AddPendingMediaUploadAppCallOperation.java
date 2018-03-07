package com.facebook.katana.platform.handler;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.katana.platform.PendingMediaUpload;
import com.facebook.katana.platform.database.PendingMediaUploadsStorageImpl;
import com.facebook.platform.common.action.PlatformAppCall;
import com.facebook.platform.common.server.AbstractPlatformOperation;
import com.facebook.platform.database.PendingAppCallsStorageImpl;
import com.facebook.platform.database.PlatformDatabaseSupplier;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import javax.inject.Inject;

/* compiled from: getAllContactsWithCap */
public class AddPendingMediaUploadAppCallOperation extends AbstractPlatformOperation {
    private final PendingMediaUploadsStorageImpl f11248b;
    private final PendingAppCallsStorageImpl f11249c;
    private final PlatformDatabaseSupplier f11250d;

    @Inject
    public AddPendingMediaUploadAppCallOperation(PendingMediaUploadsStorageImpl pendingMediaUploadsStorageImpl, PendingAppCallsStorageImpl pendingAppCallsStorageImpl, PlatformDatabaseSupplier platformDatabaseSupplier) {
        super("platform_add_pending_media_upload");
        this.f11248b = pendingMediaUploadsStorageImpl;
        this.f11249c = pendingAppCallsStorageImpl;
        this.f11250d = platformDatabaseSupplier;
    }

    public final OperationResult mo836a(OperationParams operationParams) {
        Params params = (Params) operationParams.b().getParcelable("platform_add_pending_media_upload_params");
        SQLiteDatabase a = this.f11250d.a();
        SQLiteDetour.a(a, 1080382205);
        try {
            PlatformAppCall a2 = params.a();
            this.f11249c.m11688a(a2);
            this.f11248b.m11674a(new PendingMediaUpload(params.b(), a2.a()));
            a.setTransactionSuccessful();
            return OperationResult.a();
        } finally {
            SQLiteDetour.b(a, -9602765);
        }
    }
}
