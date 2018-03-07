package com.facebook.feedplugins.attachments.poll;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.HasFeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.ui.attachments.QuestionAddPollOptionDialogFragment;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.HasFeedUnit;
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
import com.facebook.resources.ui.FbTextView;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: THROB */
public class PollAddOptionPartDefinition<E extends HasInvalidate & HasPositionInformation & HasPersistentState> extends MultiRowSinglePartDefinition<Props, Void, E, FbTextView> {
    public static final ViewType f22647a = ViewType.a(2130906338);
    private static PollAddOptionPartDefinition f22648f;
    private static final Object f22649g = new Object();
    private final BackgroundPartDefinition f22650b;
    private final DefaultPollDisplayAndClickListenerBuilder f22651c;
    private final ClickListenerPartDefinition f22652d;
    public final Context f22653e;

    @Immutable
    /* compiled from: THROB */
    public class Props implements HasFeedProps<GraphQLStory>, HasFeedUnit {
        public final boolean f22643a;
        public final GraphQLNode f22644b;
        public final FeedProps<GraphQLStoryAttachment> f22645c;
        public final FeedProps<GraphQLStory> f22646d;

        public Props(boolean z, GraphQLNode graphQLNode, FeedProps<GraphQLStoryAttachment> feedProps) {
            this.f22643a = z;
            this.f22644b = graphQLNode;
            this.f22645c = feedProps;
            this.f22646d = AttachmentProps.e(feedProps);
        }

        public final FeedUnit m25300c() {
            return (FeedUnit) this.f22646d.a;
        }

        public final FeedProps<GraphQLStory> m25301f() {
            return this.f22646d;
        }
    }

    private static PollAddOptionPartDefinition m25303b(InjectorLike injectorLike) {
        return new PollAddOptionPartDefinition(BackgroundPartDefinition.a(injectorLike), DefaultPollDisplayAndClickListenerBuilder.m25295a(injectorLike), ClickListenerPartDefinition.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public final Object m25305a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final Props props = (Props) obj;
        subParts.a(this.f22650b, PollItemBackgroundStyler.m25321a(props.f22644b.aS(), props.f22646d, this.f22651c));
        subParts.a(this.f22652d, new OnClickListener(this) {
            final /* synthetic */ PollAddOptionPartDefinition f22642b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1896387543);
                PollAddOptionPartDefinition pollAddOptionPartDefinition = this.f22642b;
                String dp = props.f22644b.dp();
                FeedProps feedProps = props.f22645c;
                FragmentManagerHost fragmentManagerHost = (FragmentManagerHost) ContextUtils.a(pollAddOptionPartDefinition.f22653e, FragmentManagerHost.class);
                if (fragmentManagerHost != null) {
                    QuestionAddPollOptionDialogFragment questionAddPollOptionDialogFragment = new QuestionAddPollOptionDialogFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("question_id", dp);
                    bundle.putParcelable("story_attachment", feedProps);
                    questionAddPollOptionDialogFragment.g(bundle);
                    questionAddPollOptionDialogFragment.a(fragmentManagerHost.kO_(), "question_add_poll_option_option_tag");
                }
                Logger.a(2, EntryType.UI_INPUT_END, 762371749, a);
            }
        });
        return null;
    }

    public final boolean m25306a(Object obj) {
        return ((Props) obj).f22643a;
    }

    public final ViewType<FbTextView> m25304a() {
        return f22647a;
    }

    public static PollAddOptionPartDefinition m25302a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PollAddOptionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22649g) {
                PollAddOptionPartDefinition pollAddOptionPartDefinition;
                if (a2 != null) {
                    pollAddOptionPartDefinition = (PollAddOptionPartDefinition) a2.a(f22649g);
                } else {
                    pollAddOptionPartDefinition = f22648f;
                }
                if (pollAddOptionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25303b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22649g, b3);
                        } else {
                            f22648f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pollAddOptionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PollAddOptionPartDefinition(BackgroundPartDefinition backgroundPartDefinition, DefaultPollDisplayAndClickListenerBuilder defaultPollDisplayAndClickListenerBuilder, ClickListenerPartDefinition clickListenerPartDefinition, Context context) {
        this.f22650b = backgroundPartDefinition;
        this.f22651c = defaultPollDisplayAndClickListenerBuilder;
        this.f22652d = clickListenerPartDefinition;
        this.f22653e = context;
    }
}
