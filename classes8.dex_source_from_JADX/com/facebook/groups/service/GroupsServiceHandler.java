package com.facebook.groups.service;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.groups.service.protocol.BlacklistGroupsYouShouldJoinMethod;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: video_share */
public class GroupsServiceHandler implements BlueServiceHandler {
    private static GroupsServiceHandler f531c;
    private static final Object f532d = new Object();
    public final Provider<SingleMethodRunner> f533a;
    public final BlacklistGroupsYouShouldJoinMethod f534b;

    private static GroupsServiceHandler m586b(InjectorLike injectorLike) {
        return new GroupsServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), new BlacklistGroupsYouShouldJoinMethod());
    }

    @Inject
    public GroupsServiceHandler(Provider<SingleMethodRunner> provider, BlacklistGroupsYouShouldJoinMethod blacklistGroupsYouShouldJoinMethod) {
        this.f533a = provider;
        this.f534b = blacklistGroupsYouShouldJoinMethod;
    }

    public final OperationResult m587a(OperationParams operationParams) {
        if ("group_blacklist_groups_you_should_join".equals(operationParams.b)) {
            CharSequence string = operationParams.c.getString("blacklistGroupsYouShouldJoinParamsKey");
            OperationResult a = StringUtil.a(string) ? OperationResult.a(ErrorCode.OTHER) : ((Boolean) ((AbstractSingleMethodRunner) this.f533a.get()).a(this.f534b, string, operationParams.e)).booleanValue() ? OperationResult.a : OperationResult.a(ErrorCode.OTHER);
            return a;
        }
        throw new Exception("Unknown type");
    }

    public static GroupsServiceHandler m585a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f532d) {
                GroupsServiceHandler groupsServiceHandler;
                if (a2 != null) {
                    groupsServiceHandler = (GroupsServiceHandler) a2.a(f532d);
                } else {
                    groupsServiceHandler = f531c;
                }
                if (groupsServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m586b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f532d, b3);
                        } else {
                            f531c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupsServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
