package nuc.zm.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * chapter
 * @author 
 */
public class ChapterDto {
    /**
     * ID
     */
    private Integer id;

    /**
     * 课程ID
     */
    private Integer courseId;

    /**
     * 名称
     */
    @JsonFormat
    private String name;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}