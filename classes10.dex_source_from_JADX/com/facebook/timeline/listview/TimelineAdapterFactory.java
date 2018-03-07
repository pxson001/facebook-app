package com.facebook.timeline.listview;

import android.content.Context;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.contextual.TimelineContextualInfoData;
import com.facebook.timeline.cursor.TimelineAllSectionsCursor;
import com.facebook.timeline.cursor.TimelineCursorHelper;
import com.facebook.timeline.environment.TimelineEnvironmentGenerated;
import com.facebook.timeline.feed.parts.TimelineFeedUnitRootPartDefinition;
import com.facebook.timeline.header.TimelineHeaderAdapterFactory;
import com.facebook.timeline.header.TimelineHeaderDataLogger;
import com.facebook.timeline.header.TimelineHeaderMultiAdapter;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.protiles.model.ProtilesData;
import com.facebook.timeline.protiles.rows.ProtilesRootGroupPartDefinition;
import com.facebook.timeline.publisher.PublisherData;
import com.facebook.timeline.publisher.rows.PublisherRootGroupPartDefinition;
import com.facebook.timeline.pymk.PeopleYouMayKnowData;
import com.facebook.timeline.pymk.rows.PeopleYouMayKnowSelectorPartDefinition;
import com.facebook.timeline.rows.TimelineListItemComparator;
import com.facebook.timeline.taggedmediaset.TimelineTaggedMediaSetData;
import com.facebook.timeline.units.model.TimelineAllSectionsData;
import com.facebook.widget.listview.ScrollingViewProxy;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetchFirstUnits() method should be used instead of this one for pages. */
public class TimelineAdapterFactory {
    private static TimelineAdapterFactory f12036p;
    private static final Object f12037q = new Object();
    private final Context f12038a;
    private final QeAccessor f12039b;
    private final TimelineHeaderAdapterFactory f12040c;
    private final MultiRowAdapterBuilder f12041d;
    private final ProtilesData f12042e;
    private final PeopleYouMayKnowData f12043f;
    private final TimelineAllSectionsData f12044g;
    private final TimelineAllSectionsCursor f12045h;
    private final Lazy<ProtilesRootGroupPartDefinition<FeedEnvironment>> f12046i;
    private final Lazy<PeopleYouMayKnowSelectorPartDefinition<FeedEnvironment>> f12047j;
    private final Lazy<TimelineFeedUnitRootPartDefinition> f12048k;
    private final Lazy<PublisherRootGroupPartDefinition> f12049l;
    private final PublisherData f12050m;
    private final TimelineListItemComparator f12051n;
    private final TimelineCursorHelper f12052o;

    private static TimelineAdapterFactory m12064b(InjectorLike injectorLike) {
        return new TimelineAdapterFactory((Context) injectorLike.getInstance(Context.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), TimelineHeaderAdapterFactory.m11419a(injectorLike), MultiRowAdapterBuilder.a(injectorLike), ProtilesData.m12116a(injectorLike), PeopleYouMayKnowData.m12492a(injectorLike), TimelineAllSectionsData.m12706a(injectorLike), TimelineAllSectionsCursor.m10495a(injectorLike), IdBasedLazy.a(injectorLike, 11334), IdBasedLazy.a(injectorLike, 11363), IdBasedLazy.a(injectorLike, 11235), IdBasedLazy.a(injectorLike, 11350), PublisherData.m12450a(injectorLike), TimelineListItemComparator.m12577a(injectorLike), TimelineCursorHelper.m10500a(injectorLike));
    }

    public static TimelineAdapterFactory m12063a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineAdapterFactory b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12037q) {
                TimelineAdapterFactory timelineAdapterFactory;
                if (a2 != null) {
                    timelineAdapterFactory = (TimelineAdapterFactory) a2.a(f12037q);
                } else {
                    timelineAdapterFactory = f12036p;
                }
                if (timelineAdapterFactory == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12064b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12037q, b3);
                        } else {
                            f12036p = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineAdapterFactory;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public TimelineAdapterFactory(Context context, QeAccessor qeAccessor, TimelineHeaderAdapterFactory timelineHeaderAdapterFactory, MultiRowAdapterBuilder multiRowAdapterBuilder, ProtilesData protilesData, PeopleYouMayKnowData peopleYouMayKnowData, TimelineAllSectionsData timelineAllSectionsData, TimelineAllSectionsCursor timelineAllSectionsCursor, Lazy<ProtilesRootGroupPartDefinition> lazy, Lazy<PeopleYouMayKnowSelectorPartDefinition> lazy2, Lazy<TimelineFeedUnitRootPartDefinition> lazy3, Lazy<PublisherRootGroupPartDefinition> lazy4, PublisherData publisherData, TimelineListItemComparator timelineListItemComparator, TimelineCursorHelper timelineCursorHelper) {
        this.f12038a = context;
        this.f12039b = qeAccessor;
        this.f12040c = timelineHeaderAdapterFactory;
        this.f12042e = protilesData;
        this.f12043f = peopleYouMayKnowData;
        this.f12044g = timelineAllSectionsData;
        this.f12045h = timelineAllSectionsCursor;
        this.f12041d = multiRowAdapterBuilder;
        this.f12046i = lazy;
        this.f12047j = lazy2;
        this.f12048k = lazy3;
        this.f12049l = lazy4;
        this.f12050m = publisherData;
        this.f12051n = timelineListItemComparator;
        this.f12052o = timelineCursorHelper;
    }

    public final TimelineAdapter m12065a(TimelineUserContext timelineUserContext, TimelineContextualInfoData timelineContextualInfoData, TimelineHeaderUserData timelineHeaderUserData, TimelineTaggedMediaSetData timelineTaggedMediaSetData, TimelineHeaderDataLogger timelineHeaderDataLogger, boolean z, TimelineEnvironmentGenerated timelineEnvironmentGenerated, ScrollingViewProxy scrollingViewProxy) {
        ListItemCollection listItemCollection;
        TimelineHeaderMultiAdapter a = this.f12040c.m11423a(this.f12038a, timelineUserContext, timelineContextualInfoData, timelineHeaderUserData, timelineTaggedMediaSetData, timelineHeaderDataLogger, Boolean.valueOf(z), false);
        if (this.f12052o.m10502a((TimelineContext) timelineUserContext)) {
            listItemCollection = this.f12045h;
        } else {
            listItemCollection = this.f12044g;
        }
        MultiRowAdapter e = this.f12041d.a(this.f12048k, listItemCollection).a(timelineEnvironmentGenerated).a(this.f12051n).b(scrollingViewProxy).e();
        MultiRowAdapter e2 = this.f12041d.a(this.f12046i, this.f12042e).a(timelineEnvironmentGenerated).e();
        MultiRowAdapter multiRowAdapter = null;
        if (this.f12039b.a(ExperimentsForTimelineAbTestModule.O, false)) {
            multiRowAdapter = this.f12041d.a(this.f12047j, this.f12043f).a(timelineEnvironmentGenerated).e();
        }
        if (!this.f12039b.a(ExperimentsForTimelineAbTestModule.G, false)) {
            MultiRowAdapter e3 = this.f12041d.a(this.f12049l, this.f12050m).a(timelineEnvironmentGenerated).e();
            if (multiRowAdapter == null) {
                return new TimelineAdapter(a, e3, e2, e, timelineHeaderUserData, this.f12042e);
            }
            return new TimelineAdapter(a, e3, e2, multiRowAdapter, e, timelineHeaderUserData, this.f12042e);
        } else if (multiRowAdapter == null) {
            return new TimelineAdapter(timelineHeaderUserData, this.f12042e, a, e2, e);
        } else {
            return new TimelineAdapter(timelineHeaderUserData, this.f12042e, a, e2, multiRowAdapter, e);
        }
    }
}
