package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.ui.MinutiaeAttachmentIconView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: inflate_fragment_before_animation */
public class MinutiaeAttachmentIconPartDefinition<E extends HasPositionInformation & HasPrefetcher & HasRowKey> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, MinutiaeAttachmentIconView> {
    public static final ViewType f20160a = new C08171();
    private static final CallerContext f20161b = CallerContext.m9061a(MinutiaeAttachmentIconPartDefinition.class, "native_newsfeed");
    private static MinutiaeAttachmentIconPartDefinition f20162e;
    private static final Object f20163f = new Object();
    private final BackgroundPartDefinition f20164c;
    private final FbDraweePartDefinition<E> f20165d;

    /* compiled from: inflate_fragment_before_animation */
    final class C08171 extends ViewType {
        C08171() {
        }

        public final View mo1995a(Context context) {
            return new MinutiaeAttachmentIconView(context);
        }
    }

    private static MinutiaeAttachmentIconPartDefinition m27833b(InjectorLike injectorLike) {
        return new MinutiaeAttachmentIconPartDefinition(BackgroundPartDefinition.m19135a(injectorLike), FbDraweePartDefinition.m27839a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        String o = GraphQLStoryAttachmentUtil.m28064o((GraphQLStoryAttachment) feedProps.f13444a);
        SinglePartDefinition singlePartDefinition = this.f20165d;
        Builder a = FbDraweePartDefinition.m27838a().m29720a(o);
        a.f21889c = f20161b;
        subParts.mo2755a(2131563893, singlePartDefinition, a.m29721a());
        subParts.mo2756a(this.f20164c, new StylingData(AttachmentProps.m28715e(feedProps), PaddingStyle.f13071a));
        return null;
    }

    public final boolean m27836a(Object obj) {
        return GraphQLStoryAttachmentUtil.m28061l((GraphQLStoryAttachment) ((FeedProps) obj).f13444a) != null;
    }

    @Inject
    public MinutiaeAttachmentIconPartDefinition(BackgroundPartDefinition backgroundPartDefinition, FbDraweePartDefinition fbDraweePartDefinition) {
        this.f20164c = backgroundPartDefinition;
        this.f20165d = fbDraweePartDefinition;
    }

    public static MinutiaeAttachmentIconPartDefinition m27832a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MinutiaeAttachmentIconPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20163f) {
                MinutiaeAttachmentIconPartDefinition minutiaeAttachmentIconPartDefinition;
                if (a2 != null) {
                    minutiaeAttachmentIconPartDefinition = (MinutiaeAttachmentIconPartDefinition) a2.mo818a(f20163f);
                } else {
                    minutiaeAttachmentIconPartDefinition = f20162e;
                }
                if (minutiaeAttachmentIconPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27833b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20163f, b3);
                        } else {
                            f20162e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = minutiaeAttachmentIconPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final ViewType mo2547a() {
        return f20160a;
    }
}
