package com.facebook.timeline.protiles.rows;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
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
import com.facebook.timeline.logging.TimelinePerformanceLogger;
import com.facebook.timeline.protiles.events.ProtilesLoadDataEvent;
import com.facebook.timeline.protiles.events.ProtilesLoadDataEvent.Type;
import com.facebook.timeline.protiles.model.ProtilesLoadingData;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fbconnect */
public class ProtilesLoadingIndicatorPartDefinition extends MultiRowSinglePartDefinition<ProtilesLoadingData, RetryClickedListener, AnyEnvironment, LoadingIndicatorView> {
    public static final ViewType f12290a = new C17441();
    private static ProtilesLoadingIndicatorPartDefinition f12291e;
    private static final Object f12292f = new Object();
    public final String f12293b;
    public final EventsStream f12294c;
    public final TimelinePerformanceLogger f12295d;

    /* compiled from: fbconnect */
    final class C17441 extends ViewType {
        C17441() {
        }

        public final View m12345a(Context context) {
            LoadingIndicatorView loadingIndicatorView = new LoadingIndicatorView(context);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131433965);
            loadingIndicatorView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            return loadingIndicatorView;
        }
    }

    /* compiled from: fbconnect */
    class C17452 implements RetryClickedListener {
        final /* synthetic */ ProtilesLoadingIndicatorPartDefinition f12289a;

        C17452(ProtilesLoadingIndicatorPartDefinition protilesLoadingIndicatorPartDefinition) {
            this.f12289a = protilesLoadingIndicatorPartDefinition;
        }

        public final void m12346a() {
            this.f12289a.f12294c.a(new ProtilesLoadDataEvent(Type.FULL_DATA, null, null, null, 0));
        }
    }

    private static ProtilesLoadingIndicatorPartDefinition m12348b(InjectorLike injectorLike) {
        return new ProtilesLoadingIndicatorPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), EventsStream.a(injectorLike), TimelinePerformanceLogger.a(injectorLike));
    }

    public final Object m12350a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        if (((ProtilesLoadingData) obj).m12124b()) {
            return new C17452(this);
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ void m12351a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -145078965);
        ProtilesLoadingData protilesLoadingData = (ProtilesLoadingData) obj;
        RetryClickedListener retryClickedListener = (RetryClickedListener) obj2;
        LoadingIndicatorView loadingIndicatorView = (LoadingIndicatorView) view;
        if (protilesLoadingData.m12123a()) {
            loadingIndicatorView.a();
        } else if (protilesLoadingData.m12124b()) {
            loadingIndicatorView.a(this.f12293b, retryClickedListener);
        }
        this.f12295d.w = true;
        Logger.a(8, EntryType.MARK_POP, -378170804, a);
    }

    public final boolean m12352a(Object obj) {
        ProtilesLoadingData protilesLoadingData = (ProtilesLoadingData) obj;
        return protilesLoadingData.m12123a() || protilesLoadingData.m12124b();
    }

    public final void m12353b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        LoadingIndicatorView loadingIndicatorView = (LoadingIndicatorView) view;
        this.f12295d.w = false;
        loadingIndicatorView.e();
    }

    @Inject
    public ProtilesLoadingIndicatorPartDefinition(Resources resources, EventsStream eventsStream, TimelinePerformanceLogger timelinePerformanceLogger) {
        this.f12294c = eventsStream;
        this.f12295d = timelinePerformanceLogger;
        this.f12293b = resources.getString(2131230797);
    }

    public final ViewType m12349a() {
        return f12290a;
    }

    public static ProtilesLoadingIndicatorPartDefinition m12347a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProtilesLoadingIndicatorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12292f) {
                ProtilesLoadingIndicatorPartDefinition protilesLoadingIndicatorPartDefinition;
                if (a2 != null) {
                    protilesLoadingIndicatorPartDefinition = (ProtilesLoadingIndicatorPartDefinition) a2.a(f12292f);
                } else {
                    protilesLoadingIndicatorPartDefinition = f12291e;
                }
                if (protilesLoadingIndicatorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12348b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12292f, b3);
                        } else {
                            f12291e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = protilesLoadingIndicatorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
