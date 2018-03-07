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

/* compiled from: generate_machine_id */
public class GetPendingAppCallForMediaUploadOperation extends AbstractPlatformOperation {
    private final PendingMediaUploadsStorageImpl f11293b;
    private final PendingAppCallsStorageImpl f11294c;
    private final PlatformDatabaseSupplier f11295d;

    @Inject
    public GetPendingAppCallForMediaUploadOperation(PendingMediaUploadsStorageImpl pendingMediaUploadsStorageImpl, PendingAppCallsStorageImpl pendingAppCallsStorageImpl, PlatformDatabaseSupplier platformDatabaseSupplier) {
        super("platform_get_app_call_for_pending_upload");
        this.f11293b = pendingMediaUploadsStorageImpl;
        this.f11294c = pendingAppCallsStorageImpl;
        this.f11295d = platformDatabaseSupplier;
    }

    public final OperationResult mo836a(OperationParams operationParams) {
        Params params = (Params) operationParams.b().getParcelable("platform_get_app_call_for_pending_upload_params");
        SQLiteDatabase a = this.f11295d.a();
        String a2 = params.a();
        PendingMediaUpload a3 = this.f11293b.m11673a(a2);
        if (a3 != null) {
            PlatformAppCall a4 = this.f11294c.m11687a(a3.b());
            if (a4 != null) {
                if (params.b()) {
                    SQLiteDetour.a(a, 870846951);
                    try {
                        this.f11293b.m11675b(a2);
                        this.f11294c.m11689b(a4.a());
                        a.setTransactionSuccessful();
                    } finally {
                        SQLiteDetour.b(a, 1781618132);
                    }
                }
                return OperationResult.a(a4);
            }
        }
        return OperationResult.a();
    }
}
