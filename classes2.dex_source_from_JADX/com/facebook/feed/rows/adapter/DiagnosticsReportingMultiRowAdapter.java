package com.facebook.feed.rows.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.feed.rows.core.BoundedAdapter;
import com.facebook.feed.rows.core.ViewBindingsMap;
import com.facebook.feed.rows.core.binding.Binder;
import com.facebook.feed.rows.core.traversal.SinglePartHolder;
import com.facebook.inject.Assisted;
import com.facebook.widget.viewdiagnostics.DiagnosticsRunner;
import com.facebook.widget.viewdiagnostics.DiagnosticsRunner.Action;
import com.facebook.widget.viewdiagnostics.ViewDiagnostics;
import com.facebook.widget.viewdiagnostics.ViewDiagnosticsWrapper;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: method/logging.clientevent */
public class DiagnosticsReportingMultiRowAdapter extends DelegatingMultiRowRecyclerViewAdapter {
    private final DiagnosticsRunner f13603a;

    @Inject
    public DiagnosticsReportingMultiRowAdapter(@Assisted MultiRowRecyclerViewAdapter multiRowRecyclerViewAdapter, DiagnosticsRunner diagnosticsRunner) {
        super(multiRowRecyclerViewAdapter);
        this.f13603a = diagnosticsRunner;
    }

    public final void mo2225a(final ViewHolder viewHolder, final int i) {
        this.f13603a.m10048a(Action.BIND, new Callable<Binder<?>>(this) {
            final /* synthetic */ DiagnosticsReportingMultiRowAdapter f19250c;

            public Object call() {
                super.mo2225a(viewHolder, i);
                BoundedAdapter boundedAdapter = (BoundedAdapter) this.f19250c.getItem(i);
                return boundedAdapter.f13446a.m19049c(boundedAdapter.f13447b);
            }
        });
        View view = viewHolder.f14095a;
        if (view instanceof ViewDiagnosticsWrapper) {
            ViewDiagnosticsWrapper viewDiagnosticsWrapper = (ViewDiagnosticsWrapper) view;
            Object b = ViewBindingsMap.m20702b(viewDiagnosticsWrapper.getWrappedView());
            if (b != null) {
                DiagnosticsRunner diagnosticsRunner = this.f13603a;
                ViewDiagnostics a = DiagnosticsRunner.m10046a(view);
                if (a != null && (a.m19828c() || a.m19826b())) {
                    a.f13476r = DiagnosticsRunner.m10044a(diagnosticsRunner.f5889d, b);
                    a.f13474p = DiagnosticsRunner.m10044a(diagnosticsRunner.f5887b, b);
                    a.f13475q = DiagnosticsRunner.m10044a(diagnosticsRunner.f5888c, b);
                }
                diagnosticsRunner.f5889d.remove(b);
                diagnosticsRunner.f5887b.remove(b);
                if (b instanceof SinglePartHolder) {
                    viewDiagnosticsWrapper.f14281a.f13473o = ((SinglePartHolder) b).f13428a.getClass().getSimpleName();
                }
            }
        }
    }
}
