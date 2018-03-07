package com.facebook.localcontent.menus.structured;

import android.content.Context;
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
import com.facebook.localcontent.menus.structured.list.StructuredMenuListAdapter;
import com.facebook.localcontent.menus.structured.list.StructuredMenuListSection;
import com.facebook.localcontent.protocol.graphql.FetchStructuredMenuListModels.StructuredMenuListDataModel;
import com.facebook.localcontent.protocol.graphql.FetchStructuredMenuListModels.StructuredMenuListDataModel.MenuSubListModel.NodesModel;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: e2c11b17824270dbfa4f6a989b19dc62 */
public class StructuredMenuListLoader {
    private static StructuredMenuListLoader f15124c;
    private static final Object f15125d = new Object();
    public final GraphQLQueryExecutor f15126a;
    public final TasksManager<String> f15127b;

    /* compiled from: e2c11b17824270dbfa4f6a989b19dc62 */
    public class C16501 extends AbstractDisposableFutureCallback<GraphQLResult<StructuredMenuListDataModel>> {
        final /* synthetic */ StructuredMenuListFragment f15122a;
        final /* synthetic */ StructuredMenuListLoader f15123b;

        public C16501(StructuredMenuListLoader structuredMenuListLoader, StructuredMenuListFragment structuredMenuListFragment) {
            this.f15123b = structuredMenuListLoader;
            this.f15122a = structuredMenuListFragment;
        }

        protected final void m17569a(Object obj) {
            ImmutableList immutableList;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            ImmutableList immutableList2 = RegularImmutableList.a;
            if (graphQLResult == null || graphQLResult.e == null || ((StructuredMenuListDataModel) graphQLResult.e).a() == null) {
                immutableList = immutableList2;
            } else {
                immutableList = ((StructuredMenuListDataModel) graphQLResult.e).a().a();
            }
            StructuredMenuListFragment structuredMenuListFragment = this.f15122a;
            structuredMenuListFragment.f15120c.setMessage(2131239097);
            structuredMenuListFragment.f15120c.a(false);
            StructuredMenuListAdapter structuredMenuListAdapter = structuredMenuListFragment.f15118a;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                NodesModel nodesModel = (NodesModel) immutableList.get(i);
                if (!(nodesModel.a() == null || nodesModel.a().a().isEmpty())) {
                    structuredMenuListAdapter.f15170c.add(new StructuredMenuListSection(nodesModel.j(), nodesModel.a().a()));
                }
            }
            AdapterDetour.a(structuredMenuListAdapter, 1553245974);
        }

        protected final void m17570a(Throwable th) {
            StructuredMenuListFragment structuredMenuListFragment = this.f15122a;
            structuredMenuListFragment.f15120c.setMessage(2131239095);
            structuredMenuListFragment.f15120c.a(false);
        }
    }

    private static StructuredMenuListLoader m17572b(InjectorLike injectorLike) {
        return new StructuredMenuListLoader(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public StructuredMenuListLoader(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f15126a = graphQLQueryExecutor;
        this.f15127b = tasksManager;
    }

    public static StructuredMenuListLoader m17571a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StructuredMenuListLoader b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f15125d) {
                StructuredMenuListLoader structuredMenuListLoader;
                if (a2 != null) {
                    structuredMenuListLoader = (StructuredMenuListLoader) a2.a(f15125d);
                } else {
                    structuredMenuListLoader = f15124c;
                }
                if (structuredMenuListLoader == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m17572b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f15125d, b3);
                        } else {
                            f15124c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = structuredMenuListLoader;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
