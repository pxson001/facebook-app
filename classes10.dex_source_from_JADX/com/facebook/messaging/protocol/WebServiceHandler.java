package com.facebook.messaging.protocol;

import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.debug.debugoverlay.DebugOverlayController;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationParamsUtil;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiMethodRunner;
import com.facebook.http.protocol.ApiMethodRunner.Batch;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.attachments.OtherAttachmentData;
import com.facebook.messaging.bugreporter.foldercounts.Channel;
import com.facebook.messaging.bugreporter.foldercounts.FolderCountsDebugDataTracker;
import com.facebook.messaging.bugreporter.foldercounts.MarkFolderSeenResult;
import com.facebook.messaging.debugoverlay.MessagesDebugOverlaySettingsTags;
import com.facebook.messaging.groups.links.GQLGroupInfoQueryHelper;
import com.facebook.messaging.login.RemoteLogOutHelper;
import com.facebook.messaging.model.messages.Message.SendChannel;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadCriteria;
import com.facebook.messaging.send.common.SendMessageException;
import com.facebook.messaging.send.service.SendApiHandler;
import com.facebook.messaging.send.service.SendMessageExceptionHelper;
import com.facebook.messaging.service.base.AbstractBlueServiceHandlerFilter;
import com.facebook.messaging.service.methods.AcceptMessageRequestsMethod;
import com.facebook.messaging.service.methods.AddAdminsToGroupMethod;
import com.facebook.messaging.service.methods.AddMembersMethod;
import com.facebook.messaging.service.methods.AddMontageViewerMethod;
import com.facebook.messaging.service.methods.AddPinnedThreadMethod;
import com.facebook.messaging.service.methods.BlockUserMethod;
import com.facebook.messaging.service.methods.CreateGroupMethod;
import com.facebook.messaging.service.methods.DeleteMessagesMethod;
import com.facebook.messaging.service.methods.DeleteThreadMethod;
import com.facebook.messaging.service.methods.FetchDeliveryReceiptsMethod;
import com.facebook.messaging.service.methods.FetchGroupInviteLinkMethod;
import com.facebook.messaging.service.methods.FetchMoreMessagesMethod;
import com.facebook.messaging.service.methods.FetchMoreThreadsMethod;
import com.facebook.messaging.service.methods.FetchPinnedThreadsGQLMethod;
import com.facebook.messaging.service.methods.FetchPinnedThreadsMethod;
import com.facebook.messaging.service.methods.FetchThreadGQLMethod;
import com.facebook.messaging.service.methods.FetchThreadListMethod;
import com.facebook.messaging.service.methods.FetchThreadMethod;
import com.facebook.messaging.service.methods.GetAuthenticatedAttachmentUrlMethod;
import com.facebook.messaging.service.methods.IgnoreMessageRequestsMethod;
import com.facebook.messaging.service.methods.MarkFolderSeenMethod;
import com.facebook.messaging.service.methods.MarkFolderSeenMqttHandler;
import com.facebook.messaging.service.methods.MarkReadThreadMethod;
import com.facebook.messaging.service.methods.MessagingServiceGatekeeper;
import com.facebook.messaging.service.methods.PostGameScoreMethod;
import com.facebook.messaging.service.methods.RemoveAdminsFromGroupMethod;
import com.facebook.messaging.service.methods.RemoveMemberMethod;
import com.facebook.messaging.service.methods.RemoveMontageViewerMethod;
import com.facebook.messaging.service.methods.SearchThreadNameAndParticipantsMethod;
import com.facebook.messaging.service.methods.SetThreadEphemeralityMethod;
import com.facebook.messaging.service.methods.SetThreadImageMethod;
import com.facebook.messaging.service.methods.SetThreadMuteUntilMethod;
import com.facebook.messaging.service.methods.SetThreadNameMethod;
import com.facebook.messaging.service.methods.SetThreadParticipantNicknameMethod;
import com.facebook.messaging.service.methods.SetThreadThemeMethod;
import com.facebook.messaging.service.methods.SetUserSettingsMethod;
import com.facebook.messaging.service.methods.UnpinThreadMethod;
import com.facebook.messaging.service.methods.UpdatePinnedThreadsMethod;
import com.facebook.messaging.service.methods.WebMarkThreadsHandler;
import com.facebook.messaging.service.model.AcceptMessageRequestsParams;
import com.facebook.messaging.service.model.AddAdminsToGroupParams;
import com.facebook.messaging.service.model.AddAdminsToGroupResult;
import com.facebook.messaging.service.model.AddMembersParams;
import com.facebook.messaging.service.model.AddMontageViewerParams;
import com.facebook.messaging.service.model.AddPinnedThreadParams;
import com.facebook.messaging.service.model.BlockUserParams;
import com.facebook.messaging.service.model.CreateGroupParams;
import com.facebook.messaging.service.model.DeleteMessagesParams;
import com.facebook.messaging.service.model.DeleteThreadParams;
import com.facebook.messaging.service.model.DeleteThreadsParams;
import com.facebook.messaging.service.model.EditUsernameParams;
import com.facebook.messaging.service.model.FetchDeliveryReceiptsParams;
import com.facebook.messaging.service.model.FetchDeliveryReceiptsResult;
import com.facebook.messaging.service.model.FetchGroupInviteLinkParams;
import com.facebook.messaging.service.model.FetchIsThreadQueueEnabledParams;
import com.facebook.messaging.service.model.FetchMoreMessagesParams;
import com.facebook.messaging.service.model.FetchMoreMessagesResult;
import com.facebook.messaging.service.model.FetchMoreThreadsParams;
import com.facebook.messaging.service.model.FetchMoreThreadsResult;
import com.facebook.messaging.service.model.FetchPinnedThreadsParams;
import com.facebook.messaging.service.model.FetchPinnedThreadsResult;
import com.facebook.messaging.service.model.FetchThreadListParams;
import com.facebook.messaging.service.model.FetchThreadListResult;
import com.facebook.messaging.service.model.FetchThreadParams;
import com.facebook.messaging.service.model.FetchThreadParamsBuilder;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.service.model.IgnoreMessageRequestsParams;
import com.facebook.messaging.service.model.MarkThreadFields.MarkThreadFieldsBuilder;
import com.facebook.messaging.service.model.MarkThreadsParams;
import com.facebook.messaging.service.model.ModifyThreadParams;
import com.facebook.messaging.service.model.ModifyThreadParamsBuilder;
import com.facebook.messaging.service.model.PostGameScoreParams;
import com.facebook.messaging.service.model.PostGameScoreResult;
import com.facebook.messaging.service.model.RemoveAdminsFromGroupParams;
import com.facebook.messaging.service.model.RemoveAdminsFromGroupResult;
import com.facebook.messaging.service.model.RemoveMemberParams;
import com.facebook.messaging.service.model.RemoveMontageViewerParams;
import com.facebook.messaging.service.model.SearchThreadNameAndParticipantsParams;
import com.facebook.messaging.service.model.SearchThreadNameAndParticipantsResult;
import com.facebook.messaging.service.model.SendMessageByRecipientsParams;
import com.facebook.messaging.service.model.SetSettingsParams;
import com.facebook.messaging.service.model.SetThreadThemeResult;
import com.facebook.messaging.service.model.UnpinThreadParams;
import com.facebook.messaging.service.model.UpdatePinnedThreadsParams;
import com.facebook.messaging.threads.graphql.ConversationRequestsThreadListFetcher;
import com.facebook.messaging.threads.graphql.GQLSearchThreadNameAndParticipantsHelper;
import com.facebook.messaging.threads.graphql.GQLThreadQueryHelper;
import com.facebook.messaging.users.username.graphql.MessagingUsernameGraphQLHandler;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableList;
import javax.inject.Provider;

/* compiled from: registration_cp_suggestion_ready */
public class WebServiceHandler extends AbstractBlueServiceHandlerFilter {
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RemoveMontageViewerMethod> f3677A = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<MarkReadThreadMethod> f3678B = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<BlockUserMethod> f3679C = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<DeleteThreadMethod> f3680D = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<DeleteMessagesMethod> f3681E = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SetThreadEphemeralityMethod> f3682F = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SetThreadNameMethod> f3683G = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SetThreadImageMethod> f3684H = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SetThreadParticipantNicknameMethod> f3685I = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SetThreadThemeMethod> f3686J = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<MarkFolderSeenMethod> f3687K = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<MarkFolderSeenMqttHandler> f3688L = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SetThreadMuteUntilMethod> f3689M = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SetUserSettingsMethod> f3690N = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<CreateGroupMethod> f3691O = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GetAuthenticatedAttachmentUrlMethod> f3692P = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FetchDeliveryReceiptsMethod> f3693Q = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SendApiHandler> f3694R = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FetchGroupInviteLinkMethod> f3695S = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AddAdminsToGroupMethod> f3696T = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RemoveAdminsFromGroupMethod> f3697U = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PostGameScoreMethod> f3698V = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GQLThreadQueryHelper> f3699W = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<MessagingServiceGatekeeper> f3700X = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ConversationRequestsThreadListFetcher> f3701Y = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<MessagingUsernameGraphQLHandler> f3702Z = UltralightRuntime.b;
    private final ApiMethodRunnerImpl f3703a;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SendMessageExceptionHelper> aa = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GQLSearchThreadNameAndParticipantsHelper> ab = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<WebMarkThreadsHandler> ac = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GQLGroupInfoQueryHelper> ad = UltralightRuntime.b;
    private final DebugOverlayController f3704b;
    private final Provider<Boolean> f3705c;
    private final Provider<Boolean> f3706d;
    private final Provider<Boolean> f3707e;
    private final Provider<Boolean> f3708f;
    private final Provider<Boolean> f3709g;
    private final MessagingPerformanceLogger f3710h;
    private final Provider<RemoteLogOutHelper> f3711i;
    private final Provider<FolderCountsDebugDataTracker> f3712j;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FetchThreadListMethod> f3713k = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FetchMoreThreadsMethod> f3714l = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FetchThreadMethod> f3715m = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FetchThreadGQLMethod> f3716n = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SearchThreadNameAndParticipantsMethod> f3717o = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FetchPinnedThreadsMethod> f3718p = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FetchPinnedThreadsGQLMethod> f3719q = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FetchMoreMessagesMethod> f3720r = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AcceptMessageRequestsMethod> f3721s = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<IgnoreMessageRequestsMethod> f3722t = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AddMembersMethod> f3723u = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AddMontageViewerMethod> f3724v = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AddPinnedThreadMethod> f3725w = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<UpdatePinnedThreadsMethod> f3726x = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<UnpinThreadMethod> f3727y = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RemoveMemberMethod> f3728z = UltralightRuntime.b;

    /* compiled from: registration_cp_suggestion_ready */
    class UnhandledWebServiceOperation extends Exception {
        UnhandledWebServiceOperation(OperationParams operationParams) {
            super("WebServiceHandler received unsupported operation of type " + operationParams.b);
        }
    }

    private void m3492a(com.facebook.inject.Lazy<FetchThreadListMethod> lazy, com.facebook.inject.Lazy<FetchMoreThreadsMethod> lazy2, com.facebook.inject.Lazy<FetchThreadMethod> lazy3, com.facebook.inject.Lazy<FetchThreadGQLMethod> lazy4, com.facebook.inject.Lazy<SearchThreadNameAndParticipantsMethod> lazy5, com.facebook.inject.Lazy<FetchPinnedThreadsMethod> lazy6, com.facebook.inject.Lazy<FetchPinnedThreadsGQLMethod> lazy7, com.facebook.inject.Lazy<FetchMoreMessagesMethod> lazy8, com.facebook.inject.Lazy<AcceptMessageRequestsMethod> lazy9, com.facebook.inject.Lazy<IgnoreMessageRequestsMethod> lazy10, com.facebook.inject.Lazy<AddMembersMethod> lazy11, com.facebook.inject.Lazy<AddMontageViewerMethod> lazy12, com.facebook.inject.Lazy<AddPinnedThreadMethod> lazy13, com.facebook.inject.Lazy<UpdatePinnedThreadsMethod> lazy14, com.facebook.inject.Lazy<UnpinThreadMethod> lazy15, com.facebook.inject.Lazy<RemoveMemberMethod> lazy16, com.facebook.inject.Lazy<RemoveMontageViewerMethod> lazy17, com.facebook.inject.Lazy<MarkReadThreadMethod> lazy18, com.facebook.inject.Lazy<BlockUserMethod> lazy19, com.facebook.inject.Lazy<DeleteThreadMethod> lazy20, com.facebook.inject.Lazy<DeleteMessagesMethod> lazy21, com.facebook.inject.Lazy<SetThreadEphemeralityMethod> lazy22, com.facebook.inject.Lazy<SetThreadNameMethod> lazy23, com.facebook.inject.Lazy<SetThreadImageMethod> lazy24, com.facebook.inject.Lazy<SetThreadParticipantNicknameMethod> lazy25, com.facebook.inject.Lazy<SetThreadThemeMethod> lazy26, com.facebook.inject.Lazy<MarkFolderSeenMethod> lazy27, com.facebook.inject.Lazy<MarkFolderSeenMqttHandler> lazy28, com.facebook.inject.Lazy<SetThreadMuteUntilMethod> lazy29, com.facebook.inject.Lazy<SetUserSettingsMethod> lazy30, com.facebook.inject.Lazy<CreateGroupMethod> lazy31, com.facebook.inject.Lazy<GetAuthenticatedAttachmentUrlMethod> lazy32, com.facebook.inject.Lazy<FetchDeliveryReceiptsMethod> lazy33, com.facebook.inject.Lazy<SendApiHandler> lazy34, com.facebook.inject.Lazy<FetchGroupInviteLinkMethod> lazy35, com.facebook.inject.Lazy<AddAdminsToGroupMethod> lazy36, com.facebook.inject.Lazy<RemoveAdminsFromGroupMethod> lazy37, com.facebook.inject.Lazy<PostGameScoreMethod> lazy38, com.facebook.inject.Lazy<GQLThreadQueryHelper> lazy39, com.facebook.inject.Lazy<MessagingServiceGatekeeper> lazy40, com.facebook.inject.Lazy<ConversationRequestsThreadListFetcher> lazy41, com.facebook.inject.Lazy<MessagingUsernameGraphQLHandler> lazy42, com.facebook.inject.Lazy<SendMessageExceptionHelper> lazy43, com.facebook.inject.Lazy<GQLSearchThreadNameAndParticipantsHelper> lazy44, com.facebook.inject.Lazy<WebMarkThreadsHandler> lazy45, com.facebook.inject.Lazy<GQLGroupInfoQueryHelper> lazy46) {
        this.f3713k = lazy;
        this.f3714l = lazy2;
        this.f3715m = lazy3;
        this.f3716n = lazy4;
        this.f3717o = lazy5;
        this.f3718p = lazy6;
        this.f3719q = lazy7;
        this.f3720r = lazy8;
        this.f3721s = lazy9;
        this.f3722t = lazy10;
        this.f3723u = lazy11;
        this.f3724v = lazy12;
        this.f3725w = lazy13;
        this.f3726x = lazy14;
        this.f3727y = lazy15;
        this.f3728z = lazy16;
        this.f3677A = lazy17;
        this.f3678B = lazy18;
        this.f3679C = lazy19;
        this.f3680D = lazy20;
        this.f3681E = lazy21;
        this.f3682F = lazy22;
        this.f3683G = lazy23;
        this.f3684H = lazy24;
        this.f3685I = lazy25;
        this.f3686J = lazy26;
        this.f3687K = lazy27;
        this.f3688L = lazy28;
        this.f3689M = lazy29;
        this.f3690N = lazy30;
        this.f3691O = lazy31;
        this.f3692P = lazy32;
        this.f3693Q = lazy33;
        this.f3694R = lazy34;
        this.f3695S = lazy35;
        this.f3696T = lazy36;
        this.f3697U = lazy37;
        this.f3698V = lazy38;
        this.f3699W = lazy39;
        this.f3700X = lazy40;
        this.f3701Y = lazy41;
        this.f3702Z = lazy42;
        this.aa = lazy43;
        this.ab = lazy44;
        this.ac = lazy45;
        this.ad = lazy46;
    }

    public static WebServiceHandler m3494b(InjectorLike injectorLike) {
        WebServiceHandler webServiceHandler = new WebServiceHandler(ApiMethodRunnerImpl.a(injectorLike), DebugOverlayController.a(injectorLike), IdBasedProvider.a(injectorLike, 4075), IdBasedProvider.a(injectorLike, 4209), IdBasedProvider.a(injectorLike, 4208), IdBasedProvider.a(injectorLike, 4067), IdBasedProvider.a(injectorLike, 4211), MessagingPerformanceLogger.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 7906), IdBasedProvider.a(injectorLike, 2558));
        webServiceHandler.m3492a(IdBasedLazy.a(injectorLike, 8383), IdBasedLazy.a(injectorLike, 8379), IdBasedLazy.a(injectorLike, 8384), IdBasedLazy.a(injectorLike, 8382), IdBasedLazy.a(injectorLike, 8407), IdBasedLazy.a(injectorLike, 8381), IdBasedLazy.a(injectorLike, 8380), IdBasedLazy.a(injectorLike, 8378), IdBasedLazy.a(injectorLike, 8359), IdBasedLazy.a(injectorLike, 8387), IdBasedLazy.a(injectorLike, 8361), IdBasedLazy.a(injectorLike, 8362), IdBasedLazy.a(injectorLike, 8363), IdBasedLazy.a(injectorLike, 8423), IdBasedLazy.a(injectorLike, 8422), IdBasedLazy.a(injectorLike, 8405), IdBasedLazy.a(injectorLike, 8406), IdBasedLazy.a(injectorLike, 8391), IdBasedLazy.a(injectorLike, 8366), IdBasedLazy.a(injectorLike, 8371), IdBasedLazy.a(injectorLike, 8370), IdBasedLazy.a(injectorLike, 8412), IdBasedLazy.a(injectorLike, 8415), IdBasedLazy.a(injectorLike, 8413), IdBasedLazy.a(injectorLike, 8416), IdBasedLazy.a(injectorLike, 8417), IdBasedLazy.a(injectorLike, 8389), IdBasedLazy.a(injectorLike, 8390), IdBasedLazy.a(injectorLike, 8414), IdBasedLazy.a(injectorLike, 8418), IdBasedLazy.a(injectorLike, 8367), IdBasedLazy.a(injectorLike, 8386), IdBasedLazy.a(injectorLike, 8373), IdBasedLazy.a(injectorLike, 8352), IdBasedLazy.a(injectorLike, 8374), IdBasedLazy.a(injectorLike, 8360), IdBasedLazy.a(injectorLike, 8404), IdBasedLazy.a(injectorLike, 8401), IdBasedLazy.a(injectorLike, 8547), IdBasedLazy.a(injectorLike, 8394), IdBasedLazy.a(injectorLike, 8544), IdBasedLazy.a(injectorLike, 8595), IdBasedSingletonScopeProvider.b(injectorLike, 8353), IdBasedLazy.a(injectorLike, 8546), IdBasedSingletonScopeProvider.b(injectorLike, 8424), IdBasedLazy.a(injectorLike, 7865));
        return webServiceHandler;
    }

    protected final OperationResult m3495A(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((Uri) this.f3703a.a((ApiMethod) this.f3692P.get(), (OtherAttachmentData) operationParams.c.getParcelable("attachment")));
    }

    protected final OperationResult m3496B(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((FetchDeliveryReceiptsResult) this.f3703a.a((ApiMethod) this.f3693Q.get(), (FetchDeliveryReceiptsParams) operationParams.c.getParcelable("fetchDeliveryReceiptsParams")));
    }

    protected final OperationResult m3498D(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        this.f3703a.a((ApiMethod) this.f3724v.get(), (AddMontageViewerParams) operationParams.c.getParcelable("addMontageViewerParams"));
        return OperationResult.a;
    }

    protected final OperationResult m3499E(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        this.f3703a.a((ApiMethod) this.f3677A.get(), (RemoveMontageViewerParams) operationParams.c.getParcelable("removeMontageViewerParams"));
        return OperationResult.a;
    }

    protected final OperationResult m3500F(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        this.f3703a.a((ApiMethod) this.f3721s.get(), (AcceptMessageRequestsParams) operationParams.c.getParcelable(AcceptMessageRequestsParams.a));
        return OperationResult.a;
    }

    protected final OperationResult m3501G(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        this.f3703a.a((ApiMethod) this.f3722t.get(), (IgnoreMessageRequestsParams) operationParams.c.getParcelable(IgnoreMessageRequestsParams.a));
        return OperationResult.a;
    }

    protected final OperationResult m3504J(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((String) this.f3703a.a((ApiMethod) this.f3695S.get(), (FetchGroupInviteLinkParams) operationParams.c.getParcelable(FetchGroupInviteLinkParams.a)));
    }

    protected final OperationResult m3506L(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((AddAdminsToGroupResult) this.f3703a.a((ApiMethod) this.f3696T.get(), (AddAdminsToGroupParams) operationParams.c.getParcelable(AddAdminsToGroupParams.a)));
    }

    protected final OperationResult m3507M(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((RemoveAdminsFromGroupResult) this.f3703a.a((ApiMethod) this.f3697U.get(), (RemoveAdminsFromGroupParams) operationParams.c.getParcelable(RemoveAdminsFromGroupParams.a)));
    }

    protected final OperationResult m3508N(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((PostGameScoreResult) this.f3703a.a((ApiMethod) this.f3698V.get(), (PostGameScoreParams) operationParams.c.getParcelable(PostGameScoreParams.a)));
    }

    protected final OperationResult m3509O(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a(((MessagingUsernameGraphQLHandler) this.f3702Z.get()).m4478b(((EditUsernameParams) operationParams.c.getParcelable(EditUsernameParams.a)).b));
    }

    protected final OperationResult m3510P(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a(((GQLGroupInfoQueryHelper) this.ad.get()).m2478a(((FetchIsThreadQueueEnabledParams) operationParams.c.getParcelable(FetchIsThreadQueueEnabledParams.a)).b));
    }

    protected final OperationResult m3514b(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        Bundle bundle = operationParams.c;
        int i = bundle.getInt("logger_instance_key");
        MessagingPerformanceLogger messagingPerformanceLogger = this.f3710h;
        boolean booleanValue = ((Boolean) this.f3706d.get()).booleanValue();
        messagingPerformanceLogger.d.a(5505042, i, (short) 24);
        messagingPerformanceLogger.d.b(5505042, i, booleanValue ? "GRAPH_QL" : "FQL");
        FetchThreadListParams fetchThreadListParams = (FetchThreadListParams) bundle.getParcelable("fetchThreadListParams");
        if (!((Boolean) this.f3706d.get()).booleanValue()) {
            this.f3704b.a(MessagesDebugOverlaySettingsTags.a, "fetchThreadList (WSH)");
            FetchThreadListResult fetchThreadListResult = (FetchThreadListResult) this.f3703a.a((ApiMethod) this.f3713k.get(), fetchThreadListParams);
            this.f3710h.d.a(5505042, i, (short) 31);
            return OperationResult.a(fetchThreadListResult);
        } else if (fetchThreadListParams.b.isMessageRequestFolders()) {
            return OperationResult.a(((ConversationRequestsThreadListFetcher) this.f3701Y.get()).a(fetchThreadListParams, operationParams.e));
        } else {
            return OperationResult.a(((GQLThreadQueryHelper) this.f3699W.get()).b(fetchThreadListParams, operationParams.e));
        }
    }

    protected final OperationResult m3515c(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        FetchMoreThreadsParams fetchMoreThreadsParams = (FetchMoreThreadsParams) operationParams.c.getParcelable("fetchMoreThreadsParams");
        if (!((Boolean) this.f3706d.get()).booleanValue()) {
            this.f3704b.a(MessagesDebugOverlaySettingsTags.a, "fetchMoreThreads (WSH)");
            return OperationResult.a((FetchMoreThreadsResult) this.f3703a.a((ApiMethod) this.f3714l.get(), fetchMoreThreadsParams));
        } else if (fetchMoreThreadsParams.a.isMessageRequestFolders()) {
            return OperationResult.a(((ConversationRequestsThreadListFetcher) this.f3701Y.get()).a(fetchMoreThreadsParams, operationParams.e));
        } else {
            return OperationResult.a(((GQLThreadQueryHelper) this.f3699W.get()).b(fetchMoreThreadsParams, operationParams.e));
        }
    }

    protected final OperationResult m3518f(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        AddMembersParams addMembersParams = (AddMembersParams) operationParams.c.getParcelable("addMembersParams");
        Batch a = this.f3703a.a();
        Builder a2 = BatchOperation.a((ApiMethod) this.f3723u.get(), addMembersParams);
        a2.c = "add-members";
        a.a(a2.a());
        m3491a(a, ThreadCriteria.a(addMembersParams.a), "add-members");
        a.a("addMembers", CallerContext.a(getClass()));
        return OperationResult.a((FetchThreadResult) a.a("fetch-thread"));
    }

    protected final OperationResult m3519g(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        ApiMethod apiMethod;
        CreateGroupParams createGroupParams = (CreateGroupParams) operationParams.c.getParcelable("createGroupParams");
        Batch a = this.f3703a.a();
        Builder a2 = BatchOperation.a((ApiMethod) this.f3691O.get(), createGroupParams);
        a2.c = "create-group";
        a.a(a2.a());
        if (createGroupParams.d) {
            a2 = BatchOperation.a((ApiMethod) this.f3725w.get(), new AddPinnedThreadParams(null, "{result=create-group:$.id}"));
            a2.c = "add-pinned-thread";
            a2 = a2;
            a2.d = "create-group";
            a.a(a2.a());
        }
        MediaResource mediaResource = createGroupParams.b;
        if (mediaResource != null) {
            ModifyThreadParamsBuilder modifyThreadParamsBuilder = new ModifyThreadParamsBuilder();
            modifyThreadParamsBuilder.b = "{result=create-group:$.id}";
            a2 = BatchOperation.a((ApiMethod) this.f3684H.get(), modifyThreadParamsBuilder.a(mediaResource).q());
            a2.c = "setThreadImage";
            a2 = a2;
            a2.d = "create-group";
            a.a(a2.a());
        }
        FetchThreadParamsBuilder fetchThreadParamsBuilder = new FetchThreadParamsBuilder();
        fetchThreadParamsBuilder.b = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
        FetchThreadParamsBuilder fetchThreadParamsBuilder2 = fetchThreadParamsBuilder;
        if (((MessagingServiceGatekeeper) this.f3700X.get()).a()) {
            fetchThreadParamsBuilder2.a = ThreadCriteria.b("{result=create-group:$.id}");
            a2 = BatchOperation.a((ApiMethod) this.f3716n.get(), fetchThreadParamsBuilder2.i());
        } else {
            fetchThreadParamsBuilder2.a = ThreadCriteria.a("{result=create-group:$.id}");
            a2 = BatchOperation.a((ApiMethod) this.f3715m.get(), fetchThreadParamsBuilder2.i());
        }
        a2.c = "fetch-thread";
        a2 = a2;
        a2.d = "create-group";
        a.a(a2.a());
        if (((Boolean) this.f3707e.get()).booleanValue()) {
            apiMethod = (ApiMethod) this.f3719q.get();
        } else {
            apiMethod = (ApiMethod) this.f3718p.get();
        }
        a2 = BatchOperation.a(apiMethod, FetchPinnedThreadsParams.a);
        a2.c = "fetch-pinned-threads";
        a2 = a2;
        if (createGroupParams.d) {
            a2.d = "add-pinned-thread";
        }
        a.a(a2.a());
        a.a("createGroup", CallerContext.a(getClass()));
        FetchThreadResult fetchThreadResult = (FetchThreadResult) a.a("fetch-thread");
        Pair create = Pair.create("fetchPinnedThreadsResult", (FetchPinnedThreadsResult) a.a("fetch-pinned-threads"));
        return OperationResult.a(fetchThreadResult, new Pair[]{create});
    }

    protected final OperationResult m3521i(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        FetchMoreMessagesParams fetchMoreMessagesParams = (FetchMoreMessagesParams) operationParams.c.getParcelable("fetchMoreMessagesParams");
        if (((Boolean) this.f3706d.get()).booleanValue() && fetchMoreMessagesParams.b != null && fetchMoreMessagesParams.c > 0) {
            return OperationResult.a(((GQLThreadQueryHelper) this.f3699W.get()).a(fetchMoreMessagesParams, operationParams.e));
        }
        this.f3704b.a(MessagesDebugOverlaySettingsTags.a, "fetchMoreMessages (WSH). " + fetchMoreMessagesParams.a);
        return OperationResult.a((FetchMoreMessagesResult) this.f3703a.a((ApiMethod) this.f3720r.get(), fetchMoreMessagesParams));
    }

    protected final OperationResult m3522j(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        RemoveMemberParams removeMemberParams = (RemoveMemberParams) operationParams.c.getParcelable("removeMemberParams");
        Batch a = this.f3703a.a();
        Builder a2 = BatchOperation.a((ApiMethod) this.f3728z.get(), removeMemberParams);
        a2.c = "remove-members";
        a.a(a2.a());
        m3491a(a, ThreadCriteria.a(removeMemberParams.b), "remove-members");
        if (removeMemberParams.a) {
            ApiMethod apiMethod;
            if (((Boolean) this.f3707e.get()).booleanValue()) {
                apiMethod = (ApiMethod) this.f3719q.get();
            } else {
                apiMethod = (ApiMethod) this.f3718p.get();
            }
            Builder a3 = BatchOperation.a(apiMethod, FetchPinnedThreadsParams.a);
            a3.c = "fetch-pinned-threads";
            a3 = a3;
            a3.d = "remove-members";
            a.a(a3.a());
        }
        a.a("removeMember", CallerContext.a(getClass()));
        FetchThreadResult fetchThreadResult = (FetchThreadResult) a.a("fetch-thread");
        Pair create = Pair.create("fetchPinnedThreadsResult", (FetchPinnedThreadsResult) a.a("fetch-pinned-threads"));
        return OperationResult.a(fetchThreadResult, new Pair[]{create});
    }

    protected final OperationResult m3523k(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        ((WebMarkThreadsHandler) this.ac.get()).a((MarkThreadsParams) operationParams.c.getParcelable("markThreadsParams"));
        return OperationResult.a;
    }

    protected final OperationResult m3524l(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        this.f3703a.a((ApiMethod) this.f3679C.get(), (BlockUserParams) operationParams.c.getParcelable("blockUserParams"));
        return OperationResult.a;
    }

    protected final OperationResult m3525m(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        ImmutableList immutableList = ((DeleteThreadsParams) operationParams.c.getParcelable("deleteThreadsParams")).a;
        Batch a = this.f3703a.a();
        for (int i = 0; i < immutableList.size(); i++) {
            Builder a2 = BatchOperation.a((ApiMethod) this.f3680D.get(), new DeleteThreadParams((ThreadKey) immutableList.get(i)));
            a2.c = "thread-key-" + i;
            a.a(a2.a());
        }
        a.a("deleteThreads", CallerContext.a(getClass()));
        return OperationResult.a((FetchThreadResult) a.a("fetch-thread"));
    }

    protected final OperationResult m3527o(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        this.f3703a.a((ApiMethod) this.f3681E.get(), (DeleteMessagesParams) operationParams.c.getParcelable("deleteMessagesParams"));
        return OperationResult.a;
    }

    protected final OperationResult m3532t(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        this.f3703a.a((ApiMethod) this.f3690N.get(), (SetSettingsParams) operationParams.c.getParcelable("setSettingsParams"));
        return OperationResult.a;
    }

    protected final OperationResult m3534v(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        Object a;
        SearchThreadNameAndParticipantsParams searchThreadNameAndParticipantsParams = (SearchThreadNameAndParticipantsParams) operationParams.c.getParcelable("searchThreadNameAndParticipantsParam");
        if (((Boolean) this.f3709g.get()).booleanValue()) {
            a = ((GQLSearchThreadNameAndParticipantsHelper) this.ab.get()).a(searchThreadNameAndParticipantsParams);
        } else {
            a = (SearchThreadNameAndParticipantsResult) this.f3703a.a((ApiMethod) this.f3717o.get(), searchThreadNameAndParticipantsParams);
        }
        return OperationResult.a(a);
    }

    protected final OperationResult m3535w(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        FetchPinnedThreadsParams fetchPinnedThreadsParams = (FetchPinnedThreadsParams) operationParams.c.getParcelable("fetchPinnedThreadsParams");
        return ((Boolean) this.f3707e.get()).booleanValue() ? OperationResult.a(((GQLThreadQueryHelper) this.f3699W.get()).a(fetchPinnedThreadsParams, operationParams.e)) : OperationResult.a((FetchPinnedThreadsResult) this.f3703a.a((ApiMethod) this.f3718p.get(), fetchPinnedThreadsParams));
    }

    protected final OperationResult m3536x(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        ApiMethod apiMethod;
        UpdatePinnedThreadsParams updatePinnedThreadsParams = (UpdatePinnedThreadsParams) operationParams.c.getParcelable("updatePinnedThreadsParams");
        Batch a = this.f3703a.a();
        Builder a2 = BatchOperation.a((ApiMethod) this.f3726x.get(), updatePinnedThreadsParams);
        a2.c = "update-pinned-threads";
        a.a(a2.a());
        if (((Boolean) this.f3707e.get()).booleanValue()) {
            apiMethod = (ApiMethod) this.f3719q.get();
        } else {
            apiMethod = (ApiMethod) this.f3718p.get();
        }
        a2 = BatchOperation.a(apiMethod, FetchPinnedThreadsParams.a);
        a2.c = "fetch-pinned-threads";
        a2 = a2;
        a2.d = "update-pinned-threads";
        a.a(a2.a());
        a.a("updatePinnedThreads", CallerContext.a(getClass()));
        return OperationResult.a((FetchPinnedThreadsResult) a.a("fetch-pinned-threads"));
    }

    protected final OperationResult m3537y(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        ApiMethod apiMethod;
        AddPinnedThreadParams addPinnedThreadParams = (AddPinnedThreadParams) operationParams.c.getParcelable("addPinnedThreadParams");
        Batch a = this.f3703a.a();
        Builder a2 = BatchOperation.a((ApiMethod) this.f3725w.get(), addPinnedThreadParams);
        a2.c = "add-pinned-thread";
        a.a(a2.a());
        if (((Boolean) this.f3707e.get()).booleanValue()) {
            apiMethod = (ApiMethod) this.f3719q.get();
        } else {
            apiMethod = (ApiMethod) this.f3718p.get();
        }
        a2 = BatchOperation.a(apiMethod, FetchPinnedThreadsParams.a);
        a2.c = "fetch-pinned-threads";
        a2 = a2;
        a2.d = "add-pinned-thread";
        a.a(a2.a());
        a.a("addPinnedThread", CallerContext.a(getClass()));
        return OperationResult.a((FetchPinnedThreadsResult) a.a("fetch-pinned-threads"));
    }

    protected final OperationResult m3538z(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        ApiMethod apiMethod;
        UnpinThreadParams unpinThreadParams = (UnpinThreadParams) operationParams.c.getParcelable("unpinThreadParams");
        Batch a = this.f3703a.a();
        Builder a2 = BatchOperation.a((ApiMethod) this.f3727y.get(), unpinThreadParams);
        a2.c = "unpin-thread";
        a.a(a2.a());
        if (((Boolean) this.f3707e.get()).booleanValue()) {
            apiMethod = (ApiMethod) this.f3719q.get();
        } else {
            apiMethod = (ApiMethod) this.f3718p.get();
        }
        a2 = BatchOperation.a(apiMethod, FetchPinnedThreadsParams.a);
        a2.c = "fetch-pinned-threads";
        a2 = a2;
        a2.d = "unpin-thread";
        a.a(a2.a());
        a.a("unpinThread", CallerContext.a(getClass()));
        return OperationResult.a((FetchPinnedThreadsResult) a.a("fetch-pinned-threads"));
    }

    @Inject
    private WebServiceHandler(ApiMethodRunner apiMethodRunner, DebugOverlayController debugOverlayController, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<Boolean> provider5, MessagingPerformanceLogger messagingPerformanceLogger, Provider<RemoteLogOutHelper> provider6, Provider<FolderCountsDebugDataTracker> provider7) {
        super("WebServiceHandler");
        this.f3703a = apiMethodRunner;
        this.f3704b = debugOverlayController;
        this.f3705c = provider;
        this.f3706d = provider2;
        this.f3707e = provider3;
        this.f3708f = provider4;
        this.f3709g = provider5;
        this.f3710h = messagingPerformanceLogger;
        this.f3711i = provider6;
        this.f3712j = provider7;
    }

    public final OperationResult m3513a(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        try {
            return super.a(operationParams, blueServiceHandler);
        } catch (Exception e) {
            ((RemoteLogOutHelper) this.f3711i.get()).a(e);
            throw e;
        }
    }

    protected final OperationResult m3516d(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        Bundle bundle = operationParams.c;
        int i = bundle.getInt("logger_instance_key");
        MessagingPerformanceLogger messagingPerformanceLogger = this.f3710h;
        boolean booleanValue = ((Boolean) this.f3706d.get()).booleanValue();
        messagingPerformanceLogger.d.a(5505041, i, (short) 24);
        messagingPerformanceLogger.d.b(5505041, i, booleanValue ? "GRAPH_QL" : "FQL");
        FetchThreadParams fetchThreadParams = (FetchThreadParams) bundle.getParcelable("fetchThreadParams");
        if (((Boolean) this.f3706d.get()).booleanValue()) {
            return OperationResult.a(((GQLThreadQueryHelper) this.f3699W.get()).a(fetchThreadParams, operationParams.e));
        }
        boolean z;
        Builder a;
        String str;
        this.f3704b.a(MessagesDebugOverlaySettingsTags.a, "fetchThread (WSH). " + fetchThreadParams.a);
        Batch a2 = this.f3703a.a();
        ThreadKey a3 = fetchThreadParams.a.a();
        if (!fetchThreadParams.d || a3 == null) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            MarkThreadFieldsBuilder markThreadFieldsBuilder = new MarkThreadFieldsBuilder();
            markThreadFieldsBuilder.a = a3;
            markThreadFieldsBuilder = markThreadFieldsBuilder;
            markThreadFieldsBuilder.b = true;
            markThreadFieldsBuilder = markThreadFieldsBuilder;
            markThreadFieldsBuilder.c = fetchThreadParams.e;
            a = BatchOperation.a((ApiMethod) this.f3678B.get(), markThreadFieldsBuilder.a());
            a.c = "update-last-read";
            a2.a(a.a());
        }
        Builder a4 = BatchOperation.a((ApiMethod) this.f3715m.get(), fetchThreadParams);
        a4.c = "fetch-thread";
        a = a4;
        if (z) {
            str = "update-last-read";
        } else {
            str = null;
        }
        a.d = str;
        a2.a(a.a());
        a2.a("fetchThread", operationParams.e);
        FetchThreadResult fetchThreadResult = (FetchThreadResult) a2.a("fetch-thread");
        this.f3710h.m(i);
        return OperationResult.a(fetchThreadResult);
    }

    protected final OperationResult m3520h(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        SendMessageByRecipientsParams sendMessageByRecipientsParams = (SendMessageByRecipientsParams) operationParams.b().getParcelable("createThreadParams");
        try {
            return OperationResult.a(((SendApiHandler) this.f3694R.get()).m3640a(sendMessageByRecipientsParams));
        } catch (Throwable th) {
            SendMessageException a = ((SendMessageExceptionHelper) this.aa.get()).m3653a(th, sendMessageByRecipientsParams.a(), SendChannel.UNKNOWN);
        }
    }

    protected final OperationResult m3526n(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        throw new UnhandledWebServiceOperation(operationParams);
    }

    protected final OperationResult m3528p(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        String str;
        ThreadCriteria a;
        ModifyThreadParams modifyThreadParams = (ModifyThreadParams) OperationParamsUtil.a(operationParams, "modifyThreadParams");
        Batch a2 = this.f3703a.a();
        if (modifyThreadParams.c) {
            Builder a3 = BatchOperation.a((ApiMethod) this.f3683G.get(), modifyThreadParams);
            a3.c = "setThreadName";
            a2.a(a3.a());
            str = "setThreadName";
        } else {
            str = null;
        }
        if (modifyThreadParams.f) {
            a3 = BatchOperation.a((ApiMethod) this.f3684H.get(), modifyThreadParams);
            a3.c = "setThreadImage";
            a3 = a3;
            a3.d = str;
            a2.a(a3.a());
            str = "setThreadImage";
        }
        if (modifyThreadParams.g) {
            a3 = BatchOperation.a((ApiMethod) this.f3689M.get(), modifyThreadParams);
            a3.c = "muteThread";
            a3 = a3;
            a3.d = str;
            a2.a(a3.a());
            str = "muteThread";
        }
        if (modifyThreadParams.n) {
            a3 = BatchOperation.a((ApiMethod) this.f3682F.get(), modifyThreadParams);
            a3.c = "setThreadEphemerality";
            a3 = a3;
            a3.d = str;
            a2.a(a3.a());
            str = "setThreadEphemerality";
        }
        if (modifyThreadParams.i || modifyThreadParams.j) {
            a3 = BatchOperation.a((ApiMethod) this.f3686J.get(), modifyThreadParams);
            a3.c = "setThreadTheme";
            a3 = a3;
            a3.d = str;
            a2.a(a3.a());
            str = "setThreadTheme";
        }
        if (modifyThreadParams.k != null) {
            a3 = BatchOperation.a((ApiMethod) this.f3685I.get(), modifyThreadParams);
            a3.c = "setThreadParticipantNickname";
            a3 = a3;
            a3.d = str;
            a2.a(a3.a());
            str = "setThreadParticipantNickname";
        }
        if (modifyThreadParams.a != null) {
            a = ThreadCriteria.a(modifyThreadParams.a);
        } else {
            a = ThreadCriteria.a(modifyThreadParams.b);
        }
        m3491a(a2, a, str);
        a2.a("modifyThread", CallerContext.a(getClass()));
        FetchThreadResult fetchThreadResult = (FetchThreadResult) a2.a("fetch-thread");
        Pair create = Pair.create("setThreadThemeResult", (SetThreadThemeResult) a2.a("setThreadTheme"));
        return OperationResult.a(fetchThreadResult, new Pair[]{create});
    }

    protected final OperationResult m3529q(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        if (((Boolean) this.f3708f.get()).booleanValue()) {
            return m3493b();
        }
        return m3490a();
    }

    private OperationResult m3490a() {
        try {
            this.f3703a.a((ApiMethod) this.f3687K.get(), null);
            ((FolderCountsDebugDataTracker) this.f3712j.get()).a(MarkFolderSeenResult.a(Channel.GRAPH));
            return OperationResult.a();
        } catch (Throwable e) {
            Throwable th = e;
            ((FolderCountsDebugDataTracker) this.f3712j.get()).a(MarkFolderSeenResult.a(th, Channel.GRAPH));
            throw th;
        }
    }

    private OperationResult m3493b() {
        try {
            OperationResult a = ((MarkFolderSeenMqttHandler) this.f3688L.get()).a();
            if (a.b()) {
                ((FolderCountsDebugDataTracker) this.f3712j.get()).a(MarkFolderSeenResult.a(Channel.MQTT));
            } else {
                ((FolderCountsDebugDataTracker) this.f3712j.get()).a(MarkFolderSeenResult.a(Channel.MQTT, a.d()));
            }
            return a;
        } catch (Throwable e) {
            Throwable th = e;
            ((FolderCountsDebugDataTracker) this.f3712j.get()).a(MarkFolderSeenResult.a(th, Channel.MQTT));
            throw th;
        }
    }

    private void m3491a(Batch batch, ThreadCriteria threadCriteria, String str) {
        if (!((Boolean) this.f3705c.get()).booleanValue()) {
            FetchThreadParamsBuilder fetchThreadParamsBuilder = new FetchThreadParamsBuilder();
            fetchThreadParamsBuilder.b = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
            fetchThreadParamsBuilder = fetchThreadParamsBuilder;
            fetchThreadParamsBuilder.a = threadCriteria;
            fetchThreadParamsBuilder = fetchThreadParamsBuilder;
            fetchThreadParamsBuilder.f = 2;
            Builder a = BatchOperation.a((ApiMethod) this.f3715m.get(), fetchThreadParamsBuilder.i());
            a.c = "fetch-thread";
            a = a;
            a.d = str;
            batch.a(a.a());
        }
    }

    protected final OperationResult m3502H(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        throw new UnhandledWebServiceOperation(operationParams);
    }

    protected final OperationResult m3517e(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        throw new UnhandledWebServiceOperation(operationParams);
    }

    protected final OperationResult m3531s(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        throw new UnhandledWebServiceOperation(operationParams);
    }

    protected final OperationResult m3533u(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        throw new UnhandledWebServiceOperation(operationParams);
    }

    protected final OperationResult m3503I(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        throw new UnhandledWebServiceOperation(operationParams);
    }

    protected final OperationResult m3530r(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        throw new UnhandledWebServiceOperation(operationParams);
    }

    protected final OperationResult m3497C(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        throw new UnhandledWebServiceOperation(operationParams);
    }

    protected final OperationResult m3505K(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        throw new UnhandledWebServiceOperation(operationParams);
    }

    protected final OperationResult m3511Q(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        throw new UnhandledWebServiceOperation(operationParams);
    }

    protected final OperationResult m3512R(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        throw new UnhandledWebServiceOperation(operationParams);
    }
}
