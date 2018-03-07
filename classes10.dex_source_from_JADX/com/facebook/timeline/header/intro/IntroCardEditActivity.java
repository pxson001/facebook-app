package com.facebook.timeline.header.intro;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.activitylistener.AbstractFbActivityListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.loadingindicator.LoadingIndicator.State;
import com.facebook.widget.loadingindicator.LoadingIndicatorState;
import com.facebook.widget.loadingindicator.LoadingIndicatorState.Builder;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: forever */
public abstract class IntroCardEditActivity<LoadedResultType> extends FbFragmentActivity {
    public TimelineLoadingFragment f11602p;
    public FutureAndCallbackHolder f11603q;
    @Inject
    public Lazy<FbErrorReporter> f11604s;
    @Inject
    @ForUiThread
    public Lazy<Executor> f11605t;

    /* compiled from: forever */
    class C16881 extends AbstractFbActivityListener {
        final /* synthetic */ IntroCardEditActivity f11819a;

        C16881(IntroCardEditActivity introCardEditActivity) {
            this.f11819a = introCardEditActivity;
        }

        public final boolean m11879i(Activity activity) {
            this.f11819a.mo540l();
            return super.i(activity);
        }
    }

    /* compiled from: forever */
    public class C16892 implements OnClickListener {
        final /* synthetic */ IntroCardEditActivity f11820a;

        public C16892(IntroCardEditActivity introCardEditActivity) {
            this.f11820a = introCardEditActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 426393884);
            this.f11820a.mo539k();
            this.f11820a.setResult(0);
            this.f11820a.finish();
            Logger.a(2, EntryType.UI_INPUT_END, 133596226, a);
        }
    }

    /* compiled from: forever */
    public class C16903 extends AbstractDisposableFutureCallback<LoadedResultType> {
        final /* synthetic */ IntroCardEditActivity f11821a;

        public C16903(IntroCardEditActivity introCardEditActivity) {
            this.f11821a = introCardEditActivity;
        }

        protected final void m11880a(LoadedResultType loadedResultType) {
            Bundle t = IntroCardEditActivity.m11630t(this.f11821a);
            if (this.f11821a.mo541m()) {
                this.f11821a.mo536c(t);
            }
            this.f11821a.mo534a((Object) loadedResultType, t);
            Fragment i = this.f11821a.mo537i();
            i.g(t);
            IntroCardEditActivity.m11626b(this.f11821a, i);
        }

        protected final void m11881a(Throwable th) {
            if (!(th instanceof IOException)) {
                ((AbstractFbErrorReporter) this.f11821a.f11604s.get()).a("load failed", th);
            }
            TimelineLoadingFragment timelineLoadingFragment = this.f11821a.f11602p;
            Builder newBuilder = LoadingIndicatorState.newBuilder();
            newBuilder.a = State.ERROR;
            newBuilder = newBuilder;
            newBuilder.b = timelineLoadingFragment.o().getString(2131230758);
            ((LoadingIndicatorView) timelineLoadingFragment.T).a(newBuilder.a(), null);
        }
    }

    public static void m11625a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        IntroCardEditActivity introCardEditActivity = (IntroCardEditActivity) obj;
        Lazy b = IdBasedSingletonScopeProvider.b(fbInjector, 494);
        Lazy b2 = IdBasedSingletonScopeProvider.b(fbInjector, 3863);
        introCardEditActivity.f11604s = b;
        introCardEditActivity.f11605t = b2;
    }

    protected abstract void mo534a(LoadedResultType loadedResultType, Bundle bundle);

    protected abstract void mo536c(Bundle bundle);

    protected abstract Fragment mo537i();

    public abstract int mo538j();

    protected abstract void mo539k();

    protected abstract void mo540l();

    protected abstract boolean mo541m();

    public abstract ListenableFuture<LoadedResultType> mo542n();

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        Class cls = IntroCardEditActivity.class;
        m11625a((Object) this, (Context) this);
    }

    protected void mo535b(@Nullable Bundle bundle) {
        super.b(bundle);
        setContentView(2130904965);
        FbTitleBarUtil.b(this);
        FbTitleBar fbTitleBar = (FbTitleBar) a(2131558563);
        fbTitleBar.setTitle(mo538j());
        fbTitleBar.a(new C16892(this));
        if (!m11628p()) {
            m11627o();
        }
        a(new C16881(this));
    }

    private void m11627o() {
        if (mo541m()) {
            this.f11602p = (TimelineLoadingFragment) m11629q();
            if (this.f11602p == null) {
                this.f11602p = new TimelineLoadingFragment();
            }
            ListenableFuture n = mo542n();
            C16903 c16903 = new C16903(this);
            Futures.a(n, c16903, (Executor) this.f11605t.get());
            this.f11603q = new FutureAndCallbackHolder(n, c16903);
            m11626b(this, this.f11602p);
            return;
        }
        Fragment i = mo537i();
        i.g(m11630t(this));
        m11626b(this, i);
    }

    public static void m11626b(IntroCardEditActivity introCardEditActivity, Fragment fragment) {
        introCardEditActivity.kO_().a().a(2131558429, fragment).c();
    }

    private boolean m11628p() {
        Fragment q = m11629q();
        return (q == null || (q instanceof TimelineLoadingFragment)) ? false : true;
    }

    private Fragment m11629q() {
        return kO_().a(2131558429);
    }

    public static Bundle m11630t(IntroCardEditActivity introCardEditActivity) {
        return introCardEditActivity.getIntent().getExtras() != null ? new Bundle(introCardEditActivity.getIntent().getExtras()) : new Bundle();
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1697860000);
        super.onDestroy();
        if (this.f11603q != null) {
            this.f11603q.a(true);
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1057402973, a);
    }
}
