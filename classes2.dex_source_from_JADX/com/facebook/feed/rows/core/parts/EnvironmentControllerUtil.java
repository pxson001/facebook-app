package com.facebook.feed.rows.core.parts;

import com.facebook.feed.rows.core.RowKey;
import com.facebook.multirow.api.AnyEnvironment;
import javax.annotation.Nullable;

/* compiled from: messages/ */
public class EnvironmentControllerUtil {
    public static EnvironmentController<AnyEnvironment> m20677a(AnyEnvironment anyEnvironment, @Nullable PartWithViewType partWithViewType, @Nullable PartWithViewType partWithViewType2, @Nullable PartWithViewType partWithViewType3, @Nullable Object obj, @Nullable Object obj2, @Nullable RowKey rowKey, boolean z) {
        EnvironmentController<AnyEnvironment> b = anyEnvironment instanceof HasEnvironmentController ? ((HasEnvironmentController) anyEnvironment).mo2441b() : null;
        if (b != null) {
            b.mo2463a(anyEnvironment, partWithViewType, partWithViewType2, partWithViewType3, obj, obj2, rowKey, z);
        }
        return b;
    }

    public static void m20678a(@Nullable EnvironmentController<AnyEnvironment> environmentController, AnyEnvironment anyEnvironment) {
        if (environmentController != null) {
            environmentController.mo2462a(anyEnvironment);
        }
    }
}
