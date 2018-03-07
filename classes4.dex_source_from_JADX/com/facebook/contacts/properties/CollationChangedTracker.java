package com.facebook.contacts.properties;

import android.os.Build.VERSION;
import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.init.INeedInit;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.Futures;
import javax.inject.Inject;

/* compiled from: maxLinesFromThumbnailSize must be false if titleMaxLines and subtitleMaxLines are specified */
public class CollationChangedTracker implements INeedInit {
    public static final Class<?> f8241a = CollationChangedTracker.class;
    private final DbContactsPropertyUtil f8242b;
    private final ContactsDbStateChecker f8243c;
    private final DefaultBlueServiceOperationFactory f8244d;

    public static CollationChangedTracker m8546b(InjectorLike injectorLike) {
        return new CollationChangedTracker(DbContactsPropertyUtil.m8548b(injectorLike), ContactsDbStateChecker.m8582a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike));
    }

    @Inject
    public CollationChangedTracker(DbContactsPropertyUtil dbContactsPropertyUtil, ContactsDbStateChecker contactsDbStateChecker, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f8242b = dbContactsPropertyUtil;
        this.f8243c = contactsDbStateChecker;
        this.f8244d = defaultBlueServiceOperationFactory;
    }

    public void init() {
        if (VERSION.SDK_INT >= 21 && !this.f8243c.m8584a()) {
            int a = this.f8242b.m8549a(DbContactsProperties.f13096g, -1);
            if (VERSION.SDK_INT != a) {
                Integer.valueOf(a);
                Integer.valueOf(VERSION.SDK_INT);
                BlueServiceOperationFactoryDetour.a(this.f8244d, "reindex_omnistore_contacts", new Bundle(), -1851099062).a(true).a();
                Futures.a(BlueServiceOperationFactoryDetour.a(this.f8244d, "reindex_contacts_names", new Bundle(), ErrorPropagation.BY_EXCEPTION, CallerContext.a(getClass()), -894903117).a(), new 1(this));
            }
        }
    }
}
