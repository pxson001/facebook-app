package com.facebook.feedplugins.musicpreview;

import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.abtest.qe.framework.QuickExperimentControllerImpl;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLMusicType;
import com.facebook.graphql.model.GraphQLApplication;
import com.facebook.graphql.model.GraphQLAudio;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLOpenGraphObject;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: composer_saved_session_creation_failed */
public class MusicPreviewUtils {
    public final QuickExperimentController f8101a;
    public final MusicPreviewQuickExperiment f8102b;

    /* compiled from: composer_saved_session_creation_failed */
    public class MusicAttachmentData {
        final GraphQLMusicType f8096a;
        public final GraphQLApplication f8097b;
        public final List<String> f8098c;
        public final ImmutableList<GraphQLOpenGraphObject> f8099d;
        public final ImmutableList<GraphQLAudio> f8100e;

        public MusicAttachmentData(GraphQLMusicType graphQLMusicType, @Nullable GraphQLApplication graphQLApplication, List<String> list, ImmutableList<GraphQLOpenGraphObject> immutableList, ImmutableList<GraphQLAudio> immutableList2) {
            this.f8096a = graphQLMusicType;
            this.f8097b = graphQLApplication;
            this.f8098c = list;
            this.f8099d = immutableList;
            this.f8100e = immutableList2;
        }
    }

    public static MusicPreviewUtils m9127b(InjectorLike injectorLike) {
        return new MusicPreviewUtils((QuickExperimentController) QuickExperimentControllerImpl.a(injectorLike), MusicPreviewQuickExperiment.a(injectorLike));
    }

    @Inject
    public MusicPreviewUtils(QuickExperimentController quickExperimentController, MusicPreviewQuickExperiment musicPreviewQuickExperiment) {
        this.f8101a = quickExperimentController;
        this.f8102b = musicPreviewQuickExperiment;
    }

    public final boolean m9129a(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment == null) {
            return false;
        }
        if (graphQLStoryAttachment.x() == null || graphQLStoryAttachment.x().isEmpty()) {
            return m9128c(graphQLStoryAttachment);
        }
        return m9126a(graphQLStoryAttachment.x());
    }

    private boolean m9126a(ImmutableList<GraphQLStoryAttachment> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (!m9128c((GraphQLStoryAttachment) immutableList.get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean m9128c(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (StringUtil.a(graphQLStoryAttachment.A())) {
            return false;
        }
        GraphQLNode z = graphQLStoryAttachment.z();
        if (z == null) {
            return false;
        }
        if (z.j() != null && z.j().g() == -1221639264) {
            return false;
        }
        GraphQLMusicType C;
        GraphQLApplication k;
        List j;
        ImmutableList D;
        ImmutableList K;
        GraphQLNode z2 = graphQLStoryAttachment.z();
        if (z2.eK() != null) {
            C = z2.eK().C();
            k = z2.eK().k();
            j = z2.eK().j();
            D = z2.eK().D();
            K = z2.eK().K();
        } else if (z2.fZ() != null) {
            C = z2.fZ().eM();
            k = z2.T();
            j = z2.fZ().J();
            D = z2.fZ().eN();
            K = z2.fZ().fT();
        } else {
            C = z2.eM();
            k = z2.T();
            j = z2.J();
            D = z2.eN();
            K = z2.fT();
        }
        MusicAttachmentData musicAttachmentData = new MusicAttachmentData(C, k, j, D, K);
        if (musicAttachmentData.f8096a != GraphQLMusicType.SONG) {
            return false;
        }
        Object obj;
        if (graphQLStoryAttachment.r() == null || graphQLStoryAttachment.r().S() == null || StringUtil.a(graphQLStoryAttachment.r().S().b())) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            return false;
        }
        if (musicAttachmentData.f8097b == null || musicAttachmentData.f8097b.j() == null || musicAttachmentData.f8097b.j().l() == null || StringUtil.a(musicAttachmentData.f8097b.y()) || musicAttachmentData.f8097b.O() == null || musicAttachmentData.f8097b.O().b() == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            return false;
        }
        int i;
        if (musicAttachmentData.f8098c == null || musicAttachmentData.f8098c.isEmpty() || Strings.isNullOrEmpty((String) musicAttachmentData.f8098c.get(0))) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            return false;
        }
        if (musicAttachmentData.f8099d == null || musicAttachmentData.f8099d.isEmpty() || musicAttachmentData.f8099d.get(0) == null || StringUtil.a(((GraphQLOpenGraphObject) musicAttachmentData.f8099d.get(0)).E())) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            return false;
        }
        if (musicAttachmentData.f8100e == null || musicAttachmentData.f8100e.isEmpty() || musicAttachmentData.f8100e.get(0) == null || ((GraphQLAudio) musicAttachmentData.f8100e.get(0)).a() == null) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            return true;
        }
        return false;
    }
}
