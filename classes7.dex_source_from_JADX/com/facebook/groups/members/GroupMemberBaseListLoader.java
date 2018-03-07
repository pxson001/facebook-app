package com.facebook.groups.members;

import android.support.v4.util.Pair;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* compiled from: promo_screen_title */
public abstract class GroupMemberBaseListLoader<MODEL> {
    private static final Class f5771e = GroupMemberBaseListLoader.class;
    protected String f5772a;
    public boolean f5773b;
    public HashMap<Enum, Pair<String, Boolean>> f5774c;
    protected GraphQLGroupVisibility f5775d;
    private final TasksManager f5776f;
    public final GraphQLQueryExecutor f5777g;
    public final MemberListLoaderListener f5778h;
    public Callable<ListenableFuture<GraphQLResult<MODEL>>> f5779i;
    public boolean f5780j;

    /* compiled from: promo_screen_title */
    public class C05351 implements Callable<ListenableFuture<GraphQLResult<MODEL>>> {
        final /* synthetic */ GroupMemberBaseListLoader f5763a;

        public C05351(GroupMemberBaseListLoader groupMemberBaseListLoader) {
            this.f5763a = groupMemberBaseListLoader;
        }

        public Object call() {
            TypedGraphQlQueryString a = this.f5763a.mo307a(this.f5763a.f5772a);
            this.f5763a.f5778h.mo313a(this.f5763a.f5780j);
            return this.f5763a.f5777g.a(GraphQLRequest.a(a).a(GraphQLCachePolicy.c));
        }
    }

    /* compiled from: promo_screen_title */
    class C05362 extends AbstractDisposableFutureCallback<GraphQLResult<MODEL>> {
        final /* synthetic */ GroupMemberBaseListLoader f5764a;

        C05362(GroupMemberBaseListLoader groupMemberBaseListLoader) {
            this.f5764a = groupMemberBaseListLoader;
        }

        protected final void m7081a(Object obj) {
            this.f5764a.m7089b((GraphQLResult) obj);
        }

        protected final void m7082a(Throwable th) {
            GroupMemberBaseListLoader.m7088a(this.f5764a, th);
        }
    }

    /* compiled from: promo_screen_title */
    public interface MemberListLoaderListener<DATA> {
        void mo312a(ImmutableList<DATA> immutableList, GraphQLGroupVisibility graphQLGroupVisibility);

        void mo313a(boolean z);
    }

    /* compiled from: promo_screen_title */
    enum Tasks {
        FETCH_GROUP_MEMBERS,
        FETCH_MEMBERS_FOR_SECTION
    }

    protected abstract TypedGraphQlQueryString<MODEL> mo307a(String str);

    protected abstract void mo308a(GraphQLResult<MODEL> graphQLResult);

    public abstract ImmutableList<? extends Object> mo310i();

    protected abstract void mo311j();

    public GroupMemberBaseListLoader(TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, MemberListLoaderListener memberListLoaderListener) {
        this(tasksManager, graphQLQueryExecutor, memberListLoaderListener, Boolean.valueOf(true));
    }

    public GroupMemberBaseListLoader(TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, MemberListLoaderListener memberListLoaderListener, Boolean bool) {
        this.f5774c = new HashMap();
        this.f5776f = tasksManager;
        this.f5777g = graphQLQueryExecutor;
        this.f5778h = memberListLoaderListener;
        this.f5780j = bool.booleanValue();
        if (this.f5778h != null) {
            this.f5779i = new C05351(this);
        }
    }

    public final boolean m7095b() {
        return mo310i().isEmpty() && !this.f5773b;
    }

    public boolean m7097c() {
        return false;
    }

    public final ImmutableMap<Enum, Boolean> m7098d() {
        if (!m7097c()) {
            return null;
        }
        Builder builder = ImmutableMap.builder();
        for (Enum enumR : this.f5774c.keySet()) {
            Pair pair = (Pair) this.f5774c.get(enumR);
            builder.b(enumR, Boolean.valueOf(pair != null ? ((Boolean) pair.b).booleanValue() : true));
        }
        return builder.b();
    }

    public final synchronized void m7099e() {
        this.f5776f.c();
        this.f5773b = false;
        mo311j();
        this.f5772a = null;
        this.f5774c = new HashMap();
    }

    public final synchronized void m7100f() {
        if (!this.f5773b) {
            this.f5776f.a(m7090l(), this.f5779i, new C05362(this));
        }
    }

    public final synchronized void m7094a(final Enum enumR, final MemberListLoaderListener memberListLoaderListener) {
        if (this.f5774c.containsKey(enumR) && this.f5774c.get(enumR) != null) {
            final Pair pair = (Pair) this.f5774c.get(enumR);
            if (!((Boolean) pair.b).booleanValue()) {
                this.f5776f.a(Tasks.FETCH_MEMBERS_FOR_SECTION + enumR.name(), new Callable<ListenableFuture<GraphQLResult<MODEL>>>(this) {
                    final /* synthetic */ GroupMemberBaseListLoader f5768d;

                    public Object call() {
                        TypedGraphQlQueryString a = this.f5768d.m7091a(enumR);
                        if (a == null) {
                            return null;
                        }
                        memberListLoaderListener.mo313a(true);
                        return this.f5768d.f5777g.a(GraphQLRequest.a(a).a(GraphQLCachePolicy.c));
                    }
                }, new AbstractDisposableFutureCallback<GraphQLResult<MODEL>>(this) {
                    final /* synthetic */ GroupMemberBaseListLoader f5770b;

                    protected final void m7083a(Object obj) {
                        GraphQLResult graphQLResult = (GraphQLResult) obj;
                        memberListLoaderListener.mo313a(false);
                        this.f5770b.m7089b(graphQLResult);
                    }

                    protected final void m7084a(Throwable th) {
                        memberListLoaderListener.mo313a(false);
                        GroupMemberBaseListLoader.m7088a(this.f5770b, th);
                    }
                });
            }
        }
    }

    protected TypedGraphQlQueryString m7091a(Enum enumR) {
        return null;
    }

    protected final void m7101g() {
        this.f5778h.mo312a(mo310i(), this.f5775d);
    }

    protected final boolean m7096b(Enum enumR) {
        if (this.f5774c == null || this.f5774c.get(enumR) == null) {
            return true;
        }
        return !((Boolean) ((Pair) this.f5774c.get(enumR)).b).booleanValue();
    }

    protected String mo309h() {
        return "Group members fetch failed";
    }

    private static Object m7090l() {
        return Tasks.FETCH_GROUP_MEMBERS;
    }

    public static synchronized void m7088a(GroupMemberBaseListLoader groupMemberBaseListLoader, Throwable th) {
        synchronized (groupMemberBaseListLoader) {
            BLog.b(f5771e, groupMemberBaseListLoader.mo309h(), th);
            groupMemberBaseListLoader.f5778h.mo313a(false);
        }
    }

    private synchronized void m7089b(GraphQLResult<MODEL> graphQLResult) {
        this.f5778h.mo313a(false);
        mo308a((GraphQLResult) graphQLResult);
    }
}
