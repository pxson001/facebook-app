package com.facebook.redspace.data;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ultralight.Inject;

@ContextScoped
/* compiled from: Precondition Failed */
public class RedSpaceSelfProfileDataStore {
    private static RedSpaceSelfProfileDataStore f11869c;
    private static final Object f11870d = new Object();
    @Inject
    public RedSpaceFriendsCollection f11871a;
    public String f11872b;

    /* compiled from: Precondition Failed */
    public class State implements Parcelable {
        public static final Creator<State> CREATOR = new C14101();
        public RedSpaceFriendsCollection f11867a;
        public String f11868b;

        /* compiled from: Precondition Failed */
        final class C14101 implements Creator<State> {
            C14101() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new State(parcel);
            }

            public final Object[] newArray(int i) {
                return new State[i];
            }
        }

        public State(RedSpaceFriendsCollection redSpaceFriendsCollection, String str) {
            this.f11867a = redSpaceFriendsCollection;
            this.f11868b = str;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f11867a, i);
            parcel.writeString(this.f11868b);
        }

        protected State(Parcel parcel) {
            this.f11867a = (RedSpaceFriendsCollection) parcel.readParcelable(RedSpaceFriendsCollection.class.getClassLoader());
            this.f11868b = parcel.readString();
        }
    }

    private static RedSpaceSelfProfileDataStore m12319b(InjectorLike injectorLike) {
        RedSpaceSelfProfileDataStore redSpaceSelfProfileDataStore = new RedSpaceSelfProfileDataStore();
        redSpaceSelfProfileDataStore.f11871a = RedSpaceFriendsCollection.m12212a(injectorLike);
        return redSpaceSelfProfileDataStore;
    }

    public final void m12320a(@Nullable State state) {
        if (state != null) {
            RedSpaceFriendsCollection redSpaceFriendsCollection = this.f11871a;
            RedSpaceFriendsCollection redSpaceFriendsCollection2 = state.f11867a;
            redSpaceFriendsCollection.f11775b = redSpaceFriendsCollection2.f11775b;
            redSpaceFriendsCollection.f11776c = redSpaceFriendsCollection2.f11776c;
            redSpaceFriendsCollection.f11774a = redSpaceFriendsCollection2.f11774a;
            this.f11872b = state.f11868b;
        }
    }

    public static RedSpaceSelfProfileDataStore m12318a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceSelfProfileDataStore b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11870d) {
                RedSpaceSelfProfileDataStore redSpaceSelfProfileDataStore;
                if (a2 != null) {
                    redSpaceSelfProfileDataStore = (RedSpaceSelfProfileDataStore) a2.a(f11870d);
                } else {
                    redSpaceSelfProfileDataStore = f11869c;
                }
                if (redSpaceSelfProfileDataStore == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12319b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11870d, b3);
                        } else {
                            f11869c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceSelfProfileDataStore;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
