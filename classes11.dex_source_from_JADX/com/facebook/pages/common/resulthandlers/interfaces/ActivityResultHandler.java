package com.facebook.pages.common.resulthandlers.interfaces;

import android.content.Intent;
import com.facebook.base.fragment.FbFragment;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.ipc.pages.ProfilePermissions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* compiled from: saved_reminders */
public interface ActivityResultHandler {
    DialogBasedProgressIndicator mo45a();

    ListenableFuture<OperationResult> mo46a(long j, @Nullable ProfilePermissions profilePermissions, FbFragment fbFragment, Intent intent, int i);

    void mo47a(OperationResult operationResult);

    void mo48a(ServiceException serviceException);

    boolean mo49b();

    boolean mo50c();

    ImmutableList<Integer> mo51d();
}
