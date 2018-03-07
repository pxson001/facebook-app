package com.facebook.friends.util;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.friends.constants.FriendRequestResponse;
import com.facebook.friends.model.FriendRequestState;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: mStorageConstraint */
public class FriendRequestUtil {
    private static FriendRequestUtil f10862j;
    private static final Object f10863k = new Object();
    private final String f10864a;
    private final String f10865b;
    private final String f10866c;
    private final String f10867d;
    private final String f10868e;
    private final String f10869f;
    private final String f10870g;
    private final String f10871h;
    private final String f10872i;

    /* compiled from: mStorageConstraint */
    public /* synthetic */ class C06671 {
        public static final /* synthetic */ int[] f10861c = new int[GraphQLFriendshipStatus.values().length];

        static {
            try {
                f10861c[GraphQLFriendshipStatus.ARE_FRIENDS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10861c[GraphQLFriendshipStatus.INCOMING_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10861c[GraphQLFriendshipStatus.OUTGOING_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f10861c[GraphQLFriendshipStatus.CAN_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            f10860b = new int[FriendRequestResponse.values().length];
            try {
                f10860b[FriendRequestResponse.CONFIRM.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f10860b[FriendRequestResponse.REJECT.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            f10859a = new int[FriendRequestState.values().length];
            try {
                f10859a[FriendRequestState.ACCEPTED.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f10859a[FriendRequestState.REJECTED.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    private static FriendRequestUtil m17438b(InjectorLike injectorLike) {
        return new FriendRequestUtil(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FriendRequestUtil(Resources resources) {
        this.f10864a = resources.getString(2131233219);
        this.f10865b = resources.getString(2131233222);
        this.f10866c = resources.getString(2131233357);
        this.f10867d = resources.getString(2131233223);
        this.f10868e = resources.getString(2131233212);
        this.f10869f = resources.getString(2131233213);
        this.f10870g = resources.getString(2131233218);
        this.f10871h = resources.getString(2131233216);
        this.f10872i = resources.getString(2131233217);
    }

    @Nullable
    public final String m17439a(FriendRequestState friendRequestState, boolean z) {
        switch (friendRequestState) {
            case ACCEPTED:
                return z ? this.f10864a : this.f10865b;
            case REJECTED:
                return z ? this.f10866c : this.f10867d;
            default:
                return null;
        }
    }

    public static FriendRequestUtil m17436a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendRequestUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10863k) {
                FriendRequestUtil friendRequestUtil;
                if (a2 != null) {
                    friendRequestUtil = (FriendRequestUtil) a2.a(f10863k);
                } else {
                    friendRequestUtil = f10862j;
                }
                if (friendRequestUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m17438b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10863k, b3);
                        } else {
                            f10862j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendRequestUtil;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final String m17440a(boolean z) {
        return z ? this.f10868e : this.f10870g;
    }

    @Nullable
    public final String m17441b(boolean z) {
        return z ? this.f10869f : null;
    }

    public final String m17442c(boolean z) {
        return z ? this.f10871h : this.f10872i;
    }

    public static GraphQLFriendshipStatus m17437a(FriendRequestResponse friendRequestResponse, boolean z) {
        switch (friendRequestResponse) {
            case CONFIRM:
                return z ? GraphQLFriendshipStatus.OUTGOING_REQUEST : GraphQLFriendshipStatus.ARE_FRIENDS;
            case REJECT:
                return GraphQLFriendshipStatus.CAN_REQUEST;
            default:
                throw new IllegalArgumentException("Unexpected value for FriendRequestResponse");
        }
    }

    public static FriendRequestState m17435a(FriendRequestResponse friendRequestResponse) {
        switch (friendRequestResponse) {
            case CONFIRM:
                return FriendRequestState.ACCEPTED;
            case REJECT:
                return FriendRequestState.REJECTED;
            default:
                throw new IllegalArgumentException("Unexpected value for FriendRequestResponse");
        }
    }
}
