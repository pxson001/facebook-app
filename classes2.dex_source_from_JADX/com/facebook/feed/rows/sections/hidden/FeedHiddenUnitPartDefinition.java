package com.facebook.feed.rows.sections.hidden;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.facebook.common.android.FragmentActivityMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.feed.curationflow.CurationFlowManager;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.protocol.FetchCurationFlowGraphQLModels.FetchCurationFlowModel.FeedCurationFlowStepModel;
import com.facebook.feed.protocol.FetchCurationFlowGraphQLModels.FetchCurationFlowModel.FeedCurationFlowStepModel.ActionsModel;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hidden.ui.FeedHiddenUnitActionItemView;
import com.facebook.feed.rows.sections.hidden.ui.FeedHiddenUnitAnimationHelper;
import com.facebook.feed.rows.sections.hidden.ui.FeedHiddenUnitView;
import com.facebook.feed.rows.sections.hidden.ui.FeedHiddenUnitView.1;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.HideEvents$ChangeRendererEvent;
import com.facebook.feed.util.event.HideEvents$StoryVisibilityEvent;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.negativefeedback.video.RapidReportingController;
import com.facebook.proxygen.HTTPTransportCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: inline_composer */
public class FeedHiddenUnitPartDefinition<T extends NegativeFeedbackActionsUnit, E extends HasPositionInformation & HasPersistentState> extends MultiRowSinglePartDefinition<FeedProps<T>, State, E, FeedHiddenUnitView> {
    public static final ViewType f19920a = new C08111();
    private static final String f19921b = FeedHiddenUnitPartDefinition.class.getSimpleName();
    private static FeedHiddenUnitPartDefinition f19922i;
    private static final Object f19923j = new Object();
    private final FragmentActivity f19924c;
    public final FeedEventBus f19925d;
    public final CurationFlowManager f19926e;
    private final IFeedIntentBuilder f19927f;
    private final AbstractFbErrorReporter f19928g;
    private final RapidReportingController f19929h;

    /* compiled from: inline_composer */
    final class C08111 extends ViewType {
        C08111() {
        }

        public final View mo1995a(Context context) {
            return new FeedHiddenUnitView(context);
        }
    }

    private static FeedHiddenUnitPartDefinition m27710b(InjectorLike injectorLike) {
        return new FeedHiddenUnitPartDefinition(FragmentActivityMethodAutoProvider.m15506b(injectorLike), FeedEventBus.m4573a(injectorLike), CurationFlowManager.m18565a(injectorLike), DefaultFeedIntentBuilder.m26214a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), RapidReportingController.m18610b(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        CacheableEntity cacheableEntity = (NegativeFeedbackActionsUnit) ((FeedProps) obj).f13444a;
        return new State(cacheableEntity.mo2892r(), (FeedUnitVisibilityState) ((HasPersistentState) ((HasPositionInformation) anyEnvironment)).mo2425a(new FeedUnitVisibilityKey(cacheableEntity), cacheableEntity));
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        FeedHiddenUnitAnimationHelper feedHiddenUnitAnimationHelper = ((FeedHiddenUnitView) view).g;
        if (feedHiddenUnitAnimationHelper.a != null && !feedHiddenUnitAnimationHelper.a.hasEnded()) {
            feedHiddenUnitAnimationHelper.a.cancel();
            feedHiddenUnitAnimationHelper.a = null;
        }
    }

    public static FeedHiddenUnitPartDefinition m27702a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedHiddenUnitPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f19923j) {
                FeedHiddenUnitPartDefinition feedHiddenUnitPartDefinition;
                if (a2 != null) {
                    feedHiddenUnitPartDefinition = (FeedHiddenUnitPartDefinition) a2.mo818a(f19923j);
                } else {
                    feedHiddenUnitPartDefinition = f19922i;
                }
                if (feedHiddenUnitPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27710b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f19923j, b3);
                        } else {
                            f19922i = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedHiddenUnitPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public FeedHiddenUnitPartDefinition(FragmentActivity fragmentActivity, FeedEventBus feedEventBus, CurationFlowManager curationFlowManager, IFeedIntentBuilder iFeedIntentBuilder, AbstractFbErrorReporter abstractFbErrorReporter, RapidReportingController rapidReportingController) {
        this.f19924c = fragmentActivity;
        this.f19925d = feedEventBus;
        this.f19926e = curationFlowManager;
        this.f19927f = iFeedIntentBuilder;
        this.f19928g = abstractFbErrorReporter;
        this.f19929h = rapidReportingController;
    }

    private void m27707a(FeedHiddenUnitActionItemView feedHiddenUnitActionItemView, FeedHiddenUnitView feedHiddenUnitView, GraphQLNegativeFeedbackActionType graphQLNegativeFeedbackActionType, FeedProps<T> feedProps, State state) {
        NegativeFeedbackActionsUnit negativeFeedbackActionsUnit = (NegativeFeedbackActionsUnit) feedProps.f13444a;
        switch (10.b[graphQLNegativeFeedbackActionType.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                this.f19927f.mo3016a(feedHiddenUnitView.getContext(), FBLinks.bV);
                m27706a(this, StoryVisibility.GONE, negativeFeedbackActionsUnit, state);
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                if (negativeFeedbackActionsUnit != null && state.a != null) {
                    this.f19929h.m18612a(this.f19924c, feedProps, NegativeFeedbackExperienceLocation.NEWSFEED.stringValueOf(), 0);
                    return;
                }
                return;
            default:
                for (int i = 0; i < feedHiddenUnitView.e.getChildCount(); i++) {
                    boolean z;
                    FeedHiddenUnitActionItemView feedHiddenUnitActionItemView2 = (FeedHiddenUnitActionItemView) feedHiddenUnitView.e.getChildAt(i);
                    if (feedHiddenUnitActionItemView2 == feedHiddenUnitActionItemView) {
                        z = true;
                    } else {
                        z = false;
                    }
                    feedHiddenUnitActionItemView2.setSelected(z);
                }
                feedHiddenUnitView.setEnabled(false);
                this.f19926e.m18571a((FeedProps) feedProps, graphQLNegativeFeedbackActionType, new 6(this, feedHiddenUnitView, feedProps, state));
                return;
        }
    }

    public final ViewType mo2547a() {
        return f19920a;
    }

    public final boolean m27714a(Object obj) {
        return true;
    }

    public static int m27700a(FeedHiddenUnitPartDefinition feedHiddenUnitPartDefinition, State state) {
        Object obj;
        if (state.b.f18983a != 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            feedHiddenUnitPartDefinition.f19928g.m2340a(f19921b, "Unit pre-hidden height not set before hiding");
        }
        return state.b.f18983a;
    }

    private void m27709a(FeedHiddenUnitView feedHiddenUnitView, String str, FeedProps<T> feedProps, State state) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder(feedHiddenUnitView.getContext().getString(2131230753));
        spannableStringBuilder.setSpan(new 3(this, feedHiddenUnitView, feedProps, state), 0, spannableStringBuilder.length(), 18);
        feedHiddenUnitView.b.setText(new SpannableStringBuilder(str).append(" ").append(spannableStringBuilder));
    }

    public static void m27703a(FeedHiddenUnitPartDefinition feedHiddenUnitPartDefinition, Context context) {
        new Builder(context).a(false).b(context.getResources().getString(2131233435)).a(17039370, new 4(feedHiddenUnitPartDefinition)).a().show();
    }

    public static void m27706a(FeedHiddenUnitPartDefinition feedHiddenUnitPartDefinition, StoryVisibility storyVisibility, NegativeFeedbackActionsUnit negativeFeedbackActionsUnit, State state) {
        feedHiddenUnitPartDefinition.f19925d.mo651a(new HideEvents$StoryVisibilityEvent(negativeFeedbackActionsUnit.mo2507g(), null, null, storyVisibility, m27700a(feedHiddenUnitPartDefinition, state)));
        feedHiddenUnitPartDefinition.f19925d.mo651a(new HideEvents$ChangeRendererEvent());
    }

    public static void m27705a(FeedHiddenUnitPartDefinition feedHiddenUnitPartDefinition, FeedHiddenUnitView feedHiddenUnitView, State state, FeedProps feedProps) {
        FeedCurationFlowStepModel b = feedHiddenUnitPartDefinition.f19926e.m18577b(state.a);
        if (b != null) {
            Object obj;
            feedHiddenUnitPartDefinition.m27708a(feedHiddenUnitView, b, state, feedProps);
            if (feedHiddenUnitView.f.getVisibility() == 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null && !feedHiddenUnitPartDefinition.f19926e.m18576a(state.a, b.j().a())) {
                feedHiddenUnitView.g.a(feedHiddenUnitView.f, new 1(feedHiddenUnitView, m27700a(feedHiddenUnitPartDefinition, state), feedHiddenUnitView.g()));
            }
        }
    }

    private void m27708a(FeedHiddenUnitView feedHiddenUnitView, FeedCurationFlowStepModel feedCurationFlowStepModel, State state, FeedProps<T> feedProps) {
        boolean z = false;
        feedHiddenUnitView.i();
        for (int i = 0; i < feedCurationFlowStepModel.a().size(); i++) {
            ActionsModel actionsModel = (ActionsModel) feedCurationFlowStepModel.a().get(i);
            GraphQLNegativeFeedbackActionType j = actionsModel.j();
            FeedHiddenUnitActionItemView h = feedHiddenUnitView.h();
            h.a(actionsModel.l().a()).setOnClickListener(new 5(this, h, feedHiddenUnitView, j, feedProps, state));
            h.a(m27701a(feedHiddenUnitView.getContext(), actionsModel));
            h.a(this.f19926e.m18576a(state.a, j));
        }
        m27709a(feedHiddenUnitView, feedCurationFlowStepModel.k().a(), (FeedProps) feedProps, state);
        if (!this.f19926e.m18575a(state.a)) {
            z = true;
        }
        feedHiddenUnitView.setEnabled(z);
    }

    @Nullable
    private static Drawable m27701a(Context context, ActionsModel actionsModel) {
        Resources resources = context.getResources();
        switch (10.b[actionsModel.j().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return resources.getDrawable(2130840244);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return resources.getDrawable(2130840243);
            case 3:
                return resources.getDrawable(2130840245);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
            case 5:
            case 6:
            case 7:
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
            case 9:
                return resources.getDrawable(2130840246);
            default:
                switch (10.c[actionsModel.k().ordinal()]) {
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        return resources.getDrawable(2130840241);
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                        return resources.getDrawable(2130840239);
                    case 3:
                        return resources.getDrawable(2130840242);
                    case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                        return resources.getDrawable(2130840238);
                    case 5:
                        return resources.getDrawable(2130840237);
                    default:
                        return null;
                }
        }
    }
}
