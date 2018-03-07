package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feed.rows.views.ContentTextView;
import com.facebook.graphql.model.GraphQLStoryAttachment;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: [F)V */
public class CenteredTextPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment, ContentTextView> {
    public static final ViewType f20548a = new C17671();
    private static CenteredTextPartDefinition f20549c;
    private static final Object f20550d = new Object();
    private final BackgroundPartDefinition f20551b;

    /* compiled from: [F)V */
    final class C17671 extends ViewType {
        C17671() {
        }

        public final View m23605a(Context context) {
            return new ContentTextView(context);
        }
    }

    private static CenteredTextPartDefinition m23607b(InjectorLike injectorLike) {
        return new CenteredTextPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m23609a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        BackgroundPartDefinition backgroundPartDefinition = this.f20551b;
        FeedProps e = AttachmentProps.e(feedProps);
        Builder g = Builder.g();
        g.b = 24.0f;
        g = g;
        g.c = 24.0f;
        g = g;
        g.d = 5.0f;
        g = g;
        g.e = 5.0f;
        subParts.a(backgroundPartDefinition, new StylingData(e, g.i()));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m23610a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1554000354);
        FeedProps feedProps = (FeedProps) obj;
        ContentTextView contentTextView = (ContentTextView) view;
        contentTextView.setIncludeFontPadding(false);
        contentTextView.setGravity(17);
        contentTextView.setText(((GraphQLStoryAttachment) feedProps.a).n().a());
        Logger.a(8, EntryType.MARK_POP, 1348520274, a);
    }

    @Inject
    public CenteredTextPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f20551b = backgroundPartDefinition;
    }

    public final ViewType m23608a() {
        return f20548a;
    }

    public final boolean m23611a(Object obj) {
        return true;
    }

    public static CenteredTextPartDefinition m23606a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CenteredTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20550d) {
                CenteredTextPartDefinition centeredTextPartDefinition;
                if (a2 != null) {
                    centeredTextPartDefinition = (CenteredTextPartDefinition) a2.a(f20550d);
                } else {
                    centeredTextPartDefinition = f20549c;
                }
                if (centeredTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23607b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20550d, b3);
                        } else {
                            f20549c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = centeredTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
