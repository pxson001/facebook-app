package com.facebook.composer.shareintent.util;

import com.facebook.runtimepermissions.AbstractRuntimePermissionsListener;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.toaster.ToastBuilder;
import com.google.common.util.concurrent.SettableFuture;

/* compiled from: contacts_upload */
public class AbstractShareIntentHandler$3 extends AbstractRuntimePermissionsListener {
    final /* synthetic */ SettableFuture f16873a;
    final /* synthetic */ AbstractShareIntentHandler f16874b;

    public AbstractShareIntentHandler$3(AbstractShareIntentHandler abstractShareIntentHandler, SettableFuture settableFuture) {
        this.f16874b = abstractShareIntentHandler;
        this.f16873a = settableFuture;
    }

    public final void m20849a() {
        FutureDetour.a(this.f16873a, null, 136067111);
    }

    public final void m20850a(String[] strArr, String[] strArr2) {
        this.f16874b.q.b(new ToastBuilder(this.f16874b.getResources().getString(2131234781)));
        this.f16873a.a(new SecurityException("Permission denied"));
    }
}
