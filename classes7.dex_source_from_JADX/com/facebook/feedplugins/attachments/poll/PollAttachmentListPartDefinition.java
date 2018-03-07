package com.facebook.feedplugins.attachments.poll;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.server.QuestionUpdatePollOptionHelper;
import com.facebook.feedplugins.attachments.poll.PollOptionItemPartDefinition.Props;
import com.facebook.graphql.model.GraphQLQuestionOption;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.MultiRowSubParts;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: THREE_IMAGE_WIDTH_HEIGHT */
public class PollAttachmentListPartDefinition<E extends HasPositionInformation & HasFeedListType & HasPersistentState & HasInvalidate> extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E> {
    private static PollAttachmentListPartDefinition f22659f;
    private static final Object f22660g = new Object();
    private final Context f22661a;
    private final PollOptionItemPartDefinition f22662b;
    public final QuestionUpdatePollOptionHelper f22663c;
    private final DefaultPollDisplayAndClickListenerBuilder f22664d;
    private final PollAttachmentMoreActionSelectorPartDefinition f22665e;

    /* compiled from: THREE_IMAGE_WIDTH_HEIGHT */
    public enum QUESTION_RESPONSE_METHOD_TYPE {
        NON_POLL("NON_POLL"),
        CHOOSE_MULTIPLE("CHOOSE_MULTIPLE"),
        CHOOSE_ONE("CHOOSE_ONE");
        
        private final String mResponseType;

        private QUESTION_RESPONSE_METHOD_TYPE(String str) {
            this.mResponseType = str;
        }

        public final String toString() {
            return this.mResponseType;
        }
    }

    private static PollAttachmentListPartDefinition m25314b(InjectorLike injectorLike) {
        return new PollAttachmentListPartDefinition((Context) injectorLike.getInstance(Context.class), PollOptionItemPartDefinition.m25324a(injectorLike), DefaultPollDisplayAndClickListenerBuilder.m25295a(injectorLike), PollAttachmentMoreActionSelectorPartDefinition.m25317a(injectorLike), QuestionUpdatePollOptionHelper.m24242a(injectorLike));
    }

    public static PollAttachmentListPartDefinition m25312a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PollAttachmentListPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22660g) {
                PollAttachmentListPartDefinition pollAttachmentListPartDefinition;
                if (a2 != null) {
                    pollAttachmentListPartDefinition = (PollAttachmentListPartDefinition) a2.a(f22660g);
                } else {
                    pollAttachmentListPartDefinition = f22659f;
                }
                if (pollAttachmentListPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25314b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22660g, b3);
                        } else {
                            f22659f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pollAttachmentListPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PollAttachmentListPartDefinition(Context context, PollOptionItemPartDefinition pollOptionItemPartDefinition, DefaultPollDisplayAndClickListenerBuilder defaultPollDisplayAndClickListenerBuilder, PollAttachmentMoreActionSelectorPartDefinition pollAttachmentMoreActionSelectorPartDefinition, QuestionUpdatePollOptionHelper questionUpdatePollOptionHelper) {
        this.f22661a = context;
        this.f22662b = pollOptionItemPartDefinition;
        this.f22663c = questionUpdatePollOptionHelper;
        this.f22664d = defaultPollDisplayAndClickListenerBuilder;
        this.f22665e = pollAttachmentMoreActionSelectorPartDefinition;
    }

    public final boolean m25316a(Object obj) {
        return true;
    }

    private Void m25313a(MultiRowSubParts<E> multiRowSubParts, FeedProps<GraphQLStoryAttachment> feedProps, E e) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a();
        ImmutableList of = graphQLStoryAttachment.z().eV() == null ? ImmutableList.of() : graphQLStoryAttachment.z().eV().a();
        boolean aS = graphQLStoryAttachment.z().aS();
        int a = m25310a(of);
        Object obj = ((((HasFeedListType) e).c().a() == FeedListName.PERMALINK ? 1 : null) != null || this.f22664d.m25299a((FeedProps) feedProps, (AnyEnvironment) e)) ? 1 : null;
        int size = obj != null ? of.size() : Math.min(of.size(), 3);
        for (int i = 0; i < size; i++) {
            boolean z;
            GraphQLQuestionOption graphQLQuestionOption = (GraphQLQuestionOption) of.get(i);
            QUESTION_RESPONSE_METHOD_TYPE question_response_method_type = (QUESTION_RESPONSE_METHOD_TYPE) Enum.valueOf(QUESTION_RESPONSE_METHOD_TYPE.class, graphQLStoryAttachment.z().gF().toString());
            OnClickListener a2 = aS ? m25311a(graphQLQuestionOption, feedProps) : null;
            PollOptionItemPartDefinition pollOptionItemPartDefinition = this.f22662b;
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            multiRowSubParts.a(pollOptionItemPartDefinition, new Props(feedProps, graphQLQuestionOption, a, z, question_response_method_type, a2, this.f22664d.m25297a(graphQLQuestionOption, this.f22661a.getString(2131231954)), aS));
        }
        multiRowSubParts.a(this.f22665e, new PollAttachmentMoreActionSelectorPartDefinition.Props(of.size() - size, feedProps, graphQLStoryAttachment.z(), aS, this.f22661a.getString(2131235697), this.f22661a.getString(2131235692, new Object[]{Integer.valueOf(of.size() - size)})));
        return null;
    }

    private OnClickListener m25311a(final GraphQLQuestionOption graphQLQuestionOption, final FeedProps<GraphQLStoryAttachment> feedProps) {
        return new OnClickListener(this) {
            final /* synthetic */ PollAttachmentListPartDefinition f22658c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1513593704);
                PollAttachmentListPartDefinition pollAttachmentListPartDefinition = this.f22658c;
                String j = graphQLQuestionOption.j();
                boolean m = graphQLQuestionOption.m();
                FeedProps feedProps = feedProps;
                GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
                QUESTION_RESPONSE_METHOD_TYPE question_response_method_type = (QUESTION_RESPONSE_METHOD_TYPE) Enum.valueOf(QUESTION_RESPONSE_METHOD_TYPE.class, graphQLStoryAttachment.z().gF().toString());
                if (!(question_response_method_type.equals(QUESTION_RESPONSE_METHOD_TYPE.CHOOSE_ONE) && m)) {
                    pollAttachmentListPartDefinition.f22663c.m24247a(j, graphQLStoryAttachment.z().dp(), m, question_response_method_type.equals(QUESTION_RESPONSE_METHOD_TYPE.CHOOSE_ONE), feedProps);
                }
                Logger.a(2, EntryType.UI_INPUT_END, -893288471, a);
            }
        };
    }

    private static int m25310a(ImmutableList<GraphQLQuestionOption> immutableList) {
        int size = immutableList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, ((GraphQLQuestionOption) immutableList.get(i2)).n().a());
        }
        return i;
    }
}
