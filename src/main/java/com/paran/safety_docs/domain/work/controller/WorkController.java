package com.paran.safety_docs.domain.work.controller;

import com.paran.safety_docs.domain.work.entity.Work;
import com.paran.safety_docs.domain.work.service.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        model.addAttribute("work", new Work());
        return "admin/work/create";
    }

    @PostMapping("/create")
    public String createWork(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam(value = "sopFile", required = false) MultipartFile sopFile,
            @RequestParam(value = "riskFile", required = false) MultipartFile riskFile
    ) {
        // TODO 저장 로직
        return "redirect:/home";
    }

    @GetMapping("/list")
    public String list(Model model) {
        // TODO 목록 조회 로직
        model.addAttribute("work", new Work());
        return "admin/work/list";
    }
}
