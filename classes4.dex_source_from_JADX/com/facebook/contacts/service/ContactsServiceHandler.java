package com.facebook.contacts.service;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.contacts.cache.ContactsCache;
import com.facebook.contacts.cache.FavoriteContactsCache;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactBuilder;
import com.facebook.contacts.graphql.ContactUserKey;
import com.facebook.contacts.handlers.AddContactHandler;
import com.facebook.contacts.handlers.DbFavoriteContactsHandler;
import com.facebook.contacts.handlers.DbInsertContactHandler;
import com.facebook.contacts.handlers.DbInsertContactHandler.InsertionType;
import com.facebook.contacts.handlers.DeleteContactHandler;
import com.facebook.contacts.handlers.FetchMultipleContactsHandler;
import com.facebook.contacts.handlers.UpdateContactIsMessengerUserHandler;
import com.facebook.contacts.handlers.UpdateContactIsMessengerUserHandler.1;
import com.facebook.contacts.omnistore.OmnistoreInsertContactHandler;
import com.facebook.contacts.properties.ContactsDbStateChecker;
import com.facebook.contacts.properties.ContactsStorageMode;
import com.facebook.contacts.properties.DbContactsProperties;
import com.facebook.contacts.properties.DbContactsPropertyUtil;
import com.facebook.contacts.protocol.methods.FetchMessagingFavoritesMethod;
import com.facebook.contacts.protocol.methods.FetchPaymentEligibleContactsMethod;
import com.facebook.contacts.protocol.methods.FetchTopContactsByCFPHatMethod;
import com.facebook.contacts.protocol.methods.UpdateMessagingFavoritesMethod;
import com.facebook.contacts.protocol.push.ContactPushabilityBroadcaster;
import com.facebook.contacts.protocol.push.ContactsMessengerUserMap;
import com.facebook.contacts.server.AddContactParams;
import com.facebook.contacts.server.DeleteContactParams;
import com.facebook.contacts.server.FetchContactsResult;
import com.facebook.contacts.server.FetchMessagingFavoritesResult;
import com.facebook.contacts.server.FetchMultipleContactsByFbidParams;
import com.facebook.contacts.server.FetchPaymentEligibleContactsParams;
import com.facebook.contacts.server.UpdateContactIsMessengerUserParams;
import com.facebook.contacts.server.UpdateFavoriteContactsParams;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: rtc_message */
public class ContactsServiceHandler implements BlueServiceHandler {
    private static final Class<?> f3236a;
    public static final CallerContext f3237b;
    private static final Object f3238w = new Object();
    public final ContactsCache f3239c;
    public final FavoriteContactsCache f3240d;
    private final FetchMessagingFavoritesMethod f3241e;
    public final UpdateMessagingFavoritesMethod f3242f;
    private final FetchPaymentEligibleContactsMethod f3243g;
    private final FetchTopContactsByCFPHatMethod f3244h;
    private final DbContactsPropertyUtil f3245i;
    public final DbInsertContactHandler f3246j;
    public final DbFavoriteContactsHandler f3247k;
    private final Lazy<OmnistoreInsertContactHandler> f3248l;
    public final AbstractSingleMethodRunner f3249m;
    private final BaseFbBroadcastManager f3250n;
    private final Clock f3251o;
    private final ContactsWebFetcher f3252p;
    private final ContactsDbStateChecker f3253q;
    public final FetchMultipleContactsHandler f3254r;
    private final DeleteContactHandler f3255s;
    public final AddContactHandler f3256t;
    private final UpdateContactIsMessengerUserHandler f3257u;
    private final Provider<Boolean> f3258v;

    private static ContactsServiceHandler m3447b(InjectorLike injectorLike) {
        return new ContactsServiceHandler(ContactsCache.m3455a(injectorLike), FavoriteContactsCache.m14024a(injectorLike), FetchMessagingFavoritesMethod.m3461a(injectorLike), UpdateMessagingFavoritesMethod.m3465a(injectorLike), FetchPaymentEligibleContactsMethod.m3471a(injectorLike), FetchTopContactsByCFPHatMethod.m3499a(injectorLike), DbContactsPropertyUtil.m8547a(injectorLike), DbInsertContactHandler.m3505a(injectorLike), DbFavoriteContactsHandler.m3572a(injectorLike), IdBasedLazy.a(injectorLike, 5357), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), ContactsWebFetcher.m3577a(injectorLike), ContactsDbStateChecker.m8582a(injectorLike), FetchMultipleContactsHandler.m3609a(injectorLike), DeleteContactHandler.m3619a(injectorLike), AddContactHandler.m3623a(injectorLike), UpdateContactIsMessengerUserHandler.m3637a(injectorLike), IdBasedProvider.a(injectorLike, 3945));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.contacts.service.ContactsServiceHandler m3445a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f3238w;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m3447b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f3238w;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.contacts.service.ContactsServiceHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.contacts.service.ContactsServiceHandler) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f3238w;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.contacts.service.ContactsServiceHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.service.ContactsServiceHandler.a(com.facebook.inject.InjectorLike):com.facebook.contacts.service.ContactsServiceHandler");
    }

    public final OperationResult m3452a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("fetch_contacts".equals(str)) {
            return OperationResult.a(this.f3254r.m3615a((FetchMultipleContactsByFbidParams) ((Bundle) Preconditions.checkNotNull(operationParams.c)).getParcelable("fetchMultipleContactsParams")));
        } else if ("sync_contacts_partial".equals(str)) {
            this.f3252p.m3587a();
            return OperationResult.a;
        } else if ("delete_contact".equals(str)) {
            m3448c(operationParams);
            return OperationResult.a;
        } else if ("sync_favorite_contacts".equals(str)) {
            m3446a();
            return OperationResult.a;
        } else if ("update_favorite_contacts".equals(str)) {
            Collection<User> collection = ((UpdateFavoriteContactsParams) operationParams.c.getParcelable("favorites")).a;
            Builder builder = ImmutableList.builder();
            for (User user : collection) {
                if (!user.b()) {
                    builder.c(user);
                }
            }
            this.f3249m.a(this.f3242f, new UpdateFavoriteContactsParams(builder.b()), f3237b);
            this.f3247k.m3576a((Collection) collection, false);
            this.f3240d.m14027a();
            return OperationResult.a;
        } else if ("add_contact_by_phone_number".equals(str)) {
            return OperationResult.a(this.f3256t.m3625a((AddContactParams) operationParams.c.getParcelable("addContactParams")));
        } else {
            if ("update_contact_is_messenger_user".equals(str)) {
                m3450g(operationParams);
                return OperationResult.a;
            } else if ("mark_full_contact_sync_required".equals(str)) {
                ContactsDbStateChecker contactsDbStateChecker = this.f3253q;
                contactsDbStateChecker.f8309b.m8557b(DbContactsProperties.f13091b, -1);
                contactsDbStateChecker.f8309b.m8557b(DbContactsProperties.f13090a, -1);
                return OperationResult.a;
            } else if ("reindex_contacts_names".equals(str)) {
                this.f3246j.m3513a();
                this.f3239c.m3458a();
                return OperationResult.a;
            } else if ("update_contacts_coefficient".equals(str)) {
                this.f3252p.m3588b();
                return OperationResult.a;
            } else if ("fetch_payment_eligible_contacts".equals(str)) {
                return m3449e(operationParams);
            } else {
                if ("fetch_top_contacts_by_cfphat_coefficient".equals(str)) {
                    return m3451h(operationParams);
                }
                if ("reindex_omnistore_contacts".equals(str)) {
                    ((OmnistoreInsertContactHandler) this.f3248l.get()).a.a().reindexAllObjects();
                    return OperationResult.a;
                }
                throw new IllegalArgumentException("Unknown operation type: " + str);
            }
        }
    }

    static {
        Class cls = ContactsServiceHandler.class;
        f3236a = cls;
        f3237b = CallerContext.a(cls);
    }

    private OperationResult m3449e(OperationParams operationParams) {
        return OperationResult.a(this.f3249m.a(this.f3243g, (FetchPaymentEligibleContactsParams) operationParams.c.getParcelable("fetchPaymentEligibleContactsParams"), f3237b));
    }

    private void m3450g(OperationParams operationParams) {
        boolean z;
        UpdateContactIsMessengerUserParams updateContactIsMessengerUserParams = (UpdateContactIsMessengerUserParams) operationParams.c.getParcelable("updateIsMessengerUserParams");
        UpdateContactIsMessengerUserHandler updateContactIsMessengerUserHandler = this.f3257u;
        updateContactIsMessengerUserParams.toString();
        FetchContactsResult a = updateContactIsMessengerUserHandler.f3418d.m3615a(new FetchMultipleContactsByFbidParams(ImmutableSet.of(UserKey.b(updateContactIsMessengerUserParams.a)), DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE));
        if (a.a.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "Tried to update isMessengerUser on user with unavailable Contact data");
        Contact contact = (Contact) a.a.get(0);
        if (contact.m4084s() != updateContactIsMessengerUserParams.b && a.freshness != DataFreshnessResult.FROM_SERVER) {
            ContactBuilder contactBuilder = new ContactBuilder(contact);
            contactBuilder.f3661w = updateContactIsMessengerUserParams.b;
            Contact P = contactBuilder.m4092P();
            switch (1.a[((ContactsStorageMode) updateContactIsMessengerUserHandler.f3419e.get()).ordinal()]) {
                case 1:
                    ((DbInsertContactHandler) updateContactIsMessengerUserHandler.f3420f.get()).m3512a(P, DataFreshnessResult.FROM_CACHE_STALE);
                    break;
                case 2:
                    ((OmnistoreInsertContactHandler) updateContactIsMessengerUserHandler.f3421g.get()).a(P);
                    break;
            }
            updateContactIsMessengerUserHandler.f3417c.m3459a(P);
            ContactPushabilityBroadcaster contactPushabilityBroadcaster = updateContactIsMessengerUserHandler.f3416b;
            ContactsMessengerUserMap contactsMessengerUserMap = new ContactsMessengerUserMap(Lists.a(new Contact[]{P}));
            Intent intent = new Intent("com.facebook.presence.ACTION_PUSH_STATE_RECEIVED");
            intent.putExtra("extra_on_messenger_map", contactsMessengerUserMap);
            contactPushabilityBroadcaster.f3423a.a(intent);
            contact.m4067b();
            Boolean.valueOf(contact.m4084s());
        }
    }

    private OperationResult m3451h(OperationParams operationParams) {
        FetchContactsResult fetchContactsResult = (FetchContactsResult) this.f3249m.a(this.f3244h, Integer.valueOf(operationParams.c.getInt("fetchTopContactsByCfphatParams")), f3237b);
        this.f3246j.m3515a((ImmutableCollection) fetchContactsResult.a, InsertionType.INSERT, fetchContactsResult.freshness);
        return OperationResult.a(fetchContactsResult);
    }

    @Inject
    public ContactsServiceHandler(ContactsCache contactsCache, FavoriteContactsCache favoriteContactsCache, FetchMessagingFavoritesMethod fetchMessagingFavoritesMethod, UpdateMessagingFavoritesMethod updateMessagingFavoritesMethod, FetchPaymentEligibleContactsMethod fetchPaymentEligibleContactsMethod, FetchTopContactsByCFPHatMethod fetchTopContactsByCFPHatMethod, DbContactsPropertyUtil dbContactsPropertyUtil, DbInsertContactHandler dbInsertContactHandler, DbFavoriteContactsHandler dbFavoriteContactsHandler, Lazy<OmnistoreInsertContactHandler> lazy, SingleMethodRunner singleMethodRunner, FbBroadcastManager fbBroadcastManager, Clock clock, ContactsWebFetcher contactsWebFetcher, ContactsDbStateChecker contactsDbStateChecker, FetchMultipleContactsHandler fetchMultipleContactsHandler, DeleteContactHandler deleteContactHandler, AddContactHandler addContactHandler, UpdateContactIsMessengerUserHandler updateContactIsMessengerUserHandler, Provider<Boolean> provider) {
        this.f3239c = contactsCache;
        this.f3240d = favoriteContactsCache;
        this.f3241e = fetchMessagingFavoritesMethod;
        this.f3242f = updateMessagingFavoritesMethod;
        this.f3243g = fetchPaymentEligibleContactsMethod;
        this.f3244h = fetchTopContactsByCFPHatMethod;
        this.f3245i = dbContactsPropertyUtil;
        this.f3246j = dbInsertContactHandler;
        this.f3247k = dbFavoriteContactsHandler;
        this.f3248l = lazy;
        this.f3249m = singleMethodRunner;
        this.f3250n = fbBroadcastManager;
        this.f3251o = clock;
        this.f3252p = contactsWebFetcher;
        this.f3253q = contactsDbStateChecker;
        this.f3254r = fetchMultipleContactsHandler;
        this.f3255s = deleteContactHandler;
        this.f3256t = addContactHandler;
        this.f3257u = updateContactIsMessengerUserHandler;
        this.f3258v = provider;
    }

    private void m3448c(OperationParams operationParams) {
        DeleteContactHandler deleteContactHandler = this.f3255s;
        DeleteContactParams deleteContactParams = (DeleteContactParams) operationParams.c.getParcelable("deleteContactParams");
        deleteContactHandler.f3391a.m3460a(ContactUserKey.a(deleteContactParams.a));
        String b = deleteContactParams.a.m4067b();
        switch (DeleteContactHandler.1.a[((ContactsStorageMode) deleteContactHandler.f3395e.get()).ordinal()]) {
            case 1:
                ((DbInsertContactHandler) deleteContactHandler.f3396f.get()).m3514a(ImmutableList.of(b));
                break;
            case 2:
                ((OmnistoreInsertContactHandler) deleteContactHandler.f3397g.get()).a.a().deleteObject(b);
                break;
        }
        deleteContactHandler.f3392b.a(new Intent("com.facebook.contacts.ACTION_CONTACT_DELETED"));
        deleteContactHandler.f3393c.a(deleteContactHandler.f3394d, deleteContactParams);
    }

    private void m3446a() {
        long a = this.f3245i.m8550a(DbContactsProperties.f13095f, -1);
        long j = ((Boolean) this.f3258v.get()).booleanValue() ? 86400000 : 10800000;
        if (a == -1 || this.f3251o.a() - a >= j) {
            this.f3247k.m3576a((Collection) ((FetchMessagingFavoritesResult) this.f3249m.a(this.f3241e, null, f3237b)).f3424a, true);
            this.f3250n.a(new Intent("com.facebook.contacts.FAVORITE_CONTACT_SYNC_PROGRESS"));
            this.f3240d.m14027a();
        }
    }
}
