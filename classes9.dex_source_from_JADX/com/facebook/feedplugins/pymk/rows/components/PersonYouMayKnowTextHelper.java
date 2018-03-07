package com.facebook.feedplugins.pymk.rows.components;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.FriendshipPersistentState;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.timeline.intent.ModelBundle;
import javax.inject.Inject;

@ContextScoped
/* compiled from: THREAD_CACHE */
public class PersonYouMayKnowTextHelper {
    private static PersonYouMayKnowTextHelper f24912f;
    private static final Object f24913g = new Object();
    private final Context f24914a;
    private final FbUriIntentHandler f24915b;
    private final String f24916c;
    private final String f24917d;
    private final String f24918e;

    private static PersonYouMayKnowTextHelper m26688b(InjectorLike injectorLike) {
        return new PersonYouMayKnowTextHelper((Context) injectorLike.getInstance(Context.class), FbUriIntentHandler.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PersonYouMayKnowTextHelper(Context context, FbUriIntentHandler fbUriIntentHandler, Resources resources) {
        this.f24914a = context;
        this.f24915b = fbUriIntentHandler;
        this.f24916c = resources.getString(2131233219);
        this.f24917d = resources.getString(2131233222);
        this.f24918e = resources.getString(2131233220);
    }

    public final void m26690a(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        ModelBundle.a(bundle, str, str2, str3);
        this.f24915b.a(this.f24914a, StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, str), bundle);
    }

    public final String m26689a(String str, FriendshipPersistentState friendshipPersistentState) {
        GraphQLFriendshipStatus graphQLFriendshipStatus = friendshipPersistentState.f24683a;
        if (graphQLFriendshipStatus == GraphQLFriendshipStatus.OUTGOING_REQUEST) {
            return this.f24916c;
        }
        if (graphQLFriendshipStatus == GraphQLFriendshipStatus.ARE_FRIENDS) {
            return this.f24917d;
        }
        if (friendshipPersistentState.f24684b) {
            return this.f24918e;
        }
        return str;
    }

    public static PersonYouMayKnowTextHelper m26687a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PersonYouMayKnowTextHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24913g) {
                PersonYouMayKnowTextHelper personYouMayKnowTextHelper;
                if (a2 != null) {
                    personYouMayKnowTextHelper = (PersonYouMayKnowTextHelper) a2.a(f24913g);
                } else {
                    personYouMayKnowTextHelper = f24912f;
                }
                if (personYouMayKnowTextHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26688b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24913g, b3);
                        } else {
                            f24912f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = personYouMayKnowTextHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
