package kim.zzang.webservice.web;

import kim.zzang.webservice.service.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@Controller
public class UploadController {

    private final S3Uploader s3Uploader;

    @GetMapping("/web/upload")
    public String upload() {
        return "upload";
    }


    @PostMapping("/api/upload")
    @ResponseBody
    public String upload(@RequestParam("data") MultipartFile multipartFile) throws IOException {
        return s3Uploader.upload(multipartFile, "static");
    }
}