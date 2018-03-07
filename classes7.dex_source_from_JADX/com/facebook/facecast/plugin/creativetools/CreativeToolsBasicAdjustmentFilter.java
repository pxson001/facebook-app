package com.facebook.facecast.plugin.creativetools;

import com.facebook.facecast.protocol.FetchCreativeToolsQueryModels.VideoBasicAdjustmentFilterModel;
import com.facebook.videocodec.effects.renderers.ColorFilter;
import com.facebook.videocodec.effects.renderers.ColorFilterRenderer;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: bio_add_prompt_suggested_impression */
public class CreativeToolsBasicAdjustmentFilter {
    public static final CreativeToolsBasicAdjustmentFilter f18641a = new CreativeToolsBasicAdjustmentFilter("No Filter", 0.0d, 0.0d, 0.0d, 0.0d, false);
    public final String f18642b;
    public final ColorFilter f18643c;
    public final ColorFilterRenderer f18644d = new ColorFilterRenderer(this.f18643c);

    private CreativeToolsBasicAdjustmentFilter(String str, double d, double d2, double d3, double d4, boolean z) {
        this.f18642b = str;
        this.f18643c = new ColorFilter(str, (float) d2, (float) d, (float) d4, (float) d3, z);
    }

    @Nullable
    public static CreativeToolsBasicAdjustmentFilter m22230a(@Nullable VideoBasicAdjustmentFilterModel videoBasicAdjustmentFilterModel) {
        if (videoBasicAdjustmentFilterModel == null || videoBasicAdjustmentFilterModel.m22366o() == null || Strings.isNullOrEmpty(videoBasicAdjustmentFilterModel.m22366o().m22355a())) {
            return null;
        }
        return new CreativeToolsBasicAdjustmentFilter(videoBasicAdjustmentFilterModel.m22366o().m22355a(), videoBasicAdjustmentFilterModel.m22361j(), videoBasicAdjustmentFilterModel.m22365n(), videoBasicAdjustmentFilterModel.m22363l(), videoBasicAdjustmentFilterModel.m22362k(), videoBasicAdjustmentFilterModel.m22364m());
    }

    public String toString() {
        return this.f18642b + " BasicAdjustmentFilter:\n brightness: " + this.f18643c.f15794c + "\nsaturation: " + this.f18643c.f15793b + "\nhue: " + this.f18643c.f15796e + "\ncontrast: " + this.f18643c.f15795d + "\nhueColorize: " + this.f18643c.f15797f;
    }
}
