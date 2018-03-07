package com.facebook.feedplugins.socialgood;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.View;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.attachments.angora.actionbutton.AngoraActionButtonController;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.socialgood.ipc.SocialGoodUtil;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: notification_launch_source */
public class FundraiserPageAttachmentBodyPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, HasPositionInformation, FundraiserPageAttachmentBodyView> {
    public static final ViewType f6837a = new C03221();
    private static FundraiserPageAttachmentBodyPartDefinition f6838i;
    private static final Object f6839j = new Object();
    private final BackgroundPartDefinition f6840b;
    private final AngoraActionButtonController f6841c;
    private final ClickListenerPartDefinition f6842d;
    public final FbUriIntentHandler f6843e;
    public final AnalyticsLogger f6844f;
    private final AllCapsTransformationMethod f6845g;
    private final SocialGoodUtil f6846h;

    /* compiled from: notification_launch_source */
    final class C03221 extends ViewType {
        C03221() {
        }

        public final View m7195a(Context context) {
            return new FundraiserPageAttachmentBodyView(context);
        }
    }

    private static FundraiserPageAttachmentBodyPartDefinition m7189b(InjectorLike injectorLike) {
        return new FundraiserPageAttachmentBodyPartDefinition(BackgroundPartDefinition.a(injectorLike), AngoraActionButtonController.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), FbUriIntentHandler.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), AllCapsTransformationMethod.b(injectorLike), SocialGoodUtil.a(injectorLike));
    }

    public final Object m7192a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        int i;
        PaddingStyle i2;
        boolean z;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        boolean b = this.f6841c.b(feedProps);
        String str = null;
        if (!(!b || ActionLinkHelper.a(graphQLStoryAttachment) == null || StringUtil.a(ActionLinkHelper.a(graphQLStoryAttachment).aB()) || StringUtil.a(ActionLinkHelper.a(graphQLStoryAttachment).aE()))) {
            String uri = Uri.parse(ActionLinkHelper.a(graphQLStoryAttachment).aE()).buildUpon().appendQueryParameter("attachment_type", "native").build().toString();
            str = ActionLinkHelper.a(graphQLStoryAttachment).aB();
            subParts.a(2131562459, this.f6842d, new 2(this, graphQLStoryAttachment, uri));
        }
        if (SocialGoodFeedDataModelHelper.g(graphQLStoryAttachment) == null) {
            if (FundraiserPersonToCharityAttachmentFacepilePartDefinition.m7197a(graphQLStoryAttachment)) {
                i = 2130840521;
            } else {
                i = 2130840520;
            }
        } else if (SocialGoodFeedDataModelHelper.a(graphQLStoryAttachment) && FundraiserPersonToCharityAttachmentFacepilePartDefinition.m7197a(graphQLStoryAttachment)) {
            i = 2130840179;
        } else {
            i = 2130840174;
        }
        if (SocialGoodFeedDataModelHelper.a(graphQLStoryAttachment)) {
            Builder f = Builder.f();
            f.d = 10.0f;
            i2 = f.i();
        } else {
            i2 = PaddingStyle.m;
        }
        subParts.a(this.f6840b, new StylingData(AttachmentProps.e(feedProps), i2, i, -1));
        subParts.a(this.f6842d, new 3(this, graphQLStoryAttachment));
        Spannable c = m7190c(graphQLStoryAttachment);
        double k = SocialGoodFeedDataModelHelper.k(graphQLStoryAttachment);
        if (!SocialGoodFeedDataModelHelper.j(graphQLStoryAttachment) || TextUtils.isEmpty(SocialGoodFeedDataModelHelper.h(graphQLStoryAttachment))) {
            z = false;
        } else {
            z = true;
        }
        return new State(b, c, str, k, z);
    }

    public final /* bridge */ /* synthetic */ void m7193a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2004174298);
        m7188a((State) obj2, (FundraiserPageAttachmentBodyView) view);
        Logger.a(8, EntryType.MARK_POP, -1434574474, a);
    }

    public static FundraiserPageAttachmentBodyPartDefinition m7187a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FundraiserPageAttachmentBodyPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6839j) {
                FundraiserPageAttachmentBodyPartDefinition fundraiserPageAttachmentBodyPartDefinition;
                if (a2 != null) {
                    fundraiserPageAttachmentBodyPartDefinition = (FundraiserPageAttachmentBodyPartDefinition) a2.a(f6839j);
                } else {
                    fundraiserPageAttachmentBodyPartDefinition = f6838i;
                }
                if (fundraiserPageAttachmentBodyPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7189b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6839j, b3);
                        } else {
                            f6838i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = fundraiserPageAttachmentBodyPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FundraiserPageAttachmentBodyPartDefinition(BackgroundPartDefinition backgroundPartDefinition, AngoraActionButtonController angoraActionButtonController, ClickListenerPartDefinition clickListenerPartDefinition, FbUriIntentHandler fbUriIntentHandler, AnalyticsLogger analyticsLogger, AllCapsTransformationMethod allCapsTransformationMethod, SocialGoodUtil socialGoodUtil) {
        this.f6840b = backgroundPartDefinition;
        this.f6841c = angoraActionButtonController;
        this.f6842d = clickListenerPartDefinition;
        this.f6843e = fbUriIntentHandler;
        this.f6844f = analyticsLogger;
        this.f6845g = allCapsTransformationMethod;
        this.f6846h = socialGoodUtil;
    }

    public final ViewType m7191a() {
        return f6837a;
    }

    public final boolean m7194a(Object obj) {
        return true;
    }

    private void m7188a(State state, FundraiserPageAttachmentBodyView fundraiserPageAttachmentBodyView) {
        fundraiserPageAttachmentBodyView.a.setText(state.b);
        double d = state.d;
        fundraiserPageAttachmentBodyView.c.setVisibility(state.e ? 0 : 8);
        LayerDrawable layerDrawable = (LayerDrawable) fundraiserPageAttachmentBodyView.getResources().getDrawable(2130840526);
        Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908301);
        if (findDrawableByLayerId != null) {
            if (d < 1.0E-6d) {
                findDrawableByLayerId.setAlpha(125);
            } else {
                findDrawableByLayerId.setAlpha(255);
            }
        }
        int i = (int) (100.0d * d);
        if (i < 3) {
            fundraiserPageAttachmentBodyView.c.setProgress(3);
        } else {
            fundraiserPageAttachmentBodyView.c.setProgress(i);
        }
        fundraiserPageAttachmentBodyView.c.setProgressDrawable(layerDrawable);
        boolean z = state.a;
        CharSequence charSequence = state.c;
        AllCapsTransformationMethod allCapsTransformationMethod = this.f6845g;
        fundraiserPageAttachmentBodyView.b.setVisibility(z ? 0 : 8);
        fundraiserPageAttachmentBodyView.b.setText(charSequence);
        fundraiserPageAttachmentBodyView.b.setTransformationMethod(allCapsTransformationMethod);
    }

    private Spannable m7190c(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment.z() == null) {
            return null;
        }
        String j;
        String h = SocialGoodFeedDataModelHelper.h(graphQLStoryAttachment);
        SocialGoodFeedDataModelHelper.m(graphQLStoryAttachment);
        if (SocialGoodFeedDataModelHelper.r(graphQLStoryAttachment)) {
            Preconditions.checkNotNull(graphQLStoryAttachment.z().au());
            Preconditions.checkNotNull(graphQLStoryAttachment.z().au().j());
            j = graphQLStoryAttachment.z().au().j();
        } else if (SocialGoodFeedDataModelHelper.a(graphQLStoryAttachment)) {
            Preconditions.checkNotNull(graphQLStoryAttachment.z().jJ());
            j = graphQLStoryAttachment.z().jJ();
        } else {
            j = null;
        }
        String str = j;
        boolean j2 = SocialGoodFeedDataModelHelper.j(graphQLStoryAttachment);
        SocialGoodUtil socialGoodUtil = this.f6846h;
        return socialGoodUtil.a(h, str, j2, ContextCompat.b(socialGoodUtil.a, 2131363684));
    }
}
