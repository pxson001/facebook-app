package com.facebook.orca.server.module;

import android.os.Bundle;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationParamsUtil;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.folders.ThreadTypeFilter;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.facebook.messaging.service.base.AbstractBlueServiceHandlerFilter;
import com.facebook.messaging.service.base.OperationMultipleFailureException;
import com.facebook.messaging.service.base.OperationResultMerger;
import com.facebook.messaging.service.base.OperationResultMerger.StrictSuccessMerger;
import com.facebook.messaging.service.base.OperationResultMerger.SubOperationBatch;
import com.facebook.messaging.service.base.OperationResultMerger.SubOperationMerger;
import com.facebook.messaging.service.model.CreateGroupParams;
import com.facebook.messaging.service.model.DeleteMessagesParams;
import com.facebook.messaging.service.model.DeleteThreadsParams;
import com.facebook.messaging.service.model.FetchMoreMessagesParams;
import com.facebook.messaging.service.model.FetchMoreThreadsParams;
import com.facebook.messaging.service.model.FetchMoreThreadsResult;
import com.facebook.messaging.service.model.FetchThreadKeyByParticipantsParams;
import com.facebook.messaging.service.model.FetchThreadListParams;
import com.facebook.messaging.service.model.FetchThreadListResult;
import com.facebook.messaging.service.model.FetchThreadListResultBuilder;
import com.facebook.messaging.service.model.FetchThreadParams;
import com.facebook.messaging.service.model.MarkThreadFields;
import com.facebook.messaging.service.model.MarkThreadsParams;
import com.facebook.messaging.service.model.MarkThreadsParams.MarkThreadsParamsBuilder;
import com.facebook.messaging.service.model.ModifyThreadParams;
import com.facebook.messaging.service.model.SaveDraftParams;
import com.facebook.messaging.service.model.SendMessageByRecipientsParams;
import com.facebook.messaging.sms.abtest.AnonymousSmsThreadStateHelper;
import com.facebook.messaging.sms.abtest.SmsIntegrationState;
import com.facebook.messaging.sms.defaultapp.SmsPermissionsUtil;
import com.facebook.messaging.threads.util.SmsMessengerThreadListMergeUtil;
import com.facebook.messaging.tincan.gatekeepers.TincanGatekeepers;
import com.facebook.user.model.User;
import com.facebook.user.model.UserIdentifier;
import com.facebook.user.model.UserKey;
import com.facebook.user.model.UserSmsIdentifier;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: nearby_places_city_typeahead_did_receive_results */
public class MultiCacheServiceHandler extends AbstractBlueServiceHandlerFilter {
    private static final SubOperationMerger<CacheType> f6381a = new StrictSuccessMerger();
    private final BlueServiceHandler f6382b;
    private final BlueServiceHandler f6383c;
    private final BlueServiceHandler f6384d;
    public final SmsIntegrationState f6385e;
    private final TincanGatekeepers f6386f;
    public final SmsPermissionsUtil f6387g;
    public final AnonymousSmsThreadStateHelper f6388h;

    /* compiled from: nearby_places_city_typeahead_did_receive_results */
    /* synthetic */ class C09583 {
        static final /* synthetic */ int[] f6380b = new int[Type.values().length];

        static {
            try {
                f6380b[Type.ONE_TO_ONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6380b[Type.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6380b[Type.PENDING_THREAD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6380b[Type.MONTAGE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6380b[Type.MY_MONTAGE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f6380b[Type.SMS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f6380b[Type.TINCAN.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            f6379a = new int[CacheType.values().length];
            try {
                f6379a[CacheType.FACEBOOK.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f6379a[CacheType.SMS.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f6379a[CacheType.TINCAN.ordinal()] = 3;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* compiled from: nearby_places_city_typeahead_did_receive_results */
    enum CacheType {
        FACEBOOK,
        SMS,
        TINCAN
    }

    public static MultiCacheServiceHandler m6043b(InjectorLike injectorLike) {
        return new MultiCacheServiceHandler(BlueServiceHandler_FacebookCachingServiceChainMethodAutoProvider.m6018a(injectorLike), BlueServiceHandler_SmsCachingServiceChainMethodAutoProvider.m6026a(injectorLike), BlueServiceHandler_TincanCachingServiceChainMethodAutoProvider.m6028a(injectorLike), SmsIntegrationState.a(injectorLike), TincanGatekeepers.b(injectorLike), SmsPermissionsUtil.a(injectorLike), AnonymousSmsThreadStateHelper.a(injectorLike));
    }

    @Inject
    public MultiCacheServiceHandler(BlueServiceHandler blueServiceHandler, BlueServiceHandler blueServiceHandler2, BlueServiceHandler blueServiceHandler3, SmsIntegrationState smsIntegrationState, TincanGatekeepers tincanGatekeepers, SmsPermissionsUtil smsPermissionsUtil, AnonymousSmsThreadStateHelper anonymousSmsThreadStateHelper) {
        super("MultiCacheServiceHandler");
        this.f6382b = blueServiceHandler;
        this.f6383c = blueServiceHandler2;
        this.f6384d = blueServiceHandler3;
        this.f6385e = smsIntegrationState;
        this.f6386f = tincanGatekeepers;
        this.f6387g = smsPermissionsUtil;
        this.f6388h = anonymousSmsThreadStateHelper;
    }

    protected final OperationResult m6055K(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6056L(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6057M(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6054J(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6053I(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6383c.a(operationParams);
    }

    protected final OperationResult m6052H(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6051G(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6050F(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6049E(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6048D(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6047C(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6046B(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6045A(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6087z(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6086y(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6085x(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6084w(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6083v(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6082u(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6081t(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6080s(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6079r(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return m6038a(((SaveDraftParams) OperationParamsUtil.a(operationParams, "saveDraftParams")).a).a(operationParams);
    }

    protected final OperationResult m6078q(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6077p(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return m6038a(((ModifyThreadParams) OperationParamsUtil.a(operationParams, "modifyThreadParams")).a).a(operationParams);
    }

    protected final OperationResult m6076o(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        ThreadKey threadKey = ((DeleteMessagesParams) OperationParamsUtil.a(operationParams, "deleteMessagesParams")).a;
        return (threadKey == null ? this.f6382b : m6038a(threadKey)).a(operationParams);
    }

    protected final OperationResult m6074m(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        HashMap a = m6041a((Iterable) ((DeleteThreadsParams) OperationParamsUtil.a(operationParams, "deleteThreadsParams")).a);
        SubOperationBatch subOperationBatch = new SubOperationBatch();
        for (Entry entry : a.entrySet()) {
            CacheType cacheType = (CacheType) entry.getKey();
            Bundle bundle = new Bundle();
            bundle.putParcelable("deleteThreadsParams", new DeleteThreadsParams((List) entry.getValue()));
            subOperationBatch.a(cacheType, m6039a(cacheType), new OperationParams("delete_threads", bundle));
        }
        return OperationResultMerger.a(subOperationBatch, f6381a);
    }

    protected final OperationResult m6075n(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6384d.a(operationParams);
    }

    protected final OperationResult m6073l(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        if (this.f6386f.a()) {
            return OperationResultMerger.a(new SubOperationBatch().a(CacheType.FACEBOOK, this.f6382b, operationParams).a(CacheType.TINCAN, this.f6384d, operationParams), f6381a);
        }
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6072k(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        MarkThreadsParams markThreadsParams = (MarkThreadsParams) OperationParamsUtil.a(operationParams, "markThreadsParams");
        HashMap a = m6041a(markThreadsParams.d);
        SubOperationBatch subOperationBatch = new SubOperationBatch();
        for (Entry entry : a.entrySet()) {
            MarkThreadsParamsBuilder markThreadsParamsBuilder = new MarkThreadsParamsBuilder();
            markThreadsParamsBuilder.a = markThreadsParams.a;
            markThreadsParamsBuilder = markThreadsParamsBuilder;
            markThreadsParamsBuilder.b = markThreadsParams.b;
            MarkThreadsParamsBuilder markThreadsParamsBuilder2 = markThreadsParamsBuilder;
            ImmutableList immutableList = markThreadsParams.c;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                MarkThreadFields markThreadFields = (MarkThreadFields) immutableList.get(i);
                if (((ArrayList) entry.getValue()).contains(markThreadFields.a)) {
                    markThreadsParamsBuilder2.a(markThreadFields);
                }
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("markThreadsParams", markThreadsParamsBuilder2.a());
            CacheType cacheType = (CacheType) entry.getKey();
            subOperationBatch.a(cacheType, m6039a(cacheType), new OperationParams("mark_threads", bundle));
        }
        return OperationResultMerger.a(subOperationBatch, f6381a);
    }

    protected final OperationResult m6071j(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6070i(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return m6038a(((FetchMoreMessagesParams) OperationParamsUtil.a(operationParams, "fetchMoreMessagesParams")).a).a(operationParams);
    }

    protected final OperationResult m6069h(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        Object obj;
        ImmutableList immutableList = ((SendMessageByRecipientsParams) OperationParamsUtil.a(operationParams, "createThreadParams")).c;
        if (immutableList == null || immutableList.isEmpty()) {
            obj = null;
        } else {
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                if (!(((UserIdentifier) immutableList.get(i)) instanceof UserSmsIdentifier)) {
                    obj = null;
                    break;
                }
            }
            obj = 1;
        }
        if (obj != null) {
            return this.f6383c.a(operationParams);
        }
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6068g(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        if (((CreateGroupParams) OperationParamsUtil.a(operationParams, "createGroupParams")).e) {
            return this.f6383c.a(operationParams);
        }
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6067f(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6066e(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        FetchThreadKeyByParticipantsParams fetchThreadKeyByParticipantsParams = (FetchThreadKeyByParticipantsParams) OperationParamsUtil.a(operationParams, "fetch_thread_with_participants_key");
        UserKey userKey = fetchThreadKeyByParticipantsParams.a;
        Iterator it = fetchThreadKeyByParticipantsParams.b.iterator();
        while (it.hasNext()) {
            UserKey userKey2 = (UserKey) it.next();
            if (!userKey2.equals(userKey) && !userKey2.e()) {
                return this.f6382b.a(operationParams);
            }
        }
        return this.f6383c.a(operationParams);
    }

    protected final OperationResult m6065d(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        FetchThreadParams fetchThreadParams = (FetchThreadParams) OperationParamsUtil.a(operationParams, "fetchThreadParams");
        if (fetchThreadParams.a.a != null) {
            return this.f6382b.a(operationParams);
        }
        return m6038a((ThreadKey) Preconditions.checkNotNull(fetchThreadParams.a.a())).a(operationParams);
    }

    protected final OperationResult m6064c(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        FetchMoreThreadsParams fetchMoreThreadsParams = (FetchMoreThreadsParams) OperationParamsUtil.a(operationParams, "fetchMoreThreadsParams");
        final FolderName folderName = fetchMoreThreadsParams.a;
        return OperationResultMerger.a(m6040a(fetchMoreThreadsParams.a, fetchMoreThreadsParams.b, operationParams), new SubOperationMerger<CacheType>(this) {
            final /* synthetic */ MultiCacheServiceHandler f6376b;

            public final OperationResult m6036a(Map<CacheType, OperationResult> map, ImmutableSet<Exception> immutableSet) {
                if (map.isEmpty()) {
                    throw new OperationMultipleFailureException(immutableSet);
                }
                Collection arrayList = new ArrayList(map.size());
                List arrayList2 = new ArrayList(map.size());
                HashMap hashMap = new HashMap();
                long j = Long.MIN_VALUE;
                for (OperationResult h : map.values()) {
                    FetchMoreThreadsResult fetchMoreThreadsResult = (FetchMoreThreadsResult) h.h();
                    arrayList.add(fetchMoreThreadsResult.c);
                    arrayList2.add(fetchMoreThreadsResult.a);
                    MultiCacheServiceHandler.m6044b(hashMap, fetchMoreThreadsResult.d);
                    j = Math.max(j, fetchMoreThreadsResult.e);
                }
                if (!map.containsKey(CacheType.FACEBOOK)) {
                    arrayList.add(new ThreadsCollection(RegularImmutableList.a, false));
                }
                return OperationResult.a(new FetchMoreThreadsResult(DataFetchDisposition.a(arrayList2), folderName, SmsMessengerThreadListMergeUtil.a(arrayList), ImmutableList.copyOf(hashMap.values()), j));
            }
        });
    }

    protected final OperationResult m6063b(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        FetchThreadListParams fetchThreadListParams = (FetchThreadListParams) OperationParamsUtil.a(operationParams, "fetchThreadListParams");
        final FolderName folderName = fetchThreadListParams.b;
        return OperationResultMerger.a(m6040a(fetchThreadListParams.b, fetchThreadListParams.c, operationParams), new SubOperationMerger<CacheType>(this) {
            final /* synthetic */ MultiCacheServiceHandler f6378b;

            public final OperationResult m6037a(Map<CacheType, OperationResult> map, ImmutableSet<Exception> immutableSet) {
                if (map.isEmpty()) {
                    throw new OperationMultipleFailureException(immutableSet);
                }
                Collection arrayList = new ArrayList(map.size());
                List arrayList2 = new ArrayList(map.size());
                HashMap hashMap = new HashMap();
                long j = Long.MIN_VALUE;
                for (OperationResult h : map.values()) {
                    FetchThreadListResult fetchThreadListResult = (FetchThreadListResult) h.h();
                    arrayList.add(fetchThreadListResult.c);
                    arrayList2.add(fetchThreadListResult.a);
                    MultiCacheServiceHandler.m6044b(hashMap, fetchThreadListResult.d);
                    j = Math.max(j, fetchThreadListResult.l);
                }
                if (!map.containsKey(CacheType.FACEBOOK)) {
                    arrayList.add(new ThreadsCollection(RegularImmutableList.a, false));
                }
                FetchThreadListResultBuilder newBuilder = FetchThreadListResult.newBuilder();
                newBuilder.a = DataFetchDisposition.a(arrayList2);
                newBuilder = newBuilder;
                newBuilder.b = folderName;
                newBuilder = newBuilder;
                newBuilder.c = SmsMessengerThreadListMergeUtil.a(arrayList);
                newBuilder = newBuilder;
                newBuilder.d = ImmutableList.copyOf(hashMap.values());
                newBuilder = newBuilder;
                newBuilder.j = j;
                return OperationResult.a(newBuilder.m());
            }
        });
    }

    protected final OperationResult m6058N(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6059O(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6060P(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6061Q(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6382b.a(operationParams);
    }

    protected final OperationResult m6062R(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return this.f6384d.a(operationParams);
    }

    private BlueServiceHandler m6038a(ThreadKey threadKey) {
        return m6039a(m6042b(threadKey));
    }

    private BlueServiceHandler m6039a(CacheType cacheType) {
        switch (cacheType) {
            case FACEBOOK:
                return this.f6382b;
            case SMS:
                return this.f6383c;
            case TINCAN:
                return this.f6384d;
            default:
                throw new RuntimeException("Unexpected CacheType: " + cacheType);
        }
    }

    public static void m6044b(HashMap<UserKey, User> hashMap, ImmutableList<User> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            User user = (User) immutableList.get(i);
            User user2 = (User) hashMap.get(user.T);
            if (user2 == null || user.L > user2.L) {
                hashMap.put(user.T, user);
            }
        }
    }

    private static HashMap<CacheType, ArrayList<ThreadKey>> m6041a(Iterable<ThreadKey> iterable) {
        HashMap<CacheType, ArrayList<ThreadKey>> hashMap = new HashMap();
        for (ThreadKey threadKey : iterable) {
            CacheType b = m6042b(threadKey);
            ArrayList arrayList = (ArrayList) hashMap.get(b);
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(b, arrayList);
            }
            arrayList.add(threadKey);
        }
        return hashMap;
    }

    private static CacheType m6042b(ThreadKey threadKey) {
        switch (C09583.f6380b[threadKey.a.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return CacheType.FACEBOOK;
            case 6:
                return CacheType.SMS;
            case 7:
                return CacheType.TINCAN;
            default:
                throw new RuntimeException("Unexpected thread key type: " + threadKey.a);
        }
    }

    private SubOperationBatch<CacheType> m6040a(FolderName folderName, ThreadTypeFilter threadTypeFilter, OperationParams operationParams) {
        SubOperationBatch<CacheType> subOperationBatch = new SubOperationBatch();
        if (threadTypeFilter != ThreadTypeFilter.SMS) {
            subOperationBatch.a(CacheType.FACEBOOK, this.f6382b, operationParams);
        }
        if (folderName == FolderName.INBOX) {
            if (threadTypeFilter != ThreadTypeFilter.NON_SMS) {
                Object obj;
                if (this.f6388h.a() || (this.f6385e.a() && this.f6387g.b())) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    subOperationBatch.a(CacheType.SMS, this.f6383c, operationParams);
                }
            }
            if (threadTypeFilter != ThreadTypeFilter.SMS && this.f6386f.a()) {
                subOperationBatch.a(CacheType.TINCAN, this.f6384d, operationParams);
            }
        }
        return subOperationBatch;
    }
}
