package com.facebook.feed.rows.sections.common.unknown;

import android.content.Context;
import android.view.View;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.sections.common.unknown.ui.UnknownFeedUnitView;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLUnknownFeedUnit;
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
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;

@ContextScoped
/* compiled from: message_capping_keyboard_guard_click */
public class UnknownFeedUnitPartDefinition extends MultiRowSinglePartDefinition<Object, String, AnyEnvironment, UnknownFeedUnitView> {
    public static final ViewType f10409a = new C06311();
    private static final String f10410b = UnknownFeedUnitPartDefinition.class.getName();
    private static UnknownFeedUnitPartDefinition f10411e;
    private static final Object f10412f = new Object();
    private final ObjectMapper f10413c;
    private final AbstractFbErrorReporter f10414d;

    /* compiled from: message_capping_keyboard_guard_click */
    final class C06311 extends ViewType {
        C06311() {
        }

        public final View m16589a(Context context) {
            return new UnknownFeedUnitView(context);
        }
    }

    private static UnknownFeedUnitPartDefinition m16592b(InjectorLike injectorLike) {
        return new UnknownFeedUnitPartDefinition((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m16596a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -390672210);
        ((UnknownFeedUnitView) view).f10415a.setText((String) obj2);
        Logger.a(8, EntryType.MARK_POP, 2007631599, a);
    }

    @Inject
    public UnknownFeedUnitPartDefinition(ObjectMapper objectMapper, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f10413c = objectMapper;
        this.f10414d = abstractFbErrorReporter;
    }

    public final ViewType m16594a() {
        return f10409a;
    }

    public static UnknownFeedUnitPartDefinition m16590a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            UnknownFeedUnitPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10412f) {
                UnknownFeedUnitPartDefinition unknownFeedUnitPartDefinition;
                if (a2 != null) {
                    unknownFeedUnitPartDefinition = (UnknownFeedUnitPartDefinition) a2.a(f10412f);
                } else {
                    unknownFeedUnitPartDefinition = f10411e;
                }
                if (unknownFeedUnitPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m16592b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10412f, b3);
                        } else {
                            f10411e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = unknownFeedUnitPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Object m16595a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return m16593c(obj);
    }

    private String m16593c(Object obj) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Beta only: unknown data object type: ");
        stringBuilder.append(obj == null ? "null" : obj.getClass().getName());
        stringBuilder.append(". ");
        if (obj instanceof GraphQLFeedUnitEdge) {
            FeedUnit c = ((GraphQLFeedUnitEdge) obj).c();
            if (c instanceof GraphQLUnknownFeedUnit) {
                stringBuilder.append("New FeedUnit type: ");
                stringBuilder.append(c.getType().e());
                stringBuilder.append(". ");
            }
            m16591a(obj, c, stringBuilder);
        }
        return stringBuilder.toString();
    }

    private void m16591a(Object obj, FeedUnit feedUnit, StringBuilder stringBuilder) {
        stringBuilder.append("JSON: ");
        try {
            stringBuilder.append(this.f10413c.a(obj));
        } catch (Throwable e) {
            this.f10414d.a(f10410b, StringFormatUtil.formatStrLocaleSafe("Failing to serialize FeedUnit of type %s", feedUnit.getType()), e);
        }
    }

    public final boolean m16597a(Object obj) {
        return BuildConstants.i;
    }
}
