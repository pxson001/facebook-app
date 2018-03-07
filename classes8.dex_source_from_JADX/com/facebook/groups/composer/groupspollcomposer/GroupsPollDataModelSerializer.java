package com.facebook.groups.composer.groupspollcomposer;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: view_fundraiser */
public class GroupsPollDataModelSerializer extends JsonSerializer<GroupsPollDataModel> {
    public final void m470a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GroupsPollDataModel groupsPollDataModel = (GroupsPollDataModel) obj;
        if (groupsPollDataModel == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m469b(groupsPollDataModel, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(GroupsPollDataModel.class, new GroupsPollDataModelSerializer());
    }

    private static void m469b(GroupsPollDataModel groupsPollDataModel, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "poll_optins", groupsPollDataModel.m463b());
        AutoGenJsonHelper.a(jsonGenerator, "can_add_poll_option", Boolean.valueOf(groupsPollDataModel.m465c()));
        AutoGenJsonHelper.a(jsonGenerator, "can_choose_multiple_options", Boolean.valueOf(groupsPollDataModel.m466d()));
    }
}
