package com.facebook.timeline.protiles.model;

import android.content.Context;
import android.support.annotation.Nullable;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLProfileTileSectionType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.collect.ImmutableList;

@ContextScoped
/* compiled from: feed_filter_events */
public class ProtilesData implements ListItemCollection<Object> {
    private static ProtilesData f12111d;
    private static final Object f12112e = new Object();
    @Nullable
    public ImmutableList<ProtileModel> f12113a;
    public final ProtilesLoadingData f12114b = new ProtilesLoadingData();
    public final TimelinePromptData f12115c = new TimelinePromptData();

    private static ProtilesData m12117f() {
        return new ProtilesData();
    }

    public final void m12121a(String str, GraphQLFriendshipStatus graphQLFriendshipStatus) {
        ProtileModel a = m12115a(GraphQLProfileTileSectionType.FRIENDS);
        if (a != null) {
            a.m12108a(str, graphQLFriendshipStatus);
        }
    }

    public static ProtilesData m12116a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProtilesData f;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12112e) {
                ProtilesData protilesData;
                if (a2 != null) {
                    protilesData = (ProtilesData) a2.a(f12112e);
                } else {
                    protilesData = f12111d;
                }
                if (protilesData == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        f = m12117f();
                        if (a2 != null) {
                            a2.a(f12112e, f);
                        } else {
                            f12111d = f;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    f = protilesData;
                }
            }
            return f;
        } finally {
            a.c(b);
        }
    }

    public final void m12120a(String str) {
        ProtileModel a = m12115a(GraphQLProfileTileSectionType.FRIENDS);
        if (a != null) {
            a.m12110b(str);
        }
    }

    @Nullable
    private ProtileModel m12115a(GraphQLProfileTileSectionType graphQLProfileTileSectionType) {
        if (this.f12113a == null) {
            return null;
        }
        int size = this.f12113a.size();
        for (int i = 0; i < size; i++) {
            ProtileModel protileModel = (ProtileModel) this.f12113a.get(i);
            if (protileModel.m12109b() == graphQLProfileTileSectionType) {
                return protileModel;
            }
        }
        return null;
    }

    public final int m12118a() {
        if (m12122e()) {
            return 1;
        }
        int size = (this.f12113a == null ? 0 : this.f12113a.size()) + 0;
        if (this.f12115c.d()) {
            return size + 1;
        }
        return size;
    }

    public final Object m12119a(int i) {
        if (m12122e()) {
            return this.f12114b;
        }
        if (this.f12113a != null) {
            if (i < this.f12113a.size()) {
                return this.f12113a.get(i);
            }
            i -= this.f12113a.size();
        }
        if (i == 0 && this.f12115c.d()) {
            return this.f12115c;
        }
        throw new IllegalArgumentException("Invalid index:" + i);
    }

    public final boolean m12122e() {
        return this.f12114b.m12123a() || this.f12114b.m12124b();
    }
}
