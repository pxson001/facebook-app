package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionStoryAttachmentStoryFragmentModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionStoryAttachmentStoryFragmentModel.ActorsModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionStoryAttachmentStoryFragmentModel.FeedbackModel;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.ReactionReviewUnitComponentFragmentModel.SpotlightStoryPreviewModel;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.ReactionReviewUnitComponentFragmentModel.SpotlightStoryPreviewModel.FormattedPreviewModel;
import com.facebook.reviews.util.helper.ReviewsRatingHelper;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: action_links_location */
public class ReactionReviewUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasPrefetcher & HasRowKey> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, ContentView> {
    public static final CallerContext f20038a = CallerContext.a(ReactionReviewUnitComponentPartDefinition.class);
    public static final String f20039b = ReactionReviewUnitComponentPartDefinition.class.getCanonicalName();
    public static final ViewType<ContentView> f20040c = new C21421();
    private static ReactionReviewUnitComponentPartDefinition f20041j;
    private static final Object f20042k = new Object();
    private final ClickListenerPartDefinition f20043d;
    public final TimeFormatUtil f20044e;
    private final FbDraweePartDefinition<E> f20045f;
    private final AbstractFbErrorReporter f20046g;
    public final ReactionIntentFactory f20047h;
    private final ReviewsRatingHelper f20048i;

    /* compiled from: action_links_location */
    final class C21421 extends ViewType {
        C21421() {
        }

        public final View m23919a(Context context) {
            return (ContentView) LayoutInflater.from(context).inflate(2130906651, null);
        }
    }

    /* compiled from: action_links_location */
    public class State {
        @Nullable
        public final String f20036a;
        @Nullable
        public final SpannableStringBuilder f20037b;

        public State(@Nullable String str, @Nullable SpannableStringBuilder spannableStringBuilder) {
            this.f20036a = str;
            this.f20037b = spannableStringBuilder;
        }
    }

    private static ReactionReviewUnitComponentPartDefinition m23922b(InjectorLike injectorLike) {
        return new ReactionReviewUnitComponentPartDefinition(ClickListenerPartDefinition.a(injectorLike), DefaultTimeFormatUtil.a(injectorLike), FbDraweePartDefinition.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ReactionIntentFactory.m22683a(injectorLike), ReviewsRatingHelper.m4932a(injectorLike));
    }

    @Nullable
    private SpannableStringBuilder m23920a(ReactionUnitComponentNode reactionUnitComponentNode, Context context) {
        FormattedPreviewModel b = reactionUnitComponentNode.f18862b.cA().b();
        if (b.a() == null) {
            return null;
        }
        CharSequence a = b.a().a();
        if (b.b()) {
            a = "…" + a;
        }
        int a2 = reactionUnitComponentNode.f18862b.cA().a();
        if (a2 == 0) {
            return SpannableStringBuilder.valueOf(a);
        }
        return new SpannableStringBuilder().append(this.f20048i.m4935a(a2, context.getResources().getDimensionPixelSize(2131427404))).append(" ").append(a);
    }

    public static ReactionStoryAttachmentStoryFragmentModel m23925h(ReactionUnitComponentNode reactionUnitComponentNode) {
        return reactionUnitComponentNode.f18862b.cA().c();
    }

    public final Object m23927a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        final CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        String a = this.f20044e.a(TimeFormatStyle.FUZZY_RELATIVE_DATE_STYLE, m23925h(reactionUnitComponentNode).d() * 1000);
        SpannableStringBuilder a2 = m23920a(reactionUnitComponentNode, ((HasContext) canLaunchReactionIntent).getContext());
        String d = m23923d(reactionUnitComponentNode);
        if (d != null) {
            FbDraweePartDefinition fbDraweePartDefinition = this.f20045f;
            Builder a3 = FbDraweePartDefinition.a().a(d);
            a3.c = f20038a;
            subParts.a(2131566691, fbDraweePartDefinition, a3.a());
        }
        d = m23924e(reactionUnitComponentNode);
        if (d != null) {
            subParts.a(this.f20043d, new OnClickListener(this) {
                final /* synthetic */ ReactionReviewUnitComponentPartDefinition f20035d;

                public void onClick(View view) {
                    String a;
                    int a2 = Logger.a(2, EntryType.UI_INPUT_START, 834558462);
                    ReactionIntentFactory reactionIntentFactory = this.f20035d.f20047h;
                    String str = d;
                    ReactionReviewUnitComponentPartDefinition reactionReviewUnitComponentPartDefinition = this.f20035d;
                    String c = ReactionReviewUnitComponentPartDefinition.m23925h(reactionUnitComponentNode).c();
                    ReactionReviewUnitComponentPartDefinition reactionReviewUnitComponentPartDefinition2 = this.f20035d;
                    FeedbackModel eN_ = ReactionReviewUnitComponentPartDefinition.m23925h(reactionUnitComponentNode).eN_();
                    if (eN_ != null) {
                        a = eN_.a();
                    } else {
                        a = null;
                    }
                    canLaunchReactionIntent.mo695a(reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d, reactionIntentFactory.m22748a(str, c, a, UnitInteractionType.STORY_TAP));
                    Logger.a(2, EntryType.UI_INPUT_END, 876645986, a2);
                }
            });
        }
        return new State(a, a2);
    }

    public final /* bridge */ /* synthetic */ void m23928a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 594598895);
        State state = (State) obj2;
        ContentView contentView = (ContentView) view;
        contentView.setTitleText(state.f20037b);
        contentView.setSubtitleText(state.f20036a);
        Logger.a(8, EntryType.MARK_POP, 944494389, a);
    }

    public final boolean m23929a(Object obj) {
        SpotlightStoryPreviewModel cA = ((ReactionUnitComponentNode) obj).f18862b.cA();
        return (cA == null || cA.b() == null || cA.c() == null) ? false : true;
    }

    public static ReactionReviewUnitComponentPartDefinition m23921a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionReviewUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20042k) {
                ReactionReviewUnitComponentPartDefinition reactionReviewUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionReviewUnitComponentPartDefinition = (ReactionReviewUnitComponentPartDefinition) a2.a(f20042k);
                } else {
                    reactionReviewUnitComponentPartDefinition = f20041j;
                }
                if (reactionReviewUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23922b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20042k, b3);
                        } else {
                            f20041j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionReviewUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionReviewUnitComponentPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, DefaultTimeFormatUtil defaultTimeFormatUtil, FbDraweePartDefinition fbDraweePartDefinition, AbstractFbErrorReporter abstractFbErrorReporter, ReactionIntentFactory reactionIntentFactory, ReviewsRatingHelper reviewsRatingHelper) {
        this.f20043d = clickListenerPartDefinition;
        this.f20044e = defaultTimeFormatUtil;
        this.f20045f = fbDraweePartDefinition;
        this.f20046g = abstractFbErrorReporter;
        this.f20047h = reactionIntentFactory;
        this.f20048i = reviewsRatingHelper;
    }

    public final ViewType<ContentView> m23926a() {
        return f20040c;
    }

    @Nullable
    private String m23923d(ReactionUnitComponentNode reactionUnitComponentNode) {
        ImmutableList b = m23925h(reactionUnitComponentNode).b();
        if (b.isEmpty() || ((ActorsModel) b.get(0)).c() == null) {
            return null;
        }
        return ((ActorsModel) b.get(0)).c().b();
    }

    @Nullable
    private String m23924e(ReactionUnitComponentNode reactionUnitComponentNode) {
        return m23925h(reactionUnitComponentNode).g();
    }
}
