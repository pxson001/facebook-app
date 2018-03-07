package com.facebook.groupcommerce.util;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.locale.Locales;
import com.facebook.common.util.TriState;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLGroupPurposeType;
import com.facebook.groupcommerce.model.GroupCommerceCategory;
import com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel;
import com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel;
import com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel;
import com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel;
import com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.ForSaleCategoriesModel.ForSaleCategoriesEdgesModel;
import com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel.EdgesModel.NodeModel.LocationPickerSettingModel;
import com.facebook.groups.grouppurposes.protocol.FetchGroupPurposesQueryInterfaces.GroupPurposeFragment;
import com.facebook.groups.protocol.GroupInformationInterface;
import com.facebook.groups.protocol.GroupInformationInterfaceFactory.C05411;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.ComposerCommerceInfo;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.composer.model.MarketplaceCrossPostSettingModel;
import com.facebook.ipc.composer.model.ProductItemLocationPickerSettings;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Currency;

/* compiled from: reaction_unit_components */
public class GroupCommerceComposerHelper {
    public static boolean m6185a(C05411 c05411) {
        if (!(c05411 == null || c05411.m7214c() == null)) {
            ImmutableList a = c05411.m7214c().m7017a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                if (((GroupPurposeFragment) a.get(i)).mo303b() == GraphQLGroupPurposeType.FOR_SALE) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String m6184a(Locales locales) {
        try {
            return Currency.getInstance(locales.a()).getCurrencyCode();
        } catch (IllegalArgumentException e) {
            return "USD";
        }
    }

    public static NodeModel m6187c(C05411 c05411) {
        if (c05411 == null) {
            return null;
        }
        GroupSellConfigModel u = c05411.f5814a.m6327u();
        if (u != null) {
            ImmutableList a = u.m6153a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                EdgesModel edgesModel = (EdgesModel) a.get(i);
                if (edgesModel.m6148a() != null) {
                    return edgesModel.m6148a();
                }
            }
        }
        return null;
    }

    public static String m6186b(C05411 c05411, Locales locales) {
        NodeModel c = m6187c(c05411);
        if (c == null || c.m6134b().isEmpty()) {
            return m6184a(locales);
        }
        return (String) c.m6134b().get(0);
    }

    public static ImmutableList<GroupCommerceCategory> m6188j(GroupInformationInterface groupInformationInterface) {
        NodeModel c = m6187c(groupInformationInterface);
        if (c == null || c.m6135c() == null) {
            return null;
        }
        ForSaleCategoriesModel c2 = c.m6135c();
        Builder builder = new Builder();
        ImmutableList a = c2.m6097a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ForSaleCategoriesEdgesModel forSaleCategoriesEdgesModel = (ForSaleCategoriesEdgesModel) a.get(i);
            if (forSaleCategoriesEdgesModel.m6092a() != null) {
                GroupCommerceCategory.Builder builder2 = new GroupCommerceCategory.Builder();
                builder2.a = forSaleCategoriesEdgesModel.m6092a().m6086c();
                builder2 = builder2;
                builder2.b = forSaleCategoriesEdgesModel.m6092a().m6085b();
                builder.c(new GroupCommerceCategory(builder2));
            }
        }
        ImmutableList<GroupCommerceCategory> b = builder.b();
        return b.isEmpty() ? null : b;
    }

    public static ComposerConfiguration.Builder m6182a(C05411 c05411, Locales locales) {
        ImmutableList immutableList;
        MarketplaceCrossPostSettingModel marketplaceCrossPostSettingModel;
        boolean z;
        String str;
        String b = m6186b(c05411, locales);
        ComposerTargetData.Builder builder = new ComposerTargetData.Builder(Long.parseLong(c05411.m7212a()), TargetType.GROUP);
        builder.c = c05411.m7213b();
        ComposerConfiguration.Builder a = ComposerConfigurationFactory.a(ComposerSourceSurface.GROUP_FEED, "groupCommerceComposerHelper", b, builder.a(), m6188j(c05411));
        ComposerConfiguration.Builder nectarModule = a.setNectarModule("group_composer");
        ComposerCommerceInfo.Builder currencyCode = ComposerCommerceInfo.newBuilder().setCurrencyCode(m6186b(c05411, locales));
        NodeModel c = m6187c(c05411);
        if (c == null) {
            immutableList = null;
        } else {
            immutableList = c.m6138j();
        }
        currencyCode = currencyCode.setInterceptWords(immutableList);
        c = m6187c(c05411);
        if (c == null) {
            immutableList = null;
        } else {
            immutableList = c.m6139k();
        }
        currencyCode = currencyCode.setInterceptWordsAfterNumber(immutableList);
        c = m6187c(c05411);
        if (c == null || c.gQ_() == null) {
            marketplaceCrossPostSettingModel = null;
        } else {
            NodeModel.MarketplaceCrossPostSettingModel gQ_ = c.gQ_();
            MarketplaceCrossPostSettingModel.Builder builder2 = new MarketplaceCrossPostSettingModel.Builder();
            builder2.a = Boolean.valueOf(gQ_.gS_()).booleanValue();
            builder2 = builder2;
            builder2.b = Boolean.valueOf(gQ_.gT_()).booleanValue();
            builder2 = builder2;
            builder2.c = Boolean.valueOf(gQ_.gU_()).booleanValue();
            builder2 = builder2;
            builder2.d = Boolean.valueOf(gQ_.m6117d()).booleanValue();
            builder2 = builder2;
            builder2.f = gQ_.m6113a();
            builder2 = builder2;
            builder2.e = gQ_.m6118g();
            builder2 = builder2;
            builder2.g = gQ_.m6124o();
            builder2 = builder2;
            builder2.h = gQ_.m6121l();
            builder2 = builder2;
            builder2.i = gQ_.m6122m();
            builder2 = builder2;
            builder2.j = gQ_.m6123n();
            builder2 = builder2;
            builder2.k = gQ_.m6115b();
            builder2 = builder2;
            builder2.l = gQ_.m6116c();
            builder2 = builder2;
            builder2.m = gQ_.m6119j();
            builder2 = builder2;
            builder2.n = gQ_.m6120k();
            marketplaceCrossPostSettingModel = new MarketplaceCrossPostSettingModel(builder2);
        }
        currencyCode = currencyCode.setMarketplaceCrossPostSettingModel(marketplaceCrossPostSettingModel).setProductItemLocationPickerSettings(m6189l(c05411));
        c = m6187c(c05411);
        if (c == null) {
            z = false;
        } else {
            z = c.gP_();
        }
        currencyCode = currencyCode.setIsCategoryOptional(z);
        c = m6187c(c05411);
        if (c == null) {
            str = null;
        } else {
            str = c.m6140l();
        }
        nectarModule = nectarModule.setCommerceInfo(currencyCode.setPrefillCategoryId(str).a());
        c = m6187c(c05411);
        if (c == null) {
            z = false;
        } else {
            z = c.m6142n();
        }
        nectarModule.setShouldPostToMarketplaceByDefault(z).setReactionSurface(Surface.ANDROID_GROUP_COMPOSER);
        return a;
    }

    public static Intent m6181a(Context context, C05411 c05411, ComposerConfiguration composerConfiguration, boolean z) {
        ComposerConfiguration.Builder a = ComposerConfiguration.a(composerConfiguration);
        ComposerTargetData.Builder builder = new ComposerTargetData.Builder(Long.parseLong(c05411.m7212a()), TargetType.GROUP);
        builder.c = c05411.m7213b();
        ComposerConfiguration a2 = a.setInitialTargetData(builder.a()).a();
        SimplePickerLauncherConfiguration.Builder g = new SimplePickerLauncherConfiguration.Builder(SimplePickerSource.GROUP).g();
        g.a = a2;
        SimplePickerLauncherConfiguration.Builder builder2 = g;
        if (z) {
            builder2.b();
        }
        return SimplePickerIntent.a(context, builder2);
    }

    public static ComposerConfiguration.Builder m6183a(C05411 c05411, TriState triState, Locales locales) {
        Object obj;
        if (m6185a(c05411) && triState == TriState.YES) {
            boolean z;
            NodeModel c = m6187c(c05411);
            if (c == null) {
                z = false;
            } else {
                z = c.m6137g();
            }
            if (z) {
                obj = 1;
                if (obj != null) {
                    return m6182a(c05411, locales).setComposerType(ComposerType.STATUS);
                }
                ComposerConfiguration.Builder a = ComposerConfigurationFactory.a(ComposerSourceSurface.GROUP_FEED, "groupCommerce");
                ComposerTargetData.Builder builder = new ComposerTargetData.Builder(Long.parseLong(c05411.m7212a()), TargetType.GROUP);
                builder.c = c05411.m7213b();
                return a.setInitialTargetData(builder.a()).setNectarModule("group_composer").setReactionSurface(Surface.ANDROID_GROUP_COMPOSER);
            }
        }
        obj = null;
        if (obj != null) {
            return m6182a(c05411, locales).setComposerType(ComposerType.STATUS);
        }
        ComposerConfiguration.Builder a2 = ComposerConfigurationFactory.a(ComposerSourceSurface.GROUP_FEED, "groupCommerce");
        ComposerTargetData.Builder builder2 = new ComposerTargetData.Builder(Long.parseLong(c05411.m7212a()), TargetType.GROUP);
        builder2.c = c05411.m7213b();
        return a2.setInitialTargetData(builder2.a()).setNectarModule("group_composer").setReactionSurface(Surface.ANDROID_GROUP_COMPOSER);
    }

    private static ProductItemLocationPickerSettings m6189l(C05411 c05411) {
        NodeModel c = m6187c(c05411);
        if (c == null || c.gR_() == null) {
            return null;
        }
        LocationPickerSettingModel gR_ = c.gR_();
        return ProductItemLocationPickerSettings.newBuilder().setUseZipCode(gR_.m6106c()).setIsCompulsory(gR_.m6104a()).setUseNeighborhoodDataSource(gR_.m6105b()).a();
    }
}
