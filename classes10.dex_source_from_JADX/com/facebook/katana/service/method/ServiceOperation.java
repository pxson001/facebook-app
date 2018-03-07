package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.facebook.debug.asserts.Assert;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: top_context_item */
public abstract class ServiceOperation {
    protected static final Handler f1186g = new Handler(Looper.getMainLooper());
    public final Context f1187h;
    public Intent f1188i;
    protected ServiceOperationListener f1189j;

    public abstract void mo46a();

    public abstract void mo49a(boolean z);

    public ServiceOperation(Context context, @Nullable Intent intent, @Nullable ServiceOperationListener serviceOperationListener) {
        this.f1187h = (Context) Preconditions.checkNotNull(context);
        this.f1188i = intent;
        this.f1189j = serviceOperationListener;
    }

    public final void m1211a(Intent intent, ServiceOperationListener serviceOperationListener) {
        boolean z = true;
        boolean z2 = this.f1188i == null && this.f1189j == null;
        Assert.a(z2);
        if (intent == null || serviceOperationListener == null) {
            z = false;
        }
        Assert.a(z);
        this.f1188i = intent;
        this.f1189j = serviceOperationListener;
    }

    protected void mo48a(ServiceOperation serviceOperation, int i, String str, @Nullable Exception exception) {
        this.f1189j.mo45a(serviceOperation, i, str, exception);
    }
}
