package com.facebook.feedplugins.socialgood;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.timeline.util.TimelineViewHelper;
import com.facebook.ufiservices.util.LinkifyUtil;
import javax.inject.Inject;

@ContextScoped
/* compiled from: notification_out_of_bounds_category */
public class FundraiserPageAttachmentHeaderPartDefinition<E extends HasPositionInformation & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, FundraiserPageAttachmentHeaderView> {
    public static final ViewType f6825a = new C03211();
    private static FundraiserPageAttachmentHeaderPartDefinition f6826k;
    private static final Object f6827l = new Object();
    private final BackgroundPartDefinition f6828b;
    private final ClickListenerPartDefinition f6829c;
    public final FbUriIntentHandler f6830d;
    private final LinkifyUtil f6831e;
    private final Context f6832f;
    private final Resources f6833g;
    public final AnalyticsLogger f6834h;
    public final Lazy<SecureContextHelper> f6835i;
    public final Lazy<IFeedIntentBuilder> f6836j;

    /* compiled from: notification_out_of_bounds_category */
    final class C03211 extends ViewType {
        C03211() {
        }

        public final View m7186a(Context context) {
            return new FundraiserPageAttachmentHeaderView(context);
        }
    }

    private static FundraiserPageAttachmentHeaderPartDefinition m7181b(InjectorLike injectorLike) {
        return new FundraiserPageAttachmentHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), FbUriIntentHandler.a(injectorLike), LinkifyUtil.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), AnalyticsLoggerMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 968), IdBasedSingletonScopeProvider.b(injectorLike, 2347));
    }

    public final Object m7183a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object 3;
        CharSequence charSequence;
        String b;
        FeedProps feedProps = (FeedProps) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        String str = null;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        subParts.a(this.f6829c, new 2(this, graphQLStoryAttachment));
        String l = SocialGoodFeedDataModelHelper.l(graphQLStoryAttachment);
        if (l != null) {
            3 = new 3(this, hasPositionInformation, l);
        } else {
            3 = null;
        }
        subParts.a(2131562461, this.f6829c, 3);
        String c = SocialGoodFeedDataModelHelper.c(graphQLStoryAttachment);
        if (SocialGoodFeedDataModelHelper.d(graphQLStoryAttachment) == null || TextUtils.isEmpty(SocialGoodFeedDataModelHelper.d(graphQLStoryAttachment).a())) {
            charSequence = "";
        } else {
            Object a = SocialGoodFeedDataModelHelper.d(graphQLStoryAttachment).a();
        }
        boolean e = SocialGoodFeedDataModelHelper.e(graphQLStoryAttachment);
        if (e) {
            charSequence = TimelineViewHelper.a(e, false, new SpannableStringBuilder(charSequence), 2130843879, 0, this.f6832f, this.f6833g.getDimensionPixelSize(2131434670), this.f6833g.getDimensionPixelSize(2131434671), null);
        }
        GraphQLImage g = SocialGoodFeedDataModelHelper.g(graphQLStoryAttachment);
        GraphQLImage f = SocialGoodFeedDataModelHelper.f(graphQLStoryAttachment);
        if (g != null) {
            b = g.b();
        } else {
            b = null;
        }
        if (f != null) {
            str = f.b();
        }
        BackgroundPartDefinition backgroundPartDefinition = this.f6828b;
        FeedProps e2 = AttachmentProps.e(feedProps);
        Builder f2 = Builder.f();
        f2.d = 10.0f;
        f2 = f2;
        f2.b = 8.0f;
        subParts.a(backgroundPartDefinition, new StylingData(e2, f2.i(), 2130840181, -1));
        return new State(b, str, c, charSequence);
    }

    public final /* bridge */ /* synthetic */ void m7184a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -776121797);
        State state = (State) obj2;
        FundraiserPageAttachmentHeaderView fundraiserPageAttachmentHeaderView = (FundraiserPageAttachmentHeaderView) view;
        String str = state.a;
        if (str == null) {
            fundraiserPageAttachmentHeaderView.d.setVisibility(8);
            fundraiserPageAttachmentHeaderView.d.getLayoutParams().height = -2;
        } else {
            fundraiserPageAttachmentHeaderView.d.a(Uri.parse(str), FundraiserPageAttachmentHeaderView.a);
            fundraiserPageAttachmentHeaderView.d.setVisibility(0);
            fundraiserPageAttachmentHeaderView.d.setAspectRatio(1.9318181f);
        }
        str = state.b;
        if (str == null) {
            fundraiserPageAttachmentHeaderView.e.setVisibility(8);
        } else {
            fundraiserPageAttachmentHeaderView.e.a(Uri.parse(str), FundraiserPageAttachmentHeaderView.a);
            fundraiserPageAttachmentHeaderView.e.setVisibility(0);
        }
        fundraiserPageAttachmentHeaderView.a(state.a != null, state.c, state.d);
        Logger.a(8, EntryType.MARK_POP, 1272033349, a);
    }

    public static FundraiserPageAttachmentHeaderPartDefinition m7180a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FundraiserPageAttachmentHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6827l) {
                FundraiserPageAttachmentHeaderPartDefinition fundraiserPageAttachmentHeaderPartDefinition;
                if (a2 != null) {
                    fundraiserPageAttachmentHeaderPartDefinition = (FundraiserPageAttachmentHeaderPartDefinition) a2.a(f6827l);
                } else {
                    fundraiserPageAttachmentHeaderPartDefinition = f6826k;
                }
                if (fundraiserPageAttachmentHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7181b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6827l, b3);
                        } else {
                            f6826k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = fundraiserPageAttachmentHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FundraiserPageAttachmentHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, FbUriIntentHandler fbUriIntentHandler, LinkifyUtil linkifyUtil, Resources resources, Context context, AnalyticsLogger analyticsLogger, Lazy<SecureContextHelper> lazy, Lazy<IFeedIntentBuilder> lazy2) {
        this.f6828b = backgroundPartDefinition;
        this.f6829c = clickListenerPartDefinition;
        this.f6830d = fbUriIntentHandler;
        this.f6831e = linkifyUtil;
        this.f6833g = resources;
        this.f6832f = context;
        this.f6834h = analyticsLogger;
        this.f6835i = lazy;
        this.f6836j = lazy2;
    }

    public final ViewType m7182a() {
        return f6825a;
    }

    public final boolean m7185a(Object obj) {
        return true;
    }
}
