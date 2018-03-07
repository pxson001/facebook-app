package com.facebook.timeline.feed.parts;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.facebook.timeline.feed.events.TimelineScrubberClickEvent;
import com.facebook.timeline.feed.ui.ScrubberView;
import com.facebook.timeline.units.model.TimelineSectionData.Scrubber;
import com.facebook.timeline.units.model.TimelineSectionData.TimelineSectionLabel;
import com.facebook.widget.CustomViewUtils;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friends_nearby_dashboard_scroll_forward_during_session */
public class TimelineScrubberPartDefinition extends MultiRowSinglePartDefinition<Scrubber, State, HasFeedListType, ScrubberView> {
    public static final ViewType f11212a = new C16241();
    private static TimelineScrubberPartDefinition f11213f;
    private static final Object f11214g = new Object();
    private final Drawable f11215b;
    private final Drawable f11216c;
    public final EventsStream f11217d;
    private final String f11218e;

    /* compiled from: friends_nearby_dashboard_scroll_forward_during_session */
    final class C16241 extends ViewType {
        C16241() {
        }

        public final View m11349a(Context context) {
            return new ScrubberView(context);
        }
    }

    /* compiled from: friends_nearby_dashboard_scroll_forward_during_session */
    public class State {
        public final String f11208a;
        public final Drawable f11209b;
        public final boolean f11210c;
        public final OnClickListener f11211d;

        public State(String str, Drawable drawable, boolean z, OnClickListener onClickListener) {
            this.f11208a = str;
            this.f11209b = drawable;
            this.f11210c = z;
            this.f11211d = onClickListener;
        }
    }

    private static TimelineScrubberPartDefinition m11351b(InjectorLike injectorLike) {
        return new TimelineScrubberPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), EventsStream.a(injectorLike));
    }

    public final Object m11353a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        OnClickListener onClickListener;
        Object obj2;
        Drawable drawable;
        final Scrubber scrubber = (Scrubber) obj;
        HasFeedListType hasFeedListType = (HasFeedListType) anyEnvironment;
        String str = scrubber instanceof TimelineSectionLabel ? ((TimelineSectionLabel) scrubber).f12785c : this.f11218e;
        boolean a = scrubber.m12736a();
        if (a) {
            onClickListener = null;
        } else {
            onClickListener = new OnClickListener(this) {
                final /* synthetic */ TimelineScrubberPartDefinition f11207b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1314596561);
                    this.f11207b.f11217d.a(new TimelineScrubberClickEvent(scrubber));
                    Logger.a(2, EntryType.UI_INPUT_END, 376727482, a);
                }
            };
        }
        if (hasFeedListType.c().a() != FeedListName.PAGE_TIMELINE) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            drawable = this.f11215b;
        } else {
            drawable = this.f11216c;
        }
        return new State(str, drawable, a, onClickListener);
    }

    public final /* bridge */ /* synthetic */ void m11354a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -353596225);
        State state = (State) obj2;
        ScrubberView scrubberView = (ScrubberView) view;
        scrubberView.f11223a.setText(state.f11208a);
        scrubberView.f11224b.setVisibility(state.f11210c ? 0 : 8);
        CustomViewUtils.b(scrubberView, state.f11209b);
        scrubberView.setPadding(scrubberView.f11225c, scrubberView.f11225c, scrubberView.f11225c, scrubberView.f11225c);
        scrubberView.setOnClickListener(state.f11211d);
        Logger.a(8, EntryType.MARK_POP, 801554085, a);
    }

    public final void m11356b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((ScrubberView) view).setOnClickListener(null);
    }

    public static TimelineScrubberPartDefinition m11350a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineScrubberPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11214g) {
                TimelineScrubberPartDefinition timelineScrubberPartDefinition;
                if (a2 != null) {
                    timelineScrubberPartDefinition = (TimelineScrubberPartDefinition) a2.a(f11214g);
                } else {
                    timelineScrubberPartDefinition = f11213f;
                }
                if (timelineScrubberPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11351b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11214g, b3);
                        } else {
                            f11213f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineScrubberPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public TimelineScrubberPartDefinition(Resources resources, EventsStream eventsStream) {
        this.f11217d = eventsStream;
        this.f11215b = new ColorDrawable(resources.getColor(2131362148));
        this.f11216c = resources.getDrawable(2130843646);
        this.f11218e = resources.getString(2131234902);
    }

    public final ViewType m11352a() {
        return f11212a;
    }

    public final boolean m11355a(Object obj) {
        return true;
    }
}
