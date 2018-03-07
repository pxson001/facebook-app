package com.facebook.timeline.protiles.rows;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.enums.GraphQLProfileTileSectionType;
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
import com.facebook.timeline.protiles.events.ProtilesActionEvent;
import com.facebook.timeline.protiles.events.ProtilesActionEvent.Type;
import com.facebook.timeline.protiles.model.ProtileModel;
import com.facebook.timeline.protiles.util.TimelineCollapsedProtilesExperimentHelper;
import com.facebook.timeline.protiles.views.ProtilesFooterView;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: featured_containers_limit */
public class ProtilesFooterPartDefinition extends MultiRowSinglePartDefinition<ProtileModel, CharSequence, AnyEnvironment, ProtilesFooterView> {
    public static final ViewType f12188a = new C17351();
    private static ProtilesFooterPartDefinition f12189f;
    private static final Object f12190g = new Object();
    public final EventsStream f12191b;
    private final ClickListenerPartDefinition f12192c;
    private final TextPartDefinition f12193d;
    private final TimelineCollapsedProtilesExperimentHelper f12194e;

    /* compiled from: featured_containers_limit */
    final class C17351 extends ViewType {
        C17351() {
        }

        public final View m12285a(Context context) {
            return new ProtilesFooterView(context);
        }
    }

    private static ProtilesFooterPartDefinition m12287b(InjectorLike injectorLike) {
        return new ProtilesFooterPartDefinition(EventsStream.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), TimelineCollapsedProtilesExperimentHelper.m12438a(injectorLike));
    }

    public final Object m12289a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final ProtileModel protileModel = (ProtileModel) obj;
        String f = protileModel.m12113f();
        subParts.a(2131566436, this.f12193d, f);
        subParts.a(this.f12192c, new OnClickListener(this) {
            final /* synthetic */ ProtilesFooterPartDefinition f12187b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 451911141);
                this.f12187b.f12191b.a(new ProtilesActionEvent(Type.CLICK_FOOTER, protileModel));
                Logger.a(2, EntryType.UI_INPUT_END, 215809477, a);
            }
        });
        return f;
    }

    public final /* bridge */ /* synthetic */ void m12290a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        boolean z;
        int a = Logger.a(8, EntryType.MARK_PUSH, 1650800800);
        CharSequence charSequence = (CharSequence) obj2;
        ProtilesFooterView protilesFooterView = (ProtilesFooterView) view;
        int i = 0;
        if (((ProtileModel) obj).m12109b() == GraphQLProfileTileSectionType.FRIENDS) {
            z = true;
        } else {
            z = false;
        }
        protilesFooterView.f12403d = z;
        if (charSequence == null) {
            i = 8;
        }
        protilesFooterView.f12404e.setVisibility(i);
        Logger.a(8, EntryType.MARK_POP, -1109976379, a);
    }

    public final boolean m12291a(Object obj) {
        ProtileModel protileModel = (ProtileModel) obj;
        return (protileModel == null || protileModel.f12107c.isEmpty() || Strings.isNullOrEmpty(protileModel.m12113f()) || this.f12194e.m12444a(protileModel)) ? false : true;
    }

    @Inject
    public ProtilesFooterPartDefinition(EventsStream eventsStream, ClickListenerPartDefinition clickListenerPartDefinition, TextPartDefinition textPartDefinition, TimelineCollapsedProtilesExperimentHelper timelineCollapsedProtilesExperimentHelper) {
        this.f12191b = eventsStream;
        this.f12192c = clickListenerPartDefinition;
        this.f12193d = textPartDefinition;
        this.f12194e = timelineCollapsedProtilesExperimentHelper;
    }

    public static ProtilesFooterPartDefinition m12286a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProtilesFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12190g) {
                ProtilesFooterPartDefinition protilesFooterPartDefinition;
                if (a2 != null) {
                    protilesFooterPartDefinition = (ProtilesFooterPartDefinition) a2.a(f12190g);
                } else {
                    protilesFooterPartDefinition = f12189f;
                }
                if (protilesFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12287b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12190g, b3);
                        } else {
                            f12189f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = protilesFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m12288a() {
        return f12188a;
    }
}
