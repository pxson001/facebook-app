package com.facebook.orca.threadview.messagelist;

import com.facebook.graphql.enums.GraphQLExtensibleMessageAdminTextType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.attachments.ImageAttachmentData;
import com.facebook.messaging.attachments.ImageAttachmentData.Orientation;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.modifiers.SlashMeAdminMessageFeature;
import com.facebook.messaging.threadview.rows.RowItem;
import com.facebook.messaging.threadview.rows.RowMessageItem;
import com.facebook.messaging.threadview.rows.RowReceiptItem;
import com.facebook.messaging.threadview.rows.RowViewType;
import com.facebook.messaging.threadview.rows.SimpleRowItem;
import java.util.List;
import javax.inject.Inject;

/* compiled from: map_center */
public class MessageListViewTypeHelper {
    private final MessageUtil f8256a;
    public final SlashMeAdminMessageFeature f8257b;

    public static MessageListViewTypeHelper m8236b(InjectorLike injectorLike) {
        return new MessageListViewTypeHelper(MessageUtil.a(injectorLike), SlashMeAdminMessageFeature.m3203b(injectorLike));
    }

    @Inject
    public MessageListViewTypeHelper(MessageUtil messageUtil, SlashMeAdminMessageFeature slashMeAdminMessageFeature) {
        this.f8256a = messageUtil;
        this.f8257b = slashMeAdminMessageFeature;
    }

    public final RowViewType m8237a(RowItem rowItem) {
        RowViewType rowViewType;
        switch (rowItem.mo131b()) {
            case BUSINESS_NUX:
                return RowViewType.BUSINESS_NUX;
            case BUSINESS_GREETING:
                return RowViewType.BUSINESS_GREETING;
            case EMOJILIKE_PICKER:
                return RowViewType.EMOJILIKE_PICKER;
            case GLOBALLY_DELETED_MESSAGE_PLACEHOLDER:
                return RowViewType.GLOBALLY_DELETED_MESSAGE_PLACEHOLDER;
            case GROUP_CREATED:
                return RowViewType.GROUP_CREATED;
            case HOT_LIKE_PREVIEW:
                return RowViewType.HOT_LIKE_PREVIEW;
            case MESSAGE:
                RowMessageItem rowMessageItem = (RowMessageItem) rowItem;
                Message message = rowMessageItem.f4732a;
                if (!(message.l == MessageType.CALL_LOG || message.l == MessageType.TELEPHONE_CALL_LOG || message.l == MessageType.SMS_LOG)) {
                    Object obj;
                    Object obj2;
                    if (message.I != null) {
                        if (message.I.c == GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_SETUP) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            obj2 = 1;
                            if (obj2 == null) {
                                rowViewType = RowViewType.JOURNEY_PROMPT_SETUP;
                            } else {
                                if (message.I != null) {
                                    if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_COLOR) {
                                        obj = 1;
                                    } else {
                                        obj = null;
                                    }
                                    if (obj != null) {
                                        obj2 = 1;
                                        if (obj2 == null) {
                                            rowViewType = RowViewType.JOURNEY_PROMPT_COLOR;
                                        } else {
                                            if (message.I != null) {
                                                if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_LIKE) {
                                                    obj = 1;
                                                } else {
                                                    obj = null;
                                                }
                                                if (obj != null) {
                                                    obj2 = 1;
                                                    if (obj2 == null) {
                                                        rowViewType = RowViewType.JOURNEY_PROMPT_LIKE;
                                                    } else {
                                                        if (message.I != null) {
                                                            if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_NICKNAME) {
                                                                obj = 1;
                                                            } else {
                                                                obj = null;
                                                            }
                                                            if (obj != null) {
                                                                obj2 = 1;
                                                                if (obj2 == null) {
                                                                    rowViewType = RowViewType.JOURNEY_PROMPT_NICKNAME;
                                                                } else {
                                                                    if (message.I != null) {
                                                                        if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_BOT) {
                                                                            obj = 1;
                                                                        } else {
                                                                            obj = null;
                                                                        }
                                                                        if (obj != null) {
                                                                            obj2 = 1;
                                                                            if (obj2 == null) {
                                                                                rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                                            } else {
                                                                                if (!MessageUtil.H(message) || MessageUtil.s(message) || MessageUtil.L(message)) {
                                                                                    obj2 = 1;
                                                                                } else {
                                                                                    obj2 = null;
                                                                                }
                                                                                if (obj2 != null) {
                                                                                    if (MessageUtil.I(message)) {
                                                                                        if (MessageUtil.B(message) || this.f8257b.m3205a(message)) {
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    obj2 = null;
                                                                    if (obj2 == null) {
                                                                        if (MessageUtil.H(message)) {
                                                                            break;
                                                                        }
                                                                        obj2 = 1;
                                                                        rowViewType = obj2 != null ? MessageUtil.I(message) ? RowViewType.ADMIN_MESSAGE : RowViewType.RIDE_ORDERED_MESSAGE : RowViewType.ADMIN_TEXT_WITH_LINK;
                                                                    } else {
                                                                        rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        obj2 = null;
                                                        if (obj2 == null) {
                                                            if (message.I != null) {
                                                                if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_BOT) {
                                                                    obj = null;
                                                                } else {
                                                                    obj = 1;
                                                                }
                                                                if (obj != null) {
                                                                    obj2 = 1;
                                                                    if (obj2 == null) {
                                                                        rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                                    } else {
                                                                        if (MessageUtil.H(message)) {
                                                                        }
                                                                        obj2 = 1;
                                                                        if (obj2 != null) {
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            obj2 = null;
                                                            if (obj2 == null) {
                                                                if (MessageUtil.H(message)) {
                                                                }
                                                                obj2 = 1;
                                                                if (obj2 != null) {
                                                                    if (MessageUtil.I(message)) {
                                                                    }
                                                                }
                                                            } else {
                                                                rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                            }
                                                        } else {
                                                            rowViewType = RowViewType.JOURNEY_PROMPT_NICKNAME;
                                                        }
                                                    }
                                                }
                                            }
                                            obj2 = null;
                                            if (obj2 == null) {
                                                if (message.I != null) {
                                                    if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_NICKNAME) {
                                                        obj = null;
                                                    } else {
                                                        obj = 1;
                                                    }
                                                    if (obj != null) {
                                                        obj2 = 1;
                                                        if (obj2 == null) {
                                                            rowViewType = RowViewType.JOURNEY_PROMPT_NICKNAME;
                                                        } else {
                                                            if (message.I != null) {
                                                                if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_BOT) {
                                                                    obj = 1;
                                                                } else {
                                                                    obj = null;
                                                                }
                                                                if (obj != null) {
                                                                    obj2 = 1;
                                                                    if (obj2 == null) {
                                                                        rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                                    } else {
                                                                        if (MessageUtil.H(message)) {
                                                                        }
                                                                        obj2 = 1;
                                                                        if (obj2 != null) {
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            obj2 = null;
                                                            if (obj2 == null) {
                                                                if (MessageUtil.H(message)) {
                                                                }
                                                                obj2 = 1;
                                                                if (obj2 != null) {
                                                                    if (MessageUtil.I(message)) {
                                                                    }
                                                                }
                                                            } else {
                                                                rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                            }
                                                        }
                                                    }
                                                }
                                                obj2 = null;
                                                if (obj2 == null) {
                                                    if (message.I != null) {
                                                        if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_BOT) {
                                                            obj = null;
                                                        } else {
                                                            obj = 1;
                                                        }
                                                        if (obj != null) {
                                                            obj2 = 1;
                                                            if (obj2 == null) {
                                                                rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                            } else {
                                                                if (MessageUtil.H(message)) {
                                                                }
                                                                obj2 = 1;
                                                                if (obj2 != null) {
                                                                }
                                                            }
                                                        }
                                                    }
                                                    obj2 = null;
                                                    if (obj2 == null) {
                                                        if (MessageUtil.H(message)) {
                                                        }
                                                        obj2 = 1;
                                                        if (obj2 != null) {
                                                            if (MessageUtil.I(message)) {
                                                            }
                                                        }
                                                    } else {
                                                        rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                    }
                                                } else {
                                                    rowViewType = RowViewType.JOURNEY_PROMPT_NICKNAME;
                                                }
                                            } else {
                                                rowViewType = RowViewType.JOURNEY_PROMPT_LIKE;
                                            }
                                        }
                                    }
                                }
                                obj2 = null;
                                if (obj2 == null) {
                                    if (message.I != null) {
                                        if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_LIKE) {
                                            obj = null;
                                        } else {
                                            obj = 1;
                                        }
                                        if (obj != null) {
                                            obj2 = 1;
                                            if (obj2 == null) {
                                                rowViewType = RowViewType.JOURNEY_PROMPT_LIKE;
                                            } else {
                                                if (message.I != null) {
                                                    if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_NICKNAME) {
                                                        obj = 1;
                                                    } else {
                                                        obj = null;
                                                    }
                                                    if (obj != null) {
                                                        obj2 = 1;
                                                        if (obj2 == null) {
                                                            rowViewType = RowViewType.JOURNEY_PROMPT_NICKNAME;
                                                        } else {
                                                            if (message.I != null) {
                                                                if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_BOT) {
                                                                    obj = 1;
                                                                } else {
                                                                    obj = null;
                                                                }
                                                                if (obj != null) {
                                                                    obj2 = 1;
                                                                    if (obj2 == null) {
                                                                        rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                                    } else {
                                                                        if (MessageUtil.H(message)) {
                                                                        }
                                                                        obj2 = 1;
                                                                        if (obj2 != null) {
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            obj2 = null;
                                                            if (obj2 == null) {
                                                                if (MessageUtil.H(message)) {
                                                                }
                                                                obj2 = 1;
                                                                if (obj2 != null) {
                                                                    if (MessageUtil.I(message)) {
                                                                    }
                                                                }
                                                            } else {
                                                                rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                            }
                                                        }
                                                    }
                                                }
                                                obj2 = null;
                                                if (obj2 == null) {
                                                    if (message.I != null) {
                                                        if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_BOT) {
                                                            obj = null;
                                                        } else {
                                                            obj = 1;
                                                        }
                                                        if (obj != null) {
                                                            obj2 = 1;
                                                            if (obj2 == null) {
                                                                rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                            } else {
                                                                if (MessageUtil.H(message)) {
                                                                }
                                                                obj2 = 1;
                                                                if (obj2 != null) {
                                                                }
                                                            }
                                                        }
                                                    }
                                                    obj2 = null;
                                                    if (obj2 == null) {
                                                        if (MessageUtil.H(message)) {
                                                        }
                                                        obj2 = 1;
                                                        if (obj2 != null) {
                                                            if (MessageUtil.I(message)) {
                                                            }
                                                        }
                                                    } else {
                                                        rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                    }
                                                } else {
                                                    rowViewType = RowViewType.JOURNEY_PROMPT_NICKNAME;
                                                }
                                            }
                                        }
                                    }
                                    obj2 = null;
                                    if (obj2 == null) {
                                        if (message.I != null) {
                                            if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_NICKNAME) {
                                                obj = null;
                                            } else {
                                                obj = 1;
                                            }
                                            if (obj != null) {
                                                obj2 = 1;
                                                if (obj2 == null) {
                                                    rowViewType = RowViewType.JOURNEY_PROMPT_NICKNAME;
                                                } else {
                                                    if (message.I != null) {
                                                        if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_BOT) {
                                                            obj = 1;
                                                        } else {
                                                            obj = null;
                                                        }
                                                        if (obj != null) {
                                                            obj2 = 1;
                                                            if (obj2 == null) {
                                                                rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                            } else {
                                                                if (MessageUtil.H(message)) {
                                                                }
                                                                obj2 = 1;
                                                                if (obj2 != null) {
                                                                }
                                                            }
                                                        }
                                                    }
                                                    obj2 = null;
                                                    if (obj2 == null) {
                                                        if (MessageUtil.H(message)) {
                                                        }
                                                        obj2 = 1;
                                                        if (obj2 != null) {
                                                            if (MessageUtil.I(message)) {
                                                            }
                                                        }
                                                    } else {
                                                        rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                    }
                                                }
                                            }
                                        }
                                        obj2 = null;
                                        if (obj2 == null) {
                                            if (message.I != null) {
                                                if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_BOT) {
                                                    obj = null;
                                                } else {
                                                    obj = 1;
                                                }
                                                if (obj != null) {
                                                    obj2 = 1;
                                                    if (obj2 == null) {
                                                        rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                    } else {
                                                        if (MessageUtil.H(message)) {
                                                        }
                                                        obj2 = 1;
                                                        if (obj2 != null) {
                                                        }
                                                    }
                                                }
                                            }
                                            obj2 = null;
                                            if (obj2 == null) {
                                                if (MessageUtil.H(message)) {
                                                }
                                                obj2 = 1;
                                                if (obj2 != null) {
                                                    if (MessageUtil.I(message)) {
                                                    }
                                                }
                                            } else {
                                                rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                            }
                                        } else {
                                            rowViewType = RowViewType.JOURNEY_PROMPT_NICKNAME;
                                        }
                                    } else {
                                        rowViewType = RowViewType.JOURNEY_PROMPT_LIKE;
                                    }
                                } else {
                                    rowViewType = RowViewType.JOURNEY_PROMPT_COLOR;
                                }
                            }
                            return rowViewType;
                        }
                    }
                    obj2 = null;
                    if (obj2 == null) {
                        if (message.I != null) {
                            if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_COLOR) {
                                obj = null;
                            } else {
                                obj = 1;
                            }
                            if (obj != null) {
                                obj2 = 1;
                                if (obj2 == null) {
                                    rowViewType = RowViewType.JOURNEY_PROMPT_COLOR;
                                } else {
                                    if (message.I != null) {
                                        if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_LIKE) {
                                            obj = 1;
                                        } else {
                                            obj = null;
                                        }
                                        if (obj != null) {
                                            obj2 = 1;
                                            if (obj2 == null) {
                                                rowViewType = RowViewType.JOURNEY_PROMPT_LIKE;
                                            } else {
                                                if (message.I != null) {
                                                    if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_NICKNAME) {
                                                        obj = 1;
                                                    } else {
                                                        obj = null;
                                                    }
                                                    if (obj != null) {
                                                        obj2 = 1;
                                                        if (obj2 == null) {
                                                            rowViewType = RowViewType.JOURNEY_PROMPT_NICKNAME;
                                                        } else {
                                                            if (message.I != null) {
                                                                if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_BOT) {
                                                                    obj = 1;
                                                                } else {
                                                                    obj = null;
                                                                }
                                                                if (obj != null) {
                                                                    obj2 = 1;
                                                                    if (obj2 == null) {
                                                                        rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                                    } else {
                                                                        if (MessageUtil.H(message)) {
                                                                        }
                                                                        obj2 = 1;
                                                                        if (obj2 != null) {
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            obj2 = null;
                                                            if (obj2 == null) {
                                                                if (MessageUtil.H(message)) {
                                                                }
                                                                obj2 = 1;
                                                                if (obj2 != null) {
                                                                    if (MessageUtil.I(message)) {
                                                                    }
                                                                }
                                                            } else {
                                                                rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                            }
                                                        }
                                                    }
                                                }
                                                obj2 = null;
                                                if (obj2 == null) {
                                                    if (message.I != null) {
                                                        if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_BOT) {
                                                            obj = null;
                                                        } else {
                                                            obj = 1;
                                                        }
                                                        if (obj != null) {
                                                            obj2 = 1;
                                                            if (obj2 == null) {
                                                                rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                            } else {
                                                                if (MessageUtil.H(message)) {
                                                                }
                                                                obj2 = 1;
                                                                if (obj2 != null) {
                                                                }
                                                            }
                                                        }
                                                    }
                                                    obj2 = null;
                                                    if (obj2 == null) {
                                                        if (MessageUtil.H(message)) {
                                                        }
                                                        obj2 = 1;
                                                        if (obj2 != null) {
                                                            if (MessageUtil.I(message)) {
                                                            }
                                                        }
                                                    } else {
                                                        rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                    }
                                                } else {
                                                    rowViewType = RowViewType.JOURNEY_PROMPT_NICKNAME;
                                                }
                                            }
                                        }
                                    }
                                    obj2 = null;
                                    if (obj2 == null) {
                                        if (message.I != null) {
                                            if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_NICKNAME) {
                                                obj = null;
                                            } else {
                                                obj = 1;
                                            }
                                            if (obj != null) {
                                                obj2 = 1;
                                                if (obj2 == null) {
                                                    rowViewType = RowViewType.JOURNEY_PROMPT_NICKNAME;
                                                } else {
                                                    if (message.I != null) {
                                                        if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_BOT) {
                                                            obj = 1;
                                                        } else {
                                                            obj = null;
                                                        }
                                                        if (obj != null) {
                                                            obj2 = 1;
                                                            if (obj2 == null) {
                                                                rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                            } else {
                                                                if (MessageUtil.H(message)) {
                                                                }
                                                                obj2 = 1;
                                                                if (obj2 != null) {
                                                                }
                                                            }
                                                        }
                                                    }
                                                    obj2 = null;
                                                    if (obj2 == null) {
                                                        if (MessageUtil.H(message)) {
                                                        }
                                                        obj2 = 1;
                                                        if (obj2 != null) {
                                                            if (MessageUtil.I(message)) {
                                                            }
                                                        }
                                                    } else {
                                                        rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                    }
                                                }
                                            }
                                        }
                                        obj2 = null;
                                        if (obj2 == null) {
                                            if (message.I != null) {
                                                if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_BOT) {
                                                    obj = null;
                                                } else {
                                                    obj = 1;
                                                }
                                                if (obj != null) {
                                                    obj2 = 1;
                                                    if (obj2 == null) {
                                                        rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                    } else {
                                                        if (MessageUtil.H(message)) {
                                                        }
                                                        obj2 = 1;
                                                        if (obj2 != null) {
                                                        }
                                                    }
                                                }
                                            }
                                            obj2 = null;
                                            if (obj2 == null) {
                                                if (MessageUtil.H(message)) {
                                                }
                                                obj2 = 1;
                                                if (obj2 != null) {
                                                    if (MessageUtil.I(message)) {
                                                    }
                                                }
                                            } else {
                                                rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                            }
                                        } else {
                                            rowViewType = RowViewType.JOURNEY_PROMPT_NICKNAME;
                                        }
                                    } else {
                                        rowViewType = RowViewType.JOURNEY_PROMPT_LIKE;
                                    }
                                }
                            }
                        }
                        obj2 = null;
                        if (obj2 == null) {
                            if (message.I != null) {
                                if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_LIKE) {
                                    obj = null;
                                } else {
                                    obj = 1;
                                }
                                if (obj != null) {
                                    obj2 = 1;
                                    if (obj2 == null) {
                                        rowViewType = RowViewType.JOURNEY_PROMPT_LIKE;
                                    } else {
                                        if (message.I != null) {
                                            if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_NICKNAME) {
                                                obj = 1;
                                            } else {
                                                obj = null;
                                            }
                                            if (obj != null) {
                                                obj2 = 1;
                                                if (obj2 == null) {
                                                    rowViewType = RowViewType.JOURNEY_PROMPT_NICKNAME;
                                                } else {
                                                    if (message.I != null) {
                                                        if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_BOT) {
                                                            obj = 1;
                                                        } else {
                                                            obj = null;
                                                        }
                                                        if (obj != null) {
                                                            obj2 = 1;
                                                            if (obj2 == null) {
                                                                rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                            } else {
                                                                if (MessageUtil.H(message)) {
                                                                }
                                                                obj2 = 1;
                                                                if (obj2 != null) {
                                                                }
                                                            }
                                                        }
                                                    }
                                                    obj2 = null;
                                                    if (obj2 == null) {
                                                        if (MessageUtil.H(message)) {
                                                        }
                                                        obj2 = 1;
                                                        if (obj2 != null) {
                                                            if (MessageUtil.I(message)) {
                                                            }
                                                        }
                                                    } else {
                                                        rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                    }
                                                }
                                            }
                                        }
                                        obj2 = null;
                                        if (obj2 == null) {
                                            if (message.I != null) {
                                                if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_BOT) {
                                                    obj = null;
                                                } else {
                                                    obj = 1;
                                                }
                                                if (obj != null) {
                                                    obj2 = 1;
                                                    if (obj2 == null) {
                                                        rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                    } else {
                                                        if (MessageUtil.H(message)) {
                                                        }
                                                        obj2 = 1;
                                                        if (obj2 != null) {
                                                        }
                                                    }
                                                }
                                            }
                                            obj2 = null;
                                            if (obj2 == null) {
                                                if (MessageUtil.H(message)) {
                                                }
                                                obj2 = 1;
                                                if (obj2 != null) {
                                                    if (MessageUtil.I(message)) {
                                                    }
                                                }
                                            } else {
                                                rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                            }
                                        } else {
                                            rowViewType = RowViewType.JOURNEY_PROMPT_NICKNAME;
                                        }
                                    }
                                }
                            }
                            obj2 = null;
                            if (obj2 == null) {
                                if (message.I != null) {
                                    if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_NICKNAME) {
                                        obj = null;
                                    } else {
                                        obj = 1;
                                    }
                                    if (obj != null) {
                                        obj2 = 1;
                                        if (obj2 == null) {
                                            rowViewType = RowViewType.JOURNEY_PROMPT_NICKNAME;
                                        } else {
                                            if (message.I != null) {
                                                if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_BOT) {
                                                    obj = 1;
                                                } else {
                                                    obj = null;
                                                }
                                                if (obj != null) {
                                                    obj2 = 1;
                                                    if (obj2 == null) {
                                                        rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                                    } else {
                                                        if (MessageUtil.H(message)) {
                                                        }
                                                        obj2 = 1;
                                                        if (obj2 != null) {
                                                        }
                                                    }
                                                }
                                            }
                                            obj2 = null;
                                            if (obj2 == null) {
                                                if (MessageUtil.H(message)) {
                                                }
                                                obj2 = 1;
                                                if (obj2 != null) {
                                                    if (MessageUtil.I(message)) {
                                                    }
                                                }
                                            } else {
                                                rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                            }
                                        }
                                    }
                                }
                                obj2 = null;
                                if (obj2 == null) {
                                    if (message.I != null) {
                                        if (message.I.c != GraphQLExtensibleMessageAdminTextType.JOURNEY_PROMPT_BOT) {
                                            obj = null;
                                        } else {
                                            obj = 1;
                                        }
                                        if (obj != null) {
                                            obj2 = 1;
                                            if (obj2 == null) {
                                                rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                            } else {
                                                if (MessageUtil.H(message)) {
                                                }
                                                obj2 = 1;
                                                if (obj2 != null) {
                                                }
                                            }
                                        }
                                    }
                                    obj2 = null;
                                    if (obj2 == null) {
                                        if (MessageUtil.H(message)) {
                                        }
                                        obj2 = 1;
                                        if (obj2 != null) {
                                            if (MessageUtil.I(message)) {
                                            }
                                        }
                                    } else {
                                        rowViewType = RowViewType.JOURNEY_PROMPT_BOT;
                                    }
                                } else {
                                    rowViewType = RowViewType.JOURNEY_PROMPT_NICKNAME;
                                }
                            } else {
                                rowViewType = RowViewType.JOURNEY_PROMPT_LIKE;
                            }
                        } else {
                            rowViewType = RowViewType.JOURNEY_PROMPT_COLOR;
                        }
                    } else {
                        rowViewType = RowViewType.JOURNEY_PROMPT_SETUP;
                    }
                    return rowViewType;
                }
                boolean z = rowMessageItem.f4739h;
                if (rowMessageItem.f4735d != null) {
                    rowViewType = z ? RowViewType.MESSAGE_WITH_AUDIO_ME_USER : RowViewType.MESSAGE_WITH_AUDIO;
                } else if (MessageUtil.W(message)) {
                    rowViewType = z ? RowViewType.MESSAGE_WITH_XMA_HSCROLL_ME_USER : RowViewType.MESSAGE_WITH_XMA_HSCROLL;
                } else if ((message.j == null || message.j.isEmpty()) && message.G == null) {
                    List list = rowMessageItem.f4734c;
                    switch (list == null ? 0 : list.size()) {
                        case 0:
                            if (!z) {
                                rowViewType = RowViewType.MESSAGE;
                                break;
                            }
                            rowViewType = RowViewType.MESSAGE_ME_USER;
                            break;
                        case 1:
                            RowViewType rowViewType2 = ((ImageAttachmentData) list.get(0)).c() == Orientation.LANDSCAPE ? z ? RowViewType.MESSAGE_WITH_1_IMAGE_LANDSCAPE_ME_USER : RowViewType.MESSAGE_WITH_1_IMAGE_LANDSCAPE : z ? RowViewType.MESSAGE_WITH_1_IMAGE_PORTRAIT_SQUARE_ME_USER : RowViewType.MESSAGE_WITH_1_IMAGE_PORTRAIT_SQUARE;
                            rowViewType = rowViewType2;
                            break;
                        case 2:
                            if (!z) {
                                rowViewType = RowViewType.MESSAGE_WITH_2_IMAGES;
                                break;
                            }
                            rowViewType = RowViewType.MESSAGE_WITH_2_IMAGES_ME_USER;
                            break;
                        case 3:
                            if (!z) {
                                rowViewType = RowViewType.MESSAGE_WITH_3_IMAGES;
                                break;
                            }
                            rowViewType = RowViewType.MESSAGE_WITH_3_IMAGES_ME_USER;
                            break;
                        case 4:
                            if (!z) {
                                rowViewType = RowViewType.MESSAGE_WITH_4_IMAGES;
                                break;
                            }
                            rowViewType = RowViewType.MESSAGE_WITH_4_IMAGES_ME_USER;
                            break;
                        case 5:
                            if (!z) {
                                rowViewType = RowViewType.MESSAGE_WITH_5_IMAGES;
                                break;
                            }
                            rowViewType = RowViewType.MESSAGE_WITH_5_IMAGES_ME_USER;
                            break;
                        default:
                            if (!z) {
                                rowViewType = RowViewType.MESSAGE_WITH_6_OR_MORE_IMAGES;
                                break;
                            }
                            rowViewType = RowViewType.MESSAGE_WITH_6_OR_MORE_IMAGES_ME_USER;
                            break;
                    }
                } else {
                    rowViewType = z ? RowViewType.MESSAGE_WITH_XMA_ME_USER : RowViewType.MESSAGE_WITH_XMA;
                }
                return rowViewType;
            case MONTAGE_STATUS:
                return RowViewType.MONTAGE_STATUS;
            case RECEIPT:
                RowReceiptItem rowReceiptItem = (RowReceiptItem) rowItem;
                rowViewType = rowReceiptItem.f4765h ? RowViewType.SEEN_HEADS : rowReceiptItem.f4764g ? RowViewType.RECEIPT_MESSAGE_ME_USER : RowViewType.RECEIPT_MESSAGE;
                return rowViewType;
            case SOCIAL_CONTEXT:
                return RowViewType.SOCIAL_CONTEXT;
            case SPACER:
                return RowViewType.SPACER_AFTER_LAST_MESSAGE;
            case THEME_PICKER:
                return RowViewType.THEME_PICKER;
            case TIMESTAMP_DIVIDER:
                return RowViewType.TIMESTAMP_DIVIDER;
            case TYPING:
                return RowViewType.TYPING;
            default:
                if (rowItem instanceof SimpleRowItem) {
                    return ((SimpleRowItem) rowItem).f4778b;
                }
                throw new IllegalArgumentException("Don't know how to get view type of " + rowItem.getClass().getSimpleName());
        }
    }

    public static MessageListViewTypeHelper m8235a(InjectorLike injectorLike) {
        return m8236b(injectorLike);
    }
}
