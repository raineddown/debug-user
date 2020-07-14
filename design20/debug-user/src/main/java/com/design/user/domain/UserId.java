package com.design.user.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class UserId implements Serializable {
    private int value;

    public int userId(int value){
        return this.value = value + 1;
    }

    public int value(){
        return this.value;
    }
}
