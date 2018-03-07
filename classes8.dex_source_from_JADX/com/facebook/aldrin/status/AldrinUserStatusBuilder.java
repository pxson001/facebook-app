package com.facebook.aldrin.status;

import com.facebook.graphql.enums.GraphQLTosRegionCodeEnum;
import com.facebook.graphql.enums.GraphQLTosTransitionTypeEnum;

/* compiled from: layout_spec_version */
public class AldrinUserStatusBuilder {
    public GraphQLTosRegionCodeEnum f10374a = GraphQLTosRegionCodeEnum.GENERAL;
    public GraphQLTosRegionCodeEnum f10375b = GraphQLTosRegionCodeEnum.GENERAL;
    public GraphQLTosTransitionTypeEnum f10376c = GraphQLTosTransitionTypeEnum.NOOP;
    public boolean f10377d = false;
    public boolean f10378e = false;
    public String f10379f = null;
    public String f10380g = null;
    public String f10381h = null;
    public String f10382i = null;
    public long f10383j = 0;
    public String f10384k = null;

    public final AldrinUserStatus m12181l() {
        return new AldrinUserStatus(this);
    }
}
