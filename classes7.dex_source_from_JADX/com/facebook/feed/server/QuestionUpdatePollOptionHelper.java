package com.facebook.feed.server;

import android.content.Context;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.feed.protocol.QuestionAddPollOption.QuestionAddResponseMutationString;
import com.facebook.feed.protocol.QuestionAddPollOptionModels.QuestionAddResponseMutationModel;
import com.facebook.feed.protocol.QuestionPollUpdateVote.QuestionAddVoteMutationString;
import com.facebook.feed.protocol.QuestionPollUpdateVote.QuestionRemoveVoteMutationString;
import com.facebook.feed.protocol.QuestionPollUpdateVoteModels.QuestionMutationFragmentModel.OptionsModel.EdgesModel;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.graphql.calls.QuestionAddOptionInputData;
import com.facebook.graphql.calls.QuestionAddVoteInputData;
import com.facebook.graphql.calls.QuestionRemoveVoteInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Typing_Indicator_Pill_Tapped */
public class QuestionUpdatePollOptionHelper {
    private static QuestionUpdatePollOptionHelper f21659f;
    private static final Object f21660g = new Object();
    public final FeedStoryMutator f21661a;
    private final TasksManager f21662b;
    public final FeedEventBus f21663c;
    private final GraphQLQueryExecutor f21664d;
    @LoggedInUserId
    private final String f21665e;

    private static QuestionUpdatePollOptionHelper m24244b(InjectorLike injectorLike) {
        return new QuestionUpdatePollOptionHelper(String_LoggedInUserIdMethodAutoProvider.b(injectorLike), FeedStoryMutator.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), FeedEventBus.a(injectorLike));
    }

    public static QuestionUpdatePollOptionHelper m24242a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuestionUpdatePollOptionHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21660g) {
                QuestionUpdatePollOptionHelper questionUpdatePollOptionHelper;
                if (a2 != null) {
                    questionUpdatePollOptionHelper = (QuestionUpdatePollOptionHelper) a2.a(f21660g);
                } else {
                    questionUpdatePollOptionHelper = f21659f;
                }
                if (questionUpdatePollOptionHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24244b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21660g, b3);
                        } else {
                            f21659f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = questionUpdatePollOptionHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public QuestionUpdatePollOptionHelper(String str, FeedStoryMutator feedStoryMutator, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, FeedEventBus feedEventBus) {
        this.f21665e = str;
        this.f21661a = feedStoryMutator;
        this.f21664d = graphQLQueryExecutor;
        this.f21662b = tasksManager;
        this.f21663c = feedEventBus;
    }

    public final void m24247a(String str, String str2, boolean z, boolean z2, FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStory c = AttachmentProps.c(feedProps);
        this.f21663c.a(new FeedUnitMutatedEvent(StoryProps.f(this.f21661a.a(feedProps, str, z, z2))));
        if (z) {
            m24245b(this.f21665e, str, str2, c);
        } else {
            m24243a(this.f21665e, str, str2, c);
        }
    }

    public final void m24246a(final String str, String str2, final FeedProps<GraphQLStoryAttachment> feedProps, final QuestionAddPollOptionProgressListener questionAddPollOptionProgressListener) {
        questionAddPollOptionProgressListener.f21836a = ProgressDialog.a(questionAddPollOptionProgressListener.f21837b.f21839b.getContext(), questionAddPollOptionProgressListener.f21837b.f21839b.b(2131237736), questionAddPollOptionProgressListener.f21837b.f21839b.b(2131237737));
        QuestionAddOptionInputData questionAddOptionInputData = new QuestionAddOptionInputData();
        questionAddOptionInputData.a("question_id", str2);
        questionAddOptionInputData.a("actor_id", this.f21665e);
        questionAddOptionInputData.a("option_text", str);
        GraphQlQueryString questionAddResponseMutationString = new QuestionAddResponseMutationString();
        questionAddResponseMutationString.a("input", questionAddOptionInputData);
        this.f21662b.a("task_key_update_poll_vote" + str, this.f21664d.a(GraphQLRequest.a(questionAddResponseMutationString)), new AbstractDisposableFutureCallback<GraphQLResult>(this) {
            final /* synthetic */ QuestionUpdatePollOptionHelper f21656d;

            protected final void m24237a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                questionAddPollOptionProgressListener.m24420b();
                if (graphQLResult != null && graphQLResult.e != null) {
                    ImmutableList a = ((QuestionAddResponseMutationModel) graphQLResult.e).a().k().a();
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        EdgesModel edgesModel = (EdgesModel) a.get(i);
                        if (str.equals(edgesModel.a().k().a())) {
                            this.f21656d.f21663c.a(new FeedUnitMutatedEvent(StoryProps.f(this.f21656d.f21661a.a(feedProps, str, edgesModel.a().j()))));
                            return;
                        }
                    }
                }
            }

            protected final void m24238a(Throwable th) {
                this.f21656d.f21663c.a(new FeedUnitMutatedEvent(AttachmentProps.c(feedProps)));
                questionAddPollOptionProgressListener.m24420b();
            }
        });
    }

    private void m24243a(String str, String str2, String str3, GraphQLStory graphQLStory) {
        QuestionAddVoteInputData questionAddVoteInputData = new QuestionAddVoteInputData();
        questionAddVoteInputData.a("actor_id", str);
        questionAddVoteInputData.a("option_id", str2);
        questionAddVoteInputData.a("question_id", str3);
        GraphQlQueryString questionAddVoteMutationString = new QuestionAddVoteMutationString();
        questionAddVoteMutationString.a("input", questionAddVoteInputData);
        this.f21662b.a("task_key_update_poll_vote" + str2, this.f21664d.a(GraphQLRequest.a(questionAddVoteMutationString)), m24241a(graphQLStory));
    }

    private void m24245b(String str, String str2, String str3, GraphQLStory graphQLStory) {
        QuestionRemoveVoteInputData questionRemoveVoteInputData = new QuestionRemoveVoteInputData();
        questionRemoveVoteInputData.a("actor_id", str);
        questionRemoveVoteInputData.a("option_id", str2);
        questionRemoveVoteInputData.a("question_id", str3);
        GraphQlQueryString questionRemoveVoteMutationString = new QuestionRemoveVoteMutationString();
        questionRemoveVoteMutationString.a("input", questionRemoveVoteInputData);
        this.f21662b.a("task_key_update_poll_vote" + str2, this.f21664d.a(GraphQLRequest.a(questionRemoveVoteMutationString)), m24241a(graphQLStory));
    }

    private AbstractDisposableFutureCallback<GraphQLResult> m24241a(final GraphQLStory graphQLStory) {
        return new AbstractDisposableFutureCallback<GraphQLResult>(this) {
            final /* synthetic */ QuestionUpdatePollOptionHelper f21658b;

            protected final void m24240a(Throwable th) {
                BLog.b(QuestionUpdatePollOptionHelper.class, "failed to update poll option", th);
                this.f21658b.f21663c.a(new FeedUnitMutatedEvent(graphQLStory));
            }
        };
    }
}
