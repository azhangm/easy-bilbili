package nuc.zm.server.dto;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 小节
 * @author 
 */
public class SectionDto {
     /**
     * ID
     */
    private Long id;
     /**
     * 标题
     */
    private String title;
     /**
     * 课程ID|course_id
     */
    private Long courseId;
     /**
     * 大章ID|chapter_id
     */
    private Long chapterId;
     /**
     * 视频
     */
    private String video;
     /**
     * 课程时长|秒
     */
    private Long time;
     /**
     * 收费|true or false
     */
    private boolean charge;
     /**
     * 顺序
     */
    private Integer sort;
     /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
     /**
     * 修改时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public void setCharge(boolean charge) {
        this.charge = charge;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}