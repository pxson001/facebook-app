package com.facebook.auth.module;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.viewercontext.PushedViewerContext;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.activitylistener.AbstractFbActivityListener;
import com.facebook.inject.FbInjector;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

/* compiled from: user attribute */
public class ViewerContextManagerImpl implements ViewerContextManager {
    public final LoggedInUserSessionManager f1490a;
    private final Context f1491b;
    private ViewerContext f1492c;
    public ThreadLocal<List<ViewerContext>> f1493d = new C01081(this);
    public ViewerContext f1494e;

    /* compiled from: user attribute */
    class C01081 extends ThreadLocal<List<ViewerContext>> {
        final /* synthetic */ ViewerContextManagerImpl f1495a;

        C01081(ViewerContextManagerImpl viewerContextManagerImpl) {
            this.f1495a = viewerContextManagerImpl;
        }

        protected Object initialValue() {
            return Lists.m1296a();
        }
    }

    /* compiled from: user attribute */
    public class MyListener extends AbstractFbActivityListener {
        public final void mo255b(Activity activity, @Nullable Bundle bundle) {
            super.mo255b(activity, bundle);
            ViewerContext viewerContext = (ViewerContext) activity.getIntent().getParcelableExtra("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT");
            if (viewerContext != null) {
                ViewerContextManagerProvider.m2496b(FbInjector.get(activity)).mo213a(viewerContext);
            }
        }
    }

    public ViewerContextManagerImpl(LoggedInUserSessionManager loggedInUserSessionManager, Context context) {
        this.f1490a = loggedInUserSessionManager;
        this.f1491b = context;
    }

    public final ViewerContext mo212a() {
        return this.f1490a.m2517a();
    }

    @Nullable
    public final ViewerContext mo215b() {
        return this.f1494e;
    }

    public final ViewerContext mo216c() {
        return this.f1492c;
    }

    public final void mo213a(ViewerContext viewerContext) {
        Preconditions.checkState(!(this.f1491b instanceof Application), "Cannot override viewer context on the application context");
        this.f1494e = viewerContext;
    }

    public final ViewerContext mo218e() {
        ViewerContext d = mo217d();
        if (d == mo212a()) {
            return null;
        }
        return d;
    }

    public final ViewerContext mo217d() {
        ViewerContext viewerContext;
        List list = (List) this.f1493d.get();
        if (!list.isEmpty()) {
            viewerContext = (ViewerContext) list.get(list.size() - 1);
        } else if (this.f1494e != null) {
            viewerContext = this.f1494e;
        } else {
            viewerContext = this.f1490a.m2517a();
        }
        ViewerContext viewerContext2 = viewerContext;
        if (this.f1492c == null) {
            this.f1492c = viewerContext2;
        }
        return viewerContext2;
    }

    public final PushedViewerContext mo214b(ViewerContext viewerContext) {
        if (viewerContext == null) {
            return PushedViewerContext.f14985a;
        }
        ((List) this.f1493d.get()).add(viewerContext);
        return new 2(this, viewerContext);
    }

    public final void mo219f() {
        List list = (List) this.f1493d.get();
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        list.remove(list.size() - 1);
    }
}
