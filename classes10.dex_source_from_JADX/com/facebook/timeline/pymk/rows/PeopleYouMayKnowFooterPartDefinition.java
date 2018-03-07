package com.facebook.timeline.pymk.rows;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.timeline.protiles.rows.ProtilesFooterPartDefinition;
import com.facebook.timeline.protiles.views.ProtilesFooterView;
import com.facebook.timeline.pymk.PeopleYouMayKnowModel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: facewebmodal */
public class PeopleYouMayKnowFooterPartDefinition extends MultiRowSinglePartDefinition<PeopleYouMayKnowModel, Void, AnyEnvironment, ProtilesFooterView> {
    private static PeopleYouMayKnowFooterPartDefinition f12488e;
    private static final Object f12489f = new Object();
    private final ClickListenerPartDefinition f12490a;
    public final FbUriIntentHandler f12491b;
    private final TextPartDefinition f12492c;
    private final Resources f12493d;

    /* compiled from: facewebmodal */
    class C17611 implements OnClickListener {
        final /* synthetic */ PeopleYouMayKnowFooterPartDefinition f12487a;

        C17611(PeopleYouMayKnowFooterPartDefinition peopleYouMayKnowFooterPartDefinition) {
            this.f12487a = peopleYouMayKnowFooterPartDefinition;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1934135092);
            this.f12487a.f12491b.a(view.getContext(), StringFormatUtil.a(FBLinks.cd, new Object[]{FriendsCenterSource.TIMELINE_PYMK.name(), FriendsCenterTabType.SUGGESTIONS.name()}));
            Logger.a(2, EntryType.UI_INPUT_END, 435378833, a);
        }
    }

    private static PeopleYouMayKnowFooterPartDefinition m12505b(InjectorLike injectorLike) {
        return new PeopleYouMayKnowFooterPartDefinition(ClickListenerPartDefinition.a(injectorLike), FbUriIntentHandler.a(injectorLike), TextPartDefinition.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PeopleYouMayKnowFooterPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, FbUriIntentHandler fbUriIntentHandler, TextPartDefinition textPartDefinition, Resources resources) {
        this.f12490a = clickListenerPartDefinition;
        this.f12491b = fbUriIntentHandler;
        this.f12492c = textPartDefinition;
        this.f12493d = resources;
    }

    public final boolean m12508a(Object obj) {
        return true;
    }

    public final ViewType<ProtilesFooterView> m12506a() {
        return ProtilesFooterPartDefinition.f12188a;
    }

    public static PeopleYouMayKnowFooterPartDefinition m12504a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayKnowFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12489f) {
                PeopleYouMayKnowFooterPartDefinition peopleYouMayKnowFooterPartDefinition;
                if (a2 != null) {
                    peopleYouMayKnowFooterPartDefinition = (PeopleYouMayKnowFooterPartDefinition) a2.a(f12489f);
                } else {
                    peopleYouMayKnowFooterPartDefinition = f12488e;
                }
                if (peopleYouMayKnowFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12505b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12489f, b3);
                        } else {
                            f12488e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayKnowFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Object m12507a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(2131566436, this.f12492c, this.f12493d.getString(2131233250));
        subParts.a(this.f12490a, new C17611(this));
        return null;
    }
}
