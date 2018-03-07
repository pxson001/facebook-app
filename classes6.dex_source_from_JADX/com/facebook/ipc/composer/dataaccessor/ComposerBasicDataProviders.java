package com.facebook.ipc.composer.dataaccessor;

import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.google.common.collect.ImmutableList;

/* compiled from: local_search(%s) */
public class ComposerBasicDataProviders {

    /* compiled from: local_search(%s) */
    public interface ProvidesIsBackoutDraft {
        boolean m18218z();
    }

    /* compiled from: local_search(%s) */
    public interface ProvidesIsComposerDrawn {
        boolean m18219B();
    }

    /* compiled from: local_search(%s) */
    public interface ProvidesIsImplicitLocationSupported {
        boolean m18220G();
    }

    /* compiled from: local_search(%s) */
    public interface ProvidesIsMultimediaSupported {
        boolean m18221K();
    }

    /* compiled from: local_search(%s) */
    public interface ProvidesSessionId {
        String ab();
    }

    /* compiled from: local_search(%s) */
    public interface ProvidesTargetAlbum {
        GraphQLAlbum ad();
    }

    /* compiled from: local_search(%s) */
    public interface ProvidesTextWithEntities {
        GraphQLTextWithEntities ae();
    }

    /* compiled from: local_search(%s) */
    public interface ProvidesTopics {
        ImmutableList<GraphQLExploreFeed> af();
    }

    private ComposerBasicDataProviders() {
    }
}
