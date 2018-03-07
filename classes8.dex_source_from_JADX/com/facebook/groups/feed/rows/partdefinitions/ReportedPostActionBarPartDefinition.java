package com.facebook.groups.feed.rows.partdefinitions;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.GroupBlockInputData;
import com.facebook.graphql.calls.GroupIgnoreReportedStoryInputData;
import com.facebook.graphql.calls.GroupIgnoreReportedStoryInputData.Source;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.feed.data.GroupsFeedEvents.StoryIgnoreReportEvent;
import com.facebook.groups.feed.menu.GroupsFeedStoryModerationHelper;
import com.facebook.groups.feed.menu.GroupsFeedStoryModerationHelper.C15022;
import com.facebook.groups.feed.rows.views.ReportedPostActionBarView;
import com.facebook.groups.mutations.GroupsClient;
import com.facebook.groups.mutations.protocol.GroupPostMutationsModels.LocalGroupModerationFieldsModel;
import com.facebook.groups.mutations.protocol.ReportedPostsMutations.GroupIgnoreReportedStoryCoreMutationString;
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
import com.google.common.base.Functions;
import com.google.common.util.concurrent.Futures;
import javax.inject.Inject;

@ContextScoped
/* compiled from: faa122162ef18f29dada7bd5d347ee01 */
public class ReportedPostActionBarPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, HasPositionInformation, ReportedPostActionBarView> {
    public static final ViewType f14155a = new C15161();
    private static final PaddingStyle f14156b = Builder.g().b(3).i();
    private static ReportedPostActionBarPartDefinition f14157h;
    private static final Object f14158i = new Object();
    private final BackgroundPartDefinition f14159c;
    public final GroupsFeedStoryModerationHelper f14160d;
    private final ClickListenerPartDefinition f14161e;
    private final ClickListenerPartDefinition f14162f;
    private final ClickListenerPartDefinition f14163g;

    /* compiled from: faa122162ef18f29dada7bd5d347ee01 */
    final class C15161 extends ViewType {
        C15161() {
        }

        public final View m15712a(Context context) {
            return new ReportedPostActionBarView(context);
        }
    }

    private static ReportedPostActionBarPartDefinition m15714b(InjectorLike injectorLike) {
        return new ReportedPostActionBarPartDefinition(BackgroundPartDefinition.a(injectorLike), GroupsFeedStoryModerationHelper.m15664a(injectorLike), ClickListenerPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m15716a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f14159c, new StylingData(feedProps, f14156b));
        subParts.a(2131564002, this.f14162f, new OnClickListener(this) {
            final /* synthetic */ ReportedPostActionBarPartDefinition f14150b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1516411686);
                GroupsFeedStoryModerationHelper groupsFeedStoryModerationHelper = this.f14150b.f14160d;
                FeedProps feedProps = feedProps;
                if (groupsFeedStoryModerationHelper.f14126k.b()) {
                    groupsFeedStoryModerationHelper.f14117b.a(new StoryIgnoreReportEvent(feedProps, true, true));
                }
                GroupsClient groupsClient = groupsFeedStoryModerationHelper.f14120e;
                GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
                Source source = Source.TREEHOUSE_GROUP_MALL;
                GroupIgnoreReportedStoryInputData groupIgnoreReportedStoryInputData = new GroupIgnoreReportedStoryInputData();
                groupIgnoreReportedStoryInputData.a("group_id", graphQLStory.aJ().b());
                GraphQlCallInput graphQlCallInput = groupIgnoreReportedStoryInputData;
                graphQlCallInput.a("story_id", graphQLStory.c());
                graphQlCallInput = graphQlCallInput;
                graphQlCallInput.a("source", source);
                graphQlCallInput = graphQlCallInput;
                GraphQlQueryString groupIgnoreReportedStoryCoreMutationString = new GroupIgnoreReportedStoryCoreMutationString();
                groupIgnoreReportedStoryCoreMutationString.a("input", graphQlCallInput);
                MutationRequest a2 = GraphQLRequest.a(groupIgnoreReportedStoryCoreMutationString);
                if (groupsClient.f14754b.a()) {
                    LocalGroupModerationFieldsModel.Builder builder = new LocalGroupModerationFieldsModel.Builder();
                    builder.f14781a = graphQLStory.c();
                    builder = builder;
                    builder.f14783c = true;
                    a2.a(builder.m17110a());
                    a2.d = true;
                }
                groupsFeedStoryModerationHelper.f14116a.a(Futures.a(groupsClient.f14753a.a(a2), Functions.constant(null)), new C15022(groupsFeedStoryModerationHelper, feedProps));
                Logger.a(2, EntryType.UI_INPUT_END, 176676691, a);
            }
        });
        subParts.a(2131564003, this.f14163g, new OnClickListener(this) {
            final /* synthetic */ ReportedPostActionBarPartDefinition f14152b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1791454184);
                this.f14152b.f14160d.m15670a(feedProps, view.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, -665197523, a);
            }
        });
        subParts.a(2131564004, this.f14161e, new OnClickListener(this) {
            final /* synthetic */ ReportedPostActionBarPartDefinition f14154b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 489510221);
                this.f14154b.f14160d.m15669a(view.getContext(), feedProps, GroupBlockInputData.Source.TREEHOUSE_REPORTED_POSTS_QUEUE);
                Logger.a(2, EntryType.UI_INPUT_END, -584582974, a);
            }
        });
        return null;
    }

    @Inject
    public ReportedPostActionBarPartDefinition(BackgroundPartDefinition backgroundPartDefinition, GroupsFeedStoryModerationHelper groupsFeedStoryModerationHelper, ClickListenerPartDefinition clickListenerPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition2, ClickListenerPartDefinition clickListenerPartDefinition3) {
        this.f14159c = backgroundPartDefinition;
        this.f14160d = groupsFeedStoryModerationHelper;
        this.f14161e = clickListenerPartDefinition;
        this.f14162f = clickListenerPartDefinition2;
        this.f14163g = clickListenerPartDefinition3;
    }

    public static ReportedPostActionBarPartDefinition m15713a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReportedPostActionBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14158i) {
                ReportedPostActionBarPartDefinition reportedPostActionBarPartDefinition;
                if (a2 != null) {
                    reportedPostActionBarPartDefinition = (ReportedPostActionBarPartDefinition) a2.a(f14158i);
                } else {
                    reportedPostActionBarPartDefinition = f14157h;
                }
                if (reportedPostActionBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15714b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14158i, b3);
                        } else {
                            f14157h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reportedPostActionBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m15715a() {
        return f14155a;
    }

    public final boolean m15717a(Object obj) {
        return true;
    }
}
