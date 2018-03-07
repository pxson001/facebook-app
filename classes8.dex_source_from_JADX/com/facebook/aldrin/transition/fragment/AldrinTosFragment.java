package com.facebook.aldrin.transition.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.aldrin.service.FetchAldrinUserStatusClient;
import com.facebook.aldrin.status.AldrinUserStatus;
import com.facebook.aldrin.status.AldrinUserStatusManager;
import com.facebook.aldrin.status.RegionTosResponseAction;
import com.facebook.aldrin.transition.TosTransitionStateEvent;
import com.facebook.aldrin.transition.TosTransitionStateMachine;
import com.facebook.base.fragment.AbstractNavigableFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForegroundExecutorService;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.util.FindViewUtil;
import com.facebook.graphql.enums.GraphQLTosRegionCodeEnum;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: last_application_id */
public class AldrinTosFragment extends AbstractNavigableFragment {
    @Inject
    public FetchAldrinUserStatusClient f10410b;
    @Inject
    AldrinUserStatusManager f10411c;
    @Inject
    public TosTransitionStateMachine f10412d;
    @Inject
    @ForegroundExecutorService
    public ExecutorService f10413e;
    @Inject
    Toaster f10414f;
    public AldrinUserStatus f10415g;
    public View f10416h;
    public View f10417i;

    /* compiled from: last_application_id */
    class C11141 implements OnClickListener {
        final /* synthetic */ AldrinTosFragment f10407a;

        C11141(AldrinTosFragment aldrinTosFragment) {
            this.f10407a = aldrinTosFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1269287819);
            AldrinTosFragment aldrinTosFragment = this.f10407a;
            aldrinTosFragment.f10416h.setEnabled(false);
            aldrinTosFragment.f10417i.setEnabled(false);
            Futures.a(aldrinTosFragment.f10410b.m12180a(CallerContext.a(aldrinTosFragment.getClass()), GraphQLTosRegionCodeEnum.ALDRIN, RegionTosResponseAction.AGREED, aldrinTosFragment.f10415g.tosVersion), new C11163(aldrinTosFragment), aldrinTosFragment.f10413e);
            Logger.a(2, EntryType.UI_INPUT_END, -541760115, a);
        }
    }

    /* compiled from: last_application_id */
    class C11152 implements OnClickListener {
        final /* synthetic */ AldrinTosFragment f10408a;

        C11152(AldrinTosFragment aldrinTosFragment) {
            this.f10408a = aldrinTosFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1277129927);
            AldrinTosFragment aldrinTosFragment = this.f10408a;
            aldrinTosFragment.f10410b.m12180a(CallerContext.a(aldrinTosFragment.getClass()), GraphQLTosRegionCodeEnum.ALDRIN, RegionTosResponseAction.DENIED, aldrinTosFragment.f10415g.tosVersion);
            aldrinTosFragment.f10412d.m12202a(TosTransitionStateEvent.DENIED_ALDRIN_TOS);
            Logger.a(2, EntryType.UI_INPUT_END, 1666515783, a);
        }
    }

    /* compiled from: last_application_id */
    public class C11163 implements FutureCallback<AldrinUserStatus> {
        final /* synthetic */ AldrinTosFragment f10409a;

        public C11163(AldrinTosFragment aldrinTosFragment) {
            this.f10409a = aldrinTosFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f10409a.ao().finish();
            this.f10409a.f10412d.m12202a(TosTransitionStateEvent.AGREED_TO_ALDRIN_TOS);
        }

        public void onFailure(Throwable th) {
            this.f10409a.f10416h.setEnabled(true);
            this.f10409a.f10417i.setEnabled(true);
            this.f10409a.f10414f.a(new ToastBuilder(2131239885));
        }
    }

    public static void m12212a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((AldrinTosFragment) obj).m12211a(FetchAldrinUserStatusClient.m12176b(injectorLike), AldrinUserStatusManager.a(injectorLike), TosTransitionStateMachine.m12200a(injectorLike), (ExecutorService) ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike), Toaster.b(injectorLike));
    }

    public final void m12215c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = AldrinTosFragment.class;
        m12212a((Object) this, getContext());
        this.f10415g = this.f10411c.d();
    }

    public final View m12213a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1855218778);
        View inflate = layoutInflater.inflate(2130904410, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 424088834, a);
        return inflate;
    }

    public final void m12214a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f10416h = FindViewUtil.b(view, 2131562119);
        this.f10417i = FindViewUtil.b(view, 2131562120);
        this.f10416h.setOnClickListener(new C11141(this));
        this.f10417i.setOnClickListener(new C11152(this));
    }

    private void m12211a(FetchAldrinUserStatusClient fetchAldrinUserStatusClient, AldrinUserStatusManager aldrinUserStatusManager, TosTransitionStateMachine tosTransitionStateMachine, ExecutorService executorService, Toaster toaster) {
        this.f10410b = fetchAldrinUserStatusClient;
        this.f10411c = aldrinUserStatusManager;
        this.f10412d = tosTransitionStateMachine;
        this.f10413e = executorService;
        this.f10414f = toaster;
    }
}
