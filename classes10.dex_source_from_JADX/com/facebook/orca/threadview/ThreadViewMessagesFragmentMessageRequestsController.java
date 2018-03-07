package com.facebook.orca.threadview;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.internal.widget.ViewStubCompat;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.TriState;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.messagerequests.experiment.MessageRequestsExperimentController;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.mutators.DeleteThreadDialogFragment;
import com.facebook.messaging.mutators.DeleteThreadDialogParams;
import com.facebook.messaging.mutators.DeleteThreadDialogParams.Builder;
import com.facebook.messaging.service.model.AcceptMessageRequestsParams;
import com.facebook.messaging.service.model.IgnoreMessageRequestsParams;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.C11592;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.ViewStubHolder.OnInflateListener;
import com.facebook.widget.bottomsheet.BottomSheetAdapter;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: member_remove_attempt */
public class ThreadViewMessagesFragmentMessageRequestsController {
    public final AnalyticsLogger f7849a;
    private final DefaultBlueServiceOperationFactory f7850b;
    private final Provider<BottomSheetDialog> f7851c;
    private final Context f7852d;
    private final ErrorDialogs f7853e;
    private final FragmentManager f7854f;
    private final Resources f7855g;
    private final Executor f7856h;
    private ViewStubHolder<View> f7857i;
    private BottomSheetDialog f7858j;
    private BottomSheetAdapter f7859k;
    public boolean f7860l = false;
    public ThreadSummary f7861m;
    public C11592 f7862n;

    /* compiled from: member_remove_attempt */
    class C11801 implements OnInflateListener<View> {
        final /* synthetic */ ThreadViewMessagesFragmentMessageRequestsController f7841a;

        C11801(ThreadViewMessagesFragmentMessageRequestsController threadViewMessagesFragmentMessageRequestsController) {
            this.f7841a = threadViewMessagesFragmentMessageRequestsController;
        }

        public final void m7769a(View view) {
            this.f7841a.f7861m;
        }
    }

    /* compiled from: member_remove_attempt */
    class C11812 implements OnClickListener {
        final /* synthetic */ ThreadViewMessagesFragmentMessageRequestsController f7842a;

        C11812(ThreadViewMessagesFragmentMessageRequestsController threadViewMessagesFragmentMessageRequestsController) {
            this.f7842a = threadViewMessagesFragmentMessageRequestsController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -550627136);
            ThreadViewMessagesFragmentMessageRequestsController.m7795i(this.f7842a);
            Logger.a(2, EntryType.UI_INPUT_END, -1659639167, a);
        }
    }

    /* compiled from: member_remove_attempt */
    class C11823 implements OnClickListener {
        final /* synthetic */ ThreadViewMessagesFragmentMessageRequestsController f7843a;

        C11823(ThreadViewMessagesFragmentMessageRequestsController threadViewMessagesFragmentMessageRequestsController) {
            this.f7843a = threadViewMessagesFragmentMessageRequestsController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1370214687);
            this.f7843a.m7791g();
            Logger.a(2, EntryType.UI_INPUT_END, -1113167231, a);
        }
    }

    /* compiled from: member_remove_attempt */
    class C11834 extends OperationResultFutureCallback {
        final /* synthetic */ ThreadViewMessagesFragmentMessageRequestsController f7844a;

        C11834(ThreadViewMessagesFragmentMessageRequestsController threadViewMessagesFragmentMessageRequestsController) {
            this.f7844a = threadViewMessagesFragmentMessageRequestsController;
        }

        protected final void m7771a(Object obj) {
            this.f7844a.f7860l = true;
        }

        protected final void m7770a(ServiceException serviceException) {
            this.f7844a.m7776a(serviceException);
        }
    }

    /* compiled from: member_remove_attempt */
    class C11845 implements OnMenuItemClickListener {
        final /* synthetic */ ThreadViewMessagesFragmentMessageRequestsController f7845a;

        C11845(ThreadViewMessagesFragmentMessageRequestsController threadViewMessagesFragmentMessageRequestsController) {
            this.f7845a = threadViewMessagesFragmentMessageRequestsController;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            ThreadViewMessagesFragmentMessageRequestsController.m7797k(this.f7845a);
            return true;
        }
    }

    /* compiled from: member_remove_attempt */
    public class C11856 {
        final /* synthetic */ ThreadViewMessagesFragmentMessageRequestsController f7846a;

        C11856(ThreadViewMessagesFragmentMessageRequestsController threadViewMessagesFragmentMessageRequestsController) {
            this.f7846a = threadViewMessagesFragmentMessageRequestsController;
        }

        public final void m7772a() {
            this.f7846a.f7849a.a(new HoneyClientEvent("core_graph_delete_request").a("thread_fbid", this.f7846a.f7861m.a.i()));
        }
    }

    /* compiled from: member_remove_attempt */
    class C11867 implements OnClickListener {
        final /* synthetic */ ThreadViewMessagesFragmentMessageRequestsController f7847a;

        C11867(ThreadViewMessagesFragmentMessageRequestsController threadViewMessagesFragmentMessageRequestsController) {
            this.f7847a = threadViewMessagesFragmentMessageRequestsController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1985898418);
            this.f7847a.f7849a.a(new HoneyClientEvent("core_graph_accept_request").a("thread_fbid", this.f7847a.f7861m.a.i()));
            ThreadViewMessagesFragmentMessageRequestsController.m7800n(this.f7847a);
            Logger.a(2, EntryType.UI_INPUT_END, -1773299018, a);
        }
    }

    /* compiled from: member_remove_attempt */
    class C11878 extends OperationResultFutureCallback {
        final /* synthetic */ ThreadViewMessagesFragmentMessageRequestsController f7848a;

        C11878(ThreadViewMessagesFragmentMessageRequestsController threadViewMessagesFragmentMessageRequestsController) {
            this.f7848a = threadViewMessagesFragmentMessageRequestsController;
        }

        protected final void m7774a(Object obj) {
            this.f7848a.f7860l = true;
            ThreadViewMessagesFragmentMessageRequestsController.m7801o(this.f7848a);
        }

        protected final void m7773a(ServiceException serviceException) {
            this.f7848a.m7776a(serviceException);
        }
    }

    @Inject
    public ThreadViewMessagesFragmentMessageRequestsController(AnalyticsLogger analyticsLogger, BlueServiceOperationFactory blueServiceOperationFactory, Provider<BottomSheetDialog> provider, Context context, ErrorDialogs errorDialogs, @Assisted FragmentManager fragmentManager, MessageRequestsExperimentController messageRequestsExperimentController, Resources resources, Executor executor) {
        this.f7849a = analyticsLogger;
        this.f7850b = blueServiceOperationFactory;
        this.f7851c = provider;
        this.f7852d = context;
        this.f7853e = errorDialogs;
        this.f7854f = fragmentManager;
        this.f7855g = resources;
        this.f7856h = executor;
    }

    public final boolean m7808a() {
        return this.f7857i.d();
    }

    private boolean m7784c() {
        return this.f7861m != null && this.f7861m.A.isMessageRequestFolders();
    }

    private boolean m7786d() {
        return this.f7861m != null && this.f7861m.A == FolderName.OTHER;
    }

    public final void m7805a(ViewStubCompat viewStubCompat) {
        this.f7857i = ViewStubHolder.a(viewStubCompat);
        this.f7857i.c = new C11801(this);
    }

    public static void m7788e(ThreadViewMessagesFragmentMessageRequestsController threadViewMessagesFragmentMessageRequestsController) {
        threadViewMessagesFragmentMessageRequestsController.m7790f();
        threadViewMessagesFragmentMessageRequestsController.m7799m();
    }

    private void m7790f() {
        TextView textView = (TextView) this.f7857i.a().findViewById(2131564940);
        if (m7786d()) {
            m7775a(textView);
        } else {
            m7780b(textView);
        }
    }

    private void m7775a(TextView textView) {
        textView.setText(this.f7855g.getString(2131231784));
        textView.setOnClickListener(new C11812(this));
    }

    private void m7780b(TextView textView) {
        textView.setText(this.f7855g.getString(2131231782));
        textView.setOnClickListener(new C11823(this));
    }

    private void m7791g() {
        this.f7849a.a(new HoneyClientEvent("core_graph_ignore_request").a("thread_fbid", this.f7861m.a.i()));
        m7793h();
    }

    private void m7793h() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(IgnoreMessageRequestsParams.a, new IgnoreMessageRequestsParams(ImmutableList.of(Long.valueOf(this.f7861m.a.i()))));
        Futures.a(BlueServiceOperationFactoryDetour.a(this.f7850b, "message_ignore_requests", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(getClass()), -1522598502).a(new DialogBasedProgressIndicator(this.f7852d, this.f7855g.getString(2131240846))).a(), new C11834(this), this.f7856h);
    }

    public static void m7795i(ThreadViewMessagesFragmentMessageRequestsController threadViewMessagesFragmentMessageRequestsController) {
        threadViewMessagesFragmentMessageRequestsController.f7858j = (BottomSheetDialog) threadViewMessagesFragmentMessageRequestsController.f7851c.get();
        threadViewMessagesFragmentMessageRequestsController.m7796j();
        threadViewMessagesFragmentMessageRequestsController.f7858j.a(threadViewMessagesFragmentMessageRequestsController.f7859k);
        threadViewMessagesFragmentMessageRequestsController.f7858j.show();
    }

    private void m7796j() {
        if (this.f7859k == null) {
            this.f7859k = new BottomSheetAdapter(this.f7852d);
            this.f7859k.e(2131240834).setIcon(2130841363).setOnMenuItemClickListener(new C11845(this));
        }
    }

    public static void m7797k(ThreadViewMessagesFragmentMessageRequestsController threadViewMessagesFragmentMessageRequestsController) {
        DeleteThreadDialogFragment a = DeleteThreadDialogFragment.m3235a(threadViewMessagesFragmentMessageRequestsController.m7798l());
        a.ax = new C11856(threadViewMessagesFragmentMessageRequestsController);
        a.a(threadViewMessagesFragmentMessageRequestsController.f7854f, "delete_message_request_dialog");
    }

    private DeleteThreadDialogParams m7798l() {
        ImmutableList of = ImmutableList.of(this.f7861m.a);
        Builder builder = new Builder();
        builder.f3320a = of;
        builder = builder;
        builder.f3321b = this.f7855g.getQuantityString(2131689774, of.size());
        Builder builder2 = builder;
        builder2.f3322c = this.f7855g.getString(2131240840);
        builder2 = builder2;
        builder2.f3323d = this.f7855g.getString(2131240834);
        return builder2.m3239a();
    }

    private void m7799m() {
        ((TextView) this.f7857i.a().findViewById(2131564941)).setOnClickListener(new C11867(this));
    }

    public static void m7800n(ThreadViewMessagesFragmentMessageRequestsController threadViewMessagesFragmentMessageRequestsController) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(AcceptMessageRequestsParams.a, new AcceptMessageRequestsParams(ImmutableList.of(Long.valueOf(threadViewMessagesFragmentMessageRequestsController.f7861m.a.i()))));
        Futures.a(BlueServiceOperationFactoryDetour.a(threadViewMessagesFragmentMessageRequestsController.f7850b, "message_accept_requests", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(threadViewMessagesFragmentMessageRequestsController.getClass()), -1927105996).a(new DialogBasedProgressIndicator(threadViewMessagesFragmentMessageRequestsController.f7852d, threadViewMessagesFragmentMessageRequestsController.f7855g.getString(2131240845))).a(), new C11878(threadViewMessagesFragmentMessageRequestsController), threadViewMessagesFragmentMessageRequestsController.f7856h);
    }

    public static void m7801o(ThreadViewMessagesFragmentMessageRequestsController threadViewMessagesFragmentMessageRequestsController) {
        threadViewMessagesFragmentMessageRequestsController.m7804r();
        threadViewMessagesFragmentMessageRequestsController.f7857i.a().setAnimation(AnimationUtils.loadAnimation(threadViewMessagesFragmentMessageRequestsController.f7852d, 2130968686));
        if (threadViewMessagesFragmentMessageRequestsController.f7862n != null) {
            threadViewMessagesFragmentMessageRequestsController.f7862n.m7460a();
        }
    }

    private void m7776a(ServiceException serviceException) {
        ErrorDialogs errorDialogs = this.f7853e;
        ErrorDialogParamsBuilder a = ErrorDialogParams.a(this.f7852d).a(2131230721);
        a.f = serviceException;
        errorDialogs.a(a.l());
    }

    public final void m7807a(ThreadSummary threadSummary) {
        if (m7782b(threadSummary)) {
            this.f7861m = threadSummary;
            this.f7860l = false;
            this.f7861m;
            m7802p();
        }
    }

    private boolean m7782b(ThreadSummary threadSummary) {
        return this.f7861m == null || threadSummary == null || !Objects.equal(this.f7861m.a, threadSummary.a);
    }

    private void m7802p() {
        if (this.f7858j != null && this.f7858j.isShowing()) {
            this.f7858j.dismiss();
        }
    }

    public final boolean m7809b() {
        return m7784c() && !this.f7860l;
    }

    public final void m7806a(TriState triState) {
        if (!m7809b() || triState == TriState.NO) {
            m7804r();
        } else {
            m7803q();
        }
    }

    private void m7803q() {
        if (this.f7861m != null) {
            this.f7857i.f();
        }
    }

    private void m7804r() {
        this.f7857i.e();
    }
}
