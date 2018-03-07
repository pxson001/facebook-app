package com.facebook.api.feed.service;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.api.feed.DeleteStoryMethod;
import com.facebook.api.feed.DeleteStoryMethod.Params.DeleteMode;
import com.facebook.api.feed.HideFeedStoryMethod.Params;
import com.facebook.api.feed.NegativeFeedbackActionOnFeedMethod;
import com.facebook.api.feed.NegativeFeedbackActionOnFeedMethod.ParamsBuilder;
import com.facebook.api.graphql.feed.StoryMutationModels.HideableStoryMutationFieldsModel.Builder;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.executor.LegacyConsistencyBridge;
import com.facebook.graphql.model.GraphQLNegativeFeedbackAction;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.offlinemode.executor.OfflineObliviousOperationsExecutor;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.saved.common.protocol.UpdateSavedStateParams;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: network_type_based */
public class GraphPostService {
    private DefaultBlueServiceOperationFactory f12408a;
    private final OfflineObliviousOperationsExecutor f12409b;
    private final Lazy<ViewerContextManager> f12410c;
    private final LegacyConsistencyBridge f12411d;

    public static GraphPostService m18477b(InjectorLike injectorLike) {
        return new GraphPostService(DefaultBlueServiceOperationFactory.m3782b(injectorLike), OfflineObliviousOperationsExecutor.m18485a(injectorLike), IdBasedLazy.m1808a(injectorLike, 375), LegacyConsistencyBridge.m18540b(injectorLike));
    }

    @Inject
    public GraphPostService(BlueServiceOperationFactory blueServiceOperationFactory, OfflineObliviousOperationsExecutor offlineObliviousOperationsExecutor, Lazy<ViewerContextManager> lazy, LegacyConsistencyBridge legacyConsistencyBridge) {
        this.f12408a = blueServiceOperationFactory;
        this.f12409b = offlineObliviousOperationsExecutor;
        this.f12410c = lazy;
        this.f12411d = legacyConsistencyBridge;
    }

    public final ListenableFuture<OperationResult> m18481a(HideableUnit hideableUnit, String str) {
        String r;
        Bundle bundle = new Bundle();
        GraphQLObjectType type = hideableUnit.getType();
        String q = hideableUnit.mo2881q();
        StoryVisibility storyVisibility = StoryVisibility.HIDDEN;
        String g = hideableUnit.mo2507g();
        int p = hideableUnit.mo2880p();
        if (hideableUnit instanceof NegativeFeedbackActionsUnit) {
            r = ((NegativeFeedbackActionsUnit) hideableUnit).mo2892r();
        } else {
            r = null;
        }
        bundle.putParcelable("hideFeedStoryParams", new Params(type, q, str, storyVisibility, true, g, p, r));
        return BlueServiceOperationFactoryDetour.a(this.f12408a, "feed_hide_story", bundle, -1143497621).mo3452a();
    }

    public final ListenableFuture<OperationResult> m18478a(FeedProps<? extends NegativeFeedbackActionsUnit> feedProps, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction, String str, String str2) {
        return m18475a(feedProps, graphQLNegativeFeedbackAction, str, false, str2);
    }

    public final ListenableFuture<OperationResult> m18483b(FeedProps<? extends NegativeFeedbackActionsUnit> feedProps, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction, String str, String str2) {
        return m18475a(feedProps, graphQLNegativeFeedbackAction, str, true, str2);
    }

    private ListenableFuture<OperationResult> m18475a(FeedProps<? extends NegativeFeedbackActionsUnit> feedProps, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction, String str, boolean z, String str2) {
        Preconditions.checkNotNull(feedProps);
        Preconditions.checkNotNull(graphQLNegativeFeedbackAction);
        NegativeFeedbackActionsUnit negativeFeedbackActionsUnit = (NegativeFeedbackActionsUnit) feedProps.f13444a;
        Bundle bundle = new Bundle();
        ArrayNode b = TrackableFeedProps.m27452b(feedProps);
        ParamsBuilder paramsBuilder = new ParamsBuilder();
        paramsBuilder.a = negativeFeedbackActionsUnit.getType();
        paramsBuilder = paramsBuilder;
        paramsBuilder.b = negativeFeedbackActionsUnit.mo2881q();
        paramsBuilder = paramsBuilder;
        paramsBuilder.c = negativeFeedbackActionsUnit.mo2892r();
        paramsBuilder = paramsBuilder;
        paramsBuilder.d = b.toString();
        ParamsBuilder paramsBuilder2 = paramsBuilder;
        paramsBuilder2.e = negativeFeedbackActionsUnit.mo2507g();
        paramsBuilder2 = paramsBuilder2;
        paramsBuilder2.f = negativeFeedbackActionsUnit.mo2880p();
        paramsBuilder2 = paramsBuilder2;
        paramsBuilder2.g = graphQLNegativeFeedbackAction;
        paramsBuilder2 = paramsBuilder2;
        paramsBuilder2.h = str;
        paramsBuilder2 = paramsBuilder2;
        paramsBuilder2.i = z;
        paramsBuilder2 = paramsBuilder2;
        paramsBuilder2.j = str2;
        Parcelable params = new NegativeFeedbackActionOnFeedMethod.Params(paramsBuilder2);
        if (graphQLNegativeFeedbackAction.m27654b() == GraphQLNegativeFeedbackActionType.DONT_LIKE) {
            m18476a(bundle);
        }
        bundle.putParcelable("negativeFeedbackActionOnFeedParams", params);
        ListenableFuture a = BlueServiceOperationFactoryDetour.a(this.f12408a, "feed_negative_feedback_story", bundle, 303643486).mo3452a();
        if (negativeFeedbackActionsUnit instanceof GraphQLStory) {
            String name;
            switch (1.a[graphQLNegativeFeedbackAction.m27654b().ordinal()]) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    name = StoryVisibility.HIDDEN.name();
                    break;
                default:
                    name = null;
                    break;
            }
            String str3 = name;
            if (str3 != null) {
                Builder builder = new Builder();
                builder.a = ((GraphQLStory) negativeFeedbackActionsUnit).m22350c();
                Builder builder2 = builder;
                builder2.c = str3;
                builder2 = builder2;
                builder2.b = graphQLNegativeFeedbackAction.m27654b().name();
                this.f12411d.m18544a(a, builder2.a());
            }
        }
        return a;
    }

    public final ListenableFuture<OperationResult> m18479a(GraphQLStory graphQLStory) {
        return m18480a(graphQLStory, false);
    }

    public final ListenableFuture<OperationResult> m18480a(GraphQLStory graphQLStory, boolean z) {
        Bundle bundle = new Bundle();
        DeleteStoryMethod.Params params = new DeleteStoryMethod.Params(graphQLStory.ai(), Lists.m1300a(graphQLStory.mo2507g()), graphQLStory.m22350c(), DeleteMode.LOCAL_AND_SERVER);
        if (z) {
            m18476a(bundle);
        }
        bundle.putParcelable("deleteStoryParams", params);
        return BlueServiceOperationFactoryDetour.a(this.f12408a, "feed_delete_story", bundle, -1132803973).mo3452a();
    }

    public final ListenableFuture<OperationResult> m18482a(UpdateSavedStateParams updateSavedStateParams, CallerContext callerContext) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("updateStorySavedStateParamsKey", updateSavedStateParams);
        return this.f12409b.m18494a(BlueServiceOperationFactoryDetour.a(this.f12408a, "update_story_saved_state", bundle, ErrorPropagation.BY_EXCEPTION, callerContext, -1456001976));
    }

    private void m18476a(Bundle bundle) {
        bundle.putParcelable("overridden_viewer_context", ((ViewerContextManager) this.f12410c.get()).mo212a());
    }
}
