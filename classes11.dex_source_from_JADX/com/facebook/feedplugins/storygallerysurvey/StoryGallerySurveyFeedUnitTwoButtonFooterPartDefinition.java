package com.facebook.feedplugins.storygallerysurvey;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.HideEvents.ChangeRendererEvent;
import com.facebook.feed.util.event.HideEvents.StoryVisibilityEvent;
import com.facebook.feedplugins.base.footer.OneButtonFooterStylerPartDefinition;
import com.facebook.feedplugins.base.footer.ui.TwoButtonFooterView;
import com.facebook.feedplugins.base.footer.ui.TwoButtonFooterView.Button;
import com.facebook.feedplugins.storygallerysurvey.constants.StoryGallerySurveyConstants.ActionType;
import com.facebook.feedplugins.storygallerysurvey.logger.StoryGallerySurveyLogger;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.GraphQLStoryGallerySurveyFeedUnit;
import com.facebook.graphql.model.PropertyHelper;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: ble_params */
public class StoryGallerySurveyFeedUnitTwoButtonFooterPartDefinition extends MultiRowSinglePartDefinition<GraphQLStoryGallerySurveyFeedUnit, State, HasPositionInformation, TwoButtonFooterView> {
    public static final String f9513a = FBLinks.eL;
    private static StoryGallerySurveyFeedUnitTwoButtonFooterPartDefinition f9514f;
    private static final Object f9515g = new Object();
    public final FbUriIntentHandler f9516b;
    private final OneButtonFooterStylerPartDefinition f9517c;
    public final StoryGallerySurveyLogger f9518d;
    private final FeedEventBus f9519e;

    /* compiled from: ble_params */
    public class State {
        public final String f9509a;
        public final String f9510b;
        public final OnClickListener f9511c;
        public final OnClickListener f9512d;

        public State(String str, String str2, OnClickListener onClickListener, OnClickListener onClickListener2) {
            this.f9509a = str;
            this.f9510b = str2;
            this.f9511c = onClickListener;
            this.f9512d = onClickListener2;
        }
    }

    private static StoryGallerySurveyFeedUnitTwoButtonFooterPartDefinition m10059b(InjectorLike injectorLike) {
        return new StoryGallerySurveyFeedUnitTwoButtonFooterPartDefinition(FbUriIntentHandler.a(injectorLike), OneButtonFooterStylerPartDefinition.a(injectorLike), StoryGallerySurveyLogger.m10068b(injectorLike), FeedEventBus.a(injectorLike));
    }

    public final Object m10061a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final GraphQLStoryGallerySurveyFeedUnit graphQLStoryGallerySurveyFeedUnit = (GraphQLStoryGallerySurveyFeedUnit) obj;
        String a = graphQLStoryGallerySurveyFeedUnit.l().a();
        String a2 = graphQLStoryGallerySurveyFeedUnit.k().a();
        C11311 c11311 = new OnClickListener(this) {
            final /* synthetic */ StoryGallerySurveyFeedUnitTwoButtonFooterPartDefinition f9503b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -726774991);
                StoryGallerySurveyFeedUnitTwoButtonFooterPartDefinition.m10058a(this.f9503b, graphQLStoryGallerySurveyFeedUnit, view);
                this.f9503b.f9518d.m10070a(ActionType.HIDE, graphQLStoryGallerySurveyFeedUnit);
                this.f9503b.f9518d.m10069a(ActionType.HIDE);
                Logger.a(2, EntryType.UI_INPUT_END, -416773425, a);
            }
        };
        C11332 c11332 = new OnClickListener(this) {
            public final /* synthetic */ StoryGallerySurveyFeedUnitTwoButtonFooterPartDefinition f9508b;

            public void onClick(final View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -474709069);
                final StoryGallerySurveyStartPopoverWindow storyGallerySurveyStartPopoverWindow = new StoryGallerySurveyStartPopoverWindow(view.getContext());
                storyGallerySurveyStartPopoverWindow.f9521a = new Object(this) {
                    public final /* synthetic */ C11332 f9506c;
                };
                storyGallerySurveyStartPopoverWindow.a(view);
                this.f9508b.f9518d.m10070a(ActionType.TAKEN, graphQLStoryGallerySurveyFeedUnit);
                this.f9508b.f9518d.m10069a(ActionType.TAKEN);
                Logger.a(2, EntryType.UI_INPUT_END, 1420518675, a);
            }
        };
        if (!PropertyHelper.a(graphQLStoryGallerySurveyFeedUnit)) {
            this.f9518d.m10069a(ActionType.SEEN);
        }
        subParts.a(this.f9517c, null);
        return new State(a, a2, c11311, c11332);
    }

    public final /* bridge */ /* synthetic */ void m10062a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1223409961);
        State state = (State) obj2;
        TwoButtonFooterView twoButtonFooterView = (TwoButtonFooterView) view;
        twoButtonFooterView.a(Button.LEFT, state.f9510b);
        twoButtonFooterView.a(Button.LEFT, state.f9511c);
        twoButtonFooterView.a(Button.RIGHT, state.f9509a);
        twoButtonFooterView.a(Button.RIGHT, state.f9512d);
        Logger.a(8, EntryType.MARK_POP, -58549596, a);
    }

    public final void m10064b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        TwoButtonFooterView twoButtonFooterView = (TwoButtonFooterView) view;
        twoButtonFooterView.a(Button.LEFT, null);
        twoButtonFooterView.a(Button.RIGHT, null);
    }

    public static StoryGallerySurveyFeedUnitTwoButtonFooterPartDefinition m10057a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StoryGallerySurveyFeedUnitTwoButtonFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9515g) {
                StoryGallerySurveyFeedUnitTwoButtonFooterPartDefinition storyGallerySurveyFeedUnitTwoButtonFooterPartDefinition;
                if (a2 != null) {
                    storyGallerySurveyFeedUnitTwoButtonFooterPartDefinition = (StoryGallerySurveyFeedUnitTwoButtonFooterPartDefinition) a2.a(f9515g);
                } else {
                    storyGallerySurveyFeedUnitTwoButtonFooterPartDefinition = f9514f;
                }
                if (storyGallerySurveyFeedUnitTwoButtonFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10059b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9515g, b3);
                        } else {
                            f9514f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storyGallerySurveyFeedUnitTwoButtonFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public StoryGallerySurveyFeedUnitTwoButtonFooterPartDefinition(FbUriIntentHandler fbUriIntentHandler, OneButtonFooterStylerPartDefinition oneButtonFooterStylerPartDefinition, StoryGallerySurveyLogger storyGallerySurveyLogger, FeedEventBus feedEventBus) {
        this.f9516b = fbUriIntentHandler;
        this.f9517c = oneButtonFooterStylerPartDefinition;
        this.f9518d = storyGallerySurveyLogger;
        this.f9519e = feedEventBus;
    }

    public final boolean m10063a(Object obj) {
        return true;
    }

    public final ViewType m10060a() {
        return TwoButtonFooterView.a;
    }

    public static void m10058a(StoryGallerySurveyFeedUnitTwoButtonFooterPartDefinition storyGallerySurveyFeedUnitTwoButtonFooterPartDefinition, GraphQLStoryGallerySurveyFeedUnit graphQLStoryGallerySurveyFeedUnit, View view) {
        storyGallerySurveyFeedUnitTwoButtonFooterPartDefinition.f9519e.a(new StoryVisibilityEvent(graphQLStoryGallerySurveyFeedUnit.g(), null, null, StoryVisibility.GONE, view.getMeasuredHeight()));
        storyGallerySurveyFeedUnitTwoButtonFooterPartDefinition.f9519e.a(new ChangeRendererEvent());
    }
}
