package com.facebook.timeline.pymk.rows;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition.Controller;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Callbacks;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.friends.FriendingQueryExecutor;
import com.facebook.friends.constants.PeopleYouMayKnowLocation;
import com.facebook.friends.model.FetchPeopleYouMayKnowResult;
import com.facebook.friends.model.PersonYouMayKnow;
import com.facebook.graphql.model.GraphQLPageInfo.Builder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.timeline.pymk.PeopleYouMayKnowModel;
import com.facebook.timeline.pymk.rows.PeopleYouMayKnowPagePartDefinition.Props;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: faceweb_modal */
public class PeopleYouMayKnowHScrollPartDefinition<E extends CanFriendPerson & HasContext & HasPersistentState & HasRowKey & HasPrefetcher & HasInvalidate> extends MultiRowSinglePartDefinition<PeopleYouMayKnowModel, Void, E, HScrollRecyclerView> {
    public static final ViewType<HScrollRecyclerView> f12531a = new C17651();
    public static final CallerContext f12532b = CallerContext.a(PeopleYouMayKnowHScrollPartDefinition.class);
    private static PeopleYouMayKnowHScrollPartDefinition f12533l;
    private static final Object f12534m = new Object();
    public final FriendingQueryExecutor f12535c;
    private final PersistentRecyclerPartDefinition<Object, E> f12536d;
    private final PageSwitcherPartDefinition f12537e;
    public final PeopleYouMayKnowPagePartDefinition<E> f12538f;
    public final PeopleYouMayKnowSeeAllPartDefinition f12539g;
    public final PeopleYouMayKnowLoadingPartDefinition f12540h;
    private final PageStyleFactory f12541i;
    public final Resources f12542j;
    public final TasksManager<String> f12543k;

    /* compiled from: faceweb_modal */
    final class C17651 extends ViewType<HScrollRecyclerView> {
        C17651() {
        }

        public final View m12520a(Context context) {
            return new HScrollRecyclerView(context);
        }
    }

    /* compiled from: faceweb_modal */
    public class C17673 {
        public final /* synthetic */ PeopleYouMayKnowModel f12522a;
        public final /* synthetic */ int f12523b;
        public final /* synthetic */ CanFriendPerson f12524c;
        final /* synthetic */ PeopleYouMayKnowHScrollPartDefinition f12525d;

        public C17673(PeopleYouMayKnowHScrollPartDefinition peopleYouMayKnowHScrollPartDefinition, PeopleYouMayKnowModel peopleYouMayKnowModel, int i, CanFriendPerson canFriendPerson) {
            this.f12525d = peopleYouMayKnowHScrollPartDefinition;
            this.f12522a = peopleYouMayKnowModel;
            this.f12523b = i;
            this.f12524c = canFriendPerson;
        }
    }

    /* compiled from: faceweb_modal */
    public class C17684 implements Callable<ListenableFuture<FetchPeopleYouMayKnowResult>> {
        final /* synthetic */ PeopleYouMayKnowModel f12526a;
        final /* synthetic */ PeopleYouMayKnowHScrollPartDefinition f12527b;

        public C17684(PeopleYouMayKnowHScrollPartDefinition peopleYouMayKnowHScrollPartDefinition, PeopleYouMayKnowModel peopleYouMayKnowModel) {
            this.f12527b = peopleYouMayKnowHScrollPartDefinition;
            this.f12526a = peopleYouMayKnowModel;
        }

        public Object call() {
            return this.f12527b.f12535c.a(this.f12526a.f12469b.a(), 20, Integer.valueOf(this.f12527b.f12542j.getDimensionPixelSize(2131430284)), PeopleYouMayKnowLocation.SELF_PROFILE, PeopleYouMayKnowHScrollPartDefinition.f12532b);
        }
    }

    /* compiled from: faceweb_modal */
    public class C17695 extends AbstractDisposableFutureCallback<FetchPeopleYouMayKnowResult> {
        final /* synthetic */ PeopleYouMayKnowModel f12528a;
        final /* synthetic */ CanFriendPerson f12529b;
        final /* synthetic */ PeopleYouMayKnowHScrollPartDefinition f12530c;

        public C17695(PeopleYouMayKnowHScrollPartDefinition peopleYouMayKnowHScrollPartDefinition, PeopleYouMayKnowModel peopleYouMayKnowModel, CanFriendPerson canFriendPerson) {
            this.f12530c = peopleYouMayKnowHScrollPartDefinition;
            this.f12528a = peopleYouMayKnowModel;
            this.f12529b = canFriendPerson;
        }

        protected final void m12523a(Object obj) {
            FetchPeopleYouMayKnowResult fetchPeopleYouMayKnowResult = (FetchPeopleYouMayKnowResult) obj;
            PeopleYouMayKnowModel peopleYouMayKnowModel = this.f12528a;
            peopleYouMayKnowModel.f12468a.addAll(fetchPeopleYouMayKnowResult.a);
            this.f12528a.f12469b = fetchPeopleYouMayKnowResult.b;
            ((HasInvalidate) this.f12529b).a(new Object[]{this.f12528a});
        }

        protected final void m12524a(Throwable th) {
            PeopleYouMayKnowModel peopleYouMayKnowModel = this.f12528a;
            Builder builder = new Builder();
            builder.f = false;
            peopleYouMayKnowModel.f12469b = builder.a();
            ((HasInvalidate) this.f12529b).a(new Object[]{this.f12528a});
        }
    }

    private static PeopleYouMayKnowHScrollPartDefinition m12527b(InjectorLike injectorLike) {
        return new PeopleYouMayKnowHScrollPartDefinition(FriendingQueryExecutor.a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), PageSwitcherPartDefinition.a(injectorLike), PeopleYouMayKnowPagePartDefinition.m12544a(injectorLike), PeopleYouMayKnowSeeAllPartDefinition.m12552a(injectorLike), PeopleYouMayKnowLoadingPartDefinition.m12539a(injectorLike), PageStyleFactory.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), TasksManager.b(injectorLike));
    }

    private Callbacks<Object, E> m12525a(PeopleYouMayKnowModel peopleYouMayKnowModel, E e, Controller controller) {
        final List copyOf = ImmutableList.copyOf(peopleYouMayKnowModel.f12468a);
        final PeopleYouMayKnowModel peopleYouMayKnowModel2 = peopleYouMayKnowModel;
        final E e2 = e;
        final Controller controller2 = controller;
        return new SimpleCallbacks<E>(this) {
            final /* synthetic */ PeopleYouMayKnowHScrollPartDefinition f12521e;

            public final void m12521a(PageSubParts<E> pageSubParts) {
                int size = copyOf.size();
                for (int i = 0; i < size; i++) {
                    pageSubParts.a(this.f12521e.f12538f, new Props((PersonYouMayKnow) copyOf.get(i), new C17673(this.f12521e, peopleYouMayKnowModel2, i, e2), controller2, peopleYouMayKnowModel2));
                }
                if (peopleYouMayKnowModel2.f12469b.b()) {
                    pageSubParts.a(this.f12521e.f12540h, null);
                } else {
                    pageSubParts.a(this.f12521e.f12539g, null);
                }
            }

            public final void m12522c(int i) {
                PeopleYouMayKnowHScrollPartDefinition peopleYouMayKnowHScrollPartDefinition = this.f12521e;
                PeopleYouMayKnowModel peopleYouMayKnowModel = peopleYouMayKnowModel2;
                CanFriendPerson canFriendPerson = e2;
                if (i >= copyOf.size() - 3 && peopleYouMayKnowModel.f12469b.b()) {
                    peopleYouMayKnowHScrollPartDefinition.f12543k.a("FETCH_PYMK_TASK_KEY", new C17684(peopleYouMayKnowHScrollPartDefinition, peopleYouMayKnowModel), new C17695(peopleYouMayKnowHScrollPartDefinition, peopleYouMayKnowModel, canFriendPerson));
                }
            }
        };
    }

    public final Object m12529a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PeopleYouMayKnowModel peopleYouMayKnowModel = (PeopleYouMayKnowModel) obj;
        CanFriendPerson canFriendPerson = (CanFriendPerson) anyEnvironment;
        Controller controller = new Controller();
        subParts.a(this.f12537e, controller);
        subParts.a(this.f12536d, new PersistentRecyclerPartDefinition.Props(this.f12541i.a(304.0f, PageStyle.a, true), 0, m12525a(peopleYouMayKnowModel, canFriendPerson, controller), peopleYouMayKnowModel.m12499g(), peopleYouMayKnowModel));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m12530a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1108031123);
        ((HScrollRecyclerView) view).setBackgroundDrawable(new ColorDrawable(this.f12542j.getColor(2131361920)));
        Logger.a(8, EntryType.MARK_POP, -541058430, a);
    }

    public static PeopleYouMayKnowHScrollPartDefinition m12526a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayKnowHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12534m) {
                PeopleYouMayKnowHScrollPartDefinition peopleYouMayKnowHScrollPartDefinition;
                if (a2 != null) {
                    peopleYouMayKnowHScrollPartDefinition = (PeopleYouMayKnowHScrollPartDefinition) a2.a(f12534m);
                } else {
                    peopleYouMayKnowHScrollPartDefinition = f12533l;
                }
                if (peopleYouMayKnowHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12527b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12534m, b3);
                        } else {
                            f12533l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayKnowHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PeopleYouMayKnowHScrollPartDefinition(FriendingQueryExecutor friendingQueryExecutor, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, PageSwitcherPartDefinition pageSwitcherPartDefinition, PeopleYouMayKnowPagePartDefinition peopleYouMayKnowPagePartDefinition, PeopleYouMayKnowSeeAllPartDefinition peopleYouMayKnowSeeAllPartDefinition, PeopleYouMayKnowLoadingPartDefinition peopleYouMayKnowLoadingPartDefinition, PageStyleFactory pageStyleFactory, Resources resources, TasksManager tasksManager) {
        this.f12535c = friendingQueryExecutor;
        this.f12536d = persistentRecyclerPartDefinition;
        this.f12537e = pageSwitcherPartDefinition;
        this.f12538f = peopleYouMayKnowPagePartDefinition;
        this.f12539g = peopleYouMayKnowSeeAllPartDefinition;
        this.f12540h = peopleYouMayKnowLoadingPartDefinition;
        this.f12541i = pageStyleFactory;
        this.f12542j = resources;
        this.f12543k = tasksManager;
    }

    public final boolean m12531a(Object obj) {
        return true;
    }

    public final ViewType<HScrollRecyclerView> m12528a() {
        return f12531a;
    }
}
