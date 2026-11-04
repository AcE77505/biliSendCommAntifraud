package icu.freedomIntrovert.biliSendCommAntifraud.biliApis;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GeneralResponseTest {
    @Test
    public void commentUnavailableIsOnlyDeleted() {
        assertTrue(GeneralResponse.isCommentUnavailable(GeneralResponse.CODE_COMMENT_DELETED));
        assertFalse(GeneralResponse.isCommentUnavailable(GeneralResponse.CODE_COMMENT_NOT_THIS));
    }

    @Test
    public void notThisIsCommentNotFound() {
        assertTrue(GeneralResponse.isCommentNotFound(GeneralResponse.CODE_COMMENT_NOT_THIS));
        assertFalse(GeneralResponse.isCommentNotFound(GeneralResponse.CODE_COMMENT_DELETED));
    }

    @Test
    public void lookupMissCoversBothCodes() {
        assertTrue(GeneralResponse.isCommentLookupMiss(GeneralResponse.CODE_COMMENT_DELETED));
        assertTrue(GeneralResponse.isCommentLookupMiss(GeneralResponse.CODE_COMMENT_NOT_THIS));
    }

    @Test
    public void unrelatedCodesAreNotCommentUnavailable() {
        assertFalse(GeneralResponse.isCommentUnavailable(GeneralResponse.CODE_SUCCESS));
        assertFalse(GeneralResponse.isCommentUnavailable(GeneralResponse.CODE_COMMENT_CONTAIN_SENSITIVE));
        assertFalse(GeneralResponse.isCommentLookupMiss(GeneralResponse.CODE_COMMENT_AREA_CLOSED));
    }
}
