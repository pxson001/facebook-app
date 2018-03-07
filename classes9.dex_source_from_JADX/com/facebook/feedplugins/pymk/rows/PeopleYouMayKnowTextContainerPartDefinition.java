package com.facebook.feedplugins.pymk.rows;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.FriendshipPersistentState;
import com.facebook.feedplugins.pymk.rows.components.PersonYouMayKnowTextHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TIMED_OUT_POST_PROCESS */
public class PeopleYouMayKnowTextContainerPartDefinition extends BaseSinglePartDefinition<Props, Void, AnyEnvironment, LinearLayout> {
    private static PeopleYouMayKnowTextContainerPartDefinition f24842d;
    private static final Object f24843e = new Object();
    private final ClickListenerPartDefinition f24844a;
    private final TextPartDefinition f24845b;
    public final PersonYouMayKnowTextHelper f24846c;

    /* compiled from: TIMED_OUT_POST_PROCESS */
    public class Props {
        public final String f24837a;
        public final String f24838b;
        public final String f24839c;
        public final String f24840d;
        public final FriendshipPersistentState f24841e;

        public Props(String str, String str2, String str3, String str4, FriendshipPersistentState friendshipPersistentState) {
            this.f24837a = str;
            this.f24838b = str2;
            this.f24839c = str3;
            this.f24840d = str4;
            this.f24841e = friendshipPersistentState;
        }
    }

    private static PeopleYouMayKnowTextContainerPartDefinition m26641b(InjectorLike injectorLike) {
        return new PeopleYouMayKnowTextContainerPartDefinition(ClickListenerPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), PersonYouMayKnowTextHelper.m26687a(injectorLike));
    }

    public final Object m26642a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(2131561962, this.f24845b, this.f24846c.m26689a(props.f24839c, props.f24841e));
        subParts.a(2131561961, this.f24845b, props.f24838b);
        ClickListenerPartDefinition clickListenerPartDefinition = this.f24844a;
        final String str = props.f24837a;
        final String str2 = props.f24840d;
        final String str3 = props.f24838b;
        subParts.a(2131561961, clickListenerPartDefinition, new OnClickListener(this) {
            final /* synthetic */ PeopleYouMayKnowTextContainerPartDefinition f24832d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1200492743);
                this.f24832d.f24846c.m26690a(str, str2, str3);
                Logger.a(2, EntryType.UI_INPUT_END, 1231243217, a);
            }
        });
        clickListenerPartDefinition = this.f24844a;
        str = props.f24837a;
        str2 = props.f24840d;
        str3 = props.f24838b;
        subParts.a(2131561962, clickListenerPartDefinition, new OnClickListener(this) {
            final /* synthetic */ PeopleYouMayKnowTextContainerPartDefinition f24836d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -637402989);
                this.f24836d.f24846c.m26690a(str, str2, str3);
                Logger.a(2, EntryType.UI_INPUT_END, -258718895, a);
            }
        });
        return null;
    }

    public static PeopleYouMayKnowTextContainerPartDefinition m26640a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayKnowTextContainerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24843e) {
                PeopleYouMayKnowTextContainerPartDefinition peopleYouMayKnowTextContainerPartDefinition;
                if (a2 != null) {
                    peopleYouMayKnowTextContainerPartDefinition = (PeopleYouMayKnowTextContainerPartDefinition) a2.a(f24843e);
                } else {
                    peopleYouMayKnowTextContainerPartDefinition = f24842d;
                }
                if (peopleYouMayKnowTextContainerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26641b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24843e, b3);
                        } else {
                            f24842d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayKnowTextContainerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PeopleYouMayKnowTextContainerPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, TextPartDefinition textPartDefinition, PersonYouMayKnowTextHelper personYouMayKnowTextHelper) {
        this.f24844a = clickListenerPartDefinition;
        this.f24845b = textPartDefinition;
        this.f24846c = personYouMayKnowTextHelper;
    }
}
