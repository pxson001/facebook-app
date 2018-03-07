package com.facebook.orca.threadview;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.contacts.server.AddContactParams;
import com.facebook.contacts.server.AddContactResult;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.Operation;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.orca.threadview.AutoContactAddController.C10253;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: multiway_call_thread_view_button */
public class AddToContactListHelper {
    private final DefaultBlueServiceOperationFactory f6790a;
    private final ExecutorService f6791b;
    @Nullable
    public C10253 f6792c;

    /* compiled from: multiway_call_thread_view_button */
    class C10171 extends OperationResultFutureCallback {
        final /* synthetic */ AddToContactListHelper f6789a;

        C10171(AddToContactListHelper addToContactListHelper) {
            this.f6789a = addToContactListHelper;
        }

        protected final void m6464a(Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (this.f6789a.f6792c != null) {
                AddContactResult addContactResult = (AddContactResult) operationResult.h();
                C10253 c10253 = this.f6789a.f6792c;
                c10253.f6860a.f6869h = addContactResult.a;
                c10253.f6860a.f6864c.edit().putBoolean(AutoContactAddController.m6510c(c10253.f6860a.f6869h.c()), true).commit();
            }
        }

        protected final void m6463a(ServiceException serviceException) {
        }
    }

    public final void m6465a(Context context, String str, boolean z) {
        Parcelable addContactParams = new AddContactParams(str, null);
        Bundle bundle = new Bundle();
        bundle.putParcelable("addContactParams", addContactParams);
        Operation a = BlueServiceOperationFactoryDetour.a(this.f6790a, "add_contact_by_phone_number", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(context), 976819838);
        if (z) {
            a.a(new DialogBasedProgressIndicator(context, 2131231798));
        }
        Futures.a(a.a(), new C10171(this), this.f6791b);
    }

    @Inject
    public AddToContactListHelper(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ExecutorService executorService) {
        this.f6790a = defaultBlueServiceOperationFactory;
        this.f6791b = executorService;
    }
}
