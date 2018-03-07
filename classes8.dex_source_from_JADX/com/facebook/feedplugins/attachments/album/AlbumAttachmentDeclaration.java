package com.facebook.feedplugins.attachments.album;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feedplugins.attachments.collage.CollageAttachmentPartDefinition;
import com.facebook.feedplugins.attachments.collage.ObjectionableContentCollageAttachmentPartDefinition;
import com.facebook.feedplugins.attachments.multimedia.MultimediaCollageAttachmentPartDefinition;
import com.facebook.feedplugins.attachments.multimedia.MultimediaSinglePlayerAttachmentPartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.ViewType;
import com.google.common.collect.ImmutableList;

@ContextScoped
/* compiled from: group_add_member */
public class AlbumAttachmentDeclaration implements FeedRowSupportDeclaration {
    private static AlbumAttachmentDeclaration f11987a;
    private static final Object f11988b = new Object();

    private static AlbumAttachmentDeclaration m14067a() {
        return new AlbumAttachmentDeclaration();
    }

    public final void m14069a(ListItemRowController listItemRowController) {
        ImmutableList of = ImmutableList.of(CollageAttachmentPartDefinition.a, MultimediaSinglePlayerAttachmentPartDefinition.a, MultimediaCollageAttachmentPartDefinition.a, ObjectionableContentCollageAttachmentPartDefinition.a);
        int size = of.size();
        for (int i = 0; i < size; i++) {
            listItemRowController.a((ViewType) of.get(i));
        }
    }

    public static AlbumAttachmentDeclaration m14068a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AlbumAttachmentDeclaration a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f11988b) {
                AlbumAttachmentDeclaration albumAttachmentDeclaration;
                if (a3 != null) {
                    albumAttachmentDeclaration = (AlbumAttachmentDeclaration) a3.a(f11988b);
                } else {
                    albumAttachmentDeclaration = f11987a;
                }
                if (albumAttachmentDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m14067a();
                        if (a3 != null) {
                            a3.a(f11988b, a2);
                        } else {
                            f11987a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = albumAttachmentDeclaration;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
