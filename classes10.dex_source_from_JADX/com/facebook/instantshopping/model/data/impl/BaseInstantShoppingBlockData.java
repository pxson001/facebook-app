package com.facebook.instantshopping.model.data.impl;

import com.facebook.instantshopping.model.data.InstantShoppingBlockData;
import com.facebook.richdocument.model.data.impl.BaseBlockData;
import com.facebook.richdocument.model.data.impl.BaseBlockData.BaseBlockDataBuilder;

/* compiled from: SavedDashboardStartSequence */
public abstract class BaseInstantShoppingBlockData extends BaseBlockData implements InstantShoppingBlockData {
    private final int f23605a;

    /* compiled from: SavedDashboardStartSequence */
    public abstract class BaseInstantShoppingBlockDataBuilder<T extends InstantShoppingBlockData> extends BaseBlockDataBuilder<T> {
        public final int f23607a;

        public BaseInstantShoppingBlockDataBuilder(int i, int i2) {
            super(i2);
            this.f23607a = i;
        }
    }

    public BaseInstantShoppingBlockData(BaseInstantShoppingBlockDataBuilder baseInstantShoppingBlockDataBuilder) {
        super(baseInstantShoppingBlockDataBuilder);
        this.f23605a = baseInstantShoppingBlockDataBuilder.f23607a;
    }

    private BaseInstantShoppingBlockData(String str, int i, int i2) {
        super(str, i);
        this.f23605a = i2;
    }

    public BaseInstantShoppingBlockData(int i, int i2) {
        this(null, i, i2);
    }

    public int mo1000B() {
        return this.f23605a;
    }
}
