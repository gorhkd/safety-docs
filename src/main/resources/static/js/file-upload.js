document.querySelectorAll(".upload-box").forEach((uploadBox) => {
    const inputId = uploadBox.dataset.input;
    const fileInput = document.getElementById(inputId);
    const fileNameElement = uploadBox.querySelector(".selected-file-name");

    function updateFileName() {
        const file = fileInput.files?.[0];

        if (!file) {
            fileNameElement.textContent = "선택된 파일 없음";
            fileNameElement.classList.remove("visible");
            return;
        }

        fileNameElement.textContent = file.name;
        fileNameElement.classList.add("visible");
    }

    uploadBox.addEventListener("dragover", (event) => {
        event.preventDefault();
        uploadBox.classList.add("dragging");
    });

    uploadBox.addEventListener("dragleave", () => {
        uploadBox.classList.remove("dragging");
    });

    uploadBox.addEventListener("drop", (event) => {
        event.preventDefault();
        uploadBox.classList.remove("dragging");

        const file = event.dataTransfer.files?.[0];

        if (!file) {
            return;
        }

        const isPdf =
            file.type === "application/pdf" ||
            file.name.toLowerCase().endsWith(".pdf");

        if (!isPdf) {
            alert("PDF 파일만 업로드할 수 있습니다.");
            return;
        }

        const dataTransfer = new DataTransfer();
        dataTransfer.items.add(file);

        fileInput.files = dataTransfer.files;

        updateFileName();
    });

    fileInput.addEventListener("change", updateFileName);
});