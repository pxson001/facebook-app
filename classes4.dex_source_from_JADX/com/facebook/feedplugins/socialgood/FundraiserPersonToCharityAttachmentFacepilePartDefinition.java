package com.facebook.feedplugins.socialgood;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLUser;
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
import com.facebook.multirow.parts.FacepilePartDefinition;
import com.facebook.multirow.parts.FacepilePartDefinition.Props;
import com.facebook.multirow.parts.TextOrHiddenPartDefinition;
import com.facebook.multirow.parts.ViewPaddingPartDefinition;
import com.facebook.multirow.parts.ViewPaddingPartDefinition.PaddingData;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: notification_dropped_message_read_locally */
public class FundraiserPersonToCharityAttachmentFacepilePartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, HasPositionInformation, LinearLayout> {
    public static final ViewType f6847a = ViewType.a(2130904566);
    private static FundraiserPersonToCharityAttachmentFacepilePartDefinition f6848j;
    private static final Object f6849k = new Object();
    private final BackgroundPartDefinition f6850b;
    private final ClickListenerPartDefinition f6851c;
    private final FacepilePartDefinition f6852d;
    private final TextOrHiddenPartDefinition f6853e;
    private final ViewPaddingPartDefinition f6854f;
    public final FbUriIntentHandler f6855g;
    public final AnalyticsLogger f6856h;
    private final Context f6857i;

    private static FundraiserPersonToCharityAttachmentFacepilePartDefinition m7198b(InjectorLike injectorLike) {
        return new FundraiserPersonToCharityAttachmentFacepilePartDefinition(BackgroundPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), FacepilePartDefinition.a(injectorLike), TextOrHiddenPartDefinition.a(injectorLike), ViewPaddingPartDefinition.a(injectorLike), FbUriIntentHandler.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public final Object m7200a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        BackgroundPartDefinition backgroundPartDefinition = this.f6850b;
        FeedProps e = AttachmentProps.e(feedProps);
        Builder f = Builder.f();
        f.d = 10.0f;
        subParts.a(backgroundPartDefinition, new StylingData(e, f.i(), 2130840524, -1));
        subParts.a(this.f6851c, new 1(this, graphQLStoryAttachment));
        subParts.a(2131562472, this.f6853e, graphQLStoryAttachment.z().jS());
        Object arrayList = new ArrayList();
        if (!(graphQLStoryAttachment.z().jR() == null || graphQLStoryAttachment.z().jR().a() == null)) {
            ImmutableList a = graphQLStoryAttachment.z().jR().a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                GraphQLUser graphQLUser = (GraphQLUser) a.get(i);
                if (!(graphQLUser.aI() == null || TextUtils.isEmpty(graphQLUser.aI().b()))) {
                    arrayList.add(Uri.parse(graphQLUser.aI().b()));
                }
            }
        }
        subParts.a(2131562472, this.f6854f, new PaddingData(arrayList.isEmpty() ? 0 : this.f6857i.getResources().getDimensionPixelSize(2131434677), Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE));
        subParts.a(2131562471, this.f6852d, new Props(ImmutableList.copyOf(arrayList), null, arrayList.size()));
        return null;
    }

    public final boolean m7201a(Object obj) {
        return m7197a((GraphQLStoryAttachment) ((FeedProps) obj).a);
    }

    public static FundraiserPersonToCharityAttachmentFacepilePartDefinition m7196a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FundraiserPersonToCharityAttachmentFacepilePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6849k) {
                FundraiserPersonToCharityAttachmentFacepilePartDefinition fundraiserPersonToCharityAttachmentFacepilePartDefinition;
                if (a2 != null) {
                    fundraiserPersonToCharityAttachmentFacepilePartDefinition = (FundraiserPersonToCharityAttachmentFacepilePartDefinition) a2.a(f6849k);
                } else {
                    fundraiserPersonToCharityAttachmentFacepilePartDefinition = f6848j;
                }
                if (fundraiserPersonToCharityAttachmentFacepilePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7198b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6849k, b3);
                        } else {
                            f6848j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = fundraiserPersonToCharityAttachmentFacepilePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FundraiserPersonToCharityAttachmentFacepilePartDefinition(BackgroundPartDefinition backgroundPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, FacepilePartDefinition facepilePartDefinition, TextOrHiddenPartDefinition textOrHiddenPartDefinition, ViewPaddingPartDefinition viewPaddingPartDefinition, FbUriIntentHandler fbUriIntentHandler, AnalyticsLogger analyticsLogger, Context context) {
        this.f6850b = backgroundPartDefinition;
        this.f6851c = clickListenerPartDefinition;
        this.f6852d = facepilePartDefinition;
        this.f6853e = textOrHiddenPartDefinition;
        this.f6855g = fbUriIntentHandler;
        this.f6856h = analyticsLogger;
        this.f6854f = viewPaddingPartDefinition;
        this.f6857i = context;
    }

    public final ViewType m7199a() {
        return f6847a;
    }

    public static boolean m7197a(GraphQLStoryAttachment graphQLStoryAttachment) {
        return (graphQLStoryAttachment.z() == null || TextUtils.isEmpty(graphQLStoryAttachment.z().jS())) ? false : true;
    }
}
