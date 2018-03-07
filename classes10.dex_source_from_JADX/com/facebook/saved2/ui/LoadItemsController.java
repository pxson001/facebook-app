package com.facebook.saved2.ui;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.MainThread;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import com.facebook.crudolib.dao.DAOItem;
import com.facebook.crudolib.dbquery.loader.inprocess.DatabaseQueryManager;
import com.facebook.crudolib.dbquery.loader.inprocess.OnDataCallback;
import com.facebook.infer.annotation.Assertions;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.saved2.analytics.Saved2StartPerfLogger;
import com.facebook.saved2.model.Saved2ItemTable_Queries.BaseQueryDAO;
import com.facebook.saved2.model.Saved2ItemTable_Queries.QueryBySectionDAO;
import com.facebook.saved2.model.Saved2ItemTable_Queries.QueryBySectionProvider;
import com.facebook.saved2.model.Saved2ItemTable_Queries.TimeSortedQueryBySectionProvider;
import com.facebook.saved2.prefs.Saved2PrefKeys;
import com.facebook.saved2.ui.Saved2DashboardEmptyView.OnAfterDrawListener;
import com.facebook.saved2.ui.itemadapters.Saved2GroupedItemsAdapterFactory;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import javax.annotation.Nullable;

@MainThread
/* compiled from: instant_shopping_catalog_activity */
public class LoadItemsController {
    private final DatabaseQueryManager f9481a;
    private final Saved2NetworkController f9482b;
    private final Saved2StartPerfLogger f9483c;
    private final Toaster f9484d;
    private final SimpleArrayMap<String, StateMachine> f9485e = new SimpleArrayMap(8);
    private final FbSharedPreferences f9486f;

    /* compiled from: instant_shopping_catalog_activity */
    public class Saved2ScrollListener extends OnScrollListener {
        private final Saved2NetworkController f9444a;
        public final SimpleArrayMap<String, Boolean> f9445b = new SimpleArrayMap(12);
        public String f9446c;
        public BaseQueryDAO f9447d;

        public Saved2ScrollListener(Saved2NetworkController saved2NetworkController) {
            this.f9444a = saved2NetworkController;
        }

        public final void m9718a(RecyclerView recyclerView, int i, int i2) {
            super.a(recyclerView, i, i2);
            if (i == 0 && this.f9445b.get(this.f9446c) != Boolean.TRUE) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int D = linearLayoutManager.D();
                int v = linearLayoutManager.v();
                int n = linearLayoutManager.n();
                if (D > 0 && v < D && n + 10 >= D) {
                    this.f9447d.a().moveToLast();
                    Saved2NetworkController saved2NetworkController = this.f9444a;
                    saved2NetworkController.f9502a.m9710a(this.f9446c, this.f9447d.f());
                    this.f9445b.put(this.f9446c, Boolean.TRUE);
                }
            }
        }
    }

    @MainThread
    /* compiled from: instant_shopping_catalog_activity */
    public abstract class State {
        public static final State f9448a = new C14051();
        public static final State f9449b = new C14062();
        public static final State f9450c = new C14073();
        public static final State f9451d = new C14084();
        public static final State f9452e = new C14095();
        public static final State f9453f = new C14136();

        /* compiled from: instant_shopping_catalog_activity */
        final class C14051 extends State {
            C14051() {
            }

            public final void mo436a(StateMachine stateMachine) {
                stateMachine.f9471j = null;
                stateMachine.f9473l = null;
                stateMachine.f9476o = -1;
                stateMachine.f9477p = -1;
                stateMachine.f9479r = null;
            }

            public final void mo437b(StateMachine stateMachine) {
                StateMachine.m9760a(stateMachine, State.f9449b);
            }

            public final void mo438d(StateMachine stateMachine) {
                StateMachine.m9760a(stateMachine, State.f9450c);
            }
        }

        /* compiled from: instant_shopping_catalog_activity */
        final class C14062 extends State {
            public final void mo439a(StateMachine stateMachine, BaseQueryDAO baseQueryDAO) {
                stateMachine.f9479r = baseQueryDAO;
                StateMachine.m9760a(stateMachine, State.f9453f);
            }

            public final void mo440a(StateMachine stateMachine, String str) {
                stateMachine.f9480s = str;
            }

            C14062() {
            }

            public final void mo436a(StateMachine stateMachine) {
                stateMachine.f9471j.a();
            }

            public final void mo441c(StateMachine stateMachine) {
                StateMachine.m9760a(stateMachine, State.f9448a);
            }

            public final void mo438d(StateMachine stateMachine) {
                StateMachine.m9760a(stateMachine, State.f9451d);
            }
        }

        /* compiled from: instant_shopping_catalog_activity */
        abstract class DataFetchingBaseState extends State {
            public void mo436a(final StateMachine stateMachine) {
                TimeSortedQueryBySectionProvider queryBySectionProvider;
                stateMachine.f9465d.m9527b();
                DatabaseQueryManager databaseQueryManager = stateMachine.f9464c;
                String str = stateMachine.f9467f;
                int i = -1;
                switch (str.hashCode()) {
                    case -1932444596:
                        if (str.equals("PLACES")) {
                            i = 0;
                            break;
                        }
                        break;
                }
                switch (i) {
                    case 0:
                        queryBySectionProvider = new QueryBySectionProvider(0, 0, str);
                        break;
                    default:
                        queryBySectionProvider = new TimeSortedQueryBySectionProvider(0, 0, str);
                        break;
                }
                stateMachine.f9470i = databaseQueryManager.a(queryBySectionProvider, new OnDataCallback<QueryBySectionDAO>(this) {
                    final /* synthetic */ DataFetchingBaseState f9461b;

                    public final void m9759a(DAOItem dAOItem) {
                        stateMachine.f9462a.mo439a(stateMachine, (QueryBySectionDAO) dAOItem);
                        stateMachine.f9465d.m9528c();
                        if (stateMachine.f9463b.m9780a(stateMachine.f9467f)) {
                            stateMachine.f9465d.m9529d();
                        }
                    }

                    public final void m9758a() {
                        stateMachine.f9465d.m9528c();
                        stateMachine.f9462a.mo444e(stateMachine);
                    }
                });
            }
        }

        /* compiled from: instant_shopping_catalog_activity */
        final class C14073 extends DataFetchingBaseState {
            public final void mo439a(StateMachine stateMachine, BaseQueryDAO baseQueryDAO) {
                stateMachine.f9479r = baseQueryDAO;
                StateMachine.m9760a(stateMachine, State.f9452e);
            }

            public final void mo440a(StateMachine stateMachine, String str) {
                stateMachine.f9480s = str;
            }

            C14073() {
            }

            public final void mo437b(StateMachine stateMachine) {
                StateMachine.m9760a(stateMachine, State.f9449b);
            }
        }

        /* compiled from: instant_shopping_catalog_activity */
        final class C14084 extends DataFetchingBaseState {
            C14084() {
            }

            public final void mo436a(StateMachine stateMachine) {
                super.mo436a(stateMachine);
                StateMachine.m9760a(stateMachine, State.f9449b);
            }
        }

        /* compiled from: instant_shopping_catalog_activity */
        final class C14095 extends State {
            public final void mo440a(StateMachine stateMachine, String str) {
                stateMachine.f9480s = str;
            }

            C14095() {
            }

            public final void mo437b(StateMachine stateMachine) {
                StateMachine.m9760a(stateMachine, State.f9453f);
            }

            public final void mo439a(StateMachine stateMachine, BaseQueryDAO baseQueryDAO) {
                stateMachine.f9479r.c();
                stateMachine.f9479r = baseQueryDAO;
            }
        }

        /* compiled from: instant_shopping_catalog_activity */
        final class C14136 extends State {
            C14136() {
            }

            public final void mo436a(StateMachine stateMachine) {
                if (m9748a(stateMachine, stateMachine.f9474m.f9630d.aZ_(), stateMachine.f9480s)) {
                    stateMachine.f9479r.c();
                } else {
                    m9749c(stateMachine, stateMachine.f9479r);
                }
                stateMachine.f9479r = null;
                stateMachine.f9480s = null;
            }

            public final void mo441c(StateMachine stateMachine) {
                if (stateMachine.f9475n != null) {
                    stateMachine.f9471j.removeView(stateMachine.f9475n);
                    stateMachine.f9475n = null;
                }
                DatabaseQueryManager databaseQueryManager = stateMachine.f9464c;
                databaseQueryManager.a.a(stateMachine.f9470i);
                stateMachine.f9470i = -1;
                StateMachine.m9760a(stateMachine, State.f9448a);
            }

            public final void mo439a(StateMachine stateMachine, BaseQueryDAO baseQueryDAO) {
                m9749c(stateMachine, baseQueryDAO);
            }

            private void m9749c(StateMachine stateMachine, BaseQueryDAO baseQueryDAO) {
                Saved2ScrollListener saved2ScrollListener = stateMachine.f9468g;
                saved2ScrollListener.f9446c = stateMachine.f9467f;
                saved2ScrollListener.f9447d = baseQueryDAO;
                saved2ScrollListener.f9445b.put(saved2ScrollListener.f9446c, Boolean.FALSE);
                stateMachine.f9474m.m9873a(baseQueryDAO.a(), baseQueryDAO);
                boolean z = false;
                if (baseQueryDAO.a().getCount() != 0 || stateMachine.f9469h.a(Saved2PrefKeys.m9711a(stateMachine.f9467f), false)) {
                    z = true;
                }
                if (z) {
                    m9750f(stateMachine);
                }
            }

            private void m9750f(final StateMachine stateMachine) {
                stateMachine.f9471j.b();
                if (stateMachine.f9472k != null) {
                    stateMachine.f9472k.setRefreshing(false);
                }
                stateMachine.f9472k = (FbSwipeRefreshLayout) stateMachine.f9471j.findViewById(stateMachine.f9476o);
                stateMachine.f9472k.e = new OnRefreshListener(this) {
                    final /* synthetic */ C14136 f9455b;

                    public final void m9744a() {
                        stateMachine.f9463b.m9781b(stateMachine.f9467f);
                    }
                };
                if (stateMachine.f9473l == null) {
                    stateMachine.f9473l = (RecyclerView) stateMachine.f9471j.findViewById(stateMachine.f9477p);
                    stateMachine.f9473l.getContext();
                    stateMachine.f9473l.setLayoutManager(new LinearLayoutManager(1, false));
                    stateMachine.f9473l.setAdapter(stateMachine.f9474m.f9630d);
                    stateMachine.f9473l.a(stateMachine.f9468g);
                }
                if (stateMachine.f9474m.f9630d.aZ_() == 0) {
                    stateMachine.f9473l.setVisibility(8);
                    if (stateMachine.f9475n == null) {
                        stateMachine.f9475n = (Saved2DashboardEmptyView) LayoutInflater.from(stateMachine.f9473l.getContext()).inflate(stateMachine.f9478q, stateMachine.f9471j, false);
                        stateMachine.f9471j.addView(stateMachine.f9475n);
                        stateMachine.f9475n.f9488a = new OnAfterDrawListener(this) {
                            final /* synthetic */ C14136 f9457b;

                            public final void mo442a() {
                                stateMachine.f9465d.m9531f();
                            }
                        };
                    }
                    stateMachine.f9475n.setVisibility(0);
                    return;
                }
                stateMachine.f9473l.setVisibility(0);
                if (stateMachine.f9475n != null) {
                    stateMachine.f9475n.setVisibility(8);
                }
            }

            public final void mo438d(StateMachine stateMachine) {
            }

            public final void mo443a(StateMachine stateMachine, int i) {
                stateMachine.f9465d.m9530e();
                if (!stateMachine.f9469h.a(Saved2PrefKeys.m9711a(stateMachine.f9467f), false)) {
                    stateMachine.f9469h.edit().putBoolean(Saved2PrefKeys.m9711a(stateMachine.f9467f), true).commit();
                }
                if (i == 0 && stateMachine.f9473l != null) {
                    stateMachine.f9473l.b(stateMachine.f9468g);
                }
                if (i == 0 && stateMachine.f9474m != null && stateMachine.f9474m.f9630d.aZ_() == 0) {
                    m9750f(stateMachine);
                }
            }

            public final void mo440a(StateMachine stateMachine, String str) {
                stateMachine.f9465d.m9530e();
                Assertions.b(str);
                m9748a(stateMachine, stateMachine.f9474m.f9630d.aZ_(), str);
            }

            private boolean m9748a(final StateMachine stateMachine, int i, @Nullable String str) {
                if (i == 0 && str != null) {
                    stateMachine.f9471j.a(str, new RetryClickedListener(this) {
                        final /* synthetic */ C14136 f9459b;

                        public final void m9747a() {
                            stateMachine.f9463b.m9781b(stateMachine.f9467f);
                        }
                    });
                    if (stateMachine.f9475n != null) {
                        stateMachine.f9475n.setVisibility(8);
                    }
                    return true;
                } else if (stateMachine.f9472k == null || !stateMachine.f9472k.f) {
                    return false;
                } else {
                    stateMachine.f9472k.setRefreshing(false);
                    stateMachine.f9466e.b(new ToastBuilder(2131241578));
                    return false;
                }
            }

            public final void mo444e(StateMachine stateMachine) {
                stateMachine.f9474m.m9873a(null, null);
            }
        }

        public void mo436a(StateMachine stateMachine) {
        }

        public void mo437b(StateMachine stateMachine) {
            throw new IllegalStateException("Unhandled: " + stateMachine.f9462a);
        }

        public void mo441c(StateMachine stateMachine) {
            throw new IllegalStateException("Unhandled: " + stateMachine.f9462a);
        }

        public void mo438d(StateMachine stateMachine) {
            throw new IllegalStateException("Unhandled: " + stateMachine.f9462a);
        }

        public void mo439a(StateMachine stateMachine, BaseQueryDAO baseQueryDAO) {
            throw new IllegalStateException("Unhandled: " + stateMachine.f9462a);
        }

        public void mo444e(StateMachine stateMachine) {
            throw new IllegalStateException("Unhandled: " + stateMachine.f9462a);
        }

        public void mo443a(StateMachine stateMachine, int i) {
            throw new IllegalStateException("Unhandled: " + stateMachine.f9462a);
        }

        public void mo440a(StateMachine stateMachine, String str) {
            throw new IllegalStateException("Unhandled: " + stateMachine.f9462a);
        }

        public String toString() {
            try {
                return m9719a(this);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private static String m9719a(State state) {
            for (Field field : State.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) && field.get(null) == state) {
                    return field.getName();
                }
            }
            return "<unknown>";
        }
    }

    /* compiled from: instant_shopping_catalog_activity */
    public class StateMachine {
        public State f9462a = State.f9448a;
        public final Saved2NetworkController f9463b;
        public final DatabaseQueryManager f9464c;
        public final Saved2StartPerfLogger f9465d;
        public final Toaster f9466e;
        public final String f9467f;
        public final Saved2ScrollListener f9468g;
        public final FbSharedPreferences f9469h;
        public int f9470i = -1;
        public LoadingIndicatorView f9471j;
        public FbSwipeRefreshLayout f9472k;
        public RecyclerView f9473l;
        public Saved2GroupedItemsAdapterFactory f9474m;
        public Saved2DashboardEmptyView f9475n;
        @IdRes
        public int f9476o = -1;
        @IdRes
        public int f9477p = -1;
        @LayoutRes
        public int f9478q = 0;
        public BaseQueryDAO f9479r;
        public String f9480s;

        public StateMachine(Saved2NetworkController saved2NetworkController, DatabaseQueryManager databaseQueryManager, Saved2StartPerfLogger saved2StartPerfLogger, Toaster toaster, FbSharedPreferences fbSharedPreferences, String str) {
            this.f9463b = saved2NetworkController;
            this.f9464c = databaseQueryManager;
            this.f9465d = saved2StartPerfLogger;
            this.f9466e = toaster;
            this.f9467f = str;
            this.f9468g = new Saved2ScrollListener(saved2NetworkController);
            this.f9469h = fbSharedPreferences;
        }

        public final void m9761a(LoadingIndicatorView loadingIndicatorView, Saved2GroupedItemsAdapterFactory saved2GroupedItemsAdapterFactory, @IdRes int i, @IdRes int i2, @LayoutRes int i3) {
            this.f9471j = loadingIndicatorView;
            this.f9474m = saved2GroupedItemsAdapterFactory;
            this.f9476o = i;
            this.f9477p = i2;
            this.f9478q = i3;
            this.f9462a.mo437b(this);
        }

        public final void m9762b() {
            this.f9462a.mo438d(this);
        }

        public static void m9760a(StateMachine stateMachine, State state) {
            if (stateMachine.f9462a != state) {
                stateMachine.f9462a = state;
                state.mo436a(stateMachine);
            }
        }
    }

    public LoadItemsController(DatabaseQueryManager databaseQueryManager, Saved2NetworkController saved2NetworkController, Saved2StartPerfLogger saved2StartPerfLogger, FbSharedPreferences fbSharedPreferences, Toaster toaster) {
        this.f9481a = databaseQueryManager;
        this.f9482b = saved2NetworkController;
        this.f9483c = saved2StartPerfLogger;
        this.f9486f = fbSharedPreferences;
        this.f9484d = toaster;
    }

    public final StateMachine m9763a(String str) {
        StateMachine stateMachine = (StateMachine) this.f9485e.get(str);
        if (stateMachine != null) {
            return stateMachine;
        }
        stateMachine = new StateMachine(this.f9482b, this.f9481a, this.f9483c, this.f9484d, this.f9486f, str);
        this.f9485e.put(str, stateMachine);
        return stateMachine;
    }
}
