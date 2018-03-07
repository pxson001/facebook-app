package com.facebook.photos.editgallery;

import com.facebook.ipc.editgallery.EntryPoint;
import com.facebook.photos.creativeediting.analytics.CreativeEditingUsageParams;
import com.facebook.photos.creativeediting.analytics.CreativeEditingUsageParams.Builder;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.model.Filter;
import com.facebook.photos.editgallery.EditGalleryFragmentManager.UsageParams;

/* compiled from: left_handle_moves */
public class EditGalleryUsageLoggingUtils {
    public static CreativeEditingUsageParams m12203a(CreativeEditingData creativeEditingData, EntryPoint entryPoint, UsageParams usageParams, boolean z, int i) {
        Builder builder;
        Builder newBuilder = CreativeEditingUsageParams.newBuilder();
        newBuilder.f9534c = z;
        newBuilder.f9544m = i;
        if (creativeEditingData != null) {
            boolean z2;
            if (creativeEditingData.c() != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            newBuilder.f9532a = z2;
            builder = newBuilder;
            builder.f9545n = creativeEditingData.a();
            builder = builder;
            builder.f9541j = creativeEditingData.d().size();
            builder.f9542k = creativeEditingData.e().size();
        } else {
            newBuilder.f9545n = Filter.PassThrough.name();
        }
        newBuilder.f9535d = 1;
        builder = newBuilder;
        builder.f9538g = usageParams.f10349d;
        builder = builder;
        builder.f9539h = usageParams.f10350e;
        builder = builder;
        builder.f9536e = usageParams.f10347b;
        builder = builder;
        builder.f9537f = usageParams.f10346a;
        builder.f9546o = entryPoint;
        return newBuilder.m11494a();
    }
}
