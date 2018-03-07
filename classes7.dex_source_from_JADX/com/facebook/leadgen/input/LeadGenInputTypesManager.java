package com.facebook.leadgen.input;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLLeadGenInfoFieldInputType;
import com.facebook.graphql.model.GraphQLLeadGenInfoFieldData;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.leadgen.input.LeadGenFieldInput.ViewType;

@ContextScoped
/* compiled from: photos_feed_scroll_perf */
public class LeadGenInputTypesManager {
    private static LeadGenInputTypesManager f6402a;
    private static final Object f6403b = new Object();

    /* compiled from: photos_feed_scroll_perf */
    public /* synthetic */ class C05841 {
        public static final /* synthetic */ int[] f6401a = new int[GraphQLLeadGenInfoFieldInputType.values().length];

        static {
            try {
                f6401a[GraphQLLeadGenInfoFieldInputType.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6401a[GraphQLLeadGenInfoFieldInputType.INLINE_SELECT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6401a[GraphQLLeadGenInfoFieldInputType.SELECT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6401a[GraphQLLeadGenInfoFieldInputType.MESSENGER_CHECKBOX.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private static LeadGenInputTypesManager m8238a() {
        return new LeadGenInputTypesManager();
    }

    public static View m8237a(ViewGroup viewGroup, GraphQLLeadGenInfoFieldData graphQLLeadGenInfoFieldData) {
        ViewType viewType;
        GraphQLLeadGenInfoFieldInputType l = graphQLLeadGenInfoFieldData.l();
        boolean n = graphQLLeadGenInfoFieldData.n();
        switch (C05841.f6401a[l.ordinal()]) {
            case 1:
                if (!n) {
                    viewType = LeadGenNonEditableTextInputView.f6404a;
                    break;
                }
                viewType = LeadGenTextInputView.f6429a;
                break;
            case 2:
                viewType = LeadGenInlineSelectInputView.f6392a;
                break;
            case 3:
                viewType = LeadGenSpinnerSelectInputView.f6416a;
                break;
            case 4:
                viewType = LeadGenCheckBoxInputView.f6383a;
                break;
            default:
                viewType = LeadGenTextInputView.f6429a;
                break;
        }
        return viewType.mo350a(viewGroup.getContext());
    }

    public static LeadGenInputTypesManager m8239a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LeadGenInputTypesManager a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f6403b) {
                LeadGenInputTypesManager leadGenInputTypesManager;
                if (a3 != null) {
                    leadGenInputTypesManager = (LeadGenInputTypesManager) a3.a(f6403b);
                } else {
                    leadGenInputTypesManager = f6402a;
                }
                if (leadGenInputTypesManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m8238a();
                        if (a3 != null) {
                            a3.a(f6403b, a2);
                        } else {
                            f6402a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = leadGenInputTypesManager;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
