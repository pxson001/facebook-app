package com.facebook.feedplugins.attachments.poll;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.TriState;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.StoryCreateInputData.Attachments.Poll.PollAnswersState;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: THREAD_LIST_JEWEL */
public class PollAttachmentMoreActionSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<Props, Void, HasFeedListType> {
    private static PollAttachmentMoreActionSelectorPartDefinition f22673e;
    private static final Object f22674f = new Object();
    private final PollSeeMorePartDefinition f22675a;
    private final PollAddOptionPartDefinition f22676b;
    private final GatekeeperStoreImpl f22677c;
    private final DefaultPollDisplayAndClickListenerBuilder f22678d;

    @Immutable
    /* compiled from: THREAD_LIST_JEWEL */
    public class Props {
        public final int f22666a;
        public final FeedProps<GraphQLStoryAttachment> f22667b;
        public final GraphQLStoryAttachment f22668c;
        public final boolean f22669d;
        public final GraphQLNode f22670e;
        public final String f22671f;
        public final String f22672g;

        public Props(int i, FeedProps<GraphQLStoryAttachment> feedProps, GraphQLNode graphQLNode, boolean z, String str, String str2) {
            this.f22666a = i;
            this.f22667b = feedProps;
            this.f22668c = (GraphQLStoryAttachment) feedProps.a;
            this.f22669d = z;
            this.f22670e = graphQLNode;
            this.f22672g = str;
            this.f22671f = str2;
        }
    }

    private static PollAttachmentMoreActionSelectorPartDefinition m25318b(InjectorLike injectorLike) {
        return new PollAttachmentMoreActionSelectorPartDefinition(PollSeeMorePartDefinition.m25339a(injectorLike), PollAddOptionPartDefinition.m25302a(injectorLike), DefaultPollDisplayAndClickListenerBuilder.m25295a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m25319a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasFeedListType hasFeedListType = (HasFeedListType) anyEnvironment;
        boolean z = true;
        boolean z2 = props.f22668c.z().aS() && props.f22668c.z().fH().toString().equals(PollAnswersState.OPEN.toString()) && this.f22677c.a(565) == TriState.YES;
        DefaultPollDisplayAndClickListenerBuilder defaultPollDisplayAndClickListenerBuilder = this.f22678d;
        if (props.f22666a <= 0) {
            z = false;
        }
        SubPartsSelector.a(baseMultiRowSubParts, this.f22675a, new com.facebook.feedplugins.attachments.poll.PollSeeMorePartDefinition.Props(defaultPollDisplayAndClickListenerBuilder.m25298a(z, z2, props.f22671f, props.f22672g, hasFeedListType, props.f22667b), props.f22667b, props.f22669d)).a(this.f22676b, new com.facebook.feedplugins.attachments.poll.PollAddOptionPartDefinition.Props(z2, props.f22670e, props.f22667b));
        return null;
    }

    public static PollAttachmentMoreActionSelectorPartDefinition m25317a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PollAttachmentMoreActionSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22674f) {
                PollAttachmentMoreActionSelectorPartDefinition pollAttachmentMoreActionSelectorPartDefinition;
                if (a2 != null) {
                    pollAttachmentMoreActionSelectorPartDefinition = (PollAttachmentMoreActionSelectorPartDefinition) a2.a(f22674f);
                } else {
                    pollAttachmentMoreActionSelectorPartDefinition = f22673e;
                }
                if (pollAttachmentMoreActionSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25318b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22674f, b3);
                        } else {
                            f22673e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pollAttachmentMoreActionSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PollAttachmentMoreActionSelectorPartDefinition(PollSeeMorePartDefinition pollSeeMorePartDefinition, PollAddOptionPartDefinition pollAddOptionPartDefinition, DefaultPollDisplayAndClickListenerBuilder defaultPollDisplayAndClickListenerBuilder, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f22675a = pollSeeMorePartDefinition;
        this.f22676b = pollAddOptionPartDefinition;
        this.f22677c = gatekeeperStoreImpl;
        this.f22678d = defaultPollDisplayAndClickListenerBuilder;
    }

    public final boolean m25320a(Object obj) {
        return true;
    }
}
