package com.facebook.graphql.model;

import com.facebook.debug.log.BLog;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.Flattenable.VirtualFlattenableResolver;
import com.facebook.graphql.enums.GraphQLObjectType.ObjectType;
import com.facebook.graphql.typecodes.GraphQLTypeCodes;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.base.Preconditions;

/* compiled from: mFillColor */
public class VirtualFlattenableResolverImpl implements VirtualFlattenableResolver {
    public static final VirtualFlattenableResolverImpl f15617a = new VirtualFlattenableResolverImpl();

    public final short mo2869a(Flattenable flattenable) {
        Preconditions.checkNotNull(flattenable);
        Preconditions.checkArgument(flattenable instanceof GraphQLVisitableModel);
        return GraphQLTypeCodes.a(ObjectType.m22303a(((GraphQLVisitableModel) flattenable).jK_()));
    }

    public final Flattenable mo2868a(short s) {
        if (s <= (short) 0) {
            return null;
        }
        short s2 = (short) (s - 1);
        if (s2 >= GraphQLClassList.f15618a.length) {
            return null;
        }
        String str = GraphQLClassList.f15618a[s2];
        if (str == null) {
            return null;
        }
        try {
            return (Flattenable) Class.forName(str).newInstance();
        } catch (Throwable e) {
            BLog.c("FlatBuffer", e, "Could not create instance for GraphQL type: %s", new Object[]{str});
            return null;
        } catch (Throwable e2) {
            BLog.c("FlatBuffer", e2, "IllegalAccess when creating instance for GraphQL type: %s", new Object[]{str});
            return null;
        } catch (Throwable e22) {
            BLog.c("FlatBuffer", e22, "ClassNotFoundException when creating instance for GraphQL type: %s", new Object[]{str});
            return null;
        }
    }
}
