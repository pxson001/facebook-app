package com.facebook.groups.settings;

import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.GroupUpdatePushSubscriptionLevelInputData;
import com.facebook.graphql.calls.GroupUpdateRequestToJoinSubscriptionLevelInputData;
import com.facebook.graphql.calls.GroupUpdateSubscriptionLevelInputData;
import com.facebook.graphql.calls.GroupUpdateSubscriptionLevelInputData.Setting;
import com.facebook.graphql.enums.GraphQLGroupPushSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupRequestToJoinSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupSubscriptionLevel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.groups.settings.protocol.SettingMutations.GroupUpdateSubscriptionMutationString;
import com.facebook.groups.settings.protocol.SettingMutationsModels.GroupUpdatePushSubscriptionMutationModel;
import com.facebook.groups.settings.protocol.SettingMutationsModels.GroupUpdateRequestToJoinSubscriptionMutationModel;
import com.facebook.groups.settings.protocol.SettingMutationsModels.GroupUpdateSubscriptionMutationModel;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.EnumMap;
import java.util.concurrent.ExecutorService;

/* compiled from: TIME_DIVIDER */
public abstract class AbstractGroupSubscriptionController {
    public static final EnumMap<GraphQLGroupSubscriptionLevel, Setting> f23115a = new EnumMap(GraphQLGroupSubscriptionLevel.class);
    public static final EnumMap<GraphQLGroupPushSubscriptionLevel, GroupUpdatePushSubscriptionLevelInputData.Setting> f23116b = new EnumMap(GraphQLGroupPushSubscriptionLevel.class);
    public static final EnumMap<GraphQLGroupRequestToJoinSubscriptionLevel, GroupUpdateRequestToJoinSubscriptionLevelInputData.Setting> f23117c = new EnumMap(GraphQLGroupRequestToJoinSubscriptionLevel.class);
    public Toaster f23118d;
    public ExecutorService f23119e;
    public final GraphQLQueryExecutor f23120f;
    public String f23121g;
    public GroupSubscriptionController$GroupSubscriptionChangeListener f23122h;

    /* compiled from: TIME_DIVIDER */
    public class C33322 implements FutureCallback<GraphQLResult<GroupUpdatePushSubscriptionMutationModel>> {
        final /* synthetic */ GraphQLGroupPushSubscriptionLevel f23111a;
        final /* synthetic */ AbstractGroupSubscriptionController f23112b;

        public C33322(AbstractGroupSubscriptionController abstractGroupSubscriptionController, GraphQLGroupPushSubscriptionLevel graphQLGroupPushSubscriptionLevel) {
            this.f23112b = abstractGroupSubscriptionController;
            this.f23111a = graphQLGroupPushSubscriptionLevel;
        }

        public void onSuccess(Object obj) {
        }

        public void onFailure(Throwable th) {
            if (this.f23112b.f23122h != null) {
                this.f23112b.f23122h.mo990a(this.f23111a);
            }
            this.f23112b.f23118d.b(new ToastBuilder(2131237912));
        }
    }

    /* compiled from: TIME_DIVIDER */
    public class C33333 implements FutureCallback<GraphQLResult<GroupUpdateRequestToJoinSubscriptionMutationModel>> {
        final /* synthetic */ GraphQLGroupRequestToJoinSubscriptionLevel f23113a;
        final /* synthetic */ AbstractGroupSubscriptionController f23114b;

        public C33333(AbstractGroupSubscriptionController abstractGroupSubscriptionController, GraphQLGroupRequestToJoinSubscriptionLevel graphQLGroupRequestToJoinSubscriptionLevel) {
            this.f23114b = abstractGroupSubscriptionController;
            this.f23113a = graphQLGroupRequestToJoinSubscriptionLevel;
        }

        public void onSuccess(Object obj) {
        }

        public void onFailure(Throwable th) {
            if (this.f23114b.f23122h != null) {
                this.f23114b.f23122h.mo991a(this.f23113a);
            }
            this.f23114b.f23118d.b(new ToastBuilder(2131237913));
        }
    }

    public AbstractGroupSubscriptionController(Toaster toaster, ExecutorService executorService, String str, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f23118d = toaster;
        this.f23119e = executorService;
        this.f23121g = str;
        this.f23120f = graphQLQueryExecutor;
        f23115a.put(GraphQLGroupSubscriptionLevel.ALL_POSTS, Setting.ALL_POSTS);
        f23115a.put(GraphQLGroupSubscriptionLevel.FRIEND_POSTS, Setting.FRIEND_POSTS);
        f23115a.put(GraphQLGroupSubscriptionLevel.HIGHLIGHTS, Setting.HIGHLIGHTS);
        f23115a.put(GraphQLGroupSubscriptionLevel.OFF, Setting.OFF);
        f23116b.put(GraphQLGroupPushSubscriptionLevel.ON, GroupUpdatePushSubscriptionLevelInputData.Setting.ON);
        f23116b.put(GraphQLGroupPushSubscriptionLevel.HIGHLIGHTS, GroupUpdatePushSubscriptionLevelInputData.Setting.HIGHLIGHTS);
        f23116b.put(GraphQLGroupPushSubscriptionLevel.OFF, GroupUpdatePushSubscriptionLevelInputData.Setting.OFF);
        f23117c.put(GraphQLGroupRequestToJoinSubscriptionLevel.ON, GroupUpdateRequestToJoinSubscriptionLevelInputData.Setting.ON);
        f23117c.put(GraphQLGroupRequestToJoinSubscriptionLevel.OFF, GroupUpdateRequestToJoinSubscriptionLevelInputData.Setting.OFF);
    }

    public final void m24423a(String str, final GraphQLGroupSubscriptionLevel graphQLGroupSubscriptionLevel, GraphQLGroupSubscriptionLevel graphQLGroupSubscriptionLevel2) {
        if (this.f23122h != null) {
            this.f23122h.mo992a(graphQLGroupSubscriptionLevel2);
        }
        GroupUpdateSubscriptionLevelInputData groupUpdateSubscriptionLevelInputData = new GroupUpdateSubscriptionLevelInputData();
        groupUpdateSubscriptionLevelInputData.a("actor_id", this.f23121g);
        GraphQlCallInput graphQlCallInput = groupUpdateSubscriptionLevelInputData;
        graphQlCallInput.a("group_id", str);
        GraphQlCallInput graphQlCallInput2 = graphQlCallInput;
        graphQlCallInput2.a("setting", (Setting) f23115a.get(graphQLGroupSubscriptionLevel2));
        Futures.a(this.f23120f.a(GraphQLRequest.a((GroupUpdateSubscriptionMutationString) new GroupUpdateSubscriptionMutationString().a("input", graphQlCallInput2))), new FutureCallback<GraphQLResult<GroupUpdateSubscriptionMutationModel>>(this) {
            final /* synthetic */ AbstractGroupSubscriptionController f23110b;

            public void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                if (this.f23110b.f23122h != null) {
                    this.f23110b.f23122h.mo992a(graphQLGroupSubscriptionLevel);
                }
                this.f23110b.f23118d.b(new ToastBuilder(2131237911));
            }
        }, this.f23119e);
    }
}
