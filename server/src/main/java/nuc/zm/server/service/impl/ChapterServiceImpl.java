package nuc.zm.server.service.impl;

import nuc.zm.server.domain.Chapter;
import nuc.zm.server.domain.ChapterExample;
import nuc.zm.server.dto.ChapterDto;
import nuc.zm.server.mapper.ChapterMapper;
import nuc.zm.server.service.ChapterService;
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

    @Resource
    private ChapterMapper chapterMapper;

    @Override
    public List<ChapterDto> list() {
        ChapterExample chapterExample = new ChapterExample();
        List<Chapter> chapters = chapterMapper.selectByExample(chapterExample);
        List<ChapterDto> chapterDtoList = new ArrayList<>();
        for (Chapter chapter : chapters) {
            ChapterDto chapterDto = new ChapterDto();
            BeanUtils.copyProperties(chapter,chapterDto);
            chapterDtoList.add(chapterDto);
        }
        return chapterDtoList;
    }
}
