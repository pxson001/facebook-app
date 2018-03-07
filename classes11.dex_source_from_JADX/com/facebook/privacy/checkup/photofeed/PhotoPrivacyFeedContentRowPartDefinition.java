package com.facebook.privacy.checkup.photofeed;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckupInterfaces.MediaMetadataWithCreatorPrivacyOptions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: SpotifySaveSongMutation */
public class PhotoPrivacyFeedContentRowPartDefinition extends MultiRowSinglePartDefinition<MediaMetadataWithCreatorPrivacyOptions, Void, PhotoPrivacyFeedEnvironment, View> {
    public static final ViewType f11023a = ViewType.a(2130906202);
    private static final CallerContext f11024b = CallerContext.a(PhotoPrivacyFeedContentRowPartDefinition.class);
    private static final PaddingStyle f11025c;
    private static PhotoPrivacyFeedContentRowPartDefinition f11026j;
    private static final Object f11027k = new Object();
    private final Resources f11028d;
    private final DefaultTimeFormatUtil f11029e;
    private final BackgroundPartDefinition f11030f;
    private final FbDraweePartDefinition f11031g;
    private final TextPartDefinition f11032h;
    private final PhotoAudienceSpinnerPartDefinition f11033i;

    private static PhotoPrivacyFeedContentRowPartDefinition m11429b(InjectorLike injectorLike) {
        return new PhotoPrivacyFeedContentRowPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), DefaultTimeFormatUtil.a(injectorLike), BackgroundPartDefinition.a(injectorLike), FbDraweePartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), PhotoAudienceSpinnerPartDefinition.m11420a(injectorLike));
    }

    public final Object m11431a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PointF pointF;
        MediaMetadataWithCreatorPrivacyOptions mediaMetadataWithCreatorPrivacyOptions = (MediaMetadataWithCreatorPrivacyOptions) obj;
        subParts.a(this.f11030f, new StylingData(null, f11025c, 2130842605, -1));
        int dimensionPixelSize = this.f11028d.getDimensionPixelSize(2131434459);
        FbDraweePartDefinition fbDraweePartDefinition = this.f11031g;
        Builder a = new Builder().a(mediaMetadataWithCreatorPrivacyOptions.bd_().b());
        a.c = f11024b;
        a = a;
        if (mediaMetadataWithCreatorPrivacyOptions.c() != null) {
            DefaultVect2Fields c = mediaMetadataWithCreatorPrivacyOptions.c();
            pointF = new PointF((float) c.a(), (float) c.b());
        } else {
            pointF = PhotoPrivacyFeedHelper.f11048a;
        }
        a.g = pointF;
        Builder a2 = a.a(dimensionPixelSize, dimensionPixelSize);
        a2.f = true;
        subParts.a(2131565913, fbDraweePartDefinition, a2.a());
        subParts.a(2131565915, this.f11032h, m11428a(mediaMetadataWithCreatorPrivacyOptions.j()));
        subParts.a(2131565914, this.f11033i, mediaMetadataWithCreatorPrivacyOptions);
        return null;
    }

    public final boolean m11432a(Object obj) {
        MediaMetadataWithCreatorPrivacyOptions mediaMetadataWithCreatorPrivacyOptions = (MediaMetadataWithCreatorPrivacyOptions) obj;
        return (mediaMetadataWithCreatorPrivacyOptions == null || mediaMetadataWithCreatorPrivacyOptions.be_() == null) ? false : true;
    }

    static {
        PaddingStyle.Builder a = PaddingStyle.Builder.a();
        a.b = 6.0f;
        a = a;
        a.c = 6.0f;
        a = a;
        a.d = 4.0f;
        a = a;
        a.e = 4.0f;
        f11025c = a.i();
    }

    @Inject
    public PhotoPrivacyFeedContentRowPartDefinition(Resources resources, DefaultTimeFormatUtil defaultTimeFormatUtil, BackgroundPartDefinition backgroundPartDefinition, FbDraweePartDefinition fbDraweePartDefinition, TextPartDefinition textPartDefinition, PhotoAudienceSpinnerPartDefinition photoAudienceSpinnerPartDefinition) {
        this.f11028d = resources;
        this.f11029e = defaultTimeFormatUtil;
        this.f11030f = backgroundPartDefinition;
        this.f11031g = fbDraweePartDefinition;
        this.f11032h = textPartDefinition;
        this.f11033i = photoAudienceSpinnerPartDefinition;
    }

    public static PhotoPrivacyFeedContentRowPartDefinition m11427a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotoPrivacyFeedContentRowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11027k) {
                PhotoPrivacyFeedContentRowPartDefinition photoPrivacyFeedContentRowPartDefinition;
                if (a2 != null) {
                    photoPrivacyFeedContentRowPartDefinition = (PhotoPrivacyFeedContentRowPartDefinition) a2.a(f11027k);
                } else {
                    photoPrivacyFeedContentRowPartDefinition = f11026j;
                }
                if (photoPrivacyFeedContentRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11429b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11027k, b3);
                        } else {
                            f11026j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photoPrivacyFeedContentRowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m11430a() {
        return f11023a;
    }

    private String m11428a(long j) {
        String a = this.f11029e.a(TimeFormatStyle.MONTH_DAY_YEAR_STYLE, 1000 * j);
        return this.f11028d.getString(2131242318, new Object[]{a});
    }
}
