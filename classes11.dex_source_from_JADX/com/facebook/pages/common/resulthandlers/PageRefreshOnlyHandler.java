package com.facebook.pages.common.resulthandlers;

import android.content.Intent;
import com.facebook.base.fragment.FbFragment;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.pages.common.resulthandlers.interfaces.ActivityResultHandler;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* compiled from: save_successful */
public class PageRefreshOnlyHandler implements ActivityResultHandler {
    public final void mo47a(OperationResult operationResult) {
    }

    public final void mo48a(ServiceException serviceException) {
    }

    public final boolean mo50c() {
        return true;
    }

    public final ImmutableList<Integer> mo51d() {
        return ImmutableList.of(Integer.valueOf(10112), Integer.valueOf(10113));
    }

    public final DialogBasedProgressIndicator mo45a() {
        return null;
    }

    public final boolean mo49b() {
        return true;
    }

    public final ListenableFuture<OperationResult> mo46a(long j, @Nullable ProfilePermissions profilePermissions, FbFragment fbFragment, Intent intent, int i) {
        return Futures.a(OperationResult.a);
    }
}
