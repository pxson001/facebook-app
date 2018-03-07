package com.facebook.feedplugins.attachments.collage;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.photos.warning.ObjectionableContentCollageAttachmentView;
import com.facebook.photos.warning.ObjectionableContentController;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: groups/members/<p$1> */
public class ObjectionableContentCollageAttachmentPartDefinition<E extends HasContext & HasFeedListType & HasInvalidate & HasImageLoadListener & HasPositionInformation & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, ObjectionableContentCollageAttachmentView> {
    public static final ViewType f21576a = new C08541();
    private static ObjectionableContentCollageAttachmentPartDefinition f21577f;
    private static final Object f21578g = new Object();
    private final CollageAttachmentPartDefinition<E> f21579b;
    public final ObjectionableContentController f21580c;
    private final ClickListenerPartDefinition f21581d;
    private final TextPartDefinition f21582e;

    /* compiled from: groups/members/<p$1> */
    final class C08541 extends ViewType {
        C08541() {
        }

        public final View mo1995a(Context context) {
            return new ObjectionableContentCollageAttachmentView(context);
        }
    }

    private static ObjectionableContentCollageAttachmentPartDefinition m29281b(InjectorLike injectorLike) {
        return new ObjectionableContentCollageAttachmentPartDefinition(CollageAttachmentPartDefinition.m29238a(injectorLike), ObjectionableContentController.m27812a(injectorLike), ClickListenerPartDefinition.m19353a(injectorLike), TextPartDefinition.m19379a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        subParts.mo2755a(2131564005, this.f21579b, feedProps);
        subParts.mo2755a(2131564316, this.f21582e, this.f21580c.m27817a(hasContext.getContext()));
        subParts.mo2755a(2131564317, this.f21581d, new 2(this, feedProps, hasContext));
        return null;
    }

    public final boolean m29284a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        if (!this.f21579b.m29253a(feedProps)) {
            return false;
        }
        ImmutableList x = ((GraphQLStoryAttachment) feedProps.f13444a).m23985x();
        int size = x.size();
        for (int i = 0; i < size; i++) {
            if (this.f21580c.m27823a(((GraphQLStoryAttachment) x.get(i)).m23979r())) {
                return true;
            }
        }
        return false;
    }

    public static ObjectionableContentCollageAttachmentPartDefinition m29280a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ObjectionableContentCollageAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21578g) {
                ObjectionableContentCollageAttachmentPartDefinition objectionableContentCollageAttachmentPartDefinition;
                if (a2 != null) {
                    objectionableContentCollageAttachmentPartDefinition = (ObjectionableContentCollageAttachmentPartDefinition) a2.mo818a(f21578g);
                } else {
                    objectionableContentCollageAttachmentPartDefinition = f21577f;
                }
                if (objectionableContentCollageAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m29281b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21578g, b3);
                        } else {
                            f21577f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = objectionableContentCollageAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public ObjectionableContentCollageAttachmentPartDefinition(CollageAttachmentPartDefinition collageAttachmentPartDefinition, ObjectionableContentController objectionableContentController, ClickListenerPartDefinition clickListenerPartDefinition, TextPartDefinition textPartDefinition) {
        this.f21579b = collageAttachmentPartDefinition;
        this.f21580c = objectionableContentController;
        this.f21581d = clickListenerPartDefinition;
        this.f21582e = textPartDefinition;
    }

    public final ViewType<ObjectionableContentCollageAttachmentView> mo2547a() {
        return f21576a;
    }
}
