package com.facebook.groups.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.locale.Locales;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.TriState;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.calls.AymtLogEventInputData;
import com.facebook.graphql.calls.AymtLogEventInputData.EventType;
import com.facebook.graphql.enums.GraphQLAYMTNativeAction;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groupcommerce.util.GroupCommerceComposerHelper;
import com.facebook.groups.fb4a.memberpicker.FB4AGroupsAddMemberIntentProvider;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel.Builder;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.GroupSuggestionTipsModel.TipsChannelModel.TipsModel;
import com.facebook.groups.feed.protocol.GroupSuggestionMutation.GroupSuggestionLoggingMutationString;
import com.facebook.groups.feed.protocol.GroupSuggestionMutationModels.GroupSuggestionLoggingMutationModel;
import com.facebook.groups.feed.ui.GroupsFeedFragment.AnonymousClass15;
import com.facebook.groups.memberpicker.GroupsAddMemberIntentProvider;
import com.facebook.groups.protocol.GroupInformationInterfaceFactory;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.DefaultPluginConfigSerializer;
import com.facebook.ipc.composer.intent.EmptyPluginConfig;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TimelineFragment.onFragmentCreate.createDataObjects */
public class GroupSuggestionCardView extends CustomLinearLayout {
    public static final CallerContext f22058g = CallerContext.a(GroupSuggestionCardView.class);
    @Inject
    FbUriIntentHandler f22059a;
    @Inject
    GraphQLQueryExecutor f22060b;
    @Inject
    Locales f22061c;
    @Inject
    ComposerLauncher f22062d;
    @Inject
    SecureContextHelper f22063e;
    @Inject
    GroupsAddMemberIntentProvider f22064f;
    public TextView f22065h;
    public TextView f22066i;
    public Button f22067j;
    public ImageView f22068k;
    public FbDraweeView f22069l;
    public boolean f22070m;

    /* compiled from: TimelineFragment.onFragmentCreate.createDataObjects */
    public class C31621 implements OnClickListener {
        final /* synthetic */ TipsModel f22050a;
        final /* synthetic */ FetchGroupInformationModel f22051b;
        final /* synthetic */ AnonymousClass15 f22052c;
        final /* synthetic */ GroupSuggestionCardView f22053d;

        public C31621(GroupSuggestionCardView groupSuggestionCardView, TipsModel tipsModel, FetchGroupInformationModel fetchGroupInformationModel, AnonymousClass15 anonymousClass15) {
            this.f22053d = groupSuggestionCardView;
            this.f22050a = tipsModel;
            this.f22051b = fetchGroupInformationModel;
            this.f22052c = anonymousClass15;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 831244602);
            GraphQLAYMTNativeAction j = this.f22050a.j();
            if (GraphQLAYMTNativeAction.CREATE_GROUP_POST.equals(j)) {
                GroupSuggestionCardView.m23208b(this.f22053d, this.f22051b);
            } else if (GraphQLAYMTNativeAction.CREATE_GROUP_POLL.equals(j)) {
                GroupSuggestionCardView.m23209c(this.f22053d, this.f22051b);
            } else if (GraphQLAYMTNativeAction.ADD_GROUP_COVER_PHOTO.equals(j)) {
                GroupsPlutoniumHeader.m23374a(this.f22053d.f22063e, this.f22053d.getContext());
            } else if (GraphQLAYMTNativeAction.ADD_GROUP_MEMBERS.equals(j)) {
                this.f22053d.f22063e.a(this.f22053d.f22064f.b(this.f22051b.gW_(), view.getContext()), this.f22053d.getContext());
            } else if (GraphQLAYMTNativeAction.ADD_GROUP_ADMINS.equals(j)) {
                Bundle bundle = new Bundle();
                bundle.putString("group_feed_id", this.f22051b.gW_());
                this.f22053d.f22059a.a(this.f22053d.getContext(), FBLinks.F, bundle);
            }
            GroupSuggestionCardView groupSuggestionCardView = this.f22053d;
            FetchGroupInformationModel fetchGroupInformationModel = this.f22051b;
            AnonymousClass15 anonymousClass15 = this.f22052c;
            FetchGroupInformationModel a2 = FetchGroupInformationModel.a(fetchGroupInformationModel);
            Builder a3 = Builder.a(a2);
            a3.m = null;
            anonymousClass15.m23231a(a2, a3.a());
            GroupSuggestionCardView.m23206a(this.f22053d, this.f22051b, EventType.CLICK);
            LogUtils.a(-1102976287, a);
        }
    }

    /* compiled from: TimelineFragment.onFragmentCreate.createDataObjects */
    public class C31632 implements OnClickListener {
        final /* synthetic */ FetchGroupInformationModel f22054a;
        final /* synthetic */ AnonymousClass15 f22055b;
        final /* synthetic */ GroupSuggestionCardView f22056c;

        public C31632(GroupSuggestionCardView groupSuggestionCardView, FetchGroupInformationModel fetchGroupInformationModel, AnonymousClass15 anonymousClass15) {
            this.f22056c = groupSuggestionCardView;
            this.f22054a = fetchGroupInformationModel;
            this.f22055b = anonymousClass15;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 173969490);
            GroupSuggestionCardView groupSuggestionCardView = this.f22056c;
            FetchGroupInformationModel fetchGroupInformationModel = this.f22054a;
            AnonymousClass15 anonymousClass15 = this.f22055b;
            FetchGroupInformationModel a2 = FetchGroupInformationModel.a(fetchGroupInformationModel);
            Builder a3 = Builder.a(a2);
            a3.m = null;
            anonymousClass15.m23231a(a2, a3.a());
            GroupSuggestionCardView.m23206a(this.f22056c, this.f22054a, EventType.XOUT);
            Logger.a(2, EntryType.UI_INPUT_END, -2115963782, a);
        }
    }

    /* compiled from: TimelineFragment.onFragmentCreate.createDataObjects */
    class C31643 implements FutureCallback<GraphQLResult<GroupSuggestionLoggingMutationModel>> {
        final /* synthetic */ GroupSuggestionCardView f22057a;

        C31643(GroupSuggestionCardView groupSuggestionCardView) {
            this.f22057a = groupSuggestionCardView;
        }

        public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
        }

        public void onFailure(Throwable th) {
        }
    }

    public static void m23207a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GroupSuggestionCardView) obj).m23205a(FbUriIntentHandler.a(fbInjector), GraphQLQueryExecutor.a(fbInjector), Locales.a(fbInjector), (ComposerLauncher) ComposerLauncherImpl.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (GroupsAddMemberIntentProvider) FB4AGroupsAddMemberIntentProvider.b(fbInjector));
    }

    public static void m23206a(GroupSuggestionCardView groupSuggestionCardView, FetchGroupInformationModel fetchGroupInformationModel, EventType eventType) {
        GraphQlQueryString groupSuggestionLoggingMutationString = new GroupSuggestionLoggingMutationString();
        AymtLogEventInputData b = new AymtLogEventInputData().a(fetchGroupInformationModel.w().b()).a(eventType).b(((TipsModel) fetchGroupInformationModel.w().c().get(0)).gZ_());
        if (eventType.equals(EventType.CLICK)) {
            b.a("target", "primary");
        } else if (eventType.equals(EventType.IMPRESSION)) {
            groupSuggestionCardView.f22070m = true;
        }
        groupSuggestionLoggingMutationString.a("input", b);
        Futures.a(groupSuggestionCardView.f22060b.a(GraphQLRequest.a(groupSuggestionLoggingMutationString)), new C31643(groupSuggestionCardView));
    }

    public GroupSuggestionCardView(Context context) {
        this(context, null);
    }

    private GroupSuggestionCardView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private GroupSuggestionCardView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130904746);
        this.f22065h = (TextView) findViewById(2131559636);
        this.f22066i = (TextView) findViewById(2131560776);
        this.f22067j = (Button) findViewById(2131562824);
        this.f22068k = (ImageView) findViewById(2131562822);
        this.f22069l = (FbDraweeView) findViewById(2131562823);
        Class cls = GroupSuggestionCardView.class;
        m23207a(this, getContext());
    }

    private void m23205a(FbUriIntentHandler fbUriIntentHandler, GraphQLQueryExecutor graphQLQueryExecutor, Locales locales, ComposerLauncher composerLauncher, SecureContextHelper secureContextHelper, GroupsAddMemberIntentProvider groupsAddMemberIntentProvider) {
        this.f22059a = fbUriIntentHandler;
        this.f22060b = graphQLQueryExecutor;
        this.f22061c = locales;
        this.f22062d = composerLauncher;
        this.f22063e = secureContextHelper;
        this.f22064f = groupsAddMemberIntentProvider;
    }

    private ComposerConfiguration m23204a(FetchGroupInformationModel fetchGroupInformationModel) {
        return GroupCommerceComposerHelper.a(GroupInformationInterfaceFactory.a(fetchGroupInformationModel), TriState.NO, this.f22061c).a();
    }

    public static void m23208b(GroupSuggestionCardView groupSuggestionCardView, FetchGroupInformationModel fetchGroupInformationModel) {
        groupSuggestionCardView.f22062d.a(null, groupSuggestionCardView.m23204a(fetchGroupInformationModel), 1756, (Activity) ContextUtils.a(groupSuggestionCardView.getContext(), Activity.class));
    }

    public static void m23209c(GroupSuggestionCardView groupSuggestionCardView, FetchGroupInformationModel fetchGroupInformationModel) {
        ComposerConfiguration.Builder a = ComposerConfiguration.a(groupSuggestionCardView.m23204a(fetchGroupInformationModel));
        a.setDisableMentions(true);
        a.setPluginConfig(new DefaultPluginConfigSerializer().a(EmptyPluginConfig.a("GroupsPollComposerPluginConfig")));
        groupSuggestionCardView.f22062d.a(null, a.a(), 1756, (Activity) ContextUtils.a(groupSuggestionCardView.getContext(), Activity.class));
    }
}
