package com.facebook.feedplugins.graphqlstory.usertopictombstone;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@ContextScoped
/* compiled from: SYSTEM_TRAY */
public class UserTopicTombstoneDeclaration implements FeedRowSupportDeclaration {
    private static UserTopicTombstoneDeclaration f23476a;
    private static final Object f23477b = new Object();

    private static UserTopicTombstoneDeclaration m25751a() {
        return new UserTopicTombstoneDeclaration();
    }

    public final void m25753a(ListItemRowController listItemRowController) {
        listItemRowController.a(UserTopicTombstonePartDefinition.a);
    }

    public static UserTopicTombstoneDeclaration m25752a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            UserTopicTombstoneDeclaration a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f23477b) {
                UserTopicTombstoneDeclaration userTopicTombstoneDeclaration;
                if (a3 != null) {
                    userTopicTombstoneDeclaration = (UserTopicTombstoneDeclaration) a3.a(f23477b);
                } else {
                    userTopicTombstoneDeclaration = f23476a;
                }
                if (userTopicTombstoneDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m25751a();
                        if (a3 != null) {
                            a3.a(f23477b, a2);
                        } else {
                            f23476a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = userTopicTombstoneDeclaration;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
