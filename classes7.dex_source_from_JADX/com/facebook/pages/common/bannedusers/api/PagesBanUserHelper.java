package com.facebook.pages.common.bannedusers.api;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.friends.protocol.BlockUserMethod.Params;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: message_received */
public class PagesBanUserHelper {
    public static final CallerContext f9100a = CallerContext.a(PagesBanUserHelper.class);
    public final Context f9101b;
    public final DefaultBlueServiceOperationFactory f9102c;
    private final TasksManager f9103d;
    public final ViewerContext f9104e;
    @LoggedInUserId
    public final String f9105f;
    public final Toaster f9106g;

    /* compiled from: message_received */
    public class C07351 implements OnClickListener {
        final /* synthetic */ String f9089a;
        final /* synthetic */ String f9090b;
        final /* synthetic */ Runnable f9091c;
        final /* synthetic */ PagesBanUserHelper f9092d;

        public C07351(PagesBanUserHelper pagesBanUserHelper, String str, String str2, Runnable runnable) {
            this.f9092d = pagesBanUserHelper;
            this.f9089a = str;
            this.f9090b = str2;
            this.f9091c = runnable;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Preconditions.checkArgument(this.f9092d.f9104e.mIsPageContext);
            PagesBanUserHelper.m10912a(this.f9092d, this.f9092d.f9104e.mUserId, this.f9089a, this.f9090b, this.f9091c);
        }
    }

    @Inject
    public PagesBanUserHelper(Context context, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, TasksManager tasksManager, ViewerContext viewerContext, String str, Toaster toaster) {
        this.f9101b = context;
        this.f9102c = defaultBlueServiceOperationFactory;
        this.f9103d = tasksManager;
        this.f9104e = viewerContext;
        this.f9105f = str;
        this.f9106g = toaster;
    }

    public static void m10912a(PagesBanUserHelper pagesBanUserHelper, String str, String str2, final String str3, final Runnable runnable) {
        final ProgressDialog progressDialog = new ProgressDialog(pagesBanUserHelper.f9101b);
        progressDialog.a(pagesBanUserHelper.f9101b.getResources().getString(2131233257));
        progressDialog.show();
        final Bundle bundle = new Bundle();
        bundle.putParcelable("blockUser", new Params(Long.parseLong(str), Long.parseLong(str2)));
        final String str4 = "friending_block_user";
        pagesBanUserHelper.f9103d.a("ban_user_" + str2 + "_from_" + str, new Callable<ListenableFuture>(pagesBanUserHelper) {
            final /* synthetic */ PagesBanUserHelper f9099c;

            public Object call() {
                return BlueServiceOperationFactoryDetour.a(this.f9099c.f9102c, str4, bundle, ErrorPropagation.BY_EXCEPTION, PagesBanUserHelper.f9100a, -2119217501).a();
            }
        }, new OperationResultFutureCallback(pagesBanUserHelper) {
            final /* synthetic */ PagesBanUserHelper f9096d;

            public final void m10910a(ServiceException serviceException) {
                progressDialog.dismiss();
            }

            public final void m10911a(Object obj) {
                progressDialog.dismiss();
                this.f9096d.f9106g.b(new ToastBuilder(2131233258, new Object[]{str3}));
                runnable.run();
            }
        });
    }
}
