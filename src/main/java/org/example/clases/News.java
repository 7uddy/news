package org.example.clases;

public class News {
    private Integer newsId;
    private String content;
    private Integer publisherId;
    private Boolean isApproved;

    public News() {
    }

    public News(Integer newsId, String content, Integer publisherId, Boolean isApproved) {
        this.newsId = newsId;
        this.content = content;
        this.publisherId = publisherId;
        this.isApproved = isApproved;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", content='" + content + '\'' +
                ", publisherId=" + publisherId +
                ", isApproved=" + isApproved +
                '}'+"\n";
    }
}