package com.facebook.redspace.rows.sharedactivities;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.support.annotation.StyleRes;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.fig.common.ViewUtils;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.LinkableTextWithEntities;
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
import com.facebook.ultralight.Inject;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;

@ContextScoped
/* compiled from: PROMOTION */
public class RedSpaceSharedActivitiesContentViewPartDefinition extends BaseSinglePartDefinition<Props, State, AnyEnvironment, ContentView> {
    public static final CallerContext f12246a = CallerContext.a(RedSpaceSharedActivitiesContentViewPartDefinition.class);
    private static RedSpaceSharedActivitiesContentViewPartDefinition f12247d;
    private static final Object f12248e = new Object();
    private final Resources f12249b;
    private final AllCapsTransformationMethod f12250c;

    /* compiled from: PROMOTION */
    public class Props {
        public CharSequence f12234a;
        public CharSequence f12235b;
        public LinkableTextWithEntities f12236c;
        public Drawable f12237d;
        public Uri f12238e;
        @StyleRes
        public int f12239f = 2131625587;
        @StyleRes
        public int f12240g = 2131625586;
        public int f12241h = -16777216;

        Props() {
        }
    }

    /* compiled from: PROMOTION */
    public class State {
        public int f12242a;
        public CharSequence f12243b;
        public Drawable f12244c;
        @ColorInt
        public int f12245d;

        State(int i, CharSequence charSequence, Drawable drawable, @ColorInt int i2) {
            this.f12242a = i;
            this.f12243b = charSequence;
            this.f12244c = drawable;
            this.f12245d = i2;
        }
    }

    private static RedSpaceSharedActivitiesContentViewPartDefinition m12697b(InjectorLike injectorLike) {
        return new RedSpaceSharedActivitiesContentViewPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), AllCapsTransformationMethod.b(injectorLike));
    }

    public final Object m12698a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        CharSequence spannableString;
        Props props = (Props) obj;
        if (props.f12234a != null) {
            spannableString = new SpannableString(this.f12250c.getTransformation(props.f12234a, null));
            spannableString.setSpan(new ForegroundColorSpan(props.f12241h), 0, spannableString.length(), 0);
        } else {
            spannableString = null;
        }
        Drawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(props.f12241h);
        return new State(this.f12249b.getDimensionPixelSize(2131430549), spannableString, shapeDrawable, this.f12249b.getColor(2131363128));
    }

    public final /* bridge */ /* synthetic */ void m12699a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -188622187);
        Props props = (Props) obj;
        State state = (State) obj2;
        ContentView contentView = (ContentView) view;
        contentView.setTitleText(state.f12243b);
        contentView.setTitleTextAppearance(props.f12240g);
        if (props.f12236c != null) {
            ((TextWithEntitiesView) contentView.getSubtitleView()).setLinkableTextWithEntities(props.f12236c);
            contentView.setContentDescription(props.f12236c.a());
        } else {
            contentView.setSubtitleText(props.f12235b);
            contentView.setContentDescription(props.f12235b);
        }
        contentView.setSubtitleTextAppearance(props.f12239f);
        FbDraweeView fbDraweeView = (FbDraweeView) contentView.f;
        if (fbDraweeView != null) {
            ViewUtils.a(fbDraweeView, state.f12244c);
            if (props.f12237d != null) {
                fbDraweeView.setImageDrawable(props.f12237d);
                fbDraweeView.setColorFilter(state.f12245d);
            } else if (props.f12238e != null) {
                fbDraweeView.a(props.f12238e, f12246a);
                fbDraweeView.setColorFilter(state.f12245d);
            } else {
                fbDraweeView.setImageDrawable(null);
            }
        }
        contentView.setThumbnailSize(state.f12242a);
        Logger.a(8, EntryType.MARK_POP, 1149431492, a);
    }

    public static RedSpaceSharedActivitiesContentViewPartDefinition m12696a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceSharedActivitiesContentViewPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12248e) {
                RedSpaceSharedActivitiesContentViewPartDefinition redSpaceSharedActivitiesContentViewPartDefinition;
                if (a2 != null) {
                    redSpaceSharedActivitiesContentViewPartDefinition = (RedSpaceSharedActivitiesContentViewPartDefinition) a2.a(f12248e);
                } else {
                    redSpaceSharedActivitiesContentViewPartDefinition = f12247d;
                }
                if (redSpaceSharedActivitiesContentViewPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12697b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12248e, b3);
                        } else {
                            f12247d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceSharedActivitiesContentViewPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    private RedSpaceSharedActivitiesContentViewPartDefinition(Resources resources, AllCapsTransformationMethod allCapsTransformationMethod) {
        this.f12249b = resources;
        this.f12250c = allCapsTransformationMethod;
    }
}
