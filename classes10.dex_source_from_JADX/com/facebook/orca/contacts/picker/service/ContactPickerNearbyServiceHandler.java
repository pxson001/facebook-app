package com.facebook.orca.contacts.picker.service;

import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.futures.FutureUtils;
import com.facebook.contacts.cache.DynamicContactDataCache;
import com.facebook.contacts.graphql.ChatContextsGraphQLInterfaces.ChatContextForUser;
import com.facebook.contacts.picker.SuggestionType;
import com.facebook.contacts.picker.SuggestionUsersLoader;
import com.facebook.contacts.picker.SuggestionsCache;
import com.facebook.contacts.server.FetchChatContextParams;
import com.facebook.contacts.server.FetchChatContextResult;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.enums.GraphQLUserChatContextType;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.user.model.User;
import com.facebook.user.util.UserRankComparator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.inject.Inject;

@UserScoped
/* compiled from: num_manual_selected */
public class ContactPickerNearbyServiceHandler implements BlueServiceHandler {
    public static final Comparator<User> f6104a = UserRankComparator.a;
    private static final Object f6105f = new Object();
    public final SuggestionsCache f6106b;
    public final DynamicContactDataCache f6107c;
    public final SuggestionUsersLoader f6108d;
    public final DefaultBlueServiceOperationFactory f6109e;

    private static ContactPickerNearbyServiceHandler m5816b(InjectorLike injectorLike) {
        return new ContactPickerNearbyServiceHandler(SuggestionsCache.a(injectorLike), DynamicContactDataCache.a(injectorLike), SuggestionUsersLoader.b(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.orca.contacts.picker.service.ContactPickerNearbyServiceHandler m5814a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f6105f;	 Catch:{ all -> 0x006c }
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
        r1 = m5816b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f6105f;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.orca.contacts.picker.service.ContactPickerNearbyServiceHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.orca.contacts.picker.service.ContactPickerNearbyServiceHandler) r0;	 Catch:{  }
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
        r0 = f6105f;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.orca.contacts.picker.service.ContactPickerNearbyServiceHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.contacts.picker.service.ContactPickerNearbyServiceHandler.a(com.facebook.inject.InjectorLike):com.facebook.orca.contacts.picker.service.ContactPickerNearbyServiceHandler");
    }

    public final OperationResult m5817a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("fetch_nearby_suggestions".equals(str)) {
            return m5815b(operationParams);
        }
        throw new IllegalArgumentException("Unknown operation type: " + str);
    }

    @Inject
    public ContactPickerNearbyServiceHandler(SuggestionsCache suggestionsCache, DynamicContactDataCache dynamicContactDataCache, SuggestionUsersLoader suggestionUsersLoader, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f6106b = suggestionsCache;
        this.f6107c = dynamicContactDataCache;
        this.f6108d = suggestionUsersLoader;
        this.f6109e = defaultBlueServiceOperationFactory;
    }

    private OperationResult m5815b(OperationParams operationParams) {
        ImmutableList a = this.f6106b.a(SuggestionType.NEARBY);
        if (a == null) {
            a = this.f6107c.a(GraphQLUserChatContextType.NEARBY);
            if (a != null) {
                this.f6106b.a(SuggestionType.NEARBY, a);
            } else {
                ImmutableList immutableList;
                Bundle bundle = new Bundle();
                bundle.putParcelable("fetchChatContextParams", new FetchChatContextParams());
                OperationResult operationResult = (OperationResult) FutureUtils.a(BlueServiceOperationFactoryDetour.a(this.f6109e, "sync_chat_context", bundle, operationParams.e, -450480865).c());
                if (operationResult == null) {
                    immutableList = null;
                } else {
                    ImmutableMap immutableMap = ((FetchChatContextResult) operationResult.h()).a;
                    Builder builder = ImmutableList.builder();
                    Iterator it = immutableMap.entrySet().iterator();
                    while (it.hasNext()) {
                        Entry entry = (Entry) it.next();
                        if (((ChatContextForUser) entry.getValue()).b().b() == GraphQLUserChatContextType.NEARBY) {
                            builder.c(entry.getKey());
                        }
                    }
                    immutableList = builder.b();
                }
                a = immutableList;
                if (a != null) {
                    this.f6106b.a(SuggestionType.NEARBY, a);
                } else {
                    a = null;
                }
            }
        }
        ImmutableList immutableList2 = a;
        if (immutableList2 == null) {
            immutableList2 = null;
        } else {
            Collection a2 = Lists.a(this.f6108d.a(immutableList2));
            Collections.sort(a2, f6104a);
            immutableList2 = ImmutableList.copyOf(a2);
        }
        ImmutableList immutableList3 = immutableList2;
        if (immutableList3 == null) {
            return OperationResult.a(ErrorCode.OTHER);
        }
        return OperationResult.a(new ContactPickerNearbyResult(immutableList3));
    }
}
