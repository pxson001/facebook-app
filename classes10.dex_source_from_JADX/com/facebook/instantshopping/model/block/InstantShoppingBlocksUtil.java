package com.facebook.instantshopping.model.block;

import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.graphql.enums.GraphQLInstantShoppingDocumentElementType;
import com.facebook.graphql.enums.GraphQLInstantShoppingPresentationStyle;
import com.facebook.instantshopping.model.data.impl.BaseElementDescriptorBlockData;
import com.facebook.instantshopping.model.data.impl.BaseInstantShoppingMediaBlock.BaseInstantShoppingMediaBlockBuilder;
import com.facebook.instantshopping.model.data.impl.ButtonBlockDataImpl;
import com.facebook.instantshopping.model.data.impl.ColorPickerBlockDataImpl;
import com.facebook.instantshopping.model.data.impl.CompositeBlockDataImpl;
import com.facebook.instantshopping.model.data.impl.DividerBlockDataImpl;
import com.facebook.instantshopping.model.data.impl.ExpandableBlockDataImpl;
import com.facebook.instantshopping.model.data.impl.FooterBlockDataImpl;
import com.facebook.instantshopping.model.data.impl.HeaderBlockDataImpl;
import com.facebook.instantshopping.model.data.impl.InstantShoppingBlockDataHelper;
import com.facebook.instantshopping.model.data.impl.InstantShoppingImageBlockDataImpl;
import com.facebook.instantshopping.model.data.impl.InstantShoppingImageBlockDataImpl.InstantShoppingImageBlockDataBuilder;
import com.facebook.instantshopping.model.data.impl.InstantShoppingSlideshowBlockDataImpl.InstantShoppingSlideshowBlockDataBuilder;
import com.facebook.instantshopping.model.data.impl.InstantShoppingTextBlockDataImpl;
import com.facebook.instantshopping.model.data.impl.InstantShoppingVideoBlockDataImpl.InstantShoppingVideoBlockDataBuilder;
import com.facebook.instantshopping.model.data.impl.ToggleButtonBlockDataImpl;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingDocumentFragment.DocumentBodyElements;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingPhotoElementFragment;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.ShoppingDocumentElementsEdgeModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.ShoppingDocumentElementsEdgeModel.NodeModel;
import com.facebook.instantshopping.utils.GridUtils;
import com.facebook.richdocument.model.data.BlockData;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nonnull;

/* compiled from: Set weinre server hostname and port number  */
public class InstantShoppingBlocksUtil {
    public static boolean f23588a = false;

    /* compiled from: Set weinre server hostname and port number  */
    public /* synthetic */ class C33931 {
        public static final /* synthetic */ int[] f23587a = new int[GraphQLInstantShoppingDocumentElementType.values().length];

        static {
            try {
                f23587a[GraphQLInstantShoppingDocumentElementType.RICH_TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23587a[GraphQLInstantShoppingDocumentElementType.PHOTO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23587a[GraphQLInstantShoppingDocumentElementType.VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f23587a[GraphQLInstantShoppingDocumentElementType.BUTTON.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f23587a[GraphQLInstantShoppingDocumentElementType.SLIDESHOW.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f23587a[GraphQLInstantShoppingDocumentElementType.DIVIDER.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f23587a[GraphQLInstantShoppingDocumentElementType.COLOR_SELECTOR.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f23587a[GraphQLInstantShoppingDocumentElementType.EXPANDABLE_SECTION.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f23587a[GraphQLInstantShoppingDocumentElementType.COMPOSITE_BLOCK.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f23587a[GraphQLInstantShoppingDocumentElementType.TOGGLE_BUTTON.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    public static InstantShoppingBlocks m24892a(ImmutableList<InstantShoppingPhotoElementFragment> immutableList) {
        Collection arrayList = new ArrayList();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            InstantShoppingPhotoElementFragment instantShoppingPhotoElementFragment = (InstantShoppingPhotoElementFragment) immutableList.get(i);
            int i2 = 107;
            boolean z = instantShoppingPhotoElementFragment.iJ_() != null && instantShoppingPhotoElementFragment.iJ_().contains(GraphQLInstantShoppingPresentationStyle.FIT_TO_HEIGHT);
            GraphQLDocumentMediaPresentationStyle graphQLDocumentMediaPresentationStyle = null;
            if (z) {
                graphQLDocumentMediaPresentationStyle = GraphQLDocumentMediaPresentationStyle.FULL_SCREEN;
                i2 = 108;
            }
            if (instantShoppingPhotoElementFragment.iJ_() == null || !instantShoppingPhotoElementFragment.iJ_().contains(GraphQLInstantShoppingPresentationStyle.EXPANDABLE)) {
                z = false;
            } else {
                z = true;
            }
            boolean contains = instantShoppingPhotoElementFragment.iJ_().contains(GraphQLInstantShoppingPresentationStyle.SHOW_INTERACTION_HINT);
            if (instantShoppingPhotoElementFragment.l() == null || instantShoppingPhotoElementFragment.l().isEmpty() || instantShoppingPhotoElementFragment.l().get(0) == null) {
                i2 = 110;
            }
            BaseInstantShoppingMediaBlockBuilder instantShoppingImageBlockDataBuilder = new InstantShoppingImageBlockDataBuilder(instantShoppingPhotoElementFragment, GridUtils.a, i2);
            instantShoppingImageBlockDataBuilder.f23620m = true;
            if (graphQLDocumentMediaPresentationStyle != null) {
                instantShoppingImageBlockDataBuilder.f23614g = graphQLDocumentMediaPresentationStyle;
            }
            if (z) {
                instantShoppingImageBlockDataBuilder.f23618k = true;
            } else {
                instantShoppingImageBlockDataBuilder.f23618k = false;
            }
            instantShoppingImageBlockDataBuilder.f23616i = contains;
            if (InstantShoppingBlockDataHelper.m24957a(instantShoppingPhotoElementFragment.iJ_())) {
                instantShoppingImageBlockDataBuilder.f23619l = true;
            }
            InstantShoppingImageBlockDataImpl d = instantShoppingImageBlockDataBuilder.m24963d();
            if (d != null) {
                arrayList.add(d);
            }
        }
        InstantShoppingBlocks instantShoppingBlocks = new InstantShoppingBlocks(null);
        instantShoppingBlocks.a(arrayList);
        return instantShoppingBlocks;
    }

    public static FooterBlockDataImpl m24893a() {
        return new FooterBlockDataImpl(GridUtils.a);
    }

    public static HeaderBlockDataImpl m24895b() {
        return new HeaderBlockDataImpl(GridUtils.a);
    }

    public static List<BlockData> m24894a(DocumentBodyElements documentBodyElements, int i) {
        List<BlockData> arrayList = new ArrayList();
        f23588a = false;
        ImmutableList a = documentBodyElements.a();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            NodeModel a2 = ((ShoppingDocumentElementsEdgeModel) a.get(i2)).a();
            InstantShoppingTextBlockDataImpl instantShoppingTextBlockDataImpl = null;
            ImmutableList iJ_;
            boolean z;
            BaseInstantShoppingMediaBlockBuilder instantShoppingImageBlockDataBuilder;
            boolean z2;
            BaseInstantShoppingMediaBlockBuilder baseInstantShoppingMediaBlockBuilder;
            BaseElementDescriptorBlockData d;
            switch (C33931.f23587a[a2.c().ordinal()]) {
                case 1:
                    instantShoppingTextBlockDataImpl = new InstantShoppingTextBlockDataImpl(a2, a2.g(), m24896b(a2.iJ_()));
                    break;
                case 2:
                    boolean z3;
                    int g = a2.g();
                    iJ_ = a2.iJ_();
                    if (iJ_ == null) {
                        z3 = false;
                    } else {
                        z3 = iJ_.contains(GraphQLInstantShoppingPresentationStyle.TILT_TO_PAN);
                    }
                    z = z3;
                    GraphQLDocumentMediaPresentationStyle graphQLDocumentMediaPresentationStyle = (a2.iJ_() == null || !(InstantShoppingBlockDataHelper.m24960e(a2.iJ_()) || z)) ? GraphQLDocumentMediaPresentationStyle.ASPECT_FIT : GraphQLDocumentMediaPresentationStyle.FULL_SCREEN;
                    instantShoppingImageBlockDataBuilder = new InstantShoppingImageBlockDataBuilder(a2, g, 114);
                    instantShoppingImageBlockDataBuilder.f23614g = graphQLDocumentMediaPresentationStyle;
                    if (a2.iJ_() != null) {
                        if (InstantShoppingBlockDataHelper.m24961f(a2.iJ_())) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        instantShoppingImageBlockDataBuilder.f23615h = z2;
                        baseInstantShoppingMediaBlockBuilder = instantShoppingImageBlockDataBuilder;
                        baseInstantShoppingMediaBlockBuilder.f23618k = InstantShoppingBlockDataHelper.m24959c(a2.iJ_());
                        baseInstantShoppingMediaBlockBuilder = baseInstantShoppingMediaBlockBuilder;
                        baseInstantShoppingMediaBlockBuilder.f23621n = z;
                        baseInstantShoppingMediaBlockBuilder = baseInstantShoppingMediaBlockBuilder;
                        baseInstantShoppingMediaBlockBuilder.f23616i = InstantShoppingBlockDataHelper.m24958b(a2.iJ_());
                        baseInstantShoppingMediaBlockBuilder.f23619l = InstantShoppingBlockDataHelper.m24957a(a2.iJ_());
                    }
                    d = instantShoppingImageBlockDataBuilder.m24963d();
                    break;
                case 3:
                    f23588a = true;
                    if (a2.y() != null) {
                        BaseInstantShoppingMediaBlockBuilder instantShoppingVideoBlockDataBuilder = new InstantShoppingVideoBlockDataBuilder(a2, a2.g(), 115);
                        if (a2.iJ_() != null) {
                            boolean z4;
                            if (InstantShoppingBlockDataHelper.m24960e(a2.iJ_())) {
                                instantShoppingVideoBlockDataBuilder.f23614g = GraphQLDocumentMediaPresentationStyle.FULL_SCREEN;
                            }
                            iJ_ = a2.iJ_();
                            if (iJ_ == null) {
                                z4 = false;
                            } else {
                                z4 = iJ_.contains(GraphQLInstantShoppingPresentationStyle.VIDEO_PLAY_PAUSE_DISABLED);
                            }
                            instantShoppingVideoBlockDataBuilder.f23656b = z4;
                            baseInstantShoppingMediaBlockBuilder = instantShoppingVideoBlockDataBuilder;
                            ImmutableList iJ_2 = a2.iJ_();
                            if (iJ_2 == null) {
                                z4 = false;
                            } else {
                                z4 = iJ_2.contains(GraphQLInstantShoppingPresentationStyle.LANDSCAPE_ENABLED);
                            }
                            baseInstantShoppingMediaBlockBuilder.f23617j = z4;
                            instantShoppingImageBlockDataBuilder = baseInstantShoppingMediaBlockBuilder;
                            if (InstantShoppingBlockDataHelper.m24961f(a2.iJ_())) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            instantShoppingImageBlockDataBuilder.f23615h = z2;
                            baseInstantShoppingMediaBlockBuilder = instantShoppingImageBlockDataBuilder;
                            baseInstantShoppingMediaBlockBuilder.f23616i = InstantShoppingBlockDataHelper.m24958b(a2.iJ_());
                            baseInstantShoppingMediaBlockBuilder.f23618k = InstantShoppingBlockDataHelper.m24959c(a2.iJ_());
                        }
                        d = instantShoppingVideoBlockDataBuilder.m24973d();
                        break;
                    }
                    break;
                case 4:
                    instantShoppingTextBlockDataImpl = new ButtonBlockDataImpl(a2);
                    break;
                case 5:
                    z = true;
                    BaseInstantShoppingMediaBlockBuilder instantShoppingSlideshowBlockDataBuilder = new InstantShoppingSlideshowBlockDataBuilder(m24892a(a2.w()), a2, GridUtils.a, 116);
                    instantShoppingSlideshowBlockDataBuilder.f23646b = i;
                    if (a2.iJ_() != null) {
                        if (InstantShoppingBlockDataHelper.m24960e(a2.iJ_())) {
                            instantShoppingSlideshowBlockDataBuilder.f23614g = GraphQLDocumentMediaPresentationStyle.FULL_SCREEN;
                        }
                        if (instantShoppingSlideshowBlockDataBuilder.f23614g != GraphQLDocumentMediaPresentationStyle.FULL_SCREEN) {
                            boolean z5;
                            iJ_ = a2.iJ_();
                            if (iJ_ == null) {
                                z5 = false;
                            } else {
                                z5 = iJ_.contains(GraphQLInstantShoppingPresentationStyle.NON_ADJUSTED_FIT_TO_WIDTH);
                            }
                            if (z5) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            instantShoppingSlideshowBlockDataBuilder.f23622o = z2;
                        }
                        instantShoppingSlideshowBlockDataBuilder.f23647c = a2.iJ_().contains(GraphQLInstantShoppingPresentationStyle.DARK_GRADIENT);
                        baseInstantShoppingMediaBlockBuilder = instantShoppingSlideshowBlockDataBuilder;
                        if (InstantShoppingBlockDataHelper.m24961f(a2.iJ_())) {
                            z = false;
                        }
                        baseInstantShoppingMediaBlockBuilder.f23615h = z;
                        baseInstantShoppingMediaBlockBuilder.f23618k = InstantShoppingBlockDataHelper.m24959c(a2.iJ_());
                    }
                    d = instantShoppingSlideshowBlockDataBuilder.m24966d();
                    break;
                case 6:
                    instantShoppingTextBlockDataImpl = new DividerBlockDataImpl(a2.d(), GridUtils.a);
                    break;
                case 7:
                    if (a2.g() > 0 && a2.g() < 100) {
                        instantShoppingTextBlockDataImpl = new ColorPickerBlockDataImpl(a2, 111, a2.g());
                        break;
                    }
                    instantShoppingTextBlockDataImpl = new ColorPickerBlockDataImpl(a2, 104, GridUtils.a);
                    break;
                case 8:
                    instantShoppingTextBlockDataImpl = new ExpandableBlockDataImpl(a2, GridUtils.a);
                    break;
                case 9:
                    instantShoppingTextBlockDataImpl = new CompositeBlockDataImpl(a2);
                    break;
                case 10:
                    instantShoppingTextBlockDataImpl = new ToggleButtonBlockDataImpl(a2, a2.g());
                    break;
            }
            InstantShoppingTextBlockDataImpl instantShoppingTextBlockDataImpl2 = instantShoppingTextBlockDataImpl;
            if (instantShoppingTextBlockDataImpl2 != null) {
                arrayList.add(instantShoppingTextBlockDataImpl2);
            }
        }
        return arrayList;
    }

    public static boolean m24896b(@Nonnull ImmutableList<GraphQLInstantShoppingPresentationStyle> immutableList) {
        if (immutableList == null) {
            return false;
        }
        return immutableList.contains(GraphQLInstantShoppingPresentationStyle.TEXT_NO_CUSTOM_MEASURE);
    }
}
