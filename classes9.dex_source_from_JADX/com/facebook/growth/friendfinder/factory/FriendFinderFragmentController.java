package com.facebook.growth.friendfinder.factory;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.contacts.upload.prefs.ContactUploadStatusHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.growth.friendfinder.factory.FriendFinderStepsConfig.FriendFinderStep;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: partial_payment_card */
public class FriendFinderFragmentController {
    private static FriendFinderFragmentController f7282c;
    private static final Object f7283d = new Object();
    private ImmutableList<FriendFinderStep> f7284a;
    private int f7285b = 0;

    private static FriendFinderFragmentController m7557b(InjectorLike injectorLike) {
        return new FriendFinderFragmentController(new FriendFinderStepsConfig(ContactUploadStatusHelper.b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike)));
    }

    @Inject
    public FriendFinderFragmentController(FriendFinderStepsConfig friendFinderStepsConfig) {
        friendFinderStepsConfig.f7288c.clear();
        if (!friendFinderStepsConfig.f7286a.a()) {
            friendFinderStepsConfig.f7288c.add(FriendFinderStep.LEGAL_SCREEN);
        }
        friendFinderStepsConfig.f7288c.add(FriendFinderStep.FRIENDABLE_CONTACTS);
        if (friendFinderStepsConfig.f7287b.a(33, false)) {
            friendFinderStepsConfig.f7288c.add(FriendFinderStep.INVITABLE_CONTACTS);
        }
        this.f7284a = ImmutableList.copyOf(friendFinderStepsConfig.f7288c);
    }

    public static FriendFinderFragmentController m7556a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendFinderFragmentController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7283d) {
                FriendFinderFragmentController friendFinderFragmentController;
                if (a2 != null) {
                    friendFinderFragmentController = (FriendFinderFragmentController) a2.a(f7283d);
                } else {
                    friendFinderFragmentController = f7282c;
                }
                if (friendFinderFragmentController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7557b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7283d, b3);
                        } else {
                            f7282c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendFinderFragmentController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
