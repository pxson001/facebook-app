package com.facebook.placetips.logging;

import com.facebook.graphql.enums.GraphQLPulsarScanQueryResultCode;

/* compiled from: scale_saturate */
public class PlaceTipsEmptyResponseException extends RuntimeException {
    public PlaceTipsEmptyResponseException(String str) {
        super(str);
    }

    public PlaceTipsEmptyResponseException(GraphQLPulsarScanQueryResultCode graphQLPulsarScanQueryResultCode, String str) {
        this(str + " -- ResultCode: " + graphQLPulsarScanQueryResultCode.toString());
    }
}
