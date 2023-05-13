package nuc.zm.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import nuc.zm.server.domain.Section;
import nuc.zm.server.domain.SectionExample;
import nuc.zm.server.dto.SectionDto;
import nuc.zm.server.dto.PageDto;
import nuc.zm.server.mapper.SectionMapper;
import nuc.zm.server.service.SectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class SectionServiceImpl implements SectionService {
    private static final Logger LOG = LoggerFactory.getLogger(SectionServiceImpl.class);
    @Resource
    private SectionMapper sectionMapper;

    @Override
    public void list(PageDto<SectionDto> pageDto) {
        // 分页功能关键字 ： limit.
        // limit 1 相当于 limit 0 1 从第0行开始 查1条
        // 插页分件语法规则 调用它后 往后遇到的第一个 select语句会进行分页
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        SectionExample sectionExample = new SectionExample();
        List<Section> sections = sectionMapper.selectByExample(sectionExample);
        PageInfo<Section> sectionPageInfo = new PageInfo<>(sections);
        long total = sectionPageInfo.getTotal();
        pageDto.setTotal(total);
        List<SectionDto> sectionDtoList = new ArrayList<>();
        for (Section section : sections) {
            SectionDto sectionDto = new SectionDto();
            BeanUtils.copyProperties(section,sectionDto);
            sectionDtoList.add(sectionDto);
        }
        LOG.info("SectionDtoList:{}",sectionDtoList);
//        System.out.println(sectionDtoList);
        pageDto.setList(sectionDtoList);
    }
}