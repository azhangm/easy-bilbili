package nuc.zm.file.controller.user;

import com.mysql.cj.log.Log;
import nuc.zm.server.util.SnowFlackIdUtils;
import nuc.zm.server.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UploadController {
    private static final Logger LOG = LoggerFactory.getLogger(UploadController.class);

    @PostMapping("/upload-user-avatar")
    public ResponseVo<String> uploadPAvatar(@RequestParam("file")MultipartFile file) throws IOException {
        LOG.info("上传文件开始:{}",file);
        LOG.info(file.getOriginalFilename());
        LOG.info(String.valueOf(file.getSize()));
        String fileName = file.getOriginalFilename();
        String key = SnowFlackIdUtils.getSnowFlackIdStr();
        String fullName = "D:/file/user/" + key + "-" + fileName;
        File dest = new File(fullName);
        file.transferTo(dest);
        LOG.info("文件保存路径{}" , dest.getAbsolutePath());
        return ResponseVo.ok();
    }
}
