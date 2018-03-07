package com.facebook.abtest.qe.protocol.sync.full;

import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryModels.ConfigurationParameterSetModel;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryModels.ConfigurationParameterSetsConnectionModel;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryModels.ConfigurationParameterSetsConnectionModel.EdgesModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: tosUrl */
public class ViewerConfigurationModelUtils {
    @Nullable
    public static ConfigurationParameterSetModel m2384a(ConfigurationParameterSetsConnectionModel configurationParameterSetsConnectionModel, String str) {
        ImmutableList a = configurationParameterSetsConnectionModel.m2425a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ConfigurationParameterSetModel a2 = ((EdgesModel) a.get(i)).m2420a();
            if (a2 != null && str.equals(a2.m2414a())) {
                return a2;
            }
        }
        return null;
    }
}
