package nuc.zm.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import nuc.zm.server.domain.${Domain};
import nuc.zm.server.domain.${Domain}Example;
import nuc.zm.server.dto.${Domain}Dto;
import nuc.zm.server.dto.PageDto;
import nuc.zm.server.mapper.${Domain}Mapper;
import nuc.zm.server.service.${Domain}Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class ${Domain}ServiceImpl implements ${Domain}Service {
    private static final Logger LOG = LoggerFactory.getLogger(${Domain}ServiceImpl.class);
    @Resource
    private ${Domain}Mapper ${domain}Mapper;

    @Override
    public void list(PageDto<${Domain}Dto> pageDto) {
        // 分页功能关键字 ： limit.
        // limit 1 相当于 limit 0 1 从第0行开始 查1条
        // 插页分件语法规则 调用它后 往后遇到的第一个 select语句会进行分页
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        ${Domain}Example ${domain}Example = new ${Domain}Example();
        List<${Domain}> ${domain}s = ${domain}Mapper.selectByExample(${domain}Example);
        PageInfo<${Domain}> ${domain}PageInfo = new PageInfo<>(${domain}s);
        long total = ${domain}PageInfo.getTotal();
        pageDto.setTotal(total);
        List<${Domain}Dto> ${domain}DtoList = new ArrayList<>();
        for (${Domain} ${domain} : ${domain}s) {
            ${Domain}Dto ${domain}Dto = new ${Domain}Dto();
            BeanUtils.copyProperties(${domain},${domain}Dto);
            ${domain}DtoList.add(${domain}Dto);
        }
        LOG.info("${Domain}DtoList:{}",${domain}DtoList);
//        System.out.println(${domain}DtoList);
        pageDto.setList(${domain}DtoList);
    }
}