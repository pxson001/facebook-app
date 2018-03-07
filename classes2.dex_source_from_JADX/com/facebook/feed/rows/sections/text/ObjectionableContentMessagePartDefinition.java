package com.facebook.feed.rows.sections.text;

import android.content.Context;
import android.content.res.Resources;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.photos.warning.ObjectionableContentController;
import com.facebook.resources.ui.FbTextView;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: init */
public class ObjectionableContentMessagePartDefinition<E extends HasInvalidate & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, View> {
    public static final ViewType f20136a = new C08161();
    private static final PaddingStyle f20137b = PaddingStyle.f13075e;
    private static ObjectionableContentMessagePartDefinition f20138g;
    private static final Object f20139h = new Object();
    public final ObjectionableContentController f20140c;
    private final BackgroundPartDefinition f20141d;
    private final TextPartDefinition f20142e;
    public final Context f20143f;

    /* compiled from: init */
    final class C08161 extends ViewType {
        C08161() {
        }

        public final View mo1995a(Context context) {
            View inflate = LayoutInflater.from(context).inflate(2130905523, null);
            ((FbTextView) inflate.findViewById(2131564314)).setMovementMethod(LinkMovementMethod.getInstance());
            return inflate;
        }
    }

    private static ObjectionableContentMessagePartDefinition m27806b(InjectorLike injectorLike) {
        return new ObjectionableContentMessagePartDefinition(ObjectionableContentController.m27812a(injectorLike), BackgroundPartDefinition.m19135a(injectorLike), TextPartDefinition.m19379a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        subParts.mo2756a(this.f20141d, new StylingData(AttachmentProps.m28715e(feedProps), f20137b));
        Resources resources = this.f20143f.getResources();
        2 2 = new 2(this, feedProps, hasInvalidate);
        CharSequence string = resources.getString(2131238517);
        subParts.mo2755a(2131564314, this.f20142e, new StyledStringBuilder(resources).a(string).a("link_hide_photo", resources.getString(2131238518), 2, 33).b());
        return null;
    }

    public final boolean m27810a(Object obj) {
        return m27807b(this, (FeedProps) obj) != null;
    }

    public static ObjectionableContentMessagePartDefinition m27805a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ObjectionableContentMessagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20139h) {
                ObjectionableContentMessagePartDefinition objectionableContentMessagePartDefinition;
                if (a2 != null) {
                    objectionableContentMessagePartDefinition = (ObjectionableContentMessagePartDefinition) a2.mo818a(f20139h);
                } else {
                    objectionableContentMessagePartDefinition = f20138g;
                }
                if (objectionableContentMessagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27806b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20139h, b3);
                        } else {
                            f20138g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = objectionableContentMessagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public ObjectionableContentMessagePartDefinition(ObjectionableContentController objectionableContentController, BackgroundPartDefinition backgroundPartDefinition, TextPartDefinition textPartDefinition, Context context) {
        this.f20140c = objectionableContentController;
        this.f20141d = backgroundPartDefinition;
        this.f20142e = textPartDefinition;
        this.f20143f = context;
    }

    public final ViewType mo2547a() {
        return f20136a;
    }

    @Nullable
    public static String m27807b(ObjectionableContentMessagePartDefinition objectionableContentMessagePartDefinition, FeedProps feedProps) {
        String c;
        GraphQLStory c2 = AttachmentProps.m28714c(feedProps);
        int i = 0;
        ImmutableList M = c2.m22327M();
        if (M != null && M.size() == 1) {
            i = GraphQLStoryAttachmentUtil.m28054c((GraphQLStoryAttachment) M.get(0));
        }
        if (i != 0) {
            if (ObjectionableContentController.m27815b(feedProps)) {
                c = c2.m22350c();
            }
            c = null;
        } else if (StoryAttachmentHelper.m28032c(c2)) {
            r0 = ((GraphQLStoryAttachment) feedProps.f13444a).m23979r();
            if (ObjectionableContentController.m27816b(r0)) {
                c = r0.m24452b();
            }
            c = null;
        } else {
            ImmutableList x = ((GraphQLStoryAttachment) feedProps.f13444a).m23985x();
            if (x != null && x.size() > 0) {
                r0 = ((GraphQLStoryAttachment) x.get(0)).m23979r();
                if (ObjectionableContentController.m27816b(r0)) {
                    c = r0.m24452b();
                }
            }
            c = null;
        }
        if (objectionableContentMessagePartDefinition.f20140c.m27826c(c)) {
            return c;
        }
        return null;
    }
}
