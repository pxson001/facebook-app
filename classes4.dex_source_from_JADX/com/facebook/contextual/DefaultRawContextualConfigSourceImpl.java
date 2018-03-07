package com.facebook.contextual;

import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.api.manager.QeManager;
import com.facebook.xconfig.core.XConfigReader;

/* compiled from: squareProfilePicHuge */
public class DefaultRawContextualConfigSourceImpl {
    private QeAccessor f1930a;
    private QeManager f1931b;
    public XConfigReader f1932c;

    public DefaultRawContextualConfigSourceImpl(QeAccessor qeAccessor, QeManager qeManager, XConfigReader xConfigReader) {
        this.f1930a = qeAccessor;
        this.f1931b = qeManager;
        this.f1932c = xConfigReader;
    }
}
