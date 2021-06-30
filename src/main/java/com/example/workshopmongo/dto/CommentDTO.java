package com.example.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {

    private String comment;
    private Date data;
    private AuthorDTO author;

    public CommentDTO() {
    }

    public CommentDTO(String comment, Date data, AuthorDTO author) {
        this.comment = comment;
        this.data = data;
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

}
