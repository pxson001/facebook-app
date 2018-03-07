package com.facebook.timeline.protiles.util;

import android.content.Context;
import android.graphics.PointF;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.device.ScreenUtil;
import com.facebook.graphql.enums.GraphQLProfileTileSectionType;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.tablet.sideshow.TypedSideshowFragmentContainer;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileItemFieldsModel;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileItemFieldsModel.CollageLayoutModel;
import com.facebook.timeline.util.ProfileMosaicUtil;
import com.facebook.widget.mosaic.MosaicGridLayout.LayoutParams;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fb4a_reg_name_hint_zh_promo */
public class ProtilesImageUtil {
    private static ProtilesImageUtil f12382e;
    private static final Object f12383f = new Object();
    private final ScreenUtil f12384a;
    private final Context f12385b;
    private final GraphQLImageHelper f12386c;
    private final GraphQLStoryHelper f12387d;

    private static ProtilesImageUtil m12424b(InjectorLike injectorLike) {
        return new ProtilesImageUtil((Context) injectorLike.getInstance(Context.class), ScreenUtil.a(injectorLike), GraphQLImageHelper.a(injectorLike), GraphQLStoryHelper.a(injectorLike));
    }

    @Inject
    public ProtilesImageUtil(Context context, ScreenUtil screenUtil, GraphQLImageHelper graphQLImageHelper, GraphQLStoryHelper graphQLStoryHelper) {
        this.f12385b = context;
        this.f12384a = screenUtil;
        this.f12386c = graphQLImageHelper;
        this.f12387d = graphQLStoryHelper;
    }

    public final int m12428a() {
        return GraphQLStoryHelper.a().intValue();
    }

    public final int m12429b() {
        return GraphQLImageHelper.a(((m12427f() - (this.f12385b.getResources().getDimensionPixelSize(2131433966) * 2)) - (this.f12385b.getResources().getDimensionPixelSize(2131433967) * 6)) / 3).intValue();
    }

    public static ProtilesImageUtil m12423a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProtilesImageUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12383f) {
                ProtilesImageUtil protilesImageUtil;
                if (a2 != null) {
                    protilesImageUtil = (ProtilesImageUtil) a2.a(f12383f);
                } else {
                    protilesImageUtil = f12382e;
                }
                if (protilesImageUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12424b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12383f, b3);
                        } else {
                            f12382e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = protilesImageUtil;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final int m12431c() {
        int e = m12426e();
        return GraphQLImageHelper.a(((m12427f() - e) - this.f12385b.getResources().getDimensionPixelSize(2131433968)) / 2).intValue();
    }

    public final int m12432d() {
        return GraphQLImageHelper.a(m12427f() - m12426e()).intValue();
    }

    public static PointF m12420a(ProtileItemFieldsModel protileItemFieldsModel) {
        Preconditions.checkNotNull(protileItemFieldsModel);
        if (protileItemFieldsModel.m12180b() == null || protileItemFieldsModel.m12180b().m12150c() == null) {
            return new PointF(0.5f, 0.5f);
        }
        return new PointF((float) protileItemFieldsModel.m12180b().m12150c().a(), (float) protileItemFieldsModel.m12180b().m12150c().b());
    }

    @Nullable
    public static DefaultImageFields m12422a(ProtileItemFieldsModel protileItemFieldsModel, GraphQLProfileTileSectionType graphQLProfileTileSectionType) {
        Preconditions.checkNotNull(protileItemFieldsModel);
        if (protileItemFieldsModel.m12180b() == null) {
            return null;
        }
        if (graphQLProfileTileSectionType == GraphQLProfileTileSectionType.PHOTOS) {
            return protileItemFieldsModel.m12180b().m12152g();
        }
        if (graphQLProfileTileSectionType == GraphQLProfileTileSectionType.FRIENDS) {
            return protileItemFieldsModel.m12180b().m12154k();
        }
        throw new IllegalArgumentException("Type of protile item should be Photos or Friends.");
    }

    @Nullable
    public final DefaultImageFields m12430b(ProtileItemFieldsModel protileItemFieldsModel) {
        Preconditions.checkNotNull(protileItemFieldsModel);
        if (protileItemFieldsModel.m12180b() == null) {
            return null;
        }
        CollageLayoutModel a = protileItemFieldsModel.m12179a();
        return a == null ? protileItemFieldsModel.m12180b().bd_() : m12421a(protileItemFieldsModel, (int) a.m12135b());
    }

    @Nullable
    private DefaultImageFields m12421a(ProtileItemFieldsModel protileItemFieldsModel, int i) {
        Preconditions.checkNotNull(protileItemFieldsModel);
        Preconditions.checkNotNull(protileItemFieldsModel.m12180b());
        return ProfileMosaicUtil.a(protileItemFieldsModel.m12180b(), i, 6, m12419a(i));
    }

    private int m12419a(int i) {
        return (m12427f() - m12426e()) - (((6 / i) - 1) * this.f12385b.getResources().getDimensionPixelSize(2131433968));
    }

    @Nullable
    public static LayoutParams m12425c(ProtileItemFieldsModel protileItemFieldsModel) {
        CollageLayoutModel a = protileItemFieldsModel.m12179a();
        if (a == null) {
            return null;
        }
        return new LayoutParams((int) a.m12136c(), (int) a.m12137d(), (int) a.m12135b(), (int) a.m12131a());
    }

    private int m12426e() {
        return this.f12385b.getResources().getDimensionPixelSize(2131433949) * 2;
    }

    private int m12427f() {
        TypedSideshowFragmentContainer typedSideshowFragmentContainer = (TypedSideshowFragmentContainer) ContextUtils.a(this.f12385b, TypedSideshowFragmentContainer.class);
        if (typedSideshowFragmentContainer == null || typedSideshowFragmentContainer.s() == null) {
            return this.f12384a.c();
        }
        return typedSideshowFragmentContainer.s().a;
    }
}
