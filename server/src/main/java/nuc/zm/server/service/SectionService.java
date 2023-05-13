package nuc.zm.server.service;

import nuc.zm.server.dto.SectionDto;
import nuc.zm.server.dto.PageDto;

public interface SectionService {


void list(PageDto<SectionDto> pageDto); 
    
}
