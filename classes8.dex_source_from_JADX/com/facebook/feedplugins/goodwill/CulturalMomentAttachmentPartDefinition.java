package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.multirow.parts.VisibilityPartDefinition;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: gravity_location_changed */
public class CulturalMomentAttachmentPartDefinition<E extends HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, LinearLayout> {
    public static final ViewType f12142a = new C12961();
    private static final CallerContext f12143b = CallerContext.a(CulturalMomentAttachmentPartDefinition.class);
    private static CulturalMomentAttachmentPartDefinition f12144h;
    private static final Object f12145i = new Object();
    private final BackgroundPartDefinition f12146c;
    private final VisibilityPartDefinition f12147d;
    private final TextPartDefinition f12148e;
    private final FbDraweePartDefinition f12149f;
    private int f12150g;

    /* compiled from: gravity_location_changed */
    final class C12961 extends ViewType {
        C12961() {
        }

        public final View m14147a(Context context) {
            return LayoutInflater.from(context).inflate(2130903830, null);
        }
    }

    private static CulturalMomentAttachmentPartDefinition m14149b(InjectorLike injectorLike) {
        return new CulturalMomentAttachmentPartDefinition(GraphQLImageHelper.a(injectorLike), BackgroundPartDefinition.a(injectorLike), VisibilityPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), FbDraweePartDefinition.a(injectorLike));
    }

    public final Object m14151a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        subParts.a(this.f12146c, new StylingData(AttachmentProps.e(feedProps), PaddingStyle.a));
        int i = 2131558927;
        int i2 = 2131560866;
        if ("BOTTOM".equals(graphQLStoryAttachment.z().dt())) {
            i = 2131560866;
            i2 = 2131558927;
        }
        subParts.a(i, this.f12147d, Integer.valueOf(0));
        subParts.a(i2, this.f12147d, Integer.valueOf(8));
        subParts.a(i, this.f12148e, Strings.nullToEmpty(graphQLStoryAttachment.A()));
        i2 = (graphQLStoryAttachment.z().by().a() * this.f12150g) / graphQLStoryAttachment.z().by().c();
        FbDraweePartDefinition fbDraweePartDefinition = this.f12149f;
        Builder a = FbDraweePartDefinition.a().a(graphQLStoryAttachment.z().by().b()).a(-1, i2);
        a.c = f12143b;
        subParts.a(2131560864, fbDraweePartDefinition, a.a());
        FbDraweePartDefinition fbDraweePartDefinition2 = this.f12149f;
        Builder a2 = FbDraweePartDefinition.a().a(graphQLStoryAttachment.z().cw().b()).a(graphQLStoryAttachment.z().cw().c(), graphQLStoryAttachment.z().cw().a());
        a2.c = f12143b;
        subParts.a(2131560865, fbDraweePartDefinition2, a2.a());
        return null;
    }

    public final boolean m14152a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).a;
        return (graphQLStoryAttachment == null || graphQLStoryAttachment.z() == null || graphQLStoryAttachment.z().by() == null || graphQLStoryAttachment.z().by().b() == null || graphQLStoryAttachment.z().cw() == null || graphQLStoryAttachment.z().cw().b() == null) ? false : true;
    }

    public static CulturalMomentAttachmentPartDefinition m14148a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CulturalMomentAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12145i) {
                CulturalMomentAttachmentPartDefinition culturalMomentAttachmentPartDefinition;
                if (a2 != null) {
                    culturalMomentAttachmentPartDefinition = (CulturalMomentAttachmentPartDefinition) a2.a(f12145i);
                } else {
                    culturalMomentAttachmentPartDefinition = f12144h;
                }
                if (culturalMomentAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14149b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12145i, b3);
                        } else {
                            f12144h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = culturalMomentAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public CulturalMomentAttachmentPartDefinition(GraphQLImageHelper graphQLImageHelper, BackgroundPartDefinition backgroundPartDefinition, VisibilityPartDefinition visibilityPartDefinition, TextPartDefinition textPartDefinition, FbDraweePartDefinition fbDraweePartDefinition) {
        this.f12146c = backgroundPartDefinition;
        this.f12147d = visibilityPartDefinition;
        this.f12148e = textPartDefinition;
        this.f12149f = fbDraweePartDefinition;
        this.f12150g = graphQLImageHelper.e();
    }

    public final ViewType m14150a() {
        return f12142a;
    }
}
