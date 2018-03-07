package com.facebook.messaging.photoreminders.omnistore;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.photoreminders.PhotoRemindersGatekeepers;
import com.facebook.omnistore.Collection;
import com.facebook.omnistore.Cursor;
import com.facebook.omnistore.OmnistoreException;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: mQPLTraceControl */
public class PhotoRemindersOmnistoreUtil {
    private static final String f8587a = PhotoRemindersOmnistoreUtil.class.getSimpleName();
    private final AbstractFbErrorReporter f8588b;
    private final Provider<Collection> f8589c;
    private final Provider<PhotoRemindersCollectionCallback> f8590d;
    private final PhotoRemindersGatekeepers f8591e;

    public static PhotoRemindersOmnistoreUtil m8840b(InjectorLike injectorLike) {
        return new PhotoRemindersOmnistoreUtil((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 8289), PhotoRemindersGatekeepers.m8831b(injectorLike), IdBasedProvider.a(injectorLike, 2856));
    }

    @Inject
    public PhotoRemindersOmnistoreUtil(FbErrorReporter fbErrorReporter, Provider<PhotoRemindersCollectionCallback> provider, PhotoRemindersGatekeepers photoRemindersGatekeepers, Provider<Collection> provider2) {
        this.f8588b = fbErrorReporter;
        this.f8590d = provider;
        this.f8591e = photoRemindersGatekeepers;
        this.f8589c = provider2;
    }

    @Nullable
    public final Collection m8841a() {
        if (!this.f8591e.m8833b()) {
            return null;
        }
        if (!((PhotoRemindersCollectionCallback) this.f8590d.get()).a()) {
            return null;
        }
        try {
            return (Collection) this.f8589c.get();
        } catch (OmnistoreException e) {
            this.f8588b.a("PhotoRemindersCollection", "Failed to subscribe to collection");
            return null;
        }
    }

    @Nullable
    public final Boolean m8843b() {
        Boolean bool = null;
        Cursor object;
        try {
            Collection a = m8841a();
            if (a != null) {
                object = a.getObject("feature_enabled");
                try {
                    if (object.step()) {
                        bool = Boolean.valueOf(object.getBlob().getInt() > 0);
                        if (object != null) {
                            object.close();
                        }
                    } else if (object != null) {
                        object.close();
                    }
                } catch (OmnistoreException e) {
                    if (object != null) {
                        object.close();
                    }
                    return bool;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    if (object != null) {
                        object.close();
                    }
                    throw th2;
                }
            }
        } catch (OmnistoreException e2) {
            object = null;
            if (object != null) {
                object.close();
            }
            return bool;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            object = null;
            th2 = th4;
            if (object != null) {
                object.close();
            }
            throw th2;
        }
        return bool;
    }

    public final void m8842a(boolean z) {
        if (this.f8591e.m8833b()) {
            Boolean.valueOf(z);
            Collection collection = (Collection) this.f8589c.get();
            if (collection != null) {
                try {
                    collection.saveObject("feature_enabled", "", ByteBuffer.allocate(4).putInt(z ? 1 : 0).array());
                } catch (OmnistoreException e) {
                    BLog.b(f8587a, e, "Failed to save Photo Reminders' enable state (%b) to Omnistore", new Object[]{Boolean.valueOf(z)});
                }
            }
        }
    }
}
