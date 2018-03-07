package com.facebook.search.results.rows.sections.derp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.linkshare.SmallPhotoShareAttachmentPartDefinition;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REACTION_CONTEXT_ITEM_VIEW */
public class SmallPhotoShareAttachmentWithMarginPartDefinition<E extends HasInvalidate & HasPersistentState & HasPositionInformation & HasPrefetcher, V extends View & AngoraAttachment> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
    public static final ViewType f24093a = new C25671();
    private static SmallPhotoShareAttachmentWithMarginPartDefinition f24094c;
    private static final Object f24095d = new Object();
    private final SmallPhotoShareAttachmentPartDefinition f24096b;

    /* compiled from: REACTION_CONTEXT_ITEM_VIEW */
    final class C25671 extends ViewType {
        C25671() {
        }

        public final View m27646a(Context context) {
            return LayoutInflater.from(context).inflate(2130907139, null);
        }
    }

    private static SmallPhotoShareAttachmentWithMarginPartDefinition m27648b(InjectorLike injectorLike) {
        return new SmallPhotoShareAttachmentWithMarginPartDefinition(SmallPhotoShareAttachmentPartDefinition.a(injectorLike));
    }

    public final Object m27650a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(2131567500, this.f24096b, (FeedProps) obj);
        return null;
    }

    @Inject
    public SmallPhotoShareAttachmentWithMarginPartDefinition(SmallPhotoShareAttachmentPartDefinition smallPhotoShareAttachmentPartDefinition) {
        this.f24096b = smallPhotoShareAttachmentPartDefinition;
    }

    public final ViewType<V> m27649a() {
        return f24093a;
    }

    public static SmallPhotoShareAttachmentWithMarginPartDefinition m27647a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SmallPhotoShareAttachmentWithMarginPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24095d) {
                SmallPhotoShareAttachmentWithMarginPartDefinition smallPhotoShareAttachmentWithMarginPartDefinition;
                if (a2 != null) {
                    smallPhotoShareAttachmentWithMarginPartDefinition = (SmallPhotoShareAttachmentWithMarginPartDefinition) a2.a(f24095d);
                } else {
                    smallPhotoShareAttachmentWithMarginPartDefinition = f24094c;
                }
                if (smallPhotoShareAttachmentWithMarginPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27648b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24095d, b3);
                        } else {
                            f24094c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = smallPhotoShareAttachmentWithMarginPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m27651a(Object obj) {
        return true;
    }
}
