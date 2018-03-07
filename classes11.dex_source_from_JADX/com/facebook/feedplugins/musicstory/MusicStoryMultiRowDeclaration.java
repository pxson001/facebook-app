package com.facebook.feedplugins.musicstory;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.pager.PagerRowType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@ContextScoped
/* compiled from: composer_media_inline_sprout */
public class MusicStoryMultiRowDeclaration implements FeedRowSupportDeclaration {
    private static MusicStoryMultiRowDeclaration f8185a;
    private static final Object f8186b = new Object();

    private static MusicStoryMultiRowDeclaration m9180a() {
        return new MusicStoryMultiRowDeclaration();
    }

    public final void m9182a(ListItemRowController listItemRowController) {
        listItemRowController.a(SimpleMusicStoryPartDefinition.f8199a);
        listItemRowController.a(PagerRowType.a);
    }

    public static MusicStoryMultiRowDeclaration m9181a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MusicStoryMultiRowDeclaration a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f8186b) {
                MusicStoryMultiRowDeclaration musicStoryMultiRowDeclaration;
                if (a3 != null) {
                    musicStoryMultiRowDeclaration = (MusicStoryMultiRowDeclaration) a3.a(f8186b);
                } else {
                    musicStoryMultiRowDeclaration = f8185a;
                }
                if (musicStoryMultiRowDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9180a();
                        if (a3 != null) {
                            a3.a(f8186b, a2);
                        } else {
                            f8185a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = musicStoryMultiRowDeclaration;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
