package nuc.zm.server.service;

import nuc.zm.server.dto.ChapterDto;
import nuc.zm.server.dto.PageDto;



public interface ChapterService {


    void list(PageDto<ChapterDto> pageDto);
}
