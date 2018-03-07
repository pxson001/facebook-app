package com.facebook.photos.upload.protocol;

import com.facebook.inject.InjectorLike;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.model.Filter;
import com.facebook.photos.creativeediting.model.StickerParams;
import com.facebook.photos.creativeediting.model.TextParams;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: getName */
public class CreativeEditingPhotoUploadHelper {
    public static CreativeEditingPhotoUploadHelper m21691a(InjectorLike injectorLike) {
        return new CreativeEditingPhotoUploadHelper();
    }

    @Nullable
    public final String m21693a(UploadPhotoParams uploadPhotoParams) {
        CreativeEditingData h = m21692h(uploadPhotoParams);
        if (h == null || h.m4441d() == null || h.m4441d().isEmpty()) {
            return null;
        }
        ImmutableList d = uploadPhotoParams.f14131y.f3381a.m4441d();
        HashMap c = Maps.c();
        int size = d.size();
        for (int i = 0; i < size; i++) {
            String g = ((StickerParams) d.get(i)).mo228g();
            int i2 = 1;
            if (c.containsKey(g)) {
                i2 = ((Integer) c.get(g)).intValue() + 1;
            }
            c.put(g, Integer.valueOf(i2));
        }
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        for (Entry entry : c.entrySet()) {
            objectNode.a((String) entry.getKey(), (Integer) entry.getValue());
        }
        return objectNode.toString();
    }

    @Nullable
    public final String m21694b(UploadPhotoParams uploadPhotoParams) {
        CreativeEditingData h = m21692h(uploadPhotoParams);
        if (h == null || h.m4442e() == null || h.m4442e().isEmpty()) {
            return null;
        }
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        ImmutableList e = h.m4442e();
        int size = e.size();
        for (int i = 0; i < size; i++) {
            String l = ((TextParams) e.get(i)).m4736l();
            if (!Strings.isNullOrEmpty(l)) {
                arrayNode.h(l);
            }
        }
        return arrayNode.toString();
    }

    public final boolean m21695c(UploadPhotoParams uploadPhotoParams) {
        CreativeEditingData h = m21692h(uploadPhotoParams);
        if (h == null || h.m4440c() == null || (h.m4440c().height() == 1.0f && h.m4440c().width() == 1.0f)) {
            return false;
        }
        return true;
    }

    public final boolean m21696d(UploadPhotoParams uploadPhotoParams) {
        CreativeEditingData h = m21692h(uploadPhotoParams);
        if (h == null || !h.m4439b()) {
            return false;
        }
        return true;
    }

    public final boolean m21697e(UploadPhotoParams uploadPhotoParams) {
        CreativeEditingData h = m21692h(uploadPhotoParams);
        if (h == null || !h.m4450m() || Filter.AE08bit.name().equals(h.m4438a())) {
            return false;
        }
        return true;
    }

    @Nullable
    public static CreativeEditingData m21692h(UploadPhotoParams uploadPhotoParams) {
        if (uploadPhotoParams == null || uploadPhotoParams.f14131y == null) {
            return null;
        }
        return uploadPhotoParams.f14131y.f3381a;
    }
}
