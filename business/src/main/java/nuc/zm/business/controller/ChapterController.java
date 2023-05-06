package nuc.zm.business.controller;

import nuc.zm.server.dto.ChapterDto;
import nuc.zm.server.dto.PageDto;
import nuc.zm.server.service.ChapterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;


@RestController
//@RequestMapping("/chapter")
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    @GetMapping("/test")
    public PageDto<ChapterDto> list(PageDto<ChapterDto> pageDto){
         chapterService.list(pageDto);
         return pageDto;
    }
}
