package com.facebook.timeline.feed.parts;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.rows.core.FeedListName;
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
import com.facebook.timeline.datafetcher.section.TimelineSectionFetchParams;
import com.facebook.timeline.feed.events.TimelineLoadingIndicatorClickEvent;
import com.facebook.timeline.logging.TimelinePerformanceLogger;
import com.facebook.timeline.logging.TimelinePerformanceLogger.InitialUnitsLoadingIndicatorVisibility;
import com.facebook.timeline.units.model.TimelineSectionData.LoadingIndicator;
import com.facebook.timeline.units.model.TimelineSectionLoadState;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friends_nearby_dashboard_selfview_report_location */
public class TimelineLoadingIndicatorPartDefinition extends MultiRowSinglePartDefinition<LoadingIndicator, State, HasFeedListType, LoadingIndicatorView> {
    public static final ViewType f11185a = new C16201();
    private static TimelineLoadingIndicatorPartDefinition f11186e;
    private static final Object f11187f = new Object();
    public final TimelinePerformanceLogger f11188b;
    public final EventsStream f11189c;
    public final String f11190d;

    /* compiled from: friends_nearby_dashboard_selfview_report_location */
    final class C16201 extends ViewType {
        C16201() {
        }

        public final View m11320a(Context context) {
            LoadingIndicatorView loadingIndicatorView = new LoadingIndicatorView(context);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131429883);
            loadingIndicatorView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            return loadingIndicatorView;
        }
    }

    /* compiled from: friends_nearby_dashboard_selfview_report_location */
    public class State {
        public final LoadingIndicator f11183a;
        public final RetryClickedListener f11184b;

        public State(LoadingIndicator loadingIndicator, RetryClickedListener retryClickedListener) {
            this.f11183a = loadingIndicator;
            this.f11184b = retryClickedListener;
        }
    }

    private static TimelineLoadingIndicatorPartDefinition m11323b(InjectorLike injectorLike) {
        return new TimelineLoadingIndicatorPartDefinition(TimelinePerformanceLogger.a(injectorLike), EventsStream.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m11325a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final LoadingIndicator loadingIndicator = (LoadingIndicator) obj;
        return new State(loadingIndicator, new RetryClickedListener(this) {
            final /* synthetic */ TimelineLoadingIndicatorPartDefinition f11182b;

            public final void m11321a() {
                this.f11182b.f11189c.a(new TimelineLoadingIndicatorClickEvent(loadingIndicator));
            }
        });
    }

    public final /* bridge */ /* synthetic */ void m11326a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        Object obj3;
        int a = Logger.a(8, EntryType.MARK_PUSH, -786663661);
        State state = (State) obj2;
        LoadingIndicatorView loadingIndicatorView = (LoadingIndicatorView) view;
        FeedListName a2 = ((HasFeedListType) anyEnvironment).c().a();
        if (state.f11183a.f12777b == TimelineSectionLoadState.LOADING) {
            obj3 = 1;
        } else {
            obj3 = null;
        }
        if (obj3 != null) {
            loadingIndicatorView.a();
            TimelineSectionFetchParams timelineSectionFetchParams = state.f11183a.f12776a;
            if (timelineSectionFetchParams == null) {
                this.f11188b.a(true, InitialUnitsLoadingIndicatorVisibility.VISIBLE);
            } else if (a2 == FeedListName.MY_TIMELINE || a2 == FeedListName.OTHER_PERSON_TIMELINE) {
                TimelinePerformanceLogger timelinePerformanceLogger = this.f11188b;
                String str = timelineSectionFetchParams.f10697a;
                Preconditions.checkNotNull(str);
                if (!timelinePerformanceLogger.C.contains(str)) {
                    timelinePerformanceLogger.C.add(str);
                    timelinePerformanceLogger.b.e(1703957, str.hashCode());
                }
            }
        } else {
            if ((state.f11183a.f12777b == TimelineSectionLoadState.FAILED ? 1 : null) != null) {
                loadingIndicatorView.a(this.f11190d, state.f11184b);
            }
        }
        Logger.a(8, EntryType.MARK_POP, -983363826, a);
    }

    public final boolean m11327a(Object obj) {
        return !((LoadingIndicator) obj).m12735a();
    }

    public final void m11328b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        ((LoadingIndicatorView) view).e();
        if (state.f11183a.f12776a == null) {
            this.f11188b.a(false, InitialUnitsLoadingIndicatorVisibility.VISIBLE);
        }
    }

    public static TimelineLoadingIndicatorPartDefinition m11322a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineLoadingIndicatorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11187f) {
                TimelineLoadingIndicatorPartDefinition timelineLoadingIndicatorPartDefinition;
                if (a2 != null) {
                    timelineLoadingIndicatorPartDefinition = (TimelineLoadingIndicatorPartDefinition) a2.a(f11187f);
                } else {
                    timelineLoadingIndicatorPartDefinition = f11186e;
                }
                if (timelineLoadingIndicatorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11323b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11187f, b3);
                        } else {
                            f11186e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineLoadingIndicatorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public TimelineLoadingIndicatorPartDefinition(TimelinePerformanceLogger timelinePerformanceLogger, EventsStream eventsStream, Resources resources) {
        this.f11188b = timelinePerformanceLogger;
        this.f11189c = eventsStream;
        this.f11190d = resources.getString(2131234962);
    }

    public final ViewType m11324a() {
        return f11185a;
    }
}
