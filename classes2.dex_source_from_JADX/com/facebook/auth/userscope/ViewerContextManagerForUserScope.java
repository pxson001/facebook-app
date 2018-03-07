package com.facebook.auth.userscope;

import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.viewercontext.PushedViewerContext;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

/* compiled from: place_id */
public class ViewerContextManagerForUserScope implements ViewerContextManager {
    private static final Class<?> f9816a = ViewerContextManagerForUserScope.class;
    private final LoggedInUserSessionManager f9817b;
    private final ViewerContext f9818c;
    private final String f9819d;
    private ThreadLocal<List<ViewerContext>> f9820e = new C04131(this);

    /* compiled from: place_id */
    class C04131 extends ThreadLocal<List<ViewerContext>> {
        final /* synthetic */ ViewerContextManagerForUserScope f9821a;

        C04131(ViewerContextManagerForUserScope viewerContextManagerForUserScope) {
            this.f9821a = viewerContextManagerForUserScope;
        }

        protected Object initialValue() {
            return Lists.m1296a();
        }
    }

    public ViewerContextManagerForUserScope(LoggedInUserSessionManager loggedInUserSessionManager, ViewerContext viewerContext) {
        this.f9817b = loggedInUserSessionManager;
        if (viewerContext == null) {
            viewerContext = EmptyViewerContextManager.f763a;
        }
        this.f9818c = viewerContext;
        if (loggedInUserSessionManager.m2517a() != null) {
            this.f9819d = loggedInUserSessionManager.m2517a().mUserId;
        } else {
            this.f9819d = this.f9818c.mUserId;
        }
    }

    public final ViewerContext mo212a() {
        return this.f9817b.m2517a();
    }

    @Nullable
    public final ViewerContext mo215b() {
        if (Objects.equal(this.f9818c.mUserId, this.f9819d)) {
            return null;
        }
        return this.f9818c;
    }

    public final ViewerContext mo216c() {
        throw new UnsupportedOperationException();
    }

    public final void mo213a(ViewerContext viewerContext) {
        throw new UnsupportedOperationException();
    }

    public final ViewerContext mo217d() {
        List list = (List) this.f9820e.get();
        if (!list.isEmpty()) {
            return (ViewerContext) list.get(list.size() - 1);
        }
        if (!Objects.equal(this.f9818c.mUserId, this.f9819d)) {
            return this.f9818c;
        }
        ViewerContext a = this.f9817b.m2517a();
        if (a == null) {
            Boolean.valueOf(this.f9817b.m2522b());
            return this.f9818c;
        } else if (Objects.equal(a.mUserId, this.f9819d)) {
            return a;
        } else {
            String str = a.mUserId;
            Boolean.valueOf(this.f9817b.m2522b());
            return this.f9818c;
        }
    }

    public final ViewerContext mo218e() {
        return mo217d();
    }

    public final PushedViewerContext mo214b(ViewerContext viewerContext) {
        if (viewerContext == null) {
            return PushedViewerContext.f14985a;
        }
        ((List) this.f9820e.get()).add(viewerContext);
        return new 2(this, viewerContext);
    }

    public final void mo219f() {
        List list = (List) this.f9820e.get();
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        list.remove(list.size() - 1);
    }
}
