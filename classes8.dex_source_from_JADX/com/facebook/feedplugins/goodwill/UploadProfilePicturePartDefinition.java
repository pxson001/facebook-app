package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.goodwill.analytics.GoodwillAnalyticsLogger;
import com.facebook.goodwill.analytics.GoodwillAnalyticsLogger$Events;
import com.facebook.graphql.model.GoodwillFeedUnitHelper;
import com.facebook.graphql.model.GraphQLGoodwillCampaign;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLImageOverlay;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.heisman.BirthdayFrameStagingGroundDummyActivity;
import com.facebook.heisman.protocol.conversion.ImageOverlayConversionHelper;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: global_share_graphql_object_type */
public class UploadProfilePicturePartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, Void, HasPositionInformation, View> {
    public static final ViewType f12645a = ViewType.a(2130903389);
    private static UploadProfilePicturePartDefinition f12646e;
    private static final Object f12647f = new Object();
    public final SecureContextHelper f12648b;
    private final ClickListenerPartDefinition f12649c;
    public final GoodwillAnalyticsLogger f12650d;

    private static UploadProfilePicturePartDefinition m14473b(InjectorLike injectorLike) {
        return new UploadProfilePicturePartDefinition((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), GoodwillAnalyticsLogger.a(injectorLike));
    }

    public final Object m14475a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLGoodwillCampaign g = GoodwillFeedUnitHelper.g((GraphQLGoodwillThrowbackPromotionFeedUnit) ((FeedProps) obj).a);
        final GraphQLImageOverlay graphQLImageOverlay = (GraphQLImageOverlay) g.G().get(0);
        final String b = g.k().b();
        ClickListenerPartDefinition clickListenerPartDefinition = this.f12649c;
        final String t = g.t();
        subParts.a(2131559914, clickListenerPartDefinition, new OnClickListener(this) {
            final /* synthetic */ UploadProfilePicturePartDefinition f12644d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1263378327);
                Intent a2 = BirthdayFrameStagingGroundDummyActivity.m590a(view.getContext(), b, ImageOverlayConversionHelper.a(graphQLImageOverlay));
                GoodwillAnalyticsLogger goodwillAnalyticsLogger = this.f12644d.f12650d;
                String str = t;
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent(GoodwillAnalyticsLogger$Events.GOODWILL_THROWBACK_ADD_PROFILE_FRAME_CLICK.name);
                honeyClientEvent.c = "goodwill";
                goodwillAnalyticsLogger.a.a(honeyClientEvent.b("campaign_id", str));
                this.f12644d.f12648b.a(a2, view.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, 961905337, a);
            }
        });
        return null;
    }

    public final boolean m14476a(Object obj) {
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) ((FeedProps) obj).a;
        GraphQLGoodwillCampaign g = GoodwillFeedUnitHelper.g(graphQLGoodwillThrowbackPromotionFeedUnit);
        if (g == null || !"self_birthday_profile_pic_frame".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F())) {
            return false;
        }
        GraphQLProfile k = g.k();
        return (k == null || TextUtils.isEmpty(k.b()) || TextUtils.isEmpty(k.U()) || k.ai() == null || TextUtils.isEmpty(k.ai().b()) || g.G() == null || g.G().isEmpty() || g.G().get(0) == null || TextUtils.isEmpty(((GraphQLImageOverlay) g.G().get(0)).l())) ? false : true;
    }

    @Inject
    public UploadProfilePicturePartDefinition(SecureContextHelper secureContextHelper, ClickListenerPartDefinition clickListenerPartDefinition, GoodwillAnalyticsLogger goodwillAnalyticsLogger) {
        this.f12648b = secureContextHelper;
        this.f12649c = clickListenerPartDefinition;
        this.f12650d = goodwillAnalyticsLogger;
    }

    public static UploadProfilePicturePartDefinition m14472a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            UploadProfilePicturePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12647f) {
                UploadProfilePicturePartDefinition uploadProfilePicturePartDefinition;
                if (a2 != null) {
                    uploadProfilePicturePartDefinition = (UploadProfilePicturePartDefinition) a2.a(f12647f);
                } else {
                    uploadProfilePicturePartDefinition = f12646e;
                }
                if (uploadProfilePicturePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14473b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12647f, b3);
                        } else {
                            f12646e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = uploadProfilePicturePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<View> m14474a() {
        return f12645a;
    }
}
