package com.facebook.components.feed.api;

import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;

/* compiled from: image_search_interstitial */
public interface ComponentPart<P, E extends AnyEnvironment> {
    Component<?> mo3130a(ComponentContext componentContext, P p, E e);

    void mo3132a(SubParts<E> subParts, P p);

    boolean mo3133a(E e);

    CacheableEntity mo3131b(P p);
}
