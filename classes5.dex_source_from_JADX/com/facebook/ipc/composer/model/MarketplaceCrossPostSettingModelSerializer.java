package com.facebook.ipc.composer.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TIMELINE_LIKE_CHAINING */
public class MarketplaceCrossPostSettingModelSerializer extends JsonSerializer<MarketplaceCrossPostSettingModel> {
    public final void m23380a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MarketplaceCrossPostSettingModel marketplaceCrossPostSettingModel = (MarketplaceCrossPostSettingModel) obj;
        if (marketplaceCrossPostSettingModel == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m23379b(marketplaceCrossPostSettingModel, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(MarketplaceCrossPostSettingModel.class, new MarketplaceCrossPostSettingModelSerializer());
    }

    private static void m23379b(MarketplaceCrossPostSettingModel marketplaceCrossPostSettingModel, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "is_enabled", marketplaceCrossPostSettingModel.isEnabled);
        AutoGenJsonHelper.a(jsonGenerator, "shold_show_intercept", marketplaceCrossPostSettingModel.shouldShowIntercept);
        AutoGenJsonHelper.a(jsonGenerator, "shold_show_nux", marketplaceCrossPostSettingModel.shouldShowNux);
        AutoGenJsonHelper.a(jsonGenerator, "is_compulsory", marketplaceCrossPostSettingModel.isCompulsory);
        AutoGenJsonHelper.a(jsonGenerator, "nux_label", marketplaceCrossPostSettingModel.nuxLabel);
        AutoGenJsonHelper.a(jsonGenerator, "check_box_label", marketplaceCrossPostSettingModel.checkBoxLabel);
        AutoGenJsonHelper.a(jsonGenerator, "upsell_title_label", marketplaceCrossPostSettingModel.upsellTitleLabel);
        AutoGenJsonHelper.a(jsonGenerator, "upsell_people_label", marketplaceCrossPostSettingModel.upsellPeopleLabel);
        AutoGenJsonHelper.a(jsonGenerator, "upsell_pin_label", marketplaceCrossPostSettingModel.upsellPinLabel);
        AutoGenJsonHelper.a(jsonGenerator, "upsell_Time_label", marketplaceCrossPostSettingModel.upsellTimeLabel);
        AutoGenJsonHelper.a(jsonGenerator, "intercept_accept_button_label", marketplaceCrossPostSettingModel.interceptAcceptButtonLabel);
        AutoGenJsonHelper.a(jsonGenerator, "intercept_decline_button_label", marketplaceCrossPostSettingModel.interceptDeclineButtonLabel);
        AutoGenJsonHelper.a(jsonGenerator, "upsell_accept_button_label", marketplaceCrossPostSettingModel.upsellAcceptButtonLabel);
        AutoGenJsonHelper.a(jsonGenerator, "upsell_decline_button_label", marketplaceCrossPostSettingModel.upsellDeclineButtonLabel);
    }
}
