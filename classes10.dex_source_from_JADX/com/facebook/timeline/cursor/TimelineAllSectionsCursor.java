package com.facebook.timeline.cursor;

import android.content.Context;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.cursor.ModelCursor;
import com.facebook.graphql.model.FetchTimeMsHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTimelineSection;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.timeline.units.model.TimelineSectionData.LoadingIndicator;
import com.facebook.timeline.units.model.TimelineSectionData.TimelinePostsLabel;
import com.facebook.timeline.units.model.TimelineSectionData.TimelineSectionLabel;
import com.google.common.base.Preconditions;
import java.util.WeakHashMap;

@ContextScoped
/* compiled from: group_header */
public class TimelineAllSectionsCursor implements ListItemCollection<Object> {
    private static TimelineAllSectionsCursor f10380g;
    private static final Object f10381h = new Object();
    private final LoadingIndicator f10382a = new LoadingIndicator();
    private final TimelinePostsLabel f10383b = TimelinePostsLabel.m12737a();
    private final WeakHashMap<String, TimelineSectionLabel> f10384c = new WeakHashMap();
    private ModelCursor f10385d;
    private int f10386e = 0;
    public boolean f10387f = false;

    /* compiled from: group_header */
    public @interface ViewType {
    }

    private static TimelineAllSectionsCursor m10496b() {
        return new TimelineAllSectionsCursor();
    }

    public final synchronized void m10499a(ModelCursor modelCursor) {
        boolean z = true;
        synchronized (this) {
            int i;
            if (this.f10385d != null) {
                this.f10385d.close();
            }
            this.f10385d = modelCursor;
            if (this.f10385d == null) {
                i = 0;
            } else {
                i = this.f10385d.getCount();
            }
            this.f10386e = i;
            if (this.f10385d != null && this.f10385d.moveToLast()) {
                while (this.f10385d.f() == 1) {
                    this.f10386e--;
                    if (!this.f10385d.moveToPrevious()) {
                        break;
                    }
                }
            }
            if (this.f10386e < 0) {
                z = false;
            }
            Preconditions.checkState(z);
        }
    }

    public static TimelineAllSectionsCursor m10495a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineAllSectionsCursor b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10381h) {
                TimelineAllSectionsCursor timelineAllSectionsCursor;
                if (a2 != null) {
                    timelineAllSectionsCursor = (TimelineAllSectionsCursor) a2.a(f10381h);
                } else {
                    timelineAllSectionsCursor = f10380g;
                }
                if (timelineAllSectionsCursor == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m10496b();
                        if (a2 != null) {
                            a2.a(f10381h, b3);
                        } else {
                            f10380g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineAllSectionsCursor;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final int m10497a() {
        if (this.f10387f) {
            return this.f10386e + 1;
        }
        return this.f10386e;
    }

    public final Object m10498a(int i) {
        if (this.f10387f && i >= this.f10386e) {
            return this.f10382a;
        }
        Preconditions.checkState(this.f10385d.moveToPosition(i));
        switch (this.f10385d.f()) {
            case 1:
                GraphQLTimelineSection graphQLTimelineSection = (GraphQLTimelineSection) this.f10385d.d();
                TimelineSectionLabel timelineSectionLabel = (TimelineSectionLabel) this.f10384c.get(graphQLTimelineSection.j());
                if (timelineSectionLabel != null) {
                    return timelineSectionLabel;
                }
                Object timelineSectionLabel2 = new TimelineSectionLabel(graphQLTimelineSection.j(), graphQLTimelineSection.k(), false);
                this.f10384c.put(graphQLTimelineSection.j(), timelineSectionLabel2);
                return timelineSectionLabel2;
            case 2:
                return this.f10383b;
            default:
                MutableFlattenable mutableFlattenable = (MutableFlattenable) this.f10385d.d();
                if (mutableFlattenable instanceof GraphQLStory) {
                    FetchTimeMsHelper.a((GraphQLStory) mutableFlattenable, this.f10385d.c());
                }
                return mutableFlattenable;
        }
    }
}
