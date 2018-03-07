package com.facebook.aldrin.transition.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.aldrin.transition.TosTransitionStateEvent;
import com.facebook.aldrin.transition.TosTransitionStateMachine;
import com.facebook.base.fragment.AbstractNavigableFragment;
import com.facebook.common.util.FindViewUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.dbl.FbAndroidAuthActivityUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

/* compiled from: last_article */
public class AldrinTosDeclinedFragment extends AbstractNavigableFragment implements OnClickListener {
    @Inject
    public SecureContextHelper f10404b;
    @Inject
    public TosTransitionStateMachine f10405c;
    @Inject
    public FbAndroidAuthActivityUtil f10406d;

    public static void m12207a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        AldrinTosDeclinedFragment aldrinTosDeclinedFragment = (AldrinTosDeclinedFragment) obj;
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike);
        TosTransitionStateMachine a = TosTransitionStateMachine.m12200a(injectorLike);
        FbAndroidAuthActivityUtil b = FbAndroidAuthActivityUtil.b(injectorLike);
        aldrinTosDeclinedFragment.f10404b = secureContextHelper;
        aldrinTosDeclinedFragment.f10405c = a;
        aldrinTosDeclinedFragment.f10406d = b;
    }

    public final void m12210c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = AldrinTosDeclinedFragment.class;
        m12207a((Object) this, getContext());
    }

    public final View m12208a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -13372714);
        View inflate = layoutInflater.inflate(2130904411, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1357296353, a);
        return inflate;
    }

    public final void m12209a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        FindViewUtil.b(view, 2131562121).setOnClickListener(this);
        FindViewUtil.b(view, 2131562122).setOnClickListener(this);
        FindViewUtil.b(view, 2131562123).setOnClickListener(this);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1220133181);
        int id = view.getId();
        if (id == 2131562123) {
            this.f10405c.m12202a(TosTransitionStateEvent.GO_BACK);
        } else if (id == 2131562122) {
            this.f10406d.a(getContext());
        } else if (id == 2131562121) {
            Context context = getContext();
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.setFlags(268435456);
            this.f10404b.b(intent, context);
        }
        LogUtils.a(-1468482291, a);
    }
}
