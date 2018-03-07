package com.facebook.attachments.photos;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import com.facebook.attachments.photos.NoCropHelper.NoCropLayoutParams;
import com.facebook.attachments.photos.PhotoAttachmentInfo.Builder;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.datasensitivity.pref.DataSensitivitySettingsPrefUtil;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.story.StoryImageSizes;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: historical_max_txns */
public class PhotoAttachmentLayoutHelper {
    private static final Rect f21021a = new Rect(0, 0, 0, 0);
    private static PhotoAttachmentLayoutHelper f21022g;
    private static final Object f21023h = new Object();
    private final Provider<StoryImageSizes> f21024b;
    private final GraphQLImageHelper f21025c;
    private final NoCropHelper f21026d;
    private final GraphQLImageChooser f21027e;
    private final DataSensitivitySettingsPrefUtil f21028f;

    private static PhotoAttachmentLayoutHelper m28744b(InjectorLike injectorLike) {
        return new PhotoAttachmentLayoutHelper(IdBasedProvider.m1811a(injectorLike, 3479), GraphQLImageHelper.m10139a(injectorLike), new NoCropHelper(), GraphQLImageChooser.m28750a(injectorLike), DataSensitivitySettingsPrefUtil.m8604a(injectorLike));
    }

    @Inject
    public PhotoAttachmentLayoutHelper(Provider<StoryImageSizes> provider, GraphQLImageHelper graphQLImageHelper, NoCropHelper noCropHelper, GraphQLImageChooser graphQLImageChooser, DataSensitivitySettingsPrefUtil dataSensitivitySettingsPrefUtil) {
        this.f21024b = provider;
        this.f21025c = graphQLImageHelper;
        this.f21026d = noCropHelper;
        this.f21027e = graphQLImageChooser;
        this.f21028f = dataSensitivitySettingsPrefUtil;
    }

    public static PointF m28739a(GraphQLMedia graphQLMedia) {
        return graphQLMedia.m24431J() != null ? new PointF((float) graphQLMedia.m24431J().mo3123a(), (float) graphQLMedia.m24431J().mo3124b()) : new PointF(0.5f, 0.5f);
    }

    public static PhotoAttachmentLayoutHelper m28742a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotoAttachmentLayoutHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21023h) {
                PhotoAttachmentLayoutHelper photoAttachmentLayoutHelper;
                if (a2 != null) {
                    photoAttachmentLayoutHelper = (PhotoAttachmentLayoutHelper) a2.mo818a(f21023h);
                } else {
                    photoAttachmentLayoutHelper = f21022g;
                }
                if (photoAttachmentLayoutHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28744b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21023h, b3);
                        } else {
                            f21022g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = photoAttachmentLayoutHelper;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final PhotoAttachmentInfo m28745a(GraphQLMedia graphQLMedia, Rect rect, int i, float f) {
        if (m28743a()) {
            return m28741a(graphQLMedia, rect, f, ((StoryImageSizes) this.f21024b.get()).f6095c / 2);
        }
        return m28741a(graphQLMedia, rect, f, ((StoryImageSizes) this.f21024b.get()).f6095c - (i * 2));
    }

    public final PhotoAttachmentInfo m28746b(GraphQLMedia graphQLMedia) {
        if (m28743a()) {
            return m28741a(graphQLMedia, f21021a, 0.0f, ((StoryImageSizes) this.f21024b.get()).f6093a);
        }
        return m28741a(graphQLMedia, f21021a, 0.0f, ((StoryImageSizes) this.f21024b.get()).f6095c);
    }

    private PhotoAttachmentInfo m28741a(GraphQLMedia graphQLMedia, Rect rect, float f, int i) {
        String aE;
        GraphQLImage a = GraphQLImageChooser.m28753a(graphQLMedia, GraphQLImageHelper.m10140a(i).intValue());
        NoCropLayoutParams a2 = m28740a(rect, f, i, a);
        GraphQLVideo aG = graphQLMedia.aG();
        Builder builder = new Builder();
        if (aG != null) {
            aE = aG.aE();
        } else {
            aE = null;
        }
        builder.f21983a = aE;
        Builder builder2 = builder;
        builder2.f21984b = a.mo2925c();
        builder2 = builder2;
        builder2.f21985c = a.mo2923a();
        builder2 = builder2;
        builder2.f21986d = a2.f21979a;
        builder2 = builder2;
        builder2.f21987e = a2.f21980b;
        builder2 = builder2;
        GraphQLMediaRequestHelper.m29770a(graphQLMedia, a, builder2);
        return builder2.m29768a();
    }

    private NoCropLayoutParams m28740a(Rect rect, float f, int i, GraphQLImage graphQLImage) {
        int c;
        int a;
        if (GraphQLHelper.m22492b(graphQLImage)) {
            float c2 = ((float) i) / ((float) graphQLImage.mo2925c());
            if (c2 == 0.0f || Float.isNaN(c2)) {
                c2 = 1.0f;
            }
            c = (int) (((float) graphQLImage.mo2925c()) * c2);
            a = (int) (c2 * ((float) graphQLImage.mo2923a()));
        } else {
            a = NoCropHelper.m28748a(i, graphQLImage.mo2925c(), graphQLImage.mo2923a(), true);
            c = i;
        }
        if (f != 0.0f) {
            a = Math.min(a, (int) (((float) c) * f));
        }
        return NoCropHelper.m28749a(new NoCropLayoutRestrictions(graphQLImage.mo2925c(), graphQLImage.mo2923a(), rect.left, rect.top, rect.right, rect.bottom, 0, c, a));
    }

    public final PhotoAttachmentInfo m28747c(GraphQLMedia graphQLMedia) {
        int a;
        int i = ((StoryImageSizes) this.f21024b.get()).f6095c + 0;
        GraphQLImage T = graphQLMedia.m24441T();
        if (GraphQLHelper.m22492b(T)) {
            float c = ((float) i) / ((float) T.mo2925c());
            if (c == 0.0f || Float.isNaN(c)) {
                c = 1.0f;
            }
            a = (int) (c * ((float) T.mo2923a()));
        } else {
            a = NoCropHelper.m28748a(i, T.mo2925c(), T.mo2923a(), false);
        }
        Builder builder = new Builder();
        builder.f21984b = T.mo2925c();
        builder = builder;
        builder.f21985c = T.mo2923a();
        builder = builder;
        builder.f21986d = i;
        Builder builder2 = builder;
        builder2.f21987e = a;
        Builder builder3 = builder2;
        GraphQLMediaRequestHelper.m29770a(graphQLMedia, T, builder3);
        return builder3.m29768a();
    }

    private boolean m28743a() {
        return this.f21028f.m8609b(false);
    }
}
