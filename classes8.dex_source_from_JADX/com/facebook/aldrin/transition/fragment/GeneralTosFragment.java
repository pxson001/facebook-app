package com.facebook.aldrin.transition.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.aldrin.service.FetchAldrinUserStatusClient;
import com.facebook.aldrin.status.AldrinUserStatus;
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
import javax.inject.Inject;

/* compiled from: last_action/ */
public class GeneralTosFragment extends AbstractNavigableFragment {
    @Inject
    public FetchAldrinUserStatusClient f10420b;
    @Inject
    public TosTransitionStateMachine f10421c;
    @Inject
    @ForegroundExecutorService
    public ExecutorService f10422d;
    @Inject
    public Toaster f10423e;
    public View f10424f;

    /* compiled from: last_action/ */
    class C11171 implements OnClickListener {
        final /* synthetic */ GeneralTosFragment f10418a;

        C11171(GeneralTosFragment generalTosFragment) {
            this.f10418a = generalTosFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 443731300);
            GeneralTosFragment generalTosFragment = this.f10418a;
            generalTosFragment.f10424f.setEnabled(false);
            Futures.a(generalTosFragment.f10420b.m12180a(CallerContext.a(generalTosFragment.getClass()), GraphQLTosRegionCodeEnum.GENERAL, RegionTosResponseAction.AGREED, "v1"), new C11182(generalTosFragment), generalTosFragment.f10422d);
            Logger.a(2, EntryType.UI_INPUT_END, -124290373, a);
        }
    }

    /* compiled from: last_action/ */
    public class C11182 implements FutureCallback<AldrinUserStatus> {
        final /* synthetic */ GeneralTosFragment f10419a;

        public C11182(GeneralTosFragment generalTosFragment) {
            this.f10419a = generalTosFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f10419a.ao().finish();
            this.f10419a.f10421c.m12202a(TosTransitionStateEvent.AGREED_TO_GENERAL_TOS);
        }

        public void onFailure(Throwable th) {
            this.f10419a.f10424f.setEnabled(true);
            this.f10419a.f10423e.a(new ToastBuilder(2131239885));
        }
    }

    public static void m12216a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        GeneralTosFragment generalTosFragment = (GeneralTosFragment) obj;
        FetchAldrinUserStatusClient b = FetchAldrinUserStatusClient.m12176b(injectorLike);
        TosTransitionStateMachine a = TosTransitionStateMachine.m12200a(injectorLike);
        ExecutorService executorService = (ExecutorService) ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike);
        Toaster b2 = Toaster.b(injectorLike);
        generalTosFragment.f10420b = b;
        generalTosFragment.f10421c = a;
        generalTosFragment.f10422d = executorService;
        generalTosFragment.f10423e = b2;
    }

    public final void m12219c(@javax.annotation.Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = GeneralTosFragment.class;
        m12216a((Object) this, getContext());
    }

    public final View m12217a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -948029106);
        View inflate = layoutInflater.inflate(2130904412, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -479145383, a);
        return inflate;
    }

    public final void m12218a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f10424f = FindViewUtil.b(view, 2131562124);
        this.f10424f.setOnClickListener(new C11171(this));
    }
}
