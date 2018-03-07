package com.facebook.feed.rows.sections.attachments.calltoaction.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.facebook.attachments.angora.actionbutton.GenericActionButtonView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.GraphQLLeadGenDeepLinkUserStatus;
import com.facebook.graphql.model.GraphQLStoryActionLink;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: WATCHING_VOD */
public class LeadGenCallToActionButtonPartDefinition extends BaseSinglePartDefinition<GraphQLStoryActionLink, Void, AnyEnvironment, GenericActionButtonView> {
    private static LeadGenCallToActionButtonPartDefinition f20894e;
    private static final Object f20895f = new Object();
    private final Context f20896a;
    public String f20897b;
    public int f20898c;
    public int f20899d;

    private static LeadGenCallToActionButtonPartDefinition m23818b(InjectorLike injectorLike) {
        return new LeadGenCallToActionButtonPartDefinition((Context) injectorLike.getInstance(Context.class));
    }

    public final Object m23819a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        int i;
        GraphQLStoryActionLink graphQLStoryActionLink = (GraphQLStoryActionLink) obj;
        this.f20897b = graphQLStoryActionLink.aB();
        GraphQLLeadGenDeepLinkUserStatus O = graphQLStoryActionLink.O();
        Resources resources = this.f20896a.getResources();
        Object obj2 = (O == null || !O.j()) ? null : 1;
        this.f20898c = obj2 != null ? resources.getColor(2131361859) : resources.getColor(2131362052);
        if (obj2 != null) {
            i = 2130838052;
        } else {
            i = 0;
        }
        this.f20899d = i;
        return null;
    }

    public final /* bridge */ /* synthetic */ void m23820a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1185859926);
        GenericActionButtonView genericActionButtonView = (GenericActionButtonView) view;
        TextView textView = genericActionButtonView.a;
        textView.setText(this.f20897b);
        textView.setTextColor(this.f20898c);
        textView.setCompoundDrawablesWithIntrinsicBounds(this.f20899d, 0, 0, 0);
        genericActionButtonView.setVisibility(0);
        Logger.a(8, EntryType.MARK_POP, 368925601, a);
    }

    @Inject
    public LeadGenCallToActionButtonPartDefinition(Context context) {
        this.f20896a = context;
    }

    public static LeadGenCallToActionButtonPartDefinition m23817a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LeadGenCallToActionButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20895f) {
                LeadGenCallToActionButtonPartDefinition leadGenCallToActionButtonPartDefinition;
                if (a2 != null) {
                    leadGenCallToActionButtonPartDefinition = (LeadGenCallToActionButtonPartDefinition) a2.a(f20895f);
                } else {
                    leadGenCallToActionButtonPartDefinition = f20894e;
                }
                if (leadGenCallToActionButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23818b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20895f, b3);
                        } else {
                            f20894e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = leadGenCallToActionButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
