package com.facebook.timeline.header.externalLinks;

import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.ExternalLink;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.ExternalLinkModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.ExternalLinkModel.LinkTypeModel;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: files */
public class IntroCardExternalLinksHelper {
    public static boolean m11769a(@Nullable ImmutableList<? extends ExternalLink> immutableList, @Nullable ImmutableList<? extends ExternalLink> immutableList2) {
        if (immutableList == null) {
            if (immutableList2 == null) {
                return true;
            }
            return false;
        } else if (immutableList2 == null || immutableList.size() != immutableList2.size()) {
            return false;
        } else {
            for (int i = 0; i < immutableList.size(); i++) {
                Object obj;
                ExternalLinkModel externalLinkModel = (ExternalLinkModel) immutableList.get(i);
                ExternalLinkModel externalLinkModel2 = (ExternalLinkModel) immutableList2.get(i);
                if (Objects.equal(externalLinkModel.c(), externalLinkModel2.c()) && Objects.equal(externalLinkModel.d(), externalLinkModel2.d())) {
                    LinkTypeModel b = externalLinkModel.b();
                    LinkTypeModel b2 = externalLinkModel2.b();
                    boolean equal = b == null ? b2 == null : Objects.equal(b.a(), b2.a());
                    if (equal) {
                        DefaultImageFields a = externalLinkModel.a();
                        DefaultImageFields a2 = externalLinkModel2.a();
                        equal = a == null ? a2 == null : Objects.equal(a.b(), a2.b());
                        if (equal) {
                            obj = 1;
                            if (obj != null) {
                                return false;
                            }
                        }
                    }
                }
                obj = null;
                if (obj != null) {
                    return false;
                }
            }
            return true;
        }
    }
}
