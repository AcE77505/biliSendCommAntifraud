package icu.freedomIntrovert.biliSendCommAntifraud.biliApis;

public class GeneralResponse<T> extends BaseResponse {
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_COMMENT_DELETED = 12022;
    public static final int CODE_COMMENT_CONTAIN_SENSITIVE = 12016;
    public static final int CODE_COMMENT_NOT_THIS = 12006;
    public static final int CODE_COMMENT_AREA_CLOSED = 12002;
    public T data;

    /**
     * 评论已不可见：12022 表示“已经被删除了”，无账号下取到该码即说明评论被 ShadowBan。
     */
    public static boolean isCommentUnavailable(int code) {
        return code == CODE_COMMENT_DELETED;
    }

    /**
     * 取不到这条评论（“没有该评论”）。它不是删除，也要当作“没找到”处理，
     * 由上层继续按有无账号的结果区分秒删、ShadowBan 与疑似审核。
     */
    public static boolean isCommentNotFound(int code) {
        return code == CODE_COMMENT_NOT_THIS;
    }

    /** 查找评论时表示“请求成功但没拿到这条评论”，应视为未找到而不是接口错误。 */
    public static boolean isCommentLookupMiss(int code) {
        return isCommentUnavailable(code) || isCommentNotFound(code);
    }
}
