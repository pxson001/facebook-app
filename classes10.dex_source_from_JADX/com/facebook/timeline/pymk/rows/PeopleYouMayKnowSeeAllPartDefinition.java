package com.facebook.timeline.pymk.rows;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feedplugins.pymk.views.rows.SeeAllPeopleYouMayKnowView;
import com.facebook.friending.center.constants.FriendsCenterSource;
import com.facebook.friending.center.constants.FriendsCenterTabType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: faceweb/f?href={%s} */
public class PeopleYouMayKnowSeeAllPartDefinition extends BaseSinglePartDefinitionWithViewType<Void, Void, AnyEnvironment, SeeAllPeopleYouMayKnowView> {
    public static final ViewType<SeeAllPeopleYouMayKnowView> f12568a = new C17721();
    private static PeopleYouMayKnowSeeAllPartDefinition f12569d;
    private static final Object f12570e = new Object();
    private final ClickListenerPartDefinition f12571b;
    public final FbUriIntentHandler f12572c;

    /* compiled from: faceweb/f?href={%s} */
    final class C17721 extends ViewType<SeeAllPeopleYouMayKnowView> {
        C17721() {
        }

        public final View m12551a(Context context) {
            return new SeeAllPeopleYouMayKnowView(context, null, 1);
        }
    }

    /* compiled from: faceweb/f?href={%s} */
    public class C17732 implements OnClickListener {
        final /* synthetic */ PeopleYouMayKnowSeeAllPartDefinition f12567a;

        public C17732(PeopleYouMayKnowSeeAllPartDefinition peopleYouMayKnowSeeAllPartDefinition) {
            this.f12567a = peopleYouMayKnowSeeAllPartDefinition;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1573002326);
            this.f12567a.f12572c.a(view.getContext(), StringFormatUtil.a(FBLinks.cd, new Object[]{FriendsCenterSource.TIMELINE_PYMK.name(), FriendsCenterTabType.SUGGESTIONS.name()}));
            Logger.a(2, EntryType.UI_INPUT_END, 1488572076, a);
        }
    }

    private static PeopleYouMayKnowSeeAllPartDefinition m12553b(InjectorLike injectorLike) {
        return new PeopleYouMayKnowSeeAllPartDefinition(ClickListenerPartDefinition.a(injectorLike), FbUriIntentHandler.a(injectorLike));
    }

    @Inject
    public PeopleYouMayKnowSeeAllPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, FbUriIntentHandler fbUriIntentHandler) {
        this.f12571b = clickListenerPartDefinition;
        this.f12572c = fbUriIntentHandler;
    }

    public final ViewType<SeeAllPeopleYouMayKnowView> m12554a() {
        return f12568a;
    }

    public final Object m12555a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(2131566455, this.f12571b, new C17732(this));
        return null;
    }

    public static PeopleYouMayKnowSeeAllPartDefinition m12552a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayKnowSeeAllPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12570e) {
                PeopleYouMayKnowSeeAllPartDefinition peopleYouMayKnowSeeAllPartDefinition;
                if (a2 != null) {
                    peopleYouMayKnowSeeAllPartDefinition = (PeopleYouMayKnowSeeAllPartDefinition) a2.a(f12570e);
                } else {
                    peopleYouMayKnowSeeAllPartDefinition = f12569d;
                }
                if (peopleYouMayKnowSeeAllPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12553b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12570e, b3);
                        } else {
                            f12569d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayKnowSeeAllPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
