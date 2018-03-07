package com.facebook.redspace.data;

import android.support.annotation.Nullable;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceWallItemFragmentModel;
import com.facebook.ultralight.Inject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/* compiled from: Place Tips */
public class RedSpaceWallItemDebugWriter {
    private final ObjectWriter f11918a;

    @Inject
    public RedSpaceWallItemDebugWriter(ObjectMapper objectMapper) {
        this.f11918a = objectMapper.g().a();
    }

    public final String m12359a(@Nullable RedSpaceWallItemFragmentModel redSpaceWallItemFragmentModel) {
        if (redSpaceWallItemFragmentModel == null) {
            return " NULL wall item";
        }
        try {
            return this.f11918a.a(redSpaceWallItemFragmentModel);
        } catch (JsonProcessingException e) {
            return "GraphQlStory:" + redSpaceWallItemFragmentModel.j() + "\nToken:" + redSpaceWallItemFragmentModel.k();
        }
    }
}
