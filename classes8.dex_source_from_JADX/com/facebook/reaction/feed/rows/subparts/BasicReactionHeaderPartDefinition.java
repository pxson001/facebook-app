package com.facebook.reaction.feed.rows.subparts;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.LinkableTextWithEntities;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.reaction.feed.common.ImageBlockLayoutIconPartDefinition;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitHeaderFieldsModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: app_discovery_lite_install_clicked */
public class BasicReactionHeaderPartDefinition extends BaseSinglePartDefinition<Props, Void, CanLaunchReactionIntent, ImageBlockLayout> {
    private static BasicReactionHeaderPartDefinition f19400c;
    private static final Object f19401d = new Object();
    private final ImageBlockLayoutIconPartDefinition f19402a;
    private final ReactionTextWithEntitiesPartDefinition f19403b;

    /* compiled from: app_discovery_lite_install_clicked */
    public class Props {
        public final ReactionUnitHeaderFieldsModel f19397a;
        public final String f19398b;
        public final String f19399c;

        public Props(ReactionUnitHeaderFieldsModel reactionUnitHeaderFieldsModel, String str, String str2) {
            this.f19397a = reactionUnitHeaderFieldsModel;
            this.f19398b = str;
            this.f19399c = str2;
        }
    }

    private static BasicReactionHeaderPartDefinition m23395b(InjectorLike injectorLike) {
        return new BasicReactionHeaderPartDefinition(ImageBlockLayoutIconPartDefinition.m22994a(injectorLike), ReactionTextWithEntitiesPartDefinition.m23423a(injectorLike));
    }

    public final Object m23396a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        LinkableTextWithEntities linkableTextWithEntities;
        Props props = (Props) obj;
        ReactionUnitHeaderFieldsModel reactionUnitHeaderFieldsModel = props.f19397a;
        String str = props.f19398b;
        String str2 = props.f19399c;
        subParts.a(2131566648, this.f19403b, new com.facebook.reaction.feed.rows.subparts.ReactionTextWithEntitiesPartDefinition.Props(reactionUnitHeaderFieldsModel.fA_(), str, str2));
        if (reactionUnitHeaderFieldsModel.fz_() == null || Strings.isNullOrEmpty(reactionUnitHeaderFieldsModel.fz_().a())) {
            linkableTextWithEntities = null;
        } else {
            linkableTextWithEntities = reactionUnitHeaderFieldsModel.fz_();
        }
        subParts.a(2131566653, this.f19403b, new com.facebook.reaction.feed.rows.subparts.ReactionTextWithEntitiesPartDefinition.Props(linkableTextWithEntities, str, str2));
        if (!(reactionUnitHeaderFieldsModel.d() == null || Strings.isNullOrEmpty(reactionUnitHeaderFieldsModel.d().b()))) {
            subParts.a(this.f19402a, reactionUnitHeaderFieldsModel.d().b());
        }
        return null;
    }

    @Inject
    public BasicReactionHeaderPartDefinition(ImageBlockLayoutIconPartDefinition imageBlockLayoutIconPartDefinition, ReactionTextWithEntitiesPartDefinition reactionTextWithEntitiesPartDefinition) {
        this.f19402a = imageBlockLayoutIconPartDefinition;
        this.f19403b = reactionTextWithEntitiesPartDefinition;
    }

    public static BasicReactionHeaderPartDefinition m23394a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BasicReactionHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19401d) {
                BasicReactionHeaderPartDefinition basicReactionHeaderPartDefinition;
                if (a2 != null) {
                    basicReactionHeaderPartDefinition = (BasicReactionHeaderPartDefinition) a2.a(f19401d);
                } else {
                    basicReactionHeaderPartDefinition = f19400c;
                }
                if (basicReactionHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23395b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19401d, b3);
                        } else {
                            f19400c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = basicReactionHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
