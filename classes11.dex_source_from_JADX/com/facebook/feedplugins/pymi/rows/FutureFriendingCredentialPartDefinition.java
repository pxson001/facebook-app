package com.facebook.feedplugins.pymi.rows;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.GraphQLContactPoint;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnitContactsEdge;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ImageViewDrawablePartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.multirow.parts.VisibilityPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: cmdline */
public class FutureFriendingCredentialPartDefinition extends BaseSinglePartDefinition<Props, Void, AnyEnvironment, View> {
    private static FutureFriendingCredentialPartDefinition f8711e;
    private static final Object f8712f = new Object();
    private final ImageViewDrawablePartDefinition f8713a;
    public final Resources f8714b;
    private final TextPartDefinition f8715c;
    private final VisibilityPartDefinition<AnyEnvironment> f8716d;

    /* compiled from: cmdline */
    public class Props {
        public final GraphQLPeopleYouMayInviteFeedUnitContactsEdge f8709a;
        public final boolean f8710b;

        public Props(GraphQLPeopleYouMayInviteFeedUnitContactsEdge graphQLPeopleYouMayInviteFeedUnitContactsEdge, boolean z) {
            this.f8709a = graphQLPeopleYouMayInviteFeedUnitContactsEdge;
            this.f8710b = z;
        }
    }

    private static FutureFriendingCredentialPartDefinition m9522b(InjectorLike injectorLike) {
        return new FutureFriendingCredentialPartDefinition(ImageViewDrawablePartDefinition.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), TextPartDefinition.a(injectorLike), VisibilityPartDefinition.a(injectorLike));
    }

    public final Object m9523a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String string;
        Props props = (Props) obj;
        Drawable a = m9520a(props.f8709a.m());
        subParts.a(2131562477, this.f8713a, m9520a(props.f8709a.m()));
        subParts.a(2131562477, this.f8716d, Integer.valueOf(a == null ? 8 : 0));
        TextPartDefinition textPartDefinition = this.f8715c;
        GraphQLPeopleYouMayInviteFeedUnitContactsEdge graphQLPeopleYouMayInviteFeedUnitContactsEdge = props.f8709a;
        if (props.f8710b) {
            string = this.f8714b.getString(2131239088);
        } else {
            string = graphQLPeopleYouMayInviteFeedUnitContactsEdge.l();
        }
        subParts.a(2131562478, textPartDefinition, string);
        return null;
    }

    @Inject
    public FutureFriendingCredentialPartDefinition(ImageViewDrawablePartDefinition imageViewDrawablePartDefinition, Resources resources, TextPartDefinition textPartDefinition, VisibilityPartDefinition visibilityPartDefinition) {
        this.f8713a = imageViewDrawablePartDefinition;
        this.f8714b = resources;
        this.f8715c = textPartDefinition;
        this.f8716d = visibilityPartDefinition;
    }

    public static FutureFriendingCredentialPartDefinition m9521a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FutureFriendingCredentialPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8712f) {
                FutureFriendingCredentialPartDefinition futureFriendingCredentialPartDefinition;
                if (a2 != null) {
                    futureFriendingCredentialPartDefinition = (FutureFriendingCredentialPartDefinition) a2.a(f8712f);
                } else {
                    futureFriendingCredentialPartDefinition = f8711e;
                }
                if (futureFriendingCredentialPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9522b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8712f, b3);
                        } else {
                            f8711e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = futureFriendingCredentialPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Nullable
    private Drawable m9520a(GraphQLContactPoint graphQLContactPoint) {
        if (graphQLContactPoint == null || graphQLContactPoint.j() == null) {
            return null;
        }
        switch (graphQLContactPoint.j().g()) {
            case -906611496:
                return this.f8714b.getDrawable(2130839845);
            case 474898999:
                return this.f8714b.getDrawable(2130839993);
            default:
                return null;
        }
    }
}
