package com.facebook.feedplugins.pymi.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feedplugins.pymi.logging.PeopleYouMayInviteLogger;
import com.facebook.feedplugins.pymi.views.PymiInviteMoreView;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: now */
public class PeopleYouMayInviteMorePartDefinition extends BaseSinglePartDefinitionWithViewType<Void, Void, AnyEnvironment, PymiInviteMoreView> {
    public static final ViewType<PymiInviteMoreView> f6685a = new C03071();
    private static PeopleYouMayInviteMorePartDefinition f6686e;
    private static final Object f6687f = new Object();
    private final ClickListenerPartDefinition f6688b;
    public final FbUriIntentHandler f6689c;
    public final PeopleYouMayInviteLogger f6690d;

    /* compiled from: now */
    final class C03071 extends ViewType<PymiInviteMoreView> {
        C03071() {
        }

        public final View m7086a(Context context) {
            return new PymiInviteMoreView(context);
        }
    }

    private static PeopleYouMayInviteMorePartDefinition m7083b(InjectorLike injectorLike) {
        return new PeopleYouMayInviteMorePartDefinition(ClickListenerPartDefinition.a(injectorLike), FbUriIntentHandler.a(injectorLike), PeopleYouMayInviteLogger.a(injectorLike));
    }

    @Inject
    public PeopleYouMayInviteMorePartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, FbUriIntentHandler fbUriIntentHandler, PeopleYouMayInviteLogger peopleYouMayInviteLogger) {
        this.f6688b = clickListenerPartDefinition;
        this.f6689c = fbUriIntentHandler;
        this.f6690d = peopleYouMayInviteLogger;
    }

    public final ViewType<PymiInviteMoreView> m7084a() {
        return f6685a;
    }

    public final Object m7085a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(2131566453, this.f6688b, new 2(this));
        return null;
    }

    public static PeopleYouMayInviteMorePartDefinition m7082a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayInviteMorePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6687f) {
                PeopleYouMayInviteMorePartDefinition peopleYouMayInviteMorePartDefinition;
                if (a2 != null) {
                    peopleYouMayInviteMorePartDefinition = (PeopleYouMayInviteMorePartDefinition) a2.a(f6687f);
                } else {
                    peopleYouMayInviteMorePartDefinition = f6686e;
                }
                if (peopleYouMayInviteMorePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7083b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6687f, b3);
                        } else {
                            f6686e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayInviteMorePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
