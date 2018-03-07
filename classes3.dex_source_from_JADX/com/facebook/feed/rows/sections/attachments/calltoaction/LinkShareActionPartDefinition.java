package com.facebook.feed.rows.sections.attachments.calltoaction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.attachments.utils.CallToActionUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
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
/* compiled from: Videos testing. */
public class LinkShareActionPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, HasPositionInformation, View> {
    public static final ViewType f317a = new C00101();
    private static LinkShareActionPartDefinition f318f;
    private static final Object f319g = new Object();
    private final BackgroundPartDefinition f320b;
    private final LinkShareActionTextPartDefinition f321c;
    private final LinkShareActionButtonPartDefinition f322d;
    private final DefaultPaddingStyleResolver f323e;

    /* compiled from: Videos testing. */
    final class C00101 extends ViewType {
        C00101() {
        }

        public final View m284a(Context context) {
            return LayoutInflater.from(context).inflate(2130905048, null);
        }
    }

    private static LinkShareActionPartDefinition m280b(InjectorLike injectorLike) {
        return new LinkShareActionPartDefinition(BackgroundPartDefinition.a(injectorLike), LinkShareActionTextPartDefinition.m286a(injectorLike), LinkShareActionButtonPartDefinition.m289a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike));
    }

    public final Object m282a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        subParts.a(2131563433, this.f321c, graphQLStoryAttachment);
        subParts.a(2131563434, this.f322d, graphQLStoryAttachment);
        subParts.a(this.f320b, new StylingData(AttachmentProps.e(feedProps), this.f323e.h(), 2130840313, -1));
        return null;
    }

    public final boolean m283a(Object obj) {
        return CallToActionUtil.i((GraphQLStoryAttachment) ((FeedProps) obj).a);
    }

    @Inject
    public LinkShareActionPartDefinition(BackgroundPartDefinition backgroundPartDefinition, LinkShareActionTextPartDefinition linkShareActionTextPartDefinition, LinkShareActionButtonPartDefinition linkShareActionButtonPartDefinition, DefaultPaddingStyleResolver defaultPaddingStyleResolver) {
        this.f320b = backgroundPartDefinition;
        this.f321c = linkShareActionTextPartDefinition;
        this.f322d = linkShareActionButtonPartDefinition;
        this.f323e = defaultPaddingStyleResolver;
    }

    public final ViewType m281a() {
        return f317a;
    }

    public static LinkShareActionPartDefinition m279a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LinkShareActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f319g) {
                LinkShareActionPartDefinition linkShareActionPartDefinition;
                if (a2 != null) {
                    linkShareActionPartDefinition = (LinkShareActionPartDefinition) a2.a(f319g);
                } else {
                    linkShareActionPartDefinition = f318f;
                }
                if (linkShareActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m280b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f319g, b3);
                        } else {
                            f318f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = linkShareActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
