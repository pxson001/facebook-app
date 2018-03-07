package com.facebook.xconfig.sync;

import android.annotation.SuppressLint;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.Assisted;
import com.facebook.xconfig.core.XConfigAndValueInformation;
import com.facebook.xconfig.core.XConfigInformation;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigRegistry;
import com.facebook.xconfig.core.XConfigSetting;
import com.facebook.xconfig.core.XConfigStorage;
import com.facebook.xconfig.core.XConfigSyncListener;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap$Builder;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: structured_name */
public class XSyncHandler {
    private final AbstractSingleMethodRunner f1626a;
    private final DefaultAndroidThreadUtil f1627b;
    @Nullable
    private final String f1628c;
    @GuardedBy("XSyncHandler.class")
    private final XConfigStorage f1629d;
    private final XConfigRegistry f1630e;
    private final XSyncApiMethod f1631f;
    private final Set<XConfigSyncListener> f1632g;

    @Inject
    public XSyncHandler(SingleMethodRunner singleMethodRunner, AndroidThreadUtil androidThreadUtil, @Nullable @Assisted String str, XConfigStorage xConfigStorage, XConfigRegistry xConfigRegistry, XSyncApiMethodProvider xSyncApiMethodProvider, Set<XConfigSyncListener> set) {
        this.f1626a = singleMethodRunner;
        this.f1627b = androidThreadUtil;
        this.f1628c = str;
        this.f1629d = xConfigStorage;
        this.f1630e = xConfigRegistry;
        this.f1631f = xSyncApiMethodProvider.m1859a(str);
        this.f1632g = set;
    }

    public final void m1865a() {
        this.f1627b.b();
        synchronized (XSyncHandler.class) {
            try {
                XSyncResult xSyncResult = (XSyncResult) this.f1626a.a(this.f1631f, m1867b());
                if (xSyncResult == null) {
                    throw new XSyncException("Failed to sync xconfig");
                }
                m1866a(xSyncResult);
            } catch (Throwable e) {
                throw new XSyncException(e);
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            } catch (Throwable e22) {
                throw new XSyncException(e22);
            }
        }
    }

    final XSyncParams m1867b() {
        XSyncParams xSyncParams;
        synchronized (XSyncHandler.class) {
            xSyncParams = new XSyncParams(m1864c(), false);
        }
        return xSyncParams;
    }

    final void m1866a(XSyncResult xSyncResult) {
        List b = Lists.b();
        synchronized (XSyncHandler.class) {
            ImmutableMap a = this.f1630e.a();
            ImmutableMap a2 = this.f1629d.a(this.f1628c, a.keySet());
            Builder builder = ImmutableMap.builder();
            Iterator it = a.values().iterator();
            while (it.hasNext()) {
                Object xConfigAndValueInformation;
                XConfigInformation xConfigInformation = (XConfigInformation) it.next();
                String str = xConfigInformation.f1654d;
                XSyncConfigResult xSyncConfigResult = (XSyncConfigResult) xSyncResult.f2005a.get(xConfigInformation.f1651a.a());
                if (xSyncConfigResult == null) {
                    ImmutableMap a3 = m1862a(xConfigInformation.f1651a, xConfigInformation.f1652b);
                    String str2 = (String) a2.get(str);
                    if (str2 == null) {
                        throw new XSyncException(StringFormatUtil.formatStrLocaleSafe("Config %s received no response from server but does not have a stored config hash", xConfigInformation.f1651a));
                    } else if (str2.equals("")) {
                        throw new XSyncException(StringFormatUtil.formatStrLocaleSafe("Config %s received no response from server but does not have a stored value hash", xConfigInformation.f1651a));
                    } else {
                        xConfigAndValueInformation = new XConfigAndValueInformation(xConfigInformation.f1651a.a(), a3, str, str2);
                    }
                } else {
                    XConfigAndValueInformation xConfigAndValueInformation2 = new XConfigAndValueInformation(xConfigInformation.f1651a.a(), xSyncConfigResult.f2001b, str, xSyncConfigResult.f2002c);
                    b.add(xConfigInformation.f1651a);
                    XConfigAndValueInformation xConfigAndValueInformation3 = xConfigAndValueInformation2;
                }
                builder.b(xConfigInformation.f1651a.a(), xConfigAndValueInformation);
            }
            if (this.f1629d.a(this.f1628c, builder.b())) {
            } else {
                throw new XSyncException("Failed to write to xconfig storage");
            }
        }
        m1863a(b);
    }

    private void m1863a(List<XConfigName> list) {
        ImmutableMultimap$Builder c = ImmutableMultimap.c();
        for (Object obj : this.f1632g) {
            Object a = obj.mo137a();
            Preconditions.checkNotNull(a, "XConfigSyncListener.getConfig needs to return an XConfig");
            c.mo697b(a, obj);
        }
        ImmutableMultimap b = c.mo698b();
        for (XConfigName xConfigName : list) {
            Iterator it = b.h(xConfigName).iterator();
            while (it.hasNext()) {
                ((XConfigSyncListener) it.next()).mo138a(xConfigName);
            }
            it = b.h(XConfigName.d).iterator();
            while (it.hasNext()) {
                ((XConfigSyncListener) it.next()).mo138a(xConfigName);
            }
        }
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    @VisibleForTesting
    @GuardedBy("XSyncHandler.class")
    private ImmutableMap<String, String> m1862a(XConfigName xConfigName, Iterable<XConfigSetting> iterable) {
        Builder builder = ImmutableMap.builder();
        for (XConfigSetting xConfigSetting : iterable) {
            String a = this.f1629d.a(this.f1628c, xConfigSetting);
            if (a == null) {
                throw new XSyncException(StringFormatUtil.formatStrLocaleSafe("No value for X Setting %s:%s was returned by the server, and no value is stored for it on the client", xConfigName.a(), xConfigSetting.a));
            }
            builder.b(xConfigSetting.a, a);
        }
        return builder.b();
    }

    @GuardedBy("XSyncHandler.class")
    @VisibleForTesting
    private ImmutableMap<String, String> m1864c() {
        ImmutableMap a = this.f1630e.a();
        ImmutableMap a2 = this.f1629d.a(this.f1628c, a.keySet());
        Builder builder = ImmutableMap.builder();
        Iterator it = a.values().iterator();
        while (it.hasNext()) {
            XConfigInformation xConfigInformation = (XConfigInformation) it.next();
            String str = xConfigInformation.f1653c;
            String str2 = xConfigInformation.f1654d;
            String str3 = (String) a2.get(str2);
            if (str3 == null) {
                builder.b(str, "");
            } else {
                builder.b(str2, str3);
            }
        }
        return builder.b();
    }
}
