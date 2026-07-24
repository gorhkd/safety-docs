package com.paran.safety_docs.domain.work.controller;

import com.paran.safety_docs.domain.work.dto.request.WorkCreateRequest;
import com.paran.safety_docs.domain.work.entity.Work;
import com.paran.safety_docs.domain.work.service.WorkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/admin/works")
@RequiredArgsConstructor
@Controller
public class WorkController {

    private final WorkService workService;

    @GetMapping
    public String workForm() {
        // TODO 작업건 수 및 최근 등록 작업 조회
        return "admin/home";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("workCreateRequest", new WorkCreateRequest());
        return "admin/work/create";
    }

    @PostMapping("/create")
    public String create(
            @Valid @ModelAttribute("workCreateRequest")
            WorkCreateRequest request,
            BindingResult bindingResult
    ) {
        validatePdf(
                request.getSopFile(),
                "sopFile",
                "SOP PDF 파일을 선택해주세요.",
                bindingResult
        );

        validatePdf(
                request.getRiskFile(),
                "riskFile",
                "위험성평가서 PDF 파일을 선택해주세요.",
                bindingResult
        );

        if (bindingResult.hasErrors()) {
            return "admin/work/create";
        }

        workService.create(request);

        return "redirect:/home";
    }

    @GetMapping("/list")
    public String list(Model model) {
        // TODO 목록 조회 로직
        model.addAttribute("work", new Work());
        return "admin/work/list";
    }


    private void validatePdf(
            MultipartFile file,
            String fieldName,
            String requiredMessage,
            BindingResult bindingResult
    ) {
        if (file == null || file.isEmpty()) {
            bindingResult.rejectValue(
                    fieldName,
                    "file.required",
                    requiredMessage
            );
            return;
        }

        String originalFilename = file.getOriginalFilename();

        if (originalFilename == null ||
                !originalFilename.toLowerCase().endsWith(".pdf")) {

            bindingResult.rejectValue(
                    fieldName,
                    "file.extension",
                    "PDF 파일만 업로드할 수 있습니다."
            );
        }

        if (!"application/pdf".equalsIgnoreCase(file.getContentType())) {
            bindingResult.rejectValue(
                    fieldName,
                    "file.contentType",
                    "PDF 형식의 파일만 업로드할 수 있습니다."
            );
        }
    }
}
