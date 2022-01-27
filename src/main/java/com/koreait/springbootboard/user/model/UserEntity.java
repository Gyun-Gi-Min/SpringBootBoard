package com.koreait.springbootboard.user.model;

import lombok.Data;

@Data

public class UserEntity {
    private int iuser;
    private String uid;
    private String upw;
    private String nm;
    private int gender;
    private String rdt;
    private String mdt;
    private String profileimg;

}
