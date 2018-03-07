package com.facebook.dialtone;

import android.net.Uri;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.dialtone.common.DialtoneStateChangedListener;
import com.facebook.dialtone.protocol.DialtoneGraphQLModels.DialtonePhotoUnblockMutationModel;
import com.facebook.dialtone.protocol.DialtoneGraphQLModels.DialtonePhotoUnblockMutationModel.DialtonePhotoQuotaModel;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.ui.toaster.ToastBuilder;

/* compiled from: ] */
class DialtoneControllerImpl$1 extends AbstractDisposableFutureCallback<GraphQLResult<DialtonePhotoUnblockMutationModel>> {
    final /* synthetic */ DialtoneStateChangedListener f11796a;
    final /* synthetic */ Uri f11797b;
    final /* synthetic */ boolean f11798c;
    final /* synthetic */ DialtoneControllerImpl f11799d;

    DialtoneControllerImpl$1(DialtoneControllerImpl dialtoneControllerImpl, DialtoneStateChangedListener dialtoneStateChangedListener, Uri uri, boolean z) {
        this.f11799d = dialtoneControllerImpl;
        this.f11796a = dialtoneStateChangedListener;
        this.f11797b = uri;
        this.f11798c = z;
    }

    protected final void m19819a(Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (this.f11799d.w != null) {
            this.f11799d.w.a();
        }
        if (graphQLResult == null) {
            DialtoneControllerImpl.s(this.f11799d);
            return;
        }
        DialtonePhotoQuotaModel a = ((DialtonePhotoUnblockMutationModel) graphQLResult.e).m19901a();
        if (a == null) {
            DialtoneControllerImpl.s(this.f11799d);
            return;
        }
        ((DialtonePhotoCapController) this.f11799d.h.get()).a(a);
        DialtonePhotoCapController dialtonePhotoCapController = (DialtonePhotoCapController) this.f11799d.h.get();
        DialtoneStateChangedListener dialtoneStateChangedListener = this.f11796a;
        int i = 1;
        if (dialtonePhotoCapController.a(this.f11797b)) {
            dialtoneStateChangedListener.b_(false);
            dialtonePhotoCapController.d.b(new ToastBuilder(dialtonePhotoCapController.b.getResources().getQuantityString(2131689507, dialtonePhotoCapController.g, new Object[]{Integer.valueOf(dialtonePhotoCapController.g)})));
        } else {
            i = 0;
        }
        if (i == 0) {
            DialtoneControllerImpl.e(this.f11799d, "dialtone_photocapping_upgrade_dialog_impression");
            this.f11799d.a(this.f11798c);
            return;
        }
        DialtoneControllerImpl.e(this.f11799d, "dialtone_photocapping_image_reveal");
    }

    protected final void m19820a(Throwable th) {
        DialtoneControllerImpl.s(this.f11799d);
    }
}
