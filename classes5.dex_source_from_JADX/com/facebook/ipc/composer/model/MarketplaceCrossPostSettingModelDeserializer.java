package com.facebook.ipc.composer.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: TIMELINE_MAP_PAGELET_LINK */
public class MarketplaceCrossPostSettingModelDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13998a;

    static {
        GlobalAutoGenDeserializerCache.a(MarketplaceCrossPostSettingModel.class, new MarketplaceCrossPostSettingModelDeserializer());
        m23377e();
    }

    public MarketplaceCrossPostSettingModelDeserializer() {
        a(MarketplaceCrossPostSettingModel.class);
    }

    private static synchronized Map<String, FbJsonField> m23377e() {
        Map<String, FbJsonField> map;
        synchronized (MarketplaceCrossPostSettingModelDeserializer.class) {
            if (f13998a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("is_enabled", FbJsonField.jsonField(MarketplaceCrossPostSettingModel.class.getDeclaredField("isEnabled")));
                    builder.b("shold_show_intercept", FbJsonField.jsonField(MarketplaceCrossPostSettingModel.class.getDeclaredField("shouldShowIntercept")));
                    builder.b("shold_show_nux", FbJsonField.jsonField(MarketplaceCrossPostSettingModel.class.getDeclaredField("shouldShowNux")));
                    builder.b("is_compulsory", FbJsonField.jsonField(MarketplaceCrossPostSettingModel.class.getDeclaredField("isCompulsory")));
                    builder.b("nux_label", FbJsonField.jsonField(MarketplaceCrossPostSettingModel.class.getDeclaredField("nuxLabel")));
                    builder.b("check_box_label", FbJsonField.jsonField(MarketplaceCrossPostSettingModel.class.getDeclaredField("checkBoxLabel")));
                    builder.b("upsell_title_label", FbJsonField.jsonField(MarketplaceCrossPostSettingModel.class.getDeclaredField("upsellTitleLabel")));
                    builder.b("upsell_people_label", FbJsonField.jsonField(MarketplaceCrossPostSettingModel.class.getDeclaredField("upsellPeopleLabel")));
                    builder.b("upsell_pin_label", FbJsonField.jsonField(MarketplaceCrossPostSettingModel.class.getDeclaredField("upsellPinLabel")));
                    builder.b("upsell_Time_label", FbJsonField.jsonField(MarketplaceCrossPostSettingModel.class.getDeclaredField("upsellTimeLabel")));
                    builder.b("intercept_accept_button_label", FbJsonField.jsonField(MarketplaceCrossPostSettingModel.class.getDeclaredField("interceptAcceptButtonLabel")));
                    builder.b("intercept_decline_button_label", FbJsonField.jsonField(MarketplaceCrossPostSettingModel.class.getDeclaredField("interceptDeclineButtonLabel")));
                    builder.b("upsell_accept_button_label", FbJsonField.jsonField(MarketplaceCrossPostSettingModel.class.getDeclaredField("upsellAcceptButtonLabel")));
                    builder.b("upsell_decline_button_label", FbJsonField.jsonField(MarketplaceCrossPostSettingModel.class.getDeclaredField("upsellDeclineButtonLabel")));
                    f13998a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13998a;
        }
        return map;
    }

    public final FbJsonField m23378a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23377e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23377e().keySet());
    }
}
