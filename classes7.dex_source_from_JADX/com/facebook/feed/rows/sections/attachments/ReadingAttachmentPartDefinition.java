package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.abtest.ExperimentsForMultipleRowsStoriesAbtestModule;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition.Props;
import com.facebook.feed.rows.sections.attachments.calltoaction.ActionButtonPartDefinition;
import com.facebook.feed.rows.sections.attachments.ui.ReadingAttachmentView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: YESTERDAY */
public class ReadingAttachmentPartDefinition<E extends HasInvalidate & HasPersistentState & HasPositionInformation & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, ReadingAttachmentView> {
    public static final ViewType f20750a = new C17761();
    private static final CallerContext f20751b = CallerContext.a(ReadingAttachmentPartDefinition.class);
    private static ReadingAttachmentPartDefinition f20752i;
    private static final Object f20753j = new Object();
    private final FbDraweeControllerBuilder f20754c;
    private final Resources f20755d;
    private final BackgroundPartDefinition f20756e;
    private final QeAccessor f20757f;
    private final ActionButtonPartDefinition<E, ReadingAttachmentView> f20758g;
    private final AttachmentLinkPartDefinition<E> f20759h;

    /* compiled from: YESTERDAY */
    final class C17761 extends ViewType {
        C17761() {
        }

        public final View m23732a(Context context) {
            return new ReadingAttachmentView(context);
        }
    }

    /* compiled from: YESTERDAY */
    public class State {
        public final DraweeController f20747a;
        public final CharSequence f20748b;
        public final CharSequence f20749c;

        public State(DraweeController draweeController, CharSequence charSequence, CharSequence charSequence2) {
            this.f20747a = draweeController;
            this.f20748b = charSequence;
            this.f20749c = charSequence2;
        }
    }

    private static ReadingAttachmentPartDefinition m23735b(InjectorLike injectorLike) {
        return new ReadingAttachmentPartDefinition(FbDraweeControllerBuilder.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), BackgroundPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), ActionButtonPartDefinition.a(injectorLike), AttachmentLinkPartDefinition.a(injectorLike));
    }

    public final Object m23737a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        CharSequence charSequence;
        DraweeController s;
        FeedProps feedProps = (FeedProps) obj;
        HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        String str = null;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        subParts.a(this.f20756e, new StylingData(AttachmentProps.e(feedProps), PaddingStyle.b));
        subParts.a(this.f20758g, feedProps);
        subParts.a(this.f20759h, new Props(feedProps));
        if (graphQLStoryAttachment.z() != null) {
            int a = (graphQLStoryAttachment.z() == null || graphQLStoryAttachment.z().fd() == null) ? 0 : graphQLStoryAttachment.z().fd().a();
            String quantityString = a == 0 ? null : this.f20755d.getQuantityString(2131689535, a, new Object[]{Integer.valueOf(a)});
            if (graphQLStoryAttachment.z().gv() != null) {
                charSequence = quantityString;
                s = this.f20754c.a(f20751b).b(Uri.parse(graphQLStoryAttachment.z().gv().b())).s();
            } else {
                Object obj2 = quantityString;
                s = null;
            }
        } else {
            s = null;
            charSequence = null;
        }
        String A = graphQLStoryAttachment.A();
        if (graphQLStoryAttachment.z() != null) {
            str = graphQLStoryAttachment.z().ae();
        }
        return new State(s, m23734a(A, str, GraphQLStoryAttachmentUtil.s(graphQLStoryAttachment), ((HasContext) hasInvalidate).getContext()), charSequence);
    }

    public final void m23740b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ReadingAttachmentView readingAttachmentView = (ReadingAttachmentView) view;
        readingAttachmentView.setSideImageController(null);
        readingAttachmentView.setText(null);
        readingAttachmentView.setLikesCountText(null);
        readingAttachmentView.m23967a();
    }

    public static ReadingAttachmentPartDefinition m23733a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReadingAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20753j) {
                ReadingAttachmentPartDefinition readingAttachmentPartDefinition;
                if (a2 != null) {
                    readingAttachmentPartDefinition = (ReadingAttachmentPartDefinition) a2.a(f20753j);
                } else {
                    readingAttachmentPartDefinition = f20752i;
                }
                if (readingAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23735b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20753j, b3);
                        } else {
                            f20752i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = readingAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReadingAttachmentPartDefinition(FbDraweeControllerBuilder fbDraweeControllerBuilder, Resources resources, BackgroundPartDefinition backgroundPartDefinition, QeAccessor qeAccessor, ActionButtonPartDefinition actionButtonPartDefinition, AttachmentLinkPartDefinition attachmentLinkPartDefinition) {
        this.f20754c = fbDraweeControllerBuilder;
        this.f20755d = resources;
        this.f20756e = backgroundPartDefinition;
        this.f20758g = actionButtonPartDefinition;
        this.f20757f = qeAccessor;
        this.f20759h = attachmentLinkPartDefinition;
    }

    public final ViewType m23736a() {
        return f20750a;
    }

    public final boolean m23739a(Object obj) {
        return this.f20757f.a(ExperimentsForMultipleRowsStoriesAbtestModule.l, false);
    }

    private static CharSequence m23734a(@Nullable String str, @Nullable String str2, @Nullable String str3, Context context) {
        int i = 0;
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        if (!Strings.isNullOrEmpty(str)) {
            spannableStringBuilder.append(str + "\n");
            spannableStringBuilder.setSpan(new TextAppearanceSpan(context, 2131625546), 0, spannableStringBuilder.length(), 33);
            i = spannableStringBuilder.length();
            spannableStringBuilder.append("\n");
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(1, true), i, spannableStringBuilder.length(), 33);
            i = spannableStringBuilder.length();
        }
        if (!Strings.isNullOrEmpty(str2)) {
            spannableStringBuilder.append(str2 + "\n");
            spannableStringBuilder.setSpan(new TextAppearanceSpan(context, 2131625547), i, spannableStringBuilder.length(), 33);
            i = spannableStringBuilder.length();
        }
        if (!Strings.isNullOrEmpty(str3)) {
            spannableStringBuilder.append("\n");
            spannableStringBuilder.setSpan(new TextAppearanceSpan(context, 2131625549), i, spannableStringBuilder.length(), 33);
            i = spannableStringBuilder.length();
            spannableStringBuilder.append(str3);
            spannableStringBuilder.setSpan(new TextAppearanceSpan(context, 2131625548), i, spannableStringBuilder.length(), 33);
        }
        return spannableStringBuilder;
    }
}
