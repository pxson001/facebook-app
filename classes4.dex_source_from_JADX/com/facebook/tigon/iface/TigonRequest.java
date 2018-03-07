package com.facebook.tigon.iface;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.tigon.iface.TigonRequestLayers.LayerInfo;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@DoNotStrip
@Immutable
/* compiled from: last_upload_success_time */
public interface TigonRequest {
    @DoNotStrip
    public static final String GET = "GET";
    @DoNotStrip
    public static final String POST = "POST";

    @Nullable
    <T> T mo307a(LayerInfo<T> layerInfo);

    String mo308a();

    String mo309b();

    Map<String, String> mo310c();

    TigonPriorityData mo311d();
}
