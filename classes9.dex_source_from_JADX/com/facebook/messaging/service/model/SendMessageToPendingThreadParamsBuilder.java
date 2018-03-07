package com.facebook.messaging.service.model;

import com.facebook.fbtrace.FbTraceNode;
import com.facebook.messaging.model.messages.Message;
import com.facebook.user.model.UserIdentifier;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: console */
public class SendMessageToPendingThreadParamsBuilder {
    public Message f17323a;
    public ImmutableList<UserIdentifier> f17324b;
    public FbTraceNode f17325c = FbTraceNode.a;
}
