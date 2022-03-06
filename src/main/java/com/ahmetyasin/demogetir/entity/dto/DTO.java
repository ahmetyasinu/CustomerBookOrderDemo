package com.ahmetyasin.demogetir.entity.dto;

import java.io.Serializable;

public interface DTO<PK extends Serializable> extends Serializable {

    PK getId();

    void setId(PK id);

}
