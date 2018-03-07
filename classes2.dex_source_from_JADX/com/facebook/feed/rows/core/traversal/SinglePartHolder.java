package com.facebook.feed.rows.core.traversal;

import android.view.View;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.feed.rows.core.analytics.MultiRowPerfLogger;
import com.facebook.feed.rows.core.binding.Binder;
import com.facebook.feed.rows.core.parts.SinglePartDefinitionBinder;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinitionWithViewTypeAndIsNeeded;
import com.facebook.multirow.api.ViewType;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.annotations.VisibleForTesting;

/* compiled from: ml_IN */
public class SinglePartHolder<P, S, E extends AnyEnvironment, V extends View> extends Binder<V> {
    public final SinglePartDefinitionWithViewTypeAndIsNeeded<P, S, E, V> f13428a;
    public final GroupPartHolder<?, ?, ?> f13429b;
    public final RowKey f13430c = new RowKey();
    public final P f13431d;
    private final MultiRowPerfLogger f13432e;
    private final Binder<V> f13433f;
    public boolean f13434g = false;
    private PartHolderDebugUtil$1 f13435h;

    public SinglePartHolder(SinglePartDefinitionWithViewTypeAndIsNeeded<P, S, E, V> singlePartDefinitionWithViewTypeAndIsNeeded, GroupPartHolder<?, ?, ?> groupPartHolder, P p, MultiRowPerfLogger multiRowPerfLogger) {
        this.f13428a = singlePartDefinitionWithViewTypeAndIsNeeded;
        this.f13429b = groupPartHolder;
        this.f13431d = p;
        this.f13432e = multiRowPerfLogger;
        this.f13433f = new SinglePartDefinitionBinder(this.f13431d, this.f13428a);
    }

    public final void mo2634a(AnyEnvironment anyEnvironment) {
        TracerDetour.a("SinglePartHolder.prepare", -1340100320);
        try {
            this.f13432e.mo1983a(this.f13428a, 1);
            this.f13432e.mo1981a(1, anyEnvironment);
            this.f13433f.mo2634a(anyEnvironment);
            m19776a(1);
            this.f13432e.mo1980a(1);
            this.f13434g = true;
        } catch (Throwable e) {
            WrappedTraversalException.a(this, e, "preparing");
        } finally {
            TracerDetour.a(1913591437);
        }
    }

    public final void mo2633a(V v) {
        TracerDetour.a("SinglePartHolder.bind", -1946144388);
        try {
            this.f13429b.m19105a((View) v, m19779b());
            this.f13432e.mo1983a(this.f13428a, 2);
            this.f13433f.mo2633a((View) v);
            m19776a(2);
            this.f13432e.mo1980a(2);
        } catch (Throwable e) {
            WrappedTraversalException.a(this, e, "binding");
        } finally {
            TracerDetour.a(1784395356);
        }
    }

    public final void mo2635b(V v) {
        TracerDetour.a("SinglePartHolder.unbind", 1506335901);
        try {
            this.f13432e.mo1983a(this.f13428a, 3);
            this.f13433f.mo2635b((View) v);
            m19776a(3);
            this.f13432e.mo1980a(3);
            this.f13429b.m19109b(v, m19779b());
        } catch (Throwable e) {
            WrappedTraversalException.a(this, e, "unbinding");
        } finally {
            TracerDetour.a(403751733);
        }
    }

    public final void mo2636b(AnyEnvironment anyEnvironment) {
        try {
            this.f13433f.mo2636b(anyEnvironment);
            this.f13434g = false;
        } catch (Throwable e) {
            WrappedTraversalException.a(this, e, "releasing");
        }
    }

    public final ViewType<V> m19779b() {
        return this.f13428a.mo2547a();
    }

    @VisibleForTesting
    public final P m19782i() {
        return this.f13431d;
    }

    @VisibleForTesting
    public final GroupPartHolder<?, ?, ?> m19783j() {
        return this.f13429b;
    }

    private void m19776a(int i) {
        if (this.f13435h == null) {
            this.f13435h = new PartHolderDebugUtil$1(this);
        }
        this.f13432e.mo1982a(i, this.f13435h);
    }
}
