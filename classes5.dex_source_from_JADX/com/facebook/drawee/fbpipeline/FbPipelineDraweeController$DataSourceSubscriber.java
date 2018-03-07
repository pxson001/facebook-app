package com.facebook.drawee.fbpipeline;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;

/* compiled from: [-x‐-―−ー－-／  ­​⁠　()（）［］.\[\]/~⁓∼～]*(\$\d[-x‐-―−ー－-／  ­​⁠　()（）［］.\[\]/~⁓∼～]*)+ */
class FbPipelineDraweeController$DataSourceSubscriber implements DataSubscriber<CloseableReference<CloseableImage>> {
    final /* synthetic */ FbPipelineDraweeController f11972a;

    public FbPipelineDraweeController$DataSourceSubscriber(FbPipelineDraweeController fbPipelineDraweeController) {
        this.f11972a = fbPipelineDraweeController;
    }

    public final void m19973a(DataSource<CloseableReference<CloseableImage>> dataSource) {
        if (dataSource.b()) {
            this.f11972a.a(FbPipelineDraweeController.a(this.f11972a) ? this.f11972a.e : null);
        }
    }

    public final void m19974b(DataSource<CloseableReference<CloseableImage>> dataSource) {
        this.f11972a.a(this.f11972a.e);
    }

    public final void m19975c(DataSource<CloseableReference<CloseableImage>> dataSource) {
    }

    public final void m19976d(DataSource<CloseableReference<CloseableImage>> dataSource) {
        this.f11972a.a(null);
    }
}
