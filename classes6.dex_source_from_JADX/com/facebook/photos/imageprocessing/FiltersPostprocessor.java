package com.facebook.photos.imageprocessing;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.inject.Assisted;
import com.facebook.photos.creativeediting.model.Filter;
import com.facebook.photos.imageprocessing.FiltersEngine.Session;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import javax.inject.Inject;

/* compiled from: header_text_field */
public class FiltersPostprocessor extends BasePostprocessor {
    private final ImmutableList<RectF> f13045a;
    private final String f13046b;
    private FiltersEngine f13047c;

    @Inject
    public FiltersPostprocessor(@Assisted String str, @Assisted ImmutableList<RectF> immutableList, FiltersEngine filtersEngine) {
        this.f13045a = immutableList;
        this.f13046b = str;
        this.f13047c = filtersEngine;
    }

    public final void m20389a(Bitmap bitmap) {
        if (this.f13046b != null && !Filter.PassThrough.name().equals(this.f13046b) && this.f13045a != null) {
            Session session = null;
            try {
                session = this.f13047c.m20386a(bitmap);
                session.m20372a((RectF[]) this.f13045a.toArray(new RectF[0]));
                session.m20373a(bitmap, this.f13046b);
                if (session != null) {
                    try {
                        session.close();
                    } catch (IOException e) {
                    }
                }
            } catch (Throwable th) {
                if (session != null) {
                    try {
                        session.close();
                    } catch (IOException e2) {
                    }
                }
            }
        }
    }

    public final String m20388a() {
        return FiltersPostprocessor.class.getSimpleName();
    }
}
