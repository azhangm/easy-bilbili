package nuc.zm.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import nuc.zm.server.domain.Chapter;
import nuc.zm.server.domain.ChapterExample;
import nuc.zm.server.dto.ChapterDto;
import nuc.zm.server.dto.PageDto;
import nuc.zm.server.mapper.ChapterMapper;
import nuc.zm.server.service.ChapterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 章服务impl
 *
 * @author zm
 * @date 2023/05/06
 */
@Service
public class ChapterServiceImpl implements ChapterService {
    private static final Logger LOG = LoggerFactory.getLogger(ChapterServiceImpl.class);
    @Resource
    private ChapterMapper chapterMapper;

    @Override
    public void list(PageDto<ChapterDto> pageDto) {
        // 分页功能关键字 ： limit.
        // limit 1 相当于 limit 0 1 从第0行开始 查1条
        // 插页分件语法规则 调用它后 往后遇到的第一个 select语句会进行分页
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        ChapterExample chapterExample = new ChapterExample();
        List<Chapter> chapters = chapterMapper.selectByExample(chapterExample);
        PageInfo<Chapter> chapterPageInfo = new PageInfo<>(chapters);
        long total = chapterPageInfo.getTotal();
        pageDto.setTotal(total);
        List<ChapterDto> chapterDtoList = new ArrayList<>();
        for (Chapter chapter : chapters) {
            ChapterDto chapterDto = new ChapterDto();
            BeanUtils.copyProperties(chapter,chapterDto);
            chapterDtoList.add(chapterDto);
        }
        LOG.info("ChapterDtoList:{}",chapterDtoList);
//        System.out.println(chapterDtoList);
        pageDto.setList(chapterDtoList);
    }
}
