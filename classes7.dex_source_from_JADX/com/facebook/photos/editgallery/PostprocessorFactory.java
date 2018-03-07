package com.facebook.photos.editgallery;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import com.facebook.inject.Assisted;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.model.Filter;
import com.facebook.photos.editgallery.EditFeatureController.UriRequestType;
import com.facebook.photos.imageprocessing.FiltersRepeatedPostprocessor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: lead_gen_close_context_card_click */
public class PostprocessorFactory {
    public static final RectF f10412a = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    private final List<RectF> f10413b;
    private final Provider<FiltersRepeatedPostprocessor> f10414c;

    @Inject
    public PostprocessorFactory(@Assisted List<RectF> list, Provider<FiltersRepeatedPostprocessor> provider) {
        this.f10413b = list;
        this.f10414c = provider;
    }

    @Nullable
    public final FiltersRepeatedPostprocessor m12267a(CreativeEditingData creativeEditingData, UriRequestType uriRequestType, int i) {
        if (creativeEditingData == null || creativeEditingData.a() == null || creativeEditingData.a().equals(Filter.PassThrough.name()) || this.f10413b == null) {
            return null;
        }
        RectF[] rectFArr;
        if ((uriRequestType != UriRequestType.SHOW_EDITED_URI || creativeEditingData.c() == null) && i == 0) {
            rectFArr = (RectF[]) this.f10413b.toArray(new RectF[0]);
        } else {
            List<RectF> list = this.f10413b;
            RectF c = creativeEditingData.c();
            List arrayList = new ArrayList();
            Matrix matrix = new Matrix();
            if (c != null) {
                matrix.setRectToRect(c, f10412a, ScaleToFit.FILL);
            }
            matrix.postRotate((float) i, 0.5f, 0.5f);
            for (RectF rectF : list) {
                RectF rectF2 = new RectF(rectF);
                if (c == null || c.contains(rectF2)) {
                    matrix.mapRect(rectF2);
                    arrayList.add(rectF2);
                }
            }
            rectFArr = (RectF[]) arrayList.toArray(new RectF[0]);
        }
        FiltersRepeatedPostprocessor filtersRepeatedPostprocessor = (FiltersRepeatedPostprocessor) this.f10414c.get();
        filtersRepeatedPostprocessor.a(rectFArr);
        filtersRepeatedPostprocessor.a(creativeEditingData.a());
        return filtersRepeatedPostprocessor;
    }
}
