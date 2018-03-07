package com.facebook.aldrin.transition.activity;

import android.content.Context;
import android.os.Bundle;
import com.facebook.aldrin.transition.AldrinTransitionLauncher;
import com.facebook.aldrin.transition.TosTransitionStateEvent;
import com.facebook.aldrin.transition.TosTransitionStateMachine;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: last_article_debug_info */
public class AldrinTransitionActivity extends FbFragmentActivity {
    @Inject
    AldrinTransitionLauncher f10402p;
    @Inject
    TosTransitionStateMachine f10403q;

    private static <T extends Context> void m12204a(Class<T> cls, T t) {
        m12205a((Object) t, (Context) t);
    }

    public static void m12205a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((AldrinTransitionActivity) obj).m12203a(AldrinTransitionLauncher.m12188a(injectorLike), TosTransitionStateMachine.m12200a(injectorLike));
    }

    protected final void m12206b(@Nullable Bundle bundle) {
        super.b(bundle);
        setContentView(2130903085);
        Class cls = AldrinTransitionActivity.class;
        m12205a((Object) this, (Context) this);
        if (!this.f10402p.m12191a()) {
            finish();
        }
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1317906255);
        super.onResume();
        if (this.f10402p.m12191a()) {
            this.f10402p.f10393e = true;
        } else {
            finish();
        }
        LogUtils.c(1937216846, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 2145270804);
        super.onPause();
        this.f10402p.f10393e = false;
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 696728802, a);
    }

    protected void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -56294024);
        super.onStop();
        this.f10402p.f10393e = false;
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -2136028339, a);
    }

    public void onBackPressed() {
        this.f10403q.m12202a(TosTransitionStateEvent.GO_BACK);
    }

    private void m12203a(AldrinTransitionLauncher aldrinTransitionLauncher, TosTransitionStateMachine tosTransitionStateMachine) {
        this.f10402p = aldrinTransitionLauncher;
        this.f10403q = tosTransitionStateMachine;
    }
}
