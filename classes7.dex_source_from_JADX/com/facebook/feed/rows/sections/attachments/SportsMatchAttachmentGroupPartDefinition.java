package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: X-ZERO-FAST-HASH */
public class SportsMatchAttachmentGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static SportsMatchAttachmentGroupPartDefinition f20780e;
    private static final Object f20781f = new Object();
    private final SportsMatchPhotoPartDefinition f20782a;
    private final SportsMatchScorePartDefinition f20783b;
    private final SportsMatchFooterTextPartDefinition f20784c;
    private final Provider<Boolean> f20785d;

    private static SportsMatchAttachmentGroupPartDefinition m23750b(InjectorLike injectorLike) {
        return new SportsMatchAttachmentGroupPartDefinition(SportsMatchPhotoPartDefinition.m23758a(injectorLike), SportsMatchScorePartDefinition.m23765a(injectorLike), SportsMatchFooterTextPartDefinition.m23753a(injectorLike), IdBasedProvider.a(injectorLike, 4009));
    }

    public final Object m23751a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f20782a, feedProps);
        baseMultiRowSubParts.a(this.f20783b, feedProps);
        baseMultiRowSubParts.a(this.f20784c, feedProps);
        return null;
    }

    @Inject
    public SportsMatchAttachmentGroupPartDefinition(SportsMatchPhotoPartDefinition sportsMatchPhotoPartDefinition, SportsMatchScorePartDefinition sportsMatchScorePartDefinition, SportsMatchFooterTextPartDefinition sportsMatchFooterTextPartDefinition, Provider<Boolean> provider) {
        this.f20782a = sportsMatchPhotoPartDefinition;
        this.f20783b = sportsMatchScorePartDefinition;
        this.f20784c = sportsMatchFooterTextPartDefinition;
        this.f20785d = provider;
    }

    public final boolean m23752a(Object obj) {
        return ((Boolean) this.f20785d.get()).equals(Boolean.valueOf(true));
    }

    public static SportsMatchAttachmentGroupPartDefinition m23749a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SportsMatchAttachmentGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20781f) {
                SportsMatchAttachmentGroupPartDefinition sportsMatchAttachmentGroupPartDefinition;
                if (a2 != null) {
                    sportsMatchAttachmentGroupPartDefinition = (SportsMatchAttachmentGroupPartDefinition) a2.a(f20781f);
                } else {
                    sportsMatchAttachmentGroupPartDefinition = f20780e;
                }
                if (sportsMatchAttachmentGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23750b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20781f, b3);
                        } else {
                            f20780e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = sportsMatchAttachmentGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
