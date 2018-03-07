package com.facebook.feed.rows.core;

import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.debug.dumpsys.DumpsysContext;
import com.facebook.debug.dumpsys.DumpsysDumpable;
import com.facebook.feed.rows.core.analytics.MultiRowPerfLogger;
import com.facebook.feed.rows.core.binding.Binder;
import com.facebook.feed.rows.core.parts.EnvironmentController;
import com.facebook.feed.rows.core.parts.EnvironmentControllerUtil;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.parts.SingleChildMultiRowGroupPartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.traversal.GroupPartDumper;
import com.facebook.feed.rows.core.traversal.GroupPartRenderer;
import com.facebook.feed.rows.core.traversal.SinglePartHolder;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowGroupPartDefinition;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.multirow.api.ViewType;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.viewdiagnostics.DiagnosticsRunner;
import com.facebook.widget.viewdiagnostics.DiagnosticsRunner.Action;
import com.google.common.collect.ImmutableList;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

/* compiled from: nb */
public class FeedUnitAdapter<P, E extends AnyEnvironment> implements DumpsysDumpable {
    public static final String f12956a = FeedUnitAdapter.class.getSimpleName();
    public final P f12957b;
    @Nullable
    private final GraphQLFeedUnitEdge f12958c;
    public final E f12959d;
    private final MultiRowGroupPartDefinition<? super P, ?, ? super E> f12960e;
    public final AbstractFbErrorReporter f12961f;
    private final DiagnosticsRunner f12962g;
    private final DefaultAndroidThreadUtil f12963h;
    private final MultipleRowsStoriesRecycleCallback f12964i;
    public final ImmutableList<SinglePartHolder<?, ?, ?, ?>> f12965j;
    private final List<BoundedAdapter<P>> f12966k = new ArrayList();
    public final boolean f12967l;

    public final void mo1888a(DumpsysContext dumpsysContext) {
        PrintWriter printWriter = dumpsysContext.e;
        printWriter.println("DUMPING SECTIONS for adapter with " + m19044a() + " parts");
        printWriter.println("story: " + this.f12957b);
        if (this.f12957b instanceof FeedUnit) {
            printWriter.println("debug info: " + ((FeedUnit) this.f12957b).S_());
        }
        new GroupPartDumper(printWriter, this.f12959d).mo2546a(this.f12960e, this.f12957b);
    }

    public FeedUnitAdapter(Object obj, E e, MultiRowPartWithIsNeeded<? super P, ? super E> multiRowPartWithIsNeeded, FbErrorReporter fbErrorReporter, DiagnosticsRunner diagnosticsRunner, AndroidThreadUtil androidThreadUtil, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, MultiRowPerfLogger multiRowPerfLogger, boolean z, boolean z2) {
        this.f12957b = obj instanceof GraphQLFeedUnitEdge ? ((GraphQLFeedUnitEdge) obj).mo2540c() : obj;
        this.f12967l = z2;
        this.f12958c = obj instanceof GraphQLFeedUnitEdge ? (GraphQLFeedUnitEdge) obj : null;
        this.f12959d = e;
        this.f12960e = m19041a((MultiRowPartWithIsNeeded) multiRowPartWithIsNeeded);
        this.f12961f = fbErrorReporter;
        this.f12962g = diagnosticsRunner;
        this.f12963h = androidThreadUtil;
        this.f12964i = multipleRowsStoriesRecycleCallback;
        TracerDetour.a("FeedUnitAdapter.init", -439724456);
        try {
            this.f12965j = GroupPartRenderer.m19102a(this.f12960e, this.f12957b, this.f12959d, multiRowPerfLogger);
            m19042a(z);
        } finally {
            TracerDetour.a(-1739115976);
        }
    }

    private static MultiRowGroupPartDefinition<? super P, ?, ? super E> m19041a(MultiRowPartWithIsNeeded<? super P, ? super E> multiRowPartWithIsNeeded) {
        if (multiRowPartWithIsNeeded instanceof MultiRowSinglePartDefinition) {
            return new SingleChildMultiRowGroupPartDefinition((MultiRowSinglePartDefinition) multiRowPartWithIsNeeded);
        }
        return (MultiRowGroupPartDefinition) multiRowPartWithIsNeeded;
    }

    public final int m19044a() {
        return this.f12965j.size();
    }

    public final P m19048b() {
        return this.f12957b;
    }

    public final RowKey m19045a(int i) {
        return ((SinglePartHolder) this.f12965j.get(i)).f13430c;
    }

    public final ViewType m19047b(int i) {
        return ((SinglePartHolder) this.f12965j.get(i)).m19779b();
    }

    public final Binder<View> m19049c(int i) {
        return (Binder) this.f12965j.get(i);
    }

    public final void m19050c() {
        for (int i = 0; i < this.f12965j.size(); i++) {
            MultipleRowsStoriesRecycleCallback.m10041a(ViewBindingsMap.m20699a((Binder) this.f12965j.get(i)));
        }
    }

    public final boolean m19052e(int i) {
        return m19043a(i, false);
    }

    public final boolean m19053f(int i) {
        return m19043a(i, true);
    }

    public final BoundedAdapter<P> m19054g(int i) {
        return (BoundedAdapter) this.f12966k.get(i);
    }

    private boolean m19043a(final int i, final boolean z) {
        this.f12963h.m1649a();
        final SinglePartHolder singlePartHolder = (SinglePartHolder) this.f12965j.get(i);
        if (singlePartHolder.f13434g) {
            return false;
        }
        Action action;
        DiagnosticsRunner diagnosticsRunner = this.f12962g;
        if (z) {
            action = Action.PREPARE_ASYNC;
        } else {
            action = Action.PREPARE;
        }
        diagnosticsRunner.m10048a(action, new Callable<Binder<?>>(this) {
            final /* synthetic */ FeedUnitAdapter f14285d;

            public Object call() {
                SinglePartHolder singlePartHolder;
                MultiRowSinglePartDefinition multiRowSinglePartDefinition;
                MultiRowSinglePartDefinition multiRowSinglePartDefinition2;
                Object obj;
                Object obj2 = null;
                SinglePartHolder singlePartHolder2 = i > 0 ? (SinglePartHolder) this.f14285d.f12965j.get(i - 1) : null;
                SinglePartHolder singlePartHolder3 = (SinglePartHolder) this.f14285d.f12965j.get(i);
                if (i < this.f14285d.f12965j.size() - 1) {
                    singlePartHolder = (SinglePartHolder) this.f14285d.f12965j.get(i + 1);
                } else {
                    singlePartHolder = null;
                }
                AnyEnvironment anyEnvironment = this.f14285d.f12959d;
                if (singlePartHolder2 != null) {
                    multiRowSinglePartDefinition = singlePartHolder2.f13428a;
                } else {
                    multiRowSinglePartDefinition = null;
                }
                MultiRowSinglePartDefinition multiRowSinglePartDefinition3 = singlePartHolder3.f13428a;
                if (singlePartHolder != null) {
                    multiRowSinglePartDefinition2 = singlePartHolder.f13428a;
                } else {
                    multiRowSinglePartDefinition2 = null;
                }
                if (singlePartHolder2 != null) {
                    obj = singlePartHolder2.f13431d;
                } else {
                    obj = null;
                }
                if (singlePartHolder != null) {
                    obj2 = singlePartHolder.f13431d;
                }
                EnvironmentController a = EnvironmentControllerUtil.m20677a(anyEnvironment, multiRowSinglePartDefinition, multiRowSinglePartDefinition3, multiRowSinglePartDefinition2, obj, obj2, singlePartHolder3.f13430c, z);
                singlePartHolder.mo2634a(this.f14285d.f12959d);
                EnvironmentControllerUtil.m20678a(a, this.f14285d.f12959d);
                return singlePartHolder;
            }
        });
        return true;
    }

    public final void m19051d() {
        for (int i = 0; i < this.f12965j.size(); i++) {
            m19055i(i);
        }
    }

    public final boolean m19055i(int i) {
        this.f12963h.m1649a();
        Binder binder = (SinglePartHolder) this.f12965j.get(i);
        if (binder.f13434g) {
            Object obj;
            if (ViewBindingsMap.m20699a(binder) != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                binder.mo2636b(this.f12959d);
                return true;
            }
        }
        return false;
    }

    private void m19042a(boolean z) {
        for (int i = 0; i < m19044a(); i++) {
            FeedUnit feedUnit;
            long T_ = this.f12957b instanceof FeedUnit ? ((FeedUnit) this.f12957b).T_() : 0;
            Object obj = this.f12957b;
            if (this.f12957b instanceof FeedProps) {
                obj = ((FeedProps) this.f12957b).f13444a;
            }
            if (obj instanceof FeedUnit) {
                feedUnit = (FeedUnit) obj;
            } else {
                obj = ((SinglePartHolder) this.f12965j.get(i)).f13431d;
                if (obj instanceof FeedUnit) {
                    feedUnit = (FeedUnit) obj;
                } else {
                    feedUnit = null;
                }
            }
            this.f12966k.add(new BoundedAdapter(this, i, T_, this.f12958c, feedUnit, z));
        }
    }
}
