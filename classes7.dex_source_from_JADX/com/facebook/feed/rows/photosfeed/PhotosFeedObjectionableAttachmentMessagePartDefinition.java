package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLStory;
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
import com.facebook.photos.data.protocol.PhotosMetadataConversionHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.warning.ObjectionableContentController;
import com.facebook.resources.ui.FbTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: a238ba6b2e5670eccb3a104fa9673c2e */
public class PhotosFeedObjectionableAttachmentMessagePartDefinition<E extends HasPositionInformation & HasInvalidate> extends MultiRowSinglePartDefinition<MediaMetadata, Void, E, View> {
    public static final ViewType f20270a = new C17541();
    private static final PaddingStyle f20271b = PaddingStyle.e;
    private static PhotosFeedObjectionableAttachmentMessagePartDefinition f20272g;
    private static final Object f20273h = new Object();
    public final ObjectionableContentController f20274c;
    private final BackgroundPartDefinition f20275d;
    private final TextPartDefinition f20276e;
    public final Context f20277f;

    /* compiled from: a238ba6b2e5670eccb3a104fa9673c2e */
    final class C17541 extends ViewType {
        C17541() {
        }

        public final View m23397a(Context context) {
            View inflate = LayoutInflater.from(context).inflate(2130905523, null);
            ((FbTextView) inflate.findViewById(2131564314)).setMovementMethod(LinkMovementMethod.getInstance());
            return inflate;
        }
    }

    private static PhotosFeedObjectionableAttachmentMessagePartDefinition m23399b(InjectorLike injectorLike) {
        return new PhotosFeedObjectionableAttachmentMessagePartDefinition(ObjectionableContentController.a(injectorLike), BackgroundPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public final Object m23401a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final MediaMetadata mediaMetadata = (MediaMetadata) obj;
        final HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        subParts.a(this.f20275d, new StylingData(null, f20271b));
        Resources resources = this.f20277f.getResources();
        C17552 c17552 = new ClickableSpan(this) {
            final /* synthetic */ PhotosFeedObjectionableAttachmentMessagePartDefinition f20269c;

            public void onClick(View view) {
                GraphQLStory a = PhotosMetadataConversionHelper.a(mediaMetadata.z());
                this.f20269c.f20274c.b(mediaMetadata.d());
                ((HasInvalidate) hasPositionInformation).a(new FeedProps[]{FeedProps.c(a)});
            }

            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
                textPaint.setColor(ContextCompat.b(this.f20269c.f20277f, 2131361924));
            }
        };
        CharSequence string = resources.getString(2131238517);
        subParts.a(2131564314, this.f20276e, new StyledStringBuilder(resources).a(string).a("link_hide_photo", resources.getString(2131238518), c17552, 33).b());
        return null;
    }

    public final boolean m23402a(Object obj) {
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        return mediaMetadata.T() && this.f20274c.c(mediaMetadata.d());
    }

    public static PhotosFeedObjectionableAttachmentMessagePartDefinition m23398a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedObjectionableAttachmentMessagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20273h) {
                PhotosFeedObjectionableAttachmentMessagePartDefinition photosFeedObjectionableAttachmentMessagePartDefinition;
                if (a2 != null) {
                    photosFeedObjectionableAttachmentMessagePartDefinition = (PhotosFeedObjectionableAttachmentMessagePartDefinition) a2.a(f20273h);
                } else {
                    photosFeedObjectionableAttachmentMessagePartDefinition = f20272g;
                }
                if (photosFeedObjectionableAttachmentMessagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23399b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20273h, b3);
                        } else {
                            f20272g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedObjectionableAttachmentMessagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PhotosFeedObjectionableAttachmentMessagePartDefinition(ObjectionableContentController objectionableContentController, BackgroundPartDefinition backgroundPartDefinition, TextPartDefinition textPartDefinition, Context context) {
        this.f20274c = objectionableContentController;
        this.f20275d = backgroundPartDefinition;
        this.f20276e = textPartDefinition;
        this.f20277f = context;
    }

    public final ViewType m23400a() {
        return f20270a;
    }
}
