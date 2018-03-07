package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.fbui.textcachewarmer.FbTextLayoutCacheWarmer;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.sections.text.ContentTextLayoutBasePartDefinition;
import com.facebook.feed.rows.sections.text.TextLayoutBuilderUtil;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.views.AccessibleTextLayoutView;
import com.facebook.graphql.querybuilder.convertible.DefaultGraphQLConversionHelper;
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
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import javax.inject.Inject;

@ContextScoped
/* compiled from: accepted */
public class PhotosFeedAttachmentTextPartDefinition extends MultiRowSinglePartDefinition<MediaMetadata, Layout, HasPositionInformation, AccessibleTextLayoutView> {
    private static PhotosFeedAttachmentTextPartDefinition f20137f;
    private static final Object f20138g = new Object();
    private final BackgroundPartDefinition f20139a;
    private final TextLayoutBuilder f20140b;
    private final AbstractFbErrorReporter f20141c;
    private final TextLayoutBuilderUtil f20142d;
    private final PhotosFeedAttachmentTextBuilder f20143e;

    private static PhotosFeedAttachmentTextPartDefinition m23293b(InjectorLike injectorLike) {
        return new PhotosFeedAttachmentTextPartDefinition(BackgroundPartDefinition.a(injectorLike), FbTextLayoutCacheWarmer.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (Context) injectorLike.getInstance(Context.class), TextLayoutBuilderUtil.a(injectorLike), PhotosFeedAttachmentTextBuilder.m23289a(injectorLike));
    }

    public final Object m23295a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        subParts.a(this.f20139a, new StylingData(null, PaddingStyle.e));
        CharSequence a = this.f20143e.m23291a(DefaultGraphQLConversionHelper.m5800a(mediaMetadata.M()), (int) this.f20140b.b());
        this.f20142d.a(this.f20140b, null);
        try {
            this.f20140b.a(a);
        } catch (Throwable e) {
            this.f20141c.a(SoftError.a("PhotosFeedAttachmentTextPartDefinition", StringLocaleUtil.a("JellyBean setText bug with MediaMetadata ID: %s", new Object[]{mediaMetadata.d()})).a(e).g());
            this.f20140b.a(a.toString());
        }
        return this.f20140b.d();
    }

    public final /* bridge */ /* synthetic */ void m23296a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -956049291);
        ((AccessibleTextLayoutView) view).setTextLayout((Layout) obj2);
        Logger.a(8, EntryType.MARK_POP, -2082672999, a);
    }

    public final boolean m23297a(Object obj) {
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        return (mediaMetadata == null || mediaMetadata.M() == null) ? false : true;
    }

    @Inject
    public PhotosFeedAttachmentTextPartDefinition(BackgroundPartDefinition backgroundPartDefinition, FbTextLayoutCacheWarmer fbTextLayoutCacheWarmer, AbstractFbErrorReporter abstractFbErrorReporter, Context context, TextLayoutBuilderUtil textLayoutBuilderUtil, PhotosFeedAttachmentTextBuilder photosFeedAttachmentTextBuilder) {
        this.f20141c = abstractFbErrorReporter;
        this.f20142d = textLayoutBuilderUtil;
        this.f20139a = backgroundPartDefinition;
        this.f20143e = photosFeedAttachmentTextBuilder;
        this.f20140b = TextLayoutBuilderUtil.a(context, fbTextLayoutCacheWarmer);
    }

    public static PhotosFeedAttachmentTextPartDefinition m23292a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedAttachmentTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20138g) {
                PhotosFeedAttachmentTextPartDefinition photosFeedAttachmentTextPartDefinition;
                if (a2 != null) {
                    photosFeedAttachmentTextPartDefinition = (PhotosFeedAttachmentTextPartDefinition) a2.a(f20138g);
                } else {
                    photosFeedAttachmentTextPartDefinition = f20137f;
                }
                if (photosFeedAttachmentTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23293b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20138g, b3);
                        } else {
                            f20137f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedAttachmentTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23294a() {
        return ContentTextLayoutBasePartDefinition.a;
    }
}
