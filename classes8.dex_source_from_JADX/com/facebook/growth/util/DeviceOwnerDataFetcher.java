package com.facebook.growth.util;

import android.content.Context;
import android.util.Patterns;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.hardware.String_PhoneIsoCountryCodeMethodAutoProvider;
import com.facebook.common.phonenumbers.PhoneNumberUtilMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.growth.model.DeviceOwnerData;
import com.facebook.growth.model.FullName;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.phonenumbers.NumberParseException;
import com.facebook.phonenumbers.PhoneNumberUtil;
import com.facebook.phonenumbers.Phonenumber.PhoneNumber;
import com.google.common.base.CharMatcher;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: effectiveRegion */
public class DeviceOwnerDataFetcher {
    private static DeviceOwnerDataFetcher f14902i;
    private static final Object f14903j = new Object();
    private final String[] f14904a = new String[]{"My Info"};
    private final DeviceContactpointUtil f14905b;
    private final DeviceOwnerInfoUtil f14906c;
    private final ListeningExecutorService f14907d;
    private final String f14908e;
    private final PhoneNumberUtil f14909f;
    @Nullable
    public volatile DeviceOwnerData f14910g;
    private int f14911h = -1;

    /* compiled from: effectiveRegion */
    class C16171 implements Callable<DeviceOwnerData> {
        final /* synthetic */ DeviceOwnerDataFetcher f14901a;

        C16171(DeviceOwnerDataFetcher deviceOwnerDataFetcher) {
            this.f14901a = deviceOwnerDataFetcher;
        }

        public Object call() {
            return DeviceOwnerDataFetcher.m17372c(this.f14901a);
        }
    }

    private static DeviceOwnerDataFetcher m17371b(InjectorLike injectorLike) {
        return new DeviceOwnerDataFetcher(DeviceContactpointUtil.m17363b(injectorLike), new DeviceOwnerInfoUtil((Context) injectorLike.getInstance(Context.class), ContentResolverMethodAutoProvider.b(injectorLike)), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), String_PhoneIsoCountryCodeMethodAutoProvider.b(injectorLike), PhoneNumberUtilMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public DeviceOwnerDataFetcher(DeviceContactpointUtil deviceContactpointUtil, DeviceOwnerInfoUtil deviceOwnerInfoUtil, ListeningExecutorService listeningExecutorService, String str, PhoneNumberUtil phoneNumberUtil) {
        this.f14905b = deviceContactpointUtil;
        this.f14906c = deviceOwnerInfoUtil;
        this.f14907d = listeningExecutorService;
        this.f14908e = str;
        this.f14909f = phoneNumberUtil;
    }

    public final ListenableFuture<DeviceOwnerData> m17374a() {
        return m17375a(false);
    }

    public static DeviceOwnerDataFetcher m17367a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DeviceOwnerDataFetcher b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14903j) {
                DeviceOwnerDataFetcher deviceOwnerDataFetcher;
                if (a2 != null) {
                    deviceOwnerDataFetcher = (DeviceOwnerDataFetcher) a2.a(f14903j);
                } else {
                    deviceOwnerDataFetcher = f14902i;
                }
                if (deviceOwnerDataFetcher == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m17371b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14903j, b3);
                        } else {
                            f14902i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = deviceOwnerDataFetcher;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ListenableFuture<DeviceOwnerData> m17375a(boolean z) {
        if (this.f14910g != null && !z) {
            return Futures.a(this.f14910g);
        }
        this.f14910g = new DeviceOwnerData();
        return this.f14907d.a(new C16171(this));
    }

    public static DeviceOwnerData m17372c(DeviceOwnerDataFetcher deviceOwnerDataFetcher) {
        int i = 0;
        for (String a : deviceOwnerDataFetcher.f14905b.m17366c()) {
            deviceOwnerDataFetcher.f14910g.m17353a(a);
        }
        for (String a2 : deviceOwnerDataFetcher.f14905b.m17365b()) {
            deviceOwnerDataFetcher.f14910g.m17353a(a2);
        }
        deviceOwnerDataFetcher.m17370a(deviceOwnerDataFetcher.f14905b.m17364a());
        try {
            deviceOwnerDataFetcher.m17368a(deviceOwnerDataFetcher.f14906c.m17380a());
        } catch (Exception e) {
        }
        DeviceOwnerData deviceOwnerData = new DeviceOwnerData();
        try {
            ImmutableList c = deviceOwnerDataFetcher.f14910g.m17356c();
            int size = c.size();
            for (int i2 = 0; i2 < size; i2++) {
                for (DeviceOwnerData a3 : deviceOwnerDataFetcher.f14906c.m17381a((String) c.get(i2))) {
                    deviceOwnerData.m17351a(a3);
                }
            }
        } catch (Exception e2) {
        }
        try {
            ImmutableList d = deviceOwnerDataFetcher.f14910g.m17358d();
            int size2 = d.size();
            while (i < size2) {
                for (DeviceOwnerData a32 : deviceOwnerDataFetcher.f14906c.m17382b((String) d.get(i))) {
                    deviceOwnerData.m17351a(a32);
                }
                i++;
            }
        } catch (Exception e3) {
        }
        deviceOwnerDataFetcher.m17368a(deviceOwnerData);
        if (StringUtil.c(deviceOwnerDataFetcher.f14910g.m17359e())) {
            deviceOwnerDataFetcher.f14910g.m17357c(deviceOwnerDataFetcher.f14908e);
        }
        return deviceOwnerDataFetcher.f14910g;
    }

    private void m17368a(DeviceOwnerData deviceOwnerData) {
        int i = 0;
        if (deviceOwnerData != null) {
            int i2;
            if (this.f14910g.m17349a() == null) {
                this.f14910g.m17350a(deviceOwnerData.m17349a());
            }
            ImmutableList c = deviceOwnerData.m17356c();
            int size = c.size();
            for (i2 = 0; i2 < size; i2++) {
                String str = (String) c.get(i2);
                if (!StringUtil.c(str)) {
                    String trim = str.trim();
                    if (Patterns.EMAIL_ADDRESS.matcher(trim).matches()) {
                        this.f14910g.m17353a(trim);
                    }
                }
            }
            c = deviceOwnerData.m17354b();
            size = c.size();
            for (i2 = 0; i2 < size; i2++) {
                m17369a((FullName) c.get(i2));
            }
            ImmutableList d = deviceOwnerData.m17358d();
            int size2 = d.size();
            while (i < size2) {
                m17370a((String) d.get(i));
                i++;
            }
            if (StringUtil.c(this.f14910g.m17359e())) {
                this.f14910g.m17357c(deviceOwnerData.m17359e());
            }
        }
    }

    private void m17370a(String str) {
        Object obj;
        if (!StringUtil.c(str)) {
            Object regionCodeForNumber;
            try {
                PhoneNumber parse = this.f14909f.parse(str, this.f14908e);
                String l = Long.toString(parse.getNationalNumber());
                try {
                    if (this.f14911h == -1) {
                        this.f14911h = this.f14909f.getCountryCodeForRegion(this.f14908e);
                    }
                    if (this.f14911h != parse.getCountryCode()) {
                        regionCodeForNumber = this.f14909f.getRegionCodeForNumber(parse);
                        if (regionCodeForNumber == null || regionCodeForNumber.equals("ZZ")) {
                            regionCodeForNumber = null;
                        }
                        obj = l;
                    } else {
                        regionCodeForNumber = this.f14908e;
                        String str2 = l;
                    }
                } catch (NumberParseException e) {
                    String str3 = l;
                    obj = regionCodeForNumber;
                    regionCodeForNumber = null;
                    if (!StringUtil.c(obj)) {
                        this.f14910g.m17355b(obj);
                    }
                    if (!StringUtil.c(regionCodeForNumber)) {
                        return;
                    }
                }
            } catch (NumberParseException e2) {
                regionCodeForNumber = null;
                obj = regionCodeForNumber;
                regionCodeForNumber = null;
                if (StringUtil.c(obj)) {
                    this.f14910g.m17355b(obj);
                }
                if (!StringUtil.c(regionCodeForNumber)) {
                }
                return;
            }
            if (StringUtil.c(obj)) {
                this.f14910g.m17355b(obj);
            }
            if (!StringUtil.c(regionCodeForNumber) && StringUtil.c(this.f14910g.m17359e())) {
                this.f14910g.m17357c(regionCodeForNumber);
            }
        }
    }

    private void m17369a(FullName fullName) {
        if (fullName != null) {
            Object c = m17373c(fullName.f14897b);
            Object c2 = m17373c(fullName.f14899d);
            Object c3 = m17373c(fullName.f14898c);
            if (!StringUtil.c(c) || !StringUtil.c(c2) || !StringUtil.c(c3)) {
                this.f14910g.m17352a(new FullName(c, c2, c3, fullName.f14896a));
            }
        }
    }

    private String m17373c(String str) {
        if (StringUtil.c(str)) {
            return null;
        }
        String trimFrom = CharMatcher.WHITESPACE.or(CharMatcher.anyOf(",")).trimFrom(str);
        if (StringUtil.c(trimFrom) || Patterns.PHONE.matcher(trimFrom).matches() || Patterns.EMAIL_ADDRESS.matcher(trimFrom).matches()) {
            return null;
        }
        for (String equalsIgnoreCase : this.f14904a) {
            if (equalsIgnoreCase.equalsIgnoreCase(trimFrom)) {
                return null;
            }
        }
        return trimFrom;
    }
}
