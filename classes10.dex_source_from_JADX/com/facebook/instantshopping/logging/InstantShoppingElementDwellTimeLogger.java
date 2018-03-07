package com.facebook.instantshopping.logging;

import android.content.Context;
import android.os.SystemClock;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ShareType.invitedUsersMap */
public class InstantShoppingElementDwellTimeLogger {
    private static final String f23550c = InstantShoppingElementDwellTimeLogger.class.getSimpleName();
    private static InstantShoppingElementDwellTimeLogger f23551d;
    private static final Object f23552e = new Object();
    public HashMap<String, ElementDwellTime> f23553a = new HashMap();
    private Lazy<FbErrorReporter> f23554b;

    /* compiled from: ShareType.invitedUsersMap */
    public class ElementDwellTime {
        public boolean f23545a;
        public boolean f23546b;
        public boolean f23547c;
        private double f23548d;
        public double f23549e;

        public final void m24869a() {
            m24868j();
            this.f23545a = true;
            this.f23548d = (double) SystemClock.uptimeMillis();
        }

        public final void m24870b() {
            m24868j();
            this.f23546b = true;
            m24867i();
        }

        public final void m24871c() {
            m24868j();
            this.f23547c = true;
            m24867i();
        }

        public final void m24872d() {
            m24868j();
            this.f23548d = (double) SystemClock.uptimeMillis();
        }

        private void m24867i() {
            if (this.f23548d != 0.0d) {
                this.f23549e += ((double) SystemClock.uptimeMillis()) - this.f23548d;
                this.f23548d = 0.0d;
            }
        }

        private void m24868j() {
            this.f23545a = false;
            this.f23545a = false;
            this.f23547c = false;
        }
    }

    private static InstantShoppingElementDwellTimeLogger m24874b(InjectorLike injectorLike) {
        return new InstantShoppingElementDwellTimeLogger(IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    public InstantShoppingElementDwellTimeLogger(Lazy<FbErrorReporter> lazy) {
        this.f23554b = lazy;
    }

    public final void m24876a(String str) {
        ElementDwellTime elementDwellTime;
        if (this.f23553a.containsKey(str)) {
            elementDwellTime = (ElementDwellTime) this.f23553a.get(str);
            if (elementDwellTime.f23546b) {
                elementDwellTime.m24869a();
                return;
            } else {
                ((AbstractFbErrorReporter) this.f23554b.get()).a(SoftError.a(f23550c + ".setElementOnScreen", "Error reporting element on screen. Element was not off screen to go on screen.").g());
                return;
            }
        }
        elementDwellTime = new ElementDwellTime();
        elementDwellTime.m24869a();
        this.f23553a.put(str, elementDwellTime);
    }

    public final void m24877b(String str) {
        if (this.f23553a.containsKey(str)) {
            ElementDwellTime elementDwellTime = (ElementDwellTime) this.f23553a.get(str);
            if (elementDwellTime.f23545a) {
                elementDwellTime.m24870b();
            } else {
                ((AbstractFbErrorReporter) this.f23554b.get()).a(SoftError.a(f23550c + ".setElementOffScreen", "Error reporting element off screen.Element was not on screen to go off screen.").g());
            }
        }
    }

    public static InstantShoppingElementDwellTimeLogger m24873a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstantShoppingElementDwellTimeLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23552e) {
                InstantShoppingElementDwellTimeLogger instantShoppingElementDwellTimeLogger;
                if (a2 != null) {
                    instantShoppingElementDwellTimeLogger = (InstantShoppingElementDwellTimeLogger) a2.a(f23552e);
                } else {
                    instantShoppingElementDwellTimeLogger = f23551d;
                }
                if (instantShoppingElementDwellTimeLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24874b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23552e, b3);
                        } else {
                            f23551d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = instantShoppingElementDwellTimeLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m24875a() {
        for (Entry value : this.f23553a.entrySet()) {
            ElementDwellTime elementDwellTime = (ElementDwellTime) value.getValue();
            if (elementDwellTime.f23545a) {
                elementDwellTime.m24871c();
            }
        }
    }

    public final JsonNode m24878c() {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        for (Entry entry : this.f23553a.entrySet()) {
            objectNode.a((String) entry.getKey(), ((ElementDwellTime) entry.getValue()).f23549e / 1000.0d);
        }
        return objectNode;
    }
}
