package com.facebook.feed.rows.sections;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.GraphQLTextWithEntities;
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

@ContextScoped
/* compiled from: \\u([0-9A-Fa-f]{4}) */
public class SubStoriesSubtitlePartDefinition<E extends AnyEnvironment> extends BaseSinglePartDefinition<GraphQLStoryAttachment, CharSequence, E, TextView> {
    private static SubStoriesSubtitlePartDefinition f20462a;
    private static final Object f20463b = new Object();

    private static SubStoriesSubtitlePartDefinition m23546a() {
        return new SubStoriesSubtitlePartDefinition();
    }

    public final Object m23548a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object obj2;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) obj;
        if (graphQLStoryAttachment.z() == null || graphQLStoryAttachment.z().j() == null || graphQLStoryAttachment.z().j().g() != -1072845520) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        if (obj2 != null) {
            GraphQLTextWithEntities hv = graphQLStoryAttachment.z().hv() != null ? graphQLStoryAttachment.z().hv() : graphQLStoryAttachment.z().cY();
            if (!(hv == null || StringUtil.a(hv.a()))) {
                return hv.a();
            }
        }
        return GraphQLStoryAttachmentUtil.r(graphQLStoryAttachment) != null ? GraphQLStoryAttachmentUtil.r(graphQLStoryAttachment).a() : "";
    }

    public final /* bridge */ /* synthetic */ void m23549a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1740591754);
        CharSequence charSequence = (CharSequence) obj2;
        TextView textView = (TextView) view;
        textView.setVisibility(!TextUtils.isEmpty(charSequence) ? 0 : 8);
        textView.setText(charSequence);
        Logger.a(8, EntryType.MARK_POP, 1190188597, a);
    }

    public static SubStoriesSubtitlePartDefinition m23547a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SubStoriesSubtitlePartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f20463b) {
                SubStoriesSubtitlePartDefinition subStoriesSubtitlePartDefinition;
                if (a3 != null) {
                    subStoriesSubtitlePartDefinition = (SubStoriesSubtitlePartDefinition) a3.a(f20463b);
                } else {
                    subStoriesSubtitlePartDefinition = f20462a;
                }
                if (subStoriesSubtitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m23546a();
                        if (a3 != null) {
                            a3.a(f20463b, a2);
                        } else {
                            f20462a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = subStoriesSubtitlePartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
