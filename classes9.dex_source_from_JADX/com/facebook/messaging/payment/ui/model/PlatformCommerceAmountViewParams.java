package com.facebook.messaging.payment.ui.model;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fa9934cd8d3439f5f517b3ebf8cbd658 */
public class PlatformCommerceAmountViewParams {
    public final String f15154a;
    @Nullable
    public final String f15155b;
    @Nullable
    public final String f15156c;
    public final String f15157d;

    public PlatformCommerceAmountViewParams(PlatformCommerceAmountViewParamsBuilder platformCommerceAmountViewParamsBuilder) {
        this.f15154a = platformCommerceAmountViewParamsBuilder.f15158a;
        this.f15155b = platformCommerceAmountViewParamsBuilder.f15159b;
        this.f15156c = platformCommerceAmountViewParamsBuilder.f15160c;
        this.f15157d = platformCommerceAmountViewParamsBuilder.f15161d;
    }

    public static PlatformCommerceAmountViewParamsBuilder newBuilder() {
        return new PlatformCommerceAmountViewParamsBuilder();
    }
}
