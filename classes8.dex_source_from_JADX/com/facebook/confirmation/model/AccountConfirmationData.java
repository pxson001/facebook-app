package com.facebook.confirmation.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.growth.model.Contactpoint;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: intent_slideshow */
public class AccountConfirmationData implements Parcelable {
    public static final Creator<AccountConfirmationData> CREATOR = new C11621();
    private static AccountConfirmationData f10774e;
    private static final Object f10775f = new Object();
    public Contactpoint f10776a;
    public boolean f10777b;
    public boolean f10778c;
    public String f10779d;

    /* compiled from: intent_slideshow */
    final class C11621 implements Creator<AccountConfirmationData> {
        C11621() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AccountConfirmationData(parcel);
        }

        public final Object[] newArray(int i) {
            return new AccountConfirmationData[i];
        }
    }

    private static AccountConfirmationData m12725e() {
        return new AccountConfirmationData();
    }

    @Inject
    public AccountConfirmationData() {
        this.f10776a = null;
        this.f10777b = false;
        this.f10778c = false;
        this.f10779d = "";
    }

    public AccountConfirmationData(Parcel parcel) {
        this.f10776a = (Contactpoint) parcel.readParcelable(Contactpoint.class.getClassLoader());
        this.f10777b = ParcelUtil.a(parcel);
        this.f10778c = ParcelUtil.a(parcel);
        this.f10779d = parcel.readString();
    }

    public final void m12726a(Contactpoint contactpoint) {
        if (contactpoint.m17345a()) {
            this.f10776a = contactpoint;
        }
    }

    public static AccountConfirmationData m12724a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AccountConfirmationData e;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10775f) {
                AccountConfirmationData accountConfirmationData;
                if (a2 != null) {
                    accountConfirmationData = (AccountConfirmationData) a2.a(f10775f);
                } else {
                    accountConfirmationData = f10774e;
                }
                if (accountConfirmationData == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        e = m12725e();
                        if (a2 != null) {
                            a2.a(f10775f, e);
                        } else {
                            f10774e = e;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    e = accountConfirmationData;
                }
            }
            return e;
        } finally {
            a.c(b);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f10776a, i);
        ParcelUtil.a(parcel, this.f10777b);
        ParcelUtil.a(parcel, this.f10778c);
        parcel.writeString(this.f10779d);
    }
}
