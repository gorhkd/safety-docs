package com.paran.safety_docs.domain.work.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class WorkCreateRequest {

    @NotBlank(message = "작업명을 입력해주세요.")
    @Size(max = 100, message = "작업명은 100자 이하로 입력해주세요.")
    private String title;

    @NotBlank(message = "작업 설명을 입력해주세요.")
    @Size(max = 1000, message = "작업 설명은 1000자 이하로 입력해주세요.")
    private String description;

    private MultipartFile sopFile;

    private MultipartFile riskFile;
}
