package com.facebook.productionprompts.common.v3;

import com.facebook.graphql.enums.GraphQLPromptConfidence;
import com.facebook.ipc.productionprompts.ui.v2.PromptPartDefinitionProps;

/* compiled from: request_notification */
public class PromptConfidenceHelper {
    public static boolean m4379a(PromptPartDefinitionProps promptPartDefinitionProps) {
        String str = promptPartDefinitionProps.a.b.e;
        return str.equals(GraphQLPromptConfidence.VERY_HIGH.toString()) || str.equals(GraphQLPromptConfidence.HIGH.toString());
    }
}
