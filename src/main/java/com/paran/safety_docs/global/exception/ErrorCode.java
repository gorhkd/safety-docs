package com.paran.safety_docs.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    // 공통
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "C001", "서버 오류가 발생했습니다."),
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "C002", "잘못된 입력입니다."),
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, "C003", "존재하지 않는 리소스입니다."),
    INVALID_FILE_TYPE(HttpStatus.BAD_REQUEST, "C004", "지원하지 않는 파일 형식입니다."),
    FILE_UPLOAD_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "C005", "파일 업로드에 실패했습니다."),

    // 사용자 인증 (UserAuth)
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "UA001", "사용자를 찾을 수 없습니다."),

    // 템플릿 (Template)
    TEMPLATE_NOT_FOUND(HttpStatus.NOT_FOUND, "T001", "템플릿을 찾을 수 없습니다."),
    DUPLICATE_TEMPLATE(HttpStatus.CONFLICT, "T002", "이미 동일한 템플릿이 존재합니다."),
    TEMPLATE_UPLOAD_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "T003", "템플릿 업로드에 실패했습니다."),
    INVALID_TEMPLATE_META(HttpStatus.BAD_REQUEST, "T004", "템플릿 메타 정보가 유효하지 않습니다."),
    TEMPLATE_ACCESS_DENIED(HttpStatus.FORBIDDEN, "T005", "템플릿에 대한 수정 권한이 없습니다."),

    // 파일 업로드 (File)
    EMPTY_FILE(HttpStatus.BAD_REQUEST, "F001", "업로드할 파일이 비어 있습니다."),
    UNSUPPORTED_EXTENSION(HttpStatus.BAD_REQUEST, "F002", "지원하지 않는 파일 확장자입니다."),
    FILE_SAVE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "F003", "파일 저장 중 오류가 발생했습니다."),
    FILE_TOO_LARGE(HttpStatus.BAD_REQUEST, "F004", "파일 크기가 허용치를 초과했습니다."),
    INVALID_FILENAME(HttpStatus.BAD_REQUEST, "F005", "파일 이름을 확인할 수 없습니다."),
    FILE_DELETE_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "F006", "파일 삭제에 실패했습니다."),
    TEMPLATE_FILE_NOT_FOUND(HttpStatus.NOT_FOUND, "F007", "해당 파일이 존재하지 않습니다."),

    // 템플릿 다운로드 (TemplateDownload)
    DOWNLOAD_LIMIT_EXCEEDED(HttpStatus.BAD_REQUEST, "TD001", "다운로드 횟수를 초과했습니다."),
    DOWNLOAD_NOT_FOUND(HttpStatus.NOT_FOUND, "TD002", "다운로드 내역이 존재하지 않습니다."),
    FILE_READ_ERROR(HttpStatus.NOT_FOUND, "TD003", "해당 파일을 불러올 수 없습니다."),
    INVALID_FILE_PATH(HttpStatus.BAD_REQUEST, "TD004", "잘못된 파일 경로입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
