package com.facebook.feed.rows.sections.attachments.calltoaction;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.attachments.angora.actionbutton.AngoraActionButtonController;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_primary_email_address */
public class ActionButtonPartDefinition<E extends HasInvalidate, V extends View & AttachmentHasButton> extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
    private static ActionButtonPartDefinition f23961b;
    private static final Object f23962c = new Object();
    private final Lazy<AngoraActionButtonController> f23963a;

    private static ActionButtonPartDefinition m32347b(InjectorLike injectorLike) {
        return new ActionButtonPartDefinition(IdBasedLazy.m1808a(injectorLike, 318));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.mo2756a(((AngoraActionButtonController) this.f23963a.get()).m32351a(feedProps).mo3513a(), feedProps);
        return null;
    }

    @Inject
    public ActionButtonPartDefinition(Lazy<AngoraActionButtonController> lazy) {
        this.f23963a = lazy;
    }

    public static ActionButtonPartDefinition m32346a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ActionButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23962c) {
                ActionButtonPartDefinition actionButtonPartDefinition;
                if (a2 != null) {
                    actionButtonPartDefinition = (ActionButtonPartDefinition) a2.mo818a(f23962c);
                } else {
                    actionButtonPartDefinition = f23961b;
                }
                if (actionButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32347b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23962c, b3);
                        } else {
                            f23961b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = actionButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
