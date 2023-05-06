package nuc.zm.business.controller;

import nuc.zm.server.dto.ChapterDto;
import nuc.zm.server.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/chapter")
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    @GetMapping("/test")
    public List<ChapterDto> list(){
        return chapterService.list();
    }
}
