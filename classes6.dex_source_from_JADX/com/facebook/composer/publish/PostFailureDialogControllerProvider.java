package com.facebook.composer.publish;

import android.content.Context;
import com.facebook.bugreporter.BugReporter;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.xconfig.core.XConfigReader;

/* compiled from: pictureForShareLink */
public class PostFailureDialogControllerProvider extends AbstractAssistedProvider<PostFailureDialogController> {
    public final PostFailureDialogController m11575a(String str) {
        return new PostFailureDialogController((Context) getInstance(Context.class), FbObjectMapperMethodAutoProvider.a(this), BugReporter.a(this), PendingStoryStore.a(this), Handler_ForUiThreadMethodAutoProvider.b(this), str, XConfigReader.a(this));
    }
}
