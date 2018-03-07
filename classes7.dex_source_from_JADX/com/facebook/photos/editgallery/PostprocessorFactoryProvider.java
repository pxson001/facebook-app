package com.facebook.photos.editgallery;

import android.graphics.RectF;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import java.util.List;

/* compiled from: lead_gen */
public class PostprocessorFactoryProvider extends AbstractAssistedProvider<PostprocessorFactory> {
    public final PostprocessorFactory m12268a(List<RectF> list) {
        return new PostprocessorFactory(list, IdBasedProvider.a(this, 9336));
    }
}
