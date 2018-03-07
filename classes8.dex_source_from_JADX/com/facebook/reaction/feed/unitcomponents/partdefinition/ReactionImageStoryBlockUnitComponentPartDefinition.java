package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.environment.HasContext;
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
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.rows.ui.ReactionImageStoryBlockUnitComponentView;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionImageFields;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionActionFatFieldsModel.StoryModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionActionFatFieldsModel.StoryModel.FeedbackModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.touchlistener.HighlightViewChildrenOnTouchListener;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: admin_type */
public class ReactionImageStoryBlockUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, ReactionImageStoryBlockUnitComponentView> {
    private static ReactionImageStoryBlockUnitComponentPartDefinition f19830d;
    private static final Object f19831e = new Object();
    public final ReactionIntentFactory f19832a;
    private TextAppearanceSpan f19833b;
    private TextAppearanceSpan f19834c;

    /* compiled from: admin_type */
    public class State {
        public final SpannableStringBuilder f19824a;
        public final String f19825b;
        public final Uri f19826c;
        public final Uri f19827d;
        public final OnClickListener f19828e;
        public final OnTouchListener f19829f;

        public State(SpannableStringBuilder spannableStringBuilder, String str, Uri uri, @Nullable Uri uri2, OnClickListener onClickListener, OnTouchListener onTouchListener) {
            this.f19824a = spannableStringBuilder;
            this.f19825b = str;
            this.f19826c = uri;
            this.f19827d = uri2;
            this.f19828e = onClickListener;
            this.f19829f = onTouchListener;
        }
    }

    private static ReactionImageStoryBlockUnitComponentPartDefinition m23738b(InjectorLike injectorLike) {
        return new ReactionImageStoryBlockUnitComponentPartDefinition(ReactionIntentFactory.m22683a(injectorLike));
    }

    public final Object m23740a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        final CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        final ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        String a = reactionUnitComponentFields.bv().a();
        String a2 = reactionUnitComponentFields.cG().a();
        ReactionImageFields an = reactionUnitComponentFields.an();
        return new State(m23736a(a, a2, ((HasContext) canLaunchReactionIntent).getContext()), reactionUnitComponentFields.cO().a(), Uri.parse(reactionUnitComponentFields.aU().b()), an != null ? Uri.parse(an.b()) : null, new OnClickListener(this) {
            final /* synthetic */ ReactionImageStoryBlockUnitComponentPartDefinition f19823d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1339362926);
                StoryModel V = reactionUnitComponentFields.v().V();
                FeedbackModel c = V.c();
                canLaunchReactionIntent.mo695a(reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d, this.f19823d.f19832a.m22748a(V.d(), V.b(), c != null ? c.a() : null, UnitInteractionType.STORY_TAP));
                LogUtils.a(1730228734, a);
            }
        }, new HighlightViewChildrenOnTouchListener());
    }

    public final /* bridge */ /* synthetic */ void m23741a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 489712408);
        State state = (State) obj2;
        ReactionImageStoryBlockUnitComponentView reactionImageStoryBlockUnitComponentView = (ReactionImageStoryBlockUnitComponentView) view;
        reactionImageStoryBlockUnitComponentView.f19462c.setThumbnailUri(state.f19826c);
        reactionImageStoryBlockUnitComponentView.f19462c.setThumbnailPlaceholderResource(2131361970);
        Uri uri = state.f19827d;
        if (uri != null) {
            if (reactionImageStoryBlockUnitComponentView.f19465f == null) {
                reactionImageStoryBlockUnitComponentView.f19465f = (FbDraweeView) ((ViewStub) reactionImageStoryBlockUnitComponentView.a(2131566620)).inflate();
            }
            reactionImageStoryBlockUnitComponentView.f19465f.a(uri, ReactionImageStoryBlockUnitComponentView.f19461b);
            reactionImageStoryBlockUnitComponentView.f19465f.setPadding(0, 0, 0, 0);
        }
        reactionImageStoryBlockUnitComponentView.f19463d.setText(state.f19824a);
        reactionImageStoryBlockUnitComponentView.f19464e.setText(state.f19825b);
        reactionImageStoryBlockUnitComponentView.setOnClickListener(state.f19828e);
        reactionImageStoryBlockUnitComponentView.setOnTouchListener(state.f19829f);
        Logger.a(8, EntryType.MARK_POP, -1016614962, a);
    }

    public final boolean m23742a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionUnitComponentFields.aU() == null || reactionUnitComponentFields.bv() == null || reactionUnitComponentFields.bv().a() == null || reactionUnitComponentFields.cG() == null || reactionUnitComponentFields.cG().a() == null || reactionUnitComponentFields.cO() == null || reactionUnitComponentFields.cO().a() == null || reactionUnitComponentFields.v() == null || reactionUnitComponentFields.v().V() == null || reactionUnitComponentFields.v().V().d() == null) ? false : true;
    }

    public final void m23743b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ReactionImageStoryBlockUnitComponentView reactionImageStoryBlockUnitComponentView = (ReactionImageStoryBlockUnitComponentView) view;
        super.b((ReactionUnitComponentNode) obj, (State) obj2, (CanLaunchReactionIntent) anyEnvironment, reactionImageStoryBlockUnitComponentView);
        reactionImageStoryBlockUnitComponentView.setOnClickListener(null);
        reactionImageStoryBlockUnitComponentView.setOnTouchListener(null);
    }

    @Inject
    public ReactionImageStoryBlockUnitComponentPartDefinition(ReactionIntentFactory reactionIntentFactory) {
        this.f19832a = reactionIntentFactory;
    }

    public static ReactionImageStoryBlockUnitComponentPartDefinition m23737a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionImageStoryBlockUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19831e) {
                ReactionImageStoryBlockUnitComponentPartDefinition reactionImageStoryBlockUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionImageStoryBlockUnitComponentPartDefinition = (ReactionImageStoryBlockUnitComponentPartDefinition) a2.a(f19831e);
                } else {
                    reactionImageStoryBlockUnitComponentPartDefinition = f19830d;
                }
                if (reactionImageStoryBlockUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23738b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19831e, b3);
                        } else {
                            f19830d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionImageStoryBlockUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private SpannableStringBuilder m23736a(String str, @Nullable String str2, Context context) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (this.f19833b == null) {
            this.f19833b = new TextAppearanceSpan(context, 2131625827);
        }
        if (this.f19834c == null) {
            this.f19834c = new TextAppearanceSpan(context, 2131625828);
        }
        if (str2 != null) {
            spannableStringBuilder.append(" - ");
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append(str2);
            spannableStringBuilder.setSpan(this.f19833b, 0, length, 33);
            spannableStringBuilder.setSpan(this.f19834c, length, spannableStringBuilder.length(), 33);
        } else {
            spannableStringBuilder.setSpan(this.f19833b, 0, spannableStringBuilder.length(), 33);
        }
        return spannableStringBuilder;
    }

    public final ViewType m23739a() {
        return ReactionImageStoryBlockUnitComponentView.f19460a;
    }
}
