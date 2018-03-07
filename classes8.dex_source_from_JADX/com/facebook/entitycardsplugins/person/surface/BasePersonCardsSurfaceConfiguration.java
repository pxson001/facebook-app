package com.facebook.entitycardsplugins.person.surface;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.debug.log.BLog;
import com.facebook.entitycards.analytics.EntityCardsAnalyticsLogger;
import com.facebook.entitycards.analytics.EntityCardsPerfLogger;
import com.facebook.entitycards.intent.EntityCardsIntentHelper;
import com.facebook.entitycards.intent.EntityCardsIntentHelper.EntityRange;
import com.facebook.entitycards.loader.AvailableIdsLoader;
import com.facebook.entitycards.loader.DefaultEntityCardsPageLoader;
import com.facebook.entitycards.loader.DefaultEntityCardsPageLoaderProvider;
import com.facebook.entitycards.model.EntityCardsCardSupportDeclaration;
import com.facebook.entitycards.model.EntityCardsDataSource;
import com.facebook.entitycards.service.EntityCardsIdsForPageLoader;
import com.facebook.entitycards.surface.EntityCardsSurfaceConfigurationHelper;
import com.facebook.entitycardsplugins.person.PersonCardActivityResultHandler;
import com.facebook.entitycardsplugins.person.loader.DefaultPersonCardsLoader;
import com.facebook.entitycardsplugins.person.loader.DefaultPersonCardsLoaderProvider;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardModel;
import com.facebook.entitycardsplugins.person.view.PersonCardViewHelper;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Absent;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: help_center_click */
public abstract class BasePersonCardsSurfaceConfiguration {
    private static final Class<?> f11246d = BasePersonCardsSurfaceConfiguration.class;
    protected final EntityCardsIntentHelper f11247a;
    protected final DefaultPersonCardsLoaderProvider f11248b;
    protected final DefaultEntityCardsPageLoaderProvider f11249c;
    private final EntityCardsSurfaceConfigurationHelper f11250e;
    public final Provider<PersonCardActivityResultHandler> f11251f;
    private final PersonCardViewHelper f11252g;

    public abstract String mo833a();

    public abstract Set<EntityCardsCardSupportDeclaration> mo834b();

    protected BasePersonCardsSurfaceConfiguration(EntityCardsSurfaceConfigurationHelper entityCardsSurfaceConfigurationHelper, Provider<PersonCardActivityResultHandler> provider, PersonCardViewHelper personCardViewHelper, EntityCardsIntentHelper entityCardsIntentHelper, DefaultPersonCardsLoaderProvider defaultPersonCardsLoaderProvider, DefaultEntityCardsPageLoaderProvider defaultEntityCardsPageLoaderProvider) {
        this.f11250e = entityCardsSurfaceConfigurationHelper;
        this.f11251f = provider;
        this.f11252g = personCardViewHelper;
        this.f11247a = entityCardsIntentHelper;
        this.f11248b = defaultPersonCardsLoaderProvider;
        this.f11249c = defaultEntityCardsPageLoaderProvider;
    }

    public final int m13237d() {
        return this.f11252g.m13247f();
    }

    public final EntityCardsDataSource m13233a(ImmutableList<String> immutableList, String str, EntityCardsAnalyticsLogger entityCardsAnalyticsLogger, EntityCardsPerfLogger entityCardsPerfLogger, CallerContext callerContext, Bundle bundle) {
        Preconditions.checkNotNull(immutableList);
        EntityRange a = EntityCardsIntentHelper.m12921a(immutableList, str);
        DefaultPersonCardsLoader a2 = this.f11248b.m13092a(Absent.withType(), callerContext);
        DefaultEntityCardsPageLoader a3 = this.f11249c.m12957a(mo832a(a, callerContext, bundle), a2, mo833a(), bundle);
        ImmutableMap a4 = m13232a(bundle);
        return this.f11250e.m13025a(a3, a2, entityCardsAnalyticsLogger, entityCardsPerfLogger, mo833a(), a.f10986c, a4, a.f10985b);
    }

    protected EntityCardsIdsForPageLoader mo832a(EntityRange entityRange, CallerContext callerContext, @Nullable Bundle bundle) {
        return new AvailableIdsLoader(entityRange);
    }

    @VisibleForTesting
    private static ImmutableMap<String, PersonCardModel> m13232a(@Nullable Bundle bundle) {
        if (bundle == null) {
            return RegularImmutableBiMap.a;
        }
        ArrayList arrayList = (ArrayList) FlatBufferModelHelper.b(bundle, "preliminary_entities");
        if (arrayList == null) {
            return RegularImmutableBiMap.a;
        }
        Builder builder = ImmutableMap.builder();
        HashSet hashSet = new HashSet();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            PersonCardModel personCardModel = (PersonCardModel) arrayList.get(i);
            String r = personCardModel.m13204r();
            if (hashSet.contains(r)) {
                BLog.b(f11246d, "Duplicate model IDs in the list of preliminary entities");
            } else {
                hashSet.add(r);
                builder.b(r, personCardModel);
            }
        }
        return builder.b();
    }
}
