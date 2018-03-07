package com.facebook.goodfriends.feedplugins;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.goodfriends.analytics.GoodFriendsAnalyticsLogger;
import com.facebook.graphql.model.GraphQLNoContentGoodFriendsFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: all_draft_posts */
public class NoContentFeedPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLNoContentGoodFriendsFeedUnit>, Void, AnyEnvironment, View> {
    public static final ViewType f10062a = new C11641();
    private static NoContentFeedPartDefinition f10063f;
    private static final Object f10064g = new Object();
    public final SecureContextHelper f10065b;
    private final ClickListenerPartDefinition f10066c;
    public final UriIntentMapper f10067d;
    private final GoodFriendsAnalyticsLogger f10068e;

    /* compiled from: all_draft_posts */
    final class C11641 extends ViewType {
        C11641() {
        }

        public final View m10407a(Context context) {
            return LayoutInflater.from(context).inflate(2130905457, null);
        }
    }

    /* compiled from: all_draft_posts */
    public class C11652 implements OnClickListener {
        final /* synthetic */ NoContentFeedPartDefinition f10061a;

        public C11652(NoContentFeedPartDefinition noContentFeedPartDefinition) {
            this.f10061a = noContentFeedPartDefinition;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -293944298);
            Intent a2 = this.f10061a.f10067d.a(view.getContext(), FBLinks.gh);
            a2.putExtra("triggered_by_nux", false);
            this.f10061a.f10065b.a(a2, 101, (Activity) ContextUtils.a(view.getContext(), Activity.class));
            Logger.a(2, EntryType.UI_INPUT_END, -2031666499, a);
        }
    }

    private static NoContentFeedPartDefinition m10409b(InjectorLike injectorLike) {
        return new NoContentFeedPartDefinition((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), GoodFriendsAnalyticsLogger.a(injectorLike));
    }

    @Inject
    public NoContentFeedPartDefinition(SecureContextHelper secureContextHelper, ClickListenerPartDefinition clickListenerPartDefinition, UriIntentMapper uriIntentMapper, GoodFriendsAnalyticsLogger goodFriendsAnalyticsLogger) {
        this.f10065b = secureContextHelper;
        this.f10066c = clickListenerPartDefinition;
        this.f10067d = uriIntentMapper;
        this.f10068e = goodFriendsAnalyticsLogger;
    }

    public static NoContentFeedPartDefinition m10408a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NoContentFeedPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10064g) {
                NoContentFeedPartDefinition noContentFeedPartDefinition;
                if (a2 != null) {
                    noContentFeedPartDefinition = (NoContentFeedPartDefinition) a2.a(f10064g);
                } else {
                    noContentFeedPartDefinition = f10063f;
                }
                if (noContentFeedPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10409b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10064g, b3);
                        } else {
                            f10063f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = noContentFeedPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Object m10411a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(2131564249, this.f10066c, new C11652(this));
        this.f10068e.a("placeholder_no_content");
        return null;
    }

    public final ViewType m10410a() {
        return f10062a;
    }

    public final boolean m10412a(Object obj) {
        return true;
    }
}
