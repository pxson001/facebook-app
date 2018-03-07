package com.facebook.events.permalink.multirow;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeView;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventViewerCapability;
import com.facebook.events.permalink.composeractionbar.EventFeedComposer;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.user.model.User;
import com.google.common.annotations.VisibleForTesting;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: bearing */
public class EventFeedComposerRootPartDefinition extends MultiRowSinglePartDefinition<Event, State, CanPostToEventWall, EventFeedComposer> {
    @VisibleForTesting
    static final CallerContext f18700a = CallerContext.a(EventFeedComposerRootPartDefinition.class, "event_permalink");
    public static final ViewType<EventFeedComposer> f18701b = ViewType.a(2130904032);
    private static EventFeedComposerRootPartDefinition f18702f;
    private static final Object f18703g = new Object();
    private final FbDraweeControllerBuilder f18704c;
    public final Provider<User> f18705d;
    public final Provider<IFeedIntentBuilder> f18706e;

    /* compiled from: bearing */
    public class State {
        public final DraweeController f18696a;
        public final OnClickListener f18697b;
        public final OnClickListener f18698c;
        public final OnClickListener f18699d;

        public State(DraweeController draweeController, OnClickListener onClickListener, OnClickListener onClickListener2, OnClickListener onClickListener3) {
            this.f18696a = draweeController;
            this.f18697b = onClickListener;
            this.f18698c = onClickListener2;
            this.f18699d = onClickListener3;
        }
    }

    private static EventFeedComposerRootPartDefinition m18992b(InjectorLike injectorLike) {
        return new EventFeedComposerRootPartDefinition(FbDraweeControllerBuilder.b(injectorLike), IdBasedProvider.a(injectorLike, 3595), IdBasedSingletonScopeProvider.a(injectorLike, 2347));
    }

    public final Object m18994a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String str;
        Uri uri;
        C26631 c26631;
        final Event event = (Event) obj;
        final CanPostToEventWall canPostToEventWall = (CanPostToEventWall) anyEnvironment;
        FbDraweeControllerBuilder a = this.f18704c.a(f18700a);
        if (event.v != null) {
            str = event.w;
        } else {
            str = ((User) this.f18705d.get()).x();
        }
        String str2 = str;
        if (str2 == null) {
            uri = null;
        } else {
            uri = Uri.parse(str2);
        }
        FbPipelineDraweeController s = a.b(uri).s();
        if (event == null) {
            c26631 = null;
        } else {
            c26631 = new OnClickListener(this) {
                public final /* synthetic */ EventFeedComposerRootPartDefinition f18689b;

                public void onClick(View view) {
                    String formatStrLocaleSafe;
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 469807944);
                    IFeedIntentBuilder iFeedIntentBuilder = (IFeedIntentBuilder) this.f18689b.f18706e.get();
                    Context context = view.getContext();
                    if (event.v != null) {
                        formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.af, event.v);
                    } else {
                        formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, ((User) this.f18689b.f18705d.get()).a);
                    }
                    iFeedIntentBuilder.a(context, formatStrLocaleSafe);
                    Logger.a(2, EntryType.UI_INPUT_END, -32672640, a);
                }
            };
        }
        return new State(s, c26631, new OnClickListener(this) {
            final /* synthetic */ EventFeedComposerRootPartDefinition f18692c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1295900254);
                canPostToEventWall.mo847a(view.getContext(), event);
                Logger.a(2, EntryType.UI_INPUT_END, 473173759, a);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ EventFeedComposerRootPartDefinition f18695c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -464347802);
                canPostToEventWall.mo848b(view.getContext(), event);
                Logger.a(2, EntryType.UI_INPUT_END, 1609757858, a);
            }
        });
    }

    public final /* bridge */ /* synthetic */ void m18995a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1507080863);
        State state = (State) obj2;
        EventFeedComposer eventFeedComposer = (EventFeedComposer) view;
        DraweeView draweeView = eventFeedComposer.f18316a;
        draweeView.setController(state.f18696a);
        draweeView.setOnClickListener(state.f18697b);
        eventFeedComposer.f18318c.setOnClickListener(state.f18699d);
        eventFeedComposer.setOnClickListener(state.f18698c);
        Logger.a(8, EntryType.MARK_POP, -1276500459, a);
    }

    public final boolean m18996a(Object obj) {
        return ((Event) obj).a(EventViewerCapability.POST);
    }

    public final void m18997b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        EventFeedComposer eventFeedComposer = (EventFeedComposer) view;
        DraweeView draweeView = eventFeedComposer.f18316a;
        draweeView.setController(null);
        draweeView.setOnClickListener(null);
        eventFeedComposer.f18318c.setOnClickListener(null);
        eventFeedComposer.setOnClickListener(null);
    }

    public static EventFeedComposerRootPartDefinition m18991a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventFeedComposerRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18703g) {
                EventFeedComposerRootPartDefinition eventFeedComposerRootPartDefinition;
                if (a2 != null) {
                    eventFeedComposerRootPartDefinition = (EventFeedComposerRootPartDefinition) a2.a(f18703g);
                } else {
                    eventFeedComposerRootPartDefinition = f18702f;
                }
                if (eventFeedComposerRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m18992b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18703g, b3);
                        } else {
                            f18702f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = eventFeedComposerRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public EventFeedComposerRootPartDefinition(FbDraweeControllerBuilder fbDraweeControllerBuilder, Provider<User> provider, Provider<IFeedIntentBuilder> provider2) {
        this.f18705d = provider;
        this.f18706e = provider2;
        this.f18704c = fbDraweeControllerBuilder;
    }

    public final ViewType<EventFeedComposer> m18993a() {
        return f18701b;
    }
}
