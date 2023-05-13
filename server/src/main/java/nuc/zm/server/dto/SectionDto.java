package nuc.zm.server.dto;

/**
 * 小节
 * @author 
 */
public class SectionDto {
     /**
     * ID
     */
    private String id;
     /**
     * 标题
     */
    private String title;
     /**
     * 课程ID|course_id
     */
    private String courseId;
     /**
     * 大章ID|chapter_id
     */
    private String chapterId;
     /**
     * 视频
     */
    private String video;
     /**
     * 课程时长|秒
     */
    private String time;
     /**
     * 收费|true or false
     */
    private String charge;
     /**
     * 顺序
     */
    private String sort;
     /**
     * 创建时间
     */
    private String createTime;
     /**
     * 修改时间
     */
    private String updateTime;

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

}