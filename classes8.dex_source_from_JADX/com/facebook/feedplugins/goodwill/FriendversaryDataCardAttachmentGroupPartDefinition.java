package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackDataPoint;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: graph_search_results_page_videos */
public class FriendversaryDataCardAttachmentGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static FriendversaryDataCardAttachmentGroupPartDefinition f12241e;
    private static final Object f12242f = new Object();
    private final FriendversaryDataCardAttachmentHeaderPartDefinition f12243a;
    private final FriendversaryDataCardAttachmentHeaderTextPartDefinition f12244b;
    private final FriendversaryDataCardAttachmentDataPointPartDefinition f12245c;
    private final float f12246d = 8.0f;

    private static FriendversaryDataCardAttachmentGroupPartDefinition m14210b(InjectorLike injectorLike) {
        return new FriendversaryDataCardAttachmentGroupPartDefinition(FriendversaryDataCardAttachmentHeaderPartDefinition.m14213a(injectorLike), FriendversaryDataCardAttachmentHeaderTextPartDefinition.m14222a(injectorLike), FriendversaryDataCardAttachmentDataPointPartDefinition.m14200a(injectorLike));
    }

    public final Object m14211a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        baseMultiRowSubParts.a(this.f12243a, feedProps);
        baseMultiRowSubParts.a(this.f12244b, feedProps);
        if (!(graphQLStoryAttachment == null || graphQLStoryAttachment.z() == null || graphQLStoryAttachment.z().bA() == null || graphQLStoryAttachment.z().bA().a() == null)) {
            GraphQLGoodwillThrowbackDataPoint graphQLGoodwillThrowbackDataPoint;
            UnmodifiableIterator it = graphQLStoryAttachment.z().bA().a().iterator();
            List arrayList = new ArrayList();
            while (it.hasNext()) {
                graphQLGoodwillThrowbackDataPoint = (GraphQLGoodwillThrowbackDataPoint) it.next();
                if (!(graphQLGoodwillThrowbackDataPoint == null || graphQLGoodwillThrowbackDataPoint.j() == null || TextUtils.isEmpty(graphQLGoodwillThrowbackDataPoint.j().a()) || graphQLGoodwillThrowbackDataPoint.a() == null)) {
                    arrayList.add(graphQLGoodwillThrowbackDataPoint);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Object obj2;
                graphQLGoodwillThrowbackDataPoint = (GraphQLGoodwillThrowbackDataPoint) it2.next();
                Position position = Position.MIDDLE;
                float f = 0.0f;
                if (AttachmentProps.a(feedProps, 2) != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 != null) {
                    f = 8.0f;
                    if (!it2.hasNext()) {
                        position = Position.BOTTOM;
                    }
                }
                baseMultiRowSubParts.a(this.f12245c, new FriendversaryDataCardAttachmentDataPointProps(graphQLGoodwillThrowbackDataPoint, feedProps, position, f));
            }
        }
        return null;
    }

    @Inject
    public FriendversaryDataCardAttachmentGroupPartDefinition(FriendversaryDataCardAttachmentHeaderPartDefinition friendversaryDataCardAttachmentHeaderPartDefinition, FriendversaryDataCardAttachmentHeaderTextPartDefinition friendversaryDataCardAttachmentHeaderTextPartDefinition, FriendversaryDataCardAttachmentDataPointPartDefinition friendversaryDataCardAttachmentDataPointPartDefinition) {
        this.f12243a = friendversaryDataCardAttachmentHeaderPartDefinition;
        this.f12244b = friendversaryDataCardAttachmentHeaderTextPartDefinition;
        this.f12245c = friendversaryDataCardAttachmentDataPointPartDefinition;
    }

    public final boolean m14212a(Object obj) {
        return true;
    }

    public static FriendversaryDataCardAttachmentGroupPartDefinition m14209a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendversaryDataCardAttachmentGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12242f) {
                FriendversaryDataCardAttachmentGroupPartDefinition friendversaryDataCardAttachmentGroupPartDefinition;
                if (a2 != null) {
                    friendversaryDataCardAttachmentGroupPartDefinition = (FriendversaryDataCardAttachmentGroupPartDefinition) a2.a(f12242f);
                } else {
                    friendversaryDataCardAttachmentGroupPartDefinition = f12241e;
                }
                if (friendversaryDataCardAttachmentGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14210b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12242f, b3);
                        } else {
                            f12241e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendversaryDataCardAttachmentGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
