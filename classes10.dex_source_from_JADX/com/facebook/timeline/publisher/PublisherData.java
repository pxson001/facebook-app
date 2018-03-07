package com.facebook.timeline.publisher;

import android.content.Context;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fav_photos_extra */
public class PublisherData implements ListItemCollection<Object> {
    private static PublisherData f12415b;
    private static final Object f12416c = new Object();
    public final TimelinePublisherBarModel f12417a;

    private static PublisherData m12451b(InjectorLike injectorLike) {
        return new PublisherData(new TimelinePublisherBarModel());
    }

    @Inject
    public PublisherData(TimelinePublisherBarModel timelinePublisherBarModel) {
        this.f12417a = timelinePublisherBarModel;
    }

    public final Object m12454a(int i) {
        if (i == 0 && m12452b()) {
            return this.f12417a;
        }
        throw new IllegalArgumentException("Invalid index");
    }

    public final int m12453a() {
        if (m12452b()) {
            return 1;
        }
        return 0;
    }

    private boolean m12452b() {
        return this.f12417a.f12428a;
    }

    public static PublisherData m12450a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PublisherData b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12416c) {
                PublisherData publisherData;
                if (a2 != null) {
                    publisherData = (PublisherData) a2.a(f12416c);
                } else {
                    publisherData = f12415b;
                }
                if (publisherData == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12451b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12416c, b3);
                        } else {
                            f12415b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = publisherData;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
