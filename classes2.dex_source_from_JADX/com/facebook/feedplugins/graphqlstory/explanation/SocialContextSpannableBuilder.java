package com.facebook.feedplugins.graphqlstory.explanation;

import android.content.Context;
import android.text.Spannable;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ufiservices.flyout.FlyoutClickSource;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friend_requests */
public class SocialContextSpannableBuilder {
    private static SocialContextSpannableBuilder f23161b;
    private static final Object f23162c = new Object();
    private final LinkifyUtil f23163a;

    private static SocialContextSpannableBuilder m31271b(InjectorLike injectorLike) {
        return new SocialContextSpannableBuilder(LinkifyUtil.m26532a(injectorLike));
    }

    @Inject
    public SocialContextSpannableBuilder(LinkifyUtil linkifyUtil) {
        this.f23163a = linkifyUtil;
    }

    public static SocialContextSpannableBuilder m31270a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SocialContextSpannableBuilder b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23162c) {
                SocialContextSpannableBuilder socialContextSpannableBuilder;
                if (a2 != null) {
                    socialContextSpannableBuilder = (SocialContextSpannableBuilder) a2.mo818a(f23162c);
                } else {
                    socialContextSpannableBuilder = f23161b;
                }
                if (socialContextSpannableBuilder == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m31271b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23162c, b3);
                        } else {
                            f23161b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = socialContextSpannableBuilder;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final Spannable m31272a(FeedProps<GraphQLStory> feedProps) {
        FeedUnit feedUnit = (GraphQLStory) feedProps.f13444a;
        if (feedUnit.aG() == null || feedUnit.aG().aH() == null) {
            return null;
        }
        return this.f23163a.m26550a(LinkifyUtilConverter.m29870b(feedUnit.aG().aH()), feedUnit, FlyoutClickSource.TITLE, TrackableFeedProps.m27451a(feedProps));
    }
}
