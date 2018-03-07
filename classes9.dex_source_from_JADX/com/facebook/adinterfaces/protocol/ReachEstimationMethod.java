package com.facebook.adinterfaces.protocol;

import android.content.Context;
import com.facebook.adinterfaces.MapAreaPickerActivity.C25004;
import com.facebook.adinterfaces.protocol.ReachEstimateDataQueryModels.ReachEstimateQueryModel;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Video Home badge count query succeeded but result was null. */
public class ReachEstimationMethod {
    private static ReachEstimationMethod f22408c;
    private static final Object f22409d = new Object();
    public final GraphQLQueryExecutor f22410a;
    public final TasksManager f22411b;

    /* compiled from: Video Home badge count query succeeded but result was null. */
    public class C25521 extends AbstractDisposableFutureCallback<GraphQLResult<ReachEstimateQueryModel>> {
        final /* synthetic */ C25004 f22406a;
        final /* synthetic */ ReachEstimationMethod f22407b;

        public C25521(ReachEstimationMethod reachEstimationMethod, C25004 c25004) {
            this.f22407b = reachEstimationMethod;
            this.f22406a = c25004;
        }

        protected final void m24264a(Object obj) {
            ReachEstimateQueryModel reachEstimateQueryModel = (ReachEstimateQueryModel) ((GraphQLResult) obj).e;
            C25004 c25004 = this.f22406a;
            int a = (reachEstimateQueryModel == null || reachEstimateQueryModel.m24257a() == null) ? -1 : reachEstimateQueryModel.m24257a().m24250a();
            c25004.m22535a(a);
        }

        protected final void m24265a(Throwable th) {
            this.f22406a.m22535a(-1);
        }
    }

    /* compiled from: Video Home badge count query succeeded but result was null. */
    public enum Tasks {
        REACH_TASK
    }

    private static ReachEstimationMethod m24267b(InjectorLike injectorLike) {
        return new ReachEstimationMethod(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public ReachEstimationMethod(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f22410a = graphQLQueryExecutor;
        this.f22411b = tasksManager;
    }

    public static ReachEstimationMethod m24266a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReachEstimationMethod b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22409d) {
                ReachEstimationMethod reachEstimationMethod;
                if (a2 != null) {
                    reachEstimationMethod = (ReachEstimationMethod) a2.a(f22409d);
                } else {
                    reachEstimationMethod = f22408c;
                }
                if (reachEstimationMethod == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24267b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22409d, b3);
                        } else {
                            f22408c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reachEstimationMethod;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m24268a() {
        this.f22411b.c(Tasks.REACH_TASK);
    }
}
