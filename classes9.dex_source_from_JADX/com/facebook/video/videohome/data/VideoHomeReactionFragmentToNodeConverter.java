package com.facebook.video.videohome.data;

import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.common.ReactionUnitComponentUtil;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
import com.google.common.collect.ImmutableList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: status_desc_full */
public class VideoHomeReactionFragmentToNodeConverter {

    /* compiled from: status_desc_full */
    public /* synthetic */ class C02641 {
        public static final /* synthetic */ int[] f2822a = new int[GraphQLReactionUnitComponentStyle.values().length];

        static {
            try {
                f2822a[GraphQLReactionUnitComponentStyle.PAGINATED_V_SCROLL_COMPONENTS_LIST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2822a[GraphQLReactionUnitComponentStyle.PAGINATED_V_SCROLL_GENERIC_COMPONENTS_LIST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2822a[GraphQLReactionUnitComponentStyle.PAGINATED_V_SCROLL_GENERIC_COMPONENTS_LIST_LIVE_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2822a[GraphQLReactionUnitComponentStyle.VERTICAL_COMPONENTS_LIST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static List<ReactionUnitComponentNode> m2710a(ReactionUnitFragment reactionUnitFragment) {
        List<ReactionUnitComponentNode> linkedList = new LinkedList();
        ImmutableList s = reactionUnitFragment.s();
        int size = s.size();
        for (int i = 0; i < size; i++) {
            List list;
            ReactionUnitComponentFields reactionUnitComponentFields = (ReactionUnitComponentModel) s.get(i);
            switch (C02641.f2822a[reactionUnitComponentFields.a().ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    List a = m2711a(reactionUnitFragment, ReactionUnitComponentUtil.a(reactionUnitComponentFields));
                    a.addAll(m2711a(reactionUnitFragment, ReactionUnitComponentUtil.a(reactionUnitComponentFields)));
                    list = a;
                    break;
                default:
                    list = Collections.singletonList(m2709a(reactionUnitFragment, reactionUnitComponentFields));
                    break;
            }
            linkedList.addAll(list);
        }
        return linkedList;
    }

    public static List<ReactionUnitComponentNode> m2711a(ReactionUnitFragment reactionUnitFragment, @Nullable List<? extends ReactionUnitComponentFields> list) {
        List<ReactionUnitComponentNode> linkedList = new LinkedList();
        if (list == null) {
            return linkedList;
        }
        for (ReactionUnitComponentFields a : list) {
            linkedList.add(m2709a(reactionUnitFragment, a));
        }
        return linkedList;
    }

    public static ReactionUnitComponentNode m2708a(ReactionUnitFragment reactionUnitFragment, int i) {
        return m2709a(reactionUnitFragment, (ReactionUnitComponentFields) reactionUnitFragment.s().get(i));
    }

    public static ReactionUnitComponentNode m2709a(ReactionUnitFragment reactionUnitFragment, ReactionUnitComponentFields reactionUnitComponentFields) {
        return new ReactionUnitComponentNode(reactionUnitComponentFields, reactionUnitFragment.d(), reactionUnitFragment.n(), reactionUnitFragment.j());
    }
}
