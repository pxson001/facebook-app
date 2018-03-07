package com.facebook.growth.service;

import android.content.Context;
import com.facebook.api.growth.UserSetContactInfoMethod;
import com.facebook.api.growth.UserSetContactInfoMethod.Params;
import com.facebook.api.growth.contactimporter.PhonebookLookupResultContact;
import com.facebook.api.growth.contactimporter.UsersInviteMethod;
import com.facebook.api.growth.contactimporter.UsersInviteParams;
import com.facebook.api.growth.profile.SetNativeNameMethod;
import com.facebook.api.growth.profile.SetNativeNameParams;
import com.facebook.api.growth.profile.SetProfilePhotoMethod;
import com.facebook.api.growth.profile.SetProfilePhotoParams;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.contacts.ccu.ContactsUploadClient;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.friends.cache.FriendshipStatusCache;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.ContactUploadSessionCreateAndMaybeBatchUploadInputData;
import com.facebook.graphql.calls.ContinuousContactUploadSettingUpdateInputData.Source;
import com.facebook.graphql.calls.ContinuousContactUploadSettingUpdateInputData.Status;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.growth.protocol.FriendFinderMethod;
import com.facebook.growth.protocol.FriendFinderMethod.Result;
import com.facebook.growth.protocol.FriendFinderPYMKMethod;
import com.facebook.growth.protocol.SetContinuousContactsUploadMethod;
import com.facebook.growth.protocol.SetContinuousContactsUploadMethod.Setting;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: p2p_pin_status_update_fail */
public class GrowthServiceHandler implements BlueServiceHandler {
    private static GrowthServiceHandler f7524l;
    private static final Object f7525m = new Object();
    private final Provider<ContactsUploadClient> f7526a;
    public final FriendshipStatusCache f7527b;
    private final Lazy<GatekeeperStore> f7528c;
    public final Provider<SingleMethodRunner> f7529d;
    public final Lazy<SetProfilePhotoMethod> f7530e;
    public final Lazy<SetNativeNameMethod> f7531f;
    public final Lazy<UsersInviteMethod> f7532g;
    public final Lazy<UserSetContactInfoMethod> f7533h;
    public final Lazy<FriendFinderMethod> f7534i;
    private final Lazy<FriendFinderPYMKMethod> f7535j;
    private final Lazy<SetContinuousContactsUploadMethod> f7536k;

    private static GrowthServiceHandler m7825b(InjectorLike injectorLike) {
        return new GrowthServiceHandler(IdBasedProvider.a(injectorLike, 901), FriendshipStatusCache.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2128), IdBasedSingletonScopeProvider.a(injectorLike, 2289), IdBasedSingletonScopeProvider.b(injectorLike, 4815), IdBasedLazy.a(injectorLike, 4814), IdBasedLazy.a(injectorLike, 4813), IdBasedLazy.a(injectorLike, 4812), IdBasedLazy.a(injectorLike, 7145), IdBasedLazy.a(injectorLike, 7146), IdBasedLazy.a(injectorLike, 7147));
    }

    public final OperationResult m7828a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("growth_set_profile_photo".equals(str)) {
            ((AbstractSingleMethodRunner) this.f7529d.get()).a((ApiMethod) this.f7530e.get(), (SetProfilePhotoParams) operationParams.c.getParcelable("growthSetProfilePhotoParams"));
            return OperationResult.a;
        } else if ("growth_set_native_name".equals(str)) {
            return OperationResult.a((String) ((AbstractSingleMethodRunner) this.f7529d.get()).a((ApiMethod) this.f7531f.get(), (SetNativeNameParams) operationParams.c.getParcelable("growthSetNativeNameParams")));
        } else if ("growth_users_invite".equals(str)) {
            return OperationResult.a((ArrayList) ((AbstractSingleMethodRunner) this.f7529d.get()).a((ApiMethod) this.f7532g.get(), (UsersInviteParams) operationParams.c.getParcelable("growthUsersInviteParamsKey")));
        } else if ("growth_user_set_contact_info".equals(str)) {
            ((AbstractSingleMethodRunner) this.f7529d.get()).a((ApiMethod) this.f7533h.get(), (Params) operationParams.c.getParcelable("growthUserSetContactInfoParamsKey"));
            return OperationResult.a;
        } else if ("growth_friend_finder".equals(str)) {
            Result result = (Result) ((AbstractSingleMethodRunner) this.f7529d.get()).a((ApiMethod) this.f7534i.get(), (FriendFinderMethod.Params) operationParams.c.getParcelable("growthFriendFinderParamsKey"));
            List<PhonebookLookupResultContact> a = result != null ? result.m7808a() : null;
            if (!(a == null || a.isEmpty())) {
                for (PhonebookLookupResultContact phonebookLookupResultContact : a) {
                    this.f7527b.a(phonebookLookupResultContact.userId, GraphQLFriendshipStatus.CAN_REQUEST);
                }
            }
            return OperationResult.a(result);
        } else if ("growth_friend_finder_pymk".equals(str)) {
            return m7826g(operationParams);
        } else {
            if ("growth_set_continuous_contacts_upload".equals(str)) {
                return m7827h(operationParams);
            }
            throw new Exception("Unknown type");
        }
    }

    private OperationResult m7826g(OperationParams operationParams) {
        FriendFinderPYMKMethod.Result result = (FriendFinderPYMKMethod.Result) ((AbstractSingleMethodRunner) this.f7529d.get()).a((ApiMethod) this.f7535j.get(), (FriendFinderPYMKMethod.Params) operationParams.c.getParcelable("growthFriendFinderPYMKParamsKey"));
        List<PhonebookLookupResultContact> a = result != null ? result.m7817a() : null;
        if (!(a == null || a.isEmpty())) {
            for (PhonebookLookupResultContact phonebookLookupResultContact : a) {
                this.f7527b.a(phonebookLookupResultContact.userId, GraphQLFriendshipStatus.CAN_REQUEST);
            }
        }
        return OperationResult.a(result);
    }

    public static GrowthServiceHandler m7824a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GrowthServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7525m) {
                GrowthServiceHandler growthServiceHandler;
                if (a2 != null) {
                    growthServiceHandler = (GrowthServiceHandler) a2.a(f7525m);
                } else {
                    growthServiceHandler = f7524l;
                }
                if (growthServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7825b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7525m, b3);
                        } else {
                            f7524l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = growthServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public GrowthServiceHandler(Provider<ContactsUploadClient> provider, FriendshipStatusCache friendshipStatusCache, Lazy<GatekeeperStore> lazy, Provider<SingleMethodRunner> provider2, Lazy<SetProfilePhotoMethod> lazy2, Lazy<SetNativeNameMethod> lazy3, Lazy<UsersInviteMethod> lazy4, Lazy<UserSetContactInfoMethod> lazy5, Lazy<FriendFinderMethod> lazy6, Lazy<FriendFinderPYMKMethod> lazy7, Lazy<SetContinuousContactsUploadMethod> lazy8) {
        this.f7526a = provider;
        this.f7527b = friendshipStatusCache;
        this.f7528c = lazy;
        this.f7529d = provider2;
        this.f7530e = lazy2;
        this.f7531f = lazy3;
        this.f7532g = lazy4;
        this.f7533h = lazy5;
        this.f7534i = lazy6;
        this.f7535j = lazy7;
        this.f7536k = lazy8;
    }

    private OperationResult m7827h(OperationParams operationParams) {
        Setting setting = (Setting) operationParams.c.getSerializable("growthSetContinuousContactsUploadParamsKey");
        if (((GatekeeperStoreImpl) this.f7528c.get()).a(386, false)) {
            ((ContactsUploadClient) this.f7526a.get()).a(Status.valueOf(setting.toString()), setting == Setting.ON ? Source.CI : Source.USER_SETTING);
            if (setting == Setting.ON && ((GatekeeperStoreImpl) this.f7528c.get()).a(387, false)) {
                ((ContactsUploadClient) this.f7526a.get()).a(ContactUploadSessionCreateAndMaybeBatchUploadInputData.Source.FB_NUX_CI, true, 0);
            }
        } else {
            ((AbstractSingleMethodRunner) this.f7529d.get()).a((ApiMethod) this.f7536k.get(), setting, operationParams.e);
        }
        return OperationResult.a;
    }
}
