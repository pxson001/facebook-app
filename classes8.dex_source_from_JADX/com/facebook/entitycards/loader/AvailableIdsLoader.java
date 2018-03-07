package com.facebook.entitycards.loader;

import android.os.Bundle;
import com.facebook.entitycards.collect.ImmutableOffsetArray;
import com.facebook.entitycards.intent.EntityCardsIntentHelper.EntityRange;
import com.facebook.entitycards.model.EntityCardsScrollDirection;
import com.facebook.entitycards.service.EntityCardsIdsForPageLoader;
import com.google.common.base.Absent;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: id_token */
public class AvailableIdsLoader implements EntityCardsIdsForPageLoader {
    private ImmutableList<String> f11011a;
    private int f11012b;
    private int f11013c;

    public final Optional<Bundle> mo772a() {
        return Absent.INSTANCE;
    }

    public AvailableIdsLoader(ImmutableList<String> immutableList, int i, int i2) {
        boolean z;
        boolean z2 = true;
        if (ImmutableSet.builder().b(immutableList).b().size() == immutableList.size()) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "AvailableIdsLoader doesn't support duplicate IDs");
        Preconditions.checkArgument(i >= 0);
        if (i2 >= immutableList.size()) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        this.f11011a = immutableList;
        this.f11012b = i;
        this.f11013c = i2;
    }

    public AvailableIdsLoader(EntityRange entityRange) {
        this(entityRange.f10984a, entityRange.f10987d, entityRange.f10988e);
    }

    public final boolean mo774a(EntityCardsScrollDirection entityCardsScrollDirection) {
        if (entityCardsScrollDirection == EntityCardsScrollDirection.LEFT) {
            if (this.f11012b > 0) {
                return true;
            }
            return false;
        } else if (this.f11013c >= this.f11011a.size() - 1) {
            return false;
        } else {
            return true;
        }
    }

    public final ListenableFuture<ImmutableOffsetArray<String>> mo773a(EntityCardsScrollDirection entityCardsScrollDirection, int i) {
        return Futures.a(m12952b(entityCardsScrollDirection, i));
    }

    public final ImmutableOffsetArray<String> m12952b(EntityCardsScrollDirection entityCardsScrollDirection, int i) {
        if (entityCardsScrollDirection == EntityCardsScrollDirection.LEFT) {
            int max = Math.max(0, this.f11012b - i);
            ImmutableOffsetArray<String> a = ImmutableOffsetArray.m12843a(max, this.f11011a.subList(max, this.f11012b));
            this.f11012b = max;
            return a;
        }
        max = Math.min(this.f11011a.size() - 1, this.f11013c + i);
        a = ImmutableOffsetArray.m12843a(this.f11013c + 1, this.f11011a.subList(this.f11013c + 1, max + 1));
        this.f11013c = max;
        return a;
    }

    public final boolean m12951a(String str) {
        return this.f11011a.contains(str);
    }

    public final void m12949a(ImmutableList<String> immutableList) {
        this.f11011a = ImmutableList.builder().b(this.f11011a).b(immutableList).b();
    }

    public String toString() {
        return Objects.toStringHelper(AvailableIdsLoader.class).add("startIndex", this.f11012b).add("endIndex", this.f11013c).add("availableIds", this.f11011a).toString();
    }
}
