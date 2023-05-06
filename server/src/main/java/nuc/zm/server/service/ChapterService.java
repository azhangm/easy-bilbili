package nuc.zm.server.service;

import nuc.zm.server.dto.ChapterDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ChapterService {

    List<ChapterDto> list();
}
