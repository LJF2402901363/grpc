package com.grpc.server;

import lombok.Getter;

/**
 * 用户点赞的状态
 */
@Getter
public enum ActionStatusEnum {
    DEFAULT_TYPE_COLLECTION_POEM(1, "收藏诗词"),
    DEFAULT_TYPE_CANCEL_COLLECTION_POEM(2, "取消收藏诗词"),
    DEFAULT_TYPE_COLLECTION_ARTICLE(3, "收藏文章"),
    DEFAULT_TYPE_CANCEL_COLLECTION_ARTICLE(4, "取消收藏文章"),
    DEFAULT_TYPE_LIKE_POEM(5, "点赞诗词"),
    DEFAULT_TYPE_CANCEL_LIKE_POEM(6, "取消点赞诗词"),
    DEFAULT_TYPE_LIKE_ARTICLE(7, "点赞文章"),
    DEFAULT_TYPE_CANCEL_LIKE_ARTICLE(8, "取消点赞文章"),
    DEFAULT_TYPE_LIKE_COMMENT(9, "点赞评论"),
    DEFAULT_TYPE_CANCEL_LIKE_COMMENT(10, "取消点赞评论"),
    DEFAULT_TYPE_COLLECTION_COMMENT(11, "收藏评论"),
    DEFAULT_TYPE_CANCEL_COLLECTION_COMMENT(12, "取消收藏评论"),
    DEFAULT_TYPE_BROWSE_ARTICLE(13, "浏览文章"),
    DEFAULT_TYPE_BROWSE_POEM(14, "浏览诗词"),
    DEFAULT_TYPE_BROWSE_AUTHOR (15,"浏览诗人") ;
    private Integer code;

    private String msg;

    ActionStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
   public static ActionStatusEnum getActionStatusEnumByCode(Integer code){
        ActionStatusEnum[] values = ActionStatusEnum.values();
        for (ActionStatusEnum value : values) {
            if (value.getCode() == code){
                return value;
            }
        }
        return null;
    }
}