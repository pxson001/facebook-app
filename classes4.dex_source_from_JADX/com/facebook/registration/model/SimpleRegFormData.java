package com.facebook.registration.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.growth.model.DeviceOwnerData;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.registration.constants.RegErrorCategory;
import com.facebook.registration.protocol.RegisterAccountMethod.Result;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: extra_page_tab */
public class SimpleRegFormData extends RegistrationFormData implements Parcelable {
    public static final Creator<SimpleRegFormData> CREATOR = new C05901();
    private static SimpleRegFormData f12464g;
    private static final Object f12465h = new Object();
    public DeviceOwnerData f12466a;
    public ContactPointSuggestions f12467b;
    public RegErrorCategory f12468c;
    public Map<RegErrorCategory, RegError> f12469d;
    public OperationFuture f12470e;
    public Result f12471f;

    /* compiled from: extra_page_tab */
    final class C05901 implements Creator<SimpleRegFormData> {
        C05901() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SimpleRegFormData(parcel);
        }

        public final Object[] newArray(int i) {
            return new SimpleRegFormData[i];
        }
    }

    private static SimpleRegFormData m13213C() {
        return new SimpleRegFormData();
    }

    @Inject
    public SimpleRegFormData() {
        this.f12466a = null;
        this.f12467b = null;
        this.f12468c = null;
        this.f12469d = Maps.c();
        this.f12470e = null;
        this.f12471f = null;
    }

    public SimpleRegFormData(Parcel parcel) {
        super(parcel);
        this.f12466a = (DeviceOwnerData) parcel.readParcelable(DeviceOwnerData.class.getClassLoader());
        this.f12467b = (ContactPointSuggestions) parcel.readParcelable(ContactPointSuggestions.class.getClassLoader());
        this.f12468c = (RegErrorCategory) parcel.readSerializable();
        this.f12469d = (Map) parcel.readSerializable();
        this.f12470e = null;
        this.f12471f = (Result) parcel.readParcelable(Result.class.getClassLoader());
    }

    public static SimpleRegFormData m13214a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SimpleRegFormData C;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12465h) {
                SimpleRegFormData simpleRegFormData;
                if (a2 != null) {
                    simpleRegFormData = (SimpleRegFormData) a2.a(f12465h);
                } else {
                    simpleRegFormData = f12464g;
                }
                if (simpleRegFormData == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        C = m13213C();
                        if (a2 != null) {
                            a2.a(f12465h, C);
                        } else {
                            f12464g = C;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    C = simpleRegFormData;
                }
            }
            return C;
        } finally {
            a.c(b);
        }
    }

    public final synchronized void m13215a(DeviceOwnerData deviceOwnerData) {
        this.f12466a = deviceOwnerData;
    }

    public final synchronized DeviceOwnerData m13221s() {
        DeviceOwnerData deviceOwnerData;
        if (this.f12466a == null) {
            deviceOwnerData = new DeviceOwnerData();
        } else {
            deviceOwnerData = this.f12466a;
        }
        return deviceOwnerData;
    }

    public final synchronized void m13217a(ContactPointSuggestions contactPointSuggestions) {
        this.f12467b = contactPointSuggestions;
    }

    public final synchronized ContactPointSuggestions m13222t() {
        ContactPointSuggestions contactPointSuggestions;
        if (this.f12467b == null) {
            contactPointSuggestions = new ContactPointSuggestions();
        } else {
            contactPointSuggestions = this.f12467b;
        }
        return contactPointSuggestions;
    }

    public final synchronized boolean m13223u() {
        return this.f12467b != null;
    }

    public final void m13216a(RegErrorCategory regErrorCategory, int i, String str) {
        this.f12469d.put(regErrorCategory, new RegError(i, str));
    }

    public final void m13224w() {
        m13218b(this.f12468c);
    }

    public final void m13218b(RegErrorCategory regErrorCategory) {
        this.f12469d.remove(regErrorCategory);
        if (this.f12468c == regErrorCategory) {
            this.f12468c = null;
        }
    }

    @Nullable
    public final String m13219c(RegErrorCategory regErrorCategory) {
        RegError regError = (RegError) this.f12469d.get(regErrorCategory);
        if (regError == null) {
            return null;
        }
        return regError.message;
    }

    public final void m13225x() {
        this.f12469d.clear();
        this.f12468c = null;
    }

    public final boolean m13220d(RegErrorCategory regErrorCategory) {
        return this.f12469d.containsKey(regErrorCategory);
    }

    public final boolean m13226y() {
        return !this.f12469d.isEmpty();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f12466a, i);
        parcel.writeParcelable(this.f12467b, i);
        parcel.writeSerializable(this.f12468c);
        parcel.writeSerializable((Serializable) this.f12469d);
        parcel.writeParcelable(this.f12471f, i);
    }
}
