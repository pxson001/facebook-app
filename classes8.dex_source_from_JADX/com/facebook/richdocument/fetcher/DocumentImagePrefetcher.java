package com.facebook.richdocument.fetcher;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.inject.Inject;

/* compiled from: presence_source */
public class DocumentImagePrefetcher {
    @Inject
    public ImagePipeline f5217a;
    private final Queue<String> f5218b = new LinkedList();
    private final List<String> f5219c = new ArrayList();

    /* compiled from: presence_source */
    public class ImagePrefetchSubscriber implements DataSubscriber {
        private final DocumentImagePrefetcher f5215a;
        private final String f5216b;

        public ImagePrefetchSubscriber(String str, DocumentImagePrefetcher documentImagePrefetcher) {
            this.f5216b = str;
            this.f5215a = documentImagePrefetcher;
        }

        public final void m5157c(DataSource dataSource) {
            if (this.f5215a != null) {
                DocumentImagePrefetcher.m5161b(this.f5215a, this.f5216b);
            }
        }

        public final void m5155a(DataSource dataSource) {
            if (dataSource != null) {
                dataSource.g();
            }
            if (this.f5215a == null) {
                return;
            }
            if (dataSource == null || dataSource.b()) {
                DocumentImagePrefetcher.m5161b(this.f5215a, this.f5216b);
            }
        }

        public final void m5156b(DataSource dataSource) {
            if (this.f5215a != null) {
                DocumentImagePrefetcher.m5161b(this.f5215a, this.f5216b);
            }
        }

        public final void m5158d(DataSource dataSource) {
        }
    }

    public static void m5159a(Object obj, Context context) {
        ((DocumentImagePrefetcher) obj).f5217a = ImagePipelineMethodAutoProvider.a(FbInjector.get(context));
    }

    public DocumentImagePrefetcher(Context context) {
        Class cls = DocumentImagePrefetcher.class;
        m5159a(this, context);
    }

    public final synchronized void m5164a(String str) {
        if (!StringUtil.a(str)) {
            this.f5218b.add(str);
            m5160b();
        }
    }

    public final synchronized void m5163a() {
        this.f5218b.clear();
        this.f5219c.clear();
    }

    public static synchronized void m5161b(DocumentImagePrefetcher documentImagePrefetcher, String str) {
        synchronized (documentImagePrefetcher) {
            documentImagePrefetcher.f5219c.remove(str);
            documentImagePrefetcher.m5160b();
        }
    }

    private synchronized void m5160b() {
        if (this.f5219c.size() < 3) {
            m5162c();
        }
    }

    private synchronized void m5162c() {
        String str = (String) this.f5218b.poll();
        if (str != null) {
            ImageRequest a = ImageRequest.a(str);
            if (a != null) {
                DataSource d = this.f5217a.d(a, CallerContext.a(DocumentImagePrefetcher.class));
                this.f5219c.add(str);
                d.a(new ImagePrefetchSubscriber(str, this), MoreExecutors.a());
            }
        }
    }
}
