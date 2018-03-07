package com.facebook.growth.nux;

import com.facebook.inject.InjectorLike;
import com.facebook.ipc.model.NuxStep;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: p2p_settings_help_center_tap */
public class NUXStepsValidator {
    private static final List<String> f7411a = ImmutableList.of("contact_importer", "upload_profile_pic", "people_you_may_know", "native_name");

    public static NUXStepsValidator m7734a(InjectorLike injectorLike) {
        return new NUXStepsValidator();
    }

    public final List<NuxStep> m7736a(List<NuxStep> list) {
        List<NuxStep> arrayList = new ArrayList();
        for (NuxStep nuxStep : list) {
            if (m7735a(nuxStep.name)) {
                arrayList.add(nuxStep);
            }
        }
        return arrayList;
    }

    public static boolean m7735a(String str) {
        return f7411a.contains(str);
    }
}
