package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_more_transactions */
public class AngoraAttachmentBackgroundPartDefinition extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, HasPositionInformation, View> {
    private static AngoraAttachmentBackgroundPartDefinition f24003d;
    private static final Object f24004e = new Object();
    private final BackgroundPartDefinition f24005a;
    private final FeedStoryUtil f24006b;
    private final QeAccessor f24007c;

    private static AngoraAttachmentBackgroundPartDefinition m32424b(InjectorLike injectorLike) {
        return new AngoraAttachmentBackgroundPartDefinition(BackgroundPartDefinition.m19135a(injectorLike), FeedStoryUtil.m18578a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PaddingStyle paddingStyle;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        int i = 2130840176;
        if (this.f24006b.m18592d(feedProps) && GraphQLStoryAttachmentUtil.m28054c(graphQLStoryAttachment) && this.f24007c.mo596a(ExperimentsForNewsFeedAbTestModule.ah, false)) {
            paddingStyle = PaddingStyle.f13084n;
            i = -1;
        } else {
            paddingStyle = PaddingStyle.f13078h;
        }
        subParts.mo2756a(this.f24005a, new StylingData(AttachmentProps.m28715e(feedProps), paddingStyle, i, -1));
        return null;
    }

    @Inject
    public AngoraAttachmentBackgroundPartDefinition(BackgroundPartDefinition backgroundPartDefinition, FeedStoryUtil feedStoryUtil, QeAccessor qeAccessor) {
        this.f24005a = backgroundPartDefinition;
        this.f24006b = feedStoryUtil;
        this.f24007c = qeAccessor;
    }

    public static AngoraAttachmentBackgroundPartDefinition m32423a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AngoraAttachmentBackgroundPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24004e) {
                AngoraAttachmentBackgroundPartDefinition angoraAttachmentBackgroundPartDefinition;
                if (a2 != null) {
                    angoraAttachmentBackgroundPartDefinition = (AngoraAttachmentBackgroundPartDefinition) a2.mo818a(f24004e);
                } else {
                    angoraAttachmentBackgroundPartDefinition = f24003d;
                }
                if (angoraAttachmentBackgroundPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32424b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24004e, b3);
                        } else {
                            f24003d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = angoraAttachmentBackgroundPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
