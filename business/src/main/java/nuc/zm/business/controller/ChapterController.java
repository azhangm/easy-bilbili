package nuc.zm.business.controller;

import nuc.zm.server.dto.ChapterDto;
import nuc.zm.server.dto.PageDto;
import nuc.zm.server.exception.ConditionException;
import nuc.zm.server.service.ChapterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;


@RestController
//@RequestMapping("/chapter")
public class ChapterController {
    private static final Logger LOG = LoggerFactory.getLogger(ChapterController.class);
    @Resource
    private ChapterService chapterService;

    @GetMapping("/test")
    public PageDto<ChapterDto> list(@RequestBody PageDto<ChapterDto> pageDto){
        LOG.info("前: pageDto : {}",pageDto);
        chapterService.list(pageDto);
        if (true) //骗过编译器测试
        throw new ConditionException(2,"查询异常");
        LOG.info("后: pageDto : {}",pageDto);
        return pageDto;
    }
}
