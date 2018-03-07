package com.facebook.feedback.ui.rows;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams.Builder;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.ui.OriginalPostButtonUtil;
import com.facebook.feedback.ui.OriginalPostButtonUtil$1;
import com.facebook.feedback.ui.OriginalPostButtonView;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironment;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActorUtil;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.fasterxml.jackson.databind.node.ArrayNode;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ridge_composer_toolip */
public class OriginalPostButtonPartDefinition extends MultiRowSinglePartDefinition<Props, State, CommentsEnvironment, OriginalPostButtonView> {
    public static final ViewType f5085a = new C05011();
    private static OriginalPostButtonPartDefinition f5086h;
    private static final Object f5087i = new Object();
    private final LinkifyUtil f5088b;
    public final QeAccessor f5089c;
    public final SecureContextHelper f5090d;
    public final IFeedIntentBuilder f5091e;
    public final OriginalPostButtonUtil f5092f;
    public final FunnelLoggerImpl f5093g;

    /* compiled from: ridge_composer_toolip */
    final class C05011 extends ViewType {
        C05011() {
        }

        public final View m5557a(Context context) {
            return new OriginalPostButtonView(context);
        }
    }

    /* compiled from: ridge_composer_toolip */
    public class Props implements RootProps {
        public final FeedProps<GraphQLStory> f5081a;

        public Props(FeedProps<GraphQLStory> feedProps) {
            this.f5081a = feedProps;
        }
    }

    /* compiled from: ridge_composer_toolip */
    public class State {
        public final Uri f5082a;
        public final CharSequence f5083b;
        public final OnClickListener f5084c;

        public State(Uri uri, CharSequence charSequence, OnClickListener onClickListener) {
            this.f5082a = uri;
            this.f5083b = charSequence;
            this.f5084c = onClickListener;
        }
    }

    private static OriginalPostButtonPartDefinition m5559b(InjectorLike injectorLike) {
        return new OriginalPostButtonPartDefinition(LinkifyUtil.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), OriginalPostButtonUtil.a(injectorLike), FunnelLoggerImpl.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m5561a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLStory L;
        Uri parse;
        Spannable a;
        CharSequence string;
        final FeedProps feedProps;
        Props props = (Props) obj;
        BaseCommentsEnvironment baseCommentsEnvironment = (BaseCommentsEnvironment) anyEnvironment;
        OriginalPostButtonUtil originalPostButtonUtil = this.f5092f;
        FeedProps feedProps2 = props.f5081a;
        switch (OriginalPostButtonUtil$1.f4641a[OriginalPostButtonUtil.c(feedProps2).ordinal()]) {
            case 1:
                L = ((GraphQLStory) feedProps2.a).L();
                break;
            case 2:
                L = (GraphQLStory) feedProps2.c();
                break;
            case 3:
                L = ((GraphQLStory) feedProps2.a).L();
                break;
            case 4:
                L = ((GraphQLStory) feedProps2.c()).L();
                break;
            case 5:
                if (!originalPostButtonUtil.a.a(ExperimentsForFeedbackTestModule.I, false) && !originalPostButtonUtil.a.a(ExperimentsForFeedbackTestModule.L, false)) {
                    L = (GraphQLStory) ((GraphQLStory) feedProps2.c()).G().j().get(0);
                    break;
                }
                L = (GraphQLStory) feedProps2.c();
                break;
                break;
            default:
                L = (GraphQLStory) feedProps2.a;
                break;
        }
        final GraphQLStory graphQLStory = L;
        GraphQLActor b = StoryActorHelper.b(graphQLStory);
        if (b != null) {
            Object c = GraphQLActorUtil.c(b);
            if (!TextUtils.isEmpty(c)) {
                parse = Uri.parse(c);
                a = this.f5088b.a(LinkifyTargetBuilder.a(b), null, LinkifyUtil.a, true);
                if (graphQLStory.aD() > 0) {
                    string = baseCommentsEnvironment.getContext().getString(2131233352, new Object[]{a});
                    this.f5093g.b(FunnelRegistry.D, "show_aggregate_post_button");
                } else if (graphQLStory.L() == null) {
                    string = baseCommentsEnvironment.getContext().getString(2131233353, new Object[]{a});
                    this.f5093g.b(FunnelRegistry.D, "show_reshare_post_button");
                } else if (((GraphQLStory) props.f5081a.c()) == null && ((GraphQLStory) props.f5081a.c()).L() == graphQLStory) {
                    string = baseCommentsEnvironment.getContext().getString(2131233351, new Object[]{a});
                    this.f5093g.b(FunnelRegistry.D, "show_original_post_button");
                } else {
                    string = baseCommentsEnvironment.getContext().getString(2131233353, new Object[]{a});
                    this.f5093g.b(FunnelRegistry.D, "show_aggregate_reshare_post_button");
                }
                feedProps = props.f5081a;
                return new State(parse, string, new OnClickListener(this) {
                    final /* synthetic */ OriginalPostButtonPartDefinition f5080c;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 1657133585);
                        Intent a2 = this.f5080c.f5091e.a(graphQLStory);
                        OriginalPostButtonUtil originalPostButtonUtil = this.f5080c.f5092f;
                        FeedProps feedProps = feedProps;
                        FeedbackLoggingParams feedbackLoggingParams = (FeedbackLoggingParams) a2.getParcelableExtra("feedback_logging_params");
                        ArrayNode a3 = TrackableFeedProps.a(feedProps);
                        Builder a4 = Builder.a(feedbackLoggingParams);
                        a4.a = a3;
                        Builder builder = a4;
                        originalPostButtonUtil.b.a((GraphQLStory) feedProps.a, builder);
                        a2.putExtra("feedback_logging_params", builder.a());
                        OriginalPostButtonUtil originalPostButtonUtil2 = this.f5080c.f5092f;
                        a2.putExtra("RESHARE_BUTTON_EXPERIMENT_CLICKED", true);
                        this.f5080c.f5090d.a(a2, view.getContext());
                        this.f5080c.f5093g.b(FunnelRegistry.D, "click_view_post_button");
                        Logger.a(2, EntryType.UI_INPUT_END, -1235174518, a);
                    }
                });
            }
        }
        parse = null;
        a = this.f5088b.a(LinkifyTargetBuilder.a(b), null, LinkifyUtil.a, true);
        if (graphQLStory.aD() > 0) {
            string = baseCommentsEnvironment.getContext().getString(2131233352, new Object[]{a});
            this.f5093g.b(FunnelRegistry.D, "show_aggregate_post_button");
        } else if (graphQLStory.L() == null) {
            if (((GraphQLStory) props.f5081a.c()) == null) {
            }
            string = baseCommentsEnvironment.getContext().getString(2131233353, new Object[]{a});
            this.f5093g.b(FunnelRegistry.D, "show_aggregate_reshare_post_button");
        } else {
            string = baseCommentsEnvironment.getContext().getString(2131233353, new Object[]{a});
            this.f5093g.b(FunnelRegistry.D, "show_reshare_post_button");
        }
        feedProps = props.f5081a;
        return new State(parse, string, /* anonymous class already generated */);
    }

    public final /* bridge */ /* synthetic */ void m5562a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 657762460);
        State state = (State) obj2;
        OriginalPostButtonView originalPostButtonView = (OriginalPostButtonView) view;
        originalPostButtonView.setThumbnailUri(state.f5082a);
        originalPostButtonView.setOnClickListener(state.f5084c);
        if (this.f5089c.a(ExperimentsForFeedbackTestModule.K, false)) {
            originalPostButtonView.setShowAuxView(true);
        } else {
            originalPostButtonView.setShowAuxView(false);
        }
        TextView textView = (TextView) originalPostButtonView.findViewById(2131565274);
        if (textView != null) {
            textView.setText(state.f5083b);
        }
        Logger.a(8, EntryType.MARK_POP, 327605518, a);
    }

    public final boolean m5563a(Object obj) {
        return this.f5092f.a(((Props) obj).f5081a) && this.f5089c.a(ExperimentsForFeedbackTestModule.P, false);
    }

    public final void m5564b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        OriginalPostButtonView originalPostButtonView = (OriginalPostButtonView) view;
        originalPostButtonView.setOnClickListener(null);
        originalPostButtonView.setThumbnailResource(2130841701);
    }

    public static OriginalPostButtonPartDefinition m5558a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OriginalPostButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5087i) {
                OriginalPostButtonPartDefinition originalPostButtonPartDefinition;
                if (a2 != null) {
                    originalPostButtonPartDefinition = (OriginalPostButtonPartDefinition) a2.a(f5087i);
                } else {
                    originalPostButtonPartDefinition = f5086h;
                }
                if (originalPostButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5559b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5087i, b3);
                        } else {
                            f5086h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = originalPostButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public OriginalPostButtonPartDefinition(LinkifyUtil linkifyUtil, SecureContextHelper secureContextHelper, IFeedIntentBuilder iFeedIntentBuilder, OriginalPostButtonUtil originalPostButtonUtil, FunnelLoggerImpl funnelLoggerImpl, QeAccessor qeAccessor) {
        this.f5088b = linkifyUtil;
        this.f5089c = qeAccessor;
        this.f5092f = originalPostButtonUtil;
        this.f5090d = secureContextHelper;
        this.f5091e = iFeedIntentBuilder;
        this.f5093g = funnelLoggerImpl;
    }

    public final ViewType m5560a() {
        return f5085a;
    }
}
